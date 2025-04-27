package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.ehis.util.*;
import java.util.*;
import java.sql.*;
import java.lang.*;
import java.net.*;
import java.text.*;
import eCommon.Common.*;
import org.json.simple.*;
import java.util.Map.Entry;
import java.util.Set;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import eBL.Common.*;
import eBL.*;
import eBL.resources.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.text.SimpleDateFormat;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __intermdraftreportvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/IntermDraftReportValidation.jsp", 1709114126068L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No        Version           Incident              SCF/CRF             Developer Name\n---------------------------------------------------------------------------------------\n1            V210112            7661\t     \t MOHE-CRF-0050.1         Ram kumar S\n2            V210226      15050,15117,15109\t MOHE-CRF-0050.1         Ram kumar S\n -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	Connection conDrftRprt = null;
	PreparedStatement pstmtDrftRprt = null ;
	ResultSet rsDrftRprt = null;
	PreparedStatement pstmtDischarge = null ;
	ResultSet rsDischarge = null;
	String CalledFor = request.getParameter("CalledFor");
	if(CalledFor.equals("popPayerName")){
	String locale = request.getParameter("locale");
	String payerCode = request.getParameter("payerCode");
	String popPayerNameQuery="select long_name "+
							 "from ar_customer_lang_vw "+
			                 "where language_id='"+locale+"' "+
			                 "AND CUST_cODE = '"+payerCode+"' ";
	String PayerName="";
	try
	{	
		conDrftRprt = ConnectionManager.getConnection(request);
		pstmtDrftRprt = conDrftRprt.prepareStatement(popPayerNameQuery);
		rsDrftRprt=pstmtDrftRprt.executeQuery();
		if( rsDrftRprt != null ) 
		{
		while(rsDrftRprt.next())
		{
			PayerName= rsDrftRprt.getString(1);
		}
		}else
		{ 
			rsDrftRprt.close();
		}
		out.println("~S~"+PayerName);
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.err.println("Exception while Retriving Payer Name :"+e);
		out.println("~E~"+e);
	}
	finally {
	    if (rsDrftRprt != null) {
	        try {
	        	rsDrftRprt.close();
	        } catch (SQLException eR) { eR.printStackTrace();/* ignored */}
	    }
	    if (pstmtDrftRprt != null) {
	        try {
	        	pstmtDrftRprt.close();
	        } catch (SQLException eP) { eP.printStackTrace();/* ignored */}
	    }
	    if (conDrftRprt != null) {
	        try {
	        	conDrftRprt.close();
	        } catch (SQLException eC) { eC.printStackTrace();/* ignored */}
	    }
	}
}
if(CalledFor.equals("reportPrintOption")){
	String facId = request.getParameter("facId");
	String reportPrintOptQuery="Select REPORT_TOOL_IND "+
		       				   "From   BL_DOC_PRINT_SETUP "+
		       				   "Where  operating_facility_id='"+facId+"' "+
		       				   "and    EXECUTABLE_NAME='BLRINTDR'";
	String reportType="";
	try
	{	
		conDrftRprt = ConnectionManager.getConnection(request);
		pstmtDrftRprt = conDrftRprt.prepareStatement(reportPrintOptQuery);
		rsDrftRprt=pstmtDrftRprt.executeQuery();
		if( rsDrftRprt != null ) 
		{
		while(rsDrftRprt.next())
		{
			reportType= rsDrftRprt.getString(1);
			
		}
		}else
		{ 
			rsDrftRprt.close();
		}
		if(reportType==null || reportType.equals(""))
			reportType="C";
		out.println("~S~"+reportType);
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.err.println("Exception while Retrieving Report Type :"+e);
		out.println("~E~"+e);
	}
	finally {
	    if (rsDrftRprt != null) {
	        try {
	        	rsDrftRprt.close();
	        } catch (SQLException eR) { eR.printStackTrace();/* ignored */}
	    }
	    if (pstmtDrftRprt != null) {
	        try {
	        	pstmtDrftRprt.close();
	        } catch (SQLException eP) { eP.printStackTrace();/* ignored */}
	    }
	    if (conDrftRprt != null) {
	        try {
	        	conDrftRprt.close();
	        } catch (SQLException eC) { eC.printStackTrace();/* ignored */}
	    }
	}
}
if(CalledFor.equals("searchPatient")){
try
	{	
	String facId = request.getParameter("facId");
	String reportType = request.getParameter("reportType");
	String option = request.getParameter("option");
	String frmWardCode = request.getParameter("frmWardCode");
	frmWardCode = frmWardCode == null ? "" : frmWardCode;	
	String toWardCode = request.getParameter("toWardCode");
	toWardCode = toWardCode == null ? "" : toWardCode;	
	String frmAdminCode = request.getParameter("frmAdminCode");
	frmAdminCode = frmAdminCode == null ? "" : frmAdminCode;	
	String toAdminCode = request.getParameter("toAdminCode");
	toAdminCode = toAdminCode == null ? "" : toAdminCode;	
	String payableType = request.getParameter("payableType");
	String Payer = request.getParameter("Payer");
	String billStageVal = request.getParameter("billStageVal");
	String PayerAmtExceed = request.getParameter("PayerAmtExceed");
	String frmServDate = request.getParameter("frmServDate");
	frmServDate = frmServDate == null ? "" : frmServDate;	
	String toServDate = request.getParameter("toServDate");
	toServDate = toServDate == null ? "" : toServDate;	
	String frmBillServGrp = request.getParameter("frmBillServGrp");
	frmBillServGrp = frmBillServGrp == null ? "" : frmBillServGrp;	
	String toBillServGrp = request.getParameter("toBillServGrp");
	toBillServGrp = toBillServGrp == null ? "" : toBillServGrp;	
	/*System.err.println("facility Id received "+facId);
	System.err.println("reportType received "+reportType);
	System.err.println("option received "+option);
	System.err.println("frmWardCode received "+frmWardCode);
	System.err.println("toWardCode received "+toWardCode);
	System.err.println("frmAdminCode received "+frmAdminCode);
	System.err.println("toAdminCode received "+toAdminCode);
	System.err.println("payableType received "+payableType);
	System.err.println("Payer received "+Payer);
	System.err.println("billStageVal received "+billStageVal);
	System.err.println("PayerAmtExceed received "+PayerAmtExceed);
	System.err.println("frmServDate received "+frmServDate);
	System.err.println("toServDate received "+toServDate);
	System.err.println("frmBillServGrp received "+frmBillServGrp);
	System.err.println("toBillServGrp received "+toBillServGrp);*/
	String SearchQuery="";
	if(option.equalsIgnoreCase("Y") || option.equalsIgnoreCase("N")){
		if(billStageVal.equalsIgnoreCase("1")){
			SearchQuery="SELECT a.facility_id, a.patient_id, patient_name, patient_name_loc_lang, "+
					"b.episode_type, open_episode_id, "+
					"a.admission_date_time admission_date_time, cur_ward_code, cur_room_num, "+
					"cur_bed_num, cur_bed_class_code, a.cust_code, a.policy_type_code, "+
					"c.inh_bill_gen_date, NVL (unbld_amt, 0) unbld_amt, "+
					"NVL (outst_amt, 0) outst_amt, "+
					"NVL (unbld_amt, 0) + NVL (outst_amt, 0) total, "+
					"DECODE (a.policy_type_code, "+
					"NULL, NVL (b.tot_unadj_dep_amt, 0), 0 "+
					") tot_unadj_dep_amt, "+
					"credit_doc_ref_desc, a.blng_grp_id, c.priority, a.cust_group_code "+
				    "FROM bl_unbld_outst_vw a, "+
					"bl_episode_fin_dtls b, "+
					"bl_encounter_payer_priority c "+
				    "WHERE a.facility_id = b.operating_facility_id "+
				    "AND a.open_episode_id = b.episode_id "+
				    "AND b.operating_facility_id = c.operating_facility_id "+
				    "AND b.episode_id = c.episode_id "+
				    "AND b.cur_acct_seq_no = c.acct_seq_no "+
				    "AND c.blng_grp_id = a.blng_grp_id "+
				    "AND NVL (a.cust_code, '!!!') = NVL (c.cust_code, '!!!') "+
				    "AND NVL (a.policy_type_code, '!!!') = NVL (c.policy_type_code, '!!!') "+
				    "AND facility_id = '"+facId+"' "+
				    "AND cur_ward_code BETWEEN NVL ('"+frmWardCode+"', '!!!!') "+
					"AND NVL ('"+toWardCode+"', '~~~~') "+
				    "AND open_episode_id BETWEEN NVL ('"+frmAdminCode+"', 0) "+
					"AND NVL ('"+toAdminCode+"', 999999999999) "+
				    "AND ((NVL ('"+payableType+"', 'I') = 'P' AND a.cust_code IS NULL) "+
					"OR (NVL ('"+payableType+"', 'I') = 'I' "+
					"AND a.cust_code IS NOT NULL "+
					"AND a.cust_code = NVL ('"+Payer+"', a.cust_code)) "+
					"OR (NVL ('"+payableType+"', 'I') = 'B')) "+
				    "AND NVL (unbld_amt, 0) + NVL (outst_amt, 0) >= "+
					"NVL (LTRIM (RTRIM ('"+PayerAmtExceed+"', ''), ''), "+
					"NVL (unbld_amt, 0) + NVL (outst_amt, 0)) "+
				    "AND (('N' = NVL ('"+option+"', 'N') "+
					"AND NOT EXISTS ( "+
					"SELECT 'x' "+
					"FROM ip_discharge_advice_his_vw b "+
					"WHERE facility_id = b.facility_id "+
					"AND open_episode_id = b.episode_id "+
					"AND NVL (dis_adv_status, ' ') != '9')) "+
					"OR ('Y' = NVL ('"+option+"', 'N') "+
					"AND EXISTS ( "+
					"SELECT 'x' "+
					"FROM ip_discharge_advice_his_vw b "+
					"WHERE facility_id = b.facility_id "+
					"AND open_episode_id = b.episode_id "+
					"AND NVL (dis_adv_status, ' ') != '9'))) "+
				    "AND bl_inter_rep_serv_grp_dt_fltr (b.patient_id, "+
					"b.episode_id, "+
					"NVL ('"+frmServDate+"', NULL), "+
					"NVL ('"+toServDate+"', NULL), "+
					"NVL ('"+frmBillServGrp+"', NULL), "+
					"NVL ('"+toBillServGrp+"', NULL) "+
					") = 'Y' "+
					"union all "+
				 	"SELECT  A.FACILITY_ID,A.PATIENT_ID,PATIENT_NAME,PATIENT_NAME_LOC_LANG,B.EPISODE_TYPE, "+
					"OPEN_EPISODE_ID,A.ADMISSION_DATE_TIME ADMISSION_DATE_TIME,CUR_WARD_CODE,CUR_ROOM_NUM, "+    
					"CUR_BED_NUM,CUR_BED_CLASS_CODE,    c.CUST_CODE, c.POLICY_TYPE_CODE,c.inh_bill_gen_date, "+   
					"0 UNBLD_AMT,0 OUTST_AMT,    0 TOTAL,  "+
					"decode(c.POLICY_TYPE_CODE,null,nvl(b.TOT_UNADJ_DEP_AMT,0),0) TOT_UNADJ_DEP_AMT,  "+
					"b.CREDIT_DOC_REF_DESC,c.BLNG_GRP_ID, c.priority, c.cust_group_code   "+
					"FROM IP_OPEN_EPISODE A,BL_EPISODE_FIN_DTLS B,BL_ENCOUNTER_PAYER_PRIORITY C ,MP_PATIENT D  "+
					"WHERE a.facility_id = b.operating_facility_id   "+
					"AND a.open_episode_id=b.episode_id   "+
					"AND b.operating_facility_id=c.operating_facility_id  "+
					"AND b.episode_id=c.episode_id  "+
					"AND b.cur_acct_seq_no=c.acct_seq_no   "+
					"and not exists  "+
					"(select 1 from BL_UNBLD_OUTST_VW e where e.open_episode_id = a.open_episode_id)  "+
					"AND a.patient_id = d.patient_id  "+
					"AND FACILITY_ID = '"+facId+"' "+
					"AND CUR_WARD_CODE  BETWEEN NVL('"+frmWardCode+"','!!!!')     "+                   
					"AND NVL('"+toWardCode+"','~~~~') AND         open_episode_id BETWEEN NVL('"+frmAdminCode+"',0) AND NVL('"+toAdminCode+"',999999999999)  "+
					"AND   ((NVL('"+payableType+"','I') = 'P' "+
					"AND c.CUST_CODE IS NULL) OR (NVL('"+payableType+"','I') = 'I'   "+
					"AND c.cust_code is not null   "+
					"AND c.CUST_CODE = NVL('"+Payer+"',c.CUST_CODE))    OR (NVL('"+payableType+"','I') = 'B'))  "+
					"AND (('N'= NVL('"+option+"','N')   "+
					"AND NOT EXISTS   "+
					"(SELECT 'x' FROM ip_discharge_advice_his_vw b   "+
					"WHERE facility_id = b.facility_id   "+
					"AND open_episode_id = b.episode_id   "+
					"AND NVL (dis_adv_status, ' ') != '9')) OR ('Y' = NVL('"+option+"','N')   "+
					"AND EXISTS   "+
					"(SELECT 'x' FROM ip_discharge_advice_his_vw b        "+           
					"WHERE facility_id = b.facility_id   "+
					"AND open_episode_id = b.episode_id   "+
					"AND NVL (dis_adv_status, ' ') != '9')))    "+
					"AND bl_inter_rep_serv_grp_dt_fltr (b.PATIENT_ID,b.EPISODE_ID,nvl('"+frmServDate+"',null),nvl('"+toServDate+"',null),nvl('"+frmBillServGrp+"',null),nvl('"+toBillServGrp+"',null)) = 'Y'";			
		}else if(billStageVal.equalsIgnoreCase("1")){
			SearchQuery="SELECT a.facility_id, a.patient_id, patient_name, patient_name_loc_lang, "+
			    "b.episode_type, open_episode_id, "+
			    "a.admission_date_time admission_date_time, cur_ward_code, cur_room_num, "+
			    "cur_bed_num, cur_bed_class_code, a.cust_code, a.policy_type_code, "+
			    "c.inh_bill_gen_date, NVL (unbld_amt, 0) unbld_amt, "+
			    "NVL (outst_amt, 0) outst_amt, "+
			    "NVL (unbld_amt, 0) + NVL (outst_amt, 0) total, "+
			    "DECODE (a.policy_type_code, NULL, NVL (b.tot_unadj_dep_amt, 0), 0) tot_unadj_dep_amt, "+
			    "credit_doc_ref_desc, a.blng_grp_id, c.priority, a.cust_group_code "+
		 	    "FROM bl_unbilled_outst_vw a, bl_episode_fin_dtls b, bl_encounter_payer_priority c "+
			    "WHERE a.facility_id = b.operating_facility_id "+
		   		"AND a.open_episode_id = b.episode_id "+
		   		"AND b.operating_facility_id = c.operating_facility_id "+
		   		"AND b.episode_id = c.episode_id "+
		  		"AND b.cur_acct_seq_no = c.acct_seq_no "+
		   		"AND c.blng_grp_id = a.blng_grp_id "+
		   		"AND NVL (a.cust_code, '!!!') = NVL (c.cust_code, '!!!') "+
		   		"AND NVL (a.policy_type_code, '!!!') = NVL (c.policy_type_code, '!!!') "+
		   		"AND facility_id = '"+facId+"' "+
		   		"AND cur_ward_code BETWEEN NVL ('"+frmWardCode+"', '!!!!') AND NVL ('"+toWardCode+"', '~~~~') "+
		  		"AND open_episode_id BETWEEN NVL ('"+frmAdminCode+"', 0) AND NVL ('"+toAdminCode+"', 999999999999) "+
		        "AND ((NVL ('"+payableType+"', 'I') = 'P' AND a.cust_code IS NULL) "+
				"OR ( NVL ('"+payableType+"', 'I') = 'I' "+
				"AND a.cust_code IS NOT NULL "+
				"AND a.cust_code = NVL ('"+Payer+"', a.cust_code)) "+
				"OR (NVL ('"+payableType+"', 'I') = 'B')) "+
		        "AND NVL (unbld_amt, 0) + NVL (outst_amt, 0) >= "+
				"NVL (LTRIM (RTRIM ('"+PayerAmtExceed+"', ''), ''), "+
				"NVL (unbld_amt, 0) + NVL (outst_amt, 0) ) "+
		        "AND (('N' = NVL ('"+option+"', 'N') "+
				"AND NOT EXISTS ( "+
				"SELECT 'x' "+
				"FROM ip_discharge_advice_his_vw b "+
				"WHERE facility_id = b.facility_id "+
				"AND open_episode_id = b.episode_id "+
				"AND NVL (dis_adv_status, ' ') != '9') ) "+
				"OR (    'Y' = NVL ('"+option+"', 'N') "+
				"AND EXISTS (SELECT 'x' "+
				"FROM ip_discharge_advice_his_vw b "+
				"WHERE facility_id = b.facility_id "+
				"AND open_episode_id = b.episode_id "+
				"AND NVL (dis_adv_status, ' ') != '9') )) "+
		        "AND bl_inter_rep_serv_grp_dt_fltr (b.patient_id, "+
				"b.episode_id, "+
				"NVL ('"+frmServDate+"', NULL), "+
				"NVL ('"+toServDate+"', NULL), "+
				"NVL ('"+frmBillServGrp+"', NULL), "+
				"NVL ('"+toBillServGrp+"', NULL) ) = 'Y' "+
				"union all "+
		 		"SELECT  A.FACILITY_ID,A.PATIENT_ID,PATIENT_NAME,PATIENT_NAME_LOC_LANG,B.EPISODE_TYPE, "+
				"A.EPISODE_ID,A.ADMISSION_DATE_TIME ADMISSION_DATE_TIME,CUR_WARD_CODE,CUR_ROOM_NUM, "+     
				"CUR_BED_NUM,CUR_BED_CLASS_CODE,    c.CUST_CODE, c.POLICY_TYPE_CODE,c.inh_bill_gen_date, "+     
				"0 UNBLD_AMT,0 OUTST_AMT,    0 TOTAL, "+ 
				"decode(c.POLICY_TYPE_CODE,null,nvl(b.TOT_UNADJ_DEP_AMT,0),0) TOT_UNADJ_DEP_AMT, "+ 
				"b.CREDIT_DOC_REF_DESC,c.BLNG_GRP_ID, c.priority, c.cust_group_code "+  
				"FROM   IP_EPISODE A,BL_EPISODE_FIN_DTLS B,BL_ENCOUNTER_PAYER_PRIORITY C ,MP_PATIENT D "+ 
				"WHERE  a.facility_id = b.operating_facility_id "+  
				"AND    a.episode_id=b.episode_id "+  
				"AND    b.operating_facility_id=c.operating_facility_id "+ 
				"AND    b.episode_id=c.episode_id  "+
				"AND    b.cur_acct_seq_no=c.acct_seq_no  "+ 
				"and not exists (select 1 from bl_unbilled_outst_vw e where e.open_episode_id = a.episode_id) "+ 
				"AND   a.patient_id = d.patient_id AND    FACILITY_ID = '"+facId+"' "+
				"AND         CUR_WARD_CODE  BETWEEN NVL('"+frmWardCode+"','!!!!') "+                       
				"AND NVL('"+toWardCode+"','~~~~') "+
				"AND A.episode_id BETWEEN NVL('"+frmAdminCode+"',0)  "+
				"AND NVL('"+toAdminCode+"',999999999999) "+
				"AND  ((NVL('"+payableType+"','I') = 'P'  "+
				"AND c.CUST_CODE IS NULL) OR (NVL('"+payableType+"','I') = 'I' "+ 
				"AND c.cust_code is not null  "+
				"AND  c.CUST_CODE = NVL('"+Payer+"',c.CUST_CODE)) OR (NVL('"+payableType+"','I') = 'B')) "+
				"AND    (('N'= NVL('"+option+"','N')  "+
				"AND NOT EXISTS (SELECT 'x' FROM ip_discharge_advice_his_vw b  "+
				"WHERE facility_id = b.facility_id  "+
				"AND A.episode_id = b.episode_id  "+
				"AND NVL (dis_adv_status, ' ') != '9')) OR ('Y' = NVL('"+option+"','N')  "+
				"AND EXISTS (SELECT 'x' FROM ip_discharge_advice_his_vw b  "+
				"WHERE facility_id = b.facility_id  "+
				"AND A.episode_id = b.episode_id  "+
				"AND NVL (dis_adv_status, ' ') != '9')))   "+
				"AND bl_inter_rep_serv_grp_dt_fltr (b.PATIENT_ID,b.EPISODE_ID,nvl('"+frmServDate+"',null),nvl('"+toServDate+"',null),nvl('"+frmBillServGrp+"',null),nvl('"+toBillServGrp+"',null)) = 'Y')";
		}else{
			if(reportType.equalsIgnoreCase("R")){
				SearchQuery="SELECT a.facility_id, a.patient_id, patient_name, patient_name_loc_lang, "+
						"b.episode_type, open_episode_id, "+
						"a.admission_date_time admission_date_time, cur_ward_code, "+
						"cur_room_num, cur_bed_num, cur_bed_class_code, a.cust_code, "+
						"a.policy_type_code, c.inh_bill_gen_date, NVL (unbld_amt, 0) unbld_amt, "+
						"NVL (outst_amt, 0) outst_amt, "+
						"NVL (unbld_amt, 0) + NVL (outst_amt, 0) total, "+
						"DECODE (a.policy_type_code,NULL, NVL (b.tot_unadj_dep_amt, 0),0) tot_unadj_dep_amt, "+
						"credit_doc_ref_desc, a.blng_grp_id, c.priority, a.cust_group_code "+
				   		"FROM bl_ip_disch_unbld_outst_vw a, "+
						"bl_episode_fin_dtls b, "+
						"bl_encounter_payer_priority c "+
				  		"WHERE a.facility_id = b.operating_facility_id "+
						"AND a.open_episode_id = b.episode_id "+
						"AND b.operating_facility_id = c.operating_facility_id "+
						"AND b.episode_id = c.episode_id "+
						"AND b.cur_acct_seq_no = c.acct_seq_no "+
						"AND NVL (a.cust_code, '!!!') = NVL (c.cust_code, '!!!') "+
						"AND NVL (a.policy_type_code, '!!!') = NVL (c.policy_type_code, '!!!') "+
						"AND facility_id = '"+facId+"' "+
						"AND cur_ward_code BETWEEN NVL ('"+frmWardCode+"', '!!!!') "+
						"AND NVL ('"+toWardCode+"', '~~~~') "+
						"AND open_episode_id BETWEEN NVL ('"+frmAdminCode+"', 0) "+
						"AND NVL ('"+toAdminCode+"', 999999999999) "+
						"AND ((NVL ('"+payableType+"', 'I') = 'P' AND a.cust_code IS NULL) "+
						"OR (NVL ('"+payableType+"', 'I') = 'I' "+
						"AND a.cust_code IS NOT NULL "+
						"AND a.cust_code = NVL ('"+Payer+"', a.cust_code)) "+
						"OR (NVL ('"+payableType+"', 'I') = 'B')) "+
						"AND NVL (unbld_amt, 0) + NVL (outst_amt, 0) >= "+
						"NVL (LTRIM (RTRIM ('"+PayerAmtExceed+"', ''), ''), "+
						"NVL (unbld_amt, 0) + NVL (outst_amt, 0)) "+
						"AND NVL ('"+option+"', 'N') = 'D' "+
						"AND bl_inter_rep_serv_grp_dt_fltr (b.patient_id,b.episode_id,NVL ('"+frmServDate+"', NULL), "+
						"NVL ('"+toServDate+"', NULL), "+
						"NVL ('"+frmBillServGrp+"', NULL), "+
						"NVL ('"+toBillServGrp+"', NULL)) = 'Y'";
			}
		}
	}
		System.out.println("SearchQuery in search Button  "+SearchQuery);
		conDrftRprt = ConnectionManager.getConnection(request);
		pstmtDrftRprt = conDrftRprt.prepareStatement(SearchQuery);
		rsDrftRprt=pstmtDrftRprt.executeQuery();
		String facilitId,patId,patName,episodeType,admissNo,admissDate,nurseUnit,rooM,custCode,beD,bedClass,unbilledAmt,unadjustAmt,outStandAmt,totalAmt,blngGrpId,creditDocRefDesc="";
		String disChrgeAdvStatus="No";
		String disChrgeAdvDate="";
		JSONArray patientArray = new JSONArray();
		if( rsDrftRprt != null ) 
		{
		while(rsDrftRprt.next())
		{
			JSONObject patientObj= new JSONObject();
			facilitId= rsDrftRprt.getString("FACILITY_ID");
			patId= rsDrftRprt.getString("PATIENT_ID");
			patName= rsDrftRprt.getString("PATIENT_NAME");
			episodeType= rsDrftRprt.getString("EPISODE_TYPE");
			admissNo= rsDrftRprt.getString("OPEN_EPISODE_ID");
			admissDate= rsDrftRprt.getString("ADMISSION_DATE_TIME");
			nurseUnit= rsDrftRprt.getString("CUR_WARD_CODE");
			rooM= rsDrftRprt.getString("CUR_ROOM_NUM");
			custCode= rsDrftRprt.getString("CUST_CODE");
			beD= rsDrftRprt.getString("CUR_BED_NUM");
			bedClass= rsDrftRprt.getString("CUR_BED_CLASS_CODE");
			unbilledAmt= rsDrftRprt.getString("UNBLD_AMT");
			unadjustAmt= rsDrftRprt.getString("TOT_UNADJ_DEP_AMT");
			outStandAmt= rsDrftRprt.getString("OUTST_AMT");
			totalAmt= rsDrftRprt.getString("TOTAL");
			blngGrpId=rsDrftRprt.getString("BLNG_GRP_ID");
			creditDocRefDesc=rsDrftRprt.getString("CREDIT_DOC_REF_DESC");
			
			String dischargeQuery="SELECT DIS_ADV_STATUS,DIS_ADV_DATE "+
			       " FROM   ip_discharge_advice_his_vw b "+ 
			       " WHERE facility_id ='"+facId+"' AND  b.episode_id='"+admissNo+"' AND NVL(dis_adv_status, ' ') != '9'";
			System.err.println("dischargeQuery "+dischargeQuery);
			pstmtDischarge = conDrftRprt.prepareStatement(dischargeQuery);
			rsDischarge=pstmtDischarge.executeQuery();
			if( rsDischarge != null ) 
			{
				while(rsDischarge.next())
				{
					disChrgeAdvStatus= rsDischarge.getString("DIS_ADV_STATUS");
					System.err.println("disChrgeAdvStatus "+disChrgeAdvStatus);
					disChrgeAdvDate= rsDischarge.getString("DIS_ADV_DATE");
					System.err.println("disChrgeAdvDate "+disChrgeAdvDate);
					if(disChrgeAdvStatus.equalsIgnoreCase("0") || disChrgeAdvStatus.equalsIgnoreCase("1")){
						disChrgeAdvStatus="Yes";
					}else{
						disChrgeAdvStatus="No";
						disChrgeAdvDate="";
					}
				}
			}else
			{ 
				rsDischarge.close();
			}
			if(facilitId==null || facilitId.equalsIgnoreCase("undefined"))
				facilitId="";
			patientObj.put("facilitId",facilitId);
			if(patId==null || patId.equalsIgnoreCase("undefined"))
				patId="";
			patientObj.put("patId",patId);
			if(patName==null || patName.equalsIgnoreCase("undefined"))
				patName="";
			patientObj.put("patName",patName);
			if(episodeType==null || episodeType.equalsIgnoreCase("undefined"))
				episodeType="";
			patientObj.put("episodeType",episodeType);
			if(admissNo==null || admissNo.equalsIgnoreCase("undefined"))
				admissNo="";
			patientObj.put("admissNo",admissNo);
			if(admissDate==null || admissDate.equalsIgnoreCase("undefined"))
				admissDate="";
			patientObj.put("admissDate",admissDate);
			if(nurseUnit==null || nurseUnit.equalsIgnoreCase("undefined"))
				nurseUnit="";
			patientObj.put("nurseUnit",nurseUnit);
			if(rooM==null || rooM.equalsIgnoreCase("undefined"))
				rooM="";
			patientObj.put("rooM",rooM);
			if(custCode==null || custCode.equalsIgnoreCase("undefined"))
				custCode="";
			patientObj.put("custCode",custCode);
			if(beD==null || beD.equalsIgnoreCase("undefined"))
				beD="";
			patientObj.put("beD",beD);
			if(bedClass==null || bedClass.equalsIgnoreCase("undefined"))
				bedClass="";
			patientObj.put("bedClass",bedClass);
			if(unbilledAmt==null || unbilledAmt.equalsIgnoreCase("undefined"))
				unbilledAmt="";
			patientObj.put("unbilledAmt",unbilledAmt);
			if(unadjustAmt==null || unadjustAmt.equalsIgnoreCase("undefined"))
				unadjustAmt="";
			patientObj.put("unadjustAmt",unadjustAmt);
			if(outStandAmt==null || outStandAmt.equalsIgnoreCase("undefined"))
				outStandAmt="";
			patientObj.put("outStandAmt",outStandAmt);
			if(totalAmt==null || totalAmt.equalsIgnoreCase("undefined"))
				totalAmt="";
			patientObj.put("totalAmt",totalAmt);
			if(disChrgeAdvStatus==null || disChrgeAdvStatus.equalsIgnoreCase("undefined"))
				disChrgeAdvStatus="";
			patientObj.put("disChrgeAdvStatus",disChrgeAdvStatus);
			if(disChrgeAdvDate==null || disChrgeAdvDate.equalsIgnoreCase("undefined"))
				disChrgeAdvDate="";
			patientObj.put("disChrgeAdvDate",disChrgeAdvDate);
			if(blngGrpId==null || blngGrpId.equalsIgnoreCase("undefined"))
				blngGrpId="";
			patientObj.put("blngGrpId",blngGrpId);
			if(creditDocRefDesc==null || creditDocRefDesc.equalsIgnoreCase("undefined"))
				creditDocRefDesc="";
			patientObj.put("creditDocRefDesc",creditDocRefDesc);
			patientArray.add(patientObj);
				
		}
		}else
		{ 
			rsDrftRprt.close();
		}
		System.err.println("Returning patientArray values in search Query"+patientArray);
		out.println("~S~"+patientArray);
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.err.println("Exception while Retrieving Report Type :"+e);
		out.println("~E~"+e);
	}
	finally {
	    if (rsDrftRprt != null) {
	        try {
	        	rsDrftRprt.close();
	        } catch (SQLException eR) { eR.printStackTrace();/* ignored */}
	    }
	    if (pstmtDrftRprt != null) {
	        try {
	        	pstmtDrftRprt.close();
	        } catch (SQLException eP) { eP.printStackTrace();/* ignored */}
	    }
	    if (conDrftRprt != null) {
	        try {
	        	conDrftRprt.close();
	        } catch (SQLException eC) { eC.printStackTrace();/* ignored */}
	    }
	}
	
}
if(CalledFor.equals("prcsBedCharge")){
	try
	{	
	String patient_Id = request.getParameter("patient_Id");
	String episodeType = request.getParameter("episodeType");
	String episodeId = request.getParameter("episodeId");
	String admissionDate = request.getParameter("admissionDate");
	String facility_id = request.getParameter("facId");
	String wsNo = request.getParameter("wsNo");
	String userId = request.getParameter("userId");
	System.err.println("patient_Id Received :"+patient_Id);
	System.err.println("episodeType Received :"+episodeType);
	System.err.println("episodeId Received :"+episodeId);
	System.err.println("admissionDate Received :"+admissionDate);
	if(admissionDate.indexOf(".") !=-1){
		admissionDate=admissionDate.substring(0, admissionDate.indexOf("."));
	}
	System.err.println("admissionDate Received after SubStr:"+admissionDate);
	System.err.println("facility_id Received :"+facility_id);
	System.err.println("wsNo Received :"+wsNo);
	System.err.println("userId Received :"+userId);
	String processBedChargeCall = "{ call bl_reports.process_bed_charge ('"+facility_id+"','"+patient_Id+"','"+episodeType+"','"+episodeId+"',to_date('"+admissionDate+"','YYYY-MM-DD HH24:MI:SS'),'"+userId+"','"+wsNo+"',?,?,?) }";
	System.err.println("processBedChargeCall  "+processBedChargeCall);
	conDrftRprt = ConnectionManager.getConnection(request);
	CallableStatement callPrcssBedChrge = conDrftRprt.prepareCall(processBedChargeCall);		
	callPrcssBedChrge.registerOutParameter(1,java.sql.Types.VARCHAR);		
	callPrcssBedChrge.registerOutParameter(2,java.sql.Types.VARCHAR);		
	callPrcssBedChrge.registerOutParameter(3,java.sql.Types.VARCHAR);
	callPrcssBedChrge.execute();
	String errId = callPrcssBedChrge.getString(1) == null ? "" : callPrcssBedChrge.getString(1);
	String erroCode =callPrcssBedChrge.getString(2) == null ? "" : callPrcssBedChrge.getString(2);
	String errorText = callPrcssBedChrge.getString(3) == null ? "" : callPrcssBedChrge.getString(3);
	System.err.println("Response errId  "+errId);
	System.err.println("Response erroCode  "+erroCode);
	System.err.println("Response errorText  "+errorText);
	//V210226 Starts 
	if(!errId.equals("") || !erroCode.equals("") || !errorText.equals("")){
		out.println("~E~"+errId+"~"+erroCode+"~"+errorText);
	}else{
		out.println("~S~"+errId+"~"+erroCode+"~"+errorText);	
	}
	// V210226 Ends
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.err.println("Exception while Retrieving Report Type :"+e);
		out.println("~E~"+e);
	}
	finally {
	    if (rsDrftRprt != null) {
	        try {
	        	rsDrftRprt.close();
	        } catch (SQLException eR) { eR.printStackTrace();/* ignored */}
	    }
	    if (pstmtDrftRprt != null) {
	        try {
	        	pstmtDrftRprt.close();
	        } catch (SQLException eP) { eP.printStackTrace();/* ignored */}
	    }
	    if (conDrftRprt != null) {
	        try {
	        	conDrftRprt.close();
	        } catch (SQLException eC) { eC.printStackTrace();/* ignored */}
	    }
	}
}
if(CalledFor.equals("reCalculate")){
	try
	{	
	String patient_Id = request.getParameter("patient_Id");
	String episodeType = request.getParameter("episodeType");
	String episodeId = request.getParameter("episodeId");
	String facility_id = request.getParameter("facId");
	String wsNo = request.getParameter("wsNo");
	String userId = request.getParameter("userId");
	System.err.println("patient_Id Received :"+patient_Id);
	System.err.println("episodeType Received :"+episodeType);
	System.err.println("episodeId Received :"+episodeId);
	System.err.println("facility_id Received :"+facility_id);
	System.err.println("wsNo Received :"+wsNo);
	System.err.println("userId Received :"+userId);
	String reCalCall = "{ call bl_reports.recalculate_charge_idr('"+facility_id+"','"+patient_Id+"','"+episodeType+"','"+episodeId+"','"+wsNo+"','"+userId+"',?,?,?) }";
	System.err.println("reCalCall  "+reCalCall);
	conDrftRprt = ConnectionManager.getConnection(request);
	CallableStatement callRecalculate = conDrftRprt.prepareCall(reCalCall);		
	callRecalculate.registerOutParameter(1,java.sql.Types.VARCHAR);		
	callRecalculate.registerOutParameter(2,java.sql.Types.VARCHAR);		
	callRecalculate.registerOutParameter(3,java.sql.Types.VARCHAR);
	callRecalculate.execute();
	String errId = callRecalculate.getString(1) == null ? "" : callRecalculate.getString(1);
	String erroCode =callRecalculate.getString(2) == null ? "" : callRecalculate.getString(2);
	String errorText = callRecalculate.getString(3) == null ? "" : callRecalculate.getString(3);
	System.err.println("Response errId  "+errId);
	System.err.println("Response erroCode  "+erroCode);
	System.err.println("Response errorText  "+errorText);
	//V210226 Starts
	if(!errId.equals("") || !erroCode.equals("") || !errorText.equals("")){
		out.println("~E~"+errId+"~"+erroCode+"~"+errorText);	
	}else{
		out.println("~S~"+errId+"~"+erroCode+"~"+errorText);	
	}
	//V210226 Ends
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.err.println("Exception while Retrieving Report Type :"+e);
		out.println("~E~"+e);
	}
	finally {
	    if (rsDrftRprt != null) {
	        try {
	        	rsDrftRprt.close();
	        } catch (SQLException eR) { eR.printStackTrace();}
	    }
	    if (pstmtDrftRprt != null) {
	        try {
	        	pstmtDrftRprt.close();
	        } catch (SQLException eP) { eP.printStackTrace();}
	    }
	    if (conDrftRprt != null) {
	        try {
	        	conDrftRprt.close();
	        } catch (SQLException eC) { eC.printStackTrace();}
	    }
	}
}
if(CalledFor.equals("reportGeneration")){
	try{
		String reportId = request.getParameter("p_report_id");
		String facility_id = request.getParameter("facId");
		String param1 = request.getParameter("param1");
		String param2 = request.getParameter("param2");
		String param3 = request.getParameter("param3");
		String param4 = request.getParameter("param4");
		String param5 = request.getParameter("param5");
		String param6 = request.getParameter("param6");
		String param7 = request.getParameter("param7");
		String param8 = request.getParameter("param8");
		String param9 = request.getParameter("param9");
		String param10 = request.getParameter("param10");
		String param11 = request.getParameter("param11");
		String param12 = request.getParameter("param12");
		String param13 = request.getParameter("param13");
		String param14 = request.getParameter("param14");
		String param15 = request.getParameter("param15");
		String param16 = request.getParameter("param16");
		String param17 = request.getParameter("param17");
		String param18 = request.getParameter("param18");
		String param19 = request.getParameter("param19");
		String param20 = request.getParameter("param20");
		String param21 = request.getParameter("param21");
		String param22 = request.getParameter("param22");			
		String param23 = request.getParameter("param23");
		String param24 = request.getParameter("param24");
		String param25 = request.getParameter("param25");
		String param26 = request.getParameter("param26");
		String param27 = request.getParameter("param27");
		String param28 = request.getParameter("param28");
		String param29 = request.getParameter("param29");
		String param30 = request.getParameter("param30");
		
		
		
		String functionalityQuery="SELECT COUNT (*) AS FUNCTION_COUNT FROM sm_function_control a, sm_site_param b "+
		          "WHERE a.site_id = b.customer_id AND module_id = 'BL' AND functionality_id = 'ARABIC_REPORT_PRINT'";
		int funCount=0;
		String AR_REP_Print="";
		String langId="";
		String langIdFinal="";
		String reportIdFinal="";
		conDrftRprt = ConnectionManager.getConnection(request);
		conDrftRprt.setAutoCommit(false);
		pstmtDrftRprt = conDrftRprt.prepareStatement(functionalityQuery);
		rsDrftRprt=pstmtDrftRprt.executeQuery();
		if(rsDrftRprt!=null){
			while(rsDrftRprt.next()){
				funCount=Integer.parseInt(rsDrftRprt.getString("FUNCTION_COUNT"));
			}
		}
		rsDrftRprt.close();
		pstmtDrftRprt.close();
		if(funCount>0){
			AR_REP_Print="Y";
		}else{
			AR_REP_Print="N";
		}
		if(AR_REP_Print.equals("N")){
			langId="E";
		}else{
			if(param8.equalsIgnoreCase("en")){
				langId="E";
			}else if(param8.equalsIgnoreCase("ar")){
				langId="A";
			}
		}
		
		if(param8.equalsIgnoreCase("ar") && AR_REP_Print.equals("N")){
			reportIdFinal="BLRBLPRTAKAR"; 
		}else if(AR_REP_Print.equals("Y") && langId.equals("A")){
			reportIdFinal="BLRBLPRT_ALMOAR";
			langIdFinal="ar";
		}else{
			reportIdFinal="BLRBLPRT";
			langIdFinal=param8;
		}
		
		int session_id = 0;
		String pgm_date = "";
		String insertSql = BlRepository.getBlKeyValue("INSERT_SY_PROG_PARAM");
		CallableStatement callReportGn = conDrftRprt.prepareCall(insertSql);
		callReportGn.setString(1, facility_id);
		callReportGn.setString(2, reportIdFinal);
		callReportGn.registerOutParameter(3, Types.INTEGER);
		callReportGn.registerOutParameter(4, Types.VARCHAR);
		callReportGn.setString(5, param1);
		callReportGn.setString(6, param2);
		callReportGn.setString(7, param3);
		callReportGn.setString(8, param4);
		callReportGn.setString(9, param5);
		callReportGn.setString(10, param6);
		callReportGn.setString(11, param7);
		callReportGn.setString(12, langIdFinal);
		callReportGn.setString(13, param9);
		callReportGn.setString(14, param10);
		callReportGn.setString(15, param11);
		callReportGn.setString(16, param12);
		callReportGn.setString(17, param13);
		callReportGn.setString(18, param14);
		callReportGn.setString(19, param15);
		callReportGn.setString(20, param16);
		callReportGn.setString(21, param17);
		callReportGn.setString(22, param18);
		callReportGn.setString(23, param19);
		callReportGn.setString(24, param20);
		callReportGn.setString(25, param21);
		callReportGn.setString(26, param22);
		callReportGn.setString(27, param23);
		callReportGn.setString(28, param24);
		callReportGn.setString(29, param25);
		callReportGn.setString(30, param26);
		callReportGn.setString(31, param27);
		callReportGn.setString(32, param28);
		callReportGn.setString(33, param29);
		callReportGn.setString(34, param30);
		callReportGn.execute();
		
		session_id = callReportGn.getInt(3);
		pgm_date = callReportGn.getString(4);
		callReportGn = null;
		
		//Calling fetch_from_sy_2
		String data=request.getParameter("data");
		JSONParser parser = new JSONParser();
		JSONArray array = (JSONArray)parser.parse(data);
		for(int n = 0; n < array.size(); n++)
		{
		    JSONObject object = (JSONObject)array.get(n);
			String fetchSql ="{ CALL  bl_reports.fetch_from_sy_2 ( '"+facility_id+"','"+AR_REP_Print+"','"+langId+"','"+session_id+"','"+pgm_date+"','"+object.get("patId")+"','"+object.get("episodeType")+"',"+
			" '"+object.get("episodeId")+"', '"+object.get("custCode")+"','"+object.get("custDocRefDesc")+"','"+object.get("blngGrp")+"',?,?,?)}";
			System.err.println("fetchSql:::"+fetchSql);
			CallableStatement callReportFt = conDrftRprt.prepareCall(fetchSql);		
			callReportFt.registerOutParameter(1,java.sql.Types.VARCHAR);		
			callReportFt.registerOutParameter(2,java.sql.Types.VARCHAR);		
			callReportFt.registerOutParameter(3,java.sql.Types.VARCHAR);
			callReportFt.execute();
			String errCode = callReportFt.getString(1) == null ? "" : callReportFt.getString(1);
			String errLevel =callReportFt.getString(2) == null ? "" : callReportFt.getString(2);
			String errorText = callReportFt.getString(3) == null ? "" : callReportFt.getString(3);
		}

		conDrftRprt.commit();
		out.println("~S~"+session_id+":::"+pgm_date+":::"+reportIdFinal);
	}
	catch(Exception e)
	{
		System.err.println("Exception while Inserting report Values in Sy_Prog_Param :"+e);
		e.printStackTrace();
		out.println("~E~"+e);
	}
	finally {
	    if (rsDrftRprt != null) {
	        try {
	        	rsDrftRprt.close();
	        } catch (SQLException eR) { eR.printStackTrace();}
	    }
	    if (pstmtDrftRprt != null) {
	        try {
	        	pstmtDrftRprt.close();
	        } catch (SQLException eP) { eP.printStackTrace();}
	    }
	    if (conDrftRprt != null) {
	        try {
	        	conDrftRprt.close();
	        } catch (SQLException eC) { eC.printStackTrace();}
	    }
	}
}
if(CalledFor.equals("backJobCheck")){
	try{
		String facId = request.getParameter("facId");
		String frmEpisodeId = request.getParameter("frmEpisodeId");
		String toEpisodeId = request.getParameter("toEpisodeId");
		System.err.println("Facility Id in BackJob Check "+facId);
		System.err.println("frmEpisode Id in BackJob Check "+frmEpisodeId);
		System.err.println("toEpisode Id in BackJob Check "+toEpisodeId);
		String backJobCkhQuery = "select bl_reports.check_background_jobs('"+facId+"','"+frmEpisodeId+"','"+toEpisodeId+"') xMsg from dual";
		System.err.println("backJobCkhQuery  "+backJobCkhQuery);
		conDrftRprt = ConnectionManager.getConnection(request);
		pstmtDrftRprt = conDrftRprt.prepareStatement(backJobCkhQuery);
		rsDrftRprt = pstmtDrftRprt.executeQuery();
		String xMsg ="";
	  	while(rsDrftRprt!= null && rsDrftRprt.next()){
	  		 xMsg = rsDrftRprt.getString("xMsg") == null ? "" : rsDrftRprt.getString("xMsg");
        }
		out.println("~S~"+xMsg);
	}catch(Exception e)
	{
		System.err.println("Exception while Checking BackJob :"+e);
		e.printStackTrace();
		out.println("~E~"+e);
	}
	finally {
	    if (rsDrftRprt != null) {
	        try {
	        	rsDrftRprt.close();
	        } catch (SQLException eR) { eR.printStackTrace();}
	    }
	    if (pstmtDrftRprt != null) {
	        try {
	        	pstmtDrftRprt.close();
	        } catch (SQLException eP) { eP.printStackTrace();}
	    }
	    if (conDrftRprt != null) {
	        try {
	        	conDrftRprt.close();
	        } catch (SQLException eC) { eC.printStackTrace();}
	    }
	}
}

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
