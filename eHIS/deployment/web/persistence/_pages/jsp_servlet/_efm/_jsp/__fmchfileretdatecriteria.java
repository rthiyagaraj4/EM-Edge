package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmchfileretdatecriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMChFileRetDateCriteria.jsp", 1726141415068L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tDeveloped by \t:\tPrakash.S\n\tCreated on \t\t:\t17/06/2002\n\tModule\t\t\t:\tFM - Change File Return Date\n\tFunction\t\t:\tThis function is used for Search Criteria.\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMChFileRetDate.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n\t<script>\n\tfunction fetchResults(val)\n{  \n var obj=val;\n var patient_id=\"\";\n var filenum=\"\";\n var volume_no=\"\";\n var to_proceed=true;\n\tvar file_type_appl_yn = FMChFileRetDateCriteriaForm.file_type_appl_yn.value;\t\n\tvar doc_or_file = FMChFileRetDateCriteriaForm.maintain_doc_or_file.value;\n\tif(doc_or_file == \'D\')\n\t{\n\t\tvar fields = new Array ( FMChFileRetDateCriteriaForm.p_curr_fs_loc,FMChFileRetDateCriteriaForm.doc_folder_id,FMChFileRetDateCriteriaForm.doc_type_id);\n\t\tvar issfsloc= getLabel(\"Common.Issue.label\",\"Common\") + getLabel(\"eFM.FSLocation.label\",\"FM\");\n\t\tvar names = new Array ( issfsloc, getLabel(\"eFM.DocumentFolder.label\",\"FM\"), getLabel(\"Common.documenttype.label\",\"common\"));\t\n\t}\n\telse if(doc_or_file == \'F\')\n\t{\n\t\tif(file_type_appl_yn == \'N\')\n\t\t{\n\t\t\tvar fields = new Array ( FMChFileRetDateCriteriaForm.p_curr_fs_loc,FMChFileRetDateCriteriaForm.patient_id,FMChFileRetDateCriteriaForm.file_no,FMChFileRetDateCriteriaForm.volume_no);\n\t\t\tvar issfsloc= getLabel(\"Common.Issue.label\",\"Common\") + getLabel(\"eFM.FSLocation.label\",\"FM\");\n\t\t\tvar names = new Array ( issfsloc , getLabel(\"Common.patientId.label\",\"common\"), getLabel(\"Common.fileno.label\",\"common\"),getLabel(\"eFM.VolumeNo.label\",\"FM\"));\t\n\t\t}\n\t\telse if(file_type_appl_yn == \'Y\')\n\t\t{\n\t\t\tvar fields = new Array ( FMChFileRetDateCriteriaForm.p_curr_fs_loc,FMChFileRetDateCriteriaForm.patient_id,FMChFileRetDateCriteriaForm.patient_file_type,FMChFileRetDateCriteriaForm.volume_no);\n\t\t\tvar issfsloc= getLabel(\"Common.Issue.label\",\"Common\") + getLabel(\"eFM.FSLocation.label\",\"FM\");\n\t\t\tvar names = new Array ( issfsloc , getLabel(\"Common.patientId.label\",\"common\"), getLabel(\"Common.filetype.label\",\"common\"),getLabel(\"eFM.VolumeNo.label\",\"FM\"));\t\n\t\t}\n\t}\n\t\n\tvar errors = \"\";\n\tfor( var i=0; i<fields.length; i++ ) \n\t{\n\t\tif(trimCheck(fields[i].value)) \n\t\t{\n\t\t\tfields[i].value = trimString(fields[i].value);\n\t\t}\n\t\telse\t\n\t\t{\t\n\t\t\t//errors = errors + \"APP-000001 \" + names[i] + \" cannot be blank...\" + \"<br>\" ;\n\t\t\terrors=errors + getMessage(\"CAN_NOT_BE_BLANK\",\"common\") + \"<br>\";\n\t\t\terrors=errors.replace(\'$\',names[i]);\n\t\t}\n\t}\n\tif ( errors.length != 0 ) \n\t{\n\t\tparent.parent.frames[2].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors ;\n\t\tto_proceed = false;\n\t\treturn false ;\n\t}\n\tvar whereClause=\"and\";\n\tvar selectClause=\"\";\n\tvar strand = \"\";\n\tvar empty = 0;\n\tvar count_sql = \"\";\n\tvar i=0;\n\t\n\tif(obj==\'search\')\n\t{\n\t\tif(doc_or_file == \'D\')\n\t\t{\n\t\t\tvar fields = new Array(FMChFileRetDateCriteriaForm.file_no, FMChFileRetDateCriteriaForm.patient_id,FMChFileRetDateCriteriaForm.patient_file_type);\n\t\t}\n\t\telse if(doc_or_file == \'F\')\n\t\t{\n\t\tif(file_type_appl_yn == \'N\')\n\t\t{\n\t\t\tvar fields = new Array(FMChFileRetDateCriteriaForm.file_no, FMChFileRetDateCriteriaForm.patient_id,FMChFileRetDateCriteriaForm.volume_no);\n\t\t}\n\t\telse if(file_type_appl_yn == \'Y\')\n\t\t{\n\t\t\tvar fields = new Array(FMChFileRetDateCriteriaForm.file_no, FMChFileRetDateCriteriaForm.patient_id,FMChFileRetDateCriteriaForm.volume_no,FMChFileRetDateCriteriaForm.patient_file_type);\n\t\t}\n\t\t}\n\t}\n\t\n\t  patient_id=FMChFileRetDateCriteriaForm.patient_id.value;\n\t  filenum=FMChFileRetDateCriteriaForm.file_no.value;\n\t  volume_no=FMChFileRetDateCriteriaForm.volume_no.value;\n\t\n\tfor(i=0;i<fields.length;i++) \n\t{\n\t\tif(fields[i] != null)\n\t\t{\n\t\t\tif(trimCheck(fields[i].value))  empty++;\n\t\t}\n\t}\n\tif(empty != 0) \n\t{\n\t\tflag=true;\n\t\tif(fields[0] != null)\n        {\n\t\t\tif(trimCheck(fields[0].value)) \n\t\t\t{\n\t\t\t\twhereClause = whereClause + \" file_no = trim(\'\" + fields[0].value + \"\') and \";\n\t\t\t}\n\t\t}\n\t\tif(fields[1] != null)\n        {\n\t\t\tif( trimCheck(fields[1].value)) \n\t\t\t{\n\t\t\t\twhereClause = whereClause + \" patient_id = trim(\'\" + fields[1].value + \"\') and \";\n\t\t\t}\n\t\t}\n\t\tif(doc_or_file != \'D\')\n\t\t{\n\t\t\tif(fields[2] != null)\n\t\t\t{\n\t\t\t\tif(trimCheck(fields[2].value)) \n\t\t\t\t{\n\t\t\t\t\twhereClause = whereClause + \" volume_no = trim(\'\" + fields[2].value + \"\') and \";\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tif(file_type_appl_yn == \'Y\')\n\t\t{\n\t\t\tif(fields[3] != null)\n\t\t\t{\n\t\t\t\tif(trimCheck(fields[3].value)) \n\t\t\t\t{\n\t\t\t\t\twhereClause = whereClause + \" file_type_code = trim(\'\" + fields[3].value + \"\') and \";\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tvar p_curr_fs_loc = FMChFileRetDateCriteriaForm.p_curr_fs_loc.value;\n\t\tvar user_id\t\t  = FMChFileRetDateCriteriaForm.user_id.value;\t\n\t\t//whereClause = whereClause + \" mr_pat_fs_locn_code = trim(\'\" + p_curr_fs_loc+ \"\') and \";\n\t\twhereClause = whereClause + \" PERM_FS_LOCN_CODE = trim(\'\" + p_curr_fs_loc+ \"\') and \";\n\n\t\twhereClause = whereClause + strand;\n\t\tvar replace_url\t\t= \t/%/g ;\n\t\twhereClause   \t= whereClause.replace(replace_url,\"~\" );\n\t\tif(whereClause.lastIndexOf(\"and\") != -1)\n\t\twhereClause = whereClause.substring(0,whereClause.lastIndexOf(\"and\"));\n\n\t\tvar user_security_yn = document.forms[0].user_security_yn.value;\t\t\t\n\t\tvar p_access_all\t = document.forms[0].p_access_all.value;\t\t\t\n\t\tvar sysDate\t\t\t = document.forms[0].sysDate.value;\t\t\t\n\t\t\t\t\n\t\tif(obj==\'search\')\n\t\t{\n\t\t\tFMChFileRetDateCriteriaForm.search_dtl.disabled=true;\n\t\t\tFMChFileRetDateCriteriaForm.reset1.disabled=true;\n\t\t\tif(doc_or_file != \'D\')\n\t\t\t{\n\t\t\t\tFMChFileRetDateCriteriaForm.pat_search.disabled=true;\n\t\t\t}\n\t\t\tFMChFileRetDateCriteriaForm.p_curr_fs_loc.disabled=true;\n\t\t\t\n\t\t\tif(doc_or_file == \'D\')\n\t\t\t{\n\t\t\t\tparent.FMChFileRetDateResultFrame.location.href=\'../../eFM/jsp/DTChFileRetDateResult.jsp?whereClause=\'+whereClause+\'&user_security_yn=\'+user_security_yn+\'&p_access_all=\'+p_access_all+\'&sysDate=\'+sysDate+\'&patient_id=\'+patient_id+\'&filenum=\'+filenum+\'&volume_no=\'+volume_no+\'&user_id=\'+user_id;\n\t\t\t}\n\t\t\telse if(doc_or_file == \'F\')\n\t\t\t{\n\t\t\t\tparent.FMChFileRetDateResultFrame.location.href=\'../../eFM/jsp/FMChFileRetDateResult.jsp?whereClause=\'+whereClause+\'&user_security_yn=\'+user_security_yn+\'&p_access_all=\'+p_access_all+\'&sysDate=\'+sysDate+\'&patient_id=\'+patient_id+\'&filenum=\'+filenum+\'&volume_no=\'+volume_no+\'&user_id=\'+user_id+\'&current_fs_location=\'+p_curr_fs_loc; //Modified this line HSA-CRF-0306.1\n\t\t\t}\n\t\t\tparent.parent.frames[2].location.href=\'../../eCommon/jsp/error.jsp\';\n\t\t}\n\t\treturn true;\n\t}\n\telse\n\t{\n\t\tif(doc_or_file == \'D\')\n\t\t{\n\t\tvar msg =\tgetMessage(\'DOC_CAN_NOT_BE_BLANK\',\'FM\');\n\t\t}\n\t\telse if(doc_or_file == \'F\')\n\t\t{\n\t\tvar msg =\tgetMessage(\'FILE_CAN_NOT_BE_BLANK\',\'FM\');\n\t\t}\n\t\tif(msg!=\"\")\n\t\t{\n\t\t\tparent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg+\"&err_value=0\";\n\t\t\treturn false;\n\t\t}\n\t}\n\t\n}\n\tfunction clearvalue(obj)\n{\nFMChFileRetDateCriteriaForm.patient_id.value=\"\";\nFMChFileRetDateCriteriaForm.patient_id.onblur();\n\n}\n\t</script>\n\t\n\n</head>\n<body  onMouseDown=\'CodeArrest()\' onLoad=\"document.FMChFileRetDateCriteriaForm.p_curr_fs_loc.focus();\" onKeyDown = \'lockKey();\'>\n<form name=\'FMChFileRetDateCriteriaForm\' id=\'FMChFileRetDateCriteriaForm\' action=\'\' method=\'\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<table cellpadding=\'2\' cellspacing=\'0\' border=\'0\' width=\'100%\' align=\'CENTER\'>\n\t<tr>\n\t\t<td class=\'label\' width=\"25%\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t<td class=\'fields\' width=\"25%\"><select name=\'p_curr_fs_loc\' id=\'p_curr_fs_loc\' onchange=\'clearvalue(this.value);\'>\n\t\t\t\t<option value=\'\'>------ ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="------</option>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t<option value=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t</td>\n\t\t<td class=\'label\' width=\"25%\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t<!--Below line modifed for this SCF ML-MMOH-SCF-0361 -->\n\t\t<td class=\'fields\' width=\'25%\'>\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t<input type=\'text\' name=\'appl_user_id1\' id=\'appl_user_id1\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" readonly size=\'30\' ><input type=\'hidden\' name=\'appl_user_id\' id=\'appl_user_id\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' disabled readonly size=\'40\' maxlength=30><input type=button name=searchcode value=\'?\' class=button onClick=\"searchCode(appl_user_id,\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\')\" disabled>\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"  readonly size=\'30\' ><input type=\'hidden\' name=\'appl_user_id\' id=\'appl_user_id\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' readonly size=\'40\' maxlength=30><input type=button name=searchcode value=\'?\' class=button onClick=\"searchCode(appl_user_id,\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\')\">\n\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t</td>\n\t</tr>\n\t<tr><td colspan=\"4\">\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t</td>\n\t</tr>\n\t<tr align=\"right\">\n\t\t<td colspan=\'4\' class=\'button\' ><input type=\'button\' class=\'button\' name=\'search_dtl\' id=\'search_dtl\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' onClick=\'return fetchResults(\"search\");\'><input type=\'button\' class=\'button\' name=\'reset1\' id=\'reset1\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' onClick=\'clearAll()\'><input type=\'hidden\' name=\'user_id\' id=\'user_id\' value=\'\'></td>\n\t</tr>\n</table>\n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n<script>\n\tif(\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" == 1)\n\t{\n\t\tFMChFileRetDateCriteriaForm.p_curr_fs_loc.options(1).selected = true;\n\t}\n</script>\n<input type=\'hidden\' name=\'user_security_yn\' id=\'user_security_yn\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n<input type=\'hidden\' name=\'p_access_all\' id=\'p_access_all\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n<input type=\'hidden\' name=\'sysDate\' id=\'sysDate\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);


