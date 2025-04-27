package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.BLReportIdMapper;
import java.sql.*;
import webbeans.eCommon.*;
import java.net.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import blpatreg.*;
import com.ehis.util.*;
import java.util.*;
import eBL.BLPatRegChargesBean;
import ecis.utils.OnlineReport;
import ecis.utils.OnlineReports;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __blpatregvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLPatRegValidation.jsp", 1709114570009L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<script>\n/* Code commented by Karthik to move the Online Print module to asyncronous mode by Providing ajax Call*/\nfunction callAsyncOnlinePrint(){\t\n\tvar xmlStr=\"<root><report/></root>\";\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",\"../../eBL/jsp/BLAdhocDiscOnlineReport.jsp\",true);\n\txmlHttp.send(xmlDoc);\t\n}\n</script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<HTML>\n<HEAD>\n<script language=\'javascript\' src=\'../js/BLMPPatRegCharges.js\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\t\n</HEAD>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<body onLoad=\'\' onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" \t\t\t\t\t      \t\t\t\t\t  \t\t  onSelect=\"codeArrestThruSelect();\">\n\t\t<form name=\'view_enctr_bill_det\' id=\'view_enctr_bill_det\' method=\'post\' >\n\t\t<input type=\'hidden\' name=\'pat_reg_chrg_amt\' id=\'pat_reg_chrg_amt\' value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\t\n\t\t<input type=\'hidden\' name=\'pat_reg_chrg_pat_amt\' id=\'pat_reg_chrg_pat_amt\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\t\n\t\t<input type=\'hidden\' name=\'patregnchargeYN\' id=\'patregnchargeYN\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\t\n\t\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\t\n\t\t<input type=\'hidden\' name=\'cur_acct_seq_no\' id=\'cur_acct_seq_no\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\t\n\t\t<input type=\'hidden\' name=\'strPatRegServPanelInd\' id=\'strPatRegServPanelInd\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\t\n\t\t<input type=\'hidden\' name=\'strPatRegServPanelCode\' id=\'strPatRegServPanelCode\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\t\n\t\t<input type=\'hidden\' name=\'service_date\' id=\'service_date\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\t\n\t\t<input type=\'hidden\' name=\'bean_id\' id=\'bean_id\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\t\n\t\t<input type=\'hidden\' name=\'bean_name\' id=\'bean_name\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\t\n\t\t<input type=\'hidden\' name=\'blng_grp_id\' id=\'blng_grp_id\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\t\n\t\t<input type=\'hidden\' name=\'regn_charge_dur_enc_YN\' id=\'regn_charge_dur_enc_YN\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\t\n\t\t<input type=\'hidden\' name=\'step1\' id=\'step1\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\t\n</form>\n</body>\n</HTML>\n<script>\n\t\tvar patregnchargeYN=document.forms[0].patregnchargeYN.value;\n\t\tvar step1=document.forms[0].step1.value;\n\t\tif(patregnchargeYN==\'Y\' && step1==\'STEP_OTH\')\n\t\t{\n\t\t\t//test();\n\t\t}\n\t\t\n</script>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" \n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block5Bytes, _wl_block5);

 System.out.println("IINSIDE BLPatRegValidation.jsp");
	request.setCharacterEncoding("UTF-8");	
	Connection con				= null;
	//PreparedStatement pstmt		= null ;
	Statement stmt				= null;
