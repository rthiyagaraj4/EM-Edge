package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import eOR.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __resultcodingqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ResultCodingQueryResult.jsp", 1709119980000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n  \t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/ResultReporting.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/OrCommonFunction.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<Script>\n\tfunction dummy(){}\n \t</script>\n       <STYLE TYPE=\"text/css\">\n       \tA:link\n       \t {\n       \t     COLOR: blue;\n       \t }\n     \tA:visited\n     \t {\n             COLOR: blue ;\n         }\n        A:active\n         {\n             COLOR: red;\n         }\n         \n\n   </STYLE>\n   \n</head>\n\n<body onscroll=\'processScroll()\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"))\n\t\tclearValuesfor1(); //added by prasad\t\n</script>\n ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<form name=\'result_coding_dtl\' id=\'result_coding_dtl\'  action=\"../../eOR/jsp/ResultCodingQueryResult.jsp\" method=\"post\">\n<div id=\"divHeadSep\" style=\"position: absolute;\">\n<table cellpadding=3 cellspacing=0 border=1 width=\"100%\"  id=\"tableresult\" class=\"grid\">\n<tr id=\"heading\">\n\t\t<td class=columnheader width=\'\' nowrap>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n        <td class=columnheader width=\'\' nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t<td class=columnheader width=\'\' nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n</tr>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<tr align=\"right\">\n\t\t\t\t\t\t<td colspan=\"5\">\n\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" \n\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\n\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="   \n\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\t\t\t\t \n\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="  \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n        <tr>\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t<td class=columnheader colspan=8> <font size=1>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</font></td>\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n            <td class=columnheader colspan=7> <font size=1>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</font></td>\n            ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n            ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\n            ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n             ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n        ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n \t\t</tr>\n\t\t\t<td width=\'\' class=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' nowrap>  <font size=1><a class=\'gridLink\' href=\'javascript:dummy()\' onClick=\"procedureLink(\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\',\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\')\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</a></font></td>\n\t\t \t<td width=\'\' class=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'> ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" </font> ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" </td>\n\t\t\t<td width=\'\' class=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'> <font size=1><a class=\'gridLink\' href=\'#\' onClick=\"callMenuFunctions(\'View\',\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\',\'\',\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\',\'N\')\">";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</a></td>\n\t\t\t<td width=\'\' class=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'><font size=1>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" </font></td>\n\t\t\t<td width=\'\' class=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' align=center><font size=1> ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</font> </td>\n\t\t\n\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t</table>  \n</div>\n<Input type=\"hidden\" name=\"total_recs\" id=\"total_recs\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n<Input type=\"hidden\" name=\"order_category\" id=\"order_category\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n<input type=\'hidden\' name=\'group_by\' id=\'group_by\' value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n<Input type=\"hidden\" name=\"from_ca\" id=\"from_ca\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n<Input type=\"hidden\" name=\"can_location_type\" id=\"can_location_type\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n<input type=\'hidden\' name=\'location\' id=\'location\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n<input type=\'hidden\' name=\'single_multi\' id=\'single_multi\' value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n<input type=\'hidden\' name=\'priority\' id=\'priority\' value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n<Input type=\"hidden\" name=\"date_from\" id=\"date_from\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n<Input type=\"hidden\" name=\"date_to\" id=\"date_to\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n<Input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n<Input type=\"hidden\" name=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n<Input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n<Input type=\"hidden\" name=\"patient_id_found\" id=\"patient_id_found\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n<Input type=\"hidden\" name=\"order_type\" id=\"order_type\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n<Input type=\"hidden\" name=\"performing_location_code\" id=\"performing_location_code\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n<Input type=\"hidden\" name=\"view_by\" id=\"view_by\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n<input type=\'hidden\' name=\'catalog_desc\' id=\'catalog_desc\' value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n<input type=\'hidden\' name=\'task_status\' id=\'task_status\' value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n<input type=\'hidden\' name=\'source_type\' id=\'source_type\' value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n<input type=\'hidden\' name=\'peforming_location_code\' id=\'peforming_location_code\' value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n<input type=\'hidden\' name=\'source_location\' id=\'source_location\' value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n<input type=\'hidden\' name=\'search_criteria\' id=\'search_criteria\' value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n<input type=\'hidden\' name=\'activity_type\' id=\'activity_type\' value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\n <!-- For Next & previous -->\n<input type=\'hidden\' name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>\n<input type=\'hidden\' name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'>\n<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t<script>\n\t\t\t//if(parent.ResultReportingHeader.document.getElementById(\"tableheader\")==null)\n\t\t\t//{\n\t\t\t\t//setTimeout(\"alignHeading();\",300);\n\t\t\t//}\n\t\t\t//else \n\t\t\t\t//alignCodingHeading();\n\t</script>\n\n\t <!-- For Next & previous -->\n</form>\n</body>\n<script>\nparent.ResultReportingSearch.document.result_reporting_search.search_btn.disabled= false;\n</script>\n</html>\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	HashMap Parameters = new HashMap();
	Enumeration paramNames = request.getParameterNames();
 	while(paramNames.hasMoreElements())
	{
		String pName = (String)paramNames.nextElement();

		String paramValue = request.getParameter(pName);
		if(paramValue == null)	paramValue = "";
		else paramValue = paramValue.trim();
		Parameters.put(pName, paramValue);
	}
	//out.println("<script>alert('Parameters:::"+Parameters+"')</script>");

	/* Mandatory checks start */
	String mode	   						= "1";//request.getParameter( "mode" ) ;
	String function_id 					= request.getParameter( "function_id" ) ;
	String practitioner_id 				= (String)session.getValue("ca_practitioner_id");
	String responsibility_id 			= (String)session.getValue("responsibility_id");
	String facility_id 					= (String)session.getValue("facility_id");
	String practitioner_type 			= (String)session.getValue("practitioner_type");
	//String patient_id_found 			= request.getParameter("patient_id_found");
	String order_category 				= request.getParameter("order_category");
 	String group_by						= request.getParameter("group_by");

	String from_ca						= request.getParameter("from_ca");

	String can_location_type			= request.getParameter("location_type");
	String can_location					= request.getParameter("location");
	String can_order_category			= request.getParameter("order_category");
	String can_single_multi				= request.getParameter("single_multi");
	String can_priority					= request.getParameter("priority");
	String can_date_from				= request.getParameter("date_from");
	String can_date_to					= request.getParameter("date_to");
	String can_patient_id				= request.getParameter("patient_id");
	String can_order_id					= request.getParameter("order_id");
	String can_encounter_id				= request.getParameter("encounter_id");
	String can_patient_id_found			= request.getParameter("patient_id_found");
	String can_order_type				= request.getParameter("order_type");
	String can_performing_location_code = request.getParameter("performing_location_code");
	String can_view_by 					= request.getParameter("view_by");
 	if(practitioner_id == null)	practitioner_id = "";
	if(responsibility_id == null)	responsibility_id = "";
	if(facility_id == null) facility_id = "";
	if(practitioner_id == null)practitioner_id = "";
	if(order_category == null) order_category = "";
	if (group_by == null) group_by = "";

	if (from_ca == null) from_ca = "";

	if(can_location_type == null) can_location_type = "";
	if(can_location == null) can_location = "";
	if(can_order_category == null) can_order_category = "";
	if(can_single_multi == null) can_single_multi = "";
	if(can_priority == null) can_priority = "";
	if(can_date_from == null) can_date_from = "";
	if(can_date_to == null) can_date_to = "";
	if(can_patient_id == null) can_patient_id = "";
	if(can_order_id == null) can_order_id = "";
	if(can_encounter_id == null) can_encounter_id = "";
	if(can_patient_id_found == null) can_patient_id_found = "";
	if(can_order_type == null) can_order_type = "";
	if(can_performing_location_code == null) can_performing_location_code = "";
	if(can_view_by == null) can_view_by = "";
 	Parameters.put("practitioner_id", practitioner_id);
	Parameters.put("responsibility_id", responsibility_id);
	Parameters.put("facility_id", facility_id);
	Parameters.put("practitioner_type", practitioner_type);
	Parameters.put("from_ca",from_ca);

	String total_query_records  = "0";

