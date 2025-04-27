package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __callassign extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/CallAssign.jsp", 1709117133816L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n\t<HEAD>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n</HEAD>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<FRAMESET ROWS=\'14%,*,0%,0%\' framespacing=0>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\n\t\t<FRAMESET ROWS=\'14%,*,0%\' framespacing=0>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n\t\t\t<FRAME NAME=\'PLINE\' SRC=\'../../eCommon/jsp/pline.jsp?EncounterId=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&Facility_Id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' noresize  frameborder=no scrolling=no>\n\t\t\t<frame name=\'detail\' src=\'../../eOP/jsp/QmgmtRe_AssignPract.jsp?encounter_id=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&mode=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&PreviousDay=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&care_locn_id=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&module_id=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&locn_type=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&locn_code=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&practitioner_id=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&patient_id=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&visit_adm_date=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&patientID=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&location_type=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&location_code=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&attend_practitioner_id=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&sex=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&dob=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&p_status=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&dtime=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&p_queue_date=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&room_num=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&appt_id=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&ARRIVE_DATE_TIME=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&VITAL_SIGNS_DATE_TIME=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&other_res_class=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&other_res_code=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="&queue_num=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&appt_walk_ind=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&oper_id=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&queue_id=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&assign_q_num_by=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="&isPatientEncMovement=";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="&Sydate=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="&p_queue_status=";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' noresize frameborder=no marginheight=0 marginwidth=0 scrolling = no>\n\t\t\t<frame name=\'dummyfr\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\'no\'>\n          ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t   <frame name=\'billingfr\' src=\'../../eBL/jsp/BLSessionValuesReset.jsp\' frameborder=0 noresize scrolling=\'no\'>\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n    </FRAMESET>\n</HTML>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
  
			request.setCharacterEncoding("UTF-8");
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
	        response.addHeader("X-Content-Type-Options", "nosniff");
			Connection con=null;
			String p_mode		= request.getParameter("p10");
			String encounter	= request.getParameter("p3");
			String PreviousDay = request.getParameter("p11");
			String facilityid 	= (String) session.getValue( "facility_id" ) ;
			String care_locn_id = request.getParameter("p13");
           	String bl_install_yn= (String) session.getValue( "bl_operational" ) ;
			
			String patientID=request.getParameter("p2");
			String location_type=request.getParameter("p4");
			String location_code=request.getParameter("p5");
			String attend_practitioner_id=request.getParameter("p6");
            String oper_id=request.getParameter("oper_id")==null?"":request.getParameter("oper_id");
			String sex=request.getParameter("p8");
			String dob=request.getParameter("p9");

			String p_status=request.getParameter("p15");
			String dtime=request.getParameter("p16");
			String p_queue_date  =request.getParameter("p18");
			String room_num =request.getParameter("p19");
			String appt_id =request.getParameter("p17");
			String ARRIVE_DATE_TIME=request.getParameter("p24");
			String VITAL_SIGNS_DATE_TIME=request.getParameter("p25");
			String other_res_class=request.getParameter("p26");
			if(other_res_class == null) other_res_class="";

			String other_res_code=request.getParameter("p27");
			if(other_res_code == null) other_res_code="";

			String queue_num=request.getParameter("p28");
			if(queue_num == null) queue_num="0";

			String appt_walk_ind=request.getParameter("p29");
			if(appt_walk_ind == null) appt_walk_ind="";
			String queue_id=request.getParameter("p30");
			if(queue_id == null) queue_id="";

			String assign_q_num_by = request.getParameter("assign_q_num_by")==null?"":request.getParameter("assign_q_num_by");
			
			if(assign_q_num_by == ""){
				assign_q_num_by=request.getParameter("p31");
			}
			// Thru CA module Starts
			String module_id=request.getParameter("module_id");
			if(module_id == null) module_id="";
			String locn_type=request.getParameter("locn_type");
			String locn_code=request.getParameter("locn_code");
			String practitioner_id=request.getParameter("practitioner_id");
			String visit_adm_date=request.getParameter("visit_adm_date");
			String patient_id=request.getParameter("patient_id");
			String case_type="";
			String ref_id="";
            //ends
		  /*Below line added for this CRF Bru-HIMS-CRF-133*/	
        String p_queue_status=request.getParameter("p1");		  
	    String isPatientEncMovement	= request.getParameter("isPatientEncMovement")==null?"":request.getParameter("isPatientEncMovement");	   
		String Sydate = request.getParameter("Sydate")==null?"":request.getParameter("Sydate");
		//End Bru-HIMS-CRF-133  	
					
			
		if(module_id.equals("CA"))
		{     		
			con=ConnectionManager.getConnection(request);
		 try{
    		
			String sql="SELECT APPT_ID, OTHER_RES_CLASS, OTHER_RESOURCE_ID, QUEUE_NUM, APPT_OR_WALK_IN_IND  CASE_TYPE, REFERRAL_ID FROM  OP_CURRENT_PATIENT WHERE facility_id = '"+facilityid+"' AND encounter_id='"+encounter+"'";
			
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();

			  if(rs!=null)
				{
					if(rs.next())
					{
						
						appt_id				=   rs.getString("appt_id");
						if(appt_id == null) appt_id="";
						other_res_class		=   rs.getString("OTHER_RES_CLASS");
						if(other_res_class == null) other_res_class="";
						other_res_code		=   rs.getString("OTHER_RESOURCE_ID");
						if(other_res_code == null) other_res_code="";
						queue_num			=   rs.getString("QUEUE_NUM");
						ref_id				=   rs.getString("REFERRAL_ID");
						if(ref_id == null) ref_id="";
						case_type			= rs.getString("CASE_TYPE");
						if(!(appt_id.equals("") && ref_id.equals("")))
							appt_walk_ind="A";
						else if(!ref_id.equals(""))
							appt_walk_ind="R";
						else
							appt_walk_ind=case_type;

					}
				}
				if(rs != null) rs.close(); 
				if(pstmt != null) pstmt.close();
			}catch(Exception e )
			{
				e.printStackTrace();
			}finally
			{
				if(con != null) ConnectionManager.returnConnection(con,request);
			}
		}
	
			if(p_mode.equals("A"))
			{out.println("<TITLE>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.assignpractitioner.label","op_labels")+"</TITLE>");
				
			}
			else
			{out.println("<TITLE>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.reassignpractitioner.label","op_labels")+"</TITLE>");
				
			}
/*Below line modified for this CRF Bru-HIMS-CRF-133*/			
		
            _bw.write(_wl_block6Bytes, _wl_block6);
 if(bl_install_yn.equals("Y")){
            _bw.write(_wl_block7Bytes, _wl_block7);
}else{
            _bw.write(_wl_block8Bytes, _wl_block8);
}
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(encounter));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encounter));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_mode));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(PreviousDay));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(care_locn_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patientID));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(attend_practitioner_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(p_status));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(dtime));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(p_queue_date));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(room_num));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(appt_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(ARRIVE_DATE_TIME));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(VITAL_SIGNS_DATE_TIME));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(other_res_class));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(other_res_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(queue_num));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(appt_walk_ind));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(oper_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(queue_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(assign_q_num_by));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(isPatientEncMovement));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(Sydate));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(p_queue_status));
            _bw.write(_wl_block44Bytes, _wl_block44);
 if(bl_install_yn.equals("Y")){
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block46Bytes, _wl_block46);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
