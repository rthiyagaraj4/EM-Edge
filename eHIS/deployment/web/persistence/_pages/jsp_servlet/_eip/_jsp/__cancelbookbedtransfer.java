package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.ConnectionManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;
import com.ehis.util.*;

public final class __cancelbookbedtransfer extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/CancelBookBedTransfer.jsp", 1720177724049L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
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

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\n\t<script src=\'../js/ConfirmCancelTransfer.js\' language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body  onload=\"getOnload_tfrDtls();setdefault()\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<!--Added by kishore on 4/26/2004-->\n<form name=\"ConfirmCancelTransfer_form\" id=\"ConfirmCancelTransfer_form\"  method=\"post\" action=\"../../servlet/eIP.ConfirmCancelTransferServlet\" target=_top>\n<table border=\'0\' width=\"100%\" cellpadding=2 cellspacing=0>\n\t<tr>\n\t\t<td  class=\"label\"  width=\'25%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&nbsp;</td>\n\t\t <td  class=\'querydata\' width=\'25%\'><input type=\"hidden\" name=\"admission_date\" id=\"admission_date\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t<td  class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&nbsp;</td>\n\t\t<td  class=\'querydata\' width=\'25%\'><input type=\"hidden\" name=\"admission_type\" id=\"admission_type\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td> \n\t</tr>\n\t<tr>\n\t\t<td class=\"label\"  nowrap>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&nbsp;</td>\n\t\t<td class=\'querydata\' >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="<input type=\"hidden\" name=\"transfer_date\" id=\"transfer_date\"  value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"></td>\n\t\t<!--Changed Lable name from Tranfer type to Reason for Transfer by kishore on 4/23/2004-->\n\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="<input type=\"hidden\" name=\"transfer_type\" id=\"transfer_type\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="<input type=\"hidden\" name=\"priority_code\" id=\"priority_code\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"></td>\t\t\n\t\t<td class=\"label\"  nowrap>&nbsp;</td>\n\t\t<td class=\'querydata\'  ></td>\n\t</tr>\n</table>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t<table border=0 width=\"100%\" cellpadding=2 cellspacing=0>\n\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t<tr>\n\t\t<td colspan=4 class=\'columnheader\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t</tr>\n\t<tr>\n\t\t<td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&nbsp;</td>\n\t\t<td class=\'querydata\' colspan=3>\n\t\t<select name=\'reason_for_cancel\' id=\'reason_for_cancel\'><option value=\'\' selected >-----";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="-----";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t<OPTION VALUE=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t</select> \n\t<img align=\"center\" src=\"../../eCommon/images/mandatory.gif\">\n\t<input type=\"hidden\" name=\"reason_for_cancelation\" id=\"reason_for_cancelation\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" >\n\t<input type=\"hidden\" name=\"reason_for_cancelation\" id=\"reason_for_cancelation\" value=\"\">\n\t</td>\n</tr>\n<tr>\n\t<td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&nbsp;&nbsp;</td>\n\t<td nowrap  colspan=\'2\'><input type=\'hidden\' name=\'authorized_practid\' id=\'authorized_practid\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" readonly><input type=\'text\' name=\'pract_descn\' id=\'pract_descn\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" size=\'40\' maxlength=\'30\' onblur=\"BeforeGetPractitioner(document.forms[0].practid1,pract_descn, \'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\');\"><input type=\'button\' name=\'pract_id_search\' id=\'pract_id_search\' value=\'?\' class=\'button\'  onClick=\"checkPractTxtVal(document.forms[0].practid1,document.forms[0].pract_descn,\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\');\" >\n\t<img align=\"center\" src=\"../../eCommon/images/mandatory.gif\">\t\t\n\t<input type=hidden name=\"pract_desc_hid\" id=\"pract_desc_hid\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"></td>\n\t<td  class=\'querydata\' width=\'25%\'><input type=\"hidden\" name=\"pract_id\" id=\"pract_id\" value=\"\"></td>\n</tr>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\t\n</table>\t\n\n<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n<input type=\"hidden\" name=\"fr_bed_type\" id=\"fr_bed_type\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n<input type=\"hidden\" name=\"booking_ref_no\" id=\"booking_ref_no\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n<input type=\"hidden\" name=\"patient_gender\" id=\"patient_gender\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n<input type=\"hidden\" name=\"age\" id=\"age\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" >\n<input type=\"hidden\" name=\"continue_yn\" id=\"continue_yn\" > \n<input type=\"hidden\" name=\"pri_target\" id=\"pri_target\">\n<input type=\"hidden\" name=\"priority_value\" id=\"priority_value\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" >\n<input type=\"hidden\" name=\"to_nursing_unit_type\" id=\"to_nursing_unit_type\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n<input type=\"hidden\" name=\"to_bed_type\" id=\"to_bed_type\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n<input type=\"hidden\" name=\"bl_interfaced_yn\" id=\"bl_interfaced_yn\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n<input type=\"hidden\" name=\"allow_transfer_yn\" id=\"allow_transfer_yn\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n<input type=\"hidden\" name=\"fr_daily_rate\" id=\"fr_daily_rate\" value=\"0\">\n<input type=\"hidden\" name=\"to_daily_rate\" id=\"to_daily_rate\" value=\"0\">\n<input type=\"hidden\" name=\"bill_type_code\" id=\"bill_type_code\" value=\"\">\n<input type=\"hidden\" name=\"blng_class_code\" id=\"blng_class_code\" value=\"\">\n<input type=\"hidden\" name=\"blng_serv_code\" id=\"blng_serv_code\" value=\"\">\n<input type=\'hidden\' name=\'modified_bed_type_code\' id=\'modified_bed_type_code\' value=\"\">\n<input type=\'hidden\' name=\'billing_group_id\' id=\'billing_group_id\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n<input type=\'hidden\' name=\'billing_group_desc\' id=\'billing_group_desc\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n<input type=\'hidden\' name=\'bl_operational\' id=\'bl_operational\' value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\t\n<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\t\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t<!-- START MODIFICATION BY ARUN -->\n\t\t<!-- MOD#02 Introduced the following hidden item corresponding to the commented billing -->\n\t\t\t<input type=\"hidden\" name=\"transfer_chargeable_yn\" id=\"transfer_chargeable_yn\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"transfer_serv_charge\" id=\"transfer_serv_charge\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"surgery_reqd_yn\" id=\"surgery_reqd_yn\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"addnl_dep_amt\" id=\"addnl_dep_amt\" value=\"\">\n\t<!-- END MODIFICATION BY ARUN -->\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\t\n\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t<table border=0 width=\'100%\' cellpadding=2 cellspacing=0 align=\"right\">\n\t\t<tr>\n\t\t<td align=right>\n\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\t\t\n\t\t\t<input type=\"button\" class=\"button\" name = \"confirm_or_cancel\" id = \"confirm_or_cancel\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" onclick=\'OffsetDate(\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\", \"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"); checkForMandatory();\'>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="<input type=\"button\" class=\"button\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" onclick=\"const dialogTag = parent.parent.document.getElementById(\'dialog_tag\'); dialogTag.close();\">\n\t</tr>\n\t</table>\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n</form>\t \n</body>\n</html>\n\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );
	
	// Added by Sridhar R on Mar 11 2005.. for handling null values ..
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
	String locale			= (String)session.getAttribute("LOCALE");
	
	Connection con			= null;
	Statement stmt			= null;	
	ResultSet rset				= null;	
	ResultSet rset_practid	= null;
	Statement stmt1			= null;
	ResultSet rset1			= null;
	Statement stmt_bl		= null;
	ResultSet rs_bl				= null;
	String facilityId			= (String)session.getValue("facility_id");
	String bl_operational		= (String)session.getValue("bl_operational");
	StringBuffer strBuffer	= new StringBuffer();

