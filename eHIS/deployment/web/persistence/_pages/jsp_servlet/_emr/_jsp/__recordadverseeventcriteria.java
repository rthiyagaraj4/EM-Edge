package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __recordadverseeventcriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/RecordAdverseEventCriteria.jsp", 1709119026223L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\"></link>\n  <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n  <Script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\" ></Script>\n  <script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/messages.js\' ></script>\n  <script language=\'javascript\' src=\'../../eMR/js/eMRmessages.js\' ></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/common.js\' ></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/dchk.js\' ></script>\n  <script language=\'javascript\' src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n  <script language=\'javascript\' src=\"../js/RecordAdverseEventCriteria.js\"></script>\n\n</head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<body onLoad=\"FocusFirstElement()\"  OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n   <form name = \'search_form\' action=\"../../eCommon/jsp/report_options.jsp\" target=\"messageFrame\">\n      <div>\n        <table cellpadding=\'0\'  border=\"0\" cellspacing=\'0\' width=\'100%\' align=\'center\' >\n\t\t\t<tr>\n\t\t\t\t<td align=\'right\' width=\'11%\' class=\"label\">Patient ID</td>\n\t\t\t\t<td align=left>&nbsp;<input type=text  name=\'PatientId\' id=\'PatientId\' size=\"\" maxlength=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\" onBlur=\"makeValidString(this);ChangeUpperCase(this);document.forms[0].clear.onclick();\" onKeypress=\'makeValidString(this);return CheckForSpecChars(event);\' align=\"center\"><input type=\'button\' name=\'patient_id\' id=\'patient_id\' value=\'?\' class=\'button\' onclick=\'callSearchScreen()\'>\n\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'patID_img\' style=\"visibility:visible\"></img>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="<input type=\'button\' name=\'search\' id=\'search\' value=\'Search\' class=\'button\' onclick=\'submitPage()\'></td>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<td align=\'right\' class=\'label\' nowrap>Cause Indicator&nbsp;</td>\n\t\t\t<td class=label><select name=\"cause_ind\" id=\"cause_ind\">\n\t\t\t\t<option>----- Select -----</option>\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="       \n\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t</select>\t\t\t\t\t\t\n\t\t\t</td>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<td align=\'right\' class=\'label\'>&nbsp;&nbsp;</td>\t\t\t\n\t\t\t\t<td align=\'right\' class=\'label\'>&nbsp;&nbsp;</td>\t\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t<td align=\'right\' class=\'label\'>Marked Status&nbsp;</td>\n\t\t\t\t<td align=\'left\' ><select name=\'marked_status\' id=\'marked_status\'>\n\t\t\t\t\t <option value=\'\'>---Select---</option>\n\t\t\t\t\t <option value=\'O\'>OSCC</option>\n\t\t\t\t\t <option value=\'M\'>MLC</option>\n\t\t\t\t</td>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="<td align=\'right\'  class=\'label\'>&nbsp;</td>\t\t\t\n\t\t  <td align=\'right\'  class=\'label\'>&nbsp;</td>\n          </tr>\n\t<tr>\n\t\t<td colspan=6 align=left width=\'100%\'>\n\t\t<table cellpadding=\'0\'  border=0 cellspacing=\'0\' width=\'100%\' align=\'left\' >\n\t\t<tr align=left>\t\t\t\n\t\t<td class=label width=\'100%\' align=left>\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t\t</td>\n\t</tr>\n</table>\n<table cellpadding=\'0\'  border=\'0\' cellspacing=\'0\' width=\'100%\' align=\'left\' >\n\t<tr>\n\t\t<td  align=\'right\' class=\"label\" width=\"11%\">Enc Period&nbsp;</td><td  align=left width = \"44%\">&nbsp;<input type=\"text\" name=\"alt_id1_exp_date\" id=\"alt_id1_exp_date\" size=\"16\" maxlength=\'16\' id=\'altidexpdt1\'  onblur=\"ComparePeriodFromToTime(this,alt_id2_exp_date);CompareSysDatecriteria(document.forms[0].SystemDate,this);\" onkeypress=\"return Valid_DT(event)\"></input><input type=\'image\' src=\'../../eCommon/images/CommonCalendar.gif\'  onClick=\"document.forms[0].alt_id1_exp_date.focus();return showCalendar(\'altidexpdt1\',null,\'hh:mm\');\">&nbsp;-&nbsp;<input type=\"text\" name=\"alt_id2_exp_date\" id=\"alt_id2_exp_date\" size=\"16\" maxlength=\'16\' id=\'altidexpdate2\'  onblur=\"ComparePeriodFromToTime(alt_id1_exp_date,this);CompareSysDatecriteria(document.forms[0].SystemDate,this);\" onkeypress=\"return Valid_DT(event)\" ></input><input type=\'image\' src=\'../../eCommon/images/CommonCalendar.gif\'   onClick=\"document.forms[0].alt_id2_exp_date.focus();return showCalendar(\'altidexpdate2\',null,\'hh:mm\');\">&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'encDate_img\' style=\"visibility:hidden\"></img></td>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<script>\n\t\t\t\tdocument.getElementById(\"patID_img\").style.visibility = \"hidden\";\n\t\t\t\tdocument.forms[0].alt_id1_exp_date.value = \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n\t\t\t\tdocument.forms[0].alt_id2_exp_date.value = \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\t\t\t\n\t\t<td align=\'right\' class=\"label\" >Encounter Type&nbsp;</td>\n\t\t\t<td align=left>\n\t\t\t\t<select name=\"lstPatientClass\" id=\"lstPatientClass\">\n\t\t\t\t<option>----- Select -----</option>\n\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t</select>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'encType_img\' style=\"visibility:hidden\"></img></td>\n\n\t\t\t\t<td align=\'right\' class=\'label\'>&nbsp;&nbsp;</td>\t\n\t\t\t\t<td align=\'right\' class=\'label\'>&nbsp;&nbsp;</td>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t<td align=\'right\' class=\'label\'>&nbsp;&nbsp;</td>\t\t\t\n\t\t\t\t<td align=\'right\' class=\'label\'>&nbsp;&nbsp;</td>\t\n\t\t\t\t<td align=\'right\' class=\'label\'>&nbsp;&nbsp;</td>\t\n\t\t\t\t<td align=\'right\' class=\'label\'>&nbsp;&nbsp;</td>\t\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\n\t</tr>\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t<tr>\n\t\t<td align=\'right\' class=\"label\" >Disch Date&nbsp;</td>\n\t\t<td align=\'left\' >&nbsp;<input name=\'p_discharge_date_from\' id=\'p_discharge_date_from\' id=\'dischargedatefrom\' value=\'\' size=\'16\' maxlength=\'16\' onkeypress=\"return Valid_DT(event)\"><input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'dischargedatefrom\',null,\'hh:mm\' );\" ></input>&nbsp;-&nbsp;<input name=\'p_discharge_date_to\' id=\'p_discharge_date_to\' id=\'dischargedateto\' value=\'\' size=\'16\' maxlength=\'16\' onkeypress=\"return Valid_DT(event)\"><input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'dischargedateto\',null,\'hh:mm\' );\"></input></td>\n\t\t<td align=\'right\'  class=\'label\'>&nbsp;</td>\t\t\t\n\t\t<td align=\'right\'  class=\'label\'>&nbsp;</td>\t\t\n\t\t<td align=\'right\'  class=\'label\'>&nbsp;</td>\t\t\n\t\t<td align=\'right\'  class=\'label\'>&nbsp;</td>\t\t\n\t</tr>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t<tr>\n\t\t<td align=\'right\' class=\"label\">Encounter ID&nbsp;</td>\n\t\t<td  nowrap  align=left>&nbsp;<input type=text  name=\'p_encounter_id\' id=\'p_encounter_id\' size=\"12\" maxlength=\"12\" onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\"CheckNumVal(this)\" align=\"center\"></td>\t\t\n\t\t<td align=\'right\' class=\"label\" nowrap>Order By&nbsp;</td>\n\t\t<td nowrap ><select name=\"orderBy\" id=\"orderBy\"><option>----- Select -----</option>\n\t\t\t<option value=\"ED\" selected>Encounter Date</option>\n\t\t\t<option value=\"ET\"  >Encounter Type</option>\n\t\t\t</select>\t\t\n\t\t</td>\n\t\t<td align=\'right\' colspan=2 class=\'label\'>&nbsp;&nbsp;</td>\t\t\n\t\t\n\t\t</tr>\n\t<tr>\n\t\t\t<td align=\'right\'  class=\'label\' colspan=\'3\'>&nbsp;&nbsp;</td>\n\t\t\t<td align=\'right\'colspan=3 nowrap><input type=\'button\' name=\'search\' id=\'search\' value=\'Search\' class=\'button\' onclick=\'submitPage()\'><input type=\'button\' name=\'clear\' id=\'clear\' value=\'Clear\' class=\'button\' onclick=\'clearAll()\'>&nbsp;&nbsp;</td>\n\t\t</tr>\n\t\t</table>\n\n     </div>\n\n\t<input type=\'hidden\' name=\'jsp_name\' id=\'jsp_name\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" >\n\t<input type=\'hidden\' name=\'win_height\' id=\'win_height\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" >\n\t<input type=\'hidden\' name=\'win_width\' id=\'win_width\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" >\n\t<input type=\'hidden\' name=\'param\' id=\'param\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" >\t\n\t<input type=\'hidden\' name=\'dialogTop\' id=\'dialogTop\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" >\n\t<input type=\'hidden\' name=\'modal\' id=\'modal\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" >\n\t<input type=\'hidden\' name=\'module\' id=\'module\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" >\n\t<input type=\'hidden\' name=\'model_window\' id=\'model_window\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" >\n\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" >\n\t<input type=\'hidden\' name=\'call_function\' id=\'call_function\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" >\n\t<input type=\'hidden\' name=\'prog_id\' id=\'prog_id\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" >\n\t<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" >\n\t<input type=\'hidden\' name=\'operstn\' id=\'operstn\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" >\n\t<input type=\'hidden\' name=\'loginUser\' id=\'loginUser\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" >\n\t<input type=\'hidden\' name=\'SystemDate\' id=\'SystemDate\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" >\n\t<input type=\'hidden\' name=\'qerString\' id=\'qerString\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" >\n\n\n     <input type=\'hidden\' name=\'p_report_id\' id=\'p_report_id\' value=\'MRBIPFFPRC\'></input>\n     <input type=\'hidden\' name=\'p_module_id\' id=\'p_module_id\' value=\'MR\'></input>\n     <input type= \'hidden\' name=\'p_facility_id\' id=\'p_facility_id\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'></input>\n     <input type=\'hidden\' name=\'p_user_name\' id=\'p_user_name\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'></input>\n     <input type=\'hidden\' name=\'sys_date\' id=\'sys_date\' value=\'\'></input>\n\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t<script>\n\t\t\t document.forms[0].all.encType_img.style.visibility = \'visible\';\n\t\t\t document.forms[0].all.encDate_img.style.visibility = \'visible\';\n\t\t</script>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t \n\t ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n  </form>\n</body>\n\n</html>\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
  String p_user_name		= (String) session.getValue( "login_user" ) ;
  Connection con = ConnectionManager.getConnection(request);
  ResultSet rs   = null;
  Statement stmt = null;
  String pat_id_length = "";
	try 
	{
		String jsp_name =request.getParameter("jsp_name");
		if( jsp_name == null) jsp_name="";
		String window_styl=request.getParameter("window_styl");
		if( window_styl == null) window_styl="";
		String close_yn	=request.getParameter("close_yn");
		if( close_yn == null) close_yn="";
		String win_top =request.getParameter("win_top");
		if( win_top == null) win_top="";
		String win_height =request.getParameter("win_height");
		if(win_height ==null) win_height="";
		String win_width =request.getParameter("win_width");
		if( win_width == null) win_width="";
		
		String call_function=request.getParameter("call_function");
		if(call_function == null) call_function="";		
		String modal=request.getParameter("modal");
		if(modal == null) modal="";			
		String dialogTop =request.getParameter("dialogTop");
		if(dialogTop ==null) dialogTop="";			
		//module=ph
		String module=request.getParameter("module");
		if(module == null) module="";
		String model_window=request.getParameter("model_window");
		if( model_window == null) model_window="";
		
		String function_id=request.getParameter("function_id");
		if( function_id == null) function_id="";
		
		String prog_id=request.getParameter("prog_id");
		if( prog_id == null) prog_id="";

		String practitioner_id=request.getParameter("practitioner_id");
		if( practitioner_id == null) practitioner_id="";
		
		String wherecondn = request.getParameter("wherecondn");
		if(wherecondn == null) wherecondn ="";	
		String operstn	= request.getParameter("wherecondn");
		if(wherecondn == null) wherecondn ="";	

		String encounterID_repDischargeAdvice=request.getParameter("encounter_id");
		if( encounterID_repDischargeAdvice == null) encounterID_repDischargeAdvice="";
		String loginUser = (String)session.getValue("login_user");
		String p_facility_id		= (String) session.getValue( "facility_id" ) ;
		String SystemDate = "";

			/*Commented On 6/4/2010 For PE
			try
			{
		    	 stmt = con.createStatement();
				 rs	=	stmt.executeQuery("select to_char(sysdate,'dd/mm/yyyy hh24:mi') SystemDate from dual");
 				 if (rs.next() && rs != null)
					 SystemDate = rs.getString(1);
			
				if(stmt!=null)
					stmt.close();
				if(rs!=null)
					rs.close();
			}
			catch(Exception e) 
			{
				//out.println("Exception in Sysdate : "+e.toString());
				e.printStackTrace();
			}
			finally
			{
				if(rs!=null) rs.close();
			}*/
			try{
		    	 stmt = con.createStatement();
				 rs	=	stmt.executeQuery("select patient_id_length,to_char(sysdate,'dd/mm/yyyy hh24:mi') SystemDate from mp_param");
 				 if (rs.next() && rs != null){
					 pat_id_length = rs.getString("patient_id_length");
					 SystemDate = rs.getString("SystemDate");
				 }
			}catch(Exception e){
				//out.println("Exception in Sysdate : "+e.toString());
				e.printStackTrace();
			}finally{
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			}

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(pat_id_length));
            _bw.write(_wl_block5Bytes, _wl_block5);
 out.println("call_function :" +call_function);
				if (!call_function.equals("QUERY_MARK_MLC_OSCC") && !call_function.equals("QUERY_MATERNAL_REPORT") ) 
				{
            _bw.write(_wl_block6Bytes, _wl_block6);
 
				} 
            _bw.write(_wl_block7Bytes, _wl_block7);
	if(call_function.equals("QUERY_MATERNAL_REPORT")) 
		{	
            _bw.write(_wl_block8Bytes, _wl_block8);
	
					rs = stmt.executeQuery("select DISCHARGE_TYPE_CODE, SHORT_DESC from ip_discharge_type where  MATERNAL_DEATH_YN = 'Y' and EFF_STATUS = 'E' order by 2 ")  ;
					if(rs != null)
					{									
						while (rs.next())
						{	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(rs.getString("DISCHARGE_TYPE_CODE")));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rs.getString("SHORT_DESC")));
            _bw.write(_wl_block11Bytes, _wl_block11);
	}
					}	
            _bw.write(_wl_block12Bytes, _wl_block12);
	}	
            _bw.write(_wl_block13Bytes, _wl_block13);
	if(!call_function.equals("QUERY_MATERNAL_REPORT")&& !call_function.equals("QUERY_MARK_MLC_OSCC")) 
	{	
            _bw.write(_wl_block14Bytes, _wl_block14);
	}	
            _bw.write(_wl_block1Bytes, _wl_block1);
	if(call_function.equals("QUERY_MARK_MLC_OSCC")) 
	{	
            _bw.write(_wl_block15Bytes, _wl_block15);
	}	
            _bw.write(_wl_block16Bytes, _wl_block16);
            {java.lang.String __page ="../../eMP/jsp/natAltIDComponentCriteria.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("alert_reqd_yn"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("mr_transaction"), weblogic.utils.StringUtils.valueOf("Y")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block20Bytes, _wl_block20);
		if(call_function.equals("DIAG_RECODE"))
		{	
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(SystemDate));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(SystemDate));
            _bw.write(_wl_block23Bytes, _wl_block23);
	}	
            _bw.write(_wl_block24Bytes, _wl_block24);
	if(!call_function.equals("QUERY_MATERNAL_REPORT")) 
	{	
            _bw.write(_wl_block25Bytes, _wl_block25);
	
					if(rs != null) rs = null;
					rs = stmt.executeQuery("select PATIENT_CLASS, short_desc from am_patient_class order by 1")  ;
					if(rs != null)
					{									
						while (rs.next())
						{	
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(rs.getString("PATIENT_CLASS")));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rs.getString("short_desc")));
            _bw.write(_wl_block11Bytes, _wl_block11);
	}
					}	
            _bw.write(_wl_block27Bytes, _wl_block27);
 }else { 
            _bw.write(_wl_block28Bytes, _wl_block28);
 } 
            _bw.write(_wl_block29Bytes, _wl_block29);
 if(call_function.equals("QUERY_MATERNAL_REPORT")||call_function.equals("DIAG_RECODE")) {
            _bw.write(_wl_block30Bytes, _wl_block30);
 } 
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(win_height));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(win_width));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(dialogTop));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(modal));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(module));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(model_window));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(prog_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(operstn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(SystemDate));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(p_facility_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(p_user_name));
            _bw.write(_wl_block49Bytes, _wl_block49);
	if(call_function.equals("DIAG_RECODE"))
	{	
            _bw.write(_wl_block50Bytes, _wl_block50);
	}	
            _bw.write(_wl_block51Bytes, _wl_block51);

     } catch(Exception e) {
          //out.println(e.toString());
		  e.printStackTrace();
          if (rs != null) rs.close();
          if (stmt != null) stmt.close();
     }
     finally {
          if (rs != null) rs.close();
          if (stmt != null) stmt.close();
		  ConnectionManager.returnConnection(con,request);
     }

            _bw.write(_wl_block52Bytes, _wl_block52);
            _bw.write(_wl_block53Bytes, _wl_block53);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
