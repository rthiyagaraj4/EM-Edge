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

public final class __fmreturntomrdvalidations extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMReturnToMRDValidations.jsp", 1709116873687L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n<html>\n<head>\n<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eFM/js/FMReturnToMRD.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<script>\n\t\t\t\tvar selectBox   = parent.criteria_frame.document.FMReturnToMRDCriteriaForm.fs_req_location;\n\t\t\t\tvar seletLen\t=\tMath.abs(selectBox.length);\n\t\t\t\tfor (i=0; i<seletLen; i++)\n\t\t\t\t\tselectBox.remove(0);\n\t\t\t\tvar selectOption\t=  parent.criteria_frame.document.createElement(\"OPTION\");\t\t\n\t\t\t\tselectOption.value\t=\t\"\";\n\t\t\t\tselectOption.text\t=\t\"--------\"+getLabel(\"Common.defaultSelect.label\",\"common\")+\"--------\";\n\t\t\t\tselectBox.add(selectOption);\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\tselectOption\t\t=  parent.criteria_frame.document.createElement(\"OPTION\");\t\t\n\t\t\t\tselectOption.value\t=\t\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\tselectOption.text\t=\t\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\tselectBox.add(selectOption);\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\tif (\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" == \"C\")\n\t\t\t{    \n\t\t\t    \n\t\t\t\tparent.criteria_frame.document.getElementById(\"returning\").innerText = getLabel(\"Common.clinic.label\",\"common\");\n\t\t\t\tparent.criteria_frame.document.FMReturnToMRDCriteriaForm.returning_code.value = \"\";\n\t\t\t\tparent.criteria_frame.document.FMReturnToMRDCriteriaForm.returning_desc.value = \"\";\n\t\t\t}\n\t\t\telse if (\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" == \"N\")\n\t\t\t{\n\t\t\t\tparent.criteria_frame.document.getElementById(\"returning\").innerText = getLabel(\"Common.nursingUnit.label\",\"common\"); \tparent.criteria_frame.document.FMReturnToMRDCriteriaForm.returning_code.value = \"\";\n\t\t\t\tparent.criteria_frame.document.FMReturnToMRDCriteriaForm.returning_desc.value = \"\";\n\t\t\t}\n\t\t\telse if (\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" == \"T\")\n\t\t\t{\n\t\t\t\tparent.criteria_frame.document.getElementById(\"returning\").innerText = getLabel(\"Common.practitioner.label\",\"common\"); \tparent.criteria_frame.document.FMReturnToMRDCriteriaForm.returning_code.value = \"\";\n\t\t\t\tparent.criteria_frame.document.FMReturnToMRDCriteriaForm.returning_desc.value = \"\";\n\t\t\t}\n            else if (\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" == \"Y\")\n\t\t\t{\n\t\t\t\tparent.criteria_frame.document.getElementById(\"returning\").innerText = getLabel(\"Common.DaycareUnit.label\",\"common\"); \tparent.criteria_frame.document.FMReturnToMRDCriteriaForm.returning_code.value = \"\";\n\t\t\t\tparent.criteria_frame.document.FMReturnToMRDCriteriaForm.returning_desc.value = \"\";\n\t\t\t}\n\t\t\telse if (\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" == \"E\")\n\t\t\t{\n\t\t\t\tparent.criteria_frame.document.getElementById(\"returning\").innerText = getLabel(\"Common.ProcedureUnit.label\",\"common\"); \tparent.criteria_frame.document.FMReturnToMRDCriteriaForm.returning_code.value = \"\";\n\t\t\t\tparent.criteria_frame.document.FMReturnToMRDCriteriaForm.returning_desc.value = \"\";\n\t\t\t}\n            else if (\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" == \"D\")\n\t\t\t{\n\t\t\t\tparent.criteria_frame.document.getElementById(\"returning\").innerText = getLabel(\"Common.department.label\",\"common\"); \tparent.criteria_frame.document.FMReturnToMRDCriteriaForm.returning_code.value = \"\";\n\t\t\t\tparent.criteria_frame.document.FMReturnToMRDCriteriaForm.returning_desc.value = \"\";\n\t\t\t} \n\t\t\telse \n\t\t\t{  \n\t\t\t\tparent.criteria_frame.document.getElementById(\"returning\").innerText = getLabel(\"eFM.Returning.label\",\"FM\");\n\t\t\t\tparent.criteria_frame.document.FMReturnToMRDCriteriaForm.returning_code.value = \"\";\n\t\t\t\tparent.criteria_frame.document.FMReturnToMRDCriteriaForm.returning_desc.value = \"\";\n\t\t\t}\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n</head>\n<script>parent.messageFrame.document.location.href=\'../../eCommon/jsp/error.jsp\';\n</script>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n</html>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

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
 
	request.setCharacterEncoding("UTF-8");
	String sStyle			= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
	

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

Connection connection			=	null;
PreparedStatement preStatement	=	null;
PreparedStatement volStatement	=	null;
ResultSet	resultSet			=	null;
ResultSet	volResultSet		=	null;

