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

public final class __newproceduredesc extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/NewProcedureDesc.jsp", 1709119748000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block8 ="\'></link>\n <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\">\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script src=\'../js/NewProcedure.js\' language=\'javascript\'></script>\n<script src=\'../js/NewProcedureMain.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\' ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<form name=\'proc_outcome_form\' id=\'proc_outcome_form\'  action=\'\' method=\'get\' target=\'\'>\n\t<table border=0 cellspacing=0 cellpadding = 3 width=\'100%\' style=\'\' id=\'DiagTable\' align=center>\n\t<tr>\n\t<td class=\'label\' align=\'right\' width=\'30%\'>Anesthesia</td>\n\t<td width=\'70%\'><Select name=\"anesthesia\" id=\"anesthesia\"><option value=\"\">-----Select-----</option>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t</Select>\n    </td>\n\t</tr>\n\t<tr>\n\t<td class=\'label\' width=\'10%\' align=\'right\' colspan=\'\' nowrap>Anesthesia Details</td>\n\t<td class=\'label\' width=\'70%\' colspan=\'\'><textarea name=\"anesthesia_det\" rows=\'1\' cols=\'38\'\n\tonBlur=\"makeValidString(this);\" maxlength=500  onFocus=\'\' onKeyPress=\'\'></textarea>\n\t</td>\n\t</tr>\n\t<tr>\n\t<td class=\'label\' align=\'right\' width=\'\' colspan=\'\' >Status</td>\n\t<td class=\'label\' width=\'\' colspan=\'\' >\n\t<select name=\"proc_status\" id=\"proc_status\" style=\'\'>\n\t\t<!-- <option value=\"\">---Select---</option> -->\n\t\t<option value=\"P\">In Progress</option>\n\t\t<option value=\"C\">Completed</option>\n\t</select></td>\n\t\n\t</tr>\n\t\n\t<tr>\n\t<td class=\'label\' align=\'right\' width=\'\' colspan=\'\'>Outcome</td>\n\t<td class=\'label\' width=\'\' colspan=\'\'>\n\t<select name=\"proc_outcome\" id=\"proc_outcome\" onChange=\"showReason(this)\" style=\'\'>\n\t\t<option value=\"\" >---Select---</option>\n\t\t<option value=\"E\">Effective</option>\n\t\t<option value=\"EC\">Effective With Complications</option>\n\t\t<option value=\"I\">Ineffective</option>\n\t\t<option value=\"IC\">Ineffective With Complications</option>\n\t</select></td>\n\t\n\t</tr>\n\t<tr style=\'display:none;\' id=\'tr_reason\'>\n\t<td class=\'label\' align=\'right\' width=\'\' colspan=\'\' ><label id=\'td_reason_legend\' style=\'visibility:hidden\'>Reason</label></td>\n\t<td class=\'label\' align=\'left\' width=\'\' colspan=\'\'>\n\t\t<label id=\'td_reason\' style=\'visibility:hidden\'>\n\t\t<select name=\"proc_reason\" id=\"proc_reason\" style=\'display:none;\'>\n\t\t<option value=\"\">---Select---</option>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t</select><img name=\'man_reason\' style=\'visibility:hidden\' src=\'../../eCommon/images/mandatory.gif\'></img></label></td>\n\t\n\t</tr>\n\t\n\t<tr style=\'display:none;\' id=\'tr_remarks\'>\n\t<td class=\'label\' align=\'right\' width=\'\' colspan=\'\' ><label id=\'td_remarks_legend\' style=\'\'>Remarks</label></td>\n\t<td class=\'label\' align=\'left\' width=\'\' colspan=\'\'>\n\t<label id=\'td_remark\' style=\'\'><textarea name=\"remarks\" rows=\'2\' cols=\'38\' onBlur=\"makeValidString(this);\" maxlength=500></textarea></label></td>\n\t</tr>\n\n\t<tr style=\'display:none\'>\n\t\t<td align=\"right\" valign=\"middle\" class=\"label\">Intra - Procedural Complications</td>\n\t\t<td colspan=\'5\'><textarea name=\"findings\" rows=\'1\' cols=\'60\'\n\tonBlur=\"makeValidString(this);\" maxlength=500  onFocus=\'\' onKeyPress=\'\'></textarea></td>\n\t</tr>\n\t<tr style=\'display:none\'>\n\t\t<td align=\"right\" valign=\"middle\" class=\"label\">Actions taken to resolve complications</td>\n\t\t<td colspan=\'5\'><textarea name=\"impression\" rows=\'2\' cols=\'60\'\n\tonBlur=\"makeValidString(this);\" maxlength=500  onFocus=\'\' onKeyPress=\'\'></textarea></td>\n\t</tr>\n\t<tr style=\'display:none\'>\n\t\t<td align=\"right\" valign=\"middle\" class=\"label\">Remarks</td>\n\t\t<td colspan=\'5\'><textarea name=\"disposition\" rows=\'3\' cols=\'60\' onBlur=\"makeValidString(this);\" maxlength=500  onFocus=\'\' onKeyPress=\'\' ></textarea></td>\n\t</tr>\n\t</table>\n\t\n\n<input type=\"hidden\" name = \"Practitioner_Id\" value =\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n<input type=\"hidden\" name = \"relationship_id\" value =\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n<input type=\"hidden\" name = \"Locn_Code\" value =\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n<input type=\"hidden\" name = \"Locn_Type\" value =\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n<input type=\"hidden\" name = \"Patient_Id\" value =\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n<input type=\"hidden\" name = \"Encounter_Id\" value =\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n<input type=\"hidden\" name = \"currentdate\" value =\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n<input type=\"hidden\" name = \"as_evidenced_by_hid\" value =\"\">\n<input type=\"hidden\" name = \"accry_code\" value =\"\">\n<input type=\"hidden\" name = \"accry_code_ind\" value =\"\">\n<!-- Params for Code Set up...Get papulate from Script file. -->\n<input type=\"hidden\" name = \"term_set_id\" value =\"\">\n<input type=\"hidden\" name = \"priority_appl_yn\" value =\"\">\n<input type=\"hidden\" name = \"nature_appl_yn\" value =\"\">\n<input type=\"hidden\" name = \"severity_appl_yn\" value =\"\">\n<input type=\"hidden\" name = \"onset_type_appl_yn\" value =\"\">\n<input type=\"hidden\" name = \"factors_appl_yn\" value =\"\">\n<input type=\"hidden\" name = \"notification_appl_yn\" value =\"\">\n<input type=\"hidden\" name = \"notifiable_yn\" value =\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n<!-- hidden fields for search -->\n<input type=\"hidden\" name = \"dob\" value =\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n<input type=\"hidden\" name = \"age\" value =\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n<input type=\"hidden\" name = \"sex\" value =\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n<input type=\"hidden\" name = \"facilityId\" value =\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n<input type=\"hidden\" name = \"mode\" value =\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n<input type=\"hidden\" name = \"modal_yn\" value =\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n<input type=\'hidden\' name=\'text5\' id=\'text5\' value=\'\'>\n<input type=\'hidden\' name=\'text6\' id=\'text6\' value=\'\'>\n<input type=\'hidden\' name=\'onset_date_temp\' id=\'onset_date_temp\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\t\n<input type=\'hidden\' name=\'status_date_temp\' id=\'status_date_temp\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n<input type=\'hidden\' name=\'status_srl_no\' id=\'status_srl_no\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n<input type=\'hidden\' name=\'onset_date1\' id=\'onset_date1\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\n<!--  hidden fields requeried to populate external diag -->\n<input type=\'hidden\' name=\'associate_codes\' id=\'associate_codes\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n<input type=\'hidden\' name=\'associate_codes_modify\' id=\'associate_codes_modify\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n<input type=\'hidden\' name=\'code_indicator\' id=\'code_indicator\' ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" value=\'\' ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =">\n<input type=\'hidden\' name=\'diff_group_id_hid\' id=\'diff_group_id_hid\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n<input type=\'hidden\' name=\'occur_srl_no_hid\' id=\'occur_srl_no_hid\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n<input type=\'hidden\' name=\'expandcollapse\' id=\'expandcollapse\' value=\'C\'></input>\n<input type=\'hidden\' name=\'curr_encr_flag\' id=\'curr_encr_flag\' value=\'\'></input>\n<input type=\'hidden\' name=\'diff_group_vals\' id=\'diff_group_vals\' value=\'\'></input>\n\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n<!-- <script>setTimeout(\"getCodeSet()\",300);</script> -->\n<script>//getAccuracy_code();</script>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n<script>setStatus();getCodeSet();</script>\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n<script>//check_enc();getCodeSet();</script>\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" \n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n<script>expandColapseframe(\'E\');onload_display();</script>\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n<script>getDescription();</script>\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n</font>\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );
	
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
	
	//PreparedStatement stmt2	= null;
	PreparedStatement pstmt	= null;
	//ResultSet rs2	= null;
	String Practitioner_Id="";	String relationship_id	="";
	String Locn_Code	="";	String Locn_Type	="";
	String Patient_Id	="";	String Encounter_Id	="";
	String currentdate	="";	String facilityId ="";
	String dob = ""; String age = "";
	String sex = ""; String associate_codes ="";
	String notifiable_yn;
	
	String term_code = "";	String term_set_id = "";
	//String nature = "";  	
	String onset_date = "";
	String status = "";  	String srl_no = "";     
	
	//String	severity = "";	
	//String	onset_type = "";
	//String	priority = "";	String	accuracy_code = "";
	//String	remarks = "";	
	String	status_date = "";
	String patient_class	="";	
	String disimage = "display:none";
		
	String def_status	=""; //String date_status	="";
	String def_disable	="";  String occur_srl_no="";
	//String style_def = "";		
	String mode="";
	String modal_yn="";	
	
	//String facility_id=checkForNull((String)session.getValue("facility_id"));
	//String practitioner_type=checkForNull((String)session.getValue("practitioner_type"));
	StringBuffer sql=new StringBuffer(); 

	try
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" ) ;
		currentdate			= dateFormat.format(new java.util.Date()) ;
		onset_date			=currentdate;
		status_date			=currentdate;
		occur_srl_no			=checkForNull(request.getParameter("occur_srl_no"));
		srl_no					= checkForNull(request.getParameter("srl_no"));
		Practitioner_Id			=checkForNull(request.getParameter("Practitioner_Id"));	
		relationship_id		= checkForNull(request.getParameter("relationship_id"));
		Locn_Code			= checkForNull(request.getParameter("location_code"));			
		Locn_Type			= checkForNull(request.getParameter("location_type"));
		Patient_Id				= checkForNull(request.getParameter("patient_id"));
		patient_class			= checkForNull(request.getParameter("patient_class"));
		Encounter_Id			= checkForNull(request.getParameter("encounter_id"));
		associate_codes			=checkForNull(request.getParameter("associate_codes"));		
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

		//String term_short_desc = "";
		//String codes = "";			String Aselect ="";			String Pselect ="";
		//String Wselect ="";			String pri_N_select ="";	String pri_H_select ="";
		//String pri_C_select ="";	String sevr_L_select ="";	String sevr_D_select ="";
		//String sevr_S_select ="";	String sevr_E_select ="";	String stus_A_select ="";
		//String stus_R_select ="";	String stus_X_select ="";	String stus_E_select ="";

		//String type_A_select = "";	String type_C_select = "";	
		String mandatory_status	=""; 
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
		
	
	
	
		def_disable="";			def_status	="";
		mandatory_status="";	mandatory_disable	="";
		def_select = "selected";
	

            _bw.write(_wl_block9Bytes, _wl_block9);

	String sql1 = "Select LONG_DESC,ANAESTHESIA_CODE from AM_ANAESTHESIA where eff_status='E' order by 1";
    try
	{
		pstmt =con.prepareStatement(sql1,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		rset=pstmt.executeQuery();
		String name="",id="",sel="";
		String anaesthesia_code="";	
		while(rset!=null && rset.next())
		{
			name=rset.getString(1);
			id =rset.getString(2);
			if(mode.equals("update")){
				if (id.trim().equalsIgnoreCase(anaesthesia_code))
					sel="selected";
				else sel="";
			}else{
				sel="";
			}
			out.println("<option value='"+id+"' " + sel +">"+name+"</option>");
		}

		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
	}catch(Exception e){
		System.out.println("Exception in Anesthesia.jsp"+e.toString());
	}
    
            _bw.write(_wl_block10Bytes, _wl_block10);

	if(sql.length() > 0) sql.delete(0,sql.length());
	sql.append("SELECT CONTACT_REASON_CODE,CONTACT_REASON FROM AM_CONTACT_REASON WHERE EFF_STATUS='E'");
    try
	{
		pstmt =con.prepareStatement(sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		rset=pstmt.executeQuery();
		String name="",id="";
		while(rset!=null && rset.next())
		{
			id =rset.getString(1);
			name=rset.getString(2);
			out.println("<option value='"+id+"' >"+name+"</option>");
		}
		
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
		if(stmt!=null) stmt.close();
	}catch(Exception e){
		System.out.println("Exception "+e.toString());
	}
	
    
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(relationship_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Locn_Type));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(currentdate));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(notifiable_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(age));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(onset_date));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(status_date));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(onset_date));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(associate_codes));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(associate_codes));
            _bw.write(_wl_block32Bytes, _wl_block32);
if(mode.equals("modify")){ 
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(code_ind));
            _bw.write(_wl_block34Bytes, _wl_block34);
} else{
            _bw.write(_wl_block35Bytes, _wl_block35);
}
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(diff_group_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(occur_srl_no));
            _bw.write(_wl_block38Bytes, _wl_block38);


} 
catch(Exception sqle)
{
	//out.println(sqle.getMessage());//common-icn-0181
	 sqle.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}


            _bw.write(_wl_block39Bytes, _wl_block39);
if(mode.equals("modify") && status.equals("A")) {
            _bw.write(_wl_block40Bytes, _wl_block40);
}
            _bw.write(_wl_block1Bytes, _wl_block1);
if(!mode.equals("modify")){
            _bw.write(_wl_block41Bytes, _wl_block41);
}
            _bw.write(_wl_block42Bytes, _wl_block42);
if(mode.equals("modify")){
            _bw.write(_wl_block43Bytes, _wl_block43);
}
            _bw.write(_wl_block1Bytes, _wl_block1);
if(modal_yn.equals("Y"))
{
            _bw.write(_wl_block44Bytes, _wl_block44);
}
            _bw.write(_wl_block45Bytes, _wl_block45);
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
