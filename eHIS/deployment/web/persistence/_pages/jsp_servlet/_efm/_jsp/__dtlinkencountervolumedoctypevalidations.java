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
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Iterator;
import java.util.*;
import com.ehis.util.*;

public final class __dtlinkencountervolumedoctypevalidations extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/DTLinkEncounterVolumeDocTypeValidations.jsp", 1709116822185L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<script>\n\t\t\t\tparent.criteria_frame.document.forms[0].patient_period_specific.value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\';\n\t\t\t\tparent.criteria_frame.document.forms[0].patient_id.value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\n\n\t\t\t\tif (\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"==\"P\")\n\t\t\t\t{\n\t\t\t\t\tparent.criteria_frame.document.getElementById(\"patient\").innerHTML=getLabel(\"Common.patientId.label\",\"common\");\n\t\t\t\t\tparent.criteria_frame.document.getElementById(\"patient_detail\").innerHTML=\"<b>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</b>\";\n\t\t\t\t\tparent.criteria_frame.document.getElementById(\"period\").innerHTML=\"&nbsp;\";\n\t\t\t\t\tparent.criteria_frame.document.getElementById(\"period_detail\").innerHTML=\"&nbsp;\";\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.criteria_frame.document.getElementById(\"patient\").innerHTML=getLabel(\"Common.periodfrom.label\",\"common\");\n\t\t\t\t\tparent.criteria_frame.document.getElementById(\"patient_detail\").innerHTML=\"<input type=\'Text\' name=\'from_period\' id=\'from_period\' value=\'\"+\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'+\"\' maxlength=\'10\' size=\'8\' id=\'from_period\' onBlur=\\\"validDateObj(this,\'DMY\',localeName);DateCompare(this, to_period, \'messageFrame\',\'Period From\');\\\" readonly>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t\t\tparent.criteria_frame.document.getElementById(\"period\").innerHTML=getLabel(\"Common.to.label\",\"common\");\n\t\t\t\t\tparent.criteria_frame.document.getElementById(\"period_detail\").innerHTML=\"<input type=\'Text\' name=\'to_period\' id=\'to_period\' value=\'\"+\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'+\"\' maxlength=\'10\' size=\'8\' id=\'to_period\' onBlur=\\\"validDateObj(this,\'DMY\',localeName);DateCompare(from_period, this, \'messageFrame\',\'Period From\');\\\" readonly>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t\t}\n\t\t\t\tparent.tab_frame.document.location.href\t\t\t=\t\"../../eCommon/html/blank.html\";\n\t\t\t\tparent.result_frame.document.location.href\t\t=\t\"../../eCommon/html/blank.html\";\n\t\t\t\tparent.messageFrame.document.location.href\t\t=\t\"../../eCommon/jsp/error.jsp\";\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<script>\n\t\t\tvar code\t=\t\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\';\n\t\t\tvar desc\t=\t\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\';\n\t\t\tparent.result_frame.add_doc_frame.document.forms[0].doc_type_code.value = code;\n\t\t\tparent.result_frame.add_doc_frame.document.forms[0].doc_type_desc.value = desc;\n\t\t\tparent.result_frame.add_doc_frame.document.forms[0].add_button.disabled = false;\n\t\t\tparent.result_frame.add_doc_frame.document.getElementById(\"doc_type\").innerText\t\t= desc;\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t<script>\n\t\t\t//alert(\"Invalid Document Number\");\n\t\t\talert(getMessage(\'INVALID_DOC_NO\',\'FM\'));\n\t\t\tparent.result_frame.add_doc_frame.document.forms[0].document_no.select();\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\t//alert(\"Record Already Selected\");\n\t\t\t\t\t\talert(getMessage(\'RECORD_ALREADY_SEL\',\'FM\'));\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t<script>\n\t\t\t\tparent.result_frame.add_doc_frame.document.forms[0].document_no.value\t= \"\";\t\n\t\t\t\tparent.result_frame.add_doc_frame.document.forms[0].add_button.disabled\t= true;\t\n\t\t\t\tparent.result_frame.add_doc_frame.document.getElementById(\"doc_type\").innerHTML\t\t= \"&nbsp;\";\t\n\t\t\t\tparent.result_frame.add_doc_frame.document.forms[0].doc_details.value\t= \"\";\n\t\t\t\tparent.result_frame.add_doc_frame.document.forms[0].document_date.value\t= \"\";\n\t\t\t\t//parent.result_frame.select_doc_frame.location.href=\"../../eFM/jsp/DTLinkEncounterDocumentsList.jsp?maintain_doc_or_file=\"+\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" &status=\"+\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n\t\t  var maintain_doc_or_file=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\t\n\t\t  var status=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\";\t\n\t\t var  count=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\t\n\t\tvar first_time=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\";\t \nparent.result_frame.select_doc_frame.location.href=\'../../eFM/jsp/DTLinkEncounterDocumentsList.jsp?&maintain_doc_or_file=\' +maintain_doc_or_file + \'&status=\'+status+ \'&count=\'+count+ \'&first_time=\'+first_time;\t\n\t\t\t\t\t\t\t\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t <script>\n\t\t\t\t//alert(\"Record Already Exists in Database. \");\n\t\t\t\talert(getMessage(\'RECORD_EXISTS\',\'SM\'));\n\t\t\t</script> \n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t<script>\n\t\t\tparent.result_frame.add_doc_frame.document.forms[0].document_no.value\t= \"\";\t\n\t\t\tparent.result_frame.add_doc_frame.document.forms[0].add_button.disabled\t= true;\t\n\t\t\tparent.result_frame.add_doc_frame.document.getElementById(\"doc_type\").innerHTML\t\t= \"&nbsp;\";\t\n\t //\tparent.result_frame.select_doc_frame.location.href=\"../../eFM/jsp/DTLinkEncounterDocumentsList.jsp?maintain_doc_or_file=\"+\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\";\n\t\t var maintain_doc_or_file=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\";\t\n\t\t  var  count=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\";\t parent.result_frame.select_doc_frame.location.href=\'../../eFM/jsp/DTLinkEncounterDocumentsList.jsp?&maintain_doc_or_file=\' +maintain_doc_or_file + \'&status=\'+status+ \'&count=\'+count;\t\n\t\t\n\t\t</script>\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t<script>\n\tparent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\';\n\t</script>\n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n</html>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );


