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

public final class __selecttermcoderesult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/SelectTermCodeResult.jsp", 1743501767199L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<html>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n<script language=\"JavaScript\" src=\"../../eMR/js/TerminologyCode.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<script>\nfunction submitPrevNext(from, to)\n{\n\t\tdocument.term_code_result.from.value = from;\n\t    document.term_code_result.to.value = to; \n\t   // var termcode = document.term_code_result.termsetid.value; \n\t    var termcode = document.term_code_result.part_term_code.value; \n\t    var termsetid = document.term_code_result.termsetid.value; \n\t    var termdesc = document.term_code_result.termdesc.value; \n\t    var search_criteria = document.term_code_result.search_criteria.value; \n\t    codelevel = document.term_code_result.codelevel.value; \n\n\t\tparent.f_term_code_result.location.href=\"../../eMR/jsp/SelectTermCodeResult.jsp?termcode=\"+termcode+\"&termsetid=\"+termsetid+\"&codelevel=\"+codelevel+\"&from=\"+from+\"&to=\"+to+\"&termdesc=\"+termdesc+\"&search_criteria=\"+search_criteria;\n}\nfunction call(termcode,termdesc,select_yn)\n{\n\tparent.f_sel_term_buttons.document.sel_term_code_button.termcode.value = termcode;\n\tparent.f_sel_term_buttons.document.sel_term_code_button.select_yn.value = select_yn;\n\tvar termsetid = document.term_code_result.termsetid.value; \n\tvar className = \"\";\n\tvar codelvl = eval(document.term_code_result.codelevel.value); \n\tcdlvl = eval(parent.f_term_result_header.document.term_code_result_header.defn_levels.value)+1;\n\tcodelevel = codelvl + 1;\n\tif(cdlvl!=codelevel)\n\t{\n\t\tif(codelevel==2)\n\t\t{\t\n\t\t\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode2.value=termcode;\n\t\t}\n\t\telse if(codelevel==3)\n\t\t{\t\n\t\t\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode3.value=termcode;\n\t\t}\n\t\telse if(codelevel==4)\n\t\t{\t\n\t\t\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode4.value=termcode;\n\t\t}\n\t\telse if(codelevel==5)\n\t\t{\t\n\t\t\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode5.value=termcode;\n\t\t}\n\t\telse if(codelevel==6)\n\t\t{\t\n\t\t\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode6.value=termcode;\n\t\t}\n\t\telse if(codelevel==7)\n\t\t{\t\n\t\t\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode7.value=termcode;\n\t\t}\n\t\telse if(codelevel==8)\n\t\t{\t\n\t\t\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode8.value=termcode;\n\t\t}\n\t\telse if(codelevel==9)\n\t\t{\t\n\t\t\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode9.value=termcode;\n\t\t}\n\t\telse if(codelevel==10)\n\t\t{\t\n\t\t\tparent.f_term_selected_frms.f_term_disp_lvl.document.term_code_displvl.termcode10.value=termcode;\n\t\t}\n\t\tparent.f_term_result_header.document.term_code_result_header.termcode.value = termcode;\n\t\tparent.f_term_result_header.document.term_code_result_header.codelevel.value = codelevel;\n\t\t// This part dynamic rows are generated for final frame seleted value based on click of result page.\n \t\tvar rowvar = parent.f_term_selected_frms.f_term_selected_value.document.getElementById(\"tableId\").insertRow();\n\t\tvar cellvar = rowvar.insertCell();\n\t\tcellvar.style.color = \"#0000EE\";\n\t\tfor(var i= 0 ; i < termdesc.length;i++)\n\t\t{\n\t\t\ttermdesc = \ttermdesc.replace(\'|\',\' \');\n\t\t}\n\n\t\tfor(var i= 0 ; i < termdesc.length;i++)\n\t\t{\n\t\t\ttermdesc = \ttermdesc.replace(\'$\',\"\'\");\n\t\t}\n\t\tcellvar.insertAdjacentHTML(\"beforeend\",termdesc);\n\t\tif(codelevel%2==0)\n\t\t{\n\t\t\tcellvar.className=\'ATCQRYEVEN\';\n\t\t}\n\t\telse\n\t\t{\n\t\t\tcellvar.className=\'ATCQRYODD\';\n\t\t}\n\t\t// End of dynamic rows creation.\n\t\tif(codelevel==(cdlvl-1))\n\t\t{\n\t\t\tclassName = \"className\"\n\t\t}\n\t\tparent.f_term_code_result.location.href=\"../../eMR/jsp/SelectTermCodeResult.jsp?termcode=\"+termcode+\"&termsetid=\"+termsetid+\"&codelevel=\"+codelevel+\"&className=\"+className+\"\";\n\t\t\n\t\tvar htmlvalue = \"<html><body onKeyDown=\'lockKey()\'><form name=\'dynamic_value\' id=\'dynamic_value\' method=\'post\' action=\'../../eMR/jsp/SelectTermCodeDynamicValues.jsp\'><input type=\'hidden\' name=\'termsetid\' id=\'termsetid\' value=\'\"+termsetid+\"\'><input type=\'hidden\' name=\'codelevel\' id=\'codelevel\' value=\'\"+codelevel+\"\'><input type=\'hidden\' name=\'termcode\' id=\'termcode\' value=\'\"+termcode+\"\'></form></body></html>\"\n\t\tparent.blankFrame.document.write(htmlvalue);\n\t\tparent.blankFrame.document.dynamic_value.submit();\n\t}\n\telse\n\t{\n\t\t// This part dynamic rows are generated for final frame seleted value based on click of result page last level.\n\t\tif(document.forms[0].last_level.value==\"\")\n\t\t{\n\t\t\tvar rowvar = parent.f_term_selected_frms.f_term_selected_value.document.getElementById(\"tableId\").insertRow();\n\t\t\tvar cellvar = rowvar.insertCell();\n\t\t\tcellvar.style.color = \"#0000EE\";\n\t\t\tfor(var i= 0 ; i < termdesc.length;i++)\n\t\t\t{\n\t\t\t\ttermdesc = \ttermdesc.replace(\'|\',\' \');\n\t\t\t}\n\n\t\t\tfor(var i= 0 ; i < termdesc.length;i++)\n\t\t\t{\n\t\t\t\ttermdesc = \ttermdesc.replace(\'$\',\"\'\");\n\t\t\t}\n\t\t\tcellvar.insertAdjacentHTML(\"beforeend\",termdesc);\n\t\t\tif(codelevel%2==0)\n\t\t\t{\n\t\t\t\tcellvar.className=\'ATCQRYEVEN\';\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tcellvar.className=\'ATCQRYODD\';\n\t\t\t}\n\t\t\tdocument.forms[0].last_level.value = \"lastlevel\";\n\t\t}\n\t\t// End of dynamic rows creation at last level.\n\t}\n}\t\n</script>\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'> \n<FORM METHOD=\'POST\' name=\'term_code_result\' id=\'term_code_result\' target=\'blankFrame\' ACTION=\"\">\n<table width=\'95%\'>\n<tr>\n<td align=\'right\'  id=\'prevNext\'  class=\'BODYCOLORFILLED\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</td>\n</tr>\n</table>\n\n<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\'  width=\'95%\' >\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<th align=\'left\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\n\t</table>\n<INPUT TYPE=\"hidden\" name=\"termsetid\" id=\"termsetid\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n<INPUT TYPE=\"hidden\" name=\"termcode\" id=\"termcode\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n<INPUT TYPE=\"hidden\" name=\"termcode1\" id=\"termcode1\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n<INPUT TYPE=\"hidden\" name=\"codelevel\" id=\"codelevel\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n<INPUT type=hidden name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n<INPUT type=hidden name=\"to\" id=\"to\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n<INPUT type=hidden name=\"start\" id=\"start\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n<INPUT type=hidden name=\"end\" id=\"end\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n<INPUT TYPE=\"hidden\" name=\'desc\' id=\'desc\' value=\'\'>\n<INPUT TYPE=\"hidden\" name=\'last_level\' id=\'last_level\' value=\'\'>\n<INPUT TYPE=\"hidden\" name=\'part_term_code\' id=\'part_term_code\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n<INPUT TYPE=\"hidden\" name=\'termdesc\' id=\'termdesc\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n<INPUT TYPE=\"hidden\" name=\'search_criteria\' id=\'search_criteria\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block0Bytes, _wl_block0);
 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
            _bw.write(_wl_block5Bytes, _wl_block5);
 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String locale = checkForNull((String)session.getAttribute("LOCALE")); 

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

