package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __callpatarrival extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/CallPatArrival.jsp", 1738922829380L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<!--\n\n\tDeveloped by \t:\tR.Nanda Kumar\n\tCreated on \t:\t18/01/2000\n\tModule\t\t:\tOut Patient Management\n\tFunction\t:\tConsultation - Patient Arrival. This file is used to call\n\t\t\t\tthe ConsPatArrival.jsp file from the CallPatArrival.jsp for\n\t\t\t\tdisplaying records based on the arrival.\n-->\n<HTML>\n\t<HEAD>\n\t\t<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n          <!--below line modified for this CRF Bru-HIMS-CRF-133 -->\n\t\t<iframe name=\'PLINE\' id=\'PLINE\' SRC=\'../../eCommon/jsp/pline.jsp?EncounterId=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&Facility_Id=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' noresize  frameborder=no scrolling=no style=\'height:25vh;width:100vw\'></iframe>\n\t\t<iframe name=\'detail\' id=\'detail\' src=\"../../eOP/jsp/ConsPatArrival.jsp?revert_to_check_in=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&Encounter_Id=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&Queue_Status=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&PreviousDay=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&patient_id=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&locn_type=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&locn_code=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&pract_id=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&room_num=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&p_status=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&dt=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&appt_id=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&p_queue_date=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&arrival_date=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&curr_locn=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&curr_locn_type_desc=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&VISIT_ADM_TYPE_IND=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&appt_case_yn=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&other_res_class=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&other_res_code=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&queue_num=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&appt_walk_ind=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&queue_id=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&assign_q_num_by=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&curr_locntype=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&curr_locncode=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&isPatientEncMovement=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&Sydate=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" noresize  frameborder=no marginheight=0 marginwidth=0 style=\'height:52vh;width:100vw\'></iframe>\n\t\t<iframe name=\'dummyframe\' id=\'dummyframe\' src=\'../../eCommon/jsp/error.jsp\' noresize frameborder=no marginheight=0 marginwidth=0 scrolling=no style=\'height:0vh;width:100vw\'></iframe>\n\n\t</HEAD>\n\n</HTML>\n\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

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
			String encounter=request.getParameter("p3");
			String queuestatus=request.getParameter("p1");
			String PreviousDay = request.getParameter("p11");
			String revert_to_check_in = request.getParameter("revert_to_check_in");
			if (revert_to_check_in==null) revert_to_check_in  = "N";
			String facility= (String) session.getValue( "facility_id" ) ;
			/*Below line added for this CRF Bru-HIMS-CRF-133*/
	        String curr_locntype = request.getParameter("curr_locntype")==null?"":request.getParameter("curr_locntype");
	        String curr_locncode = request.getParameter("curr_locncode")==null?"":request.getParameter("curr_locncode");
	        String isPatientEncMovement	= request.getParameter("isPatientEncMovement")==null?"":request.getParameter("isPatientEncMovement");
			String Sydate = request.getParameter("Sydate")==null?"":request.getParameter("Sydate");
	    	//End this CRF Bru-HIMS-CRF-133

			String patient_id=request.getParameter("p2");
			String locn_type=request.getParameter("p4");
			String locn_code=request.getParameter("p5");
			String pract_id=request.getParameter("p6");
			
			String room_num=request.getParameter("p19");

			String p_status=request.getParameter("p15");
			String dt=request.getParameter("p16");
			String appt_id=request.getParameter("p17");
			String p_queue_date=request.getParameter("p18");
			String arrival_date=request.getParameter("p14");
			String curr_locn=request.getParameter("p20");
			String curr_locn_type_desc=request.getParameter("p21");
			String VISIT_ADM_TYPE_IND=request.getParameter("p22");
			String appt_case_yn=request.getParameter("p23");

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

			String assign_q_num_by = request.getParameter("p31") == null?"":request.getParameter("p31");			
		 		
			if (queuestatus.equals("01"))
			{
				out.println("<TITLE>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.FirstTimeArrival.label","op_labels")+"</TITLE>");
			}
			else
			{
				out.println("<TITLE>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ReverttoCheckin.label","op_labels")+"</TITLE>");
			}
		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(encounter));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(facility));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(revert_to_check_in));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(encounter));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(queuestatus));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(PreviousDay));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(pract_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(room_num));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(p_status));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dt));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(appt_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(p_queue_date));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(arrival_date));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(curr_locn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(curr_locn_type_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(VISIT_ADM_TYPE_IND));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(appt_case_yn));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(other_res_class));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(other_res_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(queue_num));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(appt_walk_ind));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(queue_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(assign_q_num_by));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(curr_locntype));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(curr_locncode));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(isPatientEncMovement));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(Sydate));
            _bw.write(_wl_block36Bytes, _wl_block36);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
