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
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __equivalenttermcode2 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/EquivalentTermCode2.jsp", 1722863656674L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"></link>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script language=\"JavaScript\" src=\"../js/EquivalentTermCode.js\"></script>\n<SCRIPT LANGUAGE=\"JavaScript\">\n\nfunction callres()\n{  \n\n\tif(document.frm_terminology_code.terminology_set1.value==\"\")\n\t{\n\t  //var msg=\"APP-000001 Equivalent Term Set  Cannot be blank...\";\n\t  var msg\t=\tgetMessage(\"CAN_NOT_BE_BLANK\",\"Common\");\n\t  msg\t=\tmsg.replace(\"$\",getLabel(\"eMR.EquivalentTermSet.label\",\"MR\"));\n\t  parent.parent.messageFrame.location.href = \"../../eCommon/jsp/MstCodeError.jsp?err_num=\"+ msg;\n\t  return false ;\n\t}\n\tvar termsetid = document.frm_terminology_code.termsetid.value;\n\tvar search_criteria = document.frm_terminology_code.search_criteria.value;\n\tvar search_text = document.frm_terminology_code.search_text.value;\n\tvar termcode = document.frm_terminology_code.termcode.value;\n\tvar codelevel = document.frm_terminology_code.codelevel.value;\n    var ThirdConbox = document.frm_terminology_code.terminology_set1.value;\n\tvar FirstConbox = document.frm_terminology_code.Terminology.value;\n\tvar SecondValue = document.frm_terminology_code.termset_id.value;\n\tvar searchcode = document.frm_terminology_code.searchName.name;\n\tvar type_set = document.frm_terminology_code.type_set.value;\n\t\t\n\nif(type_set == \'EQ\')\n\t type_set=\'EQ\';\nelse if(type_set == \'DA\')\n\ttype_set = \'AS\'\n/*else if(type_set == \'EC\')\n\ttype_set=\'CO\';*/\n/*\n\tThe Above code was commented On 2/1/2010 that code was modified as below \n*/\nelse if(type_set == \'CO\')\n\ttype_set=\'EC\';\n\n\n\n\tif(codelevel==\"\") codelevel = \"1\";\n\t\n\tif(search_text.indexOf(\"\'\")!=-1)\n\t\t\t{\n\t\t\t\t\n\t\t\tsearch_text = search_text.replace(\"\'\",\"\'\'\");\n\t\t}\n\tif(document.frm_terminology_code.class_lvl.value==document.frm_terminology_code.codelevel.value)\n\t\tclassName = \"className\";\n\telse\n\t\tclassName = \"\";\n\tif(termsetid!=null)\n\t{\n\t\tparent.f_batch_result.location.href=\"../../eMR/jsp/EquivalentTermCodeResult.jsp?codeResult=result&termsetid=\"+termsetid+\"&search_criteria=\"+search_criteria+\"&search_text=\"+search_text+\"&termcode=\"+termcode+\"&codelevel=\"+codelevel+\"&className=\"+className+\"&Terminology=\"+FirstConbox+\"&termset_id=\"+SecondValue+\"&termsetid=\"+ThirdConbox+\"&searchcode=\"+searchcode+\"&mr_term_set=N&status=Y\"+\"&type_set=\"+type_set+\" \";\n\t\t\n\t}\n\t\tparent.parent.messageFrame.document.location.href = \"../../eCommon/jsp/MstCodeError.jsp\";\n\n\n}\n\nfunction callresult(values)\n{\n\tif(document.frm_terminology_code.terminology_set1.value==\"\")\n\t{\n\t  //var msg=\"APP-000001 Equivalent Term Set  Cannot be blank...\";\n\t  var msg\t=\tgetMessage(\"CAN_NOT_BE_BLANK\",\"Common\");\n\t  msg\t=\tmsg.replace(\"$\",getLabel(\"eMR.EquivalentTermSet.label\",\"MR\"));\n\t  parent.parent.messageFrame.location.href = \"../../eCommon/jsp/MstCodeError.jsp?err_num=\"+ msg;\n\t}\n  else\n\t{\n\t\n\t\tvar termsetid = document.frm_terminology_code.termsetid.value;\n\t\tvar search_criteria = document.frm_terminology_code.search_criteria.value;\n\t\tvar search_text = document.frm_terminology_code.search_text.value;\n\t\tvar termcode = document.frm_terminology_code.termcode.value;\n\t\tvar codelevel = document.frm_terminology_code.codelevel.value;\n\t\tif(codelevel==\"\") codelevel = \"1\";\n\t\tvar srch_text = search_text.toUpperCase();\n\t\tvar hypval = values;\n\t\tvar ThirdConbox = document.frm_terminology_code.terminology_set1.value;\n\t\tvar FirstConbox = document.frm_terminology_code.Terminology.value;\n\t\tvar SecondValue = document.frm_terminology_code.termset_id.value;\n\t\tvar type_set = document.frm_terminology_code.type_set.value;\n\nif(type_set == \'EQ\')\n\t type_set=\'EQ\';\nelse if(type_set == \'DA\')\n\ttype_set = \'AS\'\n/*else if(type_set == \'EC\')\n\ttype_set=\'CO\';*/\n/*\n\tThe Above code was commented On 2/1/2010 that code was modified as below \n*/\n\nelse if(type_set == \'CO\')\n\ttype_set=\'EC\';\n\n\n\t\tif(search_text.indexOf(\"\'\")!=-1)\n\t\t\t{\n\t\t\t\t\n\t\t\tsearch_text = search_text.replace(\"\'\",\"\'\'\");\n\t\t}\n\t\t\n\tif(termsetid!=null)\n\t{\n\t\t\n\t\tif(search_criteria==\"S\")\n\t\t{\n\t\t\t \n\t\t\tif(search_text!=\"\")\n\t\t\t{ \n\t\t\t\tif((search_text==hypval) || (srch_text==hypval))\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\tparent.f_batch_result.location.href=\"../../eMR/jsp/EquivalentTermCodeResult.jsp?status=Y&code=\'Y\'&termdesc=\"+values+\"&termsetid=\"+termsetid+\"&search_criteria=\"+search_criteria+\"&search_text=\"+search_text+\"&termcode=\"+termcode+\"&alphalink=\"+values+\"&codelevel=\"+codelevel+\"&Terminology=\"+FirstConbox+\"&termset_id=\"+SecondValue+\"&termsetid=\"+ThirdConbox+\"&mr_term_set=N&type_set=\"+type_set+\" \";\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse{\n\n\t\t\t\t\tparent.f_batch_result.location.href=\"../../eMR/jsp/EquivalentTermCodeResult.jsp?status=Y&code=\'Y\'&termdesc=\"+values+\"&termsetid=\"+termsetid+\"&search_criteria=\"+search_criteria+\"&search_text=\"+search_text+\"&termcode=\"+termcode+\"&alphalink=\"+values+\"&codelevel=\"+codelevel+\"&Terminology=\"+FirstConbox+\"&termset_id=\"+SecondValue+\"&termsetid=\"+ThirdConbox+\"&mr_term_set=N&type_set=\"+type_set+\" \";\n\t\t\t\t}\n\t\t\t}\n\t\t\telse\n\t\t\t{\t\n\t\t\t\t\tparent.f_batch_result.location.href=\"../../eMR/jsp/EquivalentTermCodeResult.jsp?status=Y&code=\'Y\'&termdesc=\"+values+\"&termsetid=\"+termsetid+\"&search_criteria=\"+search_criteria+\"&search_text=\"+search_text+\"&termcode=\"+termcode+\"&alphalink=\"+values+\"&codelevel=\"+codelevel+\"&Terminology=\"+FirstConbox+\"&termset_id=\"+SecondValue+\"&termsetid=\"+ThirdConbox+\"&mr_term_set=N&type_set=\"+type_set+\"\";\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\t\n\t\t\t\n\t\t\tif(document.frm_terminology_code.className.value==\"className\")\n\t\t\t\tclassName = \"className\";\n\t\t\telse\n\t\t\t\tclassName = \"\";\n\t\t\n\t\tparent.f_batch_result.location.href=\"../../eMR/jsp/EquivalentTermCodeResult.jsp?status=Y&code=\'Y\'&termdesc=\"+values+\"&termsetid=\"+termsetid+\"&search_criteria=\"+search_criteria+\"&search_text=\"+search_text+\"&termcode=\"+termcode+\"&alphalink=\"+values+\"&codelevel=\"+codelevel+\"&className=\"+className+\"&Terminology=\"+FirstConbox+\"&termset_id=\"+SecondValue+\"&termsetid=\"+ThirdConbox+\"&&status=Y\"+\"&mr_term_set=N&type_set=\"+type_set+\" \";\n\t\t\t\n\t\t}\n\t}\n\tparent.parent.messageFrame.document.location.href = \"../../eCommon/jsp/MstCodeError.jsp\";\n }\n}\nfunction getdefnlevels()\n{\n\tparent.parent.messageFrame.location.href = \"../../eCommon/jsp/MstCodeError.jsp?err_num=\";\n\tvar termsetid = document.frm_terminology_code.terminology_set1.value;\n\t\n\tvar Terminology = document.frm_terminology_code.Terminology.value;\n\tvar termset_id = document.frm_terminology_code.termset_id.value;\n\tvar type_set = document.frm_terminology_code.type_set.value;\t\n\nif(type_set == \'EQ\')\n\t type_set=\'EQ\';\nelse if(type_set == \'DA\')\n\ttype_set = \'AS\'\n/*else if(type_set == \'EC\')\n\ttype_set=\'CO\';*/\n/*\n\tThe Above code was commented On 2/1/2010 that code was modified as below \n*/\nelse if(type_set == \'CO\')\n\ttype_set=\'EC\';\n\n\tparent.f_query_criteria.document.frm_terminology_code.search_text.value=\"\";\n\t\n\tparent.f_query_criteria.document.frm_terminology_code.search_criteria.value=\"C\";\n\tparent.f_query_criteria.document.frm_terminology_code.termcode.value=\"\";\n\tparent.f_query_criteria.document.frm_terminology_code.codelevel.value=\"\";\n\tdocument.frm_terminology_code.termsetid.value =termsetid;     \n\t\t \n\tparent.parent.f_term_selected_frms.f_batch_result.document.location.href=\"../../eMR/jsp/EquivalentTermCodeResult.jsp?termsetid=\"+termsetid+\"&Terminology=\"+Terminology+\"&termset_id=\"+termset_id+\"&mr_term_set=N&type_set=\"+type_set+\" \";\t\t\n\n\t\n}\n</SCRIPT>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\' OnLoad=\'getdefnlevels()\'>\n<FORM METHOD=POST ACTION=\"\" target=\"messageFrame\" name=\"frm_terminology_code\" id=\"frm_terminology_code\">\n<INPUT TYPE=\"hidden\" name=\"terminology\" id=\"terminology\" value=\"\">  \n<font = \'verdana\' class = \"COLUMNHEADER\" size = \'2\' style=\'COLOR: black;\'><b>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</b></font>\n<TABLE border=\"0\" cellpadding=\"4\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n<TR>\n\t<TD class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</TD>\n\t<TD class=\'fields\' width=\'25%\'>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\n\t\t<SELECT name=\"terminology_set1\" id=\"terminology_set1\" disabled >\n\t\t<!--<OPTION value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" disabled>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</OPTION>-->\n\t\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<SELECT name=\"terminology_set1\" id=\"terminology_set1\"  onchange=\"getdefnlevels()\">\n\t\t<OPTION value=\"\"> ----";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="---- </OPTION>\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\t\n\t\t</SELECT><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</TD>\n\t<TD  width=\"10%\" class=\'label\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t<td width=\"30%\" class=\'fields\'><INPUT TYPE=\"text\" name=\"search_text\" id=\"search_text\" maxlength=\'100\' size=\'17\'><SELECT name=\"search_criteria\" id=\"search_criteria\">\n\t<OPTION Value=\"C\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</OPTION>\n\t<OPTION value=\"S\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</OPTION>\n\t<OPTION Value=\"E\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</OPTION>\n\t</SELECT></TD>\n\t<TD width=\'15%\' class=\'button\'><INPUT TYPE=\"button\" class=\"button\" id=\"SearchId\" name=\"searchName\" id=\"searchName\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" onclick=\"callres()\">\n\t</TD>\n\t</TR>\n\t</TABLE>\n\n<TABLE border=\"0\" cellpadding=\"4\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n\t<TR>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'All\')\"><U>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'A\')\"><U>A</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'B\')\"><U>B</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'C\')\"><U>C</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'D\')\"><U>D</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'E\')\"><U>E</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'F\')\"><U>F</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'G\')\"><U>G</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'H\')\"><U>H</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'I\')\"><U>I</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'J\')\"><U>J</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'K\')\"><U>K</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'L\')\"><U>L</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'M\')\"><U>M</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'N\')\"><U>N</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'O\')\"><U>O</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'P\')\"><U>P</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'Q\')\"><U>Q</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'R\')\"><U>R</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'S\')\"><U>S</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'T\')\"><U>T</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'U\')\"><U>U</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'V\')\"><U>V</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'W\')\"><U>W</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'X\')\"><U>X</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'Y\')\"><U>Y</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'Z\')\"><U>Z</U></A></TD>\n\t<TD class=\"label\"><A HREF=\"javascript:callresult(\'OT\')\"><U>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</U></A></TD>\n\t</TR>\n</TABLE>\n<INPUT TYPE=\"hidden\" name=\'dyanmic_level\' id=\'dyanmic_level\' value=\"\">  \n<INPUT TYPE=\"hidden\" name=\'termsetid\' id=\'termsetid\'     value=\'\'> \n<INPUT TYPE=\"hidden\" name=\'termdesc\' id=\'termdesc\'      value=\'\'>\n<INPUT TYPE=\"hidden\" name=\'termcode\' id=\'termcode\'      value=\'\'>\n<INPUT TYPE=\"hidden\" name=\'codelevel\' id=\'codelevel\'     value=\'\'>\n<INPUT TYPE=\"hidden\" name=\"className\" id=\"className\"     value=\"\">\n<INPUT TYPE=\"hidden\" name=\"class_lvl\" id=\"class_lvl\"     value=\"\">\n<INPUT TYPE=\"hidden\" name=\"Terminology\" id=\"Terminology\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n<INPUT TYPE=\"hidden\" name=\"termset_id\" id=\"termset_id\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n<input type = \'hidden\' name = \'type_set\' value=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =">\n</FORM>\n</body>\n</html>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block3Bytes, _wl_block3);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con = null;
	ResultSet termcodeRs = null;
	ResultSet SearchValues = null;
	PreparedStatement termcodeStmt = null;
	PreparedStatement  SearchPmt=null;
	String termcodeSql = "";
	String termsetid = "";
	String termsetdesc = "";
	String Terminology = "";
	String termset_id = "";
	String termcodeSql_title = "";
	String typeset_title  = "";
	
	Terminology=request.getParameter("termsetid");
	termset_id=request.getParameter("termset_id");


	String type_set = request.getParameter("type_set");

	String sq = "select EQUIVALENT_TERM_CODE from MR_EQUIVALENT_TERM_CODE where  TERM_SET_ID=? and TERM_CODE=?";


	con = ConnectionManager.getConnection(request);
	SearchPmt=con.prepareStatement(sq);
	SearchPmt.setString(1,Terminology);
	SearchPmt.setString(2,termset_id);
	SearchValues = SearchPmt.executeQuery();
