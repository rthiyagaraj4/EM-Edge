package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.math.*;
import eCA.*;
import webbeans.eCommon.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.zip.*;
import java.io.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __encountersprint extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/EncountersPrint.jsp", 1742382245672L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 =" \n<html>\n\t<head>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="<!-- Added Date and SimpleDateFormat for IN042733 --><!--IN063813 Added  math.*-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<!-- IN032246 - Start -->\n<STYLE>\n\t\tPRE.RESULTTEXTAREAEVEN\n\t\t{\n\t\t\tfont-size: 10pt ;\n\t\t\tFont-Family : Courier New;\n\t\t\tBACKGROUND-COLOR: #F0F0F2;\n\t\t\tBORDER-STYLE: none;\n\t\t\tfontWeight : bold;\n\t\t\ttext-align: left;\n\t\t\twhite-space: normal;\n\t\t\tWORD-WRAP: break-word;\n\t\t}\n\t\t<!-- IN056313 Start. -->\n\t\tDIV\n\t\t{\n\t\t\twhite-space: normal;\n\t\t\tword-wrap: break-word;\n\t\t\twidth\t: 1000px;\n\t\t\n\t\t}\n\t\tADDRESS\n\t\t{\t\t\t\n\t\t\twhite-space: normal;\n\t\t\tword-wrap: break-word;\n\t\t\t/*width\t: 1000px;*/ <!-- IN059735 -->\n\t\t}\n\t\t<!-- IN056313 End. -->\n</STYLE>\n<!-- IN032246 - End -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCA/js/Encounters.js\' language=\'javascript\'></script>\n\t\t<title> ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</title>\n\n\t</head>\n<!--IN066304 starts-->\t\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<body scroll=\"yes\">\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onload=\"printtext();\">\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<!--IN066304 ends-->\t\n\t\t<form name=\'printDtlsForm\' id=\'printDtlsForm\'>\t\t\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<script Language=\"vbscript\">\n\tDim WSHShell\n\tDim myHeader\n\tDim myFooter\n\tDim myMarginleft \n\tDim myMarginright \n\tSet WSHShell = CreateObject(\"WScript.Shell\")\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\tWSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header\", \"&b&d\" \n\tWSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer\", \"&b Page &p of &P\"\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\n\tWSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header\", \"\" \n\tWSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer\", \"\"\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\tWSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_left\", \"0.5\"\n\tWSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_right\", \"0.3\"\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\n<script>\nasync function printtext()\n{\n\tvar called_from = \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\tif (called_from == \"OR\")\n\t{\t\t\n\t\tif (document.all) {\n\t\tvar i = 0;\t\t\n\t\twhile( i < document.applets.length ) \n\t\t{\n\t\t\tvar j = 0 ;\n\t\t\twhile ( !document.applets[i].isActive() && j++ <=75000 ) \n\t\t\t\twindow.status = i;\n\t\t\ti++;\n\t\t}\t\t\n\t\twindow.print();\t\n\t}\n\t}else {\n\t\tawait printtextandclose();\n\t}\n\n}\nfunction printtextandclose()\n{\t\t\n\tif (document.all) {\n\t\tvar i = 0;\t\t\n\t\t\n\t\twhile( i < document.applets.length ) \n\t\t{\t\t\t\n\t\t\tvar j = 0 ;\n\t\t\twhile ( !document.applets[i].isActive() && j++ <=75000 ) \n\t\t\t\twindow.status = i;\n\t\t\ti++;\n\t\t}\n\t\twindow.print();\n\t\twindow.close();\t\n\t}\t\n}\n</SCRIPT>\n<style>\n\tADDRESS\t{ FONT-FAMILY: Arial ;FONT-SIZE: 10pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }\n\tPRE\n\t{\n\t\tfont-size: 8pt ;\n\t\tFont-Family : verdana;\n\t\tBACKGROUND-COLOR: #E2E3F0;\n\t\tBORDER-STYLE: none;\n\t\tfont-Weight : bold;\n\t\ttext-align: left;\n\t\tWORD-WRAP: break-word\n\t}\n\n\tTD.spanId1\n\t{\n\t\tBACKGROUND-COLOR: #637BBD;\n\t\tfont-size: 14pt ;\n\t\tFont-Family : Verdana;\n\t\tBORDER-STYLE: solid;\n\t\tfont-Weight: bold;\n\t\ttext-align: center;\n\t\twidth: 780;\n\t\tpadding-top: 3;\n\t\tpadding-bottom: 3;\n\t\tWORD-WRAP: break-word\n\t}\n\t\n\tTD.spanId2\n\t{\n\t\tBACKGROUND-COLOR: #B0C4DE;\n\t\tfont-size: 10pt ;\n\t\tFont-Family : Verdana;\n\t\tBORDER-STYLE: solid;\n\t\tfont-Weight: bold;\n\t\ttext-align: left;\n\t\twidth: 780;\n\t\tpadding-top: 3;\n\t\tpadding-bottom: 3;\n\t\tWORD-WRAP: break-word\n\t}\n</style>\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           	created
15/12/2011    IN029312      Menaka V 	    Incident No: IN029312 - <Report is printed either through
											order tracking or clinical event history it prints without proper header and footer. This happens to all the reports defined as procedure note groups. >
27/01/2012	  INO30714		Menaka V	 	THAI screen>View Clinical Event History>View>In the Recorded Clinical
											Note the name is not displayed in THAI 
02/02/2012	  IN030859		Menaka V		CA>HTML code is displayed if we view the recorded Chief complaints in
											Clinical Events History and Chart Summary.	
08/02/2012	  IN030996		Menaka V		CA>Patient Chart>Clinical event history>When the already recorded details
											are accessed we get Java Lang null pointer exception Script Error. 
05/04/2012	  IN031989		Menaka V		When a patient is selected by using patient without encounter search function and when clinical
											event history is accessed the note header is incomplete for all the existing notes for that patient.
20/06/2012	  IN033489		Menaka V		Report header blank in clinical event history.									
04/10/2012	  IN032555		Dinesh T		Disclaimer text is not displayed
07/01/2012	  IN032246		Ramesh G 		Result view from Existing Orders, doesn't show the similar format as it?s shows on the Print Preview 
											and LIS (View/Print Draft Copy).
06/05/2013	  IN039562		Chowminya G		Age format Changed to Y-M-D										
15/05/2013    IN038439		NijithaS		Bru-HIMS-CRF-351									
21/05/2013    IN040090      Chowminya G	    Linked Issue: New format age components in local language	
11/06/2013    IN039361      Ramesh G        RD result aligment 						
30/07/2013	IN042046		Vijayakumark	RF-KDAH-CRF-0126/02 - CA>Patient without Encounter>View Clinical Event History>Expanded view>Discharge Advice and Expected Discharge date/time are not displayed in clinical notes report header
01/10/2013	  IN043890		Ramesh G		Consent form alignment incorrect and contains some special characters.				
09/10/2013	  IN043087		Ramesh G		The alingment for consent form when it is been printed from the Clinical Event History is not correct.				
17/10/2013    IN042733    NijithaS		MO-GN-5430
23/10/2013		IN044358	Ramesh G		 Header field of matrix component should be display border for separate each column
16/12/2013		IN045646	Chowminya		Speciality name in report header has to be long name
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
02/04/2014	IN048271		Ramesh G		02/04/2014		Akbar			While doing copy paste from word file to clinical notes and after taking print out content are not proper format
04/04/2014	IN047528		Karthi L		04/04/2014		Akbar 			 "#" symbols  are printing  instead of number  
03/09/2014  IN050584		NijithaS										MO-GN-5454-CA-SL3  
20/03/2015	IN054648		Ramesh G		20/03/2015		Akbar S			RESULTED REPORT RANGE COMMENTS ARE DISPLAYING IN OR.NOTE: REPORT RANGE COMMENT SETUP IS <REPORT RANGE COMMENT>
21/07/2015  IN056353		Ramesh G		21/07/2015      Akbar S			GHL-SCF-942 : Radilogy report blank page printout
29/09/2015  IN056313		Ramesh G		29/09/2015      Akbar S			Issue With Printing Of Consent Forms From Clinical Event
29/09/2015	IN056146		Ramesh G		29/09/2015		Akbar S			Notes Spacing Issue In Clinical Event History
05/10/2015	IN056330		Ramesh G		05/10/2015		Akbar S			 Clinical Event History - Some word truncated at the end on the right side.
05/02/2016	IN004500		Raja S										GHL-SCF-1000
22/03/2016	IN059735		Ramesh G										AAKH-SCF-0262
22/09/2017	IN063813		Raja S			10/10/2017		Ramesh G		AAKH-CRF-0095
07/11/2017	IN064132		Raja S			07/11/2017		Ramesh G		ML-MMOH-CRF-0831
28/11/2017	IN065886		Raja S			28/11/2017		Ramesh G		CA-ML-MMOH-CRF-0824/02-Clinical Event History
22/08/2018	IN066793		Sharanraj		22/08/2018		Ramesh G		ARYU-SCF-0064
05/10/2018	IN068396		Raja S			05/10/2018		Ramesh G		Ml-MMOH-CRF-1237
10/10/2018	IN068669		sivabagyam	 10/10/2018	        Ramesh G       ARYU-CRF-0026
04/01/2019      IN067016                Ramya Maddena	        04/01/2019              Ramesh G    	        AMRI-CRF-0370	
04/03/2019       IN066807                Ramya Maddena            4/03/2019              Ramesh G		AMRI-CRF-0340
03/01/2019  IN069290        sivabagyam      03/01/2019      Ramesh G    	 ML-MMOH-CRF-1317	
11/04/2019	IN066304    	Kamalakannan G		11/04/2019		Ramesh Goli		ML-MMOH-CRF-1064
04/05/2019	IN069484		Ramesh G										AMRI-CRF-0398
18/07/2019  IN066005        Ramya Maddena   18/07/2019      Ramesh G        ML-BRU-CRF-0474
10/05/2019  IN070239       sivabagyam      10/05/2019      Ramesh G    	 ML-MMOH-CRF-1393
06/09/2019	IN071335		Ramesh G										Common-ICN-0012
14/10/2019	IN071513		Ramesh G		14/10/2019		Ramesh G		ML-BRU-CRF-0585.1
06/04/2020	IN071865		Sivabagyam M		06/04/2020		Ramesh G		ML-MMOH-CRF-1484
04/01/2021	5593			Sivabagyam M		04/01/2021		Ramesh G		BSP-CRF-0013
20/04/2021	6484			Ramesh Goli		20/04/2021		RAMESH G		MO-CRF-20147.7
27/07/2021	21509			Ramesh Goli		27/07/2021		Ramesh G   		ML-MMOH-SCF-1865
15/02/2022	26161			Ramesh Goli										JD-CRF-0219
13/10/2022	27926			Ramesh Goli										ML-MMOH-CRF-1643
--------------------------------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	String called_from = request.getParameter("called_from") == null ? "" : request.getParameter("called_from");
	String action = request.getParameter("action") == null ? "" : request.getParameter("action");//IN066304
	String fac_id = "";//Menaka
	String enctr_id ="";//Menaka
	eCA.PatientBannerGroupLine manageEmailBean = null;
	manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patient_id+encounter_id,"eCA.PatientBannerGroupLine",session);
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	String facilityId = (String) session.getValue("facility_id") == null ? "" : (String) session.getValue("facility_id");
	String clinician_id			= (String)session.getValue("ca_practitioner_id") == null ? "" : (String) session.getValue("ca_practitioner_id");//IN038439
	String contr_mod_accession_num = "";//IN038439
	contr_mod_accession_num = request.getParameter("contr_mod_accession_num") == null ? "" : request.getParameter("contr_mod_accession_num"); //IN038439
	String navigator = request.getParameter("navigator") == null ? "" : request.getParameter("navigator"); //IN066304
	String userID= (String) session.getValue("login_user") == null ? "" : (String) session.getValue("login_user");
	String UserName = "";	
	java.util.Locale loc = new java.util.Locale(locale);
	java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
	String loggedUser = common_labels.getString("Common.LoggedUser.label");
	String dateTime = common_labels.getString("Common.datetime.label");
	String normalcyInd="";//IN069290
	int count=0;//IN071865
	//IN066304 start
	ArrayList list = null;
	ArrayList keyList2 = null;
	CAClinicalHistoryBean clinicalHistoryBean = null;
	if("PRINTING_PATIENT_WISE".equals(action)){
		String bean_id					= "CAClinicalHistoryBean" ;
		String bean_name				= "eCA.CAClinicalHistoryBean";
		clinicalHistoryBean	= (CAClinicalHistoryBean)getBeanObject( bean_id, bean_name , request) ;
		list = clinicalHistoryBean.finalizePrintList();
	}else{
		list = manageEmailBean.returnSortList();
	}
	//Collections.sort(list);//IN071865
	Collections.sort(list, Collections.reverseOrder());//IN071865
	int listSize = list.size();
	
	if("PRINTING_PATIENT_WISE".equals(action)){
		keyList2 = clinicalHistoryBean.finalizePrintList();
	}else{
		keyList2 = manageEmailBean.returnList2();
	}
	//IN066304 end
	if(keyList2.size() == 0)
	{
		out.println("<script>alert(getMessage(\"EVENTS_TO_PRINT\",\"CA\"));window.close();</script>");		
	}

	Connection con = null;
	PreparedStatement ps = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	ResultSet rs = null;
	Clob clb = null;	
	StringTokenizer strTok = null;
	String listValue = "";
	String eventDate = "";
	String histRecType = "";
	String contrSysId = "";
	String accNum = "";
	String contrSysEventCode = "";
	String histDataType = "";
	String compress_note_content_yn = ""; //6484
	String resultNum = "";
	String resultStr = "";
	String classValue = "CAQRYEVEN";
