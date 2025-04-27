package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;

public final class __cabedsidereferral extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/CABedSideReferral.jsp", 1710353544784L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="  \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t<script>\n\t\t\t\t/*\tvar retVal\t\t = \tnew String();\n\t\t\t\t\tvar dialogHeight= \"34\" ;\n\t\t\t\t\tvar dialogTop\t = \"125\";\n\t\t\t\t\tvar dialogWidth\t= \"50\" ;\n\t\t\t\t\tvar status\t\t= \"no\";\n\t\t\t\t\tvar arguments\t= \"\" ;\n\t\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ;dialogTop:\"+dialogTop+\"; scroll=no; status:\" + status;\n\t\t\t\t\tretVal = window.showModalDialog(\"../../eIP/jsp/PaintReferralPatientDetails.jsp?called_from=CA&patientid=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&encounterId=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&call_function=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&referral_id=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&oper_stn_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\",arguments,features);\n\t\t\t\t\t*/\n\t\t\t\t</script>\n\t\t\t\t<html>\n\t\t\t\t\t<head><title>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</title></head>\n\t\t\t\t\t<iframe name=\"PatientLine_frame\" id=\"PatientLine_frame\" src=\"../../eCommon/jsp/pline.jsp?Facility_Id=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&EncounterId=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"  scrolling=\'no\' noresize style=\'height:0%;width:100vw\'></iframe>\n\t\t\t\t\t\t<iframe name=\"Transfer_frame\" id=\"Transfer_frame\" src=\"../../eIP/jsp/addModifyRefPatientDtls.jsp?called_from=CA&encounter_id=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&patient_class=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&bed_block_period_dis=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&dis_date_chk_days=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"  scrolling=\'no\' noresize style=\'height:80vh;width:100vw\'></iframe>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<iframe src=\"../../eCommon/jsp/error.jsp\" name=\"Dummy_frame\" id=\"Dummy_frame\" scrolling=\'auto\' noresize style=\'height:0%;width:100vw\'></iframe>\n\t\t\t\t\t\n\t\t\t\t</html> \n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t<html>\n\t\t\t\t<head>\n\t\t\t\t\t<title>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</title>\n\t\t\t\t</head>\n\t\t\t\t<iframe name=\"BedsideFrame\" id=\"BedsideFrame\" src=\"../../eIP/jsp/ConfirmBedsideReferralQueryResult.jsp?called_from=CA&encounter_id=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&jsp_name=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&param=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&practid=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&patient_id=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" scrolling=\'no\' noresize style=\'height:80vh;width:100vw\'></iframe>\n\t\t\t\t\t<iframe src=\"../../eCommon/jsp/error.jsp\" name=\"Dummy_frame\" id=\"Dummy_frame\" scrolling=\'auto\' noresize style=\'height:8%;width:100vw\'></iframe>\n\t\t\t\t\n\t\t\t</html>\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

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

/**
* @Module		: InPatient Management ...[IP]
* @Created By	: SRIDHAR R 
* @Created Date	: 18 Oct 2005
* @Function		: Page used for BedSide Referral when called Only from CA...
**/

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
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	int bed_block_period_dis_int = 0;
	int dis_date_chk_days_int	= 0;
	Connection con		= null;
	Statement stmt		= null;
	ResultSet rset		= null;

	String facilityId		= (String)session.getValue("facility_id");
	String loginUser		= (String)session.getValue("login_user");
	String called_for		= checkForNull(request.getParameter("called_for"),"Request");
	String practid			= checkForNull(request.getParameter("practitioner_id"));
	String patientid		= checkForNull(request.getParameter("patient_id"));
	String encounterid		= checkForNull(request.getParameter("encounter_id"));
	String call_function	= checkForNull(request.getParameter("call_function"));
	String referral_id		= checkForNull(request.getParameter("referralID"));
	String patient_class		= checkForNull(request.getParameter("patient_class"));//Added by Arthi on 18-Nov-2022 against ML-MMOH-CRF-1978
	String oper_stn_id		= "";
	
	boolean isBedSideReferralApplforAE = false; //Added by Arthi on 18-Nov-2022 against ML-MMOH-CRF-1978

	try
	{
		con = ConnectionManager.getConnection(request);
        
		isBedSideReferralApplforAE = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "BED_SIDE_REFERRAL_FOR_AE");//Added by Arthi on 18-Nov-2022 against ML-MMOH-CRF-1978

		String opr_sql = " select a.oper_stn_id oper_stn_id from am_oper_stn a, am_user_for_oper_stn b where a.facility_id='"+facilityId+"' and a.facility_id=b.facility_id and a.oper_stn_id = b.oper_stn_id and b.appl_user_id ='"+loginUser+"' and trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate)) ";

		stmt = con.createStatement();
		rset = stmt.executeQuery(opr_sql);

		if(rset!=null)
		{
			while(rset.next())
			{
				oper_stn_id	= checkForNull(rset.getString("oper_stn_id"));
			}
		}
		if(rset!=null) rset.close();
		if(stmt!=null) stmt.close();

	}catch(Exception e) 
	{
		out.println(e.toString());
	}

	if(called_for.equals("Request"))
	{
		try
		{
			int count= 0;		
			StringBuffer sql_bl = new StringBuffer();
			//Added by Arthi on 18-Nov-2022 against ML-MMOH-CRF-1978
			if(isBedSideReferralApplforAE && patient_class.equals("EM")){
				sql_bl.append("select count(*) from AE_CURRENT_PATIENT where FACILITY_ID = '"+facilityId+"' and ENCOUNTER_ID ='"+encounterid+"' and PATIENT_ID='"+patientid+"' ");
			}//End ML-MMOH-CRF-1978
			else{
			sql_bl.append("select count(*) from IP_OPEN_ENCOUNTER where FACILITY_ID = '"+facilityId+"' and ENCOUNTER_ID ='"+encounterid+"' and PATIENT_ID='"+patientid+"' ");
			}
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql_bl.toString());
			if(rset!=null && rset.next())
			{
				count = rset.getInt(1);
			}
			if(rset!=null)rset.close();
			if(stmt!=null)stmt.close();

			if(count > 0 )
			{	
				call_function	= "ReferralPatientDetails";
			
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bed_block_period_dis_int));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(dis_date_chk_days_int));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
	}
			else
			{
				out.println("<script>alert(getMessage('ENCOUNTER_NOT_FOUND','Common'));window.close();</script>");	
			}

		}catch(Exception e) 
		{
			out.println(e.toString());
		}
		finally
		{
			ConnectionManager.returnConnection(con,request);
		}
	}
	else if(called_for.equals("Confirm"))
	{	
		try
		{
			call_function = "BedSideReferral";
			String jsp_name = "ConfirmBedSideReferralDetail.jsp";
		
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(jsp_name));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(practid));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block25Bytes, _wl_block25);
	}catch(Exception e) 
		{
			out.println(e.toString());
		}
		finally
		{
			ConnectionManager.returnConnection(con,request);
		}
	}

            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ConfirmBedsideReferral.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ConfirmBedsideReferral.label", java.lang.String .class,"key"));
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
