package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __privilegeaddmodifydetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/PrivilegeAddModifyDetail.jsp", 1709119928000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n\t\t \n\n<html>\n<head>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t<!--<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script>-->\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n <body onMouseDown=\"CodeArrest()\"  onKeyDown=\"lockKey()\" >\n \n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n<form name=\"privilegeDetail\" id=\"privilegeDetail\" method=\"post\" scrolling=\"yes\" >\n\n\n\n\n<table border=\"1\" id=\"headerTab\" cellpadding=3 cellspacing=0 width=\"100%\" align=\"center\">\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n<tr>\n\t<td class=columnheader rowspan=\"2\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t<!--<th align=\"left\" rowspan=\"2\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="Privilege Type </th>--><!--removed by Kavitha.K 21.12.2004-->\n\t<!--<th align=\"left\" width=\'10%\' >Active</th>-->\n\t<td class=columnheadercenter colspan=\"9\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n</tr>\n\t\t\n<tr>\n\t<td class=columnheader>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t<td class=columnheader>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n</tr>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n<!--";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="-->\n\n\t\n<!--&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\n//Start\n-->\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n<tr>\n\t<td class=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" style=\"display:none\">\n\t<INPUT TYPE=\"hidden\" name=\"grp_exception_id";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" id=\"grp_exception_id";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" value=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="></td>\n\t<td align=\"left\" class=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' nowrap >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\n\t<!-- modified by kavitha k on 20.12.2004-->\n\n\n<!--&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\n//Start\n-->\n<!--<td align=\"left\" class=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' nowrap>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="<select name=\"privilege_value";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" id=\"privilege_value";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n<option selected value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--- Select ---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>\n<!-- value=\"A\" ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="-->\n<!--<option value=\"A\" ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =">Allowed</option>\n\t<option value=\"X\" ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =">Not Allowed</option>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n</select>\n<INPUT TYPE=\"hidden\" name=\'privilege_value_hidden";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' id=\'privilege_value_hidden";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n<img src=\"../../eCommon/images/mandatory.gif\"></img>\n</td>\n<!--\t<td align=\"center\" class=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' ><INPUT TYPE=\"checkbox\" name=\"include";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" id=\"include";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" \n\tvalue=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" \n\tonclick=\"return parent.parent.checkActive(this)\"></td>-->\n\n\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n<!--added by kavitha k on 13.12.2004-->\n<td class=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'><input type=\"checkbox\" name=\"privilege_value";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"\nonclick=\"return parent.parent.checkActive(this)\" ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\t<input type=\"hidden\" name=\"include";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t</td>\n\t\n<td class=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'><select name=\"privilege_value";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" >\n<option value=\'A\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =">A</option>\n<option value=\'S\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =">S</option>\n<option value=\'M\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =">M</option>\n<option value=\'N\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =">N</option> \n</select>\n\t\n\t\t<input type=\"hidden\" name=\"include";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t</td>\n\n\t<td class=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n<option value=\'A\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =">N</option> \n</select>\n\t\t<input type=\"hidden\" name=\"include";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =">N</option> \n</select>\n<input type=\"hidden\" name=\"include";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\t\t\n\t</td>\n\n\t<td align=\"center\" class=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\t\t\n\t</td>\n\n\n\n\t<td align=\"center\" class=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t\t\n\t</td>\n\n\t<td align=\"center\" class=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t</td>\n\n\t<td align=\"center\" class=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t</td>\n\t<!--end of added by kavitha k on 13.12.2004-->\n</tr>\n\t<input type=\"hidden\" name=\"privilege_id";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" id=\"privilege_id";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" value=\"\">\n\t<!--<input type=\"hidden\" name=\"privilege_value";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" value=\"\">-->\n\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));</script>\n ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\n</table>\n\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n<input type=hidden name=\"oldvalues\" id=\"oldvalues\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\n<!--<input type=\'hidden\' name=\'nextPrevFlag\' id=\'nextPrevFlag\' value=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\' >//removed by Kavitha.K 1/10/2005-->\n<input type=\"hidden\" name=\"noOfRecords\" id=\"noOfRecords\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n<!--<input type=\'hidden\' name=\'previousRecord\' id=\'previousRecord\' value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' >//\n<input type=\'hidden\' name=\'nextRecord\' id=\'nextRecord\' value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\' >removed by Kavitha.K1/10/2005-->\n<input type=\'hidden\' name=\'action\' id=\'action\' value=\'\' >\n<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\n<input type=\'hidden\' name=\'privilege_ctx_id\' id=\'privilege_ctx_id\' value=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' >\n<input type=\'hidden\' name=\'privilege_ctx\' id=\'privilege_ctx\' value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' >\n<input type=\'hidden\' name=\'privilege_id\' id=\'privilege_id\' value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' >\n<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n<!--<input type=\'hidden\' name=\'privilege_value\' id=\'privilege_value\' value=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' >modified by Kavitha.K 21.12.2004-->\n<!--<input type=\'hidden\' name=\'active_yn\' id=\'active_yn\' value=\'\' >-->\n<input type=\'hidden\' name=\'resp_id\' id=\'resp_id\' value=\'\' >\n<input type=\'hidden\' name=\'reln_id\' id=\'reln_id\' value=\'\' >\n<input type=\'hidden\' name=\'appl_user_id\' id=\'appl_user_id\' value=\'\'>\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'>\n\n<input type=\'hidden\' name=\'flagnext\' id=\'flagnext\' value=\'0\'>\n<input type=\'hidden\' name=\'flagprev\' id=\'flagprev\' value=\'0\'>\n\n";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);


	request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	/* Mandatory checks start */
	String mode				 = request.getParameter("mode") ;
	//String function_id		 = request.getParameter("function_id" ) ;
	String action			 = request.getParameter("action" ) ;
	String privilege_ctx_id  = request.getParameter("privilege_ctx_id" ) ;
	if((privilege_ctx_id==null)|| (privilege_ctx_id.equals("null")))
	privilege_ctx_id="";
	String facility_id = "";
	/*String appl_user_id = request.getParameter("appl_user_id");
	String reln_id = request.getParameter("reln_id");
	String resp_id = request.getParameter("resp_id");
	String facility_id = request.getParameter("facility_id");

	out.println("privilege_ctx_id  " + privilege_ctx_id);
	out.println("appl_user_id  " + appl_user_id);
	out.println("reln_id  " + reln_id);
	out.println("resp_id  " + resp_id);
	out.println("facility_id  " + facility_id);*/

	//out.println(privilege_ctx_id);
	String bean_id			 = "privilege" ;
	String bean_name		 = "eOR.PrivilegeBean";
	//String readOnly			 = "" ;
	//String disabled			 = "" ;
	String grp_exception_id  = "" ;
	String facility_name	 = "" ;
	String privilege_id		 = "" ;
	String privilege_value 	 = "" ;
	
	//String priv_value		 = "" ;
	String values			 = "" ;

	//String include			 = "" ;//int count_code= 0;
								//	int count_code1= 0;
	//String active_yn		 = "";
	String privilege_ctx	 = "";
	
	
	//modified by Kavitha K 20.12.2004:
	/*
	String privilege_id1 = "";	//"checked" or ""
	
	String privilege_id2 = "";	// "selected" or ""
	String privilege_id3 = "";	// "selected" or ""
	String privilege_id4 = "";	// "selected" or ""
	String privilege_id5 = "";	// "selected" or ""
	String privilege_id6 = "";	// "selected" or ""
	String privilege_id7 = "";	// "selected" or ""
	String privilege_id8 = "";	// "selected" or ""
	String privilege_id9 = "";	// "selected" or ""*/
	//modified by Kavitha K 20.12.2004

	//added by kavitha 20.12.2004
	String privilege_value1="";//"checked" or ""
	String privilege_value2="A";
	String privilege_value3="A";
	String privilege_value4="A";
	String privilege_value5="A";
	String privilege_value6="A";
	String privilege_value7="A";
	String privilege_value8="A";
	String privilege_value9="A";
	//end of added by kavitha 20.12.2004

	
	String ascc1 = "N";
	String ascc2 = "N";
	String ascc3 = "N";
	String ascc4 = "N";
	String ascc5 = "N";
	String ascc6 = "N";
	String ascc7 = "N";
	String ascc8 = "N";
	String ascc9 = "N";

	//String valSourceLevel[]  ={"U","R","P"} ;
	//String descsourceLevel[]={"User Id","RelationShip","Responsibility"} ;
	//String valSourceVal[]  ={"S","M","A","N"} ;  //modified by kavitha on 20.12.2004--S=Self Order,M=Medical Team,A=All Orders,N=Not Applicable
	//String descsourceVal[]={"Allowed","Not Allowed"} ; //,"Allowed with Exception","Not Allowed with Exception"
	//String update_val = "";
	//boolean alteredRecord=false;
	int   fm_disp=0,to_disp=0, noOfRecords=0;
	//int start=0,row_disp=8,end=0;
	// String previousRecord=0, nextRecord =0;
	ArrayList records = null ;

	//int j = 1 ;
	String classValue ="";

	//String  from= "", to ="" ;
	String nextPrevFlag =""; //removed by Kavitha.K 1/7/2005
	/*	Initialize Function specific start */
	//eOR.Common.MultiRecordBean MultiRecordSet		= new eOR.Common.MultiRecordBean();
	PrivilegeBean privilege = (PrivilegeBean)getBeanObject( bean_id,bean_name,request ) ;

	privilege.setFunctionId(privilege.checkForNull(request.getParameter("function_id")));

	try{
	
	//Both in UPdate and Insert Mode
	if(action.equalsIgnoreCase("create")){

	privilege.clearALL();
	records =  privilege.getIdentifiers();
			if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )) {
				
				//System.out.println("#####in modify mode");

			//out.println("privilege ctx id   " + privilege_ctx_id);
			//System.err.println("@@@@@@@@########@@@@@@@@@ privilege ctx id " + privilege_ctx_id);
			//privilege.loadDetail(privilege_ctx_id,appl_user_id,reln_id,resp_id,facility_id)	;
			privilege.loadDetail(privilege_ctx_id);
			//privilege_value 	 = privilege.getPrivilege_value();//removed by Kavitha.K 07.01.2005
			//out.println(privilege_value);
			
			//System.err.println("@@@@@@@@@@@@@@@ Privilege Value " + privilege_value);

			//active_yn			 = privilege.getActive_yn()		;
			facility_id			 = privilege.getFacility_id()	;
			facility_name		 = privilege.getFacility_name()	;
		    //privilege_id		 = privilege.getPrivilege_id()	;

			//System.err.println("@@@@@@@@@@@@@@@ Privilege Id " + privilege_id);
	        privilege_ctx		 = privilege.getPrivilege_ctx()	;

			//out.println("<script>alert('privilege_value:::::"+privilege_value+"')</script>");
			//out.println("<script>alert('facility_id:::::"+facility_id+"')</script>");
			//out.println("<script>alert('facility_name:::::"+facility_name+"')</script>");
			//out.println("<script>alert('privilege_ctx:::::"+privilege_ctx+"')</script>");


		}

	}else{

		//System.out.println("#####request="+request);
		privilege.synStore(request);
	//out.println("<script>alert('synStore:::::"+privilege.synStore(request)+"')</script>");

	}
	//if(!mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ))
	records =  privilege.getIdentifiersStore();

	//System.out.println("#####records="+records);
	values  = privilege.getPrivValue();	
	//out.println("<script>alert('#####values:::::"+values+"')</script>");

