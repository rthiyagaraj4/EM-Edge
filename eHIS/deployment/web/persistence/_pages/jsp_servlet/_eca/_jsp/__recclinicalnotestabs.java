package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __recclinicalnotestabs extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesTabs.jsp", 1742466237636L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<html>\n<head>\n\t<title>";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="</title>\n\t\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart1.js\'></script>\n<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart2.js\'></script>\n<script>\n\n\tfunction tab_clickAdd(id) \n\t{\t\n\t\tif (document.getElementById(\'function_id\').value  != \"SPCL_NOTE\")\n\t\t{\n\t\t\t//IN055885 Start.\n\t\t\tif(document.getElementById(\'function_id\').value  == \"NOTIFIABLEFORM\"){\n\t\t\t\tif(document.getElementById(\'callBackMode\').value !=\"Search\" && document.getElementById(\"notifiable_code\").value ==\"\"){\n\t\t\t\t\tdocument.getElementById(\'search_tab\').className=\"tabA\";\n\t\t\t\t\tdocument.getElementById(\'search_tabspan\').className=\"tabAspan\";\n\t\t\t\t\tselectTab(id);\t\t\n\t\t\t\t\tcallRecClinicalNotesMain();\n\t\t\t\t}\t\t\t\n\t\t\t//IN067717 starts\n\t\t\t}else if( document.getElementById(\'function_id\').value  == \"BIRTH_REG_NOTES\"){\n\t\t\t\tif(document.getElementById(\'callBackMode\').value !=\"Search\" && document.getElementById(\'callBackMode\').value ==\"Add\"){\n\t\t\t\t\tdocument.getElementById(\'search_tab\').className=\"tabA\";\n\t\t\t\t\tdocument.getElementById(\'search_tabspan\').className=\"tabAspan\";\n\t\t\t\t\tselectTab(id);\t\t\n\t\t\t\t\tcallRecClinicalNotesMain();\n\t\t\t\t}\t\n\t\t\t}if(document.getElementById(\'function_id\').value  == \"DECEASEDFORM\"){\n\t\t\t\tif(document.getElementById(\'callBackMode\').value !=\"Search\"){\n\t\t\t\t\tdocument.getElementById(\'search_tab\').className=\"tabA\";\n\t\t\t\t\tdocument.getElementById(\'search_tabspan\').className=\"tabAspan\";\n\t\t\t\t\tselectTab(id);\t\t\n\t\t\t\t\tcallRecClinicalNotesMain();\n\t\t\t\t}\t\t\t\n\t\t\t//IN067717 starts\n\t\t\t}\n\t\t\t//IN067717 ends\n\t\t\telse\t{\n\t\t\t//IN055885 end.\n\t\t\t\tdocument.getElementById(\'search_tab\').className=\"tabA\";\n\t\t\t\tdocument.getElementById(\'search_tabspan\').className=\"tabAspan\";\n\t\t\t\tselectTab(id);\t\t\n\t\t\t\tcallRecClinicalNotesMain();\n\t\t\t} //IN055885\n\t\t}\n\t}\n\n\tfunction tab_clickSearch(id) \n\t{\n\t\t//if(document.getElementById(\'function_id\').value  == \"SPCL_NOTE\" && document.getElementById(\'callBackMode\').value  == \"\"){}//IN032060\t//IN053733\t\n\t\t//if((document.getElementById(\'function_id\').value  == \"SPCL_NOTE\" ||document.getElementById(\"notifiable_code\").value !=\"\") && document.getElementById(\'callBackMode\').value  == \"\"){} //IN053733\n\t\tif((document.getElementById(\'function_id\').value  == \"SPCL_NOTE\" ||document.getElementById(\'function_id\').value  == \"BIRTH_REG_NOTES\"||document.getElementById(\"notifiable_code\").value !=\"\") && document.getElementById(\'callBackMode\').value  == \"\"){} //IN067717\n\t\telse{\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t//IN032060\n\t\tdocument.getElementById(\'add_tab\').className=\"tabA\";\n\t\tdocument.getElementById(\'add_tabspan\').className=\"tabAspan\"\t;\n\t\tselectTab(id);\t\n\t\tcallRecClinicalNotesSearch();\n\t\t}\t//IN032060\n\t}\n\n\tfunction dfltTab()\n\t{\n\t\tif (\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'  == \"Add\" || \'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'  == \"\")\n\t\t{\n\t\t\tprevTabObj = \"search_tab\";\n\t\t}else if (\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'  == \"Search\")\n\t\t{\n\t\t\tprevTabObj = \"add_tab\";\n\t\t}\t\n\t\t//document.getElementById(\'search_tab\').className = \"tabA\";\n\t\t//document.getElementById(\'search_tabspan\').className = \"tabAspan\";\n\t}\n\n</script>\n</head>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" class=\'CONTENT\' onLoad=\"dfltTab();\">\n\t<center>\n\t<form name=\'RecClinicalNotesTabForm\' id=\'RecClinicalNotesTabForm\'>\n\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t\t<tr>\n\t\t\t<td width= \"100%\" class=\"white\">\n\t\t\t<ul id=\"tablist\" class=\"tablist\" style=\"padding-left:0px\">\n\t\t\t\t<li class=\"tablistitem\" title=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" >\t\t\t\t\n\t\t\t\t<a onClick=\"tab_clickAdd(\'add_tab\')\" class=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" id=\"add_tab\" >\n\t\t\t\t\t<span class=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" id=\"add_tabspan\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</span>\n\t\t\t\t</a>\t\t\t\t\n\t\t\t</li>\n\t\t\t<li class=\"tablistitem\" title=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =">\n\t\t\t\t<a onClick=\"tab_clickSearch(\'search_tab\')\" class=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" id=\"search_tab\" >\n\t\t\t\t\t<span class=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" id=\"search_tabspan\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</span>\n\t\t\t\t</a>\n\t\t\t</li>\n\t\t\t</ul>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n\n\t<input type=\'hidden\' name=\'query_string\' id=\'query_string\'\t\tvalue=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\'\t\t\tvalue=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\'\t\tvalue=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\'\t\tvalue=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t<input type=\'hidden\' name=\'operation_mode\' id=\'operation_mode\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t<input type=\'hidden\' name=\'callBackMode\' id=\'callBackMode\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>  <!--  IN032060 -->\n\t<input type=\'hidden\' name=\'notifiable_code\' id=\'notifiable_code\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'><!-- IN053733  -->\n\t<input type=\'hidden\' name=\'p_called_from_widget\' id=\'p_called_from_widget\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'><!--CIS-CA-1490-->\n\t<input type=\'hidden\' name=\'orderStatusCodeHdr\' id=\'orderStatusCodeHdr\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'><!--68801-->  \n\t</form>\n\t</center>\n\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script language=\'javascript\'>\n\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\tcallRecClinicalNotesSearch();\n\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\tcallRecClinicalNotesMain();\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\tif(\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' == \'N\')\n\t{\n\t\tdocument.getElementById(\'add_tab\').style.display = \'none\';\n\t\tdocument.getElementById(\'search_tab\').click();\n\t}\n\telse\n\t\tdocument.getElementById(\'add_tab\').style.display = \"\";\n\n\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

