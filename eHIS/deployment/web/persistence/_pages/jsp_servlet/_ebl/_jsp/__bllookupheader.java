package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import eBL.*;
import eBL.Common.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __bllookupheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLLookupHeader.jsp", 1738037435336L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n<title> ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n<!--\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link>\n-->\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\n</head>\n<script>\n\n\tfunction closew()\n\t{\n\t\tparent.window.close();\n\t}\n\tfunction CallDescFrame()\n\t{\n//\t\tvar search_by_index = document.forms[0].search_by.selectedIndex;\n\t\tvar search_by_index = document.forms[0].search_by.value;\n\t\tvar size = search_by_index.length;\n\n\t\tsearch_by_index = search_by_index.substring(size-1,size);\n\t\tdocument.forms[0].search_by_index.value = search_by_index;\n\n\t\tdocument.forms[0].submit();\n\t }\n\n\t function valtext(comp)\n\t {\n\t\t var txt=comp.value\n\t\tCallDescFrame(this);\n\t}\n\n\tfunction target_click()\n\t{\n//\t\tif(document.forms[0].target.value != \"\")\n//\t\t{\n\t\t\tdocument.getElementById(\"Search\").click();\n//\t\t}\n\t}\n</script>\n\n<body onLoad = \"document.getElementById(\'search_text\').focus();target_click();\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\'frm_search_criteria\' id=\'frm_search_criteria\' ACTION=\'BLLookupBody.jsp?";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' method=\'post\' target=\'code_desc\'><!-- Added against MMS-DM-SCF-0729 -->\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n<!-- <table align=\'right\'  border=\"0\" width=100% cellspacing=\'0\' cellpadding=\'0\'> -->\n\t<table align=\'center\'  border=\"0\" width=100% cellspacing=\'0\' cellpadding=\'3\' >\n\t<tr>\n\t\t<td width=\"25%\"  class=\"label\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" </td>\n\t\t<td width=\"25%\" class=\"fields\"><select name=\"search_by\" id=\"search_by\"> \n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t</select>\n\t\t<!--  remove on 17/11/2020 //Modified on 24-11-20 -->\n\t\t<b class=\'label\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</b>\n\t\t<!-- Comments removed on 24-11-20 -->\n\t\t</td>\n\t\t<td width=\"25%\" class=\"label\"></td>\n\t\t<td width=\"25%\" class=\"label\"></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\'label\' width=\"25%\" >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t<td class=\"fields\" width=\"25%\"><input type=\"text\" onBlur=\'makeValidString(this);\'  name=\"search_text\" id=\"search_text\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"   size=\'40\' maxlength=\'100\' > </td>\n\t\t<td class=\"fields\" width=\"25%\"><select name=\"search_criteria\" id=\"search_criteria\">\n\t\t<option value=\"S\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t<option value=\"E\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t<option value=\"C\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t</select></td>\n\t\t<td class=\"button\" width=\"25%\"><input type=\"button\" name=\"Search\" id=\"Search\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" onClick=\"valtext(search_text); \" class=\'button\' >\n\t\t</td>\n\t </tr>\n\t <tr>\n\t\t<td width=\"25%\" colspan=\"4\">&nbsp;</td>\n\t </tr>\t\n</table>\n<input type=\'hidden\' name=\'column_names\' id=\'column_names\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n<input type=\'hidden\' name=\'column_descriptions\' id=\'column_descriptions\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n<input type=\'hidden\' name=\'column_sizes\' id=\'column_sizes\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n<input type=\'hidden\' name=\'column_types\' id=\'column_types\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n<input type=\'hidden\' name=\'search_by_index\' id=\'search_by_index\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n<input type=\'hidden\' name=\'sql\' id=\'sql\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n<input type=\'hidden\' name=\'target\' id=\'target\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n<input type=\'hidden\' name=\'col_show_hide\' id=\'col_show_hide\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n<input type=\'hidden\' name=\'called_for\' id=\'called_for\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n<BR>\n<BR>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );
	
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
Sr No        Version           Incident        SCF/CRF             Developer Name
----------------------------------------------------------------------------------
 1           V210211            12033       AMS-CRF-00249            Ram kumar S
 2           V210310            12033       AMS-CRF-00249            Ram kumar S
 3           V210420            16905       MOHE-SCF-0099      	  Shikha Seth/Muthu
 4			 V211014			25017		MMS-DM-SCF-0790-TF		MohanaPriya K
 5			 V211020						COMMON-ICN-0073-TF		Mohanapriya K
 6           V221227						PMG2022-COMN-CRF-0009   Namrata Charate
7				V221230							NMC-JD-CRF-0191.1 			Mohanapriya
8			V230418/V230824							MMS-DM-SCF-0861					Mohanapriya
9			 V230707						AAKH-CRF-0142.1			Namrata Charate
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block5Bytes, _wl_block5);

	String queryString=request.getQueryString();//Added against MMS-DM-SCF-0729
	request.setCharacterEncoding("UTF-8");
	String column_names = "";
	String column_descriptions = request.getParameter("column_descriptions");
	String column_sizes = request.getParameter("column_sizes");
	String column_types = "";
	String search_by_index = "";
	String target = "";
	target = request.getParameter("target");
	if(target == null) target = "";
	String srch_by_index = request.getParameter("srch_by_clmn_index");
	if(srch_by_index == null) srch_by_index="1";
	int srch_by_clmn_index = Integer.parseInt(srch_by_index);
	String col_show_hide = request.getParameter("col_show_hide");
	if(col_show_hide == null) col_show_hide="";
    
	ArrayList col_show_hide_lst = new ArrayList();
	
	/* Added V20180709-Aravindh/GHL-CRF-0427/Starts */
	String fin_auth_user_id = request.getParameter("fin_auth_user_id");
	if(fin_auth_user_id == null) {
		fin_auth_user_id = "";
	}
	
	Connection con = null;
	con = ConnectionManager.getConnection(request);
	boolean restrictBlngGrp = false;
	try {
		//con = ConnectionManager.getConnection(request);
		restrictBlngGrp = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_BLNG_GRP_RESTRICT_FOR_USER");
	} catch(Exception e) {
		System.err.println("Error in restrictBlngGrp BLLookupHeader.jsp --> "+e);
		e.printStackTrace();
	} 
	/* Added V20180709-Aravindh/GHL-CRF-0427/Ends */
	
	/*Added for ML-MMOH-CRF-1433/starts*/
	boolean SrchByBlngGp = false;
	try {
		SrchByBlngGp = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_MODIFY_FIN_DTL_BIL_GRP");
		System.err.println("SrchByBlngGp"+SrchByBlngGp);
	} catch(Exception e) {
		System.err.println("Error in  SrchByBlngGp BLLookupHeader.jsp --> "+e);
		e.printStackTrace();
	} 
	/*Added for ML-MMOH-CRF-1433/ends*/
	