try
{
		String bl_interfaced_yn= checkForNull(request.getParameter("bl_interfaced_yn"),"N");
		con = ConnectionManager.getConnection(request);
		String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String patientid		= checkForNull(request.getParameter("patient_id"));
	String eid				= checkForNull(request.getParameter("encounter_id"));
	long    encounterid	= Long.parseLong(eid);
	session.putValue("encounter_id",eid);
	session.putValue("patientid",patientid);
	String bookingrefno	= checkForNull(request.getParameter("booking_ref_no"));
	String fromfunction	= checkForNull(request.getParameter("fromFunction"));
	String admissiondate			= "";
	String admissiontype			= "";
	String trntypecode			= "";
	String trntypedesc			= "";
	String frpractitionerid		= "";
	String frpractdesc			= "";
	String frnursingunitcode	 	= "";
	String frbedtype				= "";
	String tonursingunittype	= "";
	String tobedtype				= "";
	String bookingdatetime		= "";
	String gender					= "";
	String allow_transfer_yn 	= "Y";
	String billing_group_id		= "";
	String billing_group_desc	= "";
	String age						= "";
	String priority					= "";
	String default_priority		= "";
	String max_priority			= "";
	String sysDate					= "";
	String frbedno					= ""; 
	String frspecialitycode		= ""; 
	String frspecialitydesc		= "";
	String frbedclass				= ""; 
	String frbedclassdesc		= ""; 
	String frbedtypecode		= "";
	String frnursingunitdesc		= ""; 
	String frroomno				= ""; 
	String frbedtypedesc			= ""; 
	String frservicecode			= ""; 
	String frservicedesc			= ""; 
	String frsubservcode			= ""; 
	String frsubservdesc			= ""; 
	String frmeddesc				= ""; 
	String frmedid					= "";
	String patient_class			= "";
	String change_bed_class_yn	= "N";
	String admissiondate_converted	= "";
	String bookingdatetime_converted = "";
	int		frdailycharge			= 0;
	try
	{		
		stmt1	= con.createStatement();
		//fromfunction="RequestDetail";
		strBuffer.append("select" );
		strBuffer.append("  to_char(SYSDATE,'dd/mm/rrrr hh24:mi') SYSTEM_DATE" );
		strBuffer.append("  , to_char(B.ADMISSION_DATE_TIME,'dd/mm/rrrr hh24:mi')ADMISSION_DATE" );
		strBuffer.append("  , to_char(A.TFR_REQ_DATE_TIME,'dd/mm/rrrr hh24:mi') BOOKING_DATE_TIME" );
		strBuffer.append("  , IP_GET_DESC.IP_ADMISSION_TYPE(B.ADMISSION_TYPE,'"+locale+"', '2') ADMISSION_SHORT_DESC" );
		strBuffer.append("  , B.ADMISSION_TYPE" );
		strBuffer.append("  , A.REQ_BED_CLASS_CODE BED_CLASS_CODE" );
		strBuffer.append("  , IP_GET_DESC.IP_BED_CLASS(A.REQ_BED_CLASS_CODE,'"+locale+"', '2') BED_CLASS_SHORT_DESC" );
		strBuffer.append("  , A.REQ_BED_NO BED_NO" );
		strBuffer.append("  , A.REQ_BED_TYPE_CODE BED_TYPE_CODE" );
		strBuffer.append("  , IP_GET_DESC.IP_BED_TYPE(A.REQ_BED_TYPE_CODE,'"+locale+"', '2') BED_TYPE_SHORT_DESC" );
		strBuffer.append("  , A.BLOCKING_REMARKS" );
		strBuffer.append("  , A.BLOCKING_TYPE_CODE" );
		strBuffer.append("  , B.BED_CLASS_CODE FROM_BED_CLASS_CODE" );
		strBuffer.append("  , IP_GET_DESC.IP_BED_CLASS(B.BED_CLASS_CODE,'"+locale+"', '2') FROM_BED_CLASS_SHORT_DESC" );
		/*Friday, February 05, 2010 , 18927 , from bed type showing as to bed type*/
		strBuffer.append("  , B.BED_TYPE_CODE FROM_BED_TYPE_CODE" );
		strBuffer.append("  , IP_GET_DESC.IP_BED_TYPE(B.BED_TYPE_CODE,'"+locale+"', '2') FROM_BED_TYPE_SHORT_DESC" );
		/**/
		strBuffer.append("  , B.BED_NUM FROM_BED_NO" );
		strBuffer.append("  , B.NURSING_UNIT_CODE FROM_NURSING_UNIT_CODE" );
		strBuffer.append("  , IP_GET_DESC.IP_NURSING_UNIT(B.FACILITY_ID, B.NURSING_UNIT_CODE,'"+locale+"', '2') FROM_NURSING_UNIT_SHORT_DESC" );
		strBuffer.append("  , B.ATTEND_PRACTITIONER_ID FROM_PRACTITIONER_ID" );
		strBuffer.append("  , AM_GET_DESC.AM_PRACTITIONER(B.ATTEND_PRACTITIONER_ID,'"+locale+"','1') FROM_PRACTITIONER_NAME" );
		strBuffer.append("  , B.ROOM_NUM FROM_ROOM_NO" );
		strBuffer.append("  , B.SERVICE_CODE FROM_SERVICE_CODE" );
		strBuffer.append("  , AM_GET_DESC.AM_SERVICE(B.SERVICE_CODE,'"+locale+"','2') FROM_SERVICE_SHORT_DESC" );
		strBuffer.append("  , B.SPECIALTY_CODE FROM_SPECIALTY_CODE" );
		strBuffer.append("  , AM_GET_DESC.AM_SPECIALITY(B.SPECIALTY_CODE,'"+locale+"','2') FROM_SPECIALTY_SHORT_DESC" );
		strBuffer.append("  , B.SUBSERVICE_CODE FROM_SUBSERVICE_CODE" );
		strBuffer.append("  , AM_GET_DESC.AM_SUBSERVICE(A.REQ_SERVICE_CODE, A.REQ_SUBSERVICE_CODE,'"+locale+"','2') FROM_SUBSERVICE_SHORT_DESC" );
		strBuffer.append("  , B.TEAM_ID FROM_TEAM_ID" );
		strBuffer.append("  , AM_GET_DESC.AM_MEDICAL_TEAM(B.FACILITY_ID, B.TEAM_ID,'"+locale+"','2') FROM_TEAM_SHORT_DESC" );
		strBuffer.append("  , C.SEX GENDER" );
		strBuffer.append("  , A.INFORMED_DATE_TIME" );
		strBuffer.append("  , A.INFORMED_NAME" );
		strBuffer.append("  , B.NURSING_UNIT_CODE" );
		strBuffer.append("  , IP_GET_DESC.IP_NURSING_UNIT(B.FACILITY_ID, B.NURSING_UNIT_CODE,'"+locale+"','2') NURSING_UNIT_SHORT_DESC" );
		strBuffer.append("  , B.PAT_CURR_LOCN_CODE" );
		strBuffer.append("  , A.REQ_PRACTITIONER_ID" );
		strBuffer.append("  , AM_GET_DESC.AM_PRACTITIONER(A.REQ_PRACTITIONER_ID,'"+locale+"','1') PRACTITIONER_NAME" );
		strBuffer.append("  , A.PREF_DATE_TIME" );
		strBuffer.append("  , A.PRIORITY_CODE" );
		strBuffer.append("  , A.PRIORITY_EXP_DATE" );
		strBuffer.append("  , IP_GET_DESC.IP_TRANSFER_PRIORITY(A.FACILITY_ID, A.PRIORITY_CODE,'"+locale+"','2') PRIORITY_SHORT_DESC" );
		strBuffer.append("  , A.RECORDS_AND_DOCUMENTS1" );
		strBuffer.append("  , A.RECORDS_AND_DOCUMENTS2" );
		strBuffer.append("  , A.RECORDS_AND_DOCUMENTS3" );
		strBuffer.append("  , A.RECORDS_AND_DOCUMENTS4" );
		strBuffer.append("  , A.RECORDS_AND_DOCUMENTS5" );
		strBuffer.append("  , A.REQ_BED_TYPE_CODE_BY_DEFN" );
		strBuffer.append("  , B.ROOM_NUM ROOM_NO" );
		strBuffer.append("  , B.SERVICE_CODE" );
		strBuffer.append("  , AM_GET_DESC.AM_SERVICE(B.SERVICE_CODE,'"+locale+"','2') SERVICE_SHORT_DESC" );
		strBuffer.append("  , B.SPECIALTY_CODE" );
		strBuffer.append("  , AM_GET_DESC.AM_SPECIALITY(B.SPECIALTY_CODE,'"+locale+"','2') SPECIALTY_SHORT_DESC" );
		strBuffer.append("  , SUBSERVICE_CODE" );
		strBuffer.append("  , AM_GET_DESC.AM_SUBSERVICE(B.SERVICE_CODE,B.SUBSERVICE_CODE,'"+locale+"','2') SUBSERVICE_SHORT_DESC" );
		strBuffer.append("  , A.REQ_TEAM_ID TEAM_ID" );
		strBuffer.append("  , AM_GET_DESC.AM_MEDICAL_TEAM(A.FACILITY_ID, A.REQ_TEAM_ID,'"+locale+"','2') TEAM_SHORT_DESC" );
		strBuffer.append("  , A.TFR_REQ_ACCEPTED_YN" );
		strBuffer.append("  , A.TFR_REQ_DATE_TIME" );
		strBuffer.append("  , A.TFR_REQ_REASON" );
		strBuffer.append("  , A.TFR_REQ_REF_NO" );
		strBuffer.append("  , A.TFR_REQ_STATUS" );
		strBuffer.append("  , A.TFR_REQ_STATUS TFR_REQ_STATUS_DESC" );
		strBuffer.append("  , A.TFR_REQ_TYPE" );
		strBuffer.append("  , A.TFR_REQ_TYPE TFR_REQ_TYPE_DESC" );
		strBuffer.append("  , IP_GET_DESC.IP_TRANSFER_TYPE(A.TFR_REQ_REASON,'"+locale+"','2')TRANSFER_TYPE_SHORT_DESC " );
		strBuffer.append("from" );
		strBuffer.append("  IP_TRANSFER_REQUEST A" );
		strBuffer.append("  , IP_OPEN_ENCOUNTER B" );
		strBuffer.append("  , MP_PATIENT C " );
		strBuffer.append("where A.FACILITY_ID = B.FACILITY_ID " );
		strBuffer.append("  and A.ENCOUNTER_ID = B.ENCOUNTER_ID " );
		strBuffer.append("  and A.ENCOUNTER_ID = '"+encounterid+"' " );
		strBuffer.append("  and A.FACILITY_ID = '"+facilityId+"' " );
		strBuffer.append("  and B.PATIENT_ID = C.PATIENT_ID" );

	if (fromfunction.equals("RequestDetail"))
	{
		strBuffer.append("  and A.TFR_REQ_STATUS = '1' " );
	}
	else
	{
		strBuffer.append("  and A.TFR_REQ_STATUS = '0' " );
	}

		if (rset!=null) rset.close();
		if (stmt!=null) stmt.close();
		stmt	= con.createStatement();
		rset	= stmt.executeQuery(strBuffer.toString());
		if(rset.next() && rset != null)
		{
			sysDate				 = rset.getString("system_date");
			admissiondate		= checkForNull(rset.getString("admission_date"));  
			if(!(admissiondate.equals("") || admissiondate == null))
					admissiondate_converted = DateUtils.convertDate(admissiondate,"DMYHM","en",locale); 
	
			admissiontype		= checkForNull(rset.getString("admission_short_desc"));
			frbedtype			= checkForNull(rset.getString("bed_type_code"));
			gender				= checkForNull(rset.getString("gender"));
			priority				= checkForNull(rset.getString("priority_short_desc"));
			trntypecode		= checkForNull(rset.getString("tfr_req_type"));
			trntypedesc		= checkForNull(rset.getString("transfer_type_short_desc"));  
			bookingdatetime	= checkForNull(rset.getString("booking_date_time"));
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
		}

		if (rset!=null)rset.close();
		if (stmt!=null)stmt.close();

		if(bl_operational.equals("Y"))
		{
			strBuffer.delete(0,strBuffer.length());
			strBuffer.append("select a. BLNG_GRP_ID, a.SHORT_DESC from bl_blng_grp a,  BL_EPISODE_FIN_DTLS b where a.BLNG_GRP_ID = b.BLNG_GRP_ID and b.OPERATING_FACILITY_ID ='"+facilityId+"' and b.EPISODE_ID = '"+encounterid+"'");
			rset1 = stmt1.executeQuery(strBuffer.toString());
			if (rset1 != null)
			{
				while(rset1.next())
				{
					billing_group_id = rset1.getString("BLNG_GRP_ID");
					billing_group_desc = rset1.getString("SHORT_DESC");
				}
			}
		}
		if (rset1!=null) rset1.close();




            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(admissiondate));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(admissiondate_converted));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(admissiontype));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(admissiontype));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(bookingdatetime_converted));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(bookingdatetime));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(trntypedesc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(trntypecode));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block20Bytes, _wl_block20);
