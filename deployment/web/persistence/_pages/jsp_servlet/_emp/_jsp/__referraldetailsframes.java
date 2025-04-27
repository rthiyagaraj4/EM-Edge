package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __referraldetailsframes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/ReferralDetailsFrames.jsp", 1741936599377L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n \n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'</link> -->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<title>\n\t\t\t ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&nbsp;\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t</title>\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n          <!--Below line  modified for this CRF-Bru-HIMS-CRF-261 -->\n      ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<iframe NAME=\'PLINE\' SRC=\'../../eCommon/jsp/pline.jsp?EncounterId=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&Facility_Id=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' noresize  frameborder=\'no\' scrolling=\'no\' style=\'height:";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =";width:99vw\'></iframe>\n\t\t\t<iframe name=\'Referral_Detail_frame\' \t src=\'../../eMP/jsp/ReferralDetails.jsp?EncounterId=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&Module=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&patient_id=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&discharge_indicator=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&Transaction_type=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&regOutref=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&from_patient_id=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&from_locn_type=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&from_service_code=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&from_specialty_code=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&from_practitioner_id=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&from_practitioner_name=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&from_nursing_unit_code=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&from_nursing_unit_short_desc=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&function_id=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&allow_muti_bedside_review_yn=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&recFun=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&recFunVal=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =";width:99vw\'></iframe> \n\t\t\t<!--Below line  Modified  For AAKH-CRF-0010 [IN:038535] by Dharma on Mar 11th 2014 Start -->\n\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t<iframe name=\'Referral_Result_frame\' src=\'../../eMP/jsp/ReferralDetailsResult.jsp?encounter_id=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =";width:99vw\'></iframe>\n\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t<iframe name=\'Referral_Result_frame\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'no\' noresize style=\'height:";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t<!--Below line  Modified  For AAKH-CRF-0010 [IN:038535] by Dharma on Mar 11th 2014 End -->\n\t\t\t\n\t\t\t<iframe name=\'messageFrame1\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =";width:99vw\'></iframe>\n\t\t<!-- </frameset> -->\n\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" <!--Below line  modified for this CRF-Bru-HIMS-CRF-261 -->\n\t\t\t<iframe name=\'PLINE\' id=\'PLINE\' SRC=\'../../eCommon/jsp/pline.jsp?EncounterId=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =";width:99vw\'></iframe>\n\t\t\t<iframe name=\'Referral_Detail_frame\' id=\'Referral_Detail_frame\' src=\'../../eMP/jsp/ReferralDetails.jsp?EncounterId=";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="&referral_id=";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' frameborder=0 scrolling=\'auto\' noresize style=\'height:";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =";width:99vw\'></iframe>\n\t\t\t<!-- below \"Referral_Result_frame\" added by Venkatesh.S on 21/12/2012 againist 36866 -->\n\t\t\t<!--Below line  Modified  For AAKH-CRF-0010 [IN:038535] by Dharma on Mar 11th 2014 Start -->\n\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t<iframe name=\'Referral_Result_frame\' id=\'Referral_Result_frame\' src=\'../../eMP/jsp/ReferralDetailsResult.jsp?encounter_id=";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t<iframe name=\'Referral_Result_frame\' id=\'Referral_Result_frame\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'no\' noresize style=\'height:";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t<!--Below line  Modified  For AAKH-CRF-0010 [IN:038535] by Dharma on Mar 11th 2014 End -->\n\t\t\t<iframe name=\'messageFrame1\' id=\'messageFrame1\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =";width:99vw\'></iframe>\n\t\t<!-- </frameset> -->\n\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n</html>\n\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

public static String checkForNull(String inputString)
{
	return((inputString == null) ? "" : inputString);
}
public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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

