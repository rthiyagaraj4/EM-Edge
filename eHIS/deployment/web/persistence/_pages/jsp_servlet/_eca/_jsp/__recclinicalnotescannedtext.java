package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import java.util.*;
import eCA.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __recclinicalnotescannedtext extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesCannedText.jsp", 1734711284113L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t<!-- added by Kishore Kumar N on 10/12/2008  -->\n\t\n\t<!-- end here -->\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart1.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart2.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<style>\n\t.COLUMNHEADER1 {\n\t\tbackground: url(\"../images/headerSeparator.jpg\") repeat-y;\n\t\tbackground-position:right;\n\t\tCOLOR: white ;\n\t\tbackground-color:#83AAB4;\n\t\tborder-bottom:4px;\n\t\tpadding-left:3px;\n\t\tfont-family: Verdana;\n\t\tfont-size: 8pt;\n\t\tfont-weight:bold;\n\t\tborder-collapse:collapse;\n\t\tPADDING-TOP:5px;\n\t\tPADDING-BOTTOM:10px;\n\t}\n\t</style>\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" class=\'CONTENT\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<center>\n\t<form name=\'RecClinicalNotesCannedTextForm\' id=\'RecClinicalNotesCannedTextForm\'>\n\t\t<table class=\'grid\' width=\'100%\' >\n\t\t<tr>\n\t\t\t<td colspan=\'3\' class=\'columnheader\'>\n\t\t\t\t<!--IN063814 Start-->\n\t\t\t\t<!--<input type=\'radio\' name=\'r1\' id=\'r1\' value=\'T\' onclick=\'javascript:refPage();\' ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" />";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" &nbsp;&nbsp;\n\t\t\t\t<input type=\'radio\' name=\'r1\' id=\'r1\' value=\'E\' onclick=\'javascript:refPage();\' ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="--> \n\t\t\t\t<input type=\'radio\' name=\'r1\' id=\'r1\' value=\'T\' id = \'txt_rd\' onclick=\'javascript:refPage();\' ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" &nbsp;&nbsp;\n\t\t\t\t\n\t\t\t\t<input type=\'radio\' name=\'r1\' id=\'r1\' value=\'E\' id = \'edit_rd\' onclick=\'javascript:refPage();\' ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="  ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" style=\"display:none\" ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="/>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\n\t\t\t\t<!--IN063814 End-->\n\t\t\t</td>\t\t\t\n\t\t</tr>\t\t\n\t\t<tr>\n\t\t\t<td class=\'columnheader\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t<td class=\'columnheader\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t<tr style=\"display:none\"><td id=\"CL";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td></tr>\n\t\t\t\t<input type=\"hidden\" name=\"TL";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" id=\"TL";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"  id=\"TL";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" value=\"\"/>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' ><input type=\'checkbox\' name=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' id=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' value=\'Y\'><input type=\'hidden\' name=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar temp_text=document.getElementById(\"CL";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\").innerText;\n\t\t\t\t\t\t\tif(temp_text.length>25){\n\t\t\t\t\t\t\ttemp_text= temp_text.substring(0, 24);\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tdocument.getElementById(\"TL";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\").value=temp_text;\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t<!--[IN033786]<td width=\'60%\' class=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'><a href=\"javascript:showLongDesc(\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\')\" id=\"Temp";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"></a>-->\n\t\t\t\t\t\t<td width=\'60%\' class=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'><a href=\"javascript:showLongDesc_new(\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\',\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"></a>\n\t\t\t\t\t\t<div id= \'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' style=\'display:none\'><pre>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</pre></div></td>\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tdocument.getElementById(\"Temp";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\").innerHTML=document.getElementById(\"TL";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\").value;\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t<!--[IN033786]<td width=\'60%\' class=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\')\">";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</a> -->\n\t\t\t\t\t\t<td width=\'60%\' class=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</a>\n\t\t\t\t\t\t<div id= \'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</pre></div></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\t\t\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\n\t\t\t\t</tr>\n\t\t\t\t\n\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t</table>\n\t\t<input type=\'hidden\' name=\'totalBlocks\' id=\'totalBlocks\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n\t\t<input type=\'hidden\' name=\'text_type_TE\' id=\'text_type_TE\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'><!--IN063814-->\n\t\t<input type=\'hidden\' name=\'calledFrom\' id=\'calledFrom\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n\t</form>\n\t</center>\n\t<!--  //[IN033180] Start.-->\n\t<script>\n\t\tfunction refPage(){\n\t\t\tparent.RecClinicalNotesCTFrame.location.href=\'../../eCA/jsp/RecClinicalNotesCannedText.jsp?service_code=";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="&note_type=";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="&sec_hdg_code=";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="&text_type=\'+getRadioCheckedValue(\'r1\');\n\t\t}\n\t\t<!--IN063814 start-->\n\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\tcheckFirstRec();\n\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t<!--IN063814 end-->\n\t</script>\n\t<!--  //[IN033180] End.-->\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

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
--------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
19/08/2014	  IN050582 		Nijitha S											MO-GN-5452
05/10/2017	  IN063814		Krishna Gowtham	05/10/2017		Ramesh G			ML-MMOH-CRF-0810
-------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	
	String calledFrom	=	(request.getParameter("calledFrom")==null) ?	""	:	request.getParameter("calledFrom");
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;

	String	service_code		=	"",		login_user_id	=	"";
	String	text_blk_id			=	"",		text_blk		=	"";
	String	query_canned_text	=	"",		selectBlockId	=	"";
	String	text_blk_id_name	=	"",		text_blk_name	=	"";
	String	classValue			=	"",		note_type		=	"";
	String	sec_hdg_code		=	"";
	 //[IN033180] Start.
	String textType				=	(request.getParameter("text_type")==null) ?	"T"	:	request.getParameter("text_type");
	String  textContent			=	"";
	String  EditorContent		=	"";
	if("T".equals(textType))
		textContent="checked";
	else if("E".equals(textType))
		EditorContent="checked";
	//String queryString			= request.getQueryString(); //Commented for checkstyle
	 //[IN033180] End.
	int selectIndex = 0;
	//IN063814 start
	String canned_text_count	= "";
	String canned_text			= "";
	String text_type_TE			= "";
	String more_record_YN 		= "";
	PreparedStatement	pstmt_cnt		=	null;
	ResultSet			rs_cnt			=	null;
	int 				no_of_record	= 	0;
	//IN063814 ends

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(textContent ));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(EditorContent ));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(textContent ));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(EditorContent ));
            _bw.write(_wl_block14Bytes, _wl_block14);
