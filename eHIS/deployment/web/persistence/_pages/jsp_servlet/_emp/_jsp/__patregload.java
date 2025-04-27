package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __patregload extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/PatRegLoad.jsp", 1731833996619L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<Script language=\"JavaScript\" src=\"../../eCommon/js/common.js\" ></Script>\n<Script language=\'javascript\' src=\'../../eMP/js/PatientSearch.js\'></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="  \n\t\t\t\t\t<html>\n\t\t\t\t\t<head>\n\t\t\t\t\t<title> ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title>\n\t\t\t\t\t</head>\n\t\t\t\t\t<body onKeyDown = \'lockKey()\'>\n\t\t\t\t\t<form name =\"Pass\">\n\t\t\t\t\t<input type = \"hidden\" id = \"SecondName\" name = \"SecondName\" value = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\t\t\t\t\t\n\t\t\t\t\t<input type = \"hidden\" id = \"FirstName\" name = \"FirstName\" value = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t\t\t\t\t<input type = \"hidden\" id = \"ThirdName\" name = \"ThirdName\" value = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\t\t\t\t\n\t\t\t\t\t<input type = \"hidden\" id = \"FamilyName\" name = \"FamilyName\" value = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t\t\t\t\t<input type = \"hidden\" id = \"a_first_name_loc_lang\" name = \"a_first_name_loc_lang\" value =\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t\t\t\t\t<input type = \"hidden\" id = \"a_second_name_loc_lang\" name = \"a_second_name_loc_lang\" value =\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t\t\t\t<input type = \"hidden\" id = \"a_third_name_loc_lang\" name = \"a_third_name_loc_lang\" value =\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t\t\t\t<input type = \"hidden\" id = \"a_family_name_loc_lang\" name = \"a_family_name_loc_lang\" value =\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t\t\t\t<input type = \"hidden\" id = \"a_patient_name_loc_lang\" name = \"a_patient_name_loc_lang\" value =\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t\t\t\t\n\t\t\t\t\t<script language=\'javascript\'> \n\t\t\tdocument.location=\"PatRegMain.jsp?group=G&appt_ref_no=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&ap=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&First_Name=\"+encodeURIComponent(document.Pass.FirstName.value)+\"&Second_Name=\"+encodeURIComponent(document.Pass.SecondName.value)+\"&Third_Name=\"+encodeURIComponent(document.Pass.ThirdName.value)+\"&Family_Name=\"+encodeURIComponent(document.Pass.FamilyName.value)+\"&Alt_Id_No=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&National_Id_No=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&Sex=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&MRN=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&Area=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&Dob=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&Family_No=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&func_act=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&booking_ref_no=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&q_booking_type=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&referral_id=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&Alt_Id2_No=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&Alt_Id3_No=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&Alt_Id4_No=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&function_id=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&dr_function_id=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&calledFromModule=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="&a_first_name_loc_lang=\"+encodeURIComponent(document.Pass.a_first_name_loc_lang.value)+\"&a_second_name_loc_lang=\"+encodeURIComponent(document.Pass.a_second_name_loc_lang.value)+\"&a_third_name_loc_lang=\"+encodeURIComponent(document.Pass.a_third_name_loc_lang.value)+\"&a_family_name_loc_lang=\"+encodeURIComponent(document.Pass.a_family_name_loc_lang.value)+\"&a_patient_name_loc_lang=\"+encodeURIComponent(document.Pass.a_patient_name_loc_lang.value)+\"&pat_name_as_multipart_yn=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&acpt_appt_rfrl_in_reg_pat_yn=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&names_in_oth_lang_yn=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&toDayDate=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&cntlang=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="&patient_id_length=";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="&oainstall_yn=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="&rdinstall_yn=";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="&opinstall_yn=";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="&ipinstall_yn=";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="&race_code=";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"\n\t\t\t\t\t\t\n\t\t\t\t\t\n\n\t\t\t\t\t</script>\n\n\n\n\n\t\t\t\t\t</form>\n\t\t\t\t\t</body>\n\t\t\t\t\t</html>\n\n\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t<html>\n\t\t\t\t<head>\n\t\t\t\t<title>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</title>\n\t\t\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"></link>\n\t\t\t\t<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n\t\t\t\t<Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n\t\t\t\t</head>\n\t\t\t\t\t<body class=\"CONTENT\" onKeyDown = \'lockKey()\'>\n\t\t\t\t<form name =\"Pass\" id =\"Pass\">\n\t\t\t\t\t<input type = \"hidden\" id = \"SecondName\" name = \"SecondName\" value = \"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t\t\t<script language=\'javascript\'>\n\t\t\t\t\n\t\t\t\tasync function showModal()    { \n\t\t\t\t\tvar retVal =    new String();\n\n\t\t\t\t\t//var dialogHeight    = \"11\" ;\n\t\t\t\t\t//var dialogWidth = \"20\" ;\n\t\t\t\t\t\n\t\t\t\t\t\tvar dialogHeight= \"30vh\" ; ///added by Arun\n\t\t\t\t\t\tvar dialogTop = \"0vh\" ;\n\t\t\t\t\t\tvar dialogWidth\t= \"25vw\" ;\n\t\n\t\t\t\t\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"; status=no ;\";\n\t\t\t\t\tvar arguments   = \"\" ;\n\t\t\t\t\t\n\t\t\t\t\tif ((\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'==\'Y\' && \'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'==\'N\') || (\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'==\'A\'))\n\t\t\t\t\t{\n\t\t\t\t\t\tif( \'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' == \'\' && \'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' == \'\') \n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tretVal = await window.showModalDialog(\"loadModal.jsp?series=";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="&alt_id=";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="&prompt=\"+encodeURIComponent(\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\')+\"&nat_id_chk_digit_scheme=";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\",arguments,features);\n\t\t\t\t\t\t\tif(retVal == null)  retVal=\'G\'\n\t\t\t\t\t\t }\n\t\t\t\t\t\t else\n\t\t\t\t\t\t\tretVal = \'G\'\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t\tretVal = \'G\'\n\n\t\t\t\t\tvar pat_grp = retVal.charAt(0);\n\t\t\t\t\t\n\t\t\t\t\tif ( pat_grp == \'N\' )\n\t\t\t\t\t{ \n\t\t\t\t\t\tvar pat_id = escape(retVal.substr(1));\n\t\t\t\t\t\t//Below line modified for this incident [IN:038818]\t\t\n\t\t\t\t\t\twindow.location=\"PatRegMain.jsp?group=\"+pat_grp+\"&nat_id=\"+pat_id+\"&appt_ref_no=";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"; \n\t\t\t\t\t}\n\t\t\t\t\telse if ( pat_grp == \'A\' )\n\t\t\t\t\t{\n\t\t\t\t\t\tvar alt_id = escape(retVal.substr(1));\n\t\t\t\t        //Below line modified for this incident [IN:038818]\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\twindow.location=\"PatRegMain.jsp?group=\"+pat_grp+\"&alt_id=\"+alt_id+\"&appt_ref_no=";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="&First_Name=\"+encodeURIComponent(document.Pass.FirstName.value)+\"&Second_Name=\"+encodeURIComponent(document.Pass.SecondName.value)+\"&Third_Name=\"+encodeURIComponent(document.Pass.ThirdName.value)+\"&Family_Name=\"+encodeURIComponent(document.Pass.FamilyName.value)+\"&National_Id_No=";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"; \n\t\t\t\t\t}\n\t\t\t\t\telse if ( pat_grp == \'G\' )\n\t\t\t\t\t{ //Below line modified for this incident [IN:038818]\t\t\n\t\t\t\t\t window.location=\"PatRegMain.jsp?from_modal=Y&group=G&appt_ref_no=";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="&a_first_name_loc_lang=\"+encodeURIComponent(document.Pass.a_first_name_loc_lang.value)+\"&a_second_name_loc_lang=\"+encodeURIComponent(document.Pass.a_second_name_loc_lang.value)+\"&a_third_name_loc_lang=\"+encodeURIComponent(document.Pass.a_third_name_loc_lang.value)+\"&a_family_name_loc_lang=\"+encodeURIComponent(document.Pass.a_family_name_loc_lang.value)+\"&&a_patient_name_loc_lang=\"+encodeURIComponent(document.Pass.a_patient_name_loc_lang.value)+\"&pat_name_as_multipart_yn=";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"; \n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t\n\t\t\t\n\t\t\t\t<script language=\'javascript\'>\n\n\t\t\t\tsetTimeout(\"showModal()\",500);\n\n\t\t\t\t</script>\n\n\n\t\t\t\t</body>\n\t\t\t\t</html>\n\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block6Bytes, _wl_block6);
 

