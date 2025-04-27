package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.util.StringTokenizer;
import java.util.TreeMap;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __recdiagnosismain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/RecDiagnosisMain.jsp", 1738248252914L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/emr/jsp/RecDiagnosisGetValidation.jsp", 1730014091638L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n\n<script src=\'../js/RecDiagnosis.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n</html>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<html>\n<head>\n\t<title> ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" </title>\n\t<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\' ></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n</head>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<!-- <frameset id =\'RecDiagMain\' rows=\'7%,0%,0%,0%,*,4%,7%,8%\' > -->\n\t\t\t\t<!--<frameset id =\'RecDiagMain\' rows=\'7%,15%,3%,*,4%,7%,7%\' >-->\n\t\t<script>\n\t\t/* document.getElementById(\'pline\').style.height=\"8vh\";\n\t\tdocument.getElementById(\'RecDiagnosisCurrentDiagheader\').style.height=\"3vh\";\n\t\tdocument.getElementById(\'RecDiagnosisCurrentDiag\').style.height=\"2vh\";\n\t\tdocument.getElementById(\'RecDiagnosisCurrentDiagLegend\').style.height=\"2vh\";\n\t\tdocument.getElementById(\'RecDiagnosisAddModify\').style.height=\"75vh\";\n\t\tdocument.getElementById(\'RecDiagnosisOpernToolbar\').style.height=\"6vh\";\n\t\tdocument.getElementById(\'blankframe1\').style.height=\"0vh\";\n\t\tdocument.getElementById(\'messageFrame\').style.height=\"8vh\"; */\n\t\t</script>\n\t\t\n\t\t\n\t\t\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" \n\t\t<!--\n\t\tBefore 9/22/2008 this frame set used modified by anjaneya<frameset id =\'RecDiagMain\' rows=\'7%,0,15%,3%,*,4%,7%,7%\' >\n\t\t-->\n\t\t\t<!--<frameset id =\'RecDiagMain\' rows=\'7%,15%,3%,*,4%,7%,7%\' >-->\n\t\t<!-- <script>\n\t\tdocument.getElementById(\"pline\").style.height=\"9vh\";\n\t\tdocument.getElementById(\"RecDiagnosisCurrentDiagheader\").style.height=\"3vh\";\n\t\tdocument.getElementById(\"RecDiagnosisCurrentDiag\").style.height=\"2vh\";\n\t\tdocument.getElementById(\"RecDiagnosisCurrentDiagLegend\").style.height=\"2vh\";\n\t\tdocument.getElementById(\"RecDiagnosisAddModify\").style.height=\"75vh\";\n\t\tdocument.getElementById(\"RecDiagnosisOpernToolbar\").style.height=\"6vh\";\n\t\tdocument.getElementById(\"blankframe1\").style.height=\"0vh\";\n\t\tdocument.getElementById(\"messageFrame\").style.height=\"8vh\";\n\t\t</script> -->\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<!-- <frameset id =\'RecDiagMain\' rows=\'7%,61%,3%,*,4%,0%,7%\' > -->\n\t\t\t\t<!--<frameset id =\'RecDiagMain\' rows=\'7%,15%,3%,*,4%,7%,7%\' >-->\n\t\t<!-- <script>\n\t\tdocument.getElementById(\'pline\').style.height=\"7vh\";\n\t\tdocument.getElementById(\'RecDiagnosisCurrentDiagheader\').style.height=\"3vh\";\n\t\tdocument.getElementById(\'RecDiagnosisCurrentDiag\').style.height=\"2vh\";\n\t\tdocument.getElementById(\'RecDiagnosisCurrentDiagLegend\').style.height=\"2vh\";\n\t\tdocument.getElementById(\'RecDiagnosisAddModify\').style.height=\"75vh\";\n\t\tdocument.getElementById(\'RecDiagnosisOpernToolbar\').style.height=\"6vh\";\n\t\tdocument.getElementById(\'blankframe1\').style.height=\"0vh\";\n\t\tdocument.getElementById(\'messageFrame\').style.height=\"8vh\";\n\t\t</script> --><script>//alert(\"line 231 is coming\");</script> \n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" \n\t\t\t<!-- <frameset id =\'RecDiagMain\' rows=\'7%,7%,61%,3%,*,4%,0%,7%\' > -->\n\t\t\t\t<!--<frameset id =\'RecDiagMain\' rows=\'7%,15%,3%,*,4%,7%,7%\' >-->\n\t\t<!-- <script>\n\t\tdocument.getElementById(\'pline\').style.height=\"7vh\";\n\t\tdocument.getElementById(\'RecDiagnosisCurrentDiagheader\').style.height=\"3vh\";\n\t\tdocument.getElementById(\'RecDiagnosisCurrentDiag\').style.height=\"2vh\";\n\t\tdocument.getElementById(\'RecDiagnosisCurrentDiagLegend\').style.height=\"2vh\";\n\t\tdocument.getElementById(\'RecDiagnosisAddModify\').style.height=\"75vh\";\n\t\tdocument.getElementById(\'RecDiagnosisOpernToolbar\').style.height=\"6vh\";\n\t\tdocument.getElementById(\'blankframe1\').style.height=\"0vh\";\n\t\tdocument.getElementById(\'messageFrame\').style.height=\"8vh\";\n\t\t</script> -->\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="  \n\t\t<iframe name=\'pline\' id=\'pline\'  \tsrc=\"../../eCommon/jsp/pline.jsp?EncounterId=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" frameborder=0 scrolling=no style=\"height:";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =";width:99vw\"></iframe>\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t<iframe name=\'RecDiagnosisCurrentDiagheader\' id=\'RecDiagnosisCurrentDiagheader\' framespacing=0 border=0 src=\'../../eMR/jsp/RecDiagnosisCurrentDiagHeader.jsp\' scrolling=\'no\' frameborder=\'no\' noresize style=\"height:";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =";width:99vw\"></iframe>\n\t\t\n\t\t<iframe name=\'RecDiagnosisCurrentDiag\' id=\'RecDiagnosisCurrentDiag\' framespacing=0 border=0 src=\'../../eMR/jsp/RecDiagnosisCurrentDiag.jsp?cause_of_death=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&stage_code=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&Logical_Seq=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&Function=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&Patient_Id=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&Encounter_Id=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&episode_type=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&visit_adm_date=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&Practitioner_Id=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&called_from_ip=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&practitioner_type=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&Locn_Code=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&relationship_id=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&Locn_Type=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&f_authorize_yn=N&P_context=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&patient_class=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&Age=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="&Dob=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&Sex=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&term_code=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&term_set_id=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&modal_yn=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="&option_id=";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="&accession_num=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="&oh_chart_num=";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="&p_called_from_widget=";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="&called_from_ot=";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="&function_id=";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' scrolling=\'auto\'  frameborder=\'no\' noresize style=\"height:";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =";width:99vw\"></iframe> <!--this line Modified for this [CRFPMG2012-CRF-0030] --> <!-- CHL-CRF- 0008 - IN:001472 --><!-- function_id Added by Suji Keerthi for ML-MMOH-CRF-1605 US001 on July-18,2021-->\n  \n\n\t\t<iframe name=\'RecDiagnosisCurrentDiagLegend\' id=\'RecDiagnosisCurrentDiagLegend\' framespacing=0 border=0 src=\'../../eMR/jsp/RecDiagnosisCurrentDiagLegend.jsp\' frameborder=\'no\' scrolling=\'no\' noresize style=\"height:";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =";width:99vw\"></iframe>\n\t\t<iframe name=\'RecDiagnosisAddModify\' id=\'RecDiagnosisAddModify\' framespacing=0 border=0 src=\'../../eMR/jsp/RecDiagnosisAddModify.jsp?cause_of_death=";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="&speciality_code=";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="&occur_srl_no=";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="&isCalledFromCA=";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="&mode=";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="&term_short_desc=";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="&call_from=";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="&totalRecords=";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' frameborder=\'no\' scrolling=\'auto\'   style=\"height:";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =";width:99vw;\" ></iframe> <!--this line Modified for this [CRFPMG2012-CRF-0030] --><!-- CHL-CRF- 0008 - IN:001472 --><!-- function_id Added by Suji Keerthi for ML-MMOH-CRF-1605 US001 on July-16,2021-->\n\t\t\n\t\t<iframe name=\'RecDiagnosisOpernToolbar\' id=\'RecDiagnosisOpernToolbar\' frameborder=\'no\' framespacing=0 border=0 src=\'../../eMR/jsp/RecDiagnosisOpernToolbar.jsp?cause_of_death=";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' scrolling=\'no\' noresize style=\"height:";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =";width:99vw\"></iframe><!-- function_id Added by Suji Keerthi for ML-MMOH-CRF-1605 US001 on July-16,2021-->\n\t\t\n\t\t<iframe name=\'blankframe1\' id=\'blankframe1\' scrolling=\'no\' src=\'../../eCommon/html/blank.html\'  border=0 noresize frameborder=\'no\' style=\"height:";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =";width:99vw\"></iframe>\n\t\t<iframe name=\'messageFrame\' id=\'messageFrame\'  src=\'../../eCommon/jsp/error.jsp\' frameborder=\'no\' noresize border=0 scrolling=\'auto\' style=\"height:";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =";width:99vw\"></iframe>\n\t\t\n\t\n<script>\nif(\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'==\"Y\" && \'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' ==\"\"){\n\tif(top.name!=\"\"){ // if condition added by mujafar for ML-MMOH-CRF-1023\n\t\ttop.plineFrame.document.location.reload();\n\t}\n}\n</script>\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n</html>\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );
	
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
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
 request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue 
            _bw.write(_wl_block5Bytes, _wl_block5);

	String height1 ="";
	String height2 ="";
	String height3 ="";
	String height4 ="";
	String height5 ="";
	String height6 ="";
	String height7 ="";
	String height8 ="";

	
 

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);



	Statement pstmt		= null;
	ResultSet rs				= null;
	Connection conn = ConnectionManager.getConnection(request);	

	try{
	String Patient_Id			= request.getParameter("patient_id");
	String Encounter_Id			= request.getParameter("encounter_id");
	String episode_type			= checkForNull(request.getParameter("episode_type"));
	String relationship_id		= checkForNull(request.getParameter("relationship_id"));	
	String Locn_Code			= checkForNull(request.getParameter("Locn_Code"));
	if(Locn_Code.equals(""))
		Locn_Code				= checkForNull(request.getParameter("location_code"));

	String cause_of_death		= checkForNull(request.getParameter("cause_of_death"),"N");
	String Locn_Type			= checkForNull(request.getParameter("location_type"));   
		if(Locn_Type.equals("")) Locn_Type="C";
	//String call_function		= checkForNull(request.getParameter("call_function"));  
	String function				= checkForNull(request.getParameter("Function"));  
	String context				= checkForNull(request.getParameter("Context"));  
	String logicalseqno			= checkForNull(request.getParameter("Logical_Seq"));  
	String patient_class		= checkForNull(request.getParameter("patient_class"));  
	String called_from_ip		= checkForNull(request.getParameter("IP_YN")); 
	String age					= checkForNull(request.getParameter("Age")); 
	String dob					= checkForNull(request.getParameter("Dob")); 
	String sex					= checkForNull(request.getParameter("Sex"));
	String occur_srl_no			= checkForNull(request.getParameter("occur_srl_no"));
	String term_code			= checkForNull(request.getParameter("term_code"));
	String term_set_id			= checkForNull(request.getParameter("term_set_id"));
	String modal_yn				= checkForNull(request.getParameter("modal_yn"),"N");
	String visit_adm_date		= checkForNull(request.getParameter("visit_adm_date")); 
	String practitioner_type	= checkForNull(request.getParameter("practitioner_type"));
	String speciality_code		= checkForNull(request.getParameter("speciality_code"));
	String term_short_desc		= checkForNull(request.getParameter("term_short_desc"));
	String mode						= checkForNull(request.getParameter("mode"));
	String call_from					= checkForNull(request.getParameter("call_from"));//Calling From MDR added on 9/15/2009
	String totalRecords			= checkForNull(request.getParameter("totalRecords"));//Calling From MDR added on 9/15/2009
	String role_id				= "";
	String pract_type			= "";
	StringBuffer role           =new StringBuffer(); 
	String p_called_from_widget = checkForNull(request.getParameter("p_called_from_widget"));  //CHL-CRF- 0008 - IN:001472
	/*2/16/2009 SRR20056-SCF-2767 IN008154*/
	//String Practitioner_Id		= checkForNull(request.getParameter("practitioner_id"));
	String Practitioner_Id		= (String)session.getValue("login_user");

	String isCalledFromMDR="N";
	
	String called_from_ot=checkForNull(request.getParameter("called_from_ot")); //this variable Added for this CRF  PMG2012-CRF-0030 [IN:037757]
	
	String function_id				= checkForNull(request.getParameter("function_id")); //Added by Suji Keerthi for ML-MMOH-CRF-1605 US001 on July-16,2021
	
	try{
		//if(role.length() > 0) role.delete(0,role.length());
		role.setLength(0);
		role.append("Select func_role_id,pract_type from sm_appl_user_vw where appl_user_id = '"+Practitioner_Id+"' ");
		pstmt = conn.createStatement();
		rs = pstmt.executeQuery(role.toString());
		while(rs.next())
		{
			role_id            = rs.getString(1);
			pract_type         = rs.getString(2);
		}
		if(rs!=null)rs.close();
        if(pstmt!=null)pstmt.close();

	}catch(Exception ex){
		//out.println(ex);
		ex.printStackTrace();
	}
	
	if(practitioner_type.equals("") ||(!practitioner_type.equals(pract_type))){	
		//practitioner_type = checkForNull((String)session.getValue("practitioner_type"));
		practitioner_type = pract_type;
	}

	if(Practitioner_Id.equals("") || Practitioner_Id.equals("null") || (!Practitioner_Id.equals(role_id))){
			//Practitioner_Id		= (String)session.getValue("ca_practitioner_id");
			Practitioner_Id		    = role_id;
	}


	String stage_code = checkForNull(request.getParameter("stage_code"));
	String isCalledFromCA = checkForNull(request.getParameter("CA")); 
	String accession_number     = checkForNull(request.getParameter("accession_num"));
	String oh_chart_num			= checkForNull(request.getParameter("oh_chart_num"));
	String option_id		    = checkForNull(request.getParameter("option_id"));
	//Maheshwaran added for the SKR-CRF-0020 as on 28/09/2013
	//Start
	if(isCalledFromCA.equals("Y")&&(mode.equals("R")))
	mode="";
	//End
	if(isCalledFromCA.equals(""))
		isCalledFromCA = "N";
	  
	  /*
	  Added for IN010542

	  */	 
	  String restorative_Chart=checkForNull((String)session.getAttribute("restorative_Chart"));
	if(restorative_Chart.equals("OH"))
		isCalledFromCA = "N";
	/*
	End here.
	*/

	//out.println("<script>alert('isCalledFromCA"+isCalledFromCA+"**')</script>");
	//out.println("<script>alert('modal_yn"+modal_yn+"**')</script>");
	//out.println("<script>alert('isCalledFromMDR"+isCalledFromMDR+"**')</script>");
	

            _bw.write(_wl_block5Bytes, _wl_block5);

	if(modal_yn.equals("Y")){
		if(isCalledFromCA.equals("Y")){ 	
			
		    	height1="0vh";
				height2="3vh";
				height3="25vh";
				height4="4vh";
				height5="59vh";
				height6="3vh";
				height7="0vh";
				height8="5vh"; 
				
            _bw.write(_wl_block10Bytes, _wl_block10);

		}else{ 
		   if(call_from.equals("MAINTAIN_DEATH_REGISTER")){
			  
			   height1="8vh";
				height2="3vh";
				height3="2vh";
				height4="2vh";
				height5="75vh";
				height6="6vh";
				height7="0vh";
				height8="8vh";
				
		   
		   
            _bw.write(_wl_block11Bytes, _wl_block11);
}else{
			 
			height1="10vh";
			height2="3vh";
			height3="25vh";
			height4="3vh";
			height5="59vh";
			height6="4vh";
			height7="7vh";
			height8="7vh";
				
		
            _bw.write(_wl_block12Bytes, _wl_block12);
}
	}
	}else{

		if(isCalledFromCA.equals("Y")){
			 
			 height1="8vh";
				height2="69vh";
				height3="3vh";
				height4="18vh";
				height5="4vh";
				height6="0vh";
				height7="7vh";
				
	
            _bw.write(_wl_block13Bytes, _wl_block13);

		}else{
			
			 height1="8vh";
				height2="8vh";
				height3="51vh";
				height4="3vh";
				height5="10vh";
				height6="4vh";
				height7="0vh";
				height8="7vh";
		
            _bw.write(_wl_block14Bytes, _wl_block14);
}
	}
	
            _bw.write(_wl_block5Bytes, _wl_block5);
 
	if(!isCalledFromCA.equals("Y")){
	 
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(height1));
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(height2));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(cause_of_death));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(stage_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(logicalseqno));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(function));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(relationship_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(Locn_Type));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(context));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(age));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(accession_number));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(oh_chart_num));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(p_called_from_widget));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(called_from_ot));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(height3));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(height4));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(cause_of_death));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(stage_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(logicalseqno));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(function));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(relationship_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(Locn_Type));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(context));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(age));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(occur_srl_no));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(isCalledFromCA));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(term_short_desc));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(accession_number));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(option_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(oh_chart_num));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(call_from));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(p_called_from_widget));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(called_from_ot));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(height5));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(cause_of_death));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(logicalseqno));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(function));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(Practitioner_Id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(Locn_Code));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(relationship_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(Locn_Type));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(context));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(called_from_ip));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(age));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(call_from));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(p_called_from_widget));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(height6));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(height7));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(height8));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(isCalledFromCA));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(p_called_from_widget));
            _bw.write(_wl_block64Bytes, _wl_block64);


}catch ( Exception e )
{ 
	//out.println("Expection in try : "+e);
	e.printStackTrace();
}
finally
{
	if ( pstmt != null ) pstmt.close() ;
	if ( rs != null ) rs.close() ;
	ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block65Bytes, _wl_block65);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.RecordDiagnosis.label", java.lang.String .class,"key"));
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
