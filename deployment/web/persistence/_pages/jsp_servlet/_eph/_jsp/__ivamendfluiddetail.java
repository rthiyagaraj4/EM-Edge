package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import eOR.*;
import ePH.Common.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __ivamendfluiddetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/IVAmendFluidDetail.jsp", 1709120884434L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block3 ="\n\n\n<HTML>\n<HEAD>\n\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' type=\'text/css\'></link>\n\n\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link> \n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/messages.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/PhMessages.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/DrugNameCommonLookup.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/IVPrescriptionWithAdditives.js\"></SCRIPT>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n</HEAD>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<BODY onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" > \n<form name=\"formIVPrescriptionDetails\" id=\"formIVPrescriptionDetails\">\n\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\">\n\t<th align=\"left\" colspan=\"5\"><font style=\"font-size:9\"><fmt:message key=\"ePH.Fluid.label\" bundle=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"/></font></th>\n\t<tr>\n\t\t<td   width=\'45%\' align=\"left\">\n\t\t\t<input type=\"hidden\" name=\"fluid_code\" id=\"fluid_code\" VALUE=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\n\t\t\t&nbsp;<input type=\"text\" name=\"fluid_name\" id=\"fluid_name\" VALUE=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" size=\"40\" maxlength=\"60\" onblur=\"checkValidDrug(\'F\', this.value)\" ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="><input type=\"button\" class=\"button\" name=\"fluid_search\" id=\"fluid_search\" value=\"?\" onclick=\"searchIVFluid(formIVPrescriptionDetails,\'D\', fluid_name)\" ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =">\n\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" ></img>\n\t\t</td>\n\t\t<td   width=\'8%\' align=\"left\" class=\"label\">&nbsp;&nbsp;<fmt:message key=\"Common.volume.label\" bundle=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"/>: </td>\n\t\t<input type=\"hidden\" name=\"stock_uom_code\" id=\"stock_uom_code\" VALUE=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" >\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n\t\t\t<td class=\'label\' align=\'left\' id=\'stock_display\' width=\'22%\'><b></b></td>\n\t\t\t<input type=\"hidden\" name=\"stock_value\" id=\"stock_value\" VALUE=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\n\t\t\t<td class=\'label\' align=\'left\' id=\'stock_display\' width=\'22%\'><b></b></td>\n\t\t\t\n\t\t\t<input type=\"hidden\" name=\"stock_value\" id=\"stock_value\" VALUE=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\n\t\t\n\t\t</td>\n\t\t<td class=\'label\' align=\'center\' width=\'25%\'><fmt:message key=\"Common.IVAdmixture.label\" bundle=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"/>&nbsp;<input type=\"checkbox\" name=\"admixture\" id=\"admixture\" onClick=\"setAdmixtureValue(formIVPrescriptionDetails);\"></td>\n\t\t</tr>\n\t\t<th align=\"left\" colspan=\"5\"><font style=\"font-size:9\">Additive(s)/Drug(s)</font></th>\n\t\t\t\n\t\t\n\t\n\t\t</table>\n<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n<input type=\"hidden\" name=\"form_code\" id=\"form_code\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n<input type=\"hidden\" name=\"route_code\" id=\"route_code\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n<input type=\"hidden\" name=\"base_uom\" id=\"base_uom\" value=\"\">\n\n<input type=\"hidden\" name=\"eqvl_uom_value\" id=\"eqvl_uom_value\" value=\"\">\n<input type=\"hidden\" name=\"ORDER_TYPE_CODE\" id=\"ORDER_TYPE_CODE\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n<input type=\"hidden\" name=\"STOCK_VALUE\" id=\"STOCK_VALUE\" value=\"\">\n<input type=\"hidden\" name=\"STOCK_UOM_CODE\" id=\"STOCK_UOM_CODE\" value=\"\">\n\n<!--<input type=\"hidden\" name=\"drug_codes\" id=\"drug_codes\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">-->\n</FORM>\n</HTML>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t<script>\n\t\t\tvar bean_id\t\t\t= document.getElementById(\"bean_id\").value;\n\t\t\tvar bean_name\t\t= document.getElementById(\"bean_name\").value;\n\t\t\tvar qryString\t\t= bean_id+\"&bean_name=\"+bean_name+\"&validate=STOCKDETAILS&drug_code=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&base_uom=MLL\";\n\t\t\tsubmitXML(qryString, \"\");\n\t\t</script>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );
	
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
        response.setHeader("Content-Type", "text/html;");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;");
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
            _bw.write(_wl_block3Bytes, _wl_block3);

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);