//	out.println("sq"+sq);
	//out.println("SearchValues"+SearchValues);
	try
		{
			//con = ConnectionManager.getConnection(request);
			termcodeSql_title = "select description from MR_CROSS_REF_RULE where CROSS_REF_TYPE=(select LINKED_CROSS_REF_TYPE FROM MR_CROSS_REF_RULE WHERE CROSS_REF_TYPE =?)";
			
			termcodeStmt = con.prepareStatement(termcodeSql_title);
			termcodeStmt.setString(1,type_set);
			termcodeRs = termcodeStmt.executeQuery();
			if(termcodeRs!=null)
			{
				while(termcodeRs.next())
				{
					typeset_title = termcodeRs.getString("description");
					
					
				}
				if(termcodeRs!=null) termcodeRs.close();
				if(termcodeStmt!=null) termcodeStmt.close();
			}

		}
		catch (Exception e)
		{
			out.println(e.toString());
		}
 

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(typeset_title));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
try
		{
	
	if(type_set.equals("DA")  || type_set.equals("CO")){
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Terminology));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Terminology));
            _bw.write(_wl_block13Bytes, _wl_block13);

			
		//con = ConnectionManager.getConnection(request);
			termcodeSql = "select term_set_id,term_set_desc from MR_TERM_SET where eff_status='E' and term_set_id=?";
			termcodeStmt = con.prepareStatement(termcodeSql);
			termcodeStmt.setString(1,Terminology);
			termcodeRs = termcodeStmt.executeQuery();
			if(termcodeRs!=null)
			{
				while(termcodeRs.next()){
				termsetid = termcodeRs.getString("term_set_id");
				termsetdesc = termcodeRs.getString("term_set_desc");
				out.println("<option value='"+Terminology+"'>"+termsetdesc+"</option>");
				}

			}


	}else{
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

		
				if(termcodeRs!=null) termcodeRs.close();
				if(termcodeStmt!=null) termcodeStmt.close();
		
			termcodeSql = "select term_set_id,term_set_desc from MR_TERM_SET where eff_status='E' and term_set_id NOT IN (?) order by term_set_desc";
			
			termcodeStmt = con.prepareStatement(termcodeSql);
			termcodeStmt.setString(1,Terminology);
			termcodeRs = termcodeStmt.executeQuery();
			if(termcodeRs!=null)
			{
				while(termcodeRs.next())
				{
					termsetid = termcodeRs.getString("term_set_id");
					
					termsetdesc = termcodeRs.getString("term_set_desc");
					out.println("<option value='"+termsetid+"'>"+termsetdesc+"</option>");
										
				}
		
				if(termcodeRs!=null) termcodeRs.close();
				if(termcodeStmt!=null) termcodeStmt.close();
			}

		}
		}
		catch (Exception e)
		{
			out.println(e.toString());
		}
		finally
		{
			if(termcodeRs!=null) termcodeRs.close();
			if(termcodeStmt!=null) termcodeStmt.close();
			ConnectionManager.returnConnection(con,request);
		}
	
		
		
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(Terminology));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(termset_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(type_set));
            _bw.write(_wl_block26Bytes, _wl_block26);
            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.EquivalentTermSet.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.search.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.contains.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.startsWith.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.endsWith.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
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
}
