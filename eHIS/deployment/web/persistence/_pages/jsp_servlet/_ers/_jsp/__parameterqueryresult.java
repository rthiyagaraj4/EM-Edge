package jsp_servlet._ers._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import java.net.URLEncoder;
import eRS.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;
import eCommon.Common.*;
import java.util.*;

public final class __parameterqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/ParameterQueryResult.jsp", 1709121643465L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n*\tCopyright � MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED\n*\tApplication\t\t:\teRS\n*\tPurpose \t\t\t:\n*\tCreated By\t\t:\tSuchilagna Panigrahi\n*\tCreated On\t\t:\t29th Dec 2004\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonResult.js\"></Script>\n<!-- <script language=\"JavaScript\" src=\"../../eCommon/js/MstCodeCommon.js\"></script>\n --><script language=\'javascript\' src=\'../../eCommon/js/common.js\' ></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../js/Parameter.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n<BODY class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<table cellpadding=0 cellspacing=0 width=\"98%\" align=\"center\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"80%\" class=\"white\">&nbsp;</td>\n\t\t\t\t\t<td width=\"20%\" class=\"white\">&nbsp;\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<table cellpadding=0 cellspacing=0 border=1 width=\'98%\' align=\"center\">\n\t\t\t<tr>\n\t\t\t\t<th>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t</table>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));history.go(-1);\n\t\t\t</script>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String classvalue = "";
	try{

        boolean searched = request.getParameter( "searched" ) == null? false : true;
	
		//Common parameters.
		HashMap sqlMap = new HashMap();
		//include all the common parameters.
		//String SelectSql="select a.facility_id, nvl (b.facility_name, 'Enterprise') fac_name, a.overlap_shifts_in_workplace_yn, a.work_cycle_basis, a.period_for_work_schedule_gen, a.max_continuous_work_duration,a.staff_subs_same_grade_yn, a.staff_subs_high_to_low_yn, a.staff_subs_low_to_high_yn, a.attendance_feature_reqd_yn, a.max_durn_to_mark_attendance, a.vald_staff_acc_by_work_sch_yn,a.vald_staff_acc_by_att_yn, a.curr_shift_allocation_yn, a.curr_shift_change_yn, a.curr_shift_cancellation_yn, a.curr_shift_transfer_yn, a.curr_shift_swap_yn, a.curr_shift_overtime_yn, a.curr_shift_leave_yn,a.durn_for_allocation_from_sos, a.durn_for_change_from_sos, a.durn_for_transfer_from_sos, a.durn_for_swap_from_sos, a.durn_for_overtime_from_sos,  a.durn_for_leave_from_sos,a.durn_for_cancel_from_sos from rs_parameter a, sm_facility_param b WHERE b.facility_id(+) = a.facility_id order by fac_name";
		String SelectSql="select a.facility_id, nvl (b.facility_name, 'Enterprise') fac_name, a.overlap_shifts_in_workplace_yn, a.work_cycle_basis, a.period_for_work_schedule_gen, a.max_continuous_work_duration,a.staff_subs_same_grade_yn, a.staff_subs_high_to_low_yn, a.staff_subs_low_to_high_yn, a.attendance_feature_reqd_yn, a.max_durn_to_mark_attendance, a.vald_staff_acc_by_work_sch_yn,a.vald_staff_acc_by_att_yn, a.curr_shift_allocation_yn, a.curr_shift_change_yn, a.curr_shift_cancellation_yn, a.curr_shift_transfer_yn, a.curr_shift_swap_yn, a.curr_shift_overtime_yn, a.curr_shift_leave_yn,a.durn_for_allocation_from_sos, a.durn_for_change_from_sos, a.durn_for_transfer_from_sos, a.durn_for_swap_from_sos, a.durn_for_overtime_from_sos,  a.durn_for_leave_from_sos,a.durn_for_cancel_from_sos from rs_parameter a, sm_facility_param_lang_vw b WHERE b.facility_id(+) = a.facility_id and b.language_id(+) = ? ";

		String facility_id="";
		String facility_name="";
		String overlap_shifts_in_workplace_yn="";
		String work_cycle_basis="";
		String period_for_work_schedule_gen="";
		String max_continuous_work_duration="";
		String staff_subs_same_grade_yn="";
		String staff_subs_high_to_low_yn="";
		String staff_subs_low_to_high_yn="";
		String attendance_feature_reqd_yn="";
		String max_durn_to_mark_attendance="";
		String vald_staff_acc_by_work_sch_yn="";
		String vald_staff_acc_by_att_yn="";
		String curr_shift_allocation_yn="";
		String curr_shift_change_yn="";
		String curr_shift_cancellation_yn="";
		String curr_shift_transfer_yn="";
		String curr_shift_swap_yn="";
		String curr_shift_overtime_yn="";
		String curr_shift_leave_yn="";
		String durn_for_allocation_from_sos="";
		String durn_for_change_from_sos="";
		String durn_for_transfer_from_sos="";
		String durn_for_swap_from_sos="";
		String durn_for_overtime_from_sos="";
		String durn_for_leave_from_sos="";
		String durn_for_cancel_from_sos="";

		sqlMap.put( "sqlData",SelectSql);

		//The fields are going to be display.
		ArrayList displayFields = new ArrayList();
		displayFields.add("facility_id" );
		displayFields.add("fac_name");
		displayFields.add("overlap_shifts_in_workplace_yn");
		displayFields.add("work_cycle_basis");
		displayFields.add("period_for_work_schedule_gen");
		displayFields.add("max_continuous_work_duration");
		displayFields.add("staff_subs_same_grade_yn");
		displayFields.add("staff_subs_high_to_low_yn");
		displayFields.add("staff_subs_low_to_high_yn");
		displayFields.add("attendance_feature_reqd_yn");
		displayFields.add("max_durn_to_mark_attendance");
		displayFields.add("vald_staff_acc_by_work_sch_yn");
		displayFields.add("vald_staff_acc_by_att_yn");
		displayFields.add("curr_shift_allocation_yn");
		displayFields.add("curr_shift_change_yn");
		displayFields.add("curr_shift_cancellation_yn");
		displayFields.add("curr_shift_transfer_yn");
		displayFields.add("curr_shift_swap_yn");
		displayFields.add("curr_shift_overtime_yn");
		displayFields.add("curr_shift_leave_yn");
		displayFields.add("durn_for_allocation_from_sos");
		displayFields.add("durn_for_change_from_sos");
		displayFields.add("durn_for_transfer_from_sos");
		displayFields.add("durn_for_swap_from_sos");
		displayFields.add("durn_for_overtime_from_sos");
		displayFields.add("durn_for_leave_from_sos");
		displayFields.add("durn_for_cancel_from_sos");

		//The fields are going to be in where condition * shld match with the qry//
		ArrayList chkFields = new ArrayList();
		chkFields.add( locale);	

		// Adding function related array list into the HashMap//
		HashMap funcMap = new HashMap();
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );

		//Calling the Result from Common Adaptor as a arraylist.//
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);

		if((result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){	

            _bw.write(_wl_block8Bytes, _wl_block8);

					// For display the previous/next link
					out.println(result.get(1));

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

			ArrayList records=new ArrayList();
			for(int recCount=2; recCount<result.size(); recCount++) {
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
				 records=(ArrayList) result.get( recCount );

				facility_id=(String)records.get(0)==null?"":(String)records.get(0);
				facility_name=(String)records.get(1)==null?"":(String)records.get(1);
				overlap_shifts_in_workplace_yn=(String)records.get(2)==null?"":(String)records.get(2);
				work_cycle_basis=(String)records.get(3)==null?"":(String)records.get(3);
				period_for_work_schedule_gen=(String)records.get(4)==null?"":(String)records.get(4);
				max_continuous_work_duration=(String)records.get(5)==null?"":(String)records.get(5);
				staff_subs_same_grade_yn=(String)records.get(6)==null?"":(String)records.get(6);
				staff_subs_high_to_low_yn=(String)records.get(7)==null?"":(String)records.get(7);
				staff_subs_low_to_high_yn=(String)records.get(8)==null?"":(String)records.get(8);
				attendance_feature_reqd_yn=(String)records.get(9)==null?"":(String)records.get(9);
				max_durn_to_mark_attendance=(String)records.get(10)==null?"":(String)records.get(10);
				vald_staff_acc_by_work_sch_yn=(String)records.get(11)==null?"":(String)records.get(11);
				vald_staff_acc_by_att_yn=(String)records.get(12)==null?"":(String)records.get(12);
				curr_shift_allocation_yn=(String)records.get(13)==null?"":(String)records.get(13);
				curr_shift_change_yn=(String)records.get(14)==null?"":(String)records.get(14);
				curr_shift_cancellation_yn=(String)records.get(15)==null?"":(String)records.get(15);
				curr_shift_transfer_yn=(String)records.get(16)==null?"":(String)records.get(16);
				curr_shift_swap_yn=(String)records.get(17)==null?"":(String)records.get(17);
				curr_shift_overtime_yn=(String)records.get(18)==null?"":(String)records.get(18);
				curr_shift_leave_yn=(String)records.get(19)==null?"":(String)records.get(19);
				durn_for_allocation_from_sos=(String)records.get(20)==null?"":(String)records.get(20);
				durn_for_change_from_sos=(String)records.get(21)==null?"":(String)records.get(21);
				durn_for_transfer_from_sos=(String)records.get(22)==null?"":(String)records.get(22);
				durn_for_swap_from_sos=(String)records.get(23)==null?"":(String)records.get(23);
				durn_for_overtime_from_sos=(String)records.get(24)==null?"":(String)records.get(24);
				durn_for_leave_from_sos=(String)records.get(25)==null?"":(String)records.get(25);
				durn_for_cancel_from_sos=(String)records.get(26)==null?"":(String)records.get(26);

				out.println("<tr><td class='" + classvalue + "' align='left'><a	 href='../../eRS/jsp/ParameterAddModify.jsp?mode=2&facility_id="+facility_id+"&facility_name="+URLEncoder.encode(facility_name,"UTF-8")+"&overlap_shifts_in_workplace_yn="+overlap_shifts_in_workplace_yn+"&work_cycle_basis="+work_cycle_basis+"&period_for_work_schedule_gen="+period_for_work_schedule_gen+"&max_continuous_work_duration="+max_continuous_work_duration+"&staff_subs_same_grade_yn="+staff_subs_same_grade_yn+"&staff_subs_high_to_low_yn="+staff_subs_high_to_low_yn+"&staff_subs_low_to_high_yn="+staff_subs_low_to_high_yn+"&attendance_feature_reqd_yn="+attendance_feature_reqd_yn+"&max_durn_to_mark_attendance="+max_durn_to_mark_attendance+"&vald_staff_acc_by_work_sch_yn="+vald_staff_acc_by_work_sch_yn+"&vald_staff_acc_by_att_yn="+vald_staff_acc_by_att_yn+"&curr_shift_allocation_yn="+curr_shift_allocation_yn+"&curr_shift_change_yn="+curr_shift_change_yn+"&curr_shift_cancellation_yn="+curr_shift_cancellation_yn+"&curr_shift_transfer_yn="+curr_shift_transfer_yn+"&curr_shift_swap_yn="+curr_shift_swap_yn+"&curr_shift_overtime_yn="+curr_shift_overtime_yn+"&curr_shift_leave_yn="+curr_shift_leave_yn+"&durn_for_allocation_from_sos="+durn_for_allocation_from_sos+"&durn_for_change_from_sos="+durn_for_change_from_sos+"&durn_for_transfer_from_sos="+durn_for_transfer_from_sos+"&durn_for_swap_from_sos="+durn_for_swap_from_sos+"&durn_for_overtime_from_sos="+durn_for_overtime_from_sos+"&durn_for_leave_from_sos="+durn_for_leave_from_sos+"&durn_for_cancel_from_sos="+durn_for_cancel_from_sos+"'>");
				out.println("<font class='HYPERLINK'>"+facility_name +"</font></a></td></tr>");

			}//Loop for all records

            _bw.write(_wl_block11Bytes, _wl_block11);

			out.flush();
			} else{

            _bw.write(_wl_block12Bytes, _wl_block12);

		}
		out.println(CommonBean.setForm(request ,"../../eRS/jsp/ParameterQueryResult.jsp", searched));
		}catch(Exception e ){
			out.println("here in catch"+e);
		}

            _bw.write(_wl_block13Bytes, _wl_block13);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FacilityName.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
