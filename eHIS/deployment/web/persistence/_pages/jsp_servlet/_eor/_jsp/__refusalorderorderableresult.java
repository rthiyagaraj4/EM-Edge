package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import eCommon.Common.*;
import java.util.*;

public final class __refusalorderorderableresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/RefusalOrderOrderableResult.jsp", 1709119952000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!-- RefusalOrderOrderableResult.jsp -->\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n \n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" \n\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\'/>\n\t\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/RefusalOrders.js\"></script> \n\t<script language=\"JavaScript\" src=\"../js/OrCommonFunction.js\"></script>\n\t<!--<script language=\"JavaScript\" src=\"../js/OrMessages.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script>-->\n\t<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t\n\t<script language=\"JavaScript\" src=\"../js/OrCommon.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n <script>\n        var chkBothCriteria = false ;\n        var fromCalledPage = false ;\n\t\t\n\t\tfunction callModify(){\n\t\t\t\n\t\t\tif(document.getElementById(\"res_size\").value == \"3\"){\n\t\t\t\tvar argArray = window.dialogArguments ;\n\t\t\t\tvar code1=document.getElementById(\"resTable\").rows(1).cells[0].innerText;\n\t\t\t\tvar code2=document.getElementById(\"resTable\").rows(1).cells[1].innerText;\n\t\t\t\t\n\t\t\t\t\n\n\t\t\t\tvar retVal = code1 + \"&\" + code2 ;\n\t\t\t\twindow.returnValue = retVal ;\n\t\t\t\twindow.close()\n\t\t\t}\n\t\t}\n    </script>\n\n\t\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\"refOrderableresult\" id=\"refOrderableresult\">\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\">\n\t\t<tr>\n\t\t<td width=\"80%\" class=\"white\">&nbsp;</td>\n\t\t<td width=\"20%\" class=\"white\">&nbsp;\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t</td></tr>\n\t\t</table>\n\n\t\t<table border=\"\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" id=\"resTable\" class=\"grid\">\n\t\t<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t<td class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t<input type=\"hidden\" name=\"res_size\" id=\"res_size\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t<tr onClick=\"Modify(this);\">\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" onclick=\"disableClick(event);\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" \n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"  onclick=\"disableClick(event);\"><a href=\"#\" class=\"gridLink\" onclick=\'getDescrip(\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\",\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\")\' >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</a><input type=\"hidden\" name=\"catalog_desc";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" id=\"catalog_desc";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" value = \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"></td> \n\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" align=\"center\"><input type=\'hidden\' value=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="></img>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="<img src=\"../../eCommon/images/enabled.gif\"></img>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="<img src=\"../../eCommon/images/disabled.gif\"></img> ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t</table>\n\t\t<script>//callModify();</script>\n\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));history.go(-1);</script>\n\t\t\t<!--<script>getDescrip(\"noRecords\");</script>-->\n\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t<input type=\"hidden\" name=\"order_type_desc\" id=\"order_type_desc\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t<input type=\"hidden\" name=\"order_type_code\" id=\"order_type_code\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t<input type=\"hidden\" name=\"activity_desc\" id=\"activity_desc\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t<input type=\"hidden\" name=\"activity_code\" id=\"activity_code\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t<input type=\"hidden\" name=\"CallingModule\" id=\"CallingModule\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t</form>\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t</body>\n\t</html>\n\n\t\t\t\t\t\t\t\t\t\t\t\n\n\n\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );
	
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
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
04/12/2012	  IN031304 		Karthi L	  		new column added follow_visit_type(IN035976)  
---------------------------------------------------------------------------------------------------------------
*/ 
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

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block7Bytes, _wl_block7);
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
            _bw.write(_wl_block8Bytes, _wl_block8);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	  

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);
			
         
		String CallingModule = (request.getParameter("CallingModule")==null) ? "":request.getParameter("CallingModule");		
		String called_from = request.getParameter("called_from");
		if(called_from==null) called_from = "";
		String order_category=request.getParameter("order_category");
		String order_type_code=request.getParameter("type_code");
		String activity_type=request.getParameter("activity_type");
		String type_desc=request.getParameter("type_desc");
		String activity_desc=request.getParameter("activity_desc");		
 		String search_by=request.getParameter("search_by");
		if(search_by==null || search_by=="null") search_by = "C";
 		String description_code=request.getParameter("description_code");
		String long_desc=request.getParameter("search_text");		
		if(long_desc==null || long_desc=="null") long_desc = "";
 		//String table_name = (request.getParameter("table_name")==null) ? "":request.getParameter("table_name");
		// Apart from the Normal Parameters, when passed from Clinic (OA) p_clinic_code will be passed
		// If called from OP and table name is passed, clinic code is passed
		String p_clinic_code = (request.getParameter("p_clinic_code")==null) ? "":request.getParameter("p_clinic_code");

		// And p_speciality_code if speciality is selected, if from OP and if Wing/OT is selected 
		String p_speciality_code = (request.getParameter("p_speciality_code")==null) ? "":request.getParameter("p_speciality_code");
		// if from OP and if Wing/OT is selected service_code, p_wing_code and p_service_code will be passed 
 		String p_service_code = (request.getParameter("p_service_code")==null) ? "":request.getParameter("p_service_code");
		String p_wing_code = (request.getParameter("p_wing_code")==null) ? "":request.getParameter("p_wing_code");
		//Added by Uma on 3/12/2010 for IN019490
		String practitionerId = (request.getParameter("practitionerId")==null) ? "":request.getParameter("practitionerId");
		String locn_code = (request.getParameter("locn_code")==null) ? "":request.getParameter("locn_code"); //IN031304
		String rd_appt_yn = (request.getParameter("rd_appt_yn")==null) ? "":request.getParameter("rd_appt_yn"); //IN031304
		
		if(rd_appt_yn.equals("Y") && locn_code != null && locn_code != "" && !(locn_code.equalsIgnoreCase("undefined")) && called_from.equalsIgnoreCase("OA")){ // added for IN031304 - Start
			
			if(p_clinic_code == null || p_clinic_code.equals(""))
			{
				p_clinic_code = locn_code;
			}
			
		} // added for IN031304 - END
 		String facility_id = (String)session.getValue("facility_id");
		
		if(p_clinic_code==null || p_clinic_code.equals("null"))
			p_clinic_code ="";
		if(p_speciality_code==null || p_speciality_code.equals("null"))
			p_speciality_code ="";
		if(p_wing_code==null || p_wing_code.equals("null"))
			p_wing_code ="";
		if(p_service_code==null || p_service_code.equals("null"))
			p_service_code ="";


 		//String temp_long_desc="";
		String bean_id = "refusalOrdersBean" ;
		String bean_name = "eOR.RefusalOrdersBean";
		boolean searched = request.getParameter( "searched" ) == null ? false : true  ;
		RefusalOrdersBean bean = (RefusalOrdersBean)getBeanObject( bean_id, bean_name,request) ;
		//Added by Uma on 3/12/2010 for IN019490
		String privilegeApplicabilityOrd = (String)bean.getAuthorisationOrOrderingYn("ORD");
		String sql = "";

	try{
	String classvalue			= "";
	//String callBlur				= "";
	
  	HashMap sqlMap = new HashMap();
 	if(called_from.equalsIgnoreCase("AM") || called_from.equalsIgnoreCase("OP") || called_from.equalsIgnoreCase("OA")) 
	{
		//if(table_name!=null &&  !table_name.equals(""))	 // When table name is passed
		//{
		if(p_speciality_code!=null && !p_speciality_code.equals(""))
		{
			sqlMap.put( "sqlData", OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_AM"));
		}
		else if(p_clinic_code!=null &&  !p_clinic_code.equals(""))
		{
			sqlMap.put( "sqlData", OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_OP"));
		}
		else if(p_wing_code!=null &&  !p_wing_code.equals(""))
		{
			sqlMap.put( "sqlData", OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_WING"));
		}
		else	// Default query
		{
			sqlMap.put( "sqlData",OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_RES_WITHOUT_PH"));
		}
		//}
 		//else
		//	sqlMap.put( "sqlData", OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_RES_WITHOUT_PH"));

	}
	else
	{
		sql = (String)OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_RES");
		//sqlMap.put( "sqlData", OrRepositoryExt.getOrKeyValue("SQL_OR_REFUSAL_ORDER_RES"));
		if(privilegeApplicabilityOrd.equalsIgnoreCase("Y"))
		{
			sql = sql.replace("##FILTERCAT##"," and 'Y' = OR_GET_PRIV_APPL_YN(?,?,'OR',order_catalog_code,?)");
		}
		else
		{
			sql = sql.replace("##FILTERCAT##","");
		}
		sqlMap.put( "sqlData", sql);
	}
	
	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	displayFields.add( "order_catalog_code");
	displayFields.add("long_desc" );
	
	ArrayList chkFields = new ArrayList();

 	 if(p_wing_code==null ||  p_wing_code.equals("")) 
	{
			chkFields.add(order_category);
			chkFields.add(order_type_code);
			chkFields.add(description_code);
			chkFields.add(long_desc);
			chkFields.add(long_desc);
			chkFields.add(long_desc);
			chkFields.add(search_by);
			chkFields.add(description_code);
			chkFields.add(long_desc);
			chkFields.add(long_desc);
			chkFields.add(long_desc);
			chkFields.add(search_by);
			chkFields.add(activity_type);
			//chkFields.add(activity_type);
			if(p_speciality_code!=null && !p_speciality_code.equals(""))
				chkFields.add(p_speciality_code);
			else if(p_clinic_code!=null &&  !p_clinic_code.equals("")) 
			{
				if(p_clinic_code.equals("*A"))	p_clinic_code = "";
				chkFields.add(p_clinic_code);
				chkFields.add(facility_id);		
			} 
		} 
		else 
		{
		 	if(p_wing_code.equals("*A"))	p_wing_code = "";
	 		chkFields.add(facility_id);	
			chkFields.add(p_wing_code);	
			chkFields.add(p_service_code);	
			chkFields.add(order_category);
			chkFields.add(order_type_code);
			chkFields.add(description_code);
			chkFields.add(long_desc);
			chkFields.add(long_desc);
			chkFields.add(long_desc);
			chkFields.add(search_by);
			chkFields.add(description_code);
			chkFields.add(long_desc);
			chkFields.add(long_desc);
			chkFields.add(long_desc);
			chkFields.add(search_by);
			chkFields.add(activity_type);
			//chkFields.add(activity_type);
 		}
		if(called_from.equalsIgnoreCase("AM") || called_from.equalsIgnoreCase("OP") || called_from.equalsIgnoreCase("OA")) 
		{
		}
		else
		{
			/*Added by Uma on 3/12/2010 for IN019490*/

			if(privilegeApplicabilityOrd.equalsIgnoreCase("Y"))
			{
				if(practitionerId.equals(""))
				{
					practitionerId = bean.checkForNull((String)session.getValue("ca_practitioner_id"));
					if(practitionerId.equals("null")||practitionerId==null)
						practitionerId = (String) session.getValue("login_user") ;
				}
				String resp_id = (String)session.getValue("responsibility_id");
				chkFields.add(practitionerId);		//P_PRACTITIONER_ID
				chkFields.add(resp_id);		//P_RESP_ID
				chkFields.add(privilegeApplicabilityOrd);		//P_PRIV_APPL_YN
			}
		}
		/*End here*/

 	//Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );
	//Calling the Result from Common Adaptor as a arraylist.(sqlMap, funcMap, request,false)
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);
	

	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) ))
	{
	
            _bw.write(_wl_block11Bytes, _wl_block11);

		//For display the previous/next link
	     out.println(result.get(1));
	
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(result.size()));
            _bw.write(_wl_block15Bytes, _wl_block15);

		//Retriving the records from result arraylist
		
		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			//out.println("recCount"+recCount);
			/*if ( recCount % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;*/
				classvalue="gridData";
		
            _bw.write(_wl_block16Bytes, _wl_block16);

		String link_columns = "2", disp ="";
		records=(ArrayList) result.get( recCount );		
		for(int colCount=0; colCount<records.size(); colCount++){
			if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
				//out.println("one");
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((String)records.get(colCount)));
            _bw.write(_wl_block19Bytes, _wl_block19);
}else{
					
				if(colCount != 3){
					
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((String)records.get(colCount+0)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block23Bytes, _wl_block23);

					out.println((String)records.get(colCount)==null ? "&nbsp;" :(String)records.get(colCount));
				
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf((String)records.get(colCount+1)));
            _bw.write(_wl_block27Bytes, _wl_block27);

				}else{
						disp = (String)records.get(colCount);
					
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(disp));
            _bw.write(_wl_block29Bytes, _wl_block29);

					if(disp.equals("E")){
            _bw.write(_wl_block30Bytes, _wl_block30);
}else if(disp.equals("D")){
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block32Bytes, _wl_block32);

				}
			}
		}
		
            _bw.write(_wl_block33Bytes, _wl_block33);
}
		
            _bw.write(_wl_block34Bytes, _wl_block34);
out.flush();}else{
            _bw.write(_wl_block35Bytes, _wl_block35);
}
	}
	catch(Exception e) {
	//out.print("Exception @ Result JSP :"+e.toString());//COMMON-ICN-0181
          e.printStackTrace();//COMMON-ICN-0181
	}
	
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(type_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(activity_desc));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(activity_type));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(CallingModule));
            _bw.write(_wl_block41Bytes, _wl_block41);

	out.println(CommonBean.setForm(request ,"../../eOR/jsp/RefusalOrderOrderableResult.jsp", searched));

            _bw.write(_wl_block42Bytes, _wl_block42);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
