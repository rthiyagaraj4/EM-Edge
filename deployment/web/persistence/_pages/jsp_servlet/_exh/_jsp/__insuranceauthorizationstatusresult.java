package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.util.HashMap;
import java.sql.*;
import eXH.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import java.lang.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __insuranceauthorizationstatusresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/InsuranceAuthorizationStatusResult.jsp", 1709122344273L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script  language=\"javascript\" src=\"../../eXH/js/InsAuthStatus.js\"></script>\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\t\n\t<script language=\'javascript\' src=\'../../eXH/js/ExternalApplication.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\n</head>\n\n<body class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\t\n   <form name =\"InsuranceAuthorizationStatusResultForm\" action=\"../../servlet/eXH.InsAuthStatusResultServlet\" method=post target=\"messageFrame\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<script>errorCall()</script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<div id=\'table_container_left\' style=\'overflow:auto;width:100%;height:100%;\' style=\"margin:0px auto; padding:0px 5px;\">  \n\t<table  width=\"100%\"  class=\'grid\' id=\'titleTable\'>\n\t\n\t\t  <tr style=\'height:100%;\' style=\'position:relative\' style=\'top:expression(this.offsetParent.scrollTop-2);\'>\n\t\t\t<th width=\"5%\" class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t\t\t<th width=\"8%\" class=\'COLUMNHEADER\' align=\"left\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<th width=\"20%\" class=\'COLUMNHEADER\' align=\"left\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<th width=\"8%\" class=\'COLUMNHEADER\' align=\"left\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<th width=\"10%\" class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n        </tr>\n\t\t\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n\t</table>\n\t</div>\n\t\n<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" name=\"count\" />\n<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" name=\"countrows\" />\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value =\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>  \n<input type=\'hidden\' name=\'facilityId\' id=\'facilityId\' value =\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>  \n<input type=\'hidden\' name=\'login_user\' id=\'login_user\' value =\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>  \n<input type=\'hidden\' name=\'strClientIpAddress\' id=\'strClientIpAddress\' value =\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>  \n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );
	
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
Added by Niveditha For MOHE-CRF-0026.3
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");
String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		String login_user ="", facilityId = "", strClientIpAddress = "";
		Connection con = null;
		Properties p = null;
		HttpSession httpSession = request.getSession(false);
		p = (Properties)httpSession.getValue("jdbc"); 
		facilityId = ""+httpSession.getAttribute("facility_id");
		strClientIpAddress = p.getProperty("client_ip_address") == null ? "" : p.getProperty("client_ip_address");
		
		login_user = p.getProperty("login_user");
		String locale = (String)session.getAttribute("LOCALE");
		locale = (locale == null || locale.equals(""))?"en":locale;
		java.util.Locale loc = new java.util.Locale(locale);
		java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);

		int sNo=0;
		
		String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
		
		String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
		String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
		String fromDate_search = request.getParameter("fromDate_search") == null ? "" : request.getParameter("fromDate_search");
		String toDate_search = request.getParameter("toDate_search") == null ? "" : request.getParameter("toDate_search");
		String episode_type = request.getParameter("episode_type") == null ? "" : request.getParameter("episode_type");
		String disp_location = request.getParameter("disp_location") == null ? "" : request.getParameter("disp_location");
		String auth_status = request.getParameter("auth_status") == null ? "" : request.getParameter("auth_status");

		List<PatientDetails> oSummGroupCompList = null;
		InsuranceAuthStatusBean bean = null;
		PatientDetails sSummGroupBean = null;
		List<PatientDetails> checkauthstatus = null;
		
		
		
		String patidSubGroup="", episodeidSubGroup="", encounteridSubGroup="", dispnoSubGroup="", drugcodeSubGroup="", orderlinenumSubGroup="", orderidSubGroup="", catdescSubGroup="", authstatusSubGroup="",authstatusdescSubGroup="", dispqtySubGroup="", dispuomcodeSubGroup="", patientclassSubGroup="", basepriceSubGroup="",basepriceopSubGroup="", basepriceipSubGroup="", basepricerfSubGroup="", basepriceemSubGroup="", basepricedcSubGroup="", prevSubGroup = "", currentSubGroup = "", emptySubGroup = "", itemcodeSubGroup="", benefitValueSubGroup="", getauthstatuscheck="", benefitCurrencySubGroup="", displocncodeSubGroup="" ,orderdatetimeSubGroup="", claimIdSubGroup="", approvalNoSubGroup="";
		
		int compFlag = 0, compTemplate = 0, compColumns = 0, j = 0, nGroupCompListSize = 0, k = 0, noOfRows1 = 0, ctr=0, cnt = 0, sequenceNumber = 0, colSpan = 6, srlNo = 1;

		boolean subGroupFlag = false;
		
		
		
	try
	{

		con = ConnectionManager.getConnection(request);

		bean = new InsuranceAuthStatusBean();

		oSummGroupCompList = (ArrayList)bean.getInsAuthStatusRecordsDetails(patient_id,encounter_id,fromDate_search,toDate_search,episode_type,disp_location,auth_status,facilityId);		
		
		sSummGroupBean = new PatientDetails();	
		nGroupCompListSize = oSummGroupCompList.size();	

		checkauthstatus = new ArrayList<PatientDetails>();


            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);


