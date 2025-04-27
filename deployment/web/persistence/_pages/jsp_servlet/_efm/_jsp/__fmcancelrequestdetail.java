package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmcancelrequestdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMCancelRequestDetail.jsp", 1726141168289L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMCancelRequestFiles.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey();\'>\n<form name=\'CancelRequestDtl_form\' id=\'CancelRequestDtl_form\' action=\'../../servlet/eFM.FMCancelRequestServlet\' method=\'post\' target=\'messageFrame\'>\n<script>\n\tparent.frames[2].document.getElementById(\"hdr_tab0\").style.visibility = \'Visible\';\n\tparent.frames[2].document.getElementById(\"hdr_tab\").style.visibility = \'Visible\';\n</script>\n\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\' id=\"test\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<input type=\'checkbox\' name=\'cancelbox";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' id=\'cancelbox";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' checked value=\'N\' onClick=\'cancelSelection(this);\'></td>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t<a href=\'javascript:GetRemarks(";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =")\'>&nbsp;</a></font></td>\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =")\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</a></font></td></tr>\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" \n\t\t\t\t\n\t\t\t\t<input type=\'checkbox\'  name=\'cancelbox";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'   value=\'N\' onClick=\'cancelSelection(this);\'></td>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</a></font></td></tr>\n\t\t\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\n\t\t\t\t<input type=\"hidden\" name=\"rem_recnum_";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" id=\"rem_recnum_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" value=\"\">\n\t\t\t\t<input type=\"hidden\" name=\"p_req_remarks";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" id=\"p_req_remarks";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t<script>\n\t\t\t\tvar p_rec_cnt = \'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'\n\t\t\t\tvar curr_file_status = \'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'\n\t\t\t\tvar file_no_new= \'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'\n\t\t\t\tvar count= \'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'\n\t\t\t\tif(curr_file_status!=\"L\")\n\t\t\t{\n\t\t\tif (p_rec_cnt==0)\n\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\tparent.frames[2].document.forms[0].volumelistvals.value=\"\";\n                    parent.frames[2].document.forms[0].patientlistvals.value=\"\";\n\t                parent.frames[2].document.forms[0].filelistvals.value=\"\";\n\t\t\t\t\tparent.frames[2].document.getElementById(\"hdr_tab\").style.visibility = \'hidden\';\t\n\t\t\t\t\tparent.frames[2].document.getElementById(\"hdr_tab0\").style.visibility = \'hidden\';\n\t\t\t\t\talert(getMessage(\'NO_FILE_FOR_CANCEL_REQUEST\',\'FM\'));\n\t\t\t\t\tparent.frames[3].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t}else if(count==0 && file_no_new!=\"\")\n\t\t\t\t{\n\t\t\t\t\tparent.frames[2].document.getElementById(\"hdr_tab\").style.visibility = \'hidden\';\t\n\t\t\t\t\tparent.frames[2].document.getElementById(\"hdr_tab0\").style.visibility = \'hidden\';\n\t\t\t\t\talert(getMessage(\'NO_FILE_FOR_CANCEL_REQUEST\',\'FM\'));\n\t\t\t\t\tparent.frames[2].document.getElementById(\"hdr_tab\").style.visibility = \'Visible\';\t\n\t\t\t\t\tparent.frames[2].document.getElementById(\"hdr_tab0\").style.visibility = \'Visible\';\t\n\t\t\t\t\t\t}\n\t\t\t\tfor (i=0;i<6;i++)\n\t\t\t\t{\n\t\t\t\t\tif ((document.getElementById(\"test\").rows[i+1] != null) && (document.getElementById(\"test\").rows[i+1].cells[i] != null))\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.cancel_criteria.document.getElementById(\"hdr_tab\").rows[0].cells[i].width = document.getElementById(\"test\").rows[i+1].cells[i].width; \n\t\t\t\t\t}\n\t\t\t\t}\n\t\t  parent.frames[2].document.forms[0].patient_id.value = \"\";\n\t\t\tparent.frames[2].document.forms[0].patient_id.onblur();\n\t\t\t}\t\n\t\t\t\t\n\n\t\t\tif(curr_file_status==\"L\")\n\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\tvar p_rec_cnt=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\';\n\t\t\t\t\t\n\t\t\t\t\tif(p_rec_cnt==0)\n\t\t\t\t    {\n\t\t\t\t\tparent.frames[2].document.getElementById(\"hdr_tab\").style.visibility = \'hidden\';\t\n\t\t\t\t\tparent.frames[2].document.getElementById(\"hdr_tab0\").style.visibility = \'hidden\';\n\t\t\t\t\t}\n\t\t\t\t\tparent.frames[2].document.forms[0].volumelistvals.value=\"\";\n                    parent.frames[2].document.forms[0].patientlistvals.value=\"\";\n\t                parent.frames[2].document.forms[0].filelistvals.value=\"\";\n\t\t\t\t\t\t\t\t\n\t\t\t\t\talert(getMessage(\'FILE_IS_LOST\',\'FM\'));\n\t\t\t\t\t\t\t\t\n\t\t\t\t//\tparent.frames[3].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\n\t\t\t\tfor (i=0;i<6;i++)\n\t\t\t\t{\n\t\t\t\t\tif ((document.getElementById(\"test\").rows[i+1] != null) && (document.getElementById(\"test\").rows[i+1].cells[i] != null))\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.cancel_criteria.document.getElementById(\"hdr_tab\").rows[0].cells[i].width = document.getElementById(\"test\").rows[i+1].cells[i].width; \n\t\t\t\t\t}\n\t\t\t\t}\n\t\tparent.frames[2].document.forms[0].patient_id.value = \"\";\n\t\t\tparent.frames[2].document.forms[0].patient_id.onblur();\n\t\t\t}\n\t\t\t</script>\n\t\t\n\t\t\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t<script>\n\t\t    parent.frames[2].document.forms[0].patient_id.focus();\n\t\t\t\t\t\n\t\t</script>\n\t\t</table>\n\t\t<input type=\'hidden\' name=\'reccount\' id=\'reccount\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t<input type=\'hidden\' name=\'filenos\' id=\'filenos\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'volumenos\' id=\'volumenos\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'req\' id=\'req\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'remarks\' id=\'remarks\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'can_locn_code\' id=\'can_locn_code\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'file_type_appl_yn\' id=\'file_type_appl_yn\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );
	
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

		String facility_id			= (String) session.getValue("facility_id");
		String FSLocation			= request.getParameter("FSLocation");
		String file_num				= request.getParameter("fileno");
		String file_type_code		= request.getParameter("file_type_code");
		String patient_id			= request.getParameter("patient_id");
		String volume_no			= request.getParameter("volume_no");
		String request_date			= request.getParameter("RecDate");
		String file_type_appl_yn	= request.getParameter("file_type_appl_yn");
		String p_stored_val   = request.getParameter("p_stored_val");
	   	
		String filetype=request.getParameter("filetype");;
		String filenum=request.getParameter("filenum");
		String volume_no1=request.getParameter("volume_no1");
		String patient_id1=request.getParameter("patient_id1");
		String file_faci=request.getParameter("file_faci");
		
		String filetypedesc			= "";
		String patientno_volume="";
		String pat_id="";
		String vol_no="";
		String pat_file_vol= request.getParameter("pat_file_vol");
		String pat_file_vol1="";
		String patfilevol="";
		String status="false";
		String str="";
		String str1="";
		String file_no_new="";
		String curr_file_status="";
		int P_count=0;
		int count=0;
		int count_tokens=0;
		if(FSLocation == null || FSLocation.equals("null"))
			FSLocation = "";
		if(patient_id == null || patient_id.equals("null"))
			patient_id = "";
		if(pat_file_vol == null || pat_file_vol.equals("null"))
			pat_file_vol = "";
		
		if(file_faci == null || file_faci.equals("null"))
			file_faci = "";
		
		if(file_faci.equals(""))
		{
		file_faci=facility_id;
		}
		
		if(request_date != null)
		{
		request_date=DateUtils.convertDate(request_date,"DMY",localeName,"en");
		}
		else
			request_date = "";
		if(file_num == null || file_num.equals("null")) 
			file_num = "";
		if(file_type_code == null || file_type_code.equals("null"))
			file_type_code = "";
			if(volume_no == null || volume_no.equals("null")) 
			volume_no = "";
		if(file_type_appl_yn == null || file_type_appl_yn.equals("null"))
			file_type_appl_yn = "";

	      if(filetype == null || filetype.equals("null")) filetype = "";
		  if(volume_no1 == null || volume_no1.equals("null")) volume_no1 = "";
			if(patient_id1 == null || patient_id1.equals("null")) patient_id1= "";
			if(filenum == null || filenum.equals("null")) filenum = "";

            _bw.write(_wl_block8Bytes, _wl_block8);

		Connection con			= ConnectionManager.getConnection(request);
		PreparedStatement pstmt	= null;
		ResultSet rs			= null;
		
		String classValue		= "";		

		StringBuffer SelectSqlBuffer	= null;
		SelectSqlBuffer					= new StringBuffer();
		StringBuffer CriteriaSqlBuffer	= null;
		CriteriaSqlBuffer				= new StringBuffer();

		int i = 1, p_rec_cnt = 0;
		try 
		{
			
			if(!filetype.equals("") || !filenum.equals(""))
			{

           if(filetype.equals(""))
             {

     str="select curr_file_status ,file_no from fm_curr_locn where facility_id = '"+facility_id+"' and patient_id='"+patient_id1+"' AND file_no='"+filenum+"' and volume_no='"+volume_no1+"' ";
	//	str="select curr_file_status from fm_curr_locn where facility_id = '"+facility_id+"' and patient_id='"+patient_id1+"' AND file_no='"+filenum+"' and volume_no='"+volume_no1+"' ";
			 }
     if(filenum.equals(""))
     { 
      str="select curr_file_status,file_no from fm_curr_locn where facility_id = '"+facility_id+"' and patient_id='"+patient_id1+"' AND file_type_code='"+filetype+"' and volume_no='"+volume_no1+"' ";
     
	  
	  
	  }
			
			pstmt = con.prepareStatement(str);
			rs = pstmt.executeQuery();
			
			while(rs != null && rs.next())
			{
				
				curr_file_status			= rs.getString("curr_file_status");	
		     file_no_new			= rs.getString("file_no");	
			if(curr_file_status==null) curr_file_status="";
			if(file_no_new==null) file_no_new="";
			}
			
			}
			
		
	
		if(rs!=null)	rs.close();
		if(pstmt!=null) pstmt.close();
			
		if(!file_no_new.equals(""))	
			{
			   str1="select * from FM_REQ_DTL A,FM_REQ_HDR B where A.REQ_NO = B.REQ_NO AND B.REQ_FS_LOCN_CODE ='"+FSLocation+"' AND B.REQ_FACILITY_ID ='"+facility_id+"' AND A.ISS_YN = 'N' AND A.CANCEL_YN='N' and A.patient_id='"+patient_id1+"'  and A.file_no='"+file_no_new+"' and A.volume_no='"+volume_no1+"' ";

	    	pstmt = con.prepareStatement(str1);
			rs = pstmt.executeQuery();
			while(rs != null && rs.next())
			{
			count++;
			}
		if(rs!=null)	rs.close();
		if(pstmt!=null) pstmt.close();
			}
		
			
			if(file_type_appl_yn.equals("N") && (!file_num.equals("")))
			{
			
			  /*	CriteriaSqlBuffer.append( " AND A.PATIENT_ID in ("+patient_id+") ");
				//CriteriaSqlBuffer.append( " AND A.FILE_NO in ("+file_num+") ");
				if(!(volume_no == null || volume_no.equals("")))
				{
					CriteriaSqlBuffer.append(" AND VOLUME_NO in ("+volume_no+") ");
				} */
			
		
			
			StringTokenizer pat_volumeno=new StringTokenizer(p_stored_val,"/");  
	      count_tokens=pat_volumeno.countTokens();
	       int P_cnt=0;
	     CriteriaSqlBuffer.append( "AND ( ");
		 while(pat_volumeno.hasMoreTokens())
		{
	    P_cnt++;
	   patientno_volume    =pat_volumeno.nextToken() ;
	  StringTokenizer fileno1=new StringTokenizer(patientno_volume,"`");		
	  while(fileno1.hasMoreTokens())
		{
	pat_id =fileno1.nextToken();	
	if(fileno1.hasMoreTokens())
	vol_no	=fileno1.nextToken();
	}
	// SelectSqlString.append("  (a.patient_id ='"+pat_id+"' ");
	 CriteriaSqlBuffer.append( " ( A.PATIENT_ID ='"+pat_id+"' ");
	// if (!vol_no.equals(""))
		//	{
		if(count_tokens >P_cnt){
   // SelectSqlString.append(" AND a.volume_no ='"+vol_no+"' ) OR ");	
		CriteriaSqlBuffer.append(" AND A.VOLUME_NO ='"+vol_no+"' ) OR ");	
			} else{
              //   SelectSqlString.append("AND a.volume_no ='"+vol_no +"' )");	
		     	CriteriaSqlBuffer.append(" AND A.VOLUME_NO ='"+vol_no +"' )");	
			}
			
			//}
		
		
		P_count=P_cnt;
		}	
	//	CriteriaSqlBuffer.append( " ) ");
		CriteriaSqlBuffer.append( " ) AND A.FILE_NO in ("+file_num+") ");
		
		}
		else if(file_type_appl_yn.equals("Y") && !(file_type_code.equals("")))
			{
		StringTokenizer pat_volumeno=new StringTokenizer(p_stored_val,"/");  
	    count_tokens=pat_volumeno.countTokens();
	   int P_cnt=0;
	 CriteriaSqlBuffer.append( "AND ( ");
	  while(pat_volumeno.hasMoreTokens())
		{
	    P_cnt++;
	   patientno_volume    =pat_volumeno.nextToken() ;
	StringTokenizer fileno1=new StringTokenizer(patientno_volume,"`");		
	while(fileno1.hasMoreTokens())
		{
	pat_id =fileno1.nextToken();	
	if(fileno1.hasMoreTokens())
	vol_no	=fileno1.nextToken();
	}
	// SelectSqlString.append("  (a.patient_id ='"+pat_id+"' ");
	 CriteriaSqlBuffer.append( " ( A.PATIENT_ID ='"+pat_id+"' ");
	// if (!vol_no.equals(""))
		//	{
		if(count_tokens >P_cnt){
   // SelectSqlString.append(" AND a.volume_no ='"+vol_no+"' ) OR ");	
		CriteriaSqlBuffer.append(" AND A.VOLUME_NO ='"+vol_no+"' ) OR ");	
			} else{
              //   SelectSqlString.append("AND a.volume_no ='"+vol_no +"' )");	
		     	CriteriaSqlBuffer.append(" AND A.VOLUME_NO ='"+vol_no +"' )");	
			}
			
			//}
		P_count=P_cnt;
		}	
				
		CriteriaSqlBuffer.append( ") AND A.FILE_TYPE_CODE in ("+file_type_code+") ");
			//	CriteriaSqlBuffer.append( " AND A.FILE_TYPE_CODE in ("+file_type_code+") ");
			/*	if(!(volume_no == null || volume_no.equals("")))
				{
					CriteriaSqlBuffer.append(" AND VOLUME_NO in ("+volume_no+") ");
				}
			CriteriaSqlBuffer.append( " AND A.FILE_TYPE_CODE in ("+file_type_code+") ");
			} */
			
			}
			if(file_num.equals("") && file_type_code.equals(""))
			{
				if(file_type_appl_yn.equals("N"))
				{
				//SelectSqlBuffer.append("SELECT A.REQ_NO,A.REMARKS,A.FILE_NO,A.FILE_TYPE_CODE,TO_CHAR(A.ADDED_DATE,'DD/MM/RRRR HH24:MI')ADDED_DATE, GET_PATIENT_LINE(A.PATIENT_ID)PLINE, A.CANCEL_YN,A.REQ_TO_FACILITY_ID,A.REQ_TO_FS_LOCN_CODE,C.SHORT_DESC REQ_TO_FS_LOCN_DESC,A.VOLUME_NO FROM FM_REQ_DTL A, FM_REQ_HDR B, FM_STORAGE_LOCN C WHERE A.REQ_NO=B.REQ_NO AND B.REQ_FS_LOCN_CODE = ? AND B.REQ_FACILITY_ID  = ?  AND A.ISS_YN = 'N' AND TRUNC(A.ADDED_DATE) = NVL(?,(TRUNC(A.ADDED_DATE))) AND A.CANCEL_YN='N' AND A.REQ_TO_FACILITY_ID=C.FACILITY_ID AND A.REQ_TO_FS_LOCN_CODE=C.FS_LOCN_CODE AND  NVL(A.CANCEL_YN,'N')='N' AND A.DOC_FOLDER_ID is null ORDER BY 3,5");StringBuffer sqlBuffer = new StringBuffer();
					SelectSqlBuffer.append("SELECT" );
					SelectSqlBuffer.append("  A.REQ_NO" );
					SelectSqlBuffer.append("  , A.REMARKS" );
					SelectSqlBuffer.append("  , A.FILE_NO" );
					SelectSqlBuffer.append("  , a.patient_id" );
					SelectSqlBuffer.append("  , A.FILE_TYPE_CODE" );
					SelectSqlBuffer.append("  , TO_CHAR(A.ADDED_DATE,'DD/MM/RRRR HH24:MI') ADDED_DATE" );
					SelectSqlBuffer.append("  , Get_patient_line(A.PATIENT_ID,'"+localeName+"') PLINE" );
					SelectSqlBuffer.append("  , A.CANCEL_YN" );
					SelectSqlBuffer.append("  , A.REQ_TO_FACILITY_ID" );
					SelectSqlBuffer.append("  , A.REQ_TO_FS_LOCN_CODE" );
					SelectSqlBuffer.append("  , C.SHORT_DESC REQ_TO_FS_LOCN_DESC" );
					SelectSqlBuffer.append("  , A.VOLUME_NO " );
					SelectSqlBuffer.append("FROM" );
					SelectSqlBuffer.append("  FM_REQ_DTL A" );
					SelectSqlBuffer.append("  , FM_REQ_HDR B" );
					SelectSqlBuffer.append("  , FM_STORAGE_LOCN_LANG_VW C " );
						SelectSqlBuffer.append("  , FM_CURR_LOCN D " );
					SelectSqlBuffer.append("WHERE A.REQ_NO = B.REQ_NO " );
					SelectSqlBuffer.append("  AND B.REQ_FS_LOCN_CODE = ? " );
					SelectSqlBuffer.append("  AND B.REQ_FACILITY_ID = ? " );
					SelectSqlBuffer.append("  AND A.ISS_YN = 'N' " );
					SelectSqlBuffer.append("  AND Trunc(A.ADDED_DATE) =NVL(TO_DATE(?,'DD/MM/YYYY'),(Trunc(A.ADDED_DATE))) " );
					SelectSqlBuffer.append("  AND A.CANCEL_YN = 'N' " );
					SelectSqlBuffer.append("  AND A.REQ_TO_FACILITY_ID = C.FACILITY_ID " );
					SelectSqlBuffer.append("  AND A.REQ_TO_FS_LOCN_CODE = C.FS_LOCN_CODE " );
					SelectSqlBuffer.append("  AND Nvl(A.CANCEL_YN,'N') = 'N' " );
					SelectSqlBuffer.append("  AND A.DOC_FOLDER_ID IS" );
					SelectSqlBuffer.append("  NULL " );
					SelectSqlBuffer.append("  AND C.LANGUAGE_ID='"+localeName+"' " );
					SelectSqlBuffer.append("  AND D.volume_status not in('L') " );
					//SelectSqlBuffer.append("  AND D.facility_id = b.req_facility_id " );
					SelectSqlBuffer.append("  AND a.file_no = D.file_no " );
                    SelectSqlBuffer.append("  AND a.volume_no = D.volume_no " ); 
					
					
					SelectSqlBuffer.append("ORDER BY 3,5,12" );
				}
				else if(file_type_appl_yn.equals("Y"))
				{
				//SelectSqlBuffer.append("SELECT A.REQ_NO,A.REMARKS,A.FILE_NO,A.FILE_TYPE_CODE,d.short_desc file_type_desc,TO_CHAR(A.ADDED_DATE,'DD/MM/RRRR HH24:MI')ADDED_DATE, GET_PATIENT_LINE(A.PATIENT_ID)PLINE, A.CANCEL_YN,A.REQ_TO_FACILITY_ID,A.REQ_TO_FS_LOCN_CODE,C.SHORT_DESC REQ_TO_FS_LOCN_DESC,A.VOLUME_NO FROM FM_REQ_DTL A, FM_REQ_HDR B, FM_STORAGE_LOCN C,mr_file_type d WHERE A.REQ_NO=B.REQ_NO AND a.req_to_facility_id = d.facility_id(+)  AND a.file_type_code = d.file_type_code(+) AND B.REQ_FS_LOCN_CODE = ? AND B.REQ_FACILITY_ID  = ?  AND A.ISS_YN = 'N' AND TRUNC(A.ADDED_DATE) = NVL(?,(TRUNC(A.ADDED_DATE))) AND A.CANCEL_YN='N' AND A.REQ_TO_FACILITY_ID=C.FACILITY_ID AND A.REQ_TO_FS_LOCN_CODE=C.FS_LOCN_CODE AND NVL(A.CANCEL_YN,'N')='N' AND A.DOC_FOLDER_ID is null ORDER BY 3,5");

					SelectSqlBuffer.append("SELECT" );
					SelectSqlBuffer.append("  A.REQ_NO" );
					SelectSqlBuffer.append("  , A.REMARKS" );
					SelectSqlBuffer.append("  , A.FILE_NO" );
					SelectSqlBuffer.append("  , a.patient_id" );
					SelectSqlBuffer.append("  , A.FILE_TYPE_CODE" );
					SelectSqlBuffer.append("  , d.Short_desc File_Type_desc" );
					SelectSqlBuffer.append("  , TO_CHAR(A.ADDED_DATE,'DD/MM/RRRR HH24:MI') ADDED_DATE" );
					SelectSqlBuffer.append("  , Get_patient_line(A.PATIENT_ID,'"+localeName+"') PLINE" );
					SelectSqlBuffer.append("  , A.CANCEL_YN" );
					SelectSqlBuffer.append("  , A.REQ_TO_FACILITY_ID" );
					SelectSqlBuffer.append("  , A.REQ_TO_FS_LOCN_CODE" );
					SelectSqlBuffer.append("  , C.SHORT_DESC REQ_TO_FS_LOCN_DESC" );
					SelectSqlBuffer.append("  , A.VOLUME_NO " );
					SelectSqlBuffer.append("FROM" );
					SelectSqlBuffer.append("  FM_REQ_DTL A" );
					SelectSqlBuffer.append("  , FM_REQ_HDR B" );
					SelectSqlBuffer.append("  , FM_STORAGE_LOCN_LANG_VW C" );
					SelectSqlBuffer.append("  , mr_file_type_lang_vw D " );
					SelectSqlBuffer.append("  , FM_CURR_LOCN E " );
					SelectSqlBuffer.append("   WHERE A.REQ_NO = B.REQ_NO " );
					SelectSqlBuffer.append("  AND a.req_to_facility_id = d.facility_id(+) " );
					SelectSqlBuffer.append("  AND a.file_type_code = d.file_type_code(+) " );
					SelectSqlBuffer.append("  AND B.REQ_FS_LOCN_CODE = ? " );
					SelectSqlBuffer.append("  AND B.REQ_FACILITY_ID = ? " );
					SelectSqlBuffer.append("  AND A.ISS_YN = 'N' " );
					SelectSqlBuffer.append("  AND TRUNC(A.ADDED_DATE) = NVL(TO_DATE(?,'DD/MM/YYYY'),(TRUNC(A.ADDED_DATE))) " );
					SelectSqlBuffer.append("  AND A.CANCEL_YN='N' " );
					SelectSqlBuffer.append("  AND A.REQ_TO_FACILITY_ID=C.FACILITY_ID " );
					SelectSqlBuffer.append("  AND A.REQ_TO_FS_LOCN_CODE=C.FS_LOCN_CODE " );
					SelectSqlBuffer.append("  AND NVL(A.CANCEL_YN,'N')='N' " );
					SelectSqlBuffer.append("  AND A.DOC_FOLDER_ID IS" );
					SelectSqlBuffer.append("  NULL " );
					SelectSqlBuffer.append("  AND C.language_id=D.LANGUAGE_ID " );
					SelectSqlBuffer.append("  AND C.LANGUAGE_id = '"+localeName+"' " );
					SelectSqlBuffer.append("  AND E.volume_status not in('L') " );
					//SelectSqlBuffer.append("  AND e.facility_id = b.req_facility_id " );
					SelectSqlBuffer.append("  AND a.file_no = e.file_no " );
                    SelectSqlBuffer.append("  AND a.volume_no = e.volume_no and d.facility_id='"+file_faci+"' " ); 
									
					SelectSqlBuffer.append("ORDER BY 3,5,13" );
				}
			}
			else if(!(file_num.equals("")) || !(file_type_code.equals("")))
			{
				if(file_type_appl_yn.equals("N"))
				{
				//SelectSqlBuffer.append("SELECT a.req_no, a.remarks,a.file_no,a.file_type_code,TO_CHAR(a.added_date, 'DD/MM/RRRR HH24:MI') added_date,get_patient_line (a.patient_id) pline, a.cancel_yn,       a.req_to_facility_id, a.req_to_fs_locn_code,c.short_desc req_to_fs_locn_desc, a.volume_no  FROM fm_req_dtl a,fm_req_hdr b,fm_storage_locn c  WHERE a.req_no = b.req_no AND b.req_fs_locn_code = ? AND b.req_facility_id = ? AND a.iss_yn = 'N' AND TRUNC (a.added_date) = NVL (?, (TRUNC (a.added_date))) AND a.cancel_yn = 'N' AND a.req_to_facility_id = c.facility_id AND a.req_to_fs_locn_code = c.fs_locn_code "+CriteriaSqlBuffer+" AND NVL (a.cancel_yn, 'N') = 'N' AND A.DOC_FOLDER_ID is null ");
					SelectSqlBuffer.append("SELECT" );
					SelectSqlBuffer.append("  a.req_No" );
					SelectSqlBuffer.append("  , a.Remarks" );
					SelectSqlBuffer.append("  , a.File_No" );
					SelectSqlBuffer.append("  , a.patient_id" );
					SelectSqlBuffer.append("  , a.File_Type_Code" );
					SelectSqlBuffer.append("  , TO_CHAR(a.Added_Date,'DD/MM/RRRR HH24:MI') Added_Date" );
					SelectSqlBuffer.append("  , Get_patient_line(a.Patient_Id,'"+localeName+"') PlIne" );
					SelectSqlBuffer.append("  , a.Cancel_yn" );
					SelectSqlBuffer.append("  , a.req_To_Facility_Id" );
					SelectSqlBuffer.append("  , a.req_To_fs_Locn_Code" );
					SelectSqlBuffer.append("  , c.Short_desc req_To_fs_Locn_desc" );
					SelectSqlBuffer.append("  , a.Volume_No " );
					SelectSqlBuffer.append("FROM" );
					SelectSqlBuffer.append("  fm_req_dtl a" );
					SelectSqlBuffer.append("  , fm_req_hdr b" );
					SelectSqlBuffer.append("  , FM_STORAGE_LOCN_LANG_VW c " );
					SelectSqlBuffer.append("  , FM_CURR_LOCN d " );
					SelectSqlBuffer.append("WHERE a.req_No = b.req_No " );
					SelectSqlBuffer.append("  AND b.req_fs_Locn_Code = ? " );
					SelectSqlBuffer.append("  AND b.req_Facility_Id = ? " );
					SelectSqlBuffer.append("  AND a.Iss_yn = 'N' " );
					SelectSqlBuffer.append("  AND Trunc(a.Added_Date) = NVL(TO_DATE(?,'DD/MM/YYYY'),(Trunc(a.Added_Date))) " );
					SelectSqlBuffer.append("  AND a.Cancel_yn = 'N' " );
					SelectSqlBuffer.append("  AND a.req_To_Facility_Id = c.Facility_Id " );
					SelectSqlBuffer.append("  AND a.req_To_fs_Locn_Code = c.fs_Locn_Code " );
					SelectSqlBuffer.append(CriteriaSqlBuffer);
					SelectSqlBuffer.append("  AND Nvl(a.Cancel_yn,'N') = 'N' " );
					SelectSqlBuffer.append("  AND A.DOC_FOLDER_ID IS" );
					SelectSqlBuffer.append("  NULL " );
					SelectSqlBuffer.append("  AND C.LANGUAGE_id = '"+localeName+"'" );
                    SelectSqlBuffer.append("  AND d.volume_status not in('L') " );
					//SelectSqlBuffer.append("  AND d.facility_id = b.req_facility_id " );
					SelectSqlBuffer.append("  AND a.file_no = d.file_no " );
                    SelectSqlBuffer.append("  AND a.volume_no = d.volume_no " ); 
				   SelectSqlBuffer.append("ORDER BY 3,5,12" );
				}
				else if(file_type_appl_yn.equals("Y"))
				{
				//SelectSqlBuffer.append("SELECT a.req_no, a.remarks,a.file_no,a.file_type_code,d.short_desc file_type_desc, TO_CHAR (a.added_date, 'DD/MM/RRRR HH24:MI') added_date,get_patient_line(a.patient_id) pline, a.cancel_yn,a.req_to_facility_id,a.req_to_fs_locn_code,c.short_desc req_to_fs_locn_desc, a.volume_no FROM fm_req_dtl a,fm_req_hdr b,fm_storage_locn c,mr_file_type d WHERE a.req_no = b.req_no AND a.req_to_facility_id = d.facility_id(+) AND a.file_type_code = d.file_type_code(+) AND b.req_fs_locn_code = ? AND b.req_facility_id = ? AND a.iss_yn = 'N' AND TRUNC (a.added_date) = NVL (?, (TRUNC (a.added_date))) AND a.cancel_yn = 'N' AND a.req_to_facility_id = c.facility_id AND a.req_to_fs_locn_code = c.fs_locn_code "+CriteriaSqlBuffer+" AND NVL (a.cancel_yn, 'N') = 'N' AND A.DOC_FOLDER_ID is null ");
					SelectSqlBuffer.append("SELECT" );
					SelectSqlBuffer.append("  a.req_No" );
					SelectSqlBuffer.append("  , a.Remarks" );
					SelectSqlBuffer.append("  , a.File_No" );
					SelectSqlBuffer.append("  , a.patient_id" );
					SelectSqlBuffer.append("  , a.File_Type_Code" );
					SelectSqlBuffer.append("  , d.Short_desc File_Type_desc" );
					SelectSqlBuffer.append("  , TO_CHAR(a.Added_Date,'DD/MM/RRRR HH24:MI') Added_Date" );
					SelectSqlBuffer.append("  , Get_patient_line(a.Patient_Id,'"+localeName+"') PlIne" );
					SelectSqlBuffer.append("  , a.Cancel_yn" );
					SelectSqlBuffer.append("  , a.req_To_Facility_Id" );
					SelectSqlBuffer.append("  , a.req_To_fs_Locn_Code" );
					SelectSqlBuffer.append("  , c.Short_desc req_To_fs_Locn_desc" );
					SelectSqlBuffer.append("  , a.Volume_No " );
					SelectSqlBuffer.append("FROM" );
					SelectSqlBuffer.append("  fm_req_dtl a" );
					SelectSqlBuffer.append("  , fm_req_hdr b" );
					SelectSqlBuffer.append("  , FM_STORAGE_LOCN_LANG_VW c" );
					SelectSqlBuffer.append("  , mr_file_type_lang_vw d " );
					SelectSqlBuffer.append("  , fm_curr_locn e " );
					SelectSqlBuffer.append("WHERE a.req_No = b.req_No " );
					SelectSqlBuffer.append("  AND C.language_id=D.LANGUAGE_ID " );
					SelectSqlBuffer.append("  AND C.LANGUAGE_id = '"+localeName+"' " );
					SelectSqlBuffer.append("  AND a.req_to_facility_id = d.facility_id(+) " );
					SelectSqlBuffer.append("  AND a.file_type_code = d.file_type_code(+) " );
					SelectSqlBuffer.append("  AND b.req_fs_locn_code = ? " );
					SelectSqlBuffer.append("  AND b.req_facility_id = ? " );
					SelectSqlBuffer.append("  AND a.iss_yn = 'N' " );
					SelectSqlBuffer.append("  AND TRUNC (a.added_date) = NVL(TO_DATE(?,'DD/MM/YYYY'),(TRUNC (a.added_date))) " );
					SelectSqlBuffer.append("  AND a.cancel_yn = 'N' " );
					SelectSqlBuffer.append("  AND a.req_to_facility_id = c.facility_id " );
					SelectSqlBuffer.append("  AND a.req_to_fs_locn_code = c.fs_locn_code " );
					SelectSqlBuffer.append(CriteriaSqlBuffer);
					SelectSqlBuffer.append("  AND NVL (a.cancel_yn, 'N') = 'N' " );
					SelectSqlBuffer.append("  AND A.DOC_FOLDER_ID IS" );
					SelectSqlBuffer.append("  NULL" );
				   SelectSqlBuffer.append("  AND e.volume_status not in('L') " );
					//SelectSqlBuffer.append("  AND e.facility_id = b.req_facility_id " );
					SelectSqlBuffer.append("  AND a.file_no = e.file_no " );
                    SelectSqlBuffer.append("  AND a.volume_no = e.volume_no and d.facility_id='"+file_faci+"' " ); 
				    SelectSqlBuffer.append("ORDER BY 3,5,13" );
				}
			}
     		
			
			pstmt = con.prepareStatement(SelectSqlBuffer.toString());
		    pstmt.setString(1,FSLocation);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,request_date);
			rs = pstmt.executeQuery();
			
			while(rs != null && rs.next())
			{
				if ( i % 2 == 0 )
					classValue = "QRYODD" ;
				else
					classValue = "QRYEVEN" ;
			
				String fileno			= rs.getString("FILE_NO");
				String patientid			= rs.getString("patient_id");
				String volumeno			= rs.getString("VOLUME_NO");
				String reqno			= rs.getString("REQ_NO");
				String pline			= rs.getString("PLINE");
				
				if(pline == null || pline.equals("null"))
				{ 
					pline = ""; 
				}
				else
				{
					pline = rs.getString("PLINE").substring(0,rs.getString("PLINE").length()-6);
				}
				
				String requestDate		= rs.getString("ADDED_DATE");
				String senderlocndesc	= rs.getString("REQ_TO_FS_LOCN_DESC");
				String issuedate		= "";
				String p_req_remarks	= rs.getString("REMARKS")==null?"":rs.getString("REMARKS");
				// p_req_remarks=java.net.URLDecoder.decode( p_req_remarks,"UTF-8");
				if(reqno == null || reqno.equals("null")) reqno="";
				if(pline == null || pline.equals("null")) pline="";
				if(fileno == null || fileno.equals("null")) fileno="";
				if(requestDate != null )
				requestDate=DateUtils.convertDate(requestDate,"DMYHM","en",localeName);
					else
						requestDate="";
				if(volumeno == null || volumeno.equals("null")) volumeno="";
				if(p_req_remarks == null || p_req_remarks.equals("null")) p_req_remarks="";
				if(p_req_remarks == null || p_req_remarks.equals("null")) p_req_remarks="";
				if(issuedate == null || issuedate.equals("null")) issuedate = "&nbsp;";
				if(senderlocndesc == null || senderlocndesc.equals("null")) 
					senderlocndesc = "&nbsp;";
		
				if(file_type_appl_yn.equals("N"))
				{
					out.println("<tr><td class='"+classValue+"' width='40%'>");
					out.println("<font 	size=1><b>"+fileno+"</b><br>&nbsp;&nbsp;"+pline+"</font></td>");
					out.println("<td class='"+classValue+"' width='13%'><font size=1><CENTER>");
				}
				else if (file_type_appl_yn.equals("Y"))
				{
					out.println("<tr><td class='"+classValue+"' width='40%'>");
					out.println("<font size=1>&nbsp;"+pline+"</font></td>");
					out.println("<td class='"+classValue+"' width='13%'><font size=1><CENTER>");
					if(file_type_appl_yn.equals("Y"))
					{
						filetypedesc = rs.getString("file_type_desc");
						if(filetypedesc == null || filetypedesc.equals("null"))  
							filetypedesc= "&nbsp;";
						out.println(filetypedesc);
						if(!filetypedesc.equals("&nbsp;"))
							out.println(" / ");
					}
				}
				
				out.println(volumeno+"</CENTER></font></td>");
				out.println("<td class='"+classValue+"' width='13%'>");
				out.println("<font size=1>"+requestDate+"</font></td>");
				out.println("<td class='"+classValue+"'width='15%'>");

				if(senderlocndesc == null || senderlocndesc.equals("null"))
					out.println("&nbsp;</td>");
				else
				out.println("<font size=1>"+senderlocndesc+" </font></td>");
				out.println("<td  align='center' class='"+classValue+"' width='9%'>");
				
            _bw.write(_wl_block9Bytes, _wl_block9);

				
				pat_file_vol1=patientid+"`"+fileno+"`"+volumeno;
		if(!pat_file_vol.equals(""))
		{
		StringTokenizer patfilevolume=new StringTokenizer(pat_file_vol,",");		
	     while(patfilevolume.hasMoreTokens())
		 {
	     patfilevol =patfilevolume.nextToken();	
	       if(patfilevol.equals(pat_file_vol1))
		   {
           status="true";
		   }
		   }
			}		
				if(status.equals("true"))
					{
				status="false";
				
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(i));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(i));
            _bw.write(_wl_block12Bytes, _wl_block12);

				out.println("<td id='td1"+i+"' style='display:none'  class='"+classValue+"' width='10%'><font size=1>");
				
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block14Bytes, _wl_block14);

				out.println("<td id='td2"+i+"'  class='"+classValue+"' width='10%'><font size=1> ");
				
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
}else{ 
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);

				out.println("<td id='td1"+i+"' class='"+classValue+"' width='10%'><font size=1>");
				
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block14Bytes, _wl_block14);

				out.println("<td id='td2"+i+"' style='display:none' class='"+classValue+"' width='10%'><font size=1> ");
				
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
} 
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(p_req_remarks.trim()));
            _bw.write(_wl_block25Bytes, _wl_block25);

				out.println("<input type='hidden' name='file"+i+"' id='file"+i+"' value='"+fileno+"'>");
				out.println("<input type='hidden' name='volume"+i+"' id='volume"+i+"' value='"+volumeno+"'>");
				out.println("<input type='hidden' name='req_no"+i+"' id='req_no"+i+"' value='"+reqno+"'>");
                out.println("<input type='hidden' name='patient_id"+i+"' id='patient_id"+i+"' value='"+patientid+"'>");
				i++;
				p_rec_cnt++;
			} 
			if((SelectSqlBuffer != null) && (SelectSqlBuffer.length() > 0))
			{
				SelectSqlBuffer.delete(0,SelectSqlBuffer.length());
			}

			
			
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(p_rec_cnt ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(curr_file_status ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(file_no_new ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(count ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(p_rec_cnt));
            _bw.write(_wl_block31Bytes, _wl_block31);
	if(rs!=null)	rs.close();
		if(pstmt!=null) pstmt.close();
		}catch(Exception e){
			out.println(e.toString());
			e.printStackTrace();
		}
		finally
		{			
			ConnectionManager.returnConnection(con,request);
		}
		
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(file_type_appl_yn));
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
}
