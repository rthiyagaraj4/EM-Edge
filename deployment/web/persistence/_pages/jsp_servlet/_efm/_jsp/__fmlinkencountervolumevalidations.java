package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __fmlinkencountervolumevalidations extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMLinkEncounterVolumeValidations.jsp", 1709116863031L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tparent.frames[1].document.getElementById(\"FileNo\").innerHTML = \"<input type=\'text\' name=\'file_no\' id=\'file_no\' value=\'\' onBlur=\'getPaientID(this.value);\'><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tparent.frames[1].document.getElementById(\"FileNo\").innerHTML = \"<input type=\'text\' name=\'file_no\' id=\'file_no\' value=\'\"+\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"+\"\' onBlur=\'getPaientID(this.value);\'><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar optionValue\t= \"\";\t\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\toptionValue = optionValue + \"<option value=\'\"+\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"+\"\'>\"+\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"+\"</option>\";\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\tvar selectBox\t= \"<select name=\'file_no\' id=\'file_no\' value = \'\' ><option>------------------------\"+getLabel(\'Common.defaultSelect.label\',\'common\')+\"-----------------------</option>\";\n\t\t\t\t\t\tselectBox += optionValue;\n\t\t\t\t\t\tselectBox += \"</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t\t\t\tparent.frames[1].document.getElementById(\"FileNo\").innerHTML = selectBox;\n\t\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tparent.frames[1].document.getElementById(\"FileType\").innerHTML = \"<input type=\'text\' name=\'file_type\' id=\'file_type\' value=\'\' ><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tparent.frames[1].document.getElementById(\"FileType\").innerHTML = \"<input type=\'text\' name=\'file_type\' id=\'file_type\' value=\'\"+\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"+\"\'><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t\t\t\t\tparent.frames[1].document.forms[0].patient_file_type.value = \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\tvar selectBox\t= \"<select name=\'file_type\' id=\'file_type\' onChange=\'setValues(this.value)\'><option value = \'\' >----------\"+getLabel(\'Common.defaultSelect.label\',\'common\')+\"---------</option>\";\n\t\t\t\t\t\tselectBox += optionValue;\n\t\t\t\t\t\tselectBox += \"</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t\t\t\tparent.frames[1].document.getElementById(\"FileType\").innerHTML = selectBox;\n\t\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<script>\n\t\t\t\tparent.frames[1].document.forms[0].patient_id.value = \'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\';\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t<script>\n\t\t\t\tparent.frames[1].document.forms[0].patient_id.value = \'\';\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\n</head>\n\n<script>parent.messageFrame.document.location.href=\'../../eCommon/jsp/error.jsp\';</script>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n</html>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );


public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
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

Connection connection			=	null;
PreparedStatement preStatement	=	null;
ResultSet	resultSet			=	null;

String facilityID				=	"";
String patientID				=	"";
String file_type_appl_yn		=	"N";
String sqlString				=	"";
String file_no					=	"";
String file_type_code			=	"";
String file_type_desc			=	"";
String fileNo					=	"";

int record_count				=	0;