/* All required parameters for the Lookup needs to be derived over here and passed to the BlRepository logic as below to retrieve the SQL for execution */ 
/* ************************************************* START OF SQL RETRIVAL LOGIC ****************************************** */
	String sql = "";
	String sqlData="";
	String called_for = request.getParameter("called_for");
	if(called_for == null) called_for="";
	if(called_for.equals("BGLKUP"))
	{	
		if(SrchByBlngGp){ //Added for ML-MMOH-CRF-1433
		srch_by_clmn_index=(srch_by_clmn_index-1);//Added against ML-MMOH-CRF-1433
		}//Added for ML-MMOH-CRF-1433
		try
		{
			HashMap values = new HashMap();
			values.put("locale",request.getParameter("locale"));
			values.put("facility_id",request.getParameter("facility_id"));
			values.put("patient_id",request.getParameter("patient_id"));
			values.put("episode_type",request.getParameter("episode_type"));
			values.put("function_id",request.getParameter("function_id"));
			values.put("blnggrp",request.getParameter("blnggrp"));
			values.put("encounter_date",request.getParameter("encounter_date"));
			values.put("citizen_yn",request.getParameter("citizen_yn"));
			values.put("ext_blng_grp",request.getParameter("ext_blng_grp"));
			values.put("BlngGrpFacility",request.getParameter("BlngGrpFacility"));
			System.err.println("Age  "+request.getParameter("ageVal"));//Added Against V210211
			values.put("AgeValidation",request.getParameter("ageVal"));//Added Against V210211
			/* Added V20180709-Aravindh/GHL-CRF-0427/Starts */
			if(restrictBlngGrp) {
				values.put("restrictBlngGrp", String.valueOf(restrictBlngGrp));
				String login_user = (String) session.getAttribute("login_user");
				if(!(fin_auth_user_id.trim().equals(""))) {
					values.put("login_user", fin_auth_user_id);
				} else {
					values.put("login_user", login_user);
				}
			}
			/* Added V20180709-Aravindh/GHL-CRF-0427/Ends */
			/* Added V190508-Aravindh/GHL-CRF-0553/Starts */
			values.put("siteSpecDispBlngGrpCatg", request.getParameter("siteSpecDispBlngGrpCatg"));
			values.put("billingGroupCatCode", request.getParameter("billingGroupCatCode"));
			values.put("slmtIndicator", request.getParameter("slmtIndicator"));
			/* Added V190508-Aravindh/GHL-CRF-0553/Ends */

			sql=BlRepository.getBlKeyValue("SQL_BL_BLNG_GRP_LKUP",values,called_for);
		}
		catch(Exception e)
		{
			System.err.println("IN BGLKUP Loop Exception while fetching the query:"+e);
			e.printStackTrace();
		}
	}
	else if(called_for.equals("NONINSBGLKUP"))
	{	
		if(SrchByBlngGp){ //Added for ML-MMOH-CRF-1433
		srch_by_clmn_index=(srch_by_clmn_index-1);//Added against ML-MMOH-CRF-1433
		} //Added for ML-MMOH-CRF-1433
		try
		{
			HashMap values = new HashMap();
			values.put("locale",request.getParameter("locale"));
			values.put("module_id",request.getParameter("module_id"));
			values.put("citizen_yn",request.getParameter("citizen_yn"));
			System.err.println("Age  "+request.getParameter("ageVal"));//Added Against V210310
			values.put("AgeValidation",request.getParameter("ageVal"));//Added Against V210310
			
			/* Added V20180709-Aravindh/GHL-CRF-0427/Starts */
			if(restrictBlngGrp) {
				values.put("restrictBlngGrp", String.valueOf(restrictBlngGrp));
				String login_user = (String) session.getAttribute("login_user");
				if(login_user == null) {
					login_user = "";
				}
				if(!(fin_auth_user_id.trim().equals(""))) {
					values.put("login_user", fin_auth_user_id);
				} else {
					values.put("login_user", login_user);
				}
			}
			/* Added V20180709-Aravindh/GHL-CRF-0427/Ends */

			sql=BlRepository.getBlKeyValue("SQL_BL_NON_INS_BLNG_GRP_LKUP",values,called_for);
		}
		catch(Exception e)
		{
			System.err.println("IN NONINSBGLKUP Loop Exception while fetching the query:"+e);
			e.printStackTrace();
		}
	}
	else if(called_for.equals("INSPAYERLKUP"))
	{
		try
		{
			HashMap values = new HashMap();
			//Comented against MMS-DM-SCF-0729
			//values.put("locale",request.getParameter("locale"));
			//values.put("module_id",request.getParameter("module_id"));
			//Comented against MMS-DM-SCF-0729
			
			values.put("episode_type",request.getParameter("episode_type"));
			values.put("auto_fin_chk",request.getParameter("auto_fin_chk"));
			
			//Comented against MMS-DM-SCF-0729
			//values.put("cust_grp_code",request.getParameter("cust_grp_code"));
			//values.put("class_code",request.getParameter("class_code"));
			//values.put("blng_grp_id",request.getParameter("blng_grp_id"));
			//values.put("search_by_items",request.getParameter("search_by_items"));
			//values.put("search_code",request.getParameter("search_code"));
			//values.put("facility_id",request.getParameter("facility_id"));
			//Comented against MMS-DM-SCF-0729

			sql=BlRepository.getBlKeyValue("SQL_BL_INS_PAYER_LKUP",values,called_for);
			System.err.println("Insurance Payer Look Up Query  "+sql);
		}
		catch(Exception e)
		{
			System.err.println("IN INSPAYERLKUP Loop Exception while fetching the query:"+e);
			e.printStackTrace();
		}
	}
	else if(called_for.equals("NONINSCUSTLKUP"))
	{
		try
		{
			HashMap values = new HashMap();
			values.put("locale",request.getParameter("locale"));
			values.put("module_id",request.getParameter("module_id"));
			values.put("cust_grp_code",request.getParameter("cust_grp_code"));
			values.put("non_ins_slmt_ind",request.getParameter("non_ins_slmt_ind"));
			values.put("non_ins_adm_flag",request.getParameter("non_ins_adm_flag"));
			values.put("search_by_items",request.getParameter("search_by_items"));
			values.put("search_code",request.getParameter("search_code"));

			sql=BlRepository.getBlKeyValue("SQL_BL_NON_INS_PAYER_LKUP",values,called_for);
		}
		catch(Exception e)
		{
			System.err.println("IN NONINSCUSTLKUP Loop Exception while fetching the query:"+e);
			e.printStackTrace();
		}
	}
	else if(called_for.equals("CREDITPAYERLKUP"))
	{
		try
		{
			HashMap values = new HashMap();
			values.put("locale",request.getParameter("locale"));
			values.put("auto_fin_chk",request.getParameter("auto_fin_chk"));
			values.put("blng_grp_id",request.getParameter("blng_grp_id"));
			values.put("class_code",request.getParameter("class_code"));
			values.put("cust_grp_code",request.getParameter("cust_grp_code"));
			values.put("facility_id",request.getParameter("facility_id"));
			values.put("module_id",request.getParameter("module_id"));
			values.put("search_by_items",request.getParameter("search_by_items"));
			values.put("search_code",request.getParameter("search_code"));
			values.put("select_cust_frm_pkg",request.getParameter("select_cust_frm_pkg"));
			values.put("site_id",request.getParameter("site_id"));
			sql=BlRepository.getBlKeyValue("SQL_BL_CREDIT_PAYER_LKUP",values,called_for);

		}
		catch(Exception e)
		{
			System.err.println("IN CREDITPAYERLKUP Loop Exception while fetching the query:"+e);
			e.printStackTrace();
		}
	}
	else if(called_for.equals("SPONSORPAYERLKUP"))
	{
		try
		{
			HashMap values = new HashMap();
			values.put("locale",request.getParameter("locale"));
			values.put("auto_fin_chk",request.getParameter("auto_fin_chk"));
			values.put("blng_grp_id",request.getParameter("blng_grp_id"));
			values.put("class_code",request.getParameter("class_code"));
			values.put("cust_grp_code",request.getParameter("cust_grp_code"));
			values.put("facility_id",request.getParameter("facility_id"));
			values.put("module_id",request.getParameter("module_id"));
			values.put("search_by_items",request.getParameter("search_by_items"));
			values.put("search_code",request.getParameter("search_code"));
			values.put("select_cust_frm_pkg",request.getParameter("select_cust_frm_pkg"));
			values.put("site_id",request.getParameter("site_id"));
			sql=BlRepository.getBlKeyValue("SQL_BL_SPONSOR_PAYER_LKUP",values,called_for);
		}
		catch(Exception e)
		{
			System.err.println("IN SPONSORPAYERLKUP Loop Exception while fetching the query:"+e);
			e.printStackTrace();
		}
	}
	else if(called_for.equals("REFSRCLKUP"))
	{
		try
		{
			HashMap values = new HashMap();
			values.put("locale",request.getParameter("locale"));
			values.put("episode_type",request.getParameter("episode_type"));

			sql=BlRepository.getBlKeyValue("SQL_BL_REF_SRC_LKUP",values,called_for);
		}
		catch(Exception e)
		{
			System.err.println("IN REFSRCLKUP Loop Exception while fetching the query:"+e);
			e.printStackTrace();
		}
	}
	else if(called_for.equals("GLHOLDERLKUP"))
	{
		try
		{
			HashMap values = new HashMap();
			values.put("locale",request.getParameter("locale"));
			values.put("facility_id",request.getParameter("facility_id"));
			values.put("patient_id",request.getParameter("patient_id"));
			values.put("slmt_ind",request.getParameter("slmt_ind"));
			values.put("encounter_date_time",request.getParameter("encounter_date_time"));
			values.put("module_id",request.getParameter("module_id"));

			sql=BlRepository.getBlKeyValue("SQL_BL_GL_HOLDER_LKUP",values,called_for);
		}
		catch(Exception e)
		{
			System.err.println("IN GLHOLDERLKUP Loop Exception while fetching the query:"+e);
			e.printStackTrace();
		}
	}
	//Added By Rajesh V
	else if(called_for.equals("POLICYLUKP"))
	{
		try
		{
			String locale = request.getParameter("locale");
			String facility_id = request.getParameter("facility_id");
			String cust_code = request.getParameter("cust_code");
			String cust_group_code = request.getParameter("cust_group_code");
			String strModuleId = request.getParameter("strModuleId");
			int totalRecords = 0;
			try{
				totalRecords = Integer.parseInt(request.getParameter("totalRecords"));
			}
			catch(Exception a){
				totalRecords = 0;
				a.printStackTrace();
			}

			String action = request.getParameter("action");
			String policy_coverage_basis_gbl_ind = request.getParameter("policy_coverage_basis_gbl_ind");
			String link_policy_in_billing = request.getParameter("link_policy_in_billing");
			
			sql = 		"Select DISTINCT a.policy_type_code POLICY_TYPE_CODE,a.short_desc SHORT_DESC,POLICY_COVERAGE_BASIS POLICY_COVERAGE_BASIS"
					 +" from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b, bl_cust_by_cust_group c" 
					 +" where a.language_id='"+locale+"'" 
					 +" and  a.operating_facility_id='"+facility_id+"'" 
				   	 +" and nvl(a.status,'N') <> 'S'"
					 +" and a.operating_facility_id = b.operating_facility_id"  
					 +" and a.policy_type_code = b.policy_type_code"
					 +" and c.cust_code='"+cust_code+"'" 
					 +" and c.cust_group_code = b.cust_group_code"
					 +" and (b.cust_code=c.cust_code or b.cust_code = '**')"
					 +" AND b.cust_group_code = '"+cust_group_code+"'" 
					 +" and (('"+strModuleId+"' in ('OP','AE') and nvl(b.outpatient_cover,'N') = 'Y')" 
					 +" or ('"+strModuleId+"' in ('IP','DC') and nvl(b.inpatient_covered,'N') = 'Y')"
					 +" or ('"+strModuleId+"' = 'MP' and nvl(b.external_covered,'N') = 'Y'))";
			
			if(totalRecords>1 || ("add".equals(action) && totalRecords>=1))
			{
				if("I".equals(policy_coverage_basis_gbl_ind))
				{
					sql=sql+" and b.POLICY_COVERAGE_BASIS='"+policy_coverage_basis_gbl_ind+"'";
				}
			}
			
			if("Y".equalsIgnoreCase(link_policy_in_billing)){
				sql += " and trunc(SYSDATE) BETWEEN NVL(b.POLICY_EFF_FROM,SYSDATE-1) and NVL(b.POLICY_EFF_TO,SYSDATE) ";
			}
			
		}
		catch(Exception e)
		{
			System.err.println("IN GLHOLDERLKUP Loop Exception while fetching the query:"+e);
			e.printStackTrace();
		}
	}
	//Added By Rajesh V
	//Karthik added for Encounter Specific Lookup - starts
	/* AAKH-SCF-0038 - Added c.visit_adm_date_time CLINIC_DATE_SORT field by Karthik to sort based on clinic date descending */
	else if(called_for.equals("ENC_SPEC_EPISODE_LOOKUP"))
	{

	String episodeType=request.getParameter("episode_type");
	String facilityID=request.getParameter("facility_id");
	String patientID=request.getParameter("patient_id");
	String encounterDt=request.getParameter("encounter_date");
		
	String sqlOP=" SELECT a.patient_id PATIENT_ID,a.episode_type EPISODE_TYPE,  "+
		" a.episode_id EPISODE_ID,visit_id VISIT_ID, "+
		" TO_CHAR (c.visit_adm_date_time, 'dd/mm/yyyy') CLINIC_DATE, "+
		" a.clinic_code CLINIC_CODE, r.short_desc CLINIC_DESC ,TO_CHAR (c.visit_adm_date_time, 'dd/mm/yyyy')  CLINIC_DATE_TRUNC "+
		   " FROM bl_visit_fin_dtls a, pr_encounter c, op_clinic r "+
		   " WHERE a.operating_facility_id = c.facility_id "+
		   " AND c.encounter_id = a.episode_id || LPAD (a.visit_id, 4, 0) "+
		   " AND a.episode_type = "+"'"+episodeType+"'"+
		   " AND r.clinic_code = a.clinic_code "+
		   " AND c.facility_id = r.facility_id "+
		   " AND a.operating_facility_id =  "+"'"+facilityID+"'"+
		   /*Uncommenting the below line will enable Date wise search*/
		  // " AND TO_CHAR (c.visit_adm_date_time, 'dd/mm/yyyy')=NVL('"+encounterDt+"',TO_CHAR (c.visit_adm_date_time, 'dd/mm/yyyy')) "+
		   " AND EXISTS ( "+
		          " SELECT policy_type_code "+
		            " FROM bl_encounter_payer_priority b "+
		           " WHERE a.operating_facility_id = b.operating_facility_id "+
		             " AND a.episode_type = b.episode_type "+
		             " AND a.episode_id = b.episode_id "+
		             " AND a.visit_id = b.visit_id "+
		             " AND b.operating_facility_id ="+"'"+facilityID+"'"+
		             " AND b.episode_type = "+"'"+episodeType+"'"+
		             " AND b.patient_id = NVL ('"+patientID+"', patient_id) "+
		             " AND b.acct_seq_no = a.cur_acct_seq_no "+
		             " AND b.priority = 1 "+
		             " AND b.policy_type_code IS NOT NULL) ";
 	
 	String sqlIP=" SELECT   a.patient_id PATIENT_ID, a.episode_type EPISODE_TYPE, a.episode_id EPISODE_ID, NULL VISIT_ID, "+
 	        " TO_CHAR (c.visit_adm_date_time, 'dd/mm/yyyy') CLINIC_DATE, "+
 	        " d.nursing_unit_code CLINIC_CODE, d.short_desc CLINIC_DESC ,TO_CHAR (c.visit_adm_date_time, 'dd/mm/yyyy') CLINIC_DATE_TRUNC"+
 	   " FROM bl_episode_fin_dtls a, pr_encounter c, ip_nursing_unit d "+
 	  " WHERE a.operating_facility_id = c.facility_id "+
 	    " AND a.episode_id = c.episode_id "+
 	    " AND a.episode_type =  "+"'"+episodeType+"'"+
 	    " AND c.facility_id = d.facility_id "+
 	    " AND d.nursing_unit_code = c.assign_care_locn_code "+
 	    " AND c.assign_care_locn_type = 'N' "+
 	    " AND a.operating_facility_id =  "+"'"+facilityID+"'"+
 	  /*Uncommenting the below line will enable Date wise search*/
 	  //  " AND TO_CHAR (c.visit_adm_date_time, 'dd/mm/yyyy')=NVL('"+encounterDt+"',TO_CHAR (c.visit_adm_date_time, 'dd/mm/yyyy')) "+
 	    " AND EXISTS ( "+
 	           " SELECT policy_type_code "+
 	             " FROM bl_encounter_payer_priority b "+
 	            " WHERE a.operating_facility_id = b.operating_facility_id "+
 	              " AND a.episode_type = b.episode_type "+
 	              " AND a.episode_id = b.episode_id "+
 	              " AND b.operating_facility_id =  "+"'"+facilityID+"'"+
 	              " AND b.episode_type =  "+"'"+episodeType+"'"+
 	              " AND b.patient_id = NVL ('"+patientID+"', patient_id) "+
 	              " AND b.acct_seq_no = a.cur_acct_seq_no "+
 	              " AND b.priority = 1 "+
 	              " AND b.policy_type_code IS NOT NULL) ";
 	
 	String sqlRef=
			 " SELECT DISTINCT PATIENT_ID PATIENT_ID1, episode_type EPISODE_TYPE1, NULL episode_id,NULL visit_id,ENC_REGN_DATE_TIME clinic_date,NULL clinic_code,NULL clinic_desc ,TO_CHAR (ENC_REGN_DATE_TIME, 'dd/mm/yyyy')  CLINIC_DATE_TRUNC"+
			  " FROM bl_encounter_payer_priority WHERE operating_facility_id = '"+facilityID+"'"+
			  "  AND patient_id =  NVL ('"+patientID+"', patient_id) "+
			  "  AND episode_type = '"+episodeType+"'";
 			
 	
 	if(episodeType.equalsIgnoreCase("O")||episodeType.equalsIgnoreCase("E")){
 		sql=sqlOP;
 	} else	if(episodeType.equalsIgnoreCase("I")||episodeType.equalsIgnoreCase("D")){
 		sql=sqlIP;
 	} else  if(episodeType.equalsIgnoreCase("R")){
 		sql=sqlRef;
 	}
	
	}	//Karthik added for Encounter Specific Lookup - ends
	else if(called_for.equals("REPRINT_HDR_EPISODE_LOOKUP"))
	{

		String episodeType=request.getParameter("episode_type");
		String facilityID=request.getParameter("facility_id");
		String patientID=request.getParameter("patient_id");
		String encounterDt=request.getParameter("encounter_date");
			
		String sqlOP=" SELECT a.patient_id PATIENT_ID,a.episode_type EPISODE_TYPE,  "+
			" a.episode_id EPISODE_ID,visit_id VISIT_ID, "+
			" TO_CHAR (c.visit_adm_date_time, 'dd/mm/yyyy') CLINIC_DATE, "+
			" a.clinic_code CLINIC_CODE, r.short_desc CLINIC_DESC "+
			   " FROM bl_visit_fin_dtls a, pr_encounter c, op_clinic r "+
			   " WHERE a.operating_facility_id = c.facility_id "+
			   " AND c.encounter_id = a.episode_id || LPAD (a.visit_id, 4, 0) "+
			   " AND a.episode_type = "+"'"+episodeType+"'"+
			   " AND r.clinic_code = a.clinic_code "+
			   " AND c.facility_id = r.facility_id "+
			   " AND a.operating_facility_id =  "+"'"+facilityID+"'"+
			   " AND a.patient_id = NVL ('"+patientID+"', a.patient_id) "; 

	 	
	 	String sqlIP=" SELECT   a.patient_id PATIENT_ID, a.episode_type EPISODE_TYPE, a.episode_id EPISODE_ID, NULL VISIT_ID, "+
	 	        " TO_CHAR (c.visit_adm_date_time, 'dd/mm/yyyy') CLINIC_DATE, "+
	 	        " d.nursing_unit_code CLINIC_CODE, d.short_desc CLINIC_DESC "+
	 	   " FROM bl_episode_fin_dtls a, pr_encounter c, ip_nursing_unit d "+
	 	  " WHERE a.operating_facility_id = c.facility_id "+
	 	    " AND a.episode_id = c.episode_id "+
	 	    " AND a.episode_type =  "+"'"+episodeType+"'"+
	 	    " AND c.facility_id = d.facility_id "+
	 	    " AND d.nursing_unit_code = c.assign_care_locn_code "+
	 	    " AND c.assign_care_locn_type = 'N' "+
	 	    " AND a.operating_facility_id =  "+"'"+facilityID+"'"+
	 		" AND a.patient_id = NVL ('"+patientID+"', a.patient_id) "; 
	 	
	 	String sqlRef=
				 " SELECT DISTINCT PATIENT_ID PATIENT_ID1,  episode_type, NULL episode_id,NULL visit_id,NULL clinic_date,NULL clinic_code,NULL clinic_desc "+
				  " FROM bl_encounter_payer_priority WHERE operating_facility_id = '"+facilityID+"'"+
				  "  AND patient_id =  NVL ('"+patientID+"', patient_id) "+
				  "  AND episode_type = '"+episodeType+"'";
	 			
	 	
	 	if(episodeType.equalsIgnoreCase("O")||episodeType.equalsIgnoreCase("E")){
	 		sql=sqlOP;
	 	} else	if(episodeType.equalsIgnoreCase("I")||episodeType.equalsIgnoreCase("D")){
	 		sql=sqlIP;
	 	} else  if(episodeType.equalsIgnoreCase("R")){
	 		sql=sqlRef;
	 	}
		
		}	//Karthik added for Encounter Specific Lookup - ends

	//Added by Rajesh V for AMS-CRF-014
	else if("BILL_DOC_LOOKUP".equals(called_for)){
		String billNumberDesc = request.getParameter("billNumberDesc");		
		String facilityId = request.getParameter("facilityId");
	    /* Karthik added  ATE-BL-AMS-CRF-0049 52763  Starts*/
		String patient_id = request.getParameter("patient_id");
		if(patient_id==null) patient_id="";
		String episode_id = request.getParameter("episode_id");
		if(episode_id==null) episode_id="";
		String episode_type = request.getParameter("episode_type");
		if(episode_type==null) episode_type="";
		String cust_code = request.getParameter("cust_code");
		if(cust_code==null) cust_code="";
		String doc_type_code = request.getParameter("doc_type_code");
		if(doc_type_code==null) doc_type_code="";
		String visit_id = request.getParameter("visit_id");
		if(visit_id==null) visit_id="";
		
		sql = "SELECT doc_num code,  doc_type_code description FROM bl_bill_hdr where operating_facility_id = '"+facilityId+"'  and patient_id=nvl('"+patient_id+"',patient_id) AND NVL (bill_status, '$') <> 'C' ";
		
		if( "".equals(episode_id) == false ){
			sql +=	 "and episode_id=nvl('"+episode_id+"',episode_id)  ";
		}
		if( "".equals(episode_type) == false ){
			sql +=	 "AND episode_type = (DECODE('"+episode_type+"','**',episode_type,'"+episode_type+"')) ";
		}
		if( "".equals(cust_code) == false ){
			sql +=	 "AND CUST_CODE = (DECODE('"+cust_code+"','**',cust_code,'"+cust_code+"')) ";
		}
		if( "".equals(doc_type_code) == false ){
			sql +=	 "AND doc_type_code ='"+doc_type_code+"' ";
		}
		if( "".equals(visit_id) == false ){
			sql +=	 "AND visit_id ='"+visit_id+"' ";
		}
		
	}
	//Added by Rajesh V for AMS-CRF-014
	
	//Added by Subha-V20181112/AAKH-CRF-0103/Starts
	else if("JOB_ID_LOOKUP".equals(called_for)) {
		String facilityId = request.getParameter("facilityId");
		String visitFrom = request.getParameter("fromDate");
		String visitTo = request.getParameter("toDate");
		/* sql = "select a.orajobid jobid, a.cust_group_code grpcode, b.long_desc custgrp, a.cust_code custcode, c.long_name custname," 
				+ " decode(a.episode_type, 'O', 'Outpatient', 'E', 'Emergency', 'All') episode from BL_BACKGROUND_PROCESS a,"
				+ " ar_cust_group b, ar_customer c where patient_id is null and a.CUST_CODE = c.cust_code"
				+ " and a.cust_group_code = b.cust_group_code and a.operating_facility_id = '"+facilityId+"'"
				+ " AND TRUNC (SUBMISSION_DATE) BETWEEN TRUNC (to_date('"+visitFrom+"','dd/MM/yyyy')) AND TRUNC (to_date('"+visitTo+"','dd/MM/yyyy'))"; */
		sql = "select d.jobid jobid, d.grpcode grpcode, d.custgrp custgrp, d.custcode custcode, NVL(d.long_name, 'All Customers') custname, d.episode episode from ("
				+ " SELECT a.orajobid jobid, a.cust_group_code grpcode, b.long_desc custgrp, NVL (a.cust_code, '**') custcode, c.long_name,"
                + " DECODE (a.episode_type, 'O', 'Outpatient', 'E', 'Emergency', 'All') episode FROM bl_background_process a, ar_cust_group b, ar_customer c"
				+ " WHERE a.operating_facility_id = '"+facilityId+"' AND patient_id IS NULL AND a.cust_group_code = b.cust_group_code AND a.cust_code = c.cust_code(+)"
				+ " AND TRUNC (a.submission_date) BETWEEN TRUNC (TO_DATE ('"+visitFrom+"', 'dd/MM/yyyy')) AND TRUNC (TO_DATE ('"+visitTo+"', 'dd/MM/yyyy'))"
				+ " ) d where 1=1";
	}
	//Added by Subha-V20181112/AAKH-CRF-0103/Ends
	else if("BILLING_CATG_LOOKUP".equals(called_for)) {/* Added V190508-Aravindh/GHL-CRF-0553/ */
		String facilityId = request.getParameter("facilityId");
		String locale = request.getParameter("locale");
		sql = "select SHORT_DESC description, BLNG_GRP_CATG code from BL_BLNG_GRP_CATG_LANG_VW where language_id = '"+locale+"'";
	} else if("EMPLOYER_NAME".equals(called_for)) {//Added V190918-Aravindh/GHL-SCF-1458
		String locale = request.getParameter("locale");
		String blng_grp_id = request.getParameter("blng_grp_id");
		sql = "SELECT  short_name description, cust_code code  FROM bl_emp_ins_mst_lang_vw  WHERE language_id = '" + locale +
              "' and ((blng_grp_id = '"+blng_grp_id+"' and blcommon.IS_FUNCTION_APPLICABLE_YN('BL', 'EMPLR_BLNG_GRP_MAPPING') = 'Y') OR "+ 
              " (blcommon.IS_FUNCTION_APPLICABLE_YN('BL', 'EMPLR_BLNG_GRP_MAPPING') = 'N' AND  NVL (insurance_yn, 'N') = 'N')) AND status IS NULL";
	}
	//V210420 Start
	else if("BLOPIPREP_FACILITY_ID_LKUP1".equals(called_for)) {	
		System.err.println("called_for  =21/04/2021   BLOPIPREP_FACILITY_ID_LKUP1");
		try
		{
			//HashMap values = new HashMap();
			//values.put("locale",request.getParameter("locale"));
			//values.put("facility",request.getParameter("facility"));	
			String locale =request.getParameter("locale");
			if(locale == null) locale = "en";				
			String facility = request.getParameter("facility");
			if(facility == null) facility = "";
			sql= "SELECT facility_id facility_id,facility_name facility_name FROM sm_facility_param_lang_vw WHERE upper(language_id) = upper('"+locale+"')  and upper(facility_id) = upper('"+facility+"')  ";
			//sql=BlRepository.getBlKeyValue("BLOPIPREP_FACILITY_ID_LKUP",values,called_for);			
		}
		catch(Exception e)
		{
			System.err.println("IN BLOPIPREP_FACILITY_ID_LKUP1 Loop Exception while fetching the query:"+e);
			e.printStackTrace();
		}
	} 
	/* else if("BLOPIPREP_FACILITY_ID_LKUP2".equals(called_for)) {	
		 System.err.println("called_for  =21/04/2021   BLOPIPREP_FACILITY_ID_LKUP2");
			try
			{
				String locale = request.getParameter("locale");
				if(locale == null) locale = "en";
				sql = "SELECT facility_id facility_id,facility_name facility_name from (select 'ALL' facility_id,'All Facility' facility_name from dual union SELECT facility_id facility_id,facility_name facility_name FROM sm_facility_param_lang_vw WHERE upper(language_id) = upper('"+locale+"')) where 1=1  ";
			//	HashMap values = new HashMap();
			//	values.put("locale",request.getParameter("locale"));				
			//	sql=BlRepository.getBlKeyValue("BLOPIPREP_FACILITY_ID_LKUP",values,called_for);				
			}
			catch(Exception e)
			{
				System.err.println("IN BLOPIPREP_FACILITY_ID_LKUP2 Loop Exception while fetching the query:"+e);
				e.printStackTrace();
			}
		}*/
	else if("BLOPIPREP_ENCOUNTER_ID_LKUP1".equals(called_for)) {	
		 System.err.println("called_for  =21/04/2021   BLOPIPREP_ENCOUNTER_ID_LKUP1");		
		try
		{		
			String patient_id = request.getParameter("patient_id");
			if(patient_id == null) patient_id = "";
			String episodeType = request.getParameter("episodeType");
			if(episodeType == null) episodeType = "";
			String Effective_from = request.getParameter("Effective_from");
			if(Effective_from == null) Effective_from = "";
			String Effective_to = request.getParameter("Effective_to");
			if(Effective_to == null) Effective_to = "";
			sql= "SELECT EPISODE_ID EPISODE_ID,ENCOUNTER_ID ENCOUNTER_ID FROM pr_encounter WHERE PATIENT_ID='"+patient_id+"' AND PATIENT_CLASS='"+episodeType+"' AND TRUNC(VISIT_ADM_DATE_TIME) BETWEEN TRUNC (to_date('"+Effective_from+"','dd/MM/yyyy')) AND TRUNC (to_date('"+Effective_to+"','dd/MM/yyyy')) ";
			
			/*HashMap values = new HashMap();
			values.put("patient_id",request.getParameter("patient_id"));
			values.put("episodeType",request.getParameter("episodeType"));
			values.put("Effective_from",request.getParameter("Effective_from"));
			values.put("Effective_to",request.getParameter("Effective_to"));			
			sql=BlRepository.getBlKeyValue("BLOPIPREP_ENCOUNTER_ID_LKUP1",values,called_for);		*/	
		}
		catch(Exception e)
		{
			System.err.println("IN BLOPIPREP_ENCOUNTER_ID_LKUP1 Loop Exception while fetching the query:"+e);
			e.printStackTrace();
		}
	} else if("BLOPIPREP_ENCOUNTER_ID_LKUP2".equals(called_for)) {	//shikha		
		 System.err.println("called_for  =21/04/2021   BLOPIPREP_ENCOUNTER_ID_LKUP2");	
		try
		{		
			String patient_id = request.getParameter("patient_id");
			if(patient_id == null) patient_id = "";
			String episodeType = request.getParameter("episodeType");
			if(episodeType == null) episodeType = "";
			sql = "SELECT EPISODE_ID EPISODE_ID,ENCOUNTER_ID ENCOUNTER_ID FROM pr_encounter WHERE PATIENT_ID='"+patient_id+"' AND PATIENT_CLASS='"+episodeType+"'";
			
			/*HashMap values = new HashMap();
			values.put("patient_id",request.getParameter("patient_id"));
			values.put("episodeType",request.getParameter("episodeType"));						
			sql=BlRepository.getBlKeyValue("BLOPIPREP_ENCOUNTER_ID_LKUP2",values,called_for);			*/
		}
		catch(Exception e)
		{
			System.err.println("IN BLOPIPREP_ENCOUNTER_ID_LKUP2 Loop Exception while fetching the query:"+e);
			e.printStackTrace();
		}
		
	} else if("BLOPIPREP_ENCOUNTER_ID_LKUP3".equals(called_for)) {	//shikha
		 System.err.println("called_for  =21/04/2021   BLOPIPREP_ENCOUNTER_ID_LKUP3");		
	System.err.println("called_for  =21/04/2021   facility "+request.getParameter("facility"));		
		try		
		{
			String patient_id = request.getParameter("patient_id");
			if(patient_id == null) patient_id = "";
			String episodeType = request.getParameter("episodeType");
			if(episodeType == null) episodeType = "";
			String Effective_from = request.getParameter("Effective_from");
			if(Effective_from == null) Effective_from = "";
			String Effective_to = request.getParameter("Effective_to");
			if(Effective_to == null) Effective_to = "";
			String facility =request.getParameter("facility");
			if(facility == null) facility = "";
			sql= "SELECT EPISODE_ID EPISODE_ID,ENCOUNTER_ID ENCOUNTER_ID  FROM pr_encounter WHERE  FACILITY_ID = '"+facility+"' AND PATIENT_ID='"+patient_id+"' AND PATIENT_CLASS='"+episodeType+"' AND TRUNC(VISIT_ADM_DATE_TIME) BETWEEN TRUNC (to_date('"+Effective_from+"','dd/MM/yyyy')) AND TRUNC (to_date('"+Effective_to+"','dd/MM/yyyy'))  ";				
			
			/*HashMap values = new HashMap();
			values.put("patient_id",request.getParameter("patient_id"));
			values.put("episodeType",request.getParameter("episodeType"));
			values.put("Effective_from",request.getParameter("Effective_from"));
			values.put("Effective_to",request.getParameter("Effective_to"));
			values.put("facility",request.getParameter("facility"));						
			sql=BlRepository.getBlKeyValue("BLOPIPREP_ENCOUNTER_ID_LKUP3",values,called_for);	*/		
		}
		catch(Exception e)
		{
			System.err.println("IN BLOPIPREP_ENCOUNTER_ID_LKUP3 Loop Exception while fetching the query:"+e);
			e.printStackTrace();
		}
		
	} else if("BLOPIPREP_ENCOUNTER_ID_LKUP4".equals(called_for)) {	//shikha	
		 System.err.println("called_for  =21/04/2021   BLOPIPREP_ENCOUNTER_ID_LKUP4");	
		try
		{
			String patient_id = request.getParameter("patient_id");
			if(patient_id == null) patient_id = "";
			String episodeType = request.getParameter("episodeType");
			if(episodeType == null) episodeType = "";				
			String facility = request.getParameter("facility");
			if(facility == null) facility = "";
			sql= "SELECT EPISODE_ID EPISODE_ID,ENCOUNTER_ID ENCOUNTER_ID  FROM pr_encounter WHERE  FACILITY_ID = '"+facility+"' AND PATIENT_ID='"+patient_id+"' AND PATIENT_CLASS='"+episodeType+"' ";
			
			/*HashMap values = new HashMap();
			values.put("patient_id",request.getParameter("patient_id"));
			values.put("episodeType",request.getParameter("episodeType"));			
			values.put("facility",request.getParameter("facility"));			
			sql=BlRepository.getBlKeyValue("BLOPIPREP_ENCOUNTER_ID_LKUP4",values,called_for);	*/		
		}
		catch(Exception e)
		{
			System.err.println("IN BLOPIPREP_ENCOUNTER_ID_LKUP4 Loop Exception while fetching the query:"+e);
			e.printStackTrace();
		}		
	} //V210420 end
	//added by manivel starts for mohe-scf-0009.1
	else if("EncounterLookup".equals(called_for)) {
		System.err.println("inside ---->  EncounterLookup");
		try
		{
			System.err.println("inside ---->  try");
			String episodeType = request.getParameter("episodeType");
			if(episodeType == null) episodeType = "";
			System.err.println("episodeType ---->  "+episodeType);			
			
			String facility = request.getParameter("facility");
			if(facility == null) facility = "";
			System.err.println("facility ---->  "+facility);
			
			String patient_id = request.getParameter("patient_id");
			if(patient_id == null) patient_id = "";
			System.err.println("patient_id ---->  "+patient_id);
			
			String effFrom = request.getParameter("effFrom");
			if(effFrom == null) effFrom = "";
			System.err.println("effFrom ---->  "+effFrom);
			
			String effTo = request.getParameter("effTo");
			if(effTo == null) effTo = "";
			System.err.println("effTo ---->  "+effTo);
			
			String billDateFrom = request.getParameter("billDateFrom");
			if(billDateFrom == null) billDateFrom = "";
			System.err.println("billDateFrom ----> "+billDateFrom);
			
			String billDateTo = request.getParameter("billDateTo");
			if(billDateTo == null) billDateTo = "";
			System.err.println("billDateTo ----> "+billDateTo);
			
			// sql="SELECT EPISODE_ID description,ENCOUNTER_ID code  FROM pr_encounter WHERE  FACILITY_ID = '"+facility+"' AND PATIENT_ID='"+patient_id+"' AND PATIENT_CLASS='"+episodeType+"'";
			
			if(facility.equals("ALL")) {				
				System.err.println("sql in Lookup IF="+sql);
				if(effFrom != null && !("".equals(effFrom)) && effTo != null && !("".equals(effTo)) )
					sql="SELECT EPISODE_ID description,ENCOUNTER_ID code FROM pr_encounter WHERE  PATIENT_ID='"+patient_id+"' AND PATIENT_CLASS='"+episodeType+"' AND TRUNC(VISIT_ADM_DATE_TIME) BETWEEN TRUNC (to_date('" + effFrom +"','dd/MM/yyyy')) AND TRUNC (to_date('" + effTo +"','dd/MM/yyyy'))";
				else
					sql="SELECT EPISODE_ID description,ENCOUNTER_ID code FROM pr_encounter WHERE  PATIENT_ID='"+patient_id+"' AND PATIENT_CLASS='"+episodeType+"'";
			} else if((effFrom != null && !("".equals(effFrom)) && effTo != null && !("".equals(effTo))) && (billDateFrom != null && !("".equals(billDateFrom)) && billDateTo != null && !("".equals(billDateTo)))){
				
				/*sql="SELECT a.episode_id description,a.encounter_id code,visit_adm_date_time FROM pr_encounter a WHERE EXISTS (SELECT 1 FROM bl_patient_charges_folio b WHERE a.facility_id = b.operating_facility_id AND a.patient_id = b.patient_id AND a.episode_id = b.episode_id AND TRUNC(b.bill_doc_date) BETWEEN TRUNC(TO_DATE('" +billDateFrom+"','dd/MM/yyyy')) AND TRUNC(TO_DATE('"+billDateTo+"','dd/MM/yyyy'))) AND FACILITY_ID ='"+facility+"' AND PATIENT_ID='"+patient_id+"' AND PATIENT_CLASS='"+episodeType+"' AND TRUNC(a.visit_adm_date_time) BETWEEN TRUNC(TO_DATE('"+effFrom+"','dd/MM/yyyy')) AND TRUNC(TO_DATE('"+effTo+"','dd/MM/yyyy'))";*/
				sql="SELECT a.episode_id description,a.encounter_id code FROM pr_encounter a WHERE bl_validate_bill_period_yn(a.facility_id,a.patient_id , a.episode_id, TRUNC(TO_DATE('"+billDateFrom+"','dd/MM/yyyy')), TRUNC(TO_DATE('"+billDateTo+"','dd/MM/yyyy'))) = 'Y' AND FACILITY_ID ='"+facility+"' AND PATIENT_ID='"+patient_id+"' AND PATIENT_CLASS='"+episodeType+"' AND TRUNC(a.visit_adm_date_time) BETWEEN TRUNC(TO_DATE('"+effFrom+"','dd/MM/yyyy')) AND TRUNC(TO_DATE('"+effTo+"','dd/MM/yyyy'))";
				System.err.println("sql in Lookup ELSEIF1="+sql);
			} else if((effFrom != null && !("".equals(effFrom)) && effTo != null && !("".equals(effTo)))){
				
				sql="SELECT EPISODE_ID description, ENCOUNTER_ID code FROM pr_encounter WHERE FACILITY_ID = '"+facility+"' AND	PATIENT_ID='"+patient_id+"' AND PATIENT_CLASS='"+episodeType+"' AND TRUNC (VISIT_ADM_DATE_TIME) BETWEEN TRUNC (TO_DATE ( '" + effFrom +"','dd/MM/yyyy')) AND TRUNC (TO_DATE ('" + effTo +"','dd/MM/yyyy')) ";
				System.err.println("sql in Lookup ELSEIF2="+sql);
			} else if((billDateFrom != null && !("".equals(billDateFrom)) && billDateTo != null && !("".equals(billDateTo)))){
				
				sql="SELECT EPISODE_ID description, ENCOUNTER_ID code FROM pr_encounter WHERE FACILITY_ID = '"+facility+"' AND PATIENT_CLASS='"+episodeType+"' AND PATIENT_ID IN ( SELECT PATIENT_ID FROM BL_BILL_HDR WHERE TRUNC (DOC_DATE) BETWEEN TRUNC (TO_DATE ('" + billDateFrom +"','dd/MM/yyyy')) AND TRUNC (TO_DATE ('" + billDateTo +"','dd/MM/yyyy')) AND PATIENT_ID ='"+patient_id+"') ";
				System.err.println("sql in Lookup ELSEIF3="+sql);				
			}				
			else {
				sql="SELECT EPISODE_ID description,ENCOUNTER_ID code FROM pr_encounter WHERE  FACILITY_ID = '"+facility+"' AND PATIENT_ID='"+patient_id+"' AND PATIENT_CLASS='"+episodeType+"'";
				System.err.println("sql in Lookup ELSE="+sql);
			}
			
			//System.out.println("sql in Lookup="+sql);
			
		} catch(Exception e)
		{
			System.err.println("IN Encounter Lookup Loop Exception while fetching the query:"+e);
			e.printStackTrace();
		}	
	}
	//added by manivel ends
	else if("CANCEL_PACKAGE_REASON_LKUP".equals(called_for)) {
		String locale = request.getParameter("locale");
		sql = "SELECT DISTINCT a.action_reason_desc short_desc,a.action_reason_code action_code FROM bl_action_reason_lang_vw a, bl_action_reason_by_type b WHERE a.action_reason_code = b.action_reason_code AND action_type = 'CP' AND active_yn = 'Y' AND language_id='"+locale+"'";
	}	
	else if("PACKAGE_AUTH_REASON_LKUP".equals(called_for)) {
		String locale = request.getParameter("locale");
		sql = "SELECT DISTINCT a.action_reason_desc short_desc,a.action_reason_code action_code FROM bl_action_reason_lang_vw a, bl_action_reason_by_type b WHERE a.action_reason_code = b.action_reason_code AND action_type = 'MP' AND active_yn = 'Y' AND language_id='"+locale+"'";
	}else if("Org_Bill_ref_num".equals(called_for)) {//V221230
		String patient_id = request.getParameter("patient_id");
		String facility_id = request.getParameter("facility_id");
		String episode_type = request.getParameter("episode_type");
		
		sql="select (doc_type_code ||'/'|| doc_num) bill_Ref from bl_bill_hdr where PATIENT_ID='"+patient_id+"' and operating_facility_id = '"+facility_id+"' and episode_type = '"+episode_type+"' and bill_status='C' ";
		
	}
	else if(called_for.equals("SPLTYLKUP")){
		
		String locale = request.getParameter("locale");
		
		System.err.println("Inside SPLTYLKUP");
		String clinicVal = request.getParameter("clinicVal");
		if(clinicVal == null) clinicVal = "";
		String sqlSelect = request.getParameter("sqlSelect");
		if(sqlSelect == null) sqlSelect = "";
		String facility_id = request.getParameter("facility_id");
		if(facility_id == null) facility_id = "";

		try
		{	
			int sqlVal=Integer.parseInt(sqlSelect);	

			switch (sqlVal) {
				case 1:
				{
					sql = "select z.description description, z.code code from (select 'All Specialities' description, '**' code from dual UNION select a.short_desc description, a.speciality_code code from am_speciality_lang_vw a join op_clinic_lang_vw b on (a.speciality_code = b.SPECIALITY_CODE AND b.clinic_code = '" + clinicVal + "' AND b.facility_id = '" + facility_id + "' AND NVL (b.eff_status, 'D') = 'E' ) where UPPER(a.language_id) = UPPER('" + locale + "') ) z where 1=1";					
					
					break;
				}
				case 2:
				{
					sql = "select z.description description, z.code code from (select 'All Specialities' description, '**' code from dual UNION select a.short_desc description, a.speciality_code code from am_speciality_lang_vw a join IP_NURS_UNIT_FOR_SPECIALTY b on (a.speciality_code = b.SPECIALTY_CODE AND b.NURSING_UNIT_CODE = '" + clinicVal + "' AND b.facility_id = '" + facility_id + "') where UPPER(a.language_id) = UPPER('" + locale + "')) z where 1=1";
					break;
				}
				case 3:
				{
					sql = "select z.description description, z.code code from (SELECT 'All Specialities' description, '**' code FROM DUAL UNION select short_desc description, speciality_code code from am_speciality_lang_vw where language_id = '" + locale + "') z where 1=1";
					break;
				}
			}
			
			System.err.println("sql 818 =================:"+sql);			
		
		} catch(Exception e)
		{
			System.err.println("In Speciality Lookup Exception while fetching the query:"+e);
			e.printStackTrace();
		}
	}
	else if(called_for.equals("PRIVRIGHTS")){
		String locale = request.getParameter("locale");
		
		System.err.println("Inside PRIVRIGHTS");
		String rightsType = request.getParameter("rightsType");
		if(rightsType == null) rightsType = "";
		String facility_id = request.getParameter("facility_id");
		if(facility_id == null) facility_id = "";
		
		try
		{	
			if(rightsType.equals("U")){
				sql = "select z.description description, z.code code from (select 'All Users' description, '**' code from dual UNION select appl_user_name description, bl_user_id code from sm_appl_user, bl_user where bl_user_id = appl_user_id) z where 1=1";				
			}
			else if(rightsType.equals("G")){
				sql="select  z.description description, z.code code from (select 'All Groups' description, '**' code from dual union select long_desc description, user_group_id code from bl_user_group) z where 1=1 ";
			}
			else if(rightsType.equals("R")){
				sql="select z.description description, z.code code from (select 'All Responsibilities' description, '**' code from dual UNION select resp_name description, resp_id code from sm_resp) z where 1=1";
			}
			else{
				sql="select  z.description description, z.code code from (select 'All Users' description, '**' code from dual UNION select appl_user_name description, bl_user_id code from sm_appl_user, bl_user where bl_user_id = appl_user_id) z where 1=1";
			}
		} catch(Exception e)
		{
			System.err.println("In PRIVRIGHTS Lookup Exception while fetching the query:"+e);
			e.printStackTrace();
		}		
	} 
	else if(called_for.equals("DISCCLEAR_HDR_EPISODE_LOOKUP")){		
		
		String facilityID=request.getParameter("facility_id");
		String patientID=request.getParameter("patient_id");
		 	
	 	String sqlIP=" SELECT a.patient_id PATIENT_ID , a.episode_id EPISODE_ID  "+
	 	           " FROM bl_episode_fin_dtls a, pr_encounter c, ip_nursing_unit d "+
				   " WHERE a.operating_facility_id = c.facility_id "+
	 	           " AND a.episode_id = c.episode_id "+
	 	           " AND c.facility_id = d.facility_id "+
	 	           " AND d.nursing_unit_code = c.assign_care_locn_code "+
	 	           " AND c.assign_care_locn_type = 'N' "+
	 	           " AND a.operating_facility_id =  "+"'"+facilityID+"'"+
				   " AND a.patient_id = NVL ('"+patientID+"', a.patient_id) "; 
			System.err.println("Query is: "+sqlIP);	   
			sql = sqlIP; 
			
	}/* V221227 */
	else if(called_for.equals("DISCCLEAR_HDR_NURSINGUNIT_LOOKUP")){

		String facilityID=request.getParameter("facility_id");
		String nursing_unit_desc_val = request.getParameter("nursing_unit_desc_val");
		String nursing_unit_code_value = request.getParameter("nursing_unit_code_val");
		
		String sqlIP=" SELECT G.SHORT_DESC SHORT_DESC,G.WARD_CODE WARD_CODE "+
					" FROM IP_WARD G "+
					" WHERE G.FACILITY_ID = "+"'"+facilityID+"'  "+
					" AND G.WARD_CODE IN (SELECT CUR_WARD_CODE FROM IP_EPISODE "+
					" WHERE FACILITY_ID = '"+facilityID+"' and "+
					" episode_id in (select open_episode_id from ip_open_episode where facility_id = '"+facilityID+"'))  ";    

			System.err.println("sqlip query is: "+sqlIP);				

			sql = sqlIP;
	} /* V221227 */
	else if(called_for.equals("AUTH_REASON_LOOKUP")){

		String reason_code = request.getParameter("reason_code");
		String reason_value = request.getParameter("reason_value");
		int sqlSelect = Integer.parseInt(request.getParameter("sqlSelect"));
		int codeDesc = Integer.parseInt(request.getParameter("codeDesc"));
		String sqlIP = "";
		
		if(sqlSelect==1){
			if(codeDesc == 1)
				sqlIP = "select a.ACTION_REASON_CODE code,a.ACTION_REASON_DESC description from BL_ACTION_REASON a, BL_ACTION_REASON_BY_TYPE b  "+			
						"where a.ACTION_REASON_CODE=b.ACTION_REASON_CODE and ACTION_TYPE = 'DC'  and active_yn = 'Y'";
			else
				sqlIP = "select a.ACTION_REASON_DESC description ,a.ACTION_REASON_CODE code from BL_ACTION_REASON a, BL_ACTION_REASON_BY_TYPE b "+
						"where a.ACTION_REASON_CODE=b.ACTION_REASON_CODE and ACTION_TYPE = 'DC'  and active_yn = 'Y'"; 	
		}else{
			if(codeDesc == 1)
				sqlIP = "select a.ACTION_REASON_CODE code, a.ACTION_REASON_DESC description from BL_ACTION_REASON a, BL_ACTION_REASON_BY_TYPE b " +
                        "where a.ACTION_REASON_CODE=b.ACTION_REASON_CODE and ACTION_TYPE = 'CD' and active_yn ='Y'";
			else
				sqlIP = "select a.ACTION_REASON_DESC description, a.ACTION_REASON_CODE code from BL_ACTION_REASON a, BL_ACTION_REASON_BY_TYPE b " +
                        "where a.ACTION_REASON_CODE=b.ACTION_REASON_CODE and ACTION_TYPE = 'CD' and active_yn ='Y'"; 	 
		}
	
		System.err.println("sqlip query is: "+sqlIP);				
		sql = sqlIP;
	} /* V221227 */
	else if("enc_id_query".equals(called_for)) {
		String user = request.getParameter("user");
		String strclientip = request.getParameter("strclientip");
		String facility_id = request.getParameter("facility_id");
		String locale = request.getParameter("locale");
		String customerCode = request.getParameter("customerCode");
		String val = request.getParameter("val");
		String patient_id = request.getParameter("patient_id");
		String service_code = request.getParameter("service_code");
		String encounter_id = request.getParameter("encounter_id");
		
		sql="SELECT DISTINCT a.episode_id description FROM bl_ins_dash_serv_data_temp a, mp_patient b WHERE a.operating_facility_id = '"+facility_id+"' AND a.patient_id = b.patient_id AND a.processid = '"+user+"' AND a.machine_id = '"+strclientip+"' AND a.cust_code = '"+customerCode+"' AND ins_status = '"+val+"' AND a.blng_serv_name = NVL ('"+service_code+"', a.blng_serv_name) AND a.patient_id = NVL ('"+patient_id+"', a.patient_id) ";
	}
	else if("ENC_ID_LKUP".equals(called_for)){
		String patient_id = request.getParameter("patient_id");
		String episode_type = request.getParameter("episode_type");
		String facility_id = request.getParameter("facility_id");
		
		if("I".equals(episode_type) || "D".equals(episode_type))
			sql = "SELECT ENCOUNTER_ID EPISODE_ID FROM bl_episode_fin_dtls WHERE OPERATING_FACILITY_ID = '"+facility_id+"'";
		else if("O".equals(episode_type) || "E".equals(episode_type))
			sql = "SELECT ENCOUNTER_ID EPISODE_ID FROM bl_visit_fin_dtls WHERE OPERATING_FACILITY_ID = '"+facility_id+"'";
		else
			sql = "SELECT ENCOUNTER_ID EPISODE_ID FROM bl_episode_fin_dtls WHERE OPERATING_FACILITY_ID = '"+facility_id+"'";

		if(!"".equals(patient_id)){
			sql = sql + " AND PATIENT_ID ="+" '"+patient_id+"'";
		}
		
		if(!"".equals(episode_type) && !"A".equals(episode_type)){
			sql = sql + " AND EPISODE_TYPE ="+" '"+episode_type+"'";
		}	
	}
	else if("NURSING_UNIT_LKUP".equals(called_for)){
		
		String facility_id = request.getParameter("facility_id");
		String locale = request.getParameter("locale");
		
		sql = "SELECT LONG_DESC DESCRIPTION, NURSING_UNIT_CODE CODE FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E'";
	}
	else if("SPECIALTY_LKUP".equals(called_for)){
		
		String locale = request.getParameter("locale");
		
		sql = "select short_desc description, speciality_code code from am_speciality_lang_vw where language_id='"+locale+"' AND NVL(EFF_STATUS,'D') = 'E'";
	}
	else if("PAYER_GROUP_LKUP".equals(called_for)){
		String facility_id = request.getParameter("facility_id");
		String locale = request.getParameter("locale");
		
		sql = "select long_desc description, cust_group_code code from ar_cust_group_lang_vw where status is null " +
				" and upper(language_id) = upper('" + locale+"')"+
                " and cust_group_code in (Select Distinct Cust_Group_Code From Bl_Cust_By_Cust_Group Where Cust_Code In (Select Cust_Code From Ar_Customer_Lang_Vw " +
                " where acc_entity_code  in (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '" +
                facility_id +
                "') and upper(language_id) = upper('" +
                locale +
                "') " +
                " and nvl(patient_flag,'N')  ='Y' And Nvl(Insurance_Yn, 'N') = 'Y' )) " +
                " And Acc_Entity_Code In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '" +
                facility_id +
                "')";
	}
	else if("PAYER_LKUP".equals(called_for)){
		String facility_id = request.getParameter("facility_id");
		String locale = request.getParameter("locale");
		String payer_grp_code = request.getParameter("payer_grp_code");
		if("".equals(payer_grp_code))
			payer_grp_code = "**";
		
		sql = "Select long_name description,cust_code code from ar_customer_lang_vw " +
			  " Where Cust_Code In ( SELECT cust_code FROM bl_cust_by_cust_group WHERE cust_group_code = " +
			  " DECODE ('" + payer_grp_code + "', '**', cust_group_code, '" + payer_grp_code + "')) " +
			  " and nvl(patient_flag,'N')  ='Y' " +
			  " and nvl(pat_com_flag,'N')='N' " +
			  " And Nvl(Insurance_Yn, 'N') = 'Y' And Status Is Null " +
			  " and upper(language_id) = upper('" + locale + "')" +		  
			  " and acc_entity_code  In (Select Acc_Entity_Code From Sy_Acc_Entity Where Acc_Entity_Id = '" + facility_id + "') ";
	}
	else if("POLICY_LKUP".equals(called_for)){
		String facility_id = request.getParameter("facility_id");
		String locale = request.getParameter("locale");
		String payer_grp_code = request.getParameter("payer_grp_code");
		String payer_code = request.getParameter("payer_code");
		if("".equals(payer_grp_code))
			payer_grp_code = "**";
		
		sql = "select distinct a.long_desc description, a.policy_type_code code from bl_ins_policy_types_lang_vw a, bl_ins_policy_type_hdr b"+
			  " where language_id = '"+locale+"' AND (b.cust_group_code =  '"+payer_grp_code+"' OR b.cust_group_code = '**')" +
			  " AND UPPER (a.language_id) = UPPER ('"+locale+"') " +
			  " AND (b.cust_code = '"+payer_code+"' OR b.cust_code = '**') "+
			  " AND a.policy_type_code = b.policy_type_code "+
			  " AND a.operating_facility_id = '"+facility_id+"'";
	}
	else if("BLNG_CLASS_LKUP".equals(called_for)){
		sql = "SELECT z.description description, z.code code FROM (SELECT 'All Billing Class' description,'**' code, null status FROM DUAL UNION SELECT short_desc description, Blng_Class_Code code, status FROM BL_BLNG_CLASS_lang_vw z WHERE language_id=?) z WHERE status is null";
	}
	else if("REASON_LKUP".equals(called_for)) {
		String locale = request.getParameter("locale");
		String reason_type = request.getParameter("reason_type");
		sql = "SELECT DISTINCT a.action_reason_desc short_desc,a.action_reason_code action_code FROM bl_action_reason_lang_vw a, bl_action_reason_by_type b WHERE a.action_reason_code = b.action_reason_code AND action_type = '"+reason_type+"' AND active_yn = 'Y' AND language_id='"+locale+"'";
	}else if("PRIV_AUTH_REASON_LKUP".equals(called_for)) {   //V230707
		String locale = request.getParameter("locale");
		String reason_code = request.getParameter("reason_code");
		sql = "SELECT DISTINCT a.action_reason_desc short_desc,a.action_reason_code action_code FROM bl_action_reason_lang_vw a, bl_action_reason_by_type b WHERE a.action_reason_code = b.action_reason_code AND action_type = '"+reason_code+"' AND active_yn = 'Y' AND language_id='"+locale+"'";
	}else if("APPROVAL_DOC_REF_NO_LKUP".equals(called_for)){				//Added by Monika for NMC-JD-CRF-102.3
			String facility_id = request.getParameter("facility_id");
		sql = "select DISTINCT a.appr_doc_ref_number appr_doc_ref_number,a.APPR_DOC_REF_TYPE_CODE appr_doc_ref_type_code from bl_claim_bill_dtl a WHERE OPERATING_FACILITY_ID = '"+facility_id+"'";
		System.out.println("After Sql ")	;
	}else if("CLAIM_ID_LKUP".equals(called_for)){
		//Added by Monika for NMC-JD-CRF-102.3
		String facility_id = request.getParameter("facility_id");
		sql = "select DISTINCT a.claim_id claim_id from bl_claim_bill_dtl a where OPERATING_FACILITY_ID = '"+facility_id+"' and CLAIM_ID IS NOT NULL";
	
	}
	else{
		sql = request.getParameter( "sql");
		//Added below check for ML-MMOH-CRF-0527
		if("BankAndBranch".equals(called_for)){
			//Added against V211014 Starts
			sqlData = request.getParameter( "sqlData");//V230418
			String locale = request.getParameter("locale");
			System.err.println("sqlData "+sqlData);
			String[] arr = sqlData.split("::");
			String key = arr[0].substring(2,13);
			if(key.equals("INTERNALREP")){
				System.out.println("inside 0209");
				MessageManager mm = new MessageManager();
				java.util.Hashtable mesg = mm.getMessage(locale,arr[0],arr[1]);
				sql = (String) mesg.get("message");
				System.out.println("sql BankAndBranch BLLookupHeader.jsp=>"+sql);
			}
		}
		else{
			sql = java.net.URLDecoder.decode(sql,"UTF-8");
		}
		
	}
	
	System.err.println("SQl  "+sql);
	System.err.println("Called For  "+called_for);
