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
import eCommon.Common.*;
import eFM.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmtransferfileresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMTransferFileResult.jsp", 1726153005000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMTransferFile.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body OnMouseDown=\"CodeArrest();\" onKeyDown = \'lockKey();\'>\n<form name=\'FMTransferFileResult_form\' id=\'FMTransferFileResult_form\' method=\'post\' target=\'messageFrame\' action=\'../../servlet/eFM.FMTransferFileServlet\'>\n<script>parent.transfer_criteria.document.getElementById(\"hdr_tab\").style.visibility = \'Visible\';</script>\n<table id=\'tb1\' border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' >\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<script>\n\t\t\t\tparent.frames[2].document.forms[0].tofslocn.disabled=false;\t\t\t\t\n\t\t\t\tparent.frames[2].document.forms[0].narration.disabled=false;\n\t\t\t\tparent.frames[2].document.forms[0].FS_LOCN_ID.disabled=false;\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\tvar p_rec_cnt = \'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\';\n\t\t\t\tvar curr_file_status=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'\n\t\t\t\tvar patient_id1=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'\n\t\t\t\tvar rec_count=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'\n\t\t\t\tif ((p_rec_cnt==0 && curr_file_status!=\"L\"))\t\n\t\t\t\t{\n\t\t\t\t\tparent.transfer_criteria.document.getElementById(\"hdr_tab\").style.visibility = \'hidden\';\n\t\t\t\t\talert(getMessage(\'NO_FILE_FOR_TRANSFER\',\'FM\'));\n\t\t\t\t\tparent.frames[4].document.location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t\tparent.frames[2].document.forms[0].tofslocn.disabled=false;\n\t\t\t\t\tparent.frames[2].document.forms[0].narration.disabled=false;\n\t\t\t\t\tparent.frames[2].document.forms[0].FS_LOCN_ID.disabled=false;\t\t\t\n\t\t\t\t   parent.frames[3].document.forms[0].patient_id.value = \"\";\n\t               parent.frames[3].document.forms[0].patient_id.onblur();\n\t\t\t\t} else if(rec_count==0 && patient_id1!=\"\") {\n                alert(getMessage(\'NO_FILE_FOR_TRANSFER\',\'FM\'));\n\t\t\t\t}\n\t\t\t\n\t\t\tif(curr_file_status==\"L\")\n\t\t\t{\n                   parent.transfer_criteria.document.getElementById(\"hdr_tab\").style.visibility = \'hidden\';\n\t\t\t\t\talert(getMessage(\'FILE_IS_LOST\',\'FM\'));\n\t\t\t\t//\tparent.frames[4].document.location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t\tparent.frames[2].document.forms[0].tofslocn.disabled=false;\n\t\t\t\t\tparent.frames[2].document.forms[0].narration.disabled=false;\n\t\t\t\t\tparent.frames[2].document.forms[0].FS_LOCN_ID.disabled=false;\t\t\t\n\t\t\t\tparent.frames[3].document.forms[0].patient_id.value = \"\";\n\t        parent.frames[3].document.forms[0].patient_id.onblur();\n\n\t\t\t}\n\t\t\t</script>\n\t\t\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t</table>\n<script>\n\tfor (i=0;i<4;i++)\n\t{\n\t\tconsole.log(document.getElementById(\"tb1\"));\n\t\tif((document.getElementById(\"tb1\").rows[i + 1] != null) && (document.getElementById(\"tb1\").rows[i + 1].cells[i] != null))\n\t\t{\n\t\t\tparent.transfer_criteria.document.getElementById(\"hdr_tab\").rows[0].cells[i].width = document.getElementById(\"tb1\").rows[i + 1].cells[i].width;\n\n\t\t}\n\t}\n\tparent.frames[3].document.forms[0].patient_id.value = \"\";\n\tparent.frames[3].document.forms[0].patient_id.focus();\n\tparent.frames[3].document.forms[0].patient_id.onblur();\n     \n</script>\n\t<input type=\'hidden\' name=\'count\' id=\'count\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t<input type=\'hidden\' name=\'FileList\' id=\'FileList\' value=\'\'>\n\t<input type=\'hidden\' name=\'FileTypeList\' id=\'FileTypeList\' value=\'\'>\n\t<input type=\'hidden\' name=\'VolumeList\' id=\'VolumeList\' value=\'\'>\n\t<input type=\'hidden\' name=\'FromLocnCode\' id=\'FromLocnCode\' value=\'\'>\n\t<input type=\'hidden\' name=\'TransferUserId\' id=\'TransferUserId\' value=\'\'>\n\t<input type=\'hidden\' name=\'iss_remarks\' id=\'iss_remarks\' value=\'\'>\n\t<input type=\'hidden\' name=\'resultPage_carried_by_name\' id=\'resultPage_carried_by_name\' value=\'\'>\n\t<input type=\'hidden\' name=\'resultPage_file_trans_mode\' id=\'resultPage_file_trans_mode\' value=\'\'>\n\t<input type=\'hidden\' name=\'file_type_appl_yn\' id=\'file_type_appl_yn\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t<input type=\'hidden\' name=\'auto_rec_ward_yn\' id=\'auto_rec_ward_yn\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t<input type=\'hidden\' name=\'auto_rec_clinic_yn\' id=\'auto_rec_clinic_yn\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t<input type=\'hidden\' name=\'auto_rec_pract_yn\' id=\'auto_rec_pract_yn\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n   <input type=\'hidden\' name=\'auto_rec_dept_yn\' id=\'auto_rec_dept_yn\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n   <!--Added for this CRF HSA-CRF-0306.1-->\n   <input type=\'hidden\' name=\'isCurrentFsLocation\' id=\'isCurrentFsLocation\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'> \n   <input type=\'hidden\' name=\'noofdhtoreturn\' id=\'noofdhtoreturn\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'> \n   <input type=\'hidden\' name=\'duration_type\' id=\'duration_type\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'> \n   <input type=\'hidden\' name=\'fslocn_return_criteria\' id=\'fslocn_return_criteria\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>   \n   <input type=\'hidden\' name=\'permanent_file_area_yn\' id=\'permanent_file_area_yn\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>       \n   <input type=\'hidden\' name=\'sys_date\' id=\'sys_date\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'> <!--Added for this CRF HSA-CRF-0306.1 linked incident-->\n   <!--End HSA-CRF-0306.1 -->\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );
	
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

		Connection conn			= ConnectionManager.getConnection(request);
		PreparedStatement pstmt	=	null;
		ResultSet rs			=	null;

		StringBuffer SelectSqlBuffer	= null;

		String facility_id			= (String) session.getValue("facility_id");

		String classValue			= "";		
		String filetypedesc			= "";
		String p_file_type_code		= "";
		String p_doc_folder_id		= "";
		String p_doc_type_code		= "";
		String FromLocn				= "";	
		String ToLocn				= "";	
		String ToLocnDesc			= "";
		String ToNarration			= "";
		String patient_id			= "";
		String FileNo				= "";
		String file_type_code		= "";
		String volume_no			= "";
		String trans_from			= "";
		String trans_to				= "";
		String file_type_appl_yn	= "";
		String auto_rec_ward_yn		= ""; 
		String auto_rec_clinic_yn	= "";
		String auto_rec_pract_yn	= "";
		String  auto_rec_dept_yn="";
		String Locn_Identity	= "";
        int count_tokens=0;
		String pat_id  ="";
		String vol_no  ="";
		String p_stored_val="";
		StringBuffer moreCriteria	= null;
		moreCriteria					= new StringBuffer();
		String patientno_volume="";
		String curr_file_status="";
		String str="";
		String filetype="";
		String filenum="";
		String volume_no1="";
		String patient_id1="";
		String filetypecode="";
		String fac_id="";
		int rowid = 0;
		int i = 0, p_rec_cnt = 0;
		int rec_count=0;
		//Added for this CRF HSA-CRF-0306.1
		boolean isCurrentFsLocation =false; 	
		String noofdhtoreturn = "";
		String duration_type = "";
		String fslocn_return_criteria="",permanent_file_area_yn="";
		String sys_date	= ""; //Added for this HSA-CRF-0306.1 linked incident
			
        Properties p=(java.util.Properties) session.getValue("jdbc"); 		
		//End for this CRF HSA-CRF-0306.1
		
		try
		{
		
		   isCurrentFsLocation = CommonBean.isSiteSpecific(conn,"FM","CURRENT_FS_LOCATION");//Added for this CRF HSA-CRF-0306.1
		
			SelectSqlBuffer = new StringBuffer();

			FromLocn			= request.getParameter("FromLocn");	
			ToLocn				= request.getParameter("ToLocn");	
			ToLocnDesc			= request.getParameter("ToLocnDesc");
			ToNarration			= request.getParameter("ToNarration");
			patient_id			= request.getParameter("patient_id");
			FileNo				= request.getParameter("FileNo");
			file_type_code		= request.getParameter("file_type_code");
			volume_no			= request.getParameter("volume_no");
			trans_from			= request.getParameter("trans_from");
			trans_to			= request.getParameter("trans_to");
			file_type_appl_yn	= request.getParameter("file_type_appl_yn");
			auto_rec_ward_yn	= request.getParameter("auto_rec_ward_yn");
			auto_rec_clinic_yn	= request.getParameter("auto_rec_clinic_yn");
			auto_rec_pract_yn	= request.getParameter("auto_rec_pract_yn");
			auto_rec_dept_yn	= request.getParameter("auto_rec_dept_yn");
			p_stored_val         =request.getParameter("p_stored_val");
	     	filetype         =request.getParameter("filetype");
			filenum       	  =request.getParameter("filenum");
			volume_no1         =request.getParameter("volume_no1");
			patient_id1       	  =request.getParameter("patient_id1");
			
			if(volume_no1 == null || volume_no1.equals("null")) volume_no1 = "";
			if(patient_id1 == null || patient_id1.equals("null")) patient_id1= "";
			if(filenum == null || filenum.equals("null")) filenum = "";
			if(filetype == null || filetype.equals("null")) filetype = "";
			if(FromLocn == null || FromLocn.equals("null")) FromLocn = "";
			if(p_stored_val == null || p_stored_val.equals("null")) p_stored_val = "";
			if(ToLocn == null || ToLocn.equals("null")) ToLocn = "";
			if(ToLocnDesc == null || ToLocnDesc.equals("null")) ToLocnDesc = "";
			if(file_type_code == null || file_type_code.equals("null")) file_type_code = "";
			if(volume_no == null || volume_no.equals("null")) volume_no = "";
			if(FileNo == null ||  FileNo.equals("null")) FileNo = "";	
			if(file_type_appl_yn == null || file_type_appl_yn.equals("null")) file_type_appl_yn = "";
			if(ToNarration == null || ToNarration.equals("null")) ToNarration = "";
			if(patient_id == null || patient_id.equals("null")) patient_id = "";
			if(trans_from == null || trans_from.equals("null")) trans_from = "";
			if(trans_to == null || trans_to.equals("null")) trans_to = "";
			if(auto_rec_ward_yn == null || auto_rec_ward_yn.equals("null")) auto_rec_ward_yn = "";
			if(auto_rec_clinic_yn == null || auto_rec_clinic_yn.equals("null")) auto_rec_clinic_yn = "";
			if(auto_rec_pract_yn == null || auto_rec_pract_yn.equals("null")) auto_rec_pract_yn = "";
			if(auto_rec_dept_yn == null || auto_rec_dept_yn.equals("null")) auto_rec_dept_yn = "";
			
		/*Below line added for this CRF HSA-CRF-0306.1*/
		String sqlQuery="SELECT (CASE  WHEN locn_identity IN 'C' and exists (SELECT 1 FROM op_clinic             WHERE clinic_type = 'C' AND level_of_care_ind = 'E'   AND clinic_code = ? AND mr_location_code = ? ) THEN  no_of_dh_to_return_em     ELSE (CASE                  WHEN locn_identity IN ('C', 'E') THEN no_of_dh_to_return_op   ELSE (CASE                            WHEN locn_identity = 'N' THEN no_of_dh_to_return_ip    ELSE (CASE                                      WHEN locn_identity = 'Y' THEN no_of_dh_to_return_dc   END)  END)                  END) END) no_of_dh_to_return,duration_type,return_criteria,permanent_file_area_yn,to_char(sysdate,'dd/mm/yyyy hh24:mi') sydat  FROM fm_storage_locn WHERE fs_locn_code = ? AND facility_id = ? " ;
			
			
            			
		    pstmt=conn.prepareStatement(sqlQuery);
		    pstmt.setString(1,trans_to);
			pstmt.setString(2,ToLocn);
			pstmt.setString(3,ToLocn);
			pstmt.setString(4,facility_id);
			rs = pstmt.executeQuery();		
			if(rs != null && rs.next())
			{				
				noofdhtoreturn= rs.getString(1);
				duration_type	= rs.getString(2);
				fslocn_return_criteria= rs.getString(3); //Added for this CRF HSA-CRF-0306.1
				permanent_file_area_yn= rs.getString(4);
				sys_date = rs.getString(5);
						
			}
			if(noofdhtoreturn==null || noofdhtoreturn.equals("")) noofdhtoreturn = "0";
			if(duration_type == null || duration_type.equals("null"))	  duration_type = "";			
			if(fslocn_return_criteria == null || fslocn_return_criteria.equals("null")) fslocn_return_criteria = ""; 
			if(fslocn_return_criteria.equals("")) fslocn_return_criteria="I";				
		    if(rs!=null)	rs.close();
		    if(pstmt!=null) pstmt.close();
					
			
			//End HSA-CRF-0306.1
				
			
			if(!filetype.equals("") || !filenum.equals(""))
			{

           if(file_type_appl_yn.equals("N"))
             {
     str="select curr_file_status,(select count(*) from fm_curr_locn where patient_id='"+patient_id1+"' AND file_no='"+filenum+"' and volume_no='"+volume_no1+"' and Curr_File_Status in( 'O','I') and Curr_fs_Locn_Code='"+FromLocn+"'  and Curr_Facility_Id='"+facility_id+"') cnt from fm_curr_locn where patient_id='"+patient_id1+"' AND file_no='"+filenum+"' and volume_no='"+volume_no1+"' ";
		 }
     if(file_type_appl_yn.equals("Y"))
     { 
   	 StringTokenizer filetypecode_fac1=new StringTokenizer(filetype,"~");  
	if(filetypecode_fac1.hasMoreTokens())
	filetypecode	=filetypecode_fac1.nextToken();
	 if(filetypecode_fac1.hasMoreTokens())
	fac_id	=filetypecode_fac1.nextToken();
  
	  str="select curr_file_status,(select count(*) from fm_curr_locn where patient_id='"+patient_id1+"' AND file_no='"+filenum+"'  AND file_type_code='"+filetypecode+"' and volume_no='"+volume_no1+"' and Curr_File_Status in( 'O','I') and Curr_fs_Locn_Code='"+FromLocn+"'  and   Curr_Facility_Id='"+facility_id+"') cnt from fm_curr_locn where patient_id='"+patient_id1+"' AND file_type_code='"+filetypecode+"' and file_no='"+filenum+"'  AND volume_no='"+volume_no1+"' ";
	  }
					
		
			pstmt = conn.prepareStatement(str);
			rs = pstmt.executeQuery();
			
			while(rs != null && rs.next())
			{
				
				curr_file_status			= rs.getString("curr_file_status");	
			    rec_count                   = rs.getInt("cnt");	
			if(curr_file_status==null) curr_file_status="";
			}
			
			}
		
				
		if(rs!=null)	rs.close();
		if(pstmt!=null) pstmt.close();
			
			
				if(file_type_appl_yn.equals("N"))
			{
				if(!(FileNo == null || FileNo.equals("null") || FileNo.equals("")))
				{
					moreCriteria.append(" AND a.patient_id in ("+patient_id+") ");
					moreCriteria.append(" AND a.file_no in ("+FileNo+") ");
					if(!(volume_no == null || volume_no.equals("")))
					{
						moreCriteria.append(" AND a.volume_no in ("+volume_no+") ");
					}
				}
			}
			else if(file_type_appl_yn.equals("Y"))
			{
			/*	if(!(file_type_code == null || file_type_code.equals("null") || file_type_code.equals("")))
				{
					moreCriteria.append(" AND a.patient_id in ("+patient_id+") ");
					moreCriteria.append(" AND a.file_type_code in ("+file_type_code+") ");
					if(!(volume_no == null || volume_no.equals("")))
					{
						moreCriteria.append(" AND a.volume_no in ("+volume_no+") ");
					}
				} */
		if(!(file_type_code == null || file_type_code.equals("null") || file_type_code.equals("")))
				{
		StringTokenizer pat_volumeno=new StringTokenizer(p_stored_val,"/");  
	    count_tokens=pat_volumeno.countTokens();
	   int P_cnt=0;
	 moreCriteria.append( "AND ( ");
	  while(pat_volumeno.hasMoreTokens())
		{
	    P_cnt++;
	   patientno_volume    =pat_volumeno.nextToken() ;
	StringTokenizer fileno1=new StringTokenizer(patientno_volume,"`");		
	while(fileno1.hasMoreTokens())
		{
	pat_id =fileno1.nextToken();	
	if(fileno1.hasMoreTokens())
	filetypecode	=fileno1.nextToken();
	StringTokenizer filetypecode_fac=new StringTokenizer(filetypecode,"~");  
	if(filetypecode_fac.hasMoreTokens())
	filetypecode	=filetypecode_fac.nextToken();
	if(filetypecode_fac.hasMoreTokens())
	fac_id	=filetypecode_fac.nextToken();
	if(fileno1.hasMoreTokens())
	vol_no	=fileno1.nextToken();
	}
	
	 moreCriteria.append( " ( a.PATIENT_ID ='"+pat_id+"' ");
     //moreCriteria.append("  AND a.file_type_code='"+filetypecode+"'  ");
	moreCriteria.append("  AND a.file_no='"+filetypecode+"'  ");
	
		if(count_tokens >P_cnt){
   		moreCriteria.append(" AND a.VOLUME_NO ='"+vol_no+"' ) OR ");	
			} else{
      	     	moreCriteria.append(" AND a.VOLUME_NO ='"+vol_no +"' )");	
			}
						}
		
		moreCriteria.append(" ) ");
		//moreCriteria.append(" ) AND a.file_type_code in ("+file_type_code+") ");
				}		
			}
			if(file_type_appl_yn.equals("N"))
			{
				//SelectSqlBuffer.append("SELECT a.patient_id,a.file_no,a.file_type_code,a.doc_type_code,a.doc_folder_id,get_patient_line(a.patient_id) pline,DECODE(B.LOCN_IDENTITY,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','X','External','E','Procedure Unit','Y','Daycare Unit') locn_iden,a.volume_no FROM fm_curr_locn_vw a, fm_storage_locn b WHERE a.curr_facility_id = ? and a.curr_fs_locn_code =  ? and a.curr_file_status = 'O' "+moreCriteria+" AND a.curr_locn_id = ? AND a.curr_facility_id = b.facility_id AND b.fs_locn_code = ? AND a.doc_folder_id is null ORDER BY a.file_no,a.volume_no");
				SelectSqlBuffer.append("SELECT" );
				SelectSqlBuffer.append("  a.Patient_Id" );
				SelectSqlBuffer.append("  , a.File_No" );
				SelectSqlBuffer.append("  , a.File_Type_Code" );
				SelectSqlBuffer.append("  , a.Doc_Type_Code" );
				SelectSqlBuffer.append("  , a.Doc_Folder_Id" );
				SelectSqlBuffer.append("  , Get_patient_line(a.Patient_Id,'"+localeName+"') PlIne" );
				SelectSqlBuffer.append("  , B.LOCN_IDENTITY Locn_Iden" );
				SelectSqlBuffer.append("  , a.Volume_No " );
				SelectSqlBuffer.append("FROM" );
				SelectSqlBuffer.append("  fm_Curr_Locn a" );
				SelectSqlBuffer.append("  , fm_Storage_Locn b " );
				//SelectSqlBuffer.append("WHERE  a.Curr_Facility_Id = ? " );
				SelectSqlBuffer.append("WHERE  b.fs_Locn_Code  = ? " );
				SelectSqlBuffer.append("  AND a.Curr_File_Status in('O','I')");
				SelectSqlBuffer.append("  AND a.Curr_fs_Locn_Code = ? " );
			//	SelectSqlBuffer.append("  AND  a.Curr_fs_Locn_Code<>a.perm_fs_locn_code " );
				//SelectSqlBuffer.append("  AND a.Curr_File_Status = 'O' " );
				SelectSqlBuffer.append(moreCriteria );
				//SelectSqlBuffer.append("  AND a.Curr_Locn_Id = ? " );
				SelectSqlBuffer.append("  AND a.Curr_Facility_Id = b.Facility_Id " );
			//	SelectSqlBuffer.append("  AND b.fs_Locn_Code = ? " );
				SelectSqlBuffer.append("  AND a.Curr_Facility_Id = ? " );
				SelectSqlBuffer.append("  AND a.Doc_Folder_Id IS" );
				SelectSqlBuffer.append("  NULL " );
				SelectSqlBuffer.append("ORDER BY" );
				SelectSqlBuffer.append("  a.file_no" );
				SelectSqlBuffer.append("  , a.volume_no" );
				}
			else if(file_type_appl_yn.equals("Y"))
			{
				//SelectSqlBuffer.append("SELECT a.patient_id, a.file_type_code, c.short_desc file_type_desc,a.file_no, a.doc_type_code, a.doc_folder_id, get_patient_line (a.patient_id) pline, DECODE(b.locn_identity,' D', 'Department', 'C', 'Clinic', 'N', 'Nursing Unit', 'T', 'Practitioner', 'X', 'External', 'E', 'Procedure Unit', 'Y', 'Daycare Unit' ) locn_iden, a.volume_no FROM fm_curr_locn a, fm_storage_locn b, mr_file_type c WHERE a.curr_facility_id = ? AND a.curr_fs_locn_code = ? AND a.curr_file_status = 'O' "+moreCriteria+" AND a.curr_locn_id = ? AND a.curr_facility_id = b.facility_id AND b.fs_locn_code = ? AND a.doc_folder_id IS NULL AND a.facility_id = c.facility_id AND a.file_type_code = c.file_type_code(+) ORDER BY a.file_no, a.volume_no");
				SelectSqlBuffer.append("SELECT" );
				SelectSqlBuffer.append("  a.Patient_Id" );
				SelectSqlBuffer.append("  , a.File_Type_Code" );
				SelectSqlBuffer.append("  , MR_GET_DESC.MR_FILE_TYPE(A.FACILITY_ID, A.FILE_TYPE_CODE,'"+localeName+"','2') File_Type_desc" );
				SelectSqlBuffer.append("  , a.File_No" );
				SelectSqlBuffer.append("  , a.Doc_Type_Code" );
				SelectSqlBuffer.append("  , a.Doc_Folder_Id" );
				SelectSqlBuffer.append("  , Get_patient_line(a.Patient_Id,'"+localeName+"') PlIne" );
				SelectSqlBuffer.append("  , b.Locn_Identity Locn_Iden" );
				SelectSqlBuffer.append("  , a.Volume_No " );
				SelectSqlBuffer.append("FROM" );
				SelectSqlBuffer.append("  fm_Curr_Locn a" );
				SelectSqlBuffer.append("  , fm_Storage_Locn b " );
				//SelectSqlBuffer.append("WHERE  a.Curr_Facility_Id = ? " );
				SelectSqlBuffer.append("WHERE  b.fs_Locn_Code  = ? " );
				SelectSqlBuffer.append("  AND a.Curr_File_Status in('O','I')");
				SelectSqlBuffer.append("  AND a.Curr_fs_Locn_Code = ? " );
				//SelectSqlBuffer.append("  AND  a.Curr_fs_Locn_Code<>a.perm_fs_locn_code " );
				//SelectSqlBuffer.append("  AND a.Curr_File_Status = 'O' " );
				SelectSqlBuffer.append(moreCriteria );
				//SelectSqlBuffer.append("  AND a.Curr_Locn_Id = ? " );
				SelectSqlBuffer.append("  AND a.Curr_Facility_Id = b.Facility_Id " );
			//	SelectSqlBuffer.append("  AND b.fs_Locn_Code = ? " );
				SelectSqlBuffer.append("  AND a.Curr_Facility_Id = ? " );
				SelectSqlBuffer.append("  AND a.Doc_Folder_Id IS" );
				SelectSqlBuffer.append("  NULL " );
				SelectSqlBuffer.append("ORDER BY" );
				SelectSqlBuffer.append("  a.file_no" );
				SelectSqlBuffer.append("  , a.volume_no" );
				
			}
		
			pstmt = conn.prepareStatement(SelectSqlBuffer.toString());
			pstmt.setString(1,ToLocn);
			pstmt.setString(2,FromLocn);
			//pstmt.setString(3,trans_from);
			pstmt.setString(3,facility_id);
						
			rs	  = pstmt.executeQuery();
   			while(rs != null && rs.next())
			{
				classValue	=	( (i%2)==0 )? "QRYEVEN" : "QRYODD";
				rowid++;

				p_doc_folder_id  = rs.getString("doc_folder_id");
				p_doc_type_code  = rs.getString("doc_type_code");
				p_file_type_code = rs.getString("file_type_code");

				if(p_file_type_code == null || p_file_type_code.equals("null"))
					p_file_type_code = "";
				if(p_doc_folder_id == null || p_doc_folder_id.equals("null"))
					p_doc_folder_id = "";
				if(p_file_type_code == null || p_file_type_code.equals("null"))
					p_file_type_code = "";
			
			String PatientClass="";
			String Assigncarecode="";
			String dischargedatetime="";		
			String file_no=rs.getString("FILE_NO");	
            String Patient_Id=rs.getString("Patient_Id");	
			ArrayList List=(ArrayList)FMCurrentEncounterDetails.getCurrentEncounterDetails(conn,file_no,facility_id,p);			
			for(int k=0; k<List.size();k++){
			    FMCurrentEncounterDetailsBean currencounterDetails=(FMCurrentEncounterDetailsBean)List.get(k);                
				PatientClass=currencounterDetails.getPatientClass();
				Assigncarecode=currencounterDetails.getAssigncarecode();					   
			    dischargedatetime=currencounterDetails.getDischargedatetime();
			}

				if(file_type_appl_yn.equals("Y"))
				{
					out.println("<tr><td class='"+classValue+"' width='50%'><font size='1'>");
					out.println("&nbsp;"+rs.getString("PLINE").substring(0,rs.getString("PLINE").length()-6));

					out.println("</font></td><td class='"+classValue+"' width='15%'><font size='1'><CENTER>");
					filetypedesc = rs.getString("FILE_TYPE_DESC");
					if(filetypedesc == null || filetypedesc.equals("null")) filetypedesc = "&nbsp;";
					out.println(filetypedesc);
					if(!filetypedesc.equals("&nbsp;"))
						out.println(" / ");
				}
				else if(file_type_appl_yn.equals("N"))
				{
					out.println("<tr><td class='"+classValue+"' width='50%'><font size='1'><b>");
					out.println(rs.getString("FILE_NO"));
					out.println("</b><br>&nbsp;&nbsp;&nbsp;"+rs.getString("PLINE").substring(0,rs.getString("PLINE").length()-6));

					out.println("</font></td><td class='"+classValue+"' width='15%'><font size='1'><CENTER>");
				}
				out.println(rs.getString("volume_no")+"</CENTER>");
				out.println("</font></td><td class='"+classValue+"'  width='25%'><font size='1'>");
			Locn_Identity=rs.getString("LOCN_IDEN");
			if(!Locn_Identity.equals(""))
		{
			switch(Locn_Identity.charAt(0))
			{
				case 'D' : Locn_Identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels"); break;

				case 'C' : Locn_Identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); break;

				case 'N' : Locn_Identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); break;

				case 'T' : Locn_Identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); break;

				case 'X' : Locn_Identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;

				case 'E' : Locn_Identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"); break;

				case 'Y' : Locn_Identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); break;
		
			}
		}
				out.println(ToLocnDesc+"<br>&nbsp;&nbsp;&nbsp;("+Locn_Identity+")");
				out.println("</font></td><td align='center' class='"+classValue+"' width='10%'><font size='1'>");
				out.println("<input type='checkbox' name='confirm"+rowid+"' id='confirm"+rowid+"' checked>");
				out.println("</font></td></tr>");
				out.println("<input type='hidden' name='file"+rowid+"' id='file"+rowid+"' value='"+rs.getString("file_no")+"'>");
				out.println("<input type='hidden' name='filetype"+rowid+"' id='filetype"+rowid+"' value='"+p_file_type_code+"'>"); 
				out.println("<input type='hidden' name='volume"+rowid+"' id='volume"+rowid+"' value='"+rs.getString("volume_no")+"'>");
				out.println("<input type='hidden' name='docfolder"+rowid+"' id='docfolder"+rowid+"' value='"+p_doc_folder_id+"'>");
				out.println("<input type='hidden' name='doctype"+rowid+"' id='doctype"+rowid+"' value='"+p_doc_type_code+"'>"); 
				out.println("<input type='hidden' name='tolocns"+rowid+"' id='tolocns"+rowid+"' value='"+ToLocn+"'>");
				out.println("<input type='hidden' name='tonarration"+rowid+"' id='tonarration"+rowid+"' value='"+ToNarration+"'>");
				out.println("<input type='hidden' name='trans_to"+rowid+"' id='trans_to"+rowid+"' value='"+trans_to+"'>");
				
				//Added for this CRF HSA-CRF-0306.1
				out.println("<input type='hidden' name='patientClass"+rowid+"' id='patientClass"+rowid+"' value='"+PatientClass+"'>");
				out.println("<input type='hidden' name='assigncarecode"+rowid+"' id='assigncarecode"+rowid+"' value='"+Assigncarecode+"'>");
				out.println("<input type='hidden' name='dischargedatetime"+rowid+"' id='dischargedatetime"+rowid+"' value='"+dischargedatetime+"'>");				
				out.println("<input type='hidden' name='patient_id"+rowid+"' id='patient_id"+rowid+"' value='"+Patient_Id+"'>");
				
				
				i++;
				p_rec_cnt++;
			}

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(p_rec_cnt));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(curr_file_status));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_id1));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(rec_count));
            _bw.write(_wl_block12Bytes, _wl_block12);

		if(rs!=null)	rs.close();
		if(pstmt!=null) pstmt.close();
		}catch(Exception e){out.println("Exception :"+e.toString()); e.printStackTrace();}
		finally
		{				
			ConnectionManager.returnConnection(conn,request);			
		}

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(rowid));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(file_type_appl_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(auto_rec_ward_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(auto_rec_clinic_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(auto_rec_pract_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(auto_rec_dept_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(isCurrentFsLocation));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(noofdhtoreturn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(duration_type));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(fslocn_return_criteria));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(permanent_file_area_yn));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block25Bytes, _wl_block25);
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