///+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/// Module			: OP
/// Created By		: SRIDHAR R 
/// Created Date	: 6 SEP 2004
/// Function		: File used to define frames & will be called from Discharge Advice [IP] / Discharge Patient [IP] / CheckOut [OP/AE] Functions...  
///+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String facilityID		= (String) session.getValue("facility_id");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
	
	String Transaction_type	= request.getParameter("Transaction_type");
		if(Transaction_type == null)	Transaction_type = "";
	
	/*Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187*/
	String called_from	= request.getParameter("called_from");
		if(called_from == null)	called_from = "";

	String patient_class = request.getParameter("patient_class");
		if(patient_class == null)	patient_class = "";

	String encounterid = "";

	if(called_from.equals("CA")){
		encounterid	= request.getParameter("encounter_id");
			if(encounterid	== null	) encounterid = "";

		if(patient_class.equals("IP")){
			Transaction_type = "DP";
		}else if(patient_class.equals("DC")){
			Transaction_type = "DA";
		}else{
			Transaction_type = "CO";
		}
	}else{
		encounterid	= request.getParameter("EncounterId");
			if(encounterid	== null	) encounterid = "";
	}
	/*End MMS-DM-CRF-0187*/

	String patient_id		= request.getParameter("patient_id");
		if(patient_id	== null	) patient_id = "";
	/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 start*/ 
	String referral_id1		= request.getParameter("referral_id");
		if(referral_id1	== null	) referral_id1 = "";

	String recFun		= request.getParameter("recFun");
		if(recFun	== null	) recFun = "";

	String recFunVal		= request.getParameter("recFunVal");
		if(recFunVal	== null	) recFunVal = "";
	String EncounterId		= request.getParameter("EncounterId");
	if(EncounterId	== null	) EncounterId = "";	
	/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 end*/ 	
	String Module			= request.getParameter("Module");
		if(Module == null)	Module = "";

	String discharge_indicator	= request.getParameter("discharge_indicator");
		if(discharge_indicator == null)	discharge_indicator = "";	

	String from_patient_id		= checkForNull(request.getParameter("from_patient_id"));
	String from_locn_type		= checkForNull(request.getParameter("from_locn_type"));
	String from_service_code	= checkForNull(request.getParameter("from_service_code"));
	String from_specialty_code	= checkForNull(request.getParameter("from_specialty_code"));
	String from_practitioner_id	= checkForNull(request.getParameter("from_practitioner_id"));
	String from_practitioner_name = checkForNull(request.getParameter("from_practitioner_name"));
	String from_nursing_unit_code = checkForNull(request.getParameter("from_nursing_unit_code"));
	String from_nursing_unit_short_desc	= checkForNull(request.getParameter("from_nursing_unit_short_desc"));
	String regOutref= checkForNull(request.getParameter("functions_id"));

	String function_id= checkForNull(request.getParameter("function_id")); //this line Added for this CRF-Bru-HIMS-CRF-261
   /*Below line modified for this CRF HSA-CRF-0263.1*/
	String allow_muti_bedside_review_yn = checkForNull(request.getParameter("allow_muti_bedside_review_yn"),"N");
	String height1="";
	String height2="";
	String height3="";
	String height4="";
	
	
            _bw.write(_wl_block8Bytes, _wl_block8);
if(function_id.equals("RegPatRefFromAEAssessment")){
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
}else if(recFun.equals("ModifyReferral")) { 
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
}else{ 
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
} 
            _bw.write(_wl_block12Bytes, _wl_block12);
	
	if(Transaction_type.equals("DP"))
	{	
	/*Below line modified for this CRF HSA-CRF-0263.1*/	
	
            _bw.write(_wl_block13Bytes, _wl_block13);
if(!function_id.equals("RegPatRefFromAEAssessment")){
    	  /* <frameset rows='40%,175%,80%,0%'>  */
    	  height1="10vh";
		  height2="52vh";
		  height3="36vh";
		  height4="0vh";
	 }else{
		 /* 	<frameset rows='40%,175%,0%,0%'>*/
		 height1="10vh";
		 height2="85vh";
		 height3="0vh";
		 height4="0vh";
	  }
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(height1));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(java.net.URLEncoder.encode(encounterid)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Module));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(discharge_indicator));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Transaction_type));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(regOutref));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(from_patient_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(from_locn_type));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(from_service_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(from_specialty_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(from_practitioner_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(from_practitioner_name));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(from_nursing_unit_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(from_nursing_unit_short_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(allow_muti_bedside_review_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(recFun));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(recFunVal));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(height2));
            _bw.write(_wl_block36Bytes, _wl_block36);
if(!function_id.equals("RegPatRefFromAEAssessment")){
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(java.net.URLEncoder.encode(encounterid)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Module));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Transaction_type));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(allow_muti_bedside_review_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(recFun));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(recFunVal));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(height3));
            _bw.write(_wl_block38Bytes, _wl_block38);
}else{ 
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(height3));
            _bw.write(_wl_block38Bytes, _wl_block38);
} 
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(height4));
            _bw.write(_wl_block41Bytes, _wl_block41);
	
	}
	else if(Transaction_type.equals("DA") || Transaction_type.equals("CO"))
	{
	
	if(!function_id.equals("RegPatRefFromAEAssessment")){
		/* <frameset rows='40%,240%,60%,0%'> */
		height1="10vh";
		height2="52vh";
		height3="36vh";
		height4="0vh";
	}else{
		/* <frameset rows='40%,225%,0%,0%'> */
		height1="10vh";
		height2="85vh";
		height3="0vh";
		height4="0vh";
	}
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(facilityID));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(height1));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(java.net.URLEncoder.encode(encounterid)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Module));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(discharge_indicator));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Transaction_type));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(regOutref));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(allow_muti_bedside_review_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(recFun));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(recFunVal));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(referral_id1 ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(height2));
            _bw.write(_wl_block46Bytes, _wl_block46);
if(!function_id.equals("RegPatRefFromAEAssessment") && !recFun.equals("for_admission")){
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(java.net.URLEncoder.encode(encounterid)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Module));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Transaction_type));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(allow_muti_bedside_review_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(recFun));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(referral_id1 ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(height3));
            _bw.write(_wl_block38Bytes, _wl_block38);
}else{ 
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(height3));
            _bw.write(_wl_block38Bytes, _wl_block38);
} 
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(height4));
            _bw.write(_wl_block50Bytes, _wl_block50);
	
	}	
	
            _bw.write(_wl_block51Bytes, _wl_block51);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.RegisterPatientReferral.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.edit.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referraldetails.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.RegisterReferraldetails.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
