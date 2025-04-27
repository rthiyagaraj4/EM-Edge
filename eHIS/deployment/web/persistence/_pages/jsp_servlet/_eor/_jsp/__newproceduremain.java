package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __newproceduremain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/NewProcedureMain.jsp", 1709117180000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<title>New Procedure </title>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></SCRIPT>\n\t<script src=\'../js/NewProcedure.js\' language=\'javascript\'></script>\n\t\n</head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<frameset id =\'ProcMain\' rows=\'7%,15%,3%,*,4%,7%,7%\' >\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<!-- <frameset id =\'ProcMain\' rows=\'17%,43%,3%,*,4%,0%,7%\' > -->\n\t\t<frameset id =\'ProcMain\' rows=\'17%,53%,3%,*,0%,0%,4%,7%\' >\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\n\t\t<frame name=\'NewProcSearch\' framespacing=0 border=0 src=\'../../eOR/jsp/NewProcedureSearch.jsp\' scrolling=\'no\' frameborder=\'no\' noresize>\n\t\t\n\t\t<frame name=\'NewProcExisting\' framespacing=0 border=0 src=\'../../eOR/jsp/NewProcedureQueryResult.jsp?Logical_Seq=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&Function=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&Patient_Id=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&Encounter_Id=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&Practitioner_Id=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&Locn_Code=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&relationship_id=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&Locn_Type=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&f_authorize_yn=N&P_context=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&patient_class=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&Age=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&Dob=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&Sex=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&term_code=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&term_set_id=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&modal_yn=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' scrolling=\'auto\'  frameborder=\'no\' noresize>\n\n\t\t<frame name=\'NewProcLegend\' framespacing=0 border=0 src=\'../../eOR/jsp/NewProcedureLegend.jsp\' frameborder=\'no\' scrolling=\'no\' noresize>\n\n\t\t<frame name=\'NewProcedure\' framespacing=0 border=0 src=\'../../eOR/jsp/NewProcedureAddModify.jsp?Logical_Seq=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&called_from_ip=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&occur_srl_no=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' frameborder=\'no\' scrolling=\'auto\' noresize>\n\t\t\n\t\t<!-- <frame name=\'NewMultiProcedure\' framespacing=0 border=0 src=\'../../eOR/jsp/NewProcedureAddModifyMulti.jsp?Logical_Seq=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' frameborder=\'no\' scrolling=\'auto\' noresize> -->\n\t\t<frame name=\'NewMultiProcedure\' framespacing=0 border=0 src=\'../../eCommon/html/blank.html\' frameborder=\'no\' scrolling=\'auto\' noresize>\n\t\t\n\t\t<frame name=\'NewMultiPractProcedure\' framespacing=0 border=0 src=\'../../eOR/jsp/NewProcedureAddModifyPractMulti.jsp?Logical_Seq=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' frameborder=\'no\' scrolling=\'auto\' noresize>\n\n\t\t<frame name=\'NewProcBtn\' frameborder=\'no\' framespacing=0 border=0 src=\'../../eOR/jsp/NewProcedureBtn.jsp?Logical_Seq=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' scrolling=\'no\' noresize>\n\t\t\n\t\t\t\t\n\t\t<frame name=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=\'no\' noresize border=0 scrolling=\'no\'>\n\t\t\n\t</frameset>\n</html>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block6Bytes, _wl_block6);

	String occur_srl_no="";
	String Patient_Id			= request.getParameter("patient_id");
	
	String Encounter_Id			= request.getParameter("encounter_id");

	String Practitioner_Id		= "";
	String relationship_id		= checkForNull(request.getParameter("relationship_id"));	
	String Locn_Code			= request.getParameter("location_code");
	String Locn_Type			= checkForNull(request.getParameter("location_type"));   
	if(Locn_Type.equals("")) Locn_Type="C";

	String function				= checkForNull(request.getParameter("Function"));  
	String context				= checkForNull(request.getParameter("Context"));  
	String logicalseqno			= checkForNull(request.getParameter("Logical_Seq"));  
	String patient_class		= checkForNull(request.getParameter("patient_class"));  
	String called_from_ip		= checkForNull(request.getParameter("IP_YN")); 
	String age					= checkForNull(request.getParameter("Age")); 
	String dob					= checkForNull(request.getParameter("Dob")); 
	String sex					= checkForNull(request.getParameter("Sex"));
	occur_srl_no				= checkForNull(request.getParameter("occur_srl_no"));
	String term_code			= checkForNull(request.getParameter("term_code"));
	String term_set_id			= checkForNull(request.getParameter("term_set_id"));
	String modal_yn				= checkForNull(request.getParameter("modal_yn"));
	Practitioner_Id				= checkForNull(request.getParameter("ip_practitioner_id")); 

	if(Practitioner_Id.equals("") || Practitioner_Id.equals("null")){
			Practitioner_Id		= (String)session.getValue("ca_practitioner_id");
	
}

            _bw.write(_wl_block7Bytes, _wl_block7);

	if(modal_yn.equals("Y"))
	{
	
            _bw.write(_wl_block8Bytes, _wl_block8);

	}
	else
	{
	
            _bw.write(_wl_block9Bytes, _wl_block9);

	}

	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(logicalseqno));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(function));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(relationship_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Locn_Type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(context));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(age));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(logicalseqno));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(function));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(relationship_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Locn_Type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(context));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(age));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(occur_srl_no));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(logicalseqno));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(function));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(relationship_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Locn_Type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(context));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(age));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(occur_srl_no));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(logicalseqno));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(function));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(relationship_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Locn_Type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(context));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(age));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(occur_srl_no));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(logicalseqno));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(function));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(relationship_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Locn_Type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(context));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(age));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block32Bytes, _wl_block32);
            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
