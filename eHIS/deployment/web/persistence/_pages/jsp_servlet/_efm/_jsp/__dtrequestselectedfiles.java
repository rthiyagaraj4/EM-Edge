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

public final class __dtrequestselectedfiles extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/DTRequestSelectedFiles.jsp", 1741319269163L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n?<!--\n\tCreated On\t: 9/15/2004\n\tCreated By\t: Kiran K K.\n\tModule\t\t: Document Tracking (DT)\n\tFunction\t: Request of Document\n\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n<head>\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMRequestFile.js\'></script>\n</head>\n\n<BODY onMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey();\'>\n<FORM name = \'fm_select_form\' method=\'get\' target=\'messageFrame\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<TABLE border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'left\' id=\"srch_result\">\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<script>parent.frames[3].document.getElementById(\"hdr_tab\").style.visibility=\'Visible\';</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<TR>\n\t\t\t<Td colspan = \'9\' class=\'columnheader\'><b><h5><font size=1>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&nbsp;";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</font></Td>\n\t\t</TR>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n\t<tr>\n\n\t<td width=\"15%\"  class=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" ><input type=hidden name=p_file_no";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" value=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="`";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =">&nbsp;<input type=hidden name=p_doc_folder_id";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="><input type=hidden name=p_doc_type_code";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="><font size=1><b>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</b><br>&nbsp;";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</font></td>\n\t<td width=\"8%\"  class=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" ><font size=1>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="<input type=\'hidden\' name=\"file_type";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"file_type";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"><input type=\'hidden\' name=\"p_volume_no";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" id=\"p_volume_no";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"><input type=\'hidden\' name=\"p_patient_id";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" id=\"p_patient_id";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"></font></td>\n\t<td width=\"14%\"  class=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" ><font size=1><A HREF CLASS=\"label\" onMouseover=\"changeCursor(this)\" onClick=\"callPatDetails(\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\')\">&nbsp;";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&nbsp;</A><BR>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</font></td>\n\t<td width=\"12%\"  class=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" ><font size=1><A HREF CLASS=\"label\" onMouseover=\"changeCursor(this)\" onClick=\"showEncounter(\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\',\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</A></font></td>\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t</font></td><td width=\'8%\' align=\"CENTER\" class=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"><font size=1><a href=\"javascript:GetRemarks(";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =")\">";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</a></font></td><td width=\'13%\'  class=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"><font size=1><input type=\"hidden\" name=\"rem_recnum_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" id=\"rem_recnum_";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" value=\"\">\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t</font></td><td width=\'8%\' align=\"CENTER\" class=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</a></font></td><td width=\"13%\"  class=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t</font></td><td width=\"8%\" class=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"><font size=1>&nbsp;&nbsp;</font></td><td width=\"13%\"  class=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</font></td><td width=\'13%\'  class=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"><font size=1>\n\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" <br> &nbsp;&nbsp;(";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =")\n\t</font></td><td width=\'9%\'  class=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =" <br>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t</font></td><td width=\'8%\' align=\"center\" style=\"background-color:";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" class=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\"><font size=1>\n\t<input type=checkbox name=req_select";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =" value=\"Y\">\n\t</font></td></tr>\n\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n</TABLE>\n<script>\n//\tparent.frames[3].document.forms[0].p_patient_id.value=\"\";\n//\tparent.frames[3].document.forms[0].doc_folder_id.value=\"\";\n//\tparent.frames[3].document.forms[0].doc_folder_desc.value=\"\";\n\n\tparent.frames[3].document.forms[0].p_deselect_values.value = \"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\";\n\tvar old_value = parent.frames[3].document.forms[0].added_values.value;\n\tif (old_value != \"\")\n\t\told_value += \"|\"+\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\";\n\telse old_value = \"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\";\n\tparent.frames[3].document.forms[0].added_values.value=old_value;\n\tparent.frames[3].document.forms[0].p_select_values.value = \"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\";\n\tparent.frames[3].document.forms[0].p_total_records.value = \"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\";\n\n\tvar p_in_files\t\t= parent.frames[3].document.forms[0].p_select_values.value;\n\tvar p_not_files\t= parent.frames[3].document.forms[0].p_deselect_values.value;\n\n\tHTMLVal = \"<html><BODY onKeyDown = \'lockKey()\'><form name=\'form2\' id=\'form2\' method=\'post\' action=\'../../eFM/jsp/FMRequestDeSelectedFiles.jsp\'><input name=\'p_new_string\' id=\'p_new_string\' type=\'hidden\' value=\"+p_in_files+\"><input name=\'p_deselect_files\' id=\'p_deselect_files\' type=\'hidden\' value=\"+p_not_files+\"></form></BODY></HTML>\";\n\n\tparent.frames[3].document.forms[0].p_total_select.value = \'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\';\n\tfor (i=0;i<7;i++)\n\t{\n\t\tif ((document.getElementById(\"srch_result\").rows(i+1) != null) && (document.getElementById(\"srch_result\").rows(i+1).cells(i) != null))\n\t\t{\n\t\t\tparent.frames[3].document.getElementById(\"hdr_tab\").rows(0).cells(i).width = document.getElementById(\"srch_result\").rows(i+1).cells(i).width; \n\t\t}\n\t}\n\n</script>\n<input type=\'hidden\' name=p_select_values value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>\n<input type=\'hidden\' name=p_total_select value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>\n\n</FORM>\n</BODY>\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n</HTML>\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );


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

	Connection con = ConnectionManager.getConnection(request);
