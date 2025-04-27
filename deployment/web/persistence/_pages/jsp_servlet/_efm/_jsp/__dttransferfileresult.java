package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __dttransferfileresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/DTTransferFileResult.jsp", 1709116823591L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMTransferFile.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n<body OnMouseDown=\"CodeArrest();\" onKeyDown = \'lockKey();\'>\n<script>parent.transfer_criteria.document.getElementById(\"hdr_tab1\").style.visibility = \'Visible\';</script>\n<form name=\'FMTransferFileResult_form\' id=\'FMTransferFileResult_form\' method=\'post\' target=\'messageFrame\' action=\'../../servlet/eFM.FMTransferFileServlet\'>\n<table id=\'tb1\' border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' >\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' width=\'10%\'>\n\t\t\t\t\t<A HREF onMouseover=\"changeCursor(this)\" onClick=\"callPatDetails(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\')\"><font size=1>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</A><br>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</font></td>\n\n\t\t\t\t\t<td  CLASS=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' width=\'12%\'>\n\t\t\t\t\t<A HREF onMouseover=\"changeCursor(this)\" onClick=\"showEncounter(\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\',\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</font></A></td>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t<script>\n\t\t\t\tparent.frames[2].document.forms[0].tofslocn.disabled=false;\t\t\t\t\n\t\t\t\tparent.frames[2].document.forms[0].narration.disabled=false;\n\t\t\t\tparent.frames[2].document.forms[0].FS_LOCN_ID.disabled=false;\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\tvar p_rec_cnt = \'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\';\n\t\t\t\tif (p_rec_cnt==0)\t\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\'NO_DOC_FOR_TRANSFER\',\'FM\'));\n\t\t\t\t\tparent.frames[4].document.location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t\tparent.frames[2].document.forms[0].tofslocn.disabled=false;\n\t\t\t\t\tparent.frames[2].document.forms[0].narration.disabled=false;\n\t\t\t\t\tparent.frames[2].document.forms[0].FS_LOCN_ID.disabled=false;\t\t\t\n\t\t\t\t}\n\t\t\t</script>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t</table>\n<script>\n\tfor (i=0;i<4;i++)\n\t{\n\t\tif ((document.getElementById(\"tb1\").rows(i+1) != null) && (document.getElementById(\"tb1\").rows(i+1).cells(i) != null))\n\t\t{\n\t\t\tparent.transfer_criteria.document.getElementById(\"hdr_tab1\").rows(0).cells(i).width = document.getElementById(\"tb1\").rows(i+1).cells(i).width; \n\t\t}\n\t}\n</script>\n\t<input type=\'hidden\' name=\'count\' id=\'count\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t<input type=\'hidden\' name=\'FileList\' id=\'FileList\' value=\'\'>\n\t<input type=\'hidden\' name=\'DocFolderList\' id=\'DocFolderList\' value=\'\'>\n\t<input type=\'hidden\' name=\'DocTypeList\' id=\'DocTypeList\' value=\'\'>\n\t<input type=\'hidden\' name=\'FileTypeList\' id=\'FileTypeList\' value=\'\'>\n\t<input type=\'hidden\' name=\'VolumeList\' id=\'VolumeList\' value=\'\'>\n\t<input type=\'hidden\' name=\'FromLocnCode\' id=\'FromLocnCode\' value=\'\'>\n\t<input type=\'hidden\' name=\'TransferUserId\' id=\'TransferUserId\' value=\'\'>\n\t<input type=\'hidden\' name=\'iss_remarks\' id=\'iss_remarks\' value=\'\'>\n\t<input type=\'hidden\' name=\'resultPage_carried_by_name\' id=\'resultPage_carried_by_name\' value=\'\'>\n\t<input type=\'hidden\' name=\'resultPage_file_trans_mode\' id=\'resultPage_file_trans_mode\' value=\'\'>\n\t<input type=\'hidden\' name=\'auto_rec_ward_yn\' id=\'auto_rec_ward_yn\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\t<input type=\'hidden\' name=\'auto_rec_clinic_yn\' id=\'auto_rec_clinic_yn\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t<input type=\'hidden\' name=\'auto_rec_pract_yn\' id=\'auto_rec_pract_yn\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );
	
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

		Connection conn = ConnectionManager.getConnection(request);

		String facility_id			= (String) session.getValue("facility_id");
		String FromLocn				= request.getParameter("FromLocn");	
		String ToLocn				= request.getParameter("ToLocn");	
		String ToLocnDesc			= request.getParameter("ToLocnDesc");
		String ToNarration			= request.getParameter("ToNarration");
		String FileNo				= request.getParameter("FileNo");
		String doc_type_code		= request.getParameter("doc_type_code");
		String doc_folder_id		= request.getParameter("doc_folder_id");
		String trans_from			= request.getParameter("trans_from");
		String trans_to				= request.getParameter("trans_to");
		String auto_rec_ward_yn		= request.getParameter("auto_rec_ward_yn");
		String auto_rec_clinic_yn	= request.getParameter("auto_rec_clinic_yn");
		String auto_rec_pract_yn	= request.getParameter("auto_rec_pract_yn");
				
		String sql             = "";
		String classValue      = "";		
		String file_type_code  = "";
		String p_doc_folder_id = "";
		String p_doc_type_code = "";
		StringBuffer moreCriteria	= null;
		moreCriteria					= new StringBuffer();

		int rowid=0;
		int i = 0, p_rec_cnt = 0;

		java.sql.Statement stmt	=	null;
		ResultSet rs			=	null;

		if(auto_rec_ward_yn == null || auto_rec_ward_yn.equals("null")) auto_rec_ward_yn = "";
		if(auto_rec_clinic_yn == null || auto_rec_clinic_yn.equals("null")) auto_rec_clinic_yn = "";
		if(auto_rec_pract_yn == null || auto_rec_pract_yn.equals("null"))  auto_rec_pract_yn = "";

		if(FromLocn == null || FromLocn.equals("null")) 
			FromLocn = "";
		if(ToLocn == null || ToLocn.equals("null")) 
			ToLocn = "";
		if(ToLocnDesc == null || ToLocnDesc.equals("null")) 
			ToLocnDesc = "";
		if(doc_folder_id == null || doc_folder_id.equals("null")) 
			doc_folder_id = "";
		if(doc_type_code == null || doc_type_code.equals("null")) 
			doc_type_code = "";
		if(FileNo == null ||  FileNo.equals("null")) 
			FileNo = "";	
		if(trans_from == null || trans_from.equals("null")) 
			trans_from = "";
		if(trans_to == null || trans_to.equals("null")) 
			trans_to = "";
		if(ToNarration == null || ToNarration.equals("null")) 
			ToNarration = "";
		if(!(doc_folder_id == null || doc_folder_id.equals("")))
			moreCriteria.append(" AND a.doc_folder_id in ("+doc_folder_id+") ");
		if(!(doc_type_code == null || doc_type_code.equals("")))
			moreCriteria.append(" AND a.doc_type_code in ("+doc_type_code+") ");
