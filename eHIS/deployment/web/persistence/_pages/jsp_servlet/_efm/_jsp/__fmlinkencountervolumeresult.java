package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;
import org.json.simple.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmlinkencountervolumeresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMLinkEncounterVolumeResult.jsp", 1733194662180L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eFM/js/FMLinkEncounterVolume.js\'></script>\n</head>\n\n<body onMouseDown = \"CodeArrest();\" onKeyDown = \'lockKey();\' onKeyDown = \'lockKey();\'> \n<form name=\'FMLinkEncounterResultForm\' id=\'FMLinkEncounterResultForm\' action=\'FMLinkEncounterVolumeResult.jsp\' method=\'POST\'>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<table align=\'right\'><tr>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<td align =\'right\' id=\'prev\'><a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =", ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =")\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</a></td>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<td align =\'right\' id=\'next\' style=\'visibility:hidden\'><a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t</td></tr></table></p>\n\t<br><br>\t\t\t\t\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"1\">\n<tr>\n\t<td width=\"12%\" class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t<td width=\"11%\" class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t<td width=\"17%\" class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t<td width=\"20%\" class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t<td width=\"15%\" class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t<td width=\"5%\" class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t<td width=\"5%\" class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t<td width=\"5%\" nowrap class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n</tr>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t<tr>\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" nowrap>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" nowrap>\n\t\t\t<select name=\"file_volume";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" id=\"file_volume";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" onBlur=\"getSelectedValues(this, associate";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =")\" ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" >\n\t\t\t<option value=\"\">---";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="---</option>\n\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" >";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\t<option  value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' selected disabled>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t</select>\n\t\t\t</td>\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" align=\"CENTER\" nowrap><input type=\"checkbox\" name=\"associate";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" id=\"associate";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" onClick=\"getCheckedValues(this, file_volume";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" ></td>\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t<tr ><td colspan=\"8\" style=\'border:0px;\'> &nbsp;</td></tr>\n\t\t<tr ><td colspan=\"8\" align=\"right\" style=\'border:0px;\'><input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' onclick=\"showAuditTrail();\" ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="/></td></tr>\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t<script>\n\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\n\t\t\tparent.criteria_frame.document.forms[0].search.disabled = false;\n\t\t\tparent.criteria_frame.document.forms[0].clear_page.click();\t\tparent.patient_line_frame.document.location.href=\"../../eCommon/html/blank.html\";\tparent.result_frame.document.location.href=\"../../eCommon/html/blank.html\";\t\tparent.messageFrame.document.location.href=\"../../eCommon/jsp/error.jsp\";\n\t\t</script>\n\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n<SCRIPT >\ndocument.getElementById(\"next\").style.visibility=\'hidden\';\n</SCRIPT>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n<SCRIPT >\ndocument.getElementById(\"next\").style.visibility=\'visible\';\n</SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n</table>\n\n\t<input type=\"Hidden\" name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t<input type=\"Hidden\" name=\"to\" id=\"to\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t<input type=\"Hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t<input type=\"Hidden\" name=\"file_no\" id=\"file_no\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t<input type=\"Hidden\" name=\"file_type\" id=\"file_type\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t<input type=\"Hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t<input type=\"Hidden\" name=\"action_code\" id=\"action_code\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t<input type=\"Hidden\" name=\"record_count\" id=\"record_count\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t<input type=\"Hidden\" name=\"file_type_appl_yn\" id=\"file_type_appl_yn\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t<input type=\"Hidden\" name=\"valid_values\" id=\"valid_values\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\n<script>\n\tparent.patient_line_frame.document.location.href=\"../../eCommon/jsp/pline.jsp?Patient_ID=\"+\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\";\n\tparent.criteria_frame.document.forms[0].search.disabled = false;\n\tparent.criteria_frame.document.forms[0].patient_id.disabled = true;\n\tparent.criteria_frame.document.forms[0].pat_search.disabled = true;\n\t/*if (\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"==\"N\")\n\t\tparent.criteria_frame.document.forms[0].file_no.disabled = true;\n\telse if (\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"==\"Y\")\n\t\tparent.criteria_frame.document.forms[0].file_type.disabled = true;*/\n\tparent.criteria_frame.document.forms[0].action_code.disabled = true;\n</script>\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n<input type=\"Hidden\" name=\"patient_file_type\" id=\"patient_file_type\" value=\"\" >\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );


public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) || (inputString.equals("undefined"))) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) || (inputString.equals("")) || (inputString.equals("undefined"))) ? defaultValue : inputString);
}



    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");

            _bw.write(_wl_block1Bytes, _wl_block1);

Connection connection			=	null;
PreparedStatement preStatement	=	null;
PreparedStatement pStatement	=	null;
PreparedStatement prStatement	=	null;
ResultSet	resultSet			=	null;
ResultSet	rSet				=	null;
ResultSet	resSet				=	null;

String facilityID 			=	"";
String patient_id 			=	"";
String file_no	 			=	"";
String file_type 			=	"";
String action_code 			=	"";
String from		 			=	"";
String to		 			=	"";
//String searchYN	 			=	"N";
String file_type_appl_yn	=	"N";
String valid_values			=	"";
//String selected_values		=	"";
String patient_class_code	=	"";
String appl_to_op			=	"N";
String appl_to_dc			=	"N";
String appl_to_ip			=	"N";
String appl_to_em			=	"N";
String old_volume_no="";
int old_volumeno=0;
HashMap		keepRecord		=	null;
keepRecord	= new HashMap();

int volume_no 				=	-1;
int record_count			=	0;
int start					=	0 ;
int end						=	0 ;
int count					=	1 ;
int cnt						=	0 ;
int len=0 ,lk=0;
int len1=0;
StringBuffer sqlBuffer		=	new StringBuffer();
StringBuffer sqlQuery		=	new StringBuffer();
StringBuffer whereBuffer	=	new StringBuffer();
StringBuffer volumeBuffer	=	new StringBuffer();