//	String siteLogo = "";
	String reportDesc = "";
	String facilityName = "";
	String printDateTime = "";
	String patient_name = "";
	String location = "";
	String nationality_id = "";//IN070239
	String race = "";//IN070239
	String enc_id = "";
	String enc_id_prev = "";
	//IN029312 Starts
	String query_evthdr = "";
	String print_hdr_in_ceh_yn = "";
	String print_disc_txt = ""; //IN004500
	//IN029312 Ends
	String date_of_birth= "";//5593
	StringBuffer sql = new StringBuffer();
	StringBuffer displayData = new StringBuffer();
	StringBuffer displayDataTemp = new StringBuffer();
	StringBuffer displayDataTempNew= new StringBuffer();//IN071865
	//INO30714 Starts
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt1 =	null;
	PreparedStatement pstmt11 =	null;//IN071865
	ResultSet rs2 =	null;
	ResultSet rs1 =	null;
	ResultSet rs11 =	null;//IN071865
	PreparedStatement pstmt3 =	null;//IN070239
	ResultSet rs3 =	null;//IN070239
	String performed_by_id	=	"" ;
	String patient_class =	"";
	String default_pat_name ="";
	String encounter_id1 = "";
	String Sex = "";
	//String encounter_id	=	request.getParameter("encounter_id");
	String facility_name =	"" ;
	String visit_adm_date	=	"" ;
	String attending_practitioner	=	"" ;
	String attending_practitioner_list	=	"" ;//IN066807
	String admitting_practitioner	=	"" ;
	//String bed_number	=	"" ;
	String performing_phy_name	=	"" ;
	String age	=	"" ;
	String gender	=	"" ;
	String race_code="";//IN070239
	//String patient_name	=	"" ;
	String speciality_name	=	"" ;
	//String printDateTime	=	"" ;
	String site_name	=	"" ;
	String doc_ref_id = "";
	String last_amended_by="";
	String authorized_by="";
	String  authorized_by_id		=   ""; //IN069484
	String  authorized_sign			=   "N"; //IN069484
	String pract_sign = "";
	String query_privilege_type	=	"" ;
	String  url1					=	"";
	String  url						=	"";
	String cal_eventdate = "";//IN040090
	String footer_code = null;
	String report_header_code = null;
	Hashtable htParameter=new Hashtable();
	eCA.HeaderDomParser parser = new eCA.HeaderDomParser();
	webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();
	StringBuffer sectionContentUpdatedXML=new StringBuffer();
	/*IN066793 starts*/
	boolean sitespecific=false;
	boolean siteHeader=false;//IN071865
	Connection	 conn=null;
	try
	{
		 conn	= ConnectionManager.getConnection(request);
		sitespecific = CommonBean.isSiteSpecific(conn, "CA","BURMESE_LANGUAGE_FONT");
	}
	catch(Exception e)
	{
		out.println("Exception@111 - in getting header_appl_yn : "+e);
		
	}
	finally
	{
		if(conn!=null)	ConnectionManager.returnConnection(conn,request);
	}
	
	/*IN066793 ends*/
	// IN071335 Changes Start.
	//url   = HttpUtils.getRequestURL(request).toString();
	//url = url.substring(0,url.indexOf("jsp/")); 
	url					= application.getRealPath("/eCA")+"/";
	// IN071335 Changes End.
	//url = url.substring(0,url.indexOf("eOR/"));
	/*IN066793 starts*/
	if(sitespecific)
		url1 = url + "html/RecClinicalNotesTemplateDispayView_Burmese.xsl";
	else
		url1 = url + "html/RecClinicalNotesTemplateDispayView.xsl";
	if(sitespecific)
		url =url+"html/RecClinicalNotesTemplateSentenceView_Burmese.xsl";
	else
		url =url+"html/RecClinicalNotesTemplateSentenceView.xsl";
	/*IN066793 ends*/
	java.sql.Clob			clob_notes_content	= null;
	java.io.Reader			content_reader		= null;
	java.io.BufferedReader	bf_content_reader	= null;
	String	section_content			=	"";
	String	section_content_rpt		=	"";
	String	section_content_ftr		=	"";
	String	login_user_id		=	(String)session.getValue("login_user");
	String  sect_template_query		=	"";
	String		episode_type	=	"" ;
	String		discharge_date		=	"", med_service 	=	"", location_code 	=	"";
	String		discharge_date_only = "";//IN067016
	HashMap<String,String> paramMap = null;
	//[IN032210] Start
	String imageLogoHeader ="N";
	String textLogoHeader ="N";
	String textLogoHeaderSLY="N";//IN070239
	//[IN032210] End

	//INO30714 ends
	String l_disclaimer_code = "";//IN032555
	String l_disclaimer_text = "";//IN032555
	
	//IN064132 changes starts
	String resulted_practitioner = "";
	boolean isPracSiteSpecific = false;
	String histrectype1="";
	//IN064132 changes ends
	String LOGO_HDR_HEIGHT="40";//IN068669
	String LOGO_HDR_WIDTH="40";//IN068669
	boolean isViewLabRes=false;//IN069290
	String logo_Site_Facility ="S";//IN066005
	boolean restrctDispPerformedBy=false;
	boolean restrctPageNo=false; //27926
	boolean print_hdr_dtls=false;//IN070239
	StringBuffer dispData1=new StringBuffer();//IN071865
	StringBuffer dispData=new StringBuffer();//IN071865


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
if("VIEW".equals(navigator)){
            _bw.write(_wl_block10Bytes, _wl_block10);
}else{
	
            _bw.write(_wl_block11Bytes, _wl_block11);
}
            _bw.write(_wl_block12Bytes, _wl_block12);

	try
	{
		con  = ConnectionManager.getConnection(request);
		isPracSiteSpecific = eCommon.Common.CommonBean.isSiteSpecific(con, "OR","RESULTED_PRACTITIONER"); //Added for IN064132
		isViewLabRes=eCommon.Common.CommonBean.isSiteSpecific(con, "CA","VIEW_PRINTING_LAB_RESULT");//IN069290
		print_hdr_dtls=eCommon.Common.CommonBean.isSiteSpecific(con, "CA","PRINT_DIS_HDR_CEH_FOR_SLY");//IN069290
		siteHeader=eCommon.Common.CommonBean.isSiteSpecific(con, "CA","DISABLE_MEDICAL_REPORT");//IN071865
		restrctDispPerformedBy=eCommon.Common.CommonBean.isSiteSpecific(con, "CA","CEH_RSTRICT_PERFRMD_BY_PRINT");//5593
		restrctPageNo=eCommon.Common.CommonBean.isSiteSpecific(con, "CA","CEH_PRINT_RESTRICT_PAGENO");//27926


		ps = con.prepareStatement("select  REPORT_DESC from sm_report where MODULE_ID='CA' and REPORT_ID = 'AHCLINREP' ");
		res = ps.executeQuery();
		while(res.next())
		{
			reportDesc = res.getString("REPORT_DESC") == null ? "" : res.getString("REPORT_DESC");
		}
		
		if(res != null) res.close();
		if(ps != null) ps.close();

		ps = con.prepareStatement("SELECT FACILITY_NAME FROM SM_FACILITY_PARAM_LANG_VW WHERE LANGUAGE_ID = ? and facility_id=?");
		ps.setString(1,locale);
		ps.setString(2,facilityId);

		res = ps.executeQuery();
		while(res.next())
		{
			facilityName = res.getString("FACILITY_NAME") == null ? "" : res.getString("FACILITY_NAME");
		
		}

		if(res != null) res.close();
		if(ps != null) ps.close();

		ps = con.prepareStatement("SELECT APPL_USER_NAME FROM SM_APPL_USER_LANG_VW WHERE LANGUAGE_ID = ? and APPL_USER_ID=?");
		ps.setString(1,locale);
		ps.setString(2,userID);

		res = ps.executeQuery();
		while(res.next())
		{
			UserName = res.getString("APPL_USER_NAME") == null ? "" : res.getString("APPL_USER_NAME");
		}

		if(res != null) res.close();
		if(ps != null) ps.close();

		//ps = con.prepareStatement("SELECT to_char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time from dual");
		/*Modified by Uma on 12/22/2010 for IN025623*/
		//ps = con.prepareStatement("select DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) PATIENT_NAME ,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time from MP_PATIENT B where B.PATIENT_ID=? ");//IN070239
		//ps = con.prepareStatement("select DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) PATIENT_NAME,sex gender,race_code race,NATIONAL_ID_NO nationality ,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time from MP_PATIENT B where B.PATIENT_ID=? ");//IN070239//5593
		ps = con.prepareStatement("select DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) PATIENT_NAME,sex gender,get_age(date_of_birth) ,race_code race,NATIONAL_ID_NO nationality,to_Char(DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time from MP_PATIENT B where B.PATIENT_ID=? ");//IN070239//5593
		ps.setString(1,locale);
		ps.setString(2,patient_id);
		
		
		res = ps.executeQuery();
		while(res.next())
		{
			patient_name = res.getString("PATIENT_NAME") == null ? "" : res.getString("PATIENT_NAME");
			gender = res.getString("gender") == null ? "" : res.getString("gender");//IN070239
			race_code = res.getString("race") == null ? "" : res.getString("race");//IN070239
			nationality_id = res.getString("nationality") == null ? "" : res.getString("nationality");//IN070239
			printDateTime = res.getString("print_date_time") == null ? "" : res.getString("print_date_time");
			printDateTime	= com.ehis.util.DateUtils.convertDate(printDateTime,"DMYHM","en",locale);
			date_of_birth = res.getString("date_of_birth") == null ? "" : res.getString("date_of_birth");//5593
		}

		if(res != null) res.close();
		if(ps != null) ps.close();
		if(race_code!=null)
		{
		pstmt3=con.prepareStatement("select short_desc from MP_RACE_LANG_VW where RACE_CODE=?");
		pstmt3.setString(1,race_code);
		rs3 = pstmt3.executeQuery();
		while(rs3.next())
		{
			race=rs3.getString("short_desc") == null ? "" : rs3.getString("short_desc");//IN070239
		}
		if(rs3 != null) rs3.close();
		if(pstmt3 != null) pstmt3.close();
		}
		//IN029312 starts
		//query_evthdr = "select PRINT_HDR_IN_CEH_YN FROM ca_note_param"; //IN004500
		//query_evthdr = "select PRINT_HDR_IN_CEH_YN,CEH_DISC_TEXT FROM ca_note_param"; //IN004500 //commented for //IN068669
		query_evthdr = "select PRINT_HDR_IN_CEH_YN,CEH_DISC_TEXT,LOGO_HDR_HEIGHT,LOGO_HDR_WIDTH FROM ca_note_param"; //IN068669
		pstmt = con.prepareStatement(query_evthdr);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			print_hdr_in_ceh_yn = rs.getString("PRINT_HDR_IN_CEH_YN");
			print_disc_txt = rs.getString("CEH_DISC_TEXT") == null ? "" : rs.getString("CEH_DISC_TEXT"); //IN004500
			LOGO_HDR_HEIGHT = rs.getString("LOGO_HDR_HEIGHT") == null ? "40" : rs.getString("LOGO_HDR_HEIGHT"); //IN068669
			LOGO_HDR_WIDTH = rs.getString("LOGO_HDR_WIDTH") == null ? "40" : rs.getString("LOGO_HDR_WIDTH"); //IN068669
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		//IN029312 Ends
		
		String sortEventDateTime = "";
		String prevHistRecType = "";
		String prevEventDate = "";
		String histRecTypeDesc = "";

		pstmt = con.prepareStatement(" Select CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1') ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location from PR_ENCOUNTER A where A.PATIENT_ID= ? AND A.ENCOUNTER_ID=? and a.facility_id =? ");
		//IN071865 starts
			for(int i=0; i<listSize; i++)
		{
			if(siteHeader){//IN071865 
			displayData.append(dispData);
			}///IN071865 
			listValue = (String)list.get(i);
			strTok = new StringTokenizer(listValue,"`");

			while(strTok.hasMoreTokens())
			{
				sql.setLength(0);

				enc_id = (String) strTok.nextToken();
				histRecType = (String) strTok.nextToken();
				sortEventDateTime = (String) strTok.nextToken();
				contrSysId = (String) strTok.nextToken();
				accNum = (String) strTok.nextToken();
				contrSysEventCode = (String) strTok.nextToken();
			}
			
			//if(!enc_id.equals("0")){
			if((!enc_id.equals("0"))&&(!enc_id.equals(enc_id_prev)))
			{
				pstmt.setString(1,locale);
				pstmt.setString(2,locale);
				pstmt.setString(3,patient_id);
				pstmt.setString(4,enc_id);
				pstmt.setString(5,facilityId);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					location = rs.getString("location") == null ? "" : rs.getString("location");
				}

				if(rs != null) rs.close();
		
				}
			}
		
	if(siteHeader){
		//[IN032210] Start
				pstmt11	= con.prepareStatement("SELECT IMAGE_REF FROM CA_NOTE_IMAGE_LIST WHERE IMAGE_REF='VDFI'");
				rs11 = pstmt11.executeQuery();
				if(rs11.next()){
					imageLogoHeader="Y";				
				}
				if(rs11 != null) rs11.close();
				if(pstmt11 != null) pstmt11.close();
				
				pstmt11	= con.prepareStatement("SELECT PRINT_LOGO_HEADER_YN,PRINT_TEXT_HDR_YN FROM CA_NOTE_TYPE WHERE NOTE_TYPE=?");
				pstmt11.setString(1,contrSysEventCode);
				rs11 = pstmt11.executeQuery();
				if(rs11.next()){
					textLogoHeaderSLY = "Y";//IN070239
					String printLogoHed = rs11.getString("PRINT_LOGO_HEADER_YN")==null?"":(String)rs11.getString("PRINT_LOGO_HEADER_YN");
					String printtextHed = rs11.getString("PRINT_TEXT_HDR_YN")==null?"":(String)rs11.getString("PRINT_TEXT_HDR_YN");
					if("Y".equals(printLogoHed) && "Y".equals(printtextHed))
							textLogoHeader="Y";				
				}
			//IN070239 starts
				if("N".equals(textLogoHeaderSLY)&& print_hdr_dtls){
					textLogoHeader="Y";
				}
				//IN070239 ends
				//[IN032210] End
				//IN071513 Starts
				if(rs11 != null) rs11.close();
					if(pstmt11 != null) pstmt11.close();
				try
				{
					pstmt11 = con.prepareStatement("SELECT LOGO_SITE_FACILITY FROM CA_PARAM_BY_FACILITY WHERE FACILITY_ID=? ");
					pstmt11.setString(1,facilityId);				
					rs11 = pstmt11.executeQuery();
					if(rs11.next()){
					   logo_Site_Facility = rs11.getString("LOGO_SITE_FACILITY")==null?"":rs11.getString("LOGO_SITE_FACILITY");
					}
										
				}catch(Exception e){
				//	out.println("Exception@1 : "+e);//COMMON-ICN-0181
					e.printStackTrace();//COMMON-ICN-0181
				}finally{
					if(rs11 != null) rs11.close();
					if(pstmt11 != null) pstmt11.close();
				}
				
				dispData.append("<table width='100%' cellpadding=3 cellspacing=0 border='0'>");
				//[IN032210] Start
				if("Y".equals(imageLogoHeader)){
					dispData.append("<tr><td colspan='2'>");
					dispData.append("<table width='100%' style='height:100px;' border=0 cellpadding=3 cellspacing=0 align=center ><tr><td class='HEADER' align='center' id='headerImageID'>");
					//IN066005 Start
					if(logo_Site_Facility.equals("S")){
						dispData.append("<img src='../../eCA/jsp/CADisplayImages.jsp' >");
					}else if(logo_Site_Facility.equals("F")){
						dispData.append("<img src='../../eCommon/jsp/DisplayImages.jsp?param=facilityimage' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'>");
					}
					dispData.append("</td></tr></table></td></tr>");//IN066005 end
					
					if("Y".equals(textLogoHeader)){
						dispData.append("<tr>");	
						dispData.append("<td width='100%' colspan='2' align='center'><h3>"+facilityName+"</h3></td>");
						dispData.append("</tr>");
						
					}
				}else{
					dispData.append("<tr>");	
					//dispData.append("<td width='20%' class='HEADER' align='center'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='40' height='40'></td>");//IN068669
					//dispData.append("<td width='20%' class='HEADER' align='center'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");//IN068669
					//IN066005 Starts
						if(logo_Site_Facility.equals("S")){
							dispData.append("<td width='20%' class='HEADER' align='center' ><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");
							}else if(logo_Site_Facility.equals("F")){
								dispData.append("<td width='20%' class='HEADER' align='center'><img src='../../eCommon/jsp/DisplayImages.jsp?param=facilityimage' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");
									}//IN066005 ends
					if("Y".equals(textLogoHeader)){		
						dispData.append("<td width='80%' align='center'><h3>"+facilityName+"</h3></td>");
					}else{
						dispData.append("<td width='80%' align='center'>&nbsp;</h3></td>");
					}
					dispData.append("</tr>");		
				}
				
				//IN070239 starts
				if(gender.equals("M"))
					Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			else if (gender.equals("F"))
					Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			else 
					Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
			//IN070239 ends
				//dispData.append("<tr>");	
				//dispData.append("<td width='20%' class='HEADER' align='center'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='40' height='40'></td>");
				//dispData.append("<td width='80%' align='left'><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+facilityName+"</h3></td>");
				//dispData.append("</tr>");
				//[IN032210] End
				//IN071865 starts
				dispData.append("</table>");

					dispData.append("<BR>");
					if(print_hdr_in_ceh_yn.equals("Y"))//IN029312
					{//IN029312
					dispData.append("<table width='100%' cellpadding=0 cellspacing=0 border='0'>");
					dispData.append("<tr>");

					dispData.append("<td width='24%' align='left'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"</b></td>");
					dispData.append("<td width='2%' align='center'><b>:</b></td>");
					dispData.append("<td width='24%' align='left'><b>"+patient_id+"</b></td>");
					
					dispData.append("<td width='24%' align='left'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+"</b></td>"); 

					dispData.append("<td width='2%' align='center'><b>:</b></td>"); 
					dispData.append("<td width='24%' align='left'><b>"+patient_name+"</b></td>"); 
					dispData.append("</tr>");
					if(!print_hdr_dtls){	//IN070239
					// IN029312 Starts
					dispData.append("<table width='100%' cellpadding=0 cellspacing=0 border='0' ><td width='24%' align='left'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounterid.label","common_labels")+"</b></td>");
					dispData.append("<td width='2%' align='center'><b>:</b></td>");
					//IN065886 Changes starts
					//dispData.append("<td width='24%' align='left'><b>"+enc_id+"</b></td>");
					if(enc_id.equals("0"))
					dispData.append("<td width='24%' align='left'><b>&nbsp;</b></td>");
					else
					dispData.append("<td width='24%' align='left'><b>"+enc_id+"</b></td>");
					//IN065886 Changes ends
					dispData.append("<td width='24%' align='left'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</b></td>");  //location
					dispData.append("<td width='2%' align='center'><b>:</b></td>");  //location
					dispData.append("<td width='24%' align='left'><b>"+location+"</b></td>");  //location
					dispData.append("</tr>");
					//5593 starts
					dispData.append("<tr>");
					dispData.append("<td width='24%' align='left'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DateofBirth.label","common_labels")+"</b></td>");
					dispData.append("<td width='2%' align='center'><b>:</b></td>");
					dispData.append("<td width='24%' align='left'><b>"+date_of_birth+"</b></td>");
					dispData.append("</tr></table><BR>");
					//5593 ends
					}else{
					dispData.append("<table width='100%' cellpadding=0 cellspacing=0 border='0' ><td width='24%' align='left'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.National.label","common_labels")+" ID"+"</b></td>");  //gender
					dispData.append("<td width='2%' align='center'><b>:</b></td>");  //gender
					dispData.append("<td width='24%' align='left'><b>"+nationality_id+"</b></td>");  //gender
					dispData.append("<td width='24%' align='left'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.race.label","common_labels")+"</b></td>");  //nationality
					dispData.append("<td width='2%' align='center'><b>:</b></td>");  //nationality
					dispData.append("<td width='24%' align='left'><b>"+race+"</b></td>");  //nationality
					dispData.append("</tr></table>");
					dispData.append("<table width='100%'  cellpadding=0 cellspacing=0 border='0' ><td width='24%' align='left'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+"</b></td>");  //race
					dispData.append("<td width='2%' align='center'><b>:</b></td>");  //race
					dispData.append("<td width='24%' align='left'><b>"+Sex+"</b></td>");  //race
					//5593 starts
					dispData.append("<td width='24%' align='left'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DateofBirth.label","common_labels")+"</b></td>");
					dispData.append("<td width='2%' align='center'><b>:</b></td>");
					dispData.append("<td width='24%' align='left'><b>"+date_of_birth+"</b></td>");
					//5593 ends
					dispData.append("</tr></table><BR>");
					}//IN070239ENDS
					//		IN029312 Ends 
							
					dispData.append("<tr>");

					dispData.append("</table>");
					}//IN029312
					dispData.append("<BR>");
					
					dispData1.append("<table border='1' cellpadding='3' cellspacing='3' width = '100%' style='font-family:Verdana;:background-color:#ADADAD'><TR><TD colspan='3'>");
					if(print_hdr_in_ceh_yn.equals("Y"))//IN029312
					{//IN029312
					dispData1.append("<table width='100%' cellpadding=0 cellspacing=0>");
					dispData1.append("<tr>");
					dispData1.append("<td align='left'><b>"+loggedUser+" : "+UserName+"</b></td>");
					dispData1.append("<td align='right'><b>"+dateTime+" : "+printDateTime+"</b></td>");
					dispData1.append("</tr>");
					dispData1.append("</table>");
					}//IN029312
					dispData1.append("</td></tr></table>");
					dispData1.append("<BR>");//IN032555
					dispData1.append(l_disclaimer_text);//IN032555
					//IN004500 Start.
					if(!print_disc_txt.equals(""))
					{
					dispData1.append("<table border='0' cellpadding='0' cellspacing='0' width = '100%'><TR><TD colspan='3'>");
					dispData1.append("<table width='100%' cellpadding=0 cellspacing=0>");
					dispData1.append("<tr>");
					dispData1.append("<td > &nbsp;</td>");
					dispData1.append("</tr>");
					dispData1.append("<tr>");
					dispData1.append("<td align='left'  >"+print_disc_txt+"</td>");
					dispData1.append("</tr>");
					dispData1.append("</table>");
					dispData1.append("</td></tr></table>");
					}
		}
				else{

					//[IN032210] Start
							pstmt11	= con.prepareStatement("SELECT IMAGE_REF FROM CA_NOTE_IMAGE_LIST WHERE IMAGE_REF='VDFI'");
							rs11 = pstmt11.executeQuery();
							if(rs11.next()){
								imageLogoHeader="Y";				
							}
							
							pstmt11	= con.prepareStatement("SELECT PRINT_LOGO_HEADER_YN,PRINT_TEXT_HDR_YN FROM CA_NOTE_TYPE WHERE NOTE_TYPE=?");
							pstmt11.setString(1,contrSysEventCode);
							rs11 = pstmt11.executeQuery();
							if(rs11.next()){
								textLogoHeaderSLY = "Y";//IN070239
								String printLogoHed = rs11.getString("PRINT_LOGO_HEADER_YN")==null?"":(String)rs11.getString("PRINT_LOGO_HEADER_YN");
								String printtextHed = rs11.getString("PRINT_TEXT_HDR_YN")==null?"":(String)rs11.getString("PRINT_TEXT_HDR_YN");
								if("Y".equals(printLogoHed) && "Y".equals(printtextHed))
										textLogoHeader="Y";				
							}
						//IN070239 starts
							if("N".equals(textLogoHeaderSLY)&& print_hdr_dtls){
								textLogoHeader="Y";
							}
							//IN070239 ends
							//[IN032210] End
							//IN071513 Starts
							try
							{
								pstmt11 = con.prepareStatement("SELECT LOGO_SITE_FACILITY FROM CA_PARAM_BY_FACILITY WHERE FACILITY_ID=? ");
								pstmt11.setString(1,facilityId);				
								rs11 = pstmt11.executeQuery();
								if(rs11.next()){
								   logo_Site_Facility = rs11.getString("LOGO_SITE_FACILITY")==null?"":rs11.getString("LOGO_SITE_FACILITY");
								}
													
							}catch(Exception e){
								//out.println("Exception@1 : "+e);//COMMON-ICN-0181
								e.printStackTrace();//COMMON-ICN-0181

							}finally{
								if(rs11 != null) rs11.close();
								if(pstmt11 != null) pstmt11.close();
							}
							//StringBuffer dispData = new StringBuffer();
							dispData.append("<table width='100%' cellpadding=3 cellspacing=0 border='0'>");
							//[IN032210] Start
							if("Y".equals(imageLogoHeader)){
								dispData.append("<tr><td colspan='2'>");
								dispData.append("<table width='100%' style='height:100px;' border=0 cellpadding=3 cellspacing=0 align=center ><tr><td class='HEADER' align='center' id='headerImageID'>");
								//IN066005 Start
								if(logo_Site_Facility.equals("S")){
									dispData.append("<img src='../../eCA/jsp/CADisplayImages.jsp' >");
								}else if(logo_Site_Facility.equals("F")){
									dispData.append("<img src='../../eCommon/jsp/DisplayImages.jsp?param=facilityimage' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'>");
								}
								dispData.append("</td></tr></table></td></tr>");//IN066005 end
								
								if("Y".equals(textLogoHeader)){
									dispData.append("<tr>");	
									dispData.append("<td width='100%' colspan='2' align='center'><h3>"+facilityName+"</h3></td>");
									dispData.append("</tr>");
									
								}
							}else{
								dispData.append("<tr>");	
								//dispData.append("<td width='20%' class='HEADER' align='center'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='40' height='40'></td>");//IN068669
								//dispData.append("<td width='20%' class='HEADER' align='center'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");//IN068669
								//IN066005 Starts
									if(logo_Site_Facility.equals("S")){
										dispData.append("<td width='20%' class='HEADER' align='center' ><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");
										}else if(logo_Site_Facility.equals("F")){
											dispData.append("<td width='20%' class='HEADER' align='center'><img src='../../eCommon/jsp/DisplayImages.jsp?param=facilityimage' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");
												}//IN066005 ends
								if("Y".equals(textLogoHeader)){		
									dispData.append("<td width='80%' align='center'><h3>"+facilityName+"</h3></td>");
								}else{
									dispData.append("<td width='80%' align='center'>&nbsp;</h3></td>");
								}
								dispData.append("</tr>");		
							}
							
							//IN070239 starts
							if(gender.equals("M"))
								Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
						else if (gender.equals("F"))
								Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
						else 
								Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
						//IN070239 ends
							//dispData.append("<tr>");	
							//dispData.append("<td width='20%' class='HEADER' align='center'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='40' height='40'></td>");
							//dispData.append("<td width='80%' align='left'><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+facilityName+"</h3></td>");
							//dispData.append("</tr>");
							//[IN032210] End
							//IN071865 starts
								dispData.append("<tr>");
								dispData.append("<td colspan='2' align='center'><h4>"+reportDesc+"</h4></td>");
								dispData.append("</tr>");
							dispData.append("</table>");

							dispData.append("<BR>");
							if(print_hdr_in_ceh_yn.equals("Y"))//IN029312
							{//IN029312
							dispData.append("<table width='100%' cellpadding=0 cellspacing=0 border='0'>");
							dispData.append("<tr>");

							dispData.append("<td width='24%' align='left'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"</b></td>");
							dispData.append("<td width='2%' align='center'><b>:</b></td>");
							dispData.append("<td width='24%' align='left'><b>"+patient_id+"</b></td>");
							
							dispData.append("<td width='24%' align='left'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+"</b></td>"); 

							dispData.append("<td width='2%' align='center'><b>:</b></td>"); 
							dispData.append("<td width='24%' align='left'><b>"+patient_name+"</b></td>"); 
							dispData.append("</tr>");
							if(!print_hdr_dtls){	//IN070239
							// IN029312 Starts
							dispData.append("<table width='100%' cellpadding=0 cellspacing=0 border='0' ><td width='24%' align='left'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounterid.label","common_labels")+"</b></td>");
							dispData.append("<td width='2%' align='center'><b>:</b></td>");
							//IN065886 Changes starts
							//dispData.append("<td width='24%' align='left'><b>"+enc_id+"</b></td>");
							if(enc_id.equals("0"))
							dispData.append("<td width='24%' align='left'><b>&nbsp;</b></td>");
							else
							dispData.append("<td width='24%' align='left'><b>"+enc_id+"</b></td>");
							//IN065886 Changes ends
							dispData.append("<td width='24%' align='left'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</b></td>");  //location
							dispData.append("<td width='2%' align='center'><b>:</b></td>");  //location
							dispData.append("<td width='24%' align='left'><b>"+location+"</b></td>");  //location
							dispData.append("</tr>");
							//5593 starts
							dispData.append("<tr>");
							dispData.append("<td width='24%' align='left'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DateofBirth.label","common_labels")+"</b></td>");
							dispData.append("<td width='2%' align='center'><b>:</b></td>");
							dispData.append("<td width='24%' align='left'><b>"+date_of_birth+"</b></td>");
							dispData.append("</tr></table><BR>");
							//5593 ends
							}else{
							dispData.append("<table width='100%' cellpadding=0 cellspacing=0 border='0' ><td width='24%' align='left'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.National.label","common_labels")+" ID"+"</b></td>");  //gender
							dispData.append("<td width='2%' align='center'><b>:</b></td>");  //gender
							dispData.append("<td width='24%' align='left'><b>"+nationality_id+"</b></td>");  //gender
							dispData.append("<td width='24%' align='left'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.race.label","common_labels")+"</b></td>");  //nationality
							dispData.append("<td width='2%' align='center'><b>:</b></td>");  //nationality
							dispData.append("<td width='24%' align='left'><b>"+race+"</b></td>");  //nationality
							dispData.append("</tr></table>");
							dispData.append("<table width='100%'  cellpadding=0 cellspacing=0 border='0' ><tr><td width='24%' align='left'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+"</b></td>");  //race
							dispData.append("<td width='2%' align='center'><b>:</b></td>");  //race
							dispData.append("<td width='24%' align='left'><b>"+Sex+"</b></td>");  //race
							//5593 starts
							dispData.append("<td width='24%' align='left'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DateofBirth.label","common_labels")+"</b></td>");
							dispData.append("<td width='2%' align='center'><b>:</b></td>");
							dispData.append("<td width='24%' align='left'><b>"+date_of_birth+"</b></td>");
							//5593 ends
							dispData.append("</tr></table><BR>");
							}//IN070239ENDS
							//		IN029312 Ends 
									
							dispData.append("<tr>");

							dispData.append("</table>");
							}//IN029312
							dispData.append("<BR>");
							//StringBuffer dispData1=new StringBuffer();
							dispData1.append("<table border='1' cellpadding='3' cellspacing='3' width = '100%' style='font-family:Verdana;:background-color:#ADADAD'><TR><TD colspan='3'>");
							if(print_hdr_in_ceh_yn.equals("Y"))//IN029312
							{//IN029312
							dispData1.append("<table width='100%' cellpadding=0 cellspacing=0>");
							dispData1.append("<tr>");
							dispData1.append("<td align='left'><b>"+loggedUser+" : "+UserName+"</b></td>");
							dispData1.append("<td align='right'><b>"+dateTime+" : "+printDateTime+"</b></td>");
							dispData1.append("</tr>");
							dispData1.append("</table>");
							}//IN029312
							dispData1.append("</td></tr></table>");
							dispData1.append("<BR>");//IN032555
							dispData1.append(l_disclaimer_text);//IN032555
							//IN004500 Start.
							if(!print_disc_txt.equals(""))
							{
							dispData1.append("<table border='0' cellpadding='0' cellspacing='0' width = '100%'><TR><TD colspan='3'>");
							dispData1.append("<table width='100%' cellpadding=0 cellspacing=0>");
							dispData1.append("<tr>");
							dispData1.append("<td > &nbsp;</td>");
							dispData1.append("</tr>");
							dispData1.append("<tr>");
							dispData1.append("<td align='left'  >"+print_disc_txt+"</td>");
							dispData1.append("</tr>");
							dispData1.append("</table>");
							dispData1.append("</td></tr></table>");
							}
				}//IN071865 ends
		for(int i=0; i<listSize; i++)
		{
			if(siteHeader){//IN071865 
			displayData.append(dispData);
			}///IN071865 
			listValue = (String)list.get(i);
			strTok = new StringTokenizer(listValue,"`");

			while(strTok.hasMoreTokens())
			{
				sql.setLength(0);

				enc_id = (String) strTok.nextToken();
				histRecType = (String) strTok.nextToken();
				sortEventDateTime = (String) strTok.nextToken();
				contrSysId = (String) strTok.nextToken();
				accNum = (String) strTok.nextToken();
				contrSysEventCode = (String) strTok.nextToken();
			}
			
			//if(!enc_id.equals("0")){
			if((!enc_id.equals("0"))&&(!enc_id.equals(enc_id_prev)))
			{
				pstmt.setString(1,locale);
				pstmt.setString(2,locale);
				pstmt.setString(3,patient_id);
				pstmt.setString(4,enc_id);
				pstmt.setString(5,facilityId);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					location = rs.getString("location") == null ? "" : rs.getString("location");
				}

				if(rs != null) rs.close();
		
				}
			
			if(histRecType.equals("CLNT"))
			{
				//sql.append("select null DIS_SUMM_DISCLAIMER_TXT,null  REF_LETTER_DISCLAIMER_TXT, b.hist_data,a.FACILITY_ID,a.ENCOUNTER_ID,a.PATIENT_CLASS,AM_GET_DESC.AM_PRACTITIONER(A.PERFORMED_BY_ID,?,'2') authorized_by_name,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_datetime ,DECODE(a.patient_class,'OP','O','EM' ,'O','I') Episode_type,SM_GET_DESC.SM_FACILITY_PARAM(A.FACILITY_ID,?,'1') facility_name,(select nvl(NATIONAL_ID_NO,'') from MP_PATIENT where PATIENT_ID=a.patient_id) NATIONAL_ID_NO,(select nvl(NAT_ID_PROMPT,'National ID No') NAT_ID_PROMPT FROM MP_PARAM where rownum=1) NAT_ID_PROMPT, to_char(a.event_date,'dd/mm/yyyy hh24:mi') event_date,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,'"+locale+"','1') hist_rec_type_desc  from cr_encounter_detail a,cr_encounter_detail_txt b where a.HIST_REC_TYPE=b.HIST_REC_TYPE and a.CONTR_SYS_ID=b.CONTR_SYS_ID   and a.ACCESSION_NUM=b.ACCESSION_NUM and a.CONTR_SYS_EVENT_CODE=b.CONTR_SYS_EVENT_CODE and b.hist_rec_type = ? and a.contr_sys_id =? and b.accession_num=? and a.contr_sys_event_code =?");
				//6484 Start.
				//sql.append("select null DIS_SUMM_DISCLAIMER_TXT,null  REF_LETTER_DISCLAIMER_TXT, b.hist_data,a.FACILITY_ID,a.ENCOUNTER_ID,a.PATIENT_CLASS,AM_GET_DESC.AM_PRACTITIONER(A.PERFORMED_BY_ID,?,'2') authorized_by_name,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_datetime ,DECODE(a.patient_class,'OP','O','EM' ,'O','I') Episode_type,SM_GET_DESC.SM_FACILITY_PARAM(A.FACILITY_ID,?,'1') facility_name,(select nvl(NATIONAL_ID_NO,'') from MP_PATIENT where PATIENT_ID=a.patient_id) NATIONAL_ID_NO,(select nvl(NAT_ID_PROMPT,'National ID No') NAT_ID_PROMPT FROM MP_PARAM where rownum=1) NAT_ID_PROMPT, to_char(a.event_date,'dd/mm/yyyy hh24:mi') event_date,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,'"+locale+"','1') hist_rec_type_desc, a.encounter_ID, a.FACILITY_ID  from cr_encounter_detail a,cr_encounter_detail_txt b where a.HIST_REC_TYPE=b.HIST_REC_TYPE and a.CONTR_SYS_ID=b.CONTR_SYS_ID   and a.ACCESSION_NUM=b.ACCESSION_NUM and a.CONTR_SYS_EVENT_CODE=b.CONTR_SYS_EVENT_CODE and b.hist_rec_type = ? and a.contr_sys_id =? and b.accession_num=? and a.contr_sys_event_code =?");
				sql.append("select null DIS_SUMM_DISCLAIMER_TXT,null  REF_LETTER_DISCLAIMER_TXT, b.hist_data,b.COMPRESS_HIST_DATA_YN,b.COMPRESS_HIST_DATA,b.comments,a.FACILITY_ID,a.ENCOUNTER_ID,a.PATIENT_CLASS,AM_GET_DESC.AM_PRACTITIONER(A.PERFORMED_BY_ID,?,'2') authorized_by_name,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_datetime ,DECODE(a.patient_class,'OP','O','EM' ,'O','I') Episode_type,SM_GET_DESC.SM_FACILITY_PARAM(A.FACILITY_ID,?,'1') facility_name,(select nvl(NATIONAL_ID_NO,'') from MP_PATIENT where PATIENT_ID=a.patient_id) NATIONAL_ID_NO,(select nvl(NAT_ID_PROMPT,'National ID No') NAT_ID_PROMPT FROM MP_PARAM where rownum=1) NAT_ID_PROMPT, to_char(a.event_date,'dd/mm/yyyy hh24:mi') event_date,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,'"+locale+"','1') hist_rec_type_desc, a.encounter_ID, a.FACILITY_ID  from cr_encounter_detail a,cr_encounter_detail_txt b where a.HIST_REC_TYPE=b.HIST_REC_TYPE and a.CONTR_SYS_ID=b.CONTR_SYS_ID   and a.ACCESSION_NUM=b.ACCESSION_NUM and a.CONTR_SYS_EVENT_CODE=b.CONTR_SYS_EVENT_CODE and b.hist_rec_type = ? and a.contr_sys_id =? and b.accession_num=? and a.contr_sys_event_code =?");
				//6484 end.
			}//if end of CLNT
			else
			{
				//sql.append(" select TO_CHAR(NULL) DIS_SUMM_DISCLAIMER_TXT ,TO_CHAR(NULL) REF_LETTER_DISCLAIMER_TXT , b.long_desc,(select nvl(NATIONAL_ID_NO,'') from MP_PATIENT where PATIENT_ID=a.patient_id) NATIONAL_ID_NO,(select nvl(NAT_ID_PROMPT,'National ID No') NAT_ID_PROMPT FROM MP_PARAM where rownum=1) NAT_ID_PROMPT , A.HIST_DATA_TYPE,A.RESULT_STR, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||' '||RESULT_NUM_UOM||' '||(select decode(a.normalcy_ind,HIGH_STR,'Abnormal',LOW_STR,'Abnormal',ABN_STR,'Abnormal',CRIT_STR,'Critically Abnormal',CRIT_HIGH_STR,'Critically Abnormal',CRIT_LOW_STR,'Critically Abnormal') from cr_clin_event_param)||' '||replace('('||DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_LOW),TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||' - '||DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_HIGH),TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||')','( - )',null) RESULT_NUM,(SELECT CA_CLOB_REPLACE(hist_data,chr(10),'\n'"); // commented for IN047528
				//sql.append(" select TO_CHAR(NULL) DIS_SUMM_DISCLAIMER_TXT ,TO_CHAR(NULL) REF_LETTER_DISCLAIMER_TXT , b.long_desc,(select nvl(NATIONAL_ID_NO,'') from MP_PATIENT where PATIENT_ID=a.patient_id) NATIONAL_ID_NO,(select nvl(NAT_ID_PROMPT,'National ID No') NAT_ID_PROMPT FROM MP_PARAM where rownum=1) NAT_ID_PROMPT , A.HIST_DATA_TYPE,A.RESULT_STR, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000',8,'99999999990.90000000',9,'99999999990.90000000',0,'999999999','999999999')))||' '||RESULT_NUM_UOM||' '||(select decode(a.normalcy_ind,HIGH_STR,'Abnormal',LOW_STR,'Abnormal',ABN_STR,'Abnormal',CRIT_STR,'Critically Abnormal',CRIT_HIGH_STR,'Critically Abnormal',CRIT_LOW_STR,'Critically Abnormal') from cr_clin_event_param)||' '||replace('('||DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_LOW),TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000',8,'99999999990.90000000',9,'99999999990.90000000',0,'999999999','999999999')))||' - '||DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_HIGH),TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000',8,'99999999990.90000000',9,'99999999990.90000000',0,'999999999','999999999')))||')','( - )',null) RESULT_NUM,(SELECT CA_CLOB_REPLACE(hist_data,chr(10),'\n'"); // modified for IN047528 //Commented for IN063813
				//sql.append(" select TO_CHAR(NULL) DIS_SUMM_DISCLAIMER_TXT ,TO_CHAR(NULL) REF_LETTER_DISCLAIMER_TXT , b.long_desc,(select nvl(NATIONAL_ID_NO,'') from MP_PATIENT where PATIENT_ID=a.patient_id) NATIONAL_ID_NO,(select nvl(NAT_ID_PROMPT,'National ID No') NAT_ID_PROMPT FROM MP_PARAM where rownum=1) NAT_ID_PROMPT , A.HIST_DATA_TYPE,A.RESULT_STR, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000',8,'99999999990.90000000',9,'99999999990.90000000',0,'999999999','999999999')))||' '||RESULT_NUM_UOM||' '||(select decode(a.normalcy_ind,HIGH_STR,'Abnormal',LOW_STR,'Abnormal',ABN_STR,'Abnormal',CRIT_STR,'Critically Abnormal',CRIT_HIGH_STR,'Critically Abnormal',CRIT_LOW_STR,'Critically Abnormal') from cr_clin_event_param)||' '||replace('('||DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_LOW),TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000',8,'99999999990.90000000',9,'99999999990.90000000',0,'999999999','999999999')))||' - '||DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_HIGH),TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000',8,'99999999990.90000000',9,'99999999990.90000000',0,'999999999','999999999')))||')','( - )',null) RESULT_NUM,A.RESULT_NUM RESULT_NUM_VALUE,RESULT_NUM_UOM,RESULT_NUM_PREFIX,NORMAL_LOW,NORMAL_HIGH,CRITICAL_LOW,CRITICAL_HIGH,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, '"+locale+"', '1') clinician_short_name,(SELECT CA_CLOB_REPLACE(hist_data,chr(10),'\n'"); // modified for IN063813 //Commented for IN064132
				//sql.append(" select TO_CHAR(NULL) DIS_SUMM_DISCLAIMER_TXT ,TO_CHAR(NULL) REF_LETTER_DISCLAIMER_TXT , b.long_desc,(select nvl(NATIONAL_ID_NO,'') from MP_PATIENT where PATIENT_ID=a.patient_id) NATIONAL_ID_NO,(select nvl(NAT_ID_PROMPT,'National ID No') NAT_ID_PROMPT FROM MP_PARAM where rownum=1) NAT_ID_PROMPT , A.HIST_DATA_TYPE,A.RESULT_STR, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000',8,'99999999990.90000000',9,'99999999990.90000000',0,'999999999','999999999')))||' '||RESULT_NUM_UOM||' '||(select decode(a.normalcy_ind,HIGH_STR,'Abnormal',LOW_STR,'Abnormal',ABN_STR,'Abnormal',CRIT_STR,'Critically Abnormal',CRIT_HIGH_STR,'Critically Abnormal',CRIT_LOW_STR,'Critically Abnormal') from cr_clin_event_param)||' '||replace('('||DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_LOW),TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000',8,'99999999990.90000000',9,'99999999990.90000000',0,'999999999','999999999')))||' - '||DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_HIGH),TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000',8,'99999999990.90000000',9,'99999999990.90000000',0,'999999999','999999999')))||')','( - )',null) RESULT_NUM,A.RESULT_NUM RESULT_NUM_VALUE,RESULT_NUM_UOM,RESULT_NUM_PREFIX,NORMAL_LOW,NORMAL_HIGH,CRITICAL_LOW,CRITICAL_HIGH,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, '"+locale+"', '1') clinician_short_name,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID), '"+locale+"', '1') resulted_practitioner,a.HIST_REC_TYPE,(SELECT CA_CLOB_REPLACE(hist_data,chr(10),'\n'"); // modified for IN064132 //IN069290
				//21509 Start.
				//sql.append(" select TO_CHAR(NULL) DIS_SUMM_DISCLAIMER_TXT ,TO_CHAR(NULL) REF_LETTER_DISCLAIMER_TXT , b.long_desc,(select nvl(NATIONAL_ID_NO,'') from MP_PATIENT where PATIENT_ID=a.patient_id) NATIONAL_ID_NO,(select nvl(NAT_ID_PROMPT,'National ID No') NAT_ID_PROMPT FROM MP_PARAM where rownum=1) NAT_ID_PROMPT ,A.NORMALCY_IND,A.HIST_DATA_TYPE,A.RESULT_STR, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000',8,'99999999990.90000000',9,'99999999990.90000000',0,'999999999','999999999')))||' '||RESULT_NUM_UOM||' '||(select decode(a.normalcy_ind,HIGH_STR,'Abnormal',LOW_STR,'Abnormal',ABN_STR,'Abnormal',CRIT_STR,'Critically Abnormal',CRIT_HIGH_STR,'Critically Abnormal',CRIT_LOW_STR,'Critically Abnormal') from cr_clin_event_param)||' '||replace('('||DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_LOW),TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000',8,'99999999990.90000000',9,'99999999990.90000000',0,'999999999','999999999')))||' - '||DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_HIGH),TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000',8,'99999999990.90000000',9,'99999999990.90000000',0,'999999999','999999999')))||')','( - )',null) RESULT_NUM,A.RESULT_NUM RESULT_NUM_VALUE,RESULT_NUM_UOM,RESULT_NUM_PREFIX,NORMAL_LOW,NORMAL_HIGH,CRITICAL_LOW,CRITICAL_HIGH,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, '"+locale+"', '1') clinician_short_name,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID), '"+locale+"', '1') resulted_practitioner,a.HIST_REC_TYPE,(SELECT CA_CLOB_REPLACE(hist_data,chr(10),'\n'"); //IN069290
				sql.append(" select TO_CHAR(NULL) DIS_SUMM_DISCLAIMER_TXT ,TO_CHAR(NULL) REF_LETTER_DISCLAIMER_TXT , b.long_desc,(select nvl(NATIONAL_ID_NO,'') from MP_PATIENT where PATIENT_ID=a.patient_id) NATIONAL_ID_NO,(select nvl(NAT_ID_PROMPT,'National ID No') NAT_ID_PROMPT FROM MP_PARAM where rownum=1) NAT_ID_PROMPT ,A.NORMALCY_IND,A.HIST_DATA_TYPE,A.RESULT_STR, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000',8,'99999999990.90000000',9,'99999999990.90000000',0,'999999999','999999999')))||' '||RESULT_NUM_UOM||' '||(select decode(a.normalcy_ind,HIGH_STR,'Abnormal',LOW_STR,'Abnormal',ABN_STR,'Abnormal',CRIT_STR,'Critically Abnormal',CRIT_HIGH_STR,'Critically Abnormal',CRIT_LOW_STR,'Critically Abnormal') from cr_clin_event_param)||' '||replace('('||DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_LOW),TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000',8,'99999999990.90000000',9,'99999999990.90000000',0,'999999999','999999999')))||' - '||DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_HIGH),TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'99999999990.0',2,'99999999990.90',3,'99999999990.900',4,'99999999990.9000',5,'99999999990.90000',6,'99999999990.900000',7,'99999999990.9000000',8,'99999999990.90000000',9,'99999999990.90000000',0,'999999999','999999999')))||')','( - )',null) RESULT_NUM,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(A.RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM_VALUE,RESULT_NUM_UOM,RESULT_NUM_PREFIX,NORMAL_LOW,NORMAL_HIGH,CRITICAL_LOW,CRITICAL_HIGH,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, '"+locale+"', '1') clinician_short_name,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID), '"+locale+"', '1') resulted_practitioner,a.HIST_REC_TYPE,(SELECT CA_CLOB_REPLACE(hist_data,chr(10),'\n'");
				//21509 End.
				
				
				//6484 Start.
				//sql.append( "  ) FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA ,a.FACILITY_ID,a.ENCOUNTER_ID,a.PATIENT_CLASS,(select SHORT_NAME from am_practitioner where practitioner_id=a.PERFORMED_BY_ID) authorized_by_name,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_datetime ,dEcode(a.patient_class,'OP','O','EM' ,'O','I') Episode_type,(select FACILITY_NAME from sm_facility_param where facility_id=a.facility_id) facility_name,to_char(a.event_date,'dd/mm/yyyy hh24:mi') event_date,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,'"+locale+"','1') hist_rec_type_desc, a.encounter_ID, a.FACILITY_ID    from cr_encounter_detail a,cr_clin_event_mast b where a.HIST_REC_TYPE=b.HIST_REC_TYPE and b.event_code=a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type = ? and a.contr_sys_id =? and a.accession_num=? and a.contr_sys_event_code =?  ");//Menaka
				//26161 Start.
				//sql.append( "  ) FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA , (SELECT b.comments FROM cr_encounter_detail_txt b WHERE hist_rec_type = a.hist_rec_type AND contr_sys_id = a.contr_sys_id AND accession_num = a.accession_num AND contr_sys_event_code = a.contr_sys_event_code) comments, (SELECT b.compress_hist_data_yn FROM cr_encounter_detail_txt b WHERE hist_rec_type = a.hist_rec_type AND contr_sys_id = a.contr_sys_id AND accession_num = a.accession_num AND contr_sys_event_code = a.contr_sys_event_code) compress_hist_data_yn, (SELECT b.compress_hist_data FROM cr_encounter_detail_txt b WHERE hist_rec_type = a.hist_rec_type AND contr_sys_id = a.contr_sys_id AND accession_num = a.accession_num AND contr_sys_event_code = a.contr_sys_event_code) compress_hist_data, a.FACILITY_ID,a.ENCOUNTER_ID,a.PATIENT_CLASS,(select SHORT_NAME from am_practitioner where practitioner_id=a.PERFORMED_BY_ID) authorized_by_name,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_datetime ,dEcode(a.patient_class,'OP','O','EM' ,'O','I') Episode_type,(select FACILITY_NAME from sm_facility_param where facility_id=a.facility_id) facility_name,to_char(a.event_date,'dd/mm/yyyy hh24:mi') event_date,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,'"+locale+"','1') hist_rec_type_desc, a.encounter_ID, a.FACILITY_ID    from cr_encounter_detail a,cr_clin_event_mast b where a.HIST_REC_TYPE=b.HIST_REC_TYPE and b.event_code=a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type = ? and a.contr_sys_id =? and a.accession_num=? and a.contr_sys_event_code =?  ");
				sql.append( "  ) FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA , (SELECT b.comments FROM cr_encounter_detail_txt b WHERE hist_rec_type = a.hist_rec_type AND contr_sys_id = a.contr_sys_id AND accession_num = a.accession_num AND contr_sys_event_code = a.contr_sys_event_code) comments, (SELECT b.compress_hist_data_yn FROM cr_encounter_detail_txt b WHERE hist_rec_type = a.hist_rec_type AND contr_sys_id = a.contr_sys_id AND accession_num = a.accession_num AND contr_sys_event_code = a.contr_sys_event_code) compress_hist_data_yn, (SELECT b.compress_hist_data FROM cr_encounter_detail_txt b WHERE hist_rec_type = a.hist_rec_type AND contr_sys_id = a.contr_sys_id AND accession_num = a.accession_num AND contr_sys_event_code = a.contr_sys_event_code) compress_hist_data, a.FACILITY_ID,a.ENCOUNTER_ID,a.PATIENT_CLASS,(select SHORT_NAME from am_practitioner where practitioner_id=a.PERFORMED_BY_ID) authorized_by_name,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_datetime ,dEcode(a.patient_class,'OP','O','EM' ,'O','I') Episode_type,(select FACILITY_NAME from sm_facility_param where facility_id=a.facility_id) facility_name,to_char(nvl(a.RD_EXAM_DATE,a.event_date),'dd/mm/yyyy hh24:mi') event_date,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,'"+locale+"','1') hist_rec_type_desc, a.encounter_ID, a.FACILITY_ID    from cr_encounter_detail a,cr_clin_event_mast b where a.HIST_REC_TYPE=b.HIST_REC_TYPE and b.event_code=a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type = ? and a.contr_sys_id =? and a.accession_num=? and a.contr_sys_event_code =?  ");				
				//26161 End.
				//6484 Start.
			}

			ps = con.prepareStatement(sql.toString());

			if(histRecType.equals("CLNT"))
			{
				ps.setString(1,locale);
				ps.setString(2,locale);
				ps.setString(3,histRecType);
				ps.setString(4,contrSysId);
				ps.setString(5,accNum);
				ps.setString(6,contrSysEventCode);
			}
			else
			{
				ps.setString(1,histRecType);
				ps.setString(2,contrSysId);
				ps.setString(3,accNum);
				ps.setString(4,contrSysEventCode);
			}

			res = ps.executeQuery();
			
			if(histRecType.equals("CLNT"))
			{ 
				if(print_hdr_in_ceh_yn.equals("Y"))//IN029312
				{//IN029312
				displayData.append("<table width='100%' cellpadding=0 cellspacing=0 border='1'>");
				}//IN029312
				while(res.next())
				{
					clb = res.getClob("hist_data");
					eventDate = res.getString("event_date") == null ? "" : res.getString("event_date");
					histRecTypeDesc = res.getString("hist_rec_type_desc") == null ? "" : res.getString("hist_rec_type_desc");
					enctr_id= res.getString("encounter_ID") == null ? "" : res.getString("encounter_ID");
					fac_id= res.getString("FACILITY_ID") == null ? "" : res.getString("FACILITY_ID");
					cal_eventdate  = com.ehis.util.DateUtils.convertDate(eventDate,"DMYHM","en","en");//IN040090
					eventDate	   = com.ehis.util.DateUtils.convertDate(eventDate,"DMYHM","en",locale);
					
					//IN031989 Starts
					try{
						if(	episode_type.equals("O") )
						{
							
							//query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'2') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ?";
							//query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ?"; //IN045646 get_desc for specialty_name changed from 2 to 1 //comitted for IN067016
							//query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy') ,'') DISCHARGE_DATE_TIME_1,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ?"; //IN067016//commented for IN066807
							query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,ca_get_attend_pract_list(a.patient_id,a.encounter_id,a.facility_id)attending_pract_list,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy') ,'') DISCHARGE_DATE_TIME_1,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ?  ORDER BY A.VISIT_ADM_DATE_TIME DESC"; //IN066807
						}
						else
						{ 
							//query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'2') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? ";
							//query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? "; //IN045646 get_desc for specialty_name changed from 2 to 1//comitted for IN067016
							//query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy') ,'') DISCHARGE_DATE_TIME_1,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? "; //IN067016//commented for IN066807
							query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,ca_get_attend_pract_list(a.patient_id,a.encounter_id,a.facility_id)attending_pract_list,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy') ,'') DISCHARGE_DATE_TIME_1,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ?  ORDER BY A.VISIT_ADM_DATE_TIME DESC "; //IN066807
						}
				
						pstmt1	=	con.prepareStatement(query_privilege_type);
						
						pstmt1.setString	(	1,	locale	);
						pstmt1.setString	(	2,	locale	);
						pstmt1.setString	(	3,	locale	);
						pstmt1.setString	(	4,	locale	);
						pstmt1.setString	(	5,	performed_by_id	);
						pstmt1.setString	(	6,	locale	);
						pstmt1.setString	(	7,	locale	);			
						pstmt1.setString	(	8,	locale	);			
						pstmt1.setString	(	9,	locale	);			
						pstmt1.setString	(	10,	locale	);			
						//pstmt1.setString	(	11,	facilityId	);//IN033489
						pstmt1.setString	(	11,	fac_id	);//IN033489
						pstmt1.setString	(	12,	enctr_id);
									
						rs1		=	pstmt1.executeQuery();
				
						if(rs1.next())
						{
							patient_class	=	rs1.getString("patient_class") == null ? "" : rs1.getString("patient_class");
							facility_name			=	rs1.getString("facility_name") == null ? "" : rs1.getString("facility_name");
							visit_adm_date			=	rs1.getString("visit_adm_date")==null?"":rs1.getString("visit_adm_date");
							med_service			=	rs1.getString("service_name")==null?"":rs1.getString("service_name");
							discharge_date		=	rs1.getString("DISCHARGE_DATE_TIME")==null?"":rs1.getString("DISCHARGE_DATE_TIME");
							discharge_date_only		=	rs1.getString("DISCHARGE_DATE_TIME_1")==null?"":rs1.getString("DISCHARGE_DATE_TIME_1");//IN067016
							attending_practitioner	=	rs1.getString("attending_practitioner")==null?"":rs1.getString("attending_practitioner");
							attending_practitioner_list	=	rs1.getString("attending_pract_list")==null?"":rs1.getString("attending_pract_list");//IN066807
							admitting_practitioner	=	rs1.getString("admitting_practitioner")==null?"":rs1.getString("admitting_practitioner");
							//bed_number	=	rs1.getString("bed_number")==null?"":rs1.getString("bed_number");	  //--[IN:029839]--
							performing_phy_name	=	rs1.getString("performed_by_name")==null?"":rs1.getString("performed_by_name");
							age				=	rs1.getString("AGE")==null?"":rs1.getString("AGE");
							gender					=	rs1.getString("gender")==null?"":rs1.getString("gender");
							//nationality_id			=	rs1.getString("nationality")==null?"":rs1.getString("nationality");//IN070239//added duplicately so commented for IN071865
							//locationDesc			=	rs1.getString("location");
							location_code			=	rs1.getString("location_code")==null?"":rs1.getString("location_code");
							patient_name			=	rs1.getString("patient_name")==null?"":rs1.getString("patient_name");
							speciality_name			=	rs1.getString("specialty_name")==null?"":rs1.getString("specialty_name");
							printDateTime			=	rs1.getString("print_date_time")==null?"":rs1.getString("print_date_time");
							site_name			=	rs1.getString("site_name")==null?"":rs1.getString("site_name");
							//performed_by_desc			=	rs1.getString("performed_by_desc");
					

						
						}

						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					finally
					{
						if(rs1!=null)	rs1.close();
						if(pstmt1!=null)	pstmt1.close();
					}
					if("0".equals(enctr_id)){
						try{
							query_privilege_type	=	"SELECT  get_age (b.date_of_birth) age, DECODE (?,'en', b.patient_name, NVL (b.patient_name_loc_lang, b.patient_name)) patient_name, sex gender FROM mp_patient b WHERE  PATIENT_ID=? "; 
							
					
							pstmt1	=	con.prepareStatement(query_privilege_type);						
							pstmt1.setString	(	1,	locale	);
							pstmt1.setString	(	2,	patient_id	);
							rs1		=	pstmt1.executeQuery();
					
							if(rs1.next())
							{							
								age				=	rs1.getString("AGE")==null?"":rs1.getString("AGE");
								gender					=	rs1.getString("gender")==null?"":rs1.getString("gender");							
								patient_name			=	rs1.getString("patient_name")==null?"":rs1.getString("patient_name");
							}

							
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						finally
						{
							if(rs1!=null)	rs1.close();
							if(pstmt1!=null)	pstmt1.close();
						}
					}
					if(gender.equals("M"))
							Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					else if (gender.equals("F"))
							Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					else 
							Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

					if(discharge_date==null)
					{
						discharge_date="";
					}
					 //IN067016--Starts
							 if(discharge_date_only==null){
							 discharge_date_only="";
								 }
							 //IN067016--ends//
					if(patient_class.equals("OP"))
						patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
					else if(patient_class.equals("IP"))
						patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
					else if(patient_class.equals("EM"))
						patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
					else if(patient_class.equals("DC"))
						patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
					
					
					
					//IN031989 Ends
					//--[IN042733] - Start
		
					try{
						pstmt1	= con.prepareStatement("select patient_name patient_name,deceased_yn,to_Char(deceased_date,'dd/mm/yyyy hh24:mi') deceased_date from mp_patient where patient_id = ?");//IN040205
						pstmt1.setString(1,patient_id);
						rs1 = pstmt1.executeQuery();
				
						String deceased_yn="";
						String deceased_date = "";

						while(rs1.next())
						{
							default_pat_name	= rs1.getString("patient_name") == null ? "" : rs1.getString("patient_name");				
							deceased_yn			= rs1.getString("deceased_yn") == null ? "" : rs1.getString("deceased_yn");
							deceased_date		= rs1.getString("deceased_date") == null ? "" : rs1.getString("deceased_date");											
						}
						if(rs1 != null) rs1.close();
						if(pstmt1 != null) pstmt1.close();

						String event_date_time_isAfter = "";
						pstmt1	= con.prepareStatement("SELECT CASE WHEN TO_DATE (?, 'dd/mm/yyyy hh24:mi') > TO_DATE (?, 'dd/mm/yyyy hh24:mi') THEN 'Y'  ELSE 'N' END event_date_time_isAfter FROM DUAL");//IN040205
						pstmt1.setString(1,cal_eventdate);
						pstmt1.setString(2,deceased_date);

						rs1 = pstmt1.executeQuery();

						while(rs1.next())
						{
							event_date_time_isAfter = rs1.getString("event_date_time_isAfter");
						}

						if("Y".equals(event_date_time_isAfter))
						{
							cal_eventdate = com.ehis.util.DateUtils.convertDate(deceased_date,"DMYHM","en","en");
						}	
					}
					catch(Exception ee)
					{
						//out.println("Exceptionin EncountersPrint.jsp @ pstmt1 : "+ee.toString());//COMMON-ICN-0181
						ee.printStackTrace();
					}
					finally
					{
						if(rs1 != null) rs1.close();
						if(pstmt1 != null) pstmt1.close();
					}		
					//--[IN042733] - End
					try{
						//String head_foot_qry ="select a.FOOTER_CODE,a.REPORT_HEADER_CODE from ca_note_type a where  a.NOTE_TYPE=?";//IN032555
						String head_foot_qry ="select a.FOOTER_CODE,a.REPORT_HEADER_CODE ,a.DISCLIMER_CODE from ca_note_type a where  a.NOTE_TYPE=?";//IN032555
						pstmt2	= con.prepareStatement(head_foot_qry);
						pstmt2.setString(1,contrSysEventCode);
						rs2 = pstmt2.executeQuery();
						
						while(rs2.next())
						{
							//note_header_code = rs2.getString("NOTE_HEADER_CODE")==null?"":rs2.getString("NOTE_HEADER_CODE");
							footer_code = rs2.getString("FOOTER_CODE")==null?"":rs2.getString("FOOTER_CODE");
							report_header_code = rs2.getString("REPORT_HEADER_CODE")==null?"":rs2.getString("REPORT_HEADER_CODE");
							l_disclaimer_code = rs2.getString("DISCLIMER_CODE")==null?"":rs2.getString("DISCLIMER_CODE");//IN032555
						}
					}
					catch(Exception ee)
					{
						//out.println("Exceptionin RecClinicalNotesSection.jsp @ head_foot_qry : "+ee.toString());//COMMON-ICN-0181
						ee.printStackTrace();
					}
					finally
					{
						if(rs2 != null) rs2.close();
						if(pstmt2 != null) pstmt2.close();
					}
								
					try
					{
						sect_template_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
						pstmt2	= con.prepareStatement(sect_template_query);
						pstmt2.setString(1,report_header_code);
						rs2 = pstmt2.executeQuery();
						if(rs2.next())
						{
							clob_notes_content			=	(java.sql.Clob) rs2.getObject("TEMPLATE_FORMAT");							
							if(clob_notes_content!=null)
							{
								try
								{
									//content_reader		= ((oracle.sql.CLOB) clob_notes_content).getCharacterStream();
									content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
									bf_content_reader	= new java.io.BufferedReader(content_reader);
									char[] arr_notes_content = new char[(int)clob_notes_content.length()];
									bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
									section_content = new String(arr_notes_content);
									bf_content_reader.close();
									if(section_content == null)
										section_content = "";
								}
								catch(Exception e)
								{
									//out.println("Exception@1-readCLOB : "+e);//common-icn-0181
									e.printStackTrace();
								}
							}
						}
					}catch(Exception eee){
						//out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());//COMMON-ICN-0181
						eee.printStackTrace();
					}finally{
						if(rs2 != null) rs2.close();
						if(pstmt2 != null) pstmt2.close();						
					}
					if(!accNum.equals(""))
					{
						try
						{
							String athorise_by_qry ="select AM_GET_DESC.AM_PRACTITIONER(a.AUTHORIZED_BY_ID,?,'1') AUTHORIZED_BY_NAME,a.AUTHORIZED_BY_ID AUTHORIZED_BY_ID,AM_GET_DESC.AM_PRACTITIONER(a.LAST_AMENDED_BY_ID,?,'1') LAST_AMENDED_BY_ID,a.DOC_REF_ID,AM_GET_DESC.AM_PRACTITIONER(a.PERFORMED_BY_ID,?,'1') performed_by_name,AM_GET_DESC.AM_SERVICE(a.SERVICE_CODE,?,'2') service_name from CA_ENCNTR_NOTE a where a.ACCESSION_NUM = ? and a.PATIENT_ID = ? " ;

							pstmt2	= con.prepareStatement(athorise_by_qry);
							pstmt2.setString(1,locale);
							pstmt2.setString(2,locale);
							pstmt2.setString(3,locale);
							pstmt2.setString(4,locale);
							pstmt2.setString(5,accNum);
							pstmt2.setString(6,patient_id);
							rs2 = pstmt2.executeQuery();
							while(rs2.next())
							{
								//authorized_by		=	checkForNull( rs2.getString("AUTHORIZED_BY_ID") );
								//last_amended_by		=	checkForNull( rs2.getString("LAST_AMENDED_BY_ID") );
								//doc_ref_id		=	checkForNull( rs2.getString("DOC_REF_ID") );
								//authorized_by		=	rs2.getString("AUTHORIZED_BY_ID") ;
								//last_amended_by		=	rs2.getString("LAST_AMENDED_BY_ID");
								//doc_ref_id		=	 rs2.getString("DOC_REF_ID") ;
								authorized_by		=	rs2.getString("AUTHORIZED_BY_NAME")==null?"":rs2.getString("AUTHORIZED_BY_NAME") ;//IN030996
								authorized_by_id		=	rs2.getString("AUTHORIZED_BY_ID")==null?"":rs2.getString("AUTHORIZED_BY_ID") ;//IN030996
								last_amended_by		=	rs2.getString("LAST_AMENDED_BY_ID")==null?"":rs2.getString("LAST_AMENDED_BY_ID");//IN030996
								doc_ref_id		=	 rs2.getString("DOC_REF_ID")==null?"":rs2.getString("DOC_REF_ID") ;//IN030996
								
							}
						}
						catch (Exception roro )

						{
						//	out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+roro.toString());//COMMON-ICN-0181
							roro.printStackTrace();

						}
						finally 
						{
							if(rs2 != null) rs2.close();
							if(pstmt2 != null) pstmt2.close();
							
						}
						//IN069484 Start.
						try{
							pstmt2	= con.prepareStatement("SELECT PRACTITIONER_SIGN FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=?");
							pstmt2.setString(1,authorized_by_id);
							rs2 = pstmt2.executeQuery();
							while(rs2 !=null && rs2.next()){	
								java.sql.Blob img_blob  =  (java.sql.Blob)rs2.getBlob("PRACTITIONER_SIGN");
								if(img_blob!=null){//IN071865 starts
									byte[] bytes = img_blob.getBytes(1, (int)img_blob.length()); 										
									authorized_sign = new String(org.apache.commons.codec.binary.Base64.encodeBase64(bytes), "UTF-8");
								}//IN071865 ends
							}
						}catch(Exception se){
							se.printStackTrace();
						}finally
						{
							if(rs2 != null) rs2.close();
							if(pstmt2 != null) pstmt2.close();
						}
						//IN069484 End.
					}
					encounter_id1 = encounter_id ;
					if(encounter_id.equals("0"))
					{
						encounter_id1 ="";
					}

					if(!visit_adm_date.equals(""))
					{
						visit_adm_date					=	com.ehis.util.DateUtils.convertDate(visit_adm_date,"DMYHM","en",locale);
					}

					if(!discharge_date.equals(""))
					{
						discharge_date					=	com.ehis.util.DateUtils.convertDate(discharge_date,"DMYHM","en",locale);
					}
					//IN067016--Starts
					if(!discharge_date_only.equals(""))
				        {
					    discharge_date_only				=	com.ehis.util.DateUtils.convertDate(discharge_date_only,"DMY","en",locale);
				        }//IN067016--ends


					//IN032555, starts
					PreparedStatement l_disclaimPsmt = null;
					ResultSet l_disclaimRs = null;

					try
					{
						String l_disclaimer_query ="SELECT CA_GET_DESC.CA_DISCLIMER_TEXT(?,?,'1') DISCLAIMER_TEXT FROM DUAL";
						l_disclaimPsmt	= con.prepareStatement(l_disclaimer_query);
						l_disclaimPsmt.setString(1,l_disclaimer_code);
						l_disclaimPsmt.setString(2,locale);
						l_disclaimRs = l_disclaimPsmt.executeQuery();
						
						while(l_disclaimRs.next())
						{
							l_disclaimer_text = l_disclaimRs.getString("DISCLAIMER_TEXT")==null?"":l_disclaimRs.getString("DISCLAIMER_TEXT");
						}	
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					finally
					{
						if(l_disclaimRs != null) 
							l_disclaimRs.close();

						if(l_disclaimPsmt != null) 
							l_disclaimPsmt.close();
					}
					//IN032555, ends
					htParameter.put("V$ATT_PRACT", attending_practitioner);
					htParameter.put("V$ATT_PRACT_LT", attending_practitioner_list);//IN066807
					htParameter.put("V$ADM_PRACT", admitting_practitioner);
					htParameter.put("V$PT_SPLTY", speciality_name);
					//--[IN029296]  - Start
					if(patient_name.trim().equals(""))
						htParameter.put("V$PT_NAME", default_pat_name);
					else
						htParameter.put("V$PT_NAME", patient_name);
					//--[IN029296]  - End
					htParameter.put("V$PT_ID", patient_id);
					htParameter.put("V$SEX", Sex);
					htParameter.put("V$AGE", age);
					//htParameter.put("V$ENC_ID", encounter_id1);//IN031989
					//htParameter.put("V$ENC_ID", enctr_id);//IN031989//Commented for IN065886
					//IN065886 changes starts
					if(enctr_id.equals("0"))
						htParameter.put("V$ENC_ID", "");
					else
						htParameter.put("V$ENC_ID", enctr_id);
					//IN065886 Changes ends
					htParameter.put("V$ADM_DT", visit_adm_date); //visit_adm_date
					htParameter.put("V$DIS_DT", discharge_date); //discharge_date
					htParameter.put("V$DIS_DATE", discharge_date_only); //discharge_date_only//IN067016
					htParameter.put("V$MED_SERV", med_service);
					htParameter.put("V$DOC_REF_H", doc_ref_id);
					htParameter.put("V$PT_LOCN", location_code); //patient_loc
					htParameter.put("V$PT_CLASS", patient_class);//patient_class

					//sectionContentUpdatedXML = new StringBuffer();
					StringBuffer section_content_new = new StringBuffer(section_content);

					if (! locale.equals("en") )
					{
						if(!section_content_new.toString().equals(""))
						{
							paramMap = new HashMap<String,String>();
							paramMap.put("CURR_SEC_HDG_CODE",report_header_code);
							paramMap.put("LOCALE",locale);						
							paramMap.put("RANGE_PASER_YN","N");
							eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,section_content_new);
							section_content_new = tempLangParse.getLangReplacedXML();
							tempLangParse = null;
						}


					}
				
					if(!section_content_new.toString().equals(""))
					{
						//***************************** [CRF-118] Start *****************************					
						eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
						HashMap paramHash=new HashMap();
						Hashtable tempParameter=new Hashtable();
						paramHash.put("#p_patient_id#",patient_id);
						//IN042046 starts
						//paramHash.put("#p_encounter_id#",encounter_id1);
						paramHash.put("#p_encounter_id#",enctr_id);
						paramHash.put("#p_contr_mod_accession_num#",contr_mod_accession_num); 
						//IN042046 ends
						paramHash.put("#p_accNum#",accNum);
						paramHash.put("#p_locale#",locale);
						paramHash.put("#p_eventDate#",cal_eventdate);//IN039562//IN040090
						paramHash.put("#p_facility_id#",facilityId);//IN038439
						tempParameter = dynamicCompDetails.getDynamicCompDetails(section_content_new,paramHash);								
						if(tempParameter.size()>0){					
						htParameter.putAll(tempParameter);
						}
						//*****************************[CRF-118] Ends *****************************
						sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
					}

					if(!(sectionContentUpdatedXML.toString().equals("")))
					{								
						section_content_rpt=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);
						//section_content_rpt=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),"eCA/html/RecClinicalNotesTemplateDispayView.xsl");
						
					}
					//Report Header Ends
					
					// changes notes footer starts
					section_content= "";

					try
					{
						//String footer_sect_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
						pstmt2	= con.prepareStatement(sect_template_query);
						pstmt2.setString(1,footer_code);
						rs2 = pstmt2.executeQuery();
						if(rs2.next())
						{			
							clob_notes_content			=	(java.sql.Clob) rs2.getObject("TEMPLATE_FORMAT");
							if(clob_notes_content!=null)
							{
								try
								{
									//content_reader		= ((oracle.sql.CLOB) clob_notes_content).getCharacterStream();
									content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
									bf_content_reader	= new java.io.BufferedReader(content_reader);
									char[] arr_notes_content = new char[(int)clob_notes_content.length()];
									bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
									section_content = new String(arr_notes_content);
									bf_content_reader.close();
								
									if(section_content == null)
									section_content = "";
								}
								catch(Exception e)
								{
									//out.println("Exception@1-readCLOB : "+e);//common-icn-0181
									e.printStackTrace();
								}
							}
						}
					}catch(Exception eee){
						//out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());//COMMON-ICN-0181
						eee.printStackTrace();

					}finally{
						if(rs2 != null) rs2.close();
						if(pstmt2 != null) pstmt2.close();
					}

					if(!printDateTime.equals(""))
					{
						printDateTime					=	com.ehis.util.DateUtils.convertDate(printDateTime,"DMYHM","en",locale);
					}

					htParameter=new Hashtable();
					htParameter.put("V$CUR_USR", login_user_id);
					htParameter.put("V$AT_PRACT", authorized_by);
					htParameter.put("V$AT_PRACT_SIGN", authorized_sign); //IN069484
					htParameter.put("V$LT_MODI_USR", last_amended_by);
					htParameter.put("V$PRN_DTTIME", printDateTime);//printDateTime
					htParameter.put("V$DOC_REF_F", doc_ref_id);
					htParameter.put("V$LT_PT_P_C_D", pract_sign);

					section_content_new = new StringBuffer(section_content);
					//IN038439 Start
					if((!section_content_new.toString().equals("&nbsp;"))&& (!section_content_new.toString().equals("")))
					{													
						eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
						HashMap paramHash=new HashMap();
						Hashtable tempParameter=new Hashtable();
					
						paramHash.put("#p_contr_mod_accession_num#",contr_mod_accession_num); 
						paramHash.put("#p_accNum#",accNum);
						paramHash.put("#p_locale#",locale);
						paramHash.put("#p_pract_id#",clinician_id);
						tempParameter = dynamicCompDetails.getDynamicCompDetails(section_content_new,paramHash);	
						if(tempParameter.size()>0)
						{					
							htParameter.putAll(tempParameter);
						}
					}
				  //IN038439 Ends
					sectionContentUpdatedXML = new StringBuffer();
	
					if (! locale.equals("en") )
					{
						if(!section_content_new.toString().equals(""))
						{
							paramMap = new HashMap<String,String>();
							paramMap.put("CURR_SEC_HDG_CODE",footer_code);
							paramMap.put("LOCALE",locale);						
							paramMap.put("RANGE_PASER_YN","N");
							eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,section_content_new);
							section_content_new = tempLangParse.getLangReplacedXML();
							tempLangParse = null;
						}

					}				
				
					if(!section_content_new.toString().equals(""))
					{
						sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
					}
			
					if(!(sectionContentUpdatedXML.toString().equals("")))
					{	
						section_content_ftr=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);
					}
					//Footer Ends					
			
					if(print_hdr_in_ceh_yn.equals("Y"))//IN029312
					{
						if(!prevHistRecType.equals(histRecType))
						{
							if(!histRecTypeDesc.equals(""))
								displayData.append("<TR><TD colspan='4' class='spanId1'><B>"+histRecTypeDesc+"</B></TD></TR>");
						}

						if(!prevEventDate.equals(eventDate))
						{
							displayData.append("<TR><TD colspan='4' class='spanId2'><B>&nbsp;"+eventDate+"</B></TD></TR>");
						}
							
						displayData.append("</TABLE>");
					}//IN029312
					//6484 Start.
					if("Y".equals(res.getString("compress_hist_data_yn")==null?"":(String)res.getString("compress_hist_data_yn"))){
						
						java.sql.Blob note_blob =  (java.sql.Blob)res.getBlob("compress_hist_data");
						if(note_blob!=null && note_blob.length()>0){
							InputStream ins1 = note_blob.getBinaryStream();
							ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
							int g;
							while((g = ins1.read()) != -1) 
								bytearrayoutputstream.write(g);
							
							byte[] compressed	=bytearrayoutputstream.toByteArray();
							if(compressed.length > 0){
								if((compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) && (compressed[1] == (byte) (GZIPInputStream.GZIP_MAGIC >> 8))){
									GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressed));
									BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gis, "UTF-8"));

									String line;
									while ((line = bufferedReader.readLine()) != null) {
										displayDataTemp.append(line);
									}
								}					
							}	
						}
						displayDataTemp.append((res.getString("comments")==null?"":(String)res.getString("comments")));
					}else{	
					//6484 End.
						if( (clb!=null) && (clb.length()>0) )
						{
							displayDataTemp.append(clb.getSubString(1,((int)clb.length())));
							
						}	
						displayDataTemp.append((res.getString("comments")==null?"":(String)res.getString("comments")));
					}//6484
					//displayData.append("<TR><TD class='"+classValue+"' colspan='4'>"+displayDataTemp.toString()+"</TD></TR>");
					displayData.append("<table border='2'cellpadding='0' cellspacing='4' width='100%'><tr><td>"+section_content_rpt+"</td></tr></table><BR>");//INO30714
					displayData.append(displayDataTemp.toString());
					displayData.append("<table border='2'cellpadding='0' cellspacing='4' width='100%'><tr><td>"+section_content_ftr+"</td></tr></table><BR>");//INO30714
					displayDataTemp.delete(0,displayDataTemp.length());
				}
				if(res != null) res.close();
				if(ps != null) ps.close();
			}
			else
			{
				if(print_hdr_in_ceh_yn.equals("Y"))//IN029312
				{
					displayData.append("<table width='100%' cellpadding=0 cellspacing=0 border='1'>");				
				}//IN029312
				String longDesc = "";
				clb = null;
				while (res.next())
				{					
					longDesc = res.getString("long_desc") == null ? "" : res.getString("long_desc");
					resultNum = res.getString("RESULT_NUM") == null ? "" : res.getString("RESULT_NUM");
					resultStr = res.getString("RESULT_STR") == null ? "" : res.getString("RESULT_STR");
					//IN054648 Start.
					resultStr  = resultStr.replaceAll("<","&lt;");
					resultStr  = resultStr.replaceAll(">","&gt;");
					//IN054648 End.
					histDataType = res.getString("HIST_DATA_TYPE") == null ? "" : res.getString("HIST_DATA_TYPE");
					eventDate = res.getString("event_date") == null ? "" : res.getString("event_date");
					histRecTypeDesc = res.getString("hist_rec_type_desc") == null ? "" : res.getString("hist_rec_type_desc");
					eventDate	= com.ehis.util.DateUtils.convertDate(eventDate,"DMYHM","en",locale);
					normalcyInd = res.getString("NORMALCY_IND") == null ? "" : res.getString("NORMALCY_IND");//IN069290
					if(print_hdr_in_ceh_yn.equals("Y"))//IN029312
					{//IN029312
						if(!prevHistRecType.equals(histRecType))
						{
							if(!histRecTypeDesc.equals(""))
								displayData.append("<TR><TD colspan='4' class='spanId1'><B>"+histRecTypeDesc+"</B></TD></TR>");
						}
						if(!prevEventDate.equals(eventDate))
						{
							displayData.append("<TR><TD colspan='4' class='spanId2'><B>&nbsp;"+eventDate+"</B></TD></TR>");
						}
					}//IN029312
					//IN069290 STARTS
					if(isViewLabRes&&!histDataType.equals("HTM") && !histDataType.equals("TXT")&&histrectype1.equals("LBIN"))
					{
						displayData.append("<table width='100%' cellpadding=0 cellspacing=0 border='1'><TR>");
					}
					clb = res.getClob("hist_data");
					histrectype1 = res.getString("HIST_REC_TYPE")==null?"":res.getString("HIST_REC_TYPE"); 
					if(isViewLabRes &&!histDataType.equals("HTM") && !histDataType.equals("TXT")&&!histDataType.equals("STR")&&histrectype1.equals("LBIN"))
					{	
						displayData.append("<Th class='"+classValue+"' width='25%'>&nbsp;Test</Th>");
						displayData.append("<Th class='"+classValue+"' width='25%'>&nbsp;Result</Th>");
						displayData.append("<Th class='"+classValue+"' width='15%'>&nbsp;Unit</Th>");
						displayData.append("<Th class='"+classValue+"' width='25%'>&nbsp;Reference Range</Th>");
						displayData.append("</TR><TR>");
						displayData.append("<TD class='"+classValue+"'width='25%'&nbsp;>");
						displayData.append("<table width='100%' cellpadding=0 cellspacing=0 border='1 '><TR>");
						displayData.append("<TD class='"+classValue+"' width='25%'>&nbsp;"+longDesc+"</TD>");
						displayData.append("<TD class='"+classValue+"' style='text-align:right' width='25%' >&nbsp;"+normalcyInd+"</TD>");
						displayData.append("</TR></table></TD>");
					}
					else
						if(isViewLabRes &&!histDataType.equals("HTM") && !histDataType.equals("TXT")&&!histDataType.equals("STR")&&!histrectype1.equals("LBIN"))
						{	
							displayData.append("<TD class='"+classValue+"' width='25%'>&nbsp;"+longDesc+"</TD>");
							displayData.append("<TD class='"+classValue+"' width='1%'>");
							displayData.append("&nbsp;: ");
							displayData.append("</TD>");
						}
					if(isViewLabRes&&histDataType.equals("STR"))
					{
						displayData.append("<TD class='"+classValue+"' width='25%'>&nbsp;"+longDesc+"</TD>");
						displayData.append("<TD class='"+classValue+"' width='1%'>");
						displayData.append("&nbsp;: ");
						displayData.append("</TD>");
						
					}//IN069290 ENDS
					else if(!isViewLabRes && !histDataType.equals("HTM") && !histDataType.equals("TXT"))
					{
						displayData.append("<TR><TD class='"+classValue+"' width='1%'>&nbsp;</TD>");
						displayData.append("<TD class='"+classValue+"' width='15%'>");
						//[IN032246] Start.
						//displayData.append(longDesc);
						displayData.append("<PRE style='word-wrap:break-word;'>"+longDesc+"</PRE>");
						displayData.append("</TD>");
						//[IN032246] End.
						displayData.append("<TD class='"+classValue+"' width='1%'>");
						displayData.append("&nbsp;: ");
						displayData.append("</TD>");
						//displayData.append("<TD class='"+classValue+"' width='25%'>");
					}//IN069290 ENDS
					if(histDataType.equals("TXT"))
					{
						displayData.append("<TD class='"+classValue+"' width='1%'>&nbsp;</TD>");
						displayData.append("<TD class='"+classValue+"' width='15%'>");
						//[IN032246] Start
						//displayData.append(longDesc);
						displayData.append("<PRE style='word-wrap:break-word;'>"+longDesc+"</PRE>");
						//[IN032246] End.
						displayData.append("</TD>");
					}
					
					if(histDataType.equals("NUM"))
					{
						//IN069290 STARTS
						if(isViewLabRes&&!("LBIN".equals(histrectype1)))
						{
						displayData.append("<TD class='"+classValue+"' width='25%'>");
						}//IN069290 ENDS
						//IN063813 Starts
						String normalrange1="";
						String normalrange2="";
						String normalrange = " - ";
						String range="";
						String range1="";//IN069290
						String criticalrange = " - ";
						String result_uom ="";
						String Normal_Range = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NormalRange.label","ca_labels");
						String Critical_Range = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Critical.label","common_labels");
						StringBuffer toolTip = new StringBuffer();
						String performed_by = "";
						performed_by = res.getString("clinician_short_name")==null?"":res.getString("clinician_short_name");
						resulted_practitioner = res.getString("resulted_practitioner")==null?"":res.getString("resulted_practitioner"); //IN064132
						histrectype1 = res.getString("HIST_REC_TYPE")==null?"":res.getString("HIST_REC_TYPE"); //IN064132

						String criticalrange1="";
						String criticalrange2="";
						criticalrange1 = res.getString("CRITICAL_LOW");
						if (criticalrange1 == null) criticalrange1 = "";

						criticalrange2 = res.getString("CRITICAL_HIGH");
						if (criticalrange2 == null) criticalrange2 = "";
				
						BigDecimal rn1 =res.getBigDecimal("RESULT_NUM_VALUE");
						if(rn1!=null)
							resultNum=rn1.toString();
						else
							resultNum="";

						BigDecimal nl =res.getBigDecimal("NORMAL_LOW");
						if(nl!=null)
							normalrange1=nl.toString();
						else
							normalrange1="";
						BigDecimal nh =res.getBigDecimal("NORMAL_HIGH");
						if(nh!=null)
							normalrange2=nh.toString();
						else
							normalrange2="";
	
						String numFormat = "&nbsp;&nbsp;&nbsp;&nbsp;";
						String res_num="&nbsp;&nbsp;&nbsp;&nbsp;";//IN069290
						String res_prefix="&nbsp;&nbsp;&nbsp;&nbsp;";//IN021509
						if(res.getString("RESULT_NUM_PREFIX") != null && !(res.getString("RESULT_NUM_PREFIX")).equals(""))
						{
							numFormat= numFormat +  res.getString("RESULT_NUM_PREFIX");
							res_prefix = res_prefix+res.getString("RESULT_NUM_PREFIX"); //IN021509
						}
						if(!isViewLabRes)//IN069290 STARTS
						{
						numFormat= numFormat +  "&nbsp;&nbsp;&nbsp;&nbsp;"+ resultNum +"  "+( res.getString("RESULT_NUM_UOM")==null?"":res.getString("RESULT_NUM_UOM"));
						}
						else if(isViewLabRes&&"LBIN".equals(histrectype1))
							res_num= ( res.getString("RESULT_NUM_UOM")==null?"":res.getString("RESULT_NUM_UOM"));
							else
							     numFormat= numFormat +  "&nbsp;&nbsp;&nbsp;&nbsp;"+ resultNum +"  "+( res.getString("RESULT_NUM_UOM")==null?"":res.getString("RESULT_NUM_UOM"));
					
						
						result_uom = res.getString("RESULT_NUM_UOM")==null?"":res.getString("RESULT_NUM_UOM");
					
						if(isViewLabRes&&"LBIN".equals(histrectype1)){
							//displayData.append(resultNum);
							displayData.append("<TD class='"+classValue+"' width='15%'>"+res_prefix+"&nbsp;"+resultNum+"</TD>");
							displayData.append("<TD class='"+classValue+"' width='15%'>&nbsp;"+res_num+"</TD>");
						}
							//displayData.append("<TD  class='"+classValue+"' width='10%'>&nbsp;"+resultNum+"</TD>");
						
							result_uom = res.getString("RESULT_NUM_UOM")==null?"":res.getString("RESULT_NUM_UOM");
							if(!isViewLabRes)
							{
								if(!normalrange1.equals("") && !normalrange2.equals(""))
									normalrange = Normal_Range + " : " + normalrange1 + " - " + normalrange2 + " " + result_uom;
								else if(!normalrange1.equals("") && normalrange2.equals(""))
									normalrange = Normal_Range + " : (>=" + normalrange1 + " " + result_uom + ")";
								else if(normalrange1.equals("") && !normalrange2.equals(""))
									normalrange = Normal_Range + " : (<=" + normalrange2 + " " + result_uom + ")";
								else
									normalrange = "";
							
								if(!criticalrange1.equals("") && !criticalrange2.equals(""))
								{
									criticalrange = Critical_Range + " : " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Low.label","common_labels")+"(<"+ criticalrange1 + " " + result_uom+") & "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels")+"(>" + criticalrange2 + " " + result_uom+")" ;
								}
								else if(!criticalrange1.equals("") && criticalrange2.equals(""))
								{
									criticalrange = Critical_Range + " : " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Low.label","common_labels")+"(<"+ criticalrange1 + " " + result_uom+")" ;
								}
								else if(criticalrange1.equals("") && !criticalrange2.equals(""))
								{
									criticalrange = Critical_Range + " : " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels")+"(>" + criticalrange2 + " " + result_uom+")" ;
								}
								else
									criticalrange = "";
											
								if(!normalrange.equals("") && !criticalrange.equals(""))
									toolTip.append(normalrange+"<br>"+criticalrange);
								else if(!normalrange.equals(""))
									toolTip.append(normalrange);
								else if(!criticalrange.equals(""))
									toolTip.append(criticalrange);
								else
									toolTip.append("");
							}
							else if(isViewLabRes&&"LBIN".equals(histrectype1))
							{
								if(!normalrange1.equals("") && !normalrange2.equals(""))
									normalrange =  normalrange1 + " - " + normalrange2 ;
								else if(!normalrange1.equals("") && normalrange2.equals(""))
									normalrange =  "  (>=" + normalrange1 + " " +")";
								else if(normalrange1.equals("") && !normalrange2.equals(""))
									normalrange =  "  (<=" + normalrange2 + " " +")";
								else
									normalrange = "";
								if(!criticalrange1.equals("") && !criticalrange2.equals(""))
								{
									criticalrange = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Low.label","common_labels")+"(<"+ criticalrange1 + " " + result_uom+") & "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels")+"(>" + criticalrange2 + " " + result_uom+")" ;
								}
								else if(!criticalrange1.equals("") && criticalrange2.equals(""))
								{
									criticalrange =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Low.label","common_labels")+"(<"+ criticalrange1 + " " + result_uom+")" ;
								}
								else if(criticalrange1.equals("") && !criticalrange2.equals(""))
								{
									criticalrange = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels")+"(>" + criticalrange2 + " " + result_uom+")" ;
								}
								else
									criticalrange = "";
											
								if(!normalrange.equals("") && !criticalrange.equals(""))
									toolTip.append(normalrange+" "+criticalrange);
								else if(!normalrange.equals(""))
									toolTip.append(normalrange);
								else if(!criticalrange.equals(""))
									toolTip.append(criticalrange);
								else
									toolTip.append("");
								
							}
							else
							{
								if(!normalrange1.equals("") && !normalrange2.equals(""))
									normalrange = Normal_Range + " : " + normalrange1 + " - " + normalrange2 + " " + result_uom;
								else if(!normalrange1.equals("") && normalrange2.equals(""))
									normalrange = Normal_Range + " : (>=" + normalrange1 + " " + result_uom + ")";
								else if(normalrange1.equals("") && !normalrange2.equals(""))
									normalrange = Normal_Range + " : (<=" + normalrange2 + " " + result_uom + ")";
								else
									normalrange = "";
							
								if(!criticalrange1.equals("") && !criticalrange2.equals(""))
								{
									criticalrange = Critical_Range + " : " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Low.label","common_labels")+"(<"+ criticalrange1 + " " + result_uom+") & "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels")+"(>" + criticalrange2 + " " + result_uom+")" ;
								}
								else if(!criticalrange1.equals("") && criticalrange2.equals(""))
								{
									criticalrange = Critical_Range + " : " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Low.label","common_labels")+"(<"+ criticalrange1 + " " + result_uom+")" ;
								}
								else if(criticalrange1.equals("") && !criticalrange2.equals(""))
								{
									criticalrange = Critical_Range + " : " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels")+"(>" + criticalrange2 + " " + result_uom+")" ;
								}
								else
									criticalrange = "";
											
								if(!normalrange.equals("") && !criticalrange.equals(""))
									toolTip.append(normalrange+" "+criticalrange);
								else if(!normalrange.equals(""))
									toolTip.append(normalrange);
								else if(!criticalrange.equals(""))
									toolTip.append(criticalrange);
								else
									toolTip.append("");
							}
							
							if(isViewLabRes&&"LBIN".equals(histrectype1))
							{
								 range1=toolTip.toString();
								displayData.append("<TD class='"+classValue+"' width='25%'>&nbsp;"+range1+"</TD>");
								
							}
							//IN069290 ENDS
							//IN064132 changes starts
							/*
							if(!performed_by.equals(""))
							{
								if(!(toolTip.toString()).equals(""))
									toolTip.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Performed.label","common_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels")+" : "+ performed_by );
							}
							*/
							//IN069290 STARTS
							if(!isViewLabRes&& isPracSiteSpecific && "LBIN".equals(histrectype1))
							{
								if(!resulted_practitioner.equals(""))
								{	
									if(!(toolTip.toString()).equals(""))
										toolTip.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Performed.label","common_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels")+" : "+ resulted_practitioner );
								}
							}
							else if(isViewLabRes&& isPracSiteSpecific && "LBIN".equals(histrectype1)&&!restrctDispPerformedBy)
							{
								if(!resulted_practitioner.equals(""))
								{	
									if(!(toolTip.toString()).equals(""))
										toolTip.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Performed.label","common_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels")+" : "+ resulted_practitioner );
								}
							}
							else{
								if(!isViewLabRes&&!performed_by.equals("") &&!restrctDispPerformedBy)
								{
									if(!(toolTip.toString()).equals(""))
										toolTip.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Performed.label","common_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels")+" : "+ performed_by );
								}
								if(isViewLabRes&&!performed_by.equals(""))
								{
									if(!(toolTip.toString()).equals(""))
										toolTip.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Performed.label","common_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels")+" : "+ performed_by );
								}
							}
						if(isViewLabRes&&"LBIN".equals(histrectype1))
						{
							displayData.append("</TD></TR></table>");
						}
						else
						{
							range = toolTip.toString();
							if("".equals(range))
								resultNum = numFormat ;
							else
								resultNum = numFormat  +"<br><br>"+range+"<br><br>"; 
							//IN063813 Ends
							if(isViewLabRes&&!("LBIN".equals(histrectype1)))
							{
								displayData.append(resultNum+"</TD>");//ML-MMOH-CRF-1317
							}
							else
								displayData.append("<TD class='"+classValue+"' colspan='3'>&nbsp;"+resultNum+"</TD>");//ML-MMOH-CRF-1317
						
							if(!resultStr.equals(""))
							{
								displayData.append("</TR>");
								displayData.append("<TR>");
								displayData.append("<TD class='"+classValue+"' >&nbsp;</TD>");
								displayData.append("<TD class='"+classValue+"' colspan='3'>");
								//[IN032246] Start.
								//displayData.append("&nbsp;"+resultStr+"</TD>");
								displayData.append("&nbsp;<PRE class='RESULTTEXTAREAEVEN'>"+resultStr+"</PRE>");
								//[IN032246] End.
							}//IN069290 ENDS
						}
						if((clb!=null) && (clb.length()>0))
						{
							displayData.append("</TR>");
							displayData.append("<TR>");
							displayData.append("<TD class='"+classValue+"'>&nbsp;</TD>");
							displayData.append("<TD class='"+classValue+"'  colspan='3'>");
							//[IN039361] Start.
							if((clb!=null) && (clb.length()>0)){
								String tempsplit[] = (clb.getSubString(1,((int)clb.length()))).split("\n");							
								int indicate=0;
								int indicator=0;
								for(int n = 0; n < tempsplit.length; n++){
									String tempRow=tempsplit[n];
									if(n>0 && n < (tempsplit.length -1) && indicate==0){
										if(((tempsplit[n-1]).contains("-"))&&((tempsplit[n+1]).contains("-")))
										{
											indicate=indicate++;
											indicator=n;
										}
									}
									if(!(tempRow.length()>120)){								
										
										displayData.append("<PRE  style='word-wrap:break-word;'>"+tempRow+"</PRE>");
																					
										if(tempRow.length()>0 && !tempRow.contains("-") && indicator!=n )
											displayData.append("\n");	
									}else{
										StringBuffer br = new StringBuffer(tempRow);
										StringBuffer tempStr = new StringBuffer();
										int k = 0;
										for(int q = 0; q < br.length(); q++)
										{
											if( q == (k+120))											
											{
												String st = br.substring(k,q);													
												tempStr.append(st);
												tempStr.append("\n");													
												k += 120; 
											}
										}
										displayData.append("<PRE  style='word-wrap:break-word;'>"+tempStr+br.substring(k, br.length())+"</PRE>");
																					
										if(tempRow.length()>0 && !tempRow.contains("-") && indicator!=n)
											displayData.append("\n");
									}
								}
							}
							//displayData.append("<PRE class='RESULTTEXTAREAEVEN'>"+clb.getSubString(1,((int)clb.length()))+"</PRE>"); //--[IN032246]
							//[IN039361] End.
							displayData.append("</TD>");
						}
						else
						{
							displayData.append("</TR>");
							displayData.append("<TR>");
							displayData.append("<TD class='"+classValue+"' colspan='4'>&nbsp;</TD>");
						}
					}
					else if(histDataType.equals("STR"))
					{
						//IN069290 STARTS
						if(isViewLabRes&&"LBIN".equals(histrectype1))
						{
							displayData.append("<TD  colspan=3 class='"+classValue+"' width='25%'>");
						}
						else{
						  displayData.append("<TD class='"+classValue+"' width='25%'>");
						}
						//[IN032246] Start.
						//displayData.append("&nbsp;"+resultStr);
						displayData.append("&nbsp;<PRE class='RESULTTEXTAREAEVEN'>"+resultStr+"</PRE>");
						//[IN032246] End.
						displayData.append("</TD>");
						//IN069290 ENDS
						
						
						
						if((clb!=null) && (clb.length()>0))
						{
							displayData.append("</TR>");
							displayData.append("<TR>");
							displayData.append("<TD class='"+classValue+"'>&nbsp;</TD>");
							displayData.append("<TD class='"+classValue+"'  colspan='3'>");
							//[IN039361] Start.
							if((clb!=null) && (clb.length()>0)){
								String tempsplit[] = (clb.getSubString(1,((int)clb.length()))).split("\n");							
								int indicate=0;
								int indicator=0;
								for(int n = 0; n < tempsplit.length; n++){
									String tempRow=tempsplit[n];
									if(n>0 && n < (tempsplit.length -1) && indicate==0){
										if(((tempsplit[n-1]).contains("-"))&&((tempsplit[n+1]).contains("-")))
										{
											indicate=indicate++;
											indicator=n;
										}
									}
									if(!(tempRow.length()>120)){								
										
										displayData.append("<PRE  style='word-wrap:break-word;'>"+tempRow+"</PRE>");
																					
										if(tempRow.length()>0 && !tempRow.contains("-") && indicator!=n )
											displayData.append("\n");	
									}else{
										StringBuffer br = new StringBuffer(tempRow);
										StringBuffer tempStr = new StringBuffer();
										int k = 0;
										for(int q = 0; q < br.length(); q++)
										{
											if( q == (k+120))											
											{
												String st = br.substring(k,q);													
												tempStr.append(st);
												tempStr.append("\n");													
												k += 120; 
											}
										}
										displayData.append("<PRE  style='word-wrap:break-word;'>"+tempStr+br.substring(k, br.length())+"</PRE>");
																					
										if(tempRow.length()>0 && !tempRow.contains("-") && indicator!=n)
											displayData.append("\n");
									}
								}
							}
							//displayData.append("<PRE class='RESULTTEXTAREAEVEN'>"+clb.getSubString(1,((int)clb.length()))+"</PRE>");//--[IN032246]
							//[IN039361] End.
							displayData.append("</TD>");
						}
						else
						{
							displayData.append("</TR>");
							displayData.append("<TR>");
							displayData.append("<TD class='"+classValue+"' colspan='4'>&nbsp;</TD>");
						}
					}

					//if((histDataType.equals("HTM") || histDataType.equals("TXT")))//IN030859
					if(histDataType.equals("HTM"))//IN030859
					{						
							displayData.append("</TR>");
							displayData.append("<TR>");							
							displayData.append("<TD class='"+classValue+"'  colspan='2' width='1220px;'><PRE  style='word-wrap:break-word;'>");
							displayData.append("<table border='2'cellpadding='0' cellspacing='4' width='100%'><tr><td>"+section_content_rpt+"</td></tr></table><BR>");//INO30714
							//6484 Start.
							String displayDataTemp_="";
							
							if("Y".equals(res.getString("compress_hist_data_yn")==null?"":(String)res.getString("compress_hist_data_yn"))){
								StringBuffer tempBuffer = new StringBuffer();
								java.sql.Blob img_blob =  (java.sql.Blob)res.getBlob("compress_hist_data");
								if(img_blob!=null && img_blob.length()>0){
									InputStream ins1 = img_blob.getBinaryStream();
									ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
									int g;
									while((g = ins1.read()) != -1) 
										bytearrayoutputstream.write(g);
									
									byte[] compressed	=bytearrayoutputstream.toByteArray();
									if(compressed.length > 0){
										if((compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) && (compressed[1] == (byte) (GZIPInputStream.GZIP_MAGIC >> 8))){
											GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressed));
											BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gis, "UTF-8"));

											String line;
											while ((line = bufferedReader.readLine()) != null) {
												tempBuffer.append(line+"\n");
											}
										}					
									}								
									displayDataTemp_ = tempBuffer.toString();
								}
							}else{
								if((clb!=null) && (clb.length()>0)){
									displayDataTemp_ = (String)(clb.getSubString(1,((int)clb.length())));								
								}
							}
							//6484 End. 
							displayDataTemp_=displayDataTemp_+((res.getString("comments")==null?"":(String)res.getString("comments"))); //6484.							
							if(!"".equals(displayDataTemp_)){	
								displayDataTemp_=displayDataTemp_.replaceAll("<div align=\"left\"><address><font size=\"3\"></font>&nbsp;</address></div>","");
								Document doc = Jsoup.parse(displayDataTemp_);	
								Element link = doc.body();									
								String tempsplit[] = (link.toString()).split("\n");								
								int indicate=0;
								int indicator=0;
								for(int n = 0; n < tempsplit.length; n++){
									String tempRow=((String)(tempsplit[n])).trim();
									if((tempRow.length())>0){
										if(n>0 && n < (tempsplit.length -1) && indicate==0){
											if(((tempsplit[n-1]).contains("-"))&&((tempsplit[n+1]).contains("-")))
											{
												indicate=indicate++;
												indicator=n;
											}
										}						
										
										displayData.append(tempRow);
																					
										if(tempRow.length()>0 && !tempRow.contains("-") && indicator!=n )
											displayData.append("\n");
									}
									
								}								
							}
							
							displayData.append("<table border='2'cellpadding='0' cellspacing='4' width='100%'><tr><td>"+section_content_ftr+"</td></tr></table><BR>");//INO30714
							displayData.append("</PRE></TD>");
						
					}
					else if(histDataType.equals("TXT"))//IN030859 Starts
					{
						if((clb!=null) && (clb.length()>0))
						{
							displayData.append("</TR>");
							displayData.append("<TR>");
							displayData.append("<TD class='"+classValue+"'>&nbsp;</TD>");
							displayData.append("<TD class='"+classValue+"'  colspan='3'>");
							//[IN039361] Start.
							//displayData.append(clb.getSubString(1,((int)clb.length())));							
							String tempsplit[] = (clb.getSubString(1,((int)clb.length()))).split("\n");							
							int indicate=0;
							int indicator=0;
							int truncateChar = 115; //IN056330
							for(int n = 0; n < tempsplit.length; n++){
								String tempRow=tempsplit[n];
								if(n>0 && n < (tempsplit.length -1) && indicate==0){
									if(((tempsplit[n-1]).contains("-"))&&((tempsplit[n+1]).contains("-")))
									{
										indicate=indicate++;
										indicator=n;
									}
								}
								if(!(tempRow.length()>truncateChar)){								
									
									displayData.append("<PRE  style='word-wrap:break-word;'>"+tempRow+"</PRE>");
																				
									if(tempRow.length()>0 && !tempRow.contains("-") && indicator!=n )
										displayData.append("\n");	
								}else{
									StringBuffer br = new StringBuffer(tempRow);
									StringBuffer tempStr = new StringBuffer();
									int k = 0;
									for(int q = 0; q < br.length(); q++)
									{
										if( q == (k+truncateChar))											
										{
											String st = br.substring(k,q);													
											tempStr.append(st);
											tempStr.append("\n");													
											k += truncateChar; 
										}
									}
									displayData.append("<PRE  style='word-wrap:break-word;'>"+tempStr+br.substring(k, br.length())+"</PRE>");
																				
									if(tempRow.length()>0 && !tempRow.contains("-") && indicator!=n)
										displayData.append("\n");
								}
							}
							//[IN039361] End.	
							displayData.append("</TD>");
						}
						else
						{
							displayData.append("</TR>");
							displayData.append("<TR>");
							displayData.append("<TD class='"+classValue+"' colspan='4'>&nbsp;</TD>");
						}
					}//IN030859 Ends
					displayData.append("</TR>");
				}
				displayData.append("</TABLE>");				
				if(res != null) res.close();
				if(ps != null) ps.close();
			}
			prevEventDate = eventDate;
			prevHistRecType = histRecType;
			enc_id_prev = enc_id;
			if(siteHeader){//IN071865 starts
				displayData.append(dispData1);
				count++;//IN071865
				if(listSize!=count)//IN071865
					displayData.append("<P style='page-break-before: always'> ");
			}//IN071865 ends
		}	
		if(pstmt != null) pstmt.close();
	}
	catch(Exception e)
	{		
		//out.println("Exception in try of EncountersEmailDetails.jsp --"+e.toString());//common-icn-0181
		e.printStackTrace();
	}
	finally
	{
		if(res != null) res.close();
		if(ps != null) ps.close();
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
	if(!siteHeader){//IN071865 starts
		displayDataTempNew.append(dispData);
	}
	//displayDataTempNew.append(displayData.toString());
	String displayDataTempNew1=displayData.toString();
	String str="<th style=\"border-style:dashed;font-size:9pt;font-weight:boldl;\"";
	String str1="<td style=\"border-style:dashed;font-size:9pt;text-align:center;font-weight:bold;\"";
	displayDataTempNew1 = displayDataTempNew1.replaceAll(str,str1);
	String str_ ="<th style=\"color:black;font-size:9pt;font-weight:normal;border-style:dashed;\"";
	String str1_ ="<td style=\"color:black;font-size:9pt;font-weight:normal;border-style:dashed;text-align:center;\"";
	displayDataTempNew1 = displayDataTempNew1.replaceAll(str_,str1_);
	displayDataTempNew1 = displayDataTempNew1.replaceAll("</th>","</td>");
	displayDataTempNew1 = displayDataTempNew1.replaceAll("<!--","<!-- ");
	displayDataTempNew1= displayDataTempNew1.replaceAll("PADDING-RIGHT: 0in","PADDING-RIGHT: 0.2in");  //IN048271
	displayDataTempNew1 = displayDataTempNew1.replaceAll("PAGE-BREAK-BEFORE: always;","");   //[IN056353]
	displayDataTempNew.append(displayDataTempNew1);
	if(!siteHeader){
		displayDataTempNew.append(dispData1);
	}//IN071865 ends
	//out.println(dispData.toString());//IN068396
	displayDataTempNew = new StringBuffer(displayDataTempNew.toString().replaceAll("<IMAGE[^>]*SRC\\s*=\\s*\"[^\"]*\"[^>]*></IMAGE>", ""));//ML-MMOH-SCF-2966
	out.println((displayDataTempNew.toString()).replaceAll("line-height: 100%"," "));//IN071865


            _bw.write(_wl_block13Bytes, _wl_block13);

//27926 Start.
if(!restrctPageNo){

            _bw.write(_wl_block14Bytes, _wl_block14);
}else{
            _bw.write(_wl_block15Bytes, _wl_block15);

}
//27926 End.

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block17Bytes, _wl_block17);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.print.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
