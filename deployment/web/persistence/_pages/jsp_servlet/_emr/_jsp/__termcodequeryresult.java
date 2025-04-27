package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;
import eOR.Common.*;
import eOR.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import eCommon.Common.*;
import java.util.*;

public final class __termcodequeryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/TermCodeQueryResult.jsp", 1737697233194L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t<title></title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t\n\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eMR/js/NoteTerminologyCode.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\n\tfunction Modify(obj){\n\t\tvar code1=trimString(obj.cells[0].innerText);\n\t\tvar retVal = code1;\n\t\tif (obj && obj.cells && obj.cells.length > 1 && obj.cells[1]) {\n\t\t    var code2 = trimString(obj.cells[1].innerText);\n\t\t    retVal = retVal + \"||\" + code2;\n\t\t}\n\t\tif (obj && obj.cells && obj.cells.length > 1 && obj.cells[2]) {\n\t\t    var code3 = trimString(obj.cells[2].innerText);\n\t\t    retVal = retVal + \"||\" + code3;\n\t\t}\n\t\t//var code2=trimString(obj.cells[1].innerText);\n\t\t//var code3=trimString(obj.cells[2].innerText);\n\t\tif (obj && obj.cells && obj.cells.length > 2 && obj.cells[3] && obj.cells.children && obj.cells.children.length > 1 && obj.cells[3].children[0]) {\n\t\t\tvar code4=trimString(obj.cells[3].children[0].value);\n\t\t\tretVal = retVal + \"||\" + code4 ;\n\t\t}\n\t\t//var code4=trimString(obj.cells[3].children[0].value);\n\t\tretVal = retVal + \"~\";\n\t\t//var retVal = code1 + \"||\" + code2 + \"||\" + code3 + \"||\" + code4 +\"~\";\n\t\twindow.returnValue = retVal ;\n\t\t/* parent.window.returnValue = retVal ;\n\t\tconst dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n\t    dialogTag.close();  */\n\t\twindow.close();\n\t}\n\t//Maheshwaran K added for PMG2014-MOD-CRF-0004 \n\tfunction GetValuesChk(obj,valobj,chkValues_obj,returnVal2_obj)\n\t\t{\n\t\tvar  temp_term_code1 = parent.lookup_detail.document.getElementById(\"temp_term_code1\").value;\n\t\tvar chkValues = chkValues_obj.value;\n\t\tvar returnVal2 = returnVal2_obj.value;\n\t\tif(obj.checked)\n\t\t\t{\n\t\t\tchkValues=chkValues+\"\"+valobj+\"~\"\n\t\t\t}\n\t\telse\n\t\t\t{\n\t\t\tobj.checked=false;\n\t\t\tvalobj=valobj+\"~\";\n\t\t\tchkValues=chkValues.replace(valobj,\"\");\n\t\t\treturnVal2=returnVal2.replace(valobj,\"\");\n\t\t\ttemp_term_code1=temp_term_code1.replace(valobj,\"\");\n\t\t\t}\n\t\tchkValues_obj.value=chkValues;\n\t\treturnVal2_obj.value=returnVal2;\n\t\tparent.lookup_detail.document.getElementById(\"temp_term_code1\").value=temp_term_code1;\n\t\t}\n\t</script>\n\t<body OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<table cellpadding=1 cellspacing=0 width=\"100%\" align=\"center\">\n\t\t<tr onclick=\'retainChk()\'>\n\t\t\t<td width=\"80%\" class=\"white\" >&nbsp;</td>\n\t\t\t<td width=\"20%\" class=\"white\" >&nbsp;\n\t\t\t\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t</td>\n\t\t</tr> \n\t\t</table>\n\t\t\n\t<table border=\"2\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" id=\'result_tbl\'>\n\t\t<th width=\'20%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t<th width=\'40%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t<th width=\'20%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t<!-- <th width=\'45%\'>Term Set Description</th> -->\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<th>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n             <tr onClick=\"Modify(this);\" >\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" onmouseover=\"this.style.cursor=\'pointer\';\" ><font class=\'HYPERLINK\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t</font></td>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" onclick=\"disableClick(event);\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t<td style=\'display:none\'><input type=\'hidden\' name=\'code_level";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' id=\'code_level";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'></td>\n   \t   ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" onclick=\"\" ><font class=\'\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</font></td> \n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t<td style=\'display:none\'><input type=\'hidden\' name=\'code_level";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'></td>\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t <td class=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" align=\'center\' onclick=\"disableClick(event);\"><input type=\"checkbox\" name=\"term_chk";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" id=\"term_chk";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" onclick=\"GetValuesChk(term_chk";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =",\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\',chkValues1,returnVal2)\"></td>\n\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\t\t\n           </tr>\n\t\t\n    ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t<input type=\"hidden\" name=\'cnt\' id=\'cnt\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t<input type=\"hidden\" name=\'chkValues1\' id=\'chkValues1\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n   <input type=\"hidden\" name=\'temp_term_code1\' id=\'temp_term_code1\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t<input type=\"hidden\" name=\"ret_term_code\" id=\"ret_term_code\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t<input type=\"hidden\" name=\"term_code_associated\" id=\"term_code_associated\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t<input type=\"hidden\" name=\"db_term_code\" id=\"db_term_code\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n    <input type=\"hidden\" name=\'qry_string\' id=\'qry_string\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t<input type=\"hidden\" name=\"term_group_id1\" id=\"term_group_id1\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t<input type=\"hidden\" name=\"term_set_id1\" id=\"term_set_id1\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t<input type=\"hidden\" name=\"returnVal2\" id=\"returnVal2\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t<input type=\"hidden\" name=\'search_by\' id=\'search_by\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>  <!-- Added By vinod 14/05/2005 -->\n\t\n</table>\n\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\n\t\t<script>\n\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\'Common\'));\n\t\t\t\n\t\t\tparent.lookup_head.document.CriteriaForm.Search.disabled = false;\n\t\t\t/*\n\t\t\tThis component TermCodeSearch is used commonly. If OK button is not there it gives error\n\t\t\t*/\n\t\t\tif (parent.lookup_cancel.document.getElementById(\"ok\") != null)\n\t\t\t{\n\t\t\t\tparent.lookup_cancel.document.getElementById(\"ok\").disabled = false;\n\t\t\t}\n\t\t\t\n\t\t\thistory.go(-1);\n\t\t</script> \n\t\t\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\n</body>\n\t\n\t<script>\n\t\t\tparent.lookup_head.document.CriteriaForm.Search.disabled = false;\n\t</script> \n</html>\n\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block2Bytes, _wl_block2);
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

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet TermCodevalues= null;synchronized(session){
                TermCodevalues=(webbeans.eCommon.RecordSet)pageContext.getAttribute("TermCodevalues",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(TermCodevalues==null){
                    TermCodevalues=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("TermCodevalues",TermCodevalues,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String locale					= (String) session.getValue( "LOCALE" ) ;

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

    request.setCharacterEncoding("UTF-8");
	
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	// String sqlData         = "select a.term_Code term_code, a.short_Desc term_code_description,a.long_Desc long_description, Decode(CODE_LEVEL,'1',LEVEL_1_DESC,'2',LEVEL_2_DESC,'3',LEVEL_3_DESC, '4',LEVEL_4_DESC ,'5',LEVEL_5_DESC ,'6',LEVEL_6_DESC ,'7',LEVEL_7_DESC ,'8',LEVEL_8_DESC ,'9',LEVEL_9_DESC ,'10',LEVEL_5_DESC )  code_level_desc,code_level from mr_term_code a, mr_Term_set b    where a.term_set_id = b.term_set_ID and upper(select_yn) like upper('Y') and upper(a.term_Set_id) = upper(?)  and 	upper(a.term_code)  like upper(?) and upper(a.short_Desc) like upper(?) and upper(short_Desc) like  DECODE   ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?)) and code_level= nvl(?,code_level) order by 1";
	String chkValues  =  CommonBean.checkForNull(request.getParameter("chkValues")) ;

	String searchCriteria  = CommonBean.checkForNull( request.getParameter( "sc" ) ) ;
	String returnVal1  =  request.getParameter("returnVal1") ;
	String term_set_id	   = CommonBean.checkForNull( request.getParameter( "term_set_id" ) ) ;
	String term_code	   = CommonBean.checkForNull( request.getParameter( "term_code" ) ) ;
	String search_by	   = CommonBean.checkForNull( request.getParameter( "search_by" ) ) ;
	//  String search_text	   = CommonBean.checkForNull( request.getParameter( "search_text" ) ) ;
	//  String term_code_desc  = CommonBean.checkForNull( request.getParameter( "term_code" ) ) ;
	String code_level	   = CommonBean.checkForNull( request.getParameter( "code_level" ) ) ;
	String multiple_yn     = CommonBean.checkForNull( request.getParameter( "multiple_yn" ) ) ;
	String temp_term_code  = CommonBean.checkForNull( request.getParameter( "temp_term_code" ) ) ;
	//String term_code_associated  = CommonBean.checkForNull( request.getParameter( "term_code_associated" ) ) ;
	//String Db_term_code  = CommonBean.checkForNull( request.getParameter( "Db_term_code" ) ) ;
	String term_group_id	   = CommonBean.checkForNull( request.getParameter( "term_group_id" ) ) ;
	int db_count=0;
	String Db_term_code="";
	String term_code_associated="";
	StringBuffer DB_term_code_associated = new StringBuffer();
	StringBuffer DB_term_code_associated1 = new StringBuffer();
	StringBuffer term_code_associated1 = new StringBuffer();
	StringBuffer term_code_associated2 = new StringBuffer();
	StringBuffer temp_db_chk = new StringBuffer("");
	String DB_Term_code_Exisits = request.getParameter("Db_term_code")==null? "N" :"Y";
	boolean mode_flag=false;
	StringBuffer sr_nos= new StringBuffer("");
	String temp_no="";
	try
		{
		String sql_code = "select a.TERM_CODE term_code, c.SHORT_DESC term_code_desc, c.CODE_LEVEL code_level, Decode(c.CODE_LEVEL,'1',LEVEL_1_DESC,'2',LEVEL_2_DESC, '3',LEVEL_3_DESC, '4',LEVEL_4_DESC ,'5',LEVEL_5_DESC , '6',LEVEL_6_DESC ,'7',LEVEL_7_DESC ,'8',LEVEL_8_DESC ,  '9',LEVEL_9_DESC ,'10',LEVEL_10_DESC ) code_level_desc, ORDER_SRL_NO order_no from MR_TERM_GROUP_DTL a, mr_term_set b,mr_term_code c where   a.term_set_id = b.term_set_id and b.term_set_id = c.term_set_id and a.term_code  = c.term_code and a.term_group_id like upper(?) and a.TERM_SET_ID like upper(?)";
		Connection con = null;
		PreparedStatement pstmt_code = null;
		ResultSet rs_code = null;
		con = ConnectionManager.getConnection(request);
		pstmt_code = con.prepareStatement(sql_code);
		pstmt_code.setString(1,term_group_id);
		pstmt_code.setString(2,term_set_id);
		rs_code=pstmt_code.executeQuery();				
//		String DB_term_code_associated="";
		String temp="";
		String temp1="";
		String code_level_desc="";
		String level1="";
		mode_flag = false;
		while(rs_code.next())
		{
		    level1=rs_code.getString("code_level");
			code_level_desc=CommonBean.checkForNull(rs_code.getString("code_level_desc"));
			if(code_level_desc.equals(""))
			code_level_desc = "||";
			temp = rs_code.getString("term_code")+"~"+level1+"~"+code_level_desc+"~"+rs_code.getString("term_code_desc")+"`";
			temp1 = rs_code.getString("term_code")+"||"+rs_code.getString("term_code_desc")+"||"+code_level_desc+"||"+level1+"~";
			temp_db_chk.append(rs_code.getString("term_code")+"~");
//			sr_nos+=rs_code.getString("order_no")+"~";
			sr_nos.append(rs_code.getString("order_no")+"~");
			if(term_code_associated1.indexOf(temp) == -1)
			{
//				DB_term_code_associated += temp ;
				DB_term_code_associated.append(temp);
				db_count++;
			}
			if(term_code_associated1.indexOf(temp1) == -1)
			{
//				DB_term_code_associated1 += temp1;
				DB_term_code_associated1.append(temp1);
				db_count++;
			}
			mode_flag =true;
		}
		if ( rs_code !=null ) rs_code.close();
		if ( pstmt_code !=null ) pstmt_code.close();
//		term_code_associated1 = DB_term_code_associated + term_code_associated;
		term_code_associated1.append(DB_term_code_associated);
		term_code_associated2.append(DB_term_code_associated1);
		
	  try{
		if (con != null) ConnectionManager.returnConnection(con,request);
	  }
	  catch(Exception e)
	  {
		//out.println("Exception "+e.toString());
		 e.printStackTrace();
	  }
	}
	catch(Exception e)
		{
		e.printStackTrace();
		}
		Db_term_code  =term_code_associated1.toString();
		term_code_associated  =term_code_associated2.toString();
	StringBuffer sqlData	= new StringBuffer("");
	sqlData.append("select a.term_Code term_code, a.short_Desc term_code_description,a.long_Desc long_description, Decode(a.CODE_LEVEL,'1',b.LEVEL_1_DESC,'2',b.LEVEL_2_DESC,'3',b.LEVEL_3_DESC, '4',b.LEVEL_4_DESC ,'5',b.LEVEL_5_DESC ,'6',b.LEVEL_6_DESC ,'7',b.LEVEL_7_DESC ,'8',b.LEVEL_8_DESC ,'9',b.LEVEL_9_DESC ,'10',b.LEVEL_5_DESC )code_level_desc,a.code_level from mr_term_code a, mr_Term_set b where a.term_set_id = b.term_set_ID and upper(a.select_yn) like upper('Y') and upper(a.term_Set_id) = upper(?) and ");
	 
	if(search_by.equals("C"))
		sqlData.append("upper(a.term_code)");
	 else
		sqlData.append("upper(short_desc)");
	 sqlData.append(" like  DECODE   ((?), 'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?)) and code_level=		nvl(?,code_level)   AND a.eff_status = 'E'");
	 if(!multiple_yn.equals("Y"))
	{
		 sqlData.append("   AND a.procedure_yn = 'Y' AND b.proc_spec_yn = 'Y'  ");
	}
	sqlData.append(" order by 1");
	
/*	if(search_by.equals("C"))
		term_code_desc = "";
	else
		term_code = "";*/
		
//multiple_yn = "Y";
	boolean searched	   = request.getParameter( "searched" ) == null ? false : true  ;
	
try
{
	String classvalue			= "";
	String checked="",disabled="";

	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData", sqlData.toString());
	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	displayFields.add( "term_code" );
    displayFields.add( "term_code_description" );
	//displayFields.add( "long_description" );
    displayFields.add( "code_level_desc" );
	displayFields.add( "code_level" );
    //  displayFields.add( "term_set_desc" );
	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();
	chkFields.add(term_set_id.trim());
	chkFields.add(searchCriteria.trim());
	chkFields.add(term_code);
	chkFields.add(term_code);
	chkFields.add(term_code);
	chkFields.add(code_level.trim());
	

	//Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );
	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
	if ( sqlMap != null ) sqlMap.clear();
	if ( funcMap != null ) funcMap.clear();
	if ( chkFields != null ) chkFields.clear();
	
	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) ))
	{
	
            _bw.write(_wl_block9Bytes, _wl_block9);

			//For displaying the previous/next link
			 out.println(result.get(1));
	
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
  if(multiple_yn.equals("Y"))
			{
	 
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
   
			}
		  //Retriving the records from result arraylist
		    ArrayList records=new ArrayList();

		   for ( int recCount=2; recCount<result.size(); recCount++) 
		   {
		 	 if ( recCount % 2 == 0 )
				    classvalue = "QRYEVEN" ;
			else
				 classvalue = "QRYODD" ;
		
            _bw.write(_wl_block16Bytes, _wl_block16);


           String link_columns = "1";
		   if (multiple_yn.equals("Y"))
				link_columns = "0";
            records=(ArrayList) result.get( recCount );
		    
			for (int colCount=0; colCount<records.size(); colCount++)
			 {
				if(!multiple_yn.equals("Y"))
				 {
					if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 )
					 {
		
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((String)records.get( colCount )));
            _bw.write(_wl_block19Bytes, _wl_block19);
 
			        }
					else
					{ 
						if ( colCount != 3 )
						{

		
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get( colCount ))));
            _bw.write(_wl_block22Bytes, _wl_block22);
	
						}
						else
						{
		
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(records.get( colCount )));
            _bw.write(_wl_block26Bytes, _wl_block26);
 
						}
					}
				 }
				else
			      {
					if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 )
					 {
						
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf((String)records.get( colCount )));
            _bw.write(_wl_block29Bytes, _wl_block29);
		}
					else
					{ 
						if (colCount != 3)
						 {
							
		
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get( colCount ))));
            _bw.write(_wl_block22Bytes, _wl_block22);

						}
						else
						{
		
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(records.get( colCount )));
            _bw.write(_wl_block32Bytes, _wl_block32);

						}
						if ( (String.valueOf(colCount)).equals("3") )
						 {
    						//	String temp_rec= (String)records.get( 0 )+"~";
								if	(temp_term_code.indexOf((String)records.get( 0 )+"~") != -1)
								{
									int ind = temp_term_code.indexOf((String)records.get( 0 )+"~") ;
									String temp1=temp_term_code.substring(ind,temp_term_code.length());
									int ind1=temp1.indexOf("~") ;
									String temp2=temp1.substring(0,ind1);
									if (temp2.equals((String)records.get( 0 )) )
									 {
										checked = "checked";
										disabled= "";
									}
									else
									{
										checked = "";
										disabled= "";
									}
								}
								else
								{
									checked = "";
									disabled= "";
								}
/* Modified by vinod 9/13/2005
	To handle the term codes which are substrings of other term codes.
	A term code will be suffixed with "~" before comparing with the string "DB_term_code" to identify the exact matching sub string
*/	
					//		String temp_rec1 = (String)records.get( 0 )+"~";
							if (Db_term_code.indexOf((String)records.get( 0 )+"~") != -1) 
							 {
								int ind = Db_term_code.indexOf((String)records.get( 0 )+"~") ;
								String temp1=Db_term_code.substring(ind,Db_term_code.length());
								int ind1=temp1.indexOf("~") ;
								String temp2=temp1.substring(0,ind1);
								 if(temp2.equals((String)records.get( 0 )))
									{
										checked = "checked";
										disabled= "disabled";
									}
									else
									{
										checked = "";
										disabled= "";
									}
							}
		
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(records.get( 0 )));
            _bw.write(_wl_block40Bytes, _wl_block40);

						}
				}
			}	
         } /* End of For column Count */
 		if ( records != null ) records.clear();
    
            _bw.write(_wl_block41Bytes, _wl_block41);

      } /* End of For record Count */

    
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(result.size()));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(chkValues));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(temp_term_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(term_code_associated));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(term_code_associated));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(Db_term_code));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(term_group_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(returnVal1));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(search_by));
            _bw.write(_wl_block53Bytes, _wl_block53);
out.flush();
	}
	else /* If  result.size() not >=3) */
     {

            _bw.write(_wl_block54Bytes, _wl_block54);

	  }
	/**Following code changed by vinod 06/09/2005 - Extra characters were printing in result page  */
	out.println(CommonBean.setForm(request ,"TermCodeQueryResult.jsp?\"+request.getQueryString()+\"", searched));
	if ( displayFields != null ) displayFields.clear();
	if ( result != null ) result.clear();
 }
catch(Exception e) 
	{
		//out.print("Exception @ Result JSP :"+e.toString());
		 e.printStackTrace();
	}
	

            _bw.write(_wl_block55Bytes, _wl_block55);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TermCode.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TermCodeDescription.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CodeLevel.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