//out.println("<script>alert('Parameters:::"+Parameters+"')</script>");

	//out.println(Parameters);

	String bean_id = "Or_ResultReporting";//request.getParameter("bean_id");
	String bean_name = "eOR.ResultReportingBean";//request.getParameter("bean_name");

/* Mandatory checks end */

/* Initialize Function specific start */

	ResultReportingBean bean = (ResultReportingBean)getBeanObject( bean_id, bean_name ,request ) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(function_id));
	bean.clear() ;
	bean.setMode( mode ) ;
	String from	 = bean.checkForNull(request.getParameter( "from" ),"1") ;
	String to	 = bean.checkForNull(request.getParameter( "to" ),"7") ;
 	int start	 = Integer.parseInt(from);
	int end		 = Integer.parseInt(to);

	Parameters.put("start",String.valueOf(start));
	Parameters.put("end",String.valueOf(end));
 

/* Initialize Function specific end */
//    String encounter_id = bean.checkForNull((String)Parameters.get("encounter_id"),"");
	int i = 0;
	ArrayList allValues = new ArrayList();
	//if(from!=null && from.equals("1")) {
  		allValues		= bean.getCodingSearchDetails(Parameters);
 		// Setting as a persistence bean
	//	bean.setDetails(allValues);
 	//} else {
	//	allValues=bean.getDetails();
  	//}
 	String patient_id = "";
	String sex = "";
	//String resultType = "";//String discr_msr_id="";