String facilityID				=	"";
//String patientID				=	"";
String fs_location1				=	"";
String operation				=	"";
//String file_type_appl_yn		=	"N";
String sqlString				=	"";
//String fileType				=	"";
//String fileNo					=	"";

try
{
	facilityID 			=	checkForNull((String) session.getValue("facility_id"));
      Properties p				= (Properties) session.getValue("jdbc");
	String addedById			= p.getProperty("login_user");
	 //below line(s) added by venkatesh.S against issue KAUH-SCF-0016 [IN032341] on 23/April/2012
     String userSecurity =checkForNull(request.getParameter("userSecurity"));
    //end issue KAUH-SCF-0016 [IN032341] 
		
//	patientID			=	checkForNull(request.getParameter("patientID"));
	fs_location1			=	checkForNull(request.getParameter("fs_location1"));
	operation			=	checkForNull(request.getParameter("operation"));
	//file_type_appl_yn	=	checkForNull(request.getParameter("file_type_appl_yn"));
	//fileNo				=	checkForNull(request.getParameter("fileNo"));
	//fileType			=	checkForNull(request.getParameter("fileType"));
	connection			=	ConnectionManager.getConnection(request);	
	
	
	if (operation.equals("LOCATION"))
	{
			
//sqlString="SELECT a.fs_locn_code,fm_get_desc.fm_storage_locn(a.facility_id,a.fs_locn_code, 'en', 2) short_desc FROM fm_storage_locn a WHERE a.eff_status = 'E' AND EXISTS (SELECT 'x' FROM fm_user_access_rights  WHERE facility_id = a.facility_id  and appl_user_id = '"+addedById+"' and (fs_locn_code = a.fs_locn_code or fs_locn_code = '*ALL')) AND locn_identity = '"+fs_location1+"' AND a.facility_id ='"+facilityID+"'  ORDER BY 2 " ;



	/*	sqlString = "SELECT"
				  +"  fs_Locn_Code"
				  +"  ,fm_get_desc.fm_storage_locn (facility_id, fs_Locn_Code,'"+localeName+"',2 ) Short_desc "
				  +"FROM"
				  +"  FM_STORAGE_LOCN "
				  +"WHERE eff_Status = 'E' "
				  +"  AND Facility_Id = ? "
				  +"  AND Locn_Identity = ?"
				//  +"  AND LANGUAGE_ID=?"
				  +"ORDER BY"
				  +"  2"; */

			
//below line(s) added by venkatesh.S against issue KAUH-SCF-0016 [IN032341] on 23/April/2012
          
		  if(userSecurity.equals("Y"))
            {
        sqlString="SELECT a.fs_locn_code,fm_get_desc.fm_storage_locn(a.facility_id,a.fs_locn_code, 'en', 2) short_desc FROM fm_storage_locn a WHERE a.eff_status = 'E' AND EXISTS (SELECT 'x' FROM fm_user_access_rights  WHERE facility_id = a.facility_id  and appl_user_id = '"+addedById+"' and (fs_locn_code = a.fs_locn_code or fs_locn_code = '*ALL')) AND locn_identity = '"+fs_location1+"' AND a.facility_id ='"+facilityID+"'  ORDER BY 2 " ;
           }
		else
		{
		sqlString="SELECT a.fs_locn_code,fm_get_desc.fm_storage_locn(a.facility_id,a.fs_locn_code, 'en', 2) short_desc FROM fm_storage_locn a WHERE a.eff_status = 'E'  AND locn_identity = '"+fs_location1+"' AND a.facility_id ='"+facilityID+"'  ORDER BY 2 " ;
		}
		
//end issue KAUH-SCF-0016 [IN032341] 	  
				  
		
		if (preStatement != null)  preStatement = null;
		if (resultSet != null)  resultSet = null;
		
		
		preStatement	=	connection.prepareStatement(sqlString);
	//	preStatement.setString(1, facilityID);
	//	preStatement.setString(2, fs_location1);
	//	preStatement.setString(3, localeName);

		resultSet = preStatement.executeQuery();
		if (resultSet != null)
		{
		
            _bw.write(_wl_block8Bytes, _wl_block8);

			while (resultSet.next())
			{
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(checkForNull(resultSet.getString("fs_locn_code"))));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(checkForNull(resultSet.getString("short_desc"))));
            _bw.write(_wl_block11Bytes, _wl_block11);

			}
		}
		
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(fs_location1));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(fs_location1));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(fs_location1));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(fs_location1));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(fs_location1));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(fs_location1));
            _bw.write(_wl_block18Bytes, _wl_block18);

	}

            _bw.write(_wl_block19Bytes, _wl_block19);

if(preStatement!=null) preStatement.close();
if(volStatement!=null) volStatement.close();
if(resultSet!=null)	resultSet.close();
if(volResultSet!=null)	volResultSet.close();
}
catch(Exception e)
{
	out.println("Exception : " + e.toString());
}
finally
{
	ConnectionManager.returnConnection(connection,request);
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
