package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.sql.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.op.CurrencyFormat;
import blopin.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;

public final class __changeadmissionvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/ChangeAdmissionValidation.jsp", 1719206048572L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eip/jsp/validateBed.jsp", 1709117946401L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n</head>\n\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<body class=\"MESSAGE\" onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<script src=\'../../eCommon/js/common.js\' language=\'Javascript\'></script>\n\t<script src=\'../../eIP/js/ReviseAdmission.js\' language=\'Javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'Javascript\'></script>\n\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n</head>\n<body CLASS=\"MESSAGE\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\"Change_AdmissionValidation_form\" id=\"Change_AdmissionValidation_form\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<script>\n\t\t\t\t\tvar ambulatory_status\t\t= parent.frames[1].document.Change_Adm_Dtls_Form.ambulatory_status;\n\t\t\t\t\twhile(ambulatory_status.options.length > 1)\n\t\t\t\t\t\tambulatory_status.remove(ambulatory_status.options[1]);\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\t<script>\n\t\t\t\t\t\t\t\tvar ambulatoryOpt\t= parent.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\tambulatoryOpt.text\t= \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\t\t\t\t\t\tambulatoryOpt.value = \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\t\t\t\t\t\t\t parent.frames[1].document.Change_Adm_Dtls_Form.ambulatory_status.add(ambulatoryOpt);\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<script>\n\t\t\t\t\tvar visit_adm_type = parent.frames[1].document.Change_Adm_Dtls_Form.visit_adm_type;\n\t\t\t\t\twhile(visit_adm_type.options.length > 1)\n\t\t\t\t\t\tvisit_adm_type.remove(visit_adm_type.options[1]);\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\t<script>\n\t\t\t\t\t\t\t\tvar admTypeOpt\t\t\t= parent.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\tadmTypeOpt.text\t\t\t= \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\t\t\t\t\t\tadmTypeOpt.value\t\t= \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\t\t\t\t\t\tparent.frames[1].document.Change_Adm_Dtls_Form.visit_adm_type.add(admTypeOpt);\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar Bedcode = parent.frames[1].document.Change_Adm_Dtls_Form.Bedcode;\n\t\t\t\t\tfor(i=0;i<Bedcode.length;i++) {\n\t\t\t\t\t\tBedcode.remove(1);\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t<script>\n\t\t\t\t\t\t\t\t\tvar BedcodeOpt  = parent.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t\t\t\t\tBedcodeOpt.text\t= \"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\n\t\t\t\t\t\t\t\t\tBedcodeOpt.value= \"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\";\n\t\t\t\t\t\t\t\t\tparent.frames[1].document.Change_Adm_Dtls_Form.Bedcode.add(BedcodeOpt);\n\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tif(parent.frames[1].document.Change_Adm_Dtls_Form) {\t\n\t\t\t\t\t\t\t\t\tparent.frames[1].document.Change_Adm_Dtls_Form.ancillary_yn.value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\n\t\t\t\t\t\t\t\tvar obj =parent.frames[1].document.Change_Adm_Dtls_Form.service;\n\t\t\t\t\t\t\t\tvar length  = obj.length;\n\t\t\t\t\t\t\t\tfor(i=0;i<length;i++) {obj.remove(1);}\n\t\t\t\t\t\t\t\tvar opt= parent.frames[1].document.createElement(\'Option\');\n\t\t\t\t\t\t\t\topt.text = \"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\";\n\t\t\t\t\t\t\t\topt.value= \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\n\t\t\t\t\t\t\t\topt.selected = true;\n\t\t\t\t\t\t\t\tobj.add(opt);\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="<script> \n\t\t\t\t\t\tif(parent.frames[1].document.Change_Adm_Dtls_Form){\n\t\t\t\t\t\t\tvar obj =parent.frames[1].document.Change_Adm_Dtls_Form.service;\n\t\t\t\t\t\t\tvar length  = obj.length;\n\t\t\t\t\t\t\tfor(i=0;i<length;i++) \n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tobj.remove(1);\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\t\t<script>\n\t\t\t\t\t\t\t\tvar opt = parent.frames[1].document.createElement(\'Option\');\n\t\t\t\t\t\t\t\topt.text=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\";\n\t\t\t\t\t\t\t\topt.value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\";\n\t\t\t\t\t\t\t\tobj.add(opt);\n\t\t\t\t\t\t\t\tparent.frames[1].document.createElement(\'Option\');\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t</form>\n\t</body>\n</html>\n\t\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

   String isFutureBlock(String facility_id,String bed_no,String nursingunit,Connection con)
	{
		
		String sql = "Select booking_type,override_yn,PATIENT_ID from ip_bed_booking WHERE facility_id='"+facility_id+"' and req_nursing_unit_code='"+nursingunit+"' and req_bed_no='"+bed_no+"' and booking_status='0' and blocked_from_date_time > sysdate";
		String temp_flag = "";
		Statement stmt1 = null;
		ResultSet rset1 = null;
		try
		{
			
			stmt1 = con.createStatement();
			rset1 = stmt1.executeQuery(sql);
			if(rset1!=null && rset1.next())
			{
				temp_flag = "Y";
			}
			
							if (stmt1 != null) stmt1.close();
				if (rset1 != null) rset1.close();
			
			}catch(Exception e) {
				e.printStackTrace();
				}

			return temp_flag;
	}


	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);

