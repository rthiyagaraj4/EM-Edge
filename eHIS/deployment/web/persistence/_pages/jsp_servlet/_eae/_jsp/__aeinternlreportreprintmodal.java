package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.net.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __aeinternlreportreprintmodal extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AeinternlReportReprintModal.jsp", 1743148980165L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<html>\n<head>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n</head>\n<body onKeyDown = \'lockKey()\'>\n<form name=\"reprint_op_reports\" id=\"reprint_op_reports\">\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);



			Connection con          = null;
			PreparedStatement pstmt = null;
			ResultSet rs            = null;
			request.setCharacterEncoding("UTF-8");
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
			response.addHeader("X-Content-Type-Options", "nosniff");
			
			String facilityId       = (String) session.getValue("facility_id");
			String locale			= (String)session.getAttribute("LOCALE");
			String user_id          = (String) session.getValue("login_user");
			String Encounterid      = request.getParameter("encounterid");
			String Patient_Id	    = "";
			String Clinic_Code	    = "";
			String Clinic_Type	    = "";
			String visit_type_code="";
			String file_type_yn = "";
			String new_file_no = "";
			String sStyle	        =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		try
		{
			con   = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement("Select PATIENT_ID, ASSIGN_CARE_LOCN_CODE, ASSIGN_CARE_LOCN_TYPE, VISIT_ADM_TYPE From PR_ENCOUNTER Where facility_id = '"+facilityId+"' and Encounter_id = "+Encounterid+" ");
			rs    = pstmt.executeQuery();

			if(rs.next())
			{
				Patient_Id	= rs.getString("PATIENT_ID");
				Clinic_Code	= rs.getString("ASSIGN_CARE_LOCN_CODE");
				Clinic_Type	= rs.getString("ASSIGN_CARE_LOCN_TYPE");
				visit_type_code = rs.getString("VISIT_ADM_TYPE");
			}

				if(pstmt!=null) pstmt.close();
				if(rs!=null)rs.close();
				pstmt = con.prepareStatement("select file_type_appl_yn from mp_param");
				rs    = pstmt.executeQuery();	
				if(rs.next()){
					file_type_yn	= rs.getString("file_type_appl_yn");
				}

				if(pstmt!=null) pstmt.close();
				if(rs!=null)rs.close();
				if(file_type_yn.equals("Y")){
					pstmt = con.prepareStatement("select file_no from mr_pat_file_index where facility_id = '"+facilityId+"' and patient_id = '"+Patient_Id+"'  	and file_type_code=(select dflt_file_type_code from op_clinic where facility_id = '"+facilityId+"' and clinic_code = '"+Clinic_Code+"')");
					rs    = pstmt.executeQuery();	
					if(rs.next()){
						new_file_no 	= rs.getString("file_no");
					}
				}else{
					pstmt = con.prepareStatement("select file_no from mr_pat_file_index where facility_id = '"+facilityId+"' and patient_id = '"+Patient_Id+"'  and  rownum < 2");
					rs    = pstmt.executeQuery();	
					if(rs.next()){
						new_file_no 	= rs.getString("file_no");
					}
				}

				String req_no = "";
				String sqlString = "";
				String req_to_fs_locn_code = "";
				
				
				String sql1 = "select req_no,req_to_fs_locn_code from fm_req_dtl where curr_facility_id ='"+facilityId+"' and encounter_id='"+Encounterid+"' and rownum < 2 ";
				
				pstmt = con.prepareStatement(sql1);
				rs    = pstmt.executeQuery();	
				if(rs.next()){
					req_no	= rs.getString("req_no");
					req_to_fs_locn_code	= rs.getString("req_to_fs_locn_code");
				}

				if(pstmt!=null) pstmt.close();
				if(rs!=null)rs.close();

				String online_mr_notfn_yn ="N";
				String sql2 = "select online_mr_notfn_yn from op_clinic where clinic_code = '"+Clinic_Code+"' and facility_id = '"+facilityId+"' and eff_status = 'E' ";	
				 
				pstmt=con.prepareStatement(sql2);
				rs=pstmt.executeQuery();			
					if(rs != null) {
						 if(rs.next()) {
							 online_mr_notfn_yn=rs.getString("online_mr_notfn_yn");									
							 if(online_mr_notfn_yn == null) online_mr_notfn_yn="";						
						 }
					}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				 
				if(!req_no.equals("") && online_mr_notfn_yn.equals("Y")) {
					sqlString="select distinct report_id,SM_GET_DESC.SM_REPORT(module_id,report_id,'"+locale+"','1') report_desc, 1 no_of_copies,  module_id from ae_online_report_vw where OPERATING_FACILITY_ID='"+facilityId+"' and (clinic_code='"+Clinic_Code+"' or clinic_code ='*All') and (VISIT_TYPE_CODE='"+visit_type_code+"' OR VISIT_TYPE_CODE='*A') order by 2";
				} else {
				
					sqlString="select distinct report_id,SM_GET_DESC.SM_REPORT(module_id,report_id,'"+locale+"','1') report_desc, 1 no_of_copies,  module_id from ae_online_report_vw where OPERATING_FACILITY_ID='"+facilityId+"' and (clinic_code='"+Clinic_Code+"' or clinic_code ='*All') and (VISIT_TYPE_CODE='"+visit_type_code+"' OR VISIT_TYPE_CODE='*A')  and report_id not in ('FMFLRQSL'";  
					if(new_file_no!=null && new_file_no.equals(""))
						sqlString = sqlString+",'MPBFLLBL'";
					sqlString=sqlString+")order by 2";
				}			
			 
			String p_call_from = "WALKIN";
			String reportParamNames = "p_encounter_id,p_call_from,p_clinic_code,p_clinic_type,p_patient_id,p_user_name,p_req_no,p_file_no";
			String reportParamValues = ""+Encounterid+","+p_call_from+","+Clinic_Code+","+Clinic_Type+","+Patient_Id+","+user_id+","+req_no+","+new_file_no+"";
			StringBuffer htmlFor  = new StringBuffer();			

			htmlFor.append("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
			htmlFor.append("</head><body class='message' onKeyDown = 'lockKey()'>");
			htmlFor.append("<script language = 'JavaScript'>");
			htmlFor.append("var dialogHeight = '75vh' ;");
			htmlFor.append("var dialogWidth = '75vw' ;");
			htmlFor.append("var dialogTop = '65' ;");
			htmlFor.append("var arguments =   ''; ");
			// modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the below Query String.
			htmlFor.append("var getUrl    = '../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=AEINTERNALREP&step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&EncounterId="+Encounterid+"&dest_locn_type="+Clinic_Type+"&dest_locn_code="+Clinic_Code+"&perm_fs_locn_code="+req_to_fs_locn_code+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';");
			htmlFor.append(" var features  = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; dialogTop:' + dialogTop +'; status=no;' ;");
			htmlFor.append("retVal = window.showModalDialog(getUrl,arguments,features); ");
			htmlFor.append("</script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
			out.println(htmlFor.toString());
			// Tuesday, January 12, 2010 18111
			out.println("<script> parent.f_query_add_mod.location.reload(); </script>");
			//out.println("<script>  history.go(-1); </script>");
			htmlFor.setLength(0);
		}
		catch(Exception e)
		{  e.printStackTrace();	}	
		finally
		{
			if(pstmt!=null) pstmt.close();
			if(rs!=null)rs.close();
			if(con != null)
			ConnectionManager.returnConnection(con, request);
		}
	
            _bw.write(_wl_block6Bytes, _wl_block6);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