//	out.println(privilege.tempChk);
	noOfRecords  = records.size();



	/*nextPrevFlag  = ChkDef.defaultString(request.getParameter("nextPrevFlag"));
	previousRecord= ChkDef.defaultInt(request.getParameter("previousRecord"));
	nextRecord	  = ChkDef.defaultInt(request.getParameter("nextRecord"));*///removed by Kavitha.K 1/7/2005

}catch(Exception e){

	System.out.println(e.getMessage());
}


            _bw.write(_wl_block10Bytes, _wl_block10);
try {
	
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
/*Value */ 
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

		//out.println("<script>alert('noOfRecords:::::"+noOfRecords+"')</script>");
	if(noOfRecords != 0){
            _bw.write(_wl_block17Bytes, _wl_block17);

//privilege_value = (String )recCurrent.get("privilege_value");//added by Subhash.Y
//out.println("privilege Value   "  + privilege_value);

            _bw.write(_wl_block18Bytes, _wl_block18);
	
//String bean_value[] = null;
//String bean_privilege_value[] = null;
String privilege_value_curr = "";
//String grp_exp_id = "";
String grp_id="";
//boolean flag = false;
//int first_time=0;
//int fm= fm_disp-1;//removed by Kavitha.K 1/10/2005


String grp_exception_name ="";
String ascc			  ="";
String temp="";

for(int i=0; i < noOfRecords; i++){
//	htListRecord		=	(java.util.HashMap)	MultiRecordSet.getListObject(i);
//associate_yn		=	(String)	htListRecord.get("associate_yn");
//out.println("<script>alert('associate_yn   :"+associate_yn+"');</script>");

HashMap recCurrent = (HashMap)records.get(i);
grp_exception_name =(String)recCurrent.get("grp_exception_name");
grp_exception_id = (String)recCurrent.get("grp_exception_id");
ascc			  =(String)recCurrent.get("include");
classValue			=( (i%2)==0 )? "QRYODD" : "QRYEVEN";
//privilege_value_curr = (String )recCurrent.get("privilege_value");//Removed by Kavitha.K on 06.01.2005
/*if(privilege_value_curr ==null)
	privilege_value_curr = "A";*///removed by kavitha 07.01.2005

if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )) 
{
	if(!ascc.equals("") && !ascc.equals("N") && !ascc.equals(" "))
	{	
		grp_id=grp_exception_id;
		privilege_value_curr = privilege_value_curr;
		
		//out.println("<script>alert('grp_exception_id   :"+grp_exception_id+"');</script>");
		Vector listPrivIDs = privilege.getPrivilegeIDs(privilege_ctx_id,grp_exception_id);
		//System.err.println("Vector @@######@@@@@@@@@@ " + listPrivIDs);
		//System.out.println("listval"+listPrivIDs);
		//System.out.println("size"+listPrivIDs.size());
		for(int k=0;k<listPrivIDs.size();k++)
		{
			temp = ((String)listPrivIDs.get(k)).trim();
			//out.println("<script>alert('temp   :"+temp+"');</script>");
			k++;
			if(temp.equalsIgnoreCase("O")) 
				{
				//System.out.println("privilege_value1  FOR O :"+((String)listPrivIDs.get(k)).trim());

					if(((String)listPrivIDs.get(k)).trim().equals("Y"))
						{ 
							privilege_value1 = "checked"; 
							ascc1 = "Y";
						}
						
				}
			if(temp.equalsIgnoreCase("V")) { 
				//System.out.println("privilege_value1  FOR V :"+((String)listPrivIDs.get(k)).trim());
				privilege_value2 = ((String)listPrivIDs.get(k)).trim(); 
				
				ascc2 = "Y"; }
			if(temp.equalsIgnoreCase("C")) {
				//System.out.println("privilege_value1  FOR C :"+((String)listPrivIDs.get(k)).trim());
				privilege_value3 = ((String)listPrivIDs.get(k)).trim();  
				ascc3 = "Y"; }
			if(temp.equalsIgnoreCase("A")) { 
				privilege_value4 = ((String)listPrivIDs.get(k)).trim();  
				//System.out.println("privilege_value2  FOR A :"+privilege_value2);
				ascc4 = "Y"; }
			if(temp.equalsIgnoreCase("U")) { 
				privilege_value5 = ((String)listPrivIDs.get(k)).trim(); 
				ascc5 = "Y"; }
			if(temp.equalsIgnoreCase("S")) { 
				privilege_value6 = ((String)listPrivIDs.get(k)).trim(); 
				ascc6 = "Y"; }
			if(temp.equalsIgnoreCase("P")) {
				privilege_value7 = ((String)listPrivIDs.get(k)).trim(); 
				ascc7 = "Y"; }
			if(temp.equalsIgnoreCase("H")) { 
				privilege_value8 = ((String)listPrivIDs.get(k)).trim(); 
			ascc8 = "Y"; }
			if(temp.equalsIgnoreCase("D")) { 
				privilege_value9 = ((String)listPrivIDs.get(k)).trim(); 
				ascc9 = "Y"; }
		}

	}else{privilege_value_curr = "";}
}

//out.println("<script>alert('values:::::"+values+"')</script>");
//System.out.println("####values="+values);

/*end of removed by Kavitha.K 1/19/2005
if((values !="")||(values != null)|| (values !="null")){

	//out.println("<script>alert('values inside value loop  :"+values+"');</script>");

	StringTokenizer stoken = new StringTokenizer(values,"~");
	final int count_code		=	stoken.countTokens();
	bean_value = new String[count_code];
		int k = 0;
	while(stoken.hasMoreTokens()){
		bean_value[k]	=	stoken.nextToken();
		k++;
	}

	for(int x=0;x<bean_value.length;x++){
		//out.println("<script>alert('#####stoken1:::::')</script>");
		
		StringTokenizer stoken1= new StringTokenizer(bean_value[x],"||");		
		String temp = stoken1.nextToken();
		String actualString = stoken1.nextToken();	
		
		//out.println("<script>alert('stoken1:::::"+stoken1+"')</script>");
		//out.println("<script>alert('temp = stoken1.nextToken():::::"+temp+"')</script>");
		//out.println("<script>alert('actualString:::::"+actualString+"')</script>");


		StringTokenizer stoken2 = new StringTokenizer(actualString,",");
//		StringTokenizer stoken1 = new StringTokenizer(bean_value[x],",");
		final int count_code1		=	stoken2.countTokens();
		grp_exp_id = stoken2.nextToken();

		//out.println("<script>alert('stoken2:::::"+stoken2+"')</script>");
		//out.println("<script>alert('count_code1:::::"+count_code1+"')</script>");
		//out.println("<script>alert('grp_exp_id:::::"+grp_exp_id+"')</script>");

		if(grp_exception_id.equals(grp_exp_id))
		{
			privilege_value1 = "";privilege_value2 = "A";privilege_value3 = "A";
			privilege_value4 = "A";privilege_value5 = "A";privilege_value6 = "A";privilege_value7 = "A";
			privilege_value8 = "A";privilege_value9="A";	ascc1 = "N";ascc2 = "N";ascc3 = "N";ascc4 = "N";ascc5 = "N"; ascc6="N"; ascc7 = "N";ascc8 = "N";ascc9= "N";flag =true;
			
			bean_privilege_value = new String[count_code1];	
			bean_privilege_value[0] = grp_exp_id;
			int m = 1;
			while(stoken2.hasMoreTokens())
			{
				bean_privilege_value[m]  = stoken2.nextToken();
				privilege_value_curr = bean_privilege_value[1] ;
				m++;
			}
			//modified by Kavitha.K 20.12.2004
			for(int h=2;h<bean_privilege_value.length;h++){
			if(bean_privilege_value[h].equalsIgnoreCase("O")) {
				if((request.getParameter("O")).equals("Y"))
					{ 
					privilege_value1 = "checked"; 
					ascc1 = "Y";
					}
				}
			if(bean_privilege_value[h].equalsIgnoreCase("V")) {
				//privilege_id2 = "selected"; 
				privilege_value2=request.getParameter("V"); 
				ascc2 = "Y"; }
			if(bean_privilege_value[h].equalsIgnoreCase("C")) {
				//privilege_id3 = "selected"; 
				privilege_value3=request.getParameter("include");
				ascc3 = "Y"; }
			if(bean_privilege_value[h].equalsIgnoreCase("A")) {
				//privilege_id4 = "selected";
				privilege_value4=request.getParameter("include"); 
				ascc4 = "Y"; }
			if(bean_privilege_value[h].equalsIgnoreCase("U")) {
				//privilege_id5 = "selected";
				privilege_value5=request.getParameter("include");
				ascc5 = "Y"; }
			if(bean_privilege_value[h].equalsIgnoreCase("S")) {
				//privilege_id6 = "selected"; 
				privilege_value6=request.getParameter("include");
				ascc6 = "Y"; }
			if(bean_privilege_value[h].equalsIgnoreCase("P")) {
				//privilege_id7 = "selected"; 
				privilege_value7=request.getParameter("include");
				ascc7 = "Y"; }
			if(bean_privilege_value[h].equalsIgnoreCase("H")) {
				//privilege_id8 = "selected";
				privilege_value8=request.getParameter("include");
				ascc8 = "Y"; }
			if(bean_privilege_value[h].equalsIgnoreCase("D")) {
				//privilege_id9 = "selected";
				privilege_value9=request.getParameter("include");
				ascc9 = "Y"; }
			}	//end of modified by Kavitha.K 20.12.2004	

		}
		
		
	}if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )) 
	{
		if(!grp_id.equals("")){

  			String flag_value=privilege.getFlagValue();

			//out.println("<script>alert('flag_value:::::"+flag_value+"')</script>");

			if(flag_value!=""){
				StringTokenizer s = new StringTokenizer(flag_value,"~");
				final int fv		=	s.countTokens();
				String fg_value[] = null;
				fg_value = new String[fv];
				int a = 0;
				while(s.hasMoreTokens()){
					fg_value[a]	=	s.nextToken();
					a++;
				}
				if(fg_value.length > 1)
				{
					//first_time=1;
					//if(fg_value.length >= 2){
						for(int b=0;b<fg_value.length;b++)
						{	
							String val=fg_value[b];
							int v=Integer.parseInt(val);
							//for(int c=b+1;c<fg_value.length;c++){
								if(noOfRecords == v)//modified by Kavitha.K 1/10/2005
									first_time = 1 ;
								//else
								//{first_time = 0 ;}
							//}
							
						}		
					//}


				}
			}
			//out.println("<script>alert('first_time::::"+first_time+", i::"+i+",flag :::"+flag +"');</script>");
			if(flag == false && count_code > 0 && first_time == 1){
				privilege_value1 = "";privilege_value2 = "A";privilege_value3 = "A";
				privilege_value4 = "A";privilege_value5 = "A";privilege_value6 = "A";privilege_value7 = "A";
				privilege_value8 = "A";privilege_value9="A";
				ascc1 = "N";ascc2 = "N";ascc3 = "N";ascc4 = "N";ascc5 = "N"; ascc6="N"; ascc7 = "N";ascc8 = "N";ascc9= "N";//privilege_value_curr="";
			}else{flag = false;}

		}
		grp_id="";
	}	

}*/
//end of removed by Kavitha.K 1/19/2005


//out.println("privilege Value   "  + privilege_value_curr);
//out.println("Ascc " + ascc);

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(grp_exception_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(grp_exception_name));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);

