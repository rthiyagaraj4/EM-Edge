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
import java.util.*;
import com.ehis.util.*;

public final class __ivpiggybackvehicle extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/IVPiggyBackVehicle.jsp", 1743130615441L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
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

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\n\t\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link> \n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script> \n\t\t<script language=\"javascript\" src=\"../js/DrugNameCommonLookup.js\"></script>\n\t\t<script language=\"javascript\" src=\"../js/IVPiggyBack.js\"></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<BODY onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" > \n\t\t<form name=\"formIVPiggyBackVehicle\" id=\"formIVPiggyBackVehicle\">\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\"4\"><font style=\"font-size:9\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</font></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"white\"></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"white\"></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"white\"></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr id=\"vehicle_det\" ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =">\n\t\t\t\t\t<td NOWRAP width=\"12\" class=\"label\"  ><img style=\"visibility:";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" id=\"fluid_ADR_img\" src=\'../../ePH/images/ADR.gif\' height =25 width =25 title=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' ></td>\n\t\t\t\t\t<td width=\'50%\' class=\"label\">\n\t\t\t\t\t\t&nbsp;";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" &nbsp;\n\t\t\t\t\t\t<select name = \"vehicle\" onchange=\"changeVehicle(\'this\',\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\');\"> <!-- param_volume_cal added for AAKH-CRF-0094-->\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' selected>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</option>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t<option value=\"\">---";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="---</option>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t</select><img id=\"mandatory\"src=\"../../eCommon/images/mandatory.gif\" ></img>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'vehicle_code\' id=\'vehicle_code\' value=\'\'>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t<img style=\"cursor:pointer;filter:Chroma(Color=#FFFFFF); \" src=\"../../ePH/images/FD-ICON-rollOverInformationIcon.gif\" height=20  width=20 onClick=\"openEDLDetails(vehicle.value);\" id=\"eldImg\">\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t<img style=\"cursor:pointer;filter:Chroma(Color=#FFFFFF); visibility=hidden \" src=\"../../ePH/images/FD-ICON-rollOverInformationIcon.gif\" height=20  width=20 onClick=\"openEDLDetails(vehicle.value);\" id=\"eldImg\">\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"label\">\n\t\t\t\t\t<A HREF title=\"Default Fluid has been altered\" onMouseOver=\"changeCursor(this);\" onClick=\"fluidRemarks();\" style=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\'remarks\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</A>&nbsp;<img style=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" id=\"mandatory1\" src=\"../../eCommon/images/mandatory.gif\" ></img></td>\n\t\t\t\t\t<td class=\"label\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t<!-- Added for CRF AAKH-CRF-0094 START -->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t<input type=\"text\" name=\"volume\" id=\"volume\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" size=\"5\" maxlength=\"5\" style=\"text-align:right\"  disabled>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" size=\"5\" maxlength=\"5\" style=\"text-align:right\" onblur=\"setFluidVolume(this); calInfuseOver();setSchedule(parent.f_iv_pb_admin_dtls.formIVPrescriptionAdminDetail.FREQUENCY.value);\" onKeyPress=\"return allowValidNumber(this,event,3,0);\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t <!-- Added for CRF AAKH-CRF-0094 END -->\n\t\t\t\t\t\t<input type=\"hidden\" name=\"volume_reference\" id=\"volume_reference\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" > <!-- Added for AAKH-CRF-0094 -->\n\t\t\t\t\t\t<input type=\"hidden\" name=\"volume_unit\" id=\"volume_unit\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" > <!-- replaced uom_desc with equvalent_uom_code for IN25615 --22/12/2010-- priya -->\n\t\t\t\t\t\t<label id=\"volume_unit_desc\" width=\"10%\"></label>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr height=\"4\"><td colspan=\"12\" ></td></tr>\n\t\t\t\t<div name=\"tooltiplayer\" id=\"tooltiplayer\" style=\"position:absolute; width:20%; visibility:hidden;\" bgcolor=\"blue\">\n\t\t\t\t<table id=\"tooltiptable\" cellpadding=0 cellspacing=0 border=\"0\" width=\"auto\" height=\"100%\" align=\"center\">\n\t\t\t\t<tr><td width=\"100%\" id=\"t\"></td></tr>\n\t\t\t\t</table>\n\t\t\t\t</div>\n\t\t\t</table>\n\t\t\t<input type=\"hidden\" name=\"ORDER_TYPE_CODE\" id=\"ORDER_TYPE_CODE\"\tvalue=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"\t>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t<input type=\"hidden\" name=\"amendmode\" id=\"amendmode\"\tvalue=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t<input type=\"hidden\" name=\"fluid_remarks\" id=\"fluid_remarks\"\tvalue=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"\t>\n\t\t\t<input type=\"hidden\" name=\"default_fluid_name\" id=\"default_fluid_name\"\tvalue=\"\"\t>\n\t\t\t<input type=\"hidden\" name=\"BASE_VOLUME\" id=\"BASE_VOLUME\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t\t\t<input type=\"hidden\" name=\"language_id\" id=\"language_id\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t\t\n\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t<script>\n\t\t\t\t\tsearchOrdersetPiggyBackforVehicle(\'D\',\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\',\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\');\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t<script>\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n//\t\t\t\t\tparent.parent.f_ivdetails.f_iv_pb.formIVPiggyBackVehicle.all.volume_unit_desc.innerHTML =\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\";\n\t\t\t\t\tparent.parent.f_ivdetails.f_iv_pb.formIVPiggyBackVehicle.volume_unit_desc.innerHTML =\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\";\n\t\t\t\t\tparent.parent.f_ivdetails.f_iv_pb.formIVPiggyBackVehicle.mandatory.style.visibility=\"hidden\";\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\tparent.parent.f_detail.f_iv_pb.formIVPiggyBackVehicle.volume_unit_desc.innerHTML =\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\";\n\t\t\t\t\tparent.parent.f_detail.f_iv_pb.formIVPiggyBackVehicle.mandatory.style.visibility=\"hidden\";\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\t\t\t\t\n\t\t</script>\n\n\t\t\n\t\t<input type=\"hidden\" name=\"order_set_code\" id=\"order_set_code\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t</form>\n</html>\n<script>\n\n\t\t\tparent.f_iv_pb_admin_dtls.location.href\t=\"IVPiggyBackAdminDtls.jsp?\"+\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\';\n</script>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );
	
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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		//
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
  
	String catalog_desc			 ="";
	String order_catalog_code	 ="";
	String qty_value			 ="";
	String readonly				 ="";
	String disabled              ="";
	String orderType			 ="";
	String equvalent_uom_code	 ="";
	String uom_desc	 ="";
	String volume_unit			 ="";
	String fluid_adr_style		 ="hidden";
	String remarks_visibility    ="visibility:hidden";
	String fluid_remarks_flag	 ="0";
    String adr_count	    = request.getParameter("adr_count")==null?"0":request.getParameter("adr_count");
	String patient_id	= request.getParameter("patient_id");
	String patient_class= request.getParameter("act_patient_class");
	String encounter_id = request.getParameter("encounter_id");
	String mode                  = request.getParameter("mode")==null?"":request.getParameter("mode");
	String prev_order			= request.getParameter("prev_order")==null?"":request.getParameter("prev_order");
	String order_id				 = request.getParameter("order_id")==null?"":request.getParameter("order_id");
	String order_type_flag		= request.getParameter("order_type_flag")==null?"":request.getParameter("order_type_flag");
	String iv_prep_default		= request.getParameter("iv_prep_default")==null?"":request.getParameter("iv_prep_default");
	String order_set_code		= request.getParameter("order_set_code")==null?"":request.getParameter("order_set_code");
	String answer					= request.getParameter("answer")==null?"":request.getParameter("answer");
	String visibile="style=display:inline";
	String base_volume			= "";	
	String bean_id			= "IVPiggyBackBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPiggyBackBean";
	IVPiggyBackBean bean	= (IVPiggyBackBean)getBeanObject( bean_id, bean_name, request ) ;
	String iv_bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String iv_bean_name			= "ePH.IVPrescriptionBean";
	IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name, request ) ;
	HashMap record;
	String param_volume_cal=iv_bean.getParamVolumeCalc();//aDDED FOR AAKH-CRF-0094
	
	if(order_type_flag.equals("Existing")||mode.equals("amend")){
		if(order_type_flag.equals("Existing")){
			readonly="readonly";
			disabled="disabled";
		}
		ArrayList exstngIVorder = (ArrayList)iv_bean.getExistingIVRecords(order_id,answer,"");	//passed answer for IN24251 --16/12/2010-- priya  // RUT-CRF-0062
		record=new HashMap();
		int siz=exstngIVorder.size();
		String lengt=siz+"";
		if(lengt.equals("1")){
			visibile="style=visibility:hidden";
		}
		else{
			visibile="style=display:inline";
		}
		record=(HashMap)exstngIVorder.get(0);
		catalog_desc			=(String)record.get("CATALOG_DESC");
		order_catalog_code		=(String)record.get("ORDER_CATALOG_CODE");
		qty_value			    =(String)record.get("QTY_VALUE");
//commented by naveen during PE
		//orderType				= iv_bean.getOrderType(order_catalog_code);
		
		iv_bean.setFluidDetails(order_catalog_code,"","","",""); // CRF-0062 NEWLY ADDED

		HashMap fluid_det =(HashMap)iv_bean.getFluidDetails();
		 orderType = (String)fluid_det.get("ORDER_TYPE_CODE");



		ArrayList stockDetails=iv_bean.getStockDetails(order_catalog_code, "1");
		volume_unit= qty_value;
		base_volume = (String)stockDetails.get(0);
		equvalent_uom_code=(String)stockDetails.get(1);
		uom_desc = bean.getUomDisplay((String)session.getValue("facility_id"),equvalent_uom_code);

		if(iv_bean.getFluidRemarks() != null && !(iv_bean.getFluidRemarks().equals(""))){
			remarks_visibility    ="visibility:visible";
			fluid_remarks_flag	  ="1";
		}
		else{
			remarks_visibility    ="visibility:hidden";
		}
		if(Integer.parseInt(adr_count)>0){
			int fluid_adr_count = iv_bean.getADRCount(patient_id,order_catalog_code);   
			if(fluid_adr_count>0)
			 fluid_adr_style="visible";
		}

	}

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(visibile));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fluid_adr_style));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(param_volume_cal));
            _bw.write(_wl_block14Bytes, _wl_block14);

							if(!order_catalog_code.equals("") && !catalog_desc.equals("")){

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(catalog_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);

							}
							else{

            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

							}

            _bw.write(_wl_block20Bytes, _wl_block20);
