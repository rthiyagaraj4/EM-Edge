package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __apptwaitlist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/ApptWaitList.jsp", 1737695005777L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n<html>\n<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n</title>\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\">\t</script>\n\t<script language=\"javascript\" src=\"../../eOA/js/ApptWaitList.js\"> </script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"> </script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\n\t       ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\'    src=\"../../eOA/jsp/OAToolbar.jsp?calling_mode=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&from=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"   scrolling=\'no\' noresize style=\'height:8vh;width:100vw\' frameborder=\'0\'></iframe>\n \n\t\t\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\'    src=\"../../eOA/jsp/ApptWaitListlMainPage.jsp?";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="& operation=insert&from=ScheduleAppt&oper_stn_id=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&alcn_criteria_yn=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&waitlist_category_appl_yn=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&invitation_list_appl_yn=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&waitlist_category_reqd_yn=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&restrict_wl_cat_agst_splty_yn=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&dttm=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&prd=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&curr_month=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&install_yn=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&rd_oa_integration_yn=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"  noresize scrolling=auto style=\'height:82vh;width:100vw\' frameborder=\'0\'></iframe>\n\t        ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="  scrolling=no noresize style=\'height:8vh;width:100vw\' frameborder=\'0\'></iframe>\n\n                <iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\'    src=\"../../eOA/jsp/ApptWaitListlMainPage.jsp?";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&oper_stn_id=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"  noresize scrolling=auto style=\'height:82vh;width:100vw\' frameborder=\'0\'> </iframe>\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\'\t src=\'../../eCommon/jsp/error.jsp\' noresize scrolling=auto style=\'height:9vh;width:100vw\' frameborder=\'0\'></iframe>\n\t\t\t<iframe name=\'dummyFrame\' id=\'dummyFrame\'\t src=\'../../eCommon/jsp/error.jsp\'  noresize scrolling=auto style=\'height:0vh;width:100vw\' frameborder=\'0\'></iframe>\n\t\t\n\n\n\n\n</html>\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
	String url 	= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params	= request.getQueryString() ;
	String source   = url+params ;
	Connection con = null;
	PreparedStatement pstmt = null;
	String facilityId=(String) session.getValue("facility_id");
	String globaluser = (String)session.getValue("login_user");
	String alcn_criteria_yn = "" ;
			String waitlist_category_appl_yn = "" ;
			String invitation_list_appl_yn = "" ;
			String waitlist_category_reqd_yn = "" ;
			String restrict_wl_cat_agst_splty_yn = "" ;
			String dttm = "" ;
			String prd = "" ;
			String curr_month = "" ;
			String install_yn = "" ;
			String rd_oa_integration_yn = "N" ;
	
	//String oper_stn_access_rule="";			

	String from = request.getParameter("from")==null?"":request.getParameter("from");
	 
	String calling_mode=request.getParameter("calling_mode");
	String oper_stn_id="";
	ResultSet rs=null;
	try{
		con = ConnectionManager.getConnection(request);		 
		 String sqlQuery = "" ;
		 sqlQuery = "SELECT NVL (alcn_criteria, 'None') alcn_criteria, waitlist_category_appl_yn, invitation_list_appl_yn,       waitlist_category_reqd_yn, restrict_wl_cat_agst_splty_yn, TO_CHAR (SYSDATE, 'dd/mm/yyyy') dttm,NVL (forceclose_period, 0) prd, TO_CHAR (SYSDATE, 'mm') curr_month,(SELECT operational_yn FROM sm_modules_facility WHERE facility_id = ? AND module_id = 'OR') install_yn,AM_OPER_STN_ACCESS_CHECK(?,?,'X','','CREATE_WAIT_LIST_YN') oper_stn_id,rd_oa_integration_yn FROM oa_param";
		 pstmt = con.prepareStatement(sqlQuery);
		 pstmt.setString(1,facilityId);
		 pstmt.setString(2,facilityId);
		 pstmt.setString(3,globaluser);
		 rs = pstmt.executeQuery();
		if(rs !=null && rs.next()) {			
	     	 oper_stn_id=rs.getString("oper_stn_id")==null?"":rs.getString("oper_stn_id");
	     	 alcn_criteria_yn=rs.getString("alcn_criteria")==null?"":rs.getString("alcn_criteria");;
	     	 waitlist_category_appl_yn=rs.getString("waitlist_category_appl_yn")==null?"":rs.getString("waitlist_category_appl_yn");;
			 invitation_list_appl_yn=rs.getString("invitation_list_appl_yn")==null?"":rs.getString("invitation_list_appl_yn");;
			 waitlist_category_reqd_yn=rs.getString("waitlist_category_reqd_yn")==null?"":rs.getString("waitlist_category_reqd_yn");;
			 restrict_wl_cat_agst_splty_yn=	rs.getString("restrict_wl_cat_agst_splty_yn")==null?"":rs.getString("restrict_wl_cat_agst_splty_yn");;
			 dttm=rs.getString("dttm")==null?"":rs.getString("dttm");;
			 prd=rs.getString("prd")==null?"":rs.getString("prd");;
			 curr_month=rs.getString("curr_month")==null?"":rs.getString("curr_month");;
			 install_yn=rs.getString("install_yn")==null?"":rs.getString("install_yn");;
			 rd_oa_integration_yn=rs.getString("rd_oa_integration_yn")==null?"N":rs.getString("rd_oa_integration_yn");;
		}
		
            if(oper_stn_id.equals("1")) 
			{
			 out.println("<script>alert(getMessage('NO_OPER_STN_FOR_USER','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';				</script>");
		    }else if(oper_stn_id.equals("2"))
			{
			out.print(" <script>alert(getMessage('NO_CLINICS_FOR_USER','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");			
			}else if(oper_stn_id.equals("3"))
			{
				out.print(" <script>alert(getMessage('OPER_STN_RESTRN','OP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");		
			}else  if(oper_stn_id.equals("4"))
			{
			out.print(" <script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else  if(oper_stn_id.equals("5"))
			{
			out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			}else	if(!oper_stn_id.equals(""))
			{


            _bw.write(_wl_block8Bytes, _wl_block8);
if (from.equals("ScheduleAppt")){
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(calling_mode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(from));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(source));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(alcn_criteria_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(waitlist_category_appl_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(invitation_list_appl_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(waitlist_category_reqd_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(restrict_wl_cat_agst_splty_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dttm));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(prd));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(curr_month));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(install_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rd_oa_integration_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
}else {
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(source));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(source));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(alcn_criteria_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(waitlist_category_appl_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(invitation_list_appl_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(waitlist_category_reqd_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(restrict_wl_cat_agst_splty_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dttm));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(prd));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(curr_month));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(install_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rd_oa_integration_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
}
            _bw.write(_wl_block28Bytes, _wl_block28);

		}
	if(rs !=null) rs.close();
	if(pstmt !=null) pstmt.close();
}
catch(Exception es){
	es.printStackTrace();
	//out.println(es);
}
finally{
	ConnectionManager.returnConnection(con,request);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.CreateAppointmentWaitList.label", java.lang.String .class,"key"));
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
}
