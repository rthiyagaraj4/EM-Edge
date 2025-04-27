package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import webbeans.eCommon.*;
import eCommon.Common.*;

public final class __getpatientstatus_chknationalid extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/getPatientStatus_chkNationalId.jsp", 1709116997908L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="          \n            \n            \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

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

	request.setCharacterEncoding("UTF-8");
	Connection conn			= null;
	conn=ConnectionManager.getConnection(request);
	try{
		
		String facility_id		= (String) session.getValue( "facility_id" ) ;
		String action			= request.getParameter("action")==null?"":request.getParameter("action");
		
		if(action.equals("chk_valid_patient")){
			String patientId		= request.getParameter("patientId")==null?"":request.getParameter("patientId");
			String national_id_chk	= request.getParameter("national_id_chk")==null?"":request.getParameter("national_id_chk");
			webbeans.op.PatientData patdata = new  webbeans.op.PatientData();
			patdata.setFacility_id(facility_id);
			String pat_status = patdata.CheckStatus(conn,patientId);
			
			pat_status		= pat_status==null?"":pat_status;
			
			if(pat_status.equals("") && national_id_chk.equals("Y")){
				
				HashMap ResultParamHashMap = new HashMap();
				HashMap sqlColumns = new HashMap();
				sqlColumns.put("NATIONAL_ID_NO","S");
				sqlColumns.put("CITIZEN_YN","S");
				sqlColumns.put("PAT_DTLS_UNKNOWN_YN","S");
				String whereClause	= "where patient_id='"+patientId+"'";
				ResultParamHashMap = CommonBean.getParamDetails(sqlColumns,whereClause,"MP_PATIENT",conn);
				String NATIONAL_ID_NO = (String) ResultParamHashMap.get("NATIONAL_ID_NO");
				NATIONAL_ID_NO		= NATIONAL_ID_NO==null?"":NATIONAL_ID_NO;

				String citizen_yn = (String) ResultParamHashMap.get("CITIZEN_YN");
				citizen_yn		= citizen_yn==null?"N":citizen_yn;

				String pat_dtls_unknown_yn = (String) ResultParamHashMap.get("PAT_DTLS_UNKNOWN_YN");
				pat_dtls_unknown_yn		= pat_dtls_unknown_yn==null?"N":pat_dtls_unknown_yn;


				if(citizen_yn.equals("N")){
					pat_status	= "NRIC_FOR_NONCITIZEN";
				}else if(pat_dtls_unknown_yn.equals("Y")){
					pat_status	= "CAN_NOT_MERGE_UNKNOWN_PATIENT";
				}else if(!NATIONAL_ID_NO.equals("")){
					pat_status	= "NATIONAL_ID_EXISTS";
				}
				sqlColumns.clear();
				ResultParamHashMap.clear();
			}

			out.println(pat_status);
		}else if(action.equals("chk_national_id")){
			String nationalIdStatus	= "";
			String nationalId				= request.getParameter("nationalId")==null?"":request.getParameter("nationalId");
			String invoke_routine			= request.getParameter("invoke_routine")==null?"":request.getParameter("invoke_routine");
			String invoke_routine_name		= request.getParameter("invoke_routine_name")==null?"":request.getParameter("invoke_routine_name");
			String nat_id_check_digit_id	= request.getParameter("nat_id_check_digit_id")==null?"":request.getParameter("nat_id_check_digit_id");
			String result					= "";
			HashMap ResultParamHashMap = new HashMap();
			HashMap sqlColumns = new HashMap();
			sqlColumns.put("patient_id","S");
			String whereClause	= "where national_id_no='"+nationalId+"'";
			ResultParamHashMap = CommonBean.getParamDetails(sqlColumns,whereClause,"MP_PATIENT",conn);
			nationalIdStatus = (String) ResultParamHashMap.get("patient_id");
			sqlColumns.clear();
			ResultParamHashMap.clear();

			nationalIdStatus		= nationalIdStatus==null?"":nationalIdStatus;

			if(!nationalIdStatus.equals("")){
				nationalIdStatus	= "DUP_NAT_ID";
			}
			
			if(nationalIdStatus.equals("") && !nat_id_check_digit_id.equals("")){
				sqlColumns.put("program_name","S");
				String whereClause1						= "where scheme_id='"+nat_id_check_digit_id+"'";
				ResultParamHashMap						= CommonBean.getParamDetails(sqlColumns,whereClause1,"MP_CHECK_DIGIT_SCHEME",conn);
				String nat_id_check_digit_function		= (String) ResultParamHashMap.get("program_name");
				sqlColumns.clear();
				ResultParamHashMap.clear();
				if(!nat_id_check_digit_id.equals("")){
					nationalIdStatus	= CommonBean.verifyCheckDigitSchemeForNationalId(conn,nationalId,nat_id_check_digit_function);
					if(nationalIdStatus.equals("N")){
						nationalIdStatus	= "INVALID_NAT_ID";
					}else{
						nationalIdStatus	= "";
					}
				}
			}

			if(nationalIdStatus.equals("") && invoke_routine.equals("Y") && !invoke_routine_name.equals("")){
				nationalIdStatus	= CommonBean.verifyNationalId(conn,nationalId);
			}

			out.println(nationalIdStatus);
		}

		
	}catch(Exception e) { 
		e.printStackTrace();
		
	}finally{ 
		if(conn != null) {
			ConnectionManager.returnConnection(conn,request);
		}	
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
}
