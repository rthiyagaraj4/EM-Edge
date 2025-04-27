package jsp_servlet._efm._jsp;

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
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmfilemovementcheckpatientexists extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMFileMovementCheckPatientExists.jsp", 1742884703927L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n\n\n\n\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body class=\'message\' onKeyDown = \'lockKey()\'>\n<form>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\t\t<script>\n\t\t\t\t\t\n\t              var errors = getMessage(\'PATIENT_FILE_NOT_EXIST\',\'FM\');\t\n\t\t\t\t\tvar Rename=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\t\tif(Rename==\"RE\")\n\t\t\t\t{\n\t\t\t    \tparent.frames[3].document.forms[0].patientid.focus();\n\t\t\t\t\tparent.frames[2].document.forms[0].validFile.value =\'false\';\n\t\t\t\t\tparent.frames[3].document.getElementById(\'fileid\').innerHTML=\"<input type=\'text\' name=\'fileno\' id=\'fileno\' tabIndex=\'2\' size=\'20\' maxlength=\'20\' value=\'\' onBlur=\'ChangeUpperCase(this);CheckFileExists(this.value);\' >\";\n\t\t\t\t}else{\n\t\t\t\t\tparent.frames[2].document.forms[0].patientid.focus();\n\t\t\t\t\tparent.frames[2].document.forms[0].validFile.value =\'false\';\n\t\t\t\t\tparent.frames[2].document.getElementById(\'fileid\').innerHTML=\"<input type=\'text\' name=\'fileno\' id=\'fileno\' tabIndex=\'2\' size=\'20\' maxlength=\'20\' value=\'\' onBlur=\'ChangeUpperCase(this);CheckFileExists(this.value);\' >\";\n\t\t\t\t}\n\t\t\tparent.frames[4].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors ;\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar errors = getMessage(\'PATIENT_FILE_NOT_EXIST\',\'FM\');\t\n\t\t\t\t\tvar Rename=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\t\tif(Rename==\"RE\")\n\t\t\t\t{\n\t\t\t\t    parent.frames[3].document.forms[0].patientid.focus();\n\t\t\t\t\tparent.frames[2].document.forms[0].validFile.value =\'false\';\t\t\t\t\t\n\t\t\t\t\tparent.frames[3].document.getElementById(\'fileid\').innerHTML=\"<input type=\'text\' name=\'fileno\' id=\'fileno\' tabIndex=\'2\' size=\'20\' maxlength=\'20\' value=\'\' onBlur=\'ChangeUpperCase(this);CheckFileExists(this.value);\' >\"\n\t\t\t\tparent.frames[3].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors ;\n\t\t\t\t}else{\n\t\t\t\t\tparent.frames[1].document.forms[0].patientid.focus();\n\t\t\t\t\tparent.frames[1].document.forms[0].validFile.value =\'false\';\t\t\t\t\t\n\t\t\t\t\tif(parent.frames[1].document.getElementById(\'fileid\'))\n\t\t\t\t\tparent.frames[1].document.getElementById(\'fileid\').innerHTML=\"<input type=\'text\' name=\'fileno\' id=\'fileno\' tabIndex=\'2\' size=\'20\' maxlength=\'20\' value=\'\' onBlur=\'ChangeUpperCase(this);CheckFileExists(this.value);\' >\";\n\t\t\tparent.frames[2].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors ;\n\t\t\t\t}\t\n\t\t\t   \t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\n\t\t\t\t<script>\n\t\t\t\t\t var Rename=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\t\t\t\tif(Rename==\"RE\")\n\t\t\t\t{\n\t\t\t\t\t\t\t  \n\t\t\t\t  parent.frames[3].document.getElementById(\'fileid\').innerHTML=\"<select name=fileno id=fileno onChange=\'CheckFileExists(this.value);\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</select>\";\n\t\t\t\t\tif(parent.frames[3].document.forms[0].validFile)\n\t\t\t\t\tparent.frames[3].document.forms[0].validFile.value =\'true\';\t\n\t\t\t\t   if(parent.frames[3].document.getElementById(\'volid\'))\n\t\t\t\t   parent.frames[3].document.getElementById(\'volid\').innerHTML=\"<select name=volumeno id=volumeno >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</select>\";\n\t\t\t\t}else{\n              if(Rename==\"IP\" || Rename==\"OP\")\n\t\t\t\t\t{\n                  parent.frames[2].document.getElementById(\'fileid\').innerHTML=\"<select name=fileno id=fileno onChange=\'CheckFileExists(this.value);\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</select>\";\n\t\t\t\t\tparent.frames[2].document.forms[0].validFile.value =\'true\';\t\n\t\t\t\t\t  parent.frames[2].document.getElementById(\'volid\').innerHTML=\"<select name=volumeno id=volumeno >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</select>\";\n\t\t\t\t\t}else{\n\t\t\t   parent.frames[2].document.getElementById(\'fileid\').innerHTML=\"<select name=fileno id=fileno onChange=\'CheckFileExists(this.value);\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t\t\tparent.frames[2].document.forms[0].validFile.value =\'true\';\t\t\t\t\t\t\t\n\t\t\t\t\t}\t\n\t\t\t\t\t}\t\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\n\t\t\t\t<script>\n             \t\tvar Rename=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\n\t\t\t\t\tif(Rename==\"RE\")\n\t\t\t\t{\n\t\t\t\tparent.frames[3].document.getElementById(\'fileid\').innerHTML=\"<select name=fileno id=fileno onChange=\'CheckFileExists(this.value);\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</select>\";\n\t\t\t\t\tparent.frames[2].document.forms[0].validFile.value =\'true\';\n\t\t\t\t\tparent.frames[2].document.forms[0].file_type_code.value =\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\';\n\t\t\t\t\tparent.frames[3].document.getElementById(\'volid\').innerHTML=\"<select name=volumeno id=volumeno >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</select>\";\n\t\t\t\t\n\t\t\t\t}else{\n\t\t\t\t\t if(Rename==\"IP\" || Rename==\"OP\")\n\t\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\tparent.frames[2].document.getElementById(\'fileid\').innerHTML=\"<select name=fileno id=fileno onChange=\'CheckFileExists(this.value);\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\';\n\t\t\t\t\tparent.frames[2].document.getElementById(\'volid\').innerHTML=\"<select name=volumeno id=volumeno >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</select>\";\n\t\t\t\t\t}else{\n\n                  parent.frames[2].document.getElementById(\'fileid\').innerHTML=\"<select name=fileno id=fileno onChange=\'CheckFileExists(this.value);\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t\t\tparent.frames[2].document.forms[0].validFile.value =\'true\';\n\t\t\t\t\tparent.frames[2].document.forms[0].file_type_code.value =\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</select>\";\n\t\t\t\t\t}\n\t\t\t\t\n\t\t\t\t}\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t<script>\n\t\t\t\t\tvar Rename=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</select>\";\n\t\t\t\t\t\tparent.frames[2].document.forms[0].validFile.value =\'true\';\t\n\t\t\t\t\n\t\t\t\t}else{\n                     if(Rename==\"IP\" || Rename==\"OP\")\n\t\t\t\t\t    {\n\t\t\t\t\t\tif(parent.frames[1].document.getElementById(\'fileid\'))\n\t\t\t\t\t\tparent.frames[1].document.getElementById(\'fileid\').innerHTML=\"<select name=fileno id=fileno onChange=\'CheckFileExists(this.value);\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</select>\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].validFile.value =\'true\';\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\tif(parent.frames[1].document.getElementById(\'fileid\'))\n\t\t\t\t\t\tparent.frames[1].document.getElementById(\'fileid\').innerHTML=\"<select name=fileno id=fileno onChange=\'CheckFileExists(this.value);\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t\t\t\tif(parent.frames[1].document.getElementById(\'volid\'))\n\t\t\t\t\t\tparent.frames[1].document.getElementById(\'volid\').innerHTML=\"<select name=volumeno id=volumeno >";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</select>\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].validFile.value =\'true\';\n\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t\t}\t\t\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\n\t\t\t\t\tif(Rename==\"RE\")\n\t\t\t\t{\n\t\t\t\tparent.frames[3].document.getElementById(\'fileid\').innerHTML=\"<select name=fileno id=fileno onBlur=\'CheckFileExists(this.value);\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</select>\";\n\t\t\t\t\t\tparent.frames[2].document.forms[0].validFile.value =\'true\';\n\t\t\t\t\t\tparent.frames[2].document.forms[0].file_type_code.value =\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\';\n\t\t\t\t\t\tparent.frames[2].document.getElementById(\'volid\').innerHTML=\"<select name=volumeno id=volumeno >";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</select>\";\n\t\t\t\t}else{\n\t\t\t\t\t if(Rename==\"IP\" || Rename==\"OP\")\n\t\t\t\t\t    {\n\t\t\t\t\t\n\t\t\t\t\tif(parent.frames[1].document.getElementById(\'fileid\'))\n\t\t\t\t\tparent.frames[1].document.getElementById(\'fileid\').innerHTML=\"<select name=fileno id=fileno onBlur=\'CheckFileExists(this.value);\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</select>\";\n\t\t\t\t\t\tif(parent.frames[1].document.forms[0].validFile)\n\t\t\t\t\t\tparent.frames[1].document.forms[0].validFile.value =\'true\';\n\t\t\t\t\t\tif(parent.frames[1].document.forms[0].file_type_code)\n\t\t\t\t\t\tparent.frames[1].document.forms[0].file_type_code.value =\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\';\n\t\t\t\t\t\tif(parent.frames[1].document.getElementById(\'volid\'))\n\t\t\t\t\t\tparent.frames[1].document.getElementById(\'volid\').innerHTML=\"<select name=volumeno id=volumeno >";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</select>\";\n\t\t\t\t\t\t}else{\n                   if(parent.frames[1].document.getElementById(\'fileid\'))\n\t\t\t\t\tparent.frames[1].document.getElementById(\'fileid\').innerHTML=\"<select name=fileno id=fileno onBlur=\'CheckFileExists(this.value);\'>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t\t\t\tif(parent.frames[1].document.forms[0].validFile)\n\t\t\t\t\t\tparent.frames[1].document.forms[0].validFile.value =\'true\';\n\t\t\t\t\t\tif(parent.frames[1].document.forms[0].file_type_code)\n\t\t\t\t\t\tparent.frames[1].document.forms[0].file_type_code.value =\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</select>\";\n\n\t\t\t\t\t\t}\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t}\t\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );
	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
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
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con			= ConnectionManager.getConnection(request);
	java.sql.Statement stmt = null;
	ResultSet rs			= null;
	ResultSet rs1			= null;
	try
	{
		String sql				= "";
		String found			= "N";
		String file_no			= "";
		String file_type_desc	= "";
		String file_type_code	= "";
		String sqlString		= "";
		String VOLUME_NO		= "";
		String  file_type_desc1="";
		String Rename="";
		int record_count = 0;

		//String pat_id			= "";
		//String fs_locn		= "";
		//String currLocn		= "";	
		//String currStat		= "";
		//String currIden		= "";	
		//String sysdate		= "";	

		String facility_id		= (String) session.getValue("facility_id");	
		String logged_fcy = request.getParameter("logged_fcy");
		String req_facility = request.getParameter("req_facility");
		String queryCriteria	= request.getParameter("Patient");
		String file_type_yn		= request.getParameter("file_type_yn");	
		String func				= request.getParameter("func");
         Rename    = request.getParameter("Rename");
		if(func == null || func.equals("null")) func = "N";
		if(logged_fcy == null || logged_fcy.equals("null")) logged_fcy = "";
		if(req_facility== null || req_facility.equals("null")) req_facility = "";
		if(Rename == null || Rename.equals("null")) Rename = "";
		if(logged_fcy.equals("E"))
		{
         facility_id=req_facility;
		}
		stmt = con.createStatement();
		sqlString = "SELECT count(*) record_count FROM mr_pat_file_index WHERE facility_id ='"+facility_id+"' AND patient_id = '"+queryCriteria+"' and doc_folder_id is null ";
		rs = stmt.executeQuery(sqlString);
		if ((rs != null) && (rs.next()))
				record_count = rs.getInt("record_count");
		if (rs!=null) rs.close();
		
		//sql = "Select distinct A.FILE_NO, A.PATIENT_ID, A.FILE_TYPE_CODE,I.SHORT_DESC FILE_TYPE_DESC, A.CURR_FS_LOCN_CODE, A.CURR_FILE_STATUS, get_patient_line(A.PATIENT_ID,'"+localeName+"') PLINE, NVL(A.MR_LOCN_YN,'N') CURR_MR_LOCN_YN, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE,(CASE WHEN A.FACILITY_ID<>A.CURR_FACILITY_ID THEN ' / ' || A.CURR_FACILITY_NAME ELSE '&nbsp;' END) CURR_FACILITY_NAME  from FM_CURR_LOCN_VW A ,MR_FILE_TYPE I where PATIENT_ID='"+queryCriteria+"' and  A.FACILITY_ID='"+facility_id+"' AND A.FACILITY_ID = I.FACILITY_ID (+) AND A.FILE_TYPE_CODE = I.FILE_TYPE_CODE (+) AND A.CURR_FS_LOCN_CODE is not null";		
	
		//sql = "Select distinct A.FILE_NO, A.PATIENT_ID, A.FILE_TYPE_CODE, MR_GET_DESC.MR_FILE_TYPE(FACILITY_ID, FILE_TYPE_CODE,'"+localeName+"','2') FILE_TYPE_DESC, A.CURR_FS_LOCN_CODE, A.CURR_FILE_STATUS, get_patient_line(A.PATIENT_ID,'"+localeName+"') PLINE, NVL(A.MR_LOCN_YN,'N') CURR_MR_LOCN_YN, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE,(CASE WHEN A.FACILITY_ID<>A.CURR_FACILITY_ID THEN ' / ' || SM_GET_DESC.SM_FACILITY_PARAM(a.curr_FACILITY_ID,'"+localeName+"','1') ELSE '&nbsp;' END) CURR_FACILITY_NAME  from FM_CURR_LOCN A where a.PATIENT_ID='"+queryCriteria+"' and  A.FACILITY_ID='"+facility_id+"' AND A.CURR_FS_LOCN_CODE is not null";
		
		sql = "Select distinct FILE_NO, PATIENT_ID, FILE_TYPE_CODE, MR_GET_DESC.MR_FILE_TYPE(FACILITY_ID, FILE_TYPE_CODE,'"+localeName+"','2') FILE_TYPE_DESC from FM_CURR_LOCN  where PATIENT_ID='"+queryCriteria+"' and  FACILITY_ID='"+facility_id+"' ";	

		if(file_type_yn.equals("Y"))
				sql=sql+"AND FILE_TYPE_CODE is not null";
		else if(file_type_yn.equals("N"))
			   sql=sql+"AND FILE_NO is not null";

	            

		
	
		
		rs = stmt.executeQuery(sql);		
		

	  	String str  = "";
		String str1 = "";
		String vol1 = "";
		
		//if(rs != null)
		//{
			if(record_count > 1){
				if(file_type_yn.equals("N"))
				{
			str = str +  "<option value=''>------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----</option>";
				}
				else
				{
			str1 = str1 + "<option value=''>------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----</option>";	
				}
		}
		
			while (rs.next())
			{
				found = "Y"; 
				
				file_type_code	= (rs.getString("FILE_TYPE_CODE")==null)?"":rs.getString("FILE_TYPE_CODE");
				

				file_no			= (rs.getString("FILE_NO")==null)?"":rs.getString("FILE_NO");
				
				file_type_desc	= (rs.getString("FILE_TYPE_DESC")==null)?"":rs.getString("FILE_TYPE_DESC");
				
				if(file_type_yn.equals("N"))
				{
				
				str = str + "<option value='"+file_no+"'>"+file_no+"</option>";
				}
				else
				{
				if(!file_type_desc1.equals(file_type_desc))
					{
				str1 =str1 + "<option value='"+file_no+"'>"+file_type_desc+"</option>";
					}
				file_type_desc1=file_type_desc;
				}

			/*pat_id=(rs.getString("PATIENT_ID")==null)?"":rs.getString("PATIENT_ID");*/
			/*sysdate=(rs.getString("SYDATE")==null)?"":rs.getString("SYDATE");*/
			/*fs_locn=(rs.getString("CURR_FS_LOCN_CODE")==null)?"":rs.getString("CURR_FS_LOCN_CODE");*/
			/*currLocn=(rs.getString("CURR_FS_LOCN_CODE")==null)?"":rs.getString("CURR_FS_LOCN_CODE");*/	/*currStat=(rs.getString("CURR_FILE_STATUS")==null)?"":rs.getString("CURR_FILE_STATUS");*/
	/*currIden=(rs.getString("CURR_FS_LOCN_IDENTITY")==null)?"":rs.getString("CURR_FS_LOCN_IDENTITY");*/

			}
		//}
		if(record_count== 1)
		{
		sqlString = "SELECT distinct volume_no FROM fm_curr_locn WHERE facility_id ='"+facility_id+"' AND patient_id = '"+queryCriteria+"' and doc_folder_id is null ORDER BY volume_no desc ";
		rs1 = stmt.executeQuery(sqlString);
		if(rs1 != null)
		{			
			vol1 =vol1 +  "<option value=''>---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---</option>";		
		
			while (rs1.next())
			{
				VOLUME_NO			= (rs1.getString("volume_no")==null)?"":rs1.getString("volume_no");

				vol1 =vol1 + "<option value='"+VOLUME_NO+"'>"+VOLUME_NO+"</option>";
						
			}
		}
		}
if(record_count> 1)
		{
		vol1 = "<option value=''>----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---</option>";
		}
		
		if(found.equals("N"))
		{
			if(func.equals("tracer"))
			{
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(Rename));
            _bw.write(_wl_block9Bytes, _wl_block9);

			}
			else
			{
				
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Rename));
            _bw.write(_wl_block11Bytes, _wl_block11);

			}
		}
		else
		{
			if (func.equals("tracer"))
			{
				if(file_type_yn.equals("N"))
				{

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Rename));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(str));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(vol1));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(str));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(vol1));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(str));
            _bw.write(_wl_block18Bytes, _wl_block18);
	}else
		{
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Rename));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(str1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(file_type_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(vol1));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(str1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(file_type_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(vol1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(str1));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(file_type_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(vol1));
            _bw.write(_wl_block27Bytes, _wl_block27);
	}
			}
			else
			{
				
				if(file_type_yn.equals("N"))
				{
					
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(Rename));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(str));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(str));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(str));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(vol1));
            _bw.write(_wl_block32Bytes, _wl_block32);

				}
				else
				{
					
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(Rename));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(str1));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(file_type_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(vol1));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(str1));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(file_type_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(vol1));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(str1));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(file_type_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(vol1));
            _bw.write(_wl_block41Bytes, _wl_block41);

				}
			}
		}
		if (rs!=null) rs.close();
		if (rs1!=null) rs1.close();
		if (stmt!=null) stmt.close();
		
	}
	catch(Exception e)
	{ 
		out.println("In Exception :"+e.toString()); 
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	
            _bw.write(_wl_block42Bytes, _wl_block42);
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