Connection conn = null;
java.sql.PreparedStatement pstmt = null;
ResultSet rs =null;

try
{  
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	conn = ConnectionManager.getConnection(request);	
	String appt_ref_no = request.getParameter("appt_ref_no");
	String ap = request.getParameter("ap");
	String facilityId = (String) session.getValue("facility_id");
	
	String nat_id_chk_digit_scheme = "";
	String FirstName=request.getParameter("First_Name");if(FirstName==null)FirstName="";
	String SecondName=request.getParameter("Second_Name");if(SecondName==null)SecondName="";
	String ThirdName=request.getParameter("Third_Name");if(ThirdName==null)ThirdName="";
	String FamilyName=request.getParameter("Family_Name");if(FamilyName==null)FamilyName="";

	String a_family_name_loc_lang		= checkForNull( request.getParameter("family_name_loc_lang") );
	String a_first_name_loc_lang		= checkForNull( request.getParameter("first_name_loc_lang") );
	String a_second_name_loc_lang		= checkForNull( request.getParameter("second_name_loc_lang") );
	String a_third_name_loc_lang		= checkForNull( request.getParameter("third_name_loc_lang") );
	String a_patient_name_loc_lang		= checkForNull( request.getParameter("patient_name_loc_lang") );

	/*a_family_name_loc_lang		= java.net.URLEncoder.encode(a_family_name_loc_lang);
	a_first_name_loc_lang		= java.net.URLEncoder.encode(a_first_name_loc_lang);
	a_second_name_loc_lang		= java.net.URLEncoder.encode(a_second_name_loc_lang);
	a_third_name_loc_lang		= java.net.URLEncoder.encode(a_third_name_loc_lang);
	a_patient_name_loc_lang		= java.net.URLEncoder.encode(a_patient_name_loc_lang);*/
	
	//out.println("<script>alert(1010101);alert('"+a_second_name_loc_lang+"');alert(121212212)</script>");

	String AltIdNo=request.getParameter("Alt_Id_No");if(AltIdNo==null)AltIdNo="";

	/*FirstName = java.net.URLEncoder.encode(FirstName) ;
	SecondName = java.net.URLEncoder.encode(SecondName) ;
	ThirdName = java.net.URLEncoder.encode(ThirdName) ;
	FamilyName = java.net.URLEncoder.encode(FamilyName) ; */
	AltIdNo = java.net.URLEncoder.encode(AltIdNo) ;

	String NationalIdNo=request.getParameter("National_Id_No");if(NationalIdNo==null)NationalIdNo="";
	String MRN=request.getParameter("MRN");if(MRN==null)MRN="";
	String Dob=request.getParameter("Dob");if(Dob==null)Dob="";
	String Sex=request.getParameter("Sex");if(Sex==null)Sex="";
	String Area=request.getParameter("Area");if(Area==null)Area="";
	String FamilyNo=request.getParameter("Family_No");if(FamilyNo==null) FamilyNo="";
	String func_act = request.getParameter("func_act");if(func_act == null) func_act="";
	String function_id = request.getParameter("function_id");if(function_id == null) function_id="";
	String booking_ref_no = request.getParameter("booking_ref_no") == null? "": request.getParameter("booking_ref_no");
	String q_booking_type = request.getParameter("q_booking_type");
	if(q_booking_type==null) q_booking_type="";
	//out.println("<script>alert('Pat reg"+q_booking_type+"')</script>");
	String referral_id = request.getParameter("referral_id");if(referral_id==null) referral_id="";
	String series="";
	String accept_national_id_no_yn = "";
	String AltId2No=request.getParameter("Alt_Id2_No");if(AltId2No==null)AltId2No="";
	String AltId3No=request.getParameter("Alt_Id3_No");if(AltId3No==null)AltId3No="";
	String AltId4No=request.getParameter("Alt_Id4_No");if(AltId4No==null)AltId4No="";
	String drfunctionid = request.getParameter("dr_function_id");
	if(drfunctionid == null) drfunctionid="";
	String calledFromModule = request.getParameter("calledFromModule");
	if(calledFromModule == null || calledFromModule.equals("null")) calledFromModule="";

	int cntSeries = 0, cntPatSeries = 0,cntlang = 0;
	AltId2No = java.net.URLEncoder.encode(AltId2No) ;
	AltId3No = java.net.URLEncoder.encode(AltId3No) ;
	AltId4No = java.net.URLEncoder.encode(AltId4No) ;
	//out.println("referral_id:"+referral_id);
	out.println("&nbsp;");

	String pat_name_as_multipart_yn = "";
	String acpt_appt_rfrl_in_reg_pat_yn = "N";
	String names_in_oth_lang_yn = "";
	String toDayDate = "";
	String patient_id_length = "";
	String oainstall_yn = "";
	String rdinstall_yn = "";
	String opinstall_yn = "";
	String ipinstall_yn = "";
//Added By Dharma on 20th Aug 2020 against ML-MMOH-SCF-1384
	String a_race_code  = request.getParameter("race_code");
		if(a_race_code == null)a_race_code = "";


	//String appt_ref_no = "90";
	String sql ="";
	sql = "select dflt_pat_ser_grp_type, nvl(alt_id1_type,'Alt ID No'), nvl(nat_id_prompt,'National ID No')nat_id_prompt, accept_national_id_no_yn, nat_id_chk_digit_scheme, pat_name_as_multipart_yn, acpt_appt_rfrl_in_reg_pat_yn, names_in_oth_lang_yn, to_char(sysdate, 'dd/mm/yyyy') toDayDate, patient_id_length, (select count(*) as total from sm_language where language_direction='R' and eff_status='E') total, (SELECT COUNT (1) FROM mp_pat_ser_grp WHERE id_type NOT IN ('X', 'R')) cntSeries, (select count(1) from mp_pat_ser_grp where (id_type not in ('X', 'R') and gen_pat_id_yn = 'Y' and (pat_ser_grp_code in (select pat_ser_grp_code from mp_pat_ser_facility where site_or_facility_id = decode(site_or_facility,'S',(select site_id from sm_site_param),'F',?)))) or gen_pat_id_yn = 'N' ) cntPatSeries, (SELECT install_yn FROM sm_module WHERE module_id = 'OA' AND install_yn = 'Y') oainstall_yn, (SELECT operational_yn FROM sm_modules_facility WHERE module_id = 'RD' AND facility_id = 'HS' AND operational_yn = 'Y') rdinstall_yn, (SELECT install_yn opinstall_yn FROM sm_module WHERE module_id = 'OP' AND install_yn = 'Y') opinstall_yn,(SELECT install_yn ipinstall_yn FROM sm_module WHERE module_id = 'IP' AND install_yn = 'Y') ipinstall_yn from  mp_param_lang_vw where language_id=? and module_id='MP' ";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,facilityId);
	pstmt.setString(2,localeName);
	rs = pstmt.executeQuery();

	if ( rs.next() )
	{

		series = rs.getString(1); 
		accept_national_id_no_yn = rs.getString("accept_national_id_no_yn");
		if (accept_national_id_no_yn==null) accept_national_id_no_yn = "N";		
		nat_id_chk_digit_scheme = checkForNull(rs.getString("nat_id_chk_digit_scheme"));		
		oainstall_yn = checkForNull(rs.getString("oainstall_yn"),"N");		
		rdinstall_yn = checkForNull(rs.getString("rdinstall_yn"),"N");		
		opinstall_yn = checkForNull(rs.getString("opinstall_yn"),"N");		
		ipinstall_yn = checkForNull(rs.getString("ipinstall_yn"),"N");		
		cntSeries = rs.getInt("cntSeries");
		cntPatSeries = rs.getInt("cntPatSeries");	
		pat_name_as_multipart_yn		=	 rs.getString("pat_name_as_multipart_yn");
		acpt_appt_rfrl_in_reg_pat_yn	=	 rs.getString("acpt_appt_rfrl_in_reg_pat_yn");
		names_in_oth_lang_yn			=	 rs.getString("names_in_oth_lang_yn");
		toDayDate							=	 rs.getString("toDayDate");
		patient_id_length							=	 rs.getString("patient_id_length");
		cntlang = rs.getInt("total");		
		
		if (cntSeries > 0)
		{
			if (cntPatSeries > 0)
			{
				if  ( rs.getString(1).equals("G") ) 
				{			
				
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(SecondName));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(FirstName));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(ThirdName));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(FamilyName));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(a_first_name_loc_lang));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(a_second_name_loc_lang));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(a_third_name_loc_lang));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(a_family_name_loc_lang));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(a_patient_name_loc_lang));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ap));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(AltIdNo));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(NationalIdNo));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Sex));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(MRN));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(Area));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(Dob));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(FamilyNo));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(func_act));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(booking_ref_no));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(q_booking_type));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(AltId2No));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(AltId3No));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(AltId4No));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drfunctionid));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(calledFromModule));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(pat_name_as_multipart_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(acpt_appt_rfrl_in_reg_pat_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(names_in_oth_lang_yn));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(toDayDate));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(cntlang));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(patient_id_length));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(oainstall_yn));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(rdinstall_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(opinstall_yn));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(ipinstall_yn));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(a_race_code));
            _bw.write(_wl_block47Bytes, _wl_block47);

				}
				else 
				{
				String prompts= rs.getString(2)+"~"+rs.getString(3) ;
				String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
				
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(SecondName));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(FirstName));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(ThirdName));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(FamilyName));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(a_first_name_loc_lang));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(a_second_name_loc_lang));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(a_third_name_loc_lang));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(a_family_name_loc_lang));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(a_patient_name_loc_lang));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(accept_national_id_no_yn));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(series));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(series));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(AltId2No));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(AltId3No));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(AltId4No));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(AltIdNo));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(NationalIdNo));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(series));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(AltIdNo));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(NationalIdNo));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(prompts));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(nat_id_chk_digit_scheme));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ap));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(AltIdNo));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Sex));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(MRN));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(Area));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(Dob));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(FamilyNo));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(func_act));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(booking_ref_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(AltId2No));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(AltId3No));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(AltId4No));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drfunctionid));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(calledFromModule));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(pat_name_as_multipart_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(acpt_appt_rfrl_in_reg_pat_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(names_in_oth_lang_yn));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(toDayDate));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(cntlang));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(patient_id_length));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(oainstall_yn));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(rdinstall_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(opinstall_yn));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(ipinstall_yn));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(a_race_code));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ap));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(NationalIdNo));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Sex));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(MRN));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(Area));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(Dob));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(FamilyNo));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(func_act));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(booking_ref_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(AltId2No));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(AltId3No));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(AltId4No));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drfunctionid));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(calledFromModule));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(pat_name_as_multipart_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(acpt_appt_rfrl_in_reg_pat_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(names_in_oth_lang_yn));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(toDayDate));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(cntlang));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(patient_id_length));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(oainstall_yn));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(rdinstall_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(opinstall_yn));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(ipinstall_yn));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(a_race_code));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(ap));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(AltIdNo));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(NationalIdNo));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(Sex));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(MRN));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(Area));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(Dob));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(FamilyNo));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(func_act));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(booking_ref_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(AltId2No));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(AltId3No));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(AltId4No));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drfunctionid));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(calledFromModule));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(pat_name_as_multipart_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(acpt_appt_rfrl_in_reg_pat_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(names_in_oth_lang_yn));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(toDayDate));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(cntlang));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(patient_id_length));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(oainstall_yn));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(rdinstall_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(opinstall_yn));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(ipinstall_yn));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(a_race_code));
            _bw.write(_wl_block65Bytes, _wl_block65);
 
				} 
			}
			else
				out.println("<script>alert(getMessage('PAT_NUM_NOT_CREATED','MP'));</script>") ;
		}
		else
			out.println("<script>alert(getMessage('PAT_SER_NOT_CREATED','MP'));</script>") ;
	} 
	else 
	{
		out.println("<script>alert(getMessage('MP_PARAM_NOT_FOUND','MP'));");
out.println("parent.parent.parent.parent.frames[1].expand()</script>");
	}
 
	if (rs!= null) rs.close();	
	if (pstmt != null) pstmt.close();	
}
catch(Exception e){out.println(e);out.println("test1"); e.printStackTrace();}
finally
{
  if(conn!=null) ConnectionManager.returnConnection(conn,request);
}


            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PatientRegistrationTitle.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PatientRegistrationTitle.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
