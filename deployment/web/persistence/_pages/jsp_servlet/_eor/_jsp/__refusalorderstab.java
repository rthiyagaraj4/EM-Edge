package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import eOR.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import eOR.Common.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __refusalorderstab extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/RefusalOrdersTab.jsp", 1737606468000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n<head><title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title>\n \n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\'/></link>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/RefusalOrders.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\"JavaScript\" src=\"../js/OrCommonFunction.js\"></script>\n\t<!--<script language=\"JavaScript\" src=\"../js/OrMessages.js\"></script>-->\n\t<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\n\t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n\t<script>\n\t\t\n\t\t\n\t\tfunction change_common_tab(obj)\n\t\t{  \n\t\t \n\t\t\tvar patient_id = document.refusaltab_form.patientId.value;\n\t\t\t//alert(\"patient_id333=\"+patient_id);\n\t\t\t//alert(\"qry_str=\"+document.refusaltab_form.qry_str.value); \n \t\t\n\t\t\tif(patient_id !=\"\"){\n\t\t\t\tdocument.getElementById(\"tab\").style.visibility=\"visible\";\n\t\t\tif((obj==\"View\") )\n\t\t\t{\t//(licence_key==\"ORPV\") Only For Alrabha Version(Pharmacy Version) to load the Pharamacy Tab\n\t\t\t\tcolorChange(obj);\n\t\t\t\t/*parent.refusal_main_label.location.href = \"../../eOR/jsp/RefusalOrderResultLabel.jsp?";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&patient_id=\"+patient_id;\n \t\t\t\tparent.refusal_main_result.location.href = \"../../eOR/jsp/RefusalOrdersViewCurrentResults.jsp?";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&patient_id=\"+patient_id;*/\n\t\t\t\t//parent.document.getElementById(\"Refusal_order_main\").rows=\"9%,15%,6%,65%\";\n \t\t\t\tparent.document.getElementById(\"refusal_main\").style.height=\"11vh\";\n \t\t\t\tparent.document.getElementById(\"refusal_main_search\").style.height=\"15vh\";\n \t\t\t\tparent.document.getElementById(\"refusal_main_label\").style.height=\"4vh\";\n \t\t\t\tparent.document.getElementById(\"refusal_main_result\").style.height=\"65vh\";\n \t\t\t\t\n\t\t\t\t//parent.refusal_main_search.location.href =\"../../eOR/jsp/RefusalOrderExistingSearch.jsp?";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&patient_id=\"+patient_id;\n\t\t\t\n\t\t\t\tparent.refusal_main_search.location.href =\"../../eOR/jsp/RefusalOrderExistingSearch.jsp?patient_id=\"+patient_id;\n \t\t\t\t\n   \t\t  \t\tparent.refusal_main_label.location.href = \"../../eCommon/html/blank.html\";\n   \t\t  \t\tparent.refusal_main_result.location.href = \"../../eCommon/html/blank.html\";\n\t\t\t}\n\t\t\telse if( obj==\"Refusal\" )\n\t\t\t{\n\t\t\t\tcolorChange(obj);\n\t\t\t\t//parent.document.getElementById(\"Refusal_order_main\").rows=\"11%,0%,0%,89%\";//As this has been removed for iFrame\n\t\t\t\tparent.document.getElementById(\"refusal_main\").style.height=\"11vh\";\n\t\t\t\tparent.document.getElementById(\"refusal_main_search\").style.height=\"0vh\";\n\t\t\t\tparent.document.getElementById(\"refusal_main_label\").style.height=\"0vh\";\n\t\t\t\tparent.document.getElementById(\"refusal_main_result\").style.height=\"62vh\";\n\n\t\t\t \n\t\t\t\tparent.refusal_main_search.location.href = \"../../eCommon/html/blank.html\";\n   \t\t  \t\tparent.refusal_main_label.location.href = \"../../eCommon/html/blank.html\";\n   \t\t   \t\tparent.refusal_main_result.location.href = \"../../eOR/jsp/RefusalOrders.jsp?";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&patient_id=\"+patient_id;\n   \t\t  \t\t\n\t\t\t\n\t\t  \t}\n\t\t\t}else{\n\t\t\t\tdocument.getElementById(\"tab\").style.visibility=\"hidden\";\n\t\t\t\tdocument.refusaltab_form.patientId.focus();\n\t\t\t\tparent.refusal_main_search.location.href=\"../../eCommon/html/blank.html\";\t\n\t\t\t\tparent.refusal_main_label.location.href=\"../../eCommon/html/blank.html\";\t\n\t\t\t\tparent.refusal_main_result.location.href=\"../../eCommon/html/blank.html\";\t\n\t\t\t \n\t\t\t\t\n\t\t\t}\n\t\t\tif(top.content)\n\t\t\t\ttop.content.messageFrame.location.href = \"../../eCA/jsp/error1.jsp\";\n\t\t}\n\n\t\tfunction colorChange(obj) {\n\t\t\t/*if(document.refusaltab_form.all.viewRefusal){\n\t\t\t\tdocument.refusaltab_form.all.viewRefusal.className  = \"CAFIRSTSELECTHORZ\";\n\t\t\t\talert(\'here\');\n\t\t\t}if(document.refusaltab_form.all.refusalType){\n\t\t\t\tdocument.refusaltab_form.all.refusalType.className\t\t= \"CASECONDSELECTHORZ\";\n\t\t\t\talert(\'hereeeeeeeeeeeeeee\');\n\t\t\t}*/\n\t\t\tif(obj==\'View\'){\n\t\t\t\t//document.refusaltab_form.all.viewRefusal.className  = \"CASECONDSELECTHORZ\";\n\t\t\t\tdocument.getElementById(\"viewRefusal\").className  = \"CASECONDSELECTHORZ\";\n\t\t\t\tdocument.getElementById(\"refusalType\").className  = \"CAFIRSTSELECTHORZ\";\n\t\t\t\t//document.refusaltab_form.all.refusalType.className\t\t= \"CAFIRSTSELECTHORZ\";\n\t\t\t\t//alert(\'here\');\n\t\t\t}else if(obj==\'Refusal\'){\n\t\t\t\t//document.refusaltab_form.all.viewRefusal.className  = \"CAFIRSTSELECTHORZ\";\n\t\t\t\t//document.refusaltab_form.all.refusalType.className\t\t= \"CASECONDSELECTHORZ\";\n\t\t\t\tdocument.getElementById(\"viewRefusal\").className  = \"CAFIRSTSELECTHORZ\";\n\t\t\t\tdocument.getElementById(\"refusalType\").className  = \"CASECONDSELECTHORZ\";\n\t\t\t\t//alert(\'hereeeeeeeeeeeeeee\');\n\t\t\t}\n\t\t}\n\t\tfunction changeColor(obj,from_name)\n\t\t{\n\t\t\t\n\t\t\tif(from_name==\"COMMON\")\n\t\t\t\tcellref = document.getElementById(\"tab\").rows[0].cells\n\t\t\tfor(i=0; i<cellref.length; i++)\n\t\t\t{\n\t\t\t\tif(i!=2 && i!=3)\n\t\t\t\t cellref[i].className = \'CAFIRSTSELECTHORZ\'\n\t\t\t}\n\t\t\tobj.className = \"CASECONDSELECTHORZ\"\n\t\t\tcurrClass =\"CASECONDSELECTHORZ\";\n\t\t}\n\t\tfunction callOnMouseOver(obj){\n\t\tcurrClass = obj.className ;\n\t\t obj.className = \'CASECONDSELECTHORZ\';\n\t\t \n\t\t}\n\nfunction callOnMouseOut(obj){\n\tobj.className = currClass;\n}\n\t</script>\n\t<STYLE TYPE=\"text/css\"></STYLE>\n </head>\n ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n<body onLoad=\"change_common_tab(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\')\"  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n\t\t\t\t<!-- <body onLoad=\"change_common_tab(\'NewOrders\',\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\',\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\',\'ON_LOAD\')\"  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"> -->\n\n<form name=\"refusaltab_form\" id=\"refusaltab_form\">\n\t<table id=\"\" cellspacing=0 cellpadding=\"3\" border=\"0\" width=\'100%\' align=\"center\">\n\t\n\t<tr style=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" >\t\n\t\t\t\t<td  class=\'label\' id=\'id_locn\'   width=\'25%\' nowrap  style=\"\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t\t<td class=\'fields\' width=\'25%\' > \n\t\t\t\t\t<input type=\'text\'  name=\'patientId\' id=\'patientId\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' nowrap onKeyPress=\'return CheckForSpecChars(event)\' size=\"20\" maxlength=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" onBlur=\"ChangeUpperCase(this);populatePatientDetails(this,\'refusal_tab\');\"><input  class=\'button\' type=button name=search value=\'?\'   tabIndex=\"4\" onClick=\"callPatientSearch1()\"><img src=\"../../eCommon/images/mandatory.gif\">\n\t\t\t\t</td>\n\t\t\t\t<td  class=\'label\' id=\'short_name_id\'  colspan=\"0\" width=\'\' nowrap align=\'center\'><!-- Patient Name&nbsp;&nbsp; --></td>\n\t\t\t\t\n\t\t\t\t<td class=\"fields\" width=\'50%\'><label id=\"result_name\" ></label></td>\n\t\t\t\t\t\t\t\n\t</tr>\n</table>\n\t<tr>\n\t<td class=\"label\">\n\t<table id=\"tab\" cellspacing=0 cellpadding=\"3\" border=\"0\" width=\'30%\' align=\"left\">\n\t<tr>\n\t\t<td id=\"viewRefusal\" width=\'50%\' class=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onclick=\"changeColor(this,\'COMMON\')\" nowrap><a  style=\'color:white;cursor:pointer\' href=\"javascript:change_common_tab(\'View\')\"> ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</a></td>\n\t\t<td id=\"refusalType\" width=\'50%\' class=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"  onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onclick=\"changeColor(this,\'COMMON\')\" nowrap><a style=\'color:white;cursor:pointer\' href=\"javascript:change_common_tab(\'Refusal\')\"> ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</a></td>\n\t\t</tr>\n\t\t</table>\n\t</td>\n\t\t<td class=\"label\">&nbsp;</td>\n\t\t<td class=\"label\">&nbsp;</td>\n\t\t</tr>\n\t\n\t\n\t</table>\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t<input type=\"hidden\" name=\"qry_str\" id=\"qry_str\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\n\t<input type=\"hidden\" name=\"module_id\" id=\"module_id\" value=\"\">\n</form>\n</body>\n</html> \n\n \n\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );
	
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
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block14Bytes, _wl_block14);
 String locale = ((String)session.getAttribute("LOCALE"));	
            _bw.write(_wl_block1Bytes, _wl_block1);

	
	String encounter_id			= request.getParameter("episode_id");
	String class_name_first		= "";
	String patient_id = (request.getParameter("patient_id")==null) ? "":request.getParameter("patient_id");
	//out.println("<script>alert('patient_id="+patient_id+"');</script>");
	String tab_name = (request.getParameter("tab_name")==null) ? "View":request.getParameter("tab_name");	
	String bean_id = "refusalOrdersBean" ;
	String bean_name = "eOR.RefusalOrdersBean";
	RefusalOrdersBean bean = (RefusalOrdersBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(localeName);
	int patient_id_length = 0;
	patient_id_length = bean.getPatientIdLength();
	
	

// Till here 21/05/2003

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(tab_name));
            _bw.write(_wl_block16Bytes, _wl_block16);
//=licence_key
            _bw.write(_wl_block17Bytes, _wl_block17);
//=function_from
            _bw.write(_wl_block18Bytes, _wl_block18);
//=id_locn_style
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( patient_id ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf( patient_id_length ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(class_name_first));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(class_name_first));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block33Bytes, _wl_block33);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderEntryTabs.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ExistingRefusal.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.NewRefusal.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
