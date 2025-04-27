package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Date;
import eBL.*;
import eBL.Common.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.math.*;
import java.net.*;
import java.text.*;
import eBL.BLReportIdMapper;
import webbeans.op.CurrencyFormat;
import webbeans.eCommon.*;
import org.apache.commons.codec.binary.Base64;
import java.util.*;
import com.ehis.util.*;

public final class __bladvancedpriorauthpatientdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eBL/jsp/BLAdvancedPriorAuthPatientDetails.jsp", 1717387890392L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1669269240778L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n<script>\r\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\";\r\n</script>\r\n\r\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\r\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\r\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\r\n<script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\'></script>\r\n\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\r\n<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\r\n<script language=\'javascript\' src=\'../../eBL/js/BLAdvancedPriorAuth.js\'></script>\r\n\r\n<html>\r\n<HEAD>\r\n\t<style>\r\n\t\tdiv.tableContainer {\r\n\t\t\twidth: 100%;\t\t/* table width will be 99% of this*/\r\n\t\t\theight: 160px; \t/* must be greater than tbody*/\r\n\t\t\toverflow: auto;\r\n\t\t\tmargin: 0 auto;\r\n\t\t}\r\n\t\t\r\n\t\ttable {\r\n\t\t\twidth: 100%;\t\t/*100% of container produces horiz. scroll in Mozilla*/\r\n\t\t\tborder: none;\r\n\t\t\tbackground-color: #f7f7f7;\r\n\t\t\t}\r\n\t\t\t\r\n\t\ttable>tbody\t{  /* child selector syntax which IE6 and older do not support*/\r\n\t\t\toverflow: auto; \r\n\t\t\theight: 120x;\r\n\t\t\toverflow-x: hidden;\r\n\t\t\t}\r\n\t\t\t\r\n\t\tthead tr\t{\r\n\t\t\tposition:relative; \r\n\t\t\ttop: expression(offsetParent.scrollTop); /*IE5+ only*/\r\n\t\t\t}\r\n\t\t\t\t\r\n\t\t\tdiv.tableContainer {\r\n\t\t\t\twidth: 100%;\t\t/* table width will be 99% of this*/\r\n\t\t\t\theight: 140px; \t/* must be greater than tbody*/\r\n\t\t\t\toverflow: scroll;\r\n\t\t\t\tmargin: 0 auto;\r\n\t\t\t}\t\r\n\t\t\t.LocalYellow\r\n\t\t\t{\r\n\t\t\t\tCOLOR:#444444;\r\n\t\t\t\tBACKGROUND-COLOR: yellow ;\r\n\t\t\t\tFONT-SIZE: 8pt ;\r\n\t\t\t\tborder: 1x;\r\n\t\t\t\tborder-style: dashed;\r\n\t\t\t\tborder-left-color: #D5E2E5;\r\n\t\t\t\tborder-right-color: #D5E2E5;\r\n\t\t\t\tborder-top-color: #D5E2E5;\r\n\t\t\t\tborder-bottom-color: #D5E2E5; \r\n\t\t\t\tPADDING-LEFT:7px;\r\n\t  \t\t\tPADDING-RIGHT:7px\r\n\t\t\t}\r\n\t\t\tSPAN.LABEL\r\n\t\t\t{\r\n\t\t\t  COLOR:#444444;\r\n\t\t\t  /*background-color:#FFFFFF;*/\r\n\t\t\t  background-color:#FFFFFF;\r\n\t\t\t  FONT-SIZE: 8pt;\r\n\t\t\t  TEXT-ALIGN: LEFT;\r\n\t\t\t  /*TEXT-ALIGN: RIGHT;*/\r\n\t\t\t  PADDING-LEFT:7px;\r\n\t\t\t  PADDING-RIGHT:7px\r\n\t\t\t}\r\n\t\t\t\r\n\t\t\tSPAN.LABEL1\r\n\t\t\t{\r\n\t\t\t  COLOR:#444444;\r\n\t\t\t  /*background-color:#FFFFFF;*/\r\n\t\t\t  background-color:#FFFFFF;\r\n\t\t\t  FONT-SIZE: 8pt;\r\n\t\t\t  /*TEXT-ALIGN: LEFT;*/\r\n\t\t\t  TEXT-ALIGN: RIGHT;\r\n\t\t\t  PADDING-LEFT:7px;\r\n\t\t\t  PADDING-RIGHT:7px\r\n\t\t\t}\r\n\t\t\t\r\n\t\t\tSPAN.SpanYellow\r\n\t\t\t{\r\n\t\t\t\tCOLOR:#444444;\r\n\t\t\t\tBACKGROUND-COLOR: yellow ;\r\n\t\t\t\tFONT-SIZE: 8pt ;\r\n\t\t\t\tPADDING-LEFT:7px;\r\n\t\t\t\tPADDING-RIGHT:7px\r\n\t\t\t}\r\n\t\t\ttbody tr.YELLOW{\r\n\t\t\t\tCOLOR:#444444;\r\n\t\t\t\tBACKGROUND-COLOR: yellow ;\r\n\t\t\t}\r\n\t\t\r\n\t</style>\r\n\t\r\n</HEAD>\r\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\r\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' type=\'text/css\'/>\r\n\t\t\r\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\r\n\r\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\r\n<body class=\'CONTENT\'  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\r\n\r\n<form name=\"BLAdvancedPriorAuthPatientDetailForm\">\r\n<table cellpadding=3 cellspacing=0  width=\"100%\" border=\"1\">\r\n<div id=\"tableContainer\">\r\n\r\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\r\n\t\r\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\t\t\r\n<thead>\r\n\t<tr><td class=\"COLUMNHEADER\" align=\'left\' colspan=\"9\">Patient Data</td></tr>\r\n\t<tr>\r\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="<td class=\'COLUMNHEADER\' nowrap width = \"2%\">Polled Date</td>\r\n\t\t<td class=\'COLUMNHEADER\' nowrap width = \"5%\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\r\n\t\t<td class=\'COLUMNHEADER\' nowrap width = \"5%\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\r\n\t\t<td class=\'COLUMNHEADER\' nowrap width=\'5%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td><!-- Nphies changes -->\r\n\t\t<td class=\'COLUMNHEADER\' nowrap width = \"5%\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td><!-- Nphies changes -->\t\r\n\t</tr>\r\n</thead>\r\n<tbody id=\"BLAdvancedPriorAuthPatientDetailTable\" name=\"BLAdvancedPriorAuthPatientDetailTable\">\r\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\t\r\n\r\n\t<tr id=\'row_";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' onclick=\"getPatientServiceDetails(";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =")\">\r\n\t\t<td class=\"field\">\r\n\t\t\t&nbsp;<label name=\'srl_no_";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' id=\'srl_no_";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</label>\r\n\t\t</td>\r\n\t\t <td class=\"field\" nowrap>\r\n             &nbsp;<label name=\"patient_id_";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" id=\"patient_id_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</label>\r\n         </td>\r\n\t\t<td class=\"field\" nowrap>\r\n\t\t\t&nbsp;<label  name=\"patient_name_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"patient_name_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</label>\r\n        </td>\r\n\t\t \r\n\t\t <td class=\"field\" nowrap>\r\n         \t&nbsp;<label href=\"#\" name=\"national_Id_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" id=\"national_Id_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" </label>\r\n         </td>\r\n\t\t <td class=\"field\" nowrap>\r\n          \t&nbsp;<label name=\"iqama_Id_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" id=\"iqama_Id_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</label>\r\n         </td>\r\n\t\t<td class=\"field\" nowrap>\r\n         \t&nbsp;<label name=\"age_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" id=\"age_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</label>\r\n         </td>\r\n\t\t <td class=\"field\" nowrap>\r\n         \t&nbsp;<label name=\"gender_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" id=\"gender_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</label>\r\n         </td>\r\n\t\t <td class=\"field\" nowrap>\r\n         \t&nbsp;<label name=\"mobile_no_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" id=\"mobile_no_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</label>\r\n         </td>\r\n         <td class=\"field\" nowrap>\r\n         \t&nbsp;<label name=\"payerGrpDesc_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" id=\"payerGrpDesc_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</label>\r\n         </td><!-- Nphies changes -->\r\n\t\t \t\t \t\r\n\t</tr> \r\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\t\t\r\n\r\n\t</tbody>\r\n\r\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\t\r\n<Script>\r\n//document.getElementById(\"patient_sec\").style.display = \"none\";\r\nalert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));</script>\r\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\r\n\t\r\n\t</tbody>\r\n\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\r\n</table>\t\r\n</div>\t\r\n\t<input type=\'hidden\' name=\'called_from_dashboard_YN\' id=\'called_from_dashboard_YN\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\r\n\t<input type=\'hidden\' name=\'qry_search_params\' id=\'qry_search_params\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\r\n\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"/>\r\n\t<input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"/>\r\n\t<input type=\'hidden\' name=\'prevClicked\' value=\"\" />\r\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\r\n</form>\r\n</body>\r\n</html>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );
	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}

	
	private String checkForNull(String inputString, String dfltVal)
	{
		return (inputString == null) ? dfltVal : inputString;
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String params = request.getQueryString() ;
	if(params==null || params.equals("")) params="";
	System.err.println("In BLAdvancedPriorAuthPatientDetails.jsp: "+params);
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block6Bytes, _wl_block6);

	Connection con=null;
	PreparedStatement pstmt = null;
	ResultSet rst=null;
	
	String facilityId = (String)session.getAttribute("facility_id");
	String locale = (String)session.getAttribute("locale");
	if(locale == null) locale = "en";
	String called_from_dashboard_YN = request.getParameter("called_from_dashboard_YN");
	if(called_from_dashboard_YN == null || called_from_dashboard_YN.equals("")) called_from_dashboard_YN = "N";
	System.err.println(" called_from_dashboard_YN= "+called_from_dashboard_YN);
	String qry_patient_id = checkForNull(request.getParameter("patientId"));
	String qry_polled_from_date = checkForNull(request.getParameter("polled_from_date"));
	String qry_polled_to_date = checkForNull(request.getParameter("polled_to_date"));
	String qry_nationalId = checkForNull(request.getParameter("nationalId"));
	String qry_iqamaId = checkForNull(request.getParameter("iqamaId"));
	
	System.err.println("URL Parameters :- facilityId= "+facilityId+", Patient_id= "+qry_patient_id+",  polled_from_date = "+qry_polled_from_date+", polled_to_date="+qry_polled_to_date+", nationalId="+qry_nationalId+", iqamaId="+qry_iqamaId);

            _bw.write(_wl_block7Bytes, _wl_block7);
	

	
	try
	{
		String sql = "";
		int row_count = 0;
		int column_count = 0;
		java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
		String login_user = (String) p.getProperty("login_user");
		
		con=ConnectionManager.getConnection(request);
		sql = "select a.PATIENT_ID ,a.patient_name patient_name, a.NATIONAL_ID_NO, a.IQAMA_ID, max(a.MOBILE_NUM) MOBILE_NUM, "
				+"case when to_char(sysdate,'MM')-to_char(to_date(a.date_of_birth,'yyyy-mm-dd'),'MM') < 0 "
			    +"then to_char(sysdate,'YYYY')-to_char(to_date(a.date_of_birth,'yyyy-mm-dd'),'YYYY') - 1||'Y ' "
			    +"else to_char(sysdate,'YYYY')-to_char(to_date(a.date_of_birth,'yyyy-mm-dd'),'YYYY')||'Y ' "
			    +"end || "
			    +"case when to_char(sysdate,'MM')-to_char(to_date(a.date_of_birth,'yyyy-mm-dd'),'MM') < 0 "
			    +"then 12 + to_char(sysdate,'MM')-to_char(to_date(a.date_of_birth,'yyyy-mm-dd'),'MM')||'M ' "
			    +"else to_char(sysdate,'MM')-to_char(to_date(a.date_of_birth,'yyyy-mm-dd'),'MM')||'M ' "
			    +"end || "
			    +"case when to_char(sysdate,'DD')-to_char(to_date(a.date_of_birth,'yyyy-mm-dd'),'DD') < 0 "
			    +"then to_char(to_date(a.date_of_birth,'yyyy-mm-dd'),'DD') - to_char(sysdate,'DD')||'D ' "
			    +"else to_char(sysdate,'DD')-to_char(to_date(a.date_of_birth,'yyyy-mm-dd'),'DD')||'D ' "
			    +"end age,DECODE(a.sex,'M','Male','F','Female','Unknown') gender,max(c.short_desc) payer_group_desc, "
			    +"to_char(a.POLLED_DATE,'dd/MM/yyyy') polled_date from BL_INS_ADV_PRE_AUTH a, ar_cust_group c  "
			    +"where a.cust_group_code = c.cust_group_code(+) "; //V240503-NMC-JD-CRF-0102.17
	
	
		if(!"".equals(qry_polled_from_date) && !"".equals(qry_polled_to_date)){
			sql = sql + "and TRUNC(POLLED_DATE) BETWEEN to_date(?,'DD/MM/YYYY') AND to_date(?,'DD/MM/YYYY') ";
		}
		
		if(!"".equals(qry_patient_id)){
			sql = sql + " and a.PATIENT_ID = ? ";
		}
		
		if(!"".equals(qry_nationalId)){
			sql = sql + " and  a.NATIONAL_ID_NO = ? ";
		}
		
		if(!"".equals(qry_iqamaId)){
			sql = sql + " and a.IQAMA_ID = ? ";
		}
				
		sql = sql + " GROUP BY a.polled_date,a.patient_id, a.patient_name, a.national_id_no, a.iqama_id, a.date_of_birth,a.sex order by a.POLLED_DATE desc";
		
		System.err.println("sql to load data :"+sql); //POLLED_DATE
		
		pstmt = con.prepareStatement(sql);		
		
		if(!"".equals(qry_polled_from_date) && !"".equals(qry_polled_to_date)){
			pstmt.setString(++column_count, qry_polled_from_date);	
			pstmt.setString(++column_count, qry_polled_to_date);
		}
		
		if(!"".equals(qry_patient_id))
			pstmt.setString(++column_count,qry_patient_id);			
		
		if(!"".equals(qry_nationalId))
			pstmt.setString(++column_count, qry_nationalId);
		
		if(!"".equals(qry_iqamaId))
			pstmt.setString(++column_count, qry_iqamaId);	


		System.err.println("sql to load data column_count:"+column_count);
				
		rst = pstmt.executeQuery();
		while ( rst.next() )
		{	
			System.err.println(rst.toString());
			String patientId = checkForNull(rst.getString("PATIENT_ID"));
			String patientName = checkForNull(rst.getString("patient_name"));
			String nationalIdNo = checkForNull(rst.getString("NATIONAL_ID_NO"));
			String iqamaId = checkForNull(rst.getString("IQAMA_ID"));
			String mobileNum = checkForNull(rst.getString("MOBILE_NUM"));
			String patientAge = checkForNull(rst.getString("age"));
			String payerGrpDesc = checkForNull(rst.getString("payer_group_desc"));	//Nphies changes
			String gender=checkForNull(rst.getString("gender"));	//Nphies changes
			String polled_date=checkForNull(rst.getString("polled_date"));	//Nphies changes
 			row_count++; 
 			

            _bw.write(_wl_block8Bytes, _wl_block8);

//row_count = 1;
		if(row_count == 1)
		{

            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

		}

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(polled_date));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patientName));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(nationalIdNo));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(iqamaId));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patientAge));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(mobileNum));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(payerGrpDesc));
            _bw.write(_wl_block37Bytes, _wl_block37);

	}

            _bw.write(_wl_block38Bytes, _wl_block38);
					
		
		if(row_count == 0){

            _bw.write(_wl_block39Bytes, _wl_block39);

		}

            _bw.write(_wl_block40Bytes, _wl_block40);
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(called_from_dashboard_YN));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(params));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block45Bytes, _wl_block45);

	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(pstmt!=null)	pstmt.close();
		if(rst!=null)	rst.close();
		ConnectionManager.returnConnection(con,request);		
	} 

            _bw.write(_wl_block46Bytes, _wl_block46);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.NationalID.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.IqamaID.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MobileNo.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_GROUP.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
