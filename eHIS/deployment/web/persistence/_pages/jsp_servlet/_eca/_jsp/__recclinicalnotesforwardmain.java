package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __recclinicalnotesforwardmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesForwardMain.jsp", 1739959036526L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \n-----------------------------------------------------------------------------------------------\nDate       \t\tEdit History   Name        Description\n-----------------------------------------------------------------------------------------------\n?             \t100         ?           \tcreated\n06/02/2013\tIN037675\t\tDinesh T\tIN037675\n16/03/2013\tIN038659\t\tDineshT\t\tPrivilege level setup with sign is not working\t\t\n05/06/2018  IN67872\t  Dinesh T\t05/06/2018\tRamesh G\tCRF-0497.1\n-----------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<!--\t<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title> -->\n\t\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart1.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart2.js\'></script>\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<style>\ntextarea {\n  resize: none;\n}\n</style>\n \n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" class=\'CONTENT\'>\n\t<center>\n\t<form name=\'RecClinicalNotesForwardForm\' id=\'RecClinicalNotesForwardForm\' >\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t <table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\' style=\"display\">\n\t\t\t<TR>\n\t\t\t\t<TD class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =":</TD>\n\t\t\t\t<TD class=\'LABEL\' width=\'75%\' colspan=\'2\'>&nbsp;\n\t\t\t\t\t<input type=\"radio\" name=\"forward_to\" id=\"forward_to\" class=\"label\" value=\"P\" checked onclick=\'setValues(this)\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<input type=\"radio\" name=\"forward_to\" id=\"forward_to\" class=\"label\" value = \"S\" onclick=\'setValues(this)\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t</TD>\n\t\t\t</TR>\n\t\t\t<tr><td colspan=3>&nbsp;</td></tr>\n\t\t</table> \n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<!--IN037675, starts-->\n\t\t<table width= \'100%\' align = \'center\' id = \'pracLevelFacility\' style = \'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t<tr>\n\t\t\t<td class = \'LABEL\' width=\'30%\'>\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t</td>\n\t\t\t<td class = \'field\' width=\'50%\'>\n\t\t\t\t<select name = \'forwardToFac\' id = \'forwardToFac\'>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t<option value = \'*A\'>ALL</option><!--IN038659-->\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t<option value = \'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="selected";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</option>\n\t\t\t\t\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t</select>\n\t\t\t</td>\n\t\t\t<td>&nbsp;</td>\n\t\t</tr>\n\t\t</table>\n\n\t\t<table width= \'100%\' align = \'center\' id = \'specLevelFacility\' style = \'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t</td>\n\t\t\t<td class = \'field\' width=\'50%\'>\n\t\t\t\t<select name = \'forwardToFac1\' id = \'forwardToFac1\'>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t</select>\n\t\t\t</td>\n\t\t\t<td>&nbsp;</td>\n\t\t</tr>\n\t\t</table>\n\t\t<!--IN037675, ends-->\n\n\t\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\' id=\'speciality\'>\n\t\t\t<tr>\n\t\t\t\t<td class=\'LABEL\'  width=\'19.5%\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t\t<td width=\'50%\' id=\'speciality_list\' nowrap>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t</tr>\n\t\t</table>\n\n\t\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\' id=\"practitioner\" style=\"display\">\n\t\t\t<tr>\n\t\t\t\t<td class=\'LABEL\' id=\'pract_label\' width=\'28%\' >";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t\t<td width=\'25%\' id=\'pract_list\' nowrap>\n\t\t\t\t\t<input type =\"text\" name =\"forwarded_clinician_id\" value=\"\"  onBlur=\"populatePractitioner1(this)\" size=\"32\"><input type=\"button\" value=\"?\" class=\"button\" onClick=\"populatePractitioner()\" name=\'search_btn_pract\' id=\'search_btn_pract\' >\n\t\t\t\t\t<!-- ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" -->\n\t\t\t\t</td>\n\t\t\t\t<td><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t\t\t</tr>\n\t\t</table>\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\' style=\"display\">\n\t\t<tr>\n\t\t\t<td class=\'LABEL\'  width=\'27%\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t<td colspan=1>&nbsp;<TEXTAREA NAME=\"action_comment\" ROWS=\"3\"  COLS=\"35\" onKeyPress=\"return restrictPercentile(event);return checkMaxLimit(this,200);\" onblur=\"chkMaxLenForLongTest(\'action_comment\',\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\',200)\"></TEXTAREA>&nbsp;<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td colspan=2 align=\'right\' width=\'100%\'>\n\t\t\t\t<input type=\'BUTTON\' class=\'BUTTON\' name=\'ok\' id=\'ok\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' onClick=\'closeForwardWindow();\'>&nbsp;<input type=\'BUTTON\' class=\'BUTTON\' name=\'cancel\' id=\'cancel\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' onClick=\'parent.window.close();\'>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr><td colspan=2>&nbsp;</td></tr>\n\t\t<tr><td colspan=2>&nbsp;</td></tr>\n\t</table>\n\n\t\n\t\t<input type=\'hidden\' name=\'operation_mode\' id=\'operation_mode\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t\t<input type=\'hidden\' name=\'forward_mode\' id=\'forward_mode\' value=\"P\">\n\t\t<input type=\'hidden\' name=\'note_type\' id=\'note_type\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t<input type=\'hidden\' name=\'speciality_id\' id=\'speciality_id\' value=\"\">\n\t\t<input type=\'hidden\' name=\'pract_id\' id=\'pract_id\' value=\"\">\n\t\t<input type=\'hidden\' name=\'clinician_id\' id=\'clinician_id\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t\t<!--IN037675, starts-->\n\t\t<input type = \'hidden\' name = \'displayPracTable\' value = \'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'/>\n\t\t<input type = \'hidden\' name = \'displaySpecTable\' value = \'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'/>\n\t\t<input type = \'hidden\' name = \'prac_level\' value = \'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'/>\n\t\t<input type = \'hidden\' name = \'spec_level\' value = \'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'/>\n\t\t<!--IN037675, ends-->\n\t</form>\n\t</center>\n</body>\n\n</html>\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;

	String	note_type			=	"",		clinician_id				=	"";
	String	clinician_name		=	"",		query_clinician_details		=	"";
	String	operation_mode		=	"",		window_title				=	"";
	String  query_speciality_details = "";
	String	facility_id = session.getValue("facility_id")==null?"": (String) session.getValue("facility_id");
	String	ca_practitioner_id = "";
	String remarks = "";
	HashMap map = new HashMap();
	HashMap map1 = new HashMap();
	
	//IN037675, starts
	String displayPracTable = "";
	String displaySpecTable = "";
	String pracDefaultValue = "";
	String specDefaultValue = "";
	String prac_level = "";
	String spec_level = "";
	String forward_mode = request.getParameter("forward_mode")==null?"P":request.getParameter("forward_mode");
	//IN037675, ends
	
	try
	{
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		con	= ConnectionManager.getConnection(request);

		try
		{
			ca_practitioner_id	=	(String) session.getValue("ca_practitioner_id");

			note_type		=	checkForNull( request.getParameter("note_type"));
			operation_mode	=	checkForNull( request.getParameter("operation_mode"));

			//if(!(operation_mode.equals("MarkAsError") || operation_mode.equals("ModifySection") || operation_mode.equals("ModifyAddendum") ))//IN67872
			if(!(operation_mode.equals("MarkAsError") || operation_mode.equals("ModifySection") || operation_mode.equals("ModifyAddendum") ||operation_mode.equals("REJECT")))//IN67872
				remarks = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Subject.label","ca_labels");
			else
				remarks = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels");
			
		}
		catch(Exception e)
		{
			out.println("Exception@1: "+e);
		}
		query_clinician_details = "SELECT a.practitioner_id clinician_id, b.practitioner_name clinician_name FROM am_pract_for_facility a, am_practitioner_lang_vw b WHERE b.language_id = ? AND a.facility_id = ? and b.practitioner_id = a.practitioner_id AND a.practitioner_id != ? AND a.practitioner_id IN (SELECT ia.func_role_id FROM ca_note_type_for_resp ib,sm_appl_user ia, sm_resp_for_user ic WHERE ib.note_type = ? AND ib.privilege_type IN ('3', '4') AND ia.appl_user_id = ic.appl_user_id AND ic.resp_id = ib.resp_id)  order by 2"; 
		query_speciality_details = "Select speciality_code, short_desc speciality_desc from am_speciality_lang_vw where EFF_STATUS = 'E' and language_id = ? ORDER BY 2";

		int pract = 0;
		int splty = 0;

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(window_title));
            _bw.write(_wl_block6Bytes, _wl_block6);

		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

	//if(!(operation_mode.equals("MarkAsError") || operation_mode.equals("ModifySection") || operation_mode.equals("ModifyAddendum") ))//IN67872
	if(!(operation_mode.equals("MarkAsError") || operation_mode.equals("ModifySection") || operation_mode.equals("ModifyAddendum") ||operation_mode.equals("REJECT")))//IN67872
	{
		if(operation_mode.equals("Forward"))
		{

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

		}
		else
		{
			out.println("<br><br><br>");
		}
		String key = "*ALL";
		String value = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" -----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		try
		{
			map.put(key,value);
			pstmt		=	con.prepareStatement(query_speciality_details);
			pstmt.setString( 1,	locale);
			rs			=	pstmt.executeQuery();
			while(rs.next())
			{
				splty++;
				clinician_id	=	rs.getString("speciality_code");
				clinician_name	=	rs.getString("speciality_desc");
				map.put(clinician_id,clinician_name);
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

			if(splty == 0)
			{
				key = "ALL";
				value = "ALL";
				map.put(key,value);
			}
		}
		catch(Exception e)
		{
			//out.println("Exception@2: "+e);//COMMON-ICN-0181
		          e.printStackTrace();//COMMON-ICN-0181
		}
		
		try
		{
			map1.put(key,value);
			pstmt		=	con.prepareStatement(query_clinician_details);
			pstmt.setString( 1,	locale);
			pstmt.setString( 2,	facility_id);
			pstmt.setString( 3,	ca_practitioner_id);
			pstmt.setString( 4, note_type);

			rs			=	pstmt.executeQuery();

			while(rs.next())
			{
				pract++;
				clinician_id	=	rs.getString("clinician_id");
				clinician_name	=	rs.getString("clinician_name");
				map1.put(clinician_id,clinician_name);
			}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();

			if(pract == 0)
			{
				key = "ALL";
				value = "ALL";
				map1.put(key,value);
			}
		}
		catch(Exception e)
		{
			//out.println("Exception@2: "+e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}

		//IN037675, starts
		
		Statement stmt11 = null;
		PreparedStatement	pstmt11		=	null;//common-icn-0180
		ResultSet rs11 = null;

		try
		{
			//String sql = "SELECT FWD_PRACT_IND,FWD_SPLTY_IND FROM CA_NOTE_TYPE WHERE NOTE_TYPE = '"+ note_type +"'";	//common-icn-0180
			String sql = "SELECT FWD_PRACT_IND,FWD_SPLTY_IND FROM CA_NOTE_TYPE WHERE NOTE_TYPE = ?";	//common-icn-0180
			//stmt11 = con.createStatement();//common-icn-0180	
			pstmt11		=	con.prepareStatement(sql);//common-icn-0180
			pstmt11.setString(1,note_type);//common-icn-0181
			//rs11 = stmt11.executeQuery(sql);//common-icn-0180
			rs11 = pstmt11.executeQuery();//common-icn-0180

			while(rs11.next())
			{
				prac_level = rs11.getString("FWD_PRACT_IND");
				spec_level = rs11.getString("FWD_SPLTY_IND");
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(rs11!=null)
				rs11.close();
			if(stmt11!=null)	
				stmt11.close();
		}
	
		//String facility_id = (String)session.getValue("facility_id");
		
		displayPracTable = "";
		displaySpecTable = "";
		pracDefaultValue = "";
		specDefaultValue = "";

		if(forward_mode.equals("P"))
		{
			if(prac_level.equals("A"))
			{
				displayPracTable = "display:none";
				displaySpecTable = "display:none";
			}
			else if(prac_level.equals("F"))
			{
				displayPracTable = "display";
				displaySpecTable = "display:none";
			}
			else if(prac_level.equals("P"))
			{
				displayPracTable = "display";
				displaySpecTable = "display:none";
			}
		}
		else
		{
			if(spec_level.equals("A"))
			{
				displayPracTable = "display:none";
				displaySpecTable = "display:none";
			}
			else if(spec_level.equals("F"))
			{
				displayPracTable = "display:none";
				displaySpecTable = "display";
			}
			else if(spec_level.equals("P"))
			{
				displayPracTable = "display:none";
				displaySpecTable = "display";
			}
		}

		if(!prac_level.equals("F"))
			pracDefaultValue = "ALL";

		if(!spec_level.equals("F"))
			specDefaultValue = "ALL";
		//IN037675, ends
		

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(displayPracTable));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

					if(pracDefaultValue.equals("ALL"))
					{

            _bw.write(_wl_block17Bytes, _wl_block17);
			
					}
		Statement stmt = null;

		try
		{
			
			stmt 		=	con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs			=	stmt.executeQuery("SELECT FACILITY_ID,FACILITY_NAME from SM_FACILITY_PARAM");

			while(rs.next())
			{

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rs.getString("FACILITY_ID")));
            _bw.write(_wl_block19Bytes, _wl_block19);
if(prac_level.equals("F") && facility_id.equals(rs.getString("FACILITY_ID"))){
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rs.getString("FACILITY_NAME")));
            _bw.write(_wl_block22Bytes, _wl_block22);

			}
		}
		catch(Exception e)
		{
			out.println("Exception@2: "+e);
		}	
		finally
		{
			if(stmt!=null)
				stmt.close();
		}
		
		
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(displaySpecTable));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

					if(specDefaultValue.equals("ALL"))
					{

            _bw.write(_wl_block17Bytes, _wl_block17);
	
					}
		
		//Statement stmt = null;
		try
		{
			stmt 		=	con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs			=	stmt.executeQuery("SELECT FACILITY_ID,FACILITY_NAME from SM_FACILITY_PARAM");

			while(rs.next())
			{

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rs.getString("FACILITY_ID")));
            _bw.write(_wl_block19Bytes, _wl_block19);
