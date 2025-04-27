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

public final class __maintainservreportinggp extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/MaintainServReportingGp.jsp", 1737917090067L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n<link rel=\"stylesheet\" type=\"text/css\"href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"JavaScript\" src=\"../../eBL/js/dailycashTabFrame.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\nfunction onLoadMaintainServ(from){\n\tif(from==\'createserv\'){\n\t\tvar serviceValues=parent.AssocServtab.document.getElementById(\"tempserviceVal\").value;\n\t\tvar table = document.getElementById(\"MaintainserviceTbl\");\n\t\tvar length=parent.AssocServtab.document.getElementById(\"servcnt\").value;\n\t\tvar tablen=table.rows.length;\n\t\tserviceValues = serviceValues.slice(0, -5);\n\t\tvar arrOfServ = serviceValues.split(\",,,,,\");\n\t\tfor(var i=1; i<=length; i++) {\n\t\t\tvar row = table.insertRow(i);\n\t\t\t\n\t\t\tvar newcell\t= row.insertCell(0);\n\t\t\tnewcell.innerHTML =\"<td class=\'fields\' nowrap> \"+\n\t\t\t\t\"<select id=\'ServTypeval\"+i+\"\' style=\'width:90%;\' name=\'ServTypeval\"+i+\"\' id=\'ServTypeval\"+i+\"\' onChange=\'servTypeChange(this)\'> \"+\n\t\t\t\t\t\"<option value=\'S\'>Billing Service</option> \"+\n\t\t\t\t\t\"<option value=\'I\'>Material Item</option> \"+\n\t\t\t\t\"</select> \"+\n\t\t\t\t\"</td>\";\n\t\t\tvar newcell1\t= row.insertCell(1);\n\t\t\tnewcell1.innerHTML =\"<td align=\'center\' ><input type=\'text\' onblur=\\\"if(this.value!=\'\'){servItemlkup(this);}\\\" style=\'width:90%;\' maxlength=\'150\' name=\'servitem\"+i+\"\' id=\'servitem\"+i+\"\'  id=\'servitem\"+i+\"\'  value=\'\'   >\" +\n\t\t\t\t\t\" <input type=\'button\' name=\'servitembtn\"+i+\"\' id=\'servitembtn\"+i+\"\' id=\'servitembtn\"+i+\"\' value=\'?\' onClick=\'servItemlkup(this)\'> \"+\n\t\t\t\t\t\"<input type=\'hidden\' name=\'serv_item\"+i+\"\' id=\'serv_item\"+i+\"\' id=\'serv_item\"+i+\"\'>\"+\n\t\t\t\t\t\"</td>\";\n\t\t\tnewcell1.style.textAlign = \"left\";\n\t\t\tvar newcell2\t= row.insertCell(2);\n\t\t\tnewcell2.innerHTML =\"<td align=\'center\' colspan=\'2\'><input type=\'text\'  onfocus=\'this.blur();\' style=\'width:100%;\' maxlength=\'350\' name=\'serviceitmDesc\"+i+\"\' id=\'serviceitmDesc\"+i+\"\'  id=\'serviceitmDesc\"+i+\"\' value=\'\' readonly></td>\";\n\t\t\tnewcell2.style.textAlign = \"center\";\n\t\t\t\n\t\t\tvar k=i-1;\n\t\t\tvar arrOfStrg = arrOfServ[k].split(\"~\");\n\t\t\tvar code=arrOfStrg[0];\n\t\t\tvar desc=arrOfStrg[1];\n\t\t\tvar ind=arrOfStrg[2];\n\t\t\tdocument.getElementById(\"serviceitmDesc\"+i).value=desc;\n\t\t\tdocument.getElementById(\"servitem\"+i).value=code;\n\t\t\tvar s=document.getElementById(\"ServTypeval\"+i);\n\t\t\tfor(var j=0; j<s.options.length; j++)\n\t   \t\t{\n\t\t\t\tif(s.options[j].value==ind){\n\t\t\t\t\ts.options[j].selected=true;\n\t\t\t\t}\n\t\t\t}\t\n\t\t}\n\t}\t\n}\n\n\n\n</script>\n<style>\n#table-wrapper {\n  position:relative;\n}\n#table-scroll {\n  height:360px; \n  overflow:auto;  \n  margin-top:20px;\n}\n#table-wrapper table {\n  width:100%;\n}\n#table-wrapper table  {\n  background:white;\n  color:black;\n}\n#table-wrapper table thead tr {\n  position:relative; \n  top: expression(offsetParent.scrollTop);\n  z-index:2;\n  height:20px;\n  width:35%;\n}\n</style>\n</head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<body onload=\"onLoadMaintainServ(\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\')\">\n\t<form name=\'MaintReportServ\' id=\'MaintReportServ\' id=\'MaintReportServ\' method=\'post\' action=\"../../servlet/eBL.BLDailyCashServlet\" target=\"messageFrame\">\n\t\t<center>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t<tr>\n\t<td>\n\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t<div id=\"table-wrapper\">\n\t\t\t\t\t<div id=\"table-scroll\">\n\t\t\t\t\t<table width=\'100%\' align=\"center\" cellpadding=\"4\" cellspacing=\"0\" class=\'grid\' id=\"MaintainserviceTbl\">\n\t\t\t\t\t<thead>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' align=\'center\' width=\'7%\'>Service Type</td>\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' align=\'center\' width=\'10%\'>Service Item Code</td>\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' align=\'center\' colspan=\'2\' width=\'20%\'>Description</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</thead>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t<tr id=\"servitmCode";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t\t<select name=\"ServTypeval";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" id=\"ServTypeval";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" readonly style=\"width:90%;\" onfocus=\"this.blur()\" readonly=\"readonly\">\n\t\t\t\t\t\t\t\t\t\t<option value=\"S\" ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =">Billing Service</option>\n\t\t\t\t\t\t\t\t\t\t<option value=\"I\" ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =">Material Item</option>\n\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t\t<input class=\"gridDataInputLess\" type=\"text\" maxlength=\"150\" style=\"width:90%;\" name=\"servitem";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" id=\"servitem";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" onfocus=\"this.blur()\" readonly=\"readonly\">\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td colspan=\'2\'>\n\t\t\t\t\t\t\t\t\t<input class=\"gridDataInputLess\" type=\"text\" maxlength=\"150\" style=\"width:100%;\" name=\"serviceitmDesc";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" id=\"serviceitmDesc";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" onfocus=\"this.blur()\" readonly=\"readonly\">\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t<tr id=\"servitmCode";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =">\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<select name=\"ServTypeval";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" onChange=\'servTypeChange(this)\' style=\"width:90%;\" ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =">\n\t\t\t\t\t\t\t\t<option value=\"S\" selected>Billing Service</option>\n\t\t\t\t\t\t\t\t<option value=\"I\">Material Item</option>\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<input class=\"gridDataInputLess\" type=\"text\" maxlength=\"150\" style=\"width:90%;\" name=\"servitem";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" onblur=\"if(this.value!=\'\'){servItemlkup(this);enableNextRow(this)}\" value=\"\" ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =">\n\t\t\t\t\t\t\t<input type=\'button\' class=\'button\' name=\"servitembtn";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" id=\"servitembtn";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" value=\'?\' onClick=\"servItemlkup(this);enableNextRow(this)\" ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="/> \n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"serv_item";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" id=\"serv_item";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" value=\"\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td colspan=\'2\'>\n\t\t\t\t\t\t\t<input class=\"gridDataInputLess\" type=\"text\" maxlength=\"150\" style=\"width:100%;\" name=\"serviceitmDesc";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" value=\"\" ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" readonly>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t</table>\n\t\t\t\t</div>\n\t\t\t</div>\t\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td><br>\n\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" >\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td align=\'right\'>\n\t\t\t\t\t\t\t<input type=\'button\' class=\'BUTTON\' value=\'Add\' onclick=\"AddRowServ()\">\n\t\t\t\t\t\t\t<input type=\'button\' class=\'BUTTON\' id=\"savebtn\" value=\'Save\' onclick=\'saveNewServ()\'>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t\t</td>\n\t\t</tr>\n\t</table>\n\t<input type=\"hidden\" name=\"locale\" id=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"> \n\t<input type=\"hidden\" name=\"FacilityId\" id=\"FacilityId\" id=\"FacilityId\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"> \n\t<input type=\"hidden\" name=\"servGrpCode\" id=\"servGrpCode\" id=\"servGrpCode\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t<input type=\"hidden\" name=\"servGrpDesc\" id=\"servGrpDesc\" id=\"servGrpDesc\" value=\"\">\n\t<input type=\"hidden\" name=\"grpSize\" id=\"grpSize\" id=\"grpSize\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t<input type=\"hidden\" name=\"rowval\" id=\"rowval\" id=\"rowval\" value=\"\"> \n\t<input type=\'hidden\' name=\'user\' id=\'user\' id=\'user\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t<input type=\"hidden\" name=\"servArrCode\" id=\"servArrCode\" id=\"servArrCode\" value=\"\">\n\t<input type=\"hidden\" name=\"totalRec\" id=\"totalRec\" id=\"totalRec\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">  \n\t<input type=\"hidden\" name=\"count\" id=\"count\" id=\"count\" value=\"\">  \n\t<input type=\"hidden\" name=\"createselidx\" id=\"createselidx\" id=\"createselidx\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">  \n\t<input type=\"hidden\" name=\"modeType\" id=\"modeType\" id=\"modeType\" value=\"MaintainServIns\">\n\t<input type=\"hidden\" name=\"serviceSave\" id=\"serviceSave\" id=\"serviceSave\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t<input type=\"hidden\" name=\"WS_NO\" id=\"WS_NO\" id=\"WS_NO\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t<input type=\"hidden\" name=\"called\" id=\"called\" id=\"called\" value=\"maintainserv\">\n\t</form>\n</body>\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n</html>\n\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );
	
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

	public static String checkForNull(String inputString, String defaultValue) {
		return (((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
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

/*
<!-- 
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210203             7339  	       	MOHE-CRF-0050		           Mohana Priya K
2            V210216             14534 	       	MOHE-CRF-0050		           Mohana Priya K
-->
*/
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1   
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0   
	response.setDateHeader("Expires", 0); //prevents caching at the proxy server 
	String locale = "";
	String facilityId = "";
	String isUserCanAcess = "";
	int l=14;
	int limit=1;
	int serSize=0;
	int extra=0;
	int totRec=0;
	int extraID=0;
	String serviceSave	=	"N";
	String disabled="";
	String readonly="";
	String onfocus="";
	String servGpCode="";
	String selectall="";
	try {
		locale = (String) session.getAttribute("LOCALE");
		facilityId = (String) session.getValue("facility_id");
		isUserCanAcess = (String) (session.getValue("isUserCanAcess") == null ? "Y" : (session.getValue("isUserCanAcess")));
		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties) httpSession.getValue("jdbc");
		String WS_NO  = p.getProperty("client_ip_address");
		String strLoggedUser = p.getProperty("login_user");
		if (strLoggedUser == null)
			strLoggedUser = "";
		String Called = request.getParameter("called") == null ? "" : request.getParameter("called");
		System.err.println("called from-->"+Called);

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(Called ));
            _bw.write(_wl_block8Bytes, _wl_block8);

					String loginUser = (String) session.getValue("login_user");
					String localeLang = (String) session.getAttribute("LOCALE");
			
            _bw.write(_wl_block9Bytes, _wl_block9);

					if (Called.equals("servload")) {
						servGpCode=request.getParameter("servGpCode") == null ? "" :request.getParameter("servGpCode");
						System.err.println("servGpCode maint >" + servGpCode);
						String bean_id		=	"";
						String bean_name	=	"";
						bean_id		= 	"DailyCashDeliveryReport" ;
						bean_name	= 	"eBL.DailyCashDeliveryReport"; 
						LinkedHashMap 	DailyCashReprt	=	null;
						DailyCashDeliveryReport DailyCashDeliveryReport = 	null;
						DailyCashReportBean	DailyCashReportBean =new DailyCashReportBean();	
						DailyCashReprt	=	new LinkedHashMap();
						DailyCashDeliveryReport	= 	(DailyCashDeliveryReport)PersistenceHelper.getBeanObject( bean_id, bean_name, request );
						DailyCashDeliveryReport.clearBean();
						DailyCashDeliveryReport.getServValues(localeLang,servGpCode);//Loading DB Values from Temporary table to HasMap
						DailyCashReprt	= 	(LinkedHashMap)DailyCashDeliveryReport.getDailyCashSearchValues();
						String servtypI="";
						String servtypS="";
						String KeyValue="";
						
						serSize=DailyCashReprt.size();
						System.err.println("serSize From Bean  "+serSize);
						totRec=serSize;
						if(serSize<14){
							extra=14-serSize;
							System.err.println("extra size  "+extra);
						}
						if(!DailyCashReprt.isEmpty()) {
							Iterator it = DailyCashReprt.entrySet().iterator();
							while(it.hasNext()) {
							   Map.Entry obj = (Entry)it.next();
							   DailyCashReportBean=(DailyCashReportBean)obj.getValue();
							   KeyValue=(String)obj.getKey();
							   if(DailyCashReportBean!=null){
									//service indicator
								   String ServInd= DailyCashReportBean.getServItmInd();
								   ServInd=(ServInd==null?"":ServInd);
								   System.err.println("ServInd From Bean  "+ServInd);
									
								   if(ServInd.equals("I")){
									   servtypI="selected";
									   servtypS="";
									}else{
										 servtypS="selected";
										 servtypI="";
									}	
								   
								   //Service item Code
								   String servItmCode= DailyCashReportBean.getServItmCode();
								   servItmCode=(servItmCode==null?"":servItmCode);
								   System.err.println("servItmCode From Bean  "+servItmCode);
									
								   //service item Desc
								   String ServItmDesc= DailyCashReportBean.getServItmDesc();
								   ServItmDesc=(ServItmDesc==null?"":ServItmDesc);
								   System.err.println("ServItmDesc From Bean  "+ServItmDesc);
							   
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(servtypS ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(servtypI ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(servItmCode));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(limit));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(ServItmDesc));
            _bw.write(_wl_block20Bytes, _wl_block20);

									   }
									   limit++;	
									}
								}
							}
								
											   
					if (Called.equals("createserv")) {
						selectall=request.getParameter("selectall") == null ? "N" :request.getParameter("selectall");
						System.err.println("selectall--"+selectall);
						servGpCode=request.getParameter("servGpCode") == null ? "" :request.getParameter("servGpCode");
						String size=request.getParameter("paramlen") == null ? "" :request.getParameter("paramlen");
						int length=Integer.parseInt(size);
						totRec=length;
						System.err.println("length--"+length);
						if(length<14){
							extra=14-length;
							System.err.println("extra size  "+extra);
						}
						limit=length+1;
					}
					if(extra>0){
						extraID=limit;
						for(int k=0;k<extra;k++){
							if(k==0){
								disabled="";
								readonly="";
								onfocus="";
							}else{
								disabled="disabled";
								readonly="readonly" ;
								onfocus="this.blur()";
							}	
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(onfocus));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(onfocus));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(onfocus));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(extraID));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(onfocus));
            _bw.write(_wl_block35Bytes, _wl_block35);

					extraID++;
					}
				}
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(localeLang));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(servGpCode));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(serSize));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(strLoggedUser));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(totRec));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(selectall));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(serviceSave));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(WS_NO));
            _bw.write(_wl_block45Bytes, _wl_block45);
	}catch (Exception e) {
		e.printStackTrace();
		System.err.println("Exception in maintainserv.jsp::" + e);
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block46Bytes, _wl_block46);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
