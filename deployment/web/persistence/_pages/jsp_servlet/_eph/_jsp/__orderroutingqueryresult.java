package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.Common.*;
import ePH.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import java.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __orderroutingqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/OrderRoutingQueryResult.jsp", 1709120999969L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'></link>\n\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<!--<script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script> -->\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/PhCommon.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../ePH/js/OrderRouting.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<form name=\'OrderRoutingQueryResult\' id=\'OrderRoutingQueryResult\'>\n\t\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td width=\"80%\" class=\"white\">&nbsp;</td>\n\t\t\t\t\t\t<td width=\"20%\" class=\"white\">&nbsp;\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\">\n\t\t\t\t\t<tr >\n\t\t\t\t\t\t\n\t\t\t\t\t\t<th rowspan=\'2\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\n\t\t\t\t\t\t<th rowspan=\'2\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t\t\t\t<th rowspan=\'2\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t<th rowspan=\'2\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t\t\t\t\t\t\t<th rowspan=\'2\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t<th colspan=\'5\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<th>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\n\t\t\t\t\t\t    <th>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</th>\n\t\t\t\t\t\t\t<th>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</th>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t<tr onClick=\"Modify(this,\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\');\" >\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'routingLevel_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' id=\'routingLevel_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'/>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" ><font class=\'HYPERLINK\' onmouseover=\"changeCursor(this);\">  ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&nbsp; </font></td>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" onclick=\"disableClick(event);\"  value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" style=\"display:none\">\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' value=\'S\'/>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" >\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t<td style=\"display:none\">";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&nbsp;</td>\n\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t</table>\n\t\t\t</form>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t\t\tdocument.location.href=\"../../ePH/jsp/OrderRoutingQueryCriteria.jsp?function_id=\"+function_id ;\n\t\t\t</script>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );
	
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

