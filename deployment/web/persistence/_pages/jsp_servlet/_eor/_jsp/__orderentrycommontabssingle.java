package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __orderentrycommontabssingle extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryCommonTabsSingle.jsp", 1743590218815L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head><title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/></link>\n\t<style>\n\t\t.HIDENEWORDERS\n\t\t{\n\t\t\tdisplay:none;\n\t\t}\n\t</style>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntry.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntrySearch.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryGlobal.js\"></script>\t\n\t<script language=\"JavaScript\" src=\"../../ePH/js/PrescriptionTest.js\"></script><!-- Used for Prescription -->\n\t<script language=\'javascript\' src=\'../../eBL/js/AddModifyPatFinDetails.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\n\t\t\n\t\tfunction change_common_tab(obj, licence_key, function_from,pharmacy_scope,called_from,multi_called_from)\n\t\t{ \n\t\t\t\n\t\t\tif((obj==\"ExistingOrders\" && licence_key==\"ORPV\" && called_from==\"ON_LOAD\"))\n\t\t\t{\n\t\t\t\tcolorChange();\n\t\t\t\t\n\t\t\t\tparent.orderDetailFrame.location.href = \"../../eOR/jsp/OrderEntryByPractitioner.jsp?";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&licence_key=\"+licence_key+\"&called_from=\"+called_from;\n\t\t\t}\n\t\t\telse if( obj==\"ExistingOrders\" && (function_from!=\"EXTERNAL_ORDER\" || function_from!=\"MULTI_PATIENT_ORDERS\" || function_from!=\"CP\" || function_from!=\"MO\"|| function_from!=\"REPLACE_ADD\" )  )\n\t\t\t{\t\t\t\n\t\t\t\tif(pharmacy_scope!=\'\' && pharmacy_scope==\'PH\')\n\t\t\t\t{\n\t\t\t\t\tcolorChange();\n\t\t\t\t\tparent.orderDetailFrame.location.href = \"../../eOR/jsp/OrderEntryByPractitioner.jsp?";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&licence_key=\"+licence_key+\"&called_from=\"+called_from+\"&pharmacy_scope=\"+pharmacy_scope;\n\t\t\t\t}\n\t\t\t\telse if(obj==\"ExistingOrders\")\n\t\t\t\t{\n   \t\t  \t\t\tparent.orderDetailFrame.location.href = \"../../eOR/jsp/ExistingOrder.jsp?";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&licence_key=\"+licence_key+\"&called_from=\"+called_from+\"&function_from=\"+function_from;\n\n\t\t\t\t\tif(multi_called_from==\"MULTI_PATIENT_ORDER\")\n\t\t\t\t\t{\n\t\t\t\t\t\tif(document.OrCommonForm.newOrders)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.OrCommonForm.newOrders.style.display = \"none\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\n\t\t\t\t}\n\t\t\t\t\n\t\t  \t}\t\t\t\n\t\t\telse if(obj==\"NewOrders\")\n\t\t\t{\n\t\t\t\tparent.orderDetailFrame.location.href = \"../../eOR/jsp/OrderEntryByPractitioner.jsp?";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&licence_key=\"+licence_key+\"&called_from=\"+called_from;\n\t\t\t}\n\t\t\telse\n\t\t\t\t{\n   \t\t  \t\t\tparent.orderDetailFrame.location.href = \"../../eOR/jsp/ExistingSingleOrder.jsp?";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&licence_key=\"+licence_key+\"&called_from=\"+called_from+\"&function_from=\"+function_from;\n\n\t\t\t\t\tif(multi_called_from==\"MULTI_PATIENT_ORDER\")\n\t\t\t\t\t{\n\t\t\t\t\t\tif(document.OrCommonForm.newOrders)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tdocument.OrCommonForm.newOrders.style.display = \"none\";\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\n\t\t\t\t}\n\n\t\t\tif(top.content)\n\t\t\t\ttop.content.messageFrame.location.href = \"../../eCA/jsp/error1.jsp\";\n\t\t}\n\n\t\tfunction colorChange() \n\t\t{\n\t\t\tif(document.OrCommonForm.existingOrders)\n\t\t\t\tdocument.OrCommonForm.existingOrders.className  = \"CAFIRSTSELECTHORZ\";\n\t\t\tif(document.OrCommonForm.newOrders)\n\t\t\t\tdocument.OrCommonForm.newOrders.className\t\t= \"CASECONDSELECTHORZ\";\n\t\t}\n\n\t</script>\n\t<STYLE TYPE=\"text/css\"></STYLE>\n </head>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\t\t\t\n\t\t\t\t<body onLoad=\"change_common_tab(\'\',\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\',\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\',\'ON_LOAD\',\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\')\"  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\n\t\t\t\t<body onLoad=\"change_common_tab(\'ExistingOrders\',\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\',\'\',\'ON_LOAD\',\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\n<form name=\"OrCommonForm\" id=\"OrCommonForm\">\n\t<table id=\"tab\" cellspacing=0 cellpadding=\"3\" border=\"0\" align=center width=\"100%\">\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t<tr>\n\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" \n\t\t\t\t\t<td id=\"existingOrders\" \tclass=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onclick=\"changeColor(this,\'COMMON\')\" nowrap><a  style=\'color:white;cursor:pointer\' href=\"javascript:change_common_tab(\'\',\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\',\'\',\'ON_CLICK\',\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\')\">One Day - Continue</a></td>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t<td id=\"ExistingOrders\" \tclass=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"  style=\"display:\" onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onclick=\"changeColor(this,\'COMMON\')\" nowrap><a style=\'color:white;cursor:pointer\' href=\"javascript:change_common_tab(\'ExistingOrders\',\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\')\"> ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</a></td>\n\t\t\t\t\t\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\t\t\t\n\t\t<td class=\"LABEL\" width=\"100%\"></td>\n\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t<td class=\"COMMON_BUTTONS\"  width=\"30%\" style=\"display:none\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" <input type=\"button\" name=\"drug_profile\" id=\"drug_profile\" class=\"BUTTON\" value =\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" onClick=\'callDrugProfile(\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\")\'  >";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="<input type=\"button\" name=\"allergies\" id=\"allergies\" class=\"BUTTON\" value =\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" onClick=\'callAllergies(\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\")\' ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="  ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" ><input type=\'button\' name=\'active\' id=\'active\' class=\'BUTTON\' value =\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' onClick=\'callActive(\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\",\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="><input type=\'button\' name=\'demographic\' id=\'demographic\' class=\'BUTTON\' value =\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' onClick=\'callDemographic(\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="></td>\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t</tr>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t<script>\n\t\t\t\talert(getMessage(\"OR_MODULE_INSTALL\",\"OR\"));\n\t\t\t\tdocument.location.href = \"../../eCommon/html/blank.html\";\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t</table>\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t<input type=\"hidden\" name=\"location_type\" id=\"location_type\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t<input type=\"hidden\" name=\"location_code\" id=\"location_code\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t<input type=\"hidden\" name=\"bed_num\" id=\"bed_num\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t<input type=\"hidden\" name=\"room_num\" id=\"room_num\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t<input type=\"hidden\" name=\"module_id\" id=\"module_id\" value=\"\"><!-- Used to identify from which tab(Lab,Radiology,Treatment) it is currently used,  -->\n\t<input type=\"hidden\" name=\"ph_load_yn\" id=\"ph_load_yn\" value=\"\"><!-- Used by Pharmacy Module(To identify if it is coming inside the Pharmacy Orders,first time) -->\n\t<input type=\"hidden\" name=\"ph_priority\" id=\"ph_priority\" value=\"\"><!-- Used by Pharmacy Module(To identify if it is coming inside the Pharmacy Orders,first time) -->\n\t<input type=\"hidden\" name=\"ph_order_date_time\" id=\"ph_order_date_time\" value=\"\"><!-- Used by Pharmacy Module(To identify if it is coming inside the Pharmacy Orders,first time) -->\n\t<input type=\"hidden\" name=\"params\" id=\"params\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t<input type=\"hidden\" name=\"called_from\" id=\"called_from\" value=\"ON_LOAD\">\n\t<input type=\"hidden\" name=\"licence_key\" id=\"licence_key\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n</form>\n</body>\n</html> \n\n \n\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eOR.OrderEntryQueryBean beanQueryObj= null;{
                beanQueryObj=(eOR.OrderEntryQueryBean)pageContext.getAttribute("beanQueryObj");
                if(beanQueryObj==null){
                    beanQueryObj=new eOR.OrderEntryQueryBean();
                    pageContext.setAttribute("beanQueryObj",beanQueryObj);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block14Bytes, _wl_block14);
	
	String params					= request.getQueryString() ;
   	String bed_num                  = beanQueryObj.checkForNull(request.getParameter("bed_num"),"");
	String room_num                 = beanQueryObj.checkForNull(request.getParameter("room_num"),"");
	String patient_id				= request.getParameter("patient_id");
	String encounter_id				= request.getParameter("episode_id");
	
	String multi_bean_id 			= "Or_MultiPatientOrders";
	String multi_bean_name 			= "eOR.MultiPatientOrdersBean";
	String facility_id				= (String)session.getValue("facility_id");
	Properties properties			= (Properties) session.getValue( "jdbc" );
	beanQueryObj.setLanguageId(localeName);	
	
	String function_from			= beanQueryObj.checkForNull(request.getParameter("function_from"),"");
 	
	ArrayList multi_patient_details	=  null;
	if(function_from != null && function_from.equals("MULTI_PATIENT_ORDERS")) 
	{
		MultiPatientOrdersBean multi_bean = (MultiPatientOrdersBean)getBeanObject( multi_bean_id, multi_bean_name, request ) ;
		
		multi_patient_details	= multi_bean.getMultiPatientDetails();
		
	}
	String responsibility_id		= (String) session.getValue("responsibility_id");
	String ammend_called_from 		= beanQueryObj.checkForNull(request.getParameter("ammend_called_from"),"");
	String multi_called_from 		= beanQueryObj.checkForNull(request.getParameter("multi_called_from"),"");
	if(!ammend_called_from.equals(""))
		ammend_called_from 			= ammend_called_from.trim();
	if(!multi_called_from.equals(""))
		multi_called_from 			= multi_called_from.trim();
	String relationship_id			= beanQueryObj.checkForNull(request.getParameter("relationship_id"),"");
	String p_called_from_ca			= beanQueryObj.checkForNull(request.getParameter("p_called_from_ca "),"");
	String or_module_install_yn		= beanQueryObj.checkForNull(beanQueryObj.getFacilityModuleInstallYn("OR", facility_id, properties),"N");
 	String ph_module_install_yn		= beanQueryObj.checkForNull(beanQueryObj.getFacilityModuleInstallYn("PH", facility_id, properties),"N");
	
	String function_id				= beanQueryObj.checkForNull(request.getParameter("function_id"),"ORDERS");
  	
  	String licence_key				= eOR.OR_license_rights.getKey(); // Get the Licence Key from the Class
	String allergy_display_yn 		= "";
	String active_display_yn 		= "";
	String demography_display_yn 	= "";
	
	String disabledField			= "";
	String disp_patient_id			= patient_id;
	
	String practitioner_id    		= (String) session.getValue("ca_practitioner_id");
	String login_user               = (String) session.getValue("login_user");
	String patient_class			= beanQueryObj.checkForNull(request.getParameter("patient_class"),"");

	String class_name_first			= "";

	String record[]					= null;
	if (practitioner_id == null || practitioner_id.equals("null") || practitioner_id.equals("")) 
	{
	   String [] practitioner_details = beanQueryObj.getPractitionerDetails(properties, login_user);
	   if (practitioner_details.length == 2) 
		{
	       practitioner_id		= practitioner_details[0];
	    } 
	}
	ArrayList MainTabsHdg		= beanQueryObj.getMainTabs(properties, practitioner_id, patient_class, function_id); 
	
	String pharmacy_scope = beanQueryObj.checkForNull(request.getParameter("p_scope"),"");


            _bw.write(_wl_block1Bytes, _wl_block1);

	if(MainTabsHdg!=null && MainTabsHdg.size() > 0 ) 
	{
		for(int i=0; i<MainTabsHdg.size(); i++)
		{
			record = (String[])MainTabsHdg.get(i);
					
			if((record[0].equalsIgnoreCase("existingOrders")) && (!(function_from.equals("AMEND_ORDER") || function_from.equals("EXTERNAL_ORDER") || function_from.equals("COPY_ORDER") || function_from.equals("MULTI_PATIENT_ORDERS") || function_from.equals("CP") || function_from.equals("MO") ||  function_from.equals("REPLACE_ADD") || function_from.equals("RENEW_ORDER"))))
			{ 			
				
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(licence_key));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(pharmacy_scope));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(multi_called_from));
            _bw.write(_wl_block18Bytes, _wl_block18);

			}
			else if((record[0].equalsIgnoreCase("newOrders")) && (!(function_from.equals("PASSED_ORDERS")) ) )  
			{
				
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(licence_key));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(multi_called_from));
            _bw.write(_wl_block18Bytes, _wl_block18);

			} 
		} 
	}

            _bw.write(_wl_block21Bytes, _wl_block21);

	String location_type 			= request.getParameter("location_type");
	if(location_type!=null && location_type.equalsIgnoreCase("W"))
		location_type	 			= "N";
	String location_code 			= request.getParameter("location_code");
	if(or_module_install_yn.equals("Y"))
	{

            _bw.write(_wl_block22Bytes, _wl_block22);

		if(MainTabsHdg!=null && MainTabsHdg.size() > 0 ) 
		{
			for(int i=0; i<MainTabsHdg.size(); i++)
			{
				record					= (String[])MainTabsHdg.get(i);
				class_name_first		= "CAFIRSTSELECTHORZ";
				if(i==0 || (function_from.equals("EXTERNAL_ORDER") || function_from.equals("CP") || function_from.equals("MO") || function_from.equals("REPLACE_ADD" )) )	// Only for the first record
					class_name_first	= "CASECONDSELECTHORZ";
				if((record[0].equalsIgnoreCase("existingOrders")) && (!(function_from.equals("AMEND_ORDER") || function_from.equals("EXTERNAL_ORDER") || function_from.equals("MULTI_PATIENT_ORDERS") || function_from.equals("CP") || function_from.equals("MO") || function_from.equals("REPLACE_ADD") || function_from.equals("RENEW_ORDER") )) ) 
				{  //Name (record[0] --> Sys_tab_name --> System defined 
				
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(class_name_first));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(licence_key));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(multi_called_from));
            _bw.write(_wl_block26Bytes, _wl_block26);
 			} 
				else if((record[0].equalsIgnoreCase("newOrders"))) //&& (!(function_from.equals("PASSED_ORDERS")) ) )
				{  
					if((function_from.equals("PASSED_ORDERS")) &&(multi_called_from.equals("MULTI_PATIENT_ORDER")))
					{
					}
					else
					{

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(class_name_first));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(licence_key));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(multi_called_from));
            _bw.write(_wl_block29Bytes, _wl_block29);
 if(function_from.equalsIgnoreCase("AMEND_ORDER")) out.println("Amend Orders"); else out.println("Existing Orders"); 
            _bw.write(_wl_block30Bytes, _wl_block30);
			} 
			  }
			} // End of for
	   } // End of MainTabsHdg

            _bw.write(_wl_block1Bytes, _wl_block1);
			// To check whether the user has access to view or not , other wise button gets disabled
		if(p_called_from_ca.equals("Y"))
		{
			//if(ph_module_install_yn.equals("Y"))
			//	drug_display_yn		= beanQueryObj.getMenu("PAT_DRUG_PROFILE",responsibility_id,relationship_id);
			allergy_display_yn 		= beanQueryObj.getMenu("ALLERGY_LST",responsibility_id,relationship_id, properties);
			active_display_yn 		= beanQueryObj.getMenu("PROBLEM_LST",responsibility_id,relationship_id, properties);
			demography_display_yn 	= beanQueryObj.getMenu("DEMOGRAPY_VIEW",responsibility_id,relationship_id, properties);
		}			
		
            _bw.write(_wl_block31Bytes, _wl_block31);

			if(multi_patient_details==null || (multi_patient_details!=null && multi_patient_details.size()==1) ) 
			{
				if(multi_patient_details!=null && multi_patient_details.size() > 0)
				{
				  record					= (String[]) multi_patient_details.get(0);
				  disp_patient_id			=  beanQueryObj.checkForNull(record[0],"");	// FIRST One Patient_id, Second --> encounter-id, third-->patient_class
				}
				
            _bw.write(_wl_block32Bytes, _wl_block32);
if(ph_module_install_yn.equals("Y")){
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugProfile.label","common_labels")));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
 } 
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Allergies.label","common_labels")));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(disp_patient_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
if(allergy_display_yn.equals("X")) out.println("DISABLED");
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(disabledField));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ActiveProblems.label","common_labels")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(disp_patient_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
if(active_display_yn.equals("X")) out.println("DISABLED");
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(disabledField));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Demographics.label","common_labels")));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(disp_patient_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
if(demography_display_yn.equals("X")) out.println("DISABLED");
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(disabledField));
            _bw.write(_wl_block45Bytes, _wl_block45);
 
		} // end of   multi_patient_details

            _bw.write(_wl_block46Bytes, _wl_block46);
} 
	   else 
	   {
	
            _bw.write(_wl_block47Bytes, _wl_block47);
		
		}
		
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(bed_num));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(room_num));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(params));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(licence_key));
            _bw.write(_wl_block56Bytes, _wl_block56);
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
}