//		if(!(FileNo == null || FileNo.equals("")))
//			moreCriteria += " AND a.file_no in ("+FileNo+") ";

		try
		{
			sql="SELECT a.patient_id,decode('"+localeName+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) PATIENT_NAME,d.encounter_id,a.file_type_code,a.file_no,a.doc_folder_id,a.doc_folder_name,a.doc_type_code,a.doc_type_name,a.volume_no,(CASE WHEN c.patient_period_specific = 'D' THEN '' || TO_CHAR(c.from_period,'dd/mm/rrrr') || '-' || TO_CHAR(to_period,'dd/mm/rrrr')  ELSE  ', ' || GET_PATIENT_LINE(c.PATIENT_ID,'"+localeName+"') END) docline, DECODE (b.locn_identity,'D', 'Department','C', 'Clinic','N', 'Nursing Unit', 'T', 'Practitioner','X', 'External','E','Procedure Unit','Y','Daycare Unit') locn_iden FROM fm_curr_locn_vw a, fm_storage_locn b,fm_doc_folder c, FM_ENCOUNTER_DOC_TYPE_LINK d WHERE curr_facility_id = '"+facility_id+"' AND a.facility_id = c.facility_id AND a.facility_id = D.facility_id AND a.file_no = d.file_no AND a.doc_folder_id = c.doc_folder_id AND curr_fs_locn_code = '"+FromLocn+"' AND curr_file_status = 'O' "+moreCriteria+" AND a.curr_locn_id = '"+trans_from+"' AND a.curr_facility_id = b.facility_id AND b.fs_locn_code = '"+ToLocn+"' ORDER BY a.doc_folder_id";
		
			stmt =conn.createStatement();
			rs = stmt.executeQuery(sql);

			if(rs != null)
			{
				while(rs.next())
				{
					classValue	=	( (i%2)==0 )? "QRYEVEN" : "QRYODD";
					rowid++;
					String docline			= rs.getString("docline");
					String doc_folder_name	= rs.getString("doc_folder_name");
					String doc_type_name	= rs.getString("doc_type_name");
					p_doc_folder_id			= rs.getString("doc_folder_id");
					p_doc_type_code			= rs.getString("doc_type_code");
					file_type_code			= rs.getString("file_type_code");
					String patientid		= rs.getString("PATIENT_ID");
					String patientname		= rs.getString("PATIENT_NAME");
					String encounterid		= rs.getString("ENCOUNTER_ID");

					if(docline == null || docline.equals("null"))
						docline = "&nbsp;";
					if(doc_type_name == null || doc_type_name.equals("null"))
						doc_type_name = "&nbsp;";
					if(doc_folder_name == null || doc_folder_name.equals("null"))
						doc_folder_name = "&nbsp;";
					if(p_doc_folder_id == null || p_doc_folder_id.equals("null"))
						p_doc_folder_id = "";
					if(p_doc_type_code == null || p_doc_type_code.equals("null"))
						p_doc_type_code = "";
					if(file_type_code == null || file_type_code.equals("null"))
						file_type_code = "";

					out.println("<tr><td class='"+classValue+"' width='30%'><font size='1'><B>");
					out.println(p_doc_folder_id+"</B><BR>&nbsp;&nbsp;"+doc_folder_name+"&nbsp;&nbsp;"+docline);
					out.println("</font></td><td class='"+classValue+"' width='15%'><font size='1'><CENTER>");
					out.println(doc_type_name+"</CENTER>");
					out.println("</font></td>");
					//ragha
					
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patientname));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(rs.getString("file_no")));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block15Bytes, _wl_block15);

					out.println("<td class='"+classValue+"' align=center width='23%'><font size='1'>");
					out.println(ToLocnDesc+"<br>&nbsp;&nbsp;&nbsp;("+rs.getString("LOCN_IDEN")+")");
					out.println("</font></td><td align='center' class='"+classValue+"' width='10%'><font size='1'>");
					out.println("<input type='checkbox' name='confirm"+rowid+"' id='confirm"+rowid+"' checked>");
					out.println("</font></td></tr>");
					out.println("<input type='hidden' name='docfolder"+rowid+"' id='docfolder"+rowid+"' value='"+p_doc_folder_id+"'>");
					out.println("<input type='hidden' name='doctype"+rowid+"' id='doctype"+rowid+"' value='"+p_doc_type_code+"'>"); 
					out.println("<input type='hidden' name='file"+rowid+"' id='file"+rowid+"' value='"+rs.getString("file_no")+"'>");
					out.println("<input type='hidden' name='filetype"+rowid+"' id='filetype"+rowid+"' value='"+file_type_code+"'>"); 
					out.println("<input type='hidden' name='volume"+rowid+"' id='volume"+rowid+"' value='"+rs.getString("volume_no")+"'>"); 
					out.println("<input type='hidden' name='tolocns"+rowid+"' id='tolocns"+rowid+"' value='"+ToLocn+"'>");
					out.println("<input type='hidden' name='tonarration"+rowid+"' id='tonarration"+rowid+"' value='"+ToNarration+"'>");
					out.println("<input type='hidden' name='trans_to"+rowid+"' id='trans_to"+rowid+"' value='"+trans_to+"'>");
					
					i++;
					p_rec_cnt++;
				}
			}

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(p_rec_cnt));
            _bw.write(_wl_block17Bytes, _wl_block17);

		if(rs!=null)	rs.close();
		if(stmt!=null) stmt.close();
		}
		catch(Exception e)
		{
			out.println("Exception :"+e.toString());
		}
		finally
		{			
			ConnectionManager.returnConnection(conn,request);
		}

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rowid));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(auto_rec_ward_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(auto_rec_clinic_yn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(auto_rec_pract_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
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
