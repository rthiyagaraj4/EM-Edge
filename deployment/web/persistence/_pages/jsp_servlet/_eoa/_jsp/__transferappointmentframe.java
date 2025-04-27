package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __transferappointmentframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/TransferAppointmentFrame.jsp", 1733394548073L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n12/08/2011    IN027165       Chowminya   Incident No: IN027165 - <Future order linked orders reschedule - started date update issue> \t\t\t\t\t\t\t\t\t\t \n---------------------------------------------------------------------------------------------------------------\n--> \n\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="  \n\n<html>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<!--below title modified aganist ML-MMOH-CRF-609 by Mano-->\n<head><title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" (";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =")</title>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<head><title>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</title>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<!-- <frameset rows=\'*,8%\'>\n\t\t\t<frameset cols=\'30%,*\'>\n\t\t\t\t<frame name=\'apptdairy\' src=\'../../eOA/jsp/ApptDairy.jsp?";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' noresize frameborder=0 scrolling=\'no\'>\n\t\t\t\t\t<frameset rows=\'10%,20%,*\'>\n\t\t\t\t\t\t<frame name=\'appt_pat_details\' src=\'../../eOA/jsp/DisplayApptPatDetails.jsp?";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' noresize frameborder=0 >\n\t\t\t\t\t\t<frame name=\'appt_details\' src=\'../../eOA/jsp/DisplayApptDetails.jsp?";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' noresize frameborder=0>\n\t\t\t\t\t\t<frame name=\'DispOAResult\' src=\'../../eOA/jsp/DisplayOAResultsForTransfer.jsp?";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' noresize frameborder=0>\n\t\t\t\t\t</frameset>\t\t\t\t\t\n\t\t\t</frameset>\n\t\t\t\t<frame name=\'DispOAResultCB\' src=\'../../eOA/jsp/CheckBoxDisplayDairy.jsp\' noresize frameborder=\'0\' scrolling=\'no\'>\t\t\n\t\t</frameset>  -->\n\t\t\t\t <iframe name=\'apptdairy\' id=\'apptdairy\' src=\'../../eOA/jsp/ApptDairy.jsp?";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' noresize frameborder=\'0\' scrolling=\'no\' style=\'height:92vh;width:30vw\' align=\'left\'></iframe>\n\t\t\t\t\t\t<iframe name=\'appt_pat_details\' id=\'appt_pat_details\' align=\'right\' src=\'../../eOA/jsp/DisplayApptPatDetails.jsp?";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' noresize frameborder=\'0\' style=\'height:13vh;width:65vw\'></iframe>\n\t\t\t\t\t\t<iframe name=\'appt_details\' id=\'appt_details\' align=\'right\' src=\'../../eOA/jsp/DisplayApptDetails.jsp?";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' noresize frameborder=\'0\' style=\'height:20vh;width:65vw\'></iframe>\n\t\t\t\t\t\t<iframe name=\'DispOAResult\' id=\'DispOAResult\' align=\'right\' src=\'../../eOA/jsp/DisplayOAResultsForTransfer.jsp?";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' noresize frameborder=\'0\' style=\'height:60vh;width:65vw\'></iframe>\t\t\t\t\t\n\t\t\t\t<iframe name=\'DispOAResultCB\' id=\'DispOAResultCB\' src=\'../../eOA/jsp/CheckBoxDisplayDairy.jsp\' noresize frameborder=\'0\' scrolling=\'no\' style=\'height:8vh;width:100vw\'></iframe>\t\n\t\t\n\t</head>\n</html>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
PreparedStatement pstmt =null;
String appt_day1 = request.getParameter("appt_day1");
String locale=(String)session.getAttribute("LOCALE");
if (appt_day1==null) appt_day1="";
if (!(appt_day1.equals(""))){
	if(appt_day1.equals("Sunday"))	{
		appt_day1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
	}else if(appt_day1.equals("Monday")){
		appt_day1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
	}else if(appt_day1.equals("Tuesday")){
		appt_day1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
	}else if(appt_day1.equals("Wednesday")){
		appt_day1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
	}else if(appt_day1.equals("Thursday")){
		appt_day1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
	}else if(appt_day1.equals("Friday")){
		appt_day1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
	}else if(appt_day1.equals("Saturday")){
		appt_day1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
	}
}
String i_appt_date = request.getParameter("i_appt_date");
Connection con=null;
ResultSet rs=null;
String visit_limit_rule="";
String slot_appt_ctrl="";
String alcn_criteria="";
String appt_ref_no=request.getParameter("i_appt_ref_no");
String facilityid=(String)session.getValue("facility_id");
String old_visit_type_ind1 = "";
String old_alcn_catg_code1 = "";
int no_of_slots_value1 = 0;
String patient_id1 = "";
String old_pract_id1 = "";
String old_clinic_code = "";
int curr_month=0;
String order_catalog_code="";
String order_id=request.getParameter("order_id");//--[IN027165]
try{
	con=ConnectionManager.getConnection(request);
	String alcn_crit="select slot_appt_ctrl ,visit_limit_rule,alcn_criteria,(select to_char(sysdate,'mm')from dual) curmon  from oa_param where module_id='OA' ";
	pstmt=con.prepareStatement(alcn_crit);
	rs = pstmt.executeQuery();
	while (rs !=null && rs.next()){
		visit_limit_rule= rs.getString("visit_limit_rule");
		slot_appt_ctrl  = rs.getString("slot_appt_ctrl");
		alcn_criteria= rs.getString("alcn_criteria");
		if(alcn_criteria==null) alcn_criteria="";
		curr_month= rs.getInt("curmon");
	}
	if(rs !=null) rs.close();
	if(pstmt !=null) pstmt.close();
	alcn_crit="select a.practitioner_id,a.clinic_code,a.patient_id,a.alcn_catg_code,b.visit_type_ind,a.no_of_slots,a.order_catalog_code from oa_appt a, op_visit_type b where a.facility_id = ? and a.appt_ref_no=? and b.facility_id = a.facility_id and b.visit_type_code = a.appt_type_code ";
	pstmt=con.prepareStatement(alcn_crit);
	pstmt.setString(1,facilityid);
	pstmt.setString(2,appt_ref_no);	
	rs = pstmt.executeQuery();
	while (rs !=null && rs.next()){
		old_visit_type_ind1 = rs.getString("visit_type_ind");
		old_alcn_catg_code1=rs.getString("alcn_catg_code");
		if(old_alcn_catg_code1==null  || old_alcn_catg_code1.equals("")){
			old_alcn_catg_code1="";
		}
		no_of_slots_value1=rs.getInt("no_of_slots");
		patient_id1=rs.getString("patient_id");
		if(patient_id1==null) patient_id1="";
		old_pract_id1=rs.getString("practitioner_id");
		if(old_pract_id1==null) old_pract_id1="";
		order_catalog_code=rs.getString("order_catalog_code")==null?"":rs.getString("order_catalog_code");
		old_clinic_code=rs.getString("clinic_code")==null?"":rs.getString("clinic_code");
	}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
}catch(Exception ex){
	//out.println("Exception " +  ex);
	ex.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}finally{
	if(con!=null) 	ConnectionManager.returnConnection(con,request);
}
if (appt_day1==null) appt_day1="";
String i_appt_date_display=DateUtils.convertDate(i_appt_date,"DMY","en",locale);
if (!(appt_day1.equals(""))){

            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            out.print( String.valueOf(i_appt_date_display));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(appt_day1));
            _bw.write(_wl_block9Bytes, _wl_block9);

}else{

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
}
            _bw.write(_wl_block12Bytes, _wl_block12);

	/*old_clinic_code passed by S.Sathish for IN019815 onMonday, March 15, 2010, //modified - [IN027165]*/
		String s=request.getQueryString()+"&visit_limit_rule="+visit_limit_rule+"&slot_appt_ctrl="+slot_appt_ctrl+"&old_visit_type_ind1="+old_visit_type_ind1+"&old_alcn_catg_code1="+old_alcn_catg_code1+"&no_of_slots_value1="+no_of_slots_value1+"&patient_id1="+patient_id1+"&old_pract_id1="+old_pract_id1+"&curr_month="+curr_month+"&order_catalog_code="+order_catalog_code+"&old_clinic_code="+old_clinic_code+"&order_id="+order_id;		
		
		
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(s));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(s));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(s));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(s));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(s));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(s));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(s));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(s));
            _bw.write(_wl_block21Bytes, _wl_block21);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.RescheduleAppointmentfor.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RescheduleAppointment.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }
}
