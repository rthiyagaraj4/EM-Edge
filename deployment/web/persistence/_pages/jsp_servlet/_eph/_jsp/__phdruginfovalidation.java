package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __phdruginfovalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PhDrugInfoValidation.jsp", 1722838103225L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 =" ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );
	
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
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	try{
		String func_mode			= request.getParameter("func_mode");
		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
		String bean_id				= hash.get("bean_id")==null?"":(String) hash.get("bean_id");
		String bean_name			= hash.get( "bean_name" )==null?"":(String) hash.get("bean_name");
		String mode					= hash.get("mode")==null?"":(String) hash.get("mode");

		PhDrugInfoEnqBean bean = (PhDrugInfoEnqBean)getBeanObject( bean_id, bean_name , request) ;
		bean.setLanguageId(locale);

		if(func_mode != null && func_mode.equals("getPractType")){
			String pract_id			= hash.get("pract_id")==null?"":(String) hash.get("pract_id");
			ArrayList practType		= bean.getPractType(pract_id);
			String pract_type			= "";
			String pract_desc			= "";
			int	   p					= 0;
			if(practType.size() > 0){
				pract_type	= (String)practType.get(p);
				pract_desc	 = (String)practType.get(p+1);
			}
			out.println("assignPractType(\""+pract_type+"\",\""+pract_desc+"\")");
		}
		else if(func_mode != null && func_mode.equals("getRespondTime")){
			String enq_date			= hash.get("enq_date")==null?"":(String) hash.get("enq_date");
			String resp_dt			=  hash.get("resp_dt")==null?"":(String) hash.get("resp_dt");
			String RespondTime		= bean.getRespondTime(resp_dt,enq_date);
			out.println("assignRespondTime(\""+RespondTime+"\")");
		}
		else if(func_mode != null && func_mode.equals("getRespondTime1")){
			String enq_date			= hash.get("enq_date")==null?"":(String) hash.get("enq_date");
			String resp_dt			=  hash.get("resp_dt")==null?"":(String) hash.get("resp_dt");
			String RespondTime		= bean.getRespondTime(resp_dt,enq_date);
			out.println("assignRespondTime1(\""+RespondTime+"\")");
		}
		else if(func_mode != null && func_mode.equals("getPatientDtl")){
			String patient_id			=  hash.get("patient_id")==null?"":(String) hash.get("patient_id");
			ArrayList PatientDtl		= bean.getPatientDtl(patient_id);
			String patient_name			= "";
			String patient_age			= "";
			String sex					= "";
			String ethnic_grp			= "";
			int	   p					= 0;
			if(PatientDtl.size() > 0){
				patient_name		= PatientDtl.get(p)==null?"":(String)PatientDtl.get(p);
				patient_age			= PatientDtl.get(p+1)==null?"":(String)PatientDtl.get(p+1);
				sex					= PatientDtl.get(p+2)==null?"":(String)PatientDtl.get(p+2);
				ethnic_grp			= PatientDtl.get(p+3)==null?"":(String)PatientDtl.get(p+3);
			} 
			out.println("assignPatientDtl(\""+patient_name+"\",\""+patient_age+"\",\""+sex+"\",\""+ethnic_grp+"\")");
		}
		else if(func_mode != null && func_mode.equals("InsertMode")){
			HashMap Enq_dtls				= new HashMap();
			String Source				= hash.get("Source")==null?"":(String)hash.get("Source");
			String Verified_by			=  hash.get("Verified_by")==null?"":(String)hash.get("Verified_by");
			String Enquiry_Num			=  hash.get("Enquiry_Num")==null?"":(String)hash.get("Enquiry_Num");
			String request_mode			=  hash.get("request_mode")==null?"":(String)hash.get("request_mode"); //Added for HSA-CRF-0158 [IN:048491] 
			Enq_dtls.put("Enquiry_Num",((String)hash.get("Enquiry_Num"))==null?"":(String)hash.get("Enquiry_Num"));
			if(Source.equals("LoggedF")){
				Enq_dtls.put("facility_id",((String)hash.get("facility_id"))==null?"":(String)hash.get("facility_id"));
				Enq_dtls.put("facility_name",((String)hash.get("facility_name"))==null?"":(String)hash.get("facility_name"));
			}
			else if(Source.equals("WithinF")){
				Enq_dtls.put("facility_id",((String)hash.get("other_source"))==null?"":(String)hash.get("other_source"));
				Enq_dtls.put("facility_name",((String)hash.get("facility_desc"))==null?"":(String)hash.get("facility_desc"));
			}
			else if(Source.equals("OtherF")){
				Enq_dtls.put("facility_id","*F");
				Enq_dtls.put("facility_name",((String)hash.get("facility_name"))==null?"":(String)hash.get("facility_name"));
			}
			else{
				Enq_dtls.put("facility_id","*P");
				Enq_dtls.put("facility_name","");
			}
			Enq_dtls.put("pract_id",((String)hash.get("Pract_id"))==null?"":(String)hash.get("Pract_id"));
			if(Source.equals("WithinF")||Source.equals("LoggedF") || request_mode.equals("S")){ // request_mode - Added for HSA-CRF-0158 [IN:048491] 
				Enq_dtls.put("Pract_name",((String)hash.get("Pract_name"))==null?"":(String)hash.get("Pract_name"));
			}
			else{
				Enq_dtls.put("Pract_name",((String)hash.get("other_pract"))==null?"":(String)hash.get("other_pract"));
			}
			Enq_dtls.put("designation",((String)hash.get("Designation"))==null?"":(String)hash.get("Designation"));
			Enq_dtls.put("pract_type",((String)hash.get("pract_type"))==null?"":(String)hash.get("pract_type"));
			Enq_dtls.put("priority",((String)hash.get("priority"))==null?"":(String)hash.get("priority"));
			Enq_dtls.put("other_priority",((String)hash.get("other_priority"))==null?"":(String)hash.get("other_priority"));
			String enc_dte=(String)hash.get("enc_dt");
			enc_dte =com.ehis.util.DateUtils.convertDate(enc_dte,"DMYHM",locale,"en");
		 
			Enq_dtls.put("enq_dt",(enc_dte)==null?"":enc_dte);
			Enq_dtls.put("request_mode",((String)hash.get("request_mode"))==null?"":(String)hash.get("request_mode"));
			Enq_dtls.put("other_mode",((String)hash.get("other_mode"))==null?"":(String)hash.get("other_mode"));
			Enq_dtls.put("line1",((String)hash.get("line1"))==null?"":(String)hash.get("line1"));
			Enq_dtls.put("line2",((String)hash.get("line2"))==null?"":(String)hash.get("line2"));
			Enq_dtls.put("line3",((String)hash.get("line3"))==null?"":(String)hash.get("line3"));
			Enq_dtls.put("line4",((String)hash.get("line4"))==null?"":(String)hash.get("line4"));
			Enq_dtls.put("Confidential_YN",((String)hash.get("Confidential_YN"))==null?"N":(String)hash.get("Confidential_YN"));
			Enq_dtls.put("rep_line1",((String)hash.get("rep_line1"))==null?"":(String)hash.get("rep_line1"));
			Enq_dtls.put("rep_line2",((String)hash.get("rep_line2"))==null?"":(String)hash.get("rep_line2"));
			Enq_dtls.put("rep_line3",((String)hash.get("rep_line3"))==null?"":(String)hash.get("rep_line3"));
			Enq_dtls.put("rep_line4",((String)hash.get("rep_line4"))==null?"":(String)hash.get("rep_line4"));
			Enq_dtls.put("tel_num",((String)hash.get("tel_num"))==null?"":(String)hash.get("tel_num"));
			Enq_dtls.put("rep_tel_num",((String)hash.get("rep_tel_num"))==null?"":(String)hash.get("rep_tel_num"));
			Enq_dtls.put("fac_num",((String)hash.get("fac_num"))==null?"":(String)hash.get("fac_num"));
			Enq_dtls.put("rep_fac_num",((String)hash.get("rep_fac_num"))==null?"":(String)hash.get("rep_fac_num"));
			Enq_dtls.put("email",((String)hash.get("email"))==null?"":(String)hash.get("email"));
			Enq_dtls.put("rep_email",((String)hash.get("rep_email"))==null?"":(String)hash.get("rep_email"));
			Enq_dtls.put("function_id",((String)hash.get("function_id"))==null?"":(String)hash.get("function_id"));
			Enq_dtls.put("logged_fc_name",((String)hash.get("logged_fc_name"))==null?"":(String)hash.get("logged_fc_name"));
			Enq_dtls.put("Sysdate",((String)hash.get("sysdate"))==null?"":(String)hash.get("sysdate"));
			
			
			Enq_dtls.put("Request_dtl",((String)hash.get("Request_dtl"))==null?"":(String)hash.get("Request_dtl"));
			Enq_dtls.put("p_user_name",((String)hash.get("p_user_name"))==null?"":(String)hash.get("p_user_name"));
			Enq_dtls.put("no_of_records",((String)hash.get("no_of_records"))==null?"":(String)hash.get("no_of_records"));

			String  no_of_records			= (String) hash.get("no_of_records");
			int no_records					= (int)Integer.parseInt(no_of_records);
			String chkBox				= "";
			for(int k=1;k<=no_records;k++){
				if(!((String) hash.get("chk"+k)).equals(""))
					chkBox =chkBox + (String) hash.get("chk"+k)+"$";
			}

			Enq_dtls.put("Req_catg",chkBox);
			Enq_dtls.put("patient_id",((String)hash.get("patient_id"))==null?"":(String)hash.get("patient_id"));
			Enq_dtls.put("patient_name",((String)hash.get("patient_name"))==null?"":(String)hash.get("patient_name"));
			Enq_dtls.put("age",((String)hash.get("age"))==null?"":(String)hash.get("age"));
			Enq_dtls.put("age_unit",((String)hash.get("age_unit"))==null?"":(String)hash.get("age_unit"));
			Enq_dtls.put("gender",((String)hash.get("gender"))==null?"":(String)hash.get("gender"));
			Enq_dtls.put("ethnic_grp",((String)hash.get("ethnic_grp"))==null?"":(String)hash.get("ethnic_grp"));
			Enq_dtls.put("drug_desc",((String)hash.get("Drug"))==null?"":(String)hash.get("Drug"));
			Enq_dtls.put("food_desc",((String)hash.get("food"))==null?"":(String)hash.get("food"));
			Enq_dtls.put("other_desc",((String)hash.get("other_desc"))==null?"":(String)hash.get("other_desc"));
				
			Enq_dtls.put("Response_dtl",((String)hash.get("Response_dtl"))==null?"":(String)hash.get("Response_dtl"));
			Enq_dtls.put("response_remarks",((String)hash.get("remark"))==null?"":(String)hash.get("remark"));
			Enq_dtls.put("response_dt",((String)hash.get("response_dt"))==null?"":(String)hash.get("response_dt"));
			Enq_dtls.put("verified_by",((String)hash.get("verify"))==null?"":(String)hash.get("verify"));
			Enq_dtls.put("no_of_info_chk",((String)hash.get("no_of_info_chk"))==null?"":(String)hash.get("no_of_info_chk"));
			Enq_dtls.put("respond",((String)hash.get("respond"))==null?"":(String)hash.get("respond"));

			String no_of_info_chk			=(String)hash.get("no_of_info_chk");
			int no_info_records					= (int)Integer.parseInt(no_of_info_chk);
			String info_src_chk					= "";
			for(int k=0;k<no_info_records;k++){
				if(!((String) hash.get("info_chk"+k)).equals(""))
					info_src_chk =info_src_chk+(String) hash.get("info_chk"+k)+"$";
			}
			Enq_dtls.put("Info_src",info_src_chk);
			HashMap result= new HashMap();
			if(Enquiry_Num.equals("")){
				result=bean.insertDtl(Enq_dtls);
			}
			else{
				 result=bean.updateDtl(Enq_dtls); 
			}
			String msgid=(String)result.get("message");
			out.println("onSuccess(\""+msgid+"\")");
		}
		else if(func_mode != null && func_mode.equals("SETSIGNEDBYVALUES")){
			String SignedBy = request.getParameter("SignedBy")==null?"":request.getParameter("SignedBy") ;
			String SignedDateTime = request.getParameter("DateTime")==null?"":request.getParameter("DateTime") ;
			String verify_remarks = request.getParameter("verify_remarks")==null?"":request.getParameter("verify_remarks") ;
			bean.setSignedBy(SignedBy);
			bean.setSignedDateTime(SignedDateTime);
			bean.setSignedverify_remarks(verify_remarks);
		}
		else if(func_mode != null && func_mode.equals("setEnquirerDtls")){
			String Enq_num = hash.get("enq_num")==null?"":(String)hash.get("enq_num") ;
			if(!Enq_num.equals("")){
				bean.EnquirerDetails(Enq_num);
			}
		}
		else if(func_mode != null && func_mode.equals("getSysdate")){
				String date=bean.getSysdate();
				out.println("setDate1(\""+date+"\")");
		}
		putObjectInBean(bean_id,bean,request);	
	}catch (Exception e) {
		out.println("alert(\"Exception in PhDrugInfoEnq validation" + e + "\");") ;
		e.printStackTrace();
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