if(!order_catalog_code.equals("") && !catalog_desc.equals("")){
            _bw.write(_wl_block21Bytes, _wl_block21);
}else{
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(remarks_visibility));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(remarks_visibility));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
if(param_volume_cal.equals("N")){ 
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(volume_unit));
            _bw.write(_wl_block29Bytes, _wl_block29);
}
						else{
							 
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(volume_unit));
            _bw.write(_wl_block30Bytes, _wl_block30);
}
						 
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(volume_unit));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(equvalent_uom_code));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(orderType));
            _bw.write(_wl_block34Bytes, _wl_block34);

			if( mode.equals("amend")){

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block34Bytes, _wl_block34);

			}

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(fluid_remarks_flag));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(base_volume));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block39Bytes, _wl_block39);

			ArrayList orderSetCodes = new ArrayList();
			if(iv_prep_default.equals("3") || iv_prep_default.equals("4")){
				
				orderSetCodes = (ArrayList) iv_bean.getOrdersetCodes(order_set_code);
				String strFluidCode = (String) orderSetCodes.get(0);
				String strDrugCode  = (String) orderSetCodes.get(1);
				iv_bean.setDrugDetails(strDrugCode,"","","","","","");  //CRF-0062 

            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(order_set_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(strFluidCode));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(strDrugCode));
            _bw.write(_wl_block42Bytes, _wl_block42);

			}

            _bw.write(_wl_block43Bytes, _wl_block43);

				if(order_type_flag.equals("Existing")|| mode.equals("amend")){
					if(!prev_order.equals("") && prev_order.equals("previous")){

            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(equvalent_uom_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(uom_desc));
            _bw.write(_wl_block46Bytes, _wl_block46);
 
				}
				else{ 

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(uom_desc));
            _bw.write(_wl_block48Bytes, _wl_block48);

				}	
			}

            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf( order_set_code ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block51Bytes, _wl_block51);


	putObjectInBean(bean_id,bean,request);
	putObjectInBean(iv_bean_id,iv_bean,request);

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.FluidDetails.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Fluid.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.volume.label", java.lang.String .class,"key"));
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
}