if( allValues.size() == 0){ 
            _bw.write(_wl_block9Bytes, _wl_block9);
}else{
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

	String slClassValue = "";
	String tmp_ord_cat = "";
	

	//if(allValues.size() < 7 || end > allValues.size()) {
	//		end = allValues.size();
	//}	
	//for(int i=0; i<allValues.size(); i++)
	for(int k=0; k<allValues.size(); k++)
	{
		String[] row_details = new String[26];
		//row_details = (String[])allValues.get(i);
		row_details = (String[])allValues.get(k);
		if(row_details[2].indexOf("$$RD##")!=-1)
		{
			String[] str = (String[])row_details[2].split("!~!");
			String order_detail ="";
			String[] strtitle = null;
			for(int s=0;s<str.length;s++)
			{
				if(str[s].indexOf("$$RD##")!=-1)
				{
					String line_order = (String)str[s];
					strtitle  =line_order.split("::");
					String titleText = "";
					if(strtitle[1].length()>0)
					{
						titleText = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderedFromRadiology.label","or_labels")+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Reason.label","or_labels")+":"+ strtitle[1];
					}
					else
					{
						titleText = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderedFromRadiology.label","or_labels");
					}
					strtitle[0] = "<img src='../../eOR/images/IN_RD_ADD_TEST.gif' title='"+titleText+"'>";
					order_detail = order_detail+strtitle[0]+strtitle[2]+", ";
				}
				else
				{
					order_detail = order_detail+str[s]+", ";
				}
			}
			row_details[2]  = order_detail;
			if(row_details[2].lastIndexOf(",") ==((row_details[2].length())-2))
			{
				row_details[2] = row_details[2] .substring(0,((row_details[2].length())-2));
			}
		}
		if(row_details[2].indexOf("!~!")!=-1)
		{
			row_details[2] =row_details[2].replace("!~!",",");
		}

		if(row_details[1].compareTo("R")==0)
		{
			row_details[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
		}
		else if(row_details[1].compareTo("U")==0)
		{
			row_details[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
		}
		else if(row_details[1].compareTo("S")==0)
		{
			row_details[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
		}

		 if (row_details[3].indexOf(",")!=-1)
		{
			StringTokenizer fieldTokenizer = new StringTokenizer(row_details[3],",");
			row_details[3]="";
		
			while (fieldTokenizer.hasMoreTokens()) 
			{
				String tempToken = fieldTokenizer.nextToken();
				if ((tempToken.indexOf('/'))==2)
				{
			  	  String tempstr=tempToken.substring(2);
				  if (tempToken.charAt(0)=='M')
					  tempToken=(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")).concat(tempstr);
				  else if(tempToken.charAt(0)=='F')
					  tempToken=(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")).concat(tempstr);
				}
				row_details[3]=row_details[3].concat(tempToken).concat(",");
			}
		}
		
        for (int index = 0;index < row_details.length;index++) 
		{
		  if (row_details[index] == null)  row_details[index] = "";
		}

		
		if(k==0) 
		{ 
 				total_query_records = bean.checkForNull((String)row_details[25],"0");
				if((Integer.parseInt(total_query_records)>0) || (start>1))
				{
					
            _bw.write(_wl_block14Bytes, _wl_block14);
            {java.lang.String __page ="ResultScrolling.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("from"), weblogic.utils.StringUtils.valueOf(start
                        )},{ weblogic.utils.StringUtils.valueOf("to"), weblogic.utils.StringUtils.valueOf(end
                        )},{ weblogic.utils.StringUtils.valueOf("total_size"), weblogic.utils.StringUtils.valueOf(total_query_records
                        )},{ weblogic.utils.StringUtils.valueOf("check_box_name"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("form_name"), weblogic.utils.StringUtils.valueOf("result_coding_dtl")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block21Bytes, _wl_block21);
			}  
		}

		//out.println("<script>alert('before')</script>");

 		//out.println("<script>alert('"+facility_id+","+row_details[16]+","+visit_adm_date+"')</script>");
		//out.println("<script>alert('row_details[1]:"+row_details[1]+",row_details[2]:"+row_details[2]+"--row_details[3]::"+row_details[3]+"')</script>");
//out.println("<script>alert('row_details[7]:"+row_details[7]+",row_details[9]:"+row_details[9]+"--row_details[3]::"+row_details[3]+"')</script>");
		patient_id = row_details[11];

		if(row_details[5].trim().equalsIgnoreCase("PH") && !(row_details[7].equals("TDM")) && !(row_details[7].equals("PDC")))
		   row_details[12] = "C";
 		/*if(i % 2 == 0)
			slClassValue = "QRYEVEN";
		else
			slClassValue = "QRYODD";*/
			slClassValue="gridData";
 
		String grpCheckValue = "";
		if (group_by.equals("P")) {
		  grpCheckValue = (String)row_details[11];
		} else if (group_by.equals("") || group_by.equals("D")) {
		  grpCheckValue = (String)row_details[16];
		} else if (group_by.equals("C")) {
		  grpCheckValue = (String)row_details[5];
		}  else if (group_by.equals("T")) {
		  grpCheckValue = (String)row_details[7];
		}   else if (group_by.equals("L")) {
		  grpCheckValue = (String)row_details[17] + "/" + (String)row_details[18];
		}  else if (group_by.equals("U")) {
		  grpCheckValue = (String)row_details[12];
		}  else if (group_by.equals("O")) {
		  grpCheckValue = (String)row_details[2];
		}
 		if(!(tmp_ord_cat.equals(grpCheckValue)))
		{
 		
            _bw.write(_wl_block22Bytes, _wl_block22);
            _bw.write(_wl_block23Bytes, _wl_block23);
if (group_by.equals("") || group_by.equals("D")) {
            if (can_view_by.equals("L")) {
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(row_details[16],"DMY","en",localeName)));
            _bw.write(_wl_block25Bytes, _wl_block25);
} else {
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(row_details[16],"DMY","en",localeName)));
            _bw.write(_wl_block27Bytes, _wl_block27);
 }
                tmp_ord_cat = (String)row_details[16];
            }
            _bw.write(_wl_block28Bytes, _wl_block28);
if (group_by.equals("P")) {
            if (can_view_by.equals("L")) {
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(row_details[3]));
            _bw.write(_wl_block25Bytes, _wl_block25);
} else {
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(row_details[3]));
            _bw.write(_wl_block27Bytes, _wl_block27);
 }
                tmp_ord_cat = (String)row_details[11];
            }
            _bw.write(_wl_block28Bytes, _wl_block28);
if (group_by.equals("C")) {
            if (can_view_by.equals("L")) {
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(row_details[6]));
            _bw.write(_wl_block25Bytes, _wl_block25);
} else {
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(row_details[6]));
            _bw.write(_wl_block27Bytes, _wl_block27);
 }
                tmp_ord_cat = (String)row_details[5];
            }
            _bw.write(_wl_block29Bytes, _wl_block29);