//	privilege_value_curr = "";
	
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
 /*onChange="return parent.parent.assignPrivilege(this)" */ 
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(eHISFormatter.select(privilege_value+i,"A")));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(eHISFormatter.select(privilege_value_curr,"A")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(eHISFormatter.select(privilege_value_curr,"X")));
            _bw.write(_wl_block33Bytes, _wl_block33);
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf((privilege_value_curr).trim()));
            _bw.write(_wl_block37Bytes, _wl_block37);
//=classValue
            _bw.write(_wl_block38Bytes, _wl_block38);
//=i
            _bw.write(_wl_block39Bytes, _wl_block39);
//=i
            _bw.write(_wl_block40Bytes, _wl_block40);
//= ascc 
            _bw.write(_wl_block41Bytes, _wl_block41);
//=eHISFormatter.ChkBoxChecked("y",ascc)
            _bw.write(_wl_block42Bytes, _wl_block42);

		int j=1; 

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf( privilege_value1 ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(ascc1));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j++));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j++));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(ascc1.trim()));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block51Bytes, _wl_block51);
if((privilege_value2).equals("A"))out.println("selected");
            _bw.write(_wl_block52Bytes, _wl_block52);
if((privilege_value2).equals("S"))out.println("selected");
            _bw.write(_wl_block53Bytes, _wl_block53);
