package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;

public final class __newproctermcodequerysearch extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/NewProcTermCodeQuerySearch.jsp", 1709119752000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' type=\'text/css\' />\n\n    <script language=\"JavaScript\" src=\"../../eOR/js/NewProcedureTermCode.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eMR/js/eMRmessages.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n<body onload=\'setRadioVal()\'>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<form name=\"CriteriaForm\" id=\"CriteriaForm\"  >\n<table align=\"right\"  border=\"0\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr>\n        <td colspan=\'\'  class=\"label\" >Group\n\t\t <input type=\"radio\" name=\"terminology\" id=\"terminology\" value=\"G\" onclick=\"storeVal(this)\" ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =">\n\t\t \n\t\t Code<input type=\"radio\" name=\"terminology\" id=\"terminology\" value=\"C\" onclick=\"storeVal(this)\" ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =">\n\t\t </td>\n\t\t<td class=\"label\" >\n\t\t<!-- Code<input type=\"radio\" name=\"terminology\" id=\"terminology\" value=\"C\" onclick=\"storeVal(this)\"> -->\n        </td>\n    </tr>\n    <tr >\n        <td colspan=\'\'  class=\"label\" width=\"40%\">Term Set\n       <select name=\'term_set\' id=\'term_set\' onChange=\'changeLevel(this)\' ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="><option>---------Select--------</option>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</option> \n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t</select><img id=\'term_set_man\' style=\"visibility:hidden\" src=\"../../eCommon/images/mandatory.gif\">\n\t\t<input type=\"hidden\" name=\"term_set_id\" id=\"term_set_id\" value=\"\">\n\t\t</td>\n\t\t<td class=\"label\" width=\"60%\">\n\t\tLevel<select name=\'level\' id=\'level\' onChange=\'\'><option value=\"\">--Select--</option>\n\t\t<!-- <option>Level 1</option>\n\t\t<option>Level 2</option>\n\t\t<option>Level 3</option>\n\t\t<option>Level 4</option>\n\t\t<option>Level 5</option>\n\t\t<option>Level 6</option>\n\t\t<option>Level 7</option>\n\t\t<option>Level 8</option>\n\t\t<option>Level 9</option>\n\t\t<option>Level 10</option> -->\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t</select>Search By<select name=\'search_by\' id=\'search_by\' onChange=\'setSearch(this)\'><option value=\"D\" >Description</option><option value=\"C\">Code</option></select>\n        </td>\n    </tr>\n\t<tr>\n\t\t<td class=\"label\" colspan=\'\' id=\'term\'><label id=\'\'>Term Description</label><input type=\"text\" onBlur=\"\"  name=\"search_text\" id=\"search_text\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" width=\"30%\" align=\"left\" size=\"20\" maxlength=\"40\" onkeypress=\"return CheckForSpecChars(event);\"><img id=\'term_set_man1\' style=\"visibility:hidden\" src=\"../../eCommon/images/mandatory.gif\"></td>\n\t\t<td class=\'label\'>Search Criteria\n        <select name=\"search_criteria\" id=\"search_criteria\">\n        <option value=\"S\">Starts With\n        <option value=\"E\">Ends With\n        <option value=\"C\">Contains\n        </select></td>\n\t</tr>\n    <tr>\n\t\t<td class=\"label\">\n        </td>\n        <td align=\"right\"><input type=\"button\" align=\"left\" name=\"Search\" id=\"Search\" value=\"Search\" onClick=\"javascript:search();\" class=\"button\" >\n        <input type=\"button\" align=\"left\" name=\"Reset\" id=\"Reset\" value=\"Reset\" onClick=\"resetForm(this.form)\" class=\"button\" >\n        </td>\n    </tr>\n</table>\n<BR>\n<BR>\n<input type=\"hidden\" name=\"multiple_yn\" id=\"multiple_yn\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n<input type=\"hidden\" name=\"temp_term_code\" id=\"temp_term_code\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n<input type=\"hidden\" name=\"Db_term_code\" id=\"Db_term_code\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n<input type=\"hidden\" name=\"term_code_associated\" id=\"term_code_associated\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n<input type=\"hidden\" name=\"ret_term_code\" id=\"ret_term_code\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n<input type=\"hidden\" name=\"tmp_radioval\" id=\"tmp_radioval\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n</form>\n</body>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n<script>\n   search();\n</script>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n</html>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

String select(String str1, String str2)
{
		if(str1.trim().equalsIgnoreCase(str2.trim()))
		return "selected";
		else
		return "";
}
String disabled(String str1, String str2)
	{
		if(!str1.trim().equals("")){
			if(str1.trim().equalsIgnoreCase(str2.trim()))
				return "disabled";
			else
				return "";
		}else
			return "";
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
            _bw.write(_wl_block2Bytes, _wl_block2);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	

            _bw.write(_wl_block3Bytes, _wl_block3);

			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);

String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
String term_desc = request.getParameter("term_desc")==null?"":request.getParameter("term_desc");
String mulitple_yn = request.getParameter("mulitple_yn")==null?"":request.getParameter("mulitple_yn");
String temp_term_code = request.getParameter("temp_term_code")==null?"":request.getParameter("temp_term_code");
String term_code_associated = request.getParameter("term_code_associated")==null?"":request.getParameter("term_code_associated");
String Db_term_code = request.getParameter("Db_term_code")==null?"":request.getParameter("Db_term_code");
String radioval = request.getParameter("radioval")==null?"":request.getParameter("radioval");
//term_set_id = "ICD10";
String practitioner_id=(String) session.getValue("ca_practitioner_id");
if(radioval.equals(""))
	radioval="";	

