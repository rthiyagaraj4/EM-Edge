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

public final class __progressnotesmenu extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ProgressNotesMenu.jsp", 1736157590948L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t<script src=\'../../eCA/js/ProgressNotesTree.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eCA/js/ProgressNotes.js\' language=\'javascript\'></script>\t\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n</head>\n<body  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\" onload=\"\">\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<FORM METHOD=POST ACTION=\"\" name=\"maternityMenu\" id=\"maternityMenu\">\n<script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\n\t\t\t\t\n\t\tvar obj";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =";\n\t\tobj";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" = new dTree(\'obj";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\');\n\t\tobj";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =".add(0,-1,\'\');\n\t\tobj";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =".config.useStatusText=true;\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\tobj";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =".add(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="NG^";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\',\'0\',\'<b>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</b>\',\'../../eCA/jsp/ProgressNotesView.jsp?";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&note_group=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&progression_ref=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&level=NG&note_group_desc=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\',\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\n\t\tobj";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</b>\',\'../../eCA/jsp/ProgressNotesAccessMsg.jsp\',\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\n\t\tobj";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\',\'<b>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</b>\',\'\',\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\t\t\n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\n\t\t\t\tobj";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\t\t\t\t//obj";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\n\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t//obj";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\n\t\t\t\tobj";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\tobj";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\',\'../../eCA/jsp/RecClinicalNotesModal.jsp?";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="&note_type=";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="&accession_num=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="&function_id=SPCL_NOTE&contr_mod_accession_num=OH!";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="&rec_flag=N\',\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\',\'../../eCA/jsp/ProgressNotesView.jsp?";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="&level=NT&note_group_desc=";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\',\'../../eCA/jsp/ProgressNotesAccessMsg.jsp\',\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\t\t\t\tobj";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =".add(\'PROGRESSNOTE";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\',\'../../eCA/jsp/RecClinicalNotes.jsp?";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="&p_note_type=";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\',\'Add New\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\tobj";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\',\'../../eCA/jsp/ProgressNotesAccessMsg.jsp\',\'Add New\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\n\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\',\'\',\'Add New\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =".add(\'PROGRESSNOTEA\',\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\',\'Add New\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\t\n\t\t\t\tobj";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =".add(\'PROGRESSNOTEB\',\'0\',\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="&contr_mod_accession_num=OH!";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\',\'Add New\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\n\n\t\t\t\tobj";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =".add(\'OUTCOME\',\'0\',\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\',\'../../eCA/jsp/ProgressNotesOutcome.jsp?";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="&progression_no=";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\',\'Record Outcome\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\n\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\n\t\t\t\tobj";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\',\'../../eCA/jsp/ProgressNotesAccessMsg.jsp\',\'Add New\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\',\'../../eCA/jsp/ProgressNotesAccessMsg.jsp\',\'Add New\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\t\n\t\n\t\t\t\tobj";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\',\'../../eCA/jsp/ProgressNotesAccessMsg.jsp\',\'Record Outcome\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\n\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\n\t\t\n\t\t//obj";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\',\'\',\'Add New\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\t\t\n\t\t//obj";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =".add(\'PROGRESSNOTEB\',\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\',\'\',\'Record Outcome\',\'workAreaFrame\',\'\',\'\',\'\',\'R\');\n\n\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\n\t\tvar html=\"<TABLE width=\'95%\' align=\'center\' border=0 cellspacing=0>\";\n\t\thtml=html+\"<TR>\";\n\t\thtml=html+\"<TD background=\'../../eCA/images/MCT_FullStrip.gif\' style=\'height:32\' onclick=\\\"hideShowNodes(\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\')\\\">&nbsp;";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\";\n\t\thtml=html+\"</TD>\";\n\t\thtml=html+\"</TR></TABLE>\";\n\t\tparent.maternitytreeframe.document.write(html); \n\n\t\t\n\t\tdocument.write(\"<TABLE width=\'95%\' height=\'45%\' align=\'center\' border=0 cellspacing=0><TR VALIGN=TOP><TD id=\'tdId";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\' style=\'display;BACKGROUND-IMAGE:url(../../eCA/images/MCT_MenuBgImage.jpg)\'>\"+obj";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="+\"</td></tr></TABLE>\");\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\n\tobj";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =".openAll();\n\t\t\n\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n</script>\n";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\n\n<input type=hidden name=\'noOfEvents\' id=\'noOfEvents\' value=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'>\n</FORM>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);


	String queryString = request.getQueryString() == null ? "" : request.getQueryString();
	String module_id =  request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
	String patient_id =  request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String sel_progression_no=request.getParameter("sel_progression_no") == null ? "0" : request.getParameter("sel_progression_no");