public String checkForNull(String inputString)
{
	return (inputString==null)	?	""	:	inputString;
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
 
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
?           100				?	         	?				?				created
04/12/2012	IN032060		Ramesh G		?				?				MO-CRF-20059[All the notes which are documented through 																		   OT slate when modified 
																			by the user who has got privilege to Author and modify these notes and the note	type set up is amend original section the system does not store the original note 
																			content which was modified. ]
29/01/2014	IN046648		Karthi L	29/01/2014		Dinesh T			Speciality  NULL In Medical  Certifictae
02/06/2014	IN037701		Nijitha											SKR-CRF-0036
06/05/2015	IN053733		Ramesh G										When a notifiable recorded against a notifiable diagnosis is marked in error, 
																			the notification to be de-linked from the parent diagnosis
15/06/2015	IN055885		Ramesh G										Record Clinical Notes->After modifying the notes ->Click on "Add" button-System is not responding. 
01/11/2016	IN061988		Vijayakumar K									AAKH-CRF-0088.3 [IN:061988]
08/05/2017	IN064034		Dinesh T										ML-MMOH-CRF-0557_UT3
20/07/2018	IN067717		Ramesh G	20/07/2018		Ramesh G		ML-MMOH-CRF-0898.1
27/05/2020		IN072879		SIVABAGYAM M		27/05/2020		RAMESH G		MMS-DM-SCF-0688
28/02/2025	  68801	            Twinkle Shah		28/02/2025			ML-MMOH-CRF-0579 
------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String callback_mode =	(request.getParameter("callback_mode")==null)? "" : request.getParameter("callback_mode");	
		String addTab = "";
		String addTabSpan = "";
		String searchTab = "";
		String searchTabSpan = "";
		if(callback_mode.equals("Add") || callback_mode.equals(""))
		{
			addTab="tabClicked";
			addTabSpan = "tabSpanclicked";
			searchTab = "tabA";
			searchTabSpan = "tabAspan";
		}else if(callback_mode.equals("Search")){
			searchTab="tabClicked";
			searchTabSpan="tabSpanclicked";
			addTab= "tabA";
			addTabSpan = "tabAspan";
		}		
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(callback_mode));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(callback_mode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(callback_mode));
            _bw.write(_wl_block10Bytes, _wl_block10);


	String function_id				= "";
	String style_visibility			= " style='display' ";
	String addBt_style_visibility	= " style='display' ";
	String operation_mode		= "";
	String patient_id				= "";
	String modifyYN					= "";
	String encounter_id			= "";
	String episode_type			= "";
	String appl_task_id			= "";
	String patient_class			= "";
	String Sex			= "";
	String Dob			= "";
	String contr_mod_accession_num			= "";
	String module_id			= "";
	String note_type			= "";
	note_type					=	checkForNull(request.getParameter("note_type"));
	String p_called_from="";//CIS-CA-1490	
	String l_speciality_code  = ""; // IN046648
	StringBuffer query_string = new StringBuffer();
	String notifiable_code = ""; //IN053733
	String accession_num 	=""; //IN053733
	String called_from		=""; //IN053733
	String l_dispResLinkHYMLYN = "";//IN064034
	String l_noteSplCharValidate = "";//IN064034
	String speciality_name="",location_code="";//IN072879
	String orderStatusCodeHdr=""; //68801
	try{
	patient_id					=	checkForNull(request.getParameter("patient_id"));
	modifyYN					=	request.getParameter("modifyYN") == null ? "Y" : request.getParameter("modifyYN");
	encounter_id				=	checkForNull(request.getParameter("encounter_id"));
	episode_type				=	checkForNull(request.getParameter("episode_type"));
	function_id					=	checkForNull(request.getParameter("function_id"));
	appl_task_id				=	checkForNull(request.getParameter("appl_task_id"));
	patient_class				=	checkForNull(request.getParameter("patient_class"));
	operation_mode				=	checkForNull(request.getParameter("operation_mode"));
	Sex				=	checkForNull(request.getParameter("Sex"));
	Dob				=	checkForNull(request.getParameter("Dob"));
	contr_mod_accession_num				=	checkForNull(request.getParameter("contr_mod_accession_num"));
	module_id				=	checkForNull(request.getParameter("module_id"));

	 p_called_from		=	request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget");//CIS-CA-1490
	l_speciality_code = request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code"); //IN046648
	//IN037701 Starts
	String p_event_class_widget = request.getParameter("p_event_class_widget") == null ? "" : request.getParameter("p_event_class_widget");
	//IN037701 Ends
	notifiable_code				=	checkForNull(request.getParameter("notifiable_code")); //IN053733
	accession_num				=	checkForNull(request.getParameter("accession_num")); //IN053733
	called_from		= request.getParameter("called_from")==null?"":request.getParameter("called_from");  //IN053733 
	l_dispResLinkHYMLYN		= request.getParameter("dispResLinkHYMLYN")==null?"":request.getParameter("dispResLinkHYMLYN");//IN064034
	l_noteSplCharValidate		= request.getParameter("noteSplCharValidate")==null?"":request.getParameter("noteSplCharValidate");//IN064034
	//	query_string.append(request.getQueryString());
	location_code=request.getParameter("location_code")==null?"":request.getParameter("location_code"); //IN072879
	speciality_name=request.getParameter("speciality_name")==null?"":request.getParameter("speciality_name");//IN072879
	orderStatusCodeHdr=request.getParameter("orderStatusCodeHdr")==null?"N":request.getParameter("orderStatusCodeHdr");//IN072879
	query_string.append("patient_id=");		query_string.append(patient_id);
	query_string.append("&encounter_id=");	query_string.append(encounter_id);
	query_string.append("&episode_type=");	query_string.append(episode_type);
	query_string.append("&function_id=");	query_string.append(function_id);
	query_string.append("&appl_task_id="); query_string.append(appl_task_id);
	query_string.append("&patient_class="); query_string.append(patient_class);
	query_string.append("&Sex="); query_string.append(Sex);
	query_string.append("&Dob="); query_string.append(Dob);
	query_string.append("&contr_mod_accession_num="); query_string.append(contr_mod_accession_num);
	query_string.append("&modifyYN="); query_string.append(modifyYN);
	query_string.append("&module_id="); query_string.append(module_id);
	query_string.append("&notifiable_code=");	query_string.append(notifiable_code);//IN053733
	query_string.append("&accession_num=");	query_string.append(accession_num);//IN053733
	query_string.append("&called_from=");	query_string.append(called_from);//IN053733
	query_string.append("&note_type="); query_string.append(note_type);
	query_string.append("&p_called_from_widget="); query_string.append(p_called_from);//CIS-CA-1490
	query_string.append("&speciality_code="); query_string.append(l_speciality_code);//IN046648
	query_string.append("&p_event_class_widget="); query_string.append(p_event_class_widget);//IN037701
	query_string.append("&dispResLinkHYMLYN="); query_string.append(l_dispResLinkHYMLYN);//IN064034
	query_string.append("&noteSplCharValidate="); query_string.append(l_noteSplCharValidate);//IN064034
	query_string.append("&location_code="); query_string.append(location_code);//IN072879
	query_string.append("&speciality_name="); query_string.append(speciality_name);//IN072879
	query_string.append("&orderStatusCodeHdr="); query_string.append(orderStatusCodeHdr);//68801
	
	//if(function_id.equals("SPCL_NOTE")||function_id.equals("TASK_LIST")||appl_task_id.equals("PROGRESS_NOTES"))  //IN032060
	if(function_id.equals("TASK_LIST")||appl_task_id.equals("PROGRESS_NOTES"))									   //IN032060
	{
		style_visibility = " style='display:none' ";
	}else if( function_id.equals("SIGN_NOTES") || function_id.equals("REVIEW_NOTES") )
	{
		style_visibility = " style='display:none' ";
	}
	if(function_id.equals("SPCL_NOTE") && appl_task_id.equals("PROGRESS_NOTES"))
	{
		addBt_style_visibility  = " style='display:none' ";
	}
	//IN061988 starts
	if(function_id.equals("PH_NOTES") && appl_task_id.equals("PH_NOTES") && !"".equals(accession_num))
	{
		addBt_style_visibility  = " style='display:none' ";
	}
	//IN061988 ends
	}catch(Exception e)
	{
		out.println( "<script>alert('Error    :   " + e.getMessage() + "')</script>"  ) ;
		e.printStackTrace();
	}

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(addBt_style_visibility));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(addTab));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(addTabSpan));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(style_visibility));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(searchTab));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(searchTabSpan));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(operation_mode));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(callback_mode));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(notifiable_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(p_called_from));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(orderStatusCodeHdr));
            _bw.write(_wl_block29Bytes, _wl_block29);

		
				
		if(callback_mode.equals("Search"))
		{
	
            _bw.write(_wl_block30Bytes, _wl_block30);

		}
		else if(callback_mode.equals("Add"))
		{
	
            _bw.write(_wl_block31Bytes, _wl_block31);

		}
	
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(modifyYN));
            _bw.write(_wl_block33Bytes, _wl_block33);
            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.RecordingClinicalNotesTabs.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Add.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Add.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.search.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.search.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }
}
