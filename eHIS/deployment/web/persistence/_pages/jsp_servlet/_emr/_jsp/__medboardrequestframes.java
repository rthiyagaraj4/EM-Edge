package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __medboardrequestframes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/MedBoardRequestFrames.jsp", 1735058582884L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\n\tasync function showDateDetails()\n\t{\n\t\tvar retVal\t\t\t= new String();\n\t\tvar center\t\t\t= \"3\" ;\n\t\tvar dialogTop\t\t= \"0vh\";\n\t\tvar dialogHeight\t= \"39vh\";\n\t\tvar dialogWidth\t\t= \"40vw\";\n\t\tvar status\t\t\t= \"no\";\n\t\tvar arguments\t= \"\" ;\n\t\tvar features\t\t= \" dialogHeight:\"+dialogHeight+\"; scroll=no; dialogWidth:\"+dialogWidth+\"; center:\"+center+\"; status=no; dialogTop:\"+dialogTop;\n\n\t\tretVal =await window.showModalDialog(\"../../eMR/jsp/ChargesDetails.jsp?toShow=DateDetails&PrepareDate=\"+document.getElementById(\"prepareDate\").value+\"&applCompletionDate=\"+document.getElementById(\"applCompletionDate\").value+\"&RequestDate=\"+document.getElementById(\"RequestDate\").value+\"&ReceivedDate=\"+document.getElementById(\"ReceivedDate\").value+\"&DeliveredDate=\"+document.getElementById(\"DeliveredDate\").value,arguments,features);\n\t\t/*\n\t\t for icn:6879\n\t\tdocument.forms[0].RequestDate.value insted of this\n\t\tdocument.getElementById(\"RequestDate\").value\n\t\ti have modified insted of forms[0] to all\n\t\t*/\n\t}\n\n\tasync function showChargeDetails()\n\t{\n\t\tvar retVal\t\t\t= new String();\n\t\tvar center\t\t\t= \"3\" ;\n\t\tvar dialogTop\t\t= \"0vh\";\n\t\tvar dialogHeight\t= \"39vh\";\n\t\tvar dialogWidth\t\t= \"40vw\";\n\t\tvar status\t\t\t= \"no\";\n\t\tvar arguments\t= \"\" ;\n\t\tvar features\t\t= \" dialogHeight:\"+dialogHeight+\"; scroll=no; dialogWidth:\"+dialogWidth+\"; center:\"+center+\"; status=no; dialogTop:\"+dialogTop;\n\n\t\tretVal =await window.showModalDialog(\"../../eMR/jsp/ChargesDetails.jsp?toShow=ChargeDetails&charges_appl_yn=\"+document.getElementById(\"hdd_charges_appl_yn\").value+\"&addl_charges_yn=\"+document.getElementById(\"hdd_addl_charges_yn\").value+\"&receipt_no=\"+document.getElementById(\"hdd_receipt_no\").value+\"&addl_receipt_no=\"+document.getElementById(\"hdd_addl_receipt_no\").value+\"&amount=\"+document.getElementById(\"hdd_amount\").value+\"&addl_amount=\"+document.getElementById(\"hdd_addl_amount\").value+\"&receipt_date=\"+document.getElementById(\"hdd_receipt_date\").value+\"&addl_receipt_date=\"+document.getElementById(\"hdd_addl_receipt_date\").value,arguments,features);\n\t\t/*\n\t\t icn:6879\n\t\tdocument.forms[0].hdd_addl_charges_yn.value insted of this\n\t\tdocument.getElementById(\"hdd_addl_charges_yn\").value\n\t\t*/\n\t}\n\t</script>\n</head>\n \n<body onKeyDown=\'lockKey()\'>\n<form name=\'MedBoardReqDetails\' id=\'MedBoardReqDetails\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<table border=0 cellspacing=0 cellpadding=3 width=\'100%\' style=\'margin-top: -45px\' >\t\n\t\t<!--<tr>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<td class=\'PATIENTLINECOLOROTHLANG\'  >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =",";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t<td class=\'PATIENTLINECOLOROTHLANG\'  >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<td class=\'PATIENTLINECOLOROTHLANG\' >&nbsp;</td>\n\t\t\t<td class=\'PATIENTLINECOLOROTHLANG\' >&nbsp;</td>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t</tr>-->\n\t\t<tr>\n\t\t\t<td>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<table border=0 cellspacing=0 cellpadding=3 width=\'100%\'>\n\t\t\t\t<tr align=\"left\">\n\t\t\t\t\t<th class=\"columnheader\" colspan=\'4\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'DEFAULTBLANKROW2PT\' colspan=4 height=5>&nbsp;</td></tr> \n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'  width=\'25%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t\t<td class=\'querydata\'  width=\'20%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t\t<td class=\'label\'  width=\'30%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t\t<td class=\'querydata\'  width=\'25%\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t\t<td class=\'querydata\'  >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t\t<td class=\'label\'  >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\'   >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t\t\t<td class=\'label\'  >&nbsp;</td>\n\t\t\t\t\t<td class=\"fields\"><input type=\"button\" name=\"Dates\" id=\"Dates\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" class=\'button\' onclick=\"showDateDetails();\" ><input type=\"button\" name=\"Charges\" id=\"Charges\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" class=\'button\' onclick=\"showChargeDetails();\" ></td>\n\t\t\t\t</tr> \n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'DEFAULTBLANKROW2PT\' colspan=4 height=5>&nbsp;</td></tr> \n\t\t\t\t<tr>\n\t\t\t</table>\n\t\t</tr>\n\t</table>\n<input type=\"hidden\" name=\"prepareDate\" id=\"prepareDate\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" >\n<input type=\"hidden\" name=\"applCompletionDate\" id=\"applCompletionDate\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" >\n<input type=\"hidden\" name=\"RequestDate\" id=\"RequestDate\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" >\n<input type=\"hidden\" name=\"ReceivedDate\" id=\"ReceivedDate\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" >\n<input type=\"hidden\" name=\"DeliveredDate\" id=\"DeliveredDate\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" >\n\n<input type=\"hidden\" name=\"hdd_charges_appl_yn\" id=\"hdd_charges_appl_yn\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" >\n<input type=\"hidden\" name=\"hdd_addl_charges_yn\" id=\"hdd_addl_charges_yn\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" >\n<input type=\"hidden\" name=\"hdd_receipt_no\" id=\"hdd_receipt_no\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" >\n<input type=\"hidden\" name=\"hdd_addl_receipt_no\" id=\"hdd_addl_receipt_no\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" >\n<input type=\"hidden\" name=\"hdd_amount\" id=\"hdd_amount\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" >\n<input type=\"hidden\" name=\"hdd_addl_amount\" id=\"hdd_addl_amount\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" >\n<input type=\"hidden\" name=\"hdd_receipt_date\" id=\"hdd_receipt_date\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" >\n<input type=\"hidden\" name=\"hdd_addl_receipt_date\" id=\"hdd_addl_receipt_date\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" >\n\n\n</body>\n</form>\n\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n</html>\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\n\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	String locale = (String) session.getValue("LOCALE");
	StringBuffer sql = new StringBuffer();
	String request_id = "";
	String patient_id = "";
	String request_date = "";
	String med_board_type = "";
	String requesting_pract_name = "";
	String report_type_code = "";
	String patient_name = "";
	String gender = "";
	String age = "";

	String reqDate				= "";
	String appl_completion_date	= "";
	String RecdDate				= "";
	String prepareDate			= "";
	String delivered_date		= "";
	String amount				= "";
	String receipt_no			= "";
	String receipt_date			= "";
	String addl_amount			= "";
	String addl_receipt_no		= "";
	String addl_receipt_date	= "";
	String charges_appl_yn		= "";
	String addl_charges_yn		= "";

	request_id = request.getParameter("request_id")==null?"":request.getParameter("request_id");
	patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");

	try
	{
		con = ConnectionManager.getConnection(request);
		sql.append(" select a.patient_id, to_char(a.request_date,'dd/mm/yyyy hh24:mi') request_date, (select short_desc from mr_medical_board_type where med_board_type_code = a.med_board_type_code) short_desc, a.requesting_pract_name, a.report_type_code, decode('"+locale+"','en',a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name))patient_name, a.gender, calculate_age(to_char(date_of_birth,'dd/mm/yyyy'),1)age, addl_amount, addl_charges_yn, to_char(addl_receipt_date,'dd/mm/yyyy hh24:mi') addl_receipt_date, addl_receipt_no, to_char(appl_completion_date,'dd/mm/yyyy hh24:mi') appl_completion_date, amount, to_char(receipt_date,'dd/mm/yyyy hh24:mi') receipt_date, receipt_no, charges_appl_yn,  to_char(received_date,'dd/mm/yyyy hh24:mi')received_date, to_char(prepared_date,'dd/mm/yyyy hh24:mi') prepared_date, to_char(delivered_date,'dd/mm/yyyy hh24:mi') delivered_date from MR_REPORT_REQUEST_HDR_VW a where a.request_id = ? ");
		stmt = con.prepareStatement(sql.toString());
		stmt.setString(1,request_id);
		rs=stmt.executeQuery();

		while(rs.next())
		{
			patient_id				= checkForNull(rs.getString("patient_id"));

			request_date			= checkForNull(rs.getString("request_date"));
			if(!(request_date==null || request_date.equals("")))
					request_date	= DateUtils.convertDate(request_date,"DMYHM","en",locale);

			med_board_type			= checkForNull(rs.getString("SHORT_DESC"));
			requesting_pract_name	= checkForNull(rs.getString("requesting_pract_name"));
			report_type_code		= checkForNull(rs.getString("report_type_code"));
			patient_name			= checkForNull(rs.getString("patient_name"));
			gender					= checkForNull(rs.getString("gender"));
			age						= checkForNull(rs.getString("age"));
			amount					= checkForNull(rs.getString("AMOUNT"));
			receipt_no				= checkForNull(rs.getString("RECEIPT_NO"));
			receipt_date			= checkForNull(rs.getString("RECEIPT_DATE"));
			addl_amount				= checkForNull(rs.getString("ADDL_AMOUNT"));
			addl_receipt_no			= checkForNull(rs.getString("ADDL_RECEIPT_NO"));
			addl_receipt_date		= checkForNull(rs.getString("ADDL_RECEIPT_DATE"));
			charges_appl_yn			= checkForNull(rs.getString("CHARGES_APPL_YN"));
			addl_charges_yn			= checkForNull(rs.getString("ADDL_CHARGES_YN"));
			reqDate					= checkForNull(rs.getString("REQUEST_DATE"));
			appl_completion_date	= checkForNull(rs.getString("APPL_COMPLETION_DATE"));
			RecdDate				= checkForNull(rs.getString("RECEIVED_DATE")); 
			prepareDate				= checkForNull(rs.getString("PREPARED_DATE"));
			delivered_date			= checkForNull(rs.getString("DELIVERED_DATE"));
		}
	
	if(rs!=null)  rs.close();
	if(stmt!=null)   stmt.close();
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(age));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            _bw.write(_wl_block13Bytes, _wl_block13);
            _bw.write(_wl_block14Bytes, _wl_block14);
            {java.lang.String __page ="../../eCommon/jsp/pline.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("Patient_ID"), weblogic.utils.StringUtils.valueOf(patient_id
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(request_id));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(request_date));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(report_type_code));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(requesting_pract_name));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(med_board_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DateDetails.label","mr_labels")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.ChargesDetails.label","mr_labels")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(prepareDate));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(appl_completion_date));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(reqDate));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(RecdDate));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(delivered_date));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(charges_appl_yn));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(addl_charges_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(receipt_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(addl_receipt_no));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(amount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(addl_amount));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(receipt_date));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(addl_receipt_date));
            _bw.write(_wl_block39Bytes, _wl_block39);

	}
	catch(Exception e)
	{
			//out.println("Exception @ MedBoardRequestFrames "+e.toString());
			e.printStackTrace();
	}
	finally
	{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}


            _bw.write(_wl_block40Bytes, _wl_block40);
            _bw.write(_wl_block41Bytes, _wl_block41);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RequestDetails.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.registrationno.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RegistrationDate.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reporttype.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RequestedPractitioner.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.TypeofMedicalBoard.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
