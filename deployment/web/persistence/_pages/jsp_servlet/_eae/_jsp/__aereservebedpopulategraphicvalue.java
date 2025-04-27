package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import javax.servlet.jsp.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __aereservebedpopulategraphicvalue extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AEReserveBedPopulateGraphicValue.jsp", 1709113858194L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!doctype html public \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'Javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<script>\n\t\t\t\tvar select = parent.frames[1].document.reserve_bed_form.treatment_area;\n\t\t\t\tvar length = select.length;\n\t\t\t\tfor(i=0;i<length;i++)\n\t\t\t\t\tselect.remove(0);\n\t\t\t\tvar option\t\t=  parent.frames[1].document.createElement(\"OPTION\");\n\t\t\t\toption.text\t\t=  \"----- Select -----\"\t;\n\t\t\t\toption.value\t=  \"\"\t;\n\t\t\t\toption.selected\t=  true;\n\t\t\t\tselect.add(option);\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<script>\n\t\t\t\t\tvar option\t\t=  parent.frames[1].document.createElement(\"OPTION\");\n\t\t\t\t\toption.text\t\t=  \'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n\t\t\t\t\toption.value\t=  \'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n\t\t\t\t\tselect.add(option);\n\t\t\t\t\t</script> \n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\talert(getMessage(\'INVALID_BED\',\'AE\'));\n\t\t\t\t\t\tparent.frames[1].document.reserve_bed_form.bed_no.select();\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\talert(getMessage(\'BED_OCCUPIED\',\'AE\'));\n\t\t\t\t\t\tparent.frames[1].document.reserve_bed_form.bed_no.select();\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\talert(getMessage(\'BED_RESERVED\',\'AE\'));\n\t\t\t\t\t\tparent.frames[1].document.reserve_bed_form.bed_no.select();\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<script>\n\t\t\t\tvar select = parent.frames[1].document.AEBedAvailChartForm.treatment_area;\n\t\t\t\tvar length = select.length;\n\t\t\t\tfor(i=0;i<length;i++)\n\t\t\t\t\tselect.remove(0);\n\t\t\t\tvar option\t\t=  parent.frames[1].document.createElement(\"OPTION\");\n\t\t\t\toption.text\t\t=  \"----- Select -----\"\t;\n\t\t\t\toption.value\t=  \"\"\t;\n\t\t\t\toption.selected\t=  true;\n\t\t\t\tselect.add(option);\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\';\n\t\t\t\t\t\n\t\t\t\t\tif (\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'==\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\')\n\t\t\t\t\t\toption.selected = true;\n\t\t\t\t\tselect.add(option);\n\t\t\t\t\t</script> \n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n<script>\nparent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";</script>\n</html>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

	// To Handle java.lang.NullPointerException.

	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? "" : inputString );
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return ( ((inputString == null) || (inputString.equalsIgnoreCase("null"))) ? defaultValue : inputString );
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

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection connection			=	null;
	PreparedStatement pStatement	=	null;
	ResultSet		resultSet		=	null;
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String locale			= (String)session.getAttribute("LOCALE");
	StringBuffer sqlBuffer			=	new StringBuffer();
	String		function_name		=	"";
	String		sub_function_name	=	"";
	String		field1				=	"";
	String		field2				=	"";
	String		field3				=	"";
	String		field4				=	"";
	String		code				=	"";
	String		desc				=	"";
	String		facilityID			=	"";
	try
	{
		facilityID			=	checkForNull((String) session.getValue("facility_id"));
		function_name		=	checkForNull(request.getParameter("function_name"));
		sub_function_name	=	checkForNull(request.getParameter("sub_function_name"));
		field1				=	checkForNull(request.getParameter("field1"));
		field2				=	checkForNull(request.getParameter("field2"));
		field3				=	checkForNull(request.getParameter("field3"));
		field4				=	checkForNull(request.getParameter("field4"));
		connection			= ConnectionManager.getConnection(request);

		if ((function_name.equals("ReserveBed")) && (sub_function_name.equals("TreatmentArea")))
		{
			
            _bw.write(_wl_block8Bytes, _wl_block8);

			sqlBuffer.append("select treatment_area_code, short_desc from ae_tmt_area_for_clinic where clinic_code = ? and facility_id = ? and eff_status='E' ");	

			if (pStatement != null)	pStatement	= null;
			if (resultSet != null)	resultSet	= null;

			pStatement	= connection.prepareStatement(sqlBuffer.toString());
			pStatement.setString(1, field1);
			pStatement.setString(2, facilityID);
			resultSet	= pStatement.executeQuery();
			if (resultSet != null)
			{
				while(resultSet.next())
				{
					code = checkForNull(resultSet.getString("treatment_area_code"));
					desc = checkForNull(resultSet.getString("short_desc"));
				
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(code));
            _bw.write(_wl_block11Bytes, _wl_block11);

				}
			}
		}
        if(resultSet!=null)resultSet.close();
		if(pStatement!=null)pStatement.close();
		
		if ((function_name.equals("ReserveBed")) && (sub_function_name.equals("ValidBed")))
		{
			String treatment_area	=	field1;
			String bed				=	field2;
			String facility_id		=	field3;
			String clinic			=	field4;

			int countValue			= 0;
			if (sqlBuffer.length() > 0)
				sqlBuffer.delete(0, sqlBuffer.length());
			sqlBuffer.append("select count(*) countValue from ae_bed_for_trmt_area_lang_vw where  language_id='"+locale+"' and clinic_code ");
			sqlBuffer.append("= ? and treatment_area_code = ? and bed_no = ? and facility_id = ? ");
			
			if (pStatement != null)	pStatement	= null;
			if (resultSet != null)	resultSet	= null;

			pStatement	= connection.prepareStatement(sqlBuffer.toString());
			
			pStatement.setString(1, clinic);
			pStatement.setString(2, treatment_area);
			pStatement.setString(3, bed);
			pStatement.setString(4, facility_id);

			resultSet	= pStatement.executeQuery();
			if ((resultSet != null) && (resultSet.next()))
				countValue	=	resultSet.getInt("countValue");

			if (countValue == 0)
			{
				
            _bw.write(_wl_block12Bytes, _wl_block12);

			}
        if(resultSet!=null)resultSet.close();
		if(pStatement!=null)pStatement.close();

			if (countValue > 0)
			{
				String occupying_patient_id	 = "";
				String current_status		 = "";
				if (sqlBuffer.length() > 0)
					sqlBuffer.delete(0, sqlBuffer.length());
				sqlBuffer.append("select occupying_patient_id, current_status from ");
				sqlBuffer.append("ae_bed_for_trmt_area where clinic_code = ? and treatment_area_code ");
				sqlBuffer.append("= ? and bed_no = ? and facility_id = ? ");
				
				if (pStatement != null)	pStatement	= null;
				if (resultSet != null)	resultSet	= null;

				pStatement	= connection.prepareStatement(sqlBuffer.toString());
				
				pStatement.setString(1, clinic);
				pStatement.setString(2, treatment_area);
				pStatement.setString(3, bed);
				pStatement.setString(4, facility_id);

				resultSet	= pStatement.executeQuery();
				if ((resultSet != null) && (resultSet.next()))
				{
					occupying_patient_id = checkForNull(resultSet.getString("occupying_patient_id"));
					current_status		 = checkForNull(resultSet.getString("current_status"));
				}
				
				if (!occupying_patient_id.equals(""))
				{
				
            _bw.write(_wl_block13Bytes, _wl_block13);
	
				}
				if (current_status.equals("R"))
				{
				
            _bw.write(_wl_block14Bytes, _wl_block14);
	
				}
			}
		}
		
        if(resultSet!=null)resultSet.close();
		if(pStatement!=null)pStatement.close();

		if ((function_name.equals("BedAvailChart")) && (sub_function_name.equals("TreatmentArea")))
		{
			
            _bw.write(_wl_block15Bytes, _wl_block15);

		//	sqlBuffer.append("select treatment_area_code, short_desc from ae_tmt_area_for_clinic where clinic_code = ? and facility_id = ? AND TRIAGE_AREA_YN <> 'Y'  ");	

		sqlBuffer.append("select treatment_area_code, short_desc from ae_tmt_area_for_clinic_lang_vw where  language_id='"+locale+"' and  clinic_code = ? and facility_id = ?  ");	

			if (pStatement != null)	pStatement	= null;
			if (resultSet != null)	resultSet	= null;
			pStatement	= connection.prepareStatement(sqlBuffer.toString());
			pStatement.setString(1, field1);
			pStatement.setString(2, facilityID);
			resultSet	= pStatement.executeQuery();
			if (resultSet != null)
			{
				while(resultSet.next())
				{
					code = checkForNull(resultSet.getString("treatment_area_code"));
					desc = checkForNull(resultSet.getString("short_desc"));
				
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(field2));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(code));
            _bw.write(_wl_block18Bytes, _wl_block18);

				}
			}
			out.println("<script>parent.frames[4].document.location.href='../../eAE/jsp/AECheckBoxStatus.jsp'</script>");
		}
		
	}catch(Exception exception)
	{
		exception.printStackTrace();
	}
	finally
	{
		if (resultSet != null)	resultSet.close();
		if (pStatement != null)	pStatement.close();
		ConnectionManager.returnConnection(connection, request);
	}

            _bw.write(_wl_block19Bytes, _wl_block19);
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
