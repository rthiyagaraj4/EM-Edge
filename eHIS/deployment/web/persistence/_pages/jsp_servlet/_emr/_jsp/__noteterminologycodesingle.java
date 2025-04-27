package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;

public final class __noteterminologycodesingle extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/NoteTerminologyCodeSingle.jsp", 1741752553677L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Modified 9/21/2005 -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../js/NoteTerminologyCode.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body  onload=\'\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<form name=\'term_code_associated\' id=\'term_code_associated\' method=\'post\' target=\'messageFrame\' action=\'../../servlet/eMR.NoteTerminologyCode\'>\n<input type=\"hidden\" name=\"term_code_0\" id=\"term_code_0\" value=\"\">\t\n<input type=\"hidden\" name=\"lvl_code_0\" id=\"lvl_code_0\" value=\"\">\n<input type=\"hidden\" name=\"term_desc_0\" id=\"term_desc_0\" value=\"\">\n<input type=\"hidden\" name=\"bLvl_1_InDB\" id=\"bLvl_1_InDB\" value=\"false\">\n\n<table cellpadding=0 cellspacing=0 border=1 width=\"100%\" align=center id=\'term_associated\'>\n\t<tr>\n\t\t<td colspan=\"4\" class=\"COLUMNHEADER\" style=\"color: white;\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t</tr>\n\t<tr>\n\t\t<td width=\'20%\' class=\"COLUMNHEADER\" style=\" color: white;\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t<td width=\'20%\' class=\"COLUMNHEADER\" style=\"color: white;\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t<td width=\'50%\' class=\"COLUMNHEADER\" style=\"color: white;\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t<td width=\'10%\' class=\'COLUMNHEADERCENTER\' style=\"color: white;\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\n\t\t\t<tr id=\'term_set_tr";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t\t\t\t<td   id=\'Level";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'  class=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">Level ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t<!--<td id=\'tbl_term_code";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' class=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="*ALL";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t\t<td id=\'term_code_desc";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="ALL";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>-->\n\t\t\t\t<!--Modified on 16 june 2008 for SPR-4435 -->\n\t\t\t\t<td   id=\'tbl_term_code";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">*ALL</td>\n\t\t\t\t<td  id=\'term_code_desc";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">ALL</td>\n\t\t\t\t<td align=\'center\' class=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t\t\t<input type=\"checkbox\" name=\"term_chk";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" id=\"term_chk";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" value=\"Y\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="<img src=\"../../eCommon/images/mandatory.gif\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t<tr ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="id=\'term_set_tr";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t\t<td  id=\'Level";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t\t<td   id=\'tbl_term_code";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t\t<td   id=\'term_code_desc";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" >";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t<td  align=\'center\'  class=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\t\t<input type=\"checkbox\" name=\"term_chk";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" value=\"Y\" ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="></td>\n\t\t</tr>\n\t\t\t<input type=\"hidden\" name=\"term_code";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" id=\"term_code";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t\t\t<input type=\"hidden\" name=\"code_level";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" id=\"code_level";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" \n\t\t\t\t<script>\n\t\t\t\tif(document.getElementById(\'term_associated\').rows[2].cells[1].innerText==\' \' )\n\t\t\t\t\t//if(document.forms[0].all.term_associated.all.tbl_term_code0.innerText==\' \' )\n\t\t\t\t\t{   \n\t\t\t\t\t\tdocument.forms[0].bLvl_1_InDB.value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\';\n\t\t\t\t\t\t/* Storing the values in hidden Variables*/\n\t\t\t\t\t\tdocument.forms[0].term_code_0.value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\';\n\t\t\t\t\t\tdocument.forms[0].lvl_code_0.value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\';\n\t\t\t\t\t\tdocument.forms[0].term_desc_0.value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\';\t\n\t\t\t\t\t\tif(document.forms[0].bLvl_1_InDB.value==\'Y\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t/* Populating the values in the first row in BOLD */\n\t\t\t\t\t\t\tdocument.forms[0].all.term_associated.all.tbl_term_code0.innerHTML=\"<b>\"+document.forms[0].term_code_0.value+\"</b>\";\n\t\t\t\t\t\t\tdocument.forms[0].all.term_associated.all.Level0.innerHTML=\"<b>\"+document.forms[0].lvl_code_0.value+\"</b>\";\n\t\t\t\t\t\t\tdocument.forms[0].all.term_associated.all.term_code_desc0.innerHTML=\"<b>\"+document.forms[0].term_desc_0.value+\"</b>\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t\t/* If the Level 1 record is not in DB it should not be bold */\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.forms[0].all.term_associated.all.tbl_term_code0.innerHTML=document.forms[0].term_code_0.value;\n\t\t\t\t\t\t\tdocument.forms[0].all.term_associated.all.Level0.innerHTML=document.forms[0].lvl_code_0.value;\n\t\t\t\t\t\t\tdocument.forms[0].all.term_associated.all.term_code_desc0.innerHTML=document.forms[0].term_desc_0.value;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tdocument.forms[0].all.term_code0.value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\';\n\t\t\t\t\t\tdocument.forms[0].all.code_level0.value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\';\n\t\t\t\t\t\tdocument.forms[0].all.term_chk0.value=\'Y\';\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" id=\'term_set_tr";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\"><input type=\"checkbox\" name=\"term_chk";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t</table>\n\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"\">\n\t\t<input type=\"hidden\" name=\"totalRecords\" id=\"totalRecords\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t\t<input type=\"hidden\" name=\"service_code\" id=\"service_code\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t<input type=\"hidden\" name=\"term_set_id\" id=\"term_set_id\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t\t<input type=\"hidden\" name=\"proc_code\" id=\"proc_code\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t\t<input type=\"hidden\" name=\"temp_term_code\" id=\"temp_term_code\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t\t<input type=\"hidden\" name=\"term_code_associated\" id=\"term_code_associated\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t\t<input type=\"hidden\" name=\"DB_term_code_associated\" id=\"DB_term_code_associated\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t\t<input type=\"hidden\" name=\"bLvl_In_DB\" id=\"bLvl_In_DB\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t</form>\n\t  \n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n</body>\n</html>\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String bLvl_In_DB =( (request.getParameter("bLvl_In_DB")== null )|| (request.getParameter("bLvl_In_DB").equals("null")) || (request.getParameter("bLvl_In_DB").equals(""))) ? "N" : request.getParameter("bLvl_In_DB") ;
	String DB_term_code_associated_str = request.getParameter("DB_term_code")==null?"":request.getParameter("DB_term_code");
	String DB_Term_code_Exisits = request.getParameter("DB_term_code")==null? "N" :"Y";
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	int ilevels=0,j=0;
	String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String service_code = request.getParameter("service_code")==null?"":request.getParameter("service_code") ;
	String proc_code = request.getParameter("note_type")==null?"":request.getParameter("note_type") ;
	String term_set = request.getParameter("term_set")==null?"":request.getParameter("term_set") ;
	String term_code_associated_str = request.getParameter("term_code_associated")==null?"":request.getParameter("term_code_associated") ;
	String level1 = request.getParameter("level")==null?"":request.getParameter("level") ;
	//out.println("level1 is :"+level1);
	String note_type		= checkForNull( request.getParameter( "note_type" ) ) ;
	String classvalue="";String checked = "";int db_count=0;
	StringBuffer temp_term_code = new StringBuffer();
	StringBuffer DB_term_code_associated = new StringBuffer(DB_term_code_associated_str);
	StringBuffer term_code_associated = new StringBuffer(term_code_associated_str);
	
	String tag = "",tag1="";
	StringBuffer temp_db_chk = new StringBuffer("");
	
	temp_term_code.append("");
	if ( mode.equals("2") )
	{
		tag = "<B>";tag1="</B>";
		String sql_code = "select a.SERVICE_CODE,b.SHORT_DESC service_description, a.NOTE_TYPE,note_type_desc , a.TERM_SET_ID,term_set_desc, a.TERM_CODE term_code,e.SHORT_DESC term_code_desc, a.CODE_LEVEL code_level,Decode(a.CODE_LEVEL,'1',LEVEL_1_DESC,'2',LEVEL_2_DESC,'3',LEVEL_3_DESC, '4',LEVEL_4_DESC ,'5',LEVEL_5_DESC ,'6',LEVEL_6_DESC ,'7',LEVEL_7_DESC ,'8',LEVEL_8_DESC ,'9',LEVEL_9_DESC ,'10',LEVEL_10_DESC )  code_level_desc from MR_TERM_FOR_NOTE_TYPE_dtl a,am_service b,ca_note_type c,mr_term_set d,mr_term_code e where b.SERVICE_CODE = a.service_code and c.NOTE_TYPE = a.NOTE_TYPE and d.term_set_id = a.term_set_id and d.term_set_id = e.term_set_id and e.term_code = a.term_code and upper(a.service_code) like upper(?) and upper(a.note_type) like upper(?)  and a.TERM_SET_ID like upper(?) union select a.SERVICE_CODE,b.SHORT_DESC service_description, a.NOTE_TYPE,note_type_desc , a.TERM_SET_ID,term_set_desc, '*ALL' term_code,'ALL' term_code_desc, a.CODE_LEVEL code_level,Decode(a.CODE_LEVEL,'1',LEVEL_1_DESC,'2',LEVEL_2_DESC,'3',LEVEL_3_DESC, '4',LEVEL_4_DESC ,'5',LEVEL_5_DESC ,'6',LEVEL_6_DESC ,'7',LEVEL_7_DESC ,'8',LEVEL_8_DESC ,'9',LEVEL_9_DESC ,'10',LEVEL_10_DESC )  code_level_desc from MR_TERM_FOR_NOTE_TYPE_dtl a,am_service b,ca_note_type c,mr_term_set d where b.SERVICE_CODE = a.service_code and c.NOTE_TYPE = a.NOTE_TYPE and d.term_set_id = a.term_set_id and a.term_code = '*ALL' and upper(a.service_code) like upper(?) and upper(a.note_type) like upper(?)  and a.TERM_SET_ID like upper(?) order by code_level, term_code";
		Connection con = null;
		PreparedStatement pstmt_code = null;
		ResultSet rs_code = null;
		String temp="";
		boolean mode_flag = false;

		
		con = ConnectionManager.getConnection(request);
		pstmt_code = con.prepareStatement(sql_code);
		pstmt_code.setString(1,service_code);
		pstmt_code.setString(2,note_type);
		pstmt_code.setString(3,term_set);
		pstmt_code.setString(4,service_code);
		pstmt_code.setString(5,note_type);
		pstmt_code.setString(6,term_set);
		rs_code = pstmt_code.executeQuery();
	
//out.println("=service_code=="+service_code+"==note_type=="+note_type+"==term_set="+term_set+"===");	//out.println("<script>alert('=service_code=="+service_code+"==note_type=="+note_type+"==term_set="+term_set+"===')</script>");

	while (rs_code.next() )
	{
		temp = rs_code.getString("term_code")+"~"+rs_code.getString("code_level")+"~"+rs_code.getString("code_level_desc")+"~"+rs_code.getString("term_code_desc")+"`";
///	temp_db_chk +=  rs_code.getString("term_code")+"~";
		temp_db_chk.append(rs_code.getString("term_code")+"~");
		if(term_code_associated.indexOf(temp) == -1 )
		{
//			DB_term_code_associated += temp ;
			DB_term_code_associated.append(temp);
			db_count++;
			/* If the Level 1 code is in DB i it should be bold */
			if(rs_code.getString("code_level").equals("1") )
			{
				bLvl_In_DB = "Y";
			}
			
		}
		mode_flag =true;
	}
	if (rs_code != null) rs_code.close();
	if (pstmt_code != null) pstmt_code.close();

	if(!mode_flag)
		mode = "1";

	if (DB_Term_code_Exisits == "N")
		{
			term_code_associated.append(DB_term_code_associated);
		}
	try
	{
		ConnectionManager.returnConnection(con,request);
	}
	catch(Exception e)
		{
			e.printStackTrace();
		}
 }

