package jsp_servlet._eca._jsp;

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
import java.util.Date;
import java.text.SimpleDateFormat;
import eCommon.XSSRequestWrapper;

public final class __recprintnotelayout extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecPrintNoteLayout.jsp", 1729857570563L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<style type=\"text/css\" media=\"print\">   \n\tth {\n\t\tfont-family:Arial;\n\t\tcolor:black;\n\t\tbackground-color:lightgrey;\n\t}\n\tthead {\n\t\tdisplay:table-header-group;\n\t}\n\ttbody {\n\t\tdisplay:table-row-group;\n\t}\n\ttfoot {\n\t\tdisplay:table-footer-group;\t\t\n\t}\n\n</style>\n</head>\n<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n<body class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad = \"Print()\">\n<form>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script Language=\"vbscript\">\n    Dim WSHShell\n    Dim myHeader\n    Dim myFooter\n    Dim myMarginleft \n    Dim myMarginright \n    Set WSHShell = CreateObject(\"WScript.Shell\")\n    REM myHeader = WSHShell.RegRead(\"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header\")\n    REM myFooter = WSHShell.RegRead(\"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer\")\n    REM myMarginleft = WSHShell.RegRead(\"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_left\") \n    REM myMarginright = WSHShell.RegRead(\"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_right\") \n\n    WSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header\", \"&bPage &p of &P\"\n    WSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer\", \"&b&d\"\n    WSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_left\", \"0.5\"\n    WSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_right\", \"0.3\"\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\tWSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_top\", \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\tWSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_top\", \"0.75\"\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n  \n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\n\tWSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_bottom\", \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\t\n\tWSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_bottom\", \"0.5\"\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\n\n<style>\n\tADDRESS\t{\t\t\n\t\tFONT-FAMILY: Verdana ;\t\t\n\t\tFONT-SIZE: 10pt ; \n\t\tFONT-STYLE: NORMAL; \n\t\tCOLOR: BLACK; \n\t}\n\tPRE{\n\t\tfont-size:10pt;\t\t\t\n\t\tfont-family: Verdana;\t\t\t\n\t\tBACKGROUND-COLOR: #FFFFFF;\n\t\tBORDER-STYLE: none;\n\t\tfontWeight : bold;\n\t\ttext-align: left;\n\t\twhite-space: normal;\n\t\tword-wrap: break-word;\t\t\t\n\t}\t\t\n</style>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n<table border=\"0\" width=\"100%\"> \n\t<thead>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t<tr> \n\t\t\t<th style=\"width:100%\">\n\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t</th>\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\n\t\t<tr> \n\t\t\t<th style=\"width:100%\">\n\t\t\t\t<br>\n\t\t\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width = \'100%\' style=\"font-family:Verdana;:background-color:#ADADAD\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=\"3\" ><font style =\"font-family:Verdana\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</font></td></tr>\n\t\t\t\t</table>\n\t\t\t\t<br>\n\t\t\t</th> \n\t\t</tr>\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t</thead>\n\t\n\t<tbody> \n    \t<tr> \n     \t\t<td width=\"100%\">\n     \t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n     \t\t\t\t<table border=\"0\" width=\"100%\"> \n\t\t\t\t\t\t<thead> \n\t\t\t\t\t\t\t<tr> \n\t\t\t\t\t\t\t\t<th style=\"width:100%\">\n\t\t\t\t\t\t\t\t\t<br>\n\t\t\t\t\t\t\t\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width = \'100%\' style=\"font-family:Verdana;:background-color:#ADADAD\">\n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t<td colspan=\"3\" ><font style =\"font-family:Verdana\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</font></td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t<br>\n\t\t\t\t\t\t\t\t</th> \n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</thead> \n\t\t\t\t\t</table>\n     \t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t<br>\n\t\t\t\t<table width=\'100%\' border=1 cellpadding=0 cellspacing=0 align=center style=\"padding-bottom:1px\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\"3\" ><font style =\"font-family:Verdana\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</font>\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n     \t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\t\n     \t\t\t\t\t\t\t\t<table width=\'100%\' border=1 cellpadding=0 cellspacing=0 align=center>\n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t<td colspan=\"3\" class=\'ITEMSELECT\' ><font style=\"font-family:Verdana;FONT-SIZE:9pt;font-weight:bold;\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</font>\t</td>\n\t\t\t\t\t\t\t\t\t\t</tr>\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</font>\t</td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t<td colspan=\"3\" ><font style =\"font-family:Verdana\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</font>\t</td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\t\n\t\t\t\t\t\t\t\t<table width=\'100%\' border=1 cellpadding=0 cellspacing=0 align=center>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td colspan=\"3\" class=\'ITEMSELECT\' ><font style=\"font-family:Verdana;FONT-SIZE:9pt;font-weight:bold;\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</font>\t</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td colspan=\"3\" >&nbsp;<br><br><br><br><br><br><br><br></td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t<table width=\'100%\' border=1 cellpadding=0 cellspacing=0 align=center>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\"3\" >&nbsp;<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n     \t\t\t<table width=\'100%\' border=1 cellpadding=0 cellspacing=0 align=center>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\"3\" ><font style =\"font-family:Verdana\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</font>\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t<table width=\'100%\' border=1 cellpadding=0 cellspacing=0 align=center>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\"3\" ><font style =\"font-family:Verdana\">";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n     \t\t</td>\n     \t</tr>\n     </tbody>\n</table>\n<script>\n\t\t\t\tfunction Print() \n\t\t\t\t{\n\t\t\t\t\t//alert(\"Print 869\");\n\t\t\t\t\tif (document) {\n\t\t\t\t\t\tvar i = 0;\n\t\t\t\t\t\tvar confMess =\"Continue printing ?\";\n\t\t\t\t\t\tif(";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="==0)\n\t\t\t\t\t\t\tconfMess =\"Sections are not linked, Continue printing ?\";\n\t\t\t\t\t\tvar res = confirm(confMess);\n\t\t\t\t\t\tif(res)  \n\t\t\t\t\t\t{\n\t\t\t\t\t\t\twhile( i < document.applets.length ) \n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar j = 0 ;\n\t\t\t\t\t\t\t\twhile ( !document.applets[i].isActive() && j++ <=75000 ) \n\t\t\t\t\t\t\t\t\twindow.status = i;\n\t\t\t\t\t\t\t\ti++;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\twindow.print();\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tsetTimeout(function() {\n\t\t\t\t\t\t\t//alert(\"Print inside if while loop 888\");\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t//window.close(); \n\t\t\t\t\t\t\tconst dialogTag = parent.document.getElementById(\"dialog_tag\");    \n\t\t\t\t\t\t\tdialogTag.close();  \n\t\t\t\t\t\t\t}, ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =");\t\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t//window.close();\n\t\t\t\t\t\t\t//alert(\"Print  inside else 895\");\n\t\t\t\t\t\t\tconst dialogTag = parent.document.getElementById(\"dialog_tag\");    \n\t\t\t\t\t\t\tdialogTag.close();\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t</script>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

