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

public final class __camaintaindeathregister extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/CAMaintainDeathRegister.jsp", 1743665177760L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t<title> ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\' ></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t</head>\n<script>\nasync function call_death_reg(encid, patid, practId, pat_class, spclty_code, sex, dob, pract_type,  pat_curr_locn_code,finalize_yn,visit_adm_date)\n\t\t{\n\t\t\tvar dialogHeight=\"42vh\";\n\t\t\tvar dialogWidth=\"80vw\";\n\t\t\tvar dialogTop=\"100\";\n\t\t\tvar center = \"1\" ;\n\t\t\tvar status=\"no\";\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\tvar arguments\t= \"\" ;\n\t\t\tvar action_url=\"../../eMR/jsp/DeathRegisterFrames.jsp?cause_of_death=Y&modal_yn=Y&Locn_Code=\"+pat_curr_locn_code+\"&Sex=\"+sex+\"&Dob=\"+dob+\"&speciality_code=\"+spclty_code+\"&patient_id=\"+patid+\"&encounter_id=\"+encid+\"&episode_id=\"+encid+\"&practitioner_id=\"+practId+\"&practitioner_type=\"+pract_type+\"&patient_class=\"+pat_class+\"&call_from=MAINTAIN_DEATH_REGISTER&episode_type=I&finalize_yn=\"+finalize_yn+\"&visit_adm_date=\"+visit_adm_date;\n\t\tvar title=\"\";\n\t\tvar retVal=await window.showModalDialog(action_url,title,features);\n\t\tif(retVal==undefined){\n\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\txmlHttp.open(\"POST\",\"../../eMR/jsp/DearthRegisterValidation.jsp?mode=RemoveSessionVals\",false);\n\t\t\txmlHttp.send(null);\t\t\n\t\t\tresponseText=xmlHttp.responseText;\n\t\t}\n\t\t\tparent.frames[2].location.reload();\n}\n</script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<!-- <frameset rows=\"100%\">\n\t\t\t\t\t<frame name=\'CA_Death_Register_Frame\' id=\'CA_Death_Register_Frame\' src=\"../../eMR/jsp/DeathRegisterFrames.jsp?patient_id=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&encounter_id=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&locn_code=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&gender=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&dob=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&speciality_code=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&episode_id=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&practitioner_id=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&practitioner_type=&patient_class=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&call_from=\'CA\'&episode_type=&mode=&finalize_yn=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&visit_adm_date=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" frameborder=\'0\' noresize scrolling=\'NO\'>\n\t\t\t\t\t</frame>\n\t\t\t\t</frameset> -->\n\t\t\t<script>\n\t\t\t\tcall_death_reg(\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\',\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\',\'\',\'\',\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\');\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t<script>\n//\t\talert(\"APP-MR0137 Maintain Death Register is not applicable for this encounter.\");\n\t\tvar err_msg=getMessage(\"MR_MDR_NOT_APPLICABLE\",\"MR\")\n\t\talert(err_msg)\n\t</script>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

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
 request.setCharacterEncoding("UTF-8"); 
//String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 

            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);


String patient_id				=	checkForNull(request.getParameter("patient_id"));
String encounter_id			=	checkForNull(request.getParameter("encounter_id"));
String locn_code				=	checkForNull(request.getParameter("location_code"));
String gender	 					=	checkForNull(request.getParameter("Sex"));
String dob							=	checkForNull(	request.getParameter("Dob"));
String speciality_code		=	checkForNull(request.getParameter("speciality_code"));
String episode_id				=	checkForNull(request.getParameter("episode_id"));
String patient_class			=	checkForNull(request.getParameter("patient_class"));
String visit_adm_date		=	checkForNull(request.getParameter("visit_adm_date"));

String practitioner_id			=	checkForNull(request.getParameter("practitioner_id"));
String finalize_yn				=	checkForNull(request.getParameter("finalize_yn"));


Connection conn=null;
PreparedStatement pstmt=null;
ResultSet rs=null;

	String facilityId		= ((String)session.getValue("facility_id"));


try{

	conn=ConnectionManager.getConnection(request);

	session.removeAttribute("combined_map");
	session.removeAttribute("diag_dates_map");


	pstmt=conn.prepareStatement("select ATTEND_PRACTITIONER_ID,finalize_yn from mr_death_register_hdr  where encounter_id='"+encounter_id+"' and facility_id='"+facilityId+"'");
	rs=pstmt.executeQuery();

	if(rs.next()){
		practitioner_id=rs.getString("ATTEND_PRACTITIONER_ID");
		finalize_yn=rs.getString("finalize_yn");


		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(finalize_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(finalize_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block22Bytes, _wl_block22);
}else{
            _bw.write(_wl_block23Bytes, _wl_block23);
}
}catch(Exception ex){
	ex.printStackTrace();
}finally{
		ConnectionManager.returnConnection(conn,request);
}
            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.MaintainDeathRegister.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
