package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.RecordSet;

public final class __iponlinereportresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/IPOnlineReportResult.jsp", 1742387724477L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tDeveloped by \t:\tBangarraju\t\n\tCreated on\t\t:\t11/03/2009\n\tModule\t\t\t:\tIP\n\tFunction\t\t:\tIP Online Report\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="  \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t\t\n\t\t<script language=\'javascript\' src=\'../../eIP/js/IPOnlineReport.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body  onLoad=\'dispRecord(); \' onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n\t<form name=\'IPOnlineReportForm\' id=\'IPOnlineReportForm\' action=\'../../servlet/eIP.IPOnlineReportServlet\' method=\'post\' target=\'messageFrame\'>\n\n\t\n\t\n\t<table cellpadding=\'0\' cellspacing=\'0\' border=\'1\' width=\'90%\' align=\'center\' >\n\t<tr>\n\t<th width=\'\' >";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</th>\n\t<th width=\'\' colspan=\'7\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t<th width=\'\' >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&nbsp;</th>\n\t</tr>\n\t<tr>\n\t<th width=\'\' >&nbsp;</th>\t\n\t<th width=\'\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&nbsp;</th>\n\t<th width=\'\' >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&nbsp;</th>\n\t<th width=\'\' >&nbsp;</th>\t\t\t\n\t</tr>\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<tr id=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' nowrap>\n\n\t\t<td class=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' align=\'left\' nowrap>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\n\t\t<input type=\"hidden\" name=\"reportCode";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" id=\"reportCode";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\n\t\t<td class=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' align=\'center\' nowrap><input type=\'checkbox\' name=\'select_booking_yn";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' id=\'select_booking_yn";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" value=\'\' onClick=\'SelectCBValue(this,\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\");\'></td>\n\n\t\t<td class=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' align=\'center\' nowrap><input type=\'checkbox\' name=\'select_admissionWithBed_yn";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' id=\'select_admissionWithBed_yn";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' align=\'center\' nowrap><input type=\'checkbox\' name=\'select_admissionWithoutBed_yn";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' id=\'select_admissionWithoutBed_yn";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' align=\'center\' nowrap><input type=\'checkbox\' name=\'select_transferrequest_yn";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' id=\'select_transferrequest_yn";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' align=\'center\' nowrap><input type=\'checkbox\' name=\'select_transferConfirmation_yn";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' id=\'select_transferConfirmation_yn";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\");\'></td>\n\n\t\n\t    <td class=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' align=\'center\' nowrap><input type=\'checkbox\' name=\'print_on_discharge_yn";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' id=\'print_on_discharge_yn";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" value=\'\'  onClick=\'SelectCBValue(this,\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' align=\'center\' nowrap><input type=\'checkbox\' name=\'select_discharge_yn";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' id=\'select_discharge_yn";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\");\'></td>\n\n\t \t<td class=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' align=\'center\' nowrap><input type=\'checkbox\' name=\'select_yn";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' id=\'select_yn";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\");SelectEnableDisable(this,\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\",\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\")\'></td>\n\n\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t</table>\n\t<input type=\'hidden\' name=\'row_count\' id=\'row_count\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\n\t<input type=\'hidden\' name=\'SelectYNStr\' id=\'SelectYNStr\' value=\"\">\n\t<input type=\'hidden\' name=\'operation\' id=\'operation\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t<input type=\'hidden\' name=\'function_code\' id=\'function_code\' value=\'\'>\n\t<input type=\'hidden\' name=\'Function\' id=\'Function\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t<input type=\'hidden\' name=\'nursing_unit_code\' id=\'nursing_unit_code\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t<input type=\'hidden\' name=\'SelectYNStrBkg\' id=\'SelectYNStrBkg\' value=\"\">\n\t<input type=\'hidden\' name=\'SelectYNStrConf\' id=\'SelectYNStrConf\' value=\"\">\n\t<input type=\'hidden\' name=\'SelectYNStrBed\' id=\'SelectYNStrBed\' value=\"\">\n\t<input type=\'hidden\' name=\'SelectYNStrWoBed\' id=\'SelectYNStrWoBed\' value=\"\">\n\t<input type=\'hidden\' name=\'SelectYNStrTransReqest\' id=\'SelectYNStrTransReqest\' value=\"\">\n    <input type=\'hidden\' name=\'SelectYNStrPrint_on_discharge\' id=\'SelectYNStrPrint_on_discharge\' value=\"\"> \n\t<input type=\'hidden\' name=\'SelectYNStrDischarge\' id=\'SelectYNStrDischarge\' value=\"\">\n\t<input type=\'hidden\' name=\'SelectYNStrCode\' id=\'SelectYNStrCode\' value=\"\">\n\t<input type=hidden name=isRecordSelected_YN id=isRecordSelected_YN value=\"N\">\n\t\n\t</form>\n\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n</body>\n</html>\n\t\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );
int row_count=0;

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet IPOnlineReportRecordSet= null;synchronized(session){
                IPOnlineReportRecordSet=(webbeans.eCommon.RecordSet)pageContext.getAttribute("IPOnlineReportRecordSet",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(IPOnlineReportRecordSet==null){
                    IPOnlineReportRecordSet=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("IPOnlineReportRecordSet",IPOnlineReportRecordSet,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);



	request.setCharacterEncoding("UTF-8");
	Connection con	=	null;
	Statement stmt	=	null;
	ResultSet rs	=	null;

	String chk1	= "", chk2 = "", chk3 = "", chk4 = "", chk5 = "", chk6 = "",chk7 = "",selectChk="";
	String disabledDischarge="",disabledOthers="",disabledBkg="",
           disabledDischargeAdvise="",disabledTrsfRequest="",disabledadm="",disabledassign="";
	

	Hashtable		htRecord	=	null;
 
	try
	{
		con		=	ConnectionManager.getConnection(request);
		stmt	=	con.createStatement();

		
		
		String code="",  valid="", function_code="",  classValue="", tblrow_id="", operation="",module_id="";
		String Function="";
		String desc="";
		StringBuffer result_query = new StringBuffer();

		String facility_id  =	(String)session.getValue("facility_id");
		
		String mode			=	request.getParameter("mode") ;
		if(mode == null || mode.equals("null")) mode="";

		function_code=request.getParameter("function_code");
			if(function_code==null)function_code="";

		operation = request.getParameter("operation");
			if(operation==null)operation="";

		Function = request.getParameter("Function");
			if(Function==null)Function="";
		
		if(Function.equals("pract"))
		{}
		else if(Function.equals("nurs")){}

		if(operation.equals("insert")) {}
		else if(operation.equals("modify"))
		{
			IPOnlineReportRecordSet.clearAll();
		}
		
		String online_mr_notfn_yn	= "";

		String mr_notfn_yn = "select online_mr_notfn_yn from ip_nursing_unit where facility_id = '"+facility_id+"' and nursing_unit_code ='"+function_code+"' and eff_status = 'E'"; 

		rs=stmt.executeQuery(mr_notfn_yn);
			if(rs != null && rs.next())
			{
				online_mr_notfn_yn = rs.getString("online_mr_notfn_yn");
			}
			if(rs!=null)	rs.close();
			
		String pat_check_in_yn	= "";

		String ip_param = "select pat_check_in_allowed_yn from ip_param where facility_id = '"+facility_id+"' "; 

		rs=stmt.executeQuery(ip_param);
			if(rs != null && rs.next())
			{
				pat_check_in_yn = rs.getString("pat_check_in_allowed_yn");
			}
			if(rs!=null)	rs.close();


		if(mode.equals(""))
		{
			if(!(function_code.equals(""))) IPOnlineReportRecordSet.clearAll();
			
			if(operation.equals("insert"))
			{
		
				//result_query.append("select A.REPORT_ID,REPORT_DESC,PRINT_ON_BOOKING_YN, PRINT_ON_ADMISSION_YN, PRINT_ON_TRANSFER_REQUEST_YN, PRINT_ON_CONFORM_TRANSFER_YN, PRINT_ON_BED_ASSIGNED_YN, PRINT_ON_DISCHARGE_YN,PRINT_ON_DISCH_ADV_YN,'Y' as \"Update\"  FROM IP_ONLINE_REPORT A, SM_REPORT B WHERE A.MODULE_ID = 'IP' AND A.FACILITY_ID='"+facility_id+"' AND A.NURSING_UNIT_CODE='"+function_code+"' AND A.REPORT_ID=B.REPORT_ID  AND B.REPORT_ID != 'IPBLVPAS' UNION  select REPORT_ID,REPORT_DESC,'N','N','N','N','N','N','N','N' FROM SM_REPORT WHERE MODULE_ID='IP' "+ "AND REPORT_ID NOT IN ( 'IPBLVPAS', 'IPBGTPAS', 'IPBABNOT') AND INTERNAL_REQUEST_YN = 'Y' AND REPORT_ID NOT IN (SELECT REPORT_ID FROM IP_ONLINE_REPORT WHERE FACILITY_ID = '"+facility_id+"' AND NURSING_UNIT_CODE = '"+function_code+"')ORDER BY 2");
				
				result_query.append("select A.REPORT_ID,REPORT_DESC,a.module_id,PRINT_ON_BOOKING_YN, PRINT_ON_ADMISSION_YN, PRINT_ON_TRANSFER_REQUEST_YN, PRINT_ON_CONFORM_TRANSFER_YN, PRINT_ON_BED_ASSIGNED_YN, PRINT_ON_DISCHARGE_YN,PRINT_ON_DISCH_ADV_YN,'Y' as \"Update\"  FROM IP_ONLINE_REPORT A, SM_REPORT B WHERE A.MODULE_ID = 'IP' AND A.FACILITY_ID='"+facility_id+"' AND A.NURSING_UNIT_CODE='"+function_code+"' AND A.REPORT_ID=B.REPORT_ID  AND B.REPORT_ID != 'IPBLVPAS'");
				if(online_mr_notfn_yn.equals("Y"))
				{
					result_query.append(" UNION SELECT   a.report_id, report_desc,a.module_id, print_on_booking_yn,  print_on_admission_yn, print_on_transfer_request_yn, print_on_conform_transfer_yn,  print_on_bed_assigned_yn, print_on_discharge_yn, print_on_disch_adv_yn, 'Y' AS \"Update\" FROM ip_online_report a, sm_report b  WHERE a.module_id = 'FM' AND a.facility_id = '"+facility_id+"' AND a.nursing_unit_code = '"+function_code+"' AND a.report_id = b.report_id AND b.report_id = 'FMFLRQSL'");
				}
				result_query.append(" UNION  select REPORT_ID,REPORT_DESC,module_id,'N','N','N','N','N','N','N','N' FROM SM_REPORT WHERE MODULE_ID='IP' "+ "AND REPORT_ID NOT IN ( 'IPBLVPAS', 'IPBGTPAS', 'IPBABNOT','IPBWBLBW','IPBWBLBB','IPBWBLBR') AND INTERNAL_REQUEST_YN = 'Y' AND REPORT_ID NOT IN (SELECT REPORT_ID FROM IP_ONLINE_REPORT WHERE FACILITY_ID = '"+facility_id+"' AND NURSING_UNIT_CODE = '"+function_code+"')");
				if(online_mr_notfn_yn.equals("Y"))
				{
					result_query.append(" UNION SELECT   report_id, report_desc,module_id, 'N', 'N', 'N', 'N', 'N', 'N', 'N', 'N'  FROM sm_report WHERE module_id = 'FM' AND report_id = 'FMFLRQSL' AND internal_request_yn = 'Y' AND REPORT_ID NOT IN (SELECT REPORT_ID FROM IP_ONLINE_REPORT WHERE FACILITY_ID = '"+facility_id+"' AND NURSING_UNIT_CODE = '"+function_code+"') ");
				}

				result_query.append(" ORDER BY 2");
				
			
			}

			
			rs=stmt.executeQuery(result_query.toString());
			if(rs != null)
			{
				while(rs.next())
				{
					code		=	rs.getString("REPORT_ID");
					desc		=	rs.getString("REPORT_DESC");
					valid		=	rs.getString("Update");
					module_id	=	rs.getString("module_id");
				if(rs.getString("print_on_booking_yn").equals("Y"))
					chk1="CHECKED";
				else
					chk1="";

				if(rs.getString("print_on_admission_yn").equals("Y"))
					chk4="CHECKED";
				else
					chk4="";


				if(rs.getString("print_on_transfer_request_yn").equals("Y"))
					chk3="CHECKED";
				else
					chk3="";
			
				if(rs.getString("print_on_conform_transfer_yn").equals("Y"))
					chk2="CHECKED";
				else
					chk2="";

				if(rs.getString("print_on_bed_assigned_yn").equals("Y")) 
					chk5="CHECKED";
				else
					chk5="";

				if(rs.getString("print_on_discharge_yn").equals("Y")){
					chk6="CHECKED";
				}
				else
					chk6="";

				if(rs.getString("print_on_disch_adv_yn").equals("Y")){
					chk7="CHECKED";
				}
				else
					chk7="";
						

					if(code == null || code.equals("null"))code="";
					if(desc == null || desc.equals("null"))desc="";
					if(valid == null || valid.equals("null"))valid="";

					htRecord			=	new Hashtable();
					/**
					Valid  associate_yn -->Operation
					================================
					 Y			Y		-->Delete
					 Y			N		-->Update
					 N			Y		-->Insert
					 N			N		-->NOP*/

					htRecord.put("code"	,	code);
					htRecord.put("desc"	,	desc);
					htRecord.put("module_id"	,	module_id);
					htRecord.put("valid",	valid);		//Flag1
					htRecord.put("associate_yn" , "N"); //Flag2
					htRecord.put("booking_yn" , chk1); 
					htRecord.put("transferConfirmation_yn" , chk2); 
					htRecord.put("print_on_transfer_request_yn" ,chk3); 
					htRecord.put("admissionWithBed_yn" , chk4); 
					htRecord.put("admissionWithoutBed_yn" ,chk5); 
					htRecord.put("print_on_disch_adv_yn" , chk7);
					htRecord.put("discharge_yn" , chk6); 

					IPOnlineReportRecordSet.putObject(htRecord);
				}

			if(rs!=null)	rs.close();
			if(stmt!=null)	stmt.close();
			}

			row_count				=	IPOnlineReportRecordSet.getSize();

			
		}
		
		
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

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
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

	try
	{
	
	
	for(int i=0; i<row_count; i++)
		{
			classValue			=	( (i%2)==0 )? "QRYODD" : "QRYEVEN";
			htRecord			=	(java.util.Hashtable)	IPOnlineReportRecordSet.getObject(i);
			code			=	(String)htRecord.get("code");
			desc			=	(String)htRecord.get("desc");
			valid			=	(String)htRecord.get("valid");
			
				chk1			=	(String)htRecord.get("booking_yn");
				chk4			=	(String)htRecord.get("admissionWithBed_yn");
				chk5			=	(String)htRecord.get("admissionWithoutBed_yn");
				chk3			=	(String)htRecord.get("print_on_transfer_request_yn");
				chk2			=	(String)htRecord.get("transferConfirmation_yn");
				chk7			=	(String)htRecord.get("print_on_disch_adv_yn");
				chk6			=	(String)htRecord.get("discharge_yn");
			
			
					if(valid.equals("Y"))
					{
						selectChk	="checked";
						if(code==null)code="";
					}
					else
						selectChk	="";
/*
					if(code.equals("IPBBKSLP"))
					{
						disabledBkg	="";
						disabledOthers="disabled";
						disabledDischarge="disabled";
					}
					if(code.equals("IPHKPLTR"))
					{
						disabledOthers="disabled";
					}
					else
					{
						disabledBkg	="disabled";
						disabledOthers="";
						if(code.equals("IPBENFRM"))
							disabledDischarge="disabled";
						else
							disabledDischarge="";
					}
*/


		

		/*
			*** Added  by Bangarraju K  on 3/06/2009.. 
	
			****************************************************
			Report ID - Report Deescription
			****************************************************
		*	IPBBKSLP	Admission Booking Slip
		*	IPBADLBL	Admission Label
		*	IPBABLBL	Admission Label for Bed
		*	IPBADNOT	Admission Notification
		*	IPBADREC	Admission Record
		*	IPBAORFR	At Own Risk Form
		*	IPBBDYTG	Body Tag
		*	IPBENFRM	Encounter Form
		*	IPBWBLBL	Inpatient Wristband Label
		*	IPBINWBL	Inpatient Wristband Label for Infant's
		*	IPBINBCC	Intimation for Bed Class Change
		*	IPBINDIS	Intimation for Discharge
		*	IPBMDNOT	Notification Of Maternal Death
			****************************************************
		*/
		

			if(code.equals("IPBADLBL") || code.equals("IPBABLBL") || code.equals("IPBADNOT") || code.equals("IPBADREC") || code.equals("IPBENFRM") || code.equals("IPBWBLBL")|| code.equals("IPBINWBL") || code.equals("IPADFORM") || code.equals("IPOSIDEN"))
			{
				disabledBkg			= "disabled";
				disabledOthers		= "";
				disabledDischarge	= "disabled";
				disabledDischargeAdvise="disabled";
				disabledTrsfRequest="disabled";
			}


			if(code.equals("IPBAORFR") || code.equals("IPBBDYTG") || code.equals("IPBMDNOT") || code.equals("IPDISSUM") || code.equals("PHBORDSM"))
			{
				disabledBkg			= "disabled";
				disabledOthers		= "disabled";
				disabledDischarge	= "";
				disabledDischargeAdvise="disabled";
				disabledTrsfRequest="disabled";
			}
				if(code.equals("IPBINDIS"))
			{ 
				disabledBkg			= "disabled";
                disabledDischarge      = "disabled";
				disabledOthers   = "disabled";
				disabledDischargeAdvise	= "";
				disabledTrsfRequest="disabled";
			}
		  if(code.equals("IPBINBCC"))
			{ 
				disabledBkg			= "disabled";
                disabledDischargeAdvise="disabled";
				disabledOthers   = "disabled";        
				disabledDischarge= "disabled";
				disabledTrsfRequest="";
				
				
			}


			if(code.equals("IPBBKSLP"))
			{
				disabledBkg			    = "";
				disabledOthers		    = "disabled";
				disabledDischarge	    = "disabled";
				disabledDischargeAdvise ="disabled";
				disabledTrsfRequest     ="disabled";
			}

			if(code.equals("FMFLRQSL"))
			{
				disabledadm				= "";
				disabledassign			= "";
				disabledDischarge	    = "disabled";
				
			}
		

		/*	if(code.equals("IPBMDSUM"))
			{
				disabledBkg			= "disabled";
				disabledOthers		= "disabled";
				disabledDischarge	= "disabled";
			} */

			tblrow_id	=	"tblrow_id"+i;
		
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(((desc.equals(""))?"&nbsp;":desc)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(chk1));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disabledBkg));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(chk4));
            _bw.write(_wl_block23Bytes, _wl_block23);
if(!code.equals("FMFLRQSL"))
			{
            out.print( String.valueOf(disabledOthers));
            _bw.write(_wl_block23Bytes, _wl_block23);
}
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disabledadm));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(chk5));
            _bw.write(_wl_block23Bytes, _wl_block23);
if(!code.equals("FMFLRQSL"))
			{
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disabledOthers));
            _bw.write(_wl_block23Bytes, _wl_block23);
}
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disabledassign));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(chk3));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disabledTrsfRequest));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(chk2));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disabledOthers));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(chk7));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disabledDischargeAdvise));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(chk6));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disabledDischarge));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(selectChk));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(code));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);

			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			out.println("Exception@2: "+e);
		}
	
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(operation));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(Function));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(function_code));
            _bw.write(_wl_block50Bytes, _wl_block50);

	}
	catch(Exception e)
	{
		out.println("Exception in fetching connection"+e.toString());
		e.printStackTrace();
	}
	finally
	{
		if(stmt != null) stmt.close();
		if(rs != null) rs.close();
		ConnectionManager.returnConnection(con,request);
	}
	
            _bw.write(_wl_block51Bytes, _wl_block51);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reportname.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PrintOn.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.booking.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admission.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AssignBed.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.TransferRequest.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.TransferConfirmation.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DischargeAdvice.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Discharge.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }
}