	public String checkForNull(String inputString)
	{
		return ((inputString==null)	?	""	:	inputString).trim();
	}
	public String checkForNull(String inputString, String defaultValue)
	{
		if(inputString==null)inputString ="";
		
		return ( (inputString.equals("") )	?	defaultValue	:	inputString).trim();
		
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

/*
---------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------
14/08/2015	IN052376		Ramesh G										MMS-RY-CRF-0012 [IN:052376]
01/09/2015	IN057173		Ramesh G										System does not print main sections and their linked subsections with components.
10/10/2018	IN068669		sivabagyam	 	10/10/2018	     Ramesh G       ARYU-CRF-0026
06/09/2019	IN071335		Ramesh G										Common-ICN-0012
---------------------------------------------------------------------------------------------------------
*/ 

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
            _bw.write(_wl_block1Bytes, _wl_block1);
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(request.getParameter("title")));
            _bw.write(_wl_block6Bytes, _wl_block6);


	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String facility_id		=	(String)session.getValue("facility_id");
	String 	header_top 			= "";	
	String	logo_hdr_all_pages 	= "";
	String	rpt_hdr_all_pages 	= "";	
	String	footer_bottom 		= ""; 
	String	hdr_ft_yn 			= "";
	String	note_type			= "";
	String	imageLogoHeader 	= "N";
	String 	textLogoHeader 		= "N";
	String 	printhdrindsyn		= "";
	String  note_group_desc		= "";
	String	site_name			= "";
	String	facility_name		= "";
	String	patient_id			= "";
	String	encounter_id			= "";
	String LOGO_HDR_HEIGHT="40";//IN068669
	String LOGO_HDR_WIDTH="40";//IN068669
	int sectionCount			=0;
	int note_print_time_interval	=0;
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;	
	PreparedStatement	pstmt1		=	null;
	ResultSet			rs1			=	null;
	StringBuffer query_section_details = new StringBuffer(); //IN057173
	note_type			=	request.getParameter("note_type")==null		? ""	:	request.getParameter("note_type");
	patient_id			=	request.getParameter("patient_id")==null	? ""	:	request.getParameter("patient_id");
	encounter_id		=	request.getParameter("encounter_id")==null	? ""	:	request.getParameter("encounter_id");
	
