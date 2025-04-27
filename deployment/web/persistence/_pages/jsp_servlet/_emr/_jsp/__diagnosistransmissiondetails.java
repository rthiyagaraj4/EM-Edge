package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public final class __diagnosistransmissiondetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/DiagnosisTransmissionDetails.jsp", 1729592986315L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t<title></title>\n\t\t\t<script src=\'../../eMR/js/MedRecRequest.js\' language=\'javascript\'></script>\t\n\t\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t\t\t<script language=\'javascript\' src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t\t<script language=\'javascript\' src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t\t<!-- <script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script> -->\n\t\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body OnMouseDown=\'CodeArrest();\' onKeyDown=\'lockKey()\'>\n\t\t<form name=\'markencounter_Form\' id=\'markencounter_Form\' action=\'../../servlet/eMR.DiagTransmissionServlet\' method=\'post\' target=\'messageFrame\'>\n\t\t\t\t<table cellspacing=0 cellpadding=3 align=\'center\' width=\'100%\' border=\'0\'>\n\t\t\t\t\t\t<th colspan=2 >";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</th>\n\t\t\t\t\t\t<th colspan=2 >";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=label width=\'25%\' >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t\t\t\t<td class=fields width=\'25%\' ><input type=\'text\' name=\'trm_name\' id=\'trm_name\' size=30 maxlength=\'30\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="><img src=\'../../eCommon/images/mandatory.gif\' id=\'img1\' style=\'visibility:visible\'></img></td>\n\t\t\t\t\t\t\t<td class=label width=\'25%\' >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t\t\t\t<td class=fields width=\'25%\' ><input type=\'text\' name=\'com_name\' id=\'com_name\' size=30 maxlength=\'30\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="><img src=\'../../eCommon/images/mandatory.gif\' id=\'img4\' style=\'visibility:hidden\'></img></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=label width=\'25%\'  nowrap>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t\t\t\t\t<td class=fields width=\'25%\' ><input type=\'text\' name=\'trm_datetime\' id=\'trm_datetime\' size=\'14\' maxlength=\'16\' onkeypress=\"return Valid_DT(event);\"  onblur=\'chkDates(this);compareWithSysDt(this);\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="><img  src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].trm_datetime.select();return showCalendar(\'trm_datetime\',null,\'hh:mm\')\" ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="/><img src=\'../../eCommon/images/mandatory.gif\' id=\'img2\' style=\'visibility:visible\'></img></td>\n\t\t\t\t\t\t\t<!-- <td class=fields width=\'25%\' ><input type=\'text\' name=\'trm_datetime\' id=\'trm_datetime\' id=\'trmdatetime\' size=\'14\' maxlength=\'16\' onkeypress=\"return Valid_DT(event);\"  onblur=\'//compareDates2(this);date_Validate1(this);\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="><input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].trm_datetime.select();return showCalendar(\'trmdatetime\',null,\'hh:mm\')\" ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="><img src=\'../../eCommon/images/mandatory.gif\' id=\'img2\' style=\'visibility:visible\'></img></td> -->\n\t\t\t\t\t\t\t<td class=label width=\'25%\' >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t\t\t\t\t<td class=fields width=\'25%\' ><input type=\'text\' name=\'com_desig\' id=\'com_desig\' size=20 maxlength=\'20\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="><img src=\'../../eCommon/images/mandatory.gif\' id=\'img5\' style=\'visibility:hidden\'></img></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=label width=\'25%\' >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t\t\t\t<td class=fields width=\'25%\' ><input type=\'text\' name=\'trm_desig\' id=\'trm_desig\' size=20 maxlength=\'20\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="></td>\n\t\t\t\t\t\t\t<td class=label width=\'25%\'  nowrap>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t\t\t\t\t<td class=fields width=\'25%\' ><input type=\'text\' name=\'conf_datetime\' id=\'conf_datetime\' id=\'confdatetime\' size=\'14\' maxlength=\'16\' onkeypress=\"return Valid_DT(event);\" onblur= \'chkDates(this);compareWithSysDt(this);compareWithRcdate(this);\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].trm_datetime.select();return showCalendar(\'confdatetime\',null,\'hh:mm\')\" ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="/><img src=\'../../eCommon/images/mandatory.gif\' id=\'img6\' style=\'visibility:hidden\'></img></td>\n\t\t\t\t\t\t\t<!-- <td class=fields width=\'25%\' ><input type=\'text\' name=\'conf_datetime\' id=\'conf_datetime\' id=\'confdatetime\' size=\'14\' maxlength=\'16\' onkeypress=\"return Valid_DT(event);\" onblur= \'compareDates2(this);date_Validate1(this);Validate_withRcdate(this);\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="><input type=\"image\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"document.forms[0].trm_datetime.select();return showCalendar(\'confdatetime\',null,\'hh:mm\')\" ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="><img src=\'../../eCommon/images/mandatory.gif\' id=\'img6\' style=\'visibility:hidden\'></img></td> -->\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=label width=\'25%\' >";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t\t\t\t\t<td class=fields width=\'25%\' ><input type=\'text\' name=\'trm_location\' id=\'trm_location\' size=20 maxlength=\'20\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="><img src=\'../../eCommon/images/mandatory.gif\' id=\'img3\' style=\'visibility:visible\'></img></td>\n\t\t\t\t\t\t\t<td class=label width=\'25%\' >&nbsp;</td>\n\t\t\t\t\t\t\t<td class=label width=\'25%\' >&nbsp;</td>\n\t\t\t\t\t\t</tr>\t\t\n\t\t\t\t\t\t<tr class=\'label\'>\n\t\t\t\t\t\t\t<td class=\"label\" width=\'25%\'>&nbsp;</td>\n\t\t\t\t\t\t\t<td class=\"label\" width=\'25%\'>&nbsp;</td>\n\t\t\t\t\t\t\t<td class=\"label\" width=\'25%\'>&nbsp;</td>\n\t\t\t\t\t\t\t<td class=\'button\' width=\'25%\'><INPUT TYPE=button class=\'button\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' onclick=\"submitPage2();\" ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="><INPUT TYPE=button class=button value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' onClick=\"closeWindow();\"></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t<input type=\'hidden\' name=\'diag_code\' id=\'diag_code\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'diag_code_scheme\' id=\'diag_code_scheme\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t\t\t<!--removed comment for diag_code_scheme for SCR 4943-->\n\t\t\t\t<input type=\'hidden\' name=\'srl_no\' id=\'srl_no\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'Encounter_Id\' id=\'Encounter_Id\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'operation\' id=\'operation\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'call_function\' id=\'call_function\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'sys_date\' id=\'sys_date\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'recorded_date\' id=\'recorded_date\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'transmission_name\' id=\'transmission_name\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'confirmatin_name\' id=\'confirmatin_name\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'term_set_id\' id=\'term_set_id\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'term_code\' id=\'term_code\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'occur_srl_no\' id=\'occur_srl_no\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\t\t\t\t<script>\n\t\t\t\t\t\tif(document.forms[0].transmission_name.value!=\'\'){\n\t\t\t\t\t\t\tdocument.getElementById(\"img1\").style.visibility=\'hidden\';\n\t\t\t\t\t\t\tdocument.getElementById(\"img2\").style.visibility=\'hidden\';\n\t\t\t\t\t\t\tdocument.getElementById(\"img3\").style.visibility=\'hidden\';\t\t\n\t\t\t\t\t\t\tdocument.getElementById(\"img4\").style.visibility=\'visible\';\n\t\t\t\t\t\t\tdocument.getElementById(\"img5\").style.visibility=\'visible\';\n\t\t\t\t\t\t\tdocument.getElementById(\"img6\").style.visibility=\'visible\';\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(document.forms[0].confirmatin_name.value!=\'\'&& document.forms[0].transmission_name.value!=\'\'){\n\t\t\t\t\t\t\tdocument.getElementById(\"img4\").style.visibility=\'hidden\';\n\t\t\t\t\t\t\tdocument.getElementById(\"img5\").style.visibility=\'hidden\';\n\t\t\t\t\t\t\tdocument.getElementById(\"img6\").style.visibility=\'hidden\';\t\t\n\t\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t</form>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

	PreparedStatement pstmt		= null;
	ResultSet rset						= null;
	Connection con = ConnectionManager.getConnection(request);
	String trans_by_id = "";
	String trans_date = "";
	String conf_by_id = "";
	String conf_date = "";	
	String conf_date_dis="";
	String conf_details_status = "";
	String trns_details_status = "";
	String conf_date_status = "";
	String trans_date_status = "";
	String operation = "";
	String location = "";
	String conf_job_title = "";
	String trans_job_title = "";
	String button_status = "";
	String sys_date = "";
	String trans_date_dis = "";
	request.setCharacterEncoding("UTF-8");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String Encounter_Id = request.getParameter("Encounter_Id")==null?"":request.getParameter("Encounter_Id");
	String call_function = request.getParameter("call_function")==null?"":request.getParameter("call_function");
	String srl_no = request.getParameter("srl_no")==null?"":request.getParameter("srl_no");
	String diag_code = request.getParameter("diag_code")==null?"":request.getParameter("diag_code");
	String diag_code_scheme = request.getParameter("diag_code_scheme")==null?"":request.getParameter("diag_code_scheme");
	//<!--removed comment for diag_code_scheme for SCR 4943-->
	String recorded_date = request.getParameter("recorded_date")==null?"":request.getParameter("recorded_date");
	String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
	String term_code = request.getParameter("term_code")==null?"":request.getParameter("term_code");
	String occur_srl_no = request.getParameter("occur_srl_no")==null?"":request.getParameter("occur_srl_no");
