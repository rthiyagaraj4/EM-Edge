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

public final class __fmlostfoundcheckfileexists extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMLostFoundCheckFileExists.jsp", 1709116863484L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tCreated On\t: 6/21/2002\n\tCreated By\t: Nanda Kumar R.\n\tModule\t\t: File Management (FM)\n\tFunction\t: File Lost / Found \n-->\n";
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

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMLostFound.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body class=\'message\' onKeyDown = \'lockKey()\'>\n<form>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<script>\n\t\t\tif(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' == \'T\' || \'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'==\'R\' || \'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' == \'E\') \n\t\t\t{\n\t\t\t\tvar errors = getMessage(\'FILE_IN_TRANSIT_CANNOT_PROCEED\',\'FM\');\n\t\t\t\tparent.frames[4].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors ;\n\t\t\t parent.search_criteria.document.getElementById(\"hdr_tab\").style.visibility = \'hidden\';\n\t\t\t parent.frames[2].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t parent.frames[3].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t}\n\t\t\telse \n\t\t\t{\n\t\t\t\tparent.frames[2].document.location.href=\'../../eFM/jsp/FMLostFoundRecordFrame.jsp?p_patient_file_no=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&volume_no=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&patient_id=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&file_type_code=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&file_type_appl_yn=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&appl_user_name=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\';\n\t\t\t\t\n\t\t\t\tparent.frames[3].document.location.href=\'../../eFM/jsp/FMLostFoundChangeStatus.jsp?p_patient_file_no=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&p_patient_file_type=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\';\n\t\t\t}\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t<script>\n\t\t\tvar errors = getMessage(\'FILE_STATUS_OTHER_CANNOT_CHANGE\',\'FM\');\n\t\t\tparent.frames[4].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors ;\n\t\t\tparent.search_criteria.document.getElementById(\"hdr_tab\").style.visibility = \'hidden\';\n\t\t\tparent.frames[2].location.href=\'../../eCommon/html/blank.html\';\n\t\t\tparent.frames[3].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<script>\n\t\t\t\tvar errors = getMessage(\'FILE_STATUS_CANNOT_CHANGE\',\'FM\');\n\t\t\tparent.frames[4].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors ;\n\t\t\tparent.search_criteria.document.getElementById(\"hdr_tab\").style.visibility = \'hidden\';\n\t\t\tparent.frames[2].location.href=\'../../eCommon/html/blank.html\';\n\t\t\tparent.frames[3].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t<script>\n\t\t\t\tvar errors = getMessage(\'PATIENT_FILE_NOT_EXIST\',\'FM\');\n\t\t\tparent.frames[4].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors ;\n\t\t\t parent.frames[1].location.href=\'../../eCommon/html/blank.html\';\n\t\t\tparent.frames[2].location.href=\'../../eCommon/html/blank.html\';\n\t\t\tparent.frames[3].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t<script>\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' == \'R\')\n\t\t\t\t{\n\t\t\t\t\tvar errors = getMessage(\'DOC_IN_TRANSIT_CANNOT_PROCEED\',\'FM\');\n\t\t\t\t\tparent.frames[4].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors ;\n\t\t\t\t  parent.search_criteria.document.getElementById(\"hdr_tab\").style.visibility = \'hidden\';\n\t\t\t\t  parent.frames[2].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t  parent.frames[3].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t}\n\t\t\t\telse \n\t\t\t\t{\n\t\t\t\t\tparent.frames[2].document.location.href=\'../../eFM/jsp/DTLostFoundRecordFrame.jsp?p_doc_file_no=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&doc_type_code=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&doc_folder_id=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\';\n\t\t\t\t\n\t\t\t\t\tparent.frames[3].document.location.href=\'../../eFM/jsp/DTLostFoundChangeStatus.jsp?p_doc_file_no=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\';\n\t\t\t\t}\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t<script>\n\t\t\t\t\t\tvar errors = getMessage(\'DOC_NOT_EXIST\',\'FM\');\n\t\t\t\t\t\tparent.frames[4].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors ;\n\t\t\t\t      parent.search_criteria.document.getElementById(\"hdr_tab\").style.visibility = \'hidden\';\n\t\t\t\t\t  parent.frames[2].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t\t parent.frames[3].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t   \n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

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
try
{
	String sql 				 = "";
	String p_file_status	 = "";
	String volumeCriteria    = "";
	String more_Criteria     = "";
	String file_type_code	 = "";	
	String curr_facility_id="";
	int p_count				 = 0;

	String facilityid 				= (String) session.getValue("facility_id");

	String p_enter_fcy				= request.getParameter("p_enter_fcy");
	//String p_curr_location			= request.getParameter("p_curr_location");
	String patient_id				= request.getParameter("patient_id");
	String p_patient_file_no		= request.getParameter("p_patient_file_no");
	String p_patient_file_type_code = request.getParameter("p_patient_file_type_code");
	String volume_no				= request.getParameter("volume_no");
	String p_doc_file_no			= request.getParameter("p_doc_file_no");
	String doc_folder_id			= request.getParameter("doc_folder_id");
	String doc_type_code			= request.getParameter("doc_type_code");
	String file_type_appl_yn		= request.getParameter("file_type_appl_yn");
	String maintain_doc_or_file		= request.getParameter("maintain_doc_or_file");
	String appl_user_name			= request.getParameter("appl_user_name");
	String p_curr_location	 = request.getParameter("p_curr_location");

	if(p_enter_fcy==null || p_enter_fcy.equals("null")) p_enter_fcy=facilityid ;
	if(patient_id == null || patient_id.equals("null")) patient_id = "";
	if(p_patient_file_no == null || p_patient_file_no.equals("null")) p_patient_file_no = "";
	if(file_type_code == null || file_type_code.equals("null")) file_type_code = "";
	if(volume_no == null || volume_no.equals("null")) volume_no = "";
	if(p_doc_file_no == null || p_doc_file_no.equals("null")) p_doc_file_no = "";
	if(doc_folder_id == null || doc_folder_id.equals("null")) doc_folder_id = "";
	if(doc_type_code == null || doc_type_code.equals("null")) doc_type_code = "";
	if(maintain_doc_or_file == null || maintain_doc_or_file.equals("null")) maintain_doc_or_file = "";
	if(file_type_appl_yn == null || file_type_appl_yn.equals("null")) file_type_appl_yn = "";
	if(appl_user_name == null || appl_user_name.equals("null")) appl_user_name = "";
	if(p_curr_location == null || p_curr_location.equals("null")) p_curr_location = "";	

	if((volume_no != null) && !(volume_no.equals(""))) 
	{
		volumeCriteria = " AND VOLUME_NO = "+volume_no+" ";
	}
	if(!p_curr_location.equals("")) 
	{		
		more_Criteria = " AND perm_fs_locn_code = '"+p_curr_location+"' ";
	}
	
	if(maintain_doc_or_file.equals("F")) 
	{
		if(file_type_appl_yn.equals("N")) 
		{
			more_Criteria = more_Criteria +" AND FILE_NO = '"+p_patient_file_no+"' ";
		}
		else if(file_type_appl_yn.equals("Y")) 
		{
			more_Criteria  =more_Criteria + " AND FILE_TYPE_CODE = '"+p_patient_file_type_code+"' ";
		}

		//sql = "select curr_file_status from fm_curr_locn_vw where patient_id = ? "+volumeCriteria+" "+more_Criteria+" and curr_facility_id = ?";
		sql = "select curr_file_status,curr_facility_id from fm_curr_locn where patient_id = ? "+volumeCriteria+" "+more_Criteria+"  and facility_id = ?";
			
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,patient_id);
		pstmt.setString(2,p_enter_fcy);
		rs = pstmt.executeQuery();


		
		while(rs != null && rs.next()) 
		{
			p_file_status  = rs.getString(1);
			curr_facility_id= rs.getString(2);
			p_count++;
			}
		if(curr_facility_id==null) curr_facility_id="";
		
		if(rs!=null) rs.close();
		if(pstmt != null) pstmt.close();
		if(p_count > 0 && curr_facility_id.equals(p_enter_fcy))
		{
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(p_file_status));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_file_status));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(p_file_status));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(p_patient_file_no));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(p_patient_file_type_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(file_type_appl_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(appl_user_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(p_patient_file_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(p_patient_file_type_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(file_type_appl_yn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(appl_user_name));
            _bw.write(_wl_block19Bytes, _wl_block19);
	
		}else
		{
				
			if(!curr_facility_id.equals("") && !curr_facility_id.equals(p_enter_fcy))
			{ 
            _bw.write(_wl_block20Bytes, _wl_block20);
}else if(!p_patient_file_no.equals(""))
				{
			
            _bw.write(_wl_block21Bytes, _wl_block21);

				}else{
			
            _bw.write(_wl_block22Bytes, _wl_block22);

			}
			}
	}
	else if(maintain_doc_or_file.equals("D")) 
	{
		if(!patient_id.equals("")) 
	{		
		more_Criteria = " AND patient_id = '"+patient_id+"' ";
	}
		
			//sql ="select curr_file_status from fm_curr_locn_vw where  curr_facility_id = ? and doc_folder_id = ? and doc_type_code = ? and  curr_facility_id = ? "+more_Criteria+" AND mr_pat_fs_locn_code = ? ";
			sql ="select curr_file_status from fm_curr_locn where  curr_facility_id = ? and doc_folder_id = ? and doc_type_code = ? and  curr_facility_id = ? "+more_Criteria+"AND perm_fs_locn_code = ?" ;
			//and file_no = ? 
			pstmt = con.prepareStatement(sql);

	//		pstmt.setString(1,patient_id);
			pstmt.setString(1,p_enter_fcy);
			pstmt.setString(2,doc_folder_id);
			pstmt.setString(3,doc_type_code);			
			pstmt.setString(4,p_enter_fcy);
			pstmt.setString(5,p_curr_location);
		//	pstmt.setString(6,p_doc_file_no);

			rs = pstmt.executeQuery();
			
			while(rs != null && rs.next())
			{
				p_file_status  = rs.getString(1);
				p_count++;
			}
			if(p_count > 0)
		{
			
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(p_file_status));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_file_status));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(p_doc_file_no));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(doc_type_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(doc_folder_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(appl_user_name));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(p_doc_file_no));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(doc_type_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(doc_folder_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(appl_user_name));
            _bw.write(_wl_block28Bytes, _wl_block28);
	
			}
			else 
			{
				
            _bw.write(_wl_block29Bytes, _wl_block29);
			
			}
		}

		if(rs!=null) rs.close();	
		if(pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception e :"+e);
	}
	finally
	{					
			ConnectionManager.returnConnection(con,request);	
	}

            _bw.write(_wl_block30Bytes, _wl_block30);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
