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
import java.util.StringTokenizer;
import java.util.*;
import com.ehis.util.*;

public final class __dtlinkencountervolumedoctyperesult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/DTLinkEncounterVolumeDocTypeResult.jsp", 1709116821935L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMLinkEncounterVolume.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<script>\n\t\t/*\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\n\t\t\tparent.criteria_frame.document.forms[0].search.disabled = false;\n\t\t\tparent.criteria_frame.document.location.reload();\n\t\t\tparent.tab_frame.document.location.href=\"../../eCommon/html/blank.html\";\n\t\t\tparent.result_frame.document.location.href=\"../../eCommon/html/blank.html\";\n\t\t\tparent.messageFrame.document.location.href=\"../../eCommon/jsp/error.jsp\";*/\n\t\t</script>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<body onMouseDown = \"CodeArrest();\" onLoad=\"FocusFirstElement();\" onKeyDown = \'lockKey();\'> \n<form name=\'DTLinkEncounterResultForm\' id=\'DTLinkEncounterResultForm\' action=\'DTLinkEncounterVolumeDocTypeResult.jsp\' method=\'POST\'>\n<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<tr><td colspan=\"6\">\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t</td></tr>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\t\n</table>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<table align=\'right\'><tr>\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<td align =\'right\' id=\'prev\'>\t<a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =", ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =")\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</a></td>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t<td align =\'right\' id=\'nextid\' style=\'visibility:hidden\'><a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t</tr></table></p>\n\t\t<br><br>\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"1\">\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n<tr>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\t\n\t<td width=\"15%\" class=\'columnheader\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t<td width=\"15%\" class=\'columnheader\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t<td width=\"15%\" class=\'columnheader\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t<td width=\"20%\" class=\'columnheader\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t<td width=\"5%\" class=\'columnheader\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n</tr>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n<tr>\n\t<td width=\"15%\" class=\'columnheader\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t<td width=\"5%\" class=\'columnheader\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t<td width=\"18%\" class=\'columnheader\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t<td width=\"12%\" class=\'columnheader\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\t<td width=\"5%\" nowrap class=\'columnheader\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n</tr>\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" nowrap>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="<input type=\'Hidden\' name=\'patient_id";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' id=\'patient_id";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"></td>\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\n\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" nowrap><a href=\"javascript:getDocuments(";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =", \'\',";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =")\">";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =",";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="<input type=\"hidden\" name=\"encounter_date";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" id=\"encounter_date";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"></td>\n\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" align=\"CENTER\">";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" nowrap align=\"CENTER\"><input type=\"checkbox\" name=\"delink";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" id=\"delink";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" onClick=\"getRelatedRecords(this)\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="></td>\n\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n<SCRIPT>\n\tdocument.getElementById(\"nextid\").style.visibility=\'hidden\';\n</SCRIPT>\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n<SCRIPT>\n\tdocument.getElementById(\"nextid\").style.visibility=\'visible\';\n</SCRIPT>\n\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n<script>\n\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\n\t\t\tparent.criteria_frame.document.forms[0].search.disabled = false;\n\t\t\t/*parent.criteria_frame.document.location.reload();\n\t\t\tparent.tab_frame.document.location.href=\"../../eCommon/html/blank.html\";\n\t\t\tparent.result_frame.document.location.href=\"../../eCommon/html/blank.html\";\n\t\t\tparent.messageFrame.document.location.href=\"../../eCommon/jsp/error.jsp\";*/\n\t\t</script>\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\n</table>\n\t<input type=\"Hidden\" name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t<input type=\"Hidden\" name=\"to\" id=\"to\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t<input type=\"Hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t<input type=\"Hidden\" name=\"file_no\" id=\"file_no\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t<input type=\"Hidden\" name=\"file_type\" id=\"file_type\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t<input type=\"Hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t<input type=\"Hidden\" name=\"action_code\" id=\"action_code\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t<input type=\"Hidden\" name=\"record_count\" id=\"record_count\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t<input type=\"Hidden\" name=\"file_type_appl_yn\" id=\"file_type_appl_yn\" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t<input type=\"Hidden\" name=\"valid_values\" id=\"valid_values\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t<input type=\"Hidden\" name=\"from_period\" id=\"from_period\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t<input type=\"Hidden\" name=\"to_period\" id=\"to_period\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t<script>\n\tvar patient_id = \"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\";\n\tif(\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\"==\"L\")\n\tparent.tab_frame.document.location.href=\"../../eFM/jsp/DTLinkEncounterVolumeDocTabs.jsp\";\n\telse if(\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\"==\"D\")\n\tparent.tab_frame.document.location.href=\"../../eCommon/jsp/pline.jsp?Patient_ID=\"+patient_id;\n\t\n\tparent.criteria_frame.document.forms[0].search.disabled = false;\n\tif(\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\"!=\"D\")\n\t{\n\t\tparent.criteria_frame.document.forms[0].action_code.disabled = true;\n\t\tparent.criteria_frame.document.forms[0].patient_id.disabled = true;\n\t\tparent.criteria_frame.document.forms[0].pat_search.disabled = true;\n\t}\n\telse parent.criteria_frame.document.forms[0].doc_folder_id.disabled = true;\n\tparent.messageFrame.document.location.href=\"../../eCommon/jsp/error.jsp\";\n\t</script>\n";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t<input type=\"Hidden\" name=\"encounter_date_time\" id=\"encounter_date_time\" value=\"\"> \n\t<input type=\"Hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"\"> \n\t<input type=\"Hidden\" name=\"volume_no\" id=\"volume_no\" value=\"\"> \n\t<input type=\"Hidden\" name=\"doc_folder_id\" id=\"doc_folder_id\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\"> \n\t<input type=\"Hidden\" name=\"maintain_doc_or_file\" id=\"maintain_doc_or_file\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\"> \n\t<input type=\"Hidden\" name=\"patient_period_specific\" id=\"patient_period_specific\" value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\"> \n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );
	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
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


