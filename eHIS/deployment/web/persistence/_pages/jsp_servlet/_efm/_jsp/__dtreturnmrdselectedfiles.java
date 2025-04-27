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

public final class __dtreturnmrdselectedfiles extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/DTReturnMRDSelectedFiles.jsp", 1709116823200L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n<head> \n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMReturnMRDFile.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n<BODY onMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey();\'>\n<FORM name = \'fm_select_form\' action=\'../../servlet/eFM.FMParameterServlet\' method=\'post\' target=\'messageFrame\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<script>parent.frames[2].document.getElementById(\"hdr_tab\").style.visibility=\'Visible\';</script>\n<TABLE border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'  id=\"srch_result\">\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<TR>\n\t\t\t<td class=\'columnheader\' colspan = \'7\' ><b><h5><font size=1>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</font></td>\n\t\t</TR>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n        <tr>\n            <td  height=\"20\" colspan=\"7\"  class=\'CAGROUPHEADING\' ><b>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</b></td>\n        </tr>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n        <tr>\n            <td  height=\"20\" colspan=\"7\" class=\'CAGROUPHEADING\'  ><b>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n\t<tr>\n\t<td width=\"28%\"  class=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" >\n\t\t<font size=1><b>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</b>\n\t\t<br><input type=hidden name=file_no";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">&nbsp;";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t</td>\n\t<td width=\"14%\"  class=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"><font size=1>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =",<BR><A HREF CLASS=\"label\" onMouseover=\"changeCursor(this)\" onClick=\"showEncounter(\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\',\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\')\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&nbsp;</A></font><input type=\"Hidden\" name=\"doc_type_code";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" id=\"doc_type_code";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"><input type=\"Hidden\" name=\"volume_no";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" id=\"volume_no";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"></td>\t\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\n\t<!-- <input type=\"Hidden\" name=\"doc_type_code";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"> -->\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t   <a href=\'javascript:GetShowRemarks(\"txtComm";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\",\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\",\"IR\")\'>Remarks</a></font></td>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\n\t<td width=17%  class=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" ><font size=1>\n\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t<br>&nbsp;&nbsp;(";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =")&nbsp;";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t</font></td><td width=\"15%\" align=\"CENTER\" class=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" ><font size=1>\n\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t</font></td>\n\t\t<td width=8% align=\"CENTER\" class=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" ><font size=1>\n\t<a href=\"javascript:GetRemarks(";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =")\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</a>\n\t<input type=\"hidden\" name=\"rem_recnum_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" id=\"rem_recnum_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" value=\"\">\n\t</font></td>\t\n\t\t<td width=\"10%\" align=\'center\' style=\'background-color:";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' class=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'><font size=1>\n\t<input type=checkbox name=\"req_select";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" id=\"req_select";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =" ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" value=\'Y\'>\n\t</font></td></tr>\n\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t<script>\n\t\t\tparent.frames[1].document.forms[0].p_curr_fs_loc.disabled = false;\n\t\t\tparent.frames[1].document.forms[0].FILE_STAT.disabled = false;\n\t\t\tif (parent.frames[2].document.forms[0].file_no != null)\n\t\t\t\tparent.frames[2].document.forms[0].file_no.readOnly = false;\n\t\t\tparent.frames[2].document.forms[0].p_out_fcy.disabled = false;\n\t\t\tparent.frames[2].document.forms[0].FS_LOCN_ID.disabled = false;\n\t\t\tparent.frames[2].document.forms[0].p_out_fsloc.disabled = false;\n\t\t\tparent.frames[2].document.forms[0].Add.disabled = false;\n\t\t\tparent.frames[2].document.forms[0].show_files.disabled = false;\n\t\t\tparent.frames[2].document.forms[0].Clear.disabled = false; \n\t\t\t\n\t</script>\n</TABLE>\n<script>\n\tfor (i=0;i<7;i++)\n\t{\n\t\tif ((document.getElementById(\"srch_result\").rows(i+1) != null) && (document.getElementById(\"srch_result\").rows(i+1).cells(i) != null))\n\t\t{\n\t\t\tparent.frames[2].document.getElementById(\"hdr_tab\").rows(0).cells(i).width = document.getElementById(\"srch_result\").rows(i+1).cells(i).width; \n\t\t}\n\t}\n\n\tvar p_counter = \'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\';\n\n\tif (parseInt(p_counter)==0)\n\t{\n\t\t\talert(getMessage(\'NO_DOC_TO_RETURN\',\'FM\'));\n\t\t\tparent.frames[1].document.forms[0].p_curr_fs_loc.disabled = false;\n\t\t\tparent.frames[1].document.forms[0].FILE_STAT.disabled = false;\n\t\t\tif (parent.frames[2].document.forms[0].file_no != null)\n\t\t\t\tparent.frames[2].document.forms[0].file_no.readOnly = false;\n\t\t\tparent.frames[2].document.forms[0].p_out_fcy.disabled = false;\n\t\t\tparent.frames[2].document.forms[0].FS_LOCN_ID.disabled = false;\n\t\t\tparent.frames[2].document.forms[0].p_out_fsloc.disabled = false;\n\t\t\tparent.frames[2].document.forms[0].Add.disabled = false;\n\t\t\tparent.frames[2].document.forms[0].show_files.disabled = false;\n\t\t\tparent.frames[2].document.forms[0].Clear.disabled = false; \n\t}\n\n\tparent.frames[1].document.forms[0].p_deselect_values.value = \"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\";\n\n\tparent.frames[1].document.forms[0].p_select_values.value = \"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\";\n\tparent.frames[1].document.forms[0].p_total_records.value = \"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\";\n\n\tvar p_in_files\t\t= parent.frames[1].document.forms[0].p_select_values.value;\n\tvar p_not_files\t= parent.frames[1].document.forms[0].p_deselect_values.value;\n\n\tparent.frames[2].document.forms[0].p_total_select.value = \"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\";\n\t\n\tparent.frames[2].document.forms[0].patient_id.value=\"\";\n\tparent.frames[2].document.forms[0].doc_folder_id.value=\"\";\n\tparent.frames[2].document.forms[0].doc_folder_desc.value=\"\";\n\n</script>\n<input type=\'hidden\' name=p_select_values value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\n<input type=\'hidden\' name=p_total_select value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\n\n</FORM>\n</BODY>\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n</HTML>\n\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

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

	Connection con = ConnectionManager.getConnection(request);
	//java.util.Properties p	= (java.util.Properties) session.getValue("jdbc" ) ;
	PreparedStatement pstmt	= null;
	ResultSet rs		= null;

	StringBuffer SelectSqlBuffer	= null;

	String p_select_values		= "";
	String p_concat_string		= "";
	String p_files_not_in		= "";
	int p_count = 0;

