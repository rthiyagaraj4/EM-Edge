package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.io.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __queryfmencounterdetailsresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/QueryFMEncounterDetailsResult.jsp", 1709116883547L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- by Meghanath -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n\t<HEAD>\n\t\t<!-- <LINK rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></LINK> -->\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t\t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></SCRIPT>\n\t\t<SCRIPT language=\'javascript\' src=\'../../eFM/js/QueryFMEncounterDetails.js\'></SCRIPT>\n\t\t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/common.js\'></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t</HEAD>\n\t\t<BODY OnMouseDown=\'CodeArrest();\' onKeyDown = \'lockKey();\'>\n\t\t<SCRIPT>\n\t\t\tif(parent.frames[1].document.getElementById(\"tab\").style.visibility = \'hidden\')\n\t\t\t\tparent.frames[1].document.getElementById(\"tab\").style.visibility = \'visible\';\n\t\t</SCRIPT>\n\t\t<FORM name=\'QFMEDResultForm\' id=\'QFMEDResultForm\'>\n\t\t\t<TABLE border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD class=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' width=\'29%\'><FONT \n\t\t\t\t\t\tsize=1><B>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</B><BR>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</FONT></TD>\n\t\t\t\t\t\t<TD class=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' width=\'12%\'><FONT size=1>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' width=\'15%\'><FONT size=1>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' width=\'8%\'><FONT \n\t\t\t\t\t\tsize=1><CENTER>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</CENTER></FONT></TD>\n\t\t\t\t\t\t<TD class=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' width=\'12%\'><FONT \n\t\t\t\t\t\tsize=1>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</FONT></TD>\n\t\t\t\t\t</TR>\t\t\t\t\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\t\t\t</TABLE>\n\t\t\t\t</FORM>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t<SCRIPT>\n\t\t\t\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\n\t\t\t\t\t\tparent.frames[1].location.reload();\n\t\t\t\t\t\tif(parent.frames[1].document.getElementById(\"tab\").style.visibility == \'visible\')\n\t\t\t\t\t\t\tparent.frames[1].document.getElementById(\"tab\").style.visibility = \'hidden\';\n\t\t\t\t\t\tparent.frames[2].location.href = \"../../eCommon/html/blank.html\";\n\t\t\t\t\t\tparent.frames[3].location.href = \"../../eCommon/jsp/error.jsp?err_num=\";\n\n\t\t\t\t\t</SCRIPT>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t</BODY>\n</HTML>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

	public static String checkForNull(String inputString)
	{
		return( ((inputString == null) || (inputString.equals("null"))) ? "&nbsp;" : inputString);
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

			Connection conn  = null;
			Statement stmt   = null;			
			ResultSet rst    = null;			

			String p_file_type_code			= "";
			String p_encounter_id			= "";
			
			String encounter_id				= "";
			String patline					= "";	
			String patient_id				= "";	
			String encounter_date_time		= "";	
			String volume_no				= "";	
		//	String attend_practitioner_id	= "";	
		//	String assign_care_locn_type	= "";	
		//	String assign_care_locn_code	= "";	
			String practitioner_name		= "";	
			String spacility_code_desc		= "";	
			String file_type_desc			= "";	
			String location					= "";	

			String mysql					= "";			
			String queryCriteria			= "";
			String class_value				= "QRYEVEN";

			int recordCount	= 0;
			int ind			= 0;
		
			try
			{
				String facility_id= (String) session.getValue("facility_id");

				conn = ConnectionManager.getConnection(request);
				stmt = conn.createStatement();				

				p_file_type_code = request.getParameter("file_type");
				p_encounter_id = request.getParameter("encounter_id");
				if(p_file_type_code == null || p_file_type_code.equals("null"))
					p_file_type_code = "";
				if(p_encounter_id == null || p_encounter_id.equals("null"))
					p_encounter_id = "";

				if(!p_file_type_code.equals(""))
					queryCriteria = "AND a.file_type_code = '"+p_file_type_code+"' ORDER BY a.encounter_id";
				if(!p_encounter_id.equals(""))
					queryCriteria = "AND a.encounter_id = '"+p_encounter_id+"' ";

				mysql = "SELECT a.patient_id,get_patient_line (a.patient_id,'"+localeName+"') patline, a.encounter_id,TO_CHAR (a.encounter_date_time, 'dd/hh/rrrr hh24:mi') encounter_date_time,a.volume_no,b.attend_practitioner_id, b.assign_care_locn_type,b.assign_care_locn_code,Decode(b.PATIENT_CLASS, 'IP', (select long_desc from ip_nursing_unit where facility_id = b.facility_id and nursing_unit_code = b.assign_care_locn_code), (select long_desc from Op_Clinic where facility_id = b.facility_id and clinic_code = b.assign_care_locn_code)) location,c.practitioner_name, d.short_desc spacility_code_desc,e.short_desc file_type_desc FROM fm_encounter_volume_link a, pr_encounter b, am_practitioner c, am_speciality d, mr_file_type e WHERE a.facility_id = b.facility_id AND a.encounter_id = b.encounter_id AND b.attend_practitioner_id=c.practitioner_id(+) AND b.specialty_code = d.speciality_code(+) AND a.facility_id = e.facility_id AND a.file_type_code = e.file_type_code AND a.facility_id = '"+facility_id+"' "+queryCriteria+" ";
				
				rst = stmt.executeQuery(mysql);
				while(rst != null && rst.next())
				{
					patline					= checkForNull(rst.getString("patline"));
					patient_id				= checkForNull(rst.getString("patient_id"));
					encounter_id			= checkForNull(rst.getString("encounter_id"));
					encounter_date_time		= checkForNull(rst.getString("encounter_date_time"));	
					volume_no				= checkForNull(rst.getString("volume_no"));	
				//	attend_practitioner_id	= checkForNull(rst.getString("attend_practitioner_id"));	
				//	assign_care_locn_type	= checkForNull(rst.getString("assign_care_locn_type"));	
				//	assign_care_locn_code	= checkForNull(rst.getString("assign_care_locn_code"));	
					practitioner_name		= checkForNull(rst.getString("practitioner_name"));	
					spacility_code_desc		= checkForNull(rst.getString("practitioner_name"));
					file_type_desc			= checkForNull(rst.getString("file_type_desc"));
										
					location = checkForNull(rst.getString("location"));
					
					ind = patline.lastIndexOf(',');
					patline = patline.substring(0,ind);

					if(class_value.equals("QRYEVEN"))
						class_value = "QRYODD";
					else
						class_value = "QRYEVEN";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patline));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block12Bytes, _wl_block12);
if(!p_encounter_id.equals("")){
            out.print( String.valueOf(file_type_desc));
}else if(!p_file_type_code.equals("")){
            out.print( String.valueOf(encounter_id));
}
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(encounter_date_time));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(volume_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(spacility_code_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(class_value));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(location));
            _bw.write(_wl_block17Bytes, _wl_block17);

					recordCount++;
				}


            _bw.write(_wl_block18Bytes, _wl_block18);
				
				if(recordCount == 0)
				{

            _bw.write(_wl_block19Bytes, _wl_block19);

				}
			if(rst   != null)  rst.close();			
			if(stmt  != null)  stmt.close();			
			}
			catch(Exception e)
			{
				out.println("Exception e"+e.toString());
			}
			finally
			{
				ConnectionManager.returnConnection(conn,request);			
			}

            _bw.write(_wl_block20Bytes, _wl_block20);
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
