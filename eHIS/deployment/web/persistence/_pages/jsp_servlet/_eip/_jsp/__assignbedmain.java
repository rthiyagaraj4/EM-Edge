package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __assignbedmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/AssignBedMain.jsp", 1726464917702L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
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

    private final static java.lang.String  _wl_block6 ="\n<head>\n\t<title>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t</title>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<script language=\'javascript\' src=\'../js/AgeGroupBkgLimit.js\'></script>\n\t<script language =\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n\n<iframe name=\'PLINE\' id=\'PLINE\' src=\'../../eCommon/jsp/pline.jsp?EncounterId=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&Facility_Id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' noresize  frameborder=0 scrolling=\'no\' style=\'height:10vh;width:100vw\'></iframe>\n<iframe name=\'message\' id=\'message\'\t\tsrc=\'../jsp/AssignBedDetail.jsp?encounterId=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&patientId=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&chg_nurs_unit_in_assign_bed_yn=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&oper_stn_id=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&pat_check_in_allowed_yn=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&setup_bl_dtls_in_ip_yn=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&weight_on_admn_mandatory=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&height_on_admn_mandatory=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&enable_height_bmi_pat_cls=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' frameborder=0 noresize scrolling=\'no\' style=\'height:80vh;width:100vw\'></iframe>\n<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:5vh;width:100vw\'></iframe>\n<iframe name=\'submitFrame\' id=\'submitFrame\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\'auto\' style=\'height:0vh;width:100vw\'></iframe>\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\n\t\t<iframe name=\'PLINE\' id=\'PLINE\' src=\'../../eCommon/jsp/pline.jsp?EncounterId=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' noresize  frameborder=0 scrolling=\'no\' style=\'height:10vh;width:100vw\'></iframe>\n\t\t<iframe name=\'message\' id=\'message\'\t\tsrc=\'../jsp/AssignBedDetail.jsp?encounterId=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' frameborder=0 noresize scrolling=\'no\' style=\'height:80vh;width:100vw\'></iframe>\n\t\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:0%;width:100vw\'></iframe><iframe name=\'submitFrame\' id=\'submitFrame\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\'auto\' style=\'height:5vh;width:100vw\'></iframe>\n\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\n</html>\n\t\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

	// By Sridhar R 3/8/2005.., to handle NullPointerException.
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String facilityId				= (String) session.getValue("facility_id");
	String loginUser		        =	checkForNull((String)session.getValue("login_user"));
	String oper_stn_id				= checkForNull(request.getParameter("oper_stn_id"));
	String encounterId				= checkForNull(request.getParameter("encounterId"));
	String patientId				= checkForNull(request.getParameter("patientId"));
	String call_function				= checkForNull(request.getParameter("call_function"));

	String pat_check_in_allowed_yn	= checkForNull(request.getParameter("pat_check_in_allowed_yn"),"N");
	String setup_bl_dtls_in_ip_yn	= checkForNull(request.getParameter("setup_bl_dtls_in_ip_yn"),"N");
	String chg_nurs_unit_in_assign_bed_yn =	checkForNull(request.getParameter("chg_nurs_unit_in_assign_bed_yn"),"N");
	String location_code	=	checkForNull(request.getParameter("location_code"));
	String assign_bed_yn	=	"";
	String from_adv_bed_mgmt			= checkForNull((String)request.getParameter("from_adv_bed_mgmt"),"N");
	String weight_on_admn_mandatory	= checkForNull(request.getParameter("weight_on_admn_mandatory")); //Added By Dharma on Oct 28th 2014 against HSA-CRF-0181 [IN:049541]
	String height_on_admn_mandatory	= checkForNull(request.getParameter("height_on_admn_mandatory")); //Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527
	String enable_height_bmi_pat_cls	= checkForNull(request.getParameter("enable_height_bmi_pat_cls")); //Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527
	Connection connection	=	null;
	ResultSet resultSet 	=	null; 
	Statement statement 	=	null;
	ResultSet resultSet1 	=	null; 
	Statement statement1 	=	null;
	
	connection	= ConnectionManager.getConnection(request);
	statement	= connection.createStatement();

	try{
		statement1 = connection.createStatement();
		//resultSet1 = statement1.executeQuery("SELECT a.chg_nurs_unit_in_assign_bed_yn chg_nurs_unit_in_assign_bed_yn FROM AM_OPER_STN a WHERE a.facility_id = '"+facilityId+"' AND a.oper_stn_id = (SELECT oper_stn_id FROM AM_USER_FOR_OPER_STN where facility_id = '"+facilityId+"' AND appl_user_id = '"+loginUser+"' AND TRUNC (SYSDATE) BETWEEN eff_date_from AND NVL (eff_date_to, TRUNC (SYSDATE)))") ;
		/*Wednesday, March 03, 2010 ,IN019731 , to filter nursing unit if change nursing unit in assign bed is unchecked in AM->operator station restriction function*/

		resultSet1 = statement1.executeQuery("SELECT a.chg_nurs_unit_in_assign_bed_yn chg_nurs_unit_in_assign_bed_yn,assign_bed_yn FROM am_os_user_locn_access_vw a WHERE a.facility_id = '"+facilityId+"' AND a.oper_stn_id='"+oper_stn_id+"' and a.appl_user_id='"+loginUser+"' and a.locn_code = '"+location_code+"'") ;
		while(resultSet1.next()){	     		
			chg_nurs_unit_in_assign_bed_yn	= resultSet1.getString("chg_nurs_unit_in_assign_bed_yn");
			assign_bed_yn								= checkForNull(resultSet1.getString("assign_bed_yn"),"N");
		} 
	}catch(Exception ex)	{
		
		ex.printStackTrace();
	}finally{
		try{
			if(resultSet1!=null) resultSet1.close();
			if(statement1!=null) statement1.close();

			//if(connection != null)
			//ConnectionManager.returnConnection(connection,request);
		}catch(Exception ee)	{

			ee.printStackTrace();
				
		}

	}


	if(!(call_function.equals("assign_bed"))||(call_function.equals("assign_bed"))){
try{
/*
	Commented On 4/21/2010 For PE Tunining
	String sql = "Select locn_code from AM_OS_USER_LOCN_ACCESS_VW b where b.facility_id = '"+facilityId+"' and locn_code = '"+location_code+"' and b.locn_type = 'N' and b.oper_stn_id='"+oper_stn_id+"' and b.appl_user_id='"+loginUser+"' and b.ASSIGN_BED_YN ='N'";
	

	resultSet = statement.executeQuery(sql) ;
	
	if(resultSet != null && resultSet.next()){
				rect_loc_code = resultSet.getString("locn_code");
		}
			 if(!(rect_loc_code.equals(""))){
					
				//out.print("<script>alert(getMessage('ASSIGN_BED_USER_ACCESS','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
				out.print("<script>alert(getMessage('ASSIGN_BED_USER_ACCESS','IP')); parent.window.close();</script>");
			}
*/
		if(assign_bed_yn.equals("N")){
			//out.print("<script>alert(getMessage('ASSIGN_BED_USER_ACCESS','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
			out.print("<script>alert(getMessage('ASSIGN_BED_USER_ACCESS','IP')); top.window.document.getElementById('dialog_tag').close();</script>");
		}else{
		if(!(call_function.equals("assign_bed"))){
			out.print("<script>var ggp_status = window.confirm(getMessage('BED_CAN_NOT_ASSIGN_CONFIRM','IP'));</script>");
			out.println("<script>if(!ggp_status)top.window.document.getElementById('dialog_tag').close();</script>");
		}
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(chg_nurs_unit_in_assign_bed_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(pat_check_in_allowed_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(setup_bl_dtls_in_ip_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(weight_on_admn_mandatory));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(height_on_admn_mandatory));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(enable_height_bmi_pat_cls));
            _bw.write(_wl_block20Bytes, _wl_block20);

		}
if (resultSet != null) resultSet.close();
		if (statement != null) statement.close();
}catch(Exception e)
{
	
	e.printStackTrace();
}finally
{
	try
			{
				if(resultSet!=null) resultSet.close();
				if(statement!=null) statement.close();

				if(connection != null)
				ConnectionManager.returnConnection(connection,request);
			}
			catch(Exception ee)
			{
				

				ee.printStackTrace();
			}
}
	}
	else {
		
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(chg_nurs_unit_in_assign_bed_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(pat_check_in_allowed_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(setup_bl_dtls_in_ip_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
}
	
            _bw.write(_wl_block24Bytes, _wl_block24);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.assignbedmarkpatientarrival.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