if (fromfunction.equals("RequestDetail"))
{	
            _bw.write(_wl_block21Bytes, _wl_block21);
            {java.lang.String __page ="../../eIP/jsp/TransferDetails.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("call_function"), weblogic.utils.StringUtils.valueOf("confirm_details")},{ weblogic.utils.StringUtils.valueOf("admissiondate"), weblogic.utils.StringUtils.valueOf(admissiondate
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
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block1Bytes, _wl_block1);
}
else
{
            _bw.write(_wl_block21Bytes, _wl_block21);
            {java.lang.String __page ="../../eIP/jsp/TransferDetails.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("call_function"), weblogic.utils.StringUtils.valueOf("cancel_request")},{ weblogic.utils.StringUtils.valueOf("admissiondate"), weblogic.utils.StringUtils.valueOf(admissiondate
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
                        )},{ weblogic.utils.StringUtils.valueOf("frbedtype"), weblogic.utils.StringUtils.valueOf(frbedtype
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
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block1Bytes, _wl_block1);
	}	
            _bw.write(_wl_block24Bytes, _wl_block24);

	if (!fromfunction.equals("RequestDetail"))
	{
	
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

			String contact_reason="";
			String contact_reason_code="";
			try
			{
				stmt = con.createStatement();
				rset = stmt.executeQuery("select contact_reason_code, contact_reason from am_contact_reason_lang_vw where language_id='"+locale+"' and eff_status = 'E' and cancel_transfer_yn = 'Y' order by 2");
				   
				if( rset != null )
				{
				  while( rset.next() )
				  {
					 contact_reason   = rset.getString("contact_reason") ;
					 contact_reason_code   = rset.getString("contact_reason_code") ;
					
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(contact_reason_code ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(contact_reason));
            _bw.write(_wl_block30Bytes, _wl_block30);
           
				 }
			 }
			if (stmt!=null) stmt.close();
			if (rset!=null) rset.close();
		}
		catch(Exception e) 
		{
			out.println(e.toString());
		}
	
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(contact_reason_code));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(frpractitionerid));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(frpractdesc));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(frpractdesc));
            _bw.write(_wl_block38Bytes, _wl_block38);

}

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(frbedtype));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bookingrefno));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(age));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(tonursingunittype));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(tobedtype));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(allow_transfer_yn));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(billing_group_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(billing_group_desc));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(bl_operational));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block54Bytes, _wl_block54);

