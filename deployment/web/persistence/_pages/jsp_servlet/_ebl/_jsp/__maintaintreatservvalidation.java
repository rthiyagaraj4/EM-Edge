package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eBL.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import eBL.Common.*;
import com.ehis.util.*;
import eBL.*;
import eMR.*;
import eBL.BLReportIdMapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __maintaintreatservvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/MaintainTreatServValidation.jsp", 1737440370866L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n\n\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
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

	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
		
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
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

/* <!-- 
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1	   		  V210730           16777	      PMG2021-COMN-CRF-0076    			  Mohana Priya
2								30618		  PMG2021-COMN-CRF-0076.2    		  Manivel N
 -->  */

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

Connection con = null;
CallableStatement cstmt = null;
CallableStatement cstmt1 = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
boolean inserted = true;

try{
	con = ConnectionManager.getConnection(request);
	String operation = request.getParameter("func_mode") == null ? "" :request.getParameter("func_mode");
	String facility_id=request.getParameter("facility_id") == null ? "" :request.getParameter("facility_id");
	String hdn_package_code=request.getParameter("hdn_package_code") == null ? "" :request.getParameter("hdn_package_code");
	String hdn_package_seq_no=request.getParameter("hdn_package_seq_no") == null ? "" :request.getParameter("hdn_package_seq_no");
	String pkgservind=request.getParameter("pkgservind") == null ? "" :request.getParameter("pkgservind");
	String p_language_id=request.getParameter("p_language_id") == null ? "" :request.getParameter("p_language_id");
	String pkg_serv_code=request.getParameter("pkg_serv_code") == null ? "" :request.getParameter("pkg_serv_code");
/*	String order_catalog_yn=request.getParameter("order_catalog_yn") == null ? "" :request.getParameter("order_catalog_yn");
	//String to_cash=request.getParameter("to_cash_counter1") == null ? "" :request.getParameter("to_cash_counter1");
	System.err.println("operation-"+operation+" facility_id-"+facility_id+" hdn_package_code-"+hdn_package_code+" hdn_package_seq_no-"+hdn_package_seq_no+" pkgservind-"+pkgservind+" p_language_id-"+p_language_id+" pkg_serv_code-"+pkg_serv_code);
	System.err.println("order_catalog_yn-"+order_catalog_yn);
	*/

	if(operation.equals("chckdupl")){
	  try{
		  String order_catalog_yn=request.getParameter("order_catalog_yn") == null ? "" :request.getParameter("order_catalog_yn");
		System.err.println("operation-"+operation+" facility_id-"+facility_id+" hdn_package_code-"+hdn_package_code+" hdn_package_seq_no-"+hdn_package_seq_no+" pkgservind-"+pkgservind+" p_language_id-"+p_language_id+" pkg_serv_code-"+pkg_serv_code);
		System.err.println("order_catalog_yn-"+order_catalog_yn);


			cstmt=con.prepareCall("{ call blpackage.validate_blng_serv_code_3t(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");	
			cstmt.setString(1,facility_id);
			cstmt.setString(2,hdn_package_code);
			cstmt.setString(3,hdn_package_seq_no);
			cstmt.setString(4,pkgservind);
			cstmt.setString(5,pkg_serv_code);
			cstmt.setString(6,p_language_id);
			cstmt.setString(13,order_catalog_yn);		
			//cstmt.setString(8,p_date_format);
			cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(14,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(15,java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(16,java.sql.Types.VARCHAR);
			
			cstmt.execute();
			String pkgservname=cstmt.getString(7);
			String p_pkg_serv_status=cstmt.getString(8);
			String p_rate_charge_ind=cstmt.getString(9);
			if(p_rate_charge_ind == null) p_rate_charge_ind = "";
			String p_factor_rate_ind=cstmt.getString(10);
			String p_factor_rate=cstmt.getString(11);
			String p_home_medication_yn=cstmt.getString(12);
			String p_order_catalog_code=cstmt.getString(14);
			String p_amt_limit_ind=cstmt.getString(15);
			String messageId=cstmt.getString(16);
			System.err.println("p_home_medication_yn "+p_home_medication_yn);
				
			System.err.println("pkgservname  "+pkgservname);
			System.err.println("p_pkg_serv_status  "+p_pkg_serv_status);
			System.err.println("p_rate_charge_ind  "+p_rate_charge_ind);
			System.err.println("p_factor_rate_ind  "+p_factor_rate_ind);
			if(p_factor_rate==null || p_factor_rate==""){
				p_factor_rate="N";
			}
			System.err.println("p_factor_rate  "+p_factor_rate);
			System.err.println("p_home_medication_yn  "+p_home_medication_yn);
			System.err.println("p_order_catalog_code  "+p_order_catalog_code);
			System.err.println("p_amt_limit_ind  "+p_amt_limit_ind);
			System.err.println("messageId  "+messageId);
			
			String returnValue= "";
		/*	if(messageId != null || messageText != null){
				if(messageId != null && messageText != null){
					returnValue = "::"+messageText+"~"+messageId+"~";
				}else if(messageId != null &&  messageText == null){
					returnValue = "~"+messageId+"~";
				}else{
					returnValue = "::"+messageText+"~";
				}
			}*/
		if(messageId != null){
			returnValue = "::"+messageId+"::";
		}
		else{
				returnValue ="~"+pkgservname+"~"+p_pkg_serv_status+"~"+p_rate_charge_ind+"~"+p_factor_rate_ind+"~"+p_factor_rate+"~"+p_home_medication_yn+"~"+p_order_catalog_code+"~"+p_amt_limit_ind+"~";
			}
			
			System.err.println("returnValue  "+returnValue);
			out.println(returnValue); 
			}catch(Exception e){
				e.printStackTrace();
				System.err.println("Err Msg from MaintainTreatServValidation.jsp "+e);
				con.rollback();
			}finally{
				cstmt=null;
			}
		} else if(operation.equals("chckduplexcl")){
		  try{
			  String order_catalog_yn=request.getParameter("order_catalog_yn") == null ? "" :request.getParameter("order_catalog_yn");
			System.err.println("operation-"+operation+" facility_id-"+facility_id+" hdn_package_code-"+hdn_package_code+" hdn_package_seq_no-"+hdn_package_seq_no+" pkgservind-"+pkgservind+" p_language_id-"+p_language_id+" pkg_serv_code-"+pkg_serv_code);
			System.err.println("order_catalog_yn-"+order_catalog_yn);


				cstmt=con.prepareCall("{ call blpackage.validate_excl_serv_code_3t(?,?,?,?,?,?,?,?,?)}");	
				//cstmt.setString(1,facility_id);
				//cstmt.setString(2,hdn_package_code);
				//cstmt.setString(3,hdn_package_seq_no);
				cstmt.setString(1,pkgservind);
				cstmt.setString(2,pkg_serv_code);
				cstmt.setString(3,p_language_id);
				cstmt.setString(4,"N");		
				cstmt.registerOutParameter(5,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(9,java.sql.Types.VARCHAR);								
				cstmt.execute();
				
				String pkgservname=cstmt.getString(5);
				String p_pkg_serv_status=cstmt.getString(6);
				String p_rate_charge_ind=cstmt.getString(7);
				if(p_rate_charge_ind == null) p_rate_charge_ind = "";
				String p_factor_rate_ind="";
				String p_factor_rate="";
				String p_home_medication_yn=cstmt.getString(8);
				String p_order_catalog_code="";
				String p_amt_limit_ind="";
				String messageId=cstmt.getString(9);
				System.err.println("p_home_medication_yn "+p_home_medication_yn);
					
				System.err.println("pkgservname  "+pkgservname);
				System.err.println("p_pkg_serv_status  "+p_pkg_serv_status);
				System.err.println("p_rate_charge_ind  "+p_rate_charge_ind);
				System.err.println("p_factor_rate_ind  "+p_factor_rate_ind);
				if(p_factor_rate==null || p_factor_rate==""){
					p_factor_rate="N";
				}
				System.err.println("p_factor_rate  "+p_factor_rate);
				System.err.println("p_home_medication_yn  "+p_home_medication_yn);
				System.err.println("p_order_catalog_code  "+p_order_catalog_code);
				System.err.println("p_amt_limit_ind  "+p_amt_limit_ind);
				System.err.println("messageId  "+messageId);
				
				String returnValue= "";
			/*	if(messageId != null || messageText != null){
					if(messageId != null && messageText != null){
						returnValue = "::"+messageText+"~"+messageId+"~";
					}else if(messageId != null &&  messageText == null){
						returnValue = "~"+messageId+"~";
					}else{
						returnValue = "::"+messageText+"~";
					}
				}*/
			if(messageId != null){
				returnValue = "::"+messageId+"::";
			}
			else{
					returnValue ="~"+pkgservname+"~"+p_pkg_serv_status+"~"+p_rate_charge_ind+"~"+p_factor_rate_ind+"~"+p_factor_rate+"~"+p_home_medication_yn+"~"+p_order_catalog_code+"~"+p_amt_limit_ind+"~";
				}
				
				System.err.println("returnValue  "+returnValue);
				out.println(returnValue); 
				}catch(Exception e){
					e.printStackTrace();
					System.err.println("Err Msg from MaintainTreatServValidation.jsp "+e);
					con.rollback();
				}finally{
					cstmt=null;
				}
		}
		else if(operation.equals("deleteRecord")){
			try
			{
				String patientid1=request.getParameter("patientid1") == null ? "" :request.getParameter("patientid1");
				String userid=request.getParameter("userid") == null ? "" :request.getParameter("userid");
				String ws_no=request.getParameter("wsno") == null ? "" :request.getParameter("wsno");
				
				String p_episode_type=request.getParameter("p_episode_type") == null ? "" :request.getParameter("p_episode_type");
				String p_episode_id=request.getParameter("p_episode_id") == null ? "" :request.getParameter("p_episode_id");
				String p_visit_id=request.getParameter("p_visit_id") == null ? "" :request.getParameter("p_visit_id");
				System.err.println("operation-"+operation+" facility_id-"+facility_id+" hdn_package_code-"+hdn_package_code+" hdn_package_seq_no-"+hdn_package_seq_no+" pkgservind-"+pkgservind+" p_language_id-"+p_language_id+" pkg_serv_code-"+pkg_serv_code);
				System.err.println("patientid1-"+patientid1+"  wsno- "+ws_no+" userid"+ userid);
				
				cstmt1=con.prepareCall("{ call blpackage.deleteblpkgsubdtls_3t (?,?,?,?,?,?,?,?,?,?,?,?,?) }");
				cstmt1.setString(1,facility_id);
				cstmt1.setString(2,patientid1);
				cstmt1.setString(3,hdn_package_code);
				cstmt1.setString(4,hdn_package_seq_no);
				cstmt1.setString(5,pkg_serv_code);
				cstmt1.setString(6,userid);
				cstmt1.setString(7,ws_no);
				cstmt1.registerOutParameter(8,java.sql.Types.VARCHAR);
				cstmt1.registerOutParameter(9,java.sql.Types.VARCHAR);
				cstmt1.registerOutParameter(10,java.sql.Types.VARCHAR);
				cstmt1.setString(11,p_episode_type);
				cstmt1.setString(12,p_episode_id);
				cstmt1.setString(13,p_visit_id);
				
				 
				cstmt1.execute();
				con.commit();
				String messageId=cstmt1.getString(10);
				String messageText=cstmt1.getString(8);
				String returnValue= "";
				System.err.println("messageId deleteValidation "+messageId);
				System.err.println("messageText deleteValidation  "+messageText);
				
				if(messageId != null || messageText != null){
					if(messageId != null && messageText != null){
						returnValue = "::"+messageText+"~"+messageId+"~";
					}else if(messageId != null &&  messageText == null){
						returnValue = "~"+messageId+"~";
					}else{
						returnValue = "::"+messageText+"~";
					}
				}else{
					returnValue ="";
				}
				
				System.err.println("returnValue in deleteValidation "+returnValue);
				out.println(returnValue); 
			}catch(Exception e){
				e.printStackTrace();
				System.err.println("Err Msg from deleteValidation "+e);
				con.rollback();
			}finally{
				cstmt1=null;
			}
		}	
		else if ("PAT_RECAL_JOB_CHK".equals(operation)){
			String patientid1=request.getParameter("patid") == null ? "" :request.getParameter("patid");
			String userid=request.getParameter("userid") == null ? "" :request.getParameter("userid");
			String ws_no=request.getParameter("wsno") == null ? "" :request.getParameter("wsno");
			
			cstmt1=con.prepareCall("{ call blpackage.val_recalculatepackage_for_job (?,?,?,?,?,?,?,?) }");
			cstmt1.setString(1,facility_id);
			cstmt1.setString(2,patientid1);
			cstmt1.setString(3,userid);
			cstmt1.setString(4,"");
			cstmt1.setInt(5,0);
			cstmt1.setInt(6,0);
			cstmt1.registerOutParameter(7,java.sql.Types.VARCHAR);
			cstmt1.registerOutParameter(8,java.sql.Types.VARCHAR);		
			cstmt1.execute();
			
			String status=cstmt1.getString(7);
			if(status == null || "null".equals(status)) status = "C";
			String errorText=cstmt1.getString(8);
			if(errorText == null || "null".equals(errorText)) errorText = "";
			String returnValue= status+"~~"+errorText;
			
			System.err.println("returnValue in val_recalculatepackage_for_job "+returnValue);
			out.println(returnValue); 
		} 
		else if("POST_JOB_FOR_PACK_RECALC".equals(operation)){		
			
			facility_id = (String) session.getValue("facility_id");	
			String patientid=request.getParameter("patid") == null ? "" :request.getParameter("patid");
			String userid = (String) session.getValue("login_user");
			java.util.Properties p = (java.util.Properties) session.getValue("jdbc");
			String ws_no = p.getProperty("client_ip_address");						
			
			String pkg_seq_list_sql = "select a.package_seq_no package_seq_no, b.encounter_id episode_id ,b.visit_id visit_id,b.episode_type episode_type  from bl_package_sub_hdr a, bl_package_encounter_dtls b where a.patient_id='"+patientid+"' and a.status = 'O' and a.operating_facility_id = b.operating_facility_id(+) and a.patient_id = b.patient_id(+) and a.package_code = b.package_code(+) and a.package_seq_no = b.package_seq_no(+) order by a.package_seq_no desc";
			System.err.println("pkg_seq_list_sql:"+pkg_seq_list_sql);
			pstmt = con.prepareStatement(pkg_seq_list_sql);
			rs = pstmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {		
					int package_seq_no = rs.getInt("package_seq_no");
					int episode_id = rs.getInt("episode_id");
					int visit_id = rs.getInt("visit_id");
					String episode_type = rs.getString("episode_type");
					
					String qryrecalcpkg   ="{ call   BLPACKAGE.recalculatepackage_for_job(?,?,?,?,?,?,?,?,?,?,?,?)}";
					cstmt1 = con.prepareCall(qryrecalcpkg);	
					cstmt1.setString(1,facility_id);
					cstmt1.setString(2,patientid);
					cstmt1.setString(3,"EBL_TRAN_PACKAGE_MAINTAIN");
					cstmt1.setInt(4,package_seq_no);
					cstmt1.setString(5,userid);
					cstmt1.setString(6,ws_no);
					cstmt1.registerOutParameter(7,java.sql.Types.VARCHAR);
					cstmt1.registerOutParameter(8,java.sql.Types.VARCHAR);
					cstmt1.registerOutParameter(9,java.sql.Types.VARCHAR);
					cstmt1.setString(10,episode_type);
					cstmt1.setInt(11,episode_id);					
					cstmt1.setInt(12,visit_id);
					
					cstmt1.execute();
					
					String str_error_level = cstmt1.getString(7);		
					if(str_error_level == null) str_error_level="";
					
					String str_sys_message_id = cstmt1.getString(8);		
					if(str_sys_message_id == null) str_sys_message_id="";
					
					String str_error_text = cstmt1.getString(9);		
					if(str_error_text == null) str_error_text="";
					
					System.err.println("****str_error_level hdr 244:"+str_error_level);
					System.err.println("****str_sys_message_id 245:"+str_sys_message_id);
					System.err.println("****str_error_text 246:"+str_error_text);

					cstmt1.close();
					
					if((!str_error_level.equals("") && !str_error_text.equals("")) || !str_sys_message_id.equals(""))
					{
						if(!str_error_level.equals("") && !str_error_text.equals(""))
						{
							System.err.println("str_error_level hdr in recalculation msg:"+str_error_text);
							inserted = false;
							out.println("E~"+str_error_text);
						}
						else if(!str_sys_message_id.equals(""))
						{
							System.err.println("sysid in hdr recalculation msg:"+str_sys_message_id);
							inserted = false;
							String locale = (String)session.getAttribute("LOCALE");
							Hashtable messageHashtable=MessageManager.getMessage(locale,str_sys_message_id,"BL");
							String msg=(String)messageHashtable.get("message");
							out.println("M~"+msg);
						}
					}
					else
					{
						System.err.println("****Inside Rec Success Loop recalculation");
						inserted = true;
						con.commit();
						out.println("Y~");

					}
				}
			}					
		} else if("HOME_MED_ENABLE_YN".equals(operation)){
			String pkgServInd = request.getParameter("pkgServInd");
			String pkgServCode = request.getParameter("pkgServCode");
			String homeMedEnableYN = "N";
			String sql = "select blcommonproc.bl_pharm_service_yn ('en','"+pkgServInd+"','"+pkgServCode+"') home_medication_enable_yn from dual";
			System.err.println("HOME_MED_ENABLE_YN sql:"+sql);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {	
					homeMedEnableYN = rs.getString("home_medication_enable_yn");
					if(homeMedEnableYN == null) homeMedEnableYN = "N";
				}
			}
			out.println(homeMedEnableYN);
		}
	}catch(Exception e){
		e.printStackTrace();
		System.err.println("Err Msg from generatecolrpt.jsp "+e);
		con.rollback();
	}
	finally{
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block2Bytes, _wl_block2);
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