try {
	//String sql = " select to_char(sysdate,'dd/mm/yyyy hh24:mi') SDATE, TRANS_BY_ID,to_char(TRANS_DATE,'dd/mm/yyyy hh24:mi') TRANS_DATE, CONF_BY_ID,to_char(CONF_DATE,'dd/mm/yyyy hh24:mi') CONF_DATE, LOCATION,CONF_JOB_TITLE,TRANS_JOB_TITLE    from mr_diag_transmission where patient_id = ? and srl_no = ? ";
	String sql = " select to_char(sysdate,'dd/mm/yyyy hh24:mi') SDATE, TRANS_BY_ID,to_char(TRANS_DATE,'dd/mm/yyyy hh24:mi') TRANS_DATE, CONF_BY_ID,to_char(CONF_DATE,'dd/mm/yyyy hh24:mi') CONF_DATE, LOCATION,CONF_JOB_TITLE,TRANS_JOB_TITLE    from mr_diag_transmission where patient_id = ? and encounter_id = ? and term_set_id = ? and term_code = ?";
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1,patient_id);
	pstmt.setString(2,Encounter_Id);
	pstmt.setString(3,term_set_id);
	pstmt.setString(4,term_code);
	rset = pstmt.executeQuery();
	while(rset.next()){
		sys_date			= rset.getString("SDATE");
		trans_by_id		= rset.getString("TRANS_BY_ID")==null?"":rset.getString("TRANS_BY_ID");
		trans_date		= rset.getString("TRANS_DATE")==null?"":rset.getString("TRANS_DATE");
		if(trans_date != ""){
			trans_date_dis = DateUtils.convertDate(trans_date,"DMYHM","en",localeName); 			
		}
		conf_by_id		= rset.getString("CONF_BY_ID")==null?"":rset.getString("CONF_BY_ID");
		conf_date			= rset.getString("CONF_DATE")==null?"":rset.getString("CONF_DATE");
		if( conf_date != ""){
			conf_date_dis = DateUtils.convertDate(conf_date,"DMYHM","en",localeName);
		}
		location			= rset.getString("LOCATION")==null?"":rset.getString("LOCATION");
		conf_job_title	= rset.getString("CONF_JOB_TITLE")==null?"":rset.getString("CONF_JOB_TITLE");
		trans_job_title	= rset.getString("TRANS_JOB_TITLE")==null?"":rset.getString("TRANS_JOB_TITLE");
	}
}catch(Exception e){
	e.printStackTrace();
}
finally{
	try{
		if(rset!=null)rset.close();
		if(pstmt!=null)pstmt.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	if (con != null){
		ConnectionManager.returnConnection(con,request);
	}
}
if(call_function.equals("TRANSMIT_NOTIFY_REP")){
		if(trans_by_id.equals("")&& trans_date.equals("")){
			conf_details_status = "disabled";
			conf_date_status	= "disabled";
			trns_details_status = "";
			trans_date_status = "";
			operation = "insert";
			button_status = "";
		}else if (!trans_by_id.equals("")&& !trans_date.equals("")){
			conf_details_status = "disabled";
			trns_details_status = "disabled";
			conf_date_status	= "disabled";
			trans_date_status	= "disabled";
			operation = "display";
			button_status = "disabled";
		}
}else if(call_function.equals("CONF_TRANSMIT_NOTIFY_REP")){
		if(conf_by_id.equals("")&& conf_date.equals("")){
			if(!trans_by_id.equals("")||!trans_date.equals("")){
				conf_details_status = "";
				trns_details_status = "disabled";
				trans_date_status	= "disabled";
				conf_date_status	= "";
				operation = "insert";
				button_status = "";
			}else{
				conf_details_status = "disabled";
				trns_details_status = "disabled";
				trans_date_status	= "disabled";
				conf_date_status	= "disabled";
				operation = "display";
				button_status = "disabled";
			}
		}else if (!trans_by_id.equals("")&& !trans_date.equals("") && !conf_by_id.equals("") && !conf_date.equals("")){
			conf_details_status = "disabled";
			trns_details_status = "disabled";
			trans_date_status	= "disabled";
			conf_date_status	= "disabled";
			operation = "display";
			button_status = "disabled";
		}
}

            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(trans_by_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(trns_details_status));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(conf_by_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(conf_details_status));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(trans_date_dis));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(trns_details_status));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(trans_date_status));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(trans_date));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(trns_details_status));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(trans_date_status));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(conf_job_title));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(conf_details_status));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(trans_job_title));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(trns_details_status));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(conf_date_dis));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(conf_details_status));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(conf_date_status));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(conf_date));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(conf_details_status));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(conf_date_status));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(location));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(trns_details_status));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(button_status));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(diag_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(diag_code_scheme));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(operation));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(recorded_date));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(trans_by_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(conf_by_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(occur_srl_no));
            _bw.write(_wl_block47Bytes, _wl_block47);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.TransmissionDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.CommunicationDetails.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.TransmissionDateTime.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.designation.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.designation.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.AckDateTime.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }
}
