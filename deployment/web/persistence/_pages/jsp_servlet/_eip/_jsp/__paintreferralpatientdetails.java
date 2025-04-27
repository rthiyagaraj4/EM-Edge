package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.util.*;
import com.ehis.util.*;

public final class __paintreferralpatientdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/PaintReferralPatientDetails.jsp", 1729096422481L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eMP/js/ReferralDtls.js\' language=\'javascript\'></script> <!--Added for this CRF ML-MMOH-CRF-0566-->\n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<head><title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title></head>\n\t<iframe name=\"PatientLine_frame\" id=\"PatientLine_frame\" src=\"../../eCommon/jsp/pline.jsp?Facility_Id=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&EncounterId=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"  scrolling=\'no\' noresize style=\'height:10vh;width:100vw\'></iframe>\n\t   <iframe name=\"Transfer_frame\" id=\"Transfer_frame\" src=\"../../eIP/jsp/addModifyRefPatientDtls.jsp?function_id=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&encounter_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&function_id=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&call_function=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&wherecondn=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&referral_id=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&bed_block_period_dis=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&dis_date_chk_days=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&oper_stn_id=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&called_from=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&patientid=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&callfrom=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"  scrolling=\'auto\' noresize style=\'height:85vh;width:100vw\'></iframe>\n\t   <iframe src=\"../../eCommon/jsp/error.jsp\" name=\"Dummy_frame\" id=\"Dummy_frame\" scrolling=\'auto\' noresize style=\'height:0vh;width:100vw\'></iframe>\n\t\n</html>\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
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
   int bed_block_period_dis_int = 0;
   int dis_date_chk_days_int	= 0;

    String facilityId			= (String)session.getValue("facility_id");
	String encounterid			= checkForNull(request.getParameter("encounterId"));
	String patientid			= checkForNull(request.getParameter("patientid"));
	String called_from			= checkForNull(request.getParameter("called_from"));
	String call_function		= checkForNull(request.getParameter("call_function"));
	String function_id		= checkForNull(request.getParameter("function_id"));
	String oper_stn_id			= checkForNull(request.getParameter("oper_stn_id"));
	
	//Added for this CRF ML-MMOH-CRF-0566
	String callfrom = checkForNull(request.getParameter("callfrom"));
	

	String bed_block_period_dis	= checkForNull(request.getParameter("bed_block_period_dis"));
	if(!bed_block_period_dis.equals(""))
		bed_block_period_dis_int = Integer.parseInt(bed_block_period_dis);

	String dis_date_chk_days	= checkForNull(request.getParameter("dis_date_chk_days"));
	if(!dis_date_chk_days.equals(""))
		dis_date_chk_days_int = Integer.parseInt(dis_date_chk_days);

	String title = "";
	if(call_function.equals("BedSideReferral"))
	{
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ConfirmBedsideReferral.label","common_labels");
	}
	else
	{
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RegisterInpatientReferral.label","common_labels");
	}

	if(function_id.equals("PRACT_FOR_BEDSIDE_REFERRAL"))
	{
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AssignPractitionerBedsideReferral.label","ip_labels");
	}

	String wherecondn	= "ADMIT_PAT_YN";
    String referral_id	= checkForNull(request.getParameter("referralID"));

	if(call_function.equals("ReferralPatientDetails") && called_from.equals("CA") )
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedSideReferral.label","common_labels");
		
//Below line frameset modified  for this CRF ML-MMOH-CRF-0566 

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(title));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(wherecondn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(bed_block_period_dis_int));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(dis_date_chk_days_int));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(callfrom));
            _bw.write(_wl_block21Bytes, _wl_block21);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
