package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;

public final class __insbedpat extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/Insbedpat.jsp", 1709113877490L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n      \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eAE/js/AEUtilities.js\'></script>\n<script language=\'javascript\' src=\'../../eAE/js/AEManagePatientGI.js\'></script>\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="<script>\n\t\t\t\t\n\t\t\t\t\n\t\t\t\talert( getMessage(\'RECORD_INSERTED\',\'SM\'));\n\t\t\t\tparent.frames[0].document.forms[0].refresh.click();\n\t\t\t\n\t\t\t\t\n\t\t\t\t</script>";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="<script>alert(\'Transaction failed 1 \');parent.frames[0].document.forms[0].refresh.click();\n\t\t\t\t\t</script>";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t<script>\n\t\t\t\talert(\'patient currently occupies another bed\');\n\t\t\t\tparent.frames[0].document.forms[0].refresh.click();\n\t\t\t</script>\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t<script>\n\t\talert( getMessage(\'SECURED_NOT_ALLOWED\',\'Common\'));\n\t\tparent.frames[0].document.forms[0].refresh.click();\n\t</script>\n\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="<script>\n\t\t\t\t\talert( getMessage(\'RECORD_INSERTED\',\'SM\'));\n\t\t\t\t\tparent.frames[0].document.forms[0].refresh.click();</script>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t<script>\n\t\t\t\t\talert(\'Transaction failed 2\');\n\t\t\t\t\tparent.frames[0].document.forms[0].refresh.click();\n\t\t\t\t</script>\n\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="<script>alert(\'Transaction failed 3\');\n\t\t\tparent.frames[0].document.forms[0].refresh.click();</script>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<script></script>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\t\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

request.setCharacterEncoding("UTF-8");
Connection con = null;
PreparedStatement pstmt = null;
Statement stmt = null;
PreparedStatement pstmt1 = null;
PreparedStatement pstmt2 = null;
PreparedStatement pstmt3 = null; 
java.util.Properties p 		= null;
String client_ip_address="";
String user_id="";
int rs=0;
int rs1=0;
ResultSet rset=null;

try{
	con = ConnectionManager.getConnection(request);
	String facilityId				=(String) session.getValue("facility_id");
	String clinic_code				=request.getParameter("clinic_code");
	String practitioner_id			=request.getParameter("practitioner_id");
	String encounter_id				=request.getParameter("encounter_id");	
	String treatment_area_code		=request.getParameter("treatment_area_code");
	String bed_no					=request.getParameter("bed_no");
	String patient_id				=request.getParameter("patient_id");
	String service_code				=request.getParameter("service_code");
	String mode				=request.getParameter("mode");
	
	p = (java.util.Properties) session.getValue( "jdbc" ) ;
	client_ip_address = p.getProperty("client_ip_address");
	user_id	= (String)session.getValue("login_user") ;



	if(mode.equals("BookBed")){
	
			if(true){
		stmt=con.createStatement();
		rset=stmt.executeQuery("select '1' from ae_bed_for_trmt_area where occupying_patient_id='"+patient_id+"' and facility_id='"+facilityId+"'");
		
		boolean occupy_flag=false;

		if(rset!=null){
			if(rset.next())
				occupy_flag=true;
		}
		if(rset!=null) rset.close();
        if(stmt!=null) stmt.close();


		if(!occupy_flag){

			con.setAutoCommit( false );

			String sql1="update op_patient_queue set treatment_area_code = '"+treatment_area_code+"',  ae_bed_no = '"+bed_no+"',  practitioner_id = '"+practitioner_id+"', modified_by_id = '"+user_id+"', modified_date = SYSDATE,  modified_at_ws_no = '"+client_ip_address+"', modified_facility_id = '"+facilityId+"' where facility_id = '"+facilityId+"' and encounter_id = '"+encounter_id+"'";

			
			String sql2="update AE_BED_FOR_TRMT_AREA set OCCUPYING_PATIENT_ID =  '"+patient_id+"',CURRENT_STATUS ='O' where FACILITY_ID = '"+facilityId+"' AND  CLINIC_CODE = '"+clinic_code+"' AND  TREATMENT_AREA_CODE = '"+treatment_area_code+"' AND BED_NO = '"+bed_no+"'";

			String sql3="insert into ae_pat_movement_log (patient_id,facility_id,encounter_id,assign_tmt_area_code,assign_bed_no,assign_practitioner_id,assign_date,assign_clinic_code,added_facility_id,added_date,added_by_id,added_at_ws_no,service_code) 	values ('"+patient_id+"','"+facilityId+"','"+encounter_id+"','"+treatment_area_code+"','"+bed_no+"','"+practitioner_id+"',sysdate,'"+clinic_code+"','"+facilityId+"',sysdate,'"+user_id+"','"+client_ip_address+"','"+service_code+"')";

			String sql4="update pr_encounter set ATTEND_PRACTITIONER_ID = '"+practitioner_id+"', modified_by_id = '"+user_id+"', modified_date = SYSDATE, modified_at_ws_no = '"+client_ip_address+"', modified_facility_id = '"+facilityId+"', service_code = '"+service_code+"' where facility_id = '"+facilityId+"' and encounter_id='"+encounter_id+"'";

			 pstmt = con.prepareStatement(sql1);
			 pstmt1 = con.prepareStatement(sql2);
			 pstmt2 = con.prepareStatement(sql3);
			 pstmt3 =  con.prepareStatement(sql4);

			
			rs=pstmt.executeUpdate();
			
			rs1=pstmt1.executeUpdate();
			


			if(rs>0 && rs1>0 ){
				con.commit();
				
            _bw.write(_wl_block3Bytes, _wl_block3);
	
			}else{
				con.rollback();
				
            _bw.write(_wl_block4Bytes, _wl_block4);

			}
		}else{
			
            _bw.write(_wl_block5Bytes, _wl_block5);

		    if(pstmt!=null) pstmt.close();
			if(pstmt1!=null) pstmt1.close();
             
			}

	}else{
            _bw.write(_wl_block6Bytes, _wl_block6);
}
	}else{
		try{
			String sql4="update ae_bed_for_trmt_area set current_status='A',reason_for_reserve='' where facility_id='"+facilityId+"' and clinic_code='"+clinic_code+"' and treatment_area_code='"+treatment_area_code+"' and bed_no='"+bed_no+"' ";

			pstmt3 =  con.prepareStatement(sql4);



			rs=pstmt3.executeUpdate();
			if(rs>0){
				
            _bw.write(_wl_block7Bytes, _wl_block7);


			}else{
				
            _bw.write(_wl_block8Bytes, _wl_block8);


			}

		}catch( Exception e ){
			e.printStackTrace();
			
            _bw.write(_wl_block9Bytes, _wl_block9);


		}
		finally
		{
			
			if(pstmt3!=null) pstmt3.close();
		
		}

	}
}
catch( Exception e ){
	con.rollback();
	e.printStackTrace();
	
            _bw.write(_wl_block10Bytes, _wl_block10);

}
finally
{
	if(pstmt!=null) pstmt.close();
	if(pstmt1!=null) pstmt1.close();
	if(pstmt2!=null) pstmt2.close();
	if(pstmt3!=null) pstmt3.close();
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block11Bytes, _wl_block11);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
