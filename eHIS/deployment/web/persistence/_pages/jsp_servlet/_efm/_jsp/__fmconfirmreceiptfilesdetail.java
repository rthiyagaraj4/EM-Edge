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

public final class __fmconfirmreceiptfilesdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMConfirmReceiptFilesDetail.jsp", 1737693066557L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n\t\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMConfirmReceiptFiles.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey();\'>\n<form name=\'ConfirmReceiptDtl_form\' id=\'ConfirmReceiptDtl_form\' action=\'../../servlet/eFM.FMConfirmReceiptFilesServlet\' method=\'post\' target=\'messageFrame\'>\n<script>\n\tparent.frames[2].document.getElementById(\"hdr_tab0\").style.visibility = \'Visible\';\n\tparent.frames[2].document.getElementById(\"hdr_tab\").style.visibility = \'Visible\';\n</script>\n<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\' id=\'tb1\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<a href=\'javascript:GetShowRemarks(\"ReqComm";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\",\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\",\"R\")\'>  ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&nbsp; ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</a></font></td>\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t<a href=\'javascript:GetShowRemarks(\"txtComm";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\",\"IR\")\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<script>\n\t\t\t\tvar p_rec_cnt = \'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'\n\t\t\t\tif (p_rec_cnt==0) \n\t\t\t\t{\n\t\t\t\t\tparent.frames[2].document.getElementById(\"hdr_tab\").style.visibility = \'hidden\';\n\t\t\t\t\tparent.frames[2].document.getElementById(\"hdr_tab0\").style.visibility = \'hidden\';\n\t\t\t\t\talert(getMessage(\'NO_RECORD_FOR_CONFIRM\',\'FM\'));\n\t\t\t\t  parent.frames[2].document.forms[0].show.disabled=false;\n\t\t\t     parent.frames[2].document.forms[0].add.disabled=false;\n\t\t\t     parent.frames[2].document.forms[0].clear.disabled=false;\n\t\t\t\t\tparent.frames[3].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t}\n\t\t\t\tparent.parent.frames[2].frames[4].location.href=\"../../eCommon/jsp/error.jsp?\";\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n</table>\n<script>\n\tfor (i=0;i<7;i++)\n\t{\n\t\t//if ((document.getElementById(\"tb1\").rows(i+1) != null) && (document.getElementById(\"tb1\").rows(i+1).cells(i) != null))\n\t\tif ((document.getElementById(\"tb1\").rows[i+1] != null) && (document.getElementById(\"tb1\").rows[i+1].cells[i] != null))\n\n\t\t{\n\t\t\tparent.receipt_criteria.document.getElementById(\"hdr_tab\").rows(0).cells(i).width = document.getElementById(\"tb1\").rows(i+1).cells(i).width; \n\t\t}\n\t}\n\tparent.frames[2].FMConfirmRcptCriteria_form.patient_id.value=\'\';\n\tparent.frames[2].FMConfirmRcptCriteria_form.patient_id.focus();\n\tparent.frames[2].document.getElementById(\"patientid1\").onblur();\n\t //parent.frames[2].populateDynamicValues(parent.frames[2].FMConfirmRcptCriteria_form.patient_id);\n\n           parent.frames[2].document.forms[0].show.disabled=false;\n\t\t\tparent.frames[2].document.forms[0].add.disabled=false;\n\t\t\tparent.frames[2].document.forms[0].clear.disabled=false;\n</script>\n\t<input type=\'hidden\' name=\'reccount\' id=\'reccount\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t<input type=\'hidden\' name=\'filenos\' id=\'filenos\' value=\'\'>\n\t<input type=\'hidden\' name=\'filetypecodes\' id=\'filetypecodes\' value=\'\'>\n\t<input type=\'hidden\' name=\'volumenos\' id=\'volumenos\' value=\'\'>\n\t<input type=\'hidden\' name=\'issue_locns\' id=\'issue_locns\' value=\'\'>\n\t<input type=\'hidden\' name=\'rec_locn_code\' id=\'rec_locn_code\' value=\'\'>\n\t<input type=\'hidden\' name=\'rec_locn_iden\' id=\'rec_locn_iden\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t<input type=\'hidden\' name=\'rec_user_id\' id=\'rec_user_id\' value=\'\'>\n\t<input type=\'hidden\' name=\'file_type_appl_yn\' id=\'file_type_appl_yn\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\t<input type=\'hidden\' name=\'senderfacility\' id=\'senderfacility\' value=\'\'>\n\t<!--Added for this CRF HSA-CRF-0306.1-->\n\t<input type=\'hidden\' name=\'fs_curr_locn_id\' id=\'fs_curr_locn_id\' value=\'\'> \n\t<input type=\'hidden\' name=\'patientid\' id=\'patientid\' value=\'\'> \n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

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

		String facility_id		= (String) session.getValue("facility_id");
		

		String FSLocation		 = "";
		String flag				 = "";
		String file_num			 = "";
		String file_type		 = "";
		String volume			 = "";
		String patient_id		 = "";
		String file_type_appl_yn = "";
		
		String fs_curr_locn_id=""; // added for this CRF HSA-CRF-0306.1
		String patientid=""; // added for this CRF HSA-CRF-0306.1
		String fileno			= "";
		String pline			= "";
		String filetypecode		= "";
		String volumeno			= "";
		String senderfacility	= "";
		String senderlocn		= "";
		String senderlocndesc	= "";
		String senderlocnid		= "";
		String senderlocnid1		= "";
		String issuedate		= "";
		String p_req_remarks	= "";
		String p_iss_remarks	= "";
         String file_type_no="";
		String classValue		= "";
		String file_type_desc	= "";
		String p_concat_string	= "";
		String volumeCriteria	= "";
		String patientCriteria	= "";
       String loca_identity="";
		StringBuffer SelectSqlString = null;
		SelectSqlString				 = new StringBuffer();
        String hdrec_locn_iden="";
		int i = 1, p_rec_cnt = 0;
		int count_tokens=0;
		String p_stored_val="";
		String pat_id="";
		String vol_no="";
		String patientno_volume="";
		ArrayList list	= new ArrayList();
		
		try
		{
			FSLocation			= request.getParameter("FSLocation");
			flag				= request.getParameter("clearflag");
			file_num			= request.getParameter("fileno");
			file_type			= request.getParameter("file_type_code");
			volume				= request.getParameter("volumeno");
			patient_id			= request.getParameter("patient_id");
			file_type_appl_yn	= request.getParameter("file_type_appl_yn");
     		hdrec_locn_iden= request.getParameter("hdrec_locn_iden");
			p_stored_val=request.getParameter("p_stored_val");
			if(flag == null || flag.equals("null")) flag="";
			if(FSLocation == null || FSLocation.equals("null")) FSLocation="";
			if(file_num == null || file_num.equals("null")) file_num="";
			if(file_type == null || file_type.equals("null")) file_type="";
			if(volume == null || volume.equals("null")) volume="";
			if(patient_id == null || patient_id.equals("null")) patient_id="";
		    if(p_stored_val== null || p_stored_val.equals("null")) p_stored_val="";
			if(file_type_appl_yn == null || file_type_appl_yn.equals("null")) file_type_appl_yn="";
			
			if(file_type_appl_yn.equals("N"))
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
							p_concat_string = p_concat_string + (String)list.get(m)+",";
						 }
					 }
				}
				if(p_concat_string!=null && !p_concat_string.equals("") && list.size() >1)
				p_concat_string  = p_concat_string.substring(0,p_concat_string.length()-1);
			}
			else if(file_type_appl_yn.equals("Y"))
			{
				if( session.getAttribute("objKey")!=null)
				{
					list = (ArrayList)session.getAttribute("objKey");
					if(!file_type.equals("") && !list.contains("'"+file_type+"'"))
					list.add("'"+file_type+"'");
				}
				else
				{
					if(!file_type.equals("") && !list.contains("'"+file_type+"'"))	
					list.add("'"+file_type+"'");
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
							p_concat_string = p_concat_string + (String)list.get(m)+",";
						}
					}
				}
				if(p_concat_string!=null && !p_concat_string.equals("") && list.size() >1)
				p_concat_string  = p_concat_string.substring(0,p_concat_string.length()-1);
			}


			if(!volume.equals(""))
			{
				volumeCriteria = " AND a.volume_no IN ("+volume+") ";
			}
		
		patientCriteria = " AND a.patient_id in ("+patient_id+") "; 
	
		
		if(file_num == null || file_num.equals("null")) file_num = "";
		if(file_type == null || file_type.equals("null")) file_type = "";


		if(file_num.equals("") && file_type.equals(""))
		{

			if(file_type_appl_yn.equals("N"))
			{   
			    /*Below query modified foe this CRF HSA-CRF-0306.1*/
				
				SelectSqlString.append("SELECT" );
				SelectSqlString.append("  a.File_No" );
				SelectSqlString.append("  , Get_patient_line(a.Patient_Id,'"+localeName+"') PlIne" );
				SelectSqlString.append("  , a.File_Type_Code" );
				SelectSqlString.append("  , TO_CHAR(Sent_Date_Time,'dd/mm/yyyy hh24:mi') Sent_Date_Time" );
				SelectSqlString.append("  , src_Facility_Id" );
				SelectSqlString.append("  , src_fs_Locn_Code" );
				SelectSqlString.append("  , src_Locn_Identity src_Locn_Identity" );
				SelectSqlString.append("  , dest_Facility_Id" );
				SelectSqlString.append("  , dest_fs_Locn_Code" );
				SelectSqlString.append("  , dest_Locn_Identity" );
				SelectSqlString.append("  , FM_GET_DESC.FM_STORAGE_LOCN(A.src_Facility_Id, A.SRC_fs_Locn_Code,'"+localeName+"','2') src_fs_Locn_desc" );
				SelectSqlString.append("  , Ltrim(Rtrim(a.req_Remarks)) req_Remarks" );
				SelectSqlString.append("  ,Ltrim(Rtrim(a.Iss_Remarks)) Iss_Remarks" );
				SelectSqlString.append("  , a.Volume_No" );
				SelectSqlString.append("  , c.Curr_File_Status, curr_locn_id, c.patient_id patientid " );
				SelectSqlString.append("FROM" );
				SelectSqlString.append("  fm_Transit_File a" );
				SelectSqlString.append("  , fm_Curr_Locn C " );
				SelectSqlString.append("WHERE A.dest_Facility_Id = '"+facility_id+"' " );
				SelectSqlString.append("  AND A.dest_fs_Locn_Code = '"+FSLocation+"' " );
				SelectSqlString.append("  AND a.File_No = c.File_No " );
				SelectSqlString.append("  AND a.src_Facility_Id = c.Facility_Id " );
				SelectSqlString.append("  AND a.Volume_No = c.Volume_No " );
				SelectSqlString.append("  AND c.Curr_File_Status IN ('T','E') " );
				SelectSqlString.append("  AND c.Doc_Folder_Id IS" );
				SelectSqlString.append("  NULL " );
				SelectSqlString.append("ORDER BY" );
				SelectSqlString.append("  a.File_No,a.Volume_No" );
			}
			else if(file_type_appl_yn.equals("Y"))
			{
			   /*Below query modified foe this CRF HSA-CRF-0306.1*/
				SelectSqlString.append("SELECT" );
				SelectSqlString.append("  a.File_No" );
				SelectSqlString.append("  , Get_patient_line(a.Patient_Id,'"+localeName+"') PlIne" );
				SelectSqlString.append("  , a.File_Type_Code" );
				SelectSqlString.append("  , MR_GET_DESC.MR_FILE_TYPE(A.FACILITY_ID, A.FILE_TYPE_CODE,'"+localeName+"','2') File_Type_desc" );
				SelectSqlString.append("  , TO_CHAR(Sent_Date_Time,'dd/mm/yyyy hh24:mi') Sent_Date_Time" );
				SelectSqlString.append("  , src_Facility_Id" );
				SelectSqlString.append("  , src_fs_Locn_Code" );
				SelectSqlString.append("  , src_Locn_Identity src_Locn_Identity" );
				SelectSqlString.append("  , dest_Facility_Id" );
				SelectSqlString.append("  , dest_fs_Locn_Code" );
				SelectSqlString.append("  , dest_Locn_Identity" );
				SelectSqlString.append("  , FM_GET_DESC.FM_STORAGE_LOCN(A.src_Facility_Id, A.SRC_fs_Locn_Code,'"+localeName+"','2') src_fs_Locn_desc" );
					SelectSqlString.append("  , Ltrim(Rtrim(a.req_Remarks)) req_Remarks" );
				SelectSqlString.append("  ,Ltrim(Rtrim(a.Iss_Remarks)) Iss_Remarks" );
				SelectSqlString.append("  , a.Volume_No" );
				SelectSqlString.append("  , c.Curr_File_Status, curr_locn_id, c.patient_id patientid " );
				SelectSqlString.append("FROM" );
				SelectSqlString.append("  fm_Transit_File a" );
				SelectSqlString.append("  , fm_Curr_Locn C " );
				SelectSqlString.append("WHERE A.dest_Facility_Id = '"+facility_id+"' " );
				SelectSqlString.append("  AND A.dest_fs_Locn_Code = '"+FSLocation+"' " );
				SelectSqlString.append("  AND a.File_No = c.File_No " );
				SelectSqlString.append("  AND a.src_Facility_Id = c.Facility_Id " );
				SelectSqlString.append("  AND a.Volume_No = c.Volume_No " );
				SelectSqlString.append("  AND c.Curr_File_Status IN ('T','E') " );
				SelectSqlString.append("  AND c.Doc_Folder_Id IS" );
				SelectSqlString.append("  NULL " );
				SelectSqlString.append("ORDER BY" );
				SelectSqlString.append("  a.File_No,a.Volume_No " );
			}
		}
		else
		{
			if(file_type_appl_yn.equals("N"))
			{
			       /*Below query modified foe this CRF HSA-CRF-0306.1*/
			
					SelectSqlString.append("Select a.file_no, get_patient_line(a.patient_id,'"+localeName+"') pline,a.file_type_code, TO_CHAR(a.sent_date_time,'dd/mm/yyyy hh24:mi') sent_date_time, src_facility_id, src_fs_locn_code, DECODE(A.SRC_LOCN_IDENTITY,'C','Clinic','D','Department','N','Nursing Unit','T','Practitioner','X','External','E','Procedure Unit','Y','Daycare Unit') src_locn_identity,  dest_facility_id, dest_fs_locn_code, dest_locn_identity, long_desc src_fs_locn_desc,Ltrim(Rtrim(a.req_Remarks)) req_Remarks,Ltrim(Rtrim(a.iss_remarks)) iss_remarks, a.volume_no,c.curr_file_status,curr_locn_id, c.patient_id patientid FROM fm_transit_file a, fm_storage_locn b,fm_curr_locn c where dest_facility_id = '"+facility_id+"' and dest_fs_locn_code = '"+FSLocation+"' and a.src_facility_id = b.facility_id AND a.src_fs_locn_code = b.fs_locn_code AND ( ");
			StringTokenizer pat_volumeno=new StringTokenizer(p_stored_val,"/");  
	    count_tokens=pat_volumeno.countTokens();
	    int P_cnt=0;
	  while(pat_volumeno.hasMoreTokens())
		{
	    P_cnt++;
	   patientno_volume    =pat_volumeno.nextToken() ;
	StringTokenizer fileno1=new StringTokenizer(patientno_volume,"`");		
	while(fileno1.hasMoreTokens())
		{
	pat_id =fileno1.nextToken();	
	if(fileno1.hasMoreTokens())
	file_type_no	=fileno1.nextToken();
	if(fileno1.hasMoreTokens())
	vol_no	=fileno1.nextToken();
	}
	 SelectSqlString.append("  (a.patient_id ='"+pat_id+"' ");
	SelectSqlString.append(" and a.file_no ='"+file_type_no+"' ");
	
		if(count_tokens >P_cnt){
  	 SelectSqlString.append(" AND a.volume_no ='"+vol_no+"' ) OR ");	
			} else{
                    SelectSqlString.append("AND a.volume_no ='"+vol_no +"' )");	
			}
				
		}	
		SelectSqlString.append(") AND a.file_no = c.file_no AND a.dest_facility_id = c.curr_facility_id AND a.volume_no = c.volume_no AND c.curr_file_status IN('T','E') AND c.doc_folder_id IS NULL ORDER BY a.file_no,a.volume_no");
				
		}
			else if(file_type_appl_yn.equals("Y"))
			{
				SelectSqlString.append("select a.file_no, get_patient_line(a.patient_id,'"+localeName+"') pline,a.file_type_code,c.short_desc file_type_desc, TO_CHAR(a.sent_date_time,'dd/mm/yyyy hh24:mi') sent_date_time, a.src_facility_id, a.src_fs_locn_code, DECODE(A.SRC_LOCN_IDENTITY,'C','Clinic','D','Department','N','Nursing Unit','T','Practitioner','X','External','E','Procedure Unit','Y','Daycare Unit') src_locn_identity,  dest_facility_id, dest_fs_locn_code, dest_locn_identity, b.short_desc src_fs_locn_desc, Ltrim(Rtrim(a.req_Remarks)) req_Remarks,Ltrim(Rtrim(a.iss_remarks)) iss_remarks, a.volume_no,d.curr_file_status, curr_locn_id, d.patient_id patientid FROM fm_transit_file a, fm_storage_locn b,mr_file_type c,fm_curr_locn d WHERE a.src_facility_id = c.facility_id(+) AND a.file_type_code = c.file_type_code(+) AND dest_facility_id = '"+facility_id+"' AND dest_fs_locn_code = '"+FSLocation+"' AND a.src_facility_id = b.facility_id AND a.src_fs_locn_code = b.fs_locn_code  AND (");
		
	 StringTokenizer pat_volumeno=new StringTokenizer(p_stored_val,"/");  
	  count_tokens=pat_volumeno.countTokens();
	   int P_cnt=0;
	  while(pat_volumeno.hasMoreTokens())
		{
	    P_cnt++;
	   patientno_volume    =pat_volumeno.nextToken() ;
	StringTokenizer fileno1=new StringTokenizer(patientno_volume,"`");		
	while(fileno1.hasMoreTokens())
		{
	pat_id =fileno1.nextToken();	
	if(fileno1.hasMoreTokens())
	file_type_no	=fileno1.nextToken();
	if(fileno1.hasMoreTokens())
	vol_no	=fileno1.nextToken();
	}
	 SelectSqlString.append("  (a.patient_id ='"+pat_id+"' ");
	 SelectSqlString.append(" and a.file_no ='"+file_type_no+"' ");
	 
	
		if(count_tokens >P_cnt){
  		 SelectSqlString.append(" AND a.volume_no ='"+vol_no+"' ) OR ");	
			} else{
               	     SelectSqlString.append("AND a.volume_no ='"+vol_no +"' )");	
			}
						
		}	
		//SelectSqlString.append(") AND a.file_no = d.file_no AND a.dest_facility_id = d.curr_facility_id AND a.volume_no = d.volume_no AND d.curr_file_status IN('T','E') AND d.doc_folder_id IS NULL ORDER BY a.file_no,a.volume_no");
	
		SelectSqlString.append(") AND a.file_no = d.file_no AND a.volume_no = d.volume_no AND d.curr_file_status IN('T','E') AND d.doc_folder_id IS NULL ORDER BY a.file_no,a.volume_no");
		
		}
		}
		
		
			pstmt = con.prepareStatement(SelectSqlString.toString());
			rs = pstmt.executeQuery();

			while(rs != null && rs.next()) 
			{
				if(i % 2 == 0) classValue = "QRYODD" ;
				else classValue = "QRYEVEN" ;

				fileno			= rs.getString("file_no");
				pline			= rs.getString("pline").substring(0,rs.getString("pline").length()-6);
				filetypecode	= rs.getString("file_type_code");
				volumeno		= rs.getString("volume_no");
				senderfacility	= rs.getString("src_facility_id");
				senderlocn		= rs.getString("src_fs_locn_code");
				senderlocndesc	= rs.getString("src_fs_locn_desc");
				senderlocnid	= rs.getString("src_locn_identity");
				issuedate		= rs.getString("sent_date_time");
				p_req_remarks	= rs.getString("req_remarks")==null?"":rs.getString("req_remarks");
				//	p_req_remarks=java.net.URLDecoder.decode(p_req_remarks,"UTF-8");
				p_iss_remarks	= rs.getString("iss_remarks")==null?"":rs.getString("iss_remarks");
            //    p_iss_remarks	=java.net.URLDecoder.decode(p_iss_remarks,"UTF-8");
			    /*Below line added for this CRF HSA-CRF-0306.1*/
				fs_curr_locn_id	= rs.getString("curr_locn_id")==null?"":rs.getString("curr_locn_id");
				patientid = rs.getString("patientid")==null?"":rs.getString("patientid");
			  	if(!senderlocnid.equals("")){
				switch(senderlocnid.charAt(0))
					{
						case 'D' : senderlocnid = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels");
                        loca_identity="D";
						break;
						case 'C' : senderlocnid = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); 
                          loca_identity="C";
						break;
						case 'N' : senderlocnid = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); 
                        loca_identity="N";
						break;
						case 'T' : senderlocnid = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
                        loca_identity="T";
						break;
						case 'X' : senderlocnid1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); 
                        loca_identity="X";
						break;
						case 'E' : senderlocnid= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
                        loca_identity="E";
						break;
						case 'Y' : senderlocnid = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); 
				        loca_identity="Y";
					    break; 
					}
		}
				
				if(fileno == null || fileno.equals("null")) fileno = "";
				if(pline == null || pline.equals("null")) pline = "&nbsp;";
				if(issuedate != null)
				{
					issuedate=DateUtils.convertDate(issuedate,"DMYHM","en",localeName);
				}
				else
					issuedate = "";
				if(filetypecode == null || filetypecode.equals("null")) file_type_desc = "";
				if(volumeno == null || volumeno.equals("null")) volumeno = "";
				if(p_req_remarks == null || p_req_remarks.equals("null")) p_req_remarks = "";
				if(p_iss_remarks == null || p_iss_remarks.equals("null")) p_iss_remarks = "";
				
				if(senderlocnid == null || senderlocnid.equals("null"))  senderlocnid = "";
				if(senderlocn == null || senderlocn.equals("null"))  senderlocn = "";
				if(senderlocndesc == null || senderlocndesc.equals("null")) senderlocndesc = "";
				if(senderfacility == null || senderfacility.equals("null")) 
					senderfacility = "&nbsp;";
				if(file_type_appl_yn.equals("N"))
				{
					out.println("<tr><td class='"+classValue+"'  width='30%'>");
					out.println("<font size=1><b>"+fileno+"</b><br>&nbsp;&nbsp;"+pline+"</font></td>");
					
					out.println("<td class='"+classValue+"' width='12%'><font size=1><CENTER>");
				}
				else if(file_type_appl_yn.equals("Y"))
				{
					out.println("<tr><td class='"+classValue+"' width='30%'>");
					out.println("<font size=1>&nbsp;"+pline+"</font></td>");
					
					out.println("<td class='"+classValue+"' width='12%'><font size=1><CENTER>");
					file_type_desc = rs.getString("FILE_TYPE_DESC");
					if(file_type_desc == null || file_type_desc.equals("null")) 
						file_type_desc = "&nbsp;";
					out.println(file_type_desc);
					if(!file_type_desc.equals("&nbsp;"))
						out.println(" / ");
				}
				out.println(volumeno+"</CENTER></font></td>");
				out.println("<td class='"+classValue+"' width='8%'><font size=1 color='red'>");
				if(p_req_remarks.equals("") )
				{
					out.println("&nbsp;</font></td>");
				}
				else
				{
				
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(i));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_req_remarks));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
					
				}
				out.println("<td class='"+classValue+"' width='20%'>");

				if(senderlocndesc == null || senderlocndesc.equals("null"))
					out.println("&nbsp;</td>");
				else
				out.println("<font size=1>"+senderlocndesc+" - ("+senderlocnid+")</font></td>");
				out.println("<td  class='"+classValue+"' width='8%'><font size=1>");

				if(p_iss_remarks.equals(""))
				{
					out.println("&nbsp;</font></td>");
				}
				else
				{
				
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_iss_remarks));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
					
				}
				out.println("<td align='center' class='"+classValue+"'width='15%' >");
				out.println("<font size=1>"+issuedate+"</font></td>");
				out.println("<td  align='center' class='"+classValue+"' width='7%'>");
				out.println("<input type='checkbox' name='confirmbox"+i+"' id='confirmbox"+i+"' value='Y' Checked onClick='confirmSelection(this);'></td></tr>");
				out.println("<input type='hidden' name='file"+i+"' id='file"+i+"' value='"+fileno+"'>");
				out.println("<input type='hidden' name='filetype"+i+"' id='filetype"+i+"' value='"+filetypecode+"'>");
				out.println("<input type='hidden' name='volume"+i+"' id='volume"+i+"' value='"+volumeno+"'>");
				out.println("<input type='hidden' name='issuelocn"+i+"' id='issuelocn"+i+"' value='"+senderlocn+"'>");
				out.println("<input type='hidden' name='senderfacility"+i+"' id='senderfacility"+i+"' value='"+senderfacility+"'>");
				out.println("<input type='hidden' name='ReqComm"+i+"' id='ReqComm"+i+"' value='"+p_req_remarks+"'>");
				out.println("<input type='hidden' name='txtComm"+i+"' id='txtComm"+i+"' value='"+p_iss_remarks+"'>");				
				out.println("<input type='hidden' name='fs_curr_locn_id"+i+"' id='fs_curr_locn_id"+i+"' value='"+fs_curr_locn_id+"'>"); //Added for this CRF HSA-CRF-0306.1
				out.println("<input type='hidden' name='patientid"+i+"' id='patientid"+i+"' value='"+patientid+"'>"); //Added for this CRF HSA-CRF-0306.1 
				i++;
				p_rec_cnt++;
			}

			if((SelectSqlString != null) && (SelectSqlString.length() >0))
			{
				SelectSqlString.delete(0,SelectSqlString.length());
			}
			
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(p_rec_cnt ));
            _bw.write(_wl_block16Bytes, _wl_block16);

	if(rs!=null)	rs.close();
	if(pstmt!=null) pstmt.close();
	}catch(Exception e){
		e.printStackTrace();
		}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(hdrec_locn_iden));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(file_type_appl_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);

if(flag.equals("C"))
{
	if(session.getAttribute("objKey") != null)
		session.removeAttribute("objKey");
}
session.setAttribute("objKey",list);

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
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