if(bl_interfaced_yn.equals("Y"))
{

            _bw.write(_wl_block55Bytes, _wl_block55);

}

            _bw.write(_wl_block56Bytes, _wl_block56);
if (!fromfunction.equals("Q"))
	{
		String widthValue = "width = '14%'";
		if (fromfunction.equals("RequestDetail"))
			widthValue = "width = '4%'";
		
            _bw.write(_wl_block57Bytes, _wl_block57);
if (!fromfunction.equals("RequestDetail"))
			{
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(sysDate));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(max_priority));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(default_priority));
            _bw.write(_wl_block61Bytes, _wl_block61);
}
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block63Bytes, _wl_block63);
}
}catch(Exception e)
	{
		out.print("Exception :"+e);
	}
}
catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());}
finally 
{
	try
	{
		if(rset	!= null)rset.close();
		if(rs_bl!= null)rs_bl.close();
		if(stmt1!= null)stmt1.close();
		if(rset1 != null)rset1.close();
		if(stmt != null) stmt.close();
		if(stmt_bl != null)stmt_bl.close();
		if(rset_practid != null)rset_practid.close();
	}
	catch(Exception e)
	{
		out.println("Exception in tryCatch : "+ e.toString());
	}
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block64Bytes, _wl_block64);
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CancellationDetails.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonforCancellation.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AuthorizingPractitioner.label", java.lang.String .class,"key"));
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
