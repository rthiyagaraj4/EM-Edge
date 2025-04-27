package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import eCommon.Common.*;
import org.json.simple.*;
import java.util.Map.Entry;
import java.util.Set;
import webbeans.eCommon.*;
import eBL.Common.*;
import eBL.*;
import eBL.resources.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __createservreportinggp extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/CreateServReportingGp.jsp", 1737916945194L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No        Version              TFS              SCF/CRF           \t\tDeveloper Name\n-----------------------------------------------------------------------------------------------\n1            V210129            11086          MOHE-CRF-0050                Mohana Priya K\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<script type=\"text/javascript\" src=\"../../eBL/js/json2.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eBL/js/json.min.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t\n\t<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eBL/js/dailycashTabFrame.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<script>\n\nfunction resetTable()\n{\n\tdocument.getElementById(\'servfrm\').value=\'\';\n\tdocument.getElementById(\'servto\').value=\'\';\n\tdocument.getElementById(\"shrtdesc\").value=\'N\';\n\tdocument.getElementById(\'shortdes\').value=\'\';\n\t\n\tvar length=0;\n\tvar len=document.getElementById(\'servcount\').value;\n\tif(len<8){\n\t\tlength=8;\n\t}else{\n\t\tlength=len;\n\t}\n\tvar table = document.getElementById(\'servItemRows\');\n\tvar rowCount = table.rows.length;\n\tif(length!=0){\n\t\tfor(var m=length;m>=1;m--){\n\t\ttable.deleteRow(m);\n\t\t}\n\t}\n\t\n\tfor(var i=0;i<8;i++){\n\t\tvar row = table.insertRow(1);\n\t\tvar newcell\t= row.insertCell(0);\n\t\tnewcell.innerHTML =\"<td align=\'center\' ><input type=\'text\' style=\'width:100%;\' name=\'servCode\"+i+\"\' id=\'servCode\"+i+\"\'  id=\'servCode\"+i+\"\' style=\'width=\'100%\';\' value=\'\'></td>\";\n\t\tnewcell.style.textAlign = \"center\";\n\t\tvar newcell1\t= row.insertCell(1);\n\t\tnewcell1.innerHTML =\"<td align=\'center\' ><input type=\'text\' style=\'width:100%;\' name=\'servDesc\"+i+\"\' id=\'servDesc\"+i+\"\'  id=\'servDesc\"+i+\"\' style=\'width=\'100%\';\' value=\'\'></td>\";\n\t\tnewcell1.style.textAlign = \"center\";\n\t\tvar newcell2\t= row.insertCell(2);\n\t\tnewcell2.innerHTML =\"<td align=\'center\' ><input type=\'checkbox\'  name=\'servCheck\"+i+\"\' id=\'servCheck\"+i+\"\'  id=\'servCheck\"+i+\"\' style=\'width=\'100%\';\' value=\'\' onclick=\'selectserv(this)\'></td>\";\n\t\tnewcell2.style.textAlign = \"center\";\n\t}\n\tdocument.getElementById(\'servcount\').value=\'8\';\n}\n\t\n\t\n</script>\n<style>\n/*thead td, thead td.locked {\n\tbackground-color: navy;\n\tcolor: white;\n\tposition: relative;\n}\n\nthead td {\n\ttop: expression(document.getElementById ( \"tbl-container\") .scrollTop-4);\n\tz-index: 20;\n}\n\nthead td.locked {\n\tz-index: 30;\n}\n\ntd.locked, th.locked {\n\tleft: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);\n\tposition: relative;\n\tz-index: 10;\n}\n\ntd.locked, th.locked {\n\tleft: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);\n\tposition: relative;\n\tz-index: 10;\n}*/\n\t\n#table-wrapper {\n  position:relative;\n}\n#table-scroll {\n  height:250px;\n  overflow:auto;  \n  margin-top:20px;\n}\n#table-wrapper table {\n  width:100%;\n}\n#table-wrapper table  {\n  background:white;\n  color:black;\n}\n#table-wrapper table thead tr {\n  position:relative; \n  top: expression(offsetParent.scrollTop);\n  z-index:2;\n  height:20px;\n  width:35%;\n}\t\n</style>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<body onload=\"\">\n\t<form name=\'createrportserv\' id=\'createrportserv\' method=\'post\'>\n\t<center>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t<tr>\n\t\t\t\t\t<td><table width=\"100%\" border=\"0\" cellspacing=\"0\"\n\t\t\t\t\t\t\tcellpadding=\"0\">\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td><table width=\'100%\' align=\"center\" cellpadding=\"2\"\n\t\t\t\t\t\t\t\t\t\tcellspacing=\"0\">\n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\"10%\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t<td><select name=\"ServiceType\" id=\"ServiceType\" id=\"ServiceType\" onChange=\"resetTable();\"  \n\t\t\t\t\t\t\t\t\t\t\t\tstyle=\"width: 210px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"S\" selected>Billing Service</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"I\">Material Item</option>\n\t\t\t\t\t\t\t\t\t\t\t</select></td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td><table width=\"100%\" border=\"0\" cellspacing=\"0\"\n\t\t\t\t\t\t\t\t\t\tcellpadding=\"0\">\n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t<td colspan=\'2\'><b>Search Criteria for Service\n\t\t\t\t\t\t\t\t\t\t\t\t\tSelection </b></td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t<br>\n\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td><table width=\'100%\' align=\"center\" cellpadding=\"4\"\n\t\t\t\t\t\t\t\t\t\tcellspacing=\"0\" class=\'grid\'>\n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\"10%\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t<td><input type=\"text\" name=\'servfrm\' id=\'servfrm\' id=\'servfrm\'\n\t\t\t\t\t\t\t\t\t\t\t\tsize=\"30\" onblur=\"serviceFromTo(servfrmdes,servfrm)\">&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\'servfrmdes\' id=\'servfrmdes\' id=\'servfrmdes\'\n\t\t\t\t\t\t\t\t\t\t\t\tsize=\"30\">&nbsp; <input type=\"button\"\n\t\t\t\t\t\t\t\t\t\t\t\tclass=\"button\" value=\'?\' name=\"servfrmBtn\" id=\"servfrmBtn\" id=\"servfrmBtn\"\n\t\t\t\t\t\t\t\t\t\t\t\tonClick=\"serviceFromTo(servfrmdes,servfrm)\"></td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\'3%\' align=\'right\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t<td><input type=\"text\" name=\'servto\' id=\'servto\' id=\'servto\'\n\t\t\t\t\t\t\t\t\t\t\t\tsize=\"30\" onblur=\"serviceFromTo(servtodesc,servto)\">&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\'servtodesc\' id=\'servtodesc\' id=\'servtodesc\'\n\t\t\t\t\t\t\t\t\t\t\t\tsize=\"30\">&nbsp; <input type=\"button\"\n\t\t\t\t\t\t\t\t\t\t\t\tclass=\"button\" value=\'?\' name=\"servtoBtn\" id=\"servtoBtn\" id=\"servtoBtn\"\n\t\t\t\t\t\t\t\t\t\t\t\tonClick=\"serviceFromTo(servtodesc,servto)\"></td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\"10%\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t<td><select name=\"shrtdesc\" id=\"shrtdesc\" id=\"shrtdesc\"\n\t\t\t\t\t\t\t\t\t\t\t\tonchange=\"shortDescChange(this)\" style=\"width: 120px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"N\" selected></option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"S\">Start With</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"C\">Contains</option>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"E\">Ends With</option>\n\t\t\t\t\t\t\t\t\t\t\t</select> <input type=\"text\" name=\'shortdes\' id=\'shortdes\' id=\'shortdes\' size=\"30\"\n\t\t\t\t\t\t\t\t\t\t\t\tdisabled>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t\t\t\t\t\t<td align=\'right\'><input type=\'button\' class=\'BUTTON\'\n\t\t\t\t\t\t\t\t\t\t\t\tvalue=\'Display Services\' onclick=\'cleardata();displayServices();\'>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t<div id=\"table-wrapper\">\n\t\t\t\t\t\t\t\t<div id=\"table-scroll\">\n\t\t\t\t\t\t\t\t\t<table width=\'100%\' align=\"center\" id=\"servItemRows\" name=\"servItemRows\" id=\"servItemRows\" class=\'grid\'>\n\t\t\t\t\t\t\t\t\t\t<thead>\n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' align=\'center\' width=\'10%\'>Service Item Code</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' align=\'center\' width=\'20%\'>Service Description</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' align=\'center\' width=\'5%\'>Select All<input type=\'checkbox\' name=\"selectall\" id=\"selectall\" id=\"selectall\" onclick=\"selectallserv()\"></td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t</thead>\n\t\t\t\t\t\t\t\t\t\t <tbody>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t<td align=\"center\" >\t\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\'servcode\' id=\'servcode\' id=\'servcode\' size=\"30\" style=\"width:100%;\" readonly>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td align=\"center\" >\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\'description\' id=\'description\' id=\'description\' size=\"30\" style=\"width:100%;\" readonly>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td align=\"center\" >\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\"select\" id=\"select\" id=\"select\" onclick=\"\" style=\"width:100%;\" readonly>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t\t\t </tbody>\n\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t<td align=\'right\'><input type=\'button\' class=\'BUTTON\'\n\t\t\t\t\t\t\t\t\t\t\t\tvalue=\'Associate Services\' onclick=\'associateServices()\'></td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</center>\n\n<input type=\"hidden\" name=\"locale\" id=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n<input type=\"hidden\" name=\"FacilityId\" id=\"FacilityId\" id=\"FacilityId\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"> \n<input type=\"hidden\" name=\"servGrpCode\" id=\"servGrpCode\" id=\"servGrpCode\" value=\"\"> \n<input type=\"hidden\" name=\"servGrpDesc\" id=\"servGrpDesc\" id=\"servGrpDesc\" value=\"\"> \n<input type=\"hidden\" name=\"grpSize\" id=\"grpSize\" id=\"grpSize\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n<input type=\"hidden\" name=\"rowval\" id=\"rowval\" id=\"rowval\" value=\"\"> \n<input type=\'hidden\' name=\'user\' id=\'user\' id=\'user\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n<input type=\"hidden\" name=\"called\" id=\"called\" id=\"called\" value=\"createserv\">\n<input type=\'hidden\' name=\'servcount\' id=\'servcount\' value=\'\'>\n<input type=\'hidden\' name=\'selectidx\' id=\'selectidx\' value=\'N\'>\n</form>\n</body>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n</html>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );
	
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

	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
		
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "")
					? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1   
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0   
	response.setDateHeader("Expires", 0); //prevents caching at the proxy server 
	String locale = "";
	String facilityId = "";
	//String isUserCanAcess = "";

	try{
		sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
				|| (session.getAttribute("PREFERRED_STYLE") != "")
						? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
		locale = (String) session.getAttribute("LOCALE");
		facilityId = (String) session.getValue("facility_id");
		//isUserCanAcess = (String) (session.getValue("isUserCanAcess") == null ? "Y"
			//	: (session.getValue("isUserCanAcess")));
		HttpSession httpSession = request.getSession(false);

		Properties p = (Properties) httpSession.getValue("jdbc");
		String strLoggedUser = p.getProperty("login_user");
		if (strLoggedUser == null)
			strLoggedUser = "";

            _bw.write(_wl_block7Bytes, _wl_block7);

		String loginUser = (String) session.getValue("login_user");
			String localeLang = (String) session.getAttribute("LOCALE");
			int serSize = 0;
			int limit = 1;
			int extraID = 0;
			int extra = 0;
			int size = 0;
			if (serSize < 6) {
				extra = 6 - serSize;
				System.err.println("extra size  " + extra);
			}
	
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
int i=8;
										for(int j=0;j<i;j++){
											
            _bw.write(_wl_block14Bytes, _wl_block14);

										} 
										
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(localeLang));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(serSize));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strLoggedUser));
            _bw.write(_wl_block19Bytes, _wl_block19);

	} catch (Exception e) {
		e.printStackTrace();
		System.err.println("Exception in generatedaycolReport.jsp::" + e);
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block20Bytes, _wl_block20);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ServiceType.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Service.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.from.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ShortDesc.label", java.lang.String .class,"key"));
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
}