//	CallableStatement call = null;
	ResultSet rs				= null;	//ResultSet rscurr = null;	
	HashMap<String,String> asyncPrinterAttrib=new HashMap<String,String> (); //Code added by Karthik to move the Online Print module to asyncronous mode
	int  blprintVal =0; //increment variable to maintain uniqueness while storing in session
	CallableStatement cstmt = null;//KDAH-CRF-0546
	try
	{
		con	=	ConnectionManager.getConnection(request);

		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");
		String bean_id = "BLPatRegChargesBean" ;
		String bean_name = "eBL.BLPatRegChargesBean";
		BLPatRegChargesBean bean			= (BLPatRegChargesBean)getBeanObject( bean_id, bean_name, request ) ;

		//int noofdecimal=2;
		
		String locale	= (String)session.getAttribute("LOCALE");	
		if(locale==null || locale.equals("")) locale="en";
		String facilityid = (String) session.getValue("facility_id");
		if (facilityid==null) facilityid = "";
		String	strloggeduser	=  (String) session.getValue("login_user");	
		if (strloggeduser==null) strloggeduser = "";

		String strclientip = p.getProperty("client_ip_address");
		if (strclientip==null) strclientip = "";

		String step1 = request.getParameter("step1");
		if (step1==null) step1 = "";

	//out.println("<script>setTimeout('funHealthScheme();',500);</script>");	
		String blng_grp_id="",cur_acct_seq_no="", service_date="";//cust_group_code="", cust_code="",   non_ins_blng_grp_id="",  non_ins_cust_group_code="", non_ins_cust_code="",
		//String strPatSerCode="";
		String regn_charge_YN="N", regn_charge_dur_enc_YN="N",  strPatRegServPanelInd="", strPatRegServPanelCode="", strPatRegServChargeAmt="" ;// error_level="", sys_message_id="", error_text="",strPatRegServPanelStr="",strPatRegServChargeAmt="",strPatRegServPanelQty="1";
		String strPatientId="";
		strPatientId=request.getParameter("patient_id") == null ? "" :request.getParameter("patient_id") ;
		//String proc_success="";
		//String charge_for_pat_regn_yn="Y";
		double pat_reg_chrg_amt=0;	double pat_reg_chrg_pat_amt=0;
		//String bill_gen_yn="", bill_doc_type="", bill_doc_number="", str_bill_gen_later="", str_total_bill_amt="";
		//String str_pat_reg_chrg_amt = "",str_pat_reg_chrg_pat_amt="";String slmt_ind="";
		//HashMap finDtls		= new HashMap();
	//	String  str_cust_group_code  ="",str_cust_code ="",priority ="",str_priority  ="",policy_number="", str_policy_number ="", policy_start_date="", str_policy_start_date ="",credit_auth_ref="", str_credit_auth_ref ="",credit_auth_date="", str_credit_auth_date="", effective_from ="",str_effective_from ="", effective_to ="", str_effective_to="", approved_amt ="",str_approved_amt="", approved_days ="", str_approved_days="", policy_type_code="",str_policy_type_code="",policy_expiry_date="",str_policy_expiry_date="";
		HashMap service_panel_Dtls		= new HashMap();

            _bw.write(_wl_block6Bytes, _wl_block6);

		try
		{
			String query_service_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI') from dual";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query_service_date) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					service_date = rs.getString(1);
				}
			}
			if(rs != null) rs.close();
			stmt.close();
		}
		catch(Exception e)
		{
			System.err.println("Exception in Sys Date :"+e);
		}