if((privilege_value2).equals("M"))out.println("selected");
            _bw.write(_wl_block54Bytes, _wl_block54);
if((privilege_value2).equals("N"))out.println("selected");
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j++));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j++));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(ascc2.trim()));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block57Bytes, _wl_block57);
if((privilege_value3).equals("A"))out.println("selected");
            _bw.write(_wl_block52Bytes, _wl_block52);
if((privilege_value3).equals("S"))out.println("selected");
            _bw.write(_wl_block53Bytes, _wl_block53);
if((privilege_value3).equals("M"))out.println("selected");
            _bw.write(_wl_block54Bytes, _wl_block54);
if((privilege_value3).equals("N"))out.println("selected");
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j++));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j++));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(ascc3.trim()));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block51Bytes, _wl_block51);
if((privilege_value4).equals("A"))out.println("selected");
            _bw.write(_wl_block52Bytes, _wl_block52);
if((privilege_value4).equals("S"))out.println("selected");
            _bw.write(_wl_block53Bytes, _wl_block53);
if((privilege_value4).equals("M"))out.println("selected");
            _bw.write(_wl_block54Bytes, _wl_block54);
if((privilege_value4).equals("N"))out.println("selected");
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j++));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j++));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(ascc4.trim()));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block51Bytes, _wl_block51);
if((privilege_value5).equals("A"))out.println("selected");
            _bw.write(_wl_block52Bytes, _wl_block52);