	request.setCharacterEncoding("UTF-8");
	String locale =	(String)session.getAttribute("LOCALE");

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	webbeans.op.PatientData patdata = new webbeans.op.PatientData();
	Connection			con			=	null;
	//PreparedStatement	pstmt		=	null;

	Statement			stmt		=	null;
	//Statement			stmt_nu		=	null;
	ResultSet			rset		=	null;


	Statement			SubSerStmt	=	null;
	ResultSet			SubSerRset	=	null;

	//ResultSet			rset_nu		=	null;
	//ResultSet			rsetBL		=	null;
	//Statement			stmt1		=	null;
	//ResultSet			rs			=	null;
	//Statement			stmt1_p		=	null;
	//ResultSet			rs_p		=	null;
	//Statement			patstmt		=   null;
	//ResultSet			patrs		=   null;
	//String loginUser				= (String)session.getAttribute("login_user");
	//String install_yn				=(String)session.getValue("bl_operational");

	//java.util.Properties propertiesBill = (java.util.Properties) session.getValue( "jdbc" ) ;
	StringBuffer sql				= new StringBuffer(); 
	//StringBuffer query_booking_ref_no= new StringBuffer(); 
	//String maxperiodforrevbkg1		= checkForNull(request.getParameter("bkg_grace_period"));	
	//String admission_for			= checkForNull(request.getParameter("admission_for"));
	String facilityId				= "";
	String value1					= ""; 
	String value2					= "";
	String value3					= ""; 
	String from						= ""; 
	String value5					= "";
	String patientid				= "";
	//String dissource              = "";
	//String disspec				= "";	
	//String attendpractitionerid	= "";
	//String bookingrefno			= "";
	//String patient				= "";
	//String encounter				= "";
	//String referralid				= "";
	//String ID						= "";
	//String dat					= ""; 
	//String practitionerid			= "";
	//String nursingunit			= "";
	//String bookingstatus			= "";
	//String blooddonation			= "";
	//String specialitycode			= "";
	//String chiefcomplaint			= "";
	//String otdatetime				= "";	
	//String chiefcomplaint_desc	= "";
	//String bedclasscode			= "";	
	//String bedClassDesc			= "";	
	String bedtypecode				= "";
	String roomno					= "";
	String bedno					= "" ;	
	String ancillaryyn				= "";
	String servicecode				= "",		servicedesc				=	"";
	String Indicator				= "";
	String visit_adm_date_time		= "";	
	String expDaysofStay			= "";
	//String continue_yn			= "";
	//String to_service_code		= "";
	//String to_speciality_code		= "";
	//String to_speciality_desc		= "";
	//String queryString			= "";
	//String teamid					= "";
	//String financial_detail_ref_id= "";
	//String org_type_data			= "";
	//String practitioner			= "";
	String servcode					= "";
	
	String patient_nursingunit		= "";
	String bed_class				= "";	
	String nursingunit_code			= "";	
	String deactivate_pseudo_bed_yn = "N";	
	String frame_ref				= "";
	String populateList				= "";
	String bedType_code				= "";
	String forBllingProc			= "";
	String future_YN				= "";