if (group_by.equals("T")) {
            if (can_view_by.equals("L")) {
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(row_details[8]));
            _bw.write(_wl_block25Bytes, _wl_block25);
} else {
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(row_details[8]));
            _bw.write(_wl_block27Bytes, _wl_block27);
 }
                tmp_ord_cat = (String)row_details[7];
            }
            _bw.write(_wl_block29Bytes, _wl_block29);
if (group_by.equals("L")) {
            if (can_view_by.equals("L")) {
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf((((String)row_details[17]).equals("") && ((String)row_details[18]).equals(""))? "Others" : (String)row_details[17] + "/" + (String)row_details[18]));
            _bw.write(_wl_block25Bytes, _wl_block25);
} else {
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf((((String)row_details[18]).equals("") && ((String)row_details[18]).equals(""))? "Others" : (String)row_details[18] + "/" + (String)row_details[18]));
            _bw.write(_wl_block27Bytes, _wl_block27);
 }
                tmp_ord_cat = grpCheckValue = (String)row_details[17] + "/" + (String)row_details[18];
            }
            _bw.write(_wl_block30Bytes, _wl_block30);
if (group_by.equals("U")) {
            if (can_view_by.equals("L")) {
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(row_details[1]));
            _bw.write(_wl_block25Bytes, _wl_block25);
} else {
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(row_details[1]));
            _bw.write(_wl_block27Bytes, _wl_block27);
 }
                tmp_ord_cat = (String)row_details[12];
            }
            _bw.write(_wl_block29Bytes, _wl_block29);
