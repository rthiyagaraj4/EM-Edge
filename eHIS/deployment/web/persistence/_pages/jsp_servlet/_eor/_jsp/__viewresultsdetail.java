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
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __viewresultsdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ViewResultsDetail.jsp", 1742365550000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<!--\n-----------------------------------------------------------------------\nDate       \t  Edit History  Name        \tDescription\n-----------------------------------------------------------------------\n?             100         \t?           \tcreated\n12/11/2012\t  EMG\t\t\tChowminya G\t   PACS LIVE\t\n----------------------------------------------------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        \tRev.Date\t\tRev.Name\t\tDescription\n----------------------------------------------------------------------------------------------------------------------------------------------------------\n08/09/2014  IN050936\t\tChowminya\t\t\t\t\t\t\t\t\t\tNone of the order retrieving any image from RIS/PACS but already having order image in PACS\n-------------------------------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n\n<html>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<head>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n\t\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/ViewResults.js\"></script>\n \t<script language=\"JavaScript\" src=\"../../eCA/js/CAOpenExternalApplication.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/OrCommonFunction.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n \t<script>\n\t\tfunction alignWidth()\n\t\t{\n\t\t\tvar last=eval(document.getElementById(\'detailTab\').rows.length)-1;\n\t\t\tif(document.getElementById(\'detailTab\')!=null)\n\t\t\t{\n\t\t\t\tfor(i=0;i <document.getElementById(\'detailTab\').rows(last).cells.length;i++)\n\t\t\t\t{\n\t\t\t\t\tvar wid=document.getElementById(\'detailTab\').rows(last).cells(i).offsetWidth;\n\t\t\t\t\tvar wid1= parent.ViewResultsHeader.document.getElementById(\'titleTab\').rows(0).cells(i).offsetWidth;\n\t\t\t\t\tif(eval(wid1) <eval(wid))\n\t\t\t\t\t\tparent.ViewResultsHeader.document.getElementById(\'titleTab\').rows(0).cells(i).width=wid;\n\t\t\t\t\telse\n\t\t\t\t\t\tdocument.getElementById(\'detailTab\').rows(last).cells(i).width = wid1;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t</script>\n\t \n</head>\n<body   onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">     \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<script>\n\t\t\talert(\'APP-002415 Query caused No records to be retrieved...\');\n\t\t\tparent.ViewResultsSearch.document.view_results_search.search_btn.disabled =false;\n\t\t\tparent.ViewResultsHeader.location.href = \"../../eCommon/html/blank.html\"\n\t\t\tparent.ViewResultsDetail.location.href = \"../../eCommon/html/blank.html\"\n\t\t</script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<form name=\'view_results_dtl\' id=\'view_results_dtl\'  action=\"../../eOR/jsp/ViewResultsDetail.jsp\" method=\"post\">\n<table cellpadding=0 cellspacing=0 border=1 width=\"100%\" id=\'detailTab\' class=\"grid\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<div align=\'right\'>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t</div>\n\n\t\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<input type=hidden name=\'hist_rec_type";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' id=\'hist_rec_type";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t<input type=hidden name=\'contr_sys_id";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' id=\'contr_sys_id";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t\t<input type=hidden name=\'contr_sys_event_code";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' id=\'contr_sys_event_code";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t\t<input type=hidden name=\'accession_num";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' id=\'accession_num";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\t\t<input type=hidden name=\'result_str";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' id=\'result_str";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t\t<input type=hidden name=\'event_code";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' id=\'event_code";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t<input type=hidden name=\'event_class";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' id=\'event_class";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t\t<input type=hidden name=\'event_group";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' id=\'event_group";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t<tr>\n\t\t\t<td width=\'15%\' class=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' title = \"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"><font size=1>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</font></td>\n\t\t\t<td width=\'15%\' class=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</font></td>\n\t\t\t<td width=\'70%\' class=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"><font size=1><table border=0 cellspacing=0 cellpadding=0 width=\'100%\' ><td width=\'100%\' class=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td></table></font></td>\n\t\t\t</tr>\n\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</font></td>\n\t\t\t<td width=\'85%\' class=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\n</table>\n<input type=\"hidden\" name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" >\n<input type=\"hidden\" name=\"to\" id=\"to\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" >\n<input type=\"hidden\" name=\'practitioner_id\' id=\'practitioner_id\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n<input type=\"hidden\" name=\'total_recs\' id=\'total_recs\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n<input type=\"hidden\" name=\"patientId\" id=\"patientId\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n<input type=\"hidden\" name=\"facilityid\" id=\"facilityid\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n<input type=\"hidden\" name=\"encounter_chk\" id=\"encounter_chk\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n<input type=\"hidden\" name=\"priority\" id=\"priority\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n<input type=\"hidden\" name=\"normalcy_ind\" id=\"normalcy_ind\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n<input type=\"hidden\" name=\"groupby\" id=\"groupby\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n<input type=\"hidden\" name=\"modal\" id=\"modal\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n<input type=\"hidden\" name=\"period_from\" id=\"period_from\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n<input type=\"hidden\" name=\"period_to\" id=\"period_to\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n</form>\n<script>\n\tif(parent.ViewResultsHeader.document.getElementById(\'titleTab\')!=null) {\n\t\talignWidth();\n\t}\n\tparent.ViewResultsSearch.document.view_results_search.search_btn.disabled =false;\n\n</script>\n</body>\n</html>\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block4Bytes, _wl_block4);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	String mode							= "1";

	String bean_id						= "Or_ViewResults" ;
	String bean_name					= "eOR.ViewResults";


	String practitioner_id				= (String)session.getValue("ca_practitioner_id");
	String resp_id						= (String)session.getValue("responsibility_id");
    String user_id						= (String)session.getValue("login_user");
	
	if(resp_id== null)resp_id = "";
	if (user_id == null) user_id = "";

	String priority						= CommonBean.checkForNull((String)request.getParameter("priority"));
	String normal_ind					= CommonBean.checkForNull((String)request.getParameter("normalcy_ind"));
	String result_type					= CommonBean.checkForNull((String)request.getParameter("result_type"));
	String patientId					= CommonBean.checkForNull((String)request.getParameter("patientId"));
	String encounter_id					= CommonBean.checkForNull((String)request.getParameter("encounter_id"));
	String encounter_chk				= CommonBean.checkForNull((String)request.getParameter("encounter_chk"));
	String group_by						= CommonBean.checkForNull((String)request.getParameter("groupby"));
	System.out.println(" group_by " + group_by);
	String modal						= CommonBean.checkForNull((String)request.getParameter("modal"));
	String period_from					= CommonBean.checkForNull((String)request.getParameter("period_from"));
	String period_to					= CommonBean.checkForNull((String)request.getParameter("period_to"));
	String facilityid					= CommonBean.checkForNull((String)request.getParameter("facilityid"));
	String from							= CommonBean.checkForNull(request.getParameter( "from" ),"1") ;
	String to							= CommonBean.checkForNull(request.getParameter( "to" ),"7") ;
	String selectmode=CommonBean.checkForNull((String)request.getParameter("selectmode"));
 	int start							= Integer.parseInt(from);
	int end								= Integer.parseInt(to);

	ArrayList allValues					= new ArrayList();

	String total_query_records			= "0";
	int total_records					= 0;

	ViewResults bean					= (ViewResults)getBeanObject( bean_id, bean_name, request) ;

	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	bean.clear() ;
	bean.setMode( mode ) ;

	if (practitioner_id == null)
	{
	   String [] practitionerDetails = (String[])bean.getPractitionerDetails(user_id);
	   practitioner_id = practitionerDetails[0];
	}

	if(practitioner_id == null)practitioner_id = "";
	
	allValues		= bean.getDetails(practitioner_id,priority,normal_ind,result_type,resp_id,patientId,encounter_id,encounter_chk,group_by,modal,period_from,period_to,start,end,facilityid);

	String result_data[]				= (String[])bean.getAbnormalCondition();

	String high_str						= result_data[0];
	String low_str						= result_data[1];
	String abn_str						= result_data[2];
	String crit_str						= result_data[3];
	String crit_high_str				= result_data[4];
	String crit_low_str					= result_data[5];
	String tooltip						= "";
	String result						= "";

	if(allValues.size() == 0)
	{

            _bw.write(_wl_block7Bytes, _wl_block7);
	
	}

            _bw.write(_wl_block8Bytes, _wl_block8);


	String 	event_short_desc			= "";
	String  event_code					= "";
	String 	contr_sys_event_code		= "";
	String 	accession_num				= "";
	String 	hist_rec_type				= "";
	String 	hist_rec_type_desc				= "";
	String 	text_exisits				= "";
	String 	contr_sys_id				= "";
	String 	hist_data_type				= "";
	String 	reporting_date				= "";
	String 	resulting_date				= "";
	String 	result_num					= "";
	String 	result_num_uom				= "";
	String 	result_str					= "";
	String 	normal_low					= "";
	String 	normal_high					= "";
	String 	critical_low				= "";
	String 	critical_high				= "";
	String 	normalcy_ind				= "";
	String 	ext_image_obj_id			= "";
	String 	ext_image_appl_id			= "";
	String  reporting_practitioner		= "";
    String  parent_short_desc           = "";
	String  child_desc					= "";
	//String  temp_parent_short_desc		= "";
	//String  temp_hist_rec_type		= "";
	//String  temp_reporting_practitioner		= "";
	//String  temp_resulting_date		= "";
	String  event_group					= "";
	String  event_class					= "";
	String  slClassValue				= "";
	String[] record						= null;

	

	for(int i=0; i<allValues.size(); i++)
	{
		StringBuffer  disp_value			= new StringBuffer();
		record							= (String[])allValues.get(i);

		result							= CommonBean.checkForNull(record[0]);
		event_short_desc				= CommonBean.checkForNull(record[1]);
		event_code						= CommonBean.checkForNull(record[2]);
		result_num						= CommonBean.checkForNull(record[3]);
		result_num_uom					= CommonBean.checkForNull(record[4]);
		result_str						= CommonBean.checkForNull(record[5]);
		reporting_date					= CommonBean.checkForNull(record[6]);
		resulting_date					= CommonBean.checkForNull(record[7]);
		normalcy_ind					= CommonBean.checkForNull(record[8]);
		normal_low						= CommonBean.checkForNull(record[9]);
		normal_high						= CommonBean.checkForNull(record[10]);
		critical_low					= CommonBean.checkForNull(record[11]);
		critical_high					= CommonBean.checkForNull(record[12]);
		parent_short_desc				= CommonBean.checkForNull(record[13]);
		child_desc						= CommonBean.checkForNull(record[14]);
		hist_data_type					= CommonBean.checkForNull(record[15]);
		ext_image_obj_id				= CommonBean.checkForNull(record[17]);
		ext_image_appl_id				= CommonBean.checkForNull(record[18]);
		reporting_practitioner			= CommonBean.checkForNull(record[19]);
		hist_rec_type					= CommonBean.checkForNull(record[20]);
		accession_num					= CommonBean.checkForNull(record[21]);
		contr_sys_event_code			= CommonBean.checkForNull(record[22]);
		contr_sys_id					= CommonBean.checkForNull(record[23]);
		event_class						= CommonBean.checkForNull(record[24]);
		event_group						= CommonBean.checkForNull(record[25]);
		hist_rec_type_desc				= CommonBean.checkForNull(record[27]);
		text_exisits				= CommonBean.checkForNull(record[28]);
		if(normalcy_ind != null && (normalcy_ind.equalsIgnoreCase(high_str) || normalcy_ind.equalsIgnoreCase(low_str) || normalcy_ind.equalsIgnoreCase(abn_str) ))
			normalcy_ind = "<FONT COLOR='RED' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels")+"<br></FONT>";
		else if(normalcy_ind != null && (normalcy_ind.equalsIgnoreCase(crit_str) || normalcy_ind.equalsIgnoreCase(crit_high_str) || normalcy_ind.equalsIgnoreCase(crit_low_str) ))
			normalcy_ind = "<FONT COLOR='MAGENTA'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CriticalAbnormal.label","or_labels")+"<br></FONT>";
		else if(normalcy_ind!=null && !normalcy_ind.equals(""))
			normalcy_ind = "<FONT COLOR='RED' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels")+"<br></FONT>"; 
		else
			normalcy_ind = "&nbsp;<FONT COLOR='RED' ></FONT>";  


		tooltip = "";
		/*if(i % 2 == 0){
			slClassValue = "QRYEVEN";
		}else{
			slClassValue = "QRYODD";
		}*/
		slClassValue="gridData";
	
		if(i==0)
		{
			if(record[26] != null)
				total_query_records = bean.checkForNull((String)record[26],"0");

			total_records = Integer.parseInt(total_query_records);
 
            _bw.write(_wl_block9Bytes, _wl_block9);

				if ( !(start <= 1) )  
		  			out.println("<A class='gridLink' align='right' HREF='../../eOR/jsp/ViewResultsDetail.jsp?from="+(start-7)+"&to="+(end-7)+"&normalcy_ind="+normal_ind+"&result_type="+result_type+"&patientId="+patientId+"&encounter_id="+encounter_id+"&encounter_chk="+encounter_chk+"&groupby="+group_by+"&modal="+modal+"&period_from="+period_from+"&period_to="+period_to+"&facilityid="+facilityid+"' text-decoration='none'>Previous</A>");
 				if( !( (start+7) > total_records)) 
 					out.println("<A class='gridLink' align='right' HREF='../../eOR/jsp/ViewResultsDetail.jsp?from="+(start+7)+"&to="+(end+7)+"&normalcy_ind="+normal_ind+"&result_type="+result_type+"&patientId="+patientId+"&encounter_id="+encounter_id+"&encounter_chk="+encounter_chk+"&groupby="+group_by+"&modal="+modal+"&period_from="+period_from+"&period_to="+period_to+"&facilityid="+facilityid+"' text-decoration='none'>Next</A>");

				out.println("&nbsp;&nbsp;");

            _bw.write(_wl_block10Bytes, _wl_block10);
				
		}
		
		if(hist_data_type.equals("NUM"))
				{
					disp_value.append("<tr><td width='100%'>"+child_desc+":"+result_num+"nbsp;"+result_num_uom+"("+normal_low+"~"+normal_high+")</td>");
					disp_value.append("</tr>");

					if(!result_str.equals(""))
					{
						disp_value.append("<tr><td><br>Comments:"+result_str+"</td></tr>");
					}
					if(text_exisits.equals("Y"))
					{
						disp_value.append("<tr><td><br>Result Text:"+bean.returnClobValue(hist_rec_type,contr_sys_id,accession_num,contr_sys_event_code)+"</td></tr>");		
					}

		}
		else if(hist_data_type.trim().equals("STR"))
		{
			disp_value.append("<tr><td width='100%'>"+child_desc+":"+result_num+"nbsp;"+result_num_uom+"("+normal_low+"~"+normal_high+")</td>");
					disp_value.append("</tr>");

					if(!result_str.equals(""))
					{
						disp_value.append("<tr><td><br>Comments:"+result_str+"</td></tr>");
					}
					if(text_exisits.equals("Y"))
					{
						disp_value.append("<tr><td><br>Result Text:"+bean.returnClobValue(hist_rec_type,contr_sys_id,accession_num,contr_sys_event_code)+"</td></tr>");						
						
					}
		}
		else if(hist_data_type.trim().equals("TXT"))
		{
					disp_value.append("<tr><td width='100%'>"+child_desc+":"+result_num+"nbsp;"+result_num_uom+"("+normal_low+"~"+normal_high+")</td>");
					disp_value.append("</tr>");

					if(!result_str.equals(""))
					{
						disp_value.append("<tr><td><br>Comments:"+result_str+"</td></tr>");
					}
					if(text_exisits.equals("Y"))
					{
						disp_value.append(bean.returnClobValue(hist_rec_type,contr_sys_id,accession_num,contr_sys_event_code)+"</td></tr>");			
						//out.println("</td><td width='20%'>&nbsp;</td></tr>");						
						
					}

				}
		else if(hist_data_type.trim().equals("HTM"))
		{
			if(result_str!=null && !result_str.equals(""))
			{
				disp_value.append("<tr><td><br>Comments:"+result_str+"</td></tr>");
			}
			disp_value.append(" "+normalcy_ind);
			if(result!=null && !result.equals(""))
			{
				disp_value.append("<a class='gridLink'  href=\"javascript:viewClobDataHtm('"+accession_num+"','"+hist_data_type+"')\"> ");
				disp_value.append("<IMG SRC='../images/flow_text.gif' WIDTH='16' HEIGHT='16' BORDER=0></a>");
			}
		}
		else
		{
			disp_value.append("&nbsp;");
		}

		//Added docul condition for EMG
		if ( (ext_image_appl_id != null && (!ext_image_appl_id.equals("")))) 
		{
			if(!("DOCUL").equals(ext_image_appl_id)) 
			{
				//IN050936 included patient_id	
				disp_value.append("<br><a class='gridLink'  href=\"javascript:getFile('"+hist_rec_type+"','"+contr_sys_id+"','"+ext_image_obj_id+"','"+contr_sys_event_code+"','"+ext_image_appl_id+"','"+patientId+"')\"> ");
				disp_value.append("<img src='../../eCA/images/"+ext_image_appl_id+".gif' width='16' height='16' border=0 alt='Result'></a>");
			}
			else
			{
				//IN050936 included patient_id	
				disp_value.append("<br><a class='gridLink'  href=\"javascript:getFile('"+hist_rec_type+"','"+contr_sys_id+"','"+accession_num+"','"+contr_sys_event_code+"','"+ext_image_appl_id+"','"+patientId+"')\"> ");
				disp_value.append("<img src='../../eCA/images/"+ext_image_appl_id+".gif' width='16' height='16' border=0 alt='Result'></a>");
			}
								
		}

		disp_value.append("<a class='gridLink' href=\"javascript:viewFlowSheet('"+i+"')\"> <img src='../../eOR/images/prev_results.gif' title='Previous Results' border='0'></img>&nbsp;</a>");

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(i));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(hist_rec_type));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(contr_sys_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(contr_sys_event_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(result_str));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(event_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(event_class));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(event_group));
            _bw.write(_wl_block28Bytes, _wl_block28);
 
	if(selectmode.equals("")){
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(reporting_date));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(hist_rec_type_desc));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(disp_value.toString()));
            _bw.write(_wl_block36Bytes, _wl_block36);
}else{
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(reporting_date));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(tooltip));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(disp_value.toString()));
            _bw.write(_wl_block36Bytes, _wl_block36);
}

	}

            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(from));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(to));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(allValues.size()));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block45Bytes, _wl_block45);
//=bean.getFunctionId()
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(encounter_chk));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf((String)request.getParameter("priority")));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf((String)request.getParameter("normalcy_ind")));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf((String)request.getParameter("groupby")));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf((String)request.getParameter("modal")));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf((String)request.getParameter("period_from")));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf((String)request.getParameter("period_to")));
            _bw.write(_wl_block56Bytes, _wl_block56);

	putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block57Bytes, _wl_block57);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
