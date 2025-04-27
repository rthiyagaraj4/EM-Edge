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
import java.util.*;
import com.ehis.util.*;

public final class __dtcancelrequestdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/DTCancelRequestDetail.jsp", 1724922320554L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block8 ="\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey();\'>\n<form name=\'CancelRequestDtl_form\' id=\'CancelRequestDtl_form\' action=\'../../servlet/eFM.FMCancelRequestServlet\' method=\'post\' target=\'messageFrame\'>\n<script>\n\tparent.frames[2].document.getElementById(\"hdr_tab0\").style.visibility = \'Visible\';\n\tparent.frames[2].document.getElementById(\"hdr_tab1\").style.visibility = \'Visible\';\n</script>\n<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\' id=\"test\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' width=\'10%\'>\n\t\t\t\t\t<A HREF onMouseover=\"changeCursor(this)\" onClick=\"callPatDetails(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\')\"><font size=1>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</font></A> </font></td>\n\n\t\t\t\t\t<td  CLASS=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' width=\'10%\'>\n\t\t\t\t\t<A HREF onMouseover=\"changeCursor(this)\" onClick=\"showEncounter(\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\',\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</font></A></td>\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t<input type=\'checkbox\' name=\'cancelbox";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' id=\'cancelbox";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' value=\'Y\' onClick=\'cancelSelection(this);\'></td>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t   <a href=\'javascript:GetRemarks(";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =")\'>&nbsp;</a></font></td>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t    <a href=\'javascript:GetRemarks(";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =")\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</a></font></td></tr>\n\t\t\t\t    <input type=\"hidden\" name=\"rem_recnum_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"rem_recnum_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" value=\"\">\n\t\t\t\t    <input type=\"hidden\" name=\"p_req_remarks";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" id=\"p_req_remarks";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t<script>\n\t\t\t\tvar p_rec_cnt = \'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'\n\n\t\t\t\tif (p_rec_cnt==0)\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\'NO_DOC_AVA_CANCEL\',\'FM\'));\n\t\t\t\t\tparent.frames[3].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\tfor (i=0;i<6;i++)\n\t\t\t\t{\n\t\t\t\t\tif ((document.getElementById(\"test\").rows[i+1] != null) && (document.getElementById(\"test\").rows[i+1].cells[i] != null))\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.cancel_criteria.document.getElementById(\"hdr_tab1\").rows[0].cells[i].width = document.getElementById(\"test\").rows[i+1].cells[i].width; \n\t\t\t\t\t}\n\t\t\t\t}\n\n\t\t\t</script>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t</table>\n<input type=\'hidden\' name=\'reccount\' id=\'reccount\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n<input type=\'hidden\' name=\'filenos\' id=\'filenos\' value=\'\'>\n<input type=\'hidden\' name=\'docfoldernos\' id=\'docfoldernos\' value=\'\'>\n<input type=\'hidden\' name=\'doctypenos\' id=\'doctypenos\' value=\'\'>\n<input type=\'hidden\' name=\'volumenos\' id=\'volumenos\' value=\'\'>\n<input type=\'hidden\' name=\'req\' id=\'req\' value=\'\'>\n<input type=\'hidden\' name=\'remarks\' id=\'remarks\' value=\'\'>\n<input type=\'hidden\' name=\'can_locn_code\' id=\'can_locn_code\' value=\'\'>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );
	
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
		 
		Statement stmt			= null;
		ResultSet rs			= null;
		
		String facility_id			= (String) session.getValue("facility_id");	
		String FSLocation			= request.getParameter("FSLocation");
		String file_num				= request.getParameter("fileno");
		String patient_id			= request.getParameter("patient_id");
		String doc_folder_id		= request.getParameter("doc_folder_id");
		String doc_type_code		= request.getParameter("doc_type_code");
		String request_date			= request.getParameter("ReqDate");
		String sql				= "";
		String classValue		= "";
		String moreCriteria		= "";
		
		int i = 1, p_rec_cnt = 0;
				
		if(FSLocation == null || FSLocation.equals("null"))
			FSLocation = "";
		if(patient_id == null || patient_id.equals("null"))
			patient_id = "";
		if(doc_folder_id == null || doc_folder_id.equals("null"))
			doc_folder_id = "";
		if(doc_type_code == null || doc_type_code.equals("null"))
			doc_type_code = "";
		if(request_date == null || request_date.equals("null"))
			request_date = "";
		if(file_num == null || file_num.equals("null")) 
			file_num = "";

		if(!(doc_folder_id == null || doc_folder_id.equals("")))
			moreCriteria =moreCriteria + " AND a.doc_folder_id in ("+doc_folder_id+") ";

		if(!(doc_type_code == null || doc_type_code.equals("")))
			moreCriteria = moreCriteria + " AND a.doc_type_code = '"+doc_type_code+"' ";