StringTokenizer stoken=new StringTokenizer(term_code_associated.toString(),"`");
int cnt=stoken.countTokens();
try
{

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
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

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

	//out.println("cnt is:"+cnt);
//out.println("Mode "+mode);
	if(cnt == 0)
	{
		for(int i=0;i<(Integer.parseInt(level1));i++)
			{  
			
				if ( i % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;

				if(i!=0)
					checked="checked";
				else
					checked="";
				
		
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((i+1)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block21Bytes, _wl_block21);
if(i != 0){
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block21Bytes, _wl_block21);
if(i != 0){
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block31Bytes, _wl_block31);
if(i == 0){
            _bw.write(_wl_block32Bytes, _wl_block32);
}
            _bw.write(_wl_block33Bytes, _wl_block33);
	
			}
				
	} 
	else 
	{	String display="display:none";
		String term_assc_temp="";
		String term_code="",level="",term_code_desc="",level_code_desc="";
		String slevel="",slvl_in_trm="";
		/*	 To enable the check box in detail frame after selecting record in modal window during insertion mode  */
		checked="checked";
		ilevels = Integer.parseInt(level1);

		/* If the database has already *ALL values cnt should be the same  for all those '*ALL~<level>~' */
		for (j=0; j<ilevels;++j) 
		{
			//display ="display:inline";
			if (j==0)
			{	//term_code=" ";
				//<!--Modified on 16 june 2008 for SPR-4435 -->
				term_code = "*ALL";
				level="1";
				level_code_desc="Level 1";
				//term_code_desc = " ";
				//<!--Modified on 16 june 2008 for SPR-4435 -->
				term_code_desc="ALL ";
//				temp_term_code +=term_code+"~";
				temp_term_code.append(term_code);
				temp_term_code.append("~");
				tag ="<b>";
				tag1="</b>";
			} 
			else 
			{	slevel="*ALL~"+(j+1)+"~" ;
				if (term_code_associated.indexOf(slevel)!=-1) 
				{	
					/* To resord the *ALL records already existing in the DB. j+1 gives level no. */
					slvl_in_trm = slvl_in_trm + (j+1) + "~" ; 
					/* The entries in DB should be bold */
					if (DB_term_code_associated.indexOf(slevel)!=-1) 
					{
						tag = "<B>";
						tag1="</B>";
						checked="checked";
					}
					else
					{
						tag = "";
						tag1="";
					}
				} 
				else
				{
					//term_code_associated = term_code_associated + "*ALL~"+(j+1)+"~Level"+(j+1)+"~ALL`";
					term_code_associated.append("*ALL~"+(j+1)+"~Level"+(j+1)+"~ALL`");
					cnt++;
					tag = "";
					tag1="";
				}
				term_code="*ALL";
				level=(j+1)+"";
				level_code_desc="Level " +( j+1);
				term_code_desc="ALL";
				//temp_term_code +=term_code+"~";
				temp_term_code.append(term_code);
				temp_term_code.append("~");
				}
			if ( j % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
		
            _bw.write(_wl_block34Bytes, _wl_block34);
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(j));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(j));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(tag));
            out.print( String.valueOf(level_code_desc));
            out.print( String.valueOf(tag1));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(j));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(tag));
            out.print( String.valueOf(term_code));
            out.print( String.valueOf(tag1));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(j));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(tag));
            out.print( String.valueOf(term_code_desc));
            out.print( String.valueOf(tag1));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(j));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(j));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(j));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(j));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(j));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(j));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(level));
            _bw.write(_wl_block48Bytes, _wl_block48);

		} 