if(step1.equals("STEP_OTH")){
/*	bean.clearBean();	
	try{
		String pat_fin_det_sql="select SETTLEMENT_IND,NON_INS_BLNG_GRP_ID,blng_grp_id, non_ins_cust_group_code, non_ins_cust_code,cur_acct_seq_no  from bl_patient_fin_dtls   where patient_id ='"+strPatientId+"'";
		pstmt = con.prepareStatement(pat_fin_det_sql);
		rs = pstmt.executeQuery();	
		if( rs != null ) 
		{
			while( rs.next() )
			{  
				slmt_ind  =  rs.getString(1);
				non_ins_blng_grp_id  =  rs.getString(2);				
				blng_grp_id  =  rs.getString(3);
				non_ins_cust_group_code  =  rs.getString(4);
				non_ins_cust_code  =  rs.getString(5);
				cur_acct_seq_no  =  rs.getString(6);
				
			}
		}
		if(blng_grp_id == null) blng_grp_id="";
		if(slmt_ind == null) slmt_ind="";
		if(non_ins_blng_grp_id == null) non_ins_blng_grp_id="";
		pstmt.close();
		if(rs!=null) rs.close();
	}catch(Exception e)
		{
		System.err.println("Exception in  bl_patient_fin_dtls:"+e);
		}

	try{
		if(slmt_ind.equals("X") && !(non_ins_blng_grp_id.equals("")))
		{
			String pat_fin_det_sql="select CUST_GROUP_CODE,CUST_CODE,POLICY_TYPE_CODE,PRIORITY,POLICY_NUMBER,to_char(POLICY_START_DATE,'dd/mm/yyyy'),to_char(POLICY_EXPIRY_DATE,'dd/mm/yyyy'),CREDIT_AUTH_REF,to_char(CREDIT_AUTH_DATE,'dd/mm/yyyy'),to_char(EFFECTIVE_FROM,'dd/mm/yyyy'),to_char(EFFECTIVE_TO,'dd/mm/yyyy'),APPROVED_AMT,APPROVED_DAYS from BL_ENCOUNTER_PAYER_PRIORITY   where patient_id ='"+strPatientId+"' and EPISODE_TYPE='R' AND SETTLEMENT_IND='X'";

			pstmt = con.prepareStatement(pat_fin_det_sql);
			rs = pstmt.executeQuery();	
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					cust_group_code  =  rs.getString(1);					
					str_cust_group_code = str_cust_group_code+cust_group_code+"|";
					if(str_cust_group_code==null) str_cust_group_code="";	
					
					cust_code  =  rs.getString(2);
					str_cust_code = str_cust_code+cust_code+"|";
					if(str_cust_code==null) str_cust_code="";

					policy_type_code  =  rs.getString(3);
					str_policy_type_code = str_policy_type_code+cust_code+"|";
					if(str_policy_type_code==null) str_policy_type_code="";

					priority   =  rs.getString(4);
					str_priority = str_priority+priority+"|";
					if(str_priority==null) str_priority="";

					policy_number  =  rs.getString(5);
					str_policy_number = str_policy_number+policy_number+"|";
					if(str_policy_number==null) str_policy_number="";

					policy_start_date  =  rs.getString(6);
					str_policy_start_date = str_policy_start_date+policy_start_date+"|";
					if(str_policy_start_date==null) str_policy_start_date="";

					policy_expiry_date  =  rs.getString(7);
					str_policy_expiry_date = str_policy_expiry_date+policy_expiry_date+"|";
					if(str_policy_expiry_date==null) str_policy_expiry_date="";

					credit_auth_ref  =  rs.getString(8);
					str_credit_auth_ref = str_credit_auth_ref+credit_auth_ref+"|";
					if(str_credit_auth_ref==null) str_credit_auth_ref="";

					credit_auth_date  =  rs.getString(9);
					str_credit_auth_date = str_credit_auth_date+credit_auth_date+"|";
					if(str_credit_auth_date==null) str_credit_auth_date="";

					effective_from  =  rs.getString(10);
					str_effective_from = str_effective_from+effective_from+"|";
					if(str_effective_from==null) str_effective_from="";

					effective_to  =  rs.getString(11);
					str_effective_to = str_effective_to+effective_to+"|";
					if(str_effective_to==null) str_effective_to="";

					approved_amt  =  rs.getString(12);
					str_approved_amt = str_approved_amt+approved_amt+"|";
					if(str_approved_amt==null) str_approved_amt="";

					approved_days  =  rs.getString(13);
					str_approved_days = str_approved_days+approved_days+"|";
					if(str_approved_days==null) str_approved_days="";				
					
				}
			}
			
			pstmt.close();
			if(rs!=null) rs.close();

			
	}
	}catch(Exception e)
		{
		System.err.println("Exception in Procedure GETPATREGNSERVDTL:"+e);
		}
			finDtls.put("blng_grp_id",blng_grp_id);
			finDtls.put("str_cust_group_code",str_cust_group_code);
			finDtls.put("str_cust_code",str_cust_code);
			finDtls.put("str_policy_type_code",str_policy_type_code);
			finDtls.put("str_priority",str_priority);
			finDtls.put("str_policy_number",str_policy_number);
			finDtls.put("str_policy_start_date",str_policy_start_date);
			finDtls.put("str_policy_expiry_date",str_policy_expiry_date);
			finDtls.put("str_credit_auth_ref",str_credit_auth_ref);
			finDtls.put("str_credit_auth_date",str_credit_auth_date);
			finDtls.put("str_effective_from",str_effective_from);
			finDtls.put("str_effective_to",str_effective_to);
			finDtls.put("str_approved_amt",str_approved_amt);
			finDtls.put("str_approved_days",str_approved_days);
			finDtls.put("non_ins_blng_grp_id",non_ins_blng_grp_id);
			finDtls.put("non_ins_cust_group_code",non_ins_cust_group_code);
			finDtls.put("non_ins_cust_code",non_ins_cust_code);
			bean.setFinDtls(finDtls);
			HashMap finDtls_temp		= new HashMap();
			finDtls_temp = (HashMap)bean.getFinDtls();
		

		try{
			String strPatSerCode_qry="select PAT_SER_GRP_CODE from  mp_patient where PATIENT_ID='"+strPatientId+"'";		
			pstmt = con.prepareStatement(strPatSerCode_qry);
			rs = pstmt.executeQuery();	
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					strPatSerCode  =  rs.getString(1);	
				}
			}
			if(strPatSerCode == null) strPatSerCode="N";
			pstmt.close();
			if(rs!=null) rs.close();
		}catch(Exception e)
		{
			System.err.println("Exception in strPatSerCode"+e);
		}			

	try{	
		call = con.prepareCall("{ call BLPATIENTREGNCHARGE.GETPATREGNSERVDTL(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		call.setString(1,facilityid);
		call.setString(2,strPatSerCode);//P_pat_ser_grp_code
		call.setString(3,blng_grp_id);
		call.setString(4,cust_group_code);
		call.setString(5,cust_code);
		call.registerOutParameter(6,java.sql.Types.VARCHAR);
		call.registerOutParameter(7,java.sql.Types.VARCHAR);
		call.registerOutParameter(8,java.sql.Types.VARCHAR);
		call.registerOutParameter(9,java.sql.Types.VARCHAR);
		call.registerOutParameter(10,java.sql.Types.VARCHAR);
		call.registerOutParameter(11,java.sql.Types.VARCHAR);
		call.registerOutParameter(12,java.sql.Types.VARCHAR);
		call.registerOutParameter(13,java.sql.Types.VARCHAR);
		call.execute();
		regn_charge_YN = call.getString(6);
		if(regn_charge_YN == null) regn_charge_YN="N";

		regn_charge_dur_enc_YN = call.getString(7);
		if(regn_charge_dur_enc_YN == null) regn_charge_dur_enc_YN="N";

		strPatRegServPanelInd=call.getString(8);
		if(strPatRegServPanelInd==null) strPatRegServPanelInd="";
		strPatRegServPanelCode=call.getString(9);
		if(strPatRegServPanelCode==null) strPatRegServPanelCode="";

		error_level=call.getString(10);
		sys_message_id=call.getString(11);
		error_text=call.getString(12);

		if (error_level == null) error_level ="";
		if (sys_message_id ==null) sys_message_id ="";
		if (error_text ==null) error_text ="";

		call.close();
		
		if((!error_text.equals("") && error_level.equals("10")) || !sys_message_id.equals(""))
		{
			//strValidatedState = "E";	
			proc_success="N";
		}
		else
		{
			//strValidatedState = "Y";
			proc_success="Y";
		}
	}
	catch(Exception e)
	{
		proc_success="N";
		System.err.println("Exception in Procedure GETPATREGNSERVDTL:"+e);
	}
	if(regn_charge_dur_enc_YN.equals("N"))
	{
//		out.println("<script>close_det();</script>");
		out.println("<script>parent.window.returnValue = 'Y';parent.window.close();</script>");

	}
		String strEpisodeType="R";
		String strClinicCode="";
		String str_epi_type_clinic_code="";
		str_epi_type_clinic_code =strEpisodeType+"#"+strClinicCode;
		String 	str_ins_policy_type_code="",str_ins_cust_priority="", str_ins_policy_no ="",str_ins_policy_start_date="", str_ins_policy_expiry_date ="", str_ins_credit_auth_ref ="", str_ins_credit_auth_date ="",str_ins_policy_eff_from_date="", str_ins_policy_eff_to_date ="",str_ins_credit_approval_amount="", str_ins_credit_approval_days ="",str_non_ins_blng_grp="", str_non_ins_cust_group_code ="",str_non_ins_cust_code="",strNull="";
	if(proc_success.equals("Y") && charge_for_pat_regn_yn.equals("Y"))
		{
			try
			{				
				call = con.prepareCall("{ call BL_PROC_FOR_EXT_SERVICE_MP.GET_SERV_PANEL_DTLS(?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");	

							call.setString(1,facilityid);//facility_id
							call.setString(2,"MP");	//module_id
							call.setString(3,strNull); //key
							call.setString(4,strNull); //key_line_no
							call.setString(5,"R");//Episode_type
							call.setString(6,strPatientId);//patient_id
							call.setString(7,strNull);//strEpisodeId
							call.setString(8,strNull);
							call.setString(9,strNull);
							call.setString(10,cur_acct_seq_no);
							call.setString(11,service_date);//service_date
							call.setString(12,strNull);//item_code
							call.setString(13,strPatRegServPanelInd);//service_panel_ind
							call.setString(14,strPatRegServPanelCode);//service_panel_code
							call.setDouble(15,1);//service_qty
							call.setString(16,strNull);//charge_based_amt
							call.setString(17,strNull);//pract_staff_ind
							call.setString(18,strNull);//pract_staff_id
							call.setString(25,strNull);//excl_incl_action_ind
							call.setString(26,strNull);//action_reason_code
							call.setString(30,locale);//locale
							call.registerOutParameter(19,java.sql.Types.VARCHAR);
							call.registerOutParameter(20,java.sql.Types.VARCHAR);
							call.registerOutParameter(21,java.sql.Types.VARCHAR);
							call.registerOutParameter(22,java.sql.Types.VARCHAR);
							call.registerOutParameter(23,java.sql.Types.VARCHAR);
							call.registerOutParameter(24,java.sql.Types.VARCHAR);
							call.registerOutParameter(27,java.sql.Types.VARCHAR);
							call.registerOutParameter(28,java.sql.Types.VARCHAR);
							call.registerOutParameter(29,java.sql.Types.VARCHAR);	
							call.registerOutParameter(31,java.sql.Types.VARCHAR);
							call.registerOutParameter(32,java.sql.Types.VARCHAR);
							call.registerOutParameter(33,java.sql.Types.VARCHAR);
							call.execute();	
			
							strPatRegServPanelStr=call.getString(19);	
	
							if(strPatRegServPanelStr==null) strPatRegServPanelStr="";
	
							error_level=call.getString(31);
							sys_message_id=call.getString(32);
							error_text=call.getString(33);
	
							if (error_level == null) error_level ="";
							if (sys_message_id ==null) sys_message_id ="";
							if (error_text ==null) error_text ="";
	
	

				if((!error_text.equals("") && error_level.equals("10")) || !sys_message_id.equals(""))
				{
					//strValidatedState = "E";	
					proc_success="N";
				}
				else
				{
					//strValidatedState = "Y";
					proc_success="Y";
				}

				
			}catch(Exception e)
			{
				proc_success="N";
				System.err.println("Exception in Hospital:"+e);
			}
		}
		String str_bill_later_YN="Y";
		try
		{
		 if(proc_success.equals("Y")){
			String strPolicyTypeCode="", strPolicyPriority="",  strPolicyNumber="", strPolicyStartDate="", strPolicyExpiryDate="", strCreditAuthRef="", strCreditAuthDate="", strEffectiveFrom ="",strEffectiveTo ="",strApprovedAmt="", strApprovedDays="", strNonInsBlnggrpId ="",strNonInsCustGroupCode="", strNonInsCustCode =""; // service_date
			String sql="{call BLPatientRegnCharge.Main('C','VISIT_REGISTRATION','"+facilityid+"','MP','"+strPatientId+"','"+strPatSerCode+"','R','','"+strNull+"','"+strNull+"','"+blng_grp_id+"','"+cust_group_code+"','"+cust_code+"','"+strPolicyTypeCode+"','"+strPolicyPriority+"','"+strPolicyNumber+"','"+strPolicyStartDate+"','"+strPolicyExpiryDate+"','"+strCreditAuthRef+"','"+strCreditAuthDate+"','"+strEffectiveFrom+"','"+strEffectiveTo+"','"+strApprovedAmt+"','"+strApprovedDays+"','"+strNonInsBlnggrpId+"','"+strNonInsCustGroupCode+"','"+strNonInsCustCode+"','Y','"+strPatRegServPanelInd+"','"+strPatRegServPanelCode+"','"+strPatRegServPanelStr+"','"+strPatRegServPanelQty+"','"+strPatRegServChargeAmt+"','"+str_bill_later_YN+"','"+strloggeduser+"','"+strclientip+"','"+strclientip+"','"+strNull+"','"+strNull+"','"+locale+"',?,'"+strNull+"','"+strNull+"','"+strNull+"','"+strNull+"','"+strNull+"',?,?,?,?,?,?,?,?,?,?)}";

				call=con.prepareCall(sql);

				call.setString(1,"Y");

				call.registerOutParameter( 1, java.sql.Types.VARCHAR);		
				call.registerOutParameter( 2, java.sql.Types.VARCHAR);
				call.registerOutParameter( 3, java.sql.Types.VARCHAR);
				call.registerOutParameter( 4, java.sql.Types.VARCHAR);
				call.registerOutParameter( 5, java.sql.Types.VARCHAR);
				call.registerOutParameter( 6, java.sql.Types.VARCHAR);
				call.registerOutParameter( 7, java.sql.Types.VARCHAR);
				call.registerOutParameter( 8, java.sql.Types.VARCHAR);
				call.registerOutParameter( 9, java.sql.Types.VARCHAR);
				call.registerOutParameter( 10, java.sql.Types.VARCHAR);
				call.registerOutParameter( 11, java.sql.Types.VARCHAR);								

				call.execute();
				
				regn_charge_YN= call.getString(1);
				if(regn_charge_YN==null || regn_charge_YN.equals("")) regn_charge_YN="";


				pat_reg_chrg_amt= call.getDouble(2);
				pat_reg_chrg_pat_amt=call.getDouble(3);
				
				bill_gen_yn=call.getString(4);
				if(bill_gen_yn==null) bill_gen_yn="";
				bill_doc_type=call.getString(5);
				if(bill_doc_type==null) bill_doc_type="";
				bill_doc_number=call.getString(6);
				if(bill_doc_number==null) bill_doc_number="";
				str_bill_gen_later=call.getString(7);
				if(str_bill_gen_later==null || str_bill_gen_later.equals("")) str_bill_gen_later="";
				str_total_bill_amt=call.getString(8);
				if(str_total_bill_amt==null || str_total_bill_amt.equals("")) str_total_bill_amt="";


				error_level=call.getString(9);
				sys_message_id=call.getString(10);
				error_text=call.getString(11);
	
				call.close();
				
				if (error_level == null) error_level ="";
				if (sys_message_id ==null) sys_message_id ="";
				if (error_text ==null) error_text ="";


				if((!error_text.equals("") && error_level.equals("10")) || !sys_message_id.equals(""))
				{
				//	strValidatedState = "E";	
				proc_success="N";
				}
				else
				{
					//strValidatedState = "Y";
				}
		 }
		}catch(Exception e)
		{
			proc_success="N";
			System.err.println("Exception in BLVisitCharge:"+e);
		}
		
  
		 str_pat_reg_chrg_amt = Double.toString(pat_reg_chrg_amt);
		 str_pat_reg_chrg_pat_amt = Double.toString(pat_reg_chrg_pat_amt);

		bean.setTotPatPay(str_pat_reg_chrg_pat_amt);
		bean.setTotPay(str_pat_reg_chrg_pat_amt);
		bean.setPanelString(strPatRegServPanelStr);
	if(regn_charge_YN.equals("Y"))
	{		
	}else{
		out.println("<script>close_det();</script>");
	}
*/
} else if(step1.equals("STEP_BL")){
	try{
		String bean_id_from_bl=request.getParameter("bean_id") == null ? "" :request.getParameter("bean_id") ;
		String service_panel_ind=request.getParameter("service_panel_ind") == null ? "" :request.getParameter("service_panel_ind") ;
		String service_panel_code=request.getParameter("service_panel_code") == null ? "" :request.getParameter("service_panel_code") ;
		blng_grp_id=request.getParameter("blng_grp_id") == null ? "" :request.getParameter("blng_grp_id") ;
		strPatientId=request.getParameter("patient_id") == null ? "" :request.getParameter("patient_id") ;	
		String function_id = request.getParameter("function_id") == null ? "" :request.getParameter("function_id") ;
		String panel_str_frm_bl="";
		bean			= (BLPatRegChargesBean)getBeanObject( "BLPatRegChargesBean", "eBL.BLPatRegChargesBean", request ) ;
		if(bean!=null)
			{
				panel_str_frm_bl = (String) bean.getPanelString(); 				
				strPatRegServChargeAmt = (String) bean.getTotPay(); 				
			}
		service_panel_Dtls.put("service_panel_ind",service_panel_ind);
		service_panel_Dtls.put("service_panel_code",service_panel_code);
		service_panel_Dtls.put("panel_str_frm_bl",panel_str_frm_bl);
		service_panel_Dtls.put("facility_id",facilityid);
		service_panel_Dtls.put("patient_id",strPatientId);
		service_panel_Dtls.put("strloggeduser",strloggeduser);
		service_panel_Dtls.put("strclientip",strclientip);
		service_panel_Dtls.put("locale",locale);
		service_panel_Dtls.put("strPatRegServChargeAmt",strPatRegServChargeAmt);
		service_panel_Dtls.put("function_id",function_id);
		service_panel_Dtls.put("callFromAE","BL");

		BLMPRegCharges blmpRegCharges = new BLMPRegCharges();
		Hashtable resultsBL = blmpRegCharges.billPatientRegCharges(con, service_panel_Dtls);
		//boolean boolRes = ((Boolean) (resultsBL.get("status"))).booleanValue();						
		String doctype = (String) (resultsBL.get("billdoctype"));		
		String docnum = (String) (resultsBL.get("billdocnum"));		
		String genlater = (String) (resultsBL.get("billgenlater"));	
		String totalamt = (String) (resultsBL.get("billtotalamt"));		
		String error = (String) (resultsBL.get("error"));

		String str_bill_prt_format_YN = (String) resultsBL.get("bill_prt_format_YN");		
		if(str_bill_prt_format_YN == null || str_bill_prt_format_YN.equals("")) str_bill_prt_format_YN="N";

		if(!error.equals(""))
		{
			con.rollback();
			out.println("<script>chkError('"+error+"');</script>");
			out.println("<script>parent.window.returnValue='N';</script>");	
		}
		else
		{	
			con.commit();

			if(str_bill_prt_format_YN.equals("Y"))
			{
				
				//Added By Rajesh V - RUT-CRF0095
				String custId = BLReportIdMapper.getCustomerId();
				String strBlrblprt = "";
				System.err.println("cust Id->"+custId);
				//custId = "RUTNIN";
				System.err.println("Came to Bill BL Pat Reg Validation");
				if("RTN".equalsIgnoreCase(custId)){
					//String billTypeId = BLReportIdMapper.getBillType (ca, c ,called_module_id);
					strBlrblprt = BLReportIdMapper.getBlrBlPrtReportId(facilityid, "PH-BILL");
					System.err.println("strBlrblprt->"+strBlrblprt);
					if(strBlrblprt == null || "".equals(strBlrblprt)){
						strBlrblprt = "BLRBLPRT";
					}	
				}
				else{
					strBlrblprt = "BLRBLPRT";
				}
				//Added By Rajesh V - RUT-CRF0095
				
				
				//Added By Vijay For MMS-CRF-0208
				try{
					strBlrblprt=BLReportIdMapper.getReportId(con, locale,strBlrblprt, facilityid); //Added facilityid by subha for MMS-DM-CRF-131.1
					System.out.println("BLPatRegValidation for Report ID "+strBlrblprt);
					
				}catch(Exception e)
				{
					e.printStackTrace();
					System.err.println("Exception in BLPatRegValidation for reportID "+e);
				}
				
				
				
				
				//Added below code for GST-GHL-CRF-0477
				String gstApplicableYN = "N";
				String printOrientation = "P";
				PreparedStatement pstmtRpt = null;
				ResultSet rstMt = null;
				try{
						pstmtRpt = con.prepareStatement("Select bladdlchg.is_gst_applicable_yn('BL', 'BL_BILL_PRINT_ORIENTATION') gst_applicable from dual");
						rstMt = pstmtRpt.executeQuery();
						if(rstMt != null && rstMt.next()){
							gstApplicableYN = rstMt.getString("gst_applicable");
						}
					
					if("Y".equals(gstApplicableYN)){
					/*	String printOrientationSql = "Select NVL (default_bill_print_orientation, 'P') default_bill_print_orientation "+
													"FROM bl_parameters "+
													"WHERE operating_facility_id = ?";
						
						pstmtRpt = con.prepareStatement(printOrientationSql);
						pstmtRpt.setString(1, facilityid);
						rstMt = pstmtRpt.executeQuery();
						
						if(rstMt != null && rstMt.next()){
							printOrientation = rstMt.getString("default_bill_print_orientation");
						}
						*/
				//ADDED FOR KDAH-CRF-0546 on 15-May-20
				try{ 				
						cstmt = con.prepareCall("{ call BLCOMMON.get_report_id_for_3t(?,?,?,?) }");
						cstmt.setString(1,facilityid);
						cstmt.setString(2,"R");				
						cstmt.registerOutParameter(3,java.sql.Types.VARCHAR);
						cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);
						cstmt.execute();
						printOrientation = cstmt.getString(3);
						strBlrblprt = cstmt.getString(4);	
						System.out.println("582--printOrientation==>"+printOrientation);
						System.out.println("583--strBlrblprt==>"+strBlrblprt);
					}
					catch(Exception e){
						printOrientation = "P";
						System.err.println("Exception in getting BLPatRegValidation.jsp, 1"+e);
						e.printStackTrace();
					}
					finally{
						try
						{
							if (cstmt !=null) cstmt.close();
						}
						catch(Exception ee1) 
						{
							System.err.println("Exception in getting BLPatRegValidation.jsp, 2"+ee1);
							ee1.printStackTrace();
						}
					}
				//ADDED FOR KDAH-CRF-0546 on 15-May-20
					}
				}
				catch(Exception e){
					printOrientation = "P";
					System.err.println("Exception in getting printOrientation, 1"+e);
					e.printStackTrace();
				}
				finally{
					try
					{
						if(rstMt != null)  rstMt.close();	
						if (pstmtRpt !=null) pstmtRpt.close();
					}
					catch(Exception ee1) 
					{
						System.err.println("Exception in getting printOrientation, 2"+ee1);
						ee1.printStackTrace();
					}
				}
				if(("L".equals(printOrientation)) 
						&& ("BLRBLPRT".equals(strBlrblprt) || "BLRBLPRT_PH".equals(strBlrblprt))){
					strBlrblprt = "BLRBLPRL";
				}
				//Added below code for GST-GHL-CRF-0477
					String pgm_id = (String) resultsBL.get("pgm_id");	
					if(pgm_id == null) pgm_id="";
					String session_id = (String) resultsBL.get("session_id");	
					if(session_id == null) session_id="";
					String pgm_date = (String) resultsBL.get("pgm_date");	
					if(pgm_date == null) pgm_date="";
					String mpi_id_rep = (String) resultsBL.get("mpi_id_rep");	
					if(mpi_id_rep == null) mpi_id_rep="";
				
				/* Code commented by Karthik to move the Online Print module to asyncronous mode by Providing ajax Call - Starts*/
				asyncPrinterAttrib.put(pgm_id+"/"+session_id+"/"+pgm_date+"/"+mpi_id_rep+"/"+(blprintVal++), strBlrblprt);
				session.setAttribute("ASYNC_PRINTER_ATTRIB", asyncPrinterAttrib);	
				out.println("<script>callAsyncOnlinePrint();</script>");
				
				/* try
				{
					String pgm_id = (String) resultsBL.get("pgm_id");	
					if(pgm_id == null) pgm_id="";
					String session_id = (String) resultsBL.get("session_id");	
					if(session_id == null) session_id="";
					String pgm_date = (String) resultsBL.get("pgm_date");	
					if(pgm_date == null) pgm_date="";
					String mpi_id_rep = (String) resultsBL.get("mpi_id_rep");	
					if(mpi_id_rep == null) mpi_id_rep="";
					
				//Modified by muthukumar against Arabic Language change on 31-5-2012
				OnlineReport onlinereportParam = null;
				
						if(locale == "ar")
							{
							 onlinereportParam = new OnlineReport(facilityid, "BL", "BLRBLPRTAKAR");	
							}
							else
							{
							 onlinereportParam = new OnlineReport(facilityid, "BL", strBlrblprt);
							}
				//Modified by muthukumar against Arabic Language change on 31-5-2012
					//OnlineReport onlinereportParam = new OnlineReport(facilityid, "BL", "BLRBLPRT");
					onlinereportParam.addParameter("p_facility_id",facilityid);
					onlinereportParam.addParameter("p_pgm_date",pgm_date);
					onlinereportParam.addParameter("p_pgm_id",pgm_id);
					onlinereportParam.addParameter("p_Session_id",session_id);
					System.err.println("Online Report onlinereportParam:"+onlinereportParam);
					OnlineReports onlinereports = new OnlineReports();
					onlinereports.add(onlinereportParam);
					String strResults =  onlinereports.execute(request,response);

					onlinereportParam = null;
					onlinereports = null;								
				}
				catch (Exception e)
				{
					System.err.println("Error while submitting Print Job to Report Server:"+e);
				} */
			}
			String success_message = (String) (resultsBL.get("success_message"));				out.println("<script>callSlmtorDisc('"+facilityid+"','"+strPatientId+"','"+strloggeduser+"','"+strclientip+"','"+locale+"','"+doctype+"','"+docnum+"','"+genlater+"','"+totalamt+"','"+blng_grp_id+"','"+success_message+"');</script>");
			}

	}catch(Exception e )
		{ 
			System.err.println("exception STEP_BL:"+e);
		}
  }


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(pat_reg_chrg_amt));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(pat_reg_chrg_pat_amt));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(regn_charge_YN));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(cur_acct_seq_no));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strPatRegServPanelInd));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strPatRegServPanelCode));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(service_date));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(blng_grp_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(regn_charge_dur_enc_YN));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(step1));
            _bw.write(_wl_block20Bytes, _wl_block20);
putObjectInBean(bean_id,bean,request);
            _bw.write(_wl_block1Bytes, _wl_block1);


	}catch(Exception e )
		{ 
			System.err.println("exception PatRegValidation:"+e);
		}
		finally
		{	
		if(stmt != null)		stmt.close();
		ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block21Bytes, _wl_block21);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