if((privilege_value5).equals("S"))out.println("selected");
            _bw.write(_wl_block53Bytes, _wl_block53);
if((privilege_value5).equals("M"))out.println("selected");
            _bw.write(_wl_block54Bytes, _wl_block54);
if((privilege_value5).equals("N"))out.println("selected");
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j++));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j++));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(ascc5.trim()));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block51Bytes, _wl_block51);
if((privilege_value6).equals("A"))out.println("selected");
            _bw.write(_wl_block52Bytes, _wl_block52);
if((privilege_value6).equals("S"))out.println("selected");
            _bw.write(_wl_block53Bytes, _wl_block53);
if((privilege_value6).equals("M"))out.println("selected");
            _bw.write(_wl_block54Bytes, _wl_block54);
if((privilege_value6).equals("N"))out.println("selected");
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j++));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j++));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(ascc6.trim()));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block51Bytes, _wl_block51);
if((privilege_value7).equals("A"))out.println("selected");
            _bw.write(_wl_block52Bytes, _wl_block52);
if((privilege_value7).equals("S"))out.println("selected");
            _bw.write(_wl_block53Bytes, _wl_block53);
if((privilege_value7).equals("M"))out.println("selected");
            _bw.write(_wl_block54Bytes, _wl_block54);
if((privilege_value7).equals("N"))out.println("selected");
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j++));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j++));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(ascc7.trim()));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block51Bytes, _wl_block51);
if((privilege_value8).equals("A"))out.println("selected");
            _bw.write(_wl_block52Bytes, _wl_block52);