/* From  0 to j the rows are filled(The default levels).  The rest of the rows should be painted now. 
	so from j to (cnt + j) rows are painted below. ir is the row number */
	int ir=0, i=0, iflag_cnt=0;
	boolean flag = false;
	for(i=j,ir=j; i<cnt+j; i++,ir++)
	{
		display ="";
		if(stoken.hasMoreTokens())
		{
			term_assc_temp=stoken.nextToken();
			StringTokenizer token= new StringTokenizer(term_assc_temp,"~");
			term_code=token.nextToken();
			level=token.nextToken();
			level_code_desc=token.nextToken();
			term_code_desc=token.nextToken();
//			temp_term_code +=term_code+"~";
			temp_term_code.append(term_code);
			temp_term_code.append("~");

			if ( (slvl_in_trm.indexOf( level+"~" ) !=-1) && (term_code.equals("*ALL") ))
			{
				/* The next row should be painted in the current row as the operation is aborted for this row since it is already painted */
				--ir; 
				continue;
			} 
			else  
			{
				if  ( level.equals("1") ) 
				{  
					if(iflag_cnt==0)
					{
						flag = true;
						ir--;
					}
				iflag_cnt++;
			
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(bLvl_In_DB));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(level_code_desc));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(level));
            _bw.write(_wl_block55Bytes, _wl_block55);

				}
				if(level.equals(""))
				level = "0";
			} 			
			if(temp_db_chk.indexOf(term_code+"~") != -1 )
				{
					tag = "<B>";
					tag1="</B>";
					checked="checked";
				}
			else
				{
					tag = "";
					tag1="";
				}

			if ( ir % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;

			if (flag) 
				{
					flag = false;
					continue;
				}    
		
            _bw.write(_wl_block34Bytes, _wl_block34);
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(ir));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(ir));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(tag));
            out.print( String.valueOf(level_code_desc));
            out.print( String.valueOf(tag1));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(ir));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(tag));
            out.print( String.valueOf(term_code));
            out.print( String.valueOf(tag1));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(ir));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(tag));
            out.print( String.valueOf(term_code_desc));
            out.print( String.valueOf(tag1));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(ir));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ir));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(ir));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(ir));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(ir));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(ir));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(level));
            _bw.write(_wl_block48Bytes, _wl_block48);
 
		}
	}
	}
	//out.println("cnt:"+cnt);
  
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(proc_code));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(temp_term_code.toString()));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(term_code_associated.toString()));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(DB_term_code_associated.toString()));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(bLvl_In_DB));
            _bw.write(_wl_block67Bytes, _wl_block67);

}
  catch(Exception Ex)
  {
		Ex.printStackTrace();
  }
  finally
  {
	
  }

            _bw.write(_wl_block68Bytes, _wl_block68);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.TerminologyCodeAssociated.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Level.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TermCode.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TermCodeDescription.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