Connection connection			=	null;
PreparedStatement preStatement	=	null;
PreparedStatement pStatement	=	null;
PreparedStatement prStatement	=	null;
ResultSet	resultSet			=	null;
ResultSet	rSet				=	null;
ResultSet	resSet				=	null;

String facilityID 				=	"";
String patient_id 				=	"";
String patient_id_value			=	"";
String file_no	 				=	"";
String file_type 				=	"";
String action_code 				=	"";
String from		 				=	"";
String to		 				=	"";
String file_type_appl_yn		=	"N";
String valid_values				=	"";
String patient_class_code		=	"";
String maintain_doc_or_file		=	"";
String doc_folder_id			=	"";
String appl_to_op				=	"N";
String appl_to_dc				=	"N";
String appl_to_ip				=	"N";
String appl_to_em				=	"N";
String class_value				=	"QRYEVEN";
String patient_period_specific	=	"";
String from_period				=	"";
String to_period				=	"";

int record_count			=	0;
int start					=	0 ;
int end						=	0 ;
int count					=	1 ;
int increment				=	15 ;

StringBuffer sqlBuffer		=	new StringBuffer();
StringBuffer sqlQuery		=	new StringBuffer();
StringBuffer whereBuffer	=	new StringBuffer();

try
{
	connection				=	ConnectionManager.getConnection(request);	
	
	facilityID 				=	checkForNull((String) session.getValue("facility_id"));
	patient_id 				=	checkForNull(request.getParameter("patient_id"));
	file_no 				=	checkForNull(request.getParameter("file_no"));
	file_type 				=	checkForNull(request.getParameter("file_type"));
	action_code				=	checkForNull(request.getParameter("action_code"));
	file_type_appl_yn		=	checkForNull(request.getParameter("file_type_appl_yn"));
	from					=	checkForNull(request.getParameter("from"));
	to						=	checkForNull(request.getParameter("to"));	
	valid_values			=	checkForNull(request.getParameter("valid_values"));
	maintain_doc_or_file	=	checkForNull(request.getParameter("maintain_doc_or_file"));
	patient_period_specific	=	checkForNull(request.getParameter("patient_period_specific"));
	doc_folder_id			=	checkForNull(request.getParameter("doc_folder_id"));
	from_period				=	checkForNull(request.getParameter("from_period"));
	to_period				=	checkForNull(request.getParameter("to_period"));
	
	if (maintain_doc_or_file.equals("F"))
		increment	=15;
	else if (maintain_doc_or_file.equals("D") && patient_period_specific.equals("D"))
		increment	=	17;
	else if (maintain_doc_or_file.equals("D") && patient_period_specific.equals("P"))
		increment	=	16;

	if (from.equals(""))
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if (to.equals(""))
		end = increment ;
	else
		end = Integer.parseInt( to ) ;

	if (maintain_doc_or_file.equals("F"))
	{
		if (!file_type.equals(""))
		{
			if (preStatement != null)	preStatement = null;
			if (resultSet != null)	resultSet = null;

			preStatement	=	connection.prepareStatement("SELECT appl_to_op, appl_to_ip, appl_to_em, appl_to_dc FROM mr_file_type where facility_id = ? AND file_type_code = ? ");
			
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

		if ((!file_type.equals("")) && (file_no.equals("")))
		{
			if(resultSet!=null)	resultSet.close();
		if(preStatement!=null)  preStatement.close();

			preStatement	=	connection.prepareStatement("SELECT file_no FROM mr_pat_file_index where facility_id = ? AND file_type_code = ? AND patient_id = ?");
			
			preStatement.setString(1, facilityID);
			preStatement.setString(2, file_type);
			preStatement.setString(3, patient_id);

			resultSet		=	preStatement.executeQuery();
			if ((resultSet != null) && (resultSet.next()))
				file_no		=	checkForNull(resultSet.getString("file_no"));	
		}


		if (action_code.equals("L"))
		{
			if ((sqlBuffer != null) && (sqlBuffer.length() > 0))
				sqlBuffer.delete(0, sqlBuffer.length());

			//sqlBuffer.append("SELECT   b.short_desc encounter_type, e.encounter_id, TO_CHAR (e.encounter_date_time, 'dd/mm/rrrr hh24:mi' ) encounter_date_time, c.practitioner_name, d.short_desc specialty, Decode(a.PATIENT_CLASS, 'IP', (select short_desc from ip_nursing_unit where facility_id = a.facility_id and nursing_unit_code = a.assign_care_locn_code), (select short_desc from Op_Clinic where  facility_id = a.facility_id and clinic_code = a.assign_care_locn_code)) location, a.assign_care_locn_code, a.patient_class patient_class_code, e.volume_no  FROM pr_encounter a, am_patient_class b, am_practitioner c, am_speciality d, fm_encounter_volume_link e ");
			sqlBuffer.append("SELECT   b.Short_desc Encounter_Type,");
			sqlBuffer.append("          e.Encounter_Id,");
			sqlBuffer.append("          To_char(e.Encounter_Date_Time,'dd/mm/rrrr hh24:mi') encounter_date_time,");
			sqlBuffer.append("          c.Practitioner_Name,");
			sqlBuffer.append("          d.Short_desc Specialty,");
			sqlBuffer.append("          DECODE(a.Patient_Class,'IP',(SELECT long_desc");
			sqlBuffer.append("                                       FROM   ");
			sqlBuffer.append("                                        ip_nurSing_Unit_lang_vw");
			sqlBuffer.append("                                       WHERE  Facility_Id = a.Facility_Id");
			sqlBuffer.append("                                              AND nurSing_Unit_Code = a.Assign_Care_Locn_Code");
			sqlBuffer.append("                                              AND Language_Id = '"+localeName+"'),");
			sqlBuffer.append("                                 (SELECT long_desc");
			sqlBuffer.append("                                  FROM   ");
			sqlBuffer.append("                                   op_Clinic_lang_vw");
			sqlBuffer.append("                                  WHERE  Facility_Id = a.Facility_Id");
			sqlBuffer.append("                                         AND Clinic_Code = a.Assign_Care_Locn_Code");
			sqlBuffer.append("                                         AND Language_Id = '"+localeName+"')) Location,");
			sqlBuffer.append("          a.Assign_Care_Locn_Code,");
			sqlBuffer.append("          a.Patient_Class Patient_Class_Code,");
			sqlBuffer.append("          e.Volume_No");
			sqlBuffer.append(" FROM     ");
			sqlBuffer.append("   pr_Encounter a,");
			sqlBuffer.append("   Am_Patient_Class_lang_vw b,");
			sqlBuffer.append("   Am_Practitioner_lang_vw c,");
			sqlBuffer.append("   Am_SpecialIty_lang_vw d,");
			sqlBuffer.append("   fm_Encounter_Volume_Link e");

			if ((whereBuffer != null) && (whereBuffer.length() > 0))
				whereBuffer.delete(0, whereBuffer.length());
			    
			whereBuffer.append(" WHERE    a.Encounter_Id = e.Encounter_Id (+) ");
			whereBuffer.append("          AND a.Facility_Id = e.Facility_Id");
			whereBuffer.append("          AND a.Patient_Class = b.Patient_Class");
			whereBuffer.append("          AND a.Attend_Practitioner_Id = c.Practitioner_Id (+) ");
			whereBuffer.append("          AND a.Specialty_Code = d.SpecialIty_Code");
			whereBuffer.append("          AND b.language_id='"+localeName+"'");
			whereBuffer.append("          AND b.language_id = c.language_id");
			whereBuffer.append("          AND c.language_id = d.language_id");
			whereBuffer.append("          AND a.Facility_Id = '"+facilityID+"'");
			whereBuffer.append("          AND a.Patient_Id = '"+patient_id+"' ");
			
			if (!patient_class_code.equals(""))
			{
				whereBuffer.append(" AND a.patient_class in ");
				whereBuffer.append(patient_class_code);
			}

			
			sqlBuffer.append(whereBuffer.toString());
			sqlBuffer.append(" ORDER BY to_date(encounter_date_time, 'dd/mm/rrrr hh24:mi'), encounter_type, a.encounter_id");

			if ((sqlQuery != null) && (sqlQuery.length() > 0))
				sqlQuery.delete(0, sqlQuery.length());
			sqlQuery.append("SELECT count(*) record_count FROM pr_encounter a, Am_Patient_Class_lang_vw b , Am_Practitioner_lang_vw c, Am_SpecialIty_lang_vw d, fm_encounter_volume_link e ");
			sqlQuery.append(whereBuffer.toString());
		}
		else if (action_code.equals("D"))
		{
			if ((sqlBuffer != null) && (sqlBuffer.length() > 0))
				sqlBuffer.delete(0, sqlBuffer.length());

			//sqlBuffer.append("SELECT b.short_desc encounter_type, a.encounter_id, to_char(a.encounter_date_time, 'dd/mm/rrrr hh24:mi') encounter_date_time, d.practitioner_name, e.short_desc specialty, c.assign_care_locn_code, Decode(c.PATIENT_CLASS, 'IP', (select short_desc from ip_nursing_unit where facility_id = c.facility_id and nursing_unit_code = c.assign_care_locn_code), (select short_desc from Op_Clinic where 		 facility_id = c.facility_id and clinic_code = c.assign_care_locn_code)) location,c.patient_class patient_class_code , a.volume_no , a.doc_type_code, f.doc_type_name, f.doc_no FROM fm_encounter_doc_type_link a, am_patient_class b, pr_encounter c, am_practitioner d, am_speciality e, fm_doc_type f ");
			sqlBuffer.append("SELECT   b.Short_desc Encounter_Type,");
			sqlBuffer.append("          a.Encounter_Id,");
			sqlBuffer.append("          To_char(a.Encounter_Date_Time,'dd/mm/rrrr hh24:mi') Encounter_Date_Time,");
			sqlBuffer.append("          d.Practitioner_Name,");
			sqlBuffer.append("          e.Short_desc Specialty,");
			sqlBuffer.append("          c.Assign_Care_Locn_Code,");
			sqlBuffer.append("          DECODE(c.Patient_Class,'IP',(SELECT long_desc");
			sqlBuffer.append("                                       FROM   ");
			sqlBuffer.append("                                        ip_nurSing_Unit_lang_vw");
			sqlBuffer.append("                                       WHERE  Facility_Id = c.Facility_Id");
			sqlBuffer.append("                                              AND nurSing_Unit_Code = c.Assign_Care_Locn_Code");
			sqlBuffer.append("                                              AND Language_Id = '"+localeName+"'),");
			sqlBuffer.append("                                 (SELECT long_desc");
			sqlBuffer.append("                                  FROM   ");
			sqlBuffer.append("                                   op_Clinic_lang_vw");
			sqlBuffer.append("                                  WHERE  Facility_Id = c.Facility_Id");
			sqlBuffer.append("                                         AND Clinic_Code = c.Assign_Care_Locn_Code");
			sqlBuffer.append("                                         AND Language_Id = '+localeName+')) Location,");
			sqlBuffer.append("          c.Patient_Class Patient_Class_Code,");
			sqlBuffer.append("          a.Volume_No,");
			sqlBuffer.append("          a.Doc_Type_Code,");
			sqlBuffer.append("          f.Doc_Type_Name,");
			sqlBuffer.append("          f.Doc_No");
			sqlBuffer.append(" FROM     ");
			sqlBuffer.append("   fm_Encounter_Doc_Type_Link a,");
			sqlBuffer.append("   Am_Patient_Class_lang_vw b,");
			sqlBuffer.append("   pr_Encounter c,");
			sqlBuffer.append("   Am_Practitioner_lang_vw d,");
			sqlBuffer.append("   Am_SpecialIty_lang_vw e,");
			sqlBuffer.append("   fm_Doc_Type_lang_vw f");

			if ((whereBuffer != null) && (whereBuffer.length() > 0))
				whereBuffer.delete(0, whereBuffer.length());
			whereBuffer.append(" WHERE    a.Patient_Class = b.Patient_Class");
			whereBuffer.append("          AND a.Patient_Id = c.Patient_Id");
			whereBuffer.append("          AND a.Encounter_Id = c.Encounter_Id");
			whereBuffer.append("          AND a.Facility_Id = c.Facility_Id");
			whereBuffer.append("          AND c.Attend_Practitioner_Id = d.Practitioner_Id (+) ");
			whereBuffer.append("          AND c.Specialty_Code = e.SpecialIty_Code");
			whereBuffer.append("          AND a.Doc_Type_Code = f.Doc_Type_Code");
			whereBuffer.append("		   AND a.facility_id = '");
			whereBuffer.append(facilityID);
			whereBuffer.append("' AND a.patient_id = '");
			whereBuffer.append(patient_id);
			whereBuffer.append("' ");

			if (!file_no.equals(""))
			{
				whereBuffer.append(" AND a.file_no = '");
				whereBuffer.append(file_no);
				whereBuffer.append("' ");
			}
			
			if (!file_type.equals(""))
			{
				whereBuffer.append(" AND a.file_type_code = '");
				whereBuffer.append(file_type);
				whereBuffer.append("' ");
			}
			whereBuffer.append("          AND b.Language_Id = '"+localeName+"'");
			whereBuffer.append("          AND b.Language_Id = d.Language_Id");
			whereBuffer.append("          AND d.Language_Id = e.Language_Id");
			whereBuffer.append("          AND e.Language_Id = f.Language_Id");
			sqlBuffer.append(whereBuffer.toString());
			sqlBuffer.append(" ORDER BY a.encounter_date_time, a.encounter_id");

			if ((sqlQuery != null) && (sqlQuery.length() > 0))
				sqlQuery.delete(0, sqlQuery.length());
			sqlQuery.append("SELECT count(*) record_count FROM fm_encounter_doc_type_link a, Am_Patient_Class_lang_vw b  , pr_encounter c, Am_Practitioner_lang_vw d, Am_SpecialIty_lang_vw e , fm_doc_type f ");
			sqlQuery.append(whereBuffer.toString());
		}
	}
	else if (maintain_doc_or_file.equals("D"))
	{
		if ((sqlBuffer != null) && (sqlBuffer.length() > 0))
			sqlBuffer.delete(0, sqlBuffer.length());

		sqlBuffer.append("SELECT b.short_desc encounter_type, a.encounter_id, to_char(a.visit_adm_date_time, 'dd/mm/rrrr hh24:mi') encounter_date_time, c.practitioner_name, d.short_desc specialty, a.assign_care_locn_code, Decode(a.PATIENT_CLASS, 'IP', (select long_desc from ip_nursing_unit where facility_id = a.facility_id and nursing_unit_code = a.assign_care_locn_code), (select long_desc from Op_Clinic where facility_id = a.facility_id and clinic_code = a.assign_care_locn_code)) location, a.patient_class patient_class_code, a.patient_id, decode('"+localeName+"', 'en', e.patient_name, nvl(e.patient_name_loc_lang, e.patient_name)) patient_name ");
		sqlBuffer.append(" FROM pr_encounter a, Am_Patient_Class_lang_vw b , Am_Practitioner_lang_vw c, Am_SpecialIty_lang_vw d, mp_patient e ");

		if ((whereBuffer != null) && (whereBuffer.length() > 0))
			whereBuffer.delete(0, whereBuffer.length());
		whereBuffer.append("WHERE e.patient_id = a.patient_id AND a.patient_class = b.patient_class AND a.attend_practitioner_id = c.practitioner_id (+) AND a.specialty_code = d.speciality_code AND a.facility_id = '");
		whereBuffer.append(facilityID);
		whereBuffer.append("' ");
		if (!patient_id.equals(""))
		{
			whereBuffer.append(" AND a.patient_id = '");
			whereBuffer.append(patient_id);
			whereBuffer.append("' ");
		}
		if (patient_period_specific.equals("D"))
		{
			whereBuffer.append(" AND TRUNC (visit_adm_date_time) BETWEEN TO_DATE ('");
			whereBuffer.append(from_period);
			whereBuffer.append("', 'dd/mm/rrrr' ) AND TO_DATE ('");
			whereBuffer.append(to_period);
			whereBuffer.append("', 'dd/mm/rrrr' )");
		}

		if (!patient_class_code.equals(""))
		{
			whereBuffer.append(" AND a.patient_class in ");
			whereBuffer.append(patient_class_code);
		}		
		sqlBuffer.append(whereBuffer.toString());
		sqlBuffer.append(" ORDER BY to_date(encounter_date_time, 'dd/mm/rrrr hh24:mi'), encounter_type, a.encounter_id");

		if ((sqlQuery != null) && (sqlQuery.length() > 0))
			sqlQuery.delete(0, sqlQuery.length());
		sqlQuery.append("SELECT count(*) record_count FROM pr_encounter a, Am_Patient_Class_lang_vw b , Am_Practitioner_lang_vw c, Am_SpecialIty_lang_vw d, mp_patient e ");
		sqlQuery.append(whereBuffer.toString());
	}
	


            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	if(resultSet!=null)	resultSet.close();
		if(preStatement!=null)  preStatement.close();
	//preStatement	=	connection.prepareStatement(sqlQuery.toString());
	//resultSet		=	preStatement.executeQuery();
	//if ((resultSet != null) && (resultSet.next()))
	//	record_count	=	resultSet.getInt("record_count");
	if(resultSet!=null)	resultSet.close();
		if(preStatement!=null)  preStatement.close();
	/* if (record_count==0)
	{*/
	
            _bw.write(_wl_block8Bytes, _wl_block8);

/*	}
	else
	{*/

            _bw.write(_wl_block9Bytes, _wl_block9);

if (maintain_doc_or_file.equals("D")&& !patient_id.equals(""))
{

            _bw.write(_wl_block10Bytes, _wl_block10);
            {java.lang.String __page ="../../eCommon/jsp/pline.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("Patient_ID"), weblogic.utils.StringUtils.valueOf(patient_id
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block13Bytes, _wl_block13);

	}

            _bw.write(_wl_block14Bytes, _wl_block14);

	//if ((!(start <= 1)) || (!( (start+increment) > record_count )))
//	{
		
            _bw.write(_wl_block15Bytes, _wl_block15);

		if ( !(start <= 1) )
		{
		
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(start-increment));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(end-increment));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

		}
				
		//if ( !( (start+increment) > record_count ) )
	//	{
		
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf((start+increment)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(end+increment));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

	//	}
		
            _bw.write(_wl_block21Bytes, _wl_block21);

	//}

            _bw.write(_wl_block22Bytes, _wl_block22);

	if (action_code.equals("L"))
	{

            _bw.write(_wl_block23Bytes, _wl_block23);

	if (maintain_doc_or_file.equals("D") && patient_id.equals(""))
	{

            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

	}

            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

	if (!maintain_doc_or_file.equals("D"))
	{
	
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

	}
	
            _bw.write(_wl_block31Bytes, _wl_block31);

	}
	else if (action_code.equals("D"))
	{

            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
	
	}

	if (preStatement != null)  preStatement = null;
	if (resultSet != null)  resultSet = null;

	String encounter_type_value			=	"&nbsp;";
	String encounter_id_value			=	"&nbsp;";
	String encounter_date_time_value	=	"&nbsp;";
	String practitioner					=	"&nbsp;";
	String specialty					=	"&nbsp;";
	String location						=	"&nbsp;";	
