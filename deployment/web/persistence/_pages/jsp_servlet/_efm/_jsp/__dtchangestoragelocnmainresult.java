package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __dtchangestoragelocnmainresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/DTChangeStorageLocnMainResult.jsp", 1709116817122L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--  by Meghanath\t-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n<HEAD>\n\t<!-- <LINK rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></LINK> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n\t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/common.js\'></SCRIPT>\n\t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></SCRIPT>\n\t<SCRIPT language=\'javascript\' src=\'../../eFM/js/FMChangeStorageLocn.js\'></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\n</HEAD>\n<BODY  onLoad=\'dispRecord(); loadCurrPage();\' onMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey();\'>\n<FORM name=\'FMChngStrLocnMainResultForm\' id=\'FMChngStrLocnMainResultForm\' action=\'\' method=\'\'>\n<P>\n<TABLE align=\'right\'>\n<tr>\n<td>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<A HREF=\'../jsp/FMChangeStorageLocnMainResult.jsp?from=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&to=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&mode=Previous\' onClick=\'checkVal();\' text-decoration=\'none\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</A>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&mode=next\' onClick=\'checkVal();\' text-decoration=\'none\' >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</td>\n</tr>\n</TABLE>\n\t<br><br>\n</P>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<SCRIPT>\n\t\t\n\t\t\tvar msg =\tgetMessage(\'NO_RECORDS_FOUND\',\'FM\');\n\t\t\tif(msg!=\"\")\n\t\t\t{\n\t\t\t\tparent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg+\"&err_value=0\";\n\t\t\t}\n\t\t\tparent.FMChngStrLocnSubResultFrame.document.FMChngStrLocnSubResultForm.locn_code.disabled = \"true\";\n\t\t</SCRIPT>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n<TABLE cellpadding=\'0\' cellspacing=\'0\' border=\'1\' width=\'100%\'>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t<td class=\'columnheader\' width=\'40%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t<td class=\'columnheader\' width=\'8%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t<td class=\'columnheader\' width=\'12%\' nowrap>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="<br>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t<td class=\'columnheader\' width=\'12%\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t<td class=\'columnheader\' width=\'6%\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="?</td>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t<tr id=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' ><FONT size=\'1\'><B>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</B></FONT><BR>&nbsp;&nbsp;<FONT size=\'1\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</FONT>&nbsp;&nbsp;<font size=\'1\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</font></td>\n\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' ><FONT \tsize=\'1\'><CENTER>\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</CENTER></FONT></td>\n\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' ><FONT size=\'1\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</FONT></td>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' align=\'center\'><SELECT name=\'fs_locn_code";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' id=\'fs_locn_code";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" onChange=\'checkAssign(this, \"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\");\' onFocus=\'assignOnFocus(this);\'>\n\t\t\t<OPTION value=\'\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</OPTION>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\t\t\t</SELECT><INPUT type=\'hidden\' name=\'default_code";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' id=\'default_code";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'></td>\n\t\t\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' align=\'center\'><INPUT type=\'checkbox\' name=\'associate_yn";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' id=\'associate_yn";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" value=\'Y\' ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" onClick=\'CBValue(this,\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\");\'></td>\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t<SCRIPT>\t\t\t\n\t\t\t\tparent.frames[0].document.forms[0].fs_locn_code.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].storage_locn.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].search_dtl.disabled=false;\n\t\t\t\tparent.frames[0].document.forms[0].reset1.disabled=false;\n\t\t\t</SCRIPT>\t\t\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n</TABLE>\n<INPUT type=\'hidden\' name=\'row_count\' id=\'row_count\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n<INPUT type=\'hidden\' name=\'fm_disp\' id=\'fm_disp\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n<INPUT type=\'hidden\' name=\'to_disp\' id=\'to_disp\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n<INPUT type=\'hidden\' name=\'fs_locn\' id=\'fs_locn\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n</FORM>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n</BODY>\n</HTML>\n\n\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );
 int row_count=0; 

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet recordSet= null;synchronized(session){
                recordSet=(webbeans.eCommon.RecordSet)pageContext.getAttribute("recordSet",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(recordSet==null){
                    recordSet=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("recordSet",recordSet,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	Connection con		=	null;
	java.sql.Statement stmt		=	null;
	java.sql.Statement stmt1		=	null;
	java.sql.Statement stmt2		=	null;
	ResultSet rs		=	null;
	ResultSet rs1		=	null;
	HashMap htRecord	=	null;

	String file_no="", patient_id="",  associate_yn="N",associate_yn_prop="", tblrow_id="",classValue="",fs_locn_code="",fs_desc="",fn_locn_code="";
	String locn_identity="", narration_code="", holder_name="",fs_locn_disp="";
	String result_query="", header="", fs_locn="",mr_pat_fs_locn_desc="", curr_fs_locn_desc="";
	String other_locn_code="",curr_fs_locn_identity="",	curr_holder_name="",curr_mr_locn_yn="",mr_locn_yn="";
	String file_type_code = "",volume_no = "";
	String dissable_attribute = "";
	String sql_query = "";
	
	String docline			= "";
	String doc_folder_id	= "";
	String doc_folder_name	= "";
	String doc_type_code	= "";
	String doc_type_name	= "";


	
	try
	{
		con		=	ConnectionManager.getConnection(request);
		stmt	=	con.createStatement();
		stmt1	=	con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

	//	int row_disp	= 7;
		int start		= 0;
		int end			= 0;
		int fm_disp=0, to_disp = 0;
		
		String facility_id			=   (String)session.getValue("facility_id");	
		String from					=	request.getParameter("from");
		String to					=	request.getParameter("to");
		String mode					=	request.getParameter("mode");
		patient_id					=	request.getParameter("patient_id");
		file_type_code				=	request.getParameter("file_type_code");
		
		if(mode == null || mode.equals("null")) 
			mode="";
	   if ( from == null )
		start = 1 ;
		else
		start = Integer.parseInt( from );
		if ( to == null )
	  		end = 7 ;
		else
			end = Integer.parseInt( to );
		if(mode.equals(""))
		{
			String str=request.getParameter("whereClause");
			if(str==null)str="";
			fs_locn	=	request.getParameter("fs_locn");
			if(fs_locn==null)fs_locn="P";
			if(!(str.equals(""))) recordSet.clearAll();
			if(str==null)str="";
			else str = str.replace('~','%');
						
			if(fs_locn.equals("P"))
			{
				result_query ="select a.file_no,a.patient_id, a.doc_folder_id,a.doc_folder_name,a.doc_type_code,a.doc_type_name,a.volume_no,(CASE WHEN b.patient_period_specific='D' THEN ' ' || TO_CHAR(b.from_period,'dd/mm/rrrr ') || ' - ' || TO_CHAR(b.to_period,'dd/mm/rrrr ') ELSE  ', ' || GET_PATIENT_LINE(b.PATIENT_ID,'"+localeName+"') END) docline,a.file_type_code,a.volume_no, a.mr_pat_fs_locn_code fs_locn_code, a.curr_fs_locn_code other_locn,a.mr_pat_locn_short_desc mr_pat_fs_locn_desc, a.curr_fs_locn_short_desc curr_fs_locn_desc, a.curr_fs_locn_identity, a.curr_holder_name, a.mr_locn_yn FROM fm_curr_locn_vw a,fm_doc_folder b WHERE a.facility_id='"+facility_id+"' AND a.doc_folder_id = b.doc_folder_id(+) and a.facility_id = b.facility_id(+) " + str;
			}
			else
			{
				result_query="select a.file_no,a.patient_id, a.doc_folder_id,a.doc_folder_name,a.doc_type_code,a.doc_type_name,a.volume_no,(CASE WHEN b.patient_period_specific='D' THEN ' ' || TO_CHAR(b.from_period,'dd/mm/rrrr ') || ' - ' || TO_CHAR(b.to_period,'dd/mm/rrrr ')  ELSE b.patient_id END) docline, a.file_type_code,a.volume_no,a.curr_fs_locn_code fs_locn_code, a.mr_pat_fs_locn_code other_locn, a.mr_pat_locn_short_desc mr_pat_fs_locn_desc, a.curr_fs_locn_short_desc curr_fs_locn_desc, a.curr_fs_locn_identity, a.curr_holder_name, a.mr_locn_yn FROM fm_curr_locn_vw a,fm_doc_folder b WHERE a.facility_id='"+facility_id+"' AND a.doc_folder_id = b.doc_folder_id(+) AND a.facility_id = b.facility_id(+) " +  str;
			}
			rs=stmt.executeQuery(result_query);
			associate_yn="N";
			if(rs != null)
			{
				while(rs.next())
				{
					docline					=	rs.getString("docline");
					file_no					=	rs.getString("file_no");
					patient_id				=	rs.getString("patient_id");
					doc_folder_id			=	rs.getString("doc_folder_id");
					doc_folder_name			=	rs.getString("doc_folder_name");
					doc_type_code			=	rs.getString("doc_type_code");
					doc_type_name			=	rs.getString("doc_type_name");	
					volume_no				=	rs.getString("volume_no");
					fs_locn_disp			=	rs.getString("fs_locn_code");
					other_locn_code			=	rs.getString("other_locn");
					mr_pat_fs_locn_desc		=	rs.getString("mr_pat_fs_locn_desc");
					curr_fs_locn_desc		=	rs.getString("curr_fs_locn_desc");
					curr_fs_locn_identity	=	rs.getString("curr_fs_locn_identity");
					curr_holder_name		=	rs.getString("curr_holder_name");
					curr_mr_locn_yn			=	rs.getString("mr_locn_yn");
					
					if(docline == null || docline.equals("null"))docline="&nbsp;";
					if(file_no == null || file_no.equals("null"))file_no="";
					if(patient_id == null || patient_id.equals("null"))patient_id="";
					if(doc_folder_id == null || doc_folder_id.equals("null"))doc_folder_id="";
					if(doc_folder_name == null || doc_folder_name.equals("null"))doc_folder_name="";
					if(doc_type_code == null || doc_type_code.equals("null"))doc_type_code="";
					if(doc_type_name == null || doc_type_name.equals("null"))doc_type_name="";				
					if(volume_no == null || volume_no.equals("null"))volume_no="";
					if(fs_locn_disp == null || fs_locn_disp.equals("null"))fs_locn_disp="";
					if(mr_pat_fs_locn_desc == null || mr_pat_fs_locn_desc.equals("null"))mr_pat_fs_locn_desc="";
					if(curr_fs_locn_desc == null || curr_fs_locn_desc.equals("null"))curr_fs_locn_desc="";
					if(other_locn_code == null || other_locn_code.equals("null"))other_locn_code="";
					if(curr_fs_locn_identity == null || curr_fs_locn_identity.equals("null"))curr_fs_locn_identity="";
					if(curr_holder_name == null || curr_holder_name.equals("null"))curr_holder_name="";
					if(curr_mr_locn_yn == null || curr_mr_locn_yn.equals("null")) curr_mr_locn_yn="";
					
					htRecord			=	new HashMap();

					htRecord.put("file_no"		        ,file_no);
					htRecord.put("patient_id"	        ,patient_id);
					htRecord.put("file_type_code"       ,file_type_code);
					htRecord.put("doc_type_code"        ,doc_type_code);
					htRecord.put("doc_folder_id"        ,doc_folder_id);
					htRecord.put("volume_no"		    ,volume_no);		
					
					htRecord.put("associate_yn"	        ,associate_yn);
					htRecord.put("fn_locn_code"	        ,fn_locn_code);
					htRecord.put("locn_identity"	    ,locn_identity);
					htRecord.put("narration_code"	    ,narration_code);
					htRecord.put("holder_name"		    ,holder_name);
					htRecord.put("mr_locn_yn"		    ,mr_locn_yn);
					htRecord.put("fs_locn_disp"		    ,fs_locn_disp);
					htRecord.put("mr_pat_fs_locn_desc"  ,mr_pat_fs_locn_desc);
					htRecord.put("curr_fs_locn_desc"    ,curr_fs_locn_desc);
					htRecord.put("other_locn_code"      ,other_locn_code);
					htRecord.put("curr_fs_locn_identity",curr_fs_locn_identity);
					htRecord.put("curr_holder_name"     ,curr_holder_name);
					htRecord.put("curr_mr_locn_yn"      ,curr_mr_locn_yn);

					recordSet.putObject(htRecord);
				}
			}
			row_count				=	recordSet.getSize();
			fm_disp	=	0;
			to_disp	=	7;
			if(to_disp > (row_count-1))
					to_disp=(row_count-1);
		}
		fm_disp =	start-1;
		to_disp	=	end-1;
		if(to_disp > (row_count-1))
			to_disp=(row_count-1);

            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	if (!(start <= 1))
	{

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(start-7));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(end-7));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

	}
	if ( !( (start+7) > row_count ) )
	{

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf((start+7)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf((end+7)));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

	}

            _bw.write(_wl_block13Bytes, _wl_block13);

	if(row_count==0)
	{

            _bw.write(_wl_block14Bytes, _wl_block14);

	}

            _bw.write(_wl_block15Bytes, _wl_block15);

	if(fs_locn.equals("C")) 
		header="Current FS Location";
	else
	{
		header="Permanent FS Location";
	}

            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

try
{
/*	Properties prop	=	new Properties();
	prop.put("fs_locn",fs_locn);
	prop.put("Statement",stmt1);
	prop.put("facility_id",facility_id);
	rs1	=	eFM.FMUtilities.getStorageLocn(prop);
*/	
	if(fs_locn.equals("P"))
	{
		dissable_attribute = "disabled";
	}
	for(int i=fm_disp; i<=to_disp; i++)
	{
		classValue			=	( (i%2)==0 )? "QRYODD" : "QRYEVEN";
		htRecord			=	(java.util.HashMap)	recordSet.getObject(i);

		file_no				=	(String)	htRecord.get("file_no");
		patient_id			=	(String)	htRecord.get("patient_id");
		file_type_code		=	(String)	htRecord.get("file_type_code");
		doc_type_code		=	(String)	htRecord.get("doc_type_code");
		doc_folder_id		=	(String)	htRecord.get("doc_folder_id");
		volume_no			=	(String)	htRecord.get("volume_no");		
		associate_yn		=	(String)	htRecord.get("associate_yn");
		fs_locn_disp		=	(String)	htRecord.get("fs_locn_disp");
		mr_pat_fs_locn_desc	=	(String)	htRecord.get("mr_pat_fs_locn_desc");
		curr_fs_locn_desc	=	(String)	htRecord.get("curr_fs_locn_desc");

		tblrow_id =	"tblrow_id"+i;

		if(associate_yn.equals("Y"))
		{
			associate_yn_prop = " CHECKED ";
		}
		else
		{
			associate_yn_prop = " ";
		}

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(((doc_folder_id.equals(""))?"&nbsp;":doc_folder_id)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(((doc_folder_name.equals(""))?"&nbsp;":doc_folder_name)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(((docline.equals(""))?"&nbsp;":docline)));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(((doc_type_name.equals(""))?"&nbsp;":doc_type_name)));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(((mr_pat_fs_locn_desc.equals(""))?"&nbsp;":mr_pat_fs_locn_desc)));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(((curr_fs_locn_desc.equals(""))?"&nbsp;":curr_fs_locn_desc)));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(dissable_attribute));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

			stmt2	=	con.createStatement();			
			if(fs_locn.equals("C"))
				{
					sql_query="select fs_locn_code, short_desc from fm_storage_locn where facility_id='"+facility_id+"' and eff_status='E' order by short_desc";
				}
				else
				{
					sql_query="select fs_locn_code, short_desc from fm_storage_locn where facility_id='"+facility_id+"' and permanent_file_area_yn ='Y' and eff_status='E' order by short_desc";
				}

				rs1		=	stmt2.executeQuery(sql_query);
			
			
				while(rs1 != null && rs1.next())
				{
					fs_locn_code	=	rs1.getString("fs_locn_code");
					fs_desc			=	rs1.getString("short_desc");

					if(!fs_locn_code.equals(fs_locn_disp))
					{
						out.println("<option value="+fs_locn_code+">"+fs_desc+"</option>");
					}
				}
				if(rs1 != null) rs1.close();
				if(stmt2  != null) stmt2.close();

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(fs_locn_disp));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(associate_yn_prop));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(dissable_attribute));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);

		}

            _bw.write(_wl_block48Bytes, _wl_block48);

	}
	catch(Exception e)
	{
		out.println("Exception@2: "+e);
	}
	

            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(fm_disp));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(to_disp));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(fs_locn));
            _bw.write(_wl_block53Bytes, _wl_block53);

if(rs1   != null) rs1.close();
if(rs    != null) rs.close();
if(stmt  != null) stmt.close();
if(stmt1 != null) stmt1.close();
if(stmt2  != null) stmt2.close();
}
catch(Exception e)
{
	out.println("Exception in fetching connection"+e.toString());
}
finally
{	
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block54Bytes, _wl_block54);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.documentdetails.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.documenttype.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.PermanentFSLocation.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.CurrentFS.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.FSLocation.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.change.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }
}
