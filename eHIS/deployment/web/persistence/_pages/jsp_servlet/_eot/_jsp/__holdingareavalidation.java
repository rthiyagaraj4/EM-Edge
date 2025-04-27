package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import eCommon.XSSRequestWrapper;
import eCommon.Common.CommonBean;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import eOT.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __holdingareavalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/HoldingAreaValidation.jsp", 1709117262000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
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
 request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

			HashMap holding_area = null;
			ArrayList date_list = null;
	try{
	Connection con = null;
	Statement pstmt  = null;
	ResultSet rst = null;

			String func_mode = CommonBean.checkForNull(request.getParameter("func_mode"));
			String mts = CommonBean.checkForNull(request.getParameter("mts"));
					
			Hashtable hash = (Hashtable)xmlObj.parseXMLString(request);
			hash = (Hashtable)hash.get( "SEARCH" );
			String bean_id = "HoldingAreaBean";
			String bean_name = "eOT.HoldingAreaBean";
			HoldingAreaBean hold_bean = (HoldingAreaBean)mh.getBeanObject( bean_id, request, bean_name );
			//Added Against AAKH-SCF-0431
			String oper_num_bil="";
			if(!func_mode.equals("getSysDateTime"))	
			oper_num_bil=checkForNull((String) hash.get("oper_num"));
			//Added Against AAKH-SCF-0431
			String encounter_id="";
			String episode_id="";
			String episode_type="";
			String visit_id="";
			String nature_type="";
			String nature_code="";
			String surgeon_code="";
			String speciality_code="";
			String patient_class="";
			String bl_episode_type="";
			try{
				con = ConnectionManager.getConnection(request);
				pstmt = con.createStatement();
				String sql="SELECT  ENCOUNTER_ID,EPISODE_ID,EPISODE_TYPE,VISIT_ID,NATURE_TYPE,NATURE_CODE,SURGEON_CODE,SPECIALITY_CODE, PATIENT_CLASS FROM OT_POST_OPER_HDR WHERE OPER_NUM='"+oper_num_bil+"'";
				rst=pstmt.executeQuery(sql);
				if(rst !=null && rst.next())
				{

					encounter_id=checkForNull(rst.getString(1));
					episode_id=checkForNull(rst.getString(2));
					episode_type=checkForNull(rst.getString(3));
					visit_id=checkForNull(rst.getString(4));
					nature_type=checkForNull(rst.getString(5));
					nature_code=checkForNull(rst.getString(6));
					surgeon_code=checkForNull(rst.getString(7));
					speciality_code=checkForNull(rst.getString(8));
					patient_class=checkForNull(rst.getString(9));
				}
	
			}catch(Exception e){
					e.printStackTrace();
					System.err.println("Err Msg from CommonValidation.jsp :"+e);
				}
				finally{
					if(rst!=null) rst.close();
					if(pstmt!=null)pstmt.close();
					if(con!=null) con.close();
					}
			String err_text = "";
			String result="";
			try{
				con = ConnectionManager.getConnection(request);
				pstmt = con.createStatement();
				String sql_bl_episode_type="SELECT BL_EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS = '"+patient_class+"' AND EPISODE_TYPE ='"+episode_type+"'";
				rst=pstmt.executeQuery(sql_bl_episode_type);
				if(rst !=null && rst.next())
				{
					bl_episode_type=checkForNull(rst.getString(1));
				}
			}catch(Exception e){
					e.printStackTrace();
					System.err.println("Err Msg from CommonValidation.jsp :"+e);
				}
				finally{
					if(rst!=null) rst.close();
					if(pstmt!=null)pstmt.close();
					if(con!=null) con.close();
					}
			if(func_mode!=null && func_mode.equals("updateAndCommitHoldingAreaDtls")){
				holding_area = new HashMap();
				//converting  the hashtable into hashmap
				holding_area.put("change_date_time",(String)hash.get("change_date_time"));
				holding_area.put("oper_num",(String) hash.get("oper_num"));
				holding_area.put("slate_user_id",(String) hash.get("slate_user_id"));
				holding_area.put("change_holding_code",(String)hash.get("change_holding_code"));
				holding_area.put("change_holding_desc",(String)hash.get("change_holding_desc"));
				holding_area.put("accession_line_num",(String)hash.get("accession_line_num"));
				holding_area.put("charge_hold_area_yn",(String)hash.get("charge_hold_area_yn"));
				holding_area.put("mode",(String)hash.get("mode"));
				if(hash.get("chk_out_dt_time").equals(" ")){
					holding_area.put("chk_out_dt_time","");	
				}else{
					holding_area.put("chk_out_dt_time",(String)hash.get("chk_out_dt_time"));
				}
				holding_area.put("bill_acc_temp",(String)hash.get("bill_acc_temp"));
				if(hash.get("calc_charge_units").equals("undefined")){
				holding_area.put("calc_charge_units","");
				}else{
				holding_area.put("calc_charge_units",(String)hash.get("calc_charge_units"));
				}
				if(hash.get("modified_charge_units").equals("undefined")){
					holding_area.put("modified_charge_units","");
				}else{
					holding_area.put("modified_charge_units",(String)hash.get("modified_charge_units"));
				}
				if(hash.get("service_code").equals("undefined")){
					holding_area.put("service_code","");
				}else{
					holding_area.put("service_code",(String)hash.get("service_code"));
				}
				holding_area.put("accession_num",(String)hash.get("accession_num"));
				if(hash.get("accession_line_num").equals("undefined")){
				holding_area.put("accession_line_num","");
				}else{
				holding_area.put("accession_line_num",(String)hash.get("accession_line_num"));
				}
				holding_area.put("patient_id",(String)hash.get("patient_id"));
				holding_area.put("slate_user_id",(String)hash.get("slate_user_id"));
				holding_area.put("hold_area_chrging_stg",(String)hash.get("hold_area_chrging_stg"));
				holding_area.put("chk_holding_area_chrg_yn_stg",(String)hash.get("chk_holding_area_chrg_yn_stg"));
				holding_area.put("mode",(String)hash.get("mode"));
				holding_area.put("reason_inc_exc",(String)hash.get("reason_inc_exc"));
				holding_area.put("inc_exe_blng_wdw",(String)hash.get("inc_exe_blng_wdw"));
//				holding_area.put("speciality_code",reason_inc_exc);
//				holding_area.put("speciality_code",inc_exe_blng_wdw);

				//newly included for calling billing procedures
				holding_area.put("encounter_id",encounter_id);
				holding_area.put("episode_id",episode_id);
				holding_area.put("episode_type",bl_episode_type);
				holding_area.put("visit_id",visit_id);
				holding_area.put("nature_type",nature_type);
				holding_area.put("nature_code",nature_code);
				holding_area.put("surgeon_code",surgeon_code);
				holding_area.put("speciality_code",speciality_code);
				
				err_text = checkForNull(hold_bean.updateAndCommitHoldingAreaDtls(holding_area));

				out.println(err_text);
			}else if(func_mode!=null && func_mode.equals("updateAndCommitCheckinToORDtls")){
				holding_area = new HashMap();
				//converting  the hashtable into hashmap
				holding_area.put("change_date_time",(String)hash.get("change_date_time"));
				holding_area.put("oper_num",(String) hash.get("oper_num"));
				holding_area.put("slate_user_id",(String) hash.get("slate_user_id"));
				err_text = hold_bean.updateAndCommitCheckinToORDtls(holding_area);
				out.println(err_text);					
			}else if(func_mode!=null && func_mode.equals("getSysDateTime")){
				date_list = hold_bean.getSysDateTime();
				out.println((String)date_list.get(0)); //sysdate_time
			}else if(func_mode!=null && func_mode.equals("getSysDate")){
				date_list = hold_bean.getSysDateTime();
				out.println((String)date_list.get(1)); //sysdate_date
			}else if(func_mode!=null && func_mode.equals("getSysTime")){
				date_list = hold_bean.getSysDateTime();
				out.println((String)date_list.get(2)); //sysdate_time
			}else if(func_mode!=null && func_mode.equals("convertMts")){
				//used in Nursing Time and Details.
				result = CommonBean.checkForNull(hold_bean.getConvertedMts(mts));
				out.println(result);
			}
	}catch(Exception e){
		e.printStackTrace();
	   holding_area  = null;
	   date_list = null;
	   out.println("Err Msg from HoldingAreavalidation.jsp"+e.getMessage());
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
