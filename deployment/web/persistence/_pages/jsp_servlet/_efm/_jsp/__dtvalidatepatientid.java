package jsp_servlet._efm._jsp;

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
import java.util.*;
import com.ehis.util.*;

public final class __dtvalidatepatientid extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/DTValidatePatientID.jsp", 1709116823747L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n<HEAD>\n\t<!-- <LINK rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></LINK> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n\t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\'></SCRIPT>\n\t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></SCRIPT>\n\t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/common.js\'></SCRIPT>\n\t<SCRIPT language=\'javascript\' src=\'../../eFM/js/FMDocumentFolder.js\'></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<SCRIPT>\n\t\tfunction doDateCheckFrom(from,today) \n\t\t{ //args objects 1st is this object & second is the date object\n\t\t\tif(from.value != \"\")\n\t\t\t{\n\t\t\t\tvar fromarray;\n\t\t\t\tvar toarray;\n\t\t\t\tvar fromdate =from.value ;\n\t\t\t\tvar todate =today.value ;\n\t\t\t\t\n\t\t\t\tif(fromdate.length > 0 && todate.length > 0 ) \n\t\t\t\t{\n\t\t\t\t\tfromarray = fromdate.split(\"/\");\n\t\t\t\t\ttoarray = todate.split(\"/\");\n\t\t\t\t\tvar fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);\n\t\t\t\t\tvar todt = new Date(toarray[2],toarray[1],toarray[0]);\n\t\t\t\t\tif(Date.parse(todt) > Date.parse(fromdt)) \n\t\t\t\t\t{\n\t\t\t\t\t\tvar msg = getMessage(\'FROM_DATE_GREATER_TO_DATE\',\'FM\');\n\t\t\t\t\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/MstCodeError.jsp?err_num=\'+msg;\n\t\t\t\t\t\ttoday.focus();\n\t\t\t\t\t\ttoday.select();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t\telse if(Date.parse(todt) <= Date.parse(fromdt))\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/MstCodeError.jsp?\' ;\n\t\t\t\t\t\treturn true;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\treturn true;\n\t\t\t}\n\t\t\treturn true;\n\t\t}\n\t\tfunction doDateCheckto(from,today) \n\t\t{ //args objects 1st is this object & second is the date object\n\t\t\tif(today.value != \"\")\n\t\t\t{\n\t\t\t\tvar fromarray;\n\t\t\t\tvar toarray;\n\t\t\t\tvar fromdate =from.value ;\n\t\t\t\tvar todate =today.value ;\n\t\t\t\n\t\t\t\tif(fromdate.length > 0 && todate.length > 0 ) \n\t\t\t\t{\n\t\t\t\t\tfromarray = fromdate.split(\"/\");\n\t\t\t\t\ttoarray = todate.split(\"/\");\n\t\t\t\t\tvar fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);\n\t\t\t\t\tvar todt = new Date(toarray[2],toarray[1],toarray[0]);\n\t\t\t\t\tif(Date.parse(todt) > Date.parse(fromdt)) \n\t\t\t\t\t{\n\t\t\t\t\t\tvar msg = getMessage(\'TO_DATE_LESSER_FROM_DATE\',\'FM\');\n\t\t\t\t\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/MstCodeError.jsp?err_num=\'+msg;\n\t\t\t\t\t\tfrom.focus();\n\t\t\t\t\t\tfrom.select();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t\telse if(Date.parse(todt) <= Date.parse(fromdt))\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/MstCodeError.jsp?\' ;\n\t\t\t\t\t\treturn true;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\treturn true;\n\t\t\t}\n\t\t\treturn true;\n\t\t}\n\t\tfunction CheckSystemDateLesser(from,today) \n\t\t{ //args objects 1st is this object & second is the date in dd/mm/yyyy\n\t\t\tif(today != \"\" && from.value !=\"\" )\n\t\t\t{\n\t\t\t\tvar fromarray;\n\t\t\t\tvar toarray;\n\t\t\t\tvar fromdate =from.value ;\n\t\t\t\tvar todate =today ;\n\t\t\t\t\n\t\t\t\tif(fromdate.length > 0 && todate.length > 0 )\n\t\t\t\t{\n\t\t\t\t\tfromarray = fromdate.split(\"/\");\n\t\t\t\t\ttoarray = todate.split(\"/\");\n\t\t\t\t\tvar fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);\n\t\t\t\t\tvar todt = new Date(toarray[2],toarray[1],toarray[0]);\n\t\t\t\t\tif(Date.parse(todt) < Date.parse(fromdt))\n\t\t\t\t\t{//var msg =\"APP-FM0041 Date Entered should be lesser than System Date\"\n\t\t\t\t\t\tvar msg = getMessage(\"DATE_LESS_SYS_DATE\",\"FM\");\n\t\t\t\t\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/MstCodeError.jsp?err_num=\'+msg;\n\t\t\t\t\t\tfrom.focus();\n\t\t\t\t\t\tfrom.select();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t\telse if(Date.parse(todt) >= Date.parse(fromdt))\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/MstCodeError.jsp?\' ;\n\t\t\t\t\t\treturn true;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\treturn true;\n\t\t\t}\n\t\t\treturn true;\n\t\t}\n\t</SCRIPT>\n</HEAD>\n<BODY onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t<SCRIPT>\n\t\t\t\t\t\tvar msg = getMessage(\'INVALID_VALUE\',\'Common\'); \n\t\t\t\t\t\tmsg = msg.replace(\'#\',getLabel(\'Common.patientId.label\',\'Common\'));\n\t\t\t\t\t\talert(msg);\n\t\t\t\t\t\tparent.frames[1].document.forms[0].patient_id.select();\n\t\t\t\t\t</SCRIPT>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\t\t\t\t<SCRIPT>\n\t\t\t\t\t\tparent.frames[1].document.forms[0].doc_folder_type.disabled = false;\t\n\t\t\t\t\t\tparent.frames[1].document.forms[0].action=\"../../servlet/eFM.FMDocumentFolderServlet\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].method=\"post\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].target=\"messageFrame\";\n\t\t\t\t\t\tparent.frames[1].document.forms[0].submit();\n\t\t\t\t\t</SCRIPT>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\t\t<SCRIPT>\n\t\t\t\tvar from = parent.frames[1].document.forms[0].from;\n\t\t\t\tvar to = parent.frames[1].document.forms[0].to;\n\t\t\t\t\n\t\t\t\tif((doDateCheckFrom(to,from)))\n\t\t\t\t{\n\t\t\t\t\tparent.frames[1].document.forms[0].doc_folder_type.disabled = false;\t\n\t\t\t\t\tparent.frames[1].document.forms[0].action=\"../../servlet/eFM.FMDocumentFolderServlet\";\n\t\t\t\t\tparent.frames[1].document.forms[0].method=\"post\";\n\t\t\t\t\tparent.frames[1].document.forms[0].target=\"messageFrame\";\n\t\t\t\t\tparent.frames[1].document.forms[0].submit();\n\t\t\t\t}\n\t\t\t</SCRIPT>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<SCRIPT>\n\t\t\tparent.messageFrame.document.location.href=\'../../eCommon/jsp/MstCodeError.jsp?err_num=\';\n\t\t</SCRIPT>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

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

	Connection conn	 = null;
	try
	{
		conn				= ConnectionManager.getConnection(request);
		String patient_id		= request.getParameter("patient_id");  
		String facility_id		= request.getParameter("facility_id"); 
		String from				= request.getParameter("from"); 
		String to				= request.getParameter("to"); 
		String doc_folder_type	= request.getParameter("doc_folder_type"); 

		if(patient_id == null || patient_id.equals("null"))
			patient_id = "";
		if(facility_id == null || facility_id.equals("null"))
			facility_id = "";
		if(from == null || from.equals("null"))
			from = "";
		if(to == null || to.equals("null"))
			to = "";
		if(doc_folder_type == null || doc_folder_type.equals("null"))
			doc_folder_type = "";

		if(doc_folder_type.equals("P"))
		{
			if(!patient_id.equals(""))
			{
				webbeans.op.PatientData patdata = new webbeans.op.PatientData();
				patdata.setFacility_id(facility_id);
				String patient_status = patdata.CheckStatus(conn,patient_id);
				if(patient_status.equals("INVALID_PATIENT"))
				{

            _bw.write(_wl_block8Bytes, _wl_block8);

				}
				else
				{

            _bw.write(_wl_block9Bytes, _wl_block9);

				}
			}
		}
		else if(doc_folder_type.equals("D"))
		{

            _bw.write(_wl_block10Bytes, _wl_block10);

		}

            _bw.write(_wl_block11Bytes, _wl_block11);

	}
	catch(Exception e)
	{
		out.println("Exception :"+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(conn,request);
	}

            _bw.write(_wl_block12Bytes, _wl_block12);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
