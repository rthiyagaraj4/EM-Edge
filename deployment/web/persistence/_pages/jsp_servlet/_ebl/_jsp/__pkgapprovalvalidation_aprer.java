package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Enumeration;
import eBL.Common.*;
import eBL.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __pkgapprovalvalidation_aprer extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/PkgApprovalValidation_APRER.jsp", 1709114129052L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

	String bean_id		= "PkgApprovalBean" ;
	String bean_name	= "eBL.PkgApprovalBean";
	PkgApprovalBean bean			= (PkgApprovalBean)getBeanObject( bean_id, bean_name, request ) ;

	try 
	{
		request.setCharacterEncoding("UTF-8");

		String locale			= (String)session.getAttribute("LOCALE");
		//String facility_id			= (String)session.getAttribute("facility_id");
		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
	    hash						= (Hashtable)hash.get( "SEARCH" ) ;	
		bean.setLanguageId(locale);		
		String	func_mode	= request.getParameter( "func_mode" );	
		String	form_name	= (String) hash.get( "form_name" );		
		System.out.println("$$$$ func_mode:"+func_mode);
	
		if(func_mode != null && func_mode.equals("saveToBean" ) )
		{
			ArrayList payer=new ArrayList();
			payer=(ArrayList)bean.getDetails();
			HashMap hdrDtls=new HashMap();
			HashMap authDtls=new HashMap();
			HashMap pkgApprovals=new HashMap();
			if(payer!=null && payer.size()>0){
				hdrDtls=	(HashMap)payer.get(0);
				authDtls=	(HashMap)payer.get(1);
				pkgApprovals=	(HashMap)payer.get(2);
			}
			if(form_name != null && form_name.equals("PkgDtls" ) )
			{
				//String	credit_auth_ref		= (String)hash.get( "credit_auth_ref" );	
				String	appr_seq_no		= (String)hash.get( "appr_seq_no" );	
			/*	if(credit_auth_ref!=null && !credit_auth_ref.equals(""))
				credit_auth_ref=credit_auth_ref.trim();
				if(credit_auth_ref!=null && !credit_auth_ref.equals(""))
				*/ //commented for IN 20964
				if(appr_seq_no!=null && !appr_seq_no.equals(""))// changed for IN 20964
				appr_seq_no=appr_seq_no.trim();// changed for IN 20964
				if(appr_seq_no!=null && !appr_seq_no.equals(""))// changed for IN 20964
				{
					ArrayList  creditPkgApprovals=new ArrayList();
					String	total_records		=	(String) hash.get( "total_records" );
					ArrayList record;
					int totalRec				=	Integer.parseInt(total_records);
					String pkg_code = "";
					for(int i=0;i<totalRec; i++)
					{
					   pkg_code = (String) hash.get( "pkg_code"+i );
					   if(pkg_code!=null && !pkg_code.equals(""))
					   {
							record=new ArrayList();
							record.add((String)hash.get( "pkg_seq_no"+i ));
							record.add((String)hash.get( "pkg_code"+i ));
							record.add((String)hash.get( "pkg_desc"+i ));
							record.add((String)hash.get( "aprv_amt"+i ));
							record.add((String)hash.get( "pkg_disc_type"+i ));
							record.add((String)hash.get( "pkg_disc_amt"+i ));
							record.add((String)hash.get( "pkg_disc_reason"+i ));
							record.add((String)hash.get( "pkg_disc_reason_desc"+i ));
							creditPkgApprovals.add(record);
							record=null;	
					   }
					}
			//		if(pkgApprovals!=null && (pkgApprovals.size()>0) && pkgApprovals.containsKey(credit_auth_ref))// commented for IN 20964
					if(pkgApprovals!=null && (pkgApprovals.size()>0) && pkgApprovals.containsKey(appr_seq_no))// changed for IN 20964
					{
						//pkgApprovals.remove(credit_auth_ref);// commented for IN 20964
						pkgApprovals.remove(appr_seq_no);// changed for IN 20964
					}
				//	pkgApprovals.put(credit_auth_ref,creditPkgApprovals);// commented for IN 20964
					pkgApprovals.put(appr_seq_no,creditPkgApprovals);// commented for IN 20964

					payer=new ArrayList();
					payer.add(hdrDtls);
					payer.add(authDtls);
					payer.add(pkgApprovals);
					bean.setDetails(payer);
				}
			}
			else if(form_name != null && form_name.equals("PayerDtls" ) )
			{
				authDtls=new HashMap();
				String	total_records		=	(String) hash.get( "total_records" );
				ArrayList record;
				int totalRec				=	Integer.parseInt(total_records);
				String appr_seq_no = "";// added for IN 20964
				String credit_apprd_amt = "";// added for IN 20964
	
				for(int i=0;i<totalRec; i++)
				{
					appr_seq_no = (String) hash.get( "appr_seq_no"+i );
					if(appr_seq_no!=null && !appr_seq_no.equals(""))
						appr_seq_no=appr_seq_no.trim();
					credit_apprd_amt = (String) hash.get( "credit_apprd_amt"+i );
					if(credit_apprd_amt!=null && !credit_apprd_amt.equals(""))
						credit_apprd_amt=credit_apprd_amt.trim();
				   if(appr_seq_no!=null && !appr_seq_no.equals("") && credit_apprd_amt!=null && !credit_apprd_amt.equals(""))
				   {
						/** addded for IN 20964***end****/
						record=new ArrayList();
						record.add((String)hash.get( "appr_seq_no"+i ));// added for IN 20964
						record.add((String)hash.get( "credit_auth_ref"+i ));
						record.add((String)hash.get( "credit_auth_date"+i ));
						record.add(credit_apprd_amt);
						record.add((String)hash.get( "credit_apprd_days"+i ));
						record.add((String)hash.get( "pkg_dtls_yn"+i ));
						record.add((String)hash.get( "pol_validity_chk_date"+i ));
						//if(authDtls!=null && authDtls.size()>0 && authDtls.containsKey(credit_auth_ref))// commented for IN 20964
						if(authDtls!=null && authDtls.size()>0 && authDtls.containsKey(appr_seq_no))// changed for IN 20964
						{	
							//authDtls.remove(credit_auth_ref);// commented for IN 20964
							authDtls.remove(appr_seq_no);// changed for IN 20964
						}
						//authDtls.put(credit_auth_ref,record);		// commented for IN 20964	
						authDtls.put(appr_seq_no,record);		// commented for IN 20964	
						record=null;				
				   }	
				}
				payer=new ArrayList();
				payer.add(hdrDtls);
				payer.add(authDtls);
				payer.add(pkgApprovals);
				bean.setDetails(payer);		
			}	
		}	
		else if(func_mode != null && func_mode.equals("removeFromBean" ) )
		{
			String	blng_grp_code	= (String) hash.get( "blng_grp_code" );	
			String	payer_grp_code	= (String) hash.get( "payer_grp_code" );	
			String	payer_code	= (String) hash.get( "payer_code" );	
			String	policy_type_code	= (String) hash.get( "policy_type_code" );	
			String	policy_no	= (String) hash.get( "policy_no" );	
			String	policy_eff_frm_date	= (String) hash.get( "policy_eff_frm_date" );	
			String	priority	= (String) hash.get( "priority" );	
			String mapKey=blng_grp_code.trim()+"~~"+payer_grp_code.trim()+"~~"+payer_code.trim()+"~~"+priority.trim()+"~~"+policy_type_code.trim()+"~~"+policy_no.trim()+"~~"+policy_eff_frm_date.trim();
			HashMap payerDtls=(HashMap)bean.getPayerDtls();
			ArrayList payer=new ArrayList();		
			HashMap hdrDtls=new HashMap();
			HashMap authDtls=new HashMap();
			HashMap pkgApprovals=new HashMap();
			String	appr_seq_no		= (String) hash.get( "appr_seq_no" );	//added for IN 20964
			
			if(appr_seq_no!=null && !appr_seq_no.equals(""))
				appr_seq_no=appr_seq_no.trim();//added for IN 20964
			if(appr_seq_no==null || appr_seq_no.equals(""))//changed for  IN 20964
			{
				if(payerDtls!=null && (payerDtls.size()>0) && payerDtls.containsKey(mapKey))		
					payerDtls.remove(mapKey);	
				bean.setPayerDtls(payerDtls);
			}
			else
			{		
				payer=(ArrayList)bean.getDetails();
				if(payer!=null && payer.size()>0)
				{
					hdrDtls=	(HashMap)payer.get(0);
					authDtls=	(HashMap)payer.get(1);
					pkgApprovals=	(HashMap)payer.get(2);
				}		
				if(authDtls!=null && authDtls.size()>0 && authDtls.containsKey(appr_seq_no))
				{
					authDtls.remove(appr_seq_no);////changed for  IN 20964
				}	
				if(pkgApprovals!=null && (pkgApprovals.size()>0) && pkgApprovals.containsKey(appr_seq_no))//changed for  IN 20964
				{
					pkgApprovals.remove(appr_seq_no);//changed for  IN 20964
				}			
				payer=new ArrayList();
				payer.add(hdrDtls);
				payer.add(authDtls);
				payer.add(pkgApprovals);				
				bean.setDetails(payer);
			}				
		}
		else if(func_mode != null && func_mode.equals("renameBeanKey" ) )
		{
			String	oldMapKey	= (String) hash.get( "oldMapKey" );	
			String	currMapKey	= (String) hash.get( "currMapKey" );			
			ArrayList payer=new ArrayList();
			if(!oldMapKey.equals(currMapKey))
			{	
				HashMap payerDtls=(HashMap)bean.getPayerDtls();
				if(payerDtls!=null && payerDtls.size()>0 && payerDtls.containsKey(oldMapKey))
				{	
					payer=(ArrayList)payerDtls.get(oldMapKey);			
					payerDtls.put(currMapKey,payer);
					payerDtls.remove(oldMapKey);
				}
				bean.setPayerDtls(payerDtls);
			}
		}
		else if(func_mode!= null && func_mode.equals("hdrVals"))
		{
			String 	appr_seq_no=(String)hash.get( "appr_seq_no" );
			if(appr_seq_no!=null && !appr_seq_no.equals(""))
				appr_seq_no=appr_seq_no.trim();
			String 	credit_auth_ref=(String)hash.get( "credit_auth_ref" );
			if(credit_auth_ref!=null && !credit_auth_ref.equals(""))
				credit_auth_ref=credit_auth_ref.trim();
			String 	credit_apprd_amt=(String)hash.get( "credit_apprd_amt" );
			if(credit_apprd_amt!=null && !credit_apprd_amt.equals(""))
				credit_apprd_amt=credit_apprd_amt.trim();
			String apprd_amt_restrict_check =(String)hash.get( "apprd_amt_restrict_check" );
			if(apprd_amt_restrict_check!=null && !apprd_amt_restrict_check.equals(""))
				apprd_amt_restrict_check=apprd_amt_restrict_check.trim();
			
			if((credit_apprd_amt!=null && !credit_apprd_amt.equals("") && apprd_amt_restrict_check.equals("R")) || (credit_apprd_amt==null || credit_apprd_amt.equals("") && apprd_amt_restrict_check.equals("U")))
			{
				
				String mapKey=((String)hash.get( "blng_grp_code" )).trim()+"~~"+((String)hash.get( "ins_cust_group_code" )).trim()+"~~"+((String)hash.get( "cust_3" )).trim()+"~~"+((String)hash.get( "priority" )).trim()+"~~"+((String)hash.get( "policy_type_code" )).trim()+"~~"+((String)hash.get( "policy_no" )).trim()+"~~"+((String)hash.get( "policy_eff_frm_date" )).trim();
				HashMap payerDtls=(HashMap)bean.getPayerDtls();
				ArrayList payer=new ArrayList();
				payer=(ArrayList)bean.getDetails();
				HashMap hdrDtls=new HashMap();
				HashMap authDtls=new HashMap();
				HashMap pkgApprovals=new HashMap();
				
				if((payer==null || payer.size()==0) && payerDtls!=null && payerDtls.size()>0 && payerDtls.containsKey(mapKey))
					payer=(ArrayList)payerDtls.get(mapKey);
				if(payer!=null && payer.size()>0){
					hdrDtls=	(HashMap)payer.get(0);
					authDtls=	(HashMap)payer.get(1);
					pkgApprovals=	(HashMap)payer.get(2);
				}		
				HashMap hdrVals=new HashMap();
				ArrayList oldRecord=new ArrayList();	
				ArrayList record=new ArrayList();	
				hdrVals.put("billing_group_desc",(String)hash.get( "billing_group_desc" ));
				hdrVals.put("blng_grp_code",(String)hash.get( "blng_grp_code" ));
				hdrVals.put("payer_desc",(String)hash.get( "payer_desc" ));
				hdrVals.put("cust_3",(String)hash.get( "cust_3" ));
				hdrVals.put("priority",(String)hash.get( "priority" ));
				hdrVals.put("policy_type_desc",(String)hash.get( "policy_type_desc" ));
				hdrVals.put("policy_type_code",(String)hash.get( "policy_type_code" ));
				hdrVals.put("policy_no",(String)hash.get( "policy_no" ));
				hdrVals.put("policy_start_date",(String)hash.get( "policy_start_date" ));
				hdrVals.put("policy_exp_date",(String)hash.get( "policy_exp_date" ));
				
				hdrVals.put("credit_auth_ref",credit_auth_ref);
				hdrVals.put("credit_auth_date",(String)hash.get( "credit_auth_date" ));
				hdrVals.put("credit_apprd_amt",(String)hash.get( "credit_apprd_amt" ));
				hdrVals.put("credit_apprd_days",(String)hash.get( "credit_apprd_days" ));
				hdrVals.put("policy_eff_frm_date",(String)hash.get( "policy_eff_frm_date" ));
				hdrVals.put("policy_eff_to_date",(String)hash.get( "policy_eff_to_date" ));
				hdrVals.put("adj_rule_ind",(String)hash.get( "adj_rule_ind" ));
				hdrVals.put("adj_perc_amt_ind",(String)hash.get( "adj_perc_amt_ind" ));
				hdrVals.put("adj_perc_amt_value",(String)hash.get( "adj_perc_amt_value" ));
				hdrVals.put("pmnt_diff_adj_int",(String)hash.get( "pmnt_diff_adj_int" ));
				hdrVals.put("drg_pmnt_diff_adj_int",(String)hash.get( "drg_pmnt_diff_adj_int" ));
				hdrVals.put("spl_srv_pmnt_diff_adj_int",(String)hash.get( "spl_srv_pmnt_diff_adj_int" ));
				hdrVals.put("restrict_check",(String)hash.get( "restrict_check" ));
				hdrVals.put("valid_payer_YN",(String)hash.get( "valid_payer_YN" ));
				hdrVals.put("valid_policy_type_code_YN",(String)hash.get( "valid_policy_type_code_YN" ));
				hdrVals.put("ins_cust_group_code",(String)hash.get( "ins_cust_group_code" ));
				hdrVals.put("policy_coverage_basis_ind",(String)hash.get( "policy_coverage_basis_ind" ));
				hdrVals.put("referral_source_main_code",(String)hash.get( "referral_source_main_code" ));
				hdrVals.put("referral_source_main_desc",(String)hash.get( "referral_source_main_desc" ));
				hdrVals.put("referral_source_sub_code",(String)hash.get( "referral_source_sub_code" ));
				hdrVals.put("referral_source_sub_desc",(String)hash.get( "referral_source_sub_desc" ));
				hdrVals.put("apprd_amt_restrict_check",(String)hash.get( "apprd_amt_restrict_check" ));
				hdrVals.put("apprd_days_restrict_check",(String)hash.get( "apprd_days_restrict_check" ));
				hdrVals.put("cred_auth_req_yn",(String)hash.get( "cred_auth_req_yn" ));
				hdrVals.put("dflt_auth_ref_as_pol_no_yn",(String)hash.get( "dflt_auth_ref_as_pol_no_yn" ));
				hdrVals.put("cust_valid_from_date",(String)hash.get( "cust_valid_from_date" ));
				hdrVals.put("cust_valid_to_date",(String)hash.get( "cust_valid_to_date" ));
				hdrVals.put("ins_cust_group_name",(String)hash.get( "ins_cust_group_name" ));
				hdrVals.put("pol_validity_chk_date",(String)hash.get( "pol_validity_chk_date" ));	
				 if((authDtls==null || authDtls.size()==0) && (pkgApprovals==null || pkgApprovals.size()==0) )	{
					record=new ArrayList();
					record.add(appr_seq_no);// added for IN 20964
					record.add(credit_auth_ref);
					record.add((String)hash.get( "credit_auth_date" ));
					record.add(credit_apprd_amt);
					record.add((String)hash.get( "credit_apprd_days" ));
					record.add( "N" );
					record.add((String)hash.get( "pol_validity_chk_date" ));	
					//authDtls.put(credit_auth_ref,record);
					authDtls.put(appr_seq_no,record);// changed for IN 20964 from key 'credit_auth_ref' to key 'appr_seq_no'
				 }
				 else if(authDtls!=null && authDtls.size()>0 && authDtls.containsKey(appr_seq_no))
				 {// changed for IN 20964 from key 'credit_auth_ref' to key 'appr_seq_no'
					record=new ArrayList();	
					oldRecord=new ArrayList();	
					oldRecord=(ArrayList)authDtls.get((String)hash.get( "appr_seq_no" ));// changed for IN 20964 from key 'credit_auth_ref' to key 'appr_seq_no'
					record.add(appr_seq_no);// added for IN 20964
					record.add(credit_auth_ref);
					record.add((String)hash.get( "credit_auth_date" ));
					record.add(credit_apprd_amt);
					record.add((String)hash.get( "credit_apprd_days" ));
					record.add((String)oldRecord.get(5));	
					record.add((String)hash.get( "pol_validity_chk_date" ));	
					//authDtls.remove(credit_auth_ref);// commented for IN 20964
					authDtls.remove(appr_seq_no);// added for IN 20964
				//	authDtls.put(credit_auth_ref,record);		// commented for IN 20964		
					authDtls.put(appr_seq_no,record);		// commented for IN 20964		
				 }
				payer=new ArrayList();
				payer.add(hdrVals);
				payer.add(authDtls);
				payer.add(pkgApprovals);
				bean.setDetails(payer);		
				bean.saveDetails(mapKey);
						
			}
			
		}
		else if(func_mode!= null && func_mode.equals("nonInsHdrVals"))
		{
			String 	appr_seq_no=(String)hash.get( "appr_seq_no" );
			if(appr_seq_no!=null && !appr_seq_no.equals(""))
				appr_seq_no=appr_seq_no.trim();
			String 	credit_auth_ref=(String)hash.get( "credit_auth_ref" );
			if(credit_auth_ref!=null && !credit_auth_ref.equals(""))
				credit_auth_ref=credit_auth_ref.trim();
			String 	credit_apprd_amt=(String)hash.get( "credit_apprd_amt" );
			if(credit_apprd_amt!=null && !credit_apprd_amt.equals(""))
				credit_apprd_amt=credit_apprd_amt.trim();
			
			String mapKey=((String)hash.get( "blng_grp_code" )).trim()+"~~"+((String)hash.get( "cust_group_code" )).trim()+"~~"+((String)hash.get( "cust_3" )).trim();
			HashMap payerDtls=(HashMap)bean.getPayerDtls();
			ArrayList payer=new ArrayList();
			payer=(ArrayList)bean.getDetails();
			HashMap hdrDtls=new HashMap();
			HashMap authDtls=new HashMap();
			HashMap pkgApprovals=new HashMap();
			
			if((payer==null || payer.size()==0) && payerDtls!=null && payerDtls.size()>0 && payerDtls.containsKey(mapKey))
				payer=(ArrayList)payerDtls.get(mapKey);
			if(payer!=null && payer.size()>0)
			{
				hdrDtls=	(HashMap)payer.get(0);
				authDtls=	(HashMap)payer.get(1);
				pkgApprovals=	(HashMap)payer.get(2);
			}		
			HashMap hdrVals=new HashMap();
			ArrayList oldRecord=new ArrayList();	
			ArrayList record=new ArrayList();	
	//		hdrVals.put("billing_group_desc",(String)hash.get( "billing_group_desc" ));
			hdrVals.put("blng_grp_code",(String)hash.get( "blng_grp_code" ));
	//		hdrVals.put("payer_desc",(String)hash.get( "payer_desc" ));
			hdrVals.put("cust_3",(String)hash.get( "cust_3" ));
	//		hdrVals.put("priority",(String)hash.get( "priority" ));
	//		hdrVals.put("policy_type_desc",(String)hash.get( "policy_type_desc" ));
	//		hdrVals.put("policy_type_code",(String)hash.get( "policy_type_code" ));
	//		hdrVals.put("policy_no",(String)hash.get( "policy_no" ));
	//		hdrVals.put("policy_start_date",(String)hash.get( "policy_start_date" ));
	//		hdrVals.put("policy_exp_date",(String)hash.get( "policy_exp_date" ));
			
	//		hdrVals.put("credit_auth_ref",credit_auth_ref);
	//		hdrVals.put("credit_auth_date",(String)hash.get( "credit_auth_date" ));
	//		hdrVals.put("credit_apprd_amt",(String)hash.get( "credit_apprd_amt" ));
	//		hdrVals.put("credit_apprd_days",(String)hash.get( "credit_apprd_days" ));
	//		hdrVals.put("policy_eff_frm_date",(String)hash.get( "policy_eff_frm_date" ));
	//		hdrVals.put("policy_eff_to_date",(String)hash.get( "policy_eff_to_date" ));
	//		hdrVals.put("adj_rule_ind",(String)hash.get( "adj_rule_ind" ));
	//		hdrVals.put("adj_perc_amt_ind",(String)hash.get( "adj_perc_amt_ind" ));
	//		hdrVals.put("adj_perc_amt_value",(String)hash.get( "adj_perc_amt_value" ));
	//		hdrVals.put("pmnt_diff_adj_int",(String)hash.get( "pmnt_diff_adj_int" ));
	//		hdrVals.put("drg_pmnt_diff_adj_int",(String)hash.get( "drg_pmnt_diff_adj_int" ));
	//		hdrVals.put("spl_srv_pmnt_diff_adj_int",(String)hash.get( "spl_srv_pmnt_diff_adj_int" ));
	//		hdrVals.put("restrict_check",(String)hash.get( "restrict_check" ));
	//		hdrVals.put("valid_payer_YN",(String)hash.get( "valid_payer_YN" ));
	//		hdrVals.put("valid_policy_type_code_YN",(String)hash.get( "valid_policy_type_code_YN" ));
			hdrVals.put("ins_cust_group_code",(String)hash.get( "cust_group_code" ));
	//		hdrVals.put("policy_coverage_basis_ind",(String)hash.get( "policy_coverage_basis_ind" ));
	//		hdrVals.put("referral_source_main_code",(String)hash.get( "referral_source_main_code" ));
	//		hdrVals.put("referral_source_main_desc",(String)hash.get( "referral_source_main_desc" ));
	//		hdrVals.put("referral_source_sub_code",(String)hash.get( "referral_source_sub_code" ));
	//		hdrVals.put("referral_source_sub_desc",(String)hash.get( "referral_source_sub_desc" ));
	//		hdrVals.put("apprd_amt_restrict_check",(String)hash.get( "apprd_amt_restrict_check" ));
	//		hdrVals.put("apprd_days_restrict_check",(String)hash.get( "apprd_days_restrict_check" ));
	//		hdrVals.put("cred_auth_req_yn",(String)hash.get( "cred_auth_req_yn" ));
	//		hdrVals.put("dflt_auth_ref_as_pol_no_yn",(String)hash.get( "dflt_auth_ref_as_pol_no_yn" ));
	//		hdrVals.put("cust_valid_from_date",(String)hash.get( "cust_valid_from_date" ));
	//		hdrVals.put("cust_valid_to_date",(String)hash.get( "cust_valid_to_date" ));
	//		hdrVals.put("ins_cust_group_name",(String)hash.get( "ins_cust_group_name" ));
	//		hdrVals.put("pol_validity_chk_date",(String)hash.get( "pol_validity_chk_date" ));	
	/*		 if((authDtls==null || authDtls.size()==0) && (pkgApprovals==null || pkgApprovals.size()==0) )	{
				record=new ArrayList();
				record.add(appr_seq_no);// added for IN 20964
				record.add(credit_auth_ref);
				record.add((String)hash.get( "credit_auth_date" ));
				record.add(credit_apprd_amt);
				record.add((String)hash.get( "credit_apprd_days" ));
				record.add( "N" );
				record.add((String)hash.get( "pol_validity_chk_date" ));	
				//authDtls.put(credit_auth_ref,record);
				authDtls.put(appr_seq_no,record);// changed for IN 20964 from key 'credit_auth_ref' to key 'appr_seq_no'
			 }
			 else if(authDtls!=null && authDtls.size()>0 && authDtls.containsKey(appr_seq_no))
			 {// changed for IN 20964 from key 'credit_auth_ref' to key 'appr_seq_no'
				record=new ArrayList();	
				oldRecord=new ArrayList();	
				oldRecord=(ArrayList)authDtls.get((String)hash.get( "appr_seq_no" ));// changed for IN 20964 from key 'credit_auth_ref' to key 'appr_seq_no'
				record.add(appr_seq_no);// added for IN 20964
				record.add(credit_auth_ref);
				record.add((String)hash.get( "credit_auth_date" ));
				record.add(credit_apprd_amt);
				record.add((String)hash.get( "credit_apprd_days" ));
				record.add((String)oldRecord.get(5));	
				record.add((String)hash.get( "pol_validity_chk_date" ));	
				//authDtls.remove(credit_auth_ref);// commented for IN 20964
				authDtls.remove(appr_seq_no);// added for IN 20964
			//	authDtls.put(credit_auth_ref,record);		// commented for IN 20964		
				authDtls.put(appr_seq_no,record);		// commented for IN 20964		
			 }
	*/
			payer=new ArrayList();
			payer.add(hdrVals);
			payer.add(authDtls);
			payer.add(pkgApprovals);
			bean.setDetails(payer);		
			bean.saveDetails(mapKey);
		}
		else if(func_mode!= null && func_mode.equals("dupChk"))
		{  		
			ArrayList codes     = new ArrayList();
			int totRec		    = Integer.parseInt((String) hash.get( "total_records" ));
			int	index	    	= Integer.parseInt((String) hash.get( "index" ));	
	
			String item	= (String) hash.get( "item" );	
			for(int i=0;i<totRec; i++)
			{
				if(i!=index)
				codes.add((String) hash.get( "code_"+i ));
			}
		
			if(codes.contains(item))
				out.println("duplicateAlert('"+index+"','"+form_name+"')");
		}
		else if(func_mode != null && func_mode.equals("claimCreditMapSession" ) )
		{
			// Karthik added the code to add claim code starts  - IN50355
			HashMap<String,String> claimCreditMap=( session.getAttribute("CLAIM_CREDIT_MAP_SESSION")==null ? new HashMap<String,String>(): (HashMap)session.getAttribute("CLAIM_CREDIT_MAP_SESSION") );
			claimCreditMap.put((String)hash.get( "priority" ), (String)hash.get( "claim_code" ) +"~" + (String)hash.get( "credit_authorisation_by" ) +"~" + (String)hash.get( "membershipId") );
			session.setAttribute("CLAIM_CREDIT_MAP_SESSION",claimCreditMap);
			System.out.println("CLAIM_CREDIT_MAP_SESSION:"+ claimCreditMap);			
			// Karthik added the code to add claim code starts  - IN50355
		
		}
		else if(func_mode != null && func_mode.equals("clearBean" ) )
		{
			bean.clearBean();
		}
	}
	catch (Exception e) 
	{
		e.printStackTrace() ;
		System.out.println("Exception from PkgApprovalValidation :"+e);
	}
	putObjectInBean(bean_id,bean,request);

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