if (group_by.equals("O")) {
            _bw.write(_wl_block29Bytes, _wl_block29);
if (can_view_by.equals("L")) {
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(row_details[2]));
            _bw.write(_wl_block25Bytes, _wl_block25);
} else {
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(row_details[2]));
            _bw.write(_wl_block27Bytes, _wl_block27);
 }
                tmp_ord_cat = (String)row_details[2];
            }
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block32Bytes, _wl_block32);
            _bw.write(_wl_block33Bytes, _wl_block33);

			String fontValue 		= "";
			String imageTag 		= "";
			String procedure_code	="";
//			String result_type		="";
			sex = row_details[14];
			if(row_details[12].equals("U")){
				fontValue = "<font size=1 color=red><b>";  // this is to indicate the different color for urgency
			}else if(row_details[12].equals("S")){
				fontValue = "<font size=1 color=brown><b>";  // this is to indicate the different color for Stat
				imageTag = "<img src=\"../images/StatOrders.gif\" width=\"26\" height=\"24\" border=0 alt=\"Stat\">";
			}else{
				fontValue = "<font size=1 color=black><b>";
			}
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(row_details[9]));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(row_details[7]));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(row_details[11]));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(row_details[14]));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(row_details[15]));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(row_details[24]));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(row_details[0],"DMYHM","en",localeName)));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(fontValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(row_details[1]));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(imageTag));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(row_details[6]));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(row_details[9]));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(procedure_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(row_details[15]));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(row_details[2]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(row_details[3]));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(row_details[4]));
            _bw.write(_wl_block50Bytes, _wl_block50);
i++;
		}
		
    }
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(group_by));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(from_ca));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(can_location_type));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(can_location));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(can_single_multi));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(can_priority));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(can_date_from));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(can_date_to));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(can_patient_id));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(can_order_id));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(can_encounter_id));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(can_patient_id_found));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(can_order_type));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(can_performing_location_code));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(can_view_by));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(request.getParameter("catalog_desc")));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(request.getParameter("task_status")));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(request.getParameter("source_type")));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(request.getParameter("peforming_location_code")));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(request.getParameter("source_location")));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(request.getParameter("search_criteria")));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(request.getParameter("activity_type")));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(from));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(to));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block78Bytes, _wl_block78);

	putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block4Bytes, _wl_block4);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderDate.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderDetails.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
