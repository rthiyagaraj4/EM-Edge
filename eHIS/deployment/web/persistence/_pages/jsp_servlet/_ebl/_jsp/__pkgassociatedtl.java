package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import eBL.*;
import eBL.Common.*;
import eCommon.Common.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __pkgassociatedtl extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/PkgAssociateDtl.jsp", 1737914463389L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n \n<html>\n<head>\n<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\t\t\n<script language=\"javascript\" src=\'../../eBL/js/PkgAssociate.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n\n</head>\n\n\n<script>\n$(document).ready(function()\n{\t\t\n\nvar siteSpec=$(\'#siteSpec\').val();\nvar total_records = $(\'#total_records\').val();\n\nif(siteSpec==\'true\')\n\t{\n\t/* alert(\'total_records \'+$(\'#total_records\').val()); */\n\t$(\'[id^=from_date]\').attr(\'disabled\',\'disabled\');\n\t\t\t$(\'[id^=fromDateimg_]\').attr(\'disabled\', \'disabled\');\n\tfor(i=0;i<=total_records;i++)\n\t{\n\tif($(\'#associated\'+i).is(\":checked\")==true)\n\t\t{\n\t\t$(\'#from_date\'+i).removeAttr(\'disabled\',\'disabled\');\n\t\t$(\'#fromDateimg_\'+i).removeAttr(\'disabled\',\'disabled\');\t\n\t\t}\n\t}\n\t}\n });\n\n\n</script>\n\n\n\n<style>\n\t\tthead td, thead td.locked\t{\n\t\tbackground-color: navy;\n\t\tcolor: white;\n\t\tposition:relative;}\t\n\t\tthead td {\n\t\ttop: expression(document.getElementById(\"tbl-container\").scrollTop-4); \n\t\tz-index: 20;}\n\t\tthead td.locked {z-index: 30;}\n\t\ttd.locked,  th.locked{\n\t\tleft: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);\n\t\tposition: relative;\n\t\tz-index: 10;}\n\t\ttd.locked,  th.locked{\n\t\tleft: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);\n\t\tposition: relative;\n\t\tz-index: 10;}\n\t\t</style>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\n\n\t<body onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onload=\"\" onSelect=\"codeArrestThruSelect();\" >\n\t<form name=\'PkgAssociateDtl\' id=\'PkgAssociateDtl\' action=\"\" method=\"post\" target=\"messageFrame\" >\t\n\t<table class=\'grid\' width=\'100%\' id=\"PkgSubsAssociate_tbl\">\n\t<tr >\n\t\t<td  class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\t\t\n\t\t<td  class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t<td  class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<td  class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\t\n\t\t<td  class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t</tr>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\n\t\t\t\n\t\t\t<tr>\n\t\t\t\t\n\t\t\t<td class=\'label\'><a href=\'#\' name=\'pkgDtls";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' onClick=\"displaypkgDtls(\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\');\" >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</a><input type=\"hidden\" name=\"pkg_seq_no";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" id=\"pkg_seq_no";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"></td>\n\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="<input type=\"hidden\" name=\"pkg_code";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" id=\"pkg_code";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="<input type=\"hidden\" name=\"pkg_desc";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" id=\"pkg_desc";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"></td>\n\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t<td class=\'fields\'><input type=\"text\" name=\"from_date";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" id=\"from_date";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" onBlur=\"dateCheck(\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\')\"><img id = \'fromDateimg_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' name=\"fromDateimg_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"\t src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'from_date";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\',\'dd/mm/yyyy hh:mm:ss\');\" STYLE=\"display:inline;\"></td>\n\t\t\t<input type=\'hidden\' name=\"fromdatehdn";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" id=\"fromdatehdn";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t\t\t<input type=\'hidden\' name=\"eff_from_date_hdn";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" id=\"eff_from_date_hdn";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t\t\t<td class=\'fields\'><span class==\"text\" name=\"to_date";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" id=\"to_date";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</span></td>\t\t\n\t\t\t<input type=\'hidden\' name=\"toDateHdn";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" id=\"toDateHdn";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t\t<td  class=\'fields\' ><input type=\"checkbox\" name=\"associated";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" id=\"associated";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"  id=\"associated";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"   ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="  value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" onClick=\"chkAssociate(this,\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'); toDateDisp(this,\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\')\";></td>\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\t\n\t\t\t<td  class=\'fields\' ><input type=\"checkbox\" name=\"associated";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"  ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\');\"></td>\n\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\t\n\t\t\t\n\t\t\t</tr>\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t<tr >\n\t\t\t<td class=\'label\'><a href=\'#\' name=\'pkgDtls";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\t\n\t\t\t\n\t\t\t</tr>\n\t\t\t\t\n ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\n\t\t\t<td class=\'label\'><a href=\'#\' name=\'pkgDtls";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\n\t\t\t</tr>\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t<input type=\"hidden\" name=\"pkgAmt";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" id=\"pkgAmt";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t\t\n\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t</table>\t\t\n\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" >\n\t\t<input type=\'hidden\' name=\'total_records\' id=\'total_records\'  value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" >\n\t\t<input type=\'hidden\' name=\'patientId\' id=\'patientId\' value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" >\n\t\t<input type=\'hidden\' name=\'sysDate\' id=\'sysDate\' value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" >\n\t\t<input type=\'hidden\' name=\'function_id\'  id=\'function_id\' value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" >\n\t\t<input type=\'hidden\' name=\'noofdecimal\' id=\'noofdecimal\' value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" >\n\t\t<input type=\'hidden\' name=\'calling_module_id\' id=\'calling_module_id\' value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" >\n\t\t<input type=\'hidden\' name=\'encounter_date\' id=\'encounter_date\' value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" >\n\t\t<input type=\'hidden\' name=\'encounter_date_time\'  id=\'encounter_date_time\' value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" >\n\t\t<input type=\'hidden\' name=\'encounter_date_aft_trunc\' id=\'encounter_date_aft_trunc\' value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" >\n\t\t<!-- \t\tKarthik added code for MMS-RY-SCF-0065 -->\n\t\t<input type=\'hidden\' name=\'allPayerGroupCode\' id=\'allPayerGroupCode\' value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t\t<input type=\'hidden\' name=\'allPayerCode\' id=\'allPayerCode\' value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t\t<input type=\'hidden\' name=\'firstVisitDateTime\'  id=\'firstVisitDateTime\' value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>\n\t\t<input type=\'hidden\' name=\'strMessageId\' id=\'strMessageId\' \' value=\'\'>\n\t\t<input type=\'hidden\' name=\'strErrorText\' id=\'strErrorText\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'siteSpec\' id=\'siteSpec\'  value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'>\n\t\t\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
 

try
	{
		String locale			= (String)session.getAttribute("LOCALE");
		String facilityId		= (String) session.getValue( "facility_id" ) ;
		int noofdecimal=2;

		String function_id = request.getParameter("function_id") == null ? "" :request.getParameter("function_id") ;	
		String patientId = request.getParameter("patientId") == null ? "" :request.getParameter("patientId") ;
		String encounter_date = request.getParameter("encounter_date") == null ? "" :request.getParameter("encounter_date") ;
		String encounter_date_time = request.getParameter("encounter_date_time") == null ? "" :request.getParameter("encounter_date_time") ;
		String encounter_date_aft_trunc = request.getParameter("encounter_date_aft_trunc") == null ? "" :request.getParameter("encounter_date_aft_trunc") ;
		String calling_module_id = request.getParameter("calling_module_id") == null ? "" :request.getParameter("calling_module_id") ;
		String firstVisitDateTime=request.getParameter("firstVisitDateTime")==null ?"":request.getParameter("firstVisitDateTime");
		//System.out.println("firstVisitDateTime "+firstVisitDateTime);
		
		if(calling_module_id.equals(""))
			calling_module_id="BL";
	
		String sysDate="";

		String bean_id		= "PkgAssociateBean" ;
		String bean_name	= "eBL.PkgAssociateBean";
		PkgAssociateBean bean			= (PkgAssociateBean)getBeanObject( bean_id, bean_name, request ) ;
		Boolean siteSpec=false;
		Connection con=null;
		try
		{
			con = ConnectionManager.getConnection();	
			siteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DISP_PKG_DATE_FIELDS_DUR_SUBS");
	
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception in site specific "+e);
		}


            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

	if(siteSpec)
	{
	
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

	}else{
	
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
}	 
            _bw.write(_wl_block16Bytes, _wl_block16);


		ArrayList  subscribedOpenPkgs=bean.subscribedOpenPkgs(facilityId,locale,patientId,encounter_date_aft_trunc);
		ArrayList  associatedPkgs=bean.getAssociatedPkgs();
		if(subscribedOpenPkgs.size() >0){
			String pkg_seq_no="";		
			String pkg_code="";		
			String pkg_desc="";		
			String associated="";		
			String pkgEffFromDate="";
			String pkgEffToDate="";
			String recordedValues="";	
			StringTokenizer pkgSt=null;
			String pkgCode="";
			String pkgDesc="";
			String pkgSeqNo="";
			String pkgFromDate="";
			String pkgAmt=""; //Added By Vijay For MMS-ICN-00025
			/*System.out.println("associatedPkgs "+associatedPkgs);
			System.out.println("size "+associatedPkgs.size());
			System.out.println("subscribedOpenPkgs.size() "+subscribedOpenPkgs.size());*/
			
			for(int i=0; i<subscribedOpenPkgs.size(); i++)
			{	
				String[] record = (String[])subscribedOpenPkgs.get(i);
				pkg_seq_no	=record[0];
				pkg_code	=record[1];
				pkg_desc	=record[2];
				pkgEffFromDate=record[3];
				pkgEffToDate=record[4];
				pkgAmt		=record[5];
			
				System.out.println("pkgamt "+pkgAmt);
				//System.out.println("pkgfrom date "+pkgEffFromDate);
				//System.out.println("pkgto date "+pkgEffToDate);
				
				associated="N";
				
		if(associatedPkgs.size()==0)
		{
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(pkg_seq_no));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pkg_seq_no));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(pkg_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pkg_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(pkg_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pkg_desc));
            _bw.write(_wl_block28Bytes, _wl_block28);

			if(siteSpec)
			{ 
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pkgEffFromDate ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pkgEffFromDate ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pkgEffFromDate ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(pkgEffToDate ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pkgEffToDate ));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(associated.equals("Y")?"checked":""));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(associated));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
} 
			else
			{
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(associated.equals("Y")?"checked":""));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(associated));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);

			}
			
            _bw.write(_wl_block55Bytes, _wl_block55);
 }
		else
		{
			
			
				for(int j=0;j<associatedPkgs.size();j++)
				{
					recordedValues=(String)associatedPkgs.get(j);
					/* System.out.println("vals "+vals);
					System.out.println("pkgSeqNo list"+pkgSeqNo);
					System.out.println("pkg_seq_no query"+pkg_seq_no);
					 */
					 pkgSt=new StringTokenizer(recordedValues,"~~");
					if(pkgSt.hasMoreTokens())
					{
						pkgCode=(String)pkgSt.nextToken();
					}
					else
					{
						pkgCode="";
					}
					if(pkgSt.hasMoreTokens())
					{
						pkgDesc=(String)pkgSt.nextToken();
					}
					else
					{
						pkgDesc="";
					}
					if(pkgSt.hasMoreTokens())
					{
						pkgSeqNo=(String)pkgSt.nextToken();
						/* System.out.println("pkgSeqNo "+pkgSeqNo);
						System.out.println("pkg_seq_no "+pkg_seq_no); */
						if(pkgSeqNo.equals(pkg_seq_no))
						{
							associated="Y";
						}
					}
					else
					{
					
						pkgSeqNo="";
					}
					if(pkgSt.hasMoreTokens())
					{
						pkgFromDate=(String)pkgSt.nextToken();
						//System.out.println("pkgFromDate "+pkgFromDate);
					}
					else
					{
						pkgFromDate="";
					}
			 		
				
					if(pkg_seq_no.equals(pkgSeqNo) &&associated.equals("Y"))
					{				
				
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(pkg_seq_no));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pkg_seq_no));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(pkg_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pkg_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(pkg_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pkg_desc));
            _bw.write(_wl_block28Bytes, _wl_block28);

			if(siteSpec)
			{ 
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pkgFromDate ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pkgEffFromDate ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pkgEffFromDate ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(pkgEffToDate ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pkgEffToDate ));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(associated.equals("Y")?"checked":""));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(associated));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
} 
			else
			{
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(associated.equals("Y")?"checked":""));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(associated));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);

			}
			
            _bw.write(_wl_block57Bytes, _wl_block57);
} 
					
		}
			if(associated.equals("N")){ 
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(pkg_seq_no));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pkg_seq_no));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(pkg_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pkg_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(pkg_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pkg_desc));
            _bw.write(_wl_block28Bytes, _wl_block28);

			if(siteSpec)
			{ 
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pkgEffFromDate ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pkgEffFromDate ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pkgEffFromDate ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(pkgEffToDate ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pkgEffToDate ));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(associated.equals("Y")?"checked":""));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(associated));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
} 
			else
			{
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(associated.equals("Y")?"checked":""));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(associated));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);

			}
			
            _bw.write(_wl_block59Bytes, _wl_block59);
 }	//System.out.println("associated ouitside for "+associated);
				
				
				
			}
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pkgAmt));
            _bw.write(_wl_block62Bytes, _wl_block62);
 
			}
			} 
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(subscribedOpenPkgs.size()));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(sysDate));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(calling_module_id));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(encounter_date));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(encounter_date_time));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(encounter_date_aft_trunc));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(request.getParameter("allPayerGroupCode")));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(request.getParameter("allPayerCode")));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(firstVisitDateTime ));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(siteSpec ));
            _bw.write(_wl_block77Bytes, _wl_block77);

	putObjectInBean(bean_id,bean,request);
}
catch(Exception e)
{
	System.out.println("Exception from Package subscription  :"+e);
	e.printStackTrace();
}


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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PkgAssociateFrame.jsp.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SequenceNo.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PackageCode.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PKG_DESC.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.FromDate.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ToDate.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Associate.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Associate.label", java.lang.String .class,"key"));
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