//	String assign_care_locn_code		=	"";
	String patient_class				=	"";
	String check_attribute				=	"";
	
	StringBuffer deLinkBuffer			=	new StringBuffer();
	
	preStatement	=	connection.prepareStatement(sqlBuffer.toString());
	resultSet		=	preStatement.executeQuery();
	int local_count=0;
	if (resultSet != null)
	{
		session.removeAttribute("documentArrList");
		if ( start != 1 )
			for( int j=1; j<start; count++,j++ )
				resultSet.next() ;	
		
		StringTokenizer stringToken		= null;
		
		while (resultSet.next() && count<=end)
		{
			encounter_type_value		= checkForNull(resultSet.getString("encounter_type"));
			encounter_id_value			= checkForNull(resultSet.getString("encounter_id"));
			encounter_date_time_value	= checkForNull(resultSet.getString("encounter_date_time"));
			if(!encounter_date_time_value.equals(""))
			{
				encounter_date_time_value=DateUtils.convertDate(encounter_date_time_value,"DMYHM","en",localeName);
			}


			practitioner				= checkForNull(resultSet.getString("practitioner_name"), "&nbsp;");
			specialty					= checkForNull(resultSet.getString("specialty"));			
	//		assign_care_locn_code		= checkForNull(resultSet.getString("assign_care_locn_code"));
			patient_class				= checkForNull(resultSet.getString("patient_class_code"));
			location				= checkForNull(resultSet.getString("location"));			
			

			if(class_value.equals("QRYEVEN"))
				class_value = "QRYODD";
			else
				class_value = "QRYEVEN";
			stringToken	=	new StringTokenizer(valid_values, ",");
		
            _bw.write(_wl_block38Bytes, _wl_block38);

			if (maintain_doc_or_file.equals("D")&& patient_id.equals(""))
			{
				patient_id_value	=	checkForNull(resultSet.getString("patient_id"));
		
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(patient_id_value));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(count));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(count));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(patient_id_value));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(checkForNull(resultSet.getString("patient_name"))));
            _bw.write(_wl_block45Bytes, _wl_block45);

			}
		
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(encounter_type_value));
            _bw.write(_wl_block45Bytes, _wl_block45);

			if ((action_code.equals("L")) && (maintain_doc_or_file.equals("D")))
			{
		
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(encounter_id_value));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(count));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(encounter_id_value));
            _bw.write(_wl_block19Bytes, _wl_block19);

			}
			else if ((action_code.equals("L")) && (maintain_doc_or_file.equals("F")))
			{
		
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(encounter_id_value));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(resultSet.getInt("volume_no")));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(count));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(encounter_id_value));
            _bw.write(_wl_block19Bytes, _wl_block19);

			}
			else if ((action_code.equals("D")) && (maintain_doc_or_file.equals("F")))
			{
				check_attribute	=	"";
				if (deLinkBuffer.length()>0)
					deLinkBuffer.delete(0, deLinkBuffer.length());
				deLinkBuffer.append(checkForNull(resultSet.getString("encounter_id")));
				deLinkBuffer.append("$$");
				deLinkBuffer.append(checkForNull(resultSet.getString("doc_type_code")));
				while(stringToken.hasMoreTokens())
				{
					if ((deLinkBuffer.toString()).equals(stringToken.nextToken()))
					{
						check_attribute	=	"Checked";
						break;
					}
				}
		
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(encounter_id_value));
            _bw.write(_wl_block45Bytes, _wl_block45);

			}
		
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(encounter_date_time_value));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(count));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(count));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(encounter_date_time_value));
            _bw.write(_wl_block53Bytes, _wl_block53);

			if ((action_code.equals("D")) && (maintain_doc_or_file.equals("F")))
			{
		
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(resultSet.getString("doc_type_name")));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(resultSet.getString("doc_no")));
            _bw.write(_wl_block45Bytes, _wl_block45);

			}
		
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(practitioner));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(specialty));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(location));
            _bw.write(_wl_block55Bytes, _wl_block55);

			if (maintain_doc_or_file.equals("F"))
			{
			
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(resultSet.getInt("volume_no")));
            _bw.write(_wl_block45Bytes, _wl_block45);

			}
			if (action_code.equals("D"))
			{
		
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(count));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(count));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(deLinkBuffer.toString()));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(check_attribute));
            _bw.write(_wl_block61Bytes, _wl_block61);

			}
		
            _bw.write(_wl_block62Bytes, _wl_block62);

			count++;
			local_count++;
		}
	}
