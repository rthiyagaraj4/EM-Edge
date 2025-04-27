package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.net.URLEncoder;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.*;

public final class __confirmbedsidereferralqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/ConfirmBedsideReferralQueryResult.jsp", 1742377193426L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eip/jsp/ForSplChars.jsp", 1709116911640L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\t<html>\n\t<head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eMP/js/ReferralDtls.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n <!--Added for this CRF ML-MMOH-CRF-0566-->\n\t<script>\n\tfunction closeWin(enc,patid,changefunc)\n\t{\n\t\tshowModalCurEnc(enc,patid,changefunc);\n\t}\n\tvar locn;\n\n\tasync function showModal(enc,patid,practid,IPval,sex,refid)\n\t{\t\n\t\tvar chk_jsp\t\t= document.forms[0].jsp_name.value;\n\t\tvar tot_count\t= document.forms[0].total_count.value;\n\t\tvar instl_yn\t= document.forms[0].bl_install.value;\n\t\tvar function_id = document.forms[0].function_id.value;\n\t\t\n\t\t\n\t\tif(chk_jsp==\"ConfirmBedSideReferralDetail.jsp\") \t\t\t\t\n\t\t{\t\n\t\t\tvar call_function= \"BedSideReferral\";\n\t\t\tvar retVal = \tnew String();\n\t\t\tvar dialogHeight= \"1000px\";\n\t\t\tvar dialogWidth = \"1200px\";\n\t\t\tvar dialogTop\t= \"72\";\n\t\t\tvar center = \"1\" ;\n\t\t\tvar status=\"no\";\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\tvar arguments\t= \"\" ;\n\t\t\tretVal = \tawait window.showModalDialog(\"../../eIP/jsp/PaintReferralPatientDetails.jsp?function_id=\"+function_id+\"&location_code=\"+IPval+\"&encounterId=\"+enc+\"&referralID=\"+refid+\"&patientId=\"+patid+\"&Practitioner_Id=\"+escape(practid)+\"&callfrom=IP&call_function=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&Sex=\"+sex+\"&mode=modal&bl_instal=\"+instl_yn+\"&p_service_type=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&oper_stn_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\",arguments,features);\n\n\t\t\tif(document.forms[0].called_from.value == \"CA\")\n\t\t\t{\n\t\t\t\t//parent.window.close();\n\t\t\t\tlet dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n    dialogBody.contentWindow.returnValue = retVal;\n    \n    const dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n    dialogTag.close();\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tif(tot_count >= 1)\n\t\t\t\t\tparent.frames[2].document.location.reload();\n\t\t\t\telse\n\t\t\t\t\tparent.frames[2].document.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t}\n\t\t}\n\t}\n\n\tasync function showModalCurEnc(enc,patid,changefunc)\n\t{\n\t\tvar bl_install_yn=document.forms[0].bl_install;\n\t\tvar call_function = document.forms[0].call_function.value;\n\t\tvar jsp_name=\"CurrentEncounterMain.jsp\";\n\t\tvar win_height=document.forms[0].win_height.value;\n\t\tif(win_height == \"\") \n\t\t\twin_height=\"33.4\";\n\t\tvar win_width=document.forms[0].win_width.value;\n\t\tif(win_width == \"\") \n\t\t\twin_width=\"49.8\";\n\t\tif(changefunc == \"Y\")\n\t\t\tcall_function = \"QueryDischarge\";\n\n\n\t\tvar retVal = \tnew String();\n\t\tvar dialogHeight= \"900px\";\n\t\tvar dialogWidth = \"1200px\";\n\t\tvar dialogTop\t= \"72\";\n\t\tvar center = \"1\" ;\n\t\tvar status=\"no\";\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\tvar arguments\t= \"\" ;\n\t\tretVal = await window.showModalDialog(\"../../eIP/jsp/\"+jsp_name+\"?encounterId=\"+enc+\"&bl_instal=\"+bl_install_yn.value+\"&call_function=\"+call_function+\"&patientId=\"+patid,arguments,features);\n\t\tif(retVal!=null && retVal!=\'\')\n\t\tparent.frames[2].document.location.reload();\n\t}\n\t</script>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t</head>\n\t\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n\t\t<form name=\'iplookupqueryresult\' id=\'iplookupqueryresult\'>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<script>\n\t\t\t\tif(document.getElementById(\'next\'))\n\t\t\t\t\tdocument.getElementById(\'next\').style.visibility=\'hidden\';\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<script>\n\t\t\t\tif(document.getElementById(\'next\'))\n\t\t\t\t\tdocument.getElementById(\'next\').style.visibility=\'visible\';\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\'));</script>\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<input type=\'hidden\' name=\'bl_install\' id=\'bl_install\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" >\n\t\t<input type=\'hidden\' name=\'call_function\' id=\'call_function\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" >\n\t\t<input type=\'hidden\' name=\'called_from\' id=\'called_from\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" >\n\t\t<input type=\'hidden\' name=\'dialogTop\' id=\'dialogTop\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" >\n\t\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" >\n\t\t<input type=\'hidden\' name=\'IPParamValue\' id=\'IPParamValue\' value=\"\" >\n\t\t<input type=\'hidden\' name=\'jsp_name\' id=\'jsp_name\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" >\n\t\t<input type=\'hidden\' name=\'modal\' id=\'modal\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" >\n\t\t<input type=\'hidden\' name=\'model_window\' id=\'model_window\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" >\n\t\t<input type=\'hidden\' name=\'module\' id=\'module\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" >\n\t\t<input type=\'hidden\' name=\'no_of_days\' id=\'no_of_days\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" >\n\t\t<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" >\n\t\t<input type=\'hidden\' name=\'prog_id\' id=\'prog_id\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" >\n\t\t<input type=\'hidden\' name=\'targetURL\' id=\'targetURL\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" >\n\t\t<input type=\'hidden\' name=\'total_count\' id=\'total_count\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" >\n\t\t<input type=\'hidden\' name=\'win_height\' id=\'win_height\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" >\n\t\t<input type=\'hidden\' name=\'win_width\' id=\'win_width\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" >\n\t\t</form>\n\t</body>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n</html>\n\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );
 
public String singleToDoubleQuotes(String strDB)
{
	/*
	String strModified="";
	try
	{
		if((strDB != null) ||(strDB !=""))
		{
			StringBuffer stringbuffer = new StringBuffer(strDB);
			int i = 0;
			for(int j = 0; strDB.indexOf('\'', i) != -1; j++)
			{
				i = strDB.indexOf('\'', i);
				stringbuffer.insert(i + j, "'");
				i++;
			}
			strModified=stringbuffer.toString();
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}*/
	if(strDB == null) strDB = "";
	return strDB.replaceAll("'","''");
}


	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	Connection con			= null;
	Statement stmt			= null;
	ResultSet rs			= null;
	Statement stmt2			= null;
	ResultSet rs2			= null;
	PreparedStatement pstmt	= null;
	String facility_id		= "";
	String login_user		= "";
	String oper_stn_id		= "";
	String wherecondn		= "";
	String wc_for_bed_ref	= "";
	String referred_date1	= "";
	String TO_PRACT_NAME	= "";
	String PREFERRED_TREATMENT_DATE = "";
	String PREFERRED_TREATMENT_DATE_display = "";
	String REFERRAL_PRIORITY	= "";
	String TO_SPECIALITY_CODE2	= "";
	String bl_operational		=	(String)session.getValue("bl_operational");
	facility_id					= checkForNull((String)session.getValue("facility_id"));
	login_user			= checkForNull((String)session.getValue("login_user"));
	String called_from	= checkForNull(request.getParameter("called_from"));

	oper_stn_id			= checkForNull(request.getParameter("oper_stn_id"));
	wherecondn			= checkForNull(request.getParameter("wherecondn"));

	String confirmIP	= checkForNull(request.getParameter("confirmIP"));
	String targetURL	= checkForNull(request.getParameter("targetURL"));
	String color_code_scheme= "";
	String p_service_type	=	checkForNull(request.getParameter("p_service_type"));
	String clinic_list		=	checkForNull(request.getParameter("clinic_list"), "1");
	if(clinic_list.length() == 0) clinic_list="('')";

	boolean isCnclBedSideReferralAppl = false;//Added by Thamizh selvi on 22nd Feb 2018 against ML-MMOH-CRF-1090
	boolean isBedSideReferralApplforAE = false; //Added by Arthi on 18-Nov-2022 against ML-MMOH-CRF-1978

try
{
	con = ConnectionManager.getConnection(request);
 
	isCnclBedSideReferralAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "IP", "CANCEL_BED_SIDE_REFERRAL");//Added by Thamizh selvi on 22nd Feb 2018 against ML-MMOH-CRF-1090

	isBedSideReferralApplforAE = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "BED_SIDE_REFERRAL_FOR_AE");//Added by Arthi on 18-Nov-2022 against ML-MMOH-CRF-1978
	