if("TEMPLATES".equals(calledFrom)){
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block16Bytes, _wl_block16);
if(!"TEMPLATES".equals(calledFrom)){

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
}
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

		try
		{
			con				=	ConnectionManager.getConnection(request);
			login_user_id	=	(String) session.getValue("login_user");
			String practitioner_id =(String)session.getValue("ca_practitioner_id"); //[IN038542] 

			service_code	=	(request.getParameter("service_code")==null) ?	""	:	request.getParameter("service_code");
			note_type		=	(request.getParameter("note_type")==null)	 ?	""	:	request.getParameter("note_type");
			sec_hdg_code	=	(request.getParameter("sec_hdg_code")==null) ?	""	:	request.getParameter("sec_hdg_code");

			//out.println("Query String : "+request.getQueryString());

			if(service_code==null)		service_code	= "";
			//IN063814 start
			Boolean canned_text_auto_fill_site_YN = CommonBean.isSiteSpecific(con, "CA", "CANNED_TXT_AUTO_FILL");
			if(canned_text_auto_fill_site_YN)
			{
				canned_text_count = "Select count(TEXT_TYPE), TEXT_TYPE from ca_text_blk_by_serv_pract where nvl( service_code, ? ) = ? and nvl( practitioner_id, ? ) = ? and nvl(note_type, ?) = ? and nvl(sec_hdg_code, nvl(?,'***')) = nvl(?,'***') and APPLICABLE_CATEGORY='N' AND CA_GET_DESC.CA_TEXT_BLK_BY_SERV_PRACT(text_blk_id,?,'1') IS NOT NULL AND EFF_STATUS='E'  GROUP BY TEXT_TYPE";
				
				pstmt_cnt		=	con.prepareStatement(canned_text_count);
				
				pstmt_cnt.setString(1,service_code);
				pstmt_cnt.setString(2,service_code);
				pstmt_cnt.setString(3,practitioner_id);
				pstmt_cnt.setString(4,practitioner_id);
				pstmt_cnt.setString(5,note_type);
				pstmt_cnt.setString(6,note_type);
				pstmt_cnt.setString(7,sec_hdg_code);
				pstmt_cnt.setString(8,sec_hdg_code);
				pstmt_cnt.setString(9,locale);

				rs_cnt = pstmt_cnt.executeQuery();
				if(rs_cnt!=null)
				{
					while(rs_cnt.next())
					{
						if(no_of_record == 1)
						{
							no_of_record++;
						}
						else if(no_of_record == 0)
						{
							no_of_record 	= rs_cnt.getInt(1);
							text_type_TE	= rs_cnt.getString("TEXT_TYPE");
						}
					}
				}
				if(no_of_record == 1)
				{
					if("T".equals(text_type_TE))
					{	
						canned_text = "SELECT   text_blk_id, CA_GET_DESC.CA_TEXT_BLK_BY_SERV_PRACT(text_blk_id,?,'1') text_blk FROM ca_text_blk_by_serv_pract WHERE NVL (service_code, ?) = ? AND NVL (practitioner_id, ?) = ? AND NVL (note_type, ?) = ? AND NVL (sec_hdg_code, NVL (?, '***')) = NVL (?, '***') AND applicable_category = 'N' AND ca_get_desc.ca_text_blk_by_serv_pract (text_blk_id, ?, '1') IS NOT NULL AND eff_status = 'E' ORDER BY text_blk_id";
					}
					else
					{
						canned_text = "SELECT   text_blk_id, ca_get_desc.ca_text_clob_blk_by_serv_pract(text_blk_id,?,'1') text_blk FROM ca_text_blk_by_serv_pract WHERE NVL (service_code, ?) = ? AND NVL (practitioner_id, ?) = ? AND NVL (note_type, ?) = ? AND NVL (sec_hdg_code, NVL (?, '***')) = NVL (?, '***') AND applicable_category = 'N' AND ca_get_desc.ca_text_blk_by_serv_pract (text_blk_id, ?, '1') IS NOT NULL AND eff_status = 'E' ORDER BY text_blk_id";
					}
					pstmt		=	con.prepareStatement(canned_text);
					
					pstmt.setString(1,locale);
					pstmt.setString(2,service_code);
					pstmt.setString(3,service_code);
					pstmt.setString(4,practitioner_id);
					pstmt.setString(5,practitioner_id);
					pstmt.setString(6,note_type);
					pstmt.setString(7,note_type);
					pstmt.setString(8,sec_hdg_code);
					pstmt.setString(9,sec_hdg_code);
					pstmt.setString(10,locale);

					rs = pstmt.executeQuery();
				}
				else
				{
					more_record_YN = "Y";
				}	
			}
			if(!canned_text_auto_fill_site_YN || "Y".equals(more_record_YN))
			{
			//IN063814 ends
				 //[IN033180] Start.
				if("T".equals(textType)){  
					//query_canned_text = "Select text_blk_id, text_blk from ca_text_blk_by_serv_pract where nvl( service_code, ? ) = ? and nvl( practitioner_id, ? ) = ? and nvl(note_type, ?) = ? and nvl(sec_hdg_code, nvl(?,'***')) = nvl(?,'***') and APPLICABLE_CATEGORY='N' ";
					 //[IN033180]query_canned_text = "Select text_blk_id, CA_GET_DESC.CA_TEXT_BLK_BY_SERV_PRACT(text_blk_id,?,'1') text_blk 	from ca_text_blk_by_serv_pract where nvl( service_code, ? ) = ? and nvl( practitioner_id, ? ) = ? and nvl(note_type, ?) = ? and nvl(sec_hdg_code, nvl(?,'***')) = nvl(?,'***') and APPLICABLE_CATEGORY='N'";
					//query_canned_text = "Select text_blk_id, CA_GET_DESC.CA_TEXT_BLK_BY_SERV_PRACT(text_blk_id,?,'1') text_blk 	from ca_text_blk_by_serv_pract where nvl( service_code, ? ) = ? and nvl( practitioner_id, ? ) = ? and nvl(note_type, ?) = ? and nvl(sec_hdg_code, nvl(?,'***')) = nvl(?,'***') and APPLICABLE_CATEGORY='N' AND TEXT_TYPE='T' AND CA_GET_DESC.CA_TEXT_BLK_BY_SERV_PRACT(text_blk_id,?,'1') IS NOT NULL ORDER BY text_blk_id";//IN050582
					query_canned_text = "Select text_blk_id, CA_GET_DESC.CA_TEXT_BLK_BY_SERV_PRACT(text_blk_id,?,'1') text_blk 	from ca_text_blk_by_serv_pract where nvl( service_code, ? ) = ? and nvl( practitioner_id, ? ) = ? and nvl(note_type, ?) = ? and nvl(sec_hdg_code, nvl(?,'***')) = nvl(?,'***') and APPLICABLE_CATEGORY='N' AND TEXT_TYPE='T' AND CA_GET_DESC.CA_TEXT_BLK_BY_SERV_PRACT(text_blk_id,?,'1') IS NOT NULL AND EFF_STATUS='E'  ORDER BY text_blk_id";//IN050582
				}else{ 
					//query_canned_text = "Select text_blk_id, CA_GET_DESC.CA_TEXT_CLOB_BLK_BY_SERV_PRACT(text_blk_id,?,'1') text_blk 	from ca_text_blk_by_serv_pract where nvl( service_code, ? ) = ? and nvl( practitioner_id, ? ) = ? and nvl(note_type, ?) = ? and nvl(sec_hdg_code, nvl(?,'***')) = nvl(?,'***') and APPLICABLE_CATEGORY='N' AND TEXT_TYPE='E' AND CA_GET_DESC.CA_TEXT_CLOB_BLK_BY_SERV_PRACT(text_blk_id,?,'1') IS NOT NULL ORDER BY text_blk_id";//IN050582
					query_canned_text = "Select text_blk_id, CA_GET_DESC.CA_TEXT_CLOB_BLK_BY_SERV_PRACT(text_blk_id,?,'1') text_blk 	from ca_text_blk_by_serv_pract where nvl( service_code, ? ) = ? and nvl( practitioner_id, ? ) = ? and nvl(note_type, ?) = ? and nvl(sec_hdg_code, nvl(?,'***')) = nvl(?,'***') and APPLICABLE_CATEGORY='N' AND TEXT_TYPE='E' AND CA_GET_DESC.CA_TEXT_CLOB_BLK_BY_SERV_PRACT(text_blk_id,?,'1') IS NOT NULL AND EFF_STATUS='E' ORDER BY text_blk_id";//IN050582
				}
				 //[IN033180] End.
				pstmt		=	con.prepareStatement(query_canned_text);

				pstmt.setString(1,locale);
				pstmt.setString(2,service_code);
				pstmt.setString(3,service_code);
				//[IN038542] start.
				//pstmt.setString(4,login_user_id);
				//pstmt.setString(5,login_user_id);
				pstmt.setString(4,practitioner_id);
				pstmt.setString(5,practitioner_id);
				//[IN038542]  End.
				pstmt.setString(6,note_type);
				pstmt.setString(7,note_type);
				pstmt.setString(8,sec_hdg_code);
				pstmt.setString(9,sec_hdg_code);
				pstmt.setString(10,locale);

				rs			=	pstmt.executeQuery();
			}//IN063814
			classValue = "gridData";
			int i=0;
			while(rs.next())
			{
				text_blk_id		=	rs.getString("text_blk_id");
				text_blk		=	rs.getString("text_blk");
				text_blk_name		=	"text_blk"	  + selectIndex ;
				text_blk_id_name	=	"text_blk_id" + selectIndex ;
				selectBlockId		=	"block_id"	  + selectIndex ;

				/*if( (selectIndex%2)==0 )
					classValue = "QRYEVEN";
				else
					classValue = "QRYODD";*/

				selectIndex ++ ;
	
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(text_blk));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(selectBlockId));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(selectBlockId));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(text_blk_id_name));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(text_blk_id_name));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(text_blk_id));
            _bw.write(_wl_block30Bytes, _wl_block30);

						StringBuffer concatRmks = new StringBuffer();
						text_blk=text_blk.replace('"','`');
						
						if(!text_blk.equals(""))
						{
							if(text_blk.length() > 100)
							{
								concatRmks.append(text_blk.substring(0,99));
								concatRmks.append("..."+"<br>");
					
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(text_blk_name));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(textType));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(text_blk_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(login_user_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(text_blk_name));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(text_blk));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
}
							else
							{
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(text_blk_name));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(text_blk));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(textType));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(text_blk_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(login_user_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(text_blk));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(text_blk_name));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(text_blk));
            _bw.write(_wl_block48Bytes, _wl_block48);
}
						}
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(text_blk_id));
            _bw.write(_wl_block51Bytes, _wl_block51);

			i++;
			} // end of while(rs.next())

		
		
			if(rs!=null) rs.close();
			if(rs_cnt!=null) rs.close(); //IN063814
			if(pstmt!=null) pstmt.close();
			if(pstmt_cnt!=null) pstmt_cnt.close(); //IN063814
		}
		catch(Exception e)
		{
			//out.println("Exception@1: "+e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			
			if(con!=null)	ConnectionManager.returnConnection(con,request);
		}
	
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(selectIndex));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(text_type_TE));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(calledFrom));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(note_type ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(sec_hdg_code ));
            _bw.write(_wl_block58Bytes, _wl_block58);

		if(no_of_record == 1)
		{
		
            _bw.write(_wl_block59Bytes, _wl_block59);

		}
		
            _bw.write(_wl_block60Bytes, _wl_block60);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.CannedText.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Text.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.EditorText.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Text.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.EditorText.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.BlockID.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
