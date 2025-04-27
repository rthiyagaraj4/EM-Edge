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
import java.util.*;
import com.ehis.util.*;

public final class __iplookupqueryresultforleave extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/IPLookupQueryResultForLeave.jsp", 1742387595794L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\tvar locn;\n\tasync function callRemarksPage(encounter_id)\n\t{\n\t\tvar retVal;\n\t\tvar dialogHeight =\'9\' ;\n\t\tvar dialogWidth = \'30\' ;\n\t\tvar\tremarksvalue = \"\";\n\t\tvar features = \'dialogHeight:\' + dialogHeight + \'; dialogWidth:\' + dialogWidth +\'; scroll=no; status=no\';\n\t\tvar arguments;\n\t\tvar comments;\n\t\t   if(comments==\'\' || comments == \"null\")\n\t\t\t  comments =\'\';\n\t\targuments = comments;\n\t\tvar remarks = escape(encounter_id);\n\t\tretVal = await window.showModalDialog(\'../../eIP/jsp/IPLookupQueryRemarks.jsp?p_remarks=\'+remarks,arguments,features);\n\t}\n\n\tasync function showModal(enc,srl_no,call_fn_id)\n\t{\t\n\t\tvar tot_count=document.forms[0].total_count.value;\n\t\tvar win_height=\"1000px\";\n\t\tvar dialogTop=\"72\";\n\t\tvar win_width=\"1400px\";\n\t\tvar dialogHeight=\"1000px\";\n\t\tvar dialogWidth=\"1400px\";\n\t\t\n\t\tif( document.forms[0].modal.value != \'yes\')\n\t\t{\n\t\t\tvar jsp_name=document.forms[0].jsp_name.value;\n\t\t\tvar win_height=document.forms[0].win_height.value;\n\t\t\tif(win_height == \"\") win_height=\"1000px\";\n\n\t\t\tvar dialogTop=document.forms[0].dialogTop.value;\n\t\t\tif(dialogTop == \"\") dialogTop=\"130\";\t\t\t\t\n\n\t\t\tvar win_width=document.forms[0].win_width.value;\n\t\t\tif(win_width == \"\") win_width=\"1400px\";\n\n\t\t\tvar module=document.forms[0].module.value;\n\t\t\tif(module == \"\") module=\"eIP\";\n\n\t\t\tvar model_window=document.forms[0].model_window.value;\n\t\t\tif( model_window == \"\") model_window =\"\";\n\n\t\t\tvar p_oper_stn_id=document.forms[0].p_oper_stn_id.value;\n\t\t\tif( p_oper_stn_id == \"\") p_oper_stn_id =\"\";\n\n\t\t\tif( model_window == \'N\')\n\t\t\t{\n\t\t\t\tparent.frames[3].document.location.href=\"../../\"+module+\"/jsp/\"+jsp_name+\"?encounter_id=\"+enc+\"&srl_no=\"+srl_no+\"&call_function=\"+call_fn_id+\"&p_oper_stn_id=\"+p_oper_stn_id;\n\t\t\t}\t\t\t\n\t\t\telse\n\t\t\t{\t\t\t\t\t\n\t\t\t\tvar retVal = \tnew String();\n\t\t\t\tvar center = \"1\" ;\n\t\t\t\tvar status=\"no\";\n\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\t\tvar arguments\t= \"\" ;\t\t\t\t\n\t\t\t\tretVal = await window.showModalDialog(\"../../\"+module+\"/jsp/\"+jsp_name+\"?encounter_id=\"+enc+\"&srl_no=\"+srl_no+\"&call_function=\"+call_fn_id+\"&p_oper_stn_id=\"+p_oper_stn_id,arguments,features);\n\t\t\t\tif(tot_count >= 1)\n\t\t\t\t{\n\t\t\t\t\tparent.frames[2].document.location.reload();\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.frames[2].document.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t}\n\t\t\t}\n\t\t  }\n\t\t  else\n\t\t  {\n\t\t\twindow.parent.returnValue=enc;\n\t\t\twindow.parent.close();\n\t\t  }\n\t}\n\tasync function showEncounterDetails(enc,patid)\n\t{\n\t\tvar retVal = \tnew String();\n\t\t//var dialogHeight= \"41\";\n\t\t//var dialogWidth = \"65\";\n\t\tvar dialogHeight= \"800px\";\n\tvar dialogWidth\t= \"1400px\";\n\t\tvar dialogTop\t= \"65\";\n\t\tvar center = \"1\" ;\n\t\tvar status=\"no\";\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\tvar arguments\t= \"\" ;\n\t\tretVal = await window.showModalDialog(\"../../eIP/jsp/CurrentEncounterMain.jsp?encounterId=\"+enc+\"&patientId=\"+patid,arguments,features);\n\t}\n\t</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</head>\t\t\t\t\t\t\t\n<body onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n<form name=\'iplookupqueryresult\' id=\'iplookupqueryresult\'>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<a href=\'javascript:callRemarksPage(\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\")\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</a></td>\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<input type=\'hidden\' name=\'leave_remark\' id=\'leave_remark\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' >\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<script>\t\t\t\t\t\n\t\t\tdocument.getElementById(\'nextval\').innerHTML = \" \";\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t<script>\n\tif (parseInt(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\') == 0)\n\t{\n\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\tparent.frames[1].document.forms[0].search.disabled=false\t\n\t\tparent.frames[2].document.location.href=\'../../eCommon/html/blank.html\';\n\t}\n\t</script>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t<input type=\'hidden\' name=\'total_count\' id=\'total_count\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" >\n\t<input type=\'hidden\' name=\'jsp_name\' id=\'jsp_name\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' >\n\t<input type=\'hidden\' name=\'win_height\' id=\'win_height\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' >\n\t<input type=\'hidden\' name=\'win_width\' id=\'win_width\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' >\n\t<input type=\'hidden\' name=\'dialogTop\' id=\'dialogTop\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' >\n\t<input type=\'hidden\' name=\'modal\' id=\'modal\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' >\n\t<input type=\'hidden\' name=\'module\' id=\'module\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' >\n\t<input type=\'hidden\' name=\'model_window\' id=\'model_window\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' >\n\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' >\n\t<input type=\'hidden\' name=\'call_function\' id=\'call_function\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' >\n\t<input type=\'hidden\' name=\'prog_id\' id=\'prog_id\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' >\n\t<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' >\n\t<input type=\'hidden\' name=\'p_oper_stn_id\' id=\'p_oper_stn_id\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' >\n\t</form>\n\t</body>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n</html>\n";
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
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
	String locale = (String)session.getAttribute("LOCALE");
	String call_function =request.getParameter("param");
	if( call_function == null) call_function="";
	String oper_stn_id = request.getParameter("oper_stn_id");
	String login_user = (String)session.getValue("login_user");

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	Connection con = null;
	Statement stmt = null;
	ResultSet rs =null;

	try
	{
	con = ConnectionManager.getConnection(request);

	String facility_id			= (String)session.getValue("facility_id");
	StringBuffer where_criteria = new StringBuffer();
	String soundex_function		= "";
	String sql					= "";
	String leave_status			= "";
	String class_val			= "QRYEVENSMALL";
	String color_code_scheme	= "";
	String whereClause			= request.getParameter("whereclause");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String soundex_type			= request.getParameter("soundex");
	String nursing_unit_code	= "";
	nursing_unit_code=request.getParameter("nursing_unit");
	if( nursing_unit_code == null) nursing_unit_code = "";
	String speciality_code		= request.getParameter("Splcode");
	String encounter_id			= request.getParameter("encounter_id");
	String practitioner_id		= request.getParameter("practid");
	String from_date			= request.getParameter("from_date");
	if(from_date == null || !from_date.equals(""))
		from_date = DateUtils.convertDate(from_date,"DMY",locale,"en"); 
	String to_date				= request.getParameter("to_date");
	if(to_date == null || !to_date.equals(""))
		to_date = DateUtils.convertDate(to_date,"DMY",locale,"en"); 
	String patient_id			= request.getParameter("patient_id");
	String gender				= request.getParameter("gender");
	String name_prefix			= checkForNull(request.getParameter("name_prefix"));
	String name_suffix			= checkForNull(request.getParameter("name_suffix"));
	
	
	if(name_prefix!=null || !name_prefix.equals(""))
		name_prefix				= singleToDoubleQuotes(name_prefix);
	if(name_suffix!=null || !name_suffix.equals(""))
		name_suffix				= singleToDoubleQuotes(name_suffix);
	
	String first_name			= request.getParameter("first_name");
	String second_name			= request.getParameter("second_name");
	String third_name			= request.getParameter("third_name");
	String family_name			= request.getParameter("family_name");
	String searchby				= request.getParameter("searchby");
	String pat_name_as_multipart_yn = request.getParameter("pat_name_as_multipart_yn");
	if (pat_name_as_multipart_yn==null) pat_name_as_multipart_yn = "";
	if (searchby==null) searchby = "";
	if (searchby.equals("")) searchby="S";
	String srl_no			="" ;
	String patient_name		="";
	String leave_fr_date	= "";
	String leave_to_date	= "";
	String leave_fr_date_display	= "";
	String leave_to_date_display	= "";
	String leave_remarks	= "";
	String sex				= "";

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

	String dialogTop =request.getParameter("dialogTop");
	if(dialogTop ==null) dialogTop="";			

	String win_width =request.getParameter("win_width");
	if( win_width == null) win_width="";

	String modal=request.getParameter("modal");
	if(modal == null) modal="";

	String module=request.getParameter("module");
	if(module == null) module="";

	String model_window=request.getParameter("model_window");
	if( model_window == null) model_window="";

	String function_id=request.getParameter("function_id");
	if( function_id == null) function_id="";

	String prog_id=request.getParameter("prog_id");
	if( prog_id == null) prog_id="";

	String p_practitioner_id=request.getParameter("practitioner_id");
	if( p_practitioner_id == null) p_practitioner_id="";

	String call_func=request.getParameter("call_function");
	if(call_func == null) call_func="";

            _bw.write(_wl_block10Bytes, _wl_block10);

	if(whereClause==null)
	{
		if(soundex_type!=null)
		{
			if(soundex_type.equals("E"))
				soundex_function = "ethnic_soundex";
			else if(soundex_type.equals("G"))
				soundex_function = "soundex";
			else 
				soundex_function = "";
		}

		if(where_criteria.length() > 0) where_criteria.delete(0,where_criteria.length());
		where_criteria.append(" where facility_id='"+facility_id+"' and leave_status in ('1','4') ");

		if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
			where_criteria.append(" and ASSIGN_CARE_LOCN_CODE='"+nursing_unit_code+"' ");
		else
			where_criteria.append(" and ASSIGN_CARE_LOCN_CODE in (Select a.nursing_unit_code from ip_nursing_unit a, am_os_user_locn_access_vw b where a.facility_id='"+facility_id+"' and a.facility_id=b.facility_id and a.nursing_unit_code=b.locn_code and a.eff_status = 'E' and b.locn_type = 'N' and b.oper_stn_id='"+oper_stn_id+"' and b.appl_user_id='"+login_user+"' )"); 

		if(speciality_code!=null && !speciality_code.equals(""))
		where_criteria.append(" and specialty_code='"+speciality_code+"' ");

		if(practitioner_id!=null && !practitioner_id.equals(""))
		where_criteria.append(" and attend_practitioner_id='"+practitioner_id+"' ");

		if(from_date!=null && !from_date.equals(""))
		where_criteria.append(" and trunc(admission_date_time) >= to_date('"+from_date+"' , 'dd/mm/rrrr') ");

		if(to_date!=null && !to_date.equals(""))
		where_criteria.append(" and trunc(admission_date_time) <= to_date('"+to_date+"' , 'dd/mm/rrrr') ");

		if(patient_id!=null && !patient_id.equals(""))
		where_criteria.append(" and patient_id like '"+patient_id+"%' ");

		if(encounter_id != null && !encounter_id.equals(""))
		where_criteria.append(" and encounter_id='"+encounter_id+"' ");

		if(gender!=null && !gender.equals(""))
		where_criteria.append(" and sex='"+gender+"' ");

		if(name_prefix!=null && !name_prefix.equals(""))
		where_criteria.append(" and name_prefix='"+name_prefix+"' ");

		if(name_suffix!=null && !name_suffix.equals(""))
		where_criteria.append(" and name_suffix='"+name_suffix+"' ");

		if (!soundex_function.equals(""))
		{
		if(first_name!=null && !first_name.equals(""))
		where_criteria.append(" and "+soundex_function+"(first_name) like "+soundex_function+"('"+first_name+"') || '%' ");

		if(second_name!=null && !second_name.equals(""))
			where_criteria.append(" and "+soundex_function+"(second_name) like "+soundex_function+"('"+second_name+"') || '%' ");

		if(third_name!=null && !third_name.equals(""))
			where_criteria.append(" and "+soundex_function+"(third_name) like "+soundex_function+"('"+third_name+"') || '%' ");
		}
		else
		{
			if(first_name!=null && !first_name.equals(""))
			where_criteria.append(" and upper(first_name) like upper('"+first_name+"') || '%' ");

			if(second_name!=null && !second_name.equals(""))
			where_criteria.append(" and upper(second_name) like upper('"+second_name+"') || '%' ");

			if(third_name!=null && !third_name.equals(""))
			where_criteria.append(" and upper(third_name) like upper('"+third_name+"') || '%' ");
		}

		if(family_name!=null && !family_name.equals(""))
		{
			if (pat_name_as_multipart_yn.equals("Y"))
			{							
				where_criteria.append(" and "+soundex_function+"(family_name) like "+soundex_function+"('"+family_name+"') || '%' ");
			}
			else
			{
				if (soundex_function.equals(""))
				{
					if (searchby.equals("C"))
					{
						where_criteria.append(" and upper(family_name) like '%' || upper('"+family_name+"') || '%' ");
					}
					else if (searchby.equals("E"))
					{
						where_criteria.append(" and upper(family_name) like '%' || upper('"+family_name+"') ");
					}
					else
					{
						where_criteria.append(" and upper(family_name) like upper('"+family_name+"') || '%' ");
					}
				}
				else
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

					where_criteria.append(" and "+soundex_function+"(family_name) like "+soundex_function+"('"+fam_name_search+"') || '%' ");
				}
			}
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
			if(where_criteria.length() > 0) where_criteria.delete(0,where_criteria.length());
			where_criteria.append(whereClause) ;
		}
		int start = 0 ;
		int end = 0 ;
		int i=1;
		int cnt=0;
		int endOfRes=1;
		if ( from == null )
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;

		if ( to == null )
			end = 12 ;
		else
			end = Integer.parseInt( to ) ;

		sql  = " select encounter_id,patient_id,decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name))patient_name, sex, to_char(leave_fr_date,'dd/mm/rrrr hh24:mi') leave_fr_date,leave_fr_date leave_fr_date1, to_char(leave_to_date,'dd/mm/rrrr hh24:mi') leave_to_date,srl_no,leave_remarks,LEAVE_STATUS from ip_leave_detail_vw "+where_criteria.toString() + " order by leave_fr_date1";
		//out.println(sql);
		
		stmt = con.createStatement();
		rs= stmt. executeQuery(sql);
	

		if ( start != 1 )		
			for( int j=1; j<start; i++,j++ )
				rs.next() ;
		
		while ( i<=end && rs.next() ) 
		{
			if(cnt == 0)
			{
				out.println("<p><table align='right'><tr><td>");

				if ( !(start <= 1) )
					out.println("<A HREF='../jsp/IPLookupQueryResultForLeave.jsp?jsp_name="+jsp_name+"&win_height="+win_height+"&win_width="+win_width+"&dialogTop="+dialogTop+"&param="+call_function+"&from="+(start-12)+"&to="+(end-12)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

				if ( endOfRes == 1 )
					out.println("<A id='nextval' HREF='../jsp/IPLookupQueryResultForLeave.jsp?jsp_name="+jsp_name+"&win_height="+win_height+"&win_width="+win_width+"&dialogTop="+dialogTop+"&param="+call_function+"&from="+(start+12)+"&to="+(end+12)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
				out.println("</td></tr></table></p>");
				out.println("<br><br>");				

				out.println(" <table cellspacing=0 cellpadding=0 align='center' width='100%' border='1' cellpadding=0 cellspacing=0>");
				out.println("<tr>");
				out.println("<th width='5%'>"+"&nbsp;"+"</th>");
				out.println("<th width='20%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"&nbsp;"+"</th>");
				out.println("<th width='30%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+"&nbsp;"+"</th>");
				out.println("<th width='6%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+"&nbsp;"+"&nbsp;"+"</th>");
				out.println("<th width='15%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounterid.label","common_labels")+"&nbsp;"+"</th>");
				out.println("<th width='18%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LeaveFrom.label","common_labels")+"&nbsp;"+"</th>");
				out.println("<th width='17%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LeaveTo.label","common_labels")+"&nbsp;"+"</th>");
				out.println("<th width='5%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+"&nbsp;"+"&nbsp;"+"</th>");
				out.println("</tr>"); 
			}

			encounter_id	= rs.getString("encounter_id") == null ? "&nbsp;" : rs.getString("encounter_id");
			patient_name	= rs.getString("patient_name") == null ? "&nbsp;" : rs.getString("patient_name");
			sex				= rs.getString("sex") == null ? "" : rs.getString("sex");

			if (sex.equals("M"))
				sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			else if (sex.equals("F"))
				sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			else 
				sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
	
			leave_fr_date=rs.getString("leave_fr_date") == null ? "" : rs.getString("leave_fr_date");
			leave_to_date=rs.getString("leave_to_date") == null ? "" : rs.getString("leave_to_date");
			if(leave_fr_date.equals(""))
				leave_fr_date_display = "&nbsp;";
			else
				leave_fr_date_display = DateUtils.convertDate(leave_fr_date,"DMYHM","en",locale);

			if(leave_to_date.equals(""))
				leave_to_date_display = "&nbsp;";
			else
				leave_to_date_display = DateUtils.convertDate(leave_to_date,"DMYHM","en",locale);

			leave_remarks	= rs.getString("leave_remarks") == null ? "" : rs.getString("leave_remarks");
			leave_status	= rs.getString("leave_status") == null? "":rs.getString("leave_status");
			srl_no			= rs.getString("srl_no") == null ? "" : rs.getString("srl_no");

			if(leave_status.equals("4"))
				color_code_scheme = "#9DCECE";
			else
				color_code_scheme = "";

			if(class_val.equals("QRYEVENSMALL"))
				class_val = "QRYODDSMALL";
			else
				class_val = "QRYEVENSMALL";

			out.println("<tr>");
			out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"'><a href=\"javascript:showEncounterDetails('"+encounter_id+"','"+patient_id+"')\">+</a></td>");
			out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"'><a href=\"javascript:showModal('"+encounter_id+"','"+srl_no+"','"+call_function+"')\">"+rs.getString("patient_id")+"</a></td>");
			out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"'>"+patient_name+"</td>");
			out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"'>"+sex+"</td>");
			out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"'>"+encounter_id+"</td>");
			out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"'>"+leave_fr_date_display+"</td>");
			out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"'>"+leave_to_date_display+"</td>");

			if (!leave_remarks.equals(""))
			{
				out.print("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"'>");
				out.print("<input type='hidden' name='l_remark' id='l_remark' value='"+leave_remarks+"' >");
				
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
 
			}
			else
			{
				out.println("<td nowrap class='"+class_val+"' style='background-color:"+color_code_scheme+"'>&nbsp;</td>");
			}
			out.println("</tr>");
			
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(leave_remarks));
            _bw.write(_wl_block15Bytes, _wl_block15);

			i++;
			cnt++;
		}

		if( !rs.next() && cnt!=0 )
		{
			endOfRes=0;
		
            _bw.write(_wl_block16Bytes, _wl_block16);

		}	

		if(rs!=null)		rs.close();
		if(stmt!=null)		stmt.close();

	
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block18Bytes, _wl_block18);
				
		out.println("</table>");				

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(win_height));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(win_width));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(dialogTop));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(modal));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(module));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(model_window));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(call_func));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(prog_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(p_practitioner_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
 }
	catch(Exception e)
	{
		out.println(e);
		e.printStackTrace();
	}
	finally
	{
		if(stmt!=null)	stmt.close();
		if(rs!=null)	rs.close();
		ConnectionManager.returnConnection(con,request);

		out.print("<script>if(parent.frames[1].document.forms[0] != null)");	out.print("parent.frames[1].document.forms[0].search.disabled=false</script>");
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
}