/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
7/1/2021		12489				Shazana       										NMC-JD-CRF-0063
--------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block7Bytes, _wl_block7);
 

		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//endss
		String locale			= (String)session.getAttribute("LOCALE");
	//	

		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

		//Search Criteria's from Query Criteria page
		String ordering_facility_id		= request.getParameter( "ordering_facility_id" );
		String ordering_source_type		= request.getParameter( "ordering_source_type" ) ;
		String ordering_source_code		= request.getParameter( "ordering_source_code" ) ;
		String ordering_source_desc		= request.getParameter( "ordering_source_desc" ) ;
		String routing_level			= request.getParameter( "routing_level" ) ;
		String routing_code = "";

		if(routing_level != null && routing_level.equals("G"))
					{
			routing_code	= request.getParameter( "drug_code");
			if(routing_code == null || routing_code.equals(""))
				routing_code	= request.getParameter( "drug_desc");
		}
		else if(routing_level != null && routing_level.equals("M")){
			routing_code	= request.getParameter( "drug_code");
			if(routing_code == null || routing_code.equals(""))
				routing_code	= request.getParameter( "drug_desc");
		}
		else{
			routing_code	= request.getParameter( "routing_code" ) ;
		}
		if(routing_code.indexOf(":")>=0){
			routing_code = routing_code.substring(0,routing_code.indexOf(":"));
		}

		String rtn_ord_disp_locn_code   = request.getParameter( "rtn_ord_disp_locn_code" );
		//String rtn_ord_disp_locn_desc   = request.getParameter( "rtn_ord_disp_locn_desc" );
		String stat_ord_disp_locn_code  = request.getParameter( "stat_ord_disp_locn_code" );
		//String stat_ord_disp_locn_desc  = request.getParameter( "stat_ord_disp_locn_desc" );
		String disch_ord_disp_locn_code = request.getParameter( "disch_ord_disp_locn_code" );
		//String disch_ord_disp_locn_desc = request.getParameter( "disch_ord_disp_locn_desc" );

		//String ord[]				= request.getParameterValues("orderbycolumns");
		String strRoutingLevel		= "S";
		
		if (ordering_source_type.equals("B")){
			ordering_source_type = "";
		}

		boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;
		try{
			String classvalue			= "";
			String orderingSourceType	= "";

			ordering_facility_id = CommonBean.checkForNull( ordering_facility_id.trim() );
			ordering_source_type = CommonBean.checkForNull( ordering_source_type.trim() );
			ordering_source_code = CommonBean.checkForNull( ordering_source_code.trim() );
			ordering_source_desc = CommonBean.checkForNull( ordering_source_desc.trim() );
			routing_level		 = CommonBean.checkForNull( routing_level.trim() );
			routing_code		 = CommonBean.checkForNull( routing_code.trim() );
			rtn_ord_disp_locn_code	= CommonBean.checkForNull( rtn_ord_disp_locn_code.trim() );
			//rtn_ord_disp_locn_desc  = CommonBean.checkForNull( rtn_ord_disp_locn_desc.trim() );
			stat_ord_disp_locn_code = CommonBean.checkForNull( stat_ord_disp_locn_code.trim() );
			//stat_ord_disp_locn_desc = CommonBean.checkForNull( stat_ord_disp_locn_desc.trim() );
			disch_ord_disp_locn_code= CommonBean.checkForNull( disch_ord_disp_locn_code.trim() );
			//disch_ord_disp_locn_desc= CommonBean.checkForNull( disch_ord_disp_locn_desc.trim() );
			//Common parameters.
			 if(routing_level.equals(""))	   {
				if (ordering_source_type.equals("N")||ordering_source_type.equals("D"))
					orderingSourceType = " and a.ordering_source_type = 'N'"; 
				else if (ordering_source_type.equals("E")||ordering_source_type.equals("C"))
					orderingSourceType = " and a.ordering_source_type = 'C'"; 
				else
					orderingSourceType = "";
			}
			String abc="SELECT a.ordering_facility_id, b.facility_name ordering_facility_name, a.ordering_source_type, a.ordering_source_code,(CASE WHEN i.patient_class = 'DC' THEN 'Day Care' ELSE CASE WHEN i.patient_class = 'IP'  and a.ordering_source_type = 'N' THEN 'Nursing Unit' ELSE CASE WHEN k.care_locn_type_ind = 'C' THEN 'Clinic' ELSE CASE WHEN k.care_locn_type_ind = 'E' THEN 'Procedure Unit' ELSE CASE WHEN i.patient_class IS NULL THEN 'Nursing Unit' END END END END END) location_type,(CASE WHEN LTRIM (RTRIM (a.ordering_source_type)) = 'C'THEN (CASE WHEN a.ordering_source_code != '*A' THEN h.long_desc ELSE '*A' END)ELSE (CASE WHEN a.ordering_source_code != '*A' THEN i.long_desc ELSE '*A' END)END) ordering_source_desc,a.performing_facility_id, c.facility_name performing_facility_name,a.rtn_ord_disp_locn_code, r.short_desc rtn_ord_disp_locn_desc,a.stat_ord_disp_locn_code,s.short_desc stat_ord_disp_locn_desc,a.disch_ord_disp_locn_code, d.short_desc disch_ord_disp_locn_desc FROM ph_order_routing a,sm_facility_param_lang_vw b,sm_facility_param_lang_vw c,op_clinic_lang_vw h,ip_nursing_unit_lang_vw i,ph_disp_locn_lang_vw r,ph_disp_locn_lang_vw s,ph_disp_locn_lang_vw d,am_care_locn_type k WHERE a.ordering_facility_id = b.facility_id AND a.performing_facility_id = c.facility_id AND a.ordering_source_code = h.clinic_code(+) AND a.ordering_facility_id = h.facility_id(+) AND a.ordering_source_code = i.nursing_unit_code(+) AND a.ordering_facility_id = i.facility_id(+) AND a.performing_facility_id = r.facility_id AND a.rtn_ord_disp_locn_code = r.disp_locn_code AND a.performing_facility_id = s.facility_id AND a.stat_ord_disp_locn_code = s.disp_locn_code AND a.performing_facility_id = d.facility_id AND a.DISCH_ORD_DISP_LOCN_CODE = d.disp_locn_code AND h.clinic_type = k.locn_type(+) AND a.ordering_facility_id LIKE UPPER (?) AND (   DECODE (?, '*A', a.ordering_source_code, NULL) = a.ordering_source_code OR DECODE (?, 'N', a.ordering_source_code, NULL) IN (select '*A' from dual where a.ordering_source_type='N' union SELECT nursing_unit_code FROM ip_nursing_unit WHERE facility_id = a.ordering_facility_id AND nursing_unit_code = a.ordering_source_code AND patient_class = 'IP')OR DECODE (?, 'D', a.ordering_source_code, NULL) IN (SELECT nursing_unit_code FROM ip_nursing_unit WHERE facility_id = a.ordering_facility_id AND nursing_unit_code = a.ordering_source_code AND patient_class = 'DC') OR DECODE (?, 'C', a.ordering_source_code, NULL) IN (SELECT clinic_code FROM op_clinic WHERE facility_id = a.ordering_facility_id AND clinic_code = a.ordering_source_code AND clinic_type IN (SELECT locn_type FROM am_care_locn_type WHERE care_locn_type_ind = 'C'))OR DECODE (?, 'E', a.ordering_source_code, NULL) IN (SELECT clinic_code FROM op_clinic WHERE facility_id = a.ordering_facility_id AND clinic_code = a.ordering_source_code AND clinic_type IN (SELECT locn_type FROM am_care_locn_type WHERE care_locn_type_ind = 'E'))) AND a.ordering_source_code LIKE UPPER (?) AND (CASE WHEN LTRIM (RTRIM (a.ordering_source_type)) = 'C' THEN (CASE WHEN a.ordering_source_code != '*A' THEN UPPER (h.long_desc) ELSE '*A' END)ELSE (CASE WHEN a.ordering_source_code != '*A' THEN UPPER (i.long_desc) ELSE '*A' END)END) LIKE UPPER (?) AND UPPER (a.rtn_ord_disp_locn_code) LIKE UPPER (?)AND UPPER (a.stat_ord_disp_locn_code) LIKE UPPER (?) AND UPPER (a.disch_ord_disp_locn_code) LIKE UPPER (?)  and b.language_id = ? and c.language_id(+) =? and h.language_id(+) = ? and i.language_id(+) = ? and r.language_id(+) = ? and s.language_id(+) = ? and d.language_id(+) = ? ";//modified for NMC-JD-CRF-0063 

			String abc1="SELECT a.ordering_facility_id, b.facility_name ordering_facility_name, a.ordering_source_type, a.ordering_source_code,(CASE WHEN i.patient_class = 'DC' THEN 'Day Care' 	   ELSE CASE  WHEN i.patient_class = 'IP' AND a.ordering_source_type = 'N' THEN 'Nursing Unit' ELSE CASE WHEN p.care_locn_type_ind = 'C' THEN 'Clinic' ELSE CASE WHEN p.care_locn_type_ind = 'E' THEN 'Procedure Unit' ELSE CASE WHEN i.patient_class IS NULL AND a.ordering_source_type = 'N' THEN 'Nursing Unit' ELSE CASE WHEN i.patient_class IS NULL AND a.ordering_source_type = 'C' THEN 'Clinic' END END END END END END) location_type,(CASE WHEN LTRIM (RTRIM (a.ordering_source_type)) = 'C' THEN (CASE WHEN a.ordering_source_code != '*A' THEN h.long_desc ELSE '*A' END)ELSE (CASE WHEN a.ordering_source_code != '*A' THEN i.long_desc ELSE '*A' END)END) ordering_source_desc,a.performing_facility_id, c.facility_name performing_facility_name,a.rtn_ord_disp_locn_code, j.short_desc rtn_ord_disp_locn_desc,a.stat_ord_disp_locn_code, k.short_desc stat_ord_disp_locn_desc,a.disch_ord_disp_locn_code, l.short_desc disch_ord_disp_locn_desc, a.routing_code,DECODE (a.routing_level,'G', UPPER (m.drug_desc),'O', UPPER (n.short_desc),'M',UPPER (m.drug_desc),'D', DECODE (a.routing_code,'G', 'General','N', 'Narcotic','C', 'Controlled')) routing_code_desc,a.routing_level FROM ph_order_routing_dtl a,sm_facility_param_lang_vw b,sm_facility_param_lang_vw c,op_clinic_lang_vw h,ip_nursing_unit_lang_vw i,ph_disp_locn_lang_vw j,ph_disp_locn_lang_vw k,ph_disp_locn_lang_vw l,ph_drug_lang_vw m,or_order_type_lang_vw n,am_care_locn_type p WHERE a.ordering_facility_id = b.facility_id AND a.performing_facility_id = c.facility_id AND a.ordering_source_code = h.clinic_code(+) AND a.ordering_facility_id = h.facility_id(+) AND a.ordering_source_code = i.nursing_unit_code(+) AND a.ordering_facility_id = i.facility_id(+) AND a.performing_facility_id = j.facility_id AND a.rtn_ord_disp_locn_code = j.disp_locn_code AND a.performing_facility_id = k.facility_id AND a.stat_ord_disp_locn_code = k.disp_locn_code AND a.performing_facility_id = l.facility_id(+) AND a.disch_ord_disp_locn_code = l.disp_locn_code(+) AND h.clinic_type = p.locn_type(+) AND a.ordering_facility_id LIKE UPPER (?) AND (   DECODE (?, '*A', a.ordering_source_code, NULL) = a.ordering_source_code OR a.ordering_source_type = 'N' AND DECODE (?, 'N', a.ordering_source_code, NULL) IN ('*A',(SELECT nursing_unit_code FROM ip_nursing_unit WHERE facility_id = a.ordering_facility_id AND nursing_unit_code = a.ordering_source_code AND patient_class = 'IP')) OR a.ordering_source_type = 'N' AND DECODE (?, 'D', a.ordering_source_code, NULL) IN ('*A',(SELECT nursing_unit_code FROM ip_nursing_unit WHERE facility_id = a.ordering_facility_id AND nursing_unit_code = a.ordering_source_code AND patient_class = 'DC')) OR a.ordering_source_type = 'C' AND DECODE (?, 'C', a.ordering_source_code, NULL) IN ('*A',(SELECT clinic_code FROM op_clinic WHERE facility_id = a.ordering_facility_id AND clinic_code = a.ordering_source_code AND clinic_type IN (SELECT locn_type FROM am_care_locn_type WHERE care_locn_type_ind = 'C'))) OR a.ordering_source_type = 'C' AND DECODE (?, 'E', a.ordering_source_code, NULL) IN ('*A',(SELECT clinic_code FROM op_clinic WHERE facility_id = a.ordering_facility_id AND clinic_code = a.ordering_source_code AND clinic_type IN (SELECT locn_type FROM am_care_locn_type WHERE care_locn_type_ind = 'E')))) AND a.ordering_source_code LIKE UPPER (?) AND (CASE WHEN LTRIM (RTRIM (a.ordering_source_type)) = 'C' THEN (CASE WHEN a.ordering_source_code != '*A' THEN UPPER (h.long_desc) ELSE '*A' END) ELSE (CASE WHEN a.ordering_source_code != '*A' THEN UPPER (i.long_desc) ELSE '*A' END)END) LIKE UPPER (?) AND a.routing_level LIKE UPPER (?)   AND a.routing_code LIKE UPPER (?) AND a.routing_code = m.drug_code(+) AND a.routing_code = n.order_type_code(+) AND a.rtn_ord_disp_locn_code LIKE ? AND a.stat_ord_disp_locn_code LIKE ? AND NVL (a.disch_ord_disp_locn_code, 'X') LIKE ?  and b.language_id = ? and c.language_id(+) = ? and h.language_id(+) = ? and i.language_id(+) = ? and j.language_id(+) = ? and k.language_id(+) = ? and l.language_id(+) = ? and m.language_id(+) = ? and n.language_id(+) = ? "; 

			String all =	" SELECT a.ordering_facility_id, b.facility_name ordering_facility_name, a.ordering_source_type, a.ordering_source_code,(CASE WHEN i.patient_class = 'DC' THEN 'Day Care' ELSE CASE WHEN i.patient_class = 'IP' AND a.ordering_source_type = 'N' THEN 'Nursing Unit' ELSE CASE WHEN k.care_locn_type_ind = 'C' THEN 'Clinic' ELSE CASE WHEN k.care_locn_type_ind = 'E' THEN 'Procedure Unit' ELSE CASE WHEN i.patient_class IS NULL THEN 'Nursing Unit' END END END END END) location_type,(CASE WHEN LTRIM (RTRIM (a.ordering_source_type)) = 'C'THEN (CASE WHEN a.ordering_source_code != '*A' THEN h.long_desc ELSE '*A' END)ELSE (CASE WHEN a.ordering_source_code != '*A' THEN i.long_desc ELSE '*A' END)END) ordering_source_desc,a.performing_facility_id, c.facility_name performing_facility_name,a.rtn_ord_disp_locn_code, r.short_desc rtn_ord_disp_locn_desc,a.stat_ord_disp_locn_code,s.short_desc stat_ord_disp_locn_desc,a.disch_ord_disp_locn_code, d.short_desc disch_ord_disp_locn_desc, 'S' routing_level,'' routing_code  , '' routing_code_desc  FROM ph_order_routing a,sm_facility_param_lang_vw b,sm_facility_param_lang_vw c,op_clinic_lang_vw h,ip_nursing_unit_lang_vw i,ph_disp_locn_lang_vw r,ph_disp_locn_lang_vw s,ph_disp_locn_lang_vw d,am_care_locn_type k WHERE a.ordering_facility_id = b.facility_id AND a.performing_facility_id = c.facility_id AND a.ordering_source_code = h.clinic_code(+) AND a.ordering_facility_id = h.facility_id(+) AND a.ordering_source_code = i.nursing_unit_code(+) AND a.ordering_facility_id = i.facility_id(+) AND a.performing_facility_id = r.facility_id AND a.rtn_ord_disp_locn_code = r.disp_locn_code AND a.performing_facility_id = s.facility_id AND a.stat_ord_disp_locn_code = s.disp_locn_code AND a.performing_facility_id = d.facility_id AND a.DISCH_ORD_DISP_LOCN_CODE = d.disp_locn_code AND h.clinic_type = k.locn_type(+) AND a.ordering_facility_id LIKE UPPER (?) AND (   DECODE (?, '*A', a.ordering_source_code, NULL) = a.ordering_source_code OR DECODE (?, 'N', a.ordering_source_code, NULL) IN (select '*A' from dual where a.ordering_source_type='N' union SELECT nursing_unit_code FROM ip_nursing_unit WHERE facility_id = a.ordering_facility_id AND nursing_unit_code = a.ordering_source_code AND patient_class = 'IP')OR DECODE (?, 'D', a.ordering_source_code, NULL) IN (SELECT nursing_unit_code FROM ip_nursing_unit WHERE facility_id = a.ordering_facility_id AND nursing_unit_code = a.ordering_source_code AND patient_class = 'DC') OR DECODE (?, 'C', a.ordering_source_code, NULL) IN (SELECT clinic_code FROM op_clinic WHERE facility_id = a.ordering_facility_id AND clinic_code = a.ordering_source_code AND clinic_type IN (SELECT locn_type FROM am_care_locn_type WHERE care_locn_type_ind = 'C'))OR DECODE (?, 'P', a.ordering_source_code, NULL) IN (SELECT clinic_code FROM op_clinic WHERE facility_id = a.ordering_facility_id AND clinic_code = a.ordering_source_code AND clinic_type IN (SELECT locn_type FROM am_care_locn_type WHERE care_locn_type_ind = 'E'))) AND a.ordering_source_code LIKE UPPER (?) AND (CASE WHEN LTRIM (RTRIM (a.ordering_source_type)) = 'C' THEN (CASE WHEN a.ordering_source_code != '*A' THEN UPPER (h.long_desc) ELSE '*A' END)ELSE (CASE WHEN a.ordering_source_code != '*A' THEN UPPER (i.long_desc) ELSE '*A' END)END) LIKE UPPER (?) AND UPPER (a.rtn_ord_disp_locn_code) LIKE UPPER (?)AND UPPER (a.stat_ord_disp_locn_code) LIKE UPPER (?) AND UPPER (a.disch_ord_disp_locn_code) LIKE UPPER (?) and b.language_id = ? and c.language_id(+) =? and h.language_id(+) = ? and i.language_id(+) = ? and r.language_id(+) = ? and s.language_id(+) = ? and d.language_id(+) = ?  "+orderingSourceType +" union all SELECT a.ordering_facility_id, b.facility_name ordering_facility_name, a.ordering_source_type, a.ordering_source_code,(CASE WHEN i.patient_class = 'DC' THEN 'Day Care' 	   ELSE CASE  WHEN i.patient_class = 'IP' AND a.ordering_source_type = 'N' THEN 'Nursing Unit' ELSE CASE WHEN p.care_locn_type_ind = 'C' THEN 'Clinic' ELSE CASE WHEN p.care_locn_type_ind = 'E' THEN 'Procedure Unit' ELSE CASE WHEN i.patient_class IS NULL AND a.ordering_source_type = 'N' THEN 'Nursing Unit' ELSE CASE WHEN i.patient_class IS NULL AND a.ordering_source_type = 'C' THEN 'Clinic' END END END END END END) location_type,(CASE WHEN LTRIM (RTRIM (a.ordering_source_type)) = 'C' THEN (CASE WHEN a.ordering_source_code != '*A' THEN h.long_desc ELSE '*A' END)ELSE (CASE WHEN a.ordering_source_code != '*A' THEN i.long_desc ELSE '*A' END)END) ordering_source_desc,a.performing_facility_id, c.facility_name performing_facility_name,a.rtn_ord_disp_locn_code, j.short_desc rtn_ord_disp_locn_desc,a.stat_ord_disp_locn_code, k.short_desc stat_ord_disp_locn_desc,a.disch_ord_disp_locn_code,l.short_desc disch_ord_disp_locn_desc,a.routing_level,a.routing_code,DECODE (a.routing_level,'G', UPPER (m.drug_desc),'O', UPPER (n.short_desc),'M',UPPER (m.drug_desc),'D', DECODE (a.routing_code,'G', 'General','N', 'Narcotic','C', 'Controlled')) routing_code_desc FROM ph_order_routing_dtl a,sm_facility_param_lang_vw b,sm_facility_param_lang_vw c,op_clinic_lang_vw h,ip_nursing_unit_lang_vw i,ph_disp_locn_lang_vw j,ph_disp_locn_lang_vw k,ph_disp_locn_lang_vw l,ph_drug_lang_vw m,or_order_type_lang_vw n,am_care_locn_type p WHERE a.ordering_facility_id = b.facility_id AND a.performing_facility_id = c.facility_id AND a.ordering_source_code = h.clinic_code(+) AND a.ordering_facility_id = h.facility_id(+) AND a.ordering_source_code = i.nursing_unit_code(+) AND a.ordering_facility_id = i.facility_id(+) AND a.performing_facility_id = j.facility_id AND a.rtn_ord_disp_locn_code = j.disp_locn_code AND a.performing_facility_id = k.facility_id AND a.stat_ord_disp_locn_code = k.disp_locn_code AND a.performing_facility_id = l.facility_id(+) AND a.disch_ord_disp_locn_code = l.disp_locn_code(+)   AND h.clinic_type = p.locn_type(+) AND a.ordering_facility_id LIKE UPPER (?) AND (   DECODE (?, '*A', a.ordering_source_code, NULL) = a.ordering_source_code OR a.ordering_source_type = 'N' AND DECODE (?, 'N', a.ordering_source_code, NULL) IN ('*A',(SELECT nursing_unit_code FROM ip_nursing_unit WHERE facility_id = a.ordering_facility_id AND nursing_unit_code = a.ordering_source_code AND patient_class = 'IP')) OR a.ordering_source_type = 'N' AND DECODE (?, 'D', a.ordering_source_code, NULL) IN ('*A',(SELECT nursing_unit_code FROM ip_nursing_unit WHERE facility_id = a.ordering_facility_id AND nursing_unit_code = a.ordering_source_code AND patient_class = 'DC')) OR a.ordering_source_type = 'C' AND DECODE (?, 'C', a.ordering_source_code, NULL) IN ('*A',(SELECT clinic_code FROM op_clinic WHERE facility_id = a.ordering_facility_id AND clinic_code = a.ordering_source_code AND clinic_type IN (SELECT locn_type FROM am_care_locn_type WHERE care_locn_type_ind = 'C'))) OR a.ordering_source_type = 'C' AND DECODE (?, 'E', a.ordering_source_code, NULL) IN ('*A',(SELECT clinic_code FROM op_clinic WHERE facility_id = a.ordering_facility_id AND clinic_code = a.ordering_source_code AND clinic_type IN (SELECT locn_type FROM am_care_locn_type WHERE care_locn_type_ind = 'E')))) AND a.ordering_source_code LIKE UPPER (?) AND (CASE WHEN LTRIM (RTRIM (a.ordering_source_type)) = 'C' THEN (CASE WHEN a.ordering_source_code != '*A' THEN UPPER (h.long_desc) ELSE '*A' END) ELSE (CASE WHEN a.ordering_source_code != '*A' THEN UPPER (i.long_desc) ELSE '*A' END)END) LIKE UPPER (?) AND a.routing_level LIKE UPPER (?)   AND a.routing_code LIKE UPPER (?) AND a.routing_code = m.drug_code(+) AND a.routing_code = n.order_type_code(+) AND a.rtn_ord_disp_locn_code LIKE ? AND a.stat_ord_disp_locn_code LIKE ? AND NVL (a.disch_ord_disp_locn_code, 'X') LIKE ? and b.language_id = ? and c.language_id(+) = ? and h.language_id(+) = ? and i.language_id(+) = ? and j.language_id(+) = ? and k.language_id(+) = ? and l.language_id(+) = ? and m.language_id(+) = ? and n.language_id(+) = ? "; 

			HashMap sqlMap = new HashMap();
			if (routing_level.equals("S")){
				//sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_ORDER_ROUTING_SELECT7"));
				if (ordering_source_type.equals("N")||ordering_source_type.equals("D"))
					abc += " and a.ordering_source_type = 'N'"; 
				else if (ordering_source_type.equals("E")||ordering_source_type.equals("C"))
					abc += " and a.ordering_source_type = 'C'"; 
				else
					abc += "";
				sqlMap.put( "sqlData",abc);
			} 
			else if(routing_level.equals(""))	   {
				if (ordering_source_type.equals("N")||ordering_source_type.equals("D"))
					all += " and a.ordering_source_type = 'N'"; 
				else if (ordering_source_type.equals("E")||ordering_source_type.equals("C"))
					all += " and a.ordering_source_type = 'C'"; 
				else
					all += "";

				sqlMap.put( "sqlData",all);
			}
			else{
				strRoutingLevel = "ODGLMH"; // added H for Bru-HIMS-CRF-093[29960] 
				//sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_ORDER_ROUTING_SELECT14"));
				sqlMap.put( "sqlData", abc1);
			}
			//Function Parameters
			HashMap funcMap = new HashMap();

			//The fields that are going to be display
			ArrayList displayFields = new ArrayList();

			displayFields.add( "ordering_facility_name");
			displayFields.add( "ordering_facility_id" );
			displayFields.add( "location_type");
		//	displayFields.add( "ordering_source_type" ); 
			displayFields.add( "ordering_source_code" );
			displayFields.add( "ordering_source_desc" );
			if (!routing_level.equals("S")){	
				displayFields.add( "routing_level");
				displayFields.add( "routing_code" );
				displayFields.add( "routing_code_desc" );
			}
			displayFields.add( "rtn_ord_disp_locn_desc" );
			displayFields.add( "stat_ord_disp_locn_desc" );
			displayFields.add( "disch_ord_disp_locn_desc" );

			ArrayList chkFields = new ArrayList();
			
			if(routing_level.equals("S")){
				chkFields.add( ordering_facility_id.trim());
				chkFields.add( ordering_source_type.trim());
				chkFields.add( ordering_source_type.trim());
				chkFields.add( ordering_source_type.trim());
				chkFields.add( ordering_source_type.trim());
				chkFields.add( ordering_source_type.trim());
				chkFields.add( ordering_source_code.trim() + "%" );
				chkFields.add( ordering_source_desc.trim() + "%" );	
				chkFields.add( rtn_ord_disp_locn_code.trim() + "%" );
				chkFields.add( stat_ord_disp_locn_code.trim() + "%" );
				chkFields.add( disch_ord_disp_locn_code.trim() + "%" );
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
			}
			else if(routing_level.equals(""))	{
				chkFields.add( ordering_facility_id.trim());
				chkFields.add( ordering_source_type.trim());
				chkFields.add( ordering_source_type.trim());
				chkFields.add( ordering_source_type.trim());
				chkFields.add( ordering_source_type.trim());
				chkFields.add( ordering_source_type.trim());
				chkFields.add( ordering_source_code.trim() + "%" );
				chkFields.add( ordering_source_desc.trim() + "%" );	
				chkFields.add( rtn_ord_disp_locn_code.trim() + "%" );
				chkFields.add( stat_ord_disp_locn_code.trim() + "%" );
				chkFields.add( disch_ord_disp_locn_code.trim() + "%" );
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add( ordering_facility_id.trim());//1
				chkFields.add( ordering_source_type.trim());//2
				chkFields.add( ordering_source_type.trim());//3
				chkFields.add( ordering_source_type.trim());//4
				chkFields.add( ordering_source_type.trim());//5
				chkFields.add( ordering_source_type.trim());//6
				chkFields.add( ordering_source_code.trim() + "%" );//7
				chkFields.add( ordering_source_desc.trim() + "%" );//8		
				chkFields.add( routing_level.trim()+ "%" );//9
				chkFields.add( routing_code.trim()+ "%" );//10
				chkFields.add( rtn_ord_disp_locn_code.trim() + "%" );//11
				chkFields.add( stat_ord_disp_locn_code.trim() + "%" );//12
				chkFields.add( disch_ord_disp_locn_code.trim() + "%" );//13
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
			}
			else{
				chkFields.add( ordering_facility_id.trim());//1
				chkFields.add( ordering_source_type.trim());//2
				chkFields.add( ordering_source_type.trim());//3
				chkFields.add( ordering_source_type.trim());//4
				chkFields.add( ordering_source_type.trim());//5
				chkFields.add( ordering_source_type.trim());//6
				chkFields.add( ordering_source_code.trim() + "%" );//7
				chkFields.add( ordering_source_desc.trim() + "%" );//8		
				chkFields.add( routing_level.trim()+ "%" );//9
				chkFields.add( routing_code.trim()+ "%" );//10
				chkFields.add( rtn_ord_disp_locn_code.trim() + "%" );//11
				chkFields.add( stat_ord_disp_locn_code.trim() + "%" );//12
				chkFields.add( disch_ord_disp_locn_code.trim() + "%" );//13
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
				chkFields.add(locale);
			}
			// Adding function related array list into the HashMap
			funcMap.put( "displayFields", displayFields );
			funcMap.put( "chkFields", chkFields );
			//Calling the Result from Common Adaptor as a arraylist.
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext, sqlMap, funcMap,request);
			if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
				String link_columns ="", dkVal="";

            _bw.write(_wl_block10Bytes, _wl_block10);

				// For display the previous/next link
						out.println(result.get(1));

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

						if (!routing_level.equals("S")){

            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

						}

            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

					//Retriving the records from result arraylist
					ArrayList records=new ArrayList();
					for(int recCount=2; recCount<result.size(); recCount++) {
						if ( recCount % 2 == 0 )
							classvalue = "QRYODD" ;
						else
							classvalue = "QRYEVEN" ;

            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block23Bytes, _wl_block23);

						link_columns ="";
						if (routing_level.equals("S")){
							link_columns = "1,3,5";
						}
						else{
							link_columns = "1,3,5,6,8";
						}
						records=(ArrayList) result.get( recCount );
						for(int colCount=0; colCount<records.size(); colCount++){
							
							if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
								dkVal = (String)records.get( colCount );
								if (dkVal== null)
									dkVal = "";
								else
									dkVal = dkVal;					

								if(colCount==7 && (routing_level.equals("") || routing_level.equals("L") ||  routing_level.equals("H"))){						  
									dkVal = (String)records.get( colCount-1);
									if(dkVal == null) {
										dkVal = "";
									}
									if(dkVal.equals("ALLD")){
										dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.AllDirectOrders.label", "ph_labels");
									}
									else if(dkVal.equals("ALLA")){
										dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.AllAdmixtures.label", "ph_labels");
									}
									else if(dkVal.equals("CMPA")){
										dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.CompoundingOrder.label", "ph_labels");
									}
									else if(dkVal.equals("IVOD")){
										dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.IVOrderDirect.label", "ph_labels");
									}
									else if(dkVal.equals("IVOA")){
										dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.IVOrderAdmixture.label", "ph_labels");
									}
									else if(dkVal.equals("ONCD")){
										dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OncologyOrderDirect.label", "ph_labels");
									}
									else if(dkVal.equals("ONCA")){
										dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OncologyOrderAdmixture.label", "ph_labels");
									}
									else if(dkVal.equals("TPND")){
										dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.TPNStandardRegimen.label", "ph_labels");
									}
									else if(dkVal.equals("TPNA")){
										dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.TPNNONStandardRegimen.label", "ph_labels");
									}
								}
								if(dkVal == null) {dkVal = "";}
								if (dkVal.equals("*A")){
									dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AllLocations.label", "common_labels");
								}
								if ((colCount==2) && (dkVal.equals("N"))){
									dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.nursingUnit.label", "common_labels");
								}
								else if ((colCount==2) && (dkVal.equals("C"))){
									dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.clinic.label", "common_labels");
								}
								if (colCount==5){

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(dkVal));
            _bw.write(_wl_block27Bytes, _wl_block27);

									if((dkVal.equals("S")))
										dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.source.label", "common_labels");
									else if (dkVal.equals("O"))
										dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.OrderType.label", "common_labels");
									else if (dkVal.equals("D"))
										dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DrugClass.label", "ph_labels");
									else if (dkVal.equals("G"))
										dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Drug.label", "common_labels"); 
									else if (dkVal.equals("L"))
										dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.SpecialOrders.label", "ph_labels");
									else if (dkVal.equals("M"))
										dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.MedicalItem.label","common_labels");
									else if (dkVal.equals("H"))// added for Bru-HIMS-CRF-093[29960] 
										dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.HomeLeave.label","ph_labels");

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dkVal));
            _bw.write(_wl_block30Bytes, _wl_block30);

								}
								else{
									if(dkVal.equals("AllDirectOrders")){
										dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.AllDirectOrders.label", "ph_labels");
									}
									else if(dkVal.equals("AllAdmixtures")){
										dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.AllAdmixtures.label", "ph_labels");
									}
									else if(dkVal.equals("CompoundingOrder")){
										dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.CompoundingOrder.label", "ph_labels");
									}
									else if(dkVal.equals("IVOrderAdmixture")){
										dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.IVOrderAdmixture.label", "ph_labels");
									}
									else if(dkVal.equals("IVOrderDirect")){
										dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.IVOrderDirect.label", "ph_labels");
									}
									else if(dkVal.equals("OncologyOrderAdmixture")){
										dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OncologyOrderAdmixture.label", "ph_labels");
									}
									else if(dkVal.equals("OncologyOrderDirect")){
										dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OncologyOrderDirect.label", "ph_labels");
									}
									else if(dkVal.equals("TPNStandardRegimen")){
										dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.TPNStandardRegimen.label", "ph_labels");
									}
									else if(dkVal.equals("TPNNONStandardRegimen")){
										dkVal = com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.TPNNONStandardRegimen.label", "ph_labels");
									}

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dkVal));
            _bw.write(_wl_block30Bytes, _wl_block30);

								}
							}
							else if (colCount ==1 || colCount ==3 || (colCount==6 && !routing_level.equals("S"))){
								dkVal = (String)records.get( colCount );

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(CommonBean.checkForNull((String)records.get( colCount ))));
            _bw.write(_wl_block33Bytes, _wl_block33);

								out.println(dkVal);
								out.println("&nbsp;</td>"); 
								dkVal = "";	
							}
							else{	
								dkVal ="&nbsp;";
								if (records.get( colCount ) != null){
									dkVal = (String)records.get( colCount );
								}		
								if (colCount==5){

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block34Bytes, _wl_block34);

								}
								if(colCount==7 && routing_level.equals("S")){

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf((String)records.get( colCount )));
            _bw.write(_wl_block35Bytes, _wl_block35);

									if (dkVal.equals("*A")){
										dkVal = "All Locations";
									}
									out.println(dkVal);
									out.println("&nbsp;</td>"); 						
								}
								else if(!(colCount==9 && routing_level.equals("S"))){
									

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf((String)records.get( colCount )));
            _bw.write(_wl_block35Bytes, _wl_block35);

									if (dkVal.equals("*A")){
										dkVal = "All Locations";
									}
									out.println(dkVal);
									out.println("&nbsp;</td>"); 
									dkVal = "";	
								}
							}
						}

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strRoutingLevel));
            _bw.write(_wl_block37Bytes, _wl_block37);

				}

            _bw.write(_wl_block38Bytes, _wl_block38);

			out.flush();
		}
		else{

            _bw.write(_wl_block39Bytes, _wl_block39);

		}
		out.println(CommonBean.setForm ( request ,"../../ePH/jsp/OrderRoutingQueryResult.jsp", searched) );
	} 
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace();
	}

            _bw.write(_wl_block40Bytes, _wl_block40);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderingFacilityName.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.LocationName.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.RoutingLevel.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.RoutingCodeDesc.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispenseLocation.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.RoutineOrders.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.StatOrder.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DischargeMedicationOrders.label", java.lang.String .class,"key"));
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
}