request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");

	String patient_class	= request.getParameter("act_patient_class");
	
	String iv_option		= request.getParameter("iv_option") == null ? "":request.getParameter("iv_option");

	String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
	String or_bean_name		= "eOR.OrderEntryBean";
	OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	String order_id			= (String)ORbean.getOrderId();
	String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject( bean_id, bean_name, request ) ;

	HashMap hm_fluid_details = null;
	if(bean.getAmendFluidDetails()==null){
		bean.loadAmendDetails(order_id, patient_id,"");   // RUT-CRF-0062
	}else if(bean.getAmendFluidDetails() !=null && (bean.getAmendFluidDetails()).size()==0){
		bean.loadAmendDetails(order_id, patient_id,"");  // RUT-CRF-0062
	}
	
	hm_fluid_details = bean.getAmendFluidDetails();

	if(order_id != null || !order_id.equals("") ){
		bean.setOrderID(order_id);		
	}

	String fluid_code = "";
	String fluid_name = "";
	String disableField="";
	String stock_uom_code = "";
	String stock_value ="";
	//String stock_uom   ="";
	//String infuse_over	= "";
	//String infuse_over_unit	= "";

	//String or_mode	=	"";
	String route_code = "";
	String form_code  = "";
	String order_type_code = "";
	if(hm_fluid_details != null){
		if(hm_fluid_details.size()>0){
			disableField = "disabled";
			fluid_code = (String)hm_fluid_details.get("DRUG_CODE");
			fluid_name = (String)hm_fluid_details.get("CATALOG_DESC");
			stock_value	= (String)hm_fluid_details.get("ORDER_QTY");
			//stock_uom   = (String)hm_fluid_details.get("SHORT_DESC");
			//infuse_over	=	(String)hm_fluid_details.get("INFUSE_OVER");
			//infuse_over_unit = (String)hm_fluid_details.get("INFUSE_OVER_UNIT");

			//or_mode = "or_amend";
			route_code = (String)hm_fluid_details.get("ROUTE_CODE");
			form_code  = (String)hm_fluid_details.get("FORM_CODE");
			order_type_code = (String)hm_fluid_details.get("ORDER_TYPE_CODE");
		}
	}
		

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(fluid_code));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(fluid_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(disableField));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(disableField));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(stock_uom_code));
            _bw.write(_wl_block13Bytes, _wl_block13);

		if (bean.checkForStock()) {
			if (iv_option.equals("Y")) {
		
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(stock_value));
            _bw.write(_wl_block15Bytes, _wl_block15);

		}
		else {
		
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(stock_value));
            _bw.write(_wl_block15Bytes, _wl_block15);

		}
		
            _bw.write(_wl_block16Bytes, _wl_block16);

		}
		else {
		
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(stock_value));
            _bw.write(_wl_block18Bytes, _wl_block18);

		}
		
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(form_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(route_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf( bean_id ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( patient_id ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf( encounter_id ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( bean.getDrugCodes() ));
            _bw.write(_wl_block29Bytes, _wl_block29);

	if(fluid_code!=null && !fluid_code.equals("")){

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(fluid_code));
            _bw.write(_wl_block31Bytes, _wl_block31);

	}

            _bw.write(_wl_block1Bytes, _wl_block1);

putObjectInBean(bean_id,bean,request);
putObjectInBean(or_bean_id,ORbean,request);

            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
