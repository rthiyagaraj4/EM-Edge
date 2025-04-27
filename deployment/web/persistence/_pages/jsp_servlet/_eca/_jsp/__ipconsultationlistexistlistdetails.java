package jsp_servlet._eca._jsp;

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
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __ipconsultationlistexistlistdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/IPConsultationListExistListDetails.jsp", 1743758780604L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n-----------------------------------------------------------------------------------------------\nDate       Edit History   Name        Description\n-----------------------------------------------------------------------------------------------\n?             100         ?           created\n18/11/2011    IN29413    Dinesh T     ARTEMIS - Added the new method\n21/08/2011    IN034688\tDinesh T\t\tHandling the billing related issue, while trying to charge consultation for more patients, charges were not posting to the billing tables\n-----------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<title></title>\n\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t\t\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script Language=\"JavaScript\" src=\'../../eCA/js/IPConsultationList.js\'></script>\n\t\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t</head> \n ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<body onload=\"loadButtons()\" onKeyDown=\"lockKey()\">\n\t\t<form name=\'IPConsultationListExistListDetailsForm\' id=\'IPConsultationListExistListDetailsForm\' method=\'post\' target=\'messageFrame\' action=\'../../servlet/eCA.IPConsultationListServlet\'>\n\t\t\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<table  class=\'grid\' WIDTH=\'100%\'>\n\t\t<tr><td CLASS=\'BODYCOLORFILLED\' >&nbsp;</td>\t\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<td class=\'LABEL\'  width=\'8%\'><a href=\"../../eCA/jsp/IPConsultationListExistListDetails.jsp?lower_limit=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&upper_limit=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" style=\"text-decoration:none;  font-weight:bold\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</a></td>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<td class=\'LABEL\' align=\'center\' width=\'8%\'><a href=\"../../eCA/jsp/IPConsultationListExistListDetails.jsp?lower_limit=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" style=\"text-decoration:none; font-weight:bold\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t</tr></table>\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t<table class=\'grid\' width=\"100%\" align=\"center\" name=\"resultTable\" id=\"resultTable\" id=\"resultTable\">\n\t\t<tr>\n\t\t\t<th class=\'columnheadercenter\' align=\'left\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="<input type=\'checkbox\' name=\'existSelAll\' id=\'existSelAll\' id=\'existSelAll\' onclick=\'existSelectAll()\'></th><!--IN29413-->\n\t\t\t<th class=\'columnheadercenter\' align=\'left\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</th>\n\t\t\t<th class=\'columnheadercenter\' width=\'15%\' align=\'left\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</th>\n\t\t\t<th class=\'columnheadercenter\' colspan=\'5\' align=\'left\' >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</th>\n\t\t\t<th class=\'columnheadercenter\' align=\'left\'>&nbsp;</th>\n\t\t</tr>\n\t\t\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\t//alert(\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\");\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar msg=getMessage(\"BILLING_SERVICE_NOT_DEFINED\",\"OR\");\n\t\t\t\t\t\t\tmsg=msg.replace(\'{1}\',\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\");\n\t\t\t\t\t\t\talert(msg);\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t<script>\n\t\t\tdisplayrecord(\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\");\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t<input type=\"hidden\" name=\"explanatory_text";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" id=\"explanatory_text";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t<input type=\'hidden\' name=\'bean_key\' id=\'bean_key\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t<input type=\'hidden\' name=\'create_type\' id=\'create_type\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t\t<input type=\'hidden\' name=\'cons_date\' id=\'cons_date\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t<input type=\'hidden\' name=\'cons_time\' id=\'cons_time\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t\t<input type=\'hidden\' name=\'practitionerId\' id=\'practitionerId\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t\t<input type=\'hidden\' name=\'cons_ref_id\' id=\'cons_ref_id\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t\t<input type=\'hidden\' name=\'consultCnt\' id=\'consultCnt\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"><!--IN29413-->\n\t\t<input type=\'hidden\' name=\'status\' id=\'status\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t<input type=\'hidden\' name=\'servMode\' id=\'servMode\' value=\"cancel\">\n\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t<input type=\'hidden\' name=\'servMode\' id=\'servMode\' value=\"update\">\n\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t<input type=\'hidden\' name=\'totChecked\' id=\'totChecked\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'><!--IN29413-->\n\t\t<input type=\'hidden\' name=\'totDisabled\' id=\'totDisabled\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'><!--IN29413-->\n\t\t</form>\n\t\t<script>\n\t\t//IN29413,starts\n\t\tvar totDisabled=0;\n\t\tfor(i=0;i<document.getElementById(\"consultCnt\").value;i++)  \n\t\t{\n\t\t\tvar clicker = document.getElementById(\'consultChk\'+i);\n\t\t\t\n\t\t\tif(clicker.disabled == true)\n\t\t\t{\n\t\t\t\ttotDisabled=totDisabled+1;\n\t\t\t}\n\t\t}\n\t\tdocument.getElementById(\"totDisabled\").value=totDisabled;\n\t\t//alert(parseInt(document.getElementById(\"consultCnt\").value)+\" \"+parseInt(document.getElementById(\"totChecked\").value));\n\t\tif(parseInt(document.getElementById(\"totDisabled\").value)==parseInt(document.getElementById(\"consultCnt\").value))\n\t\t{\n\t\t\tdocument.getElementById(\"existSelAll\").checked=\'\';\n\t\t\tdocument.getElementById(\"existSelAll\").value=\'N\';\n\t\t}\n\t\telse\n\t\t{\n\t\t\tif(parseInt(document.getElementById(\"consultCnt\").value)==parseInt(document.getElementById(\"totChecked\").value)+parseInt(document.getElementById(\"totDisabled\").value))\n\t\t\t{\n\t\t\t\tdocument.getElementById(\"existSelAll\").checked=\'checked\';\n\t\t\t\tdocument.getElementById(\"existSelAll\").value=\'Y\';\n\t\t\t}\n\t\t}\n\n\t\tif(parent.IPConsultationListToolbarFrame.document.getElementById(\"ChargeCons\")!=null)//IN034688\n\t\t\tparent.IPConsultationListToolbarFrame.document.getElementById(\"ChargeCons\").disabled=false;//IN034688\n\t\t//IN29413,ends\n\t\t</script>\n  </body>\n</html>\n\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );
	
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


	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return ( inputString==null || inputString.equals("") )	?	defaultValue	:	inputString;
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

		  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		  String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p1.getProperty("LOCALE");
		//String bill_facility_id		=	(String) session.getValue("facility_id");

		eCA.IPConsultationListBean ipConsultListBean = null;

		//eOR.OrderEntryBillingQueryBean billingbean = null;
		

		//String queryString = request.getQueryString();


	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	
		Connection con = null;
		con =  ConnectionManager.getConnection(request);
		PreparedStatement stmt=null;
		PreparedStatement pstmt=null;
		//PreparedStatement stHist=null;
		ResultSet rs=null;
		ResultSet prs=null;
		int i=0;
		//int rowCnt = 0;
		String classValue ="";
		String pline ="";
		String rsAdmission_date_time ="";
		String cons_ref_id ="";
		String status ="";
		String catalog ="";
		String checked ="";
		String bean_key ="";
		String practitionerId ="";
		String cons_date ="";
		String cons_time ="";
		String create_type ="";


		String patient_id ="";
		String encounter_id ="";
		String rsSpecialty_code ="";
		String rsSpecialty_desc ="";
		String rsLocation_code ="";
		String arrVal ="";
		String cons_status ="";
		boolean flag = true;
		
		ArrayList BillChargeInfo = null;
		HashMap setBills_dtls			= null;
		HashMap bill_dtls				= null;
		String[] billing_details = null;
		double toatal_amt = 0.0;
		double toatal_pat_payable = 0.0;
		double toatal_pat_paid = 0.0;
		String aproval_reqd ="";
		String className1 ="";
	
		String quantity ="1";
		String orderId ="";
		String order_line_no ="";
		String patient_class ="IP";
		String p_patient_class ="";
		String chk_dis ="";
		String key_line_no ="";
		String  service_panel_code="";
		String  service_panel_ind="";
		String  episode_type="";
		String  visit_id="";
		String  episode_id="";
		String consult_date_time="";
		String consult_date="";
		String error_text="";
		String display="";
		String p_episode_id="";
		String source_type="";
		String source_code="";
		String episode_visit_num="";
		String display_admission_date="";
		String displaytooltip="";
		String order_id="";
		String order_line_num="";
		String billed_yn="";
		String cancelled_by="";
		String cancelled_date="";

		String	lower_limit				=	"";	
		String	upper_limit				=	"";
		String max_regular_cons ="";
		String max_referral_cons ="";
		String tool_tip ="";
		String consParamQuery ="";
		String control_value ="";
		String completed_date ="";

		StringBuffer query_string		=	new StringBuffer();
		ArrayList selectedList =new ArrayList();

		int		rowCnt					=	0,		maxRecordsDisp		=	7;
		int		startIndex				=	0,		endIndex			=	0;
		int		totalRecordCount		=	0;//,		colIndex			=	0;
		//int		sec_count				=	0;
		int totChecked=0;//IN29413
		int totDisabled=0;//IN29413

		//String display_admission_date = com.ehis.util.DateUtils.convertDate(rsAdmission_date_time,"DMYHM","en",locale);

		StringBuffer  existListQry = new StringBuffer();
		
		cons_ref_id			=	(request.getParameter("cons_ref_id")==null)	?	""	:	request.getParameter("cons_ref_id");
		status			=	(request.getParameter("status")==null)	?	""	:	request.getParameter("status");
		catalog			=	(request.getParameter("catalog")==null)	?	""	:	request.getParameter("catalog");
		practitionerId			=	(request.getParameter("practitionerId")==null)	?	""	:	request.getParameter("practitionerId");
		cons_date			=	(request.getParameter("cons_date")==null)	?	""	:	request.getParameter("cons_date");
		cons_time			=	(request.getParameter("cons_time")==null)	?	""	:	request.getParameter("cons_time");
		create_type			=	(request.getParameter("create_type")==null)	?	""	:	request.getParameter("create_type");
		consult_date_time=cons_date+" "+cons_time;

		lower_limit			=	(request.getParameter("lower_limit")==null)	?	"1"					:	request.getParameter("lower_limit");
		upper_limit			=	(request.getParameter("upper_limit")==null)	?	(""+maxRecordsDisp)	:	request.getParameter("upper_limit");
		//if(consult_date_time.length()!=16)
		//{
			try
			{
				consParamQuery = "select MAX_REGULAR_CONS MAX_REGULAR_CONS, MAX_REFERRAL_CONS MAX_REFERRAL_CONS,to_char(sysdate,'dd/mm/yyyy hh24:mi') sys_date from ca_cons_param ";
				
				pstmt = con.prepareStatement(consParamQuery);
				prs = pstmt.executeQuery();
				while(prs.next())
				{
					consult_date=prs.getString("sys_date");
					max_regular_cons = prs.getString("MAX_REGULAR_CONS");
					max_referral_cons = prs.getString("MAX_REFERRAL_CONS");
				}
				if(prs!=null) prs.close();
				if(pstmt!=null)pstmt.close();
			}
			catch(Exception Se)
			{
				System.err.println(Se);
				Se.printStackTrace();
			}
		//}	
		if(!locale.equals("en"))
		{
			consult_date_time=com.ehis.util.DateUtils.convertDate(consult_date_time,"DMYHM",locale,"en");
			consult_date=com.ehis.util.DateUtils.convertDate(consult_date,"DMYHM","en",locale);
		}
		startIndex		=	Integer.parseInt(lower_limit);
		endIndex		=	Integer.parseInt(upper_limit);

		query_string.append("cons_ref_id=");		query_string.append(cons_ref_id);
		query_string.append("&status=");		query_string.append(status);
		query_string.append("&practitionerId=");		query_string.append(practitionerId);
		query_string.append("&cons_date=");		query_string.append(cons_date);
		query_string.append("&cons_time=");		query_string.append(cons_time);
		query_string.append("&create_type=");		query_string.append(create_type);
		query_string.append("&catalog=");		query_string.append(catalog);
		

		bean_key =practitionerId+cons_date+cons_time;

		ipConsultListBean = (eCA.IPConsultationListBean)getObjectFromBean("ipConsultListBeanUpd"+bean_key,"eCA.IPConsultationListBean",session);
		//ipConsultListBean.clearBean();

		selectedList =	ipConsultListBean.returnConsList();



		String bean_id = "Or_FutureOrder" ;
		String bean_name = "eOR.FutureOrder";
		
		eOR.FutureOrder bean = (eOR.FutureOrder)getBeanObject( bean_id, bean_name, request  ) ;
		/*
		eOR.OrderEntryBillingQueryBean billingbean				= (eOR.OrderEntryBillingQueryBean)getBeanObject( "Or_BillingQry", "eOR.OrderEntryBillingQueryBean", request ) ;

		bean.setOrderEntryBillBean(billingbean); */

		 eOR.OrderEntryBillingQueryBean orderEntryBillBean = (eOR.OrderEntryBillingQueryBean) bean.getOrderEntryBillBean(); 
		 
				

            _bw.write(_wl_block8Bytes, _wl_block8);


		//existListQry.append( "select e.PATIENT_ID,e.ENCOUNTER_ID, get_patient.get_line_detail(d.PATIENT_ID,?) Pline,to_char(e.ADMISSION_DATE_TIME,'DD/MM/YYYY HH24:MI') ADMISSION_DATE_TIME,e.SPECIALTY_CODE,am_get_desc.AM_SPECIALITY(e.SPECIALTY_CODE,'en',2) SPECIALTY_DESC,e.NURSING_UNIT_CODE,d.CONS_STATUS,a.patient_class p_patient_class,a.episode_id p_episode_id,a.PAT_CURR_LOCN_TYPE source_type,a.PAT_CURR_LOCN_CODE source_code,a.OP_EPISODE_VISIT_NUM episode_visit_num,d.order_id order_id,d.line_no order_line_num,cancelled_by_user_id  cancelled_by,cancelled_date cancelled_date,CA_GET_CONS_CHRG_CONTROL(?,e.FACILITY_ID,e.ENCOUNTER_ID,?,?) control_val,to_char(COMPLETED_DATE,'DD/MM/YYYY') COMPLETED_DATE   from  CA_CONS_LIST_DTL d,IP_OPEN_ENCOUNTER e,pr_encounter a  where d.CONS_REF_ID = ? and d.PATIENT_ID=e.PATIENT_ID and d.ENCOUNTER_ID =e.ENCOUNTER_ID and d.FACILITY_ID =e.FACILITY_ID and a.facility_id=d.facility_id and a.patient_id=d.patient_id and  a.encounter_id=d.encounter_id");//CHANGES INCLUDED FOR GET ACCESS RULE
		existListQry.append( "select e.PATIENT_ID,e.ENCOUNTER_ID, get_patient.get_line_detail(d.PATIENT_ID,?) Pline,to_char(e.ADMISSION_DATE_TIME,'DD/MM/YYYY HH24:MI') ADMISSION_DATE_TIME,e.SPECIALTY_CODE,am_get_desc.AM_SPECIALITY(e.SPECIALTY_CODE,'en',2) SPECIALTY_DESC,e.NURSING_UNIT_CODE,d.CONS_STATUS,a.patient_class p_patient_class,a.episode_id p_episode_id,a.PAT_CURR_LOCN_TYPE source_type,a.PAT_CURR_LOCN_CODE source_code,a.OP_EPISODE_VISIT_NUM episode_visit_num,d.order_id order_id,d.line_no order_line_num,cancelled_by_user_id  cancelled_by,cancelled_date cancelled_date,CA_GET_CONS_CHRG_CONTROL(?,e.FACILITY_ID,e.ENCOUNTER_ID,?,?) control_val,to_char(COMPLETED_DATE,'DD/MM/YYYY') COMPLETED_DATE   from  CA_CONS_LIST_DTL d,IP_OPEN_ENCOUNTER e,pr_encounter a  where d.CONS_REF_ID = ? and d.PATIENT_ID=e.PATIENT_ID and d.ENCOUNTER_ID =e.ENCOUNTER_ID and d.FACILITY_ID =e.FACILITY_ID and a.facility_id=d.facility_id and a.patient_id=d.patient_id and  a.encounter_id=d.encounter_id AND 'Y' = OR_GET_ACCESS_RULE(e.facility_id,E.encounter_id,'CN',E.patient_class,to_char(E.ADMISSION_DATE_TIME,'DD/MM/YYYY HH24:MI'),     (select to_char(DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI') from pr_encounter where facility_id = E.facility_id and encounter_id = E.encounter_id),(SELECT to_char(DIS_ADV_DATE_TIME,'DD/MM/YYYY HH24:MI') FROM IP_DISCHARGE_ADVICE WHERE FACILITY_ID=E.FACILITY_ID    and ENCOUNTER_ID=E.encounter_id AND DIS_ADV_STATUS in('0','1') and rownum <=1))");//CHANGES INCLUDED FOR GET ACCESS RULE
		if(!status.equals("A"))
		{
		existListQry.append( " and d.CONS_STATUS = ?");
		}
		try
		{
			stmt = con.prepareStatement(existListQry.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			stmt.setString(1,locale);
			stmt.setString(2,practitionerId);
	                stmt.setString(3,max_regular_cons);
			stmt.setString(4,max_referral_cons);
			stmt.setString(5,cons_ref_id);			
                       if(!status.equals("A"))
			{
				stmt.setString(6,status);
			}

			rs = stmt.executeQuery();

			rs.last();
			totalRecordCount	=	rs.getRow();
			rs.beforeFirst();
	if( totalRecordCount>maxRecordsDisp)
		{
	
            _bw.write(_wl_block9Bytes, _wl_block9);

		if(startIndex>maxRecordsDisp)
		{
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((startIndex-maxRecordsDisp)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((endIndex-maxRecordsDisp)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(query_string.toString()));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

		}
		if(totalRecordCount>endIndex)
		{
	
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((startIndex+maxRecordsDisp)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((endIndex+maxRecordsDisp)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(query_string.toString()));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

		}
	
            _bw.write(_wl_block17Bytes, _wl_block17);

		}
	
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

		if(startIndex>1)
			rs.absolute((startIndex-1));	
		classValue = "gridData";
		while(rs.next())
		{
			String displaytooltipi="";
			/*if(i % 2 == 0) classValue = "QRYEVEN";
			else classValue = "QRYODD";	*/

			rowCnt++;
			flag = false ;

						
			patient_id = rs.getString("PATIENT_ID")==null?"":rs.getString("PATIENT_ID");
			encounter_id = rs.getString("ENCOUNTER_ID")==null?"":rs.getString("ENCOUNTER_ID");
			pline = rs.getString("Pline")==null?"":rs.getString("Pline");
			pline =pline.replaceAll("\\|",",");
			rsAdmission_date_time = rs.getString("ADMISSION_DATE_TIME")==null?"":rs.getString("ADMISSION_DATE_TIME");
			rsSpecialty_code = rs.getString("SPECIALTY_CODE")==null?"":rs.getString("SPECIALTY_CODE");
			rsSpecialty_desc = rs.getString("SPECIALTY_DESC")==null?"":rs.getString("SPECIALTY_DESC");
			rsLocation_code = rs.getString("NURSING_UNIT_CODE")==null?"":rs.getString("NURSING_UNIT_CODE");
			cons_status = rs.getString("CONS_STATUS")==null?"":rs.getString("CONS_STATUS");
			p_patient_class = rs.getString("p_patient_class")==null?"":rs.getString("p_patient_class");
			p_episode_id = rs.getString("p_episode_id")==null?"":rs.getString("p_episode_id");
			source_type = rs.getString("source_type")==null?"":rs.getString("source_type");
			source_code = rs.getString("source_code")==null?"":rs.getString("source_code");
			episode_visit_num = rs.getString("episode_visit_num")==null?"0":rs.getString("episode_visit_num");
			order_id = rs.getString("order_id")==null?"":rs.getString("order_id");
			order_line_num = rs.getString("order_line_num")==null?"":rs.getString("order_line_num");
			cancelled_by = rs.getString("cancelled_by")==null?"":rs.getString("cancelled_by");
			cancelled_date = rs.getString("cancelled_date")==null?"":rs.getString("cancelled_date");
			control_value = rs.getString("control_val")==null?"":rs.getString("control_val");
			completed_date = rs.getString("COMPLETED_DATE")==null?"":rs.getString("COMPLETED_DATE");
			if(!locale.equals("en"))
			{
				completed_date = com.ehis.util.DateUtils.convertDate(completed_date,"DMY","en",locale);
			}

			//arrVal = rsLocation_code+"~"+pline+"~"+rsAdmission_date_time+"~"+rsSpecialty_code+"~"+patient_id+"~"+encounter_id;

			arrVal = cons_ref_id+"~"+patient_id+"~"+encounter_id+"~"+consult_date_time+"~"+catalog+"~"+p_patient_class+"~"+p_episode_id+"~"+episode_visit_num+"~"+practitionerId+"~"+source_code+"~"+source_type;



			if(selectedList.contains(arrVal))
			{
				checked ="checked";
				totChecked++;//IN29413
			}
			else
			{
				checked ="";
			}


			/*if(cons_status.equals("P"))
			{
				if(!ipConsultListBean.returnConsList().contains(arrVal))
				{
					ipConsultListBean.addtoConsList(arrVal);
				}
			} */
			if(cons_status.equals("C"))
			{	
				className1="DISCHARGED";
				tool_tip="";
				
				if(status.equalsIgnoreCase("C"))
				{
					//billed_yn=ipConsultListBean.Bill_yn(bill_facility_id,order_id,order_line_num);
					billed_yn="N";
					if(billed_yn.equalsIgnoreCase("Y"))
					{
						chk_dis ="disabled";
						totDisabled++;//IN29413
					}
					else
					{
						if(!(cancelled_by.equals("")&&cancelled_date.equals("")))
						{
							chk_dis="disabled";
							totDisabled++;//IN29413
						}
						else
						{
							//if(cons_date.equals(consult_date.substring(0,10)))
							if(completed_date.equals(consult_date.substring(0,10)))
							{
								chk_dis="";
								
							}
							else
							{
								chk_dis="disabled";totDisabled++;//IN29413
							}
						}
					}
				}
				else
				{
					chk_dis="disabled";
					totDisabled++;//IN29413
				}

			}
			else
			{
				
				if(!control_value.equals(""))
				{
					chk_dis = "disabled";
					totDisabled++;//IN29413
					className1 = classValue;
					tool_tip="";

					if(control_value.equals("REGLR"))
					{
						tool_tip=bean.getMessage(localeName,"MAX_REG_CONS_EXCEED","CA");
						//tool_tip="Maximum No: of regular Consultation is over...";
					}
					if(control_value.equals("REFRL"))
					{
						tool_tip=bean.getMessage(localeName,"MAX_REF_CONS_EXCEED","CA");
						//tool_tip="Maximum No: of Referral Consultation is over...";
					}

				}
				else
				{
				totDisabled++;//IN29413
				className1 =classValue;
				chk_dis ="";
					tool_tip="";
				}
			}
	
	bill_dtls = (HashMap)orderEntryBillBean.getOrderBillDtls(patient_id+encounter_id+catalog);

	if(bill_dtls!=null)//Taken from the bean once the charging is done 
	{
				toatal_amt=Double.parseDouble(checkForNull((String)bill_dtls.get("total_payable"),"0.0"));
				toatal_pat_payable=Double.parseDouble(checkForNull((String)bill_dtls.get("patient_payable"),"0.0"));
				aproval_reqd=checkForNull((String)bill_dtls.get("preapp_yn"),"No");
				if(aproval_reqd.equals(""))
					aproval_reqd="No";
				if(aproval_reqd.equalsIgnoreCase("N"))
				{
					aproval_reqd="No";
				}
				else if(aproval_reqd.equalsIgnoreCase("Y"))
				{
					aproval_reqd="Yes";
				}

				service_panel_code  = checkForNull((String)bill_dtls.get("serv_panel_code"),"");
				service_panel_ind     = checkForNull((String)bill_dtls.get("serv_panel_ind"),"");
				episode_type             =checkForNull((String)bill_dtls.get("p_episode_type"),"");
				visit_id					  =checkForNull((String)bill_dtls.get("p_visit_id"),"");
				episode_id                =checkForNull((String)bill_dtls.get("p_episode_id"),"");
				error_text                  =(String)bill_dtls.get("error_text");
				
				if(!error_text.equals(""))
				{
				
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(error_text));
            _bw.write(_wl_block24Bytes, _wl_block24);

					display="disabled";
					displaytooltipi=error_text;
				}
				else if(service_panel_code.equals("")&&service_panel_ind.equals(""))
				{
					
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(catalog));
            _bw.write(_wl_block26Bytes, _wl_block26);

					display="disabled";
					displaytooltipi=bean.getMessage(localeName,"BILLING_SERVICE_NOT_DEFINED","OR");
					displaytooltipi=displaytooltipi.replace("{1}",catalog);
				}
				else
				{
					display="";
				}
	
	}
	else//Value is from the Database
	 {
	BillChargeInfo = orderEntryBillBean.getBillChargeDetails(quantity,catalog,consult_date_time, locale, order_id, order_line_num,patient_id,encounter_id,patient_class,practitionerId) ;
		//BillChargeInfo = orderEntryBillBean.getBillChargeDetails(quantity,catalog,consult_date_time, locale, orderId, order_line_no,patient_id,encounter_id,patient_class,practitionerId) ; by rajan on 13/10/2008
		//getBillChargeDetails(String quantity,String catalog_code,String start_date_time,String language_id,String order_id,String order_line_no,String patient_id, String encounter_id,String patient_class,String practitioner_id)

		
		if(BillChargeInfo!=null)
		{


			for( int k=0 ; k< BillChargeInfo.size() ; k++ ) 
			{
				billing_details 	= (String[])BillChargeInfo.get(k);

					
				setBills_dtls		= new HashMap();

				setBills_dtls.put("charged_yn"       , billing_details[1]);
				setBills_dtls.put("total_payable"    , billing_details[2]);
				setBills_dtls.put("patient_payable"  , billing_details[3]);
				setBills_dtls.put("quantity"         , "1");
				setBills_dtls.put("incl_excl_action" , billing_details[4]);
				setBills_dtls.put("incl_excl_action_orginal" , billing_details[16]);
				setBills_dtls.put("preapp_yn"        , billing_details[5]);
				setBills_dtls.put("patient_paid_amt" , billing_details[6]);
				setBills_dtls.put("bl_panel_str"     , billing_details[0]);
				setBills_dtls.put("serv_panel_ind"   , billing_details[10]);
				setBills_dtls.put("serv_panel_code"  , billing_details[11]);
				setBills_dtls.put("p_episode_type"	 , billing_details[13]);
				setBills_dtls.put("p_episode_id"	 , billing_details[14]);
				setBills_dtls.put("p_visit_id"		 , billing_details[15]);
				setBills_dtls.put("Future_order_yn"		 , billing_details[17]);
				setBills_dtls.put("error_text"		 , billing_details[9]);
			
				
				orderEntryBillBean.setOrderBillDtls(patient_id+encounter_id+catalog, setBills_dtls); 
				

				bill_dtls = (HashMap)orderEntryBillBean.getOrderBillDtls(patient_id+encounter_id+catalog);
				toatal_amt=Double.parseDouble(checkForNull((String)bill_dtls.get("total_payable"),"0.0"));
				toatal_pat_payable=Double.parseDouble(checkForNull((String)bill_dtls.get("patient_payable"),"0.0"));
				aproval_reqd=checkForNull((String)bill_dtls.get("preapp_yn"),"No");
				if(aproval_reqd.equals(""))
					aproval_reqd="No";
				if(aproval_reqd.equalsIgnoreCase("N"))
				{
					aproval_reqd="No";
				}
				else if(aproval_reqd.equalsIgnoreCase("Y"))
				{
					aproval_reqd="Yes";
				}

				service_panel_code  = checkForNull((String)bill_dtls.get("serv_panel_code"),"");
				service_panel_ind     = checkForNull((String)bill_dtls.get("serv_panel_ind"),"");
				episode_type             =checkForNull((String)bill_dtls.get("p_episode_type"),"");
				visit_id					  =checkForNull((String)bill_dtls.get("p_visit_id"),"");
				episode_id                =checkForNull((String)bill_dtls.get("p_episode_id"),"");
				error_text                  =(String)bill_dtls.get("error_text");
				
				if(!error_text.equals(""))
				{
				
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(error_text));
            _bw.write(_wl_block24Bytes, _wl_block24);

					display="disabled";
				
					displaytooltipi=error_text;
				}
				else if(service_panel_code.equals("")&&service_panel_ind.equals(""))
				{
					
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(catalog));
            _bw.write(_wl_block26Bytes, _wl_block26);

					display="disabled";
					displaytooltipi=bean.getMessage(localeName,"BILLING_SERVICE_NOT_DEFINED","OR");
					displaytooltipi=displaytooltipi.replace("{1}",catalog);
				}
				else
				{
					display="";
				}
			/*


				toatal_amt =toatal_amt+ Double.parseDouble(checkForNull(billing_details[2],"0.0"));
				//toatal_amt += Double.parseDouble(bean.checkForNull(billing_details[2],"0.0"));
				toatal_pat_payable =toatal_pat_payable+ Double.parseDouble(checkForNull(billing_details[3],"0.0"));
				//toatal_pat_payable += Double.parseDouble(bean.checkForNull(billing_details[3],"0.0"));
				toatal_pat_paid =toatal_pat_paid+ Double.parseDouble(checkForNull(billing_details[6],"0.0"));
				//toatal_pat_paid += Double.parseDouble(bean.checkForNull(billing_details[6],"0.0"));

				aproval_reqd = (String)checkForNull(billing_details[5],"No");
				
				service_panel_code = (String)checkForNull(billing_details[11],"");
				service_panel_ind = (String)checkForNull(billing_details[10],"");
				episode_type = (String)checkForNull(billing_details[13],"");
				visit_id = (String)checkForNull(billing_details[15],"");
				episode_id = (String)checkForNull(billing_details[14],"");*/

			}
		}
	}
	





		display_admission_date = com.ehis.util.DateUtils.convertDate(rsAdmission_date_time,"DMYHM","en",locale);
		out.println("<tr id='rowid"+i+"'>");
		if(status.equalsIgnoreCase("C"))
		{
			out.println("<td class='"+classValue+"' rowspan='2' id='chk"+i+"'><input id='consultChk"+i+"' name='consultChk"+i+"' id='consultChk"+i+"' type='checkbox' onClick=\"addToCancelList(this,"+rowCnt+",'"+patient_id+"','"+encounter_id+"','"+consult_date_time+"','"+catalog+"','"+p_patient_class+"','"+p_episode_id+"','"+episode_visit_num+"','"+practitionerId+"','"+source_code+"','"+source_type+"','"+order_id+"','"+order_line_num+"');\""+checked+" "+chk_dis+" "+display+" ></td>");//IN29413
		}
		else
		{
			out.println("<td class='"+classValue+"' rowspan='2' id='chk"+i+"'><input name='consultChk"+i+"' id='consultChk"+i+"' id='consultChk"+i+"' type='checkbox' onClick=\"addToList1(this,"+rowCnt+",'"+patient_id+"','"+encounter_id+"','"+consult_date_time+"','"+catalog+"','"+p_patient_class+"','"+p_episode_id+"','"+episode_visit_num+"','"+practitionerId+"','"+source_code+"','"+source_type+"');\""+checked+" "+chk_dis+" "+display+" title='"+tool_tip+"'></td>");//IN29413
		}
		out.println("<td class='"+classValue+"' rowspan='2' id='pline"+i+"' title='"+displaytooltipi+"' wrap width='30%'>"+pline+"</td>");
		out.println("<td class='"+classValue+"' rowspan='2' id='admdate"+i+"' width='15%'>"+display_admission_date+"</td>");
		out.println("<td class='"+classValue+"' id='space"+i+"'>&nbsp;</td><td class='"+classValue+"' id='totalamt"+i+"' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.total.label","common_labels")+"</td><td class='"+classValue+"' id='patientamt"+i+"' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels")+"</td><td class='"+classValue+"' id='apprreqd"+i+"' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ApprovalReqd.label","or_labels")+"</td><td class='"+classValue+"' id='vespace"+i+"'>&nbsp;</td> ");
		out.println("<td class='"+classValue+"' ></td>");		
		out.println("</tr>");
		out.println("<tr><td class='"+classValue+"' id='charges"+i+"'> <b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Charges.label","ca_labels")+":</b></td><td class='"+classValue+"' id='total_amt_lab"+i+"'>"+toatal_amt+"</td><input type='hidden' name='total_amt_val"+i+"' id='total_amt_val"+i+"' id='total_amt_val"+i+"' value='"+toatal_amt+"'><td class='"+classValue+"' id='toatal_pat_payable_lab"+i+"'> "+toatal_pat_payable+"</td><input type='hidden' name='toatal_pat_payable_val"+i+"' id='toatal_pat_payable_val"+i+"' id='toatal_pat_payable_val"+i+"' value='"+toatal_pat_payable+"'><td class='"+classValue+"' id='aproval_reqd_lab"+i+"' > "+aproval_reqd+"</td><input type='hidden' name='aproval_reqd_val"+i+"' id='aproval_reqd_val"+i+"' id='aproval_reqd_val"+i+"'  value='"+aproval_reqd+"'>");
		if(error_text.equals("")&&(!(service_panel_code.equals("")))&&(!(service_panel_ind.equals("")))&&!(cons_status.equals("C"))&&(chk_dis.equals("")))
		{
			out.println("<td class='"+classValue+"'> <a class='gridLink' href=\"javascript:callReviseBilling('"+i+"','"+patient_id+"','"+encounter_id+"','"+catalog+"','"+service_panel_code+"','"+service_panel_ind+"','"+consult_date_time+"','"+episode_type+"','"+visit_id+"','"+episode_id+"','"+practitionerId+"','"+key_line_no+"','"+orderId+"','"+order_line_no+"')\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.View/Edit.label","or_labels")+"</a> </td><td class='"+className1+"' width='6' align='center' ></td></tr>");
		}
		else
		{
			out.println("<td class='"+classValue+"' id='viewedit"+i+"'></td><td class='"+className1+"' width='6' align='center' ></td></tr>");
		}
		if(!error_text.equals("")||service_panel_code.equals("")||service_panel_ind.equals(""))
		{
		
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);

		}
		
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(displaytooltip));
            _bw.write(_wl_block32Bytes, _wl_block32);

		i++;

		 toatal_amt = 0.0;
		 toatal_pat_payable = 0.0;
		 toatal_pat_paid = 0.0;
		
			if(rowCnt>=maxRecordsDisp) break;
		
		}
		if(rs!=null) rs.close();
		if(stmt!=null)stmt.close();	

		putObjectInBean("ipConsultListBeanUpd"+bean_key,ipConsultListBean,session);
		putObjectInBean(bean_id,bean,request);
				
		
		}

		catch(Exception e)
		{
			e.printStackTrace(System.err);
			
			//ConnectionManager.returnConnection(con,request);
		}
		finally 
		{
		
			ConnectionManager.returnConnection(con,request);
		}
		if(flag)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			out.println("<script> setTimeout('disButtons();','50');</script>");
			
		}




            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bean_key));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(create_type));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(cons_date));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(cons_time));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(practitionerId));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(cons_ref_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(rowCnt));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(status));
            _bw.write(_wl_block32Bytes, _wl_block32);
if(status.equalsIgnoreCase("C")){
            _bw.write(_wl_block41Bytes, _wl_block41);
}else{
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(totChecked));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(totDisabled));
            _bw.write(_wl_block45Bytes, _wl_block45);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiondate.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ChargeApplicable.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