	try{	
		con	= ConnectionManager.getConnection(request);
		//pstmt =	con.prepareStatement(" select LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN  FROM ca_note_param "); commenetd for IN068669
		pstmt =	con.prepareStatement(" select LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN,LOGO_HDR_HEIGHT,LOGO_HDR_WIDTH FROM ca_note_param ");//IN068669
		rs	=	pstmt.executeQuery();
		if(rs.next()){
				logo_hdr_all_pages	= rs.getString("LOGO_HDR_ALL_PAGE_YN") == null ? "" : rs.getString("LOGO_HDR_ALL_PAGE_YN");
				rpt_hdr_all_pages	= rs.getString("RPT_HDR_ALL_PAGE_YN") == null ? "" : rs.getString("RPT_HDR_ALL_PAGE_YN");
				LOGO_HDR_HEIGHT = rs.getString("LOGO_HDR_HEIGHT") == null ? "40" : rs.getString("LOGO_HDR_HEIGHT"); //IN068669
				LOGO_HDR_WIDTH = rs.getString("LOGO_HDR_WIDTH") == null ? "40" : rs.getString("LOGO_HDR_WIDTH"); //IN068669
		}
		if(rs!=null)	rs.close();
		if(pstmt!=null)	pstmt.close();
	}catch(Exception e){
			//out.println("Exception@111 - in getting logo and report header: "+e);//COMMON-ICN-0181		
			e.printStackTrace();//COMMON-ICN-0181
	}
		