/* ************************************************* END OF SQL RETRIVAL LOGIC ****************************************** */

	String strColumnDelimiter = ",";
	String message = request.getParameter("message");
	message = (message == null) ? " ":message;

//	String billing_mode = request.getParameter("billing_mode");
//	String operation = request.getParameter("operation");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( request.getParameter("title")));
            _bw.write(_wl_block7Bytes, _wl_block7);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block10Bytes, _wl_block10);

	Connection conn = null;
	try
	{
		//conn = ConnectionManager.getConnection(request);
		
		System.err.println("Sql in BLLookupHeader.jsp :"+sql);
		PreparedStatement prepareStatement = con.prepareStatement(sql);
		//Added against MMS-DM-SCF-0729
		if(called_for.equals("INSPAYERLKUP")){
			
			String valid_cust_check = "", valid_pol_check = "";

			String locale = request.getParameter("locale");
			if(locale == null) locale = "en";

			String module_id = request.getParameter("module_id");
			if(module_id == null) module_id = "";

			String episode_type = request.getParameter("episode_type");
			if(episode_type == null) episode_type = "";

			String auto_fin_chk = request.getParameter("auto_fin_chk");
			if(auto_fin_chk == null) auto_fin_chk = "";

			String cust_grp_code =request.getParameter("cust_grp_code");
			if(cust_grp_code == null) cust_grp_code = "";

			String class_code = request.getParameter("class_code");
			if(class_code == null) class_code = "";

			String blng_grp_id =request.getParameter("blng_grp_id");
			if(blng_grp_id == null) blng_grp_id = "";

			String search_by_items = request.getParameter("search_by_items");
			if(search_by_items == null) search_by_items = "";

			String search_code = request.getParameter("search_code");
			if(search_code == null) search_code = "";
			
			String facility_id = request.getParameter("facility_id");
			if(facility_id == null) facility_id = "";
			
		//System.err.println("Called auto_fin_chk  "+auto_fin_chk);
			if(auto_fin_chk.equals("Y")){
				prepareStatement.setString(1,locale);
				prepareStatement.setString(2,locale);
				prepareStatement.setString(3,locale);
				prepareStatement.setString(4,cust_grp_code);
				prepareStatement.setString(5,cust_grp_code);
				prepareStatement.setString(6,class_code);
				prepareStatement.setString(7,blng_grp_id);
				prepareStatement.setString(8,module_id);
				prepareStatement.setString(9,module_id);
				prepareStatement.setString(10,search_by_items);
				prepareStatement.setString(11,search_code);
				prepareStatement.setString(12,search_by_items);
				//prepareStatement.setString(13,search_text);
			}else{
				prepareStatement.setString(1,locale);
				prepareStatement.setString(2,locale);
				prepareStatement.setString(3,facility_id);
				prepareStatement.setString(4,module_id);
				prepareStatement.setString(5,locale);
				prepareStatement.setString(6,cust_grp_code);
				prepareStatement.setString(7,module_id);
				prepareStatement.setString(8,search_by_items);
				prepareStatement.setString(9,search_code);
				prepareStatement.setString(10,search_by_items);
				//prepareStatement.setString(11,search_text);
			}
		}
		else if(called_for.equals("BankAndBranch")){
			//V230418
			String[] arr = sqlData.split("::");
			String key = arr[0].substring(2,13);
			System.err.println("BankAndBranch BLLookupHeader.jsp= "+key);
			if(key.equals("INTERNALREP")){
				String locale=arr[2];
				String v_cash_slmt_flag=arr[3];
				String v_slmt_type_code=arr[4];
				String v_cheque_type_enabled=arr[5];
				System.err.println("locale BLLookupHeader=>"+locale);
				System.err.println("v_cash_slmt_flag BLLookupHeader=>"+v_cash_slmt_flag);
				System.err.println("v_slmt_type_code BLLookupHeader=>"+v_slmt_type_code);
				System.err.println("v_cheque_type_enabled BLLookupHeader=>"+v_cheque_type_enabled);
					prepareStatement.setString(1,locale);
					prepareStatement.setString(2,v_cash_slmt_flag);
					prepareStatement.setString(3,v_cash_slmt_flag);
					prepareStatement.setString(4,v_slmt_type_code);
					prepareStatement.setString(5,v_cheque_type_enabled);
					prepareStatement.setString(6,v_cheque_type_enabled);
					prepareStatement.setString(7,v_cash_slmt_flag);
					prepareStatement.setString(8,v_slmt_type_code);
					prepareStatement.setString(9,v_cheque_type_enabled);
					prepareStatement.setString(10,v_cheque_type_enabled);
					prepareStatement.setString(11,v_cash_slmt_flag);
			}//V230824
		}/* else if(called_for.equals("APPROVAL_DOC_REF_NO_LKUP")){								//Added by Monika for NMC-JD-CRF-102.3
			String patient_id = request.getParameter("patient_id");
			String episode_type = request.getParameter("episode_type");
			String facility_id = request.getParameter("facility_id");
			System.out.println("facility_id : "+facility_id);
			
			prepareStatement.setString(1,facility_id);
			
			System.out.println("After setString on PS  ")	;
			
		}else if(called_for.equals("CLAIM_ID_LKUP")){
			String patient_id = request.getParameter("patient_id");
			String episode_type = request.getParameter("episode_type");
			String facility_id = request.getParameter("facility_id");

			prepareStatement.setString(1,facility_id);
		} */
		//testing new logic for security
		//Added against MMS-DM-SCF-0729
		System.out.println("Before execution ")	;
		prepareStatement.execute();
		System.out.println("After execution ")	;
		ResultSetMetaData rmeta = prepareStatement.getMetaData();
		int intCount = rmeta.getColumnCount() ;
		System.err.println("Called intCount  "+intCount);
		String strTempColumnTypeName = "";
		for (int i=1;i<=intCount ;i++ )
		{
			column_names =  column_names + rmeta.getColumnName(i) + strColumnDelimiter;
			//System.err.println("Called column_names  "+column_names);
			strTempColumnTypeName = rmeta.getColumnTypeName(i);
			System.err.println("Called strTempColumnTypeName  "+strTempColumnTypeName);
			if (strTempColumnTypeName.equalsIgnoreCase("VARCHAR2") || strTempColumnTypeName.equalsIgnoreCase("VARCHAR") || strTempColumnTypeName.equalsIgnoreCase("CHAR"))
			{
				strTempColumnTypeName = "VARCHAR2";
			}
			column_types = column_types + strTempColumnTypeName + strColumnDelimiter;
			System.err.println("Called column_types  "+column_types);
		}
			prepareStatement.close();
			// commented in Bangalore on 13/10/2005
			//ConnectionManager.returnConnection(con, request);//27-11-20  //V211020
		try
		{
			System.err.println("Called intCount  "+intCount);
			System.err.println("Called col_show_hide.length()  "+col_show_hide.length());
			if( col_show_hide.length() != intCount && col_show_hide.length() < intCount)
			{
				int diff = intCount - col_show_hide.length();
				for(int i=0;i<diff;i++)
				{
					col_show_hide=col_show_hide+"N";
				}
			}
			System.err.println("Called col_show_hide  "+col_show_hide);
			for(int i=0;i<intCount;i++)
			{
				String temp_str = col_show_hide.substring(i,i+1);
				if(temp_str == null) temp_str="N";
			System.err.println("Called col_show_hide "+i+ " "+col_show_hide);
			System.err.println("Called temp_str "+i+ " "+temp_str);
				col_show_hide_lst.add(i,temp_str);
			}
			System.err.println("Called col_show_hide_lst length "+col_show_hide_lst.size());
		}
		catch(Exception e)
		{
			System.err.println("Exception in AL   :"+e);
			e.printStackTrace();
		}
	}
	catch(Exception ex)
	{
			//commented and added below line in Bangalore on 13/10/2005
			out.println(ex.toString());
			System.err.println(ex.toString());
			ex.printStackTrace();
			//ConnectionManager.returnConnection(conn, request);
	}
	finally {  // Added on Bangalore on 13/10/2005 & //27-11-20
		if (con != null)
		{
			ConnectionManager.returnConnection(con,request);//27-11-20	
		}
	}

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