try
{	
	SelectSqlBuffer				= new StringBuffer();
	String facilityid 			= (String) session.getValue("facility_id");	
	String p_stored_val			= request.getParameter("p_select_files");	
	String p_not_in_files		= request.getParameter("p_deselect_files");
	String added_volumes		= request.getParameter("added_volumes");
	String p_include_in_select	= request.getParameter("p_include_in_select");
	String curr_fstat			= request.getParameter("curr_fstat");
	String p_outst_fcy			= request.getParameter("p_outst_fcy");
	String p_fs_locn_id			= request.getParameter("p_fs_locn_id");
	String p_out_fsloc			= request.getParameter("p_out_fsloc");
	String file_type_appl_yn	= request.getParameter("file_type_appl_yn");
	
//	String doc_or_file			= request.getParameter("doc_or_file")==null?"":request.getParameter("doc_or_file");	
	
	String p_fs_location = request.getParameter("p_fs_location")==null?"":request.getParameter("p_fs_location");
	if (file_type_appl_yn==null) file_type_appl_yn="N";
	if (p_not_in_files==null) p_not_in_files="";
	if (p_include_in_select==null) p_include_in_select="";
	if (added_volumes==null) added_volumes="";
	if (curr_fstat==null || curr_fstat.equals("null")) curr_fstat="";
	added_volumes = java.net.URLDecoder.decode(added_volumes);
	StringTokenizer token=new StringTokenizer(p_stored_val,"|");

	while(token.hasMoreTokens())
		{
				if (p_count ==0 )
				{
					p_concat_string     = "'" + token.nextToken() +"'";
				}
				else
				{
					p_concat_string     = p_concat_string + ",'" + token.nextToken() +"'";
				}
				p_count++;
		}
		if (p_concat_string.length() == 0) p_concat_string = "''";
		p_count=0;

	if (!p_not_in_files.equals(""))
	{
		StringTokenizer token1=new StringTokenizer(p_not_in_files,"|");
		String getTokenValue="";

		while(token1.hasMoreTokens())
			{
				getTokenValue = token1.nextToken();

					if (p_count ==0 )
					{
						p_files_not_in     = "'" + getTokenValue +"'";
					}
					else
					{
						p_files_not_in     = p_files_not_in + ",'" + getTokenValue +"'";
					}
					p_count++;
			}
	}


		//SelectSqlBuffer.append(" select a.file_no,a.facility_id,a.patient_id,get_patient_line(a.patient_id)patient_line,decode(a.curr_file_status,'I','Inside','O','Outside','L','Lost','T','In Transit','A','Archived')curr_file_status,curr_file_status curr_file_status1,a.curr_fs_locn_code,a.curr_fs_locn_short_desc,decode(a.curr_fs_locn_identity,'D','Department','T','Practitioner','C','Clinic','N','Nursing Unit','X','External','E','Procedure Unit','Y','Daycare Unit')curr_fs_locn_identity,nvl(to_char(a.return_date_time,'dd/mm/rrrr hh24:mi') ,'&nbsp;')return_date_time,DECODE(a.curr_file_status,'I',1,'O',1,'L',3,'T',2,'A',4,'E',2)order_by_status,(CASE WHEN a.curr_facility_id<> a.facility_id THEN '('|| a.curr_facility_name ||')' ELSE '&nbsp;' END )curr_facility_name ,ltrim(rtrim(a.req_remarks))req_remarks,ltrim(rtrim(a.remarks))remarks, a.file_type_desc, a.doc_type_code, a.volume_no,a.doc_folder_id,c.encounter_id, a.doc_folder_name, a.doc_type_name,(CASE WHEN b.PATIENT_PERIOD_SPECIFIC='D' THEN ', ' || TO_CHAR(b.from_period,'dd/mm/rrrr ') || ' - ' || TO_CHAR(b.to_period,'dd/mm/rrrr ')  ELSE ', ' || get_patient_line(b.patient_id) END)doc_type from fm_curr_locn_vw a, fm_doc_folder b,FM_ENCOUNTER_DOC_TYPE_LINK c where a.mr_pat_fs_locn_code = '"+p_fs_location+"' ");
		SelectSqlBuffer.append("SELECT a.File_No,");
		SelectSqlBuffer.append("        a.Facility_Id,");
		SelectSqlBuffer.append("        a.Patient_Id,");
		SelectSqlBuffer.append("        Get_patient_line(a.Patient_Id,'"+localeName+"') Patient_Line,");
		SelectSqlBuffer.append("        Curr_File_Status Curr_File_Status1,");
		SelectSqlBuffer.append("        a.Curr_fs_Locn_Code,");
		SelectSqlBuffer.append("        a.Curr_fs_Locn_Short_desc,");
		SelectSqlBuffer.append("        a.Curr_fs_Locn_Identity,");
		SelectSqlBuffer.append("        Nvl(To_char(a.Return_Date_Time,'dd/mm/rrrr hh24:mi'),");
		SelectSqlBuffer.append("            '&nbsp;') Return_Date_Time,");
		SelectSqlBuffer.append("        DECODE(a.Curr_File_Status,'I',1,");
		SelectSqlBuffer.append("                                  'O',1,");
		SelectSqlBuffer.append("                                  'L',3,");
		SelectSqlBuffer.append("                                  'T',2,");
		SelectSqlBuffer.append("                                  'A',4,");
		SelectSqlBuffer.append("                                  'E',2) Order_By_Status,");
		SelectSqlBuffer.append("        (CASE ");
		SelectSqlBuffer.append("           WHEN a.Curr_Facility_Id <> a.Facility_Id THEN '('");
		SelectSqlBuffer.append("                                                         ||a.Curr_Facility_Name");
		SelectSqlBuffer.append("                                                         ||')'");
		SelectSqlBuffer.append("           ELSE '&nbsp;'");
		SelectSqlBuffer.append("         END) Curr_Facility_Name,");
		SelectSqlBuffer.append("        Ltrim(Rtrim(a.req_Remarks)) req_Remarks,");
		SelectSqlBuffer.append("        Ltrim(Rtrim(a.Remarks)) Remarks,");
		SelectSqlBuffer.append("        a.File_Type_desc,");
		SelectSqlBuffer.append("        a.Doc_Type_Code,");
		SelectSqlBuffer.append("        a.Volume_No,");
		SelectSqlBuffer.append("        a.Doc_Folder_Id,");
		SelectSqlBuffer.append("        c.Encounter_Id,");
		SelectSqlBuffer.append("        a.Doc_Folder_Name,");
		SelectSqlBuffer.append("        a.Doc_Type_Name,");
		SelectSqlBuffer.append("        (CASE ");
		SelectSqlBuffer.append("           WHEN b.Patient_Period_Specific = 'D' THEN ', '");
		SelectSqlBuffer.append("                                                     ||To_char(b.From_Period,'dd/mm/rrrr ')");
		SelectSqlBuffer.append("                                                     ||' - '");
		SelectSqlBuffer.append("                                                     ||To_char(b.To_Period,'dd/mm/rrrr ')");
		SelectSqlBuffer.append("           ELSE ', '");
		SelectSqlBuffer.append("                ||Get_patient_line(b.Patient_Id,'"+localeName+"')");
		SelectSqlBuffer.append("         END) Doc_Type");
		SelectSqlBuffer.append(" FROM   ");
		SelectSqlBuffer.append("   fm_Curr_Locn_vw a,");
		SelectSqlBuffer.append("   fm_Doc_Folder b,");
		SelectSqlBuffer.append("   fm_Encounter_Doc_Type_Link c");
		SelectSqlBuffer.append(" WHERE  a.mr_Pat_fs_Locn_Code = '"+p_fs_location+"' ");
		if(!p_stored_val.equals(""))
		{
			SelectSqlBuffer.append("AND a.file_no in ("+p_concat_string+") ");
		}
		if (!added_volumes.equals(""))
		{
			SelectSqlBuffer.append("AND a.volume_no in ("+added_volumes+") ");
		}
		if (!curr_fstat.equals("S"))
		{
			SelectSqlBuffer.append("AND a.CURR_FILE_STATUS='"+curr_fstat+"' ");
		}
		SelectSqlBuffer.append( " and a.facility_id='"+facilityid+"' AND a.doc_folder_id=b.doc_folder_id and a.facility_id = c.facility_id and a.file_no = c.file_no AND a.facility_id=b.facility_id and a.curr_facility_id = '"+p_outst_fcy+"' AND a.curr_fs_locn_identity = decode('"+p_fs_locn_id+"','',a.curr_fs_locn_identity,'"+p_fs_locn_id+"') AND a.curr_fs_locn_code =decode('"+p_out_fsloc+"','',a.curr_fs_locn_code,'"+p_out_fsloc+"') AND a.doc_folder_id is not null ORDER BY order_by_status,a.curr_fs_locn_code,a.file_no ");
	pstmt	= con.prepareStatement(SelectSqlBuffer.toString());
	rs		= pstmt.executeQuery();


            _bw.write(_wl_block8Bytes, _wl_block8);

int i = 0;
int p_rec_cnt = 0;

String classValue="";
String bgcolor="";
String p_allow_select="";
String p_checked="";
int p_return_cnt=0;
int p_not_return_cnt=0;
int counter=0;

String file_type_desc	=	"";
String doc_type_code	=	"";
String volume_no		=	"";
String p_first_curr_fs_locn_code="";

String doc_folder_id = "", doc_folder_name = "", doc_type_name = "", doc_type="";

while ( rs.next() )
{
	if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;

	if (rs.getString("curr_file_status1").equals("A"))
	{
		bgcolor			= "gold";
		p_allow_select	= "disabled";
		p_checked		= "";
	}
	else if (rs.getString("curr_file_status1").equals("T"))
	{
		bgcolor = "darkseagreen";
		p_allow_select	= "disabled";
		p_checked		= "";
	}
	else if (rs.getString("curr_file_status1").equals("L"))
	{
		bgcolor = "mediumvioletred";
		p_allow_select	= "disabled";
		p_checked		= "";
	}
	else if (rs.getString("curr_file_status1").equals("E"))
	{
		bgcolor = "cyan";
		p_allow_select	= "";
		p_checked		= "checked";
	}
	else if (rs.getString("curr_file_status1").equals("I"))
	{
		bgcolor = "E0FFFF";
		p_allow_select	= "";
		p_checked		= "";
	}
	else if (rs.getString("curr_file_status1").equals("O"))
	{
		bgcolor = "sandybrown";
		p_allow_select	= "disabled";
		p_checked		= "";
	}
	else if (rs.getString("curr_file_status1").equals("R"))
	{
		bgcolor = "#C0C0C0";
		p_allow_select	= "";
		p_checked		= "checked";
	}
	else
	{
		bgcolor = "";
		p_allow_select	= "";
		p_checked		= "";
	}

	if (rs.getString("curr_file_status1").equals("I") || rs.getString("curr_file_status1").equals("O") )
	{
		if (p_return_cnt==0)
		{

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
		}
		p_return_cnt++;

	}
	
	if (rs.getString("curr_file_status1").equals("L") || rs.getString("curr_file_status1").equals("A") || rs.getString("curr_file_status1").equals("T"))
	{
		if (p_not_return_cnt==0)
		{
			if (p_return_cnt>0)
			{

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

			}
			else
			{

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

			}
		}

		p_not_return_cnt++;
	}
	String curr_fs_locn_identity = rs.getString("curr_fs_locn_identity") ;
	String curr_fs_locn_ident_desc = "";
	switch(curr_fs_locn_identity.charAt(0))
	{
		case 'D' : curr_fs_locn_ident_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels"); 
			break;
		case 'T' : curr_fs_locn_ident_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); 
			break;
		case 'C' : curr_fs_locn_ident_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); break;
		case 'N' : curr_fs_locn_ident_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); break;
		case 'X' : curr_fs_locn_ident_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;
		case 'E' : curr_fs_locn_ident_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"); break;
		case 'Y' : curr_fs_locn_ident_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); break;
		default : curr_fs_locn_ident_desc = "";
	}
      if (counter==0)
           {
                p_first_curr_fs_locn_code = rs.getString("curr_fs_locn_code");

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(rs.getString("curr_fs_locn_short_desc")+" ( " + curr_fs_locn_ident_desc +") "));
            _bw.write(_wl_block12Bytes, _wl_block12);

            }
        else if (!p_first_curr_fs_locn_code.equals(rs.getString("curr_fs_locn_code")))
            {

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(rs.getString("curr_fs_locn_short_desc")+" ( " + curr_fs_locn_ident_desc +") "));
            _bw.write(_wl_block12Bytes, _wl_block12);

            }

        counter++ ;

        if ( counter % 2 == 0 )
            classValue = "QRYODD" ;
        else
            classValue = "QRYEVEN" ;


		String tempstr = rs.getString("patient_line").substring(0,rs.getString("patient_line").length()-6);
		String patient_id ="";
		StringTokenizer st = new StringTokenizer(tempstr, ",");
		st.nextToken();
		st.nextToken();
		st.nextToken();
		patient_id = st.nextToken();
		file_type_desc  = rs.getString("file_type_desc");
		doc_type_code  = rs.getString("doc_type_code");
		volume_no  = rs.getString("volume_no");
		if ((file_type_desc==null)||(file_type_desc.equals(""))) file_type_desc = "&nbsp;";
		else file_type_desc =file_type_desc + " / ";
		if (doc_type_code==null) file_type_desc = "";
		if (volume_no==null) volume_no = "";
		doc_folder_id = rs.getString("doc_folder_id")==null?"&nbsp;":rs.getString("doc_folder_id");
		doc_folder_name = rs.getString("doc_folder_name")==null?"&nbsp;":rs.getString("doc_folder_name");
		doc_type_name = rs.getString("doc_type_name")==null?"&nbsp;":rs.getString("doc_type_name");
		doc_type = rs.getString("doc_type")==null?"&nbsp;":rs.getString("doc_type");		

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(doc_folder_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( rs.getString("file_no") ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(doc_folder_name));
            out.print( String.valueOf(doc_type));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(doc_type_name));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rs.getString("ENCOUNTER_ID")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rs.getString("PATIENT_ID")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rs.getString("FILE_NO")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rs.getString("PATIENT_ID")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(doc_type_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block29Bytes, _wl_block29);

		

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(doc_type_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block31Bytes, _wl_block31);

	String p_iss_remarks = rs.getString("remarks");

	out.println("<td align='CENTER' class='"+classValue+"' width='8%'><font size=1>");

	if (p_iss_remarks == null)
	{
		out.println("&nbsp;</font></td>");
	}
	else
	{

            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(p_iss_remarks));
            _bw.write(_wl_block34Bytes, _wl_block34);
					
	}

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf( rs.getString("curr_fs_locn_short_desc") ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf( curr_fs_locn_ident_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rs.getString("curr_facility_name")));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(rs.getString("return_date_time")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bgcolor));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(p_checked));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(p_allow_select));
            _bw.write(_wl_block52Bytes, _wl_block52);


	if (p_select_values=="")
	{
		p_select_values = rs.getString("file_no")+'`'+rs.getString("facility_id");
	}
	else
	{
		p_select_values = p_select_values + '|' + rs.getString("file_no")+'`'+rs.getString("facility_id");
	}
	i++;
	p_rec_cnt++;

	p_first_curr_fs_locn_code = rs.getString("curr_fs_locn_code");
  } //endwhile



            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(p_not_in_files));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(p_stored_val));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(p_rec_cnt));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(p_rec_cnt));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(p_select_values));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(p_rec_cnt));
            _bw.write(_wl_block60Bytes, _wl_block60);

if(rs!=null)	rs.close();
if(pstmt!=null) pstmt.close();
}
catch(Exception e)
{}
finally
{	
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block61Bytes, _wl_block61);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.DocumentstobeReturned.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.DocumentscannotbeReturned.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.DocumentscannotbeReturned.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }
}