if(nGroupCompListSize==0){
		
            _bw.write(_wl_block7Bytes, _wl_block7);
	
}	else{
	
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
		

	for (int i=0;i<nGroupCompListSize;i++){
							
		sSummGroupBean = oSummGroupCompList.get(i);
		patidSubGroup = sSummGroupBean.getPatientId();
		encounteridSubGroup = sSummGroupBean.getEncounterId();
		dispqtySubGroup = sSummGroupBean.getDispQty();
		dispuomcodeSubGroup = sSummGroupBean.getDispUomCode();
		dispnoSubGroup = sSummGroupBean.getDispNo();
		drugcodeSubGroup = sSummGroupBean.getDispDrugCode(); 
		orderidSubGroup = sSummGroupBean.getOrderId();
		patientclassSubGroup = sSummGroupBean.getPatientClass();
		basepriceSubGroup = sSummGroupBean.getNetPrice();
		itemcodeSubGroup = sSummGroupBean.getItemCode();
		getauthstatuscheck = sSummGroupBean.getAuthStatus();
		catdescSubGroup = sSummGroupBean.getShortDesc();
		orderlinenumSubGroup = sSummGroupBean.getSrlNo();
		benefitValueSubGroup = sSummGroupBean.getBenefitValue();
		benefitCurrencySubGroup = sSummGroupBean.getBenefitCurrency();
		displocncodeSubGroup = sSummGroupBean.getDispLocnCode();
		orderdatetimeSubGroup = sSummGroupBean.getOrderDateTime();
		claimIdSubGroup = sSummGroupBean.getClaimId();
		approvalNoSubGroup = sSummGroupBean.getApprovalNo();

		currentSubGroup = dispnoSubGroup;
		
		subGroupFlag = false;
		
			if (!currentSubGroup.equalsIgnoreCase(prevSubGroup)){
				subGroupFlag = true;
				out.println("<tr id = 'trGrpHeader"+j+"'>");
				out.println("<td class='CAGROUP' style='padding-left:10px; padding-right:10px;' > </td>");
				out.println("<td class='CAGROUP'> ");
				out.println("<input type='hidden' name = 'comp_subgroup"+j+"' value = '"+patidSubGroup+"' >");					
				out.println(patidSubGroup+" </td>");
				out.println("<td class='CAGROUP'>"+encounteridSubGroup+"</td>");
				out.println("<td class='CAGROUP'>"+orderidSubGroup+" / "+dispnoSubGroup+"</td>");
				out.println("<td class='CAGROUP'></td>");
				out.println("<td class='CAGROUP'></td>");
				out.println("<td class='CAGROUP'></td>");
				out.println("<td class='CAGROUP'></td>");	
	
				if("P".equals(getauthstatuscheck)){
					out.println("<td class='CAGROUP'><a href='#' onClick='generatebill()' / > Generate Bill </a></td>");
				}else{
					out.println("<td class='CAGROUP'>Generate Bill</td>");
				}
				
				out.println("<td class='gridData' align = 'center' style='display:none'> <input type='hidden' name='seq_num_text"+j+"' id='seq_num_text"+j+"' value = '"+j+"'> </td>");
				
				out.println("</tr>");
				noOfRows1 = 0;
				k = j;
				
				j++;
								
			}
			
			out.println("<td style='display:none'> <input type='hidden' name ='patient_id_value"+j+"' value = '"+patidSubGroup+"' > </td>");
			out.println("<td style='display:none'> <input type='hidden' name ='encounter_id_value"+j+"' value = '"+encounteridSubGroup+"' > </td>");
			out.println("<td style='display:none'> <input type='hidden' name ='disp_no_value"+j+"' value = '"+dispnoSubGroup+"' > </td>");
			out.println("<td style='display:none'> <input type='hidden' name ='drug_code_value"+j+"' value = '"+drugcodeSubGroup+"' > </td>");
			out.println("<td style='display:none'> <input type='hidden' name ='order_line_num_value"+j+"' value = '"+orderlinenumSubGroup+"' > </td>");
			out.println("<td style='display:none'> <input type='hidden' name='order_id_value"+j+"' id='order_id_value"+j+"' value = '"+orderidSubGroup+"' > </td>");
			out.println("<td style='display:none'> <input type='hidden' name='disp_qty_value"+j+"' id='disp_qty_value"+j+"' value = '"+dispqtySubGroup+"' > </td>");
			out.println("<td style='display:none'> <input type='hidden' name='disp_uom_code_value"+j+"' id='disp_uom_code_value"+j+"' value = '"+dispuomcodeSubGroup+"' > </td>");
			out.println("<td style='display:none'> <input type='hidden' name='patient_class_value"+j+"' id='patient_class_value"+j+"' value = '"+patientclassSubGroup+"' > </td>");
			out.println("<td style='display:none'> <input type='hidden' name='claim_id_value"+j+"' id='claim_id_value"+j+"' value = '"+claimIdSubGroup+"' > </td>");
			out.println("<td style='display:none'> <input type='hidden' name='approval_no_value"+j+"' id='approval_no_value"+j+"' value = '"+approvalNoSubGroup+"' > </td>");
			out.println("<tr width='100%' id = 'trGrpHeader'>");
			out.println("<td class='gridDataChart'> <input type='checkbox' id='checkbox' name='secChk"+j+"' id='secChk"+j+"' onclick=\"selectedRecord(this)\"> </td>");
			out.println("<td class='gridDataChart'></td>");
			out.println("<td class='gridDataChart'></td>");
			out.println("<td class='gridDataChart'>"+catdescSubGroup+"</td>");	
			
			if(null != getauthstatuscheck && !"".equals(getauthstatuscheck)){
				if("N".equals(getauthstatuscheck)){
				authstatusdescSubGroup ="Pending";
				out.println("<td class='gridDataChart'>"+authstatusdescSubGroup+"</td>");
				out.println("<td style='display:none'> <input type='hidden' name='auth_status_name_value"+j+"' id='auth_status_name_value"+j+"' value = '"+authstatusdescSubGroup+"' > </td>");
				out.println("<td style='display:none'> <input type='hidden' name='auth_status_value"+j+"' id='auth_status_value"+j+"' value = '"+getauthstatuscheck+"' > </td>");
				}
				else if("P".equals(getauthstatuscheck)){
				authstatusdescSubGroup ="Approved";
				out.println("<td class='gridDataChart'>"+authstatusdescSubGroup+"</td>");
				out.println("<td style='display:none'> <input type='hidden' name='auth_status_name_value"+j+"' id='auth_status_name_value"+j+"' value = '"+authstatusdescSubGroup+"' > </td>");
				out.println("<td style='display:none'> <input type='hidden' name='auth_status_value"+j+"' id='auth_status_value"+j+"' value = '"+getauthstatuscheck+"' > </td>");
				}
				else if("E".equals(getauthstatuscheck)){
				authstatusdescSubGroup ="Rejected";
				out.println("<td class='gridDataChart'>"+authstatusdescSubGroup+"</td>");
				out.println("<td style='display:none'> <input type='hidden' name='auth_status_name_value"+j+"' id='auth_status_name_value"+j+"' value = '"+authstatusdescSubGroup+"' > </td>");
				out.println("<td style='display:none'> <input type='hidden' name='auth_status_value"+j+"' id='auth_status_value"+j+"' value = '"+getauthstatuscheck+"' > </td>");
				}
				else if("R".equals(getauthstatuscheck)){
				authstatusdescSubGroup ="Partially Approved";
				out.println("<td class='gridDataChart'>"+authstatusdescSubGroup+"</td>");
				out.println("<td style='display:none'> <input type='hidden' name='auth_status_name_value"+j+"' id='auth_status_name_value"+j+"' value = '"+authstatusdescSubGroup+"' > </td>");
				out.println("<td style='display:none'> <input type='hidden' name='auth_status_value"+j+"' id='auth_status_value"+j+"' value = '"+getauthstatuscheck+"' > </td>");
				}
				else if("S".equals(getauthstatuscheck)){
				authstatusdescSubGroup ="Submitted";
				out.println("<td class='gridDataChart'>"+authstatusdescSubGroup+"</td>");
				out.println("<td style='display:none'> <input type='hidden' name='auth_status_name_value"+j+"' id='auth_status_name_value"+j+"' value = '"+authstatusdescSubGroup+"' > </td>");
				out.println("<td style='display:none'> <input type='hidden' name='auth_status_value"+j+"' id='auth_status_value"+j+"' value = '"+getauthstatuscheck+"' > </td>");
				}
				else{
				authstatusdescSubGroup ="Pending";
				getauthstatuscheck = "N";
				out.println("<td class='gridDataChart'>"+authstatusdescSubGroup+"</td>");
				out.println("<td style='display:none'> <input type='hidden' name='auth_status_name_value"+j+"' id='auth_status_name_value"+j+"' value = '"+authstatusdescSubGroup+"' > </td>");
				out.println("<td style='display:none'> <input type='hidden' name='auth_status_value"+j+"' id='auth_status_value"+j+"' value = '"+getauthstatuscheck+"' > </td>");
				}
			}else{
				authstatusdescSubGroup ="Pending";
				getauthstatuscheck = "N";
				out.println("<td class='gridDataChart'>"+authstatusdescSubGroup+"</td>");
				out.println("<td style='display:none'> <input type='hidden' name='auth_status_name_value"+j+"' id='auth_status_name_value"+j+"' value = '"+authstatusdescSubGroup+"' > </td>");
				out.println("<td style='display:none'> <input type='hidden' name='auth_status_value"+j+"' id='auth_status_value"+j+"' value = '"+getauthstatuscheck+"' > </td>");
			}
		
			out.println("<td class='gridDataChart'>"+basepriceSubGroup+"</td>");
			out.println("<td style='display:none'> <input type='hidden' name='base_price_value"+j+"' id='base_price_value"+j+"' value = '"+basepriceSubGroup+"' > </td>");
			out.println("<td style='display:none'> <input type='hidden' name='approved_amount_value"+j+"' id='approved_amount_value"+j+"' value = '"+benefitValueSubGroup+"' > </td>");
			
			out.println("<td class='gridDataChart'>"+dispqtySubGroup+"</td>");

			if(null != benefitValueSubGroup && !"".equals(benefitValueSubGroup)){
				out.println("<td class='gridDataChart'>"+benefitValueSubGroup+"</td>");
			}else{
				out.println("<td class='gridDataChart'></td>");
			}
			
			out.println("<td class='gridDataChart'></td>");
			
			out.println("</tr>");

			out.println("<td class='gridData' align = 'center' style='display:none'> <input type='hidden' name='seq_num_text"+j+"' id='seq_num_text"+j+"' value = '"+j+"'> </td>");
			
			out.println("</tr>");																
					
			j++;
			cnt++;
			srlNo++;
	
			prevSubGroup = currentSubGroup;
							
	} 
	
	}
	
	}catch(Exception e){
		out.println("Exception in try of InsuranceAuthorizationStatusResult.jsp"+e.toString());
		e.printStackTrace();
	}
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(srlNo-1));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(j));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strClientIpAddress));
            _bw.write(_wl_block20Bytes, _wl_block20);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.AutoCheckBox.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.OrderidItemDesc.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.AuthorizationStatus.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ItemPrice.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.AllocatedQty.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ApprovedAmt.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.StsValidBillGen.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
