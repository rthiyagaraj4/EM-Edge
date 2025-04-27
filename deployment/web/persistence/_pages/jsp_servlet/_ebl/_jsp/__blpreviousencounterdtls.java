package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import java.util.*;
import com.ehis.util.*;
import eCommon.Common.*;
import java.util.*;

public final class __blpreviousencounterdtls extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLPreviousEncounterDtls.jsp", 1728313534872L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script>\n/*\n\tfunction callPrevEnctr(strFacilityId,strPatientId,strEpisodeType,strEpisodeId,strVisitId)\n\t{\t\t\n\t\tvar calling_module_id=document.forms[0].calling_module_id.value;\n\t\tvar query_string=document.forms[0].query_string.value;\tparent.frames[2].location.href=\'../../eBL/jsp/BLFinDetHiddenFlds.jsp?selected_from_prev_enc_YN=Y&strFacilityId=\'+strFacilityId+\'&patient_id=\'+strPatientId+\"&calling_module=\"+calling_module_id+\'&episode_type=\'+strEpisodeType+\'&episode_id=\'+strEpisodeId+\'&visit_id=\'+strVisitId+\'&query_string=\'+query_string;\n\t}\n*/\n</script>\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\t\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\t\n\t\t\t<script language=\"javascript\" src=\"../../eBL/js/BLPrevEncounterDtls.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t\n\t\t\t\n\t\t\t<style>\n\t\t\t\tthead td, thead td.locked\t{\n\t\t\t\tbackground-color: navy;\n\t\t\t\tcolor: white;\n\t\t\t\tposition:relative;}\t\n\t\t\t\tthead td {\n\t\t\t\ttop: expression(document.getElementById(\"tbl-container\").scrollTop-5); \n\t\t\t\tz-index: 20;}\n\t\t\t\tthead td.locked {z-index: 30;}\n\t\t\t\ttd.locked,  th.locked{\n\t\t\t\tleft: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);\n\t\t\t\tposition: relative;\n\t\t\t\tz-index: 10;}\n\t\t\t\ttd.locked,  th.locked{\n\t\t\t\tleft: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);\n\t\t\t\tposition: relative;\n\t\t\t\tz-index: 10;}\n\t\t\t</style>\n</head>\n\n<body onLoad=\'\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<form name=\'prev_enctr_dtls\' id=\'prev_enctr_dtls\' method=\'post\' >\t\t\t\n<div>\n\t<table  cellpadding=3 cellspacing=0 width=\"100%\" align=\"center\">\n\t\t<tr>\n\t\t\t<td width=\"80%\" class=\'label\'>&nbsp;</td>\t\t\n\t\t\t<td width=\"20%\" class=\'label\'>&nbsp;\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\t\t</td></tr>\n\t</table>\n</div>\n\t\t<div id=\"tbl-container\" STYLE=\"overflow: auto; min-height: 165px;   padding:3px; margin: 0px\">\n\t\t\t<table border=\'1\' cellpadding=\'3\'  align = \'center\' id=\'enctr_fin_det\' width=\'100%\'>\t\t\t\n\t\t\t\t<thead>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' colspan=10 align=\'left\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'15%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'12%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'14%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'2%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\t\t\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</thead>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\t\n\t\t\t\t<tbody>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\n\t\t\t\t\t<tr>\n\t\t\t\t\t   <td class=\'QRYEVEN\' colspan=\'10\'>&nbsp;</td>\t\t\t\t\t\t\t\t\n\t\t\t\t\t</tr>\t\t\t\t\t\t\t\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t<tr style=\'background-color:white\'>\t\t\t\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t<td class=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" width=\'10%\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\t \n\t\t\t\t\t<td class=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" width=\'15%\'><a name=\'\' href=\"#\" onClick=\"callPrevEnctrPlcyActSeq(\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\',\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\',\'E\')\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</a></td>\t \n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t<td class=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" / ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\t \n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" width=\'10%\'>&nbsp;</td>\n\t\t\t\t\t<td class=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" width=\'15%\'>&nbsp;</td>\n\t\t\t\t\t<td class=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" width=\'10%\'>&nbsp;</td>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" width=\"12%\" >";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\t\t\t\t\t<td class=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" width=\'14%\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" width=\"2%\" style=\'text-align:right\'>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" width=\"17%\">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\t\t\n\t\t\t\t\t<td class=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" width=\"10%\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\t\t\t\t\t\n\t\t\t\t\t<td class=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td> \t\t\t\n\t\t\t\t\t<td class=";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t</tbody>\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t</table>\n\t\t\t</div>\n\t\t\t<input type=\'hidden\' name=\'calling_module_id\' id=\'calling_module_id\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n\t\t\t<input type=\'hidden\' name=\'query_string\' id=\'query_string\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\t\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\t\n\t\t\t</form>\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

    request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null ;
	Statement stmt = null; 
	ResultSet rsdt=null;ResultSet rs1=null;ResultSet rs2=null;ResultSet rs3=null;
	String locale	= (String)session.getAttribute("LOCALE");	
	if(locale==null || locale.equals("")) locale="en";
	//CurrencyFormat cf = new CurrencyFormat();
	String classval="";		
	String strEpisodeType="";String strPatientId="";String strEncounterDate="";
	String strFacilityId="";String sqlPrevEnctr="";
	String strEpisodeId="";String strVisitId="";String strEncRegnDateTime="";String strBlngGrpId="";String strStlmtInd="";String strCustcode="";String strPriority="";String strPolicyTypeCode="";String strPolicyNum="";String strPolicyStartDate="";String strPolicyExpiryDate="";String strCreditAuthRef="";String strCreditAuthDate="";String strEffectiveFrom="";String strEffectiveTo="";
	String strAppAmt="";String strAppDays="";String strAdjRuleInd="";String strAdjPercAmtInd="";String strAdjPercAmtValue="";String strPmntDiffAdjInt="";String strDrgPmntDiffAdjInt="";String strSplServPmntDiffInt="";String currEpiId="";
	//	String currVstId="";
	String prevEpiId="",system_date="",query_string="",calling_module_id="",str_epi_type="";
	String strModifiedDate="", strPatRegnDateTime = "";
	//prevVstId="",system_date="",query_string="",calling_module_id="",str_epi_type="";
	String strPolicyDesc="",strCustDesc="",strBlngDesc;
	boolean searched = (request.getParameter("searched") == null) ?false:true;	
	
	try
	{
		con	=	ConnectionManager.getConnection(request);
		strFacilityId=request.getParameter("facility_id");
		if(strFacilityId==null || strFacilityId.equals("")) strFacilityId="";
		strPatientId = request.getParameter("patient_id");
		if(strPatientId==null) strPatientId="";	
		strEpisodeType = request.getParameter("episode_type");
		if(strEpisodeType==null) strEpisodeType="";	

		calling_module_id=request.getParameter("calling_module_id");
		if(calling_module_id==null) calling_module_id="";	

		query_string=request.getQueryString();
		if(query_string==null) query_string="";

		try
		{
			String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') from dual";
			stmt = con.createStatement();
			rsdt = stmt.executeQuery(query_date) ;
			if( rsdt != null ) 
			{
				while( rsdt.next() )
				{  
					system_date = rsdt.getString(1);
				}
			}
			stmt.close();
			rsdt.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in Sys Date :"+e);
		}
		
//		System.out.println("system_date :"+system_date);
		strEncounterDate=request.getParameter("encounter_date");
		if(strEncounterDate==null || strEncounterDate.equals("")) strEncounterDate=system_date;

            _bw.write(_wl_block6Bytes, _wl_block6);

			String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		try
		{
/*			if(strEpisodeType.equals("O") || strEpisodeType.equals("E"))
			{
				sqlPrevEnctr="Select a.EPISODE_ID EPISODE_ID1,a.VISIT_ID VISIT_ID1, To_Char(a.ENC_REGN_DATE_TIME,'dd/mm/yyyy HH24:MI:SS') ENC_REGN_DATE_TIME1,a.BLNG_GRP_ID BLNG_GRP_ID1,a.SETTLEMENT_IND SETTLEMENT_IND1 ,a.CUST_CODE CUST_CODE1, a.PRIORITY PRIORITY1, a.POLICY_TYPE_CODE POLICY_TYPE_CODE1, a.POLICY_NUMBER POLICY_NUMBER1, a.POLICY_START_DATE POLICY_START_DATE1,a.POLICY_EXPIRY_DATE POLICY_EXPIRY_DATE1,a.CREDIT_AUTH_REF CREDIT_AUTH_REF1, a.CREDIT_AUTH_DATE CREDIT_AUTH_DATE1,To_Char(a.EFFECTIVE_FROM,'dd/mm/yyyy') EFFECTIVE_FROM1,To_Char(a.EFFECTIVE_TO,'dd/mm/yyyy') EFFECTIVE_TO1 , a.APPROVED_AMT APPROVED_AMT1, a.APPROVED_DAYS APPROVED_DAYS1, a.ADJ_RULE_IND ADJ_RULE_IND1,a.ADJ_PERC_AMT_IND ADJ_PERC_AMT_IND1 , a.ADJ_PERC_AMT_VALUE ADJ_PERC_AMT_VALUE1, a.PMNT_DIFF_ADJ_INT PMNT_DIFF_ADJ_INT1,  a.DRG_PMNT_DIFF_ADJ_INT DRG_PMNT_DIFF_ADJ_INT1, a.SPL_SRV_PMNT_DIFF_ADJ_INT SPL_SRV_PMNT_DIFF_ADJ_INT1 from BL_ENCOUNTER_PAYER_PRIORITY a, bl_visit_fin_dtls  b where a.OPERATING_FACILITY_ID=b.OPERATING_FACILITY_ID and   a.EPISODE_TYPE= b.episode_type and   a.ACCT_SEQ_NO= b.cur_acct_seq_no and   a.OPERATING_FACILITY_ID = b.OPERATING_FACILITY_ID and   a.episode_id= b.episode_id and   a.visit_id= b.visit_id and   a.EPISODE_TYPE = '"+strEpisodeType+"' and   a.OPERATING_FACILITY_ID = '"+strFacilityId+"' and   a.patient_id= '"+strPatientId+"' and  a.ENC_REGN_DATE_TIME < to_date('"+strEncounterDate+"','dd/mm/yyyy HH24:MI:SS') order by ENC_REGN_DATE_TIME desc";
			
				System.out.println("sqlPrevEnctr ID: "+sqlPrevEnctr);
			}
			else if(strEpisodeType.equals("I") || strEpisodeType.equals("D"))
			{
				sqlPrevEnctr="Select a.EPISODE_ID EPISODE_ID1,a.VISIT_ID VISIT_ID1, To_Char(a.ENC_REGN_DATE_TIME,'dd/mm/yyyy HH24:MI:SS') ENC_REGN_DATE_TIME1,a.BLNG_GRP_ID BLNG_GRP_ID1,a.SETTLEMENT_IND SETTLEMENT_IND1 ,a.CUST_CODE CUST_CODE1, a.PRIORITY PRIORITY1, a.POLICY_TYPE_CODE POLICY_TYPE_CODE1, a.POLICY_NUMBER POLICY_NUMBER1, a.POLICY_START_DATE POLICY_START_DATE1,a.POLICY_EXPIRY_DATE POLICY_EXPIRY_DATE1,a.CREDIT_AUTH_REF CREDIT_AUTH_REF1, a.CREDIT_AUTH_DATE CREDIT_AUTH_DATE1,To_Char(a.EFFECTIVE_FROM,'dd/mm/yyyy') EFFECTIVE_FROM1,To_Char(a.EFFECTIVE_TO,'dd/mm/yyyy') EFFECTIVE_TO1 , a.APPROVED_AMT APPROVED_AMT1, a.APPROVED_DAYS APPROVED_DAYS1, a.ADJ_RULE_IND ADJ_RULE_IND1,a.ADJ_PERC_AMT_IND ADJ_PERC_AMT_IND1 , a.ADJ_PERC_AMT_VALUE ADJ_PERC_AMT_VALUE1, a.PMNT_DIFF_ADJ_INT PMNT_DIFF_ADJ_INT1,  a.DRG_PMNT_DIFF_ADJ_INT DRG_PMNT_DIFF_ADJ_INT1, a.SPL_SRV_PMNT_DIFF_ADJ_INT SPL_SRV_PMNT_DIFF_ADJ_INT1 from BL_ENCOUNTER_PAYER_PRIORITY a,bl_episode_fin_dtls b where a.OPERATING_FACILITY_ID=b.OPERATING_FACILITY_ID and a.EPISODE_TYPE = b.episode_type and a.ACCT_SEQ_NO= b.cur_acct_seq_no and   a.OPERATING_FACILITY_ID = b.OPERATING_FACILITY_ID and a.episode_id= b.episode_id and   a.EPISODE_TYPE = '"+strEpisodeType+"'  and   a.OPERATING_FACILITY_ID = '"+strFacilityId+"' and a.patient_id = '"+strPatientId+"' and  a.ENC_REGN_DATE_TIME < to_date('"+strEncounterDate+"','dd/mm/yyyy HH24:MI:SS')  order by ENC_REGN_DATE_TIME desc";

				System.out.println("sqlPrevEnctrEO: "+sqlPrevEnctr);
			} 
*/
			sqlPrevEnctr="Select a.ACCT_SEQ_NO ACCT_SEQ_NO1,a.EPISODE_ID EPISODE_ID1,a.VISIT_ID VISIT_ID1, To_Char(a.ENC_REGN_DATE_TIME,'dd/mm/yyyy HH24:MI:SS') ENC_REGN_DATE_TIME1,a.BLNG_GRP_ID BLNG_GRP_ID1,a.SETTLEMENT_IND SETTLEMENT_IND1 ,a.CUST_CODE CUST_CODE1, a.PRIORITY PRIORITY1, a.POLICY_TYPE_CODE POLICY_TYPE_CODE1, a.POLICY_NUMBER POLICY_NUMBER1, a.POLICY_START_DATE POLICY_START_DATE1,a.POLICY_EXPIRY_DATE POLICY_EXPIRY_DATE1,a.CREDIT_AUTH_REF CREDIT_AUTH_REF1, a.CREDIT_AUTH_DATE CREDIT_AUTH_DATE1,To_Char(a.EFFECTIVE_FROM,'dd/mm/yyyy') EFFECTIVE_FROM1,To_Char(a.EFFECTIVE_TO,'dd/mm/yyyy') EFFECTIVE_TO1 , a.APPROVED_AMT APPROVED_AMT1, a.APPROVED_DAYS APPROVED_DAYS1, a.ADJ_RULE_IND ADJ_RULE_IND1,a.ADJ_PERC_AMT_IND ADJ_PERC_AMT_IND1 , a.ADJ_PERC_AMT_VALUE ADJ_PERC_AMT_VALUE1, a.PMNT_DIFF_ADJ_INT PMNT_DIFF_ADJ_INT1,  a.DRG_PMNT_DIFF_ADJ_INT DRG_PMNT_DIFF_ADJ_INT1, a.SPL_SRV_PMNT_DIFF_ADJ_INT SPL_SRV_PMNT_DIFF_ADJ_INT1,b.episode_type episode_type,ENC_REGN_DATE_TIME from BL_ENCOUNTER_PAYER_PRIORITY a, bl_visit_fin_dtls  b where a.OPERATING_FACILITY_ID=b.OPERATING_FACILITY_ID and   a.EPISODE_TYPE= b.episode_type and   a.ACCT_SEQ_NO= b.cur_acct_seq_no and   a.OPERATING_FACILITY_ID = b.OPERATING_FACILITY_ID and   a.episode_id= b.episode_id and   a.visit_id= b.visit_id and   a.EPISODE_TYPE in ('E','O') and   a.OPERATING_FACILITY_ID = '"+strFacilityId+"' and   a.patient_id= '"+strPatientId+"' and  a.ENC_REGN_DATE_TIME < to_date('"+strEncounterDate+"','dd/mm/yyyy HH24:MI:SS') union Select a.ACCT_SEQ_NO ACCT_SEQ_NO1,a.EPISODE_ID EPISODE_ID1,a.VISIT_ID VISIT_ID1, To_Char(a.ENC_REGN_DATE_TIME,'dd/mm/yyyy HH24:MI:SS') ENC_REGN_DATE_TIME1,a.BLNG_GRP_ID BLNG_GRP_ID1,a.SETTLEMENT_IND SETTLEMENT_IND1 ,a.CUST_CODE CUST_CODE1, a.PRIORITY PRIORITY1, a.POLICY_TYPE_CODE POLICY_TYPE_CODE1, a.POLICY_NUMBER POLICY_NUMBER1, a.POLICY_START_DATE POLICY_START_DATE1,a.POLICY_EXPIRY_DATE POLICY_EXPIRY_DATE1,a.CREDIT_AUTH_REF CREDIT_AUTH_REF1, a.CREDIT_AUTH_DATE CREDIT_AUTH_DATE1,To_Char(a.EFFECTIVE_FROM,'dd/mm/yyyy') EFFECTIVE_FROM1,To_Char(a.EFFECTIVE_TO,'dd/mm/yyyy') EFFECTIVE_TO1 , a.APPROVED_AMT APPROVED_AMT1, a.APPROVED_DAYS APPROVED_DAYS1, a.ADJ_RULE_IND ADJ_RULE_IND1,a.ADJ_PERC_AMT_IND ADJ_PERC_AMT_IND1 , a.ADJ_PERC_AMT_VALUE ADJ_PERC_AMT_VALUE1, a.PMNT_DIFF_ADJ_INT PMNT_DIFF_ADJ_INT1,  a.DRG_PMNT_DIFF_ADJ_INT DRG_PMNT_DIFF_ADJ_INT1, a.SPL_SRV_PMNT_DIFF_ADJ_INT SPL_SRV_PMNT_DIFF_ADJ_INT1, b.episode_type episode_type,ENC_REGN_DATE_TIME from BL_ENCOUNTER_PAYER_PRIORITY a,bl_episode_fin_dtls b where a.OPERATING_FACILITY_ID=b.OPERATING_FACILITY_ID and a.EPISODE_TYPE = b.episode_type and a.ACCT_SEQ_NO= b.cur_acct_seq_no and   a.OPERATING_FACILITY_ID = b.OPERATING_FACILITY_ID and a.episode_id= b.episode_id and   a.EPISODE_TYPE in ('I','D')  and   a.OPERATING_FACILITY_ID = '"+strFacilityId+"' and a.patient_id = '"+strPatientId+"' and  a.ENC_REGN_DATE_TIME < to_date('"+strEncounterDate+"','dd/mm/yyyy HH24:MI:SS')order by ENC_REGN_DATE_TIME desc,EPISODE_ID1,VISIT_ID1,PRIORITY1";

//			System.out.println("sqlPrevEnctr: "+sqlPrevEnctr);
					
			HashMap sqlMap = new HashMap();						
			sqlMap.put("sqlData",sqlPrevEnctr);						
			HashMap funcMap = new HashMap();
			ArrayList displayFields = new ArrayList();
			ArrayList chkFields = new ArrayList();
			displayFields.add("EPISODE_ID1");
			displayFields.add("VISIT_ID1");
			displayFields.add("ENC_REGN_DATE_TIME1");
			displayFields.add("BLNG_GRP_ID1");
			displayFields.add("SETTLEMENT_IND1");
			displayFields.add("CUST_CODE1");
			displayFields.add("PRIORITY1");
			displayFields.add("POLICY_TYPE_CODE1");
			displayFields.add("POLICY_NUMBER1");
			displayFields.add("POLICY_START_DATE1");
			displayFields.add("POLICY_EXPIRY_DATE1");
			displayFields.add("CREDIT_AUTH_REF1");
			displayFields.add("CREDIT_AUTH_DATE1");
			displayFields.add("EFFECTIVE_FROM1");
			displayFields.add("EFFECTIVE_TO1");
			displayFields.add("APPROVED_AMT1");
			displayFields.add("APPROVED_DAYS1");
			displayFields.add("ADJ_RULE_IND1");
			displayFields.add("ADJ_PERC_AMT_IND1");
			displayFields.add("ADJ_PERC_AMT_VALUE1");
			displayFields.add("PMNT_DIFF_ADJ_INT1");
			displayFields.add("DRG_PMNT_DIFF_ADJ_INT1");
			displayFields.add("SPL_SRV_PMNT_DIFF_ADJ_INT1");
			displayFields.add("episode_type");
			displayFields.add("ACCT_SEQ_NO1");
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			System.out.println("resutl==>"+result);
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))) 
			{

            _bw.write(_wl_block9Bytes, _wl_block9);
		// For display the previous/next link
			out.println(result.get(1));		

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
					//int i=0;
			int rowflag=0;
			String rec_chk_flag="N";
			ArrayList records=new ArrayList();
			System.out.println("Result Size:"+result);
			for(int j=2; j<result.size(); j++)
			{					
						
				/*if(i % 2 == 0 )
				{
					classval	=	"QRYEVEN";
				}
				else
				{
					classval	=	"QRYODD";
				}*/

				records=(ArrayList) result.get(j);							
				strEpisodeId=(String)records.get(0);						
				if ( strEpisodeId== null || strEpisodeId.equalsIgnoreCase("null")){
					strEpisodeId="";}						
				strVisitId=(String)records.get(1);
				if ( strVisitId== null || strVisitId.equalsIgnoreCase("null")){
					strVisitId="";}
				if(j==2)
				{
					rec_chk_flag="Y";
					prevEpiId=strEpisodeId+strVisitId;
					rowflag=0;
					classval	=	"QRYODD";
//							prevVstId=strVisitId;
				}

				strEncRegnDateTime=(String)records.get(2);						
				if ( strEncRegnDateTime== null || strEncRegnDateTime.equalsIgnoreCase("null")){
					strEncRegnDateTime="";}						
				strBlngGrpId=(String)records.get(3);
				if ( strBlngGrpId== null || strBlngGrpId.equalsIgnoreCase("null")){
					strBlngGrpId="";}
				strStlmtInd=(String)records.get(4);						
				if ( strStlmtInd== null || strStlmtInd.equalsIgnoreCase("null")){
					strStlmtInd="";}			
				strCustcode=(String)records.get(5);
				if ( strCustcode== null || strCustcode.equalsIgnoreCase("null")){
					strCustcode="";}
//					System.out.println("strCustcode :"+strCustcode);
				strPriority=(String)records.get(6);						
				if ( strPriority== null || strPriority.equalsIgnoreCase("null")){
					strPriority="";}
				strPolicyTypeCode=(String)records.get(7);
				if ( strPolicyTypeCode== null || strPolicyTypeCode.equalsIgnoreCase("null")){
					strPolicyTypeCode="";}
//					System.out.println("strPolicyTypeCode :"+strPolicyTypeCode);
				strPolicyNum=(String)records.get(8);
				if ( strPolicyNum== null || strPolicyNum.equalsIgnoreCase("null")){
					strPolicyNum="";}
				strPolicyStartDate=(String)records.get(9);						
				if ( strPolicyStartDate== null || strPolicyStartDate.equalsIgnoreCase("null")){
					strPolicyStartDate="";}						
				strPolicyExpiryDate=(String)records.get(10);
				if ( strPolicyExpiryDate== null || strPolicyExpiryDate.equalsIgnoreCase("null")){
					strPolicyExpiryDate="";}
				strCreditAuthRef=(String)records.get(11);						
				if ( strCreditAuthRef== null || strCreditAuthRef.equalsIgnoreCase("null")){
					strCreditAuthRef="";}							
				strCreditAuthDate=(String)records.get(12);
				if ( strCreditAuthDate== null || strCreditAuthDate.equalsIgnoreCase("null")){
					strCreditAuthDate="";}
				strEffectiveFrom=(String)records.get(13);						
				if ( strEffectiveFrom== null || strEffectiveFrom.equalsIgnoreCase("null")){
					strEffectiveFrom="";}							
				strEffectiveTo=(String)records.get(14);
				if ( strEffectiveTo== null || strEffectiveTo.equalsIgnoreCase("null")){
					strEffectiveTo="";}
				strAppAmt=(String)records.get(15);						
				if ( strAppAmt== null || strAppAmt.equalsIgnoreCase("null")){
					strAppAmt="";}
				strAppDays=(String)records.get(16);
				if ( strAppDays== null || strAppDays.equalsIgnoreCase("null")){
					strAppDays="";}
				strAdjRuleInd=(String)records.get(17);
				if ( strAdjRuleInd== null || strAdjRuleInd.equalsIgnoreCase("null")){
				strAdjRuleInd="";}
				strAdjPercAmtInd=(String)records.get(18);
				if ( strAdjPercAmtInd== null || strAdjPercAmtInd.equalsIgnoreCase("null")){
					strAdjPercAmtInd="";}
				strAdjPercAmtValue=(String)records.get(19);						
				if ( strAdjPercAmtValue== null || strAdjPercAmtValue.equalsIgnoreCase("null")){
						strAdjPercAmtValue="";}								
				strPmntDiffAdjInt=(String)records.get(20);
				if ( strPmntDiffAdjInt== null || strPmntDiffAdjInt.equalsIgnoreCase("null")){
					strPmntDiffAdjInt="";}						
				strDrgPmntDiffAdjInt=(String)records.get(21);
				if ( strDrgPmntDiffAdjInt== null || strDrgPmntDiffAdjInt.equalsIgnoreCase("null")){
					strDrgPmntDiffAdjInt="";}
				strSplServPmntDiffInt=(String)records.get(22);
				if ( strSplServPmntDiffInt== null || strSplServPmntDiffInt.equalsIgnoreCase("null")){
					strSplServPmntDiffInt="";}
					currEpiId=strEpisodeId+strVisitId;

					strEpisodeType=(String)records.get(23);
				if ( strEpisodeType== null || strEpisodeType.equalsIgnoreCase("null")){
					strEpisodeType="";}

							
				if(strEpisodeType.equals("I")){							str_epi_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");}
				if(strEpisodeType.equals("O")){							str_epi_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");}
				if(strEpisodeType.equals("D")){							str_epi_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");}
				if(strEpisodeType.equals("E")){							str_epi_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");}	
					
					
			String	acctSeqNo=(String)records.get(24);
			if ( acctSeqNo== null || acctSeqNo.equalsIgnoreCase("null")){
				acctSeqNo="";}
			System.out.println("ACCT_SEQ_NO"+acctSeqNo);

				String sqlCustDesc="Select long_name from ar_customer_lang_vw where cust_code ='"+strCustcode+"' and language_id ='"+locale+"' and acc_entity_code =( Select acc_entity_code from sy_acc_entity where acc_entity_id = '"+strFacilityId+"')";
			

//				System.out.println("sqlCustDesc :"+sqlCustDesc);

				pstmt = con.prepareStatement(sqlCustDesc);
				strCustDesc="";
				rs1 = pstmt.executeQuery();	
				while(rs1.next())
				{
					strCustDesc  =  rs1.getString(1);
					if ( strCustDesc== null || strCustDesc.equalsIgnoreCase("null")){
						strCustDesc="";}								
				}				
						rs1.close();
						pstmt.close();


				strPolicyDesc="";
				String sqlPolDesc="Select long_desc from bl_ins_policy_types_lang_vw where policy_type_code = '"+strPolicyTypeCode+"' and language_id = '"+locale+"' and Operating_facility_id = '"+strFacilityId+"' ";
//				System.out.println("sqlPolDesc :"+sqlPolDesc);
				pstmt = con.prepareStatement(sqlPolDesc);
				
				rs2 = pstmt.executeQuery();	
				while(rs2.next())
				{
					strPolicyDesc  =  rs2.getString(1);	
					if ( strPolicyDesc== null || strPolicyDesc.equalsIgnoreCase("null")){
						strPolicyDesc="";}								
				}				
						rs2.close();
						pstmt.close();

				strBlngDesc="";
				String sqlBlngDesc="select SHORT_DESC from BL_BLNG_GRP_LANG_VW where BLNG_GRP_ID ='"+strBlngGrpId+"' and language_id='"+locale+"' ";
//				System.out.println("sqlBlngDesc :"+sqlBlngDesc);
				pstmt = con.prepareStatement(sqlBlngDesc);						
				rs3 = pstmt.executeQuery();	
				while(rs3.next())
				{
					strBlngDesc  =  rs3.getString(1);	
					if ( strBlngDesc== null || strBlngDesc.equalsIgnoreCase("null")){
						strBlngDesc="";}								
				}				
						rs3.close();
						pstmt.close();


//							currVstId=strVisitId;
				strEncRegnDateTime = com.ehis.util.DateUtils.convertDate(strEncRegnDateTime,"DMYHMS","en",locale);
				strEffectiveFrom = com.ehis.util.DateUtils.convertDate(strEffectiveFrom,"DMY","en",locale);
				strEffectiveTo = com.ehis.util.DateUtils.convertDate(strEffectiveTo,"DMY","en",locale);

            _bw.write(_wl_block19Bytes, _wl_block19);
	
				if(!currEpiId.equals(prevEpiId))
				{
					rec_chk_flag="Y";
					if(rowflag==0)	rowflag=1;
					else			rowflag=0;

					if(j==2) rowflag=0;
					classval	=	"QRYODD";
//					if(rowflag==0)	classval	=	"QRYODD";
//					else			classval	=	"QRYEVEN";
							

            _bw.write(_wl_block20Bytes, _wl_block20);
														
				}
				if(strCustcode.equals("")) strCustcode="&nbsp;";
				if(strPriority.equals("")) strPriority="&nbsp;";
				if(strPolicyTypeCode.equals("")) strPolicyTypeCode="&nbsp;";
				if(strPolicyNum.equals("")) strPolicyNum="&nbsp;";
				if(strEffectiveFrom.equals("")) strEffectiveFrom="&nbsp;";
				if(strEffectiveTo.equals("")) strEffectiveTo="&nbsp;";
				if(strCustDesc.equals("")) strCustDesc="&nbsp;";
				if(strPolicyDesc.equals("")) strPolicyDesc="&nbsp;";
				if(strBlngDesc.equals("")) strBlngDesc="&nbsp;";


            _bw.write(_wl_block21Bytes, _wl_block21);

				if(rec_chk_flag.equals("Y"))
				{

            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(str_epi_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((strPolicyNum.equals("&nbsp;")?"":strPolicyNum)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(acctSeqNo));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strFacilityId));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strEpisodeType));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strEpisodeId));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strVisitId));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strEncRegnDateTime));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(strEncRegnDateTime));
            _bw.write(_wl_block28Bytes, _wl_block28);


					if(strVisitId!=null && !strVisitId.equals(""))
					{

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strEpisodeId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strVisitId));
            _bw.write(_wl_block31Bytes, _wl_block31);

					}
					else
					{

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strEpisodeId));
            _bw.write(_wl_block31Bytes, _wl_block31);

					}
				}
				else
				{

            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block34Bytes, _wl_block34);

				}

            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strBlngDesc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(strCustDesc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strPriority));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strPolicyDesc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(strPolicyNum));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(strEffectiveFrom));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(strEffectiveTo));
            _bw.write(_wl_block44Bytes, _wl_block44);
				//i++;			
 				prevEpiId = currEpiId;
				rec_chk_flag="N";
//				prevVstId = currVstId;

			}//while
			out.flush();
			}

            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(calling_module_id));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block48Bytes, _wl_block48);

		}
		catch(Exception ee)
		{
			System.out.println("Exception in qry" +ee); 
		}
	}
	catch(Exception eee)
	{
		System.out.println("Exception main"+ eee);
	}
	finally 
	{				
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
out.println(CommonBean.setForm (request ,"../../eBL/jsp/BLPreviousEncounterDtls.jsp",searched));
            _bw.write(_wl_block49Bytes, _wl_block49);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ENCOUNTER_FIN_DTLS.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EpisodeType.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterdate.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingGroup.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Payer.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_TYPE.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_NO.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EffectiveFrom.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EffectiveTo.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }
}