//	String cycle_status=request.getParameter("cycle_status");
	String ca_practitioner_id =(String)session.getValue("ca_practitioner_id");
	String patient_class = request.getParameter("patient_class") == null ? "" : request.getParameter("patient_class");

	String called_from = request.getParameter("called_from") == null ? "" : request.getParameter("called_from");
	String progression_ref_req = request.getParameter("progression_ref") == null ? "" : request.getParameter("progression_ref");



//	int cycle_no=0;
	int i=0;
	String facility_id = (String) session.getValue("facility_id"); 
	
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt2 = null;
	ResultSet rs = null;
	ResultSet rs1 = null;
	ResultSet rs2 = null;
	boolean flag = true;

	String progression_ref = "";
	String progression_no = "";
	String pre_progression_no = "";
	String speciality_code = "";
	String note_type_desc = "";
	String note_group = "";
	String note_group_desc = "";
	String progression_status = "";
	String speciality_name = "";
	String boldText = "";
	String progress_note_type = "";
	String event_date = "";
	String acc_num = "";
	String acc_num_id = "";
	String event_status = "";
	String event_date_disp = "";

/*	String note_type_desc_dtl = "";
	String progress_note_type_dtl = "";
	String note_group_desc_dtl = "";
	String note_group_dtl = "";*/
	String start_progress_note_type = "";
	String access_yn = "";
	String eff_status = "";
	String patient_class_yn = "";

	StringBuffer menu_sql =new StringBuffer();
	StringBuffer menu_sql_hdr =new StringBuffer();
	StringBuffer menu_sql_dtl =new StringBuffer();
	StringBuffer menu_sql_dtl2 =new StringBuffer();
	StringBuffer menu_sql_dtl3 =new StringBuffer();

	// menu_sql.append("select PROGRESSION_REF, PROGRESSION_CYCLE_NO,SPECIALITY_CODE,AM_GET_DESC.AM_SPECIALITY(SPECIALITY_CODE,?,2) speciality_name,START_PROGRESS_NOTE_TYPE,(select NOTE_TYPE_DESC from ca_note_type_lang where NOTE_TYPE =START_PROGRESS_NOTE_TYPE and LANGUAGE_ID = ? ) note_type_desc,(select NOTE_GROUP_ID from ca_note_type where NOTE_TYPE = START_PROGRESS_NOTE_TYPE) note_group,(select ca_get_desc.CA_NOTE_GROUP(NOTE_GROUP_ID,?,2) from ca_note_type where NOTE_TYPE = START_PROGRESS_NOTE_TYPE) note_group_desc,PROGRESSION_STATUS from CA_PAT_PROGRESSION_HDR K where PATIENT_ID=? and MODULE_ID = ? and FACILITY_ID = ? ");

	  menu_sql_hdr.append(" select PROGRESSION_REF, PROGRESSION_CYCLE_NO,SPECIALITY_CODE,AM_GET_DESC.AM_SPECIALITY(SPECIALITY_CODE,?,2) speciality_name,  START_PROGRESS_NOTE_TYPE,CA_GET_DESC.CA_NOTE_TYPE(START_PROGRESS_NOTE_TYPE,?,2) note_type_desc,(select NOTE_GROUP_ID from ca_note_type  where NOTE_TYPE = START_PROGRESS_NOTE_TYPE) note_group,(select ca_get_desc.CA_NOTE_GROUP(NOTE_GROUP_ID,?,2) from ca_note_type where NOTE_TYPE = START_PROGRESS_NOTE_TYPE) note_group_desc,(select EFF_STATUS from ca_note_type  where NOTE_TYPE = START_PROGRESS_NOTE_TYPE) EFF_STATUS,( SELECT decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN) from CA_NOTE_TYPE where note_type=START_PROGRESS_NOTE_TYPE)  patient_class_yn , PROGRESSION_STATUS,NVL2(SPECIALITY_CODE,CA_GET_PROGRESSION_ACCESS_YN(?,?,SPECIALITY_CODE),'Y') access_yn from CA_PAT_PROGRESSION_HDR K where PATIENT_ID= ? and MODULE_ID = ? and FACILITY_ID = ?  ");  // union 
	  menu_sql_dtl.append( " select distinct  NOTE_GROUP_ID,ca_get_desc.CA_NOTE_GROUP(NOTE_GROUP_ID,?,2) note_group_desc,  PROGRESSION_STATUS from CA_PAT_PROGRESSION_HDR D,CA_PAT_PROGRESSION_DTL E,CA_ENCNTR_NOTE F,ca_note_type G  where D.PROGRESSION_REF=E.PROGRESSION_REF   and E.ACCESSION_NUM =F.ACCESSION_NUM   and F.NOTE_TYPE=G.NOTE_TYPE and NOTE_GROUP_ID not in ( select  j.NOTE_GROUP_ID from ca_note_type j where j.NOTE_TYPE = START_PROGRESS_NOTE_TYPE )   AND G.NOTE_TYPE != START_PROGRESS_NOTE_TYPE  and D.PATIENT_ID= ? and D.MODULE_ID = ? and D.FACILITY_ID = ? and D.PROGRESSION_REF = ? and F.EVENT_STATUS !=9 order by note_group_desc ");
	  menu_sql_dtl2.append( " select distinct D.PROGRESSION_REF, PROGRESSION_CYCLE_NO,SPECIALITY_CODE,AM_GET_DESC.AM_SPECIALITY(SPECIALITY_CODE,?,2) speciality_name,  F.NOTE_TYPE, CA_GET_DESC.CA_NOTE_TYPE(F.NOTE_TYPE,?,2) note_type_desc,NOTE_GROUP_ID,ca_get_desc.CA_NOTE_GROUP(NOTE_GROUP_ID,?,2) note_group_desc,  PROGRESSION_STATUS from CA_PAT_PROGRESSION_HDR D,CA_PAT_PROGRESSION_DTL E,CA_ENCNTR_NOTE F,ca_note_type G  where D.PROGRESSION_REF=E.PROGRESSION_REF   and E.ACCESSION_NUM =F.ACCESSION_NUM   and F.NOTE_TYPE=G.NOTE_TYPE   AND G.NOTE_TYPE != START_PROGRESS_NOTE_TYPE  and D.PATIENT_ID= ? and D.MODULE_ID = ? and D.FACILITY_ID = ? and D.PROGRESSION_REF = ? and F.EVENT_STATUS !=9 order by NOTE_TYPE_DESC ");
	  menu_sql_dtl3.append( " select distinct D.PROGRESSION_REF, PROGRESSION_CYCLE_NO,SPECIALITY_CODE,AM_GET_DESC.AM_SPECIALITY(SPECIALITY_CODE,?,2) speciality_name,  F.NOTE_TYPE, CA_GET_DESC.CA_NOTE_TYPE(F.NOTE_TYPE,?,2) note_type_desc,NOTE_GROUP_ID,ca_get_desc.CA_NOTE_GROUP(NOTE_GROUP_ID,?,2) note_group_desc,  PROGRESSION_STATUS from CA_PAT_PROGRESSION_HDR D,CA_PAT_PROGRESSION_DTL E,CA_ENCNTR_NOTE F,ca_note_type G  where D.PROGRESSION_REF=E.PROGRESSION_REF   and E.ACCESSION_NUM =F.ACCESSION_NUM   and F.NOTE_TYPE=G.NOTE_TYPE   AND G.NOTE_TYPE != START_PROGRESS_NOTE_TYPE  and D.PATIENT_ID= ? and D.MODULE_ID = ? and D.FACILITY_ID = ? and D.PROGRESSION_REF = ? and F.EVENT_STATUS !=9 and G.EFF_STATUS='E' and decode(?,'IP',inpatient_yn,'OP',outpatient_yn,'DC',DAYCARE_YN,'EM',EMERGENCY_YN,'XT',PATIENT_SPECIFIC_YN)='Y' ");




	 if(sel_progression_no.equals("S"))
	 {
		menu_sql_hdr.append(" and PROGRESSION_STATUS= 'O' "); 
		//menu_sql_dtl.append(" and PROGRESSION_STATUS= 'O' "); 
	 }
	 else if(sel_progression_no.equals("C"))
	 {
		menu_sql_hdr.append(" and PROGRESSION_STATUS= 'C' "); 
		//menu_sql_dtl.append(" and PROGRESSION_STATUS= 'C' "); 
	 }
	 else if(!sel_progression_no.equals("A"))
	 {
		if(called_from.equals("OH_TREATMENT"))
		 {
			menu_sql_hdr.append(" and PROGRESSION_REF = ?  ");
		 }
		 else
		 {
		menu_sql_hdr.append(" and PROGRESSION_CYCLE_NO = ?  "); 
		 }
		//menu_sql_dtl.append(" and PROGRESSION_CYCLE_NO = ?  "); 
	 }
	 if(called_from.equals("OH_TREATMENT"))
	 {
		menu_sql_hdr.append(" and CALLED_FROM = 'OH_TREATMENT' ");
	 }
	 else
	 {
		menu_sql_hdr.append(" and CALLED_FROM = 'OH_CHARTING' ");
	 }

	 menu_sql.append(menu_sql_hdr );
	 //menu_sql.append(" Union " );
	// menu_sql.append(menu_sql_dtl );
	 menu_sql.append(" ORDER  BY PROGRESSION_CYCLE_NO " );

	String prog_dtl=" select B.NOTE_TYPE,A.ACCESSION_NUM,to_char(b.EVENT_DATE_TIME,'DD/MM/YY') ENCNTR_DATE,EVENT_STATUS from  CA_PAT_PROGRESSION_DTL A ,CA_ENCNTR_NOTE B where PROGRESSION_REF=? and a.ACCESSION_NUM=b.ACCESSION_NUM and b.EVENT_STATUS!=9 order by b.EVENT_DATE_TIME ";

            _bw.write(_wl_block9Bytes, _wl_block9);

	try
	{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(menu_sql.toString());

		int count=1;
		pstmt.setString(count++,locale);
		pstmt.setString(count++,locale);
		pstmt.setString(count++,locale);
		pstmt.setString(count++,patient_class);
		pstmt.setString(count++,ca_practitioner_id);
		pstmt.setString(count++,facility_id);
		pstmt.setString(count++,patient_id);
		pstmt.setString(count++,module_id);
		pstmt.setString(count++,facility_id);

		if(called_from.equals("OH_TREATMENT"))
		{
			pstmt.setString(count++,progression_ref_req);
		}
		else if(!(sel_progression_no.equals("S"))&&!(sel_progression_no.equals("C"))&&!(sel_progression_no.equals("A")))
		{
			pstmt.setString(count++,sel_progression_no);
		}
	/*pstmt.setString(count++,locale);
		pstmt.setString(count++,locale);
		pstmt.setString(count++,locale);
		pstmt.setString(count++,patient_id);
		pstmt.setString(count++,module_id);
		pstmt.setString(count++,facility_id);

		if(!(sel_progression_no.equals("S"))&&!(sel_progression_no.equals("C"))&&!(sel_progression_no.equals("A")))
		{
			
			pstmt.setString(count++,sel_progression_no);
		} */

		rs	 = pstmt.executeQuery();

		while(rs.next())
		{

			flag = false;
			progression_ref = rs.getString("PROGRESSION_REF")==null?"1":rs.getString("PROGRESSION_REF");
			progression_no = rs.getString("PROGRESSION_CYCLE_NO")==null?"0":rs.getString("PROGRESSION_CYCLE_NO");
			speciality_code = rs.getString("speciality_code")==null?"":rs.getString("speciality_code");
			note_type_desc = rs.getString("note_type_desc")==null?"":rs.getString("note_type_desc");
			eff_status = rs.getString("EFF_STATUS")==null?"":rs.getString("EFF_STATUS");
			patient_class_yn = rs.getString("patient_class_yn")==null?"":rs.getString("patient_class_yn");
			progress_note_type = rs.getString("START_PROGRESS_NOTE_TYPE")==null?"":rs.getString("START_PROGRESS_NOTE_TYPE");
			note_group_desc = rs.getString("note_group_desc")==null?"":rs.getString("note_group_desc");
			note_group = rs.getString("note_group")==null?"":rs.getString("note_group");
			progression_status = rs.getString("PROGRESSION_STATUS")==null?"":rs.getString("PROGRESSION_STATUS");
			speciality_name = rs.getString("speciality_name")==null?"":rs.getString("speciality_name");
			
			access_yn = rs.getString("access_yn")==null?"":rs.getString("access_yn");

			 start_progress_note_type = progress_note_type ;
		
		
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(i));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(i));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);

	 
		if(access_yn.equals("Y")){

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(progression_ref));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(note_group));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(note_group_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(note_group));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(progression_ref));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(note_group_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(note_group_desc));
            _bw.write(_wl_block25Bytes, _wl_block25);
	}else {	
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(progression_ref));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(note_group));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(note_group_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(note_group_desc));
            _bw.write(_wl_block28Bytes, _wl_block28);
}
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(progression_ref));
            out.print( String.valueOf(progress_note_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(progression_ref));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(note_group));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(note_type_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(note_type_desc));
            _bw.write(_wl_block32Bytes, _wl_block32);


		if(!progression_ref.equals(""))
			{
				
				pstmt2 = con.prepareStatement(menu_sql_dtl.toString());
				//pstmt2.setString(1,locale);
				//pstmt2.setString(2,locale);
				pstmt2.setString(1,locale);
				pstmt2.setString(2,patient_id);
				pstmt2.setString(3,module_id);
				pstmt2.setString(4,facility_id);
				pstmt2.setString(5,progression_ref);
				rs2	 = pstmt2.executeQuery();
				while(rs2.next())
				{

					//progression_ref = rs.getString("PROGRESSION_REF")==null?"1":rs.getString("PROGRESSION_REF");
					//progression_no = rs.getString("PROGRESSION_CYCLE_NO")==null?"0":rs.getString("PROGRESSION_CYCLE_NO");
					//speciality_code = rs.getString("speciality_code")==null?"":rs.getString("speciality_code");
					//note_type_desc = rs2.getString("note_type_desc")==null?"":rs2.getString("note_type_desc");
					//progress_note_type = rs2.getString("NOTE_TYPE")==null?"":rs2.getString("NOTE_TYPE");
					note_group_desc = rs2.getString("note_group_desc")==null?"":rs2.getString("note_group_desc");
					note_group = rs2.getString("NOTE_GROUP_ID")==null?"":rs2.getString("NOTE_GROUP_ID");
					//progression_status = rs.getString("PROGRESSION_STATUS")==null?"":rs.getString("PROGRESSION_STATUS");
					//speciality_name = rs.getString("speciality_name")==null?"":rs.getString("speciality_name");

					if(access_yn.equals("Y")){

				
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(progression_ref));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(note_group));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(note_group_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(note_group));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(progression_ref));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(note_group_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(note_group_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(progression_ref));
            out.print( String.valueOf(note_group));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(note_group_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(note_group_desc));
            _bw.write(_wl_block35Bytes, _wl_block35);
 }else{ 
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(progression_ref));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(note_group));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(note_group_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(note_group_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(progression_ref));
            out.print( String.valueOf(note_group));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(note_group_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(note_group));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(progression_ref));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(note_group_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(note_group_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
 } 
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(progression_ref));
            out.print( String.valueOf(progress_note_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(progression_ref));
            out.print( String.valueOf(note_group));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(note_type_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(note_type_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);


				}

				if(rs2!=null)	rs2.close();
				if(pstmt2!=null)	pstmt2.close();


				pstmt2 = con.prepareStatement(menu_sql_dtl2.toString());
				pstmt2.setString(1,locale);
				pstmt2.setString(2,locale);
				pstmt2.setString(3,locale);
				pstmt2.setString(4,patient_id);
				pstmt2.setString(5,module_id);
				pstmt2.setString(6,facility_id);
				pstmt2.setString(7,progression_ref);
				rs2	 = pstmt2.executeQuery();
				while(rs2.next())
				{

					//progression_ref = rs.getString("PROGRESSION_REF")==null?"1":rs.getString("PROGRESSION_REF");
					//progression_no = rs.getString("PROGRESSION_CYCLE_NO")==null?"0":rs.getString("PROGRESSION_CYCLE_NO");
					//speciality_code = rs.getString("speciality_code")==null?"":rs.getString("speciality_code");
					note_type_desc = rs2.getString("note_type_desc")==null?"":rs2.getString("note_type_desc");
					progress_note_type = rs2.getString("NOTE_TYPE")==null?"":rs2.getString("NOTE_TYPE");
					note_group_desc = rs2.getString("note_group_desc")==null?"":rs2.getString("note_group_desc");
					note_group = rs2.getString("NOTE_GROUP_ID")==null?"":rs2.getString("NOTE_GROUP_ID");
					//progression_status = rs.getString("PROGRESSION_STATUS")==null?"":rs.getString("PROGRESSION_STATUS");
					//speciality_name = rs.getString("speciality_name")==null?"":rs.getString("speciality_name");

				
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(progression_ref));
            out.print( String.valueOf(progress_note_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(progression_ref));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(note_group));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(note_type_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(note_type_desc));
            _bw.write(_wl_block35Bytes, _wl_block35);


				
				
				}

				if(rs2!=null)	rs2.close();
				if(pstmt2!=null)	pstmt2.close();
				
				pstmt1 = con.prepareStatement(prog_dtl);
				pstmt1.setString(1,progression_ref);
				rs1	 = pstmt1.executeQuery();
				 
				while(rs1.next())
				{

					
					acc_num = rs1.getString("ACCESSION_NUM")==null?"":rs1.getString("ACCESSION_NUM");
					progress_note_type = rs1.getString("NOTE_TYPE")==null?"":rs1.getString("NOTE_TYPE");
					event_date = rs1.getString("ENCNTR_DATE")==null?"":rs1.getString("ENCNTR_DATE");
					event_status = rs1.getString("EVENT_STATUS")==null?"":rs1.getString("EVENT_STATUS");

					event_date_disp = event_date;
					
					if(event_status.equals("4")||event_status.equals("5"))
					{
						
						acc_num_id ="$$SIGN##"+acc_num;
						//event_date_disp= "<img src='../images/MCT_Chart.gif' alt='' /> "+event_date+" "; 
						
					}
				    else
					{
						acc_num_id ="$$RECD##"+acc_num;
						//event_date_disp=" <img src='../images/MI_Diagnosis.gif' alt='' /> "+event_date+" ";	
					}
					if(access_yn.equals("Y"))
					{
						if(progression_status.equals("O"))
						{
	
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(acc_num_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(progression_ref));
            out.print( String.valueOf(progress_note_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(event_date_disp));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(progress_note_type));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(acc_num));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(progression_ref));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(event_date_disp));
            _bw.write(_wl_block45Bytes, _wl_block45);
					} 
						else
						{

	
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(acc_num_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(progression_ref));
            out.print( String.valueOf(progress_note_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(event_date_disp));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(note_group));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(progression_ref));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(note_group_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(acc_num));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(event_date_disp));
            _bw.write(_wl_block45Bytes, _wl_block45);




	
						}
					}
					else
					{
	
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(acc_num_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(progression_ref));
            out.print( String.valueOf(progress_note_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(event_date_disp));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(event_date_disp));
            _bw.write(_wl_block45Bytes, _wl_block45);

					}

				}
				if(rs1!=null)	rs1.close();
				if(pstmt1!=null)	pstmt1.close();

		// for Add new

				pstmt2 = con.prepareStatement(menu_sql_dtl3.toString());
				pstmt2.setString(1,locale);
				pstmt2.setString(2,locale);
				pstmt2.setString(3,locale);
				pstmt2.setString(4,patient_id);
				pstmt2.setString(5,module_id);
				pstmt2.setString(6,facility_id);
				pstmt2.setString(7,progression_ref);
				pstmt2.setString(8,patient_class);
				rs2	 = pstmt2.executeQuery();
				while(rs2.next())
				{

					//progression_ref = rs.getString("PROGRESSION_REF")==null?"1":rs.getString("PROGRESSION_REF");
					//progression_no = rs.getString("PROGRESSION_CYCLE_NO")==null?"0":rs.getString("PROGRESSION_CYCLE_NO");
					//speciality_code = rs.getString("speciality_code")==null?"":rs.getString("speciality_code");
					note_type_desc = rs2.getString("note_type_desc")==null?"":rs2.getString("note_type_desc");
					progress_note_type = rs2.getString("NOTE_TYPE")==null?"":rs2.getString("NOTE_TYPE");
					note_group_desc = rs2.getString("note_group_desc")==null?"":rs2.getString("note_group_desc");
					note_group = rs2.getString("NOTE_GROUP_ID")==null?"":rs2.getString("NOTE_GROUP_ID");
					//progression_status = rs.getString("PROGRESSION_STATUS")==null?"":rs.getString("PROGRESSION_STATUS");
					//speciality_name = rs.getString("speciality_name")==null?"":rs.getString("speciality_name");

				if(progression_status.equals("O"))
				{
				if(access_yn.equals("Y")){

				
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(progression_ref));
            out.print( String.valueOf(note_group));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(note_group_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(note_group));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(progression_ref));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(note_group_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(note_group_desc));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(progress_note_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(progression_ref));
            out.print( String.valueOf(progress_note_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AddNewP.label","ca_labels")));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(progress_note_type));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(progress_note_type));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(progression_ref));
            _bw.write(_wl_block53Bytes, _wl_block53);

				}else {
				
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(progress_note_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(progression_ref));
            out.print( String.valueOf(progress_note_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AddNewP.label","ca_labels")));
            _bw.write(_wl_block55Bytes, _wl_block55);

				}
				}
				else
				{
				
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(progress_note_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(progression_ref));
            out.print( String.valueOf(progress_note_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AddNewP.label","ca_labels")));
            _bw.write(_wl_block56Bytes, _wl_block56);


				}
				}

				if(rs2!=null)	rs2.close();
				if(pstmt2!=null)	pstmt2.close();



		//  Add new ends.

			}

		
		if(progression_status.equals("O"))
		{

		
			if(access_yn.equals("Y")){
				if(eff_status.equals("E")&&patient_class_yn.equals("Y")){
			
			
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(progression_ref));
            out.print( String.valueOf(start_progress_note_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AddNewP.label","ca_labels")));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(start_progress_note_type));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(start_progress_note_type));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(progression_ref));
            _bw.write(_wl_block58Bytes, _wl_block58);

				}	
			
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AddNewP.label","ca_labels")));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(progression_ref));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RecordOutcome.label","ca_labels")));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(progression_ref));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(progression_no));
            _bw.write(_wl_block66Bytes, _wl_block66);

			} 
			else
			{
			
				if(eff_status.equals("E")&&patient_class_yn.equals("Y")){
			
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(progression_ref));
            out.print( String.valueOf(start_progress_note_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AddNewP.label","ca_labels")));
            _bw.write(_wl_block68Bytes, _wl_block68);
 
				} 
			
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AddNewP.label","ca_labels")));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RecordOutcome.label","ca_labels")));
            _bw.write(_wl_block70Bytes, _wl_block70);
		}
		}
	else
		{
	
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(progression_ref));
            out.print( String.valueOf(progress_note_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AddNewP.label","ca_labels")));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(progression_ref));
            out.print( String.valueOf(note_group));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AddNewP.label","ca_labels")));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.RecordOutcome.label","ca_labels")));
            _bw.write(_wl_block74Bytes, _wl_block74);
  
	

		}
		if(progression_status.equals("O"))
		{
			if(!speciality_name.equals("")){
				boldText = "<a href=javascript:viewProgression("+progression_ref+",'"+access_yn+"') > <b> Progression "+progression_no+"( "+speciality_name+" )</b></a>";	
			}
			else
			{
				boldText = "<a href=javascript:viewProgression("+progression_ref+",'"+access_yn+"') > <b> Progression "+progression_no+" </b></a>";		
			}
		}
		else
		{
			if(!speciality_name.equals("")){
				boldText = " <a href=javascript:viewProgression("+progression_ref+",'"+access_yn+"') >Progression "+progression_no+"( "+speciality_name+" ) </a> ";
			}
			else
			{
				boldText = " <a href=javascript:viewProgression("+progression_ref+",'"+access_yn+"') >Progression "+progression_no+" </a> ";
			}
		}

		if(!progression_no.equals(pre_progression_no))
		{
	
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(boldText));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);

			
	  }
  			


            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);

	   i++;
		pre_progression_no = progression_no;
		
		}
		
		if(rs!=null)
			rs.close();
		if(pstmt!=null)
			pstmt.close();
		


	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		try
		{
			if(rs!= null) rs.close();
			if(pstmt!=null) pstmt.close();
			
			if(con!= null) ConnectionManager.returnConnection(con,request);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


            _bw.write(_wl_block82Bytes, _wl_block82);

if(flag)
		{

		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'))</script>");
			
		}

            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block84Bytes, _wl_block84);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
