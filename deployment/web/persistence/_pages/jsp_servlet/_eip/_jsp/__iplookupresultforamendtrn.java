package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import java.net.*;
import com.ehis.util.*;

public final class __iplookupresultforamendtrn extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/IPLookupResultForAmendTrn.jsp", 1742387619879L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eip/jsp/ForSplChars.jsp", 1709116911640L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eIP/js/BlockBed.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<script>\n\nfunction closeWin(enc,patid)\n{\n\tshowModalCurEnc(enc,patid);\t\t\t\t\n}\n\nasync function showModal(enc,patid,bkgref)\n{\n\tif( document.forms[0].modal.value != \'yes\')\n\t{ \n\t\tvar oper_stn_id=document.forms[0].oper_stn_id.value;\n\t\tvar routine_tfr_yn=document.forms[0].routine_tfr_yn.value;\n\t\tvar bed_block_period_max_int=document.forms[0].bed_block_period_max_int.value;\n\t\tvar sydate=document.forms[0].sydate.value;\n\t\tvar priority_applicable_yn=document.forms[0].priority_applicable_yn.value;\n\t\tvar change_bed_class_yn=document.forms[0].change_bed_class_yn.value;\n\t\tvar deactivate_pseudo_bed_yn=document.forms[0].deactivate_pseudo_bed_yn.value;\n\t\tvar bl_interfaced_yn=document.forms[0].bl_interfaced_yn.value;\n\t\tvar bed_block_period_max_type=document.forms[0].bed_block_period_max_type.value;\n\t\tvar tot_count=document.forms[0].total_count.value;\n\t\tvar jsp_name=document.forms[0].jsp_name.value;\n\t\tvar function_id=document.forms[0].function_id.value;\n\t\t\n\t\tvar win_height=document.forms[0].win_height.value;\n\t\tif(win_height == \"\") win_height=\"27\";\n\t\tvar dialogTop=document.forms[0].dialogTop.value;\n\t\tif(dialogTop == \"\") dialogTop=\"80\";\n\t\tvar win_width=document.forms[0].win_width.value;\n\t\tif(win_width == \"\") win_width=\"40\";\n\t\tvar module=document.forms[0].module.value;\n\t\tif(module == \"\") module=\"eIP\";\n\t\tvar model_window=document.forms[0].model_window.value;\n\t\tif( model_window == \"\") model_window =\"\";\n\t\t\n\t\tif( model_window == \'N\')\n\t\t{\n\t\t\tparent.frames[3].document.location.href=\"../../\"+module+\"/jsp/\"+jsp_name+\"?encounterId=\"+enc+\"&patientId=\"+patid+\"&Practitioner_Id=\"+practid+\"&callfrom=IP&function_id=\"+function_id;\n\t\t}\n\t\telse\n\t\t{\tvar retVal = \tnew String();\n\t\t\tvar dialogHeight= \"1000px\" ;\n\t\t\tvar dialogWidth\t= \"1200px\" ;\n\t\t\tvar dialogTop = \"30px\";\n\t\t\tvar center = \"1\" ;\n\t\t\tvar status=\"no\";\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\tvar arguments\t= \"\" ;\t\t\t\t\n\t\t\tretVal = await top.window.showModalDialog(\"../../\"+module+\"/jsp/\"+jsp_name+\"?encounterId=\"+enc+\"&patientId=\"+patid+\"&booking_ref_no=\"+bkgref+\"&oper_stn_id=\"+oper_stn_id+\"&routine_tfr_yn=\"+routine_tfr_yn+\"&bed_block_period_max_int=\"+bed_block_period_max_int+\"&sydate=\"+sydate+\"&priority_applicable_yn=\"+priority_applicable_yn+\"&change_bed_class_yn=\"+change_bed_class_yn+\"&deactivate_pseudo_bed_yn=\"+deactivate_pseudo_bed_yn+\"&bl_interfaced_yn=\"+bl_interfaced_yn+\"&bed_block_period_max_type=\"+bed_block_period_max_type+\"&function_id=\"+function_id,arguments,features);\n\t\t\t\n\t\t\tif(tot_count >= 1)\n\t\t\t{\n\t\t\t\tparent.frames[2].document.location.reload();\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tparent.frames[2].document.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t}\n\t\t}\n\t}\n\telse\n\t{\n\t\twindow.parent.returnValue=enc;\n\t\twindow.parent.close();\n\t}\n}\n\t\t\t\nasync function showModalCurEnc(enc,patid)\n{\n\tvar jsp_name=\"CurrentEncounterMain.jsp\";\n\t//var win_height=document.forms[0].win_height.value;\n\t\n\t win_height=\"400px\";\n\t//var win_width=document.forms[0].win_width.value;\n\t win_width=\"900px\";\n\tvar retVal = \tnew String();\n\tvar dialogHeight= win_height ;\n\tvar dialogWidth\t= win_width ;\n\tvar dialogTop = \"80\" ;\n\tvar center = \"1\" ;\n\tvar status=\"no\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\tvar arguments\t= \"\" ;\t\t\t\t\n\tretVal = await window.showModalDialog(\"../../eIP/jsp/\"+jsp_name+\"?encounterId=\"+enc+\"&patientId=\"+patid,arguments,features);\n\tparent.frames[2].document.location.reload();\t\t\t\t\n}\n\n</script>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n</head>\t\t\t\t\t\t\t\n<body onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n<form name=\'iplookupqueryresult\' id=\'iplookupqueryresult\'>\n\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t\t<script >\n\t\t\t\t\t\tif (document.getElementById(\'next\'))\n\t\t\t\t\t\t\tdocument.getElementById(\'next\').style.visibility=\'hidden\';\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t<script >\n\t\t\t\t\t\tif (document.getElementById(\'next\'))\n\t\t\t\t\t\t\tdocument.getElementById(\'next\').style.visibility=\'visible\';\n\t\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<input type=\'hidden\' name=\'total_count\' id=\'total_count\' value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" >\n\t\t<input type=\'hidden\' name=\'jsp_name\' id=\'jsp_name\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' >\n\t\t<input type=\'hidden\' name=\'win_height\' id=\'win_height\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' >\n\t\t<input type=\'hidden\' name=\'win_width\' id=\'win_width\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' >\n\t\t<input type=\'hidden\' name=\'dialogTop\' id=\'dialogTop\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' >\n\t\t<input type=\'hidden\' name=\'modal\' id=\'modal\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' >\n\t\t<input type=\'hidden\' name=\'module\' id=\'module\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' >\n\t\t<input type=\'hidden\' name=\'model_window\' id=\'model_window\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' >\n\t\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' >\n\t\t<input type=\'hidden\' name=\'call_function\' id=\'call_function\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' >\n\t\t<input type=\'hidden\' name=\'prog_id\' id=\'prog_id\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' >\n\t\t<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' >\n\t\t<!-- // Added by Sridhar R on Mar 11 2005.. for passing parameters to frame page...-->\n\t\t<input type=\'hidden\' name=\'oper_stn_id\' id=\'oper_stn_id\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\t\t<input type=\'hidden\' name=\'routine_tfr_yn\' id=\'routine_tfr_yn\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t\t<input type=\'hidden\' name=\'bed_block_period_max_int\' id=\'bed_block_period_max_int\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t\t<input type=\'hidden\' name=\'sydate\' id=\'sydate\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t\t<input type=\'hidden\' name=\'priority_applicable_yn\' id=\'priority_applicable_yn\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t<input type=\'hidden\' name=\'change_bed_class_yn\' id=\'change_bed_class_yn\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t<input type=\'hidden\' name=\'deactivate_pseudo_bed_yn\' id=\'deactivate_pseudo_bed_yn\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t\t<input type=\'hidden\' name=\'bl_interfaced_yn\' id=\'bl_interfaced_yn\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\t\t<input type=\'hidden\' name=\'bed_block_period_max_type\' id=\'bed_block_period_max_type\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t\t<input type=\'hidden\' name=\'sStyle\' id=\'sStyle\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\n\t</form>\t\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n</html>\n\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );
 
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
 request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 
String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
String locale = (String)session.getAttribute("LOCALE");

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	Connection con		= null;
	Statement stmt		= null;
	ResultSet rs		= null;
	String colspan		= "12";

try
{
	con = ConnectionManager.getConnection(request);
	String facility_id				= (String)session.getValue("facility_id");
	String login_user				= (String)session.getValue("login_user");
	String oper_stn_id				= checkForNull(request.getParameter("oper_stn_id"));
	String routine_tfr_yn			= checkForNull(request.getParameter("routine_tfr_yn"),"N");
	String bed_block_period_max_str	= checkForNull(request.getParameter("bed_block_period_max_int"));
	String sydate					= checkForNull(request.getParameter("sydate"));
	String priotity_status			= checkForNull(request.getParameter("priority_applicable_yn"),"N");
	String bed_class_allowed		= checkForNull(request.getParameter("change_bed_class_yn"),"N");
	String deactivate_pseudo_bed_yn	= checkForNull(request.getParameter("deactivate_pseudo_bed_yn"),"N");
	String bl_interfaced_yn			= checkForNull(request.getParameter("bl_interfaced_yn"),"N");
	String bed_block_period_max_type= checkForNull(request.getParameter("bed_block_period_max_type"));
	String loc_lang					= checkForNull(request.getParameter("loc_lang"));
	int bed_block_period_max_int	= 0;
	String adm_date_display			= "";
	if(! bed_block_period_max_str.equals(""))
		bed_block_period_max_int	= Integer.parseInt(bed_block_period_max_str);

	StringBuffer finalSql				= new StringBuffer();
	StringBuffer where_criteria			= new StringBuffer();
	String admission_date_time			= "";
	String spcl_prev_val				= "";
	String pract_prev_val				= "";
	String priority_desc				= "";
	String soundex_function				= "";	
	String sql							= "";
	String patient_name					= "";
	String fr_nursing_unit_short_desc	= "";
	String specialty_short_desc			= "";
	String practitioner_name			= "";
	String prev_val						= "";
	String prev_val2					= "";
	String booking_ref_no				= "";
	String priority						= "";
	String gender						= ""; 
	String room_no						= ""; 
	String bed_class_short_desc			= ""; 
	String bed_type_short_desc			= ""; 
	String bed_no						= "";

	String to_nursing_unit_short_desc	= "";
	String to_practitioner_name			= "";
	String to_specialty_short_desc		= "";
	String to_subservice_short_desc		= "";
	String to_bed_no					= "";
	String to_room_no					= "";
	String to_bed_class_short_desc		= "";
	String to_bed_type_short_desc		= "";
	String current_location_desc		= "";

	String class_val		= "QRYEVENSMALL";
	String class_value		= "QRYEVENSMALL";
    
	Boolean isCurrentLocDtlsAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"IP","CURNT_LOC_DTLS_APPL");//Added by Shanmukh on 25th-JULY-2018 for ML-MMOH-CRF-1113

	String whereClause		= request.getParameter("whereclause");
	String from				= checkForNull(request.getParameter("from"));
	String to				= checkForNull(request.getParameter("to"));
	String soundex_type		= checkForNull(request.getParameter("soundex"));
	String from_nursing_unit= request.getParameter("from_nursing_unit");
	String nursing_unit_code= request.getParameter("nursing_unit");
	String from_Splcode		= request.getParameter("from_Splcode");	
	String speciality_code	= request.getParameter("Splcode");	
	String encounter_id		= request.getParameter("encounter_id");
	String from_practid		= request.getParameter("from_practid");
	String practitioner_id	= request.getParameter("practid");
	String patient_id		= request.getParameter("patient_id");
	String sex				= checkForNull(request.getParameter("gender"));
	String name_prefix		= checkForNull(request.getParameter("name_prefix"));
	String name_suffix		= checkForNull(request.getParameter("name_suffix"));
	if(name_prefix!=null && !name_prefix.equals(""))
	name_prefix				= singleToDoubleQuotes(name_prefix);
   
	if(name_suffix!=null && !name_suffix.equals(""))
	name_suffix				= singleToDoubleQuotes(name_suffix);
	String first_name		= checkForNull(request.getParameter("first_name"));
	String second_name		= checkForNull(request.getParameter("second_name"));
	String third_name		= checkForNull(request.getParameter("third_name"));
	String family_name		= checkForNull(request.getParameter("family_name"));
	String werecondn		= checkForNull(request.getParameter("wherecondn"));
	String to_nursing_unit	= checkForNull(request.getParameter("to_nursing_unit"));
	String transfer_type	= checkForNull(request.getParameter("transfer_type"));
	String jsp_name			= checkForNull(request.getParameter("jsp_name"));
	String win_height		= checkForNull(request.getParameter("win_height"));
	String dialogTop		= checkForNull(request.getParameter("dialogTop"));
	String win_width		= checkForNull(request.getParameter("win_width"));
	String call_function	= checkForNull(request.getParameter("param"));
	String modal			= checkForNull(request.getParameter("modal"));
	String module			= checkForNull(request.getParameter("module"));
	String model_window		= checkForNull(request.getParameter("model_window"));
	String function_id		= checkForNull(request.getParameter("function_id"));
	String prog_id			= checkForNull(request.getParameter("prog_id"));
	String p_practitioner_id= checkForNull(request.getParameter("practitioner_id"));
	String call_func		= checkForNull(request.getParameter("call_function"));
	String p_oper_stn_id	= checkForNull(request.getParameter("operStation"));
	String from_date			=	checkForNull(request.getParameter("from_date"));
	String to_date				=	checkForNull(request.getParameter("to_date"));

	if(!(from_date==null || from_date.equals("")))
		from_date = DateUtils.convertDate(from_date,"DMY",locale,"en");

	if(!(to_date==null || to_date.equals("")))
		to_date = DateUtils.convertDate(to_date,"DMY",locale,"en");



            _bw.write(_wl_block4Bytes, _wl_block4);



		if(whereClause==null)
		{
			if(!soundex_type.equals(""))
			{
				if(soundex_type.equals("E"))
					soundex_function = "ethnic_soundex";
				else
					soundex_function = "soundex";
			}
			
			if(where_criteria.length() > 0) where_criteria.delete(0,where_criteria.length());
			where_criteria.append(" where a.facility_id='"+facility_id+"'");


			if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
			{
				if(function_id.equals("CANCEL_TRANS_BOOKING"))
				{
					//where_criteria.append(" and B.NURSING_UNIT_CODE='"+nursing_unit_code+"' ");
					where_criteria.append(" and REQ_NURSING_UNIT_CODE='"+nursing_unit_code+"' ");
				}
				else
				{
					where_criteria.append(" and REQ_NURSING_UNIT_CODE='"+nursing_unit_code+"' ");
				}
			}
			//to nursing_unit_code
			if(to_nursing_unit!=null && !to_nursing_unit.equals(""))
				where_criteria.append(" and nursing_unit_code='"+to_nursing_unit+"' ");

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

			//speciality_code
			if(speciality_code!=null && !speciality_code.equals(""))
			{
				if(function_id.equals("CANCEL_TRANS_BOOKING"))
				{
					//where_criteria.append(" and SPECIALTY_CODE='"+speciality_code+"' ");
					where_criteria.append(" and REQ_SPECIALTY_CODE='"+speciality_code+"' ");
				}
				else
				{
					where_criteria.append(" and REQ_SPECIALTY_CODE='"+speciality_code+"' ");				
				}
			}

			if(from_nursing_unit != null && !from_nursing_unit.equals(""))
			{
				where_criteria.append(" and B.NURSING_UNIT_CODE = '"+from_nursing_unit+"' ");				
			}

			if(from_Splcode != null && !from_Splcode.equals(""))
			{
				where_criteria.append(" and SPECIALTY_CODE = '"+from_Splcode+"' ");				
			}

			//practitioner_id
			if(practitioner_id!=null && !practitioner_id.equals(""))
			{
				if(function_id.equals("CANCEL_TRANS_BOOKING"))
				{
					where_criteria.append(" and REQ_PRACTITIONER_ID='"+practitioner_id+"' ");				
				}
				else
				{
					where_criteria.append(" and REQ_PRACTITIONER_ID='"+practitioner_id+"' ");				
				}
			}


			if(from_practid != null && !from_practid.equals(""))
			{
				where_criteria.append(" and ATTEND_PRACTITIONER_ID = '"+from_practid+"' ");				
			}

			//patient_id
			if(patient_id!=null && !patient_id.equals(""))
				where_criteria.append(" and a.patient_id like '"+patient_id+"%' ");
			//encounter_id
			if(encounter_id != null && !encounter_id.equals(""))
			where_criteria.append(" and a.encounter_id like '"+encounter_id+"%' ");
			//transfer_type
			if(transfer_type != null && !transfer_type.equals(""))
				where_criteria.append(" and a.TFR_REQ_REASON='"+transfer_type+"' ");
			//gender
			if(sex!=null && !sex.equals(""))
				where_criteria.append(" and sex = '"+sex+"' ");
			//name_prefix
			
			if(name_prefix!=null && !name_prefix.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append(" and name_prefix='"+name_prefix+"' ");
				else
					where_criteria.append(" and NAME_PREFIX_LOC_LANG='"+name_prefix+"' ");
			}
			//name_suffix
			if(name_suffix!=null && !name_suffix.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append(" and name_suffix='"+name_suffix+"' ");
				else
					where_criteria.append(" and NAME_SUFFIX_LOC_LANG='"+name_suffix+"' ");
			}
			//first_name
			if(first_name!=null && !first_name.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append(" and upper  "+soundex_function+"(first_name) like upper "+soundex_function+"('"+first_name+"')  || '%' ");
				else
					where_criteria.append(" and upper  "+soundex_function+"(FIRST_NAME_LOC_LANG) like upper "+soundex_function+"('"+first_name+"')  || '%' ");
			}
			//second_name
			if(second_name!=null && !second_name.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append(" and upper  "+soundex_function+"(second_name) like upper "+soundex_function+"('"+second_name+"') || '%' ");
				else
					where_criteria.append(" and upper "+soundex_function+"(SECOND_NAME_LOC_LANG) like upper "+soundex_function+"('"+second_name+"')  || '%' ");
			}
			//third_name
			if(third_name!=null && !third_name.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append(" and upper  "+soundex_function+"(third_name) like upper "+soundex_function+"('"+third_name+"')  || '%' ");
				else
					where_criteria.append(" and upper "+soundex_function+"(THIRD_NAME_LOC_LANG) like upper "+soundex_function+"('"+third_name+"') || '%' ");
			}
			//family_name
			if(family_name!=null && !family_name.equals(""))
			{
				if(loc_lang.equals("en"))
					where_criteria.append(" and upper  "+soundex_function+"(family_name) like upper "+soundex_function+"('"+family_name+"')  || '%' ");
				else
					where_criteria.append(" and upper "+soundex_function+"(FAMILY_NAME_LOC_LANG) like upper "+soundex_function+"('"+family_name+"')  || '%' ");
			}


			if( p_practitioner_id!=null && !p_practitioner_id.equals(""))
			{
				where_criteria.append(" and (practitioner_id ='"+ p_practitioner_id +"'  ");
				where_criteria.append(" or encounter_id in ");
				where_criteria.append("(select encounter_id  ");
				where_criteria.append("  from pr_encounter_pract ");
				where_criteria.append(" where operating_facility_Id= '"+ facility_id +"'  ");
				where_criteria.append(" and practitioner_id= '"+ p_practitioner_id +"' )) ");
			}
		} 
		else
		{
			where_criteria.append(whereClause) ;
		}
		int start		= 0 ;
		int end			= 0 ;
		int maxRecord	= 0;
		int i=1;
		if (from.equals(""))
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;
		if (to.equals(""))
			end = 12 ;
		else
		end = Integer.parseInt( to ) ;

		// This new query is added for Confirm Book Bed for Patient Transfer where in based on the priority the records should be displayed.
		/*String strFrm = "";
		if(function_id.equals("CONFIRM_TRANS_BOOKING"))
			strFrm = " a.req_nursing_unit_code in";
		else
			strFrm="B.NURSING_UNIT_CODE in";

		sql  = " select count(*) from IP_TRANSFER_REQUEST a, IP_OPEN_ENCOUNTER b, MP_PATIENT c ";

		StringBuffer nurSql = new StringBuffer();
		nurSql.append(strFrm);
		nurSql.append(" (select a.nursing_unit_code from ip_nursing_unit a,AM_OS_USER_LOCN_ACCESS_VW b where a.facility_id = '"+facility_id+"' and a.facility_id =b.facility_id and a.nursing_unit_code = b.locn_code and a.eff_status='E' and b.locn_type = 'N' and b.oper_stn_id='"+p_oper_stn_id+"' and b.appl_user_id = '"+login_user+"' and b."+werecondn+" = 'Y') ");
		nurSql.append(" and ip_leave_status is null ");

		if(finalSql.length() > 0) finalSql.delete(0,finalSql.length());
		finalSql.append(sql);
		finalSql.append(where_criteria.toString());

		if(bed_class_allowed.equals("Y"))
		{
			finalSql.append(" AND a.TFR_REQ_STATUS = '0' AND BED_CLASS_REQ_STATUS='1' and (PRIORITY_EXP_DATE is null or PRIORITY_EXP_DATE >= sysdate) and ");
			finalSql.append(nurSql.toString());
		}
		else
		{	
			finalSql.append(" AND a.tfr_req_status = '0' and (PRIORITY_EXP_DATE is null or PRIORITY_EXP_DATE >= sysdate) and ");
			finalSql.append(nurSql.toString());
		}

		finalSql.append(" and a.facility_id = b.facility_id and a.encounter_id = b.encounter_id and b.patient_id = c.patient_id  ");

		
		String sql_count  = finalSql.toString();
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql_count);
		rs.next();
		int maxRecord=0;
		maxRecord = rs.getInt(1);
		if(rs!=null)		rs.close();
		if(stmt!=null)		stmt.close();

		if(maxRecord == 0)
		{	
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
			return;
		}
		*/
		String  strFrm = "";
		if(function_id.equals("CONFIRM_TRANS_BOOKING"))
			strFrm = " a.req_nursing_unit_code in ";
		else
			strFrm=" b.nursing_unit_code in";

		StringBuffer nurSql = new StringBuffer();

		if(nurSql.length() > 0) nurSql.delete(0,nurSql.length());
		nurSql.append(strFrm);
		nurSql.append(" (select a.nursing_unit_code from IP_NURSING_UNIT a, AM_OS_USER_LOCN_ACCESS_VW b where a.facility_id = '"+facility_id+"' and a.facility_id =b.facility_id and a.nursing_unit_code = b.locn_code and a.eff_status='E' and b.oper_stn_id='"+p_oper_stn_id+"' and b.locn_type = 'N' and b.appl_user_id = '"+login_user+"' and b."+werecondn+"= 'Y')");


		nurSql.append(" and ip_leave_status is null ");

		sql = " select DECODE (B.PAT_CURR_LOCN_TYPE, 'N', IP_GET_DESC.IP_NURSING_UNIT (B.FACILITY_ID, B.PAT_CURR_LOCN_CODE, '"+locale+"', 2 ), 'R', B.PAT_CURR_LOCN_CODE, OP_GET_DESC.OP_CLINIC (B.FACILITY_ID, B.PAT_CURR_LOCN_CODE, '"+locale+"', 1) ) CURRENT_LOCATION_DESC , A.REQ_BED_NO TO_BED_NO , A.REQ_ROOM_NO TO_ROOM_NO , IP_GET_DESC.IP_BED_CLASS(A.REQ_BED_CLASS_CODE,'"+locale+"', '2') TO_BED_CLASS_SHORT_DESC , IP_GET_DESC.IP_BED_TYPE(A.REQ_BED_TYPE_CODE,'"+locale+"', '2') TO_BED_TYPE_SHORT_DESC , IP_GET_DESC.IP_NURSING_UNIT(A.FACILITY_ID, A.REQ_NURSING_UNIT_CODE,'"+locale+"','2') TO_NURSING_UNIT_SHORT_DESC , AM_GET_DESC.AM_PRACTITIONER(A.REQ_PRACTITIONER_ID,'"+locale+"','1') TO_PRACTITIONER_NAME , AM_GET_DESC.AM_SPECIALITY(A.REQ_SPECIALTY_CODE,'"+locale+"','2') TO_SPECIALTY_SHORT_DESC , AM_GET_DESC.AM_SUBSERVICE(A.REQ_SERVICE_CODE, A.REQ_SUBSERVICE_CODE,'"+locale+"','2') TO_SUBSERVICE_SHORT_DESC , to_char(B.ADMISSION_DATE_TIME, 'dd/mm/rrrr hh24:mi') ADMISSION_DATE_TIME , C.SEX GENDER , B.ROOM_NUM FROM_ROOM_NO , IP_GET_DESC.IP_BED_CLASS(B.BED_CLASS_CODE,'"+locale+"', '2') FROM_BED_CLASS_SHORT_DESC , IP_GET_DESC.IP_BED_TYPE(B.BED_TYPE_CODE,'"+locale+"', '2') FROM_BED_TYPE_SHORT_DESC , B.BED_NUM FROM_BED_NO , A.ENCOUNTER_ID , A.PATIENT_ID , decode('"+locale+"','en',c.patient_name, nvl(c.patient_name_loc_lang, c.patient_name))PATIENT_NAME , AM_GET_DESC.AM_SPECIALITY(a.REQ_SPECIALTY_CODE,'"+locale+"','2') SPECIALTY_SHORT_DESC , AM_GET_DESC.AM_PRACTITIONER(B.ATTEND_PRACTITIONER_ID,'"+locale+"','1') PRACTITIONER_NAME , B.NURSING_UNIT_CODE NURSING_UNIT_CODE , IP_GET_DESC.IP_NURSING_UNIT(B.FACILITY_ID, B.NURSING_UNIT_CODE,'"+locale+"', '2') NURSING_UNIT_SHORT_DESC , A.TFR_REQ_REF_NO , A.PRIORITY_CODE , IP_GET_DESC.IP_TRANSFER_PRIORITY(A.FACILITY_ID, A.PRIORITY_CODE,'"+locale+"', '2') PRIORITY_SHORT_DESC,(SELECT color_code_scheme FROM ip_transfer_priority WHERE facility_id = a.facility_id AND priority_code = a.priority_code) color_scheme from IP_TRANSFER_REQUEST A , IP_OPEN_ENCOUNTER B , MP_PATIENT C ";

		if(finalSql.length() > 0) finalSql.delete(0,finalSql.length());
		finalSql.append(sql);
		finalSql.append(where_criteria.toString());

		if(bed_class_allowed.equals("Y"))
		{
			finalSql.append(" and a.tfr_req_status='0' and bed_class_req_status='1' and (priority_exp_date is null or priority_exp_date >= sysdate) and ");
			finalSql.append(nurSql.toString());
		}
		else
		{
			finalSql.append(" and a.tfr_req_status='0' and (priority_exp_date is null or priority_exp_date >= sysdate) and ");
			finalSql.append(nurSql.toString());
		}

		finalSql.append(" and a.facility_id = b.facility_id and a.encounter_id = b.encounter_id and b.patient_id = c.patient_id  ");

		if(priotity_status.equals("Y")){
			  finalSql.append(" order by 9");
		}else{
			  finalSql.append(" order by 4,5");
		}
		
		stmt		= con.createStatement();
		rs			= stmt.executeQuery(finalSql.toString());
		if ( start != 1 )
			for( int j=1; j<start; i++,j++ ){
				rs.next() ;
			} 
		while(rs!=null &&  i<=end && rs.next()){
		if(maxRecord==0)
		{

		//if (( !(start <= 1) ) || ( !( (start+12) > maxRecord ) ))
		//{
			out.println("<p><table align='right'><tr>");
			if ( !(start <= 1) )
				out.println("<td align='right' id='prev'><A HREF='../jsp/IPLookupResultForAmendTrn.jsp?jsp_name="+jsp_name+"&win_height="+win_height+"&win_width="+win_width+"&dialogTop="+dialogTop+"&param="+call_function+"&from="+(start-12)+"&to="+(end-12)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"&operStation="+p_oper_stn_id+"&wherecondn="+werecondn+"&function_id="+function_id+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

			//if ( !( (start+12) > maxRecord ) )
				out.println("<td align='right' id='next' style='visibility:hidden'><A HREF='../jsp/IPLookupResultForAmendTrn.jsp?jsp_name="+jsp_name+"&win_height="+win_height+"&win_width="+win_width+"&dialogTop="+dialogTop+"&param="+call_function+"&from="+(start+12)+"&to="+(end+12)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"&wherecondn="+werecondn+"&operStation="+p_oper_stn_id+"&function_id="+function_id+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
			out.println("</tr></table></p>");
			out.println("<br><br>");				
		//}

			out.println(" <table cellspacing=0 cellpadding=0 align='center' width='100%' border='1' cellpadding=0 cellspacing=0>");
			out.println("<tr>");
			out.println("<th colspan = 6>&nbsp;</th>");
			if(isCurrentLocDtlsAppl){ //Added by Shanmukh on 25th-JULY-2018 for ML-MMOH-CRF-1113
			out.println("<th colspan = 5>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.current.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDetails.label","common_labels")+"</th>");
			out.println("<th colspan = 3>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.To.label","bl_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDetails.label","common_labels")+"</th>");
			}else{
			out.println("<th colspan = 5>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.FromDetails.label","ip_labels")+"</th>");
			out.println("<th colspan = 3>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ToDetails.label","ip_labels")+"</th>");
			out.println("<th colspan = 2>&nbsp;</th>");}//END
			out.println("</tr>");
			out.println("<tr>");
			out.println("<th>&nbsp;</th>");
			out.println("<th nowrap> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AdmissionDateTime.label","common_labels")+"&nbsp;"+"</th>");
			out.println("<th nowrap> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounterid.label","common_labels")+"&nbsp;"+" </th>");
			out.println("<th nowrap> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"&nbsp;"+" </th>");
			out.println("<th nowrap> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels")+"&nbsp;"+" </th>");
			out.println("<th nowrap> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+"&nbsp;"+" </th>");
			out.println("<th nowrap> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+"&nbsp;"+" </th>");
			out.println("<th nowrap> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedClass.label","common_labels")+"&nbsp;"+" </th>");
			out.println("<th nowrap> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedtype.label","common_labels")+"&nbsp;"+" </th>");
			out.println("<th nowrap> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels")+"&nbsp;"+" </th>");
			out.println("<th nowrap> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomno.label","common_labels")+"&nbsp;"+" </th>");
			out.println("<th nowrap> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+"&nbsp;"+" </th>");
			out.println("<th nowrap> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedClass.label","common_labels")+"&nbsp;"+" </th>");
			out.println("<th nowrap> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedtype.label","common_labels")+"&nbsp;"+" </th>");
			if(!isCurrentLocDtlsAppl){ //Added by shanmukh on 25th-JULY-2018 for ML-MMOH-CRF-1113
			out.println("<th nowrap> "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.currentlocation.label","common_labels")+"&nbsp;"+" </th>");}

		if(priotity_status.equals("Y"))
		{
			out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels")+"&nbsp;"+" </th>");
			colspan = "16";
		}
		else
		{
			colspan = "15";
		}
		out.println("</tr>");
		}

			//if(rs!=null)
			//{
				/*if ( start != 1 )
				for( int j=1; j<start; i++,j++ )
				{
					rs.next() ;
				} */
				//while(rs!=null && rs.next() && i<=end)
				//{

					if(class_value.equals("QRYEVENSMALL"))
						class_value = "QRYODDSMALL";
					else
						class_value = "QRYEVENSMALL";

					specialty_short_desc=rs.getString("specialty_short_desc");
					if(specialty_short_desc == null) specialty_short_desc="&nbsp;";
					
					admission_date_time=rs.getString("admission_date_time");
					if(admission_date_time == null) admission_date_time="&nbsp;";
					
					if(!admission_date_time.equals("&nbsp;"))
						adm_date_display=DateUtils.convertDate(admission_date_time,"DMYHM","en",locale); 
					
					
					encounter_id=rs.getString("encounter_id");
					if(encounter_id == null) encounter_id="";

					patient_id = rs.getString("patient_id");
					if( patient_id == null) patient_id="";
					
					patient_name=rs.getString("patient_name");
					if(patient_name == null) patient_name="&nbsp;";
					
					fr_nursing_unit_short_desc=rs.getString("nursing_unit_short_desc");
					if(fr_nursing_unit_short_desc== null) fr_nursing_unit_short_desc="&nbsp;";

					gender = rs.getString("gender");
					if(gender== null) 
						gender="&nbsp;";
					else if (gender.equals("M"))
						gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					else if (gender.equals("F"))
						gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					else 
						gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

					room_no=rs.getString("from_room_no");
					if(room_no== null) room_no="&nbsp;";

					to_nursing_unit_short_desc	= checkForNull(rs.getString("to_nursing_unit_short_desc"),"&nbsp;");
					to_practitioner_name		= checkForNull(rs.getString("to_practitioner_name"),"&nbsp;");
					to_specialty_short_desc		= checkForNull(rs.getString("to_specialty_short_desc"),"&nbsp;");
					to_subservice_short_desc	= checkForNull(rs.getString("to_subservice_short_desc"),"&nbsp;");
					to_bed_no					= checkForNull(rs.getString("to_bed_no"),"&nbsp;");
					to_room_no					= checkForNull(rs.getString("to_room_no"),"&nbsp;");
					to_bed_class_short_desc		= checkForNull(rs.getString("to_bed_class_short_desc"),"&nbsp;");
					to_bed_type_short_desc		= checkForNull(rs.getString("to_bed_type_short_desc"),"&nbsp;");

					current_location_desc		= checkForNull(rs.getString("current_location_desc"),"&nbsp;");
										
					bed_class_short_desc=rs.getString("from_bed_class_short_desc");
					if(bed_class_short_desc== null) bed_class_short_desc="&nbsp;";
					
					bed_type_short_desc=rs.getString("from_bed_type_short_desc");
					if(bed_type_short_desc== null) bed_type_short_desc="&nbsp;";
					
					bed_no=rs.getString("from_bed_no");
					if(bed_no== null) bed_no="&nbsp;";

				
					booking_ref_no = rs.getString("TFR_REQ_REF_NO");
				
					practitioner_name=rs.getString("practitioner_name");
					if(practitioner_name == null) practitioner_name="";
				
					priority = 	 rs.getString("PRIORITY_CODE");
					 priority_desc = rs.getString("PRIORITY_SHORT_DESC");
					if(priority_desc == null) priority_desc="&nbsp";

					String color_scheme="";
					color_scheme = rs.getString("color_scheme")==null?"":rs.getString("color_scheme");
					
					if(priority == null) 
						class_val ="&nbsp";				
					 else 
						class_val =color_scheme;
					
					
						
					 
					out.println("<tr>");

					if( ! (jsp_name.equals("") && modal.equals("") ) )
					{

						if(!spcl_prev_val.equals(specialty_short_desc) || !pract_prev_val.equals(practitioner_name) )
						{
							String disp_value = specialty_short_desc;
							if (!practitioner_name.equals(""))
								disp_value = disp_value+"/"+practitioner_name;

							out.println("<td class='CAGROUPHEADING' colspan='"+colspan+"' align='left'>"+disp_value+"</td></tr><tr>");
						}
						
						out.println("<td STYLE='background-color:"+class_val+"' nowrap><a href=\"javascript:closeWin('"+encounter_id+"','"+patient_id+"')\">+</a></td>");

						out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap>"+adm_date_display+"</td>");

						if( call_function.equals("assign_bed"))
						{
						   if	(bed_no.equals("&nbsp;"))
							out.println("<td class='"+class_value+"' nowrap><a href=\"javascript:showModal('"+encounter_id+"','"+patient_id+"','IPval','"+booking_ref_no+"')\">"+encounter_id+"</a></td>");
						   else
							out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap>"+encounter_id+"</td>");
						}
						else
						{
							 out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap><a href=\"javascript:showModal('"+encounter_id+"','"+patient_id+"','"+booking_ref_no+"')\">"+encounter_id+"</a></td>");
						}
					}
					else
					{
						if(!prev_val.equals(fr_nursing_unit_short_desc) || !prev_val2.equals(to_nursing_unit_short_desc) )
						{
							out.println("<td class='CAGROUPHEADING' STYLE='background-color:"+class_val+"' colspan='"+colspan+"' align='left'><font size=1>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NursingUnitFrom.label","ip_labels")+" "+fr_nursing_unit_short_desc+" To "+to_nursing_unit_short_desc+"</font></td></tr><tr>");
						}
						out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap><a href=\"javascript:closeWin('"+encounter_id+"','"+patient_id+"')\">+</a></td>");
						out.println("<td class='"+class_value+"' nowrap>"+encounter_id+"</td>");
					}

					out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap>"+patient_id+"</td>");
					out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap>"+patient_name+"</td>");
					out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap>"+gender+"</td>");
					out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap>"+fr_nursing_unit_short_desc+"</td>");
					out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap>"+bed_class_short_desc+"</td>");
					out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap>"+bed_type_short_desc+"</td>");
					out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap>"+bed_no+"</td>");
				
					out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap>"+room_no+"</td>");
					
					out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap>"+to_nursing_unit_short_desc+"</td>");

					out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap>"+to_bed_class_short_desc+"</td>");

					out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap>"+to_bed_type_short_desc+"</td>");
                    if(!isCurrentLocDtlsAppl){ //Added by shanmukh on 25th-JULY-2018 for ML-MMOH-CRF-1113
					out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap>"+current_location_desc+"</td>");
					}
				if(priotity_status.equals("Y"))
					out.println("<td class='"+class_value+"' STYLE='background-color:"+class_val+"' nowrap>"+priority_desc+"</td>");

					out.println("</tr>");
					
					spcl_prev_val  = specialty_short_desc;
					pract_prev_val = practitioner_name;

					prev_val=fr_nursing_unit_short_desc;
					prev_val2=to_nursing_unit_short_desc;
					i++;
					maxRecord++;
				}

				if(maxRecord<12 || (!rs.next()))
				{
            _bw.write(_wl_block5Bytes, _wl_block5);
}
				else
				{
            _bw.write(_wl_block6Bytes, _wl_block6);
}

				if(maxRecord==0)
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");

		
				if(rs!=null)		rs.close();
				if(stmt!=null)		stmt.close();
			//}
		out.println("</table>");

	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(win_height));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(win_width));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(dialogTop));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(modal));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(module));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(model_window));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(call_func));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(prog_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(p_practitioner_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(routine_tfr_yn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bed_block_period_max_int));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(sydate));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(priotity_status));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(bed_class_allowed));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(deactivate_pseudo_bed_yn));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(bed_block_period_max_type));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block29Bytes, _wl_block29);
	
	}catch(Exception e)
	{
		out.println(e); e.printStackTrace();
	} 
	finally
	{
		try
		{
			if(stmt != null) stmt.close();	
			if(rs != null) rs.close();
		}
		catch(Exception e)
		{
			out.println("Exception in tryCatch : "+ e.toString());
			e.printStackTrace();
		}
		
		ConnectionManager.returnConnection(con,request);
		out.print("<script>if(parent.frames[1].document.forms[0] != null)");	out.print("parent.frames[1].document.forms[0].search.disabled=false</script>");
	}
	
            _bw.write(_wl_block30Bytes, _wl_block30);
            _bw.write(_wl_block31Bytes, _wl_block31);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
