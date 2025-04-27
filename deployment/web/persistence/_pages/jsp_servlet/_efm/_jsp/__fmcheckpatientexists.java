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

public final class __fmcheckpatientexists extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMCheckPatientExists.jsp", 1709116830435L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tCreated On\t: 6/15/2002\n\tCreated By\t: Nanda Kumar R.\n\tModule\t\t: File Management (FM)\n\tFunction\t: Request of File\n-->\n";
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

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMRequestFile.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body class=\'message\' onKeyDown = \'lockKey()\'>\n<form>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="<script>\n\t\t\t\tif ((parent.frames[3].document.forms[0].file_type != null ) && (parent.frames[3].document.forms[0].file_type.type != \"text\"))\n\t\t\t\t{\n\t\t\t\tvar n = parent.frames[3].document.forms[0].file_type.options.length;\n\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t\t\t{\tparent.frames[3].document.forms[0].file_type.remove(\"file_type\");\n\t\t\t\t\t\t}\n\t\t\t\tvar temp2 =\'\';\n\t\t\t\tvar temp3=\'----\'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\'----\';\n\t\t\t\tvar opt=parent.frames[3].document.createElement(\"OPTION\");\t\t\t\t\t\t\t\t\n\t\t\t\t\t opt.text=temp3;\n\t\t\t\t\t opt.value=temp2;\n\t\t\t\tparent.frames[3].document.forms[0].file_type.add(opt);\n\t\t\t\t}\n\t\t\t</script>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<script>\n\t\t\t\tif ((parent.frames[3].document.forms[0].file_type != null )&&(parent.frames[3].document.forms[0].file_type.type != \"text\"))\n\t\t\t\t{\n\t\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\t\tvar opt=parent.frames[3].document.createElement(\"OPTION\");\t\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\topt.text=temp1;\n\t\t\t\t\t\topt.value=temp;\n\t\t\t\t\t\n\t\t\t\t\tparent.frames[3].document.forms[0].file_type.add(opt);\n\t\t\t\t}\n\t\t\t\t</script>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<script>\n\t\t\t\t\tif \t(parseInt(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\') > 0 )\n\t\t\t\t\t{\n\t\t\t\t\talert(getMessage(\'FILE_ALREADY_REQUESTED\',\'FM\')+\"\\n\"+\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\");\n\t\t\t\t\tparent.frames[3].document.forms[0].p_patient_id.value=\'\';\n\t\t\t\t\tif ((parent.frames[3].document.forms[0].file_type != null ) && (parent.frames[3].document.forms[0].file_type.type != \"text\"))\n\t\t\t\t\t{\n\t\t\t\t\tvar n = parent.frames[3].document.forms[0].file_type.options.length;\n\t\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t\t\t{\tparent.frames[3].document.forms[0].file_type.remove(\"file_type\");\n\t\t\t\t\t\t}\n\t\t\t\t\tvar temp2 =\'\';\n\t\t\t\t\tvar temp3=\'----\'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\'----\';\n\t\t\t\t\tvar opt=parent.frames[3].document.createElement(\"OPTION\");\t\t\t\t\t\t\t\topt.text=temp3;\n\t\t\t\t\t\t\t\t\t\topt.value=temp2;\n\t\t\t\t\tparent.frames[3].document.forms[0].file_type.add(opt);\n\n\t\t\t\t\t}\t\t\t\t\t\n\n\t\t\t\t\tparent.frames[3].document.forms[0].p_patient_id.focus();\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t<script>\t\t\t\n\t\t\tif \t(parseInt(\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\') == 0 )\n\t\t\t{\n\n\t\t\t\tif (parent.frames[3].document.forms[0].p_select_values.value.length==0)\n\t\t\t\t{\n\t\t\t\t\tparent.frames[3].document.forms[0].p_select_values.value = \'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\';\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.frames[3].document.forms[0].p_select_values.value = parent.frames[3].document.forms[0].p_select_values.value + \'|\' + \'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\';\n\n\t\t\t\t}\n\n\t\t\t\t\tvar p_old_string = parent.frames[3].document.forms[0].p_select_values.value ;\n\t\t\t\t\t\n\t\t\t\t\tvar p_deselect_file_no = \"\";\n\t\t\t\t\tvar p_select_file_no = parent.frames[3].document.forms[0].p_select_files.value +\'|\' + parent.frames[3].document.forms[0].p_select_values.value;\n\n\t\t\t\t\tif (parent.frames[2].document.forms[0].logged_fcy.value==\'L\')\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[2].document.forms[0].logged_fcy.disabled=true;\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[2].document.forms[0].logged_fcy.disabled=true;\n\t\t\t\t\t\tparent.frames[2].document.forms[0].enter_fcy.disabled=true;\n\t\t\t\t\t}\n\n\t\t\t\t\tHTMLVal = \"<html><BODY onKeyDown = \'lockKey()\'><form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eFM/jsp/FMRequestSelectedFiles.jsp\'><input name=\'p_select_files\' id=\'p_select_files\' type=\'hidden\' value=\'\"+p_select_file_no+\"\'><input name=\'p_deselect_files\' id=\'p_deselect_files\' type=\'hidden\' value=\"+p_deselect_file_no+\"><input name=\'p_valtype\' id=\'p_valtype\' type=\'hidden\' value=\'F\'><input name=\'conc_remarks\' id=\'conc_remarks\' type=\'hidden\' value=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="><input name=\'p_enter_fcy\' id=\'p_enter_fcy\' type=\'hidden\' value=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="><input name=\'p_req_fs_locn\' id=\'p_req_fs_locn\' type=\'hidden\' value=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="<input name=\'fileno_name\' id=\'fileno_name\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'><input name=\'filetype_name\' id=\'filetype_name\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'><input name=\'file_no_function\' id=\'file_no_function\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'><input name=\'file_type_function\' id=\'file_type_function\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'><input name=\'frame_name\' id=\'frame_name\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'><input name=\'form_name\' id=\'form_name\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'><input name=\'volumeno_name\' id=\'volumeno_name\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'></form></BODY></HTML>\";\n\t\t\t\t\tparent.frames[4].document.write(HTMLVal);\n\t\t\t\t\tparent.frames[4].document.form1.submit();\n\n\t\t\t\t\tparent.frames[1].document.forms[0].FS_LOCN_ID.disabled=true;\n\t\t\t\t\tparent.frames[1].document.forms[0].req_location.disabled=true;\n\n\t\t\t\t\tvar p_disp_files = \'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\';\n\n\t\t\t\t\tif (p_disp_files.length>0)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar errors = getMessage(\'REQUEST_EQUALS_CURRENT\',\'FM\')+ \' . Files are : \' + p_disp_files;\n\t\t\t\t\t\tparent.frames[6].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors ;\n\t\t\t\t\t}\n\t\t\t\t\tparent.frames[3].document.forms[0].p_patient_id.value=\'\';\n\t\t\t\t\tparent.frames[3].document.forms[0].p_patient_id.focus();\n\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar errors = getMessage(\'FILES_NO_STORAGE_LOCATION\',\'FM\');\t\t\n\t\t\t\t\tparent.frames[6].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors ;\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t<script>\n\t\t\t\tparent.frames[3].document.forms[0].patient_id.value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'; \n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar errors = getMessage(\'PATIENT_NOT_EXIST\',\'FM\');\t\t\t\t\n\t\t\t\t\tparent.frames[6].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors ;\n\t\t\t\t\tparent.frames[3].document.forms[0].p_patient_id.focus();\n\t\t\t\t\tparent.frames[3].document.forms[0].p_patient_id.select();\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t<script>\n\t\t\tparent.frames[3].document.forms[0].flag.value=\'\';\t\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
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
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con				= ConnectionManager.getConnection(request);
	java.sql.Statement stmt		= null;
	ResultSet rs				= null;
	ResultSet rs1				= null;
	PreparedStatement pstmt		= null;
	ResultSet rset				= null;
	