request.setCharacterEncoding("UTF-8");
Connection con=null;
Statement stmt=null;
ResultSet rset=null ;
ResultSet rset1=null ;
String cd_lvl = request.getParameter("codelevel");
if(cd_lvl==null) cd_lvl="1";
int code_level = Integer.parseInt(cd_lvl);
String className= request.getParameter("className");
if(className==null) className = "";
String classValue = "";
String termsetid = request.getParameter("termsetid");
String termdescription = request.getParameter("termdesc");
String search_criteria = request.getParameter("search_criteria");
String search_text = request.getParameter("search_text");
String termcode = request.getParameter("termcode");
String termcode1 = request.getParameter("termcode");
String whereclause = "";
String cntSql = "";
String sqltermcoderesult = "";
String part_term_code=request.getParameter("termcode");
//String  req_start= "";
//String req_end = "";
//String select_yn = "";
String desc = "";
String defnlevelSql = "";
String from = request.getParameter("from") ;
String to = request.getParameter("to") ;
if(termcode==null) termcode="";
if(termcode1==null) termcode1="";
if(termsetid==null) termsetid="";
if(code_level==1)
	termcode = "";
if((termdescription==null)||(termdescription.equals("All"))) termdescription="";
if(search_criteria==null) search_criteria="";
if(search_text==null) search_text="";
try
	{
		con = ConnectionManager.getConnection(request);
		from = request.getParameter("from") ;
		to = request.getParameter("to") ;
		if(!search_text.equals(""))
		{
			termdescription = search_text;
		}
		if(search_criteria.equals("S"))
		{
			whereclause = "upper(short_desc) like '"+termdescription + "%'";
		}
		else if(search_criteria.equals("E"))
		{
			whereclause =  "upper(short_desc) like '%" + termdescription +"'";
		}
		else if(search_criteria.equals("C"))
		{
			whereclause = "upper(short_desc) like '%"+ termdescription + "%'";
		}
		else
		{
			whereclause = "upper(short_desc) like '"+termdescription + "%'";
		}
		if(termdescription.equals("OT"))
		{
			whereclause = "(UPPER(SUBSTR(short_desc,1,1)) not between 'A' and 'Z')";
		}
		
		int maxRecord = 0;
		int start = 0 ;
		int end = 0 ;
		int i=1;
		if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
		if (to == null){ end = 11 ; }   else {  end = Integer.parseInt( to ) ; }
		//req_start       =   (request.getParameter("start")==null)   ?   "0" :   request.getParameter("start");
		//req_end         =   (request.getParameter("end")==null)     ?   "0" :   request.getParameter("end");
		i = 1;
//out.println("<script>alert(\""+termcode+"\");</script>");
		if(termcode.equals(""))
		{
			cntSql= "select count(*) from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and code_level="+code_level+" and diagnosis_yn = 'Y' order by short_desc";
		}
		else
		{
			cntSql= "select count(*) from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and part_term_code like'"+termcode+"%' and code_level="+code_level+" and diagnosis_yn = 'Y' order by short_desc";
		}
/*Friday, January 22, 2010 , 18379 , added diagnosis_yn = 'Y' since procedure code also getting listed for Record Diagnosis */
		stmt=con.createStatement();
		rset1 = stmt.executeQuery(cntSql);
		if(rset1!=null)
		{
			if(rset1.next())
			{
				maxRecord = rset1.getInt(1);
			}
			if(rset1!=null) rset1.close();
			if(stmt!=null) stmt.close();
		}
		if(code_level==1)
		{
			defnlevelSql = "select level_1_desc from mr_term_set where term_set_id='"+termsetid+"'";
		}
		else if(code_level==2)
		{
			defnlevelSql = "select level_2_desc from mr_term_set where term_set_id='"+termsetid+"'";
		}
		else if(code_level==3)
		{
			defnlevelSql = "select level_3_desc from mr_term_set where term_set_id='"+termsetid+"'";
		}
		else if(code_level==4)
		{
			defnlevelSql = "select level_4_desc from mr_term_set where term_set_id='"+termsetid+"'";
		}
		else if(code_level==5)
		{
			defnlevelSql = "select level_5_desc from mr_term_set where term_set_id='"+termsetid+"'";
		}
		else if(code_level==6)
		{
			defnlevelSql = "select level_6_desc from mr_term_set where term_set_id='"+termsetid+"'";
		}
		else if(code_level==7)
		{
			defnlevelSql = "select level_7_desc from mr_term_set where term_set_id='"+termsetid+"'";
		}
		else if(code_level==8)
		{
			defnlevelSql = "select level_8_desc from mr_term_set where term_set_id='"+termsetid+"'";
		}
		else if(code_level==9)
		{
			defnlevelSql = "select level_9_desc from mr_term_set where term_set_id='"+termsetid+"'";
		}
		else if(code_level==10)
		{
			defnlevelSql = "select level_10_desc from mr_term_set where term_set_id='"+termsetid+"'";
		}
		stmt=con.createStatement();
		rset1 = stmt.executeQuery(defnlevelSql);
		if(rset1!=null)
		{
			if(rset1.next())
			{
				desc = rset1.getString(1);
				if(rset1!=null) rset1.close();
				if(stmt!=null) stmt.close();
			}
		}

            _bw.write(_wl_block8Bytes, _wl_block8);


	if ( !(start <= 1)){

		out.println("<a href='javascript:submitPrevNext("+(start-11)+","+(end-11)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</a>");

	}

	if ( !((start+11) > maxRecord )){

		out.println("<a href='javascript:submitPrevNext("+(start+11)+","+(end+11)+")' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</a>");


	
	}

            _bw.write(_wl_block9Bytes, _wl_block9);

	if(termcode.equals("")){
						/*
							The following query was modified for IN023648.
							Modified On:10/13/2010
						*/

//		sqltermcoderesult="select term_code,short_desc,select_yn from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and code_level="+code_level+" and diagnosis_yn = 'Y' order by short_desc";
		sqltermcoderesult="select term_code,short_desc,select_yn from mr_d_"+termsetid+"_lang_vw where "+whereclause+" and term_set_id='"+termsetid+"' and code_level="+code_level+" and diagnosis_yn = 'Y' and language_id='"+locale+"' order by short_desc";
	}else{
//		sqltermcoderesult="select term_code,short_desc,select_yn from mr_term_code where "+whereclause+" and term_set_id='"+termsetid+"' and part_term_code like '"+termcode+"%' and code_level="+code_level+" and diagnosis_yn = 'Y' order by short_desc";
		sqltermcoderesult="select term_code,short_desc,select_yn from mr_d_"+termsetid+"_lang_vw where "+whereclause+" and term_set_id='"+termsetid+"' and part_term_code like '"+termcode+"%' and code_level="+code_level+" and diagnosis_yn = 'Y' and language_id='"+locale+"' order by short_desc";

	}
	/*Friday, January 22, 2010 , 18379 , added diagnosis_yn = 'Y' since procedure code also getting listed for Record Diagnosis */
	//out.println(sqltermcoderesult);
	stmt = con.createStatement();
	rset=stmt.executeQuery(sqltermcoderesult);
	
	String tempString ="";
	String test = "";
	if(maxRecord!=0){
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block11Bytes, _wl_block11);

		if(rset!=null){
			if ( start != 0 ){
				for( int j=1; j<start; i++,j++ )
				{
					rset.next() ;
				}
			}
			while(rset.next() && i<=end ){
				tempString=rset.getString("short_desc");
				tempString = tempString.replace(' ','|');	
				tempString = tempString.replace('\'','$');
				//if(rset.getString("SELECT_YN").equals("Y"))
				if((i%2) == 1)
					classValue = "ATCQRYODD";
				else
					classValue ="ATCQRYEVEN";
				test = "call('"+rset.getString("term_code")+"','"+tempString+"','"+rset.getString("SELECT_YN")+"')";
				out.println("<tr>");
					termcode = rset.getString("term_code");
					out.println("<td style='color: #0000EE;' class='"+classValue+"' width='75%' onclick="+test+"; >"+rset.getString("short_desc")+"</td>");
				out.println("</tr>");
				i++;
			}
		if(rset!=null) rset.close();
		if(stmt!=null) stmt.close();
		}
	}else{
			out.println("<script>;alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));//document.location.href='../../eCommon/html/blank.html'</script>");
	}

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(termsetid));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(termcode));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(termcode1));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(code_level));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(start));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(end));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(start));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(end));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(part_term_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(termdescription));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(search_criteria));
            _bw.write(_wl_block23Bytes, _wl_block23);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally 
	{
		if(stmt!=null) stmt.close();
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block24Bytes, _wl_block24);
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