//	java.util.Properties p	= (java.util.Properties) session.getValue("jdbc" ) ;
	Statement stmt		= null;	
	ResultSet rs		= null;
	
try
{

	stmt						= con.createStatement();
	StringBuffer SelectSqlBuffer = null;
	SelectSqlBuffer				 = new StringBuffer();	
	String p_stored_val			= request.getParameter("p_select_files");	
//	out.println("<script language='JavaScript'>alert('p_stored_val"+p_stored_val+"');</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>");
	String p_not_in_files		= request.getParameter("p_deselect_files");
	String p_include_in_select	= request.getParameter("p_include_in_select");
	String p_enter_fcy			= request.getParameter("p_enter_fcy");
	String p_req_fs_locn		= request.getParameter("p_req_fs_locn");
	String conc_remarks		 	= request.getParameter("conc_remarks");
	String added_volumes	 	= request.getParameter("added_volumes");
	String file_type_appl_yn 	= request.getParameter("file_type_appl_yn");
	if(added_volumes==null)  added_volumes = "";
	if(file_type_appl_yn==null)  added_volumes = "N";
	conc_remarks = java.net.URLDecoder.decode(conc_remarks);
	added_volumes = java.net.URLDecoder.decode(added_volumes);
	HashMap hash	= new HashMap();

	if (!(conc_remarks.equals(null) || conc_remarks==null || conc_remarks.equals("null")  )) {
		StringTokenizer st = new StringTokenizer(conc_remarks, "`");

		while(st.hasMoreTokens()) {
			hash.put(st.nextToken(), st.nextToken());

		}
	}

	String p_select_values		= "";
	String p_added_values		= "";
	String p_concat_string		= "";
	String p_files_not_in		= "";
	int p_count = 0;	

	if (p_not_in_files==null) p_not_in_files="";
	if (p_include_in_select==null) p_include_in_select="";
	if (p_req_fs_locn==null) p_req_fs_locn="";

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

		SelectSqlBuffer.append("select a.file_no,a.facility_id,a.patient_id,  a.fs_locn_short_desc, decode(a.curr_file_status,'I','Inside','O','Outside','L','Lost','T','In Transit','A','Archived','E','Other Facility', 'R', 'Returned')curr_file_status,(case when a.curr_fs_locn_code = '"+p_req_fs_locn+"' then 'X' else a.curr_file_status end)curr_file_status1, a.curr_fs_locn_short_desc, decode(a.curr_fs_locn_identity,'D','Department','T','Practitioner','C','Clinic','N','Nursing Unit','E','Procedure Unit','Y','Daycare Unit')curr_fs_locn_identity, (CASE WHEN a.curr_fs_locn_code = '"+p_req_fs_locn+"' THEN  6 ELSE  DECODE(a.curr_file_status,'I',1,'O',1,'L',4,'T',2,'A',5,'E',3) END) order_by_status, (case when a.curr_facility_id <> '"+p_enter_fcy+"' then '(' || a.curr_facility_name || ')' else '&nbsp;' end)other_facility_name, a.volume_no, a.file_type_code,  a.doc_folder_id doc_folder_id, a.doc_folder_name, a.doc_type_name, a.doc_type_code, (CASE WHEN b.PATIENT_PERIOD_SPECIFIC='D' THEN ', ' || TO_CHAR(b.from_period,'dd/mm/rrrr ')|| ' - ' || TO_CHAR(b.to_period,'dd/mm/rrrr ')  ELSE ', ' || decode('"+localeName+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) END)doc_type ,c.encounter_id,a.patient_name FROM fm_curr_locn_vw a,fm_doc_folder b,FM_ENCOUNTER_DOC_TYPE_LINK c where a.file_no in("+p_concat_string+") ");	
		SelectSqlBuffer.append(" and a.doc_folder_id = b.doc_folder_id(+) and a.facility_id = b.facility_id(+) and a.facility_id = c.facility_id and a.file_no = c.file_no and a.facility_id='"+p_enter_fcy+"' order by order_by_status,a.file_no ");
	
	rs = stmt.executeQuery(SelectSqlBuffer.toString());


            _bw.write(_wl_block8Bytes, _wl_block8);

