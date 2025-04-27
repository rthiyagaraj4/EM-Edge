package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public final class __dprecodingsupportdiagframes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/DPRecodingSupportDiagFrames.jsp", 1709118912407L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n <!-- \n\t1.Page was created for SRR-CRF-303.2\n\t2.For Recoding astriks for a Dagger.\n\t3.Created On 1/28/2010\n--> \n\n";
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script language=\'javascript\' src=\'../../eMR/js/DPRecoding.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t\t<title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title>\n\t</head>\n\t</html>\n\t<iframe name=\"Linked_Support_Diag_Frame\" id=\"Linked_Support_Diag_Frame\" frameborder=\"no\" scrolling=\"NO\" noresize src=\"../../eMR/jsp/DPRecodingLinkedSupportDiag.jsp?calling_status=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&associate_codes=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&term_set=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&term_code=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&encounter_id=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&patient_id=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&occur_srl_no=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&stage_no_disp=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&support_seq_no=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&Group_seq_no=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&group_YN=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&trx_no=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&supprt_diag_view=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t</iframe>\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t<iframe name=\"Unlinked_Support_Diag_Frame\" id=\"Unlinked_Support_Diag_Frame\" frameborder=\"no\" scrolling=\"NO\" noresize src=\"../../eMR/jsp/DPRecodingUnlinkedSupportDiag.jsp?calling_status=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&diagprob_code_val=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"/>\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t<iframe name=\"Record_Support_Diag_Frame\" id=\"Record_Support_Diag_Frame\" frameborder=\"no\" scrolling=\"NO\" noresize src=\"../../eMR/jsp/DPRecordSupportDiagnosis.jsp?calling_status=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&record_assosicate_codes_0=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&record_assosicate_codes_1=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&record_assosicate_codes_2=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t</iframe>\n\t\t<iframe name=\"Support_Diag_BTN_Frame\" id=\"Support_Diag_BTN_Frame\" frameborder=\"no\" scrolling=\"NO\" noresize src=\"../../eMR/jsp/DPRecodingSupportDiagBtns.jsp?calling_status=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&activity=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&hdr_modified_dt=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t</iframe>\n\t\t<iframe name=\"messageFrame\" src=\'../../eCommon/jsp/MstCodeError.jsp\' name=\'messageFrame\' id=\'messageFrame\' noresize frameborder=\"no\" scrolling=\'NO\'></iframe><iframe name=\"targetFrame\" src=\'../../eCommon/jsp/MstCodeError.jsp\' name=\'targetFrame\' id=\'targetFrame\' noresize frameborder=\"no\" scrolling=\'NO\'></iframe>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\n\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

	public static String checkForNull(String inputString){
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue){
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

		String sStyle					= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
		String associate_codes	= checkForNull(request.getParameter("associate_codes"));
		String activity				= checkForNull(request.getParameter("activity"));
		String calling_status		= checkForNull(request.getParameter("calling_status"));
		String term_set				= checkForNull(request.getParameter("term_set"));
		String term_code			= checkForNull(request.getParameter("term_code"));
		String encounter_id		= checkForNull(request.getParameter("EncounterId"));
		String patient_id			= checkForNull(request.getParameter("patient_id"));
		String occur_srl_no		= checkForNull(request.getParameter("occur_srl_no"));
		String stage_no_disp		= checkForNull(request.getParameter("stage_no_disp"));
		String support_seq_no	= checkForNull(request.getParameter("support_seq_no"));
		String Group_seq_no	= checkForNull(request.getParameter("Group_seq_no"));
		String group_YN			= checkForNull(request.getParameter("group_YN"));
		String trx_no					= checkForNull(request.getParameter("trx_no"));
		String supprt_diag_view	= checkForNull(request.getParameter("supprt_diag_view"));
		String diagprob_code_val		= checkForNull(request.getParameter("diagprob_code_val"));//diagprob_code_val value is only sent to  DPRecodingUnlinkedSupportDiag.jsp only because the Support Diagnosis is wil be recorded from Adding New Code & Recoding a Code.
		String record_assosicate_codes_0		= checkForNull(request.getParameter("record_assosicate_codes_0"));
		String record_assosicate_codes_1		= checkForNull(request.getParameter("record_assosicate_codes_1"));
		String record_assosicate_codes_2		= checkForNull(request.getParameter("record_assosicate_codes_2"));
		String hdr_modified_dt							= checkForNull(request.getParameter("hdr_modified_dt"));


		String FrameSettings		= "";

		if(activity.equals("RECORD")){
			FrameSettings	="4%,*,5%,3%,0%";
		}else if(activity.equals("RECODE")){
			FrameSettings	="46%,47%,4%,3%,0%";
		}


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(calling_status));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(associate_codes));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(occur_srl_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(stage_no_disp));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(support_seq_no));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Group_seq_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(group_YN));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(trx_no));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(supprt_diag_view));
            _bw.write(_wl_block21Bytes, _wl_block21);
if(activity.equals("RECODE")){
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(calling_status));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(associate_codes));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(occur_srl_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(stage_no_disp));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(support_seq_no));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Group_seq_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(group_YN));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(trx_no));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(diagprob_code_val));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(supprt_diag_view));
            _bw.write(_wl_block24Bytes, _wl_block24);
}else{
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(calling_status));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(associate_codes));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(occur_srl_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(stage_no_disp));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(support_seq_no));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Group_seq_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(group_YN));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(trx_no));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(diagprob_code_val));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(record_assosicate_codes_0));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(record_assosicate_codes_1));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(record_assosicate_codes_2));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(supprt_diag_view));
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(calling_status));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(term_set));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(occur_srl_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(stage_no_disp));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(support_seq_no));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Group_seq_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(group_YN));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(trx_no));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(activity));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(supprt_diag_view));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(hdr_modified_dt));
            _bw.write(_wl_block32Bytes, _wl_block32);
            _bw.write(_wl_block33Bytes, _wl_block33);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SupportingDiagnosis.label", java.lang.String .class,"key"));
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