	try{
		pstmt = con.prepareStatement("select HDR_FT_MARGIN_IN_NOTE_YN from CA_NOTE_PARAM");
		rs = pstmt.executeQuery();
		if(rs.next()){
			hdr_ft_yn =  rs.getString("HDR_FT_MARGIN_IN_NOTE_YN") == null ? "" : rs.getString("HDR_FT_MARGIN_IN_NOTE_YN");
		}
		if(hdr_ft_yn.equals("Y")){
			rs = null;
			pstmt = null;
			pstmt =	con.prepareStatement(" select HDR_MARGIN_IN_INCH ,FT_MARGIN_IN_INCH from CA_NOTE_TYPE where NOTE_TYPE = ? "); //[IN031116] End
			pstmt.setString	(1,note_type );
			rs	=	pstmt.executeQuery();
			if(rs.next()){
				header_top	= rs.getString("HDR_MARGIN_IN_INCH") == null ? "" : rs.getString("HDR_MARGIN_IN_INCH");
				footer_bottom = rs.getString("FT_MARGIN_IN_INCH") == null ? "" : rs.getString("FT_MARGIN_IN_INCH");
			}
		}
		if(rs!=null)	rs.close();
		if(pstmt!=null)	pstmt.close();
	}catch(Exception e){
		//out.println("Exception@111 - in getting header_appl_yn : "+e);//COMMON-ICN-0181
                  e.printStackTrace();//COMMON-ICN-0181
	}
	try
	{

		pstmt	= con.prepareStatement("SELECT IMAGE_REF FROM CA_NOTE_IMAGE_LIST WHERE IMAGE_REF='VDFI'");
		rs = pstmt.executeQuery();
		if(rs.next()){
			imageLogoHeader="Y";				
		}
		
		pstmt	= con.prepareStatement("SELECT PRINT_LOGO_HEADER_YN,PRINT_TEXT_HDR_YN FROM CA_NOTE_TYPE WHERE NOTE_TYPE=?");
		pstmt.setString(1,note_type);
		rs = pstmt.executeQuery();
		if(rs.next()){
			String printLogoHed = rs.getString("PRINT_LOGO_HEADER_YN")==null?"":(String)rs.getString("PRINT_LOGO_HEADER_YN");
			printhdrindsyn		= rs.getString("PRINT_LOGO_HEADER_YN")==null?"":(String)rs.getString("PRINT_LOGO_HEADER_YN");
			String printtextHed = rs.getString("PRINT_TEXT_HDR_YN")==null?"":(String)rs.getString("PRINT_TEXT_HDR_YN");
			if("Y".equals(printLogoHed) && "Y".equals(printtextHed))
					textLogoHeader="Y";				
		}
	}catch(Exception eee)
	{
		//out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());//COMMON-ICN-0181
		eee.printStackTrace();
	
	}
	finally
	{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	
	try{
		
		pstmt			=	con.prepareStatement("SELECT A.NOTE_GROUP_DESC NOTEGRDESC FROM CA_NOTE_GROUP A,CA_NOTE_TYPE B WHERE A.NOTE_GROUP=B.NOTE_GROUP_ID AND B.NOTE_TYPE=?");
		pstmt.setString(1, note_type);			
		rs				=	pstmt.executeQuery();
		if(rs.next())
		{
			note_group_desc = rs.getString("NOTEGRDESC");
		}
		
		if(rs!=null)	rs.close();
		if(pstmt!=null)	pstmt.close();
		
		//pstmt			=	con.prepareStatement("Select sm_get_desc.sm_facility_param (facility_id, ?, '1') facility_name,(SELECT site_name FROM sm_site_param_lang_vw WHERE language_id = ?) site_name from pr_encounter where ENCOUNTER_ID = ? and patient_id=?");
		pstmt			=	con.prepareStatement("SELECT SM_GET_DESC.SM_FACILITY_PARAM(?,?,'1') FACILITY_NAME, (SELECT SITE_NAME FROM SM_SITE_PARAM_LANG_VW WHERE LANGUAGE_ID=?) SITE_NAME FROM DUAL");
		//pstmt.setString(1, locale);	
		//pstmt.setString(2, locale);
		//pstmt.setString(3, encounter_id);
		//pstmt.setString(4, patient_id);
		pstmt.setString(1, facility_id);
		pstmt.setString(2, locale);
		pstmt.setString(3, locale);
		rs				=	pstmt.executeQuery();
		if(rs.next())
		{
			facility_name			=	rs.getString("facility_name") == null ? "" : rs.getString("facility_name");
			site_name			=	rs.getString("site_name")==null?"":rs.getString("site_name");
		}
		
		if(rs!=null)	rs.close();
		if(pstmt!=null)	pstmt.close();
	}catch(Exception eee)
	{
		//out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());//COMMON-ICN-0181
		eee.printStackTrace();
	
	}
	finally
	{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	if(!header_top.equals(""))
	{
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(header_top));
            _bw.write(_wl_block10Bytes, _wl_block10);

	} 
	else
	{
	
            _bw.write(_wl_block11Bytes, _wl_block11);

	}
	
            _bw.write(_wl_block12Bytes, _wl_block12);

	
	if(!footer_bottom.equals(""))
	{
	
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(footer_bottom));
            _bw.write(_wl_block10Bytes, _wl_block10);

	} 
	else
	{
	
            _bw.write(_wl_block14Bytes, _wl_block14);

	}
	
	
            _bw.write(_wl_block15Bytes, _wl_block15);

Hashtable htParameter=new Hashtable();
HashMap<String,String> paramMap = null;
StringBuffer sectionContentUpdatedXML=new StringBuffer();
eCA.HeaderDomParser parser = new eCA.HeaderDomParser();
webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();

String	section_content		= "";
String	section_content_rpt	= "";
String	section_content_hdr	= "";
String	section_content_ftr	= "";
String  section_content_dtl	= "";
String	note_header_code	= "";
String	footer_code			= "";
String	report_header_code	= "";
String 	disclaimer_code		= "";
String 	disclaimer_text		= "";
String  url1				= "";
String  url					= "";
String 	section_hdg_code	= "";
String	content_type		= "";
String section_hdg_desc		= "";

java.sql.Clob			clob_notes_content	= null;
java.io.Reader			content_reader		= null;
java.io.BufferedReader	bf_content_reader	= null;
// IN071335 Changes Start.
//url   = HttpUtils.getRequestURL(request).toString();
//url = url.substring(0,url.indexOf("jsp/"));
url					= application.getRealPath("/eCA")+"/";
// IN071335 Changes End.
//url1 = url + "html/RecClinicalNotesTemplateDispayView.xsl";
//System.out.println("======262============>"+url1);
url1 = url + "html/RecClinicalPrintNoteLayoutView.xsl";
System.out.println("======264============>"+url1);
String sect_template_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
String head_foot_qry ="select a.NOTE_HEADER_CODE,a.FOOTER_CODE,a.REPORT_HEADER_CODE,a.DISCLIMER_CODE from ca_note_type a where  a.NOTE_TYPE=?";

try{
	pstmt	= con.prepareStatement(head_foot_qry);
	pstmt.setString(1,note_type);
	rs = pstmt.executeQuery();

	while(rs.next()){
		note_header_code = rs.getString("NOTE_HEADER_CODE")==null?"":rs.getString("NOTE_HEADER_CODE");
		footer_code = rs.getString("FOOTER_CODE")==null?"":rs.getString("FOOTER_CODE");
		report_header_code 	= rs.getString("REPORT_HEADER_CODE")==null?"":rs.getString("REPORT_HEADER_CODE");
		disclaimer_code		= rs.getString("DISCLIMER_CODE")==null?"":rs.getString("DISCLIMER_CODE");
		System.out.println("--------------note_header_code------------->"+note_header_code);
		System.out.println("--------------footer_code------------->"+footer_code);
		System.out.println("--------------report_header_code------------->"+report_header_code);
	}	
	
}catch(Exception ee){
	//out.println("Exceptionin RecClinicalNotesSection.jsp @ head_foot_qry : "+ee.toString());//common-icn-0181
	ee.printStackTrace();
}finally{
	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();
}
if(!"".equals(disclaimer_code)){
	try{
		pstmt	= con.prepareStatement("SELECT DISCLIMER_TEXT FROM CA_DISCLIMER_TXT_LANG WHERE LANGUAGE_ID =? AND DISCLIMER_CODE=?");
		pstmt.setString(1,locale);
		pstmt.setString(2,disclaimer_code);
		rs = pstmt.executeQuery();

		while(rs.next()){
			disclaimer_text = rs.getString("DISCLIMER_TEXT")==null?"":rs.getString("DISCLIMER_TEXT");			
		}	
		
	}catch(Exception ee){
		//out.println("Exceptionin RecClinicalNotesSection.jsp @ head_foot_qry : "+ee.toString());//common-icn-0181
		ee.printStackTrace();
	}finally{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
}
//Report Header Start.
	try{
		pstmt	= con.prepareStatement(sect_template_query);	
		pstmt.setString(1,report_header_code);
		rs = pstmt.executeQuery();
		if(rs.next()){
			clob_notes_content			=	(java.sql.Clob) rs.getObject("TEMPLATE_FORMAT");
			if(clob_notes_content!=null){
				try{
					content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
					bf_content_reader	= new java.io.BufferedReader(content_reader);
					char[] arr_notes_content = new char[(int)clob_notes_content.length()];
					bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
					section_content = new String(arr_notes_content);
					bf_content_reader.close();
									
					if(section_content == null)
						section_content = "";
				}catch(Exception e){
					//out.println("Exception@1-readCLOB : "+e);//COMMON-ICN-0181
					e.printStackTrace();
				}
			}
		}
	}catch(Exception eee){
		//out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());//COMMON-ICN-0181
		eee.printStackTrace();
	}finally{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}

	StringBuffer section_content_new = new StringBuffer(section_content);
	
	if (! locale.equals("en") )
	{
		if(!section_content_new.toString().equals(""))
		{
			paramMap = new HashMap<String,String>();
			paramMap.put("CURR_SEC_HDG_CODE",report_header_code);
			paramMap.put("LOCALE",locale);						
			paramMap.put("RANGE_PASER_YN","N");
			eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,section_content_new);
			section_content_new = tempLangParse.getLangReplacedXML();
			tempLangParse = null;
		}


	}
	if(!section_content_new.toString().equals(""))
	{
		sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
	}
	if(!(sectionContentUpdatedXML.toString().equals(""))){								
		section_content_rpt=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);
	}
