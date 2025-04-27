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

public final class __fmissuefilemanualcheckfile extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMIssueFileManualCheckFile.jsp", 1742885058245L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n</head>\n<body class=\'message\' onKeyDown = \'lockKey()\'>\n<form name=\"checkvals\" id=\"checkvals\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<script>\n\t\t\t\tvar errors = getMessage(\'DOC_NOT_EXIST\',\'FM\');\n\t\t\t\tparent.frames[4].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors ;\n\t\t\t//\tparent.frames[3].document.forms[0].fileno.focus();\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<script>\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' == \"\")\n\t\t\t\t{\n\t\t\t\t\tvar errors = getMessage(\'FILES_NO_STORAGE_LOCATION\',\'FM\');\n\t\t\t\t\talert(errors);\n\t\t\t\t\tparent.frames[3].document.forms[0].fileno.focus();\n\t\t\t\t}\n\t\t\t\tvar Obj = parent.frames[3].document.forms[0]\n\t\t\t\tvar reqfacid = Obj.facility.options[Obj.facility.selectedIndex].value;\n\t\t\t\tvar reqlocn = Obj.Req_locn_code.value;\n\n\t\t\t\tif(reqfacid == \'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' && reqlocn == \'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\')\n\t\t\t\t{\n\t\t\t\t\tvar errors = getMessage(\'REQUEST_EQUALS_CURRENT\',\'FM\');\n\t\t\t\t\talert(errors);\t\t\t\t\t\t\n\t\t\t\t\tparent.frames[3].document.forms[0].patientid.value = \"\";\n\t\t\t\t\tparent.frames[3].document.forms[0].patientid.onblur(); \n\t\t\t\t\tparent.frames[3].document.forms[0].currfilelocn.value = \"\";\n\t\t\t\t\tparent.frames[3].document.forms[0].filestat.value = \"\";\n\t\t\t\t\tparent.frames[3].document.forms[0].remarks.value = \"\";\n\t\t\t\t\tparent.frames[3].document.forms[0].fileno.focus();\n\t\t\t\t}\n\t\t\t\telse if(reqfacid == \'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' && \'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' != \'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\')\n\t\t\t\t{\n\t\t\t\t\tvar errors = getMessage(\'FILE_IS_NOT_AT_ISS_LOCN\',\'FM\');\n\t\t\t\t\talert(errors);\t\t\t\t\t\t\n\t\t\t\t\tparent.frames[3].document.forms[0].patientid.value = \"\";\n\t\t\t\t\tparent.frames[3].document.forms[0].patientid.onblur(); \n\t\t\t\t\tparent.frames[3].document.forms[0].currfilelocn.value = \"\";\n\t\t\t\t\tparent.frames[3].document.forms[0].filestat.value = \"\";\n\t\t\t\t\tparent.frames[3].document.forms[0].remarks.value = \"\";\n\t\t\t\t\tparent.frames[3].document.forms[0].fileno.focus();\n\t\t\t\t}\n\t\t\t\telse if(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' == \"O\")\n\t\t\t\t{\n\t\t\t\t\tvar errors = getMessage(\'FILE_STATUS_OUTSIDE\',\'FM\');\n\t\t\t\t\talert(errors);\t\t\n\t\t\t\t\tparent.frames[3].document.forms[0].patientid.value = \"\";\n\t\t\t\t\tparent.frames[3].document.forms[0].patientid.onblur(); \n\t\t\t\t\tparent.frames[3].document.forms[0].currfilelocn.value = \"\";\n\t\t\t\t\tparent.frames[3].document.forms[0].filestat.value = \"\";\n\t\t\t\t\tparent.frames[3].document.forms[0].remarks.value = \"\";\n\t\t\t\t\tparent.frames[3].document.forms[0].fileno.focus();\n\t\t\t\t}\n\t\t\t\telse if(\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' == \"A\")\n\t\t\t\t{\n\t\t\t\t\tvar errors = getMessage(\'FILE_STATUS_ARCHIVE\',\'FM\');\n\t\t\t\t\talert(errors);\t\t\n\t\t\t\t\tparent.frames[3].document.forms[0].patientid.value = \"\";\n\t\t\t\t\tparent.frames[3].document.forms[0].patientid.onblur(); \n\t\t\t\t\tparent.frames[3].document.forms[0].currfilelocn.value = \"\";\n\t\t\t\t\tparent.frames[3].document.forms[0].filestat.value = \"\";\n\t\t\t\t\tparent.frames[3].document.forms[0].remarks.value = \"\";\n\t\t\t\t\tparent.frames[3].document.forms[0].fileno.focus();\n\t\t\t\t}\n\t\t\t\telse if(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' == \"L\")\n\t\t\t\t{\n\t\t\t\t\tvar errors = getMessage(\'FILE_STATUS_LOST\',\'FM\');\n\t\t\t\t\talert(errors);\t\t\t\t\t\t\n\t\t\t\t\tparent.frames[3].document.forms[0].patientid.value = \"\";\n\t\t\t\t\tparent.frames[3].document.forms[0].patientid.onblur(); \n\t\t\t\t\tparent.frames[3].document.forms[0].currfilelocn.value = \"\";\n\t\t\t\t\tparent.frames[3].document.forms[0].filestat.value = \"\";\n\t\t\t\t\tparent.frames[3].document.forms[0].remarks.value = \"\";\n\t\t\t\t\tparent.frames[3].document.forms[0].fileno.focus();\n\t\t\t\t}\n\t\t\t\telse if(\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' == \"T\" || \'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' == \"E\" )\n\t\t\t\t{\n\n\t\t\t\t\tif \t(parseInt(\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\') > 0 )\n\t\t\t\t\t{\n\t\t\t\t\t\talert(getMessage(\'FILE_ALREADY_REQUESTED\',\'FM\')+\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\");\n\t\t\t\t\t\tvar p_file_no_length = parent.frames[3].document.forms[0].p_file_no_length.value ;\n\t\t\t\t\t\tparent.frames[3].document.forms[0].patientid.value=\'\';\n\t\t\t\t\t\tparent.frames[3].document.forms[0].patientid.onblur(); \n\t\t\t\t\t\tparent.frames[3].document.forms[0].fileno.value=\'\';\n\t\t\t\t\t\tparent.frames[3].document.getElementById(\'fileid\').innerHTML=\"<input type=text name=fileno id=fileno size=20 value=\'\' maxlength=\'\"+p_file_no_length+\"\'>\";\n\t\t\t\t\t\tparent.frames[3].document.forms[0].currfilelocn.value=\'\';\n\t\t\t\t\t\tparent.frames[3].document.forms[0].filestat.value=\'\';\n\t\t\t\t\t\tparent.frames[3].document.forms[0].remarks.value=\'\';\n\t\t\t\t\t\tparent.frames[3].document.forms[0].fileno.focus();\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\tvar errors = getMessage(\'FILE_STATUS_TRANSIT\',\'FM\');\n\t\t\t\t\t\talert(errors);\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[3].document.forms[0].fileno.value = \"\";\n\t\t\t\t\t\tparent.frames[3].document.forms[0].patientid.value = \"\";\n\t\t\t\t\t\tparent.frames[3].document.forms[0].patientid.onblur(); \n\t\t\t\t\t\tparent.frames[3].document.forms[0].currfilelocn.value = \"\";\n\t\t\t\t\t\tparent.frames[3].document.forms[0].filestat.value = \"\";\n\t\t\t\t\t\tparent.frames[3].document.forms[0].remarks.value = \"\";\n\t\t\t\t\t\tparent.frames[3].document.forms[0].fileno.focus();\n\t\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\n\t\t\t\tif \t(parseInt(\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\') > 0 )\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\'FILE_ALREADY_REQUESTED\',\'FM\')+\"\\n\"+  \"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\");\n\t\t\t\t\tvar p_file_no_length = parent.frames[3].document.forms[0].p_file_no_length.value ;\n\t\t\t\t\tparent.frames[3].document.forms[0].patientid.value=\'\';\n\t\t\t\t\tparent.frames[3].document.forms[0].patientid.onblur(); \n\t\t\t\t\tparent.frames[3].document.forms[0].fileno.value=\'\';\n\t\t\t\t\tparent.frames[3].document.getElementById(\'fileid\').innerHTML=\"<input type=text name=fileno id=fileno size=20 value=\'\' maxlength=\'\"+p_file_no_length+\"\'>\";\n\t\t\t\t\tparent.frames[3].document.forms[0].currfilelocn.value=\'\';\n\t\t\t\t\tparent.frames[3].document.forms[0].filestat.value=\'\';\n\t\t\t\t\tparent.frames[3].document.forms[0].remarks.value=\'\';\n\t\t\t\t\tparent.frames[3].document.forms[0].fileno.focus();\n\t\t\t\t}\n\n\t\t\t\tif \t(parseInt(\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\') == 0 )\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\tparent.frames[3].document.forms[0].patientid.value = \'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\';\n\t\t\t\tparent.frames[3].document.forms[0].currfilelocn.value = \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" (";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =")\";\n\t\t\t\t\n\t\t\t\tparent.frames[3].document.forms[0].filestat.value = \'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\';\n\t\t\t\tparent.frames[3].document.forms[0].remarks.value = \'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\';\n\t\t\t\tparent.frames[3].document.forms[0].Req_on.value = \'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\';\n\t\t\t\tparent.frames[3].document.forms[0].Curr_facility_id.value = \'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\';\n\t\t\t\tparent.frames[3].document.forms[0].Curr_locn_code.value = \"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\n\t\t\t\tparent.frames[3].document.forms[0].Curr_locn_desc.value = \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\n\t\t\t\tparent.frames[3].document.forms[0].Curr_locn_iden.value = \"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\";\n\t\t\t\tparent.frames[3].document.forms[0].Curr_locn_mr_locn.value = \"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\";\t\t\t\n\t\t\t\tparent.frames[3].document.forms[0].Pat_line.value = \"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\";\n\t\t\t\tparent.frames[3].document.getElementById(\'patline\').innerText = \"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\";\n\t\t\t\tparent.frames[3].document.forms[0].patientid.disabled = true;\n\t\t//\t\tparent.frames[3].document.forms[0].fileno.disabled = true;\n\t\t\t\tparent.frames[3].document.forms[0].remarks.focus();\n\t\t//\t\tparent.frames[3].AddDoc();\n\t\t\t\t}\n\t\t\t\t}\n\t\t\t</script>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

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
	PreparedStatement pstmt	= null;
	ResultSet rs			= null;
	
	int p_file_no_found = 0;

	try
	{

		String facility_id	= (String) session.getValue("facility_id");
		String user_id		= (String) session.getValue("login_user");

		String sql				= "";
		String sql1				= "";
		String pat_id			= "";
		String pat_line			= "";
		String file_no			= "";
		String fs_locn			= "";
		String currFacility		= "";
		String currLocn			= "";
		String currDesc			= "";
		String currStat			= "";
		String currStatDesc		= "";
		String currIden			= "";
		String currIdDesc		= "";
		String currMrLocn		= "";
		String sysdate			= "";
		String remark			= "";		
		String moreCriteria		= "";
	String curr_faCILITY_ID="";
      java.util.Hashtable message;
		String userSecurity = request.getParameter("userSecurity");
		String FileNo = request.getParameter("FileNo");
		String issueLocn = request.getParameter("issueLocn");
		String Facility = request.getParameter("Facility");
		String selLocn	= request.getParameter("selLocn");
		String access_all  = request.getParameter("access_all")==null?"":request.getParameter("access_all");
//		String doctype_appl_yn = request.getParameter("doctype_appl_yn")==null?"Y":request.getParameter("doctype_appl_yn");
		
		StringTokenizer token	= new StringTokenizer(FileNo,",");
		while(token.hasMoreTokens())
				{
					FileNo = token.nextToken();
				}
//out.println("<script language='JavaScript'>alert('"+FileNo+"');</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>");
		StringBuffer SelectSqlBuffer = null;
		SelectSqlBuffer				 = new StringBuffer();
    
	   pstmt = con.prepareStatement("SELECT curr_faCILITY_ID FROM fm_curr_locn WHERE  file_no='"+FileNo+"' AND  FACILITY_ID='"+facility_id+"' ");
		rs = pstmt.executeQuery();
       	while(rs != null && rs.next())
		{
		curr_faCILITY_ID=rs.getString("curr_faCILITY_ID");
			}
		if(rs!=null) rs.close();
		
		if(userSecurity.equals("Y")) 
		{			

			if(access_all.equals("*ALL"))
			{
				//SelectSqlBuffer.append("Select PATIENT_ID, FILE_NO, CURR_FS_LOCN_CODE, CURR_FILE_STATUS, CURR_FACILITY_ID, get_patient_line(PATIENT_ID) PLINE, NVL(MR_LOCN_YN,'N') CURR_MR_LOCN_YN,  DECODE(CURR_FILE_STATUS,'A','Archive','T','Transit','I','Inside','O','Outside','L','Lost','E','Other Facility') FILE_STATUS_DESC, CURR_FS_LOCN_DESC, CURR_FS_LOCN_IDENTITY,  DECODE(CURR_FS_LOCN_IDENTITY,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','X','External','E','Procedure Unit','Y','Daycare Unit') LOCN_IDENTITY_DESC , REMARKS, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE  from FM_CURR_LOCN_VW where FILE_NO = ? and  CURR_FACILITY_ID = ? and CURR_FS_LOCN_CODE = MR_PAT_FS_LOCN_CODE ");

				SelectSqlBuffer.append("SELECT" );
				SelectSqlBuffer.append("  PATIENT_ID" );
				SelectSqlBuffer.append("  , FILE_NO" );
				SelectSqlBuffer.append("  , CURR_FS_LOCN_CODE" );
				SelectSqlBuffer.append("  , CURR_FILE_STATUS" );
				SelectSqlBuffer.append("  , CURR_FACILITY_ID" );
				SelectSqlBuffer.append("  , Get_patient_line(PATIENT_ID,'"+localeName+"') PLINE" );
				SelectSqlBuffer.append("  , Nvl(MR_LOCN_YN,'N') CURR_MR_LOCN_YN" );
				SelectSqlBuffer.append("  , CURR_FILE_STATUS FILE_STATUS_DESC" );
				SelectSqlBuffer.append("  , fm_Get_desc.Fm_storage_locn('"+curr_faCILITY_ID+"',Curr_fs_Locn_Code,'"+localeName+"',1) CURR_FS_LOCN_DESC" );
				SelectSqlBuffer.append("  , CURR_FS_LOCN_IDENTITY" );
				SelectSqlBuffer.append("  , CURR_FS_LOCN_IDENTITY LOCN_IDENTITY_DESC" );
				SelectSqlBuffer.append("  , REMARKS" );
				SelectSqlBuffer.append("  , TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE " );
				SelectSqlBuffer.append("FROM" );
				SelectSqlBuffer.append("  FM_CURR_LOCN " );
				SelectSqlBuffer.append("WHERE FILE_NO = ? " );
				SelectSqlBuffer.append("  AND FACILITY_ID = ? " );
				SelectSqlBuffer.append("  AND CURR_FS_LOCN_CODE = PERM_FS_LOCN_CODE" );


				pstmt = con.prepareStatement(SelectSqlBuffer.toString());
				pstmt.setString(1,FileNo);
				pstmt.setString(2,facility_id);
			}
			else
			{
				if(Facility.equals(facility_id)) moreCriteria = " ISS_YN = 'Y' ";
				else moreCriteria = " ISS_ACROSS_FACILITIES_YN = 'Y' ";

				//SelectSqlBuffer.append("Select PATIENT_ID, FILE_NO, CURR_FS_LOCN_CODE, CURR_FILE_STATUS, CURR_FACILITY_ID, get_patient_line(PATIENT_ID) PLINE, NVL(MR_LOCN_YN,'N') CURR_MR_LOCN_YN,  DECODE(CURR_FILE_STATUS,'A','Archive','T','Transit','I','Inside','O','Outside','L','Lost','E','Other Facility') FILE_STATUS_DESC, CURR_FS_LOCN_DESC, CURR_FS_LOCN_IDENTITY,  DECODE(CURR_FS_LOCN_IDENTITY,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','X','External','E','Procedure Unit','Y','Daycare Unit') LOCN_IDENTITY_DESC, REMARKS,  TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE  from FM_CURR_LOCN_VW A, FM_USER_ACCESS_RIGHTS B where FILE_NO = ? and  A.CURR_FACILITY_ID = ? AND A.CURR_FS_LOCN_CODE = A.MR_PAT_FS_LOCN_CODE AND A.CURR_FACILITY_ID = B.FACILITY_ID AND B.APPL_USER_ID = ? AND FS_LOCN_CODE = CURR_FS_LOCN_CODE AND "+moreCriteria+" ");

				SelectSqlBuffer.append("SELECT" );
				SelectSqlBuffer.append("  PATIENT_ID" );
				SelectSqlBuffer.append("  , FILE_NO" );
				SelectSqlBuffer.append("  , CURR_FS_LOCN_CODE" );
				SelectSqlBuffer.append("  , CURR_FILE_STATUS" );
				SelectSqlBuffer.append("  , CURR_FACILITY_ID" );
				SelectSqlBuffer.append("  , Get_patient_line(PATIENT_ID,'"+localeName+"') PLINE" );
				SelectSqlBuffer.append("  , Nvl(MR_LOCN_YN,'N') CURR_MR_LOCN_YN" );
				SelectSqlBuffer.append("  , CURR_FILE_STATUS FILE_STATUS_DESC" );
				SelectSqlBuffer.append("  , fm_Get_desc.Fm_storage_locn('"+curr_faCILITY_ID+"',Curr_fs_Locn_Code,'"+localeName+"',1) CURR_FS_LOCN_DESC" );
				SelectSqlBuffer.append("  , CURR_FS_LOCN_IDENTITY" );
				SelectSqlBuffer.append("  , CURR_FS_LOCN_IDENTITY LOCN_IDENTITY_DESC" );
				SelectSqlBuffer.append("  , REMARKS" );
				SelectSqlBuffer.append("  , TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE " );
				SelectSqlBuffer.append("FROM" );
				SelectSqlBuffer.append("  FM_CURR_LOCN A" );
				SelectSqlBuffer.append("  , FM_USER_ACCESS_RIGHTS B " );
				SelectSqlBuffer.append("WHERE FILE_NO = ? " );
				SelectSqlBuffer.append("  AND A.CURR_FACILITY_ID = ? " );
				SelectSqlBuffer.append("  AND A.CURR_FS_LOCN_CODE = A.PERM_FS_LOCN_CODE " );
				SelectSqlBuffer.append("  AND A.CURR_FACILITY_ID = B.FACILITY_ID " );
				SelectSqlBuffer.append("  AND B.APPL_USER_ID = ? " );
				SelectSqlBuffer.append("  AND B.FS_LOCN_CODE = A.CURR_FS_LOCN_CODE " );
				SelectSqlBuffer.append(moreCriteria);
				
				if(pstmt != null) pstmt.close();

				pstmt = con.prepareStatement(SelectSqlBuffer.toString());
				pstmt.setString(1,FileNo);
				pstmt.setString(2,facility_id);
				pstmt.setString(3,user_id);
			}
		}
		else if(userSecurity.equals("N"))
		{
			//SelectSqlBuffer.append("Select PATIENT_ID, FILE_NO, CURR_FS_LOCN_CODE, CURR_FILE_STATUS, CURR_FACILITY_ID, get_patient_line(PATIENT_ID) PLINE, NVL(MR_LOCN_YN,'N') CURR_MR_LOCN_YN,  DECODE(CURR_FILE_STATUS,'A','Archive','T','Transit','I','Inside','O','Outside','L','Lost','E','Other Facility') FILE_STATUS_DESC, CURR_FS_LOCN_DESC, CURR_FS_LOCN_IDENTITY,  DECODE(CURR_FS_LOCN_IDENTITY,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','X','External','E','Procedure Unit','Y','Daycare Unit') LOCN_IDENTITY_DESC , REMARKS, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE  from FM_CURR_LOCN_VW where FILE_NO = ? and  CURR_FACILITY_ID = ? and CURR_FS_LOCN_CODE = MR_PAT_FS_LOCN_CODE ");

			SelectSqlBuffer.append("SELECT" );
			SelectSqlBuffer.append("  PATIENT_ID" );
			SelectSqlBuffer.append("  , FILE_NO" );
			SelectSqlBuffer.append("  , CURR_FS_LOCN_CODE" );
			SelectSqlBuffer.append("  , CURR_FILE_STATUS" );
			SelectSqlBuffer.append("  , CURR_FACILITY_ID" );
			SelectSqlBuffer.append("  , Get_patient_line(PATIENT_ID,'"+localeName+"') PLINE" );
			SelectSqlBuffer.append("  , Nvl(MR_LOCN_YN,'N') CURR_MR_LOCN_YN" );
			SelectSqlBuffer.append("  , CURR_FILE_STATUS FILE_STATUS_DESC" );
			SelectSqlBuffer.append("  , fm_Get_desc.Fm_storage_locn('"+curr_faCILITY_ID+"',Curr_fs_Locn_Code,'"+localeName+"',1) CURR_FS_LOCN_DESC" );
			SelectSqlBuffer.append("  , CURR_FS_LOCN_IDENTITY" );
			SelectSqlBuffer.append("  , CURR_FS_LOCN_IDENTITY LOCN_IDENTITY_DESC" );
			SelectSqlBuffer.append("  , REMARKS" );
			SelectSqlBuffer.append("  , TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE " );
			SelectSqlBuffer.append("FROM" );
			SelectSqlBuffer.append("  FM_CURR_LOCN " );
			SelectSqlBuffer.append("WHERE FILE_NO = ? " );
			SelectSqlBuffer.append("  AND FACILITY_ID = ? " );
			SelectSqlBuffer.append("  AND CURR_FS_LOCN_CODE = PERM_FS_LOCN_CODE" );

			
			if(pstmt != null) pstmt.close();

			pstmt = con.prepareStatement(SelectSqlBuffer.toString());
			pstmt.setString(1,FileNo);
			pstmt.setString(2,facility_id);
		}
		rs = pstmt.executeQuery();
		if(rs != null)
		{
			while (rs.next())
			{
				pat_id			= rs.getString("PATIENT_ID");
				file_no			= rs.getString("FILE_NO");
				fs_locn			= rs.getString("CURR_FS_LOCN_CODE");
				currFacility	= rs.getString("CURR_FACILITY_ID");
				pat_line		= rs.getString("PLINE").substring(0,rs.getString("PLINE").length()-6);
				currMrLocn		= rs.getString("CURR_MR_LOCN_YN");
				currLocn		= rs.getString("CURR_FS_LOCN_CODE");
				currDesc		= rs.getString("CURR_FS_LOCN_DESC");
				currStat		= rs.getString("CURR_FILE_STATUS");
				currStatDesc	= rs.getString("FILE_STATUS_DESC"); 
				currIden		= rs.getString("CURR_FS_LOCN_IDENTITY");
				currIdDesc		= rs.getString("LOCN_IDENTITY_DESC");
				sysdate			= rs.getString("SYDATE");
				remark			= rs.getString("REMARKS");
			}
			
			if(fs_locn == null || fs_locn.equals("null")) fs_locn = "";
		}
		if(rs != null)    rs.close();
		if(pstmt != null) pstmt.close();

		if((SelectSqlBuffer != null) && (SelectSqlBuffer.length() > 0))
		{
			SelectSqlBuffer.delete(0,SelectSqlBuffer.length());
		}

		if(remark == null || remark.equals("null")) remark = "";

		if(currStat.equals("I"))
		remark="";
		
		if(file_no.equals(""))
		{
			
            _bw.write(_wl_block8Bytes, _wl_block8);

		}
		else
		{
			if(rs != null)    rs=null;
			if(pstmt != null) pstmt=null;
			sql1 = "SELECT to_char(A.SENT_DATE_TIME,'dd/mm/rrrr hh:mi AM') sent_date_time FROM FM_TRANSIT_FILE A WHERE A.FACILITY_ID = '"+facility_id+"' AND A.FILE_NO ='"+file_no+"' AND DEST_FS_LOCN_CODE = '"+selLocn+"' ";
			pstmt = con.prepareStatement(sql1);
		//	pstmt.setString(1,facility_id);
		//	pstmt.setString(2,file_no);
		//	pstmt.setString(3,selLocn);
			rs = pstmt.executeQuery();
			String p_error_message = "", p_sent_date_time="";
			sql="";
			while(rs != null && rs.next())
			{
				p_file_no_found++;			
				p_sent_date_time = rs.getString(1);
			}
			if(rs != null)    rs.close();
			if(pstmt != null) pstmt.close();

			if(p_file_no_found ==0)	
			{
				sql = "SELECT A.REQ_FS_LOCN_DESC || ' (' || A.REQ_FACILITY_NAME || ')', TO_CHAR(A.ADDED_DATE,'DD/MM/RRRR HH:MI AM'),A.REQ_BY_NAME FROM FM_REQ_HDR_VW A, FM_REQ_DTL B WHERE A.REQ_NO=B.REQ_NO AND A.REQ_FS_LOCN_CODE='"+selLocn+"' AND A.REQ_FACILITY_ID='"+Facility+"' AND B.FILE_NO='"+file_no+"' AND B.ISS_YN='N' AND B.CANCEL_YN='N' ";
				
				pstmt = con.prepareStatement(sql);
		//		pstmt.setString(1,selLocn);
		//		pstmt.setString(2,Facility);
		//		pstmt.setString(3,file_no);
				rs = pstmt.executeQuery();
				
				while(rs != null && rs.next())
				{
					p_file_no_found++;
					//p_error_message =" File no " + FileNo + " already requested by " + rs.getString(1) + " on " + rs.getString(2) + " by " + rs.getString(3) ;
					//p_error_message=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"FILE_ALREADY_REQUSTED","fm_messages");
					
					message = MessageManager.getMessage(localeName,"FILE_ALREADY_REQUSTED","FM");
					p_error_message = (String) message.get("message");

					p_error_message=p_error_message.replace("$",FileNo);
					p_error_message=p_error_message.replace("#",rs.getString(1));
					p_error_message=p_error_message.replace("~",rs.getString(2));
					p_error_message=p_error_message.replace("%",rs.getString(3));
				}
			}
			else
			{
				//p_error_message =" File no " + FileNo + " is already been issued on " + p_sent_date_time  ;
				//p_error_message=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"FILE_ALREADY_ISSUED","fm_messages");

				message = MessageManager.getMessage(localeName,"FILE_ALREADY_ISSUED","FM");
				p_error_message = (String) message.get("message");


				p_error_message=p_error_message.replace("$",FileNo);
				p_error_message=p_error_message.replace("#",p_sent_date_time);
			}
			
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(fs_locn));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(currLocn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(issueLocn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(currLocn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(currStat));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(currStat));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(currStat));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(currStat));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(currStat));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(p_file_no_found));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(p_error_message));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(p_file_no_found));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(p_error_message));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(p_file_no_found));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(pat_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(currDesc));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(currIdDesc));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(currStatDesc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(remark));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(currFacility));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(currLocn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(currDesc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(currIden));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(currMrLocn));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(pat_line));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(pat_line));
            _bw.write(_wl_block38Bytes, _wl_block38);

		}
if(rs!=null) rs.close();
if(pstmt!=null) pstmt.close();
}
catch(Exception e)
{ out.println("In Exception :"+e.toString()); 
e.printStackTrace();}
finally
{	
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block39Bytes, _wl_block39);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