//		boolean first =  true;
//		boolean second =  true;
		int rec_cnt = 0;
		String strTempSelected = "SELECTED";
		StringTokenizer strColumnTokenizer = new StringTokenizer(column_names,strColumnDelimiter);
		StringTokenizer strColumnDescriptionsTokenizer = new StringTokenizer(column_descriptions,strColumnDelimiter);
		while(strColumnTokenizer.hasMoreElements())
		{
			rec_cnt++;
			if(rec_cnt == srch_by_clmn_index)  
			{
//				if(second)
//				{
				strTempSelected = "SELECTED";
//				first = false;
//				}
//				else
//				{
//					strTempSelected = " ";
//				}
			}
			else
			{
				strTempSelected = " ";
			}
/*
			if (first) 
			{
				strTempSelected = "SELECTED";
				first = false;
			}
			else
			{
				strTempSelected = " ";
			}
*/
			
			if((col_show_hide_lst.get(rec_cnt-1)).equals("Y"))
			{
				out.println("<option value='"+strColumnTokenizer.nextElement()+"_"+(rec_cnt-1)+"'  "+ strTempSelected+"  >"+strColumnDescriptionsTokenizer.nextElement()+"</option>");
			}
			else
			{
				strColumnTokenizer.nextElement();
				strColumnDescriptionsTokenizer.nextElement();
//				out.println("<option value='"+strColumnTokenizer.nextElement()+"'  "+ strTempSelected+"  >"+strColumnDescriptionsTokenizer.nextElement()+"</option>");
			}
		}
		System.err.println("1087,end of bllookup header------------->"+sql);
		
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(message));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(target));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(column_names));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(column_descriptions));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(column_sizes));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(column_types));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(search_by_index));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(target));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(col_show_hide));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(called_for));
            _bw.write(_wl_block29Bytes, _wl_block29);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.searchby.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.searchtext.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.startsWith.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.endsWith.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.contains.label", java.lang.String .class,"key"));
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
}