//Report Header End.
//Note Header Start
	try{
		section_content = "";
		pstmt	= con.prepareStatement(sect_template_query);
		pstmt.setString(1,note_header_code);
		rs = pstmt.executeQuery();

		if(rs.next()){				
			clob_notes_content			=	(java.sql.Clob) rs.getObject("TEMPLATE_FORMAT");				

			if(clob_notes_content!=null){
				try{					
					content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
					bf_content_reader	= new java.io.BufferedReader(content_reader);
					char[] arr_notes_content = new char[(int)clob_notes_content.length()];
					bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
					section_content = new String(arr_notes_content);
					bf_content_reader.close();
									
					if(section_content == null)
						section_content = "";
				}catch(Exception e){
					//out.println("Exception@1-readCLOB : "+e);//COMMON-ICN-0181
					e.printStackTrace();
				}
			}
		}
	}catch(Exception eee){
			//out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());//COMMON-ICN-0181
			eee.printStackTrace();
	}finally{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();		
	}
	section_content_new = new StringBuffer(section_content);
	sectionContentUpdatedXML = new StringBuffer();
	
	if (! locale.equals("en") )
	{
		if(!section_content_new.toString().equals(""))
		{
			paramMap = new HashMap<String,String>();
			paramMap.put("CURR_SEC_HDG_CODE",note_header_code);
			paramMap.put("LOCALE",locale);						
			paramMap.put("RANGE_PASER_YN","N");
			eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,section_content_new);
			section_content_new = tempLangParse.getLangReplacedXML();
			tempLangParse = null;
		}
	}				
			
	if(!section_content_new.toString().equals(""))
	{
		sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
	}

	
	if(!(sectionContentUpdatedXML.toString().equals("")))
	{								
			
		section_content_hdr=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);

	}

