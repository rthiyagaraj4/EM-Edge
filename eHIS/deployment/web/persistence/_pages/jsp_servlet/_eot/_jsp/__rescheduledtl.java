package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;

public final class __rescheduledtl extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/ReScheduleDtl.jsp", 1724156338000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eOT/js/Booking.js\' language=\'javascript\'></script>\n<script src=\'../../eOT/js/CancelTransfer.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n    \n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\'ReScheduleDtlForm\' id=\'ReScheduleDtlForm\' action=\'\' method = \'post\'>\n\n<table class=\'grid\' border=\'1\' width=\'100%\' cellpadding=3  cellspacing=0>\n<tr>\n\t<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</th>\n\t<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t</tr>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="<tr>\n\n<input type=\'hidden\' name=\'xx";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' id=\'xx";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n<input type=\'hidden\' name=\'splty";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' id=\'splty";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="<td class=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'  nowrap>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\n<td class=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n</tr>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n </table>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n<input type=\'hidden\' name=\'strBookingYN\' id=\'strBookingYN\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n<input type=\'hidden\' name=\'restrictTheatreBookingYN\' id=\'restrictTheatreBookingYN\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n<input type=\'hidden\' name=\'cancel_schedule_yn\' id=\'cancel_schedule_yn\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n<input type=\'hidden\' name=\'transfer_schedule_yn\' id=\'transfer_schedule_yn\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"> \n<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n<input type=\'hidden\' name=\'login_user\' id=\'login_user\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n<input type=\'hidden\' name=\'facilityid\' id=\'facilityid\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n<input type=\'hidden\' name=\'strPatientId\' id=\'strPatientId\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n<input type=\'hidden\' name=\'strBookingNum\' id=\'strBookingNum\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n </form>\n \t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:20%; visibility:hidden;\' bgcolor=\'blue\'>\t\n\t</div>\n</html>\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

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
 String locale = (String)session.getAttribute("LOCALE"); 
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
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
	
String facilityid=(String)session.getValue("facility_id");
Properties p=(Properties)session.getValue("jdbc");
String login_user= p.getProperty("login_user");
String function_id=request.getParameter("function_id");


Connection conn=null;
PreparedStatement pstmt=null;	ResultSet rs=null;

String sql="",strOperDesc="",strReasonDesc="",strSurgeonName="",strSurgeonCode="",strBookingNum="",strPatientId="",strQuery="",strSpecialityCode="",strSpecialityDesc="",strSex="",strApptFromTime="",strApptToTime="",strOrderId="",strDOB="",strEncounterId="",strPatientClass="",strBookingYN = "",restrictTheatreBookingYN = "",cancel_schedule_yn = "",transfer_schedule_yn = "";
String strPatientName="";// 047067 Bharati

String bookingDetails_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ViewBookingDetails.Label","ot_labels")+",";
String reschedule_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reschedule.label","common_labels")+",";
String cancelappointment_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelBooking.label","common_labels")+",";
String surgeryHistory_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.SurgeryHistory.Label","ot_labels")+",";
String chartsummery_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientHistory.label","common_labels")+",";
String PreviousReschedule_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PreviousReschedule.Label","ot_labels")+",";