String sql_term = "select term_set_id,term_set_desc,defn_levels from mr_term_set a  where (exists (select 1 from mr_term_set_for_pract ib  where PRACTITIONER_ID=? AND TERM_SET_ID=A.TERM_SET_ID) or not exists (select 1 from mr_term_set_for_pract  where PRACTITIONER_ID=?) ) and proc_spec_yn = 'Y' and eff_status='E'";

String sql_level = "select  '1' code1 ,LEVEL_1_DESC   descr  ,LEVEL_1_CODE_LENGTH  LENGTH from mr_term_set  where term_Set_id = (?) and LEVEL_1_DESC is not null  and eff_status = 'E' union  select  '2' code2 ,LEVEL_2_DESC descr  ,LEVEL_2_CODE_LENGTH LENGTH from mr_term_set  where term_Set_id =(?) and LEVEL_2_DESC is not null  and eff_status = 'E' union select  '3' code ,LEVEL_3_DESC descr  ,LEVEL_3_CODE_LENGTH LENGTH from mr_term_set  where term_Set_id = (?) and LEVEL_3_DESC is not null  and eff_status = 'E' union select  '4' code3 ,LEVEL_4_DESC descr ,LEVEL_4_CODE_LENGTH LENGTH from mr_term_set  where term_Set_id = (?) and LEVEL_4_DESC is not null  and eff_status = 'E' union select  '5' code3 ,LEVEL_5_DESC descr  ,LEVEL_5_CODE_LENGTH LENGTH from mr_term_set  where term_Set_id =(?) and LEVEL_5_DESC is not null  and eff_status = 'E' union select  '6' code  ,LEVEL_6_DESC descr ,LEVEL_6_CODE_LENGTH LENGTH from mr_term_set  where term_Set_id =(?) and LEVEL_6_DESC is not null  and eff_status = 'E' union select  '7' code ,LEVEL_7_DESC descr  ,LEVEL_7_CODE_LENGTH LENGTH from mr_term_set  where term_Set_id =(?) and LEVEL_7_DESC is not null  and eff_status = 'E' union select  '8' code ,LEVEL_8_DESC descr  ,LEVEL_8_CODE_LENGTH LENGTH from mr_term_set  where   term_Set_id =(?) and LEVEL_8_DESC is not null  and eff_status = 'E' union select  '9' code ,LEVEL_9_DESC descr  ,LEVEL_9_CODE_LENGTH LENGTH from mr_term_set  where term_Set_id =(?) and LEVEL_9_DESC is not null  and eff_status = 'E' union select  '10' code ,LEVEL_10_DESC descr  ,LEVEL_10_CODE_LENGTH LENGTH from mr_term_Set where term_Set_id =(?) and LEVEL_10_DESC is not null  and eff_status = 'E'  order by 1";


	Connection con = null;
	PreparedStatement pstmt_term = null,pstmt_level = null;
	ResultSet rs_term,rs_level = null;
	
	con = ConnectionManager.getConnection(request);
	//pstmt_dept = con.prepareStatement(sql_dept);
	//pstmt_serv = con.prepareStatement(sql_serv);
	pstmt_term = con.prepareStatement(sql_term);
	pstmt_term.setString(1,practitioner_id);
	pstmt_term.setString(2,practitioner_id);

	pstmt_level = con.prepareStatement(sql_level);
	
	pstmt_level.setString(1,term_set_id);
	pstmt_level.setString(2,term_set_id);
	pstmt_level.setString(3,term_set_id);
	pstmt_level.setString(4,term_set_id);
	pstmt_level.setString(5,term_set_id);
	pstmt_level.setString(6,term_set_id);
	pstmt_level.setString(7,term_set_id);
	pstmt_level.setString(8,term_set_id);
	pstmt_level.setString(9,term_set_id);
	pstmt_level.setString(10,term_set_id);
	
	rs_term = pstmt_term.executeQuery();
	rs_level = pstmt_level.executeQuery();
	

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf((radioval.equals("G")||radioval.equals(""))?"checked":""));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf((radioval.equals("C"))?"checked":""));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(disabled(term_set_id,term_set_id)));
            _bw.write(_wl_block9Bytes, _wl_block9);
while(rs_term.next()){ 
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rs_term.getString(1)+"~"+rs_term.getString(3)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(select(rs_term.getString(1),term_set_id)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(rs_term.getString(2).trim()));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
while(rs_level.next()){ 
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rs_level.getString(1)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rs_level.getString(2).trim()));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(term_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(mulitple_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(temp_term_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Db_term_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(term_code_associated));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(term_code_associated));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(radioval));
            _bw.write(_wl_block23Bytes, _wl_block23);
 
	  if ( !term_desc.equals("") )
	   {
 
            _bw.write(_wl_block24Bytes, _wl_block24);
  }  

	if ( rs_term != null) 	rs_term.close();
	if ( rs_level != null) 	rs_level.close();
	if ( pstmt_term != null) pstmt_term.close();
	if ( pstmt_level != null) pstmt_level.close();
	if ( con != null )	ConnectionManager.returnConnection(con,request);

            _bw.write(_wl_block25Bytes, _wl_block25);
            _bw.write(_wl_block26Bytes, _wl_block26);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