try
{
	connection			=	ConnectionManager.getConnection(request);
	
	facilityID 			=	checkForNull((String) session.getValue("facility_id"));
	patient_id 			=	checkForNull(request.getParameter("patient_id"));
	file_no 			=	checkForNull(request.getParameter("file_no"));
	file_type 			=	checkForNull(request.getParameter("file_type"));
	action_code			=	checkForNull(request.getParameter("action_code"));
	file_type_appl_yn	=	checkForNull(request.getParameter("file_type_appl_yn"));
	from				=	checkForNull(request.getParameter("from"));
	to					=	checkForNull(request.getParameter("to"));
	//searchYN			=	checkForNull(request.getParameter("searchYN"));
	valid_values		=	checkForNull(request.getParameter("valid_values"));
	//selected_values		=	checkForNull(request.getParameter("selected_values"));
	
	if(from.equals("")) start = 1 ;
	else start = Integer.parseInt( from ) ;

	if(to.equals("")) end = 11 ;
	else end = Integer.parseInt( to ) ;

	if(!file_type.equals(""))
	{
		if(preStatement != null) preStatement = null;
		if(resultSet != null) resultSet = null;

		preStatement	= connection.prepareStatement("SELECT appl_to_op, appl_to_ip, appl_to_em, appl_to_dc FROM mr_file_type where facility_id = ? AND file_type_code = ? ");
		
		preStatement.setString(1, facilityID);
		preStatement.setString(2, file_type);

		resultSet		=	preStatement.executeQuery();
		
		if ((resultSet != null) && (resultSet.next()))
		{
			appl_to_op	=	checkForNull(resultSet.getString("appl_to_op"));	
			appl_to_ip	=	checkForNull(resultSet.getString("appl_to_ip"));	
			appl_to_em	=	checkForNull(resultSet.getString("appl_to_em"));	
			appl_to_dc	=	checkForNull(resultSet.getString("appl_to_dc"));	
		}

				if ((appl_to_ip.equals("Y"))&&(appl_to_op.equals("Y"))&&(appl_to_em.equals("Y"))&&(appl_to_dc.equals("Y")))
			patient_class_code	="";
		else{
			patient_class_code="('";
		if (appl_to_ip.equals("Y"))
			patient_class_code	=	patient_class_code+"IP";	
		if (appl_to_op.equals("Y")&& patient_class_code!="('")
			patient_class_code	=	patient_class_code+"','OP";	
		else if (appl_to_op.equals("Y"))
			patient_class_code	=	patient_class_code+"OP";	
		if (appl_to_em.equals("Y")&& patient_class_code!="('")
			patient_class_code	=	patient_class_code+"','EM";	
		else if (appl_to_em.equals("Y"))
			patient_class_code	=	patient_class_code+"EM";	
		if (appl_to_dc.equals("Y")&& patient_class_code!="('")
			patient_class_code	=	patient_class_code+"','DC";	
		else if (appl_to_dc.equals("Y"))
			patient_class_code	=	patient_class_code+"DC";	
		patient_class_code	=	patient_class_code+"')";
		}	
	}
		
	if(action_code.equals("L"))
	{
		if ((sqlBuffer != null) && (sqlBuffer.length() > 0))
		sqlBuffer.delete(0, sqlBuffer.length());
		sqlBuffer.append("SELECT" );
		sqlBuffer.append("  AM_GET_DESC.AM_PATIENT_CLASS(A.PATIENT_CLASS,'"+localeName+"','1') Encounter_Type" );
		sqlBuffer.append("  , A.Encounter_Id" );
		sqlBuffer.append("  , TO_CHAR(A.VISIT_ADM_DATE_TIME,'dd/mm/rrrr hh24:mi') Encounter_Date_Time" );
		sqlBuffer.append("  , AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,'"+localeName+"','1') Practitioner_Name" );
		sqlBuffer.append("  , AM_GET_DESC.AM_SPECIALITY(A.specialty_code,'"+localeName+"','2') Specialty" );
		sqlBuffer.append("  , DECODE(A.ASSIGN_CARE_LOCN_TYPE,'N',IP_GET_DESC.IP_NURSING_UNIT(A.FACILITY_ID, A.ASSIGN_CARE_LOCN_CODE,'"+localeName+"','1'), OP_GET_DESC.OP_CLINIC(A.FACILITY_ID, A.ASSIGN_CARE_LOCN_CODE,'"+localeName+"','1')) Location" );
		sqlBuffer.append("  , a.assign_care_locn_type" );
		sqlBuffer.append("  , a.Assign_Care_Locn_Code" );
		sqlBuffer.append("  , a.Patient_Class Patient_Class_Code " );
		sqlBuffer.append("FROM" );
		sqlBuffer.append("  pr_Encounter a " );

		if ((whereBuffer != null) && (whereBuffer.length() > 0))
			whereBuffer.delete(0, whereBuffer.length());
		whereBuffer.append("WHERE a.Facility_Id = '"+facilityID+"' " );
		whereBuffer.append("  AND a.Patient_Id = '"+patient_id+"' ");
	   whereBuffer.append("  AND a.discharge_date_time IS NOT NULL ");
		if (!patient_class_code.equals(""))
		{
		whereBuffer.append("AND a.patient_class IN ");
		whereBuffer.append(patient_class_code  );
		}
		whereBuffer.append("  AND NOT EXISTS (" );
		whereBuffer.append("  SELECT" );
		whereBuffer.append("    FACILITY_ID" );
		whereBuffer.append("    , ENCOUNTER_ID " );
		whereBuffer.append("  FROM" );
		whereBuffer.append("    FM_ENCOUNTER_VOLUME_LINK " );
		whereBuffer.append("  WHERE FACILITY_ID = A.FACILITY_ID " );
		whereBuffer.append("    AND ENCOUNTER_ID = A.ENCOUNTER_ID" );
		whereBuffer.append("  ) " );
		
		sqlBuffer.append(whereBuffer.toString());
		sqlBuffer.append(" ORDER BY to_date(encounter_date_time, 'dd/mm/rrrr hh24:mi'), encounter_type, a.encounter_id");
	 		if ((sqlQuery != null) && (sqlQuery.length() > 0))
			sqlQuery.delete(0, sqlQuery.length());
	}
	else if((action_code.equals("D")) || (action_code.equals("C")))
	{
			if ((sqlBuffer != null) && (sqlBuffer.length() > 0))
			sqlBuffer.delete(0, sqlBuffer.length());

		sqlBuffer.append("SELECT" );
		sqlBuffer.append("  AM_GET_DESC.AM_PATIENT_CLASS(A.PATIENT_CLASS,'"+localeName+"','1') Encounter_Type" );
		sqlBuffer.append("  , e.Encounter_Id" );
		sqlBuffer.append("  , TO_CHAR(e.Encounter_Date_Time,'dd/mm/rrrr hh24:mi') Encounter_Date_Time" );
		sqlBuffer.append("  , AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,'"+localeName+"','1') Practitioner_Name" );
		sqlBuffer.append("  , AM_GET_DESC.AM_SPECIALITY(A.specialty_code,'"+localeName+"','2') Specialty" );
		sqlBuffer.append("  , DECODE(A.ASSIGN_CARE_LOCN_TYPE,'N',IP_GET_DESC.IP_NURSING_UNIT(A.FACILITY_ID, A.ASSIGN_CARE_LOCN_CODE,'"+localeName+"','1'), OP_GET_DESC.OP_CLINIC(A.FACILITY_ID, A.ASSIGN_CARE_LOCN_CODE,'"+localeName+"','1')) Location" );
		sqlBuffer.append("  , a.Assign_Care_Locn_Code" );
		sqlBuffer.append("  , a.Assign_Care_Locn_Type" );
		sqlBuffer.append("  , a.Patient_Class Patient_Class_Code" );
		sqlBuffer.append("  , e.Volume_No File_Volume " );
		sqlBuffer.append("FROM" );
		sqlBuffer.append("  pr_Encounter a" );
		sqlBuffer.append("  , fm_Encounter_Volume_Link e  " );

		if ((whereBuffer != null) && (whereBuffer.length() > 0))
			whereBuffer.delete(0, whereBuffer.length());

		whereBuffer.append(" WHERE a.Encounter_Id = e.Encounter_Id (+) " );
		whereBuffer.append("  AND a.Facility_Id = e.Facility_Id (+) " );
		whereBuffer.append("  AND a.Facility_Id = '"+facilityID+"' " );
		whereBuffer.append("  AND a.Patient_Id = '"+patient_id+"' " );
		if (!patient_class_code.equals(""))
		{
		whereBuffer.append("  AND a.Patient_Class IN ");
		whereBuffer.append(patient_class_code);
		}

		if (!file_no.equals(""))
		{
			whereBuffer.append(" AND e.file_no = '");
			whereBuffer.append(file_no);
			whereBuffer.append("' ");
		}
		
		if (!file_type.equals(""))
		{
			whereBuffer.append(" AND e.file_type_code = '");
			whereBuffer.append(file_type);
			whereBuffer.append("' ");
		}
		sqlBuffer.append(whereBuffer.toString());
		sqlBuffer.append(" ORDER BY a.VISIT_ADM_DATE_TIME, a.encounter_id");
				if ((sqlQuery != null) && (sqlQuery.length() > 0))
			sqlQuery.delete(0, sqlQuery.length());
	}

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	if(resultSet!=null)	resultSet.close();
	if(preStatement!=null) preStatement.close();
	/*preStatement	=	connection.prepareStatement(sqlQuery.toString());
	resultSet		=	preStatement.executeQuery();
	if ((resultSet != null) && (resultSet.next()))
		record_count	=	resultSet.getInt("record_count");*/

//if ((!(start <= 1)) || (!( (start+11) > record_count )))
//{
	
            _bw.write(_wl_block7Bytes, _wl_block7);

	if ( !(start <= 1) )
	{
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(start-11));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(end-11));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

	}
			
	//if ( !( (start+11) > record_count ) )
