package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __aeregisterattn extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AERegisterAttn.jsp", 1739968881679L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n    ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n            <title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n    ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n    <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"></link>\n    <script language=\"javascript\" src=\"../../eAE/js/AERegisterAttn.js\"></script>\n    <script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n    <script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n    <script src=\"../../eCommon/js/showModalDialog.js\" language=\"javascript\"></script>\n</head>\n<body>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<iframe name=\"commontoolbarFrame\" id=\"commontoolbarFrame\" src=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" frameborder=\"0\" scrolling=\"no\" noresize style=\'height:7vh;width:100vw;\'></iframe>\n                    <iframe name=\"f_query_add_mod\" id=\"f_query_add_mod\" src=\"../../eAE/jsp/AERegisterAttnFrameset.jsp?dflt_time_reg_auto_update=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&dflt_emer_follow_type_code=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" frameborder=\"0\" scrolling=\"no\" noresize style=\'height:83vh;width:100vw;\'></iframe>\n<!--                     <iframe name=\"dummyFrame\" id=\"dummyFrame\" src=\"../../eCommon/jsp/error.jsp\" frameborder=\"0\" noresize scrolling=\"auto\" style=\'height:10vh;width:100vw;\'></iframe>\n -->                    <iframe name=\"messageFrame\" id=\"messageFrame\" src=\"../../eCommon/jsp/error.jsp\" frameborder=\"0\" noresize scrolling=\"auto\" style=\'height:10vh;width:100vw;\'></iframe>\n                    <iframe name=\"billingfr\" id=\"billingfr\" src=\"../../eBL/jsp/BLSessionValuesReset.jsp\" frameborder=\"0\" noresize scrolling=\"auto\" style=\'height:0vh;width:100vw;\'></iframe>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\n                    <iframe name=\"commontoolbarFrame\" id=\"commontoolbarFrame\" src=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" frameborder=\"0\" scrolling=\"no\" noresize style=\'height:83vh;width:100vw;\'></iframe>\n                    <iframe name=\"messageFrame\" id=\"messageFrame\" src=\"../../eCommon/jsp/error.jsp\" frameborder=\"0\" noresize scrolling=\"auto\" style=\'height:10vh;width:100vw;\'></iframe>\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n                    <iframe name=\"billingfr\" id=\"billingfr\" src=\"../../eBL/jsp/BLSessionValuesReset.jsp\" frameborder=\"0\" noresize scrolling=\"auto\" style=\'height:0vh;width:100vw;\'></iframe>\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n                ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\n        <input type=\"hidden\" name=\"params\" id=\"params\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t<input type=\"hidden\" name=\"tlbrsrc\" id=\"tlbrsrc\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n</body>\n</html>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

        request.setCharacterEncoding("UTF-8");
        request = new XSSRequestWrapper(request);
        response.addHeader("X-XSS-Protection", "1; mode=block");
        response.addHeader("X-Content-Type-Options", "nosniff");

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
                        
        String invoke_from = checkForNull(request.getParameter("invoke_from"));
        if (invoke_from.equals("EMER_REGN_NB")) { 
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
 } 
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( sStyle ));
            _bw.write(_wl_block9Bytes, _wl_block9);

    
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
		String bl_install_yn         = (String)session.getValue("bl_operational");
		String facilityId			= checkForNull((String)session.getValue("facility_id"));
        Connection	con             = null;
		PreparedStatement pstmt		= null;
		ResultSet rs				= null ;

        String StartDate1 = "";
        String AllowedDate = "";
        String bl_interface_yn = "";
        String visit_back_yn = "";
        String start_date = "";
        String sys_date = "";
        String cnt = "";
        String dflt_time_reg_auto_update = ""; // added by mujafar for KDAH-CRF-0526
        String dflt_emer_follow_type_code = "";

        // below lines added by venkatesh.S (4008) on 22/Feb/2012 against CRF Bru-HIMS-CRF-152 [IN030272]
        String max_hrs_for_re_attend = "";
        // end CRF Bru-HIMS-CRF-152 [IN030272]
        String reg_attendance_for_inpat_yn = "";
        StringBuffer sqlDate = new StringBuffer();
        /*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 26th 2014 Start*/
        String five_level_triage_appl_yn = "N";
        /*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 26th 2014 End*/

		try{
		con			            = ConnectionManager.getConnection(request);
	//	String sql1 = " select 1  from ae_param  where OPERATING_FACILITY_ID=?"; old query

				// Thursday, April 22, 2010 venkat s PE_EXE 
				   sqlDate.append("select to_char(sysdate,'dd/mm/yyyy hh24:mi:ss')sys, ");
				   sqlDate.append("to_char((sysdate -(1/(24*60*60))*3600*MAX_HOURS_ALLOW_INSERT),'dd/mm/yyyy hh24:mi:ss')sys1, ");
				   sqlDate.append(" BILLING_INTERFACED_YN, ");
				   sqlDate.append(" VISIT_BACKDATING_ALLOWED_YN,  ");
				   sqlDate.append(" REG_ATTENDANCE_FOR_INPAT_YN,  ");
				// below lines added by venkatesh.S (4008) on 22/Feb/2012 aganist CRF Bru-HIMS-CRF-152 [IN030272]
                   sqlDate.append(" MAX_HRS_FOR_RE_ATTEND,  ");
				  //end CRF  Bru-HIMS-CRF-152 [IN030272]
				   
				   sqlDate.append(" TO_CHAR(SYSDATE-(DECODE(VISIT_BACKDATING_ALLOWED_YN,");
				   sqlDate.append(" 'Y',MAX_HOURS_ALLOW_INSERT,0)*60)/1440,'dd/mm/yyyy hh24:mi')  start_date,to_char(trunc(sysdate),'dd/mm/yyyy') sys_date, 1 cnt  ");
				   /*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 26th 2014 Start*/
				   sqlDate.append(" ,five_level_triage_appl_yn ");
				   /*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 26th 2014 End*/
				   
				   /* for KDAH-CRF-0526 */
				   
				   sqlDate.append(" ,DFLT_TIME_REG_AUTO_UPDATE,DFLT_EMER_FOLLOW_TYPE_CODE  ");
				   /* for KDAH-CRF-0526 */
				   
				   sqlDate.append(" from ae_param  where operating_facility_id= ? ");
				   if (pstmt != null) pstmt.close();
				   
				   pstmt  = con.prepareStatement(sqlDate.toString());
		   		   pstmt.setString(1,facilityId);
				    rs = pstmt.executeQuery();

					
				   if (rs != null)
				   {
					 if(rs.next()) 
					  {
						StartDate1          = checkForNull(rs.getString("sys"));
						params  = params+"&StartDate1="+StartDate1;
						AllowedDate         = checkForNull(rs.getString("sys1"));
						params  = params+"&AllowedDate="+AllowedDate;
						bl_interface_yn     = checkForNull(rs.getString("BILLING_INTERFACED_YN"));
						// below lines added by venkatesh.S (4008) on 22/Feb/2012 aganist CRF Bru-HIMS-CRF-152 [IN030272]
				        max_hrs_for_re_attend = checkForNull(rs.getString("MAX_HRS_FOR_RE_ATTEND"));
						params  = params+"&max_hrs_for_re_attend="+max_hrs_for_re_attend;
						
						//end CRF  Bru-HIMS-CRF-152 [IN030272]
						params  = params+"&bl_interface_yn="+bl_interface_yn;
						visit_back_yn		= checkForNull(rs.getString("VISIT_BACKDATING_ALLOWED_YN"));
						params  = params+"&visit_back_yn="+visit_back_yn;
						reg_attendance_for_inpat_yn		= checkForNull(rs.getString("REG_ATTENDANCE_FOR_INPAT_YN"));
						params  = params+"&attendance_for_inpat_yn="+reg_attendance_for_inpat_yn;
						start_date			= checkForNull(rs.getString("start_date"));
						params  = params+"&start_date="+start_date;
						sys_date           = checkForNull(rs.getString("sys_date")); 
						params  = params+"&sys_date="+sys_date;
						cnt            = checkForNull(rs.getString("cnt")); 
						/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 26th 2014 Start*/
						five_level_triage_appl_yn	= (rs.getString("five_level_triage_appl_yn")==null || rs.getString("five_level_triage_appl_yn")=="")?"N":rs.getString("five_level_triage_appl_yn");
						params	= params + "&five_level_triage_appl_yn="+five_level_triage_appl_yn;
						/*Added For AAKH-CRF-0010 [IN:038535] By Dharma on Feb 26th 2014 End*/
						
						/*  for KDAH-CRF-0526*/ 
						dflt_time_reg_auto_update         = rs.getString("DFLT_TIME_REG_AUTO_UPDATE")==null?"0":rs.getString("DFLT_TIME_REG_AUTO_UPDATE");
						dflt_emer_follow_type_code          = checkForNull(rs.getString("dflt_emer_follow_type_code"));
						/* for KDAH-CRF-0526  */
						
					  }
				   }
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();

            if (cnt.equals("")) {
                out.println("<script>alert(getMessage('AE_PARAM_NOT_FOUND','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp'</script>");
            } else {
                if (bl_install_yn.equals("Y")) { 
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(source));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(dflt_time_reg_auto_update));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(dflt_emer_follow_type_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(params));
            _bw.write(_wl_block14Bytes, _wl_block14);
}else{
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(source));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(dflt_time_reg_auto_update));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(dflt_emer_follow_type_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(params));
            _bw.write(_wl_block16Bytes, _wl_block16);
if(bl_install_yn.equals("Y")){
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block18Bytes, _wl_block18);
 }
            }

			if((sqlDate != null) && (sqlDate.length() > 0))
			{
				sqlDate.delete(0,sqlDate.length());
			}

				}catch(Exception e){
			 e.printStackTrace();
		}finally{
		ConnectionManager.returnConnection(con,request);
       }	
		
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(params));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(source));
            _bw.write(_wl_block21Bytes, _wl_block21);
            _bw.write(_wl_block22Bytes, _wl_block22);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RegisterAttendance.label", java.lang.String .class,"key"));
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