try
{
	stmt = con.createStatement();
	String p_patient_file_no = request.getParameter("p_patient_file_no");
	String facility_id = request.getParameter("facility_id");
	String file_type_appl_yn = request.getParameter("file_type_appl_yn");
	String sql				 = "";
	String facilityid 		 = (String) session.getValue("facility_id");
	int p_count				 = 0;
	int p_fs_locn_code_cnt   = 0,p_file_no_found=0;
	String p_enter_fcy		 = request.getParameter("p_enter_fcy");
	String p_req_fs_locn	 = request.getParameter("p_req_fs_locn");
	String conc_remarks		 = request.getParameter("conc_remarks");
	String p_new_string		 = "";		
	String p_display_files = "",p_file_no="";

	String fileno_name			= checkForNull(request.getParameter("fileno_name"));
	String filetype_name		= checkForNull(request.getParameter("filetype_name"));
	String file_no_function		= checkForNull(request.getParameter("file_no_function"));
	String file_type_function	= checkForNull(request.getParameter("file_type_function"));
	String frame_name			= checkForNull(request.getParameter("frame_name"));
	String form_name			= checkForNull(request.getParameter("form_name"));
	String volumeno_name		= checkForNull(request.getParameter("volumeno_name"));
	java.util.Hashtable message;


	if (p_enter_fcy.equals("null") || p_enter_fcy.equals("")) p_enter_fcy=facilityid ;

		sql = "select count(a.file_no) rec_cnt from fm_curr_locn a , mr_pat_file_index b where a.facility_id=b.facility_id and a.file_no=b.file_no and b.patient_id='"+p_patient_file_no+"' and b.facility_id='"+p_enter_fcy+"' ";

		rs = stmt.executeQuery(sql);

		while (rs.next())
		{
			p_count = rs.getInt("rec_cnt");
		}
		if (rs!=null) rs.close();

		if (p_count > 0)
		{
			
			if(file_type_appl_yn.equals("Y"))
			{
			try {

			String code = "";
			String desc = "";
			//String strsql = "Select a.short_desc short_desc, b.file_type_code file_type_code from mr_file_type a, mr_pat_file_index b where a.facility_id = b.facility_id and a.file_type_code = b.file_type_code and a.facility_id = '"+facility_id+"' and patient_id = '"+p_patient_file_no+"'";		
			String strsql = "SELECT"
							  +"  MR_GET_DESC.MR_FILE_TYPE(FACILITY_ID, FILE_TYPE_CODE,'"+localeName+"','2') Short_desc"
							  +"  , File_Type_Code File_Type_Code "
							  +"FROM"
							  +"  mr_Pat_File_Index "
							  +"WHERE Facility_Id = '"+facility_id+"' "
							  +"  AND Patient_Id = '"+p_patient_file_no+"'";

			pstmt = con.prepareStatement(strsql);
			rset = pstmt.executeQuery();
			if (rset!=null)
		    {	
			
            _bw.write(_wl_block8Bytes, _wl_block8);

				while(rset.next())
				{				
				code = rset.getString("file_type_code")==null?"":rset.getString("file_type_code");
				desc = rset.getString("short_desc")==null?"":rset.getString("short_desc");
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block11Bytes, _wl_block11);

				}
			}
			}catch(Exception e){out.println("Exception in File Type");}
			finally { if(pstmt!=null)pstmt.close(); if(rset!=null)rset.close();}
			}

			sql = "select b.file_no , b.perm_fs_locn_code,b.curr_file_status from fm_curr_locn b where b.patient_id='"+p_patient_file_no+"' and b.facility_id='"+p_enter_fcy+"'";

			rs = stmt.executeQuery(sql);

		while (rs.next())
		{
			p_file_no = rs.getString("file_no");

			if (rs.getString("perm_fs_locn_code").equals(p_req_fs_locn) && p_enter_fcy.equals(facilityid))
			{
				if (p_display_files.equals(""))
				{
					p_display_files = p_display_files + "" + rs.getString("file_no");
				}
				else
				{
					p_display_files = p_display_files + ","+ rs.getString("file_no");
				}
			}
			else
			{
				p_new_string = p_new_string + "|" + rs.getString("file_no") ;
			}

		}
		if (rs!=null) rs.close();

		sql = "select count(*) rec_cnt from mr_pat_file_index where patient_id='"+p_patient_file_no+"' and facility_id='"+p_enter_fcy+"' and fs_locn_code is not null";

		rs = stmt.executeQuery(sql);

		while (rs.next())
		{
			p_fs_locn_code_cnt = rs.getInt("rec_cnt");
		}
		if (rs!=null) rs.close();

			if (p_fs_locn_code_cnt > 0)
			{

			sql = "SELECT to_char(A.SENT_DATE_TIME,'dd/mm/rrrr hh:mi AM') FROM FM_TRANSIT_FILE A WHERE A.FACILITY_ID='"+p_enter_fcy+"' AND A.FILE_NO='"+p_file_no+"' AND DEST_FACILITY_ID='"+p_enter_fcy+"' AND DEST_FS_LOCN_CODE='"+p_req_fs_locn+"' ";

			rs1 = stmt.executeQuery(sql);

			String p_error_message = "", p_sent_date_time="";
			while (rs1.next())
			{
				p_file_no_found++;			
				p_sent_date_time = rs1.getString(1);
			}		

				if (p_file_no_found ==0)	
				{

					//sql = "SELECT A.REQ_FS_LOCN_DESC || ' (' || A.REQ_FACILITY_NAME || ')', TO_CHAR(A.ADDED_DATE,'DD/MM/RRRR HH:MI AM'),A.REQ_BY_NAME FROM FM_REQ_HDR_VW A, FM_REQ_DTL B WHERE A.REQ_NO=B.REQ_NO AND A.REQ_FS_LOCN_CODE='"+p_req_fs_locn+"' AND A.REQ_FACILITY_ID='"+p_enter_fcy+"' AND B.FILE_NO='"+p_file_no+"' AND B.ISS_YN='N' AND B.CANCEL_YN='N'";
					sql = "SELECT"
									  +"  fm_Get_desc.Fm_storage_locn('"+facility_id+"',a.REQ_FS_LOCN_CODE,'"+localeName+"',2) ||' (' ||sm_Get_desc.SM_FACILITY_PARAM(a.REQ_FACILITY_ID,'"+localeName+"',1) ||')'"
									  +"  , TO_CHAR(A.ADDED_DATE,'DD/MM/RRRR HH:MI AM')"
									  +"  , sm_Get_desc.SM_APPL_USER(A.REQ_USER_ID,'"+localeName+"',1) "
									  +"FROM"
									  +"  FM_REQ_HDR A"
									  +"  , FM_REQ_DTL B "
									  +"WHERE A.REQ_NO = B.REQ_NO "
									  +"  AND A.REQ_FS_LOCN_CODE = '"+p_req_fs_locn+"' "
									  +"  AND A.REQ_FACILITY_ID = '"+p_enter_fcy+"' "
									  +"  AND B.FILE_NO = '"+p_file_no+"' "
									  +"  AND B.ISS_YN = 'N' "
									  +"  AND B.CANCEL_YN = 'N'";


					rs = stmt.executeQuery(sql);

					while (rs.next())
					{
						p_file_no_found++;

						//p_error_message =" File no " + p_file_no + " already requested by " + rs.getString(1) + " on " + rs.getString(2) + " by " + rs.getString(3) ;
						//p_error_message=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"FILE_ALREADY_REQUSTED","fm_messages");

						message = MessageManager.getMessage(localeName,"FILE_ALREADY_REQUSTED","FM");
						p_error_message = (String) message.get("message");


						p_error_message=p_error_message.replace("$",p_file_no);
						p_error_message=p_error_message.replace("#",rs.getString(1));
						p_error_message=p_error_message.replace("~",rs.getString(2));
						p_error_message=p_error_message.replace("%",rs.getString(3));
					}
				}
				else
				{					
					//p_error_message =" File no " + p_file_no + " is already been issued on " + p_sent_date_time  ;
					//p_error_message=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"FILE_ALREADY_ISSUED","fm_messages");

					message = MessageManager.getMessage(localeName,"FILE_ALREADY_ISSUED","FM");
					p_error_message = (String) message.get("message");


					p_error_message=p_error_message.replace("$",p_file_no);
					p_error_message=p_error_message.replace("#",p_sent_date_time);
				}
			
			
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_file_no_found));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(p_error_message));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(p_file_no_found));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(p_new_string));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(p_new_string));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(conc_remarks));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(p_enter_fcy));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(p_req_fs_locn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(fileno_name));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(filetype_name));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(file_no_function));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(file_type_function));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(frame_name));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(form_name));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(volumeno_name));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(p_display_files));
            _bw.write(_wl_block28Bytes, _wl_block28);

			}
			else
			{
				
            _bw.write(_wl_block29Bytes, _wl_block29);

			}
			
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(p_patient_file_no));
            _bw.write(_wl_block31Bytes, _wl_block31);

		}
		else
		{
			if(!p_patient_file_no.equals("null"))
			{
				
            _bw.write(_wl_block32Bytes, _wl_block32);

			}
		}
		
            _bw.write(_wl_block33Bytes, _wl_block33);

		if(rs!=null) rs.close();
		if(rs1!=null) rs1.close();
		if(stmt!=null) stmt.close();	
	}
	catch(Exception e)
	{
	//	out.println("Exception e :"+e);
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	
            _bw.write(_wl_block34Bytes, _wl_block34);
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
