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
import java.net.*;
import webbeans.eCommon.*;
import webbeans.eFM.FileDeficiencyMonitoring;
import java.util.*;
import com.ehis.util.*;

public final class __filedeficiencymonitoringbean extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FileDeficiencyMonitoringBean.jsp", 1709116823904L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eFM/js/FMFileDeficiencyMonitoring.js\' language=\'javascript\'></script>\n\n</head>\n<body class=\'message\' onKeyDown = \'lockKey()\'>\n<form name=\"DeficiencyMonitoring_bean\" id=\"DeficiencyMonitoring_bean\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<script language=\'javascript\'>\n\t\t\t\t\tvar errors = getMessage(\'DEFICIENCY_EXIST\',\'FM\');\t\n\t\t\t\t\tparent.frames[5].document.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+errors; \n\t\t\t\t\tparent.frames[4].document.forms[0].deficiency.focus();\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<script language=\'javascript\'>\n\t\t\t\t\n\t\t\t\t\tparent.frames[3].location.href = \"../../eFM/jsp/FMFileDeficiencyMonitoringDetails.jsp?PatientId=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"; \n\t\t\t\t\tparent.frames[4].document.forms[0].operation_mode.value=\"Add\";\n\t\t\t\t\tparent.frames[4].document.forms[0].deficiency.disabled = false;\n\t\t\t\t\tparent.frames[4].document.forms[0].physician.disabled = false;\n\t\t\t\t\tparent.frames[4].document.forms[0].date_reported.disabled = false;\n\t\t\t\t\tparent.frames[4].document.forms[0].date_resolved.disabled = true;\n\t\t\t\t\tparent.frames[4].document.forms[0].remarks.disabled = false;\n\t\t\t\t\tparent.frames[4].document.forms[0].add.disabled = false;\n\t\t\t\t\tparent.frames[4].document.forms[0].deficiency.value = \"\";\n\t\t\t\t\tparent.frames[4].document.forms[0].physician.value = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\t\tparent.frames[4].document.forms[0].physician1.value = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\t\t\tparent.frames[4].document.forms[0].date_reported.value = \"\";\n\t\t\t\t\tparent.frames[4].document.forms[0].date_resolved.value = \"\";\n\t\t\t\t\tparent.frames[4].document.forms[0].remarks.value = \"\";\n\t\t\t\t\tparent.frames[4].document.forms[0].defy_status(0).checked = true;\n\t\t\t\t\tparent.frames[4].document.forms[0].defy_status(1).checked = false;\n\t\t\t\t\tparent.frames[4].document.forms[0].defy_status(2).checked = false;\n\t\t\t\t\tparent.frames[4].document.forms[0].defy_status(1).disabled = true;\n\t\t\t\t\tparent.frames[4].document.forms[0].defy_status(2).disabled = true;\n\t\t\t\t\tparent.frames[4].document.forms[0].operation_mode.value = \"Add\";\n\t\t\t\t    </script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eFM.FileDeficiencyMonitoring recordSetDeficiency= null;synchronized(session){
                recordSetDeficiency=(webbeans.eFM.FileDeficiencyMonitoring)pageContext.getAttribute("recordSetDeficiency",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(recordSetDeficiency==null){
                    recordSetDeficiency=new webbeans.eFM.FileDeficiencyMonitoring();
                    pageContext.setAttribute("recordSetDeficiency",recordSetDeficiency,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String PatientId="";
	String	operation_mode		=	"";
	String  fac_id				=	"";
	String  encounter_id		=	"";
	String	file_no				=	"";
	String	defi_code			=	"";
	String	defi_desc			=	"";
	String	admission_date		=	"";
	String	discharge_date		=	"";
	String	care_locn_code		=	"";
	String	defi_completed_status=	"";
	String	practitioner		=	"";
	String	practitioner_name	=	"";
	String	defi_reported_date	=	"";
	String	defi_status			=	"";
	String	defi_resolved_date	=	"";
	String	defi_remarks		=	"";
	String  item_delete_yn		=	"N";
	String  header_exist		=	"";
	String  patient_class		=	"";
	String  file_type			=	"";
	String  volume_no			=	"";
	String  record_from			=	"",dflt_practitioner="",dflt_practitioner_name="";

	int		row_index			=	0;
	boolean	duplicateExists		=	false;	

	HashMap		htRecord	=	null; 	

	try
	{
		operation_mode	=	(request.getParameter("operation_mode")==null)?	""	: request.getParameter("operation_mode");
       if(operation_mode.equals("")) recordSetDeficiency.clearAll();
		if(operation_mode.equals("ScreenModify"))
		{	
			operation_mode = "Modify";
			record_from = "SCREEN";
		}
		else if(operation_mode.equals("DatabaseModify"))
		{
			operation_mode = "Modify";
			record_from = "DATABASE";
		}
		else if(operation_mode.equals("Add"))
		{
			record_from = "SCREEN";
		}

		if(operation_mode.equals("Add") || operation_mode.equals("Modify"))
		{

			dflt_practitioner =	(request.getParameter("dflt_practitioner")==null) ? "" :										request.getParameter("dflt_practitioner");
			
			dflt_practitioner_name = (request.getParameter("dflt_practitioner_name")==null) ? "" :									request.getParameter("dflt_practitioner_name");
			
			PatientId =	(request.getParameter("PatientId")==null) ?	"" :											request.getParameter("PatientId");
			fac_id = (request.getParameter("fac_id")==null) ? "" : request.getParameter("fac_id");
			
			encounter_id = (request.getParameter("encounter_id")==null) ? "" :											request.getParameter("encounter_id");
			
			file_no = (request.getParameter("file_no")==null) ? "" : request.getParameter("file_no");
			
			defi_code =	(request.getParameter("defi_code")==null) ? "" :											request.getParameter("defi_code");
			
			defi_desc =	(request.getParameter("defi_desc")==null) ? "" :											request.getParameter("defi_desc");
			
			admission_date = (request.getParameter("admission_date")==null) ? "" :											request.getParameter("admission_date");
			
			discharge_date = (request.getParameter("discharge_date")==null) ? "" :											request.getParameter("discharge_date");
			
			care_locn_code = (request.getParameter("care_locn_code")==null) ? "" :											request.getParameter("care_locn_code");
			
			defi_completed_status =	(request.getParameter("defi_completed_status")==null) ?	"" :								request.getParameter("defi_completed_status");
			
			practitioner = (request.getParameter("practitioner")==null) ? "" :											request.getParameter("practitioner");
			
			practitioner_name =	(request.getParameter("practitioner_name")==null) ? "" :									request.getParameter("practitioner_name");
			
			defi_reported_date = (request.getParameter("defi_reported_date")==null) ? "" :										request.getParameter("defi_reported_date");

			defi_status = (request.getParameter("defi_status")==null) ? "" :											request.getParameter("defi_status");
			
			defi_resolved_date = (request.getParameter("defi_resolved_date")==null) ? "" :										request.getParameter("defi_resolved_date");
			
			defi_remarks = (request.getParameter("defi_remarks")==null) ? "" :											request.getParameter("defi_remarks");
			header_exist = (request.getParameter("header_exist")==null) ? "" :											request.getParameter("header_exist");
			
			patient_class = (request.getParameter("patient_class")==null) ? "" :											request.getParameter("patient_class");
			
			file_type =	(request.getParameter("file_type")==null) ? "" :												request.getParameter("file_type");
			
			volume_no =	(request.getParameter("volume_no")==null) ? "" :											request.getParameter("volume_no");

			htRecord	= new HashMap();

			htRecord.put("PatientId",				PatientId);
			htRecord.put("facility_id",				fac_id);
			htRecord.put("encounter_id",			encounter_id);
			htRecord.put("file_no",					file_no);
			htRecord.put("defi_code",				defi_code);
			htRecord.put("defi_desc",				defi_desc);
			htRecord.put("admission_date",			admission_date);
			htRecord.put("discharge_date",			discharge_date);
			htRecord.put("care_locn_code",			care_locn_code);
			htRecord.put("defi_completed_status",	defi_completed_status);
			htRecord.put("practitioner",			practitioner);
			htRecord.put("practitioner_name",		practitioner_name);
			htRecord.put("defi_reported_date",		defi_reported_date);
			htRecord.put("defi_status",				defi_status);
			htRecord.put("defi_resolved_date",		defi_resolved_date);
			htRecord.put("defi_remarks",			defi_remarks);
			htRecord.put("item_delete_yn",			item_delete_yn);
			htRecord.put("header_exist",			header_exist);
			htRecord.put("patient_class",			patient_class);
			htRecord.put("file_type",				file_type);
			htRecord.put("volume_no",				volume_no);
         	if(record_from.equals("SCREEN"))
			{
				htRecord.put("operation_mode",	"Add");
			}
			else
			{
				htRecord.put("operation_mode",	"Modify");
			}

			htRecord.put("record_from",	record_from);
			
			if(operation_mode.equals("Add"))
			{
				duplicateExists	=	recordSetDeficiency.isDetailAddDuplicateExists(htRecord);
			}
			
			if(duplicateExists)
			{
				
            _bw.write(_wl_block8Bytes, _wl_block8);

			}
			else
			{
				if( operation_mode.equals("Add"))
				{
					recordSetDeficiency.putObject(htRecord);
				 }
				else if(operation_mode.equals("Modify"))
				{
				row_index = Integer.parseInt(request.getParameter("record_num"));
				 if(recordSetDeficiency.isDetailAddDuplicateExists(htRecord))
				{
				 recordSetDeficiency.setObject(row_index,htRecord);
				 }
				}
				
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(dflt_practitioner));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(dflt_practitioner_name));
            _bw.write(_wl_block12Bytes, _wl_block12);

			}
		}
	}
	catch(Exception e)
	{
		out.println("Exception@1: "+e);
	}

            _bw.write(_wl_block13Bytes, _wl_block13);
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
