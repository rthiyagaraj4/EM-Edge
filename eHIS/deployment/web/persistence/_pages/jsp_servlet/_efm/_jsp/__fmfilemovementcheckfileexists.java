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

public final class __fmfilemovementcheckfileexists extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMFileMovementCheckFileExists.jsp", 1724412329680L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body class=\'message\' onKeyDown = \'lockKey()\'>\n<form name=\"checkvals\" id=\"checkvals\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar errors = getMessage(\"PATIENT_FILE_NOT_EXIST\",\"FM\");\n\t\t\t\t\tvar Rename=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\t\tvar file_type_code=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\t\tif(Rename==\"RE\")\n\t\t\t\t{\n                    parent.frames[3].document.forms[0].fileno.focus();\n\t\t\t\t\tparent.frames[2].document.forms[0].validFile.value =\'false\';\n\t\t\t\t}else{\n\n\t\t\t\t\tparent.frames[2].document.forms[0].fileno.focus();\n\t\t\t\t\tparent.frames[2].document.forms[0].validFile.value =\'false\';\n\t\t\t\t  if(parent.frames[1].document.forms[0].file_type_code)\n\t\t\t\t\tparent.frames[1].document.forms[0].file_type_code.value=file_type_code;\n\t\t\t\t}\n\t\t\t\t//parent.frames[4].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors ;\t\t\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\t\tif(Rename==\"RE\")\n\t\t\t\t{\n\t\t\t\t   parent.frames[3].document.forms[0].fileno.focus();\n\t\t\t\t\tparent.frames[1].document.forms[0].validFile.value =\'false\';\n\t\t\t\t}else{\n\t\t\t\t\tparent.frames[1].document.forms[0].fileno.focus();\n\t\t\t\t\tparent.frames[1].document.forms[0].validFile.value =\'false\';\n\t\t\t\t    if(parent.frames[1].document.forms[0].file_type_code)\n\t\t\t\t\tparent.frames[1].document.forms[0].file_type_code.value=file_type_code;\n\t\t\t\t}\n\t\t\t\t//parent.frames[4].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors ;\t\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<script>\n\t\t\t\t var file_type_code=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\t\t\t\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' == \"\")\n\t\t\t\t\t{\n\t\t\t\t\tvar errors = getMessage(\'FILES_NO_STORAGE_LOCATION\',\'FM\');\n\t\t\t\t   var Rename=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\t\t\tif(Rename==\"RE\")\n\t\t\t\t{\n\t\t\t\t        parent.frames[3].document.forms[0].fileno.focus();\n\t\t\t\t\t\tparent.frames[2].document.forms[0].validFile.value =\'false\';\n\t\t\t\t}else{\n\t\t\t\t\t\tparent.frames[2].document.forms[0].fileno.focus();\n\t\t\t\t\t\tparent.frames[2].document.forms[0].validFile.value =\'false\';\n\t\t\t\t   if(parent.frames[1].document.forms[0].file_type_code)\n\t\t\t\t\tparent.frames[1].document.forms[0].file_type_code.value=file_type_code;\n\t\t\t\t}  \n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t var Rename=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\t\tif(Rename==\"RE\")\n\t\t\t\t{\n\t\t\t\tparent.frames[3].document.forms[0].patientid.value = \'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\';\t\t\tparent.frames[2].document.forms[0].validFile.value =\'true\';\t\n\t\t\t\t}else{\n\t\t\t\tparent.frames[2].document.forms[0].patientid.value = \'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\';\t\t\tparent.frames[2].document.forms[0].validFile.value =\'true\';\t\n\t\t\t  if(parent.frames[1].document.forms[0].file_type_code)\n\t\t\t\t\tparent.frames[1].document.forms[0].file_type_code.value=file_type_code;\n\t\t\t\t}\n\t\t\t\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\n\t\t\t\t<script>\n\t\t\t\tvar Rename=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\n\t\t\t\t var file_type_code=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\";\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' == \"\")\n\t\t\t\t\t{\n\t\t\t\t\t\tvar errors = getMessage(\'FILES_NO_STORAGE_LOCATION\',\'FM\');\n\t\t\t\t\t\t var Rename=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\n\t\t\t\tif(Rename==\"RE\")\n\t\t\t\t{  \n\t\t\t\t       parent.frames[2].document.forms[0].fileno.focus();\n\t\t\t\t\t\tparent.frames[1].document.forms[0].validFile.value =\'false\';\n\t\t\t\t}else{\t\n\t\t\t\t\t\tparent.frames[1].document.forms[0].fileno.focus();\n\t\t\t\t\t\tparent.frames[1].document.forms[0].validFile.value =\'false\';\n\t\t\t\t  if(parent.frames[1].document.forms[0].file_type_code)\n\t\t\t\t\tparent.frames[1].document.forms[0].file_type_code.value=file_type_code;\n\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\tif(Rename==\"RE\")\n\t\t\t\t     {\n\t\t\t\t\t parent.frames[3].document.forms[0].patientid.value = \'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\';\tparent.frames[1].document.forms[0].validFile.value =\'true\';\t\n\t\t\t\t\t }else{\n\t\t\t\t\t\tparent.frames[1].document.forms[0].patientid.value = \'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\';\t\t\t\t\n\t\t\t\t\t\tparent.frames[1].document.forms[0].validFile.value =\'true\';\t\n\t\t\t\t\t    if(parent.frames[1].document.forms[0].file_type_code)\n\t\t\t\t\tparent.frames[1].document.forms[0].file_type_code.value=file_type_code;\n\t\t\t\t\t }\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t<script>\n\t\t\t\tvar Rename=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\";\n\t\t      if(Rename==\"RE\")\n\t\t\t\t     {\n\t\t\t\t\t  var sel      = parent.frames[3].document.forms[0].volumeno;\n\t\t\t\t\t }else{\n\t\t        var sel      = parent.frames[1].document.forms[0].volumeno;\n\t\t\t\t\t }\n\t\t\t\tvar seletLen = 0;\n\t\t\t\tif(sel != undefined) \n\t\t\t\t{\n\t\t\t\t\tseletLen = Math.abs(sel.length);\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tfor(i=0; i<seletLen; i++) sel.remove(0);\n\t\t\t\n\t\t\t\tif(Rename==\"RE\")\n\t\t\t\t     {\n\t\t\t\t\t var Opt    = parent.frames[3].document.createElement(\"OPTION\");\n\t\t\t\t\t }else{\n\t\t\t\tvar Opt    = parent.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\t }\n\t\t\t\tOpt.value  = \"\"; \n\t\t\t\tOpt.text   = \"---\"+getLabel(\'Common.defaultSelect.label\',\'common\')+\"---\";\n\t\t\t\tvar temp = parent.frames[3].document.forms[0].volumeno;\n\t\t\t\tif(Rename==\"RE\")\n\t\t\t\t{ \n\t\t\t\t\tif(temp != undefined) \n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[3].document.forms[0].volumeno.add(Opt);\n\t\t\t\t\t}\n\t\t\t\t}else{\n\t\t\t\t\tif(temp != undefined)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[1].document.forms[0].volumeno.add(Opt);\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar Rename=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\";\n\t\t\t\tif(Rename==\"RE\"){\n\t\t\tvar Opt    = parent.frames[3].document.createElement(\"OPTION\");\n\t\t\t\t}else{\n\t\t\t\tvar Opt    = parent.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t}\n\t\t\t\t\tOpt.value  = \"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"; \n\t\t\t\t\tOpt.text   = \"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\";\n\t\t\t\t\tif(Rename==\"RE\"){\n\t\t\t\t\tparent.frames[3].document.forms[0].volumeno.add(Opt);\n\t\t\t\t\t}else{\n\t\t\t\t\tparent.frames[1].document.forms[0].volumeno.add(Opt);\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t<script>\n\t\t\t\n          var Rename=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\n           \n\t\t   if(Rename==\"RE\"){\n\t\t    var sel      = parent.frames[3].document.forms[0].volumeno;\n\t\t   }else{\n\t\t   var sel      = parent.frames[2].document.forms[0].volumeno;\n\t\t   }\n\t\t   \tvar seletLen = 0;\n\t\t\tif(sel != undefined) \n\t\t\t{\n\t\t\t\t\tseletLen = Math.abs(sel.length);\n\t\t\t}\n\t\t\tfor(i=0; i<seletLen; i++)\n\t\t\t\tsel.remove(0);\n\t\t</script>\n\t\t<script>\n\t\t\t\tvar Rename=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\n           \n\t\t   if(Rename==\"RE\"){\n\t\t   var Opt    = parent.frames[3].document.createElement(\"OPTION\");\n\t\t   }else{\n\t\tvar Opt    = parent.frames[2].document.createElement(\"OPTION\");\n\t\t   }\n\t\t\t\tOpt.value  = \"\"; \n\t\t\t\tOpt.text   = \"---\"+getLabel(\'Common.defaultSelect.label\',\'common\')+\"---\";\n\t\t\t\tif(Rename==\"RE\" )\n\t\t\t\t{\n\t\t\t\t\tvar temp1 = parent.frames[3].document.forms[0].volumeno;\n\t\t\t\t\tif(temp1 != undefined) \n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[3].document.forms[0].volumeno.add(Opt);\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tvar temp2 = parent.frames[2].document.forms[0].volumeno;\n\t\t\t\t\tif(temp2 != undefined) \n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[2].document.forms[0].volumeno.add(Opt);\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\";\n           \n\t\t   if(Rename==\"RE\"){\n\t\t   var Opt    = parent.frames[3].document.createElement(\"OPTION\");\n\t\t   }else{\n\t\t\t   var Opt    = parent.frames[2].document.createElement(\"OPTION\");\n\t\t   }\n\t\t\t\t\tOpt.value  = \"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\";\n\t\t\t\t\t if(Rename==\"RE\")\n\t\t\t\t\t {\n\t\t\t\t\t\t var v1 = parent.frames[3].document.forms[0].volumeno;\n\t\t\t\t\t\t if(v1 != undefined)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t parent.frames[3].document.forms[0].volumeno.add(Opt);\n\t\t\t\t\t\t}\n\t\t\t\t\t }\n\t\t\t\t\t else\n\t\t\t\t\t {\n\t\t\t\t\t\t var v2 = parent.frames[2].document.forms[0].volumeno;\n\t\t\t\t\t\t if(v2 != undefined)\n\t\t\t\t\t\t {\n\t\t\t\t\t\t\t parent.frames[2].document.forms[0].volumeno.add(Opt);\n\t\t\t\t\t\t }\n\t\t\t\t\t }\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

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
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con			= ConnectionManager.getConnection(request);
	java.sql.Statement stmt = null;
	ResultSet rs			= null;



	try
	{
		String sql			= "";
		String pat_id		= "";
		String file_no		= "";
		String fs_locn		= "";		
		//String currStatDesc = "";	
		//String currIdDesc	= "";	
		//String sysdate		= "";	
		String volumeno		= "";	
		String VolumeSQL	= "";	
		String ProceedValue	= "Yes";	

		int index = 0;
		
		String facility_id = (String) session.getValue("facility_id");

		String FileNo		= request.getParameter("FileNo");
		String PPatientID	= request.getParameter("patient_id");
	//	String Facility		= request.getParameter("Facility");
		String func			= request.getParameter("func");
		String Rename    = request.getParameter("Rename");
	  String logged_fcy = request.getParameter("logged_fcy");
		String req_facility = request.getParameter("req_facility");
		String file_type_code="";
		
		if(logged_fcy == null || logged_fcy.equals("null")) logged_fcy = "";
		if(req_facility== null || req_facility.equals("null")) req_facility = "";
		if(Rename == null || Rename.equals("null")) Rename = "";
      if(logged_fcy.equals("E"))
		{
         facility_id=req_facility;
		}
		
		
		if(func == null || func.equals("null")) func = "N";
		if(PPatientID == null || PPatientID.equals("null")) PPatientID = "";

		stmt = con.createStatement();

		//sql = "Select PATIENT_ID, FILE_NO, CURR_FS_LOCN_CODE, CURR_FILE_STATUS, get_patient_line(PATIENT_ID,'"+localeName+"') PLINE, NVL(MR_LOCN_YN,'N') CURR_MR_LOCN_YN,  DECODE(CURR_FILE_STATUS,'A','Archive','T','Transit','I','Inside','O','Outside','L','Lost') FILE_STATUS_DESC, CURR_FS_LOCN_DESC, CURR_FS_LOCN_IDENTITY,  DECODE(CURR_FS_LOCN_IDENTITY,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','X','External','E','Procedure Unit','Y','Daycare Unit') LOCN_IDENTITY_DESC , TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE,(CASE WHEN A.FACILITY_ID<>A.CURR_FACILITY_ID THEN ' / ' || A.CURR_FACILITY_NAME ELSE '&nbsp;' END) CURR_FACILITY_NAME  from FM_CURR_LOCN_VW A where FILE_NO='"+FileNo+"' and  A.FACILITY_ID='"+facility_id+"' AND CURR_FS_LOCN_CODE is not null ";

		//decode not handled bcoz it is not used.

		sql = "Select PATIENT_ID, FILE_NO, CURR_FS_LOCN_CODE, CURR_FILE_STATUS, get_patient_line(PATIENT_ID,'"+localeName+"') PLINE, NVL(MR_LOCN_YN,'N') CURR_MR_LOCN_YN,  CURR_FILE_STATUS FILE_STATUS_DESC,file_type_code, FM_GET_DESC.FM_STORAGE_LOCN(A.CURR_FACILITY_ID, A.CURR_FS_LOCN_CODE,'"+localeName+"','2') CURR_FS_LOCN_DESC, CURR_FS_LOCN_IDENTITY,  A.CURR_FS_LOCN_IDENTITY LOCN_IDENTITY_DESC , TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE,(CASE WHEN A.FACILITY_ID<>A.CURR_FACILITY_ID THEN ' / ' || SM_GET_DESC.SM_FACILITY_PARAM(a.curr_FACILITY_ID,'"+localeName+"','1') ELSE '&nbsp;' END) CURR_FACILITY_NAME  from FM_CURR_LOCN A where A.FILE_NO='"+FileNo+"' and  A.FACILITY_ID='"+facility_id+"' AND CURR_FS_LOCN_CODE is not null ";
			
		rs = stmt.executeQuery(sql);
		if(rs != null)
		{
			while (rs.next())
			{
				pat_id			= (rs.getString("PATIENT_ID")==null)?"":rs.getString("PATIENT_ID");
				file_no			= (rs.getString("FILE_NO")==null)?"":rs.getString("FILE_NO");
				fs_locn			= (rs.getString("CURR_FS_LOCN_CODE")==null)?"":rs.getString("CURR_FS_LOCN_CODE");
				file_type_code	= (rs.getString("file_type_code")==null)?"":rs.getString("file_type_code");
				
				//currStatDesc	= (rs.getString("FILE_STATUS_DESC")==null)?"":rs.getString("FILE_STATUS_DESC");  
				//currIdDesc		= (rs.getString("LOCN_IDENTITY_DESC")==null)?"":rs.getString("LOCN_IDENTITY_DESC");
				//sysdate  =(rs.getString("SYDATE")==null)?"":rs.getString("SYDATE");
			
				index =  index  + 1;
			}

			if(fs_locn == null || fs_locn.equals("null")) fs_locn = "";
		} if(rs!=null) rs.close();
		
		if(file_no.equals(""))
		{
			if (func.equals("tracer"))
			{

				
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(Rename));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(file_type_code));
            _bw.write(_wl_block10Bytes, _wl_block10);

			}
			else
			{
				
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(Rename));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(file_type_code));
            _bw.write(_wl_block11Bytes, _wl_block11);

			}
		}
		else
		{
			if(func.equals("tracer"))
			{
				
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(file_type_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(fs_locn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Rename));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(Rename));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block18Bytes, _wl_block18);

			}
			else
			{
				
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Rename));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(file_type_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(fs_locn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Rename));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block25Bytes, _wl_block25);

			}
		}
		VolumeSQL = "SELECT DISTINCT volume_no FROM fm_curr_locn WHERE facility_id ='"+facility_id+"' and patient_id='"+PPatientID+"' and file_no='"+FileNo+"' ORDER BY volume_no desc ";
		rs = stmt.executeQuery(VolumeSQL);

		if((!file_no.equals("")) && (ProceedValue.equals("Yes")) && (!func.equals("tracer")))
		{
		
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(Rename));
            _bw.write(_wl_block27Bytes, _wl_block27);

			while(rs != null && rs.next())
			{
				volumeno = rs.getString("volume_no");
				if(volumeno == null || volumeno.equals("null")) volumeno = "";
				
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(Rename));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(volumeno));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(volumeno));
            _bw.write(_wl_block31Bytes, _wl_block31);

			}
		}
		else
		{

            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(Rename));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(Rename));
            _bw.write(_wl_block34Bytes, _wl_block34);

		while(rs != null && rs.next())
		{
			volumeno = rs.getString("volume_no");
			if(volumeno == null || volumeno.equals("null")) volumeno = "";
			
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(Rename));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(volumeno));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(volumeno));
            _bw.write(_wl_block36Bytes, _wl_block36);

		}
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("In Exception :"+e.toString()); 
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block37Bytes, _wl_block37);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
