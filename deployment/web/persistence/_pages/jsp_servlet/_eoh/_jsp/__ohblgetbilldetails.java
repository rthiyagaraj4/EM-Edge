package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.OrderEntryBillingQueryBean;
import eOH.*;
import eOT.*;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __ohblgetbilldetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/OHBLGetBillDetails.jsp", 1709117120466L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOH/jsp/StringUtil.jsp", 1724302706763L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n\t\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}

public String format_decimal(Double gs_val, int no_of_decimal){
		 
		String gs_val_str = gs_val+"";
		String restrict_gs_val = gs_val_str;
		int index = gs_val_str.indexOf(".");
		int len = (gs_val_str.substring(index+1)).length();
		if(index != -1 && len>no_of_decimal){
			restrict_gs_val = gs_val_str.substring(0,index+no_of_decimal+1);
		}

		return restrict_gs_val;
	}

	
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
        response.setHeader("Content-Type", " text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType(" text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
 

 String locale = (String)session.getAttribute("LOCALE"); 
 try{
		//bean_id name shouldn't be changed.
		String oh_bean_id 		= "OHBillingBean";
		String oh_bean_name 	= "eOH.OHBillingBean";
		OHBillingBean oh_bean	= (OHBillingBean)getBeanObject( oh_bean_id, oh_bean_name, request );

		String or_bean_id 		= "Or_billingQueryBean";
		String or_bean_name 	= "eOR.OrderEntryBillingQueryBean";
		OrderEntryBillingQueryBean or_bean			= (OrderEntryBillingQueryBean)getBeanObject( or_bean_id, or_bean_name, request );

		String order_id			= checkForNull(request.getParameter("order_id"));
		String order_line_num	= checkForNull(request.getParameter("order_line_num"));
		String chart_num		= checkForNull(request.getParameter("chart_num"));
		String chart_line_num	= checkForNull(request.getParameter("chart_line_num"));
		String task_code		= checkForNull(request.getParameter("task_code"));
		String task_order_catalog_code		= checkForNull(request.getParameter("task_order_catalog_code"));
		String key		= checkForNull(request.getParameter("key"));
		String key_line		= checkForNull(request.getParameter("key_line"));
		String patient_id	= checkForNull(request.getParameter("patient_id"));
		String episode_type	= "";
		String episode_id	= "";
		String encounter_id	= "";
		String patient_class = "";
		String pract_staff_id = "";
		String visit_id = "";
		String bl_data_exists_yn	= checkForNull(request.getParameter("bl_data_exists_yn"));

		HashMap bill_info	= new HashMap();
		HashMap patient_dtls_hash	= new HashMap();
		StringBuilder bl_bfr = new StringBuilder();


		bill_info = or_bean.getOrderBillDtls(key+key_line);	

		if(bill_info==null){
			bill_info = new HashMap();
			bill_info.put("key",key);
			bill_info.put("key_line_no",key_line);
			bill_info.put("task_code",task_code);
			bill_info.put("chart_num",chart_num);
			bill_info.put("locale",locale);
			bill_info.put("module_id","OH");
			bill_info.put("quantity","1");
			//populate billing details from OTBillingBean........	
			//bill_info = billing_bean.getBillingParams(bill_info,"C");//C-> for Surgical Accessories Billing
			// Get the patient details 
			//String SQL = "SELECT PATIENT_ID,EPISODE_TYPE,EPISODE_ID,VISIT_ID,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),ENCOUNTER_ID,PATIENT_CLASS,PRACTITIONER_ID FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND NVL(COND_CLOSED_YN,'N') = 'N'";
			String SQL = "SELECT PATIENT_ID,EPISODE_TYPE,EPISODE_ID,VISIT_ID,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),ENCOUNTER_ID,PATIENT_CLASS,PRACTITIONER_ID FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND NVL(COND_CLOSED_YN,'N') = 'N'";
			Connection connection  = null ;
			PreparedStatement pstmt= null ;
			ResultSet rst = null;
		try{
			connection	= ConnectionManager.getConnection(request);
			pstmt=connection.prepareStatement(SQL);
			pstmt.setString(1,patient_id);		
			pstmt.setString(2,chart_num);		
			pstmt.setString(3,chart_line_num);	
			rst = pstmt.executeQuery();
			while(rst.next()){
				episode_type	= rst.getString(2);
				episode_id		= CommonBean.checkForNull(rst.getString(3));
				visit_id		= CommonBean.checkForNull(rst.getString(4),"1");
				encounter_id	= rst.getString(6);
				patient_class	= rst.getString(7);
				pract_staff_id	= rst.getString(8);
				bill_info.put("patient_id",rst.getString(1));
				bill_info.put("episode_type",episode_type);
				bill_info.put("episode_id",episode_id);
				bill_info.put("visit_id",visit_id);
				bill_info.put("service_date",rst.getString(5));
				bill_info.put("encounter_id",encounter_id);
				bill_info.put("patient_class",patient_class);
				bill_info.put("pract_staff_id",pract_staff_id);
			}
		}catch ( Exception e ) {
	        e.printStackTrace() ;
		}finally {
            try{
				if(rst!=null) rst.close();
				if(pstmt!=null) pstmt.close();
				if(connection!=null) 
					ConnectionManager.returnConnection(connection,request);
             }catch(Exception es){es.printStackTrace();}
        }
		

			
			ArrayList bill_dtls= new ArrayList();
			bl_data_exists_yn="Y";
			if(bl_data_exists_yn.equals("Y")){
				ArrayList episode_visit_list = oh_bean.getEpisodeAndVisitId(encounter_id);
				episode_id = (String) episode_visit_list.get(0);
				visit_id = (String) episode_visit_list.get(1);
				//bill_dtls=or_bean.getBillChargeDetails("1",task_order_catalog_code,(String)bill_info.get("service_date"),locale,key,order_line_num,patient_id,encounter_id,patient_class,pract_staff_id);	
				bill_dtls=or_bean.getBillChargeDetails("1",task_order_catalog_code,(String)bill_info.get("service_date"),locale,order_id,order_line_num,patient_id,encounter_id,patient_class,pract_staff_id);	

				//bill_dtls = oh_bean.getBillDetails(task_code,episode_type,"OH",key,order_line_num,patient_id,episode_id,visit_id, encounter_id,"1",pract_staff_id,facility_id,locale,"TASK");
			}else{				
				bill_dtls=or_bean.getBillChargeDetails("1",task_order_catalog_code,(String)bill_info.get("service_date"),locale,"","",patient_id,(String)bill_info.get("encounter_id"),(String)bill_info.get("patient_class"),(String)bill_info.get("pract_staff_id"));	
				//bill_dtls=or_bean.getBillChargeDetails("1",task_order_catalog_code,(String)bill_info.get("service_date"),locale,"","",patient_id,(String)bill_info.get("encounter_id"),(String)bill_info.get("patient_class"),(String)bill_info.get("pract_staff_id"));	
			}
			
			patient_dtls_hash	= oh_bean.formatBillingDetails(bill_dtls);
			bill_info.putAll(patient_dtls_hash);

			or_bean.setOrderBillDtls(key+key_line,bill_info);
			putObjectInBean(or_bean_id,or_bean,request);
			//bill_info.clear();
		}
		
		bl_bfr.append(bill_info.get("key")).append("::");				//0
		bl_bfr.append(bill_info.get("key_line_no")).append("::");		//1
		bl_bfr.append(bill_info.get("task_code")).append("::");			//2
		bl_bfr.append(bill_info.get("patient_id")).append("::");		//3
		bl_bfr.append(bill_info.get("episode_type")).append("::");		//4
		bl_bfr.append(bill_info.get("episode_id")).append("::");		//5
		bl_bfr.append(bill_info.get("visit_id")).append("::");			//6
		bl_bfr.append(bill_info.get("encounter_id")).append("::");		//7
		bl_bfr.append(bill_info.get("service_date")).append("::");		//8
		bl_bfr.append("P").append("::");								//9
		bl_bfr.append(bill_info.get("pract_staff_id")).append("::");	//10
		bl_bfr.append(bill_info.get("serv_panel_ind")).append("::");	//11
		bl_bfr.append(bill_info.get("serv_panel_code")).append("::");	//12
		bl_bfr.append(bill_info.get("bl_panel_str")).append("::");		//13
		bl_bfr.append(bill_info.get("total_payable")).append("::");		//14
		bl_bfr.append(bill_info.get("patient_payable")).append("::");	//15
		bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");	//16
		bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");	//17
		bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");			//18
		bl_bfr.append(bill_info.get("quantity")).append("::");									//19

		out.println(bl_bfr.toString());
		bl_bfr.setLength(0);
	}catch(Exception e){
		System.err.println("Exception in OHBLGetBillDetails:::"+e);
		e.printStackTrace();
	}

            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
