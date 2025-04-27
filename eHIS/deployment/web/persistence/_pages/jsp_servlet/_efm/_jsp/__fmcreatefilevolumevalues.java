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

public final class __fmcreatefilevolumevalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMCreateFileVolumeValues.jsp", 1709116834560L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\t\t\t<script>\n\t\t\tvar msg = getMessage(\'INVALID_VALUE\',\'Common\'); \n\t\t\tmsg = msg.replace(\'#\',getLabel(\'Common.patientId.label\',\'Common\'));\n\t\t\talert(msg);\n\t\t\tparent.createvolume_header.document.FMCreateFileVolumeSearchForm.patient_id.value=\"\";;\n\t\t\tparent.createvolume_header.document.FMCreateFileVolumeSearchForm.patient_id.select();\n\t\t\t</script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t<script>\n\t\t\t\t\t\tparent.createvolume_header.document.getElementById(\"PatientID\").innerHTML = \"<input type=\'text\' name=\'patient_id\' id=\'patient_id\' value=\'\"+\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"+\"\' size=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' maxlength=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'  onBlur=\'return popData(this);\'>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<script>\n\t\t\t\tparent.createvolume_header.document.getElementById(\"FileID\").innerHTML = \"<input type=\'text\' name=\'file_no\' id=\'file_no\' value=\'\' size=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' onBlur=\'popPatientID(this);\'>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<script>\n\t\t\t\t\tparent.createvolume_header.document.getElementById(\"FileID\").innerHTML = \"<input type=\'text\' name=\'file_no\' id=\'file_no\' value=\'\"+\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' onBlur=\'popPatientID(this);\'>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<script>\n\t\t\t\tvar opt = \"\";\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\topt = opt + \"<option value=\'\"+\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"+\"\'>\"+\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"+\"</option>\";\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\tvar selectBox\t= \"<select name=\'file_no\' id=\'file_no\' value = \'\' onBlur=\'popPatientID(this);\'><option>---------\"+getLabel(\'Common.defaultSelect.label\',\'common\')+\"---------</option>\";\n\t\t\t\tselectBox += opt;\n\t\t\t\tselectBox += \"</select>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t\tparent.createvolume_header.document.getElementById(\"FileID\").innerHTML = selectBox;\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t<script>\n\t\t\tvar opt = \"\";\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\topt = opt + \"<option value=\'\"+\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"+\"</option>\";\n\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\tvar selectBox\t= \"<select name=\'file_type_code\' id=\'file_type_code\' value = \'\' ><option>---------\"+getLabel(\'Common.defaultSelect.label\',\'common\')+\"---------</option>\";\n\t\t\tselectBox += opt;\n\t\t\tselectBox += \"</select>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\tparent.createvolume_header.document.getElementById(\"FileType\").innerHTML = selectBox;\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n<SCRIPT>\n\tparent.frames[3].document.location.href=\"../../eCommon/jsp/error.jsp\";\n</SCRIPT>\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	Connection con			= null;	
	ResultSet	rs			= null;
	PreparedStatement pst	= null;

	String patient_id			 = "";
	String patientid			 = "";	
	String file_no				 = "";
	String file_type_code		 = "";
	String short_desc			 = "";
	String file_type_appl_yn	 = "";
	String facilityid			 = "";
	String operation			 = "";
	String sqlString             = "";
	String patient_id_max_length = "";

	int rec_count = 0;

