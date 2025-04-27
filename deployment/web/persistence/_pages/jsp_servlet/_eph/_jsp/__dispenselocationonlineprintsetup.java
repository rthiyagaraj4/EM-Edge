package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import ePH.*;
import ePH.Common.*;
import java.util.*;
import webbeans.eCommon.*;
import java.sql.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __dispenselocationonlineprintsetup extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DispenseLocationOnlinePrintSetup.jsp", 1723551100727L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/CommonLookup.js\"></SCRIPT>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n\t\t<!-- <SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/MstCodeCommon.js\"></SCRIPT> -->\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/FieldFormatMethods.js\"></SCRIPT>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/DispenseLocation.js\"></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<style>\n#table_container_right > table > tbody > tr > td\n{\nheight:19px;\n}\n</style>\n\n\t\t<title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title>\n\t</head>\n\n\t<body  OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n\t\t<FORM name=\"formDispenseOnlineSetup\" id=\"formDispenseOnlineSetup\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<input type = \'hidden\' name = \'h_select_all\' value = \'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\t\t\t<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"90%\" >\n\t\t\t\t<tr><td  CLASS=\"label\"> ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&nbsp;&nbsp;&nbsp;<select name=\"select_all\" id=\"select_all\" onchange=\"selectAll(this)\">\n\t\t\t\t<option value =\"NP\" ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</option>\n\t\t\t\t<option value =\"PT\" ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</option>\n\t\t\t\t<option value =\"PD\" ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</option>\n\t\t\t\t</TD>\n\t\t\t</TABLE>\n\n\t\t\t<div id=\'table_container_left\' style=\'overflow:hidden;width:320px;height:342px;position:relative;float:left;\'>\n\t\t\t\t<TABLE   BORDER=\"1\" CELLPADDING=\"0\" CELLSPACING=\"0\" ALIGN=\"LEFT\" >\n\t\t\t\t\t<TR style=\'position:relative\' ><TH  WIDTH = \"25%\">&nbsp;</TH></TR>\n\t\t\t\t\t<TR style=\'position:relative\' ><TH>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</TH></TR>\n\t\t\t\t\t<TR style=\'position:relative\' ><TH>&nbsp;</TH></TR>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t<tr style=\'height:21px;\'><td nowrap class=\'label\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" </td></tr>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\n\t\t\t\t</TABLE>\n\t\t\t</div>\n\t\t\t<div id=\'table_container_right\' style=\'overflow:scroll;height:450px;\'>\n\t\t\t\t<TABLE   BORDER=\"1\" CELLPADDING=\"0\" CELLSPACING=\"0\" ALIGN=\"LEFT\" >\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TH   COLSPAN=\"4\" >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</TH>\n\t\t\t\t\t\t<TH   COLSPAN=\"6\" >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</TH>\n\t\t\t\t\t\n\t\t\t\t\t</TR>\n\t\t\t\t\t<TR>\t\t\n\t\t\t\t\t\t<TH></TH>\n\t\t\t\t\t\t<TH></TH>\n\t\t\t\t\t\t<TH></TH>\n\t\t\t\t\t\t<TH></TH>\n\t\t\t\t\t\t<TH></TH>\n\t\t\t\t\t\t<TH colspan=\'2\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</TH>\n\t\t\t\t\t\t<TH colspan=\'2\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</TH>\n\t\t\t\t\t</TR>\n\t\t\t\t\t<TR>\t\t\t\n\t\t\t\t\t\t<TH nowrap>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</TH>\n\t\t\t\t\t\t<TH nowrap>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</TH>\n\t\t\t\t\t\t<TH nowrap>&nbsp;";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&nbsp;</TH>\n\t\t\t\t\t\t<TH nowrap>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</TH>\n\t\t\t\t\t</TR>\t\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t <input type =\'hidden\' name = \'report_id_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' value =\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" />\n\t\t\t\t\t <tr>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\t \n\t\t\t\t\t\t\t<td>&nbsp;</td>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t<td class=\'label\'>\n\t\t\t\t\t\t\t\t<SELECT name=\"op_alloc_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" id=\"op_alloc_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" onchange=\'checkList(this,\"OP_A\",\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\")\' ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="  >\n\t\t\t\t\t\t\t\t<option value =\"NP\" ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</option>\n\t\t\t\t\t\t\t\t<option value =\"PT\" ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</option>\n\t\t\t\t\t\t\t\t<option value =\"PD\" ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</option>\n\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t<td class=\'label\'>\n\t\t\t\t\t\t\t\t<SELECT name=\"op_fill_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" id=\"op_fill_";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" onchange=\'checkList(this,\"OP_F\",\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t<td class=\'label\'>\n\t\t\t\t\t\t\t\t<SELECT name=\"op_deliver_";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" id=\"op_deliver_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" onchange=\'checkList(this,\"OP_D\",\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t<td class=\'label\'>\n\t\t\t\t\t\t\t\t<SELECT name=\"op_allstages_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" id=\"op_allstages_";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" onchange=\'checkList(this,\"OP_AS\",\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t<td class=\'label\'>\n\t\t\t\t\t\t\t\t<SELECT name=\"ip_fill_fp_";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" id=\"ip_fill_fp_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" onchange=\'checkList(this,\"IP_FP\",\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t<td class=\'label\'>\n\t\t\t\t\t\t\t\t<SELECT name=\"ip_fill_with_fill_";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" id=\"ip_fill_with_fill_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" onchange=\'checkList(this,\"IP_AF\",\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t\t<td class=\'label\'>\n\t\t\t\t\t\t\t\t<SELECT name=\"ip_fill_without_fill_";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" id=\"ip_fill_without_fill_";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" onchange=\'checkList(this,\"IP_F\",\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t<td class=\'label\'>\n\t\t\t\t\t\t\t\t<SELECT name=\"ip_deliver_with_fill_";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" id=\"ip_deliver_with_fill_";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" onchange=\'checkList(this,\"IP_DF\",\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t\t<td class=\'label\'>\n\t\t\t\t\t\t\t\t<SELECT name=\"ip_deliver_without_fill_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" id=\"ip_deliver_without_fill_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" onchange=\'checkList(this,\"IP_D\",\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t</TR>\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t</TABLE>\n\t\t\t</div>\n\t\t\t<input type= \'hidden\' name=\"rows_count\" id=\"rows_count\" value =\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" />\n\t\t\t<div id=\'table_buttons\' style=\'height:40px;width:800px;\'>\n\t\t\t<table>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width =\"80%\"></td>\n\t\t\t\t\t<td class=\'button\' align=\'left\'>\n\t\t\t\t\t\t<input type=\'Button\' class=\'Button\'  value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'  onclick=\'setOnlineSetuptoBean(\"ok\");\' >\n\t\t\t\t\t</TD>\n\t\t\t\t\t<td class=\'button\' align=\'left\'>\n\t\t\t\t\t\t<input type=\'Button\' class=\'Button\'  value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'  onclick=\'setOnlineSetuptoBean(\"cancel\")\' >&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t</TD>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</div>\n\t\t\t<INPUT TYPE=\"hidden\" name=\"bean_id\" id=\"bean_id\" VALUE=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"bean_name\" id=\"bean_name\" VALUE=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8");
		//String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

			String	bean_id				= "DispenseLocationBean" ;
			String	bean_name			= "ePH.DispenseLocationBean";
			DispenseLocationBean bean	= (DispenseLocationBean)getBeanObject( bean_id, bean_name, request);

			String delivery_legend = request.getParameter("delivery_legend");
			String allocate_legend = request.getParameter("allocate_legend");
			String fill_legend = request.getParameter("fill_legend");
			String mode = request.getParameter("mode");
			String pharmacyType = request.getParameter("pharmacyType");
			String disp_locn_code = request.getParameter("disp_locn_code");


			String print  =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels");	
			String noPrint = 	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.NoPrint.label","ph_labels");	
			String printDefault =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PrintDefault.label","ph_labels");	
			//String label = "";
			//String classvalue = "";
			String select_all = "";
			String disableOPCategory ="";
			String disableIPCategory ="";
			String reoprtLabel ="";
			String str ="";
			//Adding start for MOHE-CRF-0069
			Connection con			= null; 
			con				= ConnectionManager.getConnection(request);
			boolean refill_site=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REFILL_LABEL");//added for MOHE-CRF-0069

			int count = 0;
			 HashMap printMap = bean.getOnlinePrintSetupMap(); 
			if (mode.equals("1")){
				if(printMap==null || printMap.size()==0){
					bean.setOnlinePrintDetails(bean.getLoggedInFacility(),disp_locn_code);	
				}
				 if (pharmacyType.equals("I")){
					 disableIPCategory = "";
					 disableOPCategory = "disabled";
				 }
				 else if (pharmacyType.equals("O")){
					disableIPCategory = "disabled";
					disableOPCategory = "";
				}
				else{
					disableOPCategory = "";
					disableIPCategory = "";
				}
			}
			else{

				if (bean.getDispLocnCategory().equals("I")){
					disableOPCategory = "disabled";
					disableIPCategory = "";
				}
				else if (bean.getDispLocnCategory().equals("O")){
					disableIPCategory = "disabled";
					disableOPCategory = "";
				}
				else{
					disableOPCategory = "";
					disableIPCategory = "";
				}
			}
			 select_all = bean.getSelectAll() ==  "" ? "PD" :  bean.getSelectAll();

			 Set keyset=printMap.keySet();
			 Object[] sorted_set = keyset.toArray();
			 Arrays.sort(sorted_set);

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(bean.getSelectAll()));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(select_all.equals("NP") ? "selected":"" ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(noPrint));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(select_all.equals("PT") ? "selected":"" ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(print));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(select_all.equals("PD") ? "selected":"" ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(printDefault));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

					for (int i=0;i<sorted_set.length;i++){		 
						str=sorted_set[i].toString();			
						if (str.equals("BMS_SHEET"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.BMS_SHEET.label","ph_labels");
						else if (str.equals("CERTIFICATE_REIMBURSEMENT"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.CERTIFICATE_REIMBURSEMENT.label","ph_labels");
						else if (str.equals("DISPENSE_SHEET"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DISPENSE_SHEET.label","ph_labels");
						else if (str.equals("DRUG_LABEL"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DRUG_LABEL.label","ph_labels");
						else if (str.equals("FILL_LIST_DRUGMEDICAL"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FILL_LIST_DRUGMEDICAL.label","ph_labels");
						else if (str.equals("FILL_LIST_PATIENT"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FILL_LIST_PATIENT","ph_labels");
						else if (str.equals("FILL_LIST_UNALLOCATED"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FILL_LIST_UNALLOCATED.label","ph_labels");			
						else if (str.equals("PHPRMEDPL")) //Added PHPRMEDPL For ML-BRU-CRF-072[Inc:29938]
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MedicationPlanSheet.label","ph_labels"); //Added PHPRMEDPL For ML-BRU-CRF-072[Inc:29938] 
						else if (str.equals("HOME_MEDICATION_SHEET"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.HOME_MEDICATION_SHEET.label","ph_labels");
						else if (str.equals("MANUFACTURING_LABEL"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MANUFACTURING_LABEL.label","ph_labels");
						else if (str.equals("MEDICAL_SUPPLY_LABEL"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MEDICAL_SUPPLY_LABEL.label","ph_labels");
						else if (str.equals("MEDICATION_LIST"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MEDICATION_LIST.label","ph_labels");	
						else if (str.equals("REFILL_MEDICATION_SHEET"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.RefillMedicationSheet.label","ph_labels");	
						else if (str.equals("TOKEN"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TOKEN.label","ph_labels");
						else if (str.equals("WORK_SHEET"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.WORK_SHEET.label","ph_labels");
						else if (str.equals("HOME_MED_SHEET_TAPER"))//Added for RUT-CRF-0061 - Start
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.HOME_MEDICATION_SHEET.label","ph_labels")+"(Taper Order)";
						else if (str.equals("HOME_MED_SHEET_PORTRAIT"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.HOME_MEDICATION_SHEET.label","ph_labels")+"(Portrait)";
						else if (str.equals("HOME_MED_SHEET_LANDSCAPE"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.HOME_MEDICATION_SHEET.label","ph_labels")+"(Landscape)";
						else if (str.equals("REFILL_MEDICATION_LABEL") && refill_site)//Added for MOHE-CRF-0069
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.RefillMedicationLabel.label","ph_labels");
						//HashMap rowDetails=(HashMap)printMap.get(str);

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(reoprtLabel));
            _bw.write(_wl_block18Bytes, _wl_block18);

					}

            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(fill_legend));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(delivery_legend));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(allocate_legend));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(fill_legend));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(delivery_legend));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

					for (int i=0;i<sorted_set.length;i++){
						 str=sorted_set[i].toString();			
						if (str.equals("BMS_SHEET"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.BMS_SHEET.label","ph_labels");
						else if (str.equals("CERTIFICATE_REIMBURSEMENT"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.CERTIFICATE_REIMBURSEMENT.label","ph_labels");
						else if (str.equals("DISPENSE_SHEET"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DISPENSE_SHEET.label","ph_labels");
						else if (str.equals("DRUG_LABEL"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DRUG_LABEL.label","ph_labels");
						else if (str.equals("FILL_LIST_DRUGMEDICAL"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FILL_LIST_DRUGMEDICAL.label","ph_labels");
						else if (str.equals("FILL_LIST_PATIENT"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FILL_LIST_PATIENT","ph_labels");
						else if (str.equals("FILL_LIST_UNALLOCATED"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FILL_LIST_UNALLOCATED.label","ph_labels");			
						else if (str.equals("PHPRMEDPL"))//Added PHPRMEDPL For ML-BRU-CRF-072[Inc:29938]
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MedicationPlanSheet.label","ph_labels");//Added PHPRMEDPL For ML-BRU-CRF-072[Inc:29938]
						else if (str.equals("HOME_MEDICATION_SHEET"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.HOME_MEDICATION_SHEET.label","ph_labels");
						else if (str.equals("MANUFACTURING_LABEL"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MANUFACTURING_LABEL.label","ph_labels");
						else if (str.equals("MEDICAL_SUPPLY_LABEL"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MEDICAL_SUPPLY_LABEL.label","ph_labels");
						else if (str.equals("MEDICATION_LIST"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MEDICATION_LIST.label","ph_labels");	
						else if (str.equals("REFILL_MEDICATION_SHEET"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.RefillMedicationSheet.label","ph_labels");	
						else if (str.equals("TOKEN"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.TOKEN.label","ph_labels");
						else if (str.equals("WORK_SHEET"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.WORK_SHEET.label","ph_labels");
						else if (str.equals("HOME_MED_SHEET_TAPER"))//Added for RUT-CRF-0061 - Start
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.HOME_MEDICATION_SHEET.label","ph_labels")+"(Taper Order)";
						else if (str.equals("HOME_MED_SHEET_PORTRAIT"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.HOME_MEDICATION_SHEET.label","ph_labels")+"(Portrait)";
						else if (str.equals("HOME_MED_SHEET_LANDSCAPE"))
							reoprtLabel = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.HOME_MEDICATION_SHEET.label","ph_labels")+"(Landscape)";//Added for RUT-CRF-0061 - End
						HashMap rowDetails=(HashMap)printMap.get(str);

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(count));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(str));
            _bw.write(_wl_block30Bytes, _wl_block30);

						if (rowDetails.get("OP_A")==null || rowDetails.get("OP_A").toString().equals("NR")){

            _bw.write(_wl_block31Bytes, _wl_block31);

						}
						else{

            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(count));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(count));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(str));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(disableOPCategory));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rowDetails.get("OP_A").toString().equals("NP")?"selected":"" ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(noPrint));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rowDetails.get("OP_A").toString().equals("PT")?"selected":"" ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(print));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rowDetails.get("OP_A").toString().equals("PD")?"selected":"" ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(printDefault));
            _bw.write(_wl_block39Bytes, _wl_block39);

						}
						if (rowDetails.get("OP_F")==null || rowDetails.get("OP_F").toString().equals("NR")){

            _bw.write(_wl_block31Bytes, _wl_block31);

						}
						else{

            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(count));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(count));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(str));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(disableOPCategory));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rowDetails.get("OP_F").toString().equals("NP")?"selected":"" ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(noPrint));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rowDetails.get("OP_F").toString().equals("PT")?"selected":"" ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(print));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rowDetails.get("OP_F").toString().equals("PD")?"selected":"" ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(printDefault));
            _bw.write(_wl_block39Bytes, _wl_block39);

						}
						if (rowDetails.get("OP_D")==null || rowDetails.get("OP_D").toString().equals("NR")){

            _bw.write(_wl_block31Bytes, _wl_block31);

						}
						else{

            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(count));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(str));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(disableOPCategory));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rowDetails.get("OP_D").toString().equals("NP")?"selected":"" ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(noPrint));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rowDetails.get("OP_D").toString().equals("PT")?"selected":"" ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(print));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rowDetails.get("OP_D").toString().equals("PD")?"selected":"" ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(printDefault));
            _bw.write(_wl_block39Bytes, _wl_block39);

						}
						if (rowDetails.get("OP_AS")==null || rowDetails.get("OP_AS").toString().equals("NR")){

            _bw.write(_wl_block31Bytes, _wl_block31);

						  }
						  else{

            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(count));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(count));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(str));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(disableOPCategory));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rowDetails.get("OP_AS").toString().equals("NP")?"selected":"" ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(noPrint));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rowDetails.get("OP_AS").toString().equals("PT")?"selected":"" ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(print));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rowDetails.get("OP_AS").toString().equals("PD")?"selected":"" ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(printDefault));
            _bw.write(_wl_block39Bytes, _wl_block39);

						}
						if (rowDetails.get("IP_FP")==null || rowDetails.get("IP_FP").toString().equals("NR")){

            _bw.write(_wl_block31Bytes, _wl_block31);

						}
						else{

            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(count));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(count));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(str));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(disableIPCategory));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rowDetails.get("IP_FP").toString().equals("NP")?"selected":"" ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(noPrint));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rowDetails.get("IP_FP").toString().equals("PT")?"selected":"" ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(print));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rowDetails.get("IP_FP").toString().equals("PD")?"selected":"" ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(printDefault));
            _bw.write(_wl_block39Bytes, _wl_block39);

						}
						if (rowDetails.get("IP_AF")==null || rowDetails.get("IP_AF").toString().equals("NR")){

            _bw.write(_wl_block31Bytes, _wl_block31);

						}
						else{

            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(count));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(count));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(str));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(disableIPCategory));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rowDetails.get("IP_AF").toString().equals("NP")?"selected":"" ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(noPrint));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rowDetails.get("IP_AF").toString().equals("PT")?"selected":"" ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(print));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rowDetails.get("IP_AF").toString().equals("PD")?"selected":"" ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(printDefault));
            _bw.write(_wl_block39Bytes, _wl_block39);

						}
						if (rowDetails.get("IP_F")==null || rowDetails.get("IP_F").toString().equals("NR")){

            _bw.write(_wl_block31Bytes, _wl_block31);

						}
						else{

            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(count));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(count));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(str));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(disableIPCategory));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rowDetails.get("IP_F").toString().equals("NP")?"selected":"" ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(noPrint));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rowDetails.get("IP_F").toString().equals("PT")?"selected":"" ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(print));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rowDetails.get("IP_F").toString().equals("PD")?"selected":"" ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(printDefault));
            _bw.write(_wl_block39Bytes, _wl_block39);

						}
						if (rowDetails.get("IP_DF")==null || rowDetails.get("IP_DF").toString().equals("NR")){

            _bw.write(_wl_block31Bytes, _wl_block31);

						}
						else{

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(count));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(count));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(str));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(disableIPCategory));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rowDetails.get("IP_DF").toString().equals("NP")?"selected":"" ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(noPrint));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rowDetails.get("IP_DF").toString().equals("PT")?"selected":"" ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(print));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rowDetails.get("IP_DF").toString().equals("PD")?"selected":"" ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(printDefault));
            _bw.write(_wl_block39Bytes, _wl_block39);

						}
						if (rowDetails.get("IP_D")==null || rowDetails.get("IP_D").toString().equals("NR")){

            _bw.write(_wl_block31Bytes, _wl_block31);

						}
						else{

            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(count));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(count));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(str));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(disableIPCategory));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rowDetails.get("IP_D").toString().equals("NP")?"selected":"" ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(noPrint));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rowDetails.get("IP_D").toString().equals("PT")?"selected":"" ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(print));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rowDetails.get("IP_D").toString().equals("PD")?"selected":"" ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(printDefault));
            _bw.write(_wl_block39Bytes, _wl_block39);

						}
						count++;

            _bw.write(_wl_block64Bytes, _wl_block64);

					}//for

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(count));
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf( bean_id ));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block70Bytes, _wl_block70);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OnlinePrintSetup.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.selectall.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PHOnlineReportName.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OPPatientClass.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.IPPatientClass.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllStages.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.RunIPFill.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.WithFillList.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.WithoutFillList.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.WithFillList.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.WithoutFillList.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ok.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }
}