            _bw.write(_wl_block6Bytes, _wl_block6);

		String call_function	=	checkForNull(request.getParameter("param"));
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_service_type));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block11Bytes, _wl_block11);

	try
	{
	
	     //Below line added for this CRF ML-MMOH-CRF-0566
	   	Boolean referralRegister = CommonBean.isSiteSpecific(con, "IP", "RECNL_REFERRAL_REGISTER");	
	
		String nurs_unit_code		="";
		StringBuffer where_criteria = new StringBuffer();
		StringBuffer sql			= new StringBuffer();
		String sql2					= "";
		String class_val			= "QRYEVENSMALL";
		String whereClause		= checkForNull(request.getParameter("whereclause"));
		String from				= checkForNull(request.getParameter("from"));
		String to				= checkForNull(request.getParameter("to"));
		String soundex_type		= checkForNull(request.getParameter("soundex"));
		String no_of_days		= checkForNull(request.getParameter("no_of_days"));
		String nursing_unit_code= checkForNull(request.getParameter("nursing_unit"));
		String ref_speciality	= checkForNull(request.getParameter("ref_speciality"));
		String ref_loc_type		= checkForNull(request.getParameter("location0"));
		String ref_loc_code		= checkForNull(request.getParameter("location1"));
		String ref_priority		= checkForNull(request.getParameter("ref_priority"));
		String ref_pref_date	= checkForNull(request.getParameter("ref_pref_date"));
		if(!ref_pref_date.equals(""))
			ref_pref_date = DateUtils.convertDate(ref_pref_date,"DMY",locale,"en"); 
		String speciality_code	= checkForNull(request.getParameter("Splcode"));
		String encounter_id		= checkForNull(request.getParameter("encounter_id"));
		String practitioner_id	= checkForNull(request.getParameter("practid"));
		String from_date		= checkForNull(request.getParameter("from_date"));
		if(!from_date.equals(""))
			from_date = DateUtils.convertDate(from_date,"DMY",locale,"en"); 
		String to_date			= checkForNull(request.getParameter("to_date"));
		if(!to_date.equals(""))
			to_date = DateUtils.convertDate(to_date,"DMY",locale,"en"); 

		String patient_id		= checkForNull(request.getParameter("patient_id"));
		String gender			= checkForNull(request.getParameter("gender"));
		String name_prefix		= checkForNull(request.getParameter("name_prefix"));
		String name_suffix		= checkForNull(request.getParameter("name_suffix"));
		String first_name		= checkForNull(request.getParameter("first_name"));
		String second_name		= checkForNull(request.getParameter("second_name"));
		String third_name		= checkForNull(request.getParameter("third_name"));
		String family_name		= checkForNull(request.getParameter("family_name"));
		String ref_id			= checkForNull(request.getParameter("ref_id"));

		String searchby			=	checkForNull(request.getParameter("searchby"), "S");
		String pat_name_as_multipart_yn = checkForNull(request.getParameter("pat_name_as_multipart_yn"));
		String patient_name		="";
		String nursing_unit_short_desc="";
		String referral_id		= "";
		String practitioner_name = "";
		String prev_val			= "";
		String prev_val2		= "";
		String Sex				= "";

		name_prefix				= singleToDoubleQuotes(name_prefix);
		name_suffix				= singleToDoubleQuotes(name_suffix);
		nursing_unit_code		= singleToDoubleQuotes(nursing_unit_code);
		speciality_code			= singleToDoubleQuotes(speciality_code);
		practitioner_id			= singleToDoubleQuotes(practitioner_id);
		String jsp_name			= checkForNull(request.getParameter("jsp_name"));
		String win_height		= checkForNull(request.getParameter("win_height"));
		String dialogTop		= checkForNull(request.getParameter("dialogTop"));
		String win_width		= checkForNull(request.getParameter("win_width"));
		String modal			= checkForNull(request.getParameter("modal"));
		String module			= checkForNull(request.getParameter("module"));
		String model_window		= checkForNull(request.getParameter("model_window"));
		String function_id		= checkForNull(request.getParameter("function_id"));
		String prog_id			= checkForNull(request.getParameter("prog_id"));
		String p_practitioner_id= checkForNull(request.getParameter("practitioner_id"));
		String call_func				= checkForNull(request.getParameter("call_function"));
		wherecondn = "ADMIT_PAT_YN";
		
            _bw.write(_wl_block12Bytes, _wl_block12);

		if(whereClause.equals(""))	{
			where_criteria.append(" where facility_id='");
			where_criteria.append(facility_id);
			where_criteria.append("'");

			if(!wherecondn.equals(""))
			{
				if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
				{
					where_criteria.append(" and nursing_unit_code='");
					where_criteria.append(nursing_unit_code);
					where_criteria.append("' ");
				}
				else
				{	//Added by Arthi on 18-Nov-2022 against ML-MMOH-CRF-1978
					if(isBedSideReferralApplforAE){
					where_criteria.append(" AND EXISTS ( SELECT locn_code FROM am_os_user_locn_access_vw b WHERE b.facility_id = a.facility_id AND  b.locn_type = 'N' AND b.oper_stn_id = '"+oper_stn_id+"' AND b.appl_user_id = '"+login_user+"') ");
					}else{
					where_criteria.append(" AND EXISTS ( SELECT locn_code FROM am_os_user_locn_access_vw b WHERE b.facility_id = a.facility_id AND b.locn_code = a.nursing_unit_code AND b.locn_type = 'N' AND b.oper_stn_id = '"+oper_stn_id+"' AND b.appl_user_id = '"+login_user+"') ");
					}
				}
			}
			else
			{
				if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
				{
					where_criteria.append(" and nursing_unit_code='");
					where_criteria.append(nursing_unit_code);
					where_criteria.append("' ");
				}
			}

			if(ref_id != null && !ref_id.equals(""))
			{
				where_criteria.append(" and b.referral_id like upper('"+ref_id+"%') ");
			}

			if(speciality_code!=null && !speciality_code.equals(""))
			{
				where_criteria.append(" and specialty_code='");
				where_criteria.append(speciality_code);
				where_criteria.append("' ");
			}

			if(practitioner_id!=null && !practitioner_id.equals(""))
			{
				where_criteria.append(" and to_pract_id = '");
				where_criteria.append(practitioner_id);
				where_criteria.append("' ");
			}

			if(ref_speciality!=null && !ref_speciality.equals(""))
			{
				where_criteria.append(" and to_speciality_code = '");
				where_criteria.append(ref_speciality);
				where_criteria.append("' ");
			}

			if(ref_priority!=null && !ref_priority.equals(""))
			{
				where_criteria.append(" and referral_priority = '");
				where_criteria.append(ref_priority);
				where_criteria.append("' ");
			}

			if(ref_pref_date!=null && !ref_pref_date.equals(""))
			{
				where_criteria.append(" and trunc(preferred_treatment_date) = to_date('");
				where_criteria.append(ref_pref_date);
				where_criteria.append("' , 'dd/mm/rrrr') ");
			}

			/*Below condition modified for this CRF  Bru-HIMS-CRF-321.1 [IN:036409]*/

			if(!function_id.equals("PRACT_FOR_BEDSIDE_REFERRAL")&&!function_id.equals("CONFIRM_BEDSIDE_REFERRAL"))
			where_criteria.append(" and preferred_treatment_date <=  sysdate ");

			if(ref_loc_type!=null && !ref_loc_type.equals(""))
			{
				where_criteria.append(" and to_locn_type = '");
				where_criteria.append(ref_loc_type);
				where_criteria.append("' ");
			}

			if(ref_loc_code!=null && !ref_loc_code.equals(""))
			{
				where_criteria.append(" and to_clinic_code = '");
				where_criteria.append(ref_loc_code);
				where_criteria.append("' ");
			}
		
			if(from_date!=null && !from_date.equals(""))
			{
				where_criteria.append(" and trunc(admission_date_time) >= to_date('");
				where_criteria.append(from_date);
				where_criteria.append("' , 'dd/mm/rrrr') ");
			}	
			
			if(to_date!=null && !to_date.equals(""))
			{
				where_criteria.append(" and trunc(admission_date_time) <= to_date('");
				where_criteria.append(to_date);
				where_criteria.append("' , 'dd/mm/rrrr') ");
			}	
	

			

			if(patient_id!=null && !patient_id.equals(""))
			{
				where_criteria.append(" and a.patient_id like '");
				where_criteria.append(patient_id);
				where_criteria.append("%' ");
			}
		
			if(encounter_id != null && !encounter_id.equals(""))
			{
				where_criteria.append(" and a.encounter_id='");
				where_criteria.append(encounter_id);
				where_criteria.append("' ");
			}	
			
			if(gender!=null && !gender.equals(""))
			{
				where_criteria.append(" and a.gender='");
				where_criteria.append(gender);
				where_criteria.append("' ");
			}
			
			if(name_prefix!=null && !name_prefix.equals(""))
			{
				where_criteria.append(" and a.name_prefix='");
				where_criteria.append(name_prefix);
				where_criteria.append("' ");
			}
			
			if(name_suffix!=null && !name_suffix.equals(""))
			{
				where_criteria.append(" and a.name_suffix='");
				where_criteria.append(name_suffix);
				where_criteria.append("' ");
			}	

			if(soundex_type.equals("E"))
			{
				if(first_name!=null && !first_name.equals(""))
				{
					where_criteria.append(" and upper(ethnic_soundex(first_name)) like upper(ethnic_soundex('");
					where_criteria.append(first_name);
					where_criteria.append("')) || '%' ");
				}

				if(second_name!=null && !second_name.equals(""))
				{
					where_criteria.append(" and upper(ethnic_soundex(second_name)) like upper(ethnic_soundex('");
					where_criteria.append(second_name);
					where_criteria.append("')) || '%' ");
				}
				if(third_name!=null && !third_name.equals(""))
				{
					where_criteria.append(" and upper(ethnic_soundex(third_name)) like 	upper(ethnic_soundex('");
					where_criteria.append(third_name);
					where_criteria.append("')) || '%' ");
				}	
				if(family_name!=null && !family_name.equals(""))
				{
					String fam_name_search = "";
					if (pat_name_as_multipart_yn.equals("N"))
					{
						StringTokenizer stktok = new StringTokenizer(family_name, " ");
						if (stktok.hasMoreTokens())
							fam_name_search = stktok.nextToken();
						else
							fam_name_search = family_name;
					}
					else
						fam_name_search = family_name;
			
					where_criteria.append(" and upper(ethnic_soundex(family_name)) like upper(ethnic_soundex('");
					where_criteria.append(fam_name_search);
					where_criteria.append("')) || '%' ");
				}
			}
			else if(soundex_type.equals("G"))
			{
				if(first_name!=null && !first_name.equals(""))
				{
					where_criteria.append(" and upper(soundex(first_name)) like upper(soundex('");
					where_criteria.append(first_name);
					where_criteria.append("')) || '%' ");
				}
				if(second_name!=null && !second_name.equals(""))
				{
					where_criteria.append(" and upper(soundex(second_name)) like upper(soundex('");
					where_criteria.append(second_name);
					where_criteria.append("')) || '%' ");
				}
				if(third_name!=null && !third_name.equals(""))
				{
					where_criteria.append(" and upper(soundex(third_name)) like upper(soundex('");
					where_criteria.append(third_name);
					where_criteria.append("')) || '%' ");
				}
				if(family_name!=null && !family_name.equals(""))
				{
					String fam_name_search = "";
					if (pat_name_as_multipart_yn.equals("N"))
					{
						StringTokenizer stktok = new StringTokenizer(family_name, " ");
						if (stktok.hasMoreTokens())
							fam_name_search = stktok.nextToken();
						else
							fam_name_search = family_name;
					}
					else
						fam_name_search = family_name;
					where_criteria.append(" and upper(soundex(family_name)) like upper(soundex('");
					where_criteria.append(fam_name_search);
					where_criteria.append("')) || '%' ");
				}
			}
			else
			{
				if (pat_name_as_multipart_yn.equals("Y"))
				{
					if(first_name!=null && !first_name.equals(""))
					{
						where_criteria.append(" and upper(b.first_name) like upper('");
						where_criteria.append(first_name);
						where_criteria.append("') || '%' ");
					}
					if(second_name!=null && !second_name.equals(""))
					{
						where_criteria.append(" and upper(b.second_name) like upper('" );
						where_criteria.append(second_name);
						where_criteria.append("') || '%' ");
					}
					if(third_name!=null && !third_name.equals(""))
					{
						where_criteria.append(" and upper(b.third_name) like upper('");
						where_criteria.append(third_name);
						where_criteria.append("') || '%' ");
					}
					if(family_name!=null && !family_name.equals(""))
					{
						where_criteria.append(" and upper(b.family_name) like upper('" );
						where_criteria.append(family_name);
						where_criteria.append("') || '%' ");
					}
				}
				else
				{						
					if (searchby.equals("C"))
					{
						if(!family_name.equals(""))
						{
							where_criteria.append(" and upper(a.family_name) like '%' || upper('");
							where_criteria.append(family_name);
							where_criteria.append("') || '%' ");
						}
					}
					else if (searchby.equals("E"))
					{
						if(!family_name.equals(""))
						{
							where_criteria.append(" and upper(a.family_name) like '%' || upper('");
							where_criteria.append(family_name);
							where_criteria.append("') ");			  			
						}
					}
					else
					{
						if(!family_name.equals(""))
						{
							where_criteria.append(" and upper(a.family_name) like upper('");
							where_criteria.append(family_name);
							where_criteria.append("') || '%' ");
						}
					}
				}
			}
			if( p_practitioner_id!=null && !p_practitioner_id.equals(""))
			{
				where_criteria.append(" and (practitioner_id ='");
				where_criteria.append( p_practitioner_id);
				where_criteria.append("'  ");
				where_criteria.append(" or encounter_id in ");
				where_criteria.append("(select encounter_id  ");
				where_criteria.append("  from pr_encounter_pract ");
				where_criteria.append(" where operating_facility_Id= '");
				where_criteria.append(facility_id);
				where_criteria.append("'  ");
				where_criteria.append(" and practitioner_id= '");
				where_criteria.append(p_practitioner_id);
				where_criteria.append("' )) ");
			}

			if( clinic_list.length() >= 4)	{
				where_criteria.append(" and nursing_unit_code in ");
				where_criteria.append(clinic_list);
				where_criteria.append("");
			}
		}
		else
		{
			where_criteria.append( whereClause) ;
		}
		int start = 0 ;
		int end = 0 ;
		int i=1;

		if (from.equals("")){
			start = 1 ;
		}else{
			start = Integer.parseInt( from ) ;
		}

		if (to.equals("")){
			end = 12 ;
		}else{
			end = Integer.parseInt( to ) ;
		}

		//wc_for_bed_ref = " and bedside_referral_yn = 'Y' and bedside_ref_seen_date is null and a.facility_id = b.from_facility_id and a.encounter_id = b.from_encounter_id ";
         /*Above line commented and below line added for this CRF HSA-CRF-146.1*/
		//Below line added for this CRF ML-MMOH-CRF-0566
		if(referralRegister){
		     wc_for_bed_ref = " and bedside_referral_yn = 'Y' and status not in('C','X') and a.facility_id = b.from_facility_id and a.encounter_id = b.from_encounter_id ";
        }else{
             wc_for_bed_ref = " and bedside_referral_yn = 'Y' and status!='C' and a.facility_id = b.from_facility_id and a.encounter_id = b.from_encounter_id ";
		}
		//End this CRF ML-MMOH-CRF-0566
		
		int maxRecord = 0;

		if(sql.length() > 0)	sql.delete(0, sql.length());	
		
		/*Modified by Arthi on 18-Nov-2022 against ML-MMOH-CRF-1978 */
		if(isBedSideReferralApplforAE){
		sql.append(" select b.referral_id, a.encounter_id, c.sex gender, a.ASSIGN_CARE_LOCN_CODE nursing_unit_code, am_get_desc.am_practitioner(a.attend_practitioner_id, '"+locale+"', 1) practitioner_short_name, a.patient_id, decode('"+locale+"','en',c.patient_name, nvl(c.patient_name_loc_lang, c.patient_name))patient_name, ip_get_desc.ip_nursing_unit(a.facility_id, a.ASSIGN_CARE_LOCN_CODE, '"+locale+"', 2) nursing_unit_short_desc, a.attend_practitioner_id practitioner_id, to_char(b.REFERRAL_DATE, 'dd/mm/rrrr') referred_date1, am_get_desc.am_practitioner(b.to_pract_id, '"+locale+"', 1) to_pract_name, to_char(b.preferred_treatment_date, 'dd/mm/rrrr') preferred_treatment_date, am_get_desc.am_speciality(b.to_speciality_code, '"+locale+"', 2) to_speciality_code2, b.referral_priority ");
		}else{
		sql.append(" select b.referral_id, a.encounter_id, c.sex gender, a.nursing_unit_code, am_get_desc.am_practitioner(a.attend_practitioner_id, '"+locale+"', 1) practitioner_short_name, a.patient_id, decode('"+locale+"','en',c.patient_name, nvl(c.patient_name_loc_lang, c.patient_name))patient_name, ip_get_desc.ip_nursing_unit(a.facility_id, a.nursing_unit_code, '"+locale+"', 2) nursing_unit_short_desc, a.attend_practitioner_id practitioner_id, to_char(b.REFERRAL_DATE, 'dd/mm/rrrr') referred_date1, am_get_desc.am_practitioner(b.to_pract_id, '"+locale+"', 1) to_pract_name, to_char(b.preferred_treatment_date, 'dd/mm/rrrr') preferred_treatment_date, am_get_desc.am_speciality(b.to_speciality_code, '"+locale+"', 2) to_speciality_code2, b.referral_priority ");
		}
		/*Added by Thamizh selvi on 22nd Feb 2018 against ML-MMOH-CRF-1090 Start*/
		if(isCnclBedSideReferralAppl && function_id.equals("CONFIRM_BEDSIDE_REFERRAL"))
			if(isBedSideReferralApplforAE){
			sql.append(", b.from_encounter_id, b.preferred_treatment_date pref_ord_by, a.VISIT_ADM_DATE_TIME adm_date_ord_by ");
			}else{
			sql.append(", b.from_encounter_id, b.preferred_treatment_date pref_ord_by, a.admission_date_time adm_date_ord_by ");
			}
		/*End*/
		if(isBedSideReferralApplforAE){
		sql.append(" FROM PR_ENCOUNTER_VW a, PR_REFERRAL_REGISTER b, MP_PATIENT c "+where_criteria.toString()+" "+wc_for_bed_ref+" ");
		}else{
		sql.append(" FROM IP_OPEN_ENCOUNTER a, PR_REFERRAL_REGISTER b, MP_PATIENT c "+where_criteria.toString()+" "+wc_for_bed_ref+" ");
		}
		sql.append(" and a.patient_id = c.patient_id ");
		
		
		if(function_id.equals("CONFIRM_BEDSIDE_REFERRAL")){
			sql.append(" and to_pract_id is not null ");
		}else if(function_id.equals("PRACT_FOR_BEDSIDE_REFERRAL")){
			sql.append(" and to_pract_id is null ");
		}
		
		/*Added by Thamizh selvi on 22nd Feb 2018 against ML-MMOH-CRF-1090 Start*/
		if(isCnclBedSideReferralAppl){
			if(function_id.equals("CONFIRM_BEDSIDE_REFERRAL")){
				sql.append("UNION ALL SELECT b.referral_id, a.encounter_id, c.sex gender, a.nursing_unit_code, am_get_desc.am_practitioner (a.attend_practitioner_id, '"+locale+"', 1 ) practitioner_short_name, a.patient_id, DECODE ('"+locale+"', 'en', c.patient_name, NVL (c.patient_name_loc_lang, c.patient_name) ) patient_name, ip_get_desc.ip_nursing_unit (a.facility_id, a.nursing_unit_code, '"+locale+"', 2 ) nursing_unit_short_desc, a.attend_practitioner_id practitioner_id, TO_CHAR (b.referral_date, 'dd/mm/rrrr') referred_date1, am_get_desc.am_practitioner (b.to_pract_id, '"+locale+"', 1) to_pract_name, TO_CHAR (b.preferred_treatment_date, 'dd/mm/rrrr' ) preferred_treatment_date, am_get_desc.am_speciality (b.to_speciality_code, '"+locale+"', 2 ) to_speciality_code2, b.referral_priority, b.from_encounter_id, b.preferred_treatment_date pref_ord_by, a.admission_date_time adm_date_ord_by FROM ip_open_encounter a, pr_referral_register b, mp_patient c, sm_appl_user d "+where_criteria.toString()+" "+wc_for_bed_ref+" AND a.patient_id = c.patient_id AND d.appl_user_id ='"+login_user+"' AND b.from_pract_id = d.func_role_id AND b.to_pract_id IS NULL");
		
				sql.append("  order by from_encounter_id, pref_ord_by, adm_date_ord_by, practitioner_short_name ");
			}else{
				if(isBedSideReferralApplforAE){
				sql.append("  order by from_encounter_id, to_date(preferred_treatment_date, 'dd/mm/rrrr hh24:mi'), to_date(VISIT_ADM_DATE_TIME, 'dd/mm/rrrr hh24:mi'), practitioner_short_name, VISIT_ADM_DATE_TIME ");
				}else{
				sql.append("  order by from_encounter_id, to_date(preferred_treatment_date, 'dd/mm/rrrr hh24:mi'), to_date(admission_date_time, 'dd/mm/rrrr hh24:mi'), practitioner_short_name, admission_date_time ");
				}
			}
		}else{
			if(isBedSideReferralApplforAE){
			sql.append("  order by from_encounter_id, to_date(preferred_treatment_date, 'dd/mm/rrrr hh24:mi'), to_date(VISIT_ADM_DATE_TIME, 'dd/mm/rrrr hh24:mi'), practitioner_short_name, VISIT_ADM_DATE_TIME ");
			}else{
			sql.append("  order by from_encounter_id, to_date(preferred_treatment_date, 'dd/mm/rrrr hh24:mi'), to_date(admission_date_time, 'dd/mm/rrrr hh24:mi'), practitioner_short_name, admission_date_time ");
			}
		}/*End*/
		
		
//		stmt = con.createStatement();		
//rs= stmt.executeQuery(sql.toString());
		pstmt  = con.prepareStatement(sql.toString());
		rs		   = pstmt.executeQuery();

		if ( start != 1 ){
			for( int j=1; j<start; i++,j++ ){
				rs.next();
			}
		}
		while( rs!=null &&  i<=end && rs.next()) {
			if(maxRecord==0){
					out.println("<table align='right'><tr>");
					if ( !(start <= 1) ){
						out.println("<td id='prev'><A HREF='../jsp/ConfirmBedsideReferralQueryResult.jsp?jsp_name="+jsp_name+"&win_height="+win_height+"&win_width="+win_width+"&dialogTop="+dialogTop+"&param="+call_function+"&no_of_days="+no_of_days+"&modal="+modal+"&from="+(start-12)+"&to="+(end-12)+"&function_id="+function_id+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"&targetURL="+targetURL+"&confirmIP="+URLEncoder.encode(confirmIP)+"&call_function="+ URLEncoder.encode(call_func) + "'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
					}
					out.println("<td id='next' style='visibility:hidden'><A HREF='../../eIP/jsp/ConfirmBedsideReferralQueryResult.jsp?jsp_name="+jsp_name+"&win_height="+win_height+"&win_width="+win_width+"&dialogTop="+dialogTop+"&param="+call_function+"&no_of_days="+no_of_days+"&modal="+modal+"&from="+(start+12)+"&to="+(end+12)+"&function_id="+function_id+"&whereclause="+URLEncoder.encode(where_criteria.toString())+  "&targetURL="+targetURL+"&confirmIP="+URLEncoder.encode(confirmIP)+"&call_function="+ URLEncoder.encode(call_func) +"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
					out.println("</tr></table></p>");
					out.println("<br><br>");				
					out.println(" <table cellspacing=0 cellpadding=0 align='center' width='100%' border='1'>");
					out.println("<tr>");
					out.println("<th></th>");
					out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referralid.label","common_labels")+"</th>");
					out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PreferredDate.label","common_labels")+"</th>");
					out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+"</th>");
					out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+"</th>");
					out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+"</th>");
					out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReferredOn.label","common_labels")+"</th>");
					out.println("</tr>");
			}
					try{
							referred_date1 = rs.getString("referred_date1");
							if(referred_date1 == null) referred_date1="";
							TO_PRACT_NAME=rs.getString("TO_PRACT_NAME");
							if(TO_PRACT_NAME == null) TO_PRACT_NAME="&nbsp;";
							PREFERRED_TREATMENT_DATE=rs.getString("PREFERRED_TREATMENT_DATE");
							if(PREFERRED_TREATMENT_DATE == null){
								PREFERRED_TREATMENT_DATE ="";
								PREFERRED_TREATMENT_DATE_display = "";
							}else{
								PREFERRED_TREATMENT_DATE_display = DateUtils.convertDate(PREFERRED_TREATMENT_DATE,"DMY","en",locale);
							}

							REFERRAL_PRIORITY=rs.getString("REFERRAL_PRIORITY");
							if(REFERRAL_PRIORITY == null){ 
								REFERRAL_PRIORITY="";
							}else if (REFERRAL_PRIORITY.equals("L")){
								REFERRAL_PRIORITY = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.elective.label","common_labels");
							}else if (REFERRAL_PRIORITY.equals("U")){
								REFERRAL_PRIORITY = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.semiemergency.label","common_labels");
							}else if (REFERRAL_PRIORITY.equals("E")){
								REFERRAL_PRIORITY = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
							}
							TO_SPECIALITY_CODE2=rs.getString("TO_SPECIALITY_CODE2");
							if(TO_SPECIALITY_CODE2 == null){ TO_SPECIALITY_CODE2="";}
							encounter_id=rs.getString("encounter_id");
							if(encounter_id == null){encounter_id="";}
							referral_id=rs.getString("referral_id");
							if(referral_id == null){referral_id="";}
							Sex =rs.getString("gender");
							if(Sex == null ){
								Sex = "";
							}else if (Sex.equals("M")){
								Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
							}else if (Sex.equals("F")){
								Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
							}else{
								Sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
							}
							patient_id = rs.getString("patient_id");
							if( patient_id == null){ patient_id="";}
							patient_name=rs.getString("patient_name");
							if ((patient_name == null) || (patient_name.equals("null"))) {
								patient_name="";
							}
							nurs_unit_code =rs.getString("nursing_unit_code");
							if( nurs_unit_code == null){nurs_unit_code="";}
							nursing_unit_short_desc=rs.getString("nursing_unit_short_desc");
							if(nursing_unit_short_desc== null){nursing_unit_short_desc="";}
							practitioner_id=rs.getString("practitioner_id");
							if(practitioner_id == null){practitioner_id="";}
							practitioner_name=rs.getString("practitioner_short_name");
							if((practitioner_name == null) || (practitioner_name.equals("null"))){
									practitioner_name="";
							}
					}catch(SQLException e){
						e.printStackTrace();
					}
					if(class_val.equals("QRYEVENSMALL")){
						class_val = "QRYODDSMALL";
					}else{
						class_val = "QRYEVENSMALL";
					}
					out.println("<tr>");
					if(!(jsp_name.equals("") && modal.equals(""))){
						if(!prev_val.equals(patient_id)|| !prev_val2.equals(encounter_id)){
							sql2  = " select get_patient.get_line_detail('"+facility_id+"','"+encounter_id+"','"+locale+"') display_pline_details from dual ";
							stmt2 = con.createStatement();
							rs2	= stmt2.executeQuery(sql2);
							String display_pline= "";
							if(rs2!=null && rs2.next()){
								display_pline = rs2.getString("display_pline_details");
							}
							if(rs2 != null)	rs2.close();
							if(stmt2 != null)stmt2.close();
							String disp_value1 = patient_id;
							if (!patient_name.equals("")){
								disp_value1 = disp_value1+"/"+patient_name;
							}
							if (!Sex.equals("")){
								disp_value1 = disp_value1+"/"+Sex;
							}
							if (!encounter_id.equals("")){
								disp_value1 = disp_value1+"/"+encounter_id;
							}
							if (!patient_id.equals("")){
								disp_value1 = disp_value1+"/"+nursing_unit_short_desc;
							}
							out.println("<td class='CAGROUPHEADING' colspan='9' align='left'>"+display_pline+"</td></tr><tr>");
						}
						out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap> ");
						out.print("<a href=\"javascript:closeWin('"+encounter_id+"','"+patient_id+"','N')\">");
						out.print("+</a></td>" );
						out.println("<td class='"+class_val+"' align='left'><a href=\"javascript:showModal('"+encounter_id+"','"+patient_id+"','"+practitioner_id+"','"+nurs_unit_code+"','"+Sex+"','"+referral_id+"')\">"+referral_id+"</a></td>");
						out.println("<td class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>" +PREFERRED_TREATMENT_DATE_display+ "</td>");
					}
					out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' >"+REFERRAL_PRIORITY+"</td>");
					out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' >"+TO_SPECIALITY_CODE2+"</td>");
					out.println("<td  class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"+TO_PRACT_NAME+"</td>");
					out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"' nowrap>"  +DateUtils.convertDate(referred_date1,"DMY","en",locale)+"</td>");
					out.println("</tr>");
					prev_val=patient_id;
					prev_val2=encounter_id;
					i++;
					maxRecord++;
			}

		out.println("</table>");
		
		if(maxRecord<12 || (!rs.next()))
		{
            _bw.write(_wl_block13Bytes, _wl_block13);

		}
		else
		{
            _bw.write(_wl_block14Bytes, _wl_block14);

		}

		if(maxRecord == 0){	
            _bw.write(_wl_block15Bytes, _wl_block15);
	
		}

		if(rs != null)				rs.close();
		if(stmt != null)			stmt.close();
		if(pstmt != null)			pstmt.close();
		
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bl_operational));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(dialogTop));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(modal));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(model_window));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(module));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(no_of_days));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(p_practitioner_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(prog_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(targetURL));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(win_height));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(win_width));
            _bw.write(_wl_block32Bytes, _wl_block32);
	}catch(Exception e)
	{
		out.println("Exception in ConfirmBedsideReferralQueryResult.jsp :"+e.getMessage());
		out.println(e);
		e.printStackTrace();
	}
	finally
	{
		if(rs != null)				rs.close();
		if(stmt != null)			stmt.close();
		out.print("<script>if(parent.frames[1].document.forms[0]!= null)");	out.print("parent.frames[1].document.forms[0].search.disabled=false</script>");
	}

}catch(Exception e)
{ 
	out.println("Error in ConfirmBedsideReferralQueryResult : "+e.toString());
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}	

            _bw.write(_wl_block33Bytes, _wl_block33);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
