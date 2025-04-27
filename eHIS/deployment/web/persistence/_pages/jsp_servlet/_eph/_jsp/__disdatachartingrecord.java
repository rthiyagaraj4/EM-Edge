package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.io.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __disdatachartingrecord extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DisDataChartingRecord.jsp", 1709120685173L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<script src=\'../../ePH/js/DisDataCharting.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</head>\n\n<body class=\'CONTENT\' OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' onKeyPress=\'\' >\n<!-- <form name=\'DisDataCharting_form\' id=\'DisDataCharting_form\' action=\'../../servlet/eCA.DisDataChartingServlet\' method=\'post\' target=\'messageframe\'>  -->\n<form name=\'DisDataCharting_form\' id=\'DisDataCharting_form\' action=\'../../ePH/jsp/DisDataChartingSubmit.jsp\' method=\'post\' target=\'messageFrame\'> \n\t<table  id=\'detailTab\' width=\"100%\" cellspacing=\'0\' cellpadding=\'3\' border=0 align=\'center\'>\n\n\t\t<tr>\n\t\t\t<td class=\'columnheadercenter\'  width=\'10%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t<td class=\'columnheadercenter\'  colspan=\"2\" width=\'20%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t</tr>\n    ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<tr>\n\t\t\t<td width=\"50%\" id=\"short_desc_";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t<td width=\"50%\" >\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<Select name=\'str_id_";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' id=\'str_id_";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' onChange=\"javascript:chkNormalAbnormal(this,\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\')\" >\n\t\t\t\t\t  <option value=\'\'>&nbsp; -----Select------&nbsp;</option>\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t</Select>\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&nbsp;";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t</td>\n\t\t\t\t\n<td nowrap id=\'abcd\'>\n\t\t\t<input type=\"hidden\" name=\"item_id_";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" id=\"item_id_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" >\n\t\t\t<input type=\"hidden\" name=\"uom_id_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" id=\"uom_id_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" >\n\t\t\t<input type=\"hidden\" name=\"normal_low_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" id=\"normal_low_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" >\n\t\t\t<input type=\"hidden\" name=\"normal_high_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" id=\"normal_high_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" >\n\t\t\t<input type=\"hidden\" name=\"num_digits_dec_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" id=\"num_digits_dec_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" >\t\n\t\t\t<input type=\"hidden\" name=\"op_type_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" id=\"op_type_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" >\n\t\t\t<input type=\"hidden\" name=\"result_type_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" id=\"result_type_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" >\n\t\t\t<input type=\"hidden\" name=\"num_crit_low_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" id=\"num_crit_low_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" >\t\t\t\t\t\n\t\t\t<input type=\"hidden\" name=\"num_crit_high_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" id=\"num_crit_high_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" >\t\n\t\t\t<input type=\"hidden\" name=\"accession_num_";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" id=\"accession_num_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" >\n\t\t\t<input type=\"hidden\" name=\"def_data_";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" id=\"def_data_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' >\t\n\t\t\t<input type=\"hidden\" name=\"norm_abnorm_ind_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" id=\"norm_abnorm_ind_";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' >\t\t\n\t\t\t<input type=\"hidden\" name=\"mandatory_yn_";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" id=\"mandatory_yn_";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' >\t\t\t\n\t\t\t</td></tr>\n\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\n        \n        </table>\n        <input type=\"hidden\" name=\"no_of_rec\" id=\"no_of_rec\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" >\n        <input type=\"hidden\" name=\"last_record_date\" id=\"last_record_date\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" >\n\t\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" >\n\t\t<input type=\"hidden\" name=\"episode_id\" id=\"episode_id\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" >\n\t\t<input type=\"hidden\" name=\"episode_type\" id=\"episode_type\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" >\n\t\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" >\n\t\t<input type=\"hidden\" name=\"visit_id\" id=\"visit_id\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" >\n\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" >\n\t\t<input type=\"hidden\" name=\"clinician_id\" id=\"clinician_id\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" >\n\t\t<input type=\"hidden\" name=\"adm_dt_time\" id=\"adm_dt_time\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" >\n\t\t<input type=\"hidden\" name=\"locn_code\" id=\"locn_code\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" >\n\t\t<input type=\"hidden\" name=\"low_str\" id=\"low_str\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" >\n\t\t<input type=\"hidden\" name=\"high_str\" id=\"high_str\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" >\n\t\t<input type=\"hidden\" name=\"abn_str\" id=\"abn_str\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" >\n\t\t<input type=\"hidden\" name=\"crit_low_str\" id=\"crit_low_str\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" >\n\t\t<input type=\"hidden\" name=\"crit_high_str\" id=\"crit_high_str\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" >\n\t\t<input type=\"hidden\" name=\"crit_abn_str\" id=\"crit_abn_str\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" >\n\t\t<input type=\"hidden\" name=\"battery_id\" id=\"battery_id\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" >\t\n\t\t<input type=\"hidden\" name=\"sys_date_time\" id=\"sys_date_time\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" >\n\t\t<input type=\"hidden\" name=\"in_error\" id=\"in_error\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" >\n\t\t<input type=\"hidden\" name=\"in_replace\" id=\"in_replace\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" >\n\t\t<input type=\"hidden\" name=\"module_id\" id=\"module_id\" value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' >\n\t\t<input type=\"hidden\" name=\"location_type\" id=\"location_type\" value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' >\n\t\t<input type=\"hidden\" name=\"replaceError_count\" id=\"replaceError_count\" value=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\' >\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 endss
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

    Connection con = null;
    try {
			con = ConnectionManager.getConnection(request);
			PreparedStatement stmt  = null;
			PreparedStatement stmt1 = null;
		    ResultSet rset=null ;
			ResultSet rset1=null ;
			//java.util.Properties jdbc_props = (java.util.Properties) session.getValue("jdbc");
			//commented on 10 October 2005 - when called from OP clinician Id was being passed as null so taking practitioner_id from the session.
			//String clinicianid		=	(String)jdbc_props.getProperty("clinician_id");
			String clinicianid		=	(String) session.getAttribute("ca_practitioner_id") == null ? "" : (String) session.getAttribute("ca_practitioner_id");
			//out.println("clinicianid = "+clinicianid);
		    String facilityId = (String) session.getValue( "facility_id" ) ;
			String accession_num = request.getParameter("accession_num")==null?"":request.getParameter("accession_num");
			String episodeid = request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
			String episodetype = request.getParameter("episode_type")==null?"I":request.getParameter("episode_type");
			String patient_class=request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
			String visitid = request.getParameter("visit_id")==null?"":request.getParameter("visit_id");
			if(visitid.equals("") && episodetype.equals("I")) visitid = "1";
			String batteryid = request.getParameter("battery_id")==null?"":request.getParameter("battery_id");
			//out.println("batteryid = "+batteryid);
			String patientid = request.getParameter("patient_id");
			String admdttime = request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date");
			String locncode = request.getParameter("location_code")==null?"": request.getParameter("location_code");

			String patsex = request.getParameter("Sex")==null?"": request.getParameter("Sex");
//ss
			String amerepMode=request.getParameter("amerepMode")==null?"N":request.getParameter("amerepMode");
//se
			if(patsex.equals("Male")) patsex="M";
			else if(patsex.equals("Female")) patsex="F";
			else patsex="U";

			String mode = request.getParameter("mode")==null?"": request.getParameter("mode");
			String dob = request.getParameter("Dob")==null?"": request.getParameter("Dob");
		    String lastrecorddate = request.getParameter("last_record_date")==null?"":request.getParameter("last_record_date");
			String amendMode = request.getParameter("amendMode")==null?"":request.getParameter("amendMode");
			String replaceMode = request.getParameter("replaceMode")==null?"":request.getParameter("replaceMode");
			String newlastrecorddate = request.getParameter("new_last_record_date")==null?"":request.getParameter("new_last_record_date");
			String module_id = request.getParameter("module_id")==null?"": request.getParameter("module_id");
			String location_type = request.getParameter("location_type")==null?"": request.getParameter("location_type");
		    
			String readOnly="";
			String listDisabled="";
			String disabled="";
			String errorRemarks="";
			String longTextVal = "";
			
			if(amendMode.equals("Y")){
					lastrecorddate=newlastrecorddate;
					readOnly = "readOnly";
					listDisabled = "disabled";
			}

		if(replaceMode.equals("Y")){
				lastrecorddate=newlastrecorddate;
				readOnly = "readOnly";
				listDisabled = "disabled";
		}
/************************/

		String accessionnum = "" ;                  
		String discrmsrid = "" ;                   
		String discrmsrresulttype = "" ;          

		int numdigitsdec = 0;

		String defnum =  "" ;
		String defstr =  "" ;
		String defdata =  "" ;
		//String defaultdata =  "" ;
		Clob defaultdata = null;
		String chkType =  "" ;
		String shortdesc = "";

		String	normabnormind = "";
		String refrangetype = "";
		String range = "";
		String optype = "";

		String mandatoryyn = "";
		String sysdatetime = "";

		int maxsize = 8;
		int i=0;
		String dat="";

		String sel="";

		int count=0;
		/* String highstr = "";
		String lowstr = "";
		String abnstr = "";
		String crithighstr = "";
		String critlowstr = "";
		String critabnstr = ""; */

		String highstr = "";
		String lowstr = "";
		String abnstr = "";
		String critstr = "";
		String crithighstr = "";
		String critlowstr = "";
	  
		String highstr_desc = "";
		String lowstr_desc = "";
		String abnstr_desc = "";
		String critstr_desc = "";
		String crithighstr_desc = "";
		String critlowstr_desc = "";

		String critabnstr = "";
		
		int numdigitsmax =0;
		int numdigitsmin = 0;
		String numuom = "";
		int numreflow = 0;
		int numrefhigh = 0;
		int numcritlow = 0;
		int numcrithigh = 0;


            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

    try {
		// check with Rajan what is the use of this query -- suresh
	StringBuffer sql=new StringBuffer();
	if(sql.length() > 0) sql.delete(0,sql.length());
	sql.append(" select HIGH_STR,LOW_STR,ABN_STR,CRIT_STR,CRIT_HIGH_STR,CRIT_LOW_STR,HIGH_STR_DESC,LOW_STR_DESC,ABN_STR_DESC,CRIT_HIGH_STR_DESC ");
	sql.append(" ,CRIT_LOW_STR_DESC,CRIT_STR_DESC from cr_clin_event_param ");
			//added on 6th Feb 2003
			stmt = con.prepareStatement(sql.toString());
			rset=stmt.executeQuery();
			if(rset!=null && rset.next())
			{
					highstr = rset.getString("HIGH_STR")==null?"":rset.getString("HIGH_STR");
					lowstr = rset.getString("LOW_STR")==null?"":rset.getString("LOW_STR");
					abnstr = rset.getString("ABN_STR")==null?"":rset.getString("ABN_STR");
					critstr = rset.getString("CRIT_STR")==null?"":rset.getString("CRIT_STR");
					crithighstr = rset.getString("CRIT_HIGH_STR")==null?"":rset.getString("CRIT_HIGH_STR");
					critlowstr = rset.getString("CRIT_LOW_STR")==null?"":rset.getString("CRIT_LOW_STR");
					highstr_desc = rset.getString("HIGH_STR_DESC")==null?"":rset.getString("HIGH_STR_DESC");
					lowstr_desc = rset.getString("LOW_STR_DESC")==null?"":rset.getString("LOW_STR_DESC");
					abnstr_desc = rset.getString("ABN_STR_DESC")==null?"":rset.getString("ABN_STR_DESC");
					crithighstr_desc = rset.getString("CRIT_HIGH_STR_DESC")==null?"":rset.getString("CRIT_HIGH_STR_DESC");
					critlowstr_desc = rset.getString("CRIT_LOW_STR_DESC")==null?"":rset.getString("CRIT_LOW_STR_DESC");
					critstr_desc = rset.getString("CRIT_STR_DESC")==null?"":rset.getString("CRIT_STR_DESC");
			}
			if(rset!=null)rset.close();
			if(stmt!=null)stmt.close();
	//out.println("<script>alert('"+mode+"');</script>");
	//out.println("<script>alert('"+batteryid+"');</script>");
	//out.println("<script>alert('"+mode+"');</script>");
	//out.println("<script>alert('"+mode+"');</script>");
   if(mode.equals("U"))
   {
		if(sql.length() > 0) sql.delete(0,sql.length());
		sql.append(" SELECT  a.discr_msr_id ");
		sql.append(" ,a.short_desc ");
		sql.append(" ,a.unit_of_measure ");
		sql.append(" ,a.result_type ");
		sql.append(" ,a.num_digits_max ");
		sql.append(" ,a.num_digits_min ");
		sql.append(" ,a.num_digits_dec ");
		sql.append(" ,a.mandatory_yn ");
		sql.append(" ,decode(nvl(b.discr_msr_id,'Y'),'Y','I','U') operation_type ");
		sql.append(" ,b.DISCR_MSR_RESULT_NUM default_num ");          
		sql.append(" ,b.DISCR_MSR_RESULT_STR  default_str ");          
		sql.append(" ,b.DISCR_MSR_RESULT_DATA default_data ");   
		sql.append(" ,b.NORM_ABNORM_IND ");
		sql.append(" ,b.ERROR_REMARKS error_remarks ");
		sql.append(" ,ACCESSION_NUM,REF_RANGE_TYPE,to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') sysdatetime ");
		sql.append(" FROM am_discr_msr_battery_view a,ca_encntr_discr_msr b ");
		sql.append(" WHERE a.DISCR_MSR_BATTERY_ID	= ?  ");
		sql.append(" and ? = b.facility_id(+)  ");
		sql.append(" and a.discr_msr_id = b.discr_msr_id(+) ");
		sql.append(" and b.encounter_id = ? ");
		sql.append(" and b.TEST_OBSERV_DT_TM= to_date(?,'dd/mm/yyyy hh24:mi:ss') ");
		sql.append(" order by  a.ORDER_SRL_NO ");
	
		stmt = con.prepareStatement(sql.toString());
		
		stmt.clearParameters();
		stmt.setString(1,batteryid);
		stmt.setString(2,facilityId);
		stmt.setString(3,episodeid);
		stmt.setString(4,lastrecorddate);

	}
	else if(mode.equals("I"))
	{
		
		
		if(sql.length() > 0) sql.delete(0,sql.length());
		sql.append(" SELECT  discr_msr_id ");
		sql.append(" , short_desc ");
		sql.append(" ,unit_of_measure ");
		sql.append(" ,result_type ");
		sql.append(" ,num_digits_max ");
		sql.append(" ,num_digits_min ");
		sql.append(" ,num_digits_dec ");
		sql.append(" ,mandatory_yn ");
		sql.append(" ,'I' operation_type ");
		sql.append(" ,null default_num ");          
		sql.append(" ,null  default_str ");          
		sql.append(" ,null default_data ");    
		sql.append(" ,NULL NORM_ABNORM_IND ");
		sql.append(" ,null error_remarks ");
		sql.append(" ,null ACCESSION_NUM ");
		sql.append(" , REF_RANGE_TYPE,to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') sysdatetime ");
		sql.append(" FROM am_discr_msr_battery_view  ");
		sql.append(" where DISCR_MSR_BATTERY_ID = ? order by ORDER_SRL_NO ");

		//if(stmt!=null) stmt.close();
		stmt = con.prepareStatement(sql.toString());
		stmt.clearParameters();
		stmt.setString(1,batteryid);
	}
	/*
	out.println(sql.toString());
	out.println("batteryid-->"+batteryid);
	out.println("facilityId-->"+facilityId);
	out.println("episodeid-->"+episodeid);
	*/
	rset=stmt.executeQuery();

		while (rset.next())
		{
			
			i++;
			//out.println("count = "+i);
			errorRemarks= rset.getString("error_remarks")==null?"�":rset.getString("error_remarks"); 
			//char 146
			sysdatetime = rset.getString("sysdatetime");
			discrmsrid = rset.getString("discr_msr_id");
			//out.println("discr_msr_id ="+discrmsrid);
			shortdesc = rset.getString("short_desc");
			//out.println("shortdesc ="+shortdesc);
			discrmsrresulttype = rset.getString("result_type");
			//out.println("<script>alert('discrmsrresulttype ="+discrmsrresulttype+"');</script>");
			optype = rset.getString("operation_type");
			defnum = rset.getString("default_num")==null?"":rset.getString("default_num");
			//out.println("defnum ="+defnum);
			defstr = rset.getString("default_str")==null?"":rset.getString("default_str");
			//defaultdata = rset.getString("default_data");
			if(mode.equals("U"))
			{
				defaultdata = rset.getClob(12);
				if(defaultdata != null)
				{
					BufferedReader rd = new BufferedReader(defaultdata.getCharacterStream());
					/*for(int i=0;i<(((CLOB)defaultdata).length);i++)
					{
						longTextVal.append(rd.readLine());
					}*/
					char[] longTextContent = new char[(int)defaultdata.length()];
					rd.read(longTextContent,0,(int)defaultdata.length());
					longTextVal = new String(longTextContent);
					rd.close();
				}
			}
			//out.println("longTextVal ="+longTextVal);
			//out.println("defstr --"+defstr+"--");
			//out.println("defaultdata --"+defaultdata+"--");
			mandatoryyn = rset.getString("mandatory_yn")==null?"N":rset.getString("mandatory_yn");
			refrangetype = rset.getString("ref_range_type")==null?"":rset.getString("ref_range_type");
			normabnormind = rset.getString("NORM_ABNORM_IND")==null?"":rset.getString("NORM_ABNORM_IND");

			if(normabnormind.equals(highstr))
				normabnormind = highstr_desc;
			else if(normabnormind.equals(lowstr))
				normabnormind = lowstr_desc;
			else if(normabnormind.equals(abnstr))
				normabnormind = abnstr_desc;
			else if(normabnormind.equals(critstr))
				normabnormind = critstr_desc; 
			else if(normabnormind.equals(crithighstr))
				normabnormind = crithighstr_desc;
			else if(normabnormind.equals(critlowstr))
				normabnormind = critlowstr_desc; 

			numdigitsmax = rset.getInt("num_digits_max");
			numdigitsmin = rset.getInt("num_digits_min");
			numdigitsdec = rset.getInt("num_digits_dec");
			maxsize = numdigitsmax;
			accessionnum = rset.getString("ACCESSION_NUM")==null?"":rset.getString("ACCESSION_NUM");
			numuom = "";
			numreflow = 0;    
			numrefhigh = 0;   
			numcritlow = 0;   
			numcrithigh = 0;  
			
			range = "";
			
			StringBuffer valsql = new StringBuffer();
			
			valsql.append(" select num_uom, num_ref_low,num_ref_high,num_crit_low,num_crit_high ");
			valsql.append(" ,ref_range_seq from am_discr_msr_ref_rng_num ");
			valsql.append(" WHERE discr_msr_id= ? ");
			
			//out.println("refrangetype"+refrangetype);
			if(refrangetype.equals("M"))
			{
				valsql.append( " and patient_sex = ? ");
				valsql.append(" and ( to_date( ?,'dd/mm/yyyy') <= ");				
				valsql.append("decode(START_AGE_UNITS,'D',trunc(sysdate)-START_AGE,'M',add_months(trunc(sysdate),-1*START_AGE),'Y',add_months(trunc(sysdate),-12*START_AGE))) ");
				valsql.append(" and ( to_date( ?,'dd/mm/yyyy') >= ");
				valsql.append("decode(END_AGE_UNITS,'D',trunc(sysdate)-END_AGE,'M',add_months(trunc(sysdate),-1*END_AGE),'Y',add_months(trunc(sysdate),-12*END_AGE)) )");
			}
			
			stmt1 = con.prepareStatement(valsql.toString());
			
			stmt1.clearParameters();
			stmt1.setString(1,discrmsrid);
			
			if(refrangetype.equals("M"))
			{
				stmt1.setString(2,patsex);
				stmt1.setString(3,dob);
				stmt1.setString(4,dob);
			}

			rset1=stmt1.executeQuery();

			if(rset1.next()){
					numuom = rset1.getString("num_uom")==null?"":rset1.getString("num_uom");
					numreflow = rset1.getInt("num_ref_low");
					numrefhigh = rset1.getInt("num_ref_high");
					numcritlow = rset1.getInt("num_crit_low");
					numcrithigh = rset1.getInt("num_crit_high");
					
			}
			if(rset1 != null)rset1.close();
			if(stmt1 != null)stmt1.close();

			if(numreflow != 0 || numrefhigh !=0)
				range = numreflow+" - "+numrefhigh;

			if (!errorRemarks.equals("�")){
					readOnly = "readOnly";
					listDisabled = "disabled";
			}
			//out.println("sql.toString() = "+sql.toString());
		
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(i));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(shortdesc));
            _bw.write(_wl_block13Bytes, _wl_block13);

					if(discrmsrresulttype.equals("L"))
					{
					  int k = i;
			
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);


							stmt1 = con.prepareStatement(" select ref_rng_desc,NORM_ABNORM_IND,DFLT_YN from am_discr_msr_ref_rng_list where  discr_msr_id= ?");
							stmt1.clearParameters();
							stmt1.setString(1,discrmsrid);
							rset1=stmt1.executeQuery();
							if(rset1!=null)
							{
							   while(rset1.next())
							   {
									dat=rset1.getString("ref_rng_desc").trim();
									String normal=rset1.getString("NORM_ABNORM_IND")==null?"N":rset1.getString("NORM_ABNORM_IND");
									String dfltyn = rset1.getString("DFLT_YN")==null?"N":rset1.getString("DFLT_YN");
									if(dfltyn.equals("Y"))
										sel="selected";
									if(dat.equals(defstr))
								   {
										if(normal.equals("A")) normabnormind = abnstr_desc;
										else if(normal.equals("C")) normabnormind = critstr_desc;
										sel="selected";
								   }
								   else
										sel="";
									out.println("<option class='"+normal+"' value='"+dat+"' "+sel+" >"+dat+"</option>");
									k++;
							   }
							}
							if(rset1 != null)rset1.close();
						    if(stmt1 != null)stmt1.close();
			
            _bw.write(_wl_block18Bytes, _wl_block18);

				}
				else if(discrmsrresulttype.equals("C"))
				{
					String chk = "";
					if(defstr.equals("Y"))
						chk = "checked";
					out.println("<input type='checkbox' name='str_id_"+i+"' id='str_id_"+i+"' value='Y' "+chk+">");
				}
				else if(discrmsrresulttype.equals("F"))
				{
					String display = "";
					if(defdata.indexOf("<html>")==-1)
						display = defdata;
					out.println("<textarea name='str_id_"+i+"' rows='3' cols='71'>"+longTextVal+"</textarea>");
					//out.println("<textarea name='str_id_"+i+"' rows='3' cols='71'>"+display+"</textarea>");
					//out.println("<img src='../../eCA/images/Xdetail.gif' onClick=\"addDetailText('"+i+"')\" ></img>");
				}
				else if(discrmsrresulttype.equals("N"))
				{
					if (numdigitsmax==0) { numdigitsmax=22; maxsize=22;}
					out.println("<input type='text' name='str_id_"+i+"' id='str_id_"+i+"' size='"+maxsize+"' maxlength='"+maxsize+"' value='"+defnum+"'  OnKeyPress =\"return allowValidNumber(this,event,'"+numdigitsmax+"','"+numdigitsdec+"')\" onBlur=\"  validateNumber(this,'"+numreflow+"','"+numrefhigh+"','"+i+"','"+numdigitsdec+"','"+numcritlow+"','"+numcrithigh+"','"+numdigitsmin+"','"+module_id+"','"+shortdesc+"')\" >");
				}
				else if(discrmsrresulttype.equals("I"))
				{
					//maxsize = numdigitsmax;
					if(numdigitsmax == 0) maxsize = 3;
					//out.println("maxsize="+maxsize);
					out.println("<input type='text' name='str_id_"+i+"' id='str_id_"+i+"' size='"+maxsize+"' maxlength='"+maxsize+"' value='"+defnum+"'  OnKeyPress =\"return allowValidNumber(this,event,'"+numdigitsmax+"',0)\" onBlur=\"  validateNumber(this,'"+numreflow+"','"+numrefhigh+"','"+i+"','"+numdigitsdec+"','"+numcritlow+"','"+numcrithigh+"','"+numdigitsmin+"','"+module_id+"','"+shortdesc+"')\" >"); 
				}
				else if(discrmsrresulttype.equals("H"))
				{
					//out.println("maxsize = "+maxsize);
					out.println("<input type='text' name='str_id_"+i+"' id='str_id_"+i+"' size='60' maxlength='4000' value = '"+defstr+"' >");
				}
				
				else
				{
					 if(discrmsrresulttype.equals("E"))
					{
						maxsize = 16;
						chkType = "return CheckForSpecCharsForDateTime(event)";
					}
					 else if(discrmsrresulttype.equals("D"))
					{
						 maxsize = 10;
						 chkType = "return CheckForSpecCharsForDate(event)";
					}
					 else if(discrmsrresulttype.equals("T"))
					{
						 maxsize =5;
						 chkType = "return CheckForSpecChars(event)";
					}
					out.println("<input type='text' name='str_id_"+i+"' id='str_id_"+i+"' size='"+maxsize+"' maxlength='"+maxsize+"' value='"+defstr+"' OnKeyPress =\""+chkType+"\" onblur= \" return validateDateTime(this,'"+discrmsrresulttype+"'); \"  >");
				}

				if(mandatoryyn.equals("Y") && !discrmsrresulttype.equals("C"))
					out.println("<img align=center src='../../eCommon/images/mandatory.gif'></img>");
			
            _bw.write(_wl_block19Bytes, _wl_block19);