int i = 1;
int p_rec_cnt = 0;

String classValue="";
String bgcolor="";
String p_allow_select="";
String p_checked="";
int p_request_cnt=0;
int p_not_request_cnt=0;
String doc_folder_id = "", doc_folder_name = "", doc_type_name = "", doc_type="", doc_type_code = "";
String doc_patient = "";
String encounter_id = "";
String patient_name = "";
String doc_file_no = "";

            _bw.write(_wl_block9Bytes, _wl_block9);



while ( rs.next() )
{
	if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;
	if (rs.getString("curr_file_status1").equals("A"))
	{
		bgcolor			= "FFEECC";
		p_allow_select	= "disabled";
		p_checked		= "";
	}
	else if (rs.getString("curr_file_status1").equals("T"))
	{
		bgcolor = "CCEEDD";
		p_allow_select	= "";
		p_checked		= "";

	}
	else if (rs.getString("curr_file_status1").equals("L"))
	{
		bgcolor = "FFFFEE";
		p_allow_select	= "disabled";
		p_checked		= "";

	}
	else if (rs.getString("curr_file_status1").equals("X"))
	{
		bgcolor = "ADD8E6";
		p_allow_select	= "disabled";
		p_checked		= "";
	}
	else if (rs.getString("curr_file_status1").equals("E"))
	{
		bgcolor = "E0FFFF";
		p_allow_select	= "";
		p_checked		= "";
	}
	else if (rs.getString("curr_file_status1").equals("O"))
	{
		bgcolor = "#D1BBA7";
		p_allow_select	= "";
		p_checked		= "";
	}
	else if (rs.getString("curr_file_status1").equals("R"))
	{
		bgcolor = "#C0C0C0";
		p_allow_select	= "disabled";
		p_checked		= "";
	}
	else
	{
		bgcolor = "";
		p_allow_select	= "";
		p_checked		= "";
	}
	doc_folder_id = checkForNull(rs.getString("doc_folder_id"));
	doc_folder_name = checkForNull(rs.getString("doc_folder_name"));
	doc_type_name = checkForNull(rs.getString("doc_type_name"));
	doc_type = checkForNull(rs.getString("doc_type"));
	doc_type_code = checkForNull(rs.getString("doc_type_code"));
	doc_patient = checkForNull(rs.getString("patient_id"));
	encounter_id = checkForNull(rs.getString("encounter_id"));
	patient_name = checkForNull(rs.getString("patient_name"));
	doc_file_no = checkForNull(rs.getString("file_no"));


		
	if (rs.getString("curr_file_status1").equals("I") || rs.getString("curr_file_status1").equals("O") || rs.getString("curr_file_status1").equals("T"))
	{
		if (p_request_cnt==0)
		{

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
		}
		p_request_cnt++;

	}

	if (rs.getString("curr_file_status1").equals("L") || rs.getString("curr_file_status1").equals("A"))
	{
		if (p_not_request_cnt==0)
		{
			if (p_request_cnt>0)
			{

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

			}
			else
			{

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

			}
		}

		p_not_request_cnt++;
	}


            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( rs.getString("file_no") ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rs.getString("facility_id") ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(doc_folder_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(doc_type_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(doc_folder_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(doc_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(doc_type_name));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( rs.getString("file_type_code")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rs.getString("volume_no")));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rs.getString("patient_id")));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(doc_patient));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(doc_patient));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(doc_patient));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(doc_file_no));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block37Bytes, _wl_block37);

	
	if (rs.getString("curr_file_status1").equals("I") || rs.getString("curr_file_status1").equals("T") ||rs.getString("curr_file_status1").equals("O")) {
		if (conc_remarks.equals(null) || conc_remarks==null || conc_remarks.equals("null") || conc_remarks.equals("") ) {

            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block44Bytes, _wl_block44);

		}
		else {
			String tempstr = (String)hash.get(rs.getString("file_no")) ;
			if (tempstr == null || tempstr.equals(":|:")) tempstr = "";

            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( tempstr ));
            _bw.write(_wl_block47Bytes, _wl_block47);

		}
	}
	else {

            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);

	}

            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf( rs.getString("fs_locn_short_desc") ));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf( rs.getString("curr_fs_locn_short_desc") ));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf( rs.getString("curr_fs_locn_identity") ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf( (rs.getString("curr_file_status")==null)?"&nbsp;":rs.getString("curr_file_status") ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf( rs.getString("other_facility_name") ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf( bgcolor ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf( classValue ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf( p_checked ));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf( p_allow_select ));
            _bw.write(_wl_block60Bytes, _wl_block60);

	if (p_select_values=="")
	{
		p_select_values = rs.getString("file_no")+'`'+rs.getString("facility_id");
	}
	else
	{
		p_select_values = p_select_values + '|' + rs.getString("file_no")+'`'+rs.getString("facility_id");
	}
	if (p_added_values=="")
	{
		p_added_values = rs.getString("file_no")+"$$"+rs.getString("volume_no");
	}
	else
	{
		p_added_values = p_added_values + '|' + rs.getString("file_no")+"$$"+rs.getString("volume_no");
	}
	i++;
	p_rec_cnt++;

  } //endwhile



            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(p_not_in_files));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(p_added_values));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(p_added_values));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(p_stored_val));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(p_rec_cnt));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(p_rec_cnt));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(p_select_values));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(p_rec_cnt));
            _bw.write(_wl_block69Bytes, _wl_block69);

	if((SelectSqlBuffer != null) && (SelectSqlBuffer.length() > 0))
	{
		SelectSqlBuffer.delete(0,SelectSqlBuffer.length());
	}
	if(stmt!=null) stmt.close();
	if(rs!=null)	rs.close();
}
catch(Exception e)
{}
finally
{	
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block70Bytes, _wl_block70);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Requested.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.documents.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.Documentscannotberequested.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.Documentscannotberequested.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }
}