if(local_count<increment){
	
            _bw.write(_wl_block63Bytes, _wl_block63);
} else {
            _bw.write(_wl_block64Bytes, _wl_block64);
}
	
if(local_count==0){	
            _bw.write(_wl_block65Bytes, _wl_block65);
}
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(from));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(to));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(file_no));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(file_type));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(action_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(record_count));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(file_type_appl_yn));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(valid_values));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(from_period));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(to_period));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(action_code));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(action_code));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(maintain_doc_or_file));
            _bw.write(_wl_block82Bytes, _wl_block82);

	//}
	if(resultSet!=null)	resultSet.close();
	if(rSet!=null)	rSet.close();
	if(resSet!=null)	resSet.close();
	if(preStatement!=null) preStatement.close();
	if(pStatement!=null) pStatement.close();
	if(prStatement!=null) prStatement.close();
}
catch(Exception e)
{
	out.println("<script>alert(\"Exception : "+e.toString()+"\");</script>");
	out.println("Exception : " + e.toString());
	e.printStackTrace();
}
finally
{	

	ConnectionManager.returnConnection(connection,request);
}

            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(doc_folder_id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(maintain_doc_or_file));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(patient_period_specific));
            _bw.write(_wl_block86Bytes, _wl_block86);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encountertype.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterdatetime.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.VolumeNo.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encountertype.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterdatetime.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag14(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag14 = null ;
        int __result__tag14 = 0 ;

        if (__tag14 == null ){
            __tag14 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag14);
        }
        __tag14.setPageContext(pageContext);
        __tag14.setParent(null);
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.documenttype.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag14;
        __result__tag14 = __tag14.doStartTag();

        if (__result__tag14!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag14== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag14.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag14);
            return true;
        }
        _activeTag=__tag14.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag14);
        __tag14.release();
        return false;
    }

    private boolean _jsp__tag15(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag15 = null ;
        int __result__tag15 = 0 ;

        if (__tag15 == null ){
            __tag15 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag15);
        }
        __tag15.setPageContext(pageContext);
        __tag15.setParent(null);
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.documentno.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag15;
        __result__tag15 = __tag15.doStartTag();

        if (__result__tag15!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag15== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag15.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag15);
            return true;
        }
        _activeTag=__tag15.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag15);
        __tag15.release();
        return false;
    }

    private boolean _jsp__tag16(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag16 = null ;
        int __result__tag16 = 0 ;

        if (__tag16 == null ){
            __tag16 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag16);
        }
        __tag16.setPageContext(pageContext);
        __tag16.setParent(null);
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag16;
        __result__tag16 = __tag16.doStartTag();

        if (__result__tag16!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag16== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag16.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag16);
            return true;
        }
        _activeTag=__tag16.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag16);
        __tag16.release();
        return false;
    }

    private boolean _jsp__tag17(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag17 = null ;
        int __result__tag17 = 0 ;

        if (__tag17 == null ){
            __tag17 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag17);
        }
        __tag17.setPageContext(pageContext);
        __tag17.setParent(null);
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag17;
        __result__tag17 = __tag17.doStartTag();

        if (__result__tag17!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag17== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag17.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag17);
            return true;
        }
        _activeTag=__tag17.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag17);
        __tag17.release();
        return false;
    }

    private boolean _jsp__tag18(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag18 = null ;
        int __result__tag18 = 0 ;

        if (__tag18 == null ){
            __tag18 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag18);
        }
        __tag18.setPageContext(pageContext);
        __tag18.setParent(null);
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag18;
        __result__tag18 = __tag18.doStartTag();

        if (__result__tag18!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag18== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag18.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag18);
            return true;
        }
        _activeTag=__tag18.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag18);
        __tag18.release();
        return false;
    }

    private boolean _jsp__tag19(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag19 = null ;
        int __result__tag19 = 0 ;

        if (__tag19 == null ){
            __tag19 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag19);
        }
        __tag19.setPageContext(pageContext);
        __tag19.setParent(null);
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.VolumeNo.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag19;
        __result__tag19 = __tag19.doStartTag();

        if (__result__tag19!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag19== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag19.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag19);
            return true;
        }
        _activeTag=__tag19.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag19);
        __tag19.release();
        return false;
    }

    private boolean _jsp__tag20(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag20 = null ;
        int __result__tag20 = 0 ;

        if (__tag20 == null ){
            __tag20 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag20);
        }
        __tag20.setPageContext(pageContext);
        __tag20.setParent(null);
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.De-Link.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag20;
        __result__tag20 = __tag20.doStartTag();

        if (__result__tag20!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag20== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag20.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag20);
            return true;
        }
        _activeTag=__tag20.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag20);
        __tag20.release();
        return false;
    }
}