//Note Header End.
//Report Footer Start.
	try{
		section_content = "";
		pstmt	= con.prepareStatement(sect_template_query);
		pstmt.setString(1,footer_code);
		rs = pstmt.executeQuery();

		if(rs.next()){				
			clob_notes_content			=	(java.sql.Clob) rs.getObject("TEMPLATE_FORMAT");				

			if(clob_notes_content!=null){
				try{					
					content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
					bf_content_reader	= new java.io.BufferedReader(content_reader);
					char[] arr_notes_content = new char[(int)clob_notes_content.length()];
					bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
					section_content = new String(arr_notes_content);
					bf_content_reader.close();
									
					if(section_content == null)
						section_content = "";
				}catch(Exception e){
					//out.println("Exception@1-readCLOB : "+e);//COMMON-ICN-0181
					e.printStackTrace();
				}
			}
		}
	}catch(Exception eee){
			//out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());//COMMON-ICN-0181
			eee.printStackTrace();
	}finally{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();		
	}
	section_content_new = new StringBuffer(section_content);
	sectionContentUpdatedXML = new StringBuffer();
	
	if (! locale.equals("en") )
	{
		if(!section_content_new.toString().equals(""))
		{
			paramMap = new HashMap<String,String>();
			paramMap.put("CURR_SEC_HDG_CODE",footer_code);
			paramMap.put("LOCALE",locale);						
			paramMap.put("RANGE_PASER_YN","N");
			eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,section_content_new);
			section_content_new = tempLangParse.getLangReplacedXML();
			tempLangParse = null;
		}
	}				
			
	if(!section_content_new.toString().equals(""))
	{
		sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
	}

	
	if(!(sectionContentUpdatedXML.toString().equals("")))
	{								
			
		section_content_ftr=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);

	}
//Report Footer End.


            _bw.write(_wl_block1Bytes, _wl_block1);

if((printhdrindsyn.equals("Y")) && (logo_hdr_all_pages.equals("N")))
{
	if("Y".equals(imageLogoHeader)){
		out.println("<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >");
		out.println("<tr><td colspan='2'>");
		out.println("<table width='100%' style='height:100px;' border=0 cellpadding=3 cellspacing=0 align=center ><tr><td class='HEADER' align='center' id='headerImageID'>");
		out.println("<img src='../../eCA/jsp/CADisplayImages.jsp' ></td></tr></table>");
		out.println("</td></tr>");
		
		if("Y".equals(textLogoHeader)){
			out.println("<tr>");	
			out.println("<td width='100%' colspan='2' align='center'><h3>"+site_name+"</h3></td>");
			out.println("</tr>");
			out.println("<tr>");	
			out.println("<td width='100%' colspan='2' align='center'><h3>"+facility_name+"</h3></td>");
			out.println("</tr>");
			out.println("<tr>");	
			out.println("<td width='100%' colspan='2' align='center'><h4>"+note_group_desc+"</h4></td>");
			out.println("</tr>");
		}
		out.println("</table>");
	}else{
		out.println("<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >");
		out.println("<tr>");	
		//out.println("<td width='20%' class='HEADER' align='center'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='40' height='40'></td>"); commented for IN068669
		out.println("<td width='20%' class='HEADER' align='center' rowspan='3'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");//IN068669
		if("Y".equals(textLogoHeader)){	
			out.println("<td width='60%' align='center'><h3>"+site_name+"</h3></td>");
			out.println("<td width='20%'  align='center'>&nbsp;</td>");//IN037045
			out.println("</tr>");//IN037045
			out.println("<tr>");
			//out.println("<td width='20%'  align='center'>&nbsp;</td>");//IN068669
			out.println("<td width='60%'  align='center'><h3>"+facility_name+"</h3></td>");
			out.println("<td width='20%'  align='center'>&nbsp;</td>");//IN037045
			out.println("</tr>");
			out.println("<tr>");
			//out.println("<td width='20%'  align='center'>&nbsp;</td>");//IN068669
			out.println("<td width='60%'  align='center'><h4>"+note_group_desc+"</h4></td>");
			out.println("<td width='20%'  align='center'>&nbsp;</td>");//IN037045
			out.println("</tr>");
		}else{
			out.println("<td width='60%' align='center'>&nbsp;</h3></td>");
			out.println("<td width='20%'  align='center'>&nbsp;</td>");//IN037045
			out.println("</tr>");
		}
		out.println("</table>");
	}
}

            _bw.write(_wl_block16Bytes, _wl_block16);
 if((printhdrindsyn.equals("Y")) && (logo_hdr_all_pages.equals("Y"))){ 
            _bw.write(_wl_block17Bytes, _wl_block17);

					if("Y".equals(imageLogoHeader)){
						out.println("<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >");
						out.println("<tr><td colspan='2'>");
						out.println("<table width='100%' style='height:100px;' border=0 cellpadding=3 cellspacing=0 align=center ><tr><td class='HEADER' align='center' id='headerImageID'>");
						out.println("<img src='../../eCA/jsp/CADisplayImages.jsp' ></td></tr></table>");
						out.println("</td></tr>");
						
						if("Y".equals(textLogoHeader)){
							out.println("<tr>");	
							out.println("<td width='100%' colspan='2' align='center'><h3>"+site_name+"</h3></td>");
							out.println("</tr>");
							out.println("<tr>");	
							out.println("<td width='100%' colspan='2' align='center'><h3>"+facility_name+"</h3></td>");
							out.println("</tr>");
							out.println("<tr>");	
							out.println("<td width='100%' colspan='2' align='center'><h4>"+note_group_desc+"</h4></td>");
							out.println("</tr>");
						}
						out.println("</table>");
					}else{
						out.println("<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >");
						out.println("<tr>");	
						//out.println("<td width='20%' class='HEADER' align='center'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='40' height='40'></td>"); commented forIN068669 
						out.println("<td width='20%' class='HEADER' align='center' rowspan='3'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");//IN068669
						if("Y".equals(textLogoHeader)){		
							out.println("<td width='60%' align='center'><h3>"+site_name+"</h3></td>");
							out.println("<td width='20%'  align='center'>&nbsp;</td>");
							out.println("</tr>");
							out.println("<tr>");
							//out.println("<td width='20%'  align='center'>&nbsp;</td>");//IN068669
							out.println("<td width='60%'  align='center'><h3>"+facility_name+"</h3></td>");
							out.println("<td width='20%'  align='center'>&nbsp;</td>");
							out.println("</tr>");
							out.println("<tr>");
							//out.println("<td width='20%'  align='center'>&nbsp;</td>");//IN068669
							out.println("<td width='60%'  align='center'><h4>"+note_group_desc+"</h4></td>");
							out.println("<td width='20%'  align='center'>&nbsp;</td>");
							out.println("</tr>");
						}else{
							out.println("<td width='60%' align='center'>&nbsp;</h3></td>");
							out.println("<td width='20%'  align='center'>&nbsp;</td></tr>");
						}
						out.println("</table>");
					}
				
            _bw.write(_wl_block18Bytes, _wl_block18);

	}
	if(rpt_hdr_all_pages.equals("Y"))
	{
	
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(section_content_rpt));
            _bw.write(_wl_block20Bytes, _wl_block20);
} 
            _bw.write(_wl_block21Bytes, _wl_block21);