try
{
	facilityID 			=	checkForNull((String) session.getValue("facility_id"));
	patientID			=	checkForNull(request.getParameter("patientID"));
	file_type_appl_yn	=	checkForNull(request.getParameter("file_type_appl_yn"));
	fileNo				=	checkForNull(request.getParameter("fileNo"));
	connection			=	ConnectionManager.getConnection(request);	

	if (!patientID.equals(""))
	{
		webbeans.op.PatientData patdata = new webbeans.op.PatientData();
		patdata.setFacility_id(facilityID);
		String patient_status = patdata.CheckStatus(connection,patientID);
		if (patient_status.equals("INVALID_PATIENT"))
			out.println("<script>var msg = getMessage('INVALID_VALUE','Common'); msg = msg.replace('#',getLabel('Common.patientId.label','Common'));alert(msg);parent.frames[1].document.forms[0].patient_id.value='';parent.frames[1].document.forms[0].patient_id.select();</script>");
	}
	if (fileNo.equals(""))
	{
		if (file_type_appl_yn.equals("N"))
			sqlString = "SELECT count(*) record_count FROM mr_pat_file_index WHERE facility_id = ? AND patient_id = ? ";
		else if (file_type_appl_yn.equals("Y"))
			sqlString = "SELECT count(*) record_count FROM mr_file_type a, mr_pat_file_index b WHERE a.facility_id = b.facility_id AND a.file_type_code = b.file_type_code AND a.facility_id = ? AND b.patient_id = ? ";

		preStatement	=	connection.prepareStatement(sqlString);
		preStatement.setString(1, facilityID);
		preStatement.setString(2, patientID);

		resultSet = preStatement.executeQuery();
		if ((resultSet != null) && (resultSet.next()))
			record_count = resultSet.getInt("record_count");

		if (file_type_appl_yn.equals("N"))
			sqlString = "SELECT file_no FROM mr_pat_file_index WHERE facility_id = ? AND patient_id = ? ";
		else if (file_type_appl_yn.equals("Y"))
			sqlString = "SELECT DISTINCT a.file_type_code file_type_code, a.short_desc file_type_desc FROM mr_file_type a, mr_pat_file_index b WHERE a.facility_id = b.facility_id AND a.file_type_code = b.file_type_code AND a.facility_id = ? AND b.patient_id = ? ";

		if(resultSet!=null)	resultSet.close();
		if(preStatement!=null) preStatement.close();

		preStatement	=	connection.prepareStatement(sqlString);
		preStatement.setString(1, facilityID);
		preStatement.setString(2, patientID);

		resultSet = preStatement.executeQuery();
		if (resultSet != null)
		{
			if (file_type_appl_yn.equals("N"))
			{
				if (record_count==0)
				{
					
            _bw.write(_wl_block8Bytes, _wl_block8);

				}
				else if (record_count==1)
				{
					if(resultSet.next())
					{
						file_no		=	checkForNull(resultSet.getString("file_no"));
					
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(file_no));
            _bw.write(_wl_block10Bytes, _wl_block10);

					}
				}
				else if (record_count > 1)
				{
				
            _bw.write(_wl_block11Bytes, _wl_block11);

					while(resultSet.next())
					{
						file_no		=	checkForNull(resultSet.getString("file_no"));
				
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(file_no));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(file_no));
            _bw.write(_wl_block14Bytes, _wl_block14);

					}
				
            _bw.write(_wl_block15Bytes, _wl_block15);

				}
			}
			else
			if (file_type_appl_yn.equals("Y"))
			{
				if (record_count==0)
				{
					
            _bw.write(_wl_block16Bytes, _wl_block16);

				}
				else if (record_count==1)
				{
					if(resultSet.next())
					{
						file_type_code		=	checkForNull(resultSet.getString("file_type_code"));
						file_type_desc		=	checkForNull(resultSet.getString("file_type_desc"));
					
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(file_type_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(file_type_code));
            _bw.write(_wl_block19Bytes, _wl_block19);

					}
				}
				else if (record_count > 1)
				{
				
            _bw.write(_wl_block11Bytes, _wl_block11);

					while(resultSet.next())
					{
						file_type_code		=	checkForNull(resultSet.getString("file_type_code"));
						file_type_desc		=	checkForNull(resultSet.getString("file_type_desc"));
				
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(file_type_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(file_type_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);

					}
				
            _bw.write(_wl_block20Bytes, _wl_block20);

				}
			}
		}
	}
	else if (!fileNo.equals(""))
	{
		if(resultSet!=null)	resultSet.close();
		if(preStatement!=null) preStatement.close();
		sqlString = "SELECT patient_id FROM mr_pat_file_index WHERE facility_id = ? AND file_no = ? ";
		preStatement	=	connection.prepareStatement(sqlString);
		preStatement.setString(1, facilityID);
		preStatement.setString(2, fileNo);
		
		resultSet	=	preStatement.executeQuery();
		if ((resultSet != null) && (resultSet.next()))
		{
		
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(checkForNull(resultSet.getString("patient_id"))));
            _bw.write(_wl_block22Bytes, _wl_block22);

		}
		else
		{
		
            _bw.write(_wl_block23Bytes, _wl_block23);

		}	
	}


            _bw.write(_wl_block24Bytes, _wl_block24);

if(preStatement!=null) preStatement.close();
if(resultSet!=null)	resultSet.close();
}
catch(Exception e)
{
	out.println("Exception : " + e.toString());
}
finally
{
	ConnectionManager.returnConnection(connection,request);
}

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
