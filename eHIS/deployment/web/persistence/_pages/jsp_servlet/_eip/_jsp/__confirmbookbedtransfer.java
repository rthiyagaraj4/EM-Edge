package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __confirmbookbedtransfer extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/ConfirmBookBedTransfer.jsp", 1724924244295L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tDeveloped by \t:\tChitra \n\tCreated on \t\t:\t27/08/2001\n\tModule\t\t\t:\tip\n-->\n<html>\n";
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

    private final static java.lang.String  _wl_block6 ="\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\n\t<script src=\'../js/ConfirmCancelTransfer.js\' language=\"javascript\"></script>\n\t<!--//Maheshwaran added JS for GHL-CRF-0362-->\n\t\t<script src=\"../js/BedBookingTransfer.js\" language=\"javascript\"></script>\n\t<Script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\n</head>\n<body onLoad=\'seDef(); getOnload_tfrDtls();\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n\t<form name=\"ConfirmCancelTransfer_form\" id=\"ConfirmCancelTransfer_form\"  method=\"post\" action=\"../../servlet/eIP.ConfirmCancelTransferServlet\" target=messageFrame>\n\t<table border=0 width=\"100%\" cellpadding=\'2\' cellspacing=0>\n\t\t<tr>\n\t\t\t<td width=\'25%\' class=\"label\" >";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t\t\t<td  class=\'querydata\' width=\'25%\'><input type=\"hidden\" name=\"admission_date\" id=\"admission_date\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t<td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t<td  class=\'querydata\' width=\'25%\'><input type=\"hidden\" name=\"admission_type\" id=\"admission_type\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td> \n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\"label\"  nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t<td class=\'querydata\' >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="<input type=\"hidden\" name=\"transfer_date\" id=\"transfer_date\"  value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"></td>\n\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="<input type=\"hidden\" name=\"transfer_type\" id=\"transfer_type\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<!--Added by kishore on 4/23/2004-->\n\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="<input type=\"hidden\" name=\"priority_code\" id=\"priority_code\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"></td>\n\t\t\t<td class=\"label\"  nowrap>&nbsp;</td>\n\t\t\t<td class=\'querydata\' ></td>\n\t\t</tr>\n\t</table>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" \n\t<table border=0 width=\"100%\" cellpadding=2 cellspacing=0>\n\t\t<tr>\n\t\t\t<th colspan=4 class=\'columnheader\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</th>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td  class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t<td class=\'fileds\' width=\'25%\'><input type=\'checkbox\' name=\'block_bed\' id=\'block_bed\' onClick=\"enableInform();\" ></td>\n\t\t\t<td class=\"label\" width=\'25%\'>&nbsp;</td>\n\t\t\t<td width=\'25%\'>&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t<td class=\'fileds\' ><input type=text name=\'bed_block_periond\' id=\'bed_block_periond\' value=\"\" disabled id=\'calid3\' maxlength=\"3\" size=\"3\" onBlur = \"validSpecialChars(this);CheckNum(this);\" onKeyPress=\"return allowOnlyNumbers(event);\"><img src=\'../../eCommon/images/mandatory.gif\' id=\"img_m\" ></img><span class=\'label\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</span></td>\n\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t<td class=\'fileds\'><input type=\'checkbox\' name=\'override\' id=\'override\' disabled></td>\n\n\t\t</tr>\n\t</table>\n\n<!--10/20/2008 FS102IPSRRCRF0228V2.0-->\n\t\n\t\t<table width=\'100%\' cellpadding=\'2\' cellspacing=\'0\' BORDER=\'0\'>\n\t<tr>\n\t\t<td colspan=4 width=\"100%\" class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t</tr>\n\t<TR>\n\t<TD  class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</TD>\n\t<TD   class=\"fields\" colspan=\'3\'><INPUT TYPE=\"checkbox\" name=\"reserved_bed_yn\" id=\"reserved_bed_yn\" disabled ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" checked ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="><input type=\"hidden\" name=\"is_reserved_bed_checked\" id=\"is_reserved_bed_checked\"  value=\"N\"></TD>\n\t</TR>\n\t\n\t</table>\n\t\n\t<!---->\n\n\t<table border=0 width=\"100%\" cellpadding=\'2\' cellspacing=0>\n\t\t<tr>\t\n\t\t\t<td align=\'right\'><input type=\"button\" class=\"button\" id=\"confirm_or_cancel\" name = \"confirm_or_cancel\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" onclick=\"checkValues();submitForm_confmCncl(\'CONFIRM\');\"><input type=\"button\" class=\"button\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" onclick=\"const dialogTag = parent.parent.document.getElementById(\'dialog_tag\'); dialogTag.close();\"></td>\n\t\t</tr>\n\t</table>\t\n\t<input type=\"hidden\" name=\"modified_date_val\" id=\"modified_date_val\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t<input type=\"hidden\" name=\"fr_bed_type\" id=\"fr_bed_type\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t<input type=\"hidden\" name=\"booking_ref_no\" id=\"booking_ref_no\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t<input type=\"hidden\" name=\"patient_gender\" id=\"patient_gender\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t<input type=\"hidden\" name=\"def_max_period\" id=\"def_max_period\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t<input type=\"hidden\" name=\"continue_yn\" id=\"continue_yn\" > \n\t<input type=\"hidden\" name=\"pri_target\" id=\"pri_target\">\n\t<input type=\"hidden\" name=\"priority_value\" id=\"priority_value\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" >\n\t<input type=\"hidden\" name=\"to_nursing_unit_type\" id=\"to_nursing_unit_type\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t<input type=\"hidden\" name=\"to_bed_type\" id=\"to_bed_type\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t<input type=\"hidden\" name=\"tobedtype\" id=\"tobedtype\" value=\"\">\n\t<input type=\"hidden\" name=\"bl_interfaced_yn\" id=\"bl_interfaced_yn\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t<input type=\"hidden\" name=\"allow_transfer_yn\" id=\"allow_transfer_yn\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t<input type=\"hidden\" name=\"fr_daily_rate\" id=\"fr_daily_rate\" value=\"0\">\n\t<input type=\"hidden\" name=\"to_daily_rate\" id=\"to_daily_rate\" value=\"0\">\n\t<input type=\"hidden\" name=\"bill_type_code\" id=\"bill_type_code\" value=\"\">\n\t<input type=\"hidden\" name=\"blng_class_code\" id=\"blng_class_code\" value=\"\">\n\t<input type=\"hidden\" name=\"blng_serv_code\" id=\"blng_serv_code\" value=\"\">\n\t<input type=\'hidden\' name=\'modified_bed_type_code\' id=\'modified_bed_type_code\' value=\"\">\n\t<input type=\'hidden\' name=\'billing_group_id\' id=\'billing_group_id\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t<input type=\'hidden\' name=\'billing_group_desc\' id=\'billing_group_desc\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t<input type=\'hidden\' name=\'bl_operational\' id=\'bl_operational\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\t\n\t<input type=\"hidden\" name=\"practid\" id=\"practid\" value=\"\" >\n\t<input type=\"hidden\" name=\"reason_for_cancelation\" id=\"reason_for_cancelation\" value=\"\" >\n\t<input type=\"hidden\" name=\"from_daily_rate\" id=\"from_daily_rate\" value=\"0\" >\n\t<input type=\"hidden\" name=\"BalnkFlag\" id=\"BalnkFlag\" value=\"N\" >\n\t<input type=\"hidden\" name=\"call_function\" id=\"call_function\" value=\"confirm_request\" >\n\t<input type=\"hidden\" name=\"bed_change\" id=\"bed_change\" value=\"\">\n\t<input type=\"hidden\" name=\"blocking_remarks\" id=\"blocking_remarks\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t<input type=\"hidden\" name=\"pseudo_bed\" id=\"pseudo_bed\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t<input type=\"hidden\" name=\"deactivate_pseudo_bed\" id=\"deactivate_pseudo_bed\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t<!--//Maheshwaran added for GHL-CRF-0362-->\n\t<input type=\"hidden\" name=\"p_oper_stn_id\" id=\"p_oper_stn_id\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t<input type=\"hidden\" name=\"change_bed_class_yn\" id=\"change_bed_class_yn\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t<!--End-->\n\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t<input type=\"hidden\" name=\"transfer_chargeable_yn\" id=\"transfer_chargeable_yn\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"transfer_serv_charge\" id=\"transfer_serv_charge\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"surgery_reqd_yn\" id=\"surgery_reqd_yn\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"addnl_dep_amt\" id=\"addnl_dep_amt\" value=\"\">\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);


	request.setCharacterEncoding("UTF-8");
	String locale				= (String)session.getAttribute("LOCALE");
	
	Connection con				= null;
	Statement stmt				= null;
	PreparedStatement pstmt		= null;
	ResultSet rset				= null;
	ResultSet rs				= null;
	Statement stmt1				= null;
	ResultSet rset1				= null;
	Statement stmt_opn				= null;//Maheshwaran added for GHL-CRF-0362
	ResultSet rs_opn				= null;//Maheshwaran added for GHL-CRF-0362
	String facilityId			= (String)session.getValue("facility_id");
	String patientid			= checkForNull(request.getParameter("patient_id"));
	String eid					= checkForNull(request.getParameter("encounter_id"));
	long    encounterid			= Long.parseLong(eid);

	session.putValue("encounter_id",eid);
	session.putValue("patientid",patientid);

	String bookingrefno			= checkForNull(request.getParameter("booking_ref_no"));
	String bl_operational	 	= (String)session.getValue("bl_operational");
	StringBuffer sql			= new StringBuffer();


	String bed_block_period_max_str	= checkForNull(request.getParameter("bed_block_period_max_int"));
	int BED_BLOCK_PERIOD_MAX	= 0;
	if(! bed_block_period_max_str.equals(""))
		BED_BLOCK_PERIOD_MAX	= Integer.parseInt(bed_block_period_max_str);

	String change_bed_class_yn	= checkForNull(request.getParameter("change_bed_class_yn"),"N");
	String bl_interfaced_yn		= checkForNull(request.getParameter("bl_interfaced_yn"),"N");
	String max_blk_type			= checkForNull(request.getParameter("bed_block_period_max_type"));

	String deactivate_pseudo_bed_yn		= checkForNull(request.getParameter("deactivate_pseudo_bed_yn"),"N");
	String admissiondate		= "";
	String admissiontype		= "";
	String age					= "";
	String allow_transfer_yn	= "Y";
	String billing_group_desc	= "";
	String billing_group_id		= "";
	String bookingdatetime		= "";
	String frbedclass			= "";
	String frbedclassdesc		= "";
	String frbedno				= "";
	String frbedtype			= "";
	String frbedtypedesc		= "";
	String frbedtypecode		= "";
	String frmeddesc			= "";
	String frmedid				= "";
	String frnursingunitcode	= "";
	String frnursingunitdesc	= "";
	String frpractdesc			= "";
	String frpractitionerid		= "";
	String frroomno				= "";
	String frservicecode		= "";
	String frservicedesc		= "";
	String frspecialitycode		= "";
	String frspecialitydesc		= "";
	String frsubservcode		= "";
	String frsubservdesc		= "";
	String gender				= "";
	String patient_class		= "";
	String priority				= "";
	String tobedtype			= "";
	String tonursingunittype	= "";
	String trntypecode			= "";
	String trntypedesc			= "";
	int frdailycharge			= 0;
	String modified_date_val	= "";
	String admissiondate_converted = "";
	String bookingdatetime_converted = "";
	String allow_emerg_trf_yn	= "";
	String blocking_remarks		= "";
	String pseudo_bed_yn		= "";
	//Maheshwaran added for GHL-CRF-0362
	String p_oper_stn_id = "";
	String sdate ="";
	String oper_stn_bed_class_yn ="";
	String loginUser				= (String)session.getValue("login_user");
	String sdate_converted	= "";
	//End
 try
 {
	con = ConnectionManager.getConnection(request);
	if(max_blk_type.equals("D"))
			BED_BLOCK_PERIOD_MAX= (BED_BLOCK_PERIOD_MAX)*24;
			//Maheshwaran added for GHL-CRF-0362
		StringBuffer operSql = new StringBuffer();
		operSql.append(" SELECT to_char(sysdate,'dd/mm/rrrr hh24:mi') sdate, a.oper_stn_id  OPER_STN_ID, a.BED_CLASS_CHANGE_YN FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginUser+"' AND trunc(sysdate) between b.eff_date_from and  nvl(b.eff_date_to,trunc(sysdate)) ");
		stmt_opn = con.createStatement();
		rs_opn = stmt_opn.executeQuery(operSql.toString());

		if (rs_opn != null && rs_opn.next())
		{
			p_oper_stn_id = rs_opn.getString("oper_stn_id")== null ? "" : rs_opn.getString("oper_stn_id");
			oper_stn_bed_class_yn = rs_opn.getString("BED_CLASS_CHANGE_YN")== null ? "" : rs_opn.getString("BED_CLASS_CHANGE_YN");
			sdate = rs_opn.getString("sdate");
			if(sdate == null) sdate = "";
			if(!(sdate == null || sdate.equals("")))
				sdate_converted = DateUtils.convertDate(sdate,"DMYHM","en",locale);
			if(rs_opn   != null)   rs_opn.close();
			if(stmt_opn   != null)   stmt_opn.close();
		}
		//End
	try
	{		

		sql.append("select" );
		sql.append("  to_char(SYSDATE,'dd/mm/rrrr hh24:mi') SYSTEM_DATE" );
		sql.append("  , to_char(B.ADMISSION_DATE_TIME,'dd/mm/rrrr hh24:mi')ADMISSION_DATE" );
		sql.append("  , to_char(A.TFR_REQ_DATE_TIME,'dd/mm/rrrr hh24:mi') BOOKING_DATE_TIME" );
		sql.append("  , IP_GET_DESC.IP_ADMISSION_TYPE(B.ADMISSION_TYPE,'"+locale+"', '2') ADMISSION_SHORT_DESC" );
		sql.append("  , B.ADMISSION_TYPE" );
		sql.append("  , A.REQ_BED_CLASS_CODE BED_CLASS_CODE" );
		sql.append("  , IP_GET_DESC.IP_BED_CLASS(A.REQ_BED_CLASS_CODE,'"+locale+"', '2') BED_CLASS_SHORT_DESC" );
		sql.append("  , A.REQ_BED_NO BED_NO" );
		sql.append("  , A.REQ_BED_TYPE_CODE BED_TYPE_CODE" );
		sql.append("  , IP_GET_DESC.IP_BED_TYPE(A.REQ_BED_TYPE_CODE,'"+locale+"', '2') BED_TYPE_SHORT_DESC" );
		sql.append("  , A.BLOCKING_REMARKS" );
		sql.append("  , A.BLOCKING_TYPE_CODE" );
		sql.append("  , B.BED_CLASS_CODE FROM_BED_CLASS_CODE" );
		sql.append("  , IP_GET_DESC.IP_BED_CLASS(B.BED_CLASS_CODE,'"+locale+"', '2') FROM_BED_CLASS_SHORT_DESC" );
		/*Friday, February 05, 2010 , 18927 , from bed type showing as to bed type*/
		sql.append("  , B.BED_TYPE_CODE FROM_BED_TYPE_CODE" );
		sql.append("  , IP_GET_DESC.IP_BED_TYPE(B.BED_TYPE_CODE,'"+locale+"', '2') FROM_BED_TYPE_SHORT_DESC" );
		/**/
		sql.append("  , B.BED_NUM FROM_BED_NO" );
		sql.append("  , B.NURSING_UNIT_CODE FROM_NURSING_UNIT_CODE" );
		sql.append("  , IP_GET_DESC.IP_NURSING_UNIT(B.FACILITY_ID, B.NURSING_UNIT_CODE,'"+locale+"', '2') FROM_NURSING_UNIT_SHORT_DESC" );
		sql.append("  , B.ATTEND_PRACTITIONER_ID FROM_PRACTITIONER_ID" );
		sql.append("  , AM_GET_DESC.AM_PRACTITIONER(B.ATTEND_PRACTITIONER_ID,'"+locale+"','1') FROM_PRACTITIONER_NAME" );
		sql.append("  , B.ROOM_NUM FROM_ROOM_NO" );
		sql.append("  , B.SERVICE_CODE FROM_SERVICE_CODE" );
		sql.append("  , AM_GET_DESC.AM_SERVICE(B.SERVICE_CODE,'"+locale+"','2') FROM_SERVICE_SHORT_DESC" );
		sql.append("  , B.SPECIALTY_CODE FROM_SPECIALTY_CODE" );
		sql.append("  , AM_GET_DESC.AM_SPECIALITY(B.SPECIALTY_CODE,'"+locale+"','2') FROM_SPECIALTY_SHORT_DESC" );
		sql.append("  , B.SUBSERVICE_CODE FROM_SUBSERVICE_CODE" );
		sql.append("  , AM_GET_DESC.AM_SUBSERVICE(A.REQ_SERVICE_CODE, A.REQ_SUBSERVICE_CODE,'"+locale+"','2') FROM_SUBSERVICE_SHORT_DESC" );
		sql.append("  , B.TEAM_ID FROM_TEAM_ID" );
		sql.append("  , AM_GET_DESC.AM_MEDICAL_TEAM(B.FACILITY_ID, B.TEAM_ID,'"+locale+"','2') FROM_TEAM_SHORT_DESC" );
		sql.append("  , C.SEX GENDER" );
		sql.append("  , A.INFORMED_DATE_TIME" );
		sql.append("  , A.INFORMED_NAME" );
		sql.append("  , B.NURSING_UNIT_CODE" );
		sql.append("  , IP_GET_DESC.IP_NURSING_UNIT(B.FACILITY_ID, B.NURSING_UNIT_CODE,'"+locale+"','2') NURSING_UNIT_SHORT_DESC" );
		sql.append("  , B.PAT_CURR_LOCN_CODE" );
		sql.append("  , A.REQ_PRACTITIONER_ID" );
		sql.append("  , AM_GET_DESC.AM_PRACTITIONER(A.REQ_PRACTITIONER_ID,'"+locale+"','1') PRACTITIONER_NAME" );
		sql.append("  , A.PREF_DATE_TIME" );
		sql.append("  , A.PRIORITY_CODE" );
		sql.append("  , A.PRIORITY_EXP_DATE" );
		sql.append("  , IP_GET_DESC.IP_TRANSFER_PRIORITY(A.FACILITY_ID, A.PRIORITY_CODE,'"+locale+"','2') PRIORITY_SHORT_DESC" );
		sql.append("  , A.RECORDS_AND_DOCUMENTS1" );
		sql.append("  , A.RECORDS_AND_DOCUMENTS2" );
		sql.append("  , A.RECORDS_AND_DOCUMENTS3" );
		sql.append("  , A.RECORDS_AND_DOCUMENTS4" );
		sql.append("  , A.RECORDS_AND_DOCUMENTS5" );
		sql.append("  , A.REQ_BED_TYPE_CODE_BY_DEFN" );
		sql.append("  , B.ROOM_NUM ROOM_NO" );
		sql.append("  , B.SERVICE_CODE" );
		sql.append("  , AM_GET_DESC.AM_SERVICE(B.SERVICE_CODE,'"+locale+"','2') SERVICE_SHORT_DESC" );
		sql.append("  , B.SPECIALTY_CODE" );
		sql.append("  , AM_GET_DESC.AM_SPECIALITY(B.SPECIALTY_CODE,'"+locale+"','2') SPECIALTY_SHORT_DESC" );
		sql.append("  , SUBSERVICE_CODE" );
		sql.append("  , AM_GET_DESC.AM_SUBSERVICE(B.SERVICE_CODE,B.SUBSERVICE_CODE,'"+locale+"','2') SUBSERVICE_SHORT_DESC" );
		sql.append("  , A.REQ_TEAM_ID TEAM_ID" );
		sql.append("  , AM_GET_DESC.AM_MEDICAL_TEAM(A.FACILITY_ID, A.REQ_TEAM_ID,'"+locale+"','2') TEAM_SHORT_DESC" );
		sql.append("  , A.TFR_REQ_ACCEPTED_YN" );
		sql.append("  , A.TFR_REQ_DATE_TIME" );
		sql.append("  , A.TFR_REQ_REASON" );
		sql.append("  , A.TFR_REQ_REF_NO" );
		sql.append("  , A.TFR_REQ_STATUS" );
		sql.append("  , A.TFR_REQ_STATUS TFR_REQ_STATUS_DESC" );
		sql.append("  , A.TFR_REQ_TYPE" );
		sql.append("  , A.TFR_REQ_TYPE TFR_REQ_TYPE_DESC" );
		sql.append("  , IP_GET_DESC.IP_TRANSFER_TYPE(A.TFR_REQ_REASON,'"+locale+"','2') TRANSFER_TYPE_SHORT_DESC" );
		sql.append("  , to_char (C.DATE_OF_BIRTH, 'dd/mm/rrrr hh24:mi') DATE_OF_BIRTH" );
		sql.append("  , B.PATIENT_CLASS" );
		sql.append("  , NULL DLY_CHARGE " );
		sql.append("  , to_char(a.modified_date,'dd/mm/rrrr hh24:mi') modified_date " );
		//11/15/2008 FS102IPSRRCRF0228V2.0
		sql.append("  , a.blocking_type_code " );
		/*Monday, September 13, 2010 , SRR20056-SCF-5155 [IN:023680]*/
		sql.append("  ,(select pseudo_bed_yn from ip_nursing_unit_bed where  facility_id = b.facility_id and  nursing_unit_code = b.nursing_unit_code and bed_no = b.bed_num) pseudo_bed_yn " );
		//
		sql.append("from" );
		sql.append("  IP_TRANSFER_REQUEST A" );
		sql.append("  , IP_OPEN_ENCOUNTER B" );
		sql.append("  , MP_PATIENT C " );
		sql.append("where A.FACILITY_ID = B.FACILITY_ID " );
		sql.append("  and A.ENCOUNTER_ID = B.ENCOUNTER_ID " );
		sql.append("  and A.ENCOUNTER_ID = '"+encounterid+"' " );
		sql.append("  and A.FACILITY_ID = '"+facilityId+"' " );
		sql.append("  and A.TFR_REQ_STATUS = '0' " );
		sql.append("  and B.PATIENT_ID = C.PATIENT_ID" );
		
		stmt	= con.createStatement();

		rset	= stmt.executeQuery(sql.toString());
		if (rset.next() && rset != null)
		{
			modified_date_val	= checkForNull(rset.getString("modified_date"));  
			admissiondate		= checkForNull(rset.getString("admission_date")); 
			if(!(admissiondate.equals("") || admissiondate == null))
						admissiondate_converted = DateUtils.convertDate(admissiondate,"DMYHM","en",locale); 
		
			admissiontype		= checkForNull(rset.getString("admission_short_desc"));
			frbedtype			= checkForNull(rset.getString("bed_type_code"));
			gender				= checkForNull(rset.getString("gender"));
			priority			= checkForNull(rset.getString("priority_short_desc"));
			trntypecode			= checkForNull(rset.getString("tfr_req_type"));
			trntypedesc			= checkForNull(rset.getString("transfer_type_short_desc"));  
			bookingdatetime		= checkForNull(rset.getString("booking_date_time"));
			if(!(bookingdatetime.equals("") || bookingdatetime == null))
						bookingdatetime_converted = DateUtils.convertDate(bookingdatetime,"DMYHM","en",locale); 
		
			frnursingunitcode	= checkForNull(rset.getString("from_nursing_unit_code")); 
			frbedno				= checkForNull(rset.getString("from_bed_no"));
			frpractdesc			= checkForNull(rset.getString("from_practitioner_name"));
			frspecialitycode	= checkForNull(rset.getString("from_specialty_code"));   
			frspecialitydesc	= checkForNull(rset.getString("from_specialty_short_desc"));
			frbedclass			= checkForNull(rset.getString("from_bed_class_code"));  
			frbedclassdesc		= checkForNull(rset.getString("from_bed_class_short_desc")); 
			frnursingunitdesc	= checkForNull(rset.getString("from_nursing_unit_short_desc")); 
			frroomno				= checkForNull(rset.getString("from_room_no"));
			//frbedtypedesc		= checkForNull(rset.getString("bed_type_short_desc"));
			/*Friday, February 05, 2010 , 18927 , from bed type showing as to bed type*/
			frbedtypecode		= checkForNull(rset.getString("from_bed_type_code"));
			frbedtypedesc		= checkForNull(rset.getString("from_bed_type_short_desc")); 
			/**/
			frservicecode		= checkForNull(rset.getString("from_service_code"));
			frservicedesc		= checkForNull(rset.getString("from_service_short_desc"));
			frsubservcode		= checkForNull(rset.getString("from_subservice_code"));
			frsubservdesc		= checkForNull(rset.getString("from_subservice_short_desc"));
			frmeddesc			= checkForNull(rset.getString("from_team_short_desc"));
			frmedid				= checkForNull(rset.getString("from_team_id"));
			frpractitionerid		= checkForNull(rset.getString("req_practitioner_id"));
			frdailycharge		= Integer.parseInt(checkForNull(rset.getString("dly_charge"),"0"));
			age					= checkForNull(rset.getString("date_of_birth"));
			patient_class		= checkForNull(rset.getString("patient_class"));
			//11/15/2008 FS102IPSRRCRF0228V2.0
			blocking_remarks    = checkForNull(rset.getString("blocking_type_code"));
			pseudo_bed_yn		= checkForNull(rset.getString("pseudo_bed_yn"),"N");
			//
		}

		if (rset!=null) rset.close();
		if (stmt!=null) stmt.close();

		if (bl_operational.equals("Y"))
		{
			StringBuffer bl_elig = new StringBuffer();
			bl_elig.append("select a.blng_grp_id, a.short_desc from BL_BLNG_GRP a, BL_EPISODE_FIN_DTLS b where a.blng_grp_id = b.blng_grp_id and b.operating_facility_id ='"+facilityId+"' and b.episode_id = '"+encounterid+"'");			
			stmt1 = con.createStatement();

			rset1 = stmt1.executeQuery(bl_elig.toString());
			while (rset1.next())
			{
				billing_group_id = rset1.getString("BLNG_GRP_ID");
				billing_group_desc = rset1.getString("SHORT_DESC");
			}
			if (rset1!=null) rset1.close();
			if (stmt1!=null) stmt1.close();
		}	

		String auto_file_transfer_yn ="";
		int cnt=0;		
		String sqlQuery = "";
		String sqlQuery1 ="";

		sqlQuery = "SELECT auto_file_transfer_yn FROM ip_nursing_unit WHERE facility_id = ? AND nursing_unit_code = ? AND 'Y' = (SELECT install_yn FROM sm_module WHERE module_id = 'FM') AND 'Y' = (Select transfer_file_yn from fm_parameter  where facility_id =?) AND fs_locn_code is not null";

		pstmt = con.prepareStatement(sqlQuery);
		pstmt.setString(1,facilityId);
		pstmt.setString(2,frnursingunitcode);
		pstmt.setString(3,facilityId);
		rs = pstmt.executeQuery();
		if(rs!=null && rs.next())
			auto_file_transfer_yn = rs.getString("auto_file_transfer_yn")==null?"":rs.getString("auto_file_transfer_yn");
		
		if (rs!=null)rs.close();
			if (pstmt!=null)pstmt.close();


	    if(auto_file_transfer_yn.equals("Y")) {			
			sqlQuery1 = " Select count(*) from fm_transit_file where facility_id =? and patient_id =?";			
			pstmt = con.prepareStatement(sqlQuery1);
			pstmt.setString(1,facilityId);
			pstmt.setString(2,patientid);			
			rs = pstmt.executeQuery();
			if(rs!=null && rs.next())
				cnt =rs.getInt(1);					
			if (rs!=null)rs.close();
			if (pstmt!=null)pstmt.close();				
			if(cnt==0)
			 allow_transfer_yn="Y";
			else								
			 allow_transfer_yn="N";
			
			
		}
		
		/*10/20/2008 FS102IPSRRCRF0228V2.0 */
			
			String sql_nu	= " select ALLOW_EMERG_TRF_YN  from IP_NURSING_UNIT where nursing_unit_code='"+frnursingunitcode+"' and facility_id ='"+facilityId+"' ";

			stmt = con.createStatement() ;	
			rset = stmt.executeQuery(sql_nu.toString());
			
			if( rset != null &&  rset.next())
				{
					allow_emerg_trf_yn = checkForNull(rset.getString("allow_emerg_trf_yn"));
				 }
				if(rset!=null) rset.close();		
			
	
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(admissiondate));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(admissiondate_converted));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(admissiontype));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(admissiontype));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(bookingdatetime_converted));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(bookingdatetime));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(trntypedesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(trntypecode));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block19Bytes, _wl_block19);
            {java.lang.String __page ="../../eIP/jsp/TransferDetails.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("call_function"), weblogic.utils.StringUtils.valueOf("confirm_request")},{ weblogic.utils.StringUtils.valueOf("admissiondate"), weblogic.utils.StringUtils.valueOf(admissiondate
                        )},{ weblogic.utils.StringUtils.valueOf("frnursingunitcode"), weblogic.utils.StringUtils.valueOf(frnursingunitcode
                        )},{ weblogic.utils.StringUtils.valueOf("frbedno"), weblogic.utils.StringUtils.valueOf(frbedno
                        )},{ weblogic.utils.StringUtils.valueOf("frpractitionerid"), weblogic.utils.StringUtils.valueOf(frpractitionerid
                        )},{ weblogic.utils.StringUtils.valueOf("frpractdesc"), weblogic.utils.StringUtils.valueOf(frpractdesc
                        )},{ weblogic.utils.StringUtils.valueOf("frspecialitycode"), weblogic.utils.StringUtils.valueOf(frspecialitycode
                        )},{ weblogic.utils.StringUtils.valueOf("frspecialitydesc"), weblogic.utils.StringUtils.valueOf(frspecialitydesc
                        )},{ weblogic.utils.StringUtils.valueOf("frbedclass"), weblogic.utils.StringUtils.valueOf(frbedclass
                        )},{ weblogic.utils.StringUtils.valueOf("frbedclassdesc"), weblogic.utils.StringUtils.valueOf(frbedclassdesc
                        )},{ weblogic.utils.StringUtils.valueOf("frnursingunitdesc"), weblogic.utils.StringUtils.valueOf(frnursingunitdesc
                        )},{ weblogic.utils.StringUtils.valueOf("frroomno"), weblogic.utils.StringUtils.valueOf(frroomno
                        )},{ weblogic.utils.StringUtils.valueOf("frbedtype"), weblogic.utils.StringUtils.valueOf(frbedtypecode
                        )},{ weblogic.utils.StringUtils.valueOf("frbedtypedesc"), weblogic.utils.StringUtils.valueOf(frbedtypedesc
                        )},{ weblogic.utils.StringUtils.valueOf("frdailycharge"), weblogic.utils.StringUtils.valueOf(frdailycharge
                        )},{ weblogic.utils.StringUtils.valueOf("age"), weblogic.utils.StringUtils.valueOf(age
                        )},{ weblogic.utils.StringUtils.valueOf("gender"), weblogic.utils.StringUtils.valueOf(gender
                        )},{ weblogic.utils.StringUtils.valueOf("frservicecode"), weblogic.utils.StringUtils.valueOf(frservicecode
                        )},{ weblogic.utils.StringUtils.valueOf("frservicedesc"), weblogic.utils.StringUtils.valueOf(frservicedesc
                        )},{ weblogic.utils.StringUtils.valueOf("frsubservcode"), weblogic.utils.StringUtils.valueOf(frsubservcode
                        )},{ weblogic.utils.StringUtils.valueOf("frsubservdesc"), weblogic.utils.StringUtils.valueOf(frsubservdesc
                        )},{ weblogic.utils.StringUtils.valueOf("patient_class"), weblogic.utils.StringUtils.valueOf(patient_class
                        )},{ weblogic.utils.StringUtils.valueOf("frmeddesc"), weblogic.utils.StringUtils.valueOf(frmeddesc
                        )},{ weblogic.utils.StringUtils.valueOf("frmedid"), weblogic.utils.StringUtils.valueOf(frmedid
                        )},{ weblogic.utils.StringUtils.valueOf("ch_bed_class_param"), weblogic.utils.StringUtils.valueOf(change_bed_class_yn
                        )},{ weblogic.utils.StringUtils.valueOf("deact_pseudo_bed"), weblogic.utils.StringUtils.valueOf(deactivate_pseudo_bed_yn
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
if(!allow_emerg_trf_yn.equals("Y") && !blocking_remarks.equals("")){
            _bw.write(_wl_block30Bytes, _wl_block30);
}
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.confirm.label","common_labels")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(modified_date_val));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(frbedtype));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(bookingrefno));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(BED_BLOCK_PERIOD_MAX));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(tonursingunittype));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(tobedtype));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(allow_transfer_yn));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(billing_group_id));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(billing_group_desc));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(bl_operational));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(blocking_remarks));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(pseudo_bed_yn));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(deactivate_pseudo_bed_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(p_oper_stn_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(oper_stn_bed_class_yn));
            _bw.write(_wl_block53Bytes, _wl_block53);

	if(bl_interfaced_yn.equals("Y"))
	{
            _bw.write(_wl_block54Bytes, _wl_block54);
}
	}catch(Exception e)
	{
		out.print("Exception :"+e);
	}
	finally 
	{
		if(rset	!= null)   rset.close();
		if(stmt1  != null)   stmt1.close();
		if(rset1   != null)   rset1.close();
		if(stmt   != null)   stmt.close();
	}
}
catch(Exception e)
{
	out.println("Exception in tryCatch : "+ e.toString());
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
	 
            _bw.write(_wl_block55Bytes, _wl_block55);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiondate.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiontype.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.TransferBookingDate.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ReasonforTransfer.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BlockBedDetails.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BlockBed.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Period.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.override.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ReserveBedDetails.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ReserveBed.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }
}