if((privilege_value8).equals("S"))out.println("selected");
            _bw.write(_wl_block53Bytes, _wl_block53);
if((privilege_value8).equals("M"))out.println("selected");
            _bw.write(_wl_block54Bytes, _wl_block54);
if((privilege_value8).equals("N"))out.println("selected");
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j++));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j++));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf( ascc8.trim()));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j));
            _bw.write(_wl_block51Bytes, _wl_block51);
if((privilege_value9).equals("A"))out.println("selected");
            _bw.write(_wl_block52Bytes, _wl_block52);
if((privilege_value9).equals("S"))out.println("selected");
            _bw.write(_wl_block53Bytes, _wl_block53);
if((privilege_value9).equals("M"))out.println("selected");
            _bw.write(_wl_block54Bytes, _wl_block54);
if((privilege_value9).equals("N"))out.println("selected");
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j++));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            out.print( String.valueOf(j++));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(ascc9.trim()));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);

	/*
	privilege_id1 = "";
	
	privilege_id2 = "";
	privilege_id3 = "";
	privilege_id4 = "";
	privilege_id5 = "";
	privilege_id6 = "";
	privilege_id7 = "";
	privilege_id8 = "";
	privilege_id9 = "";*/
	//modified by Kavitha.K 21.12.2004
	privilege_value1="";//modified by Kavitha.K 06.01.2005
	privilege_value2="A";
	privilege_value3="A";
	privilege_value4="A";
	privilege_value5="A";
	privilege_value6="A";
	privilege_value7="A";
	privilege_value8="A";
	privilege_value9="A";
	privilege_value_curr = "";
	ascc1 = "N";
	ascc2 = "N";
	ascc3 = "N";
	ascc4 = "N";
	ascc5 = "N";
	ascc6 = "N";
	ascc7 = "N";
	ascc8 = "N";
	ascc9 = "N";
	//end of modified by Kavitha.K 21.12.2004
}//for
}else{
	
            _bw.write(_wl_block68Bytes, _wl_block68);
}
            _bw.write(_wl_block69Bytes, _wl_block69);
//out.println("<script>alert('values:::::"+values+"')</script>");
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(values));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(nextPrevFlag));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(noOfRecords));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(fm_disp));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(to_disp));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(privilege.getFunctionId()));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(privilege_ctx_id));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf( privilege_ctx ));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf( privilege_id ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf( privilege_value ));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf( facility_id ));
            _bw.write(_wl_block85Bytes, _wl_block85);
 putObjectInBean(bean_id,privilege,request);}catch(Exception e){
	System.out.println("here" + e.getMessage());

}
            _bw.write(_wl_block86Bytes, _wl_block86);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.GroupIdentifier.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Privilege.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Order.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Amend.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Authorization.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Cosign.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SpecialApproval.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.HoldResume.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Discontinue.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }
}
