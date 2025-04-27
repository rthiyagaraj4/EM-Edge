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
import webbeans.eCommon.*;
import com.ehis.eslp.*;
import java.net.*;

public final class __dprecodingpatdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/DPRecodingPatDetail.jsp", 1709118910657L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></SCRIPT>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n<script src=\"../../eCommon/js/CommonCalendar.js\" language=\'javascript\'></script>\n<script src=\'../../eCommon/js/dchk.js\'  language=\'javascript\'></script>\n<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n<script src=\'../../eMR/js/DPRecoding.js\' language=\'javascript\'></script>\n\n<html>\n<body onKeyDown=\'lockKey()\'>\n\t<form name=\"RecodeDiagnosisPatDetail\" id=\"RecodeDiagnosisPatDetail\">\n\t<table border=0 cellpadding=\'3\' cellspacing=\'0\' width=\"100%\">\n\t\t<tr>\n\t\t\t<th align=\'center\' >";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</th>\n\t\t\t<th align=\'center\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t\t</tr>\n\n\t\t\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t\t\n\t\t\t<tr class=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'><td  class=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' id=\'encSymbol";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'><a href=\"javascript:onclick=showEncounter_new(\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\')\">+</a>&nbsp;&nbsp;";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td></tr>\n\t\t\t<input type=\'hidden\' name=\'pid";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' id=\'pid";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\t\t\t<input type=\'hidden\' name=\"Pat_name";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" id=\"Pat_name";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t\t<input type=\'hidden\' name=\'gender";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' id=\'gender";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t\t<input type=\'hidden\' name=\'age";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' id=\'age";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\t\t\t<input type=\'hidden\' name=\'dob";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' id=\'dob";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t\t<input type=\'hidden\' name=\'spec_code";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' id=\'spec_code";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t\t\t<tr>\n\t\t\t<td colspan=3>\t\n\t\t\t<table id=\'dispenc";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' cellpadding=0 cellspacing=0 style=\'visibility:hidden;display:none\'>\n\n\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t<tr class=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' colspan=\'3\' align=\'center\'><img src=\'../../eCommon/images/Authorised.gif\' ></img><a href=\"javascript:onclick=changePline(\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\',\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\')\">";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</a></td>\n\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' colspan=\'3\' align=\'center\'><img src=\'../../eCommon/images/Completed.gif\' ></img><a href=\"javascript:onclick=changePline(\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</a></td>\n\n\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' colspan=\'3\' align=\'center\'><img src=\'../../eCommon/images/Partiallycompleted.gif\' ></img><a href=\"javascript:onclick=changePline(\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' colspan=\'3\' align=\'center\'><img src=\'../../eCommon/images/Pendingforreview.gif\' ></img><a href=\"javascript:onclick=changePline(\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\n\t\t\t<input type=\'hidden\' name=\'enc1";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' id=\'enc1";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n\t\t\t</tr>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t</table>\n\t\t\t</td>\n\t\t</tr>\n\n\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\n\n\t</table>\n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t<input type=\'hidden\' name=\'dflt_termset\' id=\'dflt_termset\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\t<input type=\'hidden\' name=\'Pat_id\' id=\'Pat_id\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\t<input type=\'hidden\' name=\'Pat_sex\' id=\'Pat_sex\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n\t<input type=\'hidden\' name=\'Pat_age\' id=\'Pat_age\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n\t<input type=\'hidden\' name=\'stage_no\' id=\'stage_no\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t<input type=\'hidden\' name=\'Pat_familyname\' id=\'Pat_familyname\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n\t<input type=\'hidden\' name=\'Pat_disch\' id=\'Pat_disch\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n\t<input type=\'hidden\' name=\'Pat_visit\' id=\'Pat_visit\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n\t<input type=\'hidden\' name=\'Pat_los\' id=\'Pat_los\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\n\t<input type=\'hidden\' name=\'Pat_name\' id=\'Pat_name\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\n\t<input type=\'hidden\' name=\'Pat_dob\' id=\'Pat_dob\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\n\t<input type=\'hidden\' name=\'Pat_class\' id=\'Pat_class\' value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\n\t<input type=\'hidden\' name=\'Patient_Class\' id=\'Patient_Class\' value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\n\t<input type=\'hidden\' name=\'i\' id=\'i\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n\n\t<input type=\'hidden\' name=\'enc_val\' id=\'enc_val\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n\t<input type=\'hidden\' name=\'finalSelect\' id=\'finalSelect\' value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'>\n\t<input type=\'hidden\' name=\'enc_temp\' id=\'enc_temp\' value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t<input type=\'hidden\' name=\'pat_temp\' id=\'pat_temp\' value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t<input type=\'hidden\' name=\'allow_recode_diag_yn\' id=\'allow_recode_diag_yn\' value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t<input type=\'hidden\' name=\'allow_recode_proc_yn\' id=\'allow_recode_proc_yn\' value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t<input type=\'hidden\' name=\'hdr_modified_dt\' id=\'hdr_modified_dt\' value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t<input type=\'hidden\' name=\'L1_hdr_status\' id=\'L1_hdr_status\' value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t<input type=\'hidden\' name=\'L2_hdr_status\' id=\'L2_hdr_status\' value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t<input type=\'hidden\' name=\'L3_hdr_status\' id=\'L3_hdr_status\' value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t<input type=\'hidden\' name=\'curr_level\' id=\'curr_level\' value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\n\n\n\n\n\t</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)	{
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
	//String locale = (String)session.getAttribute("LOCALE");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String FacilityId		= (String) session.getValue( "facility_id" ) ;	

	
	 


	Connection conn = ConnectionManager.getConnection(request);	
	PreparedStatement pstmt		= null;
	//PreparedStatement pstmt1		= null;
	PreparedStatement pstmt2		= null;
	ResultSet rs				= null;
	//ResultSet rs1				= null;
	ResultSet rs2				= null;
	StringBuffer sqlbuff = new StringBuffer();
	String Pat_name ="";
	String Pat_sex ="";
	String Pat_age ="";
	String Pat_class ="";
	String Pat_dob ="";
	String Pat_enc ="";
	String Pat_spec ="";
	String Pat_fname ="";
	String Pat_familyname ="";
	String classValue	 = "";
	String dPatient_id = "";
    String Pat_disch = "";
	String Pat_visit = "";
	String Pat_los = "";


    int i=1;
    int m=0;
    int n=0;



	try
	{
	String stage_no1=request.getParameter("stage_no");
	int stage_no = Integer.parseInt(stage_no1);
	String enc_val=request.getParameter("enc_val");
/*
	String enc_temp=request.getParameter("enc_temp");
	String pat_temp=request.getParameter("pat_temp");
*/
	String finalSelect1=request.getParameter("finalSelect1");
	String dflt_termset=request.getParameter("dflt_termset");
	String Patient_Class=request.getParameter("Patient_Class");
	String Pat_id=request.getParameter("Pat_id");
	Pat_sex=request.getParameter("Pat_sex");
	Pat_age=request.getParameter("Pat_age");
	/*
		F.Y.I
		1.Added On 4/26/2010 for PE Tuning;
		2.The below vairable values will be getting from the Frames page and Servlet while loading.
	*/
	String L1_hdr_status = checkForNull(request.getParameter("L1_hdr_status"));
	String L2_hdr_status = checkForNull(request.getParameter("L2_hdr_status"));
	String L3_hdr_status = checkForNull(request.getParameter("L3_hdr_status"));
	String curr_level				= checkForNull(request.getParameter("curr_level"));
	String hdr_modified_dt		= checkForNull(request.getParameter("hdr_modified_dt"));


	String pat_temp="";
	String enc_temp="";
	pat_temp=request.getParameter("pat_temp");
	enc_temp=request.getParameter("enc_temp");




	if(pat_temp ==null || pat_temp.equals("null") || pat_temp.equals("") ){
		pat_temp	=	(String)	session.getAttribute("patientList");
	}

	if(enc_temp ==null || enc_temp.equals("null")  ||enc_temp.equals("")){
		enc_temp	=	(String)	session.getAttribute("encountertList");
	}
	
String allow_recode_diag_yn	= checkForNull((String)session.getAttribute("allow_recode_diag_yn"),"N");
String allow_recode_proc_yn	= checkForNull((String)session.getAttribute("allow_recode_proc_yn"),"N");



	//pstmt = conn.prepareStatement("select ENCOUNTER_ID from pr_encounter where FACILITY_ID='"+FacilityId+"' AND ENCOUNTER_ID IN ("+enc_temp+") order by VISIT_ADM_DATE_TIME");
	//rs = pstmt.executeQuery();
	//enc_val="";

	//while (rs.next()){
		//enc_val=enc_val+"$"+rs.getString("ENCOUNTER_ID");
	//}







            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

		 


	String objName = "";
	String enc1 = "";
	String enc_line = "";
	int temp = 0;
	//int temp1= 0;

		StringTokenizer st=new StringTokenizer(enc_val,"~");
		temp=st.countTokens();


		for(int u2=0;u2<temp;u2++)
		{
		
			String st2=st.nextToken();
			StringTokenizer st1=new StringTokenizer(st2,"$");
			enc1=st1.nextToken();
			objName=st1.nextToken();
		}
		
		//String sql_pat="SELECT DISTINCT patient_id FROM mp_patient WHERE patient_id IN ("+pat_temp+")";

		String duplicates=pat_temp;
		StringTokenizer tokenString=new StringTokenizer(duplicates,",");
		int len = tokenString.countTokens();

		String[] duplicates1=new String[len];

		int z=0;
		StringTokenizer tokenString1=new StringTokenizer(duplicates,",");
		while(tokenString1.hasMoreTokens()){
			duplicates1[z++]=tokenString1.nextToken();
		}

		//Arrays.sort(duplicates1);  // commented on 7th oct
		int kkk = 0;

		for (int iii = 0; iii < duplicates1.length; iii++){
			if (iii > 0 && duplicates1[iii].equals(duplicates1[iii -1])){
				continue;
			}

			duplicates1[kkk++] = duplicates1[iii];
		}

		String[] unique = new String[kkk];

		System.arraycopy(duplicates1, 0, unique, 0, kkk);

		//ArrayList pat_list=new ArrayList();

		for (int jjj = 0; jjj < unique.length; jjj++){

			dPatient_id = unique[jjj];
			//String patsql="SELECT a.PATIENT_ID PATIENT_ID,a.PATIENT_NAME PATIENT_NAME, a.first_name, a.family_name, a.SEX SEX,to_char(a.DATE_OF_BIRTH,'dd/mm/yyyy')DATE_OF_BIRTH , GET_AGE(a.DATE_OF_BIRTH) AGE  FROM MP_PATIENT a  WHERE  a.PATIENT_ID="+dPatient_id;
		String patsql="SELECT a.PATIENT_ID PATIENT_ID,a.PATIENT_NAME PATIENT_NAME, a.first_name, a.family_name, a.SEX SEX,to_char(a.DATE_OF_BIRTH,'dd/mm/yyyy')DATE_OF_BIRTH , GET_AGE(a.DATE_OF_BIRTH,NVL(a.DECEASED_DATE,SYSDATE)) AGE  FROM MP_PATIENT a  WHERE  a.PATIENT_ID="+dPatient_id;
			
			pstmt = conn.prepareStatement(patsql);
			rs = pstmt.executeQuery();

			while(rs.next()){
				Pat_id = rs.getString("PATIENT_ID");
				Pat_name = rs.getString("PATIENT_NAME");
				Pat_sex = checkForNull(rs.getString("SEX"));
				Pat_age= checkForNull(rs.getString("AGE"));
				//Pat_class= rs.getString("PATIENT_CLASS");
				Pat_dob= rs.getString("DATE_OF_BIRTH");
				//Pat_enc= rs.getString("ENCOUNTER_ID");
				//Pat_spec= rs.getString("SPECIALTY_CODE");
				Pat_fname= rs.getString("first_name");
				Pat_familyname= rs.getString("family_name");
				//Pat_disch= rs.getString("discharge_date_time");
				//Pat_visit= rs.getString("visit_adm_date_time");
				//Pat_los= rs.getString("v_los");

			}

			if(rs != null)rs.close();
			if(pstmt  != null)pstmt.close();

					if ( i % 2 == 0 )
					classValue = "gridData" ;
				else
					classValue = "gridData" ;

		

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(m));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(m));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Pat_name));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Pat_sex));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Pat_age));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(m));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(m));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Pat_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(m));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(m));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Pat_name));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(m));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(m));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Pat_sex));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(m));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(m));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Pat_age));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(m));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(m));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Pat_dob));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(m));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(m));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Pat_spec));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(m));
            _bw.write(_wl_block32Bytes, _wl_block32);

			
			if(sqlbuff.length() > 0) sqlbuff.delete(0,sqlbuff.length());	
			sqlbuff.append("SELECT B.PATIENT_ID PATIENT_ID,B.PATIENT_NAME PATIENT_NAME,A.ENCOUNTER_ID ENCOUNTER_ID,B.SEX SEX,GET_AGE(B.DATE_OF_BIRTH) AGE FROM MP_PATIENT B,PR_ENCOUNTER A WHERE A.FACILITY_ID='"+FacilityId+"' AND A.ENCOUNTER_ID IN ("+enc_temp+") AND A.PATIENT_ID=B.PATIENT_ID AND A.PATIENT_ID="+dPatient_id+ " order by a.VISIT_ADM_DATE_TIME desc");
			//sqlbuff.append("SELECT B.PATIENT_ID PATIENT_ID,B.PATIENT_NAME PATIENT_NAME,A.ENCOUNTER_ID ENCOUNTER_ID,B.SEX SEX,GET_AGE(B.DATE_OF_BIRTH) AGE FROM MP_PATIENT B,PR_ENCOUNTER A WHERE A.FACILITY_ID='"+FacilityId+"' AND A.PATIENT_ID IN ('"+pid+"') AND A.PATIENT_ID=B.PATIENT_ID group by B.PATIENT_ID,B.PATIENT_NAME,A.ENCOUNTER_ID,B.SEX,GET_AGE(B.DATE_OF_BIRTH) order by B.PATIENT_NAME");
			pstmt = conn.prepareStatement(sqlbuff.toString());
			rs = pstmt.executeQuery();

			String enc_status="";
			//String complete_yn="";
			//String partial_yn="";
			//String pending_yn="";
