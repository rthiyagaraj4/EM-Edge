package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.*;
import java.sql.*;
import eBL.*;
import eBL.Common.*;
import java.io.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;
import java.text.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __blpakdefquery extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLPakDefQuery.jsp", 1709114560400L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script language=\"javascript\" src=\"../../eBL/js/PkgDef.js\"></script>\n\t<script language=\"javascript\" src=\"../../eBL/js/pkgActiveDis.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\n<form name=\'cust_discount_dtl\' id=\'cust_discount_dtl\'  target=\'messageFrame\' >\t\n<table width=\'100%\' id=\"cust_discount_tbl\">\n\t<tr>\n\t\t<td></td><td></td><td></td><td></td><td></td><td></td><td></td>\t\t\t\t\t\t\n\t\t<td>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t</td>\t\t\t\t\t\t\n\t</tr>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<tr>\n<td width=\'15%\' nowrap >\n\t<input type=\'text\' name=\'cust_grp_code";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' id=\'cust_grp_code";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" size=\'10\' ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" >\n\t<input type=\'text\' name = \'cust_grp_desc";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" size=\'10\' maxlength=\'10\' ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="  value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t<INPUT type=\'hidden\' name=\'cust_grp_code_temp";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' id=\'cust_grp_code_temp";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t<INPUT type=\'hidden\' name=\'cust_grp_desc_temp";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' id=\'cust_grp_desc_temp";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'><!-- 28-08-2020-->\n</td>\n\n<td width=\'15%\' nowrap>\t\t\n\t<input type=\'text\' name=\'cust_code";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' id=\'cust_code";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' size=\'10\' ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" >\n\t<input type=\'text\' name = \'cust_desc";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" >\n\t<INPUT type=\'hidden\' name=\'cust_code_temp";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' id=\'cust_code_temp";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t<INPUT type=\'hidden\' name=\'cust_code_temp";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n</td>\n\n<td  width=\'15%\' nowrap>\t\t\n\t<input type=\'text\' name=\'poly_code";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' id=\'poly_code";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" >\n\t<input type=\'text\' name = \'poly_desc";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t<INPUT type=\'hidden\' name=\'poly_code_temp";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' id=\'poly_code_temp";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t<INPUT type=\'hidden\' name=\'poly_code_temp";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n</td>\n\n<td width=\'15%\' nowrap>\n\t<input type=\'text\' name=\'blng_class_code";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' id=\'blng_class_code";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" \">\n\t<input type=\'text\' name = \'blng_class_desc";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t<INPUT type=\'hidden\' name=\'blng_class_code_temp";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' id=\'blng_class_code_temp";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t<INPUT type=\'hidden\' name=\'blng_class_desc_temp";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' id=\'blng_class_desc_temp";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\n</td>\n\n<td width=\'15%\' nowrap>\t\t\n\t<input type=\'text\' name=\'pkg_code";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' id=\'pkg_code";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" >\n\t<input type=\'text\' name = \'pkg_desc";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t<INPUT type=\'hidden\' name=\'pkg_code_temp";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' id=\'pkg_code_temp";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t<INPUT type=\'hidden\' name=\'pkg_desc_temp";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' id=\'pkg_desc_temp";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n</td>\n<!-- 20/8/2020 START-->\n<td  class=\'fields\'   witdh=\'6%\' nowrap>\n\t<input type=\'text\' name=\'eff_from_date";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' id=\'eff_from_date";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'\t ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" id=\'eff_from_date";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =" size=\'10\' maxlength=\"10\"  value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\"   onBlur=\"validateDiscountDate(this,this,eff_to_date";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =",\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\');\"><img id = \'eff_from_date_img_";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' name=\"eff_from_date_img_";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="   src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'eff_from_date";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\');\"  />\n</td>\n\n<td  class=\'fields\'   witdh=\'6%\' nowrap>\n\t<input type=\'text\' name=\'eff_to_date";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' id=\'eff_to_date";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'  ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =" id=\'eff_to_date";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' size=\'10\' maxlength=\"10\"  value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =" onBlur=\"validateDiscountDate(this,eff_from_date";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =",this,\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\');\" ><img id = \'eff_to_Date_img_";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' name=\"eff_to_Date_img_";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\"\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\tsrc=\"../../eCommon/images/CommonCalendar.gif\" ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =" onClick=\"return showCalendar(\'eff_to_date";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\');\" >\n</td>\n<!-- 20/8/2020 END-->\n\n<td  class=\'fields\'   witdh=\'6%\' nowrap>\n\t<select name=\'discount_type";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' id=\'discount_type";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' onChange=\"chkDisountType(this,\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\')\" ";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =" >\n\t<option value=\'R\' ";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =">\n\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t</option>\n\t<option value=\'A\' ";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 =">";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</option>\n</select>\n</td>\n\n<td  witdh=\'7%\' nowrap>\n\t<input type=\'text\' name=\'discount";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' id=\'discount";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'   size=\'5\'  ";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =" onBlur=\'chkDiscountAmt(this,\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\");\'  onKeyPress=\'return ChkNumberInput(this,event,\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\");\' value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\"/>\n</td>\n</tr>\n";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n</table>\n</tr>\n</table>\n<INPUT TYPE=\"hidden\" name=\'mode\' id=\'mode\' value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );
	
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


	private String checkForNull(String inputString) {
			return (inputString == null) ? "" : inputString;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8"); 
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
 
	
	Connection conn		= null;		
	PreparedStatement pstmt 	= null;
	ResultSet rs 		= null;		
	String sqlStr="";
	String facilityId = (String) session.getValue( "facility_id" ) ;
	String language_id = (String) session.getValue("LOCALE");
	String loginuser 	= (String) session.getValue( "login_user" ) ;
    	int start=0;
	int end=0;
	int i=1;
	String endOfRes="1";
	int count=0;
	boolean flage=true;
	int noofdecimal  = 0;
	String from 			= request.getParameter("from") ; 
	String to 				= request.getParameter("to") ;
	//String mode				= request.getParameter("mode") == null ? "" : request.getParameter("mode");
	  // ADDED AGAINST THE INC ON:73403 MMS-QH-128.1
	String mode				= "modify";
	
	int totalRecords=1;	
	String packageCode		=	"" ;
	//String blngGrpCode		=	"" ;
	String custCode			=	"" ;
	String ppGrpCode		=	"" ;
	String eff_from_date	=	"" ;
	String 	eff_to_date		="";//20/8/2020
	String 	blng_class_code	="";	// 20/8/2020
	String 	cust_grp_code	="";//23/09/2020
    	//ADDED AGAINST THE INC ON:73403 MMS-QH-128.1
	cust_grp_code		=	request.getParameter("custGrpCode") == null ? "" :request.getParameter("custGrpCode") ;
	packageCode		=	request.getParameter("packageCode") == null ? "" :request.getParameter("packageCode") ;
	blng_class_code		=	request.getParameter("blng_class_code") == null ? "" :request.getParameter("blng_class_code") ; // 20/8/2020
	custCode		=	request.getParameter("custCode") == null ? "" :request.getParameter("custCode") ;
	ppGrpCode		=	request.getParameter("ppGrpCode") == null ? "" :request.getParameter("ppGrpCode") ;
	eff_from_date	=	request.getParameter("eff_from_date") == null ? "" :request.getParameter("eff_from_date") ;// 20/8/2020
	eff_to_date	=	request.getParameter("eff_to_date") == null ? "" :request.getParameter("eff_to_date") ;//20/8/2020
	
	String age_group_code ="";
	String specialty_code ="";
	String hdn_age_group ="";
	String specialty_desc ="";
	String[] record;
	
	String 	cust_grp_desc	="";
	String 	cust_code		="";
	String 	cust_desc		="";
	String 	blng_class_desc	="";
	
	String 	discount_type	="";
	String 	discount		="";
	String  poly_code        ="";
	String  poly_desc        =""; 
	String  pkg_code        ="";
	String  pkg_desc        =""; 
	Connection con = null;
	
	HttpSession httpSession = request.getSession(false);
	String facility_id =  (String)httpSession.getValue("facility_id");
	if(facility_id == null) facility_id="";
	String modifyStatus = "";//73392
	//String authorized =request.getParameter("authorized")== null ? "N" : request.getParameter("authorized");//73392
	//String pkgApprovedYN =request.getParameter("pkgApprovedYN")== null ? "N" : request.getParameter("pkgApprovedYN");//73392
	//if(mode.equals("modify") && authorized.equals("N")&& pkgApprovedYN.equals("Y"))//73392
	modifyStatus = " disabled ";

	if ( from == null )
            start = 1 ;
        else
            start = Integer.parseInt( from ) ;

        if ( to == null )
            end = 16 ;
        else
            end = Integer.parseInt( to ) ;
        try{
	//28-08-2020 start
		conn = ConnectionManager.getConnection(request);
	if(cust_grp_code.equals("") || cust_grp_code.equals("null"))
	{
		sqlStr=" SELECT  a.package_code,a.cust_group_code cust_grp_code,DECODE (a.cust_group_code, '**', 'All Groups', c.short_desc ) cust_grp_desc, a.cust_code cust_code,DECODE (a.cust_code, '**', 'All Customers', b.short_name) cust_desc, a.blng_class_code blng_class_code, DECODE (a.blng_class_code, '**', 'All Billing Classes', d.short_desc ) blng_class_desc,a.age_group, a.speciality_code,TO_CHAR (a.eff_from_date, 'dd/mm/yyyy') eff_from_date,TO_CHAR (a.eff_to_date, 'dd/mm/yyyy') eff_to_date,a.discount_type discount_type, a.discount discount,DECODE (a.age_group,'**', 'All Age Group',e.short_desc) age_group_desc,DECODE (a.speciality_code,'**', 'All Specialty',f.short_desc ) speciality_desc,g.package_code package_code, g.short_desc package_short_desc,a.policy_type_code policy_type_code,DECODE (a.policy_type_code,'**', 'All Policies',h.short_desc) policy_short_desc FROM bl_package_cust_discount a,ar_customer_lang_vw b,ar_cust_group_lang_vw c,bl_blng_class_lang_vw d, bl_age_group e,am_speciality f,bl_package g,bl_ins_policy_types h WHERE a.package_code = DECODE (?, '**', a.package_code, ?) AND a.operating_facility_id = ?  and a.cust_code = DECODE (?, '**', a.cust_code, ?) AND a.policy_type_code = DECODE (?, '**', a.policy_type_code, ?) AND a.blng_class_code = DECODE (?, '**', a.blng_class_code,?) AND ( ( a.eff_to_date IS NULL AND ? IS NULL AND a.eff_from_date >= TO_DATE (?, 'dd/mm/yyyy'))OR ( a.eff_to_date IS NOT NULL AND a.eff_from_date >= TO_DATE (?, 'dd/mm/yyyy') AND( ( ? IS NOT NULL AND a.eff_to_date <= TO_DATE (?, 'dd/mm/yyyy')) OR (? IS NULL AND a.eff_to_date >= TO_DATE (NVL (?, SYSDATE), 'dd/mm/yyyy')))  )) and   a.cust_group_code = c.cust_group_code(+) AND a.cust_code = b.cust_code(+) AND a.blng_class_code = d.blng_class_code(+) AND b.language_id(+) = ? AND c.language_id(+) =? AND d.language_id(+) = ? AND a.age_group = e.age_group_code(+) AND a.speciality_code = f.speciality_code(+) AND a.package_code = g.package_code AND h.operating_facility_id(+) = a.operating_facility_id AND h.policy_type_code(+) = a.policy_type_code";
		pstmt=conn.prepareStatement(sqlStr);	
		pstmt.setString(1,packageCode);			
		pstmt.setString(2,packageCode);
		pstmt.setString(3,facility_id);     // ADDED AGAINST THE INC ON:73403 MMS-QH-128.1	
		pstmt.setString(4,custCode);    // ADDED AGAINST THE INC ON:73403 MMS-QH-128.1	
		pstmt.setString(5,custCode); 
		pstmt.setString(6,ppGrpCode);   // ADDED AGAINST THE INC ON:73403 MMS-QH-128.1	
		pstmt.setString(7,ppGrpCode);
		pstmt.setString(8,blng_class_code);
		pstmt.setString(9,blng_class_code);
		pstmt.setString(10,eff_to_date);
		pstmt.setString(11,eff_from_date);
		pstmt.setString(12,eff_from_date);
		pstmt.setString(13,eff_to_date);
		pstmt.setString(14,eff_to_date);		
		pstmt.setString(15,eff_to_date);	
		pstmt.setString(16,eff_to_date);
		pstmt.setString(17,language_id);
		pstmt.setString(18,language_id);		
		pstmt.setString(19,language_id);
		rs= pstmt.executeQuery();
	}
	else{
		
			sqlStr="SELECT  a.package_code,a.cust_group_code cust_grp_code,DECODE (a.cust_group_code, '**', 'All Groups', c.short_desc ) cust_grp_desc, a.cust_code cust_code,DECODE (a.cust_code, '**', 'All Customers', b.short_name) cust_desc, a.blng_class_code blng_class_code, DECODE (a.blng_class_code, '**', 'All Billing Classes', d.short_desc ) blng_class_desc,a.age_group, a.speciality_code,TO_CHAR (a.eff_from_date, 'dd/mm/yyyy') eff_from_date,TO_CHAR (a.eff_to_date, 'dd/mm/yyyy') eff_to_date,a.discount_type discount_type, a.discount discount,DECODE (a.age_group,'**', 'All Age Group',e.short_desc) age_group_desc,DECODE (a.speciality_code,'**', 'All Specialty',f.short_desc ) speciality_desc,g.package_code package_code, g.short_desc package_short_desc,a.policy_type_code policy_type_code,DECODE (a.policy_type_code,'**', 'All Policies',h.short_desc) policy_short_desc FROM bl_package_cust_discount a,ar_customer_lang_vw b,ar_cust_group_lang_vw c,bl_blng_class_lang_vw d, bl_age_group e,am_speciality f,bl_package g,bl_ins_policy_types h WHERE a.package_code = DECODE (?, '**', a.package_code, ?) AND a.operating_facility_id = ? AND a.cust_group_code = ? and a.cust_code = DECODE (?, '**', a.cust_code, ?) AND a.policy_type_code = DECODE (?, '**', a.policy_type_code, ?) AND a.blng_class_code = DECODE (?, '**', a.blng_class_code,?) AND ( ( a.eff_to_date IS NULL AND ? IS NULL AND a.eff_from_date >= TO_DATE (?, 'dd/mm/yyyy'))OR ( a.eff_to_date IS NOT NULL AND a.eff_from_date >= TO_DATE (?, 'dd/mm/yyyy') AND( ( ? IS NOT NULL AND a.eff_to_date <= TO_DATE (?, 'dd/mm/yyyy')) OR (? IS NULL AND a.eff_to_date >= TO_DATE (NVL (?, SYSDATE), 'dd/mm/yyyy')))  )) and   a.cust_group_code = c.cust_group_code(+) AND a.cust_code = b.cust_code(+) AND a.blng_class_code = d.blng_class_code(+) AND b.language_id(+) = ? AND c.language_id(+) =? AND d.language_id(+) = ? AND a.age_group = e.age_group_code(+) AND a.speciality_code = f.speciality_code(+) AND a.package_code = g.package_code AND h.operating_facility_id(+) = a.operating_facility_id AND h.policy_type_code(+) = a.policy_type_code"; 
		pstmt=conn.prepareStatement(sqlStr);	
		pstmt.setString(1,packageCode);			
		pstmt.setString(2,packageCode);
		pstmt.setString(3,facility_id);     // ADDED AGAINST THE INC ON:73403 MMS-QH-128.1	
		pstmt.setString(4,cust_grp_code);
		pstmt.setString(5,custCode);    // ADDED AGAINST THE INC ON:73403 MMS-QH-128.1	
		pstmt.setString(6,custCode); 
		pstmt.setString(7,ppGrpCode);   // ADDED AGAINST THE INC ON:73403 MMS-QH-128.1	
		pstmt.setString(8,ppGrpCode);
		pstmt.setString(9,blng_class_code);
		pstmt.setString(10,blng_class_code);
		pstmt.setString(11,eff_to_date);
		pstmt.setString(12,eff_from_date);
		pstmt.setString(13,eff_from_date);
		pstmt.setString(14,eff_to_date);
		pstmt.setString(15,eff_to_date);		
		pstmt.setString(16,eff_to_date);	
		pstmt.setString(17,eff_to_date);
		pstmt.setString(18,language_id);
		pstmt.setString(19,language_id);		
		pstmt.setString(20,language_id);
		rs= pstmt.executeQuery();
	}

	/*	pstmt=conn.prepareStatement(sqlStr);	
		pstmt.setString(1,packageCode);			
		pstmt.setString(2,packageCode);
		pstmt.setString(3,facility_id);     // ADDED AGAINST THE INC ON:73403 MMS-QH-128.1	
		pstmt.setString(4,custCode);    // ADDED AGAINST THE INC ON:73403 MMS-QH-128.1	
		pstmt.setString(5,custCode); 
		pstmt.setString(6,ppGrpCode);   // ADDED AGAINST THE INC ON:73403 MMS-QH-128.1	
		pstmt.setString(7,ppGrpCode);
		pstmt.setString(8,blng_class_code);
		pstmt.setString(9,blng_class_code);
		pstmt.setString(10,eff_to_date);
		pstmt.setString(11,eff_from_date);
		pstmt.setString(12,eff_from_date);
		pstmt.setString(13,eff_to_date);
		pstmt.setString(14,eff_to_date);		
		pstmt.setString(15,eff_to_date);	
		pstmt.setString(16,eff_to_date);
		pstmt.setString(17,language_id);
		pstmt.setString(18,language_id);		
		pstmt.setString(19,language_id);
		rs= pstmt.executeQuery();
*/
		// 28-08-2020  end
		while(rs.next())
		{
			count=rs.getRow();
		}

		rs= pstmt.executeQuery();
		if(count<end)
		{
			flage=false;	
		}

if ( !(start== 1) )
{	
	for( int j=1; j<=start; i++,j++ )   
		rs.next() ;  
}
	int cnt=0;
	i=1;
	 try {	
		
            _bw.write(_wl_block9Bytes, _wl_block9);

	if(cnt==0)
	{		
		if ( !(start <= i) )
		{
			out.println("<A HREF='../../eBL/jsp/BLPakDefQuery.jsp?from="+(start-16)+"&to="+(end-16)+"&packageCode="+packageCode+"&facility_id="+facility_id+"&custCode="+custCode+"&ppGrpCode="+ppGrpCode+"&blng_class_code="+blng_class_code+"&language_id="+language_id+"&language_id="+language_id+"&language_id="+language_id+"&eff_from_date="+eff_from_date+"&eff_to_date="+eff_to_date+"&cust_grp_code="+cust_grp_code+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
		}						
		if (endOfRes.equals("1") && count > end )
		{
			out.println("<A id='nextval' HREF='../../eBL/jsp/BLPakDefQuery.jsp?from="+(start+16)+"&to="+(end+16)+"&packageCode="+packageCode+"&facility_id="+facility_id+"&custCode="+custCode+"&ppGrpCode="+ppGrpCode+"&blng_class_code="+blng_class_code+"&language_id="+language_id+"&language_id="+language_id+"&language_id="+language_id+"&eff_from_date="+eff_from_date+"&eff_to_date="+eff_to_date+"&cust_grp_code="+cust_grp_code+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		}
	}					
	
            _bw.write(_wl_block10Bytes, _wl_block10);
 
	while( i<=end && rs.next() )		
	{	
		record=new String[14];
		record[0]=checkForNull(rs.getString("cust_grp_code"));
		record[1]=checkForNull(rs.getString("cust_grp_desc"));
		record[2]=checkForNull(rs.getString("cust_code"));
		record[3]=checkForNull(rs.getString("cust_desc"));
		record[4]=checkForNull(rs.getString("blng_class_code"));
		record[5]=checkForNull(rs.getString("blng_class_desc"));
		record[6]=checkForNull(rs.getString("eff_from_date"));				
		record[7]=checkForNull(rs.getString("eff_to_date"));				
		record[8]=checkForNull(rs.getString("discount_type"));				
		record[9]=checkForNull(rs.getString("discount"));	
		record[10]=checkForNull(rs.getString("policy_type_code"));
		record[11]=checkForNull(rs.getString("policy_short_desc"));
		record[12]=checkForNull(rs.getString("package_code"));
		record[13]=checkForNull(rs.getString("package_short_desc"));
		
		cust_grp_code	= record[0];
		cust_grp_desc	= record[1];
		cust_code		= record[2];
		cust_desc		= record[3];
		blng_class_code	= record[4];
		blng_class_desc	= record[5];
		eff_from_date	= record[6];
		eff_to_date		= record[7];
		discount_type	= record[8];
		discount		= record[9];	
		poly_code       = record[10];
		poly_desc       = record[11]; 
		pkg_code       = record[12];
		pkg_desc       = record[13];
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(i));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(cust_grp_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((mode.equals("modify") && !cust_grp_code.equals(""))?"readonly":""));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((mode.equals("modify") && !cust_grp_desc.equals(""))?"readonly":""));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(cust_grp_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(cust_grp_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(cust_grp_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(cust_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf((mode.equals("modify") && !cust_code.equals(""))?"readonly":""));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(cust_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((mode.equals("modify") && !cust_desc.equals(""))?"readonly":""));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(cust_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(cust_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(poly_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf((mode.equals("modify") && !poly_code.equals(""))?"readonly":""));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((mode.equals("modify") && !poly_desc.equals(""))?"readonly":""));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(poly_desc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(poly_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(poly_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(blng_class_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((mode.equals("modify") && !blng_class_code.equals(""))?"readonly":""));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((mode.equals("modify") && !blng_class_desc.equals(""))?"readonly":""));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(blng_class_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(blng_class_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(blng_class_desc));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(pkg_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf((mode.equals("modify") && !pkg_code.equals(""))?"readonly":""));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((mode.equals("modify") && !pkg_desc.equals(""))?"readonly":""));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(pkg_desc));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(pkg_code));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(pkg_desc));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((mode.equals("modify") && !eff_from_date.equals(""))?"readonly":""));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(eff_from_date));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf((mode.equals("modify") && !eff_from_date.equals(""))?"disabled":""));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(eff_to_date));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf((mode.equals("modify") && !eff_to_date.equals(""))?"readonly":""));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf((mode.equals("modify") && !eff_to_date.equals(""))?"disabled":""));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(discount_type.equals("R")?"selected":""));
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(discount_type.equals("A")?"selected":""));
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(modifyStatus));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(discount));
            _bw.write(_wl_block89Bytes, _wl_block89);

cnt++;
i++;
}	
   if (!rs.next() && cnt!=0 )
    {
	      endOfRes = "0";	
    } 
	}catch(Exception e){	
		e.printStackTrace();
	}
if(cnt==0)	
   out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
	}catch(Exception e)
	 {
	   e.printStackTrace();
	}   
   finally
   {
      try{	  
		  if(rs != null) rs.close();
		  if(pstmt != null) pstmt.close();	  
	  }catch(Exception e){
		  e.printStackTrace();
		}
		if(conn!=null) ConnectionManager.returnConnection(conn,request);
    }

            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block91Bytes, _wl_block91);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Percent.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.amount.label", java.lang.String .class,"key"));
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
}
