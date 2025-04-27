package jsp_servlet._eip._jsp;

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

public final class __paintaddpractincompletevisit extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/PaintAddPractInCompleteVisit.jsp", 1729245655017L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n</head>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\t<iframe name =\'query\' MARGINWIDTH=0 MARGINHEIGHT=0 FRAMEBORDER=NO noresize scrolling=\'auto\' src=\'../../eIP/jsp/PaintPractInCompleteResult.jsp?Encounter_Id=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="&Practitioner_Id=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="&Clinic_Code=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&Patient_Id=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&Location_Type=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&IPval=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&NursingUnitCode=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'   style=\'height:40vh;width:99vw\'></iframe>\n\t<iframe name =\'add_modify\' MARGINWIDTH=0 MARGINHEIGHT=0 FRAMEBORDER=NO noresize scrolling=\'NO\' src=\'../../eIP/jsp/addPractInCompleteVisit.jsp?&aclass=S&Encounter_Id=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&Modval=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&practitioner_role=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&role=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&Remarks=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&specialtycode=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&shortdesc=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&fromServlet=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'  style=\'height:50vh;width:99vw\'></iframe>\n    <iframe name =\'tools\'  MARGINWIDTH=0 MARGINHEIGHT=0 FRAMEBORDER=NO  noresize scrolling=\'NO\' src=\'../../eIP/jsp/PractInCompleteQueryTools.jsp?Encounter_Id=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" \' style=\'height:8vh;width:99vw\'></iframe>\n  \n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\t\t   <iframe name =\'query\' MARGINWIDTH=0 MARGINHEIGHT=0 FRAMEBORDER=NO   src=\'../../eIP/jsp/PaintPractInCompleteResult.jsp?Encounter_Id=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'   style=\'height:12vh;width:100vw\'></iframe>\n\t\t\t     <iframe name =\'add_modify\' MARGINWIDTH=0 MARGINHEIGHT=0 FRAMEBORDER=NO src=\'../../eIP/jsp/addPractInCompleteVisit.jsp?&aclass=S&Encounter_Id=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'  style=\'height:39%;width:100vw\'></iframe>\n\t\t\t     <iframe name =\'tools\'  MARGINWIDTH=0 MARGINHEIGHT=0 FRAMEBORDER=NO src=\'../../eIP/jsp/PractInCompleteQueryTools.jsp?Encounter_Id=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'   style=\'height:11%;width:100vw\'></iframe>\n\t\t\t   \n\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t<script>\n\t\t\tif(\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" !=\"ip\")\n\t\t\t{\n\t\t\t\tself.location.href=\'/../../eCommon/html/blank.html\';\n\t\t\t\talert(getMessage(\"CONS_NOT_APPL\",\'IP\'));\n\t\t\t\tparent.window.close();\n\t\t\t}\n\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\n</html>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");  
            _bw.write(_wl_block2Bytes, _wl_block2);

	String P_patient_id			= checkForNull(request.getParameter("Patient_Id"));
	String P_practitioner_id	= checkForNull(request.getParameter("Practitioner_Id"));
	String NursingUnitCode		= checkForNull(request.getParameter("nurs_unit_code"));
	String P_clinic_code		= checkForNull(request.getParameter("Clinic_Code"));
	String P_locn_type			= checkForNull(request.getParameter("Location_Type"));
	String P_Modval				= checkForNull(request.getParameter("Modval"));
	String P_practitioner_role	= checkForNull(request.getParameter("practitioner_role"));
	String P_role				= checkForNull(request.getParameter("role"));
	String P_Remarks			= checkForNull(request.getParameter("Remarks"));
	String P_specialtycode		= checkForNull(request.getParameter("specialtycode"));
	String P_shortdesc			= checkForNull(request.getParameter("shortdesc"));
	String IPval				= checkForNull(request.getParameter("IPval"));
	String P_encounter_id = "";
	String fromServlet			= checkForNull(request.getParameter("fromServlet"));
	if(IPval.equals("ip"))
		 P_encounter_id			= checkForNull(request.getParameter("EncounterId"));
	else
		 P_encounter_id			= checkForNull(request.getParameter("Encounter_Id"));

            _bw.write(_wl_block3Bytes, _wl_block3);

	if(IPval.equals("ip"))
	{               		

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(P_encounter_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(P_practitioner_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(IPval));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(NursingUnitCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(P_encounter_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(P_practitioner_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(P_Modval));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(P_practitioner_role));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(P_role));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(P_Remarks));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(P_specialtycode));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(P_shortdesc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(IPval));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(fromServlet));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(NursingUnitCode));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(P_encounter_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(P_practitioner_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(IPval));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(NursingUnitCode));
            _bw.write(_wl_block20Bytes, _wl_block20);

	}

	else
	{				
		Connection conn=null;
		ResultSet rs=null;
		Statement stmt=null;

		try{
			
			conn				=  ConnectionManager.getConnection(request);	
			StringBuffer sqlQuery= new StringBuffer();	
			stmt				=  conn.createStatement();
			sqlQuery.append("select pract_type from am_practitioner where practitioner_id = '"+P_practitioner_id+"' ");
			rs=stmt.executeQuery(sqlQuery.toString());

			if( rs != null )
			 {
			   while(rs.next())
			   {
				 String P_pract_type=rs.getString("pract_type");	

				 if ((P_pract_type.equals("MD"))||(P_pract_type.equals("SG"))||(P_pract_type.equals("PS"))||(P_pract_type.equals("DN")))
				  {

	
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(P_encounter_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(P_practitioner_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(IPval));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(NursingUnitCode));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(P_encounter_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(P_practitioner_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(P_Modval));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(P_practitioner_role));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(P_role));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(P_Remarks));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(P_specialtycode));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(P_shortdesc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(IPval));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(NursingUnitCode));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(P_encounter_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(P_practitioner_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(P_clinic_code));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(P_patient_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(P_locn_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(IPval));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(NursingUnitCode));
            _bw.write(_wl_block24Bytes, _wl_block24);
	      }
		      else
		      {            	
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(IPval));
            _bw.write(_wl_block26Bytes, _wl_block26);

		      }
		   }
		 }
		if (sqlQuery.length() > 0)
          	sqlQuery.delete(0, sqlQuery.length());
		}
		catch(Exception e)
		{out.println("Exception in tryCatch : "+ e.toString());}
		finally
		{
			try{
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
			ConnectionManager.returnConnection(conn,request);
			}
			catch(Exception ee){out.println("Error while closing the connections:"+ee.toString());}
		}
	}

            _bw.write(_wl_block27Bytes, _wl_block27);
            _bw.write(_wl_block28Bytes, _wl_block28);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
