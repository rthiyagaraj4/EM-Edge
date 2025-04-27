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

public final class __dtconfirmreceiptfilesdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/DTConfirmReceiptFilesDetail.jsp", 1709116817560L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMConfirmReceiptFiles.js\'></script>\n\t\n<SCRIPT LANGUAGE=\"JavaScript\">\n//added for on click events of patient_id and encounter_id\n\n</SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey();\'>\n<form name=\'ConfirmReceiptDtl_form\' id=\'ConfirmReceiptDtl_form\' action=\'../../servlet/eFM.FMConfirmReceiptFilesServlet\' method=\'post\' target=\'messageFrame\'>\n<script>\n\tparent.frames[2].document.getElementById(\"hdr_tab0\").style.visibility = \'Visible\';\n\tparent.frames[2].document.getElementById(\"hdr_tab\").style.visibility = \'Visible\';\n</script>\n<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\' id=\'tb1\'>\n";
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

    private final static java.lang.String  _wl_block15 ="</font></A></td>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t   <a href=\'javascript:GetShowRemarks(\"ReqComm";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\",\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\",\"R\")\'>Remarks</a></font></td>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t   <a href=\'javascript:GetShowRemarks(\"txtComm";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\",\"IR\")\'>Remarks</a></font></td>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<script>\n\t\t\t\tvar p_rec_cnt = \'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'\n\t\t\t\tif (p_rec_cnt==0) \n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\'NO_DOC_FOR_CONFIRM\',\'FM\'));\n\t\t\t\t\tparent.frames[3].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\tparent.parent.content.frames[4].location.href=\"../../eCommon/jsp/error.jsp?\";\n\t\t\t</script>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n</table>\n<script>\n\t\n\tfor (i=0;i<7;i++)\n\t{\n\t\tif ((document.getElementById(\"tb1\").rows(i+1) != null) && (document.getElementById(\"tb1\").rows(i+1).cells(i) != null))\n\t\t{\n\t\t\tparent.receipt_criteria.document.getElementById(\"hdr_tab\").rows(0).cells(i).width = document.getElementById(\"tb1\").rows(i+1).cells(i).width; \n\t\t}\n\t}\n\t</script>\n<input type=\'hidden\' name=\'reccount\' id=\'reccount\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n<input type=\'hidden\' name=\'filenos\' id=\'filenos\' value=\'\'>\n<input type=\'hidden\' name=\'filetypecodes\' id=\'filetypecodes\' value=\'\'>\n<input type=\'hidden\' name=\'volumenos\' id=\'volumenos\' value=\'\'>\n<input type=\'hidden\' name=\'issue_locns\' id=\'issue_locns\' value=\'\'>\n<input type=\'hidden\' name=\'rec_locn_code\' id=\'rec_locn_code\' value=\'\'>\n<input type=\'hidden\' name=\'rec_locn_iden\' id=\'rec_locn_iden\' value=\'\'>\n<input type=\'hidden\' name=\'rec_user_id\' id=\'rec_user_id\' value=\'\'>\n<input type=\'hidden\' name=\'file_type_appl_yn\' id=\'file_type_appl_yn\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		java.sql.Statement stmt		 = null;
		ResultSet rs		 = null;
		String sql			 = "";
		String classValue	 = "";
		int i = 1, p_rec_cnt = 0;

		Connection conn			 = ConnectionManager.getConnection(request);
		String facility_id		 = (String) session.getValue("facility_id");
		String FSLocation		 = request.getParameter("FSLocation");
		String flag				 = request.getParameter("clearflag");
		String file_num			 = request.getParameter("fileno");
		String file_type		 = request.getParameter("file_type_code");
		String volume			 = request.getParameter("volumeno");
		String file_type_appl_yn = request.getParameter("file_type_appl_yn");
		String file_type_desc    = "";
		
		if(flag == null || flag.equals("null")) flag="";
		if(FSLocation == null || FSLocation.equals("null")) FSLocation="";
		if(file_num == null || file_num.equals("null")) file_num="";
		if(file_type == null || file_type.equals("null")) file_type="";
		if(volume == null || volume.equals("null")) volume="";
		if(file_type_appl_yn == null || file_type_appl_yn.equals("null"))
			file_type_appl_yn="";

		String doc_folder_id = request.getParameter("doc_folder_id")==null?"":request.getParameter("doc_folder_id");
		String doc_type_id = request.getParameter("doc_type_id")==null?"":request.getParameter("doc_type_id");
		String doc_type = "";	