if(spec_level.equals("F") && facility_id.equals(rs.getString("FACILITY_ID"))){
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rs.getString("FACILITY_NAME")));
            _bw.write(_wl_block22Bytes, _wl_block22);

			}
		}
		catch(Exception e)
		{
			out.println("Exception@2: "+e);
		}	
		finally
		{
			if(rs!=null)
				rs.close();
			if(stmt!=null)
				stmt.close();	
		}
		
		
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
             com.iba.autocomplete.tags.IbaAutoCompleteComboTag __tag7 = null ;
            int __result__tag7 = 0 ;

            if (__tag7 == null ){
                __tag7 = new  com.iba.autocomplete.tags.IbaAutoCompleteComboTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
            }
            __tag7.setPageContext(pageContext);
            __tag7.setParent(null);
            __tag7.setMap(map
);
            __tag7.setId(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("splty_id", java.lang.String .class,"id"));
            __tag7.setName(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("splty_id", java.lang.String .class,"name"));
            __tag7.setDefaultSelection(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("*ALL", java.lang.String .class,"defaultSelection"));
            __tag7.setOnfocus(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("delSelect(splty_id)", java.lang.String .class,"onfocus"));
            __tag7.setOnblur(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("speciality_change(splty_id)", java.lang.String .class,"onblur"));
            __tag7.setOnclick(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("delSelect1(splty_id)", java.lang.String .class,"onclick"));
            _activeTag=__tag7;
            __result__tag7 = __tag7.doStartTag();

            if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                }
            }
            if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag7);
                return;
            }
            _activeTag=__tag7.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
            __tag7.release();
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
             com.iba.autocomplete.tags.IbaAutoCompleteComboTag __tag9 = null ;
            int __result__tag9 = 0 ;

            if (__tag9 == null ){
                __tag9 = new  com.iba.autocomplete.tags.IbaAutoCompleteComboTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
            }
            __tag9.setPageContext(pageContext);
            __tag9.setParent(null);
            __tag9.setMap(map1
);
            __tag9.setId(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("forwarded_clinician_id", java.lang.String .class,"id"));
            __tag9.setName(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("forwarded_clinician_id", java.lang.String .class,"name"));
            __tag9.setDefaultSelection(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("*ALL", java.lang.String .class,"defaultSelection"));
            __tag9.setOnfocus(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("delSelect(forwarded_clinician_id)", java.lang.String .class,"onfocus"));
            __tag9.setOnblur(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("pract_change(forwarded_clinician_id)", java.lang.String .class,"onblur"));
            __tag9.setOnclick(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("delSelect1(forwarded_clinician_id)", java.lang.String .class,"onclick"));
            _activeTag=__tag9;
            __result__tag9 = __tag9.doStartTag();

            if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                }
            }
            if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag9);
                return;
            }
            _activeTag=__tag9.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
            __tag9.release();
            _bw.write(_wl_block29Bytes, _wl_block29);

	} // end of if(!(operation_mode.equals("MarkAsError")))

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(operation_mode));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(ca_practitioner_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(displayPracTable));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(displaySpecTable));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(prac_level));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(spec_level));
            _bw.write(_wl_block43Bytes, _wl_block43);

}
catch(Exception e)
{
	out.println("Exception @ finally RecClinicalNotesForward.jsp "+e.toString());
}
finally
{
	if(con!=null)	ConnectionManager.returnConnection(con,request);
}			

            _bw.write(_wl_block1Bytes, _wl_block1);
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
         com.iba.autocomplete.tags.IbaAutoCompleteSetupTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  com.iba.autocomplete.tags.IbaAutoCompleteSetupTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ForwardTo.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FacilityID.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FacilityID.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