//			String enc_status_sql="";
			while(rs.next()){
				enc_line=rs.getString("ENCOUNTER_ID");
				String patsql1=" SELECT  b.PATIENT_CLASS, b.SPECIALTY_CODE, b.ENCOUNTER_ID, to_char(b.visit_adm_date_time,'dd/mm/yyyy')visit_adm_date_time, to_char(b.discharge_date_time,'dd/mm/yyyy')discharge_date_time,(b.discharge_date_time - b.discharge_date_time) v_los FROM PR_ENCOUNTER b WHERE  b.encounter_id ='"+enc_line+"' AND b.facility_id = '"+FacilityId+"' AND b.PATIENT_ID= "+dPatient_id + "order by b.VISIT_ADM_DATE_TIME desc";
				pstmt2 = conn.prepareStatement(patsql1);
				rs2 = pstmt2.executeQuery();
				while(rs2.next()){
					Pat_class= rs2.getString("PATIENT_CLASS");
					Pat_enc= rs2.getString("ENCOUNTER_ID");
					Pat_spec= rs2.getString("SPECIALTY_CODE");
					Pat_disch= rs2.getString("discharge_date_time");
					Pat_visit= rs2.getString("visit_adm_date_time");
					Pat_los= rs2.getString("v_los");
				}
				/*
				if(rs2 != null)rs2.close();
				if(pstmt2  != null)pstmt2.close();
				
				if(stage_no1.equals("1")){
					enc_status_sql="SELECT nvl(LEVEL1_STATUS,'P') enc_status FROM MR_DIAG_PROC_RECODING_HDR WHERE FACILITY_ID='"+FacilityId+"' AND ENCOUNTER_ID='"+enc_line+"'";

				}else if(stage_no1.equals("2")){
					enc_status_sql="SELECT nvl(LEVEL2_STATUS,'P') enc_status FROM MR_DIAG_PROC_RECODING_HDR WHERE FACILITY_ID='"+FacilityId+"' AND ENCOUNTER_ID='"+enc_line+"'";
				}else if(stage_no1.equals("3")){
					enc_status_sql="SELECT nvl(LEVEL3_STATUS,'P') enc_status FROM MR_DIAG_PROC_RECODING_HDR WHERE FACILITY_ID='"+FacilityId+"' AND ENCOUNTER_ID='"+enc_line+"'";
				}

				pstmt2 = conn.prepareStatement(enc_status_sql);
				rs2 = pstmt2.executeQuery();
				if(rs2.next())
				{
					enc_status = rs2.getString("enc_status");
				}
				*/
				if(rs2 != null)rs2.close();
				if(pstmt2  != null)pstmt2.close();
				// aded 19/jun	
				String sql_hdr_sts="SELECT CURR_LEVEL, nvl(LEVEL1_STATUS,'P') LEVEL1_STATUS,nvl(LEVEL2_STATUS,'P') LEVEL2_STATUS,nvl(LEVEL3_STATUS,'P') LEVEL3_STATUS,to_char(modified_date,'dd/mm/yyyy hh24:mi:sssss') MODIFIED_DATE FROM MR_DIAG_PROC_RECODING_HDR WHERE FACILITY_ID='"+FacilityId+"' AND ENCOUNTER_ID='"+enc_line+"'";
				pstmt2 = conn.prepareStatement(sql_hdr_sts);
				rs2 = pstmt2.executeQuery();	
				while(rs2.next()){
					L1_hdr_status=rs2.getString("LEVEL1_STATUS");
					L2_hdr_status=rs2.getString("LEVEL2_STATUS");
					L3_hdr_status=rs2.getString("LEVEL3_STATUS");
					curr_level		  =rs2.getString("CURR_LEVEL");
					hdr_modified_dt=rs2.getString("MODIFIED_DATE");
				}
				if(stage_no1.equals("1")){
					enc_status=L1_hdr_status;
				}else if(stage_no1.equals("2")){
					enc_status=L2_hdr_status;
				}else if(stage_no1.equals("3")){
					enc_status=L3_hdr_status;
				}
				if(pstmt2!=null)pstmt2.close();
				if(rs2!=null)rs2.close();
				if(stage_no1.equals("2")){
					if(L2_hdr_status.equals("P") && L3_hdr_status.equals("P")){
						if(L1_hdr_status.equals("A")){
							L2_hdr_status="A";
						}
					}
					enc_status=L2_hdr_status;	
				}else if(stage_no1.equals("3")){
					if(L3_hdr_status.equals("P")){
						if((L1_hdr_status.equals("A") && L2_hdr_status.equals("P")) || L2_hdr_status.equals("A")){
							L3_hdr_status="A";
						}
					}
					enc_status=L3_hdr_status;
				}
				if(enc_status.equals("R")){
					enc_status="S";
				}
			
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block34Bytes, _wl_block34);

			if(enc_status.equals("A"))	{
			
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(enc_line));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(FacilityId));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(m));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(L1_hdr_status));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(L2_hdr_status));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(L3_hdr_status));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(curr_level));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(enc_line));
            _bw.write(_wl_block39Bytes, _wl_block39);
}else if(enc_status.equals("C"))	{
			
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(enc_line));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(FacilityId));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(m));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(L1_hdr_status));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(L2_hdr_status));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(L3_hdr_status));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(curr_level));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(enc_line));
            _bw.write(_wl_block41Bytes, _wl_block41);

			}else if(enc_status.equals("S"))	{
			
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(enc_line));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(FacilityId));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(m));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(L1_hdr_status));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(L2_hdr_status));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(L3_hdr_status));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(curr_level));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(enc_line));
            _bw.write(_wl_block41Bytes, _wl_block41);

			}else{
			
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(enc_line));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(FacilityId));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(m));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(L1_hdr_status));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(L2_hdr_status));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(L3_hdr_status));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(curr_level));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(enc_line));
            _bw.write(_wl_block39Bytes, _wl_block39);
}
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(m));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(m));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(enc_line));
            _bw.write(_wl_block46Bytes, _wl_block46);
	

		} // while loop for encounter
		
            _bw.write(_wl_block47Bytes, _wl_block47);

	
		if(rs != null)rs.close();
		if(pstmt  != null)pstmt.close();

		i++;
		m++;
		n++;		
	
	}  /// for loop for pat id

	//if(rs1 != null)rs1.close();
		//if(pstmt1  != null)pstmt1.close();
	

            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(FacilityId));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(dflt_termset));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(Pat_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(Pat_sex));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(Pat_age));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(stage_no));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(Pat_familyname));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(Pat_disch));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(Pat_visit));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(Pat_los));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(Pat_name));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(Pat_dob));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(Pat_class));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(Patient_Class));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(enc_val));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(finalSelect1));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(enc_temp));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(pat_temp));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(allow_recode_diag_yn));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(allow_recode_proc_yn));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(hdr_modified_dt));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(L1_hdr_status));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(L2_hdr_status));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(L3_hdr_status));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(curr_level));
            _bw.write(_wl_block74Bytes, _wl_block74);

	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		session.removeAttribute("patientList");
		session.removeAttribute("encountertList");
		if(conn!=null){
			ConnectionManager.returnConnection(conn,request);
		}
	}
		
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Sex.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
}
