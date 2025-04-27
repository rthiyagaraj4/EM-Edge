package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.BLReportIdMapper;
import java.sql.Date;
import eBL.*;
import eBL.Common.*;
import java.sql.*;
import java.math.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import org.apache.commons.codec.binary.Base64;
import java.util.*;
import com.ehis.util.*;

public final class __blzatcaresponsesearchresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLZatcaResponseSearchResult.jsp", 1742753752586L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\"javascript\" src=\"../../eBL/js/BLZatcaResponse.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script language=\'javascript\' src=\'../../eBL/js/json2.js\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<form name=\'searchresult\' id=\'searchresult\' id=\'searchresult\' method=\'post\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\t\n\t<table border=\"2\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\' class=\"grid\">\n\t<tr>\n\t\t<th class=\'columnheadercenter\' width=\'2%\'><input type=\'checkbox\' id=\'selectAll\' name=\'selectAll\' id=\'selectAll\' value = \'N\' onClick=\"selectAllRec(this);\"></th>\n\t\t<td class=\'columnheadercenter\' width=\'10%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t<td class=\'columnheadercenter\' width=\'10%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t<td class=\'columnheadercenter\' width=\'20%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t<td class=\'columnheadercenter\' width=\'5%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\t\t\n\t\t<th class=\'columnheadercenter\' width=\'10%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t<td class=\'columnheadercenter\' width=\'8%\'>EM ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t<td class=\'columnheadercenter\' width=\'10%\'>Bill Date and time</td>\t\t\n\t\t<td class=\'columnheadercenter\' width=\'8%\'>Active Bill</td>\n\t\t<td class=\'columnheadercenter\' width=\'8%\'>Original Bill Reference Number</td>\n\t\t<td class=\'columnheadercenter\' width=\'15%\'>Comments / ZATCA Response</td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t<tr>\n\t<td nowrap class=\"QRYODD\"><input type=\'checkbox\' id=\'selectedIndex_";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' name=\'selectedIndex_";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' value = \'N\' onClick=\"setValue(this);\"></td>\n\t<td nowrap class=\"QRYODD\">&nbsp;";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t<td nowrap class=\"QRYODD\">&nbsp;";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\n\t<input type=\'hidden\' name=\'rowIndex_";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' id=\'rowIndex_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t<input type=\'hidden\' name=\'doc_type_code_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' id=\'doc_type_code_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t<input type=\'hidden\' name=\'doc_num_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' id=\'doc_num_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t<input type=\'hidden\' name=\'oper_fac_id_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' id=\'oper_fac_id_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t<input type=\'hidden\' name=\'ACTIVE_FLAG_YN_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' id=\'ACTIVE_FLAG_YN_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\t\n\n\t</tr>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\t\t\n\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t<input type=\'hidden\' name=\'episode_type\' id=\'episode_type\' id=\'episode_type\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' id=\'encounter_id\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t<input type=\'hidden\' name=\'payer_group\' id=\'payer_group\' id=\'payer_group\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t<input type=\'hidden\' name=\'payer\' id=\'payer\' id=\'payer\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t<input type=\'hidden\' name=\'encounter_from_date_str\' id=\'encounter_from_date_str\' id=\'encounter_from_date_str\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t<input type=\'hidden\' name=\'encounter_to_date_str\' id=\'encounter_to_date_str\' id=\'encounter_to_date_str\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t<input type=\'hidden\' name=\'zatcaStatus\' id=\'zatcaStatus\' id=\'zatcaStatus\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t<input type=\'hidden\' name=\'totalRecords\' id=\'totalRecords\' id=\'totalRecords\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t<input type=\'hidden\' name=\'params\' id=\'params\' id=\'params\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\t\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t<script>\t\n\t\tsetTimeout(function(){alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"))}, 100);\n\t</script>\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t<script>\t\n\t\tparent.frames[1].document.getElementById(\'resendToZatca\').disabled = false;\n\t</script>\n</form>\n</table>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t<script>\t\n\t\tparent.frames[1].document.getElementById(\'resendToZatca\').disabled = true;\n\t</script>\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	System.err.println("Inside BLZatcaResponseSearchResult.jsp");
	Connection con = null; 
	PreparedStatement pstmt = null;
	int maxRecord = 0;
	ResultSet rset = null;	

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	
 	int totalRecord =0;
	String facility_id = (String) session.getValue("facility_id");
	if(facility_id == null) facility_id = "";
	
	String locale = (String)session.getAttribute("LOCALE");
	if(locale == null) locale = "en";
	
	String params = request.getParameter("params");
	if(params == null) params = "";
	
	String patient_id = request.getParameter("patientId");
	if(patient_id == null) patient_id = "";
	
	String patient_name = request.getParameter("patient_name");
	if(patient_name == null) patient_name = "";
	
	String gender = request.getParameter("gender");
	if(gender == null) gender = "";
	
	String dob = request.getParameter("dob");
	if(dob == null) dob = "";	
	
	String visit_date = request.getParameter("visit_date");
	if(visit_date == null) visit_date = "";
	
	String encounter_id = request.getParameter("encounterId");	
	if(encounter_id == null) encounter_id = "";
	
	String payer_group = request.getParameter("payerGroup");
	if(payer_group == null) payer_group = "";
	
	String payer = request.getParameter("payer");
	if(payer == null) payer = "";
	
	String encounter_from_date_str = request.getParameter("encounterFromDate");
	if(encounter_from_date_str == null) encounter_from_date_str = "";
	
	String encounter_to_date_str = request.getParameter("encounterToDate");
	if(encounter_to_date_str == null) encounter_to_date_str = "";
	
	String zatcaStatus = request.getParameter("zatcaStatus");
	if(zatcaStatus == null) zatcaStatus = "";
	
	String episode_type = request.getParameter("episodeType");
	if(episode_type == null) episode_type = "";
	
	if("A".equals(episode_type)){
		episode_type = "";
	}
	
	String active_bill_YN = request.getParameter("active_bill_YN");
	if(active_bill_YN == null) active_bill_YN = "Y";	

	String sql_zatca_resp = "", sql_zatca_addl_cond = "";

	try
	{
 		con = ConnectionManager.getConnection(request);
	
		sql_zatca_resp = "SELECT  a.operating_facility_id operating_facility_id,a.doc_type_code doc_type_code,a.doc_num doc_num,"+
						 " to_char(b.doc_date,'DD/MM/YYYY HH:MI:SS') bill_date, b.patient_id patient_id,b.episode_id,b.visit_id, d.encounter_id encounter_id,"+ 
						 " c.patient_name patient_name, DECODE(c.sex,'M','Male','F','Female','Unknown') gender, "+
						 " to_char(c.date_of_birth,'DD/MM/YYYY') DOB,b.org_bill_ref_num  org_bill_doc_ref, "+
						 " a.error_mesg zatca_remarks, a.ERROR_CODE ERROR_CODE, to_char(trunc(D.VISIT_ADM_DATE_TIME),'DD/MM/YYYY') visit_date, "+
						 " (a.DOC_TYPE_CODE||'/'||a.DOC_NUM) bill_number, DECODE(NVL(ACTIVE_FLAG_YN,'Y'),'Y','Yes','N','No','Yes') ACTIVE_FLAG_YN_DESC, NVL(ACTIVE_FLAG_YN,'Y') ACTIVE_FLAG_YN "+
						 " FROM BL_BILL_XML_QR_INFO a, BL_BILL_HDR b, MP_PATIENT C, PR_ENCOUNTER D "+
						 " WHERE a.operating_facility_id = b.operating_Facility_id "+
						 " AND a.doc_type_code = b.doc_type_code "+
						 " AND a.doc_num = b.doc_num  "+
						 " AND b.patient_id = c.patient_id  "+
						 " AND a.operating_Facility_id = d.facility_id  "+
						 " and b.EPISODE_ID = D.EPISODE_ID "+
						 " AND trunc(D.VISIT_ADM_DATE_TIME) between to_date('"+encounter_from_date_str+"','DD/MM/YYYY') and to_date('"+encounter_to_date_str+"','DD/MM/YYYY')" +
						 " AND a.ACTIVE_FLAG_YN = '"+active_bill_YN+"'";
						 
		if(!"".equals(zatcaStatus)){
			sql_zatca_resp = sql_zatca_resp + " AND a.error_code = '"+ zatcaStatus +"'";
		}
		
		if("O".equals(episode_type) || "E".equals(episode_type))
			sql_zatca_resp = sql_zatca_resp + " and b.visit_id = d.OP_EPISODE_VISIT_NUM ";
		if(!"".equals(patient_id))
			sql_zatca_addl_cond = sql_zatca_addl_cond + " AND b.patient_id = '" + patient_id+"'";
		
		if(!"".equals(episode_type))
			sql_zatca_addl_cond = sql_zatca_addl_cond + " AND b.EPISODE_TYPE = '" + episode_type+"'";
		
		if(!"".equals(encounter_id))
			sql_zatca_addl_cond = sql_zatca_addl_cond + " AND d.encounter_id = '" + encounter_id+"'";
		
		if(!"".equals(payer_group))
			sql_zatca_addl_cond = sql_zatca_addl_cond + " AND B.CUST_GROUP_CODE = DECODE('" + payer_group+"', '**', B.CUST_GROUP_CODE, '" + payer_group+"')";	

		if(!"".equals(payer))
			sql_zatca_addl_cond = sql_zatca_addl_cond + " AND B.CUST_CODE = DECODE('" + payer +"', '**', B.CUST_CODE, '" + payer +"')";	

		if(!"".equals(sql_zatca_resp))
			sql_zatca_resp = sql_zatca_resp + sql_zatca_addl_cond;
						 
		System.err.println("sql_zatca_resp final:"+sql_zatca_resp);
		
		pstmt = con.prepareStatement(sql_zatca_resp);
		rset = pstmt.executeQuery();


            _bw.write(_wl_block8Bytes, _wl_block8);
	
	int totalRecords = 0;
	if(rset != null){
		

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

			while(rset.next()){

				totalRecords++;
				String rec_oper_fac_id = rset.getString("operating_facility_id");
				String rec_patient_id = rset.getString("patient_id");
				String rec_encounter_id = rset.getString("encounter_id");
				String rec_patient_name = rset.getString("patient_name");
				String rec_gender = rset.getString("gender");
				String rec_DOB = rset.getString("DOB");
				String rec_visit_date = rset.getString("visit_date");
				String rec_bill_number = rset.getString("bill_number");
				String rec_bill_date = rset.getString("bill_date");
				String rec_doc_type_code = rset.getString("doc_type_code");
				String rec_doc_num = rset.getString("doc_num");
				String rec_org_bill_doc_ref = rset.getString("org_bill_doc_ref");
				if(rec_org_bill_doc_ref == null) rec_org_bill_doc_ref = "";
				String rec_zatca_remarks = rset.getString("zatca_remarks");
				String ACTIVE_FLAG_YN = rset.getString("ACTIVE_FLAG_YN");
				String ACTIVE_FLAG_YN_DESC = rset.getString("ACTIVE_FLAG_YN_DESC");
				if(rec_zatca_remarks == null) rec_zatca_remarks = "";
				String rec_ERROR_CODE = rset.getString("ERROR_CODE");
				
	
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rec_patient_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rec_encounter_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rec_patient_name));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rec_gender));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rec_DOB));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rec_visit_date));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rec_bill_number));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rec_bill_date));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(ACTIVE_FLAG_YN_DESC));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rec_org_bill_doc_ref));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rec_zatca_remarks));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rec_doc_type_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rec_doc_num));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rec_oper_fac_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ACTIVE_FLAG_YN));
            _bw.write(_wl_block31Bytes, _wl_block31);

			}
		}

            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(payer_group));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(payer));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(encounter_from_date_str));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(encounter_to_date_str));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(zatcaStatus));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(params));
            _bw.write(_wl_block44Bytes, _wl_block44);
		
		if(totalRecords==0){

            _bw.write(_wl_block45Bytes, _wl_block45);
		}
		else
		{
			if("E".equals(zatcaStatus)){

            _bw.write(_wl_block46Bytes, _wl_block46);
		
			}else{

            _bw.write(_wl_block47Bytes, _wl_block47);
				
			}
		}
	}
	catch(Exception e){
		System.err.println("Exception in BLChargePatientSearchResult.jsp is ->"+e);
		e.printStackTrace();
	}
	finally{
		ConnectionManager.returnConnection(con);
	}

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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DateofBirth.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitDate.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BillNumber.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