//		if(!(file_num == null || file_num.equals("")))
//			moreCriteria += " AND a.file_no in ("+file_num+") ";

            _bw.write(_wl_block8Bytes, _wl_block8);

		sql ="SELECT   a.req_no, a.remarks, a.file_no,a.PATIENT_ID, a.file_type_code, a.doc_type_code, d.doc_type_name, a.doc_folder_id, f.ENCOUNTER_ID, e.doc_folder_name,a.volume_no,(CASE WHEN e.patient_period_specific = 'D'  THEN ' ' || TO_CHAR (e.from_period, 'dd/mm/rrrr ') || ' - ' || TO_CHAR (e.to_period, 'dd/mm/rrrr ') ELSE  ', ' || GET_PATIENT_LINE(e.PATIENT_ID,'"+localeName+"') END) docline, TO_CHAR (a.added_date, 'DD/MM/RRRR HH24:MI') added_date, a.cancel_yn, a.req_to_facility_id, a.req_to_fs_locn_code, c.short_desc req_to_fs_locn_desc FROM fm_req_dtl a,fm_req_hdr b,fm_storage_locn c,fm_doc_type d,fm_doc_folder e,FM_ENCOUNTER_DOC_TYPE_LINK f WHERE a.req_to_facility_id = e.facility_id AND a.doc_folder_id = e.doc_folder_id AND  a.doc_type_code = d.doc_type_code(+) AND a.req_no = b.req_no AND B.REQ_FS_LOCN_CODE =  '"+FSLocation+"' AND b.req_facility_id = '"+facility_id+"' AND a.iss_yn = 'N'  AND TRUNC (a.added_date) =NVL ('"+request_date+"',(TRUNC (a.added_date))) AND a.cancel_yn = 'N' AND a.req_to_facility_id = c.facility_id and a.req_to_facility_id = f.facility_id and a.file_no = f.file_no AND a.req_to_fs_locn_code = c.fs_locn_code AND NVL (a.cancel_yn, 'N') = 'N' "+moreCriteria+" ORDER BY 7 ";
		
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
					String docline			= rs.getString("docline");
					String fileno			= rs.getString("file_no");
					String doctypecode		= rs.getString("doc_type_code");
					String doctypename		= rs.getString("doc_type_name");
					String docfolderid		= rs.getString("doc_folder_id");
					String docfoldername	= rs.getString("doc_folder_name");
					String filetypecode		= rs.getString("file_type_code");
					String volumeno			= rs.getString("volume_no");
					String reqno			= rs.getString("req_no");
					String requestDate		= rs.getString("added_date");	
					String senderlocndesc	= rs.getString("req_to_fs_locn_desc");		
					String PATIENTID		= rs.getString("PATIENT_ID");				
					String ENCOUNTER_ID		= rs.getString("ENCOUNTER_ID");				
					String issuedate		= "";
					String p_req_remarks	= rs.getString("remarks");
					
					if(reqno == null || reqno.equals("null"))
						reqno="";
					if(docline == null || docline.equals("null"))
						docline="&nbsp";
					if(fileno == null || fileno.equals("null"))
						fileno="";
					if(doctypecode == null || doctypecode.equals("null"))
						doctypecode="";
					if(doctypename == null || doctypename.equals("null"))
						doctypename="&nbsp;";
					if(docfolderid == null || docfolderid.equals("null"))
						docfolderid="";
					if(docfoldername == null || docfoldername.equals("null"))
						docfoldername="";
					if(requestDate == null || requestDate.equals("null"))
						requestDate="";
					if(filetypecode == null || filetypecode.equals("null"))
						filetypecode="";
					if(volumeno == null || volumeno.equals("null"))
						volumeno="";
					if(p_req_remarks == null || p_req_remarks.equals("null"))
						p_req_remarks="";
					if(p_req_remarks == null || p_req_remarks.equals("null"))
						p_req_remarks="";
					if(issuedate == null || issuedate.equals("null"))
						issuedate = "&nbsp;";
					if(senderlocndesc == null || senderlocndesc.equals("null"))
						senderlocndesc = "&nbsp;";
				
					out.println("<tr><td  class='"+classValue+"' width='25%'>");
					out.println("<font size=1><B>"+docfolderid+"</B><BR>&nbsp;&nbsp;"+docfoldername+"&nbsp;&nbsp;"+docline+"</font></td>");
					out.println("<td  class='"+classValue+"' width='11%'><font size=1><CENTER>");
					out.println(doctypename+"</CENTER></font></td>");
				//ragha	
					
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(PATIENTID));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(PATIENTID));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(ENCOUNTER_ID));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(PATIENTID));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(fileno));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(ENCOUNTER_ID));
            _bw.write(_wl_block15Bytes, _wl_block15);

					out.println("<td  class='"+classValue+"' width='13%'>");
					out.println("<font size=1>"+requestDate+"</font></td>");
					out.println("<td  class='"+classValue+"'width='12%'>");
					if(senderlocndesc == null || senderlocndesc.equals("null"))
						out.println("&nbsp;</td>");
					else
						out.println("<font size=1>"+senderlocndesc+" </font></td>");
					out.println("<td  align='center' class='"+classValue+"' width='9%'>");

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);

					out.println("<td id='td1"+i+"'  class='"+classValue+"' width='10%'><font size=1>");

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block20Bytes, _wl_block20);

					out.println("<td id='td2"+i+"' style='display:none'  class='"+classValue+"' width='10%'><font size=1> ");

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf( i ));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(p_req_remarks.trim()));
            _bw.write(_wl_block28Bytes, _wl_block28);

					out.println("<input type='hidden' name='file"+i+"' id='file"+i+"' value='"+fileno+"'>");
					out.println("<input type='hidden' name='docfolder"+i+"' id='docfolder"+i+"' value='"+docfolderid+"'>");
					out.println("<input type='hidden' name='doctypecode"+i+"' id='doctypecode"+i+"' value='"+doctypecode+"'>");
					out.println("<input type='hidden' name='filetype"+i+"' id='filetype"+i+"' value='"+filetypecode+"'>");
					out.println("<input type='hidden' name='volume"+i+"' id='volume"+i+"' value='"+volumeno+"'>");
					out.println("<input type='hidden' name='req_no"+i+"' id='req_no"+i+"' value='"+reqno+"'>");

					i++;
					p_rec_cnt++;
				}

			}

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(p_rec_cnt ));
            _bw.write(_wl_block30Bytes, _wl_block30);

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

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
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
}