try
{
	con	= ConnectionManager.getConnection(request);

	facilityid			  = (String) session.getValue("facility_id");
	patient_id			  = request.getParameter("patient_id");
	file_no				  = request.getParameter("file_no");
	file_type_code		  = request.getParameter("file_type_code");
	file_type_appl_yn	  = request.getParameter("file_type_appl_yn");
	operation			  = request.getParameter("operation");
	patient_id_max_length = request.getParameter("patient_id_max_length");
	
	if(patient_id == null || patient_id.equals("null")) patient_id = "";
	if(file_no == null || file_no.equals("null")) patient_id = "";
	if(file_type_code == null || file_type_code.equals("null")) file_type_code = "";
	if(file_type_appl_yn == null || file_type_appl_yn.equals("null")) file_type_appl_yn = "N";
	if(operation == null || operation.equals("null")) operation = "";

	if (!patient_id.equals(""))
	{
		webbeans.op.PatientData patdata = new webbeans.op.PatientData();
		patdata.setFacility_id(facilityid);
		String patient_status = patdata.CheckStatus(con,patient_id);
		if (patient_status.equals("INVALID_PATIENT"))
		{

            _bw.write(_wl_block5Bytes, _wl_block5);
		
		}
	}
	if(patient_id.equals("") && operation.equals("POP_PATIENTID"))
	{
		if(!file_no.equals("") && file_type_appl_yn.equals("N"))
		{
			sqlString = "SELECT patient_id FROM mr_pat_file_index WHERE facility_id = ? AND file_no = ? ";
			pst	=	con.prepareStatement(sqlString);
			pst.setString(1, facilityid);
			pst.setString(2, file_no);
			rs	=	pst.executeQuery();

			if(rs != null && rs.next())
			{
				patientid = rs.getString("patient_id");
				
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(patient_id_max_length+2));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patient_id_max_length));
            _bw.write(_wl_block9Bytes, _wl_block9);

			} 
			if(rs!=null)	rs.close();
			if(pst !=null) pst.close();
		}
	}
	if(file_type_appl_yn.equals("N"))
	{
		String mysql = "select count(*) reccount from MR_PAT_FILE_INDEX where FACILITY_ID = ? AND PATIENT_ID = ? ";	

		pst = con.prepareStatement(mysql);
		pst.setString(1,facilityid);
		pst.setString(2,patient_id);
		rs = pst.executeQuery();

		if(rs != null && rs.next())
		{
			rec_count = rs.getInt("reccount");
		}
		if(rs!=null)	rs.close();
		if(pst !=null) pst.close();

		out.println("<script>parent.frames[2].document.location.href='../../eCommon/html/blank.html'</script>");
		out.println("<script>var obj =parent.createvolume_header.document.FMCreateFileVolumeSearchForm.file_no;");
		out.println("var length  = obj.length;");
		out.println("for(i=0;i<length;i++) {obj.remove(0);}</script>");
		
		String mysql1 = "SELECT FILE_NO FROM MR_PAT_FILE_INDEX WHERE FACILITY_ID = ? AND PATIENT_ID = ?";
		
		pst = con.prepareStatement(mysql1);
		pst.setString(1,facilityid);
		pst.setString(2,patient_id);
		rs  = pst.executeQuery();

		if(rec_count == 0)
		{
			
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_id_max_length+2));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patient_id_max_length));
            _bw.write(_wl_block11Bytes, _wl_block11);

		}
		else if(rec_count == 1)
		{
			if(rs != null && rs.next())
			{
				file_no = rs.getString("FILE_NO");
				
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(file_no));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(patient_id_max_length+2));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patient_id_max_length));
            _bw.write(_wl_block13Bytes, _wl_block13);

			}
		}
		else if(rec_count > 1)
		{
			
            _bw.write(_wl_block14Bytes, _wl_block14);

				while(rs != null && rs.next())
				{
					file_no		=	rs.getString("FILE_NO");
					
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(file_no));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(file_no));
            _bw.write(_wl_block17Bytes, _wl_block17);

				}
				
            _bw.write(_wl_block18Bytes, _wl_block18);

		}
		if(rs != null)  rs.close();
		if(pst != null) pst.close();
	}
	else if(file_type_appl_yn.equals("Y"))
	{
		out.println("<script>parent.frames[2].document.location.href='../../eCommon/html/blank.html'</script>");

		out.println("<script>var obj1 =parent.createvolume_header.document.FMCreateFileVolumeSearchForm.file_type_code;");
		out.println("var length  = obj1.length;");
		out.println("for(i=0;i<length;i++) {obj1.remove(0);}</script>");

		String mysql2 = "SELECT distinct A.FILE_TYPE_CODE FILE_TYPE_CODE, A.SHORT_DESC FROM MR_FILE_TYPE A,MR_PAT_FILE_INDEX  B WHERE A.FACILITY_ID = B.FACILITY_ID AND A.FILE_TYPE_CODE = B.FILE_TYPE_CODE AND A.FACILITY_ID = ? AND B.PATIENT_ID = ?";

		pst = con.prepareStatement(mysql2);
		pst.setString(1,facilityid);
		pst.setString(2,patient_id);
		rs = pst.executeQuery();
			
		
            _bw.write(_wl_block19Bytes, _wl_block19);

			while(rs != null && rs.next())
			{
				file_type_code = rs.getString("FILE_TYPE_CODE");
				short_desc = rs.getString("SHORT_DESC");
					
				
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(file_type_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);

			}
			
            _bw.write(_wl_block22Bytes, _wl_block22);

	if(rs!=null)	rs.close();
	if(pst !=null)  pst.close();
	}
}catch(Exception e){out.println("Exception e :" +e.toString());}
finally
{			
		ConnectionManager.returnConnection(con,request);	
}

            _bw.write(_wl_block23Bytes, _wl_block23);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