public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
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

try
{
	String sqlString			=	"";
	String facilityID 			=	checkForNull((String) session.getValue("facility_id"));
	String document_no			=	checkForNull(request.getParameter("document_no"));
	String operation			=	checkForNull(request.getParameter("operation"));
	String patient_id			=	checkForNull(request.getParameter("patient_id"));
	String doc_folder_id		=	checkForNull(request.getParameter("doc_folder_id"));
	String maintain_doc_or_file	=	checkForNull(request.getParameter("maintain_doc_or_file"));
	String   status=checkForNull(request.getParameter("status"));
	String    count =checkForNull(request.getParameter("count"));
	String first_time=checkForNull(request.getParameter("first_time"));
	connection					=	ConnectionManager.getConnection(request);	
	StringTokenizer	srtToken	=	null;	
	if (operation.equals("DocumentFolder"))
	{
		String patient_period_specific	=	"";
		String from_period				=	"";
		String to_period				=	"";

		sqlString	="SELECT patient_period_specific, patient_id, to_char(from_period, 'dd/mm/rrrr') from_period, to_char(to_period, 'dd/mm/rrrr') to_period FROM fm_doc_folder WHERE facility_id = ? AND doc_folder_id = ? AND eff_status = 'E' ";
		
		preStatement	=	connection.prepareStatement(sqlString);
		preStatement.setString(1, facilityID);
		preStatement.setString(2, doc_folder_id);
		resultSet		=	preStatement.executeQuery();
		
		if ((resultSet!=null) && (resultSet.next()))
		{
			patient_period_specific	=	checkForNull(resultSet.getString("patient_period_specific"));
			patient_id				=	checkForNull(resultSet.getString("patient_id"));
			from_period				=	checkForNull(resultSet.getString("from_period"));
			to_period				=	checkForNull(resultSet.getString("to_period"));
			
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patient_period_specific));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_period_specific));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(from_period));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(to_period));
            _bw.write(_wl_block14Bytes, _wl_block14);

		}
	if(resultSet!=null)	resultSet.close();
	if(preStatement!=null) preStatement.close();
	}
	else if ((!document_no.equals("")) && (operation.equals("GetDocumentType")))
	{
		sqlString		=	" SELECT doc_type_name, doc_type_code FROM fm_doc_type WHERE doc_no = ? ";
		preStatement	=	connection.prepareStatement(sqlString);
		preStatement.setString(1, document_no);
		resultSet		=	preStatement.executeQuery();
		if ((resultSet!=null) && (resultSet.next()))
		{
		
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(checkForNull(resultSet.getString("doc_type_code"))));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(checkForNull(resultSet.getString("doc_type_name"))));
            _bw.write(_wl_block17Bytes, _wl_block17);

		if(resultSet!=null)	resultSet.close();
		if(preStatement!=null) preStatement.close();
		}
		else 
		{
		
            _bw.write(_wl_block18Bytes, _wl_block18);

		}
	}
	else if ((!document_no.equals("")) && (operation.equals("AddRecords")))
	{
		String doc_type_code		=	checkForNull(request.getParameter("doc_type_code"));
		String doc_type_desc		=	checkForNull(request.getParameter("doc_type_desc"));
		String volume_no			=	checkForNull(request.getParameter("volume_no"));
		String file_no			=	checkForNull(request.getParameter("file_no"));
		String fs_location			=	checkForNull(request.getParameter("fs_location"));
		String encounter_id			=	checkForNull(request.getParameter("encounter_id"));
		String doc_details	=	checkForNull(request.getParameter("doc_details"));
		String doc_date	=	checkForNull(request.getParameter("doc_date"));
		
		boolean flag				=	true;
		String fs_location_code		=	"";
		String fs_location_desc		=	"";
		int record_count			=	0;

		sqlString	=	" SELECT count(*) record_count FROM fm_encounter_doc_type_link WHERE facility_id = ? AND encounter_id = ? AND doc_type_code = ? AND file_no = ? ";
		
		preStatement	=	connection.prepareStatement(sqlString);
		preStatement.setString(1, facilityID);
		preStatement.setString(2, encounter_id);
		preStatement.setString(3, doc_type_code);
		preStatement.setString(4, file_no);
		resultSet		=	preStatement.executeQuery();
		
		if ((resultSet!=null) && (resultSet.next()))
		{
			record_count	=	resultSet.getInt("record_count");
		}

		if (record_count == 0)
		{
			srtToken	=	new StringTokenizer(fs_location, "$$");
			if (srtToken.hasMoreTokens())
				fs_location_code	=	checkForNull(srtToken.nextToken());
			if (srtToken.hasMoreTokens())
				fs_location_desc	=	checkForNull(srtToken.nextToken());

			ArrayList arrList			=	new ArrayList();
			if (!maintain_doc_or_file.equals("D"))
				arrList.add(volume_no);
			else
			{
				arrList.add(fs_location_code);
				arrList.add(fs_location_desc);
			}
			arrList.add(document_no);
			arrList.add(doc_type_code);
			arrList.add(doc_type_desc);
			arrList.add(doc_details);
			arrList.add(doc_date);
		
			ArrayList documentArrList	=	((ArrayList)session.getAttribute("documentArrList"));	
			if (documentArrList != null)
			{
				String volume_no_temp			=	"";
				String fs_location_temp			=	"";
				String fs_location_desc_temp	=	"";
				String document_no_temp			=	"";
				String doc_type_code_temp		=	"";
				String doc_type_desc_temp		=	"";
				String doc_details_temp			=	"";
				String doc_date_temp			=	"";
				Iterator	outIter =	documentArrList.iterator();
				Iterator	inItr	=	null;
				while (outIter.hasNext())
				{
					inItr	= ((ArrayList)outIter.next()).iterator();
					if (!maintain_doc_or_file.equals("D"))
						volume_no_temp	=	(String)inItr.next();
					else
					{
						fs_location_temp		=   (String)inItr.next();
						fs_location_desc_temp	=   (String)inItr.next();
					}
					document_no_temp			=	(String)inItr.next();
					doc_type_code_temp			=	(String)inItr.next();
					doc_type_desc_temp			=	(String)inItr.next();
					doc_details_temp			=	(String)inItr.next();
					doc_date_temp			=	(String)inItr.next();
					if (document_no.equals(document_no_temp) && doc_type_code.equals(doc_type_code_temp))
					{
						flag	=	false;
					
            _bw.write(_wl_block19Bytes, _wl_block19);

					}
				}
				if (flag)
					documentArrList.add(arrList);
			}
			else
			{
				documentArrList	=	new ArrayList();
				documentArrList.add(arrList);
			}
			if (flag)
			{
				session.setAttribute("documentArrList", documentArrList);
				
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(maintain_doc_or_file));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(status));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(maintain_doc_or_file));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(status));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(count));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(first_time));
            _bw.write(_wl_block26Bytes, _wl_block26);

			}
		}
		else
		{
			
            _bw.write(_wl_block27Bytes, _wl_block27);

		}
	}
	else if (operation.equals("RemoveElement"))
	{
		String doc_type_code		=	checkForNull(request.getParameter("doc_type_code"));
		String doc_type_desc		=	checkForNull(request.getParameter("doc_type_desc"));
		String volume_no			=	checkForNull(request.getParameter("volume_no"));
		String fs_location			=	checkForNull(request.getParameter("fs_location"));
		String fs_location_code		=	"";
		String fs_location_desc		=	"";

		srtToken	=	new StringTokenizer(fs_location, "$$");
		if (srtToken.hasMoreTokens())
			fs_location_code	=	checkForNull(srtToken.nextToken());
		if (srtToken.hasMoreTokens())
			fs_location_desc	=	checkForNull(srtToken.nextToken());
		
		ArrayList arrList			=	new ArrayList();
		if (!maintain_doc_or_file.equals("D"))
			arrList.add(volume_no);
		else
		{
			arrList.add(fs_location_code);
			arrList.add(fs_location_desc);
		}

		arrList.add(document_no);
		arrList.add(doc_type_code);
		arrList.add(doc_type_desc);
		ArrayList documentArrList	=	((ArrayList)session.getAttribute("documentArrList"));	
		documentArrList.remove(arrList);
		session.setAttribute("documentArrList", documentArrList);
	
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(maintain_doc_or_file));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(maintain_doc_or_file));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(status));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(count));
            _bw.write(_wl_block31Bytes, _wl_block31);

	}
	
            _bw.write(_wl_block32Bytes, _wl_block32);

if(resultSet!=null)	resultSet.close();
if(preStatement!=null) preStatement.close();
}
catch(Exception e)
{
	out.println("Exception : " + e.toString());
}
finally
{
	ConnectionManager.returnConnection(connection,request);
}

            _bw.write(_wl_block33Bytes, _wl_block33);
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
