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

public final class __ivamendadmindetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/IVAmendAdminDetail.jsp", 1709120878926L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\n<HTML>\n<HEAD>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' type=\'text/css\'></link>\n\n\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link> \n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/messages.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/PhMessages.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/DrugNameCommonLookup.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/IVPrescriptionWithAdditives.js\"></SCRIPT>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n</HEAD>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<BODY onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" > \n<form name=\"formIVPrescriptionAdminDetail\" id=\"formIVPrescriptionAdminDetail\">\n\n\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\">\n\t\t<th align=\"left\" colspan=\"11\"><font style=\"font-size:9\"><fmt:message key=\"ePH.AdministrationDetails.label\" bundle=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"/></font></th>\n\t\t<tr>\n\t\t<td align=\'right\' width=\'15%\' class=\'label\'><fmt:message key=\"ePH.InfusionRate.label\" bundle=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"/>&nbsp;&nbsp;</td>\n\t\t<td align=\"left\" >\n\t\t<input type=\"text\" width=\'3%\' class=\"number\" size=\"2\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" maxlength=\"3\" name=\"INFUSION_VALUE\" onBlur=\"CheckNum(this);setInfusion_uom();setInfuseOverValue()\" onKeyPress=\"return allowValidNumber(this,event,3,0);\" ><label align=\"left\"  width=\'2%\' class=\'label\' id=\'infusion_uom_display\'></label></td>\n\t\t<td align=\'right\' width=\'15%\' class=\'label\'><fmt:message key=\"ePH.InfuseOver.label\" bundle=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"/>&nbsp;&nbsp;</td>\n\t\t<td align=\"left\" >\n\t\t<input type=\"text\"  width=\'3%\' class=\"number\" size=\'1\' maxlength=\"2\" name=\"INFUSION_PERIOD_VALUE\" id=\"INFUSION_PERIOD_VALUE\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" onKeyPress=\"return allowValidNumber(this,event,2,0);\" tabindex=\'2\' onBlur=\"CheckNum(this);checkHr(INFUSION_PERIOD_VALUE);setInfuseRateValue()\" >\n\t\t\n\t\t<label align=\"left\"  width=\'5%\'class=\'label\'><b><fmt:message key=\"Common.hours.label\" bundle=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"/></b></label></td>\t\t\n\t\t\n\t\t<td align=\'right\' width=\'10%\' class=\'label\'><fmt:message key=\"Common.duration.label\" bundle=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"/>&nbsp;&nbsp;</td>\n\t\t<td align=\"left\" >\n\t\t<input type=\"text\" width=\'10%\' class=\"number\" size=\"1\" maxlength=\"2\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" name=\"DURN_VALUE\" onBlur=\"CheckNum(this);chkDuration(this,\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\')\" onKeyPress=\"return allowValidNumber(this,event,3,0);\" >\n\t\t</td>\n\t\t<td align=\"left\"  width=\'5%\'class=\'label\'><b><fmt:message key=\"Common.hours.label\" bundle=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"/></b></td>\t\t\n\t\t</tr>\n\t\t<tr>\n\t\t<td align=\'right\' class=\'label\'><fmt:message key=\"Common.StartTime.label\" bundle=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"/>&nbsp;&nbsp;</td>\n\t\t<td align=\"left\" >\n\t\t<input type=\"text\" name=\"START_DATE\" id=\"START_DATE\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" size=\"12\" maxlength=\"16\" tabindex=\'4\' onblur=\"resetInfuse()\"><img src=\"../../eCommon/images/CommonCalendar.gif\" id=Calendar onclick=\"showCalendar(\'START_DATE\',null,\'hh:mm\');return false;\" >&nbsp; <img src=\"../../eCommon/images/mandatory.gif\" ></img>\n\t\t</td>\n\t\t\n\t\t<td align=\'right\' class=\'label\'><fmt:message key=\"Common.EndTime.label\" bundle=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"/>&nbsp;&nbsp;</td>\n\t\t<td>\n\t\t<input type=\"text\" name=\"END_DATE\" id=\"END_DATE\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" size=\"12\" maxlength=\"12\" tabindex=\'5\' readonly>&nbsp; \n\t\t</td>\n\t\t<td align=\"left\"   class=\'label\' ></td>\n\t\t<td align=\"left\"   class=\'label\' ></td>\n\t\t<td align=\"left\"   class=\'label\' ></td>\n\t\t\n\t\n\t\t</tr>\n\t\t</table>\n\t\n\t\t\n\n<!--<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">-->\n\n<input type=\"hidden\" name=\"BEAN_ID\" id=\"BEAN_ID\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n<input type=\"hidden\" name=\"BEAN_NAME\" id=\"BEAN_NAME\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n<!--<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">-->\n\n<INPUT TYPE=\"hidden\" name=\"LOCN_TYPE\" id=\"LOCN_TYPE\" VALUE=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n<INPUT TYPE=\"hidden\" name=\"LOCN_CODE\" id=\"LOCN_CODE\" VALUE=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n<INPUT TYPE=\"hidden\" name=\"INFUSION_PERIOD_UOM\" id=\"INFUSION_PERIOD_UOM\" VALUE=\"H\" >\n<INPUT TYPE=\"hidden\" name=\"DURN_UNIT\" id=\"DURN_UNIT\" VALUE=\'H\'>\n<INPUT TYPE=\"hidden\" name=\"DURN_VALUE\" id=\"DURN_VALUE\" VALUE=\'\'>\n<INPUT TYPE=\"hidden\" name=\"INFUSION_UOM\" id=\"INFUSION_UOM\" VALUE=\'H\'>\n<INPUT TYPE=\"hidden\" name=\"FREQUENCY\" id=\"FREQUENCY\" VALUE = \'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n<input type=\"hidden\" name=\"freq_desc\" id=\"freq_desc\" value=\'\' >\n<input type=\"hidden\" name=\"sys_date\" id=\"sys_date\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n<input type=\"hidden\" name=\"drug_codes\" id=\"drug_codes\" value=\"\">\n<input type=\"hidden\" name=\"INFUSION_UOM_DISPLAY\" id=\"INFUSION_UOM_DISPLAY\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"PRACT_ID\" id=\"PRACT_ID\" VALUE=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n<input type=\"hidden\" name=\"EQVL_UOM_CODE\" id=\"EQVL_UOM_CODE\" value=\"\">\n<input type=\"hidden\" name=\"INFUSION_PER_UNIT\" id=\"INFUSION_PER_UNIT\" value=\"H\">\n\n\n\n</FORM>\n</HTML>\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);

	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");
	String patient_class	= request.getParameter("act_patient_class");
	String start_date		= request.getParameter("start_date");
		String mode				= request.getParameter("mode");

	String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setOrderDate(start_date);
	bean.setPatientClass(patient_class);
	bean.setPatId(patient_id);
	bean.setEncId(encounter_id);

	String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
	String or_bean_name		= "eOR.OrderEntryBean";
	OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	String locn_type	= (String)ORbean.getLocationType();
	String locn_code	= (String)ORbean.getLocationCode();
	String pract_id		= (String)ORbean.getPractitionerId();
	String order_id		= (String)ORbean.getOrderId();
	
	String freq_code    = "";
	//String durn_value	= "";
	//String durn_type	= "";

	String end_date		= "";
	String infuse_over	= "";
	String infusion_rate= "";

	String tot_infuse_over	= "";
	//String tot_infuse_over_unit	= "";
	
	HashMap hm_fluid_details = null;
	if(bean.getAmendFluidDetails()==null){
		bean.loadAmendDetails(order_id, patient_id,patient_class);
	}else if(bean.getAmendFluidDetails() !=null && (bean.getAmendFluidDetails()).size()==0){
		bean.loadAmendDetails(order_id, patient_id,patient_class);	
	}

	hm_fluid_details = bean.getAmendFluidDetails();

	if(hm_fluid_details !=null){
		if(hm_fluid_details.size()>0){
			freq_code	=	(String)hm_fluid_details.get("FREQ_CODE");
			//durn_value  =   (String)hm_fluid_details.get("DURN_VALUE");
			//durn_type	=	(String)hm_fluid_details.get("DURN_TYPE");
			start_date	=	(String)hm_fluid_details.get("START_DATE_TIME");
			end_date	=	(String)hm_fluid_details.get("END_DATE_TIME");
			infuse_over	=	(String)hm_fluid_details.get("INFUSE_OVER");
			infusion_rate	=	(String)hm_fluid_details.get("INFUSION_RATE");

			tot_infuse_over = (String)hm_fluid_details.get("TOT_INFUSION_OVER");
			//tot_infuse_over_unit = (String)hm_fluid_details.get("TOT_INFUSION_OVER_UNIT");
	
		}else{
			start_date	=	bean.getOrderDate();
		}
	}



            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(infusion_rate));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(infuse_over));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(tot_infuse_over));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf( bean_id ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf( patient_id ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf( encounter_id ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( locn_type ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( locn_code ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(freq_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf( pract_id ));
            _bw.write(_wl_block30Bytes, _wl_block30);

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