int fetchCount=0;
try{
	conn = ConnectionManager.getConnection(request);
	String sql_access_rights="SELECT BOOK_SCHEDULE_YN BOOK_SCHEDULE_YN1, (SELECT NVL(RESTRICT_THEATRE_BOOKING_YN,'N') FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID=A.OPERATING_FACILITY_ID) RESTRICT_THEATRE_BOOKING_YN, NVL(CANCEL_SCHEDULE_YN,'N') CANCEL_SCHEDULE_YN,NVL(TRANSFER_SCHEDULE_YN,'N') TRANSFER_SCHEDULE_YN  FROM OT_BOOKING_ACCESS_RIGHTS A WHERE A.OPERATING_FACILITY_ID =?  AND APPL_USER_ID=?";
	pstmt = conn.prepareStatement(sql_access_rights);
	pstmt.setString(1,facilityid);
	pstmt.setString(2,login_user);
	rs=pstmt.executeQuery();
	if(rs.next()){
		strBookingYN=rs.getString("BOOK_SCHEDULE_YN1");
		restrictTheatreBookingYN=rs.getString("RESTRICT_THEATRE_BOOKING_YN");
		cancel_schedule_yn=rs.getString("CANCEL_SCHEDULE_YN");
		transfer_schedule_yn=rs.getString("TRANSFER_SCHEDULE_YN");
	}
	if(rs!=null)	 rs.close();
	if(pstmt!=null)  pstmt.close();

 sql=request.getParameter("sql");
 pstmt=conn.prepareCall(sql);
 rs=pstmt.executeQuery();


while(rs.next())
{
   fetchCount++;
   strPatientId=CommonBean.checkForNull(rs.getString("PATIENT_ID1"));
   strPatientName=CommonBean.checkForNull(rs.getString("PATIENT_NAME1"));
   strSex=CommonBean.checkForNull(rs.getString("SEX1"));
  strApptFromTime=CommonBean.checkForNull(rs.getString("APPT_FROM_TIME1"));//047067 Bharati
  strApptToTime=CommonBean.checkForNull(rs.getString("APPT_TO_TIME1"));	//047067 Bharati
   strDOB=CommonBean.checkForNull(rs.getString("DATE_OF_BIRTH1"));
   strOperDesc=CommonBean.checkForNull(rs.getString("OPER_DESC1"));
   strReasonDesc=CommonBean.checkForNull(rs.getString("REASON_DESC1"));  
   strSurgeonCode=CommonBean.checkForNull(rs.getString("SURGEON_CODE1"));  
   strSurgeonName=CommonBean.checkForNull(rs.getString("SURGEON_NAME1"));
   	strBookingNum=CommonBean.checkForNull(rs.getString("APPT_REF_NUM1"));
	strSpecialityCode=CommonBean.checkForNull(rs.getString("SPECIALITY_CODE1"));
 	strSpecialityDesc=CommonBean.checkForNull(rs.getString("SPECIALITY_DESC1"));
 	strEncounterId=CommonBean.checkForNull(rs.getString("ENCOUNTER_ID1"));
 	strPatientClass=CommonBean.checkForNull(rs.getString("PATIENT_CLASS1"));
 	strOrderId=CommonBean.checkForNull(rs.getString("ORDER_ID"));

		
if(fetchCount%2==0)	strQuery="gridData";
else		strQuery="gridData";



            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strSurgeonName));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strSpecialityDesc));
            _bw.write(_wl_block15Bytes, _wl_block15);


out.println("<input type='hidden' name='patsexdob"+fetchCount+"' id='patsexdob"+fetchCount+"' value=\""+strPatientId+"::"+strPatientName+"::"+strSex+"::"+strDOB+"\">");
out.println("<td width='' nowrap id='orderctl"+fetchCount+"' style='cursor:pointer' class='gridDataBlue' onClick=\"commonDisplayTooltip('RS1,RS2,RS3,RS6,RS4,RS5','"+bookingDetails_title+PreviousReschedule_title+reschedule_title+cancelappointment_title+surgeryHistory_title+chartsummery_title+"','"+strBookingNum+","+facilityid+","+strPatientId+","+strSurgeonCode+","+strSpecialityCode+","+fetchCount+","+strOrderId+","+strApptFromTime+","+strApptToTime+"',this,'imgArrow"+fetchCount+"');\"  width='15%'  onMouseOver='hideToolTip();'><a class='gridDataBlue' href=\"javascript:commonDisplayTooltip('RS1,RS2,RS3,RS6,RS4,RS5','"+bookingDetails_title+PreviousReschedule_title+reschedule_title+cancelappointment_title+surgeryHistory_title+chartsummery_title+"','"+strBookingNum+","+facilityid+","+strPatientId+","+strSurgeonCode+","+strSpecialityCode+","+fetchCount+","+strOrderId+","+strApptFromTime+","+strApptToTime+"',this,'imgArrow"+fetchCount+"');\">"+strPatientId+"<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+fetchCount+"' id='imgArrow"+fetchCount+"'></td>");


            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strPatientName));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strOperDesc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strReasonDesc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strQuery));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strSurgeonName));
            _bw.write(_wl_block19Bytes, _wl_block19);

	}
if(fetchCount==0)	 out.println("<script>callNoRecord();</script>");

}catch(Exception ee)
{
	ee.printStackTrace();
	System.err.println(" Caught Exception in CancelTrnsferDtl.jsp : "+ee);
}
finally{
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();


ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(strBookingYN));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(restrictTheatreBookingYN));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(cancel_schedule_yn));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(transfer_schedule_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strPatientClass));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strBookingNum));
            _bw.write(_wl_block32Bytes, _wl_block32);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Procedure(s).Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RescheduledReason.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgeon.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }
}