if(!discrmsrresulttype.equals("F")){
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(numuom));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(range));
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(discrmsrid));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(numuom));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(numreflow));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(numrefhigh));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(numdigitsdec));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(optype));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(discrmsrresulttype));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(numcritlow));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(numcrithigh));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(accessionnum));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(defdata));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(normabnormind));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(mandatoryyn));
            _bw.write(_wl_block50Bytes, _wl_block50);

		//	i++;
		}
			//out.println("sql.toString() = "+sql.toString());
		 
            if(rset!=null) rset.close();
			 if(stmt!=null) stmt.close();
			 if(rset1!=null) rset1.close();
			 if(stmt1!=null) stmt1.close();
			// while (rset.next());
			//end while

			if(!(batteryid.equals("")) && i == 0)
			{
				out.println("<script>alert(getMessage('NO_DISCR_MSR','CA'))</script>");
				out.println("<script>window.close();</script>");
			}
			else if(batteryid.equals(""))
			{
				out.println("<script>alert(getMessage('NO_BATTERY','CA'))</script>");
				out.println("<script>window.close();</script>");
			}
        }catch(Exception e){
                out.println("Inqq   "+e.toString());
				e.printStackTrace(System.err);
        }
        
        
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(lastrecorddate));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(episodeid));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(episodetype));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(visitid));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(clinicianid));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(admdttime));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(locncode));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(lowstr_desc));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(highstr_desc));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(abnstr_desc));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(critlowstr_desc));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(crithighstr_desc));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(critabnstr));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(batteryid));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(sysdatetime));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(amendMode));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(replaceMode));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(count));
            _bw.write(_wl_block75Bytes, _wl_block75);

	} catch ( Exception e) {
			out.println("Out "+e);
	}finally {
		if(con!=null) ConnectionManager.returnConnection(con,request);
	 }

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Variable.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Value.label", java.lang.String .class,"key"));
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
}
