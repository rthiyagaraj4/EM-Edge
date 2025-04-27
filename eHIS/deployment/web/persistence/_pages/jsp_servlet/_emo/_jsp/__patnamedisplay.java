package jsp_servlet._emo._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import javax.servlet.http.*;
import javax.servlet.jsp.JspWriter;
import java.util.*;
import com.ehis.util.*;

public final class __patnamedisplay extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emo/jsp/PatNameDisplay.jsp", 1709118434899L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n          venkatesh\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script>\n    \n\t\n\t \n    if(parent.frames[1].frames[1].frames[1].document.forms[0].name_prefix){\n\tparent.frames[1].frames[1].frames[1].document.forms[0].name_prefix.value\t\t  =\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'\n    parent.frames[1].frames[1].frames[1].document.forms[0].name_prefix.disabled=true}\n\t\n\tif(parent.frames[1].frames[1].frames[1].document.forms[0].first_name){\n\tparent.frames[1].frames[1].frames[1].document.forms[0].first_name.value\t\t  =\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\';\n\tparent.frames[1].frames[1].frames[1].document.forms[0].first_name.disabled=true\n\t}\n\t\n\tif(parent.frames[1].frames[1].frames[1].document.forms[0].second_name){\n    parent.frames[1].frames[1].frames[1].document.forms[0].second_name.value\t\t  =\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\';\n\tparent.frames[1].frames[1].frames[1].document.forms[0].second_name.disabled=true\n\t}\n\t\n\tif(parent.frames[1].frames[1].frames[1].document.forms[0].third_name){\n    parent.frames[1].frames[1].frames[1].document.forms[0].third_name.value\t\t  =\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n\tparent.frames[1].frames[1].frames[1].document.forms[0].third_name.disabled=true\n\t}\n\t\n\tif(parent.frames[1].frames[1].frames[1].document.forms[0].third_name_oth_lang){\n    parent.frames[1].frames[1].frames[1].document.forms[0].third_name_oth_lang.value  =\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n    parent.frames[1].frames[1].frames[1].document.forms[0].third_name_oth_lang.disabled=true\n\t}\n\t\n\tif(parent.frames[1].frames[1].frames[1].document.forms[0].second_name_oth_lang){\n\tparent.frames[1].frames[1].frames[1].document.forms[0].second_name_oth_lang.value  =\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\';\n\t parent.frames[1].frames[1].frames[1].document.forms[0].second_name_oth_lang.disabled=true\n\t }\n\t\n\t if(parent.frames[1].frames[1].frames[1].document.forms[0].family_name){\n\tparent.frames[1].frames[1].frames[1].document.forms[0].family_name.value\t\t  =\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'\n\tparent.frames[1].frames[1].frames[1].document.forms[0].family_name.disabled=true\n\t}\n\t\n\tif(parent.frames[1].frames[1].frames[1].document.forms[0].name_suffix){\n\tparent.frames[1].frames[1].frames[1].document.forms[0].name_suffix.value\t\t  =\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'\n\tparent.frames[1].frames[1].frames[1].document.forms[0].name_suffix.disabled=true\n\t}\n\t\n\tif(parent.frames[1].frames[1].frames[1].document.forms[0].first_name_oth_lang){\n\tparent.frames[1].frames[1].frames[1].document.forms[0].first_name_oth_lang.value  =\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'\n\t parent.frames[1].frames[1].frames[1].document.forms[0].first_name_oth_lang.disabled=true\n\t}\n\t\n\tif(parent.frames[1].frames[1].frames[1].document.forms[0].name_suffix_oth_lang){\n\tparent.frames[1].frames[1].frames[1].document.forms[0].name_suffix_oth_lang.value =\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'\n\tparent.frames[1].frames[1].frames[1].document.forms[0].name_suffix_oth_lang.disabled=true\n\t}\n\t\n\tif(parent.frames[1].frames[1].frames[1].document.forms[0].name_prefix_oth_lang){\n\tparent.frames[1].frames[1].frames[1].document.forms[0].name_prefix_oth_lang.value =\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'\n \tparent.frames[1].frames[1].frames[1].document.forms[0].name_prefix_oth_lang.disabled=true\n\t}\n\t\n\tif(parent.frames[1].frames[1].frames[1].document.forms[0].family_name_oth_lang){\n\tparent.frames[1].frames[1].frames[1].document.forms[0].family_name_oth_lang.value =\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'\n    parent.frames[1].frames[1].frames[1].document.forms[0].family_name_oth_lang.disabled=true\n\t}\n\tif(parent.frames[1].frames[1].frames[1].document.forms[0].requestor_dob){\n\tparent.frames[1].frames[1].frames[1].document.forms[0].requestor_dob.value\t\t=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'\n\tparent.frames[1].frames[1].frames[1].document.forms[0].requestor_dob.disabled=true\n\t}\n\tif(parent.frames[1].frames[1].frames[1].document.forms[0].national_id_no){\n    parent.frames[1].frames[1].frames[1].document.forms[0].national_id_no.value       =\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'\n    parent.frames[1].frames[1].frames[1].document.forms[0].national_id_no.disabled=true\n\t}\t\n\t\n\tparent.frames[1].frames[1].frames[1].document.forms[0].patient_name_loca_long.value  =\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'\n\t\n\tif(parent.frames[1].frames[1].frames[1].document.forms[0].other_alt_Id_text){\n\tparent.frames[1].frames[1].frames[1].document.forms[0].other_alt_Id_text.value           =\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'\n\tparent.frames[1].frames[1].frames[1].document.forms[0].other_alt_Id_text.disabled=true\n\t}\n\t\n\tparent.frames[1].frames[1].frames[1].document.forms[0].patient_name.value           =\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'\n\t\n\t  \n\t var obj1=parent.frames[1].frames[1].frames[1].document.forms[0].other_alt_id.options\n         for(var k=0;k<obj1.options.length;k++)\n\t\t{        \n\t\t\t\tif(obj1.options[k].value == \'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\')\n\t\t\t\t\tobj1.options[k].selected = true;\n\t\t}\n        parent.frames[1].frames[1].frames[1].document.forms[0].other_alt_id.disabled=true\t \t\n       \n\t var obj\t\t=\t\tparent.frames[1].frames[1].frames[1].document.forms[0].sex.options\n\t\n\tfor(var k=0;k<obj.options.length;k++)\n\t\t{    \n\t\t\t\tif(obj.options[k].value == \'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\')\n\t\t\t\t\tobj.options[k].selected = true;\n\t\t} \n\t   parent.frames[1].frames[1].frames[1].document.forms[0].sex.disabled=true\n\t\n\t/*Applicant Address */\n\tif(parent.frames[1].frames[1].frames[1].document.forms[0].addr_line1)\n\tparent.frames[1].frames[1].frames[1].document.forms[0].addr_line1.value\t\t\t=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'\n\t\n\tif(parent.frames[1].frames[1].frames[1].document.forms[0].addr_line2)\n\tparent.frames[1].frames[1].frames[1].document.forms[0].addr_line2.value           =\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'\n\t\n\tif(parent.frames[1].frames[1].frames[1].document.forms[0].addr_line3)\n\tparent.frames[1].frames[1].frames[1].document.forms[0].addr_line3.value           =\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'\n\t\n\tif(parent.frames[1].frames[1].frames[1].document.forms[0].addr_line4)\n\tparent.frames[1].frames[1].frames[1].document.forms[0].addr_line4.value           =\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'\n\tparent.frames[1].frames[1].frames[1].document.forms[0].res_town_code.value        =\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'\n\tparent.frames[1].frames[1].frames[1].document.forms[0].res_town_desc.value        =\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'\n\tparent.frames[1].frames[1].frames[1].document.forms[0].res_area_code.value        =\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'\n\tparent.frames[1].frames[1].frames[1].document.forms[0].res_area_desc.value        =\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'\n\tparent.frames[1].frames[1].frames[1].document.forms[0].res_region_code.value      =\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'\n\tparent.frames[1].frames[1].frames[1].document.forms[0].region_desc.value          =\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'\n\tparent.frames[1].frames[1].frames[1].document.forms[0].postal_code.value          =\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'\n\tparent.frames[1].frames[1].frames[1].document.forms[0].postals_code.value         =\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'\n\tparent.frames[1].frames[1].frames[1].document.forms[0].r_postal_code1.value       =\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'\n\tparent.frames[1].frames[1].frames[1].document.forms[0].country_code.value         =\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'\n\tparent.frames[1].frames[1].frames[1].document.forms[0].country_desc.value         =\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'\n\tparent.frames[1].frames[1].frames[1].document.forms[0].contact1_no.value          =\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'\n\tparent.frames[1].frames[1].frames[1].document.forms[0].contact2_no.value          =\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'\n\tparent.frames[1].frames[1].frames[1].document.forms[0].email.value                =\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'\n\t/*Applicant Address End*/\n\t\n\t/* Embalm Address */\n\tparent.frames[1].frames[1].frames[1].document.forms[0].mail_addr_line1.value       =\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'\n\tparent.frames[1].frames[1].frames[1].document.forms[0].mail_addr_line2.value       =\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'\n\tparent.frames[1].frames[1].frames[1].document.forms[0].mail_addr_line3.value       =\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'\n\tparent.frames[1].frames[1].frames[1].document.forms[0].mail_addr_line4.value       =\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'\n\tparent.frames[1].frames[1].frames[1].document.forms[0].mail_res_town_code.value    =\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'\n\tparent.frames[1].frames[1].frames[1].document.forms[0].mail_res_town_desc.value    =\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'\n\tparent.frames[1].frames[1].frames[1].document.forms[0].mail_res_area_code.value    =\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'\n\tparent.frames[1].frames[1].frames[1].document.forms[0].mail_res_area_desc.value    =\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'\n    parent.frames[1].frames[1].frames[1].document.forms[0].mail_region_code.value      =\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'\n\tparent.frames[1].frames[1].frames[1].document.forms[0].mail_region_desc.value      =\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'\n\tparent.frames[1].frames[1].frames[1].document.forms[0].mail_postal_code.value      =\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'\n\tparent.frames[1].frames[1].frames[1].document.forms[0].m_postal_code12.value       =\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'\n\tparent.frames[1].frames[1].frames[1].document.forms[0].mail_country_code.value     =\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'\n\tparent.frames[1].frames[1].frames[1].document.forms[0].mail_country_desc.value     =\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'\n\t\n\n\t\n\t\n\tparent.frames[2].document.location.href=\"../../eCommon/jsp/error.jsp\"\n\t\t\n\t\t\n\t\n</script>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\n\n ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );
	
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
        webbeans.op.PatientData patdata 	= new webbeans.op.PatientData();
		String	facility_id		    = (String) session.getValue( "facility_id" ) ;
		String	 	strNamePrefix			= "";
		String	 	strFirstName			= "";
		String	 	strSecondName		= "";
		String		strThirdName			= "";
		String	 	strFamilyName			= "";
		String 	strNameSuffix			= "";
		String patientIdStatus          ="";
		String family_name_loc_lang="";
		String third_name_loc_lang="";
		String second_name_loc_lang="";
		String first_name_loc_lang="";
		String name_prefix_loc_lang="";
		String patient_long_name="";
		String patient_long_name_loc_lang="";
		String name_suffix_loc_lang="";
		String patient_name_loc_lang="";
		String patient_name="";
	

		String 	strSex					= "";
		String AltId1No				= "";
		String AltId2No				= "";
		String AltId3No				= "";
		String AltId4No				= "";
		String OtherAltIdNo			= "";
		String OtherAltIdType       = "";
		
		String 	strDateOfBirth			= "";
		String 	strNationalityCode    = "";
		String	strNationalityDesc	= "";
		String 	strPrimaryResNo		= "";
		String 	strOtherResNo			= "";
		String 	strYear					= "";
		String 	strMonth					= "";
		String 	strDays					= "";
		String		strCitizenYN			= "";
		String		strLegalYN				= "";

		String		strNatIdNo				= "";
		String		strPatdtlsUnknownYN= "N";


			String a_res_addr_line1 = "";
			String a_res_addr_line2 = "";
			String a_res_addr_line3 = "";
			String a_res_addr_line4 = "";
			String a_country_code  = "";
			String country1_desc   ="";
			String country2_desc    ="";
			String a_postal_code    = "";
			
			String a_res_area			= "";
			String a_res_area_code = "";
			String a_res_town2_code = "";
			String a_res_town2_desc = "";
			String a_res_region_code = "";
			String a_res_region_desc = "" ;

			String m_res_addr_line1 = "";
			String m_res_addr_line2 = "";
			String m_res_addr_line3 = "";
			String m_res_addr_line4 = "";
			String m_postal_code    = "";
			String m_postal_code1		= "";
			String a_postal_code1   = "";
			String m_country_code   = "";
			String m_res_area_code  = "";
			String m_res_area_desc  = "";
			String m_res_town2_code = "";
			String m_res_town2_desc = "";
			String m_res_region_code = "";
			String m_res_region_desc = "";

			
			String strEmail			   = "";
			String strRaceCd			   = "";
			String strRaceDesc			   = "";
			String strEthnicGrpCd		   = "";
			String strBirthPldesc	   = "";
			String birth_place_code    ="";
			String place_of_birth      ="";

			String alt_id1_exp_date ="";
			String alt_id2_exp_date ="";
			String alt_id3_exp_date ="";
			String alt_id4_exp_date ="";


			
			String ethnic_desc="";
			String a_country_desc="";
			String m_country_desc="";
			String postal2_desc="";
			String postal_desc="";
			String pat_id =request.getParameter("pat_id");
			String locale	=	 ((String)session.getAttribute("LOCALE"));
			Connection con = ConnectionManager.getConnection(request);
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	
			
			 

	 try{
	   patdata.setFacility_id(facility_id);
	   patientIdStatus = patdata.CheckStatus(con,pat_id);	
       
       if(patientIdStatus.equals("")){   	   
	   String sql = "SELECT a.name_prefix, a.patient_name, a.first_name, a.second_name,a.third_name, a.family_name_prefix, a.family_name, a.name_suffix,       a.national_id_no, NVL (a.alt_id1_no, '') alt_id1_no, a.alt_id2_type, NVL (alt_id2_no, '') alt_id2_no, a.alt_id3_type, NVL (a.alt_id3_no, '') alt_id3_no, a.alt_id4_type,       NVL (a.alt_id4_no, '') alt_id4_no, TO_CHAR (a.alt_id1_exp_date, 'dd/mm/yyyy') alt_id1_exp_date, TO_CHAR (a.alt_id2_exp_date, 'dd/mm/yyyy') alt_id2_exp_date,       TO_CHAR (a.alt_id3_exp_date, 'dd/mm/yyyy') alt_id3_exp_date, TO_CHAR (a.alt_id4_exp_date, 'dd/mm/yyyy') alt_id4_exp_date, a.oth_alt_id_type, NVL (a.oth_alt_id_no, '') oth_alt_id_no, a.sex,TO_CHAR (a.date_of_birth, 'dd/mm/yyyy') date_of_birth,NVL (a.nationality_code, '') nationality_code,       mp_get_desc.mp_country (nationality_code,'"+locale+"','3' ) nationality_desc, contact1_no primary_resi_no, contact2_no other_resi_no, NVL (active_yn, 'N') active_yn, NVL (suspend_yn, 'N') suspend_yn, NVL (deceased_yn, 'N') deceased_yn,calculate_age (TO_CHAR (a.date_of_birth, 'dd/mm/yyyy'), 1) y,       calculate_age (TO_CHAR (a.date_of_birth, 'dd/mm/yyyy'), 2) m,calculate_age (TO_CHAR (a.date_of_birth, 'dd/mm/yyyy'), 3) d,a.citizen_yn, a.legal_yn, a.pat_dtls_unknown_yn, a.pat_cat_code, mp_get_desc.mp_pat_category (a.pat_cat_code, '"+locale+"',  2 ) pat_cat_desc,  a.race_code,  mp_get_desc.mp_race (a.race_code, '"+locale+"', 1) race_desc, mp_get_desc.mp_ethnic_group (a.ethnic_grp_code,  '"+locale+"',  '1'    ) ethnic_desc,  a.ethnic_grp_code, a.place_of_birth, a.birth_place_code,  mp_get_desc.mp_birth_place (a.birth_place_code,  '"+locale+"',  '1'  ) birth_place_desc,    a.family_name_loc_lang, a.third_name_loc_lang, a.second_name_loc_lang,  a.first_name_loc_lang, a.name_suffix_loc_lang, a.patient_name_loc_lang, a.name_prefix_loc_lang, language_id, mp_get_desc.mp_language (language_id, '"+locale+"', 1) language_desc,  a.patient_long_name, a.patient_long_name_loc_lang FROM mp_patient a, mp_pat_addresses b WHERE a.patient_id = '"+pat_id+"' AND a.patient_id = b.patient_id";
	    
		
		
		pstmt = con.prepareStatement(sql) ;
		
		rs      = pstmt.executeQuery() ;
	  
	   if(rs != null) {
	    while(rs.next()){
		strNamePrefix			= checkForNull(rs.getString("name_prefix"));
		strFirstName			=checkForNull(rs.getString("first_name"));
		strSecondName		    = checkForNull(rs.getString("second_name"));
		strThirdName			= checkForNull(rs.getString("third_name"));
	    strFamilyName			= checkForNull(rs.getString("family_name"));
		patient_name	        =checkForNull(rs.getString("patient_name"));
        strNameSuffix			= checkForNull(rs.getString("name_suffix"));
	    name_prefix_loc_lang	=checkForNull(rs.getString("name_prefix_loc_lang"));
		first_name_loc_lang		=checkForNull(rs.getString("first_name_loc_lang"));
		second_name_loc_lang		=checkForNull(rs.getString("second_name_loc_lang"));
		third_name_loc_lang		= checkForNull(rs.getString("third_name_loc_lang")); 
		family_name_loc_lang		=checkForNull(rs.getString("family_name_loc_lang"));
	 	name_suffix_loc_lang		=checkForNull(rs.getString("name_suffix_loc_lang"));
		strSex					=  checkForNull(rs.getString("sex"));
		strDateOfBirth			= checkForNull(rs.getString("date_of_birth"));
		strNatIdNo				= checkForNull(rs.getString("national_id_no"));
		patient_long_name		=checkForNull(rs.getString("patient_long_name"));
		patient_long_name_loc_lang		=checkForNull(rs.getString("patient_name_loc_lang")); 
		
		OtherAltIdType					=checkForNull(rs.getString("OTH_ALT_ID_TYPE"));
		OtherAltIdNo					=checkForNull(rs.getString("OTH_ALT_ID_NO"));
		}
	   }
	   if(rs != null) rs.close(); 
	   if(pstmt != null) pstmt.close();	
		  
	  String addressQuery  ="SELECT a.addr1_type,a.addr1_line1,a.addr1_line2, a.addr1_line3,addr1_line4,  nvl(a.postal1_code,'') postal1_code,MP_GET_DESC.MP_POSTAL_CODE(a.postal1_code,'"+locale+"','2') postal1_desc, a.country1_code,  MP_GET_DESC.MP_COUNTRY(a.country1_code,'"+locale+"','1') country1_desc, a.contact1_name, a.invalid1_yn, MP_GET_DESC.MP_RES_AREA(b.RES_AREA_CODE,'"+locale+"','1') res_area,  b.res_area_code ,MP_GET_DESC.MP_RES_TOWN(b.RES_TOWN_CODE,'"+locale+"','1') res_town, b.res_town_code , MP_GET_DESC.MP_REGION(b.region_code,'"+locale+"','1') region, b.region_code, a.addr2_type, a.addr2_line1, a.addr2_line2, a.addr2_line3, a.addr2_line4, a.postal2_code, MP_GET_DESC.MP_POSTAL_CODE(a.postal2_code,'"+locale+"','2') postal2_desc, a.country2_code, MP_GET_DESC.MP_COUNTRY(a.country2_code,'"+locale+"','1') country2_desc, a.contact2_name, a.invalid2_yn, MP_GET_DESC.MP_RES_AREA(a.res_area2_code,'"+locale+"','1') res_area2, a.res_area2_code, MP_GET_DESC.MP_RES_TOWN(a.res_town2_code,'"+locale+"','1') res_town2, a.res_town2_code, MP_GET_DESC.MP_REGION(region2_code,'"+locale+"','1') region2_desc,  a.region2_code, b.CONTACT1_NO, b.CONTACT2_NO,  b.EMAIL_ID FROM mp_pat_addresses a , MP_PATIENT b WHERE b.PATIENT_ID=a.PATIENT_ID  and  b.patient_id='"+pat_id+"'";
	
	
	    pstmt       = con.prepareStatement(addressQuery) ;
		   rs         = pstmt.executeQuery() ;
	      if(rs != null) {
		  if(rs.next()){
		    a_res_addr_line1  = checkForNull(rs.getString("addr1_line1"));
			a_res_addr_line2  = checkForNull(rs.getString("addr1_line2"));
			a_res_addr_line3  = checkForNull(rs.getString("addr1_line3"));
			a_res_addr_line4  = checkForNull(rs.getString("addr1_line4"));
			a_res_town2_code  = checkForNull(rs.getString("res_town_code"));
		    a_res_town2_desc  = checkForNull(rs.getString("res_town"));
			a_res_area_code   = checkForNull(rs.getString("res_area_code"));
			a_res_area        = checkForNull(rs.getString("res_area") );
            a_res_region_code = checkForNull(rs.getString("region_code"));
			a_res_region_desc = checkForNull(rs.getString("region"));	
            a_postal_code     = checkForNull(rs.getString("postal1_code"));
			a_postal_code1    = checkForNull(rs.getString("postal1_desc"));	
			 a_country_code    = checkForNull(rs.getString("country1_code"));
			country1_desc	  = checkForNull(rs.getString("country1_desc"));	
			country2_desc	  = checkForNull(rs.getString("country2_desc"));
			strPrimaryResNo   = checkForNull(rs.getString("CONTACT1_NO"));
			strOtherResNo     = checkForNull(rs.getString("CONTACT2_NO"));
			strEmail	      = checkForNull(rs.getString("EMAIL_ID"));	
			
			m_res_addr_line1  = checkForNull(rs.getString("addr2_line1"));
			m_res_addr_line2  = checkForNull(rs.getString("addr2_line2"));
			m_res_addr_line3  = checkForNull(rs.getString("addr2_line3"));
			m_res_addr_line4  = checkForNull(rs.getString("addr2_line4"));
			m_res_town2_code  = checkForNull(rs.getString("res_town2_code"));
		    m_res_town2_desc  = checkForNull(rs.getString("res_town2"));
			m_res_area_code   = checkForNull(rs.getString("res_area2_code"));
			m_res_area_desc   = checkForNull(rs.getString("res_area2"));
			m_res_region_code = checkForNull(rs.getString("region2_code"));
		    m_res_region_desc = checkForNull(rs.getString("region2_desc"));
			m_postal_code     = checkForNull(rs.getString("postal2_code"));
			m_postal_code1    = checkForNull(rs.getString("postal2_desc"));
			m_country_code    = checkForNull(rs.getString("country2_code"));
			
			
		   }
		  }
	 
	 

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(strNamePrefix));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(strFirstName));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(strSecondName));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(strThirdName));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(third_name_loc_lang));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(second_name_loc_lang));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strFamilyName));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strNameSuffix));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(first_name_loc_lang));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(name_suffix_loc_lang));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(name_prefix_loc_lang));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(family_name_loc_lang));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strDateOfBirth));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strNatIdNo));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patient_long_name_loc_lang));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(OtherAltIdNo));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(OtherAltIdType));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(strSex));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(a_res_addr_line1));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(a_res_addr_line2));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(a_res_addr_line3));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(a_res_addr_line4));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(a_res_town2_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(a_res_town2_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(a_res_area_code));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(a_res_area));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(a_res_region_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(a_res_region_desc));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(a_postal_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(a_postal_code1));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(a_postal_code1));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(a_country_code));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(country1_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(strPrimaryResNo));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(strOtherResNo));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strEmail));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(m_res_addr_line1));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(m_res_addr_line2));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(m_res_addr_line3));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(m_res_addr_line4));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(m_res_town2_code));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(m_res_town2_desc));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(m_res_area_code));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(m_res_area_desc));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(m_res_region_code));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(m_res_region_desc));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(m_postal_code));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(m_postal_code1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(m_country_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(country2_desc));
            _bw.write(_wl_block57Bytes, _wl_block57);

} else{  
        if(patientIdStatus.equals("SUSPENDED")){  
      out.println("<script>alert(parent.frames[1].getMessage('PAT_SUSPENDED_NOT_ALLOWED','MP'));parent.frames[1].frames[1].frames[1].document.forms[0].requestor_id.value=''; parent.frames[2].document.location.href='../../eCommon/jsp/error.jsp'</script>");
	  }else if (patientIdStatus.equals("DECEASED")){
          out.println("<script>alert(parent.frames[1].getMessage('PAT_DECEASED_NOT_ALLOWED','MP'));parent.frames[1].frames[1].frames[1].document.forms[0].requestor_id.value=''; parent.frames[2].document.location.href='../../eCommon/jsp/error.jsp'</script>");
		}else if(patientIdStatus.equals("INVALID_PATIENT")){
		out.println( "<script>alert(parent.frames[1].getMessage('INVALID_PATIENT','MP'));parent.frames[1].frames[1].frames[1].document.forms[0].requestor_id.value=''; parent.frames[2].document.location.href='../../eCommon/jsp/error.jsp'</script>");
		 }else if(patientIdStatus.equals("SECURED")){
		 out.println( "<script>alert(parent.frames[1].getMessage('SECURED_NOT_ALLOWED','COMMON'));parent.frames[1].frames[1].frames[1].document.forms[0].requestor_id.value=''; parent.frames[2].document.location.href='../../eCommon/jsp/error.jsp'</script>");
		 }else if(patientIdStatus.equals("INACTIVE")){ 
		 out.println( "<script>alert(parent.frames[1].getMessage('PAT_INACTIVE_NOT_ALLOWED','MP'));parent.frames[1].frames[1].frames[1].document.forms[0].requestor_id.value=''; parent.frames[2].document.location.href='../../eCommon/jsp/error.jsp'</script>");
		 }else if(patientIdStatus.equals("BLACKLISTED_PATIENT")){
		  out.println( "<script>alert(parent.frames[1].getMessage('BLACKLISTED_PATIENT','MP'));parent.frames[1].frames[1].frames[1].document.forms[0].requestor_id.value=''; parent.frames[2].document.location.href='../../eCommon/jsp/error.jsp'</script>");
		 }
		
		}


}catch(Exception e){
   
      e.printStackTrace();
  } finally{
	    if(rs != null) rs.close(); 
	   if(pstmt != null) pstmt.close();	
	   //Added for checkstyle for COMMON-ICN-0056
	   if(con != null)		
	    ConnectionManager.returnConnection(con,request);
	   //con.close(); //Commented for checkstyle for COMMON-ICN-0056
  }
            _bw.write(_wl_block58Bytes, _wl_block58);
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
