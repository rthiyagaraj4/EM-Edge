package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __patproblemlist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/PatProblemList.jsp", 1739956396145L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n<head>\n<title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n</head>\n\n\t\t<iframe   src=\"Problemsframe0.jsp?Patient_Id=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&Context=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&P_function_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&P_no_of_items=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&P_option_type=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&modal_yn=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&encounter_id=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" name=\"problemsframe0\" id=\"problemsframe0\" marginheight=\'0\'  frameborder=no scrolling=\'no\' style=\"height:";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =";width:100vw\" ></iframe>\n\t\t<iframe  src=\"Problemsframe1.jsp?Patient_Id=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&P_access_type=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&radio_par=A&P_function_id=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" name=\"problemsframe1\" id=\"problemsframe1\"   scrolling=yes frameborder=no align=top noresize=\"noresize\" style=\"height:";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =";width:100vw\"></iframe>\n\t\n\t\t<iframe src = \"ProblemsDetails.jsp?Patient_Id=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" name=\'problemsdetails\' id=\'problemsdetails\' marginheight=\'0\' marginwidth=\'0\' scrolling=no frameborder=no noresize=\"noresize\" style=\"height:";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =";width:100vw\"></iframe>\n\t\t<iframe src = \"ProblemsAssessment.jsp?Patient_Id=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" name=\"problemsassessments\" id=\"problemsassessments\" marginheight=\'0\' marginwidth=\'0\' frameborder=\'no\' style=\"height:";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =";width:100vw\"></iframe>\n\t\t\n\t\t\n\t\t<iframe name=\"problemframeControl\" id=\"problemframeControl\" src=\"PatProblemControl.jsp?modal_yn=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&called_mod=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" frameborder=no scrolling=\'no\' style=\"height:";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =";width:100vw\" ></iframe>\n\t\t<!-- <iframe name=\"problemframeEncounter\" src=\"\" frameborder=no scrolling=no></iframe> -->\n\t\t\n\t\t<iframe name=\'RecDiagnosisCurrentDiagLegend\' id=\'RecDiagnosisCurrentDiagLegend\' framespacing=0 border=0 src=\'../../eMR/jsp/RecDiagnosisCurrentDiagLegend.jsp\' frameborder=\'no\' scrolling=\'no\' noresize style=\"height:";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =";width:100vw\"></iframe>\n\t\t<!-- IN064458 ends -->\n\t\n</html> \n";
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

/*
--------------------------------------------------------------------------------------------------------------------
Date      	 Edit History     		 Name        		Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------
08/01/2018	   IN064458			Kamalakannan G.			08/01/2018		Ramesh G	  ML-MMOH-CRF-0869(legends frame added)
--------------------------------------------------------------------------------------------------------------------
*/

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
            _bw.write(_wl_block2Bytes, _wl_block2);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

String patientid = request.getParameter("patient_id");
String context = (String)request.getParameter("PQ");
if (context==null) context="Y";

String P_access_type = request.getParameter("Access_Type");
//String P_access_data = request.getParameter("Access_Data");
//String P_patient_type = request.getParameter("Patient_Type");

//****added for PH function usage
String P_function_id=request.getParameter("P_function_id")==null?"":request.getParameter("P_function_id");
String P_no_of_items=request.getParameter("P_no_of_items")==null?"0":request.getParameter("P_no_of_items");

String P_option_type=request.getParameter("P_option_type")==null?"":request.getParameter("P_option_type");
String modal_yn=request.getParameter("modal_yn")==null?"N":request.getParameter("modal_yn");
String encounter_id=request.getParameter("encounter_id")==null?"0":request.getParameter("encounter_id");
String called_mod=request.getParameter("called_mod") == null ? "N" : request.getParameter("called_mod");
//out.println("<script>alert('"+encounter_id+"')</script>");

//String frameSet="*%,17%,40%,0%,6%"; 
//String frameSet="26%,35%,*,0%,0%"; // commented for IN064458
//String frameSet="26%,35%,*,0%,0%,5%"; // added for IN064458
String height1 = "23vh";
String height2 = "30vh";
String height3 = "37vh";
String height4 = "0vh";
String height5 = "0vh";
String height6 = "5vh";

if(P_function_id.equals("PH"))
{
	//frameSet="25%,17%,*,6%,0%"; // commented for IN064458
	//frameSet="25%,17%,*,6%,0%,5%";//IN064458
	height1 = "25vh";
	height2 = "20vh";
	height3 = "40vh";
	height4 = "0vh";
	height5 = "5vh";
	height6 = "5vh";
} 
if(called_mod.equals("BL"))
{
	//frameSet="0,17%,*,6%,0%"; // commented for IN064458
	//frameSet="0,17%,*,6%,0%,0%";//IN064458
	height1 = "25vh";
	height2 = "17vh";
	height3 = "75vh";
	height4 = "0vh";
	height5 = "5vh";
	height6 = "5vh";
} 

//****


            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(context));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(P_function_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(P_no_of_items));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(P_option_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(height1));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(context));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(P_access_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(P_function_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(P_no_of_items));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(P_option_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(height2));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(context));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(height3));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(context));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(height4));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(called_mod));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(height5));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(height6));
            _bw.write(_wl_block28Bytes, _wl_block28);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ProblemList.label", java.lang.String .class,"key"));
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