if(rpt_hdr_all_pages.equals("N")){
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(section_content_rpt));
            _bw.write(_wl_block23Bytes, _wl_block23);
}
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(section_content_hdr));
            _bw.write(_wl_block25Bytes, _wl_block25);

     			try{
					//IN057173 Start.
					query_section_details.append("select sec_hdg_code,1 DOC_EXISTS,");
					query_section_details.append("case when ? = 'en' then replace(sec_hdg_desc,'''','') else ");
					query_section_details.append("replace(CA_GET_DESC.CA_SECTION_HDG(SEC_HDG_CODE ,? ,'1'),'''','') end sec_hdg_desc");
					query_section_details.append(",sec_content_type,sec_result_linked_rec_type,");
					query_section_details.append("NVL(child_sec_hdg_code,sec_hdg_code) child_sec_hdg_code, ");
					query_section_details.append("CASE 	WHEN CHILD_SEC_HDG_CODE = NULL THEN ''");
					query_section_details.append("ELSE case when ? = 'en' then replace(child_sec_hdg_desc,'''','') ");
					query_section_details.append("else replace(CA_GET_DESC.CA_SECTION_HDG(child_sec_hdg_code,?,'1'),'''','') ");
					query_section_details.append("end end child_sec_hdg_desc ");
					query_section_details.append(",child_sec_content_type, child_sec_result_link_rec_type, CHIEF_COMPLAINT_SEC_YN");
					query_section_details.append(",IMAGE_LINKED_YN,'Y' CONTENT_EDITABLE_YN");
					query_section_details.append(",nvl(child_sec_result_link_rec_type,sec_result_linked_rec_type) result_link_type");
					query_section_details.append(",nvl(child_sec_content_type,sec_content_type) content_type, OUTPUT_FORM_EXISTS_YN,SELECTION_TYPE ");  
					query_section_details.append("from ca_note_section_view where note_type = ?  order by note_sec_seq_num, child_seq_num");

					pstmt		=	con.prepareStatement(query_section_details.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

					pstmt.setString(1,locale);
					pstmt.setString(2,locale);
					pstmt.setString(3,locale);
					pstmt.setString(4,locale);
					pstmt.setString(5,note_type);
					
     				//pstmt =	con.prepareStatement("SELECT CNS.SEC_HDG_CODE,CSH.CONTENT_TYPE,CSH.SEC_HDG_DESC FROM CA_NOTE_SECTION CNS,CA_SECTION_HDG CSH WHERE CNS.SEC_HDG_CODE=CSH.SEC_HDG_CODE AND CNS.NOTE_TYPE=? ORDER BY CNS.NOTE_SEC_SEQ_NUM");
     				//pstmt.setString(1,note_type);
					//End.
     				rs	=	pstmt.executeQuery();
					String tempSectionHDGCode = "";
     				while(rs.next()){
						sectionCount++;
     					section_hdg_code	= rs.getString("SEC_HDG_CODE") == null ? "" : rs.getString("SEC_HDG_CODE");
						//IN057173 Start.
						//content_type		= rs.getString("CONTENT_TYPE") == null ? "" : rs.getString("CONTENT_TYPE");
     					content_type		= rs.getString("SEC_CONTENT_TYPE") == null ? "" : rs.getString("SEC_CONTENT_TYPE");
						//IN057173 End.
						section_hdg_desc	= rs.getString("SEC_HDG_DESC") == null ? "" : rs.getString("SEC_HDG_DESC");
						//IN057173 Start.
						if("S".equals(content_type)){
							if(!tempSectionHDGCode.equals(section_hdg_code)){
								tempSectionHDGCode = section_hdg_code;
								
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(section_hdg_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);

							}
							section_hdg_code	= rs.getString("CHILD_SEC_HDG_CODE") == null ? "" : rs.getString("CHILD_SEC_HDG_CODE");
							content_type		= rs.getString("CHILD_SEC_CONTENT_TYPE") == null ? "" : rs.getString("CHILD_SEC_CONTENT_TYPE");
							section_hdg_desc	= rs.getString("CHILD_SEC_HDG_DESC") == null ? "" : rs.getString("CHILD_SEC_HDG_DESC");
						}
						//IN057173 End
     					if("T".equals(content_type)){
     						
     						try{
     							section_content = "";
     							pstmt1	= con.prepareStatement(sect_template_query);
     							pstmt1.setString(1,section_hdg_code);
     							rs1 = pstmt1.executeQuery();

     							if(rs1.next()){				
     								clob_notes_content			=	(java.sql.Clob) rs1.getObject("TEMPLATE_FORMAT");				

     								if(clob_notes_content!=null){
     									try{					
     										content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
     										bf_content_reader	= new java.io.BufferedReader(content_reader);
     										char[] arr_notes_content = new char[(int)clob_notes_content.length()];
     										bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
     										section_content = new String(arr_notes_content);
     										bf_content_reader.close();
     														
     										if(section_content == null)
     											section_content = "";
     									}catch(Exception e){
     										//out.println("Exception@1-readCLOB : "+e);//COMMON-ICN-0181
     										e.printStackTrace();
     									}
     								}
     							}
     						}catch(Exception eee){
     								//out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());//COMMON-ICN-0181
     								eee.printStackTrace();
     						}finally{
     							if(rs1 != null) rs1.close();
     							if(pstmt1 != null) pstmt1.close();
     						}
     						section_content_new = new StringBuffer(section_content);
     						sectionContentUpdatedXML = new StringBuffer();
     						
     						if (! locale.equals("en") )
     						{
     							if(!section_content_new.toString().equals(""))
     							{
     								paramMap = new HashMap<String,String>();
     								paramMap.put("CURR_SEC_HDG_CODE",section_hdg_code);
     								paramMap.put("LOCALE",locale);						
     								paramMap.put("RANGE_PASER_YN","N");
     								eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,section_content_new);
     								section_content_new = tempLangParse.getLangReplacedXML();
     								tempLangParse = null;
     							}
     						}				
     								
     						if(!section_content_new.toString().equals(""))
     						{
     							sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
     						}

     						
     						if(!(sectionContentUpdatedXML.toString().equals("")))
     						{								
     							converter=new webbeans.eCA.XMLtoHTML();							
     							section_content_dtl=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);
     							
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(section_hdg_desc));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(section_content_dtl));
            _bw.write(_wl_block29Bytes, _wl_block29);

     						}
     					}else if("F".equals(content_type)){
							
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(section_hdg_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);

						
						}
     				}
     				if(rs!=null)	rs.close();
     				if(pstmt!=null)	pstmt.close();
					pstmt	=	con.prepareStatement("SELECT NOTE_PRINT_TIME_INTERVAL FROM CA_NOTE_PARAM ");
					rs		=	pstmt.executeQuery();
					if(rs.next()){
						note_print_time_interval			= Integer.parseInt(rs.getString("NOTE_PRINT_TIME_INTERVAL") == null ? "0" : (String)rs.getString("NOTE_PRINT_TIME_INTERVAL"));
					}
					if(rs!=null)	rs.close();
					if(pstmt!=null)	pstmt.close();
     			}catch(Exception e){
     					//out.println("Exception@111 - in getting logo and report header: "+e);//COMMON-ICN-0181
     					e.printStackTrace();//COMMON-ICN-0181
     			}
				finally
				{
					if(con!=null) ConnectionManager.returnConnection(con,request);
				}
				if(sectionCount==0){
     			
            _bw.write(_wl_block32Bytes, _wl_block32);
}
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(section_content_ftr));
            _bw.write(_wl_block34Bytes, _wl_block34);
if(!"".equals(disclaimer_text)){
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(disclaimer_text));
            _bw.write(_wl_block34Bytes, _wl_block34);
}
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(sectionCount));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(note_print_time_interval));
            _bw.write(_wl_block38Bytes, _wl_block38);
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