String p_concat_string ="";

ArrayList list = new ArrayList();

try
{	
		if( session.getAttribute("objKey")!=null)
		{
			list = (ArrayList)session.getAttribute("objKey");
			if(!file_num.equals("") && !list.contains("'"+file_num+"'"))
			list.add("'"+file_num+"'");
		}
		else
		{
			if(!file_num.equals("") && !list.contains("'"+file_num+"'"))	
			list.add("'"+file_num+"'");
		}
		/// Block for String maniputlation 
		if(list.size()>0)
		{
			for(int m=0;m<list.size();m++)
			{
				 if(list.size() ==1)
				 {
					 p_concat_string  = (String)list.get(m);
				 }
				 else
				 {
					p_concat_string =p_concat_string + (String)list.get(m)+",";
				 }
			 }
		}
		if(p_concat_string!=null && !p_concat_string.equals("") && list.size() >1)
		p_concat_string  = p_concat_string.substring(0,p_concat_string.length()-1);

	}
	catch(Exception e){}
		if (file_num == null || file_num.equals("null"))
			file_num = "";
		if (file_type == null || file_type.equals("null"))
			file_type = "";


			//sql = "select A.FILE_NO,A.FILE_TYPE_CODE, TO_CHAR(A.SENT_DATE_TIME,'DD/MM/YYYY HH24:MI') SENT_DATE_TIME, A.SRC_FACILITY_ID, A.SRC_FS_LOCN_CODE,    DECODE(A.SRC_LOCN_IDENTITY,'C','Clinic','D','Department','N','Nursing Unit','T','Practitioner','X','External','E','Procedure Unit','Y','Daycare Unit') SRC_LOCN_IDENTITY,	 A.DEST_FACILITY_ID, A.DEST_FS_LOCN_CODE, A.DEST_LOCN_IDENTITY, B.LONG_DESC SRC_FS_LOCN_DESC,A.REQ_REMARKS,A.ISS_REMARKS,A.VOLUME_NO,E.CURR_FILE_STATUS,	E.DOC_FOLDER_ID, E.DOC_FOLDER_NAME, E.DOC_TYPE_NAME, F.PATIENT_ID, F.FROM_PERIOD,  F.TO_PERIOD, F.PATIENT_PERIOD_SPECIFIC,  (CASE WHEN F.PATIENT_PERIOD_SPECIFIC='D' THEN ', ' || TO_CHAR(F.FROM_PERIOD,'DD/MM/YYYY ')	|| ' - ' || TO_CHAR(F.TO_PERIOD,'DD/MM/YYYY ') ELSE  ', ' || GET_PATIENT_LINE(F.PATIENT_ID) END)DOC_TYPE,E.PATIENT_ID,E.PATIENT_NAME,G.ENCOUNTER_ID FROM FM_TRANSIT_FILE A,		  FM_STORAGE_LOCN B,  FM_CURR_LOCN_VW E, FM_DOC_FOLDER F,FM_ENCOUNTER_DOC_TYPE_LINK G WHERE A.DEST_FACILITY_ID = '"+facility_id+"' AND A.DEST_FS_LOCN_CODE = '"+FSLocation+"' AND A.SRC_FACILITY_ID = B.FACILITY_ID AND A.SRC_FS_LOCN_CODE = B.FS_LOCN_CODE AND A.FILE_NO = E.FILE_NO AND A.SRC_FACILITY_ID = E.FACILITY_ID	AND A.VOLUME_NO = E.VOLUME_NO AND A.FILE_NO = E.FILE_NO	AND  e.facility_id = g.facility_id AND e.file_no = g.file_no AND A.SRC_FACILITY_ID = E.FACILITY_ID(+) AND A.VOLUME_NO = E.VOLUME_NO AND E.CURR_FILE_STATUS in('T','E') AND A.DOC_FOLDER_ID = F.DOC_FOLDER_ID AND A.SRC_FACILITY_ID = F.FACILITY_ID ";

			sql = "SELECT a.file_no,a.patient_id,e.patient_name patient_name, a.file_type_code,TO_CHAR (a.sent_date_time, 'DD/MM/YYYY HH24:MI') sent_date_time,a.src_facility_id, a.src_fs_locn_code,DECODE (a.src_locn_identity,'C', 'Clinic','D', 'Department','N', 'Nursing Unit','T', 'Practitioner','X', 'External','E', 'Procedure Unit','Y', 'Daycare Unit') src_locn_identity, a.dest_facility_id, a.dest_fs_locn_code, a.dest_locn_identity,b.long_desc src_fs_locn_desc, a.req_remarks, a.iss_remarks,a.volume_no, e.curr_file_status, e.doc_folder_id, e.doc_folder_name,e.doc_type_name, f.patient_id, f.from_period, f.to_period,f.patient_period_specific,(CASE WHEN f.patient_period_specific = 'D' THEN ', ' || TO_CHAR (f.from_period, 'DD/MM/YYYY ') || ' - ' || TO_CHAR (f.to_period, 'DD/MM/YYYY ') ELSE ', ' || get_patient_line (f.patient_id,'"+localeName+"') END ) doc_type,g.encounter_id FROM fm_transit_file a, fm_storage_locn b, fm_curr_locn_vw e,fm_doc_folder f, FM_ENCOUNTER_DOC_TYPE_LINK g   WHERE a.dest_facility_id = '"+facility_id+"' AND a.dest_fs_locn_code = '"+FSLocation+"' AND a.src_facility_id = b.facility_id AND a.src_fs_locn_code = b.fs_locn_code AND a.file_no = e.file_no AND a.src_facility_id = e.facility_id AND a.volume_no = e.volume_no AND e.curr_file_status IN ('T', 'E') AND a.doc_folder_id = f.doc_folder_id AND a.src_facility_id = f.facility_id AND a.file_no = g.file_no AND a.src_facility_id = g.facility_id";

				if(!doc_folder_id.equals(""))
				{
					sql = sql + " AND E.DOC_FOLDER_ID = '"+doc_folder_id+"' ";
				}
				if(!doc_type_id.equals(""))
				{
					sql = sql + " AND E.DOC_TYPE_CODE = '"+doc_type_id+"' ";
				}
	/*			if(!file_num.equals(""))
				{
					sql = sql + " AND E.FILE_NO = '"+file_num+"' ";
				}*/
				sql =sql + " ORDER BY 1 ";	

		try
		{
			stmt =conn.createStatement();
				rs = stmt.executeQuery(sql);

			if(rs != null)
			{
				while(rs.next()) 
				{
					if ( i % 2 == 0 )
						classValue = "QRYODD" ;
					else
						classValue = "QRYEVEN" ;

					String fileno			= rs.getString("FILE_NO");		
					String filetypecode		= rs.getString("FILE_TYPE_CODE");
					String volumeno			= rs.getString("VOLUME_NO");
					String senderfacility	= rs.getString("SRC_FACILITY_ID");
					String senderlocn		= rs.getString("SRC_FS_LOCN_CODE");
					String senderlocndesc	= rs.getString("SRC_FS_LOCN_DESC");
					String senderlocnid		= rs.getString("SRC_LOCN_IDENTITY");
					String issuedate		= rs.getString("SENT_DATE_TIME");
					String p_req_remarks	= rs.getString("REQ_REMARKS");
					String p_iss_remarks	= rs.getString("ISS_REMARKS");

					String p_doc_folder_id	= rs.getString("DOC_FOLDER_ID");
					String p_doc_folder_name	= rs.getString("DOC_FOLDER_NAME");
					String p_doc_type_name	= rs.getString("DOC_TYPE_NAME");

					String patientid	= rs.getString("PATIENT_ID");
					String patientname	= rs.getString("PATIENT_NAME");
					String encounterid	= rs.getString("ENCOUNTER_ID");
					
					if(fileno == null || fileno.equals("null")) fileno = "";
				
					if(issuedate == null || issuedate.equals("null")) issuedate = "";
					if(filetypecode == null || filetypecode.equals("null")) file_type_desc = "";
					if(volumeno == null || volumeno.equals("null")) volumeno = "";
					if(p_req_remarks == null || p_req_remarks.equals("null")) p_req_remarks = "";
					if(p_iss_remarks == null || p_iss_remarks.equals("null")) p_iss_remarks = "";
					if(senderlocnid == null || senderlocnid.equals("null"))  senderlocnid = "";
					if(senderlocn == null || senderlocn.equals("null"))  senderlocn = "";
					if(senderlocndesc == null || senderlocndesc.equals("null")) senderlocndesc = "";
					if(senderfacility == null || senderfacility.equals("null")) 
						senderfacility = "&nbsp;";
					if(p_doc_folder_id == null || p_doc_folder_id.equals("null")) 
						p_doc_folder_id = "&nbsp;";
					if(p_doc_folder_name == null || p_doc_folder_name.equals("null")) 
						p_doc_folder_name = "&nbsp;";
					if(p_doc_type_name == null || p_doc_type_name.equals("null")) 
						p_doc_type_name = "&nbsp;";		
			
						doc_type = rs.getString("DOC_TYPE")==null?"":rs.getString("DOC_TYPE");
				
					out.println("<tr><td  class='"+classValue+"'  width='20%'>");
					out.println("<font size=1><b>"+p_doc_folder_id+"</b><br>&nbsp;"+p_doc_folder_name+"&nbsp;"+doc_type+"&nbsp;</font></td>");
					
					out.println("<td  class='"+classValue+"' width='10%' nowrap><font size=1><CENTER>");				
					out.println(p_doc_type_name);						
					out.println("</CENTER></font></td>");
					//RAGHA

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
            out.print( String.valueOf(fileno));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block15Bytes, _wl_block15);
	

					out.println("<td  class='"+classValue+"' width='8%'><font size=1>");
					if (p_req_remarks == null)
					{
						out.println("&nbsp;</font></td>");
					}
					else
					{

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(java.net.URLEncoder.encode(p_req_remarks)));
            _bw.write(_wl_block18Bytes, _wl_block18);
					
					}
					out.println("<td  class='"+classValue+"' width='15%'>");

					if(senderlocndesc == null || senderlocndesc.equals("null"))
						out.println("&nbsp;</td>");
					else
						out.println("<font size=1>"+senderlocndesc+" - ("+senderlocnid+")</font></td>");

					out.println("<td  class='"+classValue+"' width='8%'><font size=1>");

					if (p_iss_remarks == null)
					{
						out.println("&nbsp;</font></td>");
					}
					else
					{

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(java.net.URLEncoder.encode(p_iss_remarks)));
            _bw.write(_wl_block20Bytes, _wl_block20);
					
					}
					out.println("<td align='center' class='"+classValue+"'width='10%' >");
					out.println("<font size=1>"+issuedate+"</font></td>");
					out.println("<td  align='center' class='"+classValue+"' width='7%'>");
					out.println("<input type='checkbox' name='confirmbox"+i+"' id='confirmbox"+i+"' value='Y' Checked onClick='confirmSelection(this);'></td></tr>");
					out.println("<input type='hidden' name='file"+i+"' id='file"+i+"' value='"+fileno+"'>");
					out.println("<input type='hidden' name='filetype"+i+"' id='filetype"+i+"' value='"+filetypecode+"'>");
					out.println("<input type='hidden' name='volume"+i+"' id='volume"+i+"' value='"+volumeno+"'>");
					out.println("<input type='hidden' name='issuelocn"+i+"' id='issuelocn"+i+"' value='"+senderlocn+"'>");
					i++;
					p_rec_cnt++;
				}

			}

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(p_rec_cnt ));
            _bw.write(_wl_block22Bytes, _wl_block22);

	if(rs!=null)	rs.close();
	if(stmt!=null) stmt.close();
	}
	catch(Exception e)
	{
		out.println(e.toString());
	}
	finally
	{		
		ConnectionManager.returnConnection(conn,request);
	}

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(file_type_appl_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);

	if(flag.equals("C"))
	{
		if(session.getAttribute("objKey")!=null)
		session.removeAttribute("objKey");		
	}
	session.setAttribute("objKey",list);
	list.clear();

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