//	{
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((start+11)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(end+11));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

//	}
	
            _bw.write(_wl_block13Bytes, _wl_block13);

//}

            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

		if (action_code.equals("L"))
		{
	
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

		}
		else if (action_code.equals("D"))
		{
	
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

		}
		else if (action_code.equals("C"))
		{
	
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

		}
	
            _bw.write(_wl_block23Bytes, _wl_block23);

	if(resultSet!=null)	resultSet.close();
	if(preStatement!=null) preStatement.close();

	String encounter_type_value			=	"&nbsp;";
	String encounter_id_value			=	"&nbsp;";
	String encounter_date_time_value	=	"&nbsp;";
	String class_value					=	"QRYEVEN";
	String practitioner					=	"&nbsp;";
	String specialty					=	"&nbsp;";
	String location						=	"&nbsp;";
	//String assign_care_locn_type		=	"";
	//String assign_care_locn_code		=	"";
	String patient_class				=	"";
	String check_attribute				=	"";
	String select_attribute				=	"";
	String disable_attribute			=	"";
	StringBuffer associate_value		=	new StringBuffer();
	
	preStatement	=	connection.prepareStatement(sqlBuffer.toString());
	resultSet		=	preStatement.executeQuery();
	
	if (resultSet != null)
	{
		if ( start != 1 )
			for( int j=1; j<start; count++,j++ )
				resultSet.next() ;
		int strCount					= 0;		
		int validCount					= 0;
		int volume_no_val				= -1;
		StringTokenizer strToken		= null;
		StringTokenizer validToken		= null;		
		
		String select_value	= "";
		String check_value	= "";
		String tokenValue	= "";		

		 len =keepRecord.size();
		
		if( (action_code.equals("L")) || (action_code.equals("C")))
		{
						
			if((volumeBuffer != null) && (volumeBuffer.length() > 0))
			volumeBuffer.delete(0, volumeBuffer.length());
			
			if(len==0)
			{
			volumeBuffer.append("SELECT volume_no FROM fm_curr_locn WHERE facility_id = '");
			volumeBuffer.append(facilityID);
			volumeBuffer.append("' and patient_id = '");
			volumeBuffer.append(patient_id);
			volumeBuffer.append("' ");
			if (!file_no.equals(""))
			{
				volumeBuffer.append(" AND file_no = '");
				volumeBuffer.append(file_no);
					if(file_type_appl_yn.equals("Y"))
				  {
					volumeBuffer.append("' ");
				}
				}
			if (!file_type.equals(""))
			{
				volumeBuffer.append(" AND file_type_code = '");
				volumeBuffer.append(file_type);
				}
			volumeBuffer.append("' ORDER BY volume_no");		
		
			prStatement	= connection.prepareStatement(volumeBuffer.toString());
		}
		}
		
		
		while(resultSet.next() && count <= end)
		{
			select_attribute = "";
			encounter_type_value		= checkForNull(resultSet.getString("encounter_type"));
			encounter_id_value			= checkForNull(resultSet.getString("encounter_id"));
			encounter_date_time_value	= checkForNull(resultSet.getString("encounter_date_time"));
			if(!encounter_date_time_value.equals(""))
			encounter_date_time_value=DateUtils.convertDate(encounter_date_time_value,"DMYHM","en",localeName);

			practitioner				= checkForNull(resultSet.getString("practitioner_name"), "&nbsp;");
			specialty					= checkForNull(resultSet.getString("specialty"));
			if ((action_code.equals("D")) || (action_code.equals("C")))
				volume_no				= resultSet.getInt("file_volume");
			
			//assign_care_locn_type	= checkForNull(resultSet.getString("assign_care_locn_type"));
			//assign_care_locn_code	= checkForNull(resultSet.getString("assign_care_locn_code"));
			patient_class			= checkForNull(resultSet.getString("patient_class_code"));
			location				= checkForNull(resultSet.getString("location"));

			if ((associate_value != null) && (associate_value.length() > 0))
				associate_value.delete(0, associate_value.length());
			
			associate_value.append(encounter_id_value);	
			associate_value.append("||");	
			if (file_no.equals(""))
				 associate_value.append("$$");
			else associate_value.append(file_no);	
			associate_value.append("||");	
			if (file_type.equals(""))
				 associate_value.append("$$");
			else associate_value.append(file_type);	
			associate_value.append("||");	
			associate_value.append(encounter_date_time_value);	
			associate_value.append("||");	
			associate_value.append(patient_class);	
			
			if ((!valid_values.equals("")) && (!valid_values.equals(",")))
			{
				strToken	=  new StringTokenizer(valid_values, ",");
				strCount = strToken.countTokens();
			}
			
			check_attribute = "";
			
			for (int i=0; i<strCount; i++)
			{
				tokenValue = checkForNull(strToken.nextToken());
				validToken = new StringTokenizer(tokenValue, "^^");
				validCount = validToken.countTokens();
				for (int j=0; j< validCount; j++)
				{
					select_value	=	"";
					if (validToken.hasMoreTokens())
					check_value		=	checkForNull(validToken.nextToken());
					if (validToken.hasMoreTokens())
						select_value =	checkForNull(validToken.nextToken());
					if (check_value.equals(associate_value.toString()))
						check_attribute = "Checked";
				}
			}
			
			if(class_value.equals("QRYEVEN"))
				class_value = "QRYODD";
			else
				class_value = "QRYEVEN";
			if (action_code.equals("D"))
				 disable_attribute	=	"Disabled";
			else disable_attribute	=	"";
		
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(encounter_type_value));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(encounter_id_value));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(encounter_date_time_value));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(practitioner));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(specialty));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(location));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(count));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(count));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(count));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(disable_attribute));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

				
			len1=keepRecord.size();
				if( (action_code.equals("L")) || (action_code.equals("C")) )
				{
					if(len1==0)
					resSet	= prStatement.executeQuery();
					
					if(resSet != null)
					{
						if(action_code.equals("C"))
						{
							if(len1==0)
							{
							
							while(resSet.next())
							{
								if(volume_no == resSet.getInt("volume_no"))
									select_attribute = "Selected";
								else
									select_attribute = "";
							
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(resSet.getInt("volume_no")));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(select_attribute));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(resSet.getInt("volume_no")));
            _bw.write(_wl_block36Bytes, _wl_block36);

							keepRecord.put(lk ,resSet.getString("volume_no"));
								lk++;
								}
							}else{
                        
						 for(int k=0; k<len1 ;k++)
							   {
							   old_volume_no =(String) keepRecord.get(k);
								if(old_volume_no!=null)
								old_volumeno=Integer.parseInt(old_volume_no);
                                if(volume_no == old_volumeno)
									select_attribute = "Selected";
								else
									select_attribute = "";
							
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(old_volumeno));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(select_attribute));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(old_volumeno));
            _bw.write(_wl_block36Bytes, _wl_block36);


							   }
							}
											
						}
						else if(action_code.equals("L"))
						{
							if(len1==0)
							{
							while(resSet.next())
							{
								select_attribute = "";
								if ((!valid_values.equals("")) && (!valid_values.equals(",")))
								{
									strToken =  new StringTokenizer(valid_values, ",");
									strCount = strToken.countTokens();
								}
								
								for (int i=0; i<strCount; i++)
								{
									tokenValue = checkForNull(strToken.nextToken());
									validToken = new StringTokenizer(tokenValue, "^^");
									validCount = validToken.countTokens();
									for (int j=0; j< validCount; j++)
									{
										check_value		=	"";
										select_value	=	"";	
										if (validToken.hasMoreTokens())
											check_value =	checkForNull(validToken.nextToken());
										if (validToken.hasMoreTokens())
											select_value =	checkForNull(validToken.nextToken(), "@");
										
										if ((!select_value.equals("@")) && (!select_value.equals("")))
											volume_no_val = Integer.parseInt(select_value);
										else volume_no_val = -1;
										
										if ((check_value.equals(associate_value.toString())) && (resSet.getInt("volume_no")==volume_no_val))
												select_attribute = "Selected";
									}
								}
														
							
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(resSet.getInt("volume_no")));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(select_attribute));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(resSet.getInt("volume_no")));
            _bw.write(_wl_block36Bytes, _wl_block36);

						  keepRecord.put(lk,resSet.getString("volume_no"));
							lk++;	
								}
						} else {
                     								
								for(int k=0; k<len1 ;k++)
							   {
							  old_volume_no =(String) keepRecord.get(k);
								if(old_volume_no!=null)
							old_volumeno=Integer.parseInt(old_volume_no);
							
								select_attribute = "";
								if ((!valid_values.equals("")) && (!valid_values.equals(",")))
								{
									strToken =  new StringTokenizer(valid_values, ",");
									strCount = strToken.countTokens();
								}
								for (int i=0; i<strCount; i++)
								{
									tokenValue = checkForNull(strToken.nextToken());
									validToken = new StringTokenizer(tokenValue, "^^");
									validCount = validToken.countTokens();
									for (int j=0; j< validCount; j++)
									{
										check_value		=	"";
										select_value	=	"";	
										if (validToken.hasMoreTokens())
											check_value =	checkForNull(validToken.nextToken());
										if (validToken.hasMoreTokens())
											select_value =	checkForNull(validToken.nextToken(), "@");
										
										if ((!select_value.equals("@")) && (!select_value.equals("")))
											volume_no_val = Integer.parseInt(select_value);
										else volume_no_val = -1;
										
										if ((check_value.equals(associate_value.toString())) && (old_volumeno == volume_no_val))
												select_attribute = "Selected";
									}
								}
							
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(old_volumeno));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(select_attribute));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(old_volumeno));
            _bw.write(_wl_block36Bytes, _wl_block36);

							   }
                			}
						
								}
					}
				}
				else if(action_code.equals("D"))
				{
					
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block40Bytes, _wl_block40);

				}

			
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(count));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(count));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(associate_value.toString()));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(count));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(check_attribute));
            _bw.write(_wl_block46Bytes, _wl_block46);

			count++;
			cnt++;
		}

		JSONObject jsonObj  =  eFM.FMLinkEncFileVolumeBean.getEncFileVolumeAuditDtls(connection,patient_id,file_no,file_type,localeName,1,14);
		JSONArray fileVolumeAuditDtlsArr 			= (JSONArray)jsonObj.get("fileVolumeAuditDtls");
		int fileVolumeAuditDtlCount					= fileVolumeAuditDtlsArr.size();
		String auditTrailDisplay					= "";
		if(fileVolumeAuditDtlCount==0){
			auditTrailDisplay	= "disabled";
		}


            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(auditTrailDisplay));
            _bw.write(_wl_block49Bytes, _wl_block49);
	}
	if(cnt == 0)
	{
		
            _bw.write(_wl_block50Bytes, _wl_block50);

	}
		if(cnt<11){


            _bw.write(_wl_block51Bytes, _wl_block51);
} else {
            _bw.write(_wl_block52Bytes, _wl_block52);
}
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(from));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(to));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(file_no));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(file_type));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(action_code));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(record_count));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(file_type_appl_yn));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(valid_values));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(file_type_appl_yn));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(file_type_appl_yn));
            _bw.write(_wl_block66Bytes, _wl_block66);

if(resultSet!=null)	resultSet.close();
if(rSet!=null)	rSet.close();
if(resSet!=null)	resSet.close();	
if(preStatement!=null) preStatement.close();
if(pStatement!=null) pStatement.close();
if(prStatement!=null) prStatement.close();
}
catch(Exception e)
{
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(connection,request);
}

            _bw.write(_wl_block67Bytes, _wl_block67);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encountertype.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterdatetime.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.FileVolume.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Link.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.De-Link.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.change.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AuditTrail.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }
}