	try{
		con							=	ConnectionManager.getConnection(request);
		patdata.setFacility_id(facilityId);
		facilityId					=	(String)session.getValue("facility_id");


		value1						=	checkForNull(request.getParameter("field1"));
		value2						=	checkForNull(request.getParameter("field2"));
		value3						=	checkForNull(request.getParameter("field3"));
		nursingunit_code			=	checkForNull(request.getParameter("nursingunit_code"));
		from						=	checkForNull(request.getParameter("field4"));
		Indicator					=	checkForNull(request.getParameter("Indicator"));
		value5						=	checkForNull(request.getParameter("field5"));
		expDaysofStay				=	checkForNull(request.getParameter("expDaysofStay"));
		frame_ref					= checkForNull(request.getParameter("frame_ref"));
		populateList				= checkForNull(request.getParameter("populateList"));
		bedType_code				= checkForNull(request.getParameter("bedtype_Code"));

		visit_adm_date_time			=	checkForNull(request.getParameter("visit_adm_date_time"));
		servicecode					= checkForNull(request.getParameter("service_code"));
		servcode					=	checkForNull(request.getParameter("serviceCode"));
		bed_class					=	checkForNull(request.getParameter("bed_class"));
		patientid					= checkForNull(request.getParameter("patient_id"));
		forBllingProc				= checkForNull(request.getParameter("forBllingProc"),"N");
		future_YN					= checkForNull(request.getParameter("future_yn"),"N");


		deactivate_pseudo_bed_yn	= request.getParameter("deactivate_pseudo_bed_yn");
		if(deactivate_pseudo_bed_yn == null) deactivate_pseudo_bed_yn= "N";
		
		

		String bed_type_code		= "";
		String bed_type_desc		= "";


if(future_YN.equals("Y")){

			patient_nursingunit		= checkForNull(request.getParameter("bl_Nursingunit"));
			String f_flag2			= "";	

			if(sql.length() > 0) sql.delete(0,sql.length());

			sql.append(" Select booking_type, override_yn, patient_id from IP_BED_BOOKING WHERE facility_id = '"+facilityId+"' and req_nursing_unit_code = '"+patient_nursingunit+"' and req_bed_no = '"+value3+"' and booking_status = '0' and blocked_from_date_time > sysdate and ( patient_id is null or patient_id != '"+patientid+"') ");

			stmt					=	con.createStatement();
			rset					=	stmt.executeQuery(sql.toString());

			if(rset!=null && rset.next())
			{
				f_flag2				= "Y";
			}
			if(rset !=null) rset.close(); 
			if(stmt != null) stmt.close();
			
            _bw.write(_wl_block9Bytes, _wl_block9);
if(f_flag2.equals("Y"))
			{
	
				out.println("<script>var retval = confirm(getMessage('BED_BLCKD_FOR_FUT_DT','IP'));if(retval){parent.frames[1].document.Change_Adm_Dtls_Form.confirm_flag.value = 'Y';parent.frames[1].document.Change_Adm_Dtls_Form.r_bed_no.value=parent.frames[1].document.Change_Adm_Dtls_Form.bed_no.value;if(parent.frames[1].document.Change_Adm_Dtls_Form.bl_instal.value == 'Y'){if(parent.frames[1].document.Change_Adm_Dtls_Form.pat_check_in_allowed_yn.value=='N'){if(parent.frames[1].document.Change_Adm_Dtls_Form.r_bed_no.value!=''){parent.frames[1].BLCheckElig(parent.frames[1])}else{parent.frames[1].document.Change_Adm_Dtls_Form.r_bed_no.value=parent.frames[1].document.Change_Adm_Dtls_Form.bed_no.value;parent.frames[1].document.Change_Adm_Dtls_Form.submit();}}else{parent.frames[1].frames[2].BLCheckElig(parent.frames[1].frames[1])}}else{parent.frames[1].document.Change_Adm_Dtls_Form.submit();}}</script>");
			}
			else
			{
				out.println("<script>parent.frames[1].document.Change_Adm_Dtls_Form.confirm_flag.value = 'N';parent.frames[1].document.Change_Adm_Dtls_Form.r_bed_no.value=parent.frames[1].document.Change_Adm_Dtls_Form.bed_no.value;if(parent.frames[1].document.Change_Adm_Dtls_Form.bl_instal.value =='Y'){if(parent.frames[1].document.Change_Adm_Dtls_Form.pat_check_in_allowed_yn.value=='N') {if(parent.frames[1].document.Change_Adm_Dtls_Form.r_bed_no.value!=''){parent.frames[1].BLCheckElig(parent.frames[1])}else{parent.frames[1].document.Change_Adm_Dtls_Form.submit();}}else{parent.frames[1].BLCheckElig(parent.frames[1])}}else{parent.frames[1].document.Change_Adm_Dtls_Form.submit();}</script>");
			}
		}



	if(populateList.equals("Y")){
            _bw.write(_wl_block10Bytes, _wl_block10);
			
					String ambulatory_short_desc= "";
					String ambulatory_code		= "";

					// To populate the AMBULATORY STATUS ...
					if(sql.length() > 0) sql.delete(0,sql.length());
					//sql.append(" select ambulatory_status, short_desc from AM_AMBULATORY_STATUS_LANG_VW where language_id = '"+locale+"' and eff_status='E' order by short_desc ");
					/*Tuesday, May 18, 2010 , modified for PE*/
					sql.append(" SELECT   ambulatory_status, am_get_desc.am_ambulatory_status(ambulatory_status,'"+locale+"',2)short_desc FROM am_ambulatory_status WHERE eff_status = 'E' ORDER BY short_desc ");
					stmt = con.createStatement();
					rset = stmt.executeQuery(sql.toString());

					if(rset!=null){
						while(rset.next()){
							ambulatory_short_desc	= rset.getString("short_desc");
							ambulatory_code			= rset.getString("ambulatory_status");
					
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(ambulatory_short_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(ambulatory_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
	}// E.O While
					}// E.O if

					if(rset != null) rset.close();
					if(stmt != null) stmt.close();
					
            _bw.write(_wl_block14Bytes, _wl_block14);
			

					String admission_type_short_desc= "";
					String admission_type_code		= "";
					
					//To populate the ADMISSION TYPE ...
					if(sql.length() > 0) sql.delete(0,sql.length());
					//sql.append(" select admission_type_code, short_desc from IP_ADMISSION_TYPE_LANG_VW where language_id = '"+locale+"' and  eff_status='E' order by short_desc ");
					/*Tuesday, May 18, 2010 , modified for PE*/
					sql.append(" SELECT   admission_type_code,ip_get_desc.ip_admission_type(admission_type_code,'"+locale+"',2) short_desc FROM ip_admission_type WHERE eff_status = 'E' ORDER BY short_desc ");
					stmt = con.createStatement();
					rset = stmt.executeQuery(sql.toString());

					if(rset!=null){
						while(rset.next()){
							admission_type_short_desc	= rset.getString("short_desc");
							admission_type_code			= rset.getString("admission_type_code");
					
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(admission_type_short_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(admission_type_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
	}// E.O While
					}// E.O if
					if(rset != null) rset.close();
					if(stmt != null) stmt.close();

            _bw.write(_wl_block18Bytes, _wl_block18);
			
					String bed_class_short_desc	= "";
					String bed_class_code		= "";
					// To populate the BED CLASS ...
					if(sql.length() > 0) sql.delete(0,sql.length());
					if(!value3.equals("")){
						sql.append(" SELECT DISTINCT a.bed_class_code bed_class_code, ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) short_desc FROM IP_NURSING_UNIT_BED a WHERE a.facility_id = '"+facilityId+"' AND a.eff_status = 'E' AND a.nursing_unit_code = '"+value3+"'  ORDER BY short_desc ");
					}
					else if(!value3.equals("")){
						sql.append(" SELECT DISTINCT a.bed_class_code bed_class_code, ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) short_desc FROM IP_NURSING_UNIT_BED a WHERE a.facility_id = '"+facilityId+"' AND a.eff_status = 'E'  AND a.nursing_unit_code = '"+value3+"' ORDER BY short_desc ");
					}else{
						sql.append(" Select bed_class_code, ip_get_desc.ip_bed_class(bed_class_code,'"+locale+"',2)short_desc from IP_BED_CLASS where eff_status='E' order by short_desc ");
					}

					stmt = con.createStatement();
					rset = stmt.executeQuery(sql.toString());

					if(rset!=null){
						while(rset.next()){
							bed_class_short_desc	= rset.getString("short_desc");
							bed_class_code			= rset.getString("bed_class_code");
							
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(bed_class_short_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bed_class_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
	
						}// E.O While
					}// E.O if

					if(rset != null) rset.close();
					if(stmt != null) stmt.close();

			}

	if(!bed_class.equals("")){
			if( deactivate_pseudo_bed_yn.equals("Y") && !nursingunit_code.equals("") ){
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" SELECT DISTINCT a.bed_type_code bed_type_code, ip_get_desc.ip_bed_type(a.BED_TYPE_CODE,'"+locale+"',2)  bed_type_short_desc FROM IP_NURSING_UNIT_BED a WHERE a.facility_id = '"+facilityId+"' AND a.nursing_unit_code = '"+nursingunit_code+"' AND a.bed_class_code = '"+bed_class+"' AND a.eff_status='E' AND a.psuedo_bed_status = 'N' ORDER BY bed_type_short_desc ");
			}
			else if( deactivate_pseudo_bed_yn.equals("N") && !nursingunit_code.equals("") ){
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append("SELECT DISTINCT a.bed_type_code bed_type_code, ip_get_desc.ip_bed_type(a.BED_TYPE_CODE,'"+locale+"',2)  bed_type_short_desc FROM IP_NURSING_UNIT_BED a WHERE a.facility_id = '"+facilityId+"' AND a.nursing_unit_code = '"+nursingunit_code+"' AND a.bed_class_code = '"+bed_class+"' AND a.eff_status='E'  ORDER BY bed_type_short_desc ");
			}
			stmt	=	con.createStatement();
			rset	=	stmt.executeQuery(sql.toString());

			
			out.println("<script>var obj =parent.frames[1].document.Change_Adm_Dtls_Form.bed_type;</script>");
			out.println("<script>var length  = obj.length;");
			out.println("for(i=0;i<length;i++) {obj.remove(1);}");
			out.println("</script>");

			if(rset != null){
				while(rset.next()){
					bed_type_code = checkForNull(rset.getString("bed_type_code"));
					bed_type_desc = checkForNull(rset.getString("bed_type_short_desc"));
						if((!bedType_code.equals("")) && (bedType_code.equals(bed_type_code))){
						out.println ("<script>var opt= parent.frames[1].document.createElement('Option');\nopt.text=\""+bed_type_desc+"\"; opt.value=\""+bed_type_code+"\";opt.selected=true;obj.add(opt);");
						out.println ("eval('parent.frames[1].document').createElement('Option')") ;
						out.println("</script>");
					}else{
						out.println ("<script>var opt= parent.frames[1].document.createElement('Option');\nopt.text=\""+bed_type_desc+"\"; opt.value=\""+bed_type_code+"\";obj.add(opt);");
						out.println ("eval('parent.frames[1].document').createElement('Option')") ;
						out.println("</script>");
					}
				}//while loop
				if(rset !=null) rset.close(); 
				if(stmt != null) stmt.close();
			 }//if rset not null
		}



		if (from.equals("Main_form")){
			bedno=value5;
			nursingunit_code=value3;
					if(!nursingunit_code.equals("")){
						String addlservice = "";
						if(sql.length() > 0) sql.delete(0,sql.length());
						sql.append(" Select service_code, am_get_desc.am_service(service_code,'"+locale+"',2) short_desc, ancillary_yn from AM_SERVICE where Service_code in (select service_code from IP_NURSING_UNIT where Facility_id='"+facilityId+"' and  nursing_unit_code='"+nursingunit_code+"') order by short_desc ");
						String service_add = checkForNull(request.getParameter("service_add"));
						stmt = con.createStatement();
						rset = stmt.executeQuery(sql.toString());
					if(!service_add.equals("N")){
						if(rset != null && rset.next()){
						servicecode			=	checkForNull(rset.getString("service_code"));
						servicedesc			=	checkForNull(rset.getString("short_desc"));
						ancillaryyn			=	checkForNull(rset.getString("ancillary_yn"));
						
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ancillaryyn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(servicedesc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(servicecode));
            _bw.write(_wl_block25Bytes, _wl_block25);

					}
					if(rset != null)rset.close(); if(stmt != null) stmt.close();
					//Adding Services.	
					
            _bw.write(_wl_block26Bytes, _wl_block26);

					//patient class is not used.
					if(sql.length() > 0) sql.delete(0,sql.length());
					sql.append(" select service_code, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"','2') service_short_desc from IP_NURS_UNIT_FOR_SERVICE where facility_id = '"+facilityId+"' and nursing_unit_code = '"+nursingunit_code+"' union select service_code, am_get_desc.AM_SERVICE(SERVICE_CODE,'"+locale+"','2') service_short_desc from IP_NURSING_UNIT where facility_id = '"+facilityId+"' and EFF_STATUS = 'E' and nursing_unit_code = '"+nursingunit_code+"' order by 2 ");
					stmt = con.createStatement();
					rset = stmt.executeQuery(sql.toString());	
					if(rset!=null ){
						while (rset.next()){
							addlservice			=	checkForNull(rset.getString("service_code"));
							servicedesc			=	checkForNull(rset.getString("service_short_desc"));
					
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(servicedesc));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(addlservice));
            _bw.write(_wl_block29Bytes, _wl_block29);
	}
					}

					out.println("<script>");
					if(rset != null)rset.close(); if(stmt != null) stmt.close();
					out.println("var frame_ref = \""+frame_ref+"\" ");
					out.println("if(frame_ref == '') frame_ref = 'parent.frames[1]';");
					out.println("var obj =eval(frame_ref+'.document.forms[0].sub_service');");
					out.println("var length  = obj.length;");
					out.println("for(i=0;i<length;i++) {obj.remove(1);}");
					
					String subservice_code = "", subservice_desc = "";
					StringBuffer sersql = new StringBuffer();
					sersql.append(" Select subservice_code, AM_GET_DESC.AM_SUBSERVICE(service_code,subservice_code,'"+locale+"','2') subservice_short_desc from AM_FACILITY_SUBSRVC where service_code = '"+servicecode+"' and operating_facility_id = '"+facilityId+"' and eff_status = 'E' order by subservice_short_desc ");
					stmt = con.createStatement();
					rset = stmt.executeQuery(sersql.toString());

					if(rset!=null ){
						while(rset.next()){
							subservice_code  = checkForNull(rset.getString("SUBSERVICE_CODE"));
							subservice_desc = checkForNull(rset.getString("SUBSERVICE_SHORT_DESC"));
							out.println ("var opt= eval(frame_ref+'.document').createElement('Option');\nopt.text=\""+subservice_desc+"\"; opt.value=\""+subservice_code+"\"; \nobj.add(opt)");
							out.println ("eval(frame_ref+'.document').createElement('Option')") ;
						}
					}
					out.println("</script>");
					if(rset != null)rset.close(); if(stmt != null) stmt.close();
				}
				String bedcode = "";
				String beddesc = ""; 
				StringBuffer bedcodeSql = new StringBuffer();

				if(deactivate_pseudo_bed_yn.equals("Y")){
					bedcodeSql.append(" SELECT DISTINCT a.bed_class_code bed_class_code, ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) short_desc FROM ip_nursing_unit_bed a WHERE a.facility_id = '"+facilityId+"' AND a.eff_status = 'E' AND a.nursing_unit_code = '"+nursingunit_code+"' AND  a.psuedo_bed_status = 'N' ORDER BY short_desc ");
				}else{
					bedcodeSql.append(" SELECT DISTINCT a.bed_class_code bed_class_code, ip_get_desc.ip_bed_class(a.bed_class_code,'"+locale+"',2) short_desc FROM ip_nursing_unit_bed a WHERE a.facility_id = '"+facilityId+"' AND a.eff_status = 'E' AND a.nursing_unit_code = '"+nursingunit_code+"' ORDER BY short_desc ");
				}

				stmt = con.createStatement();
				rset = stmt.executeQuery(bedcodeSql.toString());

				if(rset != null){
					out.println("<script>");
					out.println("var frame_ref = \""+frame_ref+"\" ");
					out.println("if(frame_ref == '') frame_ref = 'parent.frames[1]';");
					out.println("var obj =eval(frame_ref+'.document.forms[0].Bedcode');");
					out.println("var length  = obj.length;");
					out.println("for(i=0;i<length;i++) {obj.remove(1);}");
					while(rset.next()){
						bedcode			=	checkForNull(rset.getString("bed_class_code"));
						beddesc			=	checkForNull(rset.getString("short_desc"));
						out.println ("var opt= eval(frame_ref+'.document').createElement('Option');\nopt.text=\""+beddesc+"\"; opt.value=\""+bedcode+"\"; \nobj.add(opt)");
						out.println ("eval(frame_ref+'.document').createElement('Option')") ;
					}
					out.println("</script>");
				}
				if(rset != null)rset.close(); if(stmt != null) stmt.close();
			}
		
			if (!servcode.equals("") ||servcode.equals("")){
				if(!servcode.equals("")){
					out.println("<script>");
					out.println("var frame_ref = \""+frame_ref+"\" ");
					out.println("if(frame_ref == '') frame_ref = 'parent.frames[1].frames[2]';");
					out.println("var obj =eval(frame_ref+'.document.forms[0].sub_service');");
					out.println("var length  = obj.length;");
					out.println("for(i=0;i<length;i++) {obj.remove(1);}");
				}
				String subservice_code = "", subservice_desc = "";
				StringBuffer serSql = new StringBuffer();

				serSql.append(" select subservice_code, AM_GET_DESC.AM_SUBSERVICE(service_code,subservice_code,'"+locale+"','2') subservice_short_desc from AM_FACILITY_SUBSRVC where service_code = '"+servcode+"' and operating_facility_id = '"+facilityId+"' and eff_status = 'E' order by subservice_short_desc ");
				SubSerStmt = con.createStatement();
				try{
				SubSerRset = SubSerStmt.executeQuery(serSql.toString());
				if(SubSerRset != null ){
					while(SubSerRset.next()){
						subservice_code  = checkForNull(SubSerRset.getString("SUBSERVICE_CODE"));
						subservice_desc = checkForNull(SubSerRset.getString("SUBSERVICE_SHORT_DESC"));
						out.println("var opt= eval(frame_ref+'.document').createElement('Option');");
						out.println("opt.text=\""+subservice_desc+"\";");
						out.println("opt.value=\""+subservice_code+"\"; ");
						out.println("obj.add(opt)");
						out.println ("eval(frame_ref+'.document').createElement('Option')") ;
					}
				}
				out.println("</script>");
				if(rset != null)rset.close(); if(stmt != null) stmt.close();
				}catch (Exception EXp){
					EXp.printStackTrace();
				}
			}
			if(!bedno.equals("")){
				if(sql.length()>0) sql.delete(0,sql.length());
				sql.append(" select room_no, bed_type_code, IP_GET_DESC.IP_BED_TYPE(bed_type_code,'"+locale+"','2') bed_type_short_desc, bed_class_code, current_status, specialty_code, AM_GET_DESC.AM_SPECIALITY(specialty_code,'"+locale+"','2') short_desc from IP_NURSING_UNIT_BED where nursing_unit_code = '"+nursingunit_code+"' and bed_no='"+bedno+"' and facility_id = '"+facilityId+"' and eff_status = 'E'  and main_bed_no is null ");
				stmt	=	con.createStatement();
				rset	=	stmt.executeQuery(sql.toString());
				if(rset != null && rset.next()){
					bedtypecode		=	"";
					String bed_class_code	=	"";
					String curr_status		=	"";
					String bed_type_short_desc = "";

					bedtypecode				=	checkForNull(rset.getString("bed_type_code")).trim();
					roomno						=	checkForNull(rset.getString("room_no"));
					bed_class_code			=	checkForNull(rset.getString("bed_class_code"));
					curr_status					=	checkForNull(rset.getString("current_status"));
					bed_type_short_desc	=   checkForNull(rset.getString("bed_type_short_desc"));
					if(curr_status.equals("O"))	{
						out.print("<script>alert(getMessage('OCCUPIED_BED','IP'));parent.frames[1].document.Change_Adm_Dtls_Form.bed_no.value='';</script>");
					}else{	
						out.print("<script>parent.frames[1].document.Change_Adm_Dtls_Form.Bedcode.value=\""+bed_class_code+"\";parent.frames[1].document.Change_Adm_Dtls_Form.room_no.value=\""+roomno+"\" ;var obj = parent.frames[1].document.Change_Adm_Dtls_Form.bed_type;for(i=0;i<obj.length;i++){obj.remove(1);}var opt=parent.frames[1].document.createElement('Option');opt.text=\""+bed_type_short_desc+"\";opt.value=\""+bedtypecode+"\";opt.selected=true;obj.add(opt);if(parent.frames[1].document.Change_Adm_Dtls_Form.pat_check_in_allowed_yn.value=='Y')parent.frames[1].document.Change_Adm_Dtls_Form.attend_img.style.visibility='hidden';</script>"); 
					}
					if(rset != null)rset.close(); if(stmt != null) stmt.close();
				}else{ 
					out.print("<script>alert(getMessage('INVALID_BED','IP'));parent.frames[1].document.Change_Adm_Dtls_Form.bed_no.value='';</script>");
				
						out.print("<script>parent.frames[1].document.Change_Adm_Dtls_Form.room_no.value='';</script>");

					out.print("<script>parent.frames[1].document.Change_Adm_Dtls_Form.attend_img.style.visibility='hidden';}</script>");
				}
			}

		}

	if (forBllingProc.equals("Y")){
		PreparedStatement trnsfr_pst=null,bl_chrg_pt = null,bl_prcs_pt =	null,bl_adm_pt=null;
		ResultSet               trnsfr_rslt=null,bl_chrg_rs = null,bl_prcs_rs  = null,bl_adm_rs=null;


		String patient_id		=	checkForNull(request.getParameter("patient_id"));
		String encounter_id	=	checkForNull(request.getParameter("encounter_id"));
		//int cutt_off_time		=	Integer.parseInt(request.getParameter("cutt_of_time"));
		//int change_adm_dtls_duration	=	Integer.parseInt(request.getParameter("change_adm_dtls_duration"));
		String cutt_off_time		=	request.getParameter("cutt_of_time");
		String change_adm_dtls_duration	=	request.getParameter("change_adm_dtls_duration");
		String pract_id			=	checkForNull(request.getParameter("pract_id"));
		String location_code	=	checkForNull(request.getParameter("location_code"));
		String sex					=	checkForNull(request.getParameter("sex"));
		String bed_no			=	checkForNull(request.getParameter("bed_no"));
		String patient_class	=	checkForNull(request.getParameter("patient_class"));
		String colorCode		=	checkForNull(request.getParameter("colorCode"));
		String status_value	=	checkForNull(request.getParameter("status_value"));
		String tfr_req_status	=	checkForNull(request.getParameter("tfr_req_status"));
		String leave_exp_dt_flag	=	checkForNull(request.getParameter("leave_exp_dt_flag"));
		//String query_for_transfer		=	"";
		try{
			/*MOdified for Service Change Only
			if(cutt_off_time>change_adm_dtls_duration){
					adm_time_xcd	 =	false;
					error	 =	"The Patient Admission Time was exceeded over parameter setup.So cannot proceed.";
					out.println("<script>parent.frames[2].alert(getMessage('ADMISSION_TIME_EXCEEDED','IP'));</script>");
			}else{
			query_for_transfer=	"select count(*) tr_cnt from ip_adt_trn where facility_id='"+facilityId+"' and encounter_id='"+encounter_id+"' ";
			trnsfr_pst	=	con.prepareStatement(query_for_transfer);
			trnsfr_rslt	=	trnsfr_pst.executeQuery();
			if(trnsfr_rslt!=null&&trnsfr_rslt.next()){
				TR_Count	=	trnsfr_rslt.getInt("tr_cnt");
			}
			 if(TR_Count>1){
					err_status	 =	false;
					out.println("<script>parent.frames[2].alert(getMessage('PATIENT_IS_TRANSFFERED','IP'));</script>");
				}
			}

				if(err_status){
					out.println("<script>parent.frames[2].proceedAdmission('"+encounter_id+"','"+patient_id+"','"+pract_id+"','"+location_code+"','"+sex+"','"+bed_no+"','"+patient_class+"','"+colorCode+"','"+status_value+"','"+tfr_req_status+"','"+leave_exp_dt_flag+"','"+cutt_off_time+"','"+change_adm_dtls_duration+"');</script>");
				}*/

					out.println("<script>parent.frames[2].proceedAdmission('"+encounter_id+"','"+patient_id+"','"+pract_id+"','"+location_code+"','"+sex+"','"+bed_no+"','"+patient_class+"','"+colorCode+"','"+status_value+"','"+tfr_req_status+"','"+leave_exp_dt_flag+"','"+cutt_off_time+"','"+change_adm_dtls_duration+"');</script>");

			}catch(Exception ex){
				ex.printStackTrace();
		}finally{
			if(trnsfr_pst!=null)trnsfr_pst.close();
			if(bl_chrg_pt!=null)bl_chrg_pt.close();
			if(bl_prcs_pt!=null)bl_prcs_pt.close();
			if(bl_adm_pt!=null)bl_adm_pt.close();
			if(trnsfr_rslt!=null)trnsfr_rslt.close();
			if(bl_chrg_rs!=null)bl_chrg_rs.close();
			if(bl_prcs_rs!=null)bl_prcs_rs.close();
			if(bl_adm_rs!=null)bl_adm_rs.close();

		}
	}
}
	catch(Exception e){
		e.printStackTrace();
	}finally{
		  ConnectionManager.returnConnection(con,request); 
	}

	
            _bw.write(_wl_block30Bytes, _wl_block30);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