Connection con			=	null;
PreparedStatement pstmt =	null;
ResultSet	rs			=	null;

String addedById	= (String) session.getValue("login_user" ) ;
String facilityid 	= (String) session.getValue("facility_id");

String appl_user_name	= "", user_security_yn = "";
String p_access_all		= "";
String sql1				= "";
String p_code			= "";
String p_desc			= "";
String sysDate			= "";

int count = 0;

StringBuffer SelectSqlBuffer = null;

try
{
	con		=	ConnectionManager.getConnection(request);
	
	SelectSqlBuffer = new StringBuffer();

	
	user_security_yn	= request.getParameter("user_security_yn");
	p_access_all		= request.getParameter("p_accass_all");
	
	if(user_security_yn == null || user_security_yn.equals("null")) user_security_yn="N";
	if(p_access_all == null || p_access_all.equals("null")) p_access_all="";
	

            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	//sql1 = "select appl_user_name, TO_CHAR(sysdate,'dd/mm/yyyy hh24:mi') from sm_appl_user where appl_user_id = ? ";
	sql1 = "select appl_user_name, TO_CHAR(sysdate,'dd/mm/yyyy hh24:mi') from sm_appl_user_LANG_VW where appl_user_id = ? AND LANGUAGE_ID = ? ";
	
	pstmt = con.prepareStatement(sql1);
	pstmt.setString(1,addedById);
	pstmt.setString(2,localeName);
	rs = pstmt.executeQuery();
	while(rs != null && rs.next())
	{
		appl_user_name = rs.getString(1);
		sysDate		   = rs.getString(2);
	} 
	if(rs!=null)	rs.close();
	if(pstmt!=null) pstmt.close();	
		
	if(user_security_yn.equals("Y"))
	{
		if (p_access_all.equals("*ALL"))
		//if (p_access_all.equals("1"))
		{
		//	SelectSqlBuffer.append("select a.fs_locn_code,a.short_desc fs_locn_desc,a.narration_code from fm_storage_locn a  where a.eff_status='E' and a.facility_id='"+facilityid+"' and a.permanent_file_area_yn='Y' order by 2");
			SelectSqlBuffer.append("SELECT" );
			SelectSqlBuffer.append("  a.fs_Locn_Code" );
			SelectSqlBuffer.append("  , fm_Get_desc.Fm_storage_locn('"+facilityid+"',a.fs_Locn_Code,'"+localeName+"',2) fs_Locn_desc" );
			SelectSqlBuffer.append("  , a.Narration_Code " );
			SelectSqlBuffer.append("FROM" );
			SelectSqlBuffer.append("  fm_storage_locn  a " );
			SelectSqlBuffer.append("WHERE a.eff_Status = 'E' " );
			//SelectSqlBuffer.append("  AND LANGUAGE_ID='"+localeName+"' " );
			SelectSqlBuffer.append("  AND a.Facility_Id = '"+facilityid+"' " );
			SelectSqlBuffer.append("  AND a.Permanent_File_Area_yn = 'Y' " );
			SelectSqlBuffer.append("ORDER BY" );
			SelectSqlBuffer.append("  2" );
		}
		else
		{
			//SelectSqlBuffer.append("select a.fs_locn_code,a.short_desc fs_locn_desc,a.narration_code from fm_storage_locn a , fm_user_access_rights b where a.eff_status='E' and a.facility_id=b.facility_id and a.fs_locn_code=b.fs_locn_code and b.appl_user_id='"+addedById+"' and b.facility_id='"+facilityid+"' and b.change_return_date_yn='Y'  order by 2");
			
			SelectSqlBuffer.append("SELECT" );
			SelectSqlBuffer.append("  a.fs_Locn_Code" );
			SelectSqlBuffer.append("  , a.Short_desc fs_Locn_desc" );
			SelectSqlBuffer.append("  , a.Narration_Code " );
			SelectSqlBuffer.append("FROM" );
			SelectSqlBuffer.append("  fm_storage_locn_lang_vw a" );
			SelectSqlBuffer.append("  , fm_User_Access_Rights b " );
			SelectSqlBuffer.append("WHERE a.eff_Status = 'E' " );
			SelectSqlBuffer.append("  AND a.LANGUAGE_ID='"+localeName+"'" );
			SelectSqlBuffer.append("  AND a.Facility_Id = b.Facility_Id " );
			SelectSqlBuffer.append("  AND a.fs_Locn_Code = b.fs_Locn_Code " );
			SelectSqlBuffer.append("  AND b.apPl_User_Id = '"+addedById+"' " );
			SelectSqlBuffer.append("  AND b.Facility_Id = '"+facilityid+"' " );
			SelectSqlBuffer.append("  AND b.Change_Return_Date_yn = 'Y' " );
			SelectSqlBuffer.append("ORDER BY" );
			SelectSqlBuffer.append("  2" );

		}
	}
	else
	{
		//SelectSqlBuffer.append("select a.fs_locn_code,a.short_desc fs_locn_desc from fm_storage_locn a where a.eff_status='E' and a.facility_id='"+facilityid+"' and a.permanent_file_area_yn='Y' order by 2");
		SelectSqlBuffer.append("SELECT" );
		SelectSqlBuffer.append("  a.fs_Locn_Code" );
		SelectSqlBuffer.append("  , fm_Get_desc.Fm_storage_locn('"+facilityid+"',a.fs_Locn_Code,'"+localeName+"',2) fs_Locn_desc " );
		SelectSqlBuffer.append("FROM" );
		SelectSqlBuffer.append("  fm_storage_locn  a " );
		SelectSqlBuffer.append("WHERE a.eff_Status = 'E' " );
		//SelectSqlBuffer.append("  AND A.LANGUAGE_ID='"+localeName+"'" );
		SelectSqlBuffer.append("  AND a.Facility_Id = '"+facilityid+"'" );
		SelectSqlBuffer.append("  AND a.Permanent_File_Area_yn = 'Y'" );
		SelectSqlBuffer.append("ORDER BY" );
		SelectSqlBuffer.append("  2" );

	}

	
	pstmt = con.prepareStatement(SelectSqlBuffer.toString());	

	
	
	rs	  = pstmt.executeQuery();

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

				while(rs.next())
				{
					count++;
					p_code = rs.getString("fs_locn_code");
					p_desc = rs.getString("fs_locn_desc");
					
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(p_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);

				}
				
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

			if(user_security_yn.equals("Y"))
			{
				
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(appl_user_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(addedById));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block19Bytes, _wl_block19);

			}
			else
			{
				
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(appl_user_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(addedById));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block22Bytes, _wl_block22);

			}
		
            _bw.write(_wl_block23Bytes, _wl_block23);
            {java.lang.String __page ="../../eFM/jsp/FMFileSearchComponentValues.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("frame_name"), weblogic.utils.StringUtils.valueOf("parent.f_query_add_mod.FMChFileRetDateCriteriaFrame")},{ weblogic.utils.StringUtils.valueOf("frame_name1"), weblogic.utils.StringUtils.valueOf("parent.FMChFileRetDateCriteriaFrame")},{ weblogic.utils.StringUtils.valueOf("form_name"), weblogic.utils.StringUtils.valueOf("FMChFileRetDateCriteriaForm")},{ weblogic.utils.StringUtils.valueOf("messageframe_name"), weblogic.utils.StringUtils.valueOf("parent.parent.messageFrame")},{ weblogic.utils.StringUtils.valueOf("patientid_name"), weblogic.utils.StringUtils.valueOf("patient_id")},{ weblogic.utils.StringUtils.valueOf("fileno_name"), weblogic.utils.StringUtils.valueOf("file_no")},{ weblogic.utils.StringUtils.valueOf("filetype_name"), weblogic.utils.StringUtils.valueOf("file_type_code")},{ weblogic.utils.StringUtils.valueOf("volumeno_name"), weblogic.utils.StringUtils.valueOf("volume_no")},{ weblogic.utils.StringUtils.valueOf("table_width"), weblogic.utils.StringUtils.valueOf("100")},{ weblogic.utils.StringUtils.valueOf("tablealign"), weblogic.utils.StringUtils.valueOf("CENTER")},{ weblogic.utils.StringUtils.valueOf("volume_mandatory_yn"), weblogic.utils.StringUtils.valueOf("Y")},{ weblogic.utils.StringUtils.valueOf("locn_code"), weblogic.utils.StringUtils.valueOf("p_curr_fs_loc")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block28Bytes, _wl_block28);

		if((SelectSqlBuffer != null) && (SelectSqlBuffer.length() > 0))
		{
			SelectSqlBuffer.delete(0,SelectSqlBuffer.length());
		}

		if(rs!=null)	rs.close();
		if(pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception e" + e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);	
	}

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(count));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(user_security_yn));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(p_access_all));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(sysDate));
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.IssueFSLocation.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Changedby.label", java.lang.String .class,"key"));
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
