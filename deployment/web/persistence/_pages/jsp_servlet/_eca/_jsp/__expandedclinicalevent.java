package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import webbeans.eCommon.*;
import eCA.*;
import java.util.*;
import java.util.zip.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.math.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __expandedclinicalevent extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ExpandedClinicalEvent.jsp", 1743758723534L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="<!-- IN042733 --><!--IN064688 Added  math.*-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="  \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<style>\n\tTD.CAGREEN\n\t{\n\t\tFONT-SIZE: 10PT ;\n\t\tBACKGROUND-COLOR: #99CC00;\n\t\tBORDER-STYLE: SOLID;\n\t\tBORDER-LEFT-COLOR: #B2B6D7;\n\t\tBORDER-RIGHT-COLOR: #B2B6D7;\n\t\tBORDER-TOP-COLOR: #E2E3F0;\n\t\tBORDER-BOTTOM-COLOR: #E2E3F0;\n\t}\n\tTD.TD_BROWN\n\t{\n\t\tBACKGROUND-COLOR: BROWN;  \n\t\tCOLOR = WHITE;\n\t\tFONT-SIZE: 10pt ;\n\t\tBORDER-STYLE: SOLID;\n\t\tborder-left-color: #B2B6D7;\n\t\tborder-right-color: #B2B6D7;\n\t\tborder-top-color: #E2E3F0;\n\t\tborder-bottom-color: #E2E3F0;\n\t\theight:18;\t\n\t}\n\tPRE\n\t\t{\n\t\t\tfont-size: 10pt ;\n\t\t\t/*IN043895 Start.*/\n\t\t\t/*Font-Family : Courier New;*/\n\t\t\tFont-Family : \"Charis SIL\", \"Doulos SIL\", Gentium,\"Arial Unicode MS\";\n\t\t\t/*IN043895 End.*/\n\t\t\tBACKGROUND-COLOR: #E2E3F0;\n\t\t\tBORDER-STYLE: none;\n\t\t\tfontWeight : bold;\n\t\t\ttext-align: left;\n\t\t\twhite-space: normal;\n\t\t\tword-wrap: break-word;\t\n\t\t}\n\t<!-- IN042466 Start. -->\n\tDIV\n\t\t{\n\t\t\twhite-space: normal;\n\t\t\tword-wrap: break-word;\n\t\t\twidth\t: 1000px;\n\t\t\n\t\t}\n\tADDRESS\n\t\t{\n\t\t\t/*IN049424 Start.*/\n\t\t\t/*Font-Family : \"Charis SIL\", \"Doulos SIL\", Gentium,\"Arial Unicode MS\";*/  /*IN043895*/\n\t\t\tFONT-FAMILY: Verdana ;\n\t\t\t/* IN049424 End.*/\n\t\t\twhite-space: normal;\n\t\t\tword-wrap: break-word;\n\t\t\t/*width\t: 1000px;*/ <!-- IN059735 -->\n\t\t}\n\t<!-- IN042466 End. --> \n</style>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script src=\'../../eCA/js/Encounters.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCA/js/CAOpenExternalApplication.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eXH/js/ExternalApplication.js\' language=\'javascript\'></script> <!-- added for IN047024 -->\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script> <!-- added for IN048253 -->\n</head>\n\n<body class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\"details2_form\" id=\"details2_form\">\n\n<script language=javascript>\ndocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\ndocument.body.style.scrollbarArrowColor=\'#000080\';\ndocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\ndocument.body.style.scrollbarHighlightColor=\'white\';\ndocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n\nfunction  selectCheckBox(encounter_id,sortEventDateTime,classValue,obj,eventDate,Histrectype,Contrsysid,Accessionnum,Contrsyseventcode,rowNum)\n{\t\n\tvar patient_id = document.details2_form.patient_id.value;\t\n\tvar enc_id = document.details2_form.enc_id.value;\n\tvar checkbox__cnt = document.details2_form.checkbox__cnt.value;\t\n\tif(enc_id == \"\" || enc_id == null) enc_id = \"0\";\t\n\tif(encounter_id == \"\" || encounter_id == null) encounter_id = \"0\";\n\trowNum = parseInt(rowNum,10);\n\tcheckbox__cnt = parseInt(checkbox__cnt);\n\tvar addRemove = \"Add\";\n    var comImg = document.getElementById(\'commImage\'+rowNum);\n\n\tif(obj.checked)\n\t{\n\t\taddRemove = \"Add\";\t\t\n\t}\n\telse\n\t{\n\t\taddRemove = \"Remove\";\t\t\n\t}\n\n\tvar valsToRemove = encounter_id+\"`\"+Histrectype+\"`\"+Contrsysid+\"`\"+Accessionnum+\"`\"+Contrsyseventcode;\n\n\tvar valsToSort = encounter_id+\"`\"+Histrectype+\"`\"+sortEventDateTime+\"`\"+Contrsysid+\"`\"+Accessionnum+\"`\"+Contrsyseventcode;\n\n\tparent.parent.parent.manageEmailFrame.location.href = \'../../eCA/jsp/EncountersManageEmail.jsp?addRemove=\'+addRemove+\'&valsToRemove=\'+escape(valsToRemove)+\'&sortEventDateTime=\'+sortEventDateTime+\'&valsToSort=\'+escape(valsToSort)+\'&patient_id=\'+patient_id+\'&encounter_id=\'+enc_id;\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<div name=\'tooltiplayer\' id=\'tooltiplayer\'  style=\'position:absolute; width:30%; visibility:hidden;\' bgcolor=\'yellow\'>\n\t\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t<tr>\n\t\t\t<td width=\'100%\' class=\'gridTooltipData\' id=\'t\' nowrap></td>\n\t\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t</div>\t\n<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'> \n<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'> \n<input type=\"hidden\" name=\"enc_id\" id=\"enc_id\" value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'> \n<input type=\'hidden\' name=\'txtFlagQuickText\' id=\'txtFlagQuickText\' value=\"N\">\n<input type=\"hidden\" name=\"checkbox__cnt\" id=\"checkbox__cnt\" value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n<input type=\"hidden\" name=\"fac_id\" id=\"fac_id\" value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'><!--IN033489-->\n<input type=\"hidden\" name=\"enctr_id\" id=\"enctr_id\" value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'><!--IN033489-->\n</form>\n</body>\n<!-- Added for ML-MMOH-CRF-2149 start -->\n ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script type=\"text/javascript\">\nif (document.body.addEventListener) {\n    document.body.addEventListener(\'selectstart\', function(e) {\n        e.preventDefault();\n    });\n} else if (document.body.attachEvent) { \n    document.body.attachEvent(\'onselectstart\', function(e) {\n        e.returnValue = false;\n    });\n}\n</script>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\n<!-- Added for ML-MMOH-CRF-2149 end -->\n</html>\n";
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


//IN071106, starts
private String extractSpecimenNumber(String str, String firstSplitter, String secondSplitter)
{
	if(str!=null && str.length()>0)
		return str.substring(str.indexOf(firstSplitter)+1, str.indexOf(secondSplitter));
	return "";
}
//IN071106, ends


	String replaceSpecialChar(String resultStr)
	{		
		if(resultStr.indexOf("\n")!=-1)
			resultStr = resultStr.replaceAll("\n","<BR>");	//IN068560 changed ~ to <BR>		
		if(resultStr.indexOf("\r")!=-1)
			resultStr = resultStr.replaceAll("\r","");
		if(resultStr.indexOf("'")!=-1)
			resultStr = resultStr.replaceAll("'","`");
		return resultStr;
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
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
?             100            ?           created
20/10/2011	  IN26953		 MenakaV	 In History Notes are not aligned properly. It is preferable to 
										 display the Note type description above the Note details. While
										 the alignment issue is not consistent. Same note is displayed properly for some patients
14/12/2011    IN29385		MenakaV		 CA>Clinical Event History>Expanded view>System display 
										 var localeName = "en"; message.
27/01/2012	  INO30714		Menaka V	 THAI screen>View Clinical Event History>View>In the Recorded
										 Clinical Note the name is not displayed in THAI 
01/02/2012	  IN030859		Menaka V	CA>HTML code is displayed if we view the recorded Chief complaints in
										Clinical Events History and Chart Summary. 
08/02/2012	  IN030996		Menaka V	 CA>Patient Chart>Clinical event history>When the already recorded details
										 are accessed we get Java Lang null pointer exception Script Error. 
05/04/2012	  IN031989		MenakaV	 	When a patient is selected by using patient without encounter search function and when clinical
										event history is accessed the note header is incomplete for all the existing notes for that patient.	
20/06/2012	  IN033489		Menaka V	Report header blank in clinical event history.	
03/10/2012	  IN034973		Ramesh G	Laboratory result is not showing in a proper format from Clinical Event History and order 	  tracking. 
13/12/2012	  IN033977		Chowminya G	ARITIMIS:Report Header - Age calculates with system date - use added_date of notes 									
07/01/2013	  IN035950		Nijitha		CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
										more appealing. Keeping the display of information more clear and visible.	
07/01/2012	  IN032246		Ramesh G 	Result view from Existing Orders, doesn't show the similar format as it?s shows on the Print Preview 
12/11/2012	  EMG			Chowminya G											and LIS (View/Print Draft Copy).	
12/03/2013    IN037900      Chowminya G  System is displaying wrong data for the decimal numeric component - max data										
06/05/2013	  IN039562		Chowminya G	 Age format Changed to Y-M-D
15/05/2013    IN038439		NijithaS		Bru-HIMS-CRF-351			
14/05/2013	  IN037793		Karthi L	To be able to view the Specimen image attachment in 'Existing Orders' function and 'Clinical Event History' function in OR and CA.											
21/05/2013    IN040090      Chowminya G	 Linked Issue: New format age components in local language	
30/05/2013    IN040199      Chowminya G	 Many of the Report Header components are left blank	
17/06/2013	IN040866		Karthi L	System is not displaying the Image in CA 											
22/06/2013  IN040416		Nijitha S  CRF-OR-Bru-HIMS-CRF-052.1/02-System is not displaying 'View' hyperlink for the Laboratory Panel Order.
30/07/2013	IN042046		Vijayakumark	RF-KDAH-CRF-0126/02 ? CA>Patient without Encounter>View Clinical Event History>Expanded view>Discharge Advice and Expected Discharge date/time are not displayed in clinical notes report header								
08/10/2013	IN042466		Ramesh G	Report content is displaying in single line in Clinical event history.
09/10/2013	  IN043087		Ramesh G		The alingment for consent form when it is been printed from the Clinical Event History is not correct.				
17/10/2013    IN042733    NijithaS		MO-GN-5430	
18/12/2013	IN042552		Ramesh G	Bru-HIMS-CRF-391 --- Notes Confidentiality		
16/12/2013		IN045646	Chowminya		Speciality name in report header has to be long name					
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
18/02/2014	IN043895		Ramesh G		20/2/2014	    Chowminya   	Clinical Notes is not correct for some of the Symbols which are loaded. 
27/03/2014	IN047204		Karthi L		07/03/2014		Ramesh 			Order result screen for Radiology to provide a link to the DMS URL where the scanned radiology result document is uploaded to. 
12/03/2014	IN047566		Akbar											Linked issue of Bru-HIMS-CRF-195.2-47204/01
19/03/2014	IN47847			Nijitha S										Order result screen for Radiology to provide a link to the DMS URL where the scanned radiology result document is uploaded to
01/04/2014	IN048253		Karthi L		01/04/2014		Akbar			Getting Script error when click on External Application link icon.
15/05/2014	IN047205		Karthi L		16/05/2014		Ramesh			Changes to clinical event history and chart summary view - to provide link to the scanned document in clinical views
04/06/2014	IN049424		Ramesh G 		04/06/2014		Akbar S			IN043895 Changes Reverted.
09/06/2014	IN049533		Karthi L										DMS Document Uploaded is not displayed in chart summary
11/06/2014	IN049589[IN047205]		Karthi L								Document Uploaded cannot be viewed in another facility	
03/09/2014  IN050584		NijithaS										MO-GN-5454-CA-SL3  
08/09/2014  IN050936		Chowminya										None of the order retrieving any image from RIS/PACS but already having order image in PACS		
01/12/2014	IN052367		ChowminyaG 										Signature not published in Result linked clinical notes
19/03/2015	IN052800		Karthi L										If link image for Histology orderable, from CA, user not able to view the image. No link appear under View.
20/03/2015	IN054648		Ramesh G		20/03/2015		Akbar S			RESULTED REPORT RANGE COMMENTS ARE DISPLAYING IN OR.NOTE: REPORT RANGE COMMENT SETUP IS <REPORT RANGE COMMENT>
29/09/2015	IN056146		Ramesh G		29/09/2015		Akbar S			Notes Spacing Issue In Clinical Event History
12/17/2015  IN058156		Prathyusha					        			Once encounter is closed, there is no way for the user to check if the clinical notes in
                                                                            the event history has been forwarded or modified by another practitioner.  
22/03/2016	IN059735		Ramesh G										AAKH-SCF-0262																			
07/10/2016	IN047572		Karthi L									[MMS-QH-CRF-0177]To provide attending doctor and specialty  filter in the ?View Clinical Notes? and ?Clinical Event History?
07/07/2017	IN064688		Raja S			08/07/2017		RameshG			ML-MMOH-SCF-0753
22/09/2017	IN063813		Raja S			10/10/2017		Ramesh G		AAKH-CRF-0095
07/11/2017	IN064132		Raja S			07/11/2017		Ramesh G		ML-MMOH-CRF-0831
28/11/2017	IN065886		Raja S			28/11/2017		Ramesh G		CA-ML-MMOH-CRF-0824/02-Clinical Event History
07/02/2018	IN065970		Vijayakumar K	07/02/2018		RameshGo		ML-BRU-SCF-1611.1 [IN:065970]
07/03/2018	IN065970		Vijayakumar K	07/03/2018		RameshGo		ML-BRU-SCF-1611.1 [IN:065970] reopen
26/02/2018	IN065834		Raja S			26/02/2018		Ramesh G		PMG2017-KDAH-CRF-0002
19/03/2018	IN067037		Raja S			19/03/2018		Ramesh G		ML-BRU-SCF-1787
22/08/2018	IN066793		Sharanraj		22/08/2018		Ramesh G		ARYU-SCF-0064
05/10/2018	IN068396		Raja S			05/10/2018		Ramesh G		Ml-MMOH-CRF-1237
02/01/2019  IN066453		Kamalakannan G  02/01/2019		Ramesh G		ML-BRU-0491
04/01/2019  IN067016		Ramya Maddena	04/01/2019      Ramesh G    	AMRI-CRF-0370
16/01/2019	IN068560		Raja S			16/01/2019		Ramesh G		ML-MMOH-SCF-1078
18/12/2018   IN067236      	 Sivabagyam M	18/12/2018	Ramesh G	   ML-MMOH-CRF-1148
04/02/2019  IN066453		Ramya Maddena   06/02/2019      Ramesh G    	ML-BRU-CRF-0491
26/02/2019	IN069290		Raja S			26/02/2019		Ramehs G		ML-MMOH-CRF-1317
04/03/2019	IN066807        Ramya Maddena   04/03/2019      Ramesh G		AMRI-CRF-0340
04/03/2019	IN069028		Ramesh G		04/03/2019		Ramesh G		ML-MMOH-CRF-1293
30/07/2019	IN070610		Dinesh T		30/07/2019		Ramesh G		TBMC-CRF-0011.1				
06/08/2019	IN071106		Dinesh T		06/08/2019		Ramesh G		ML-MMOH-SCF-1341
06/09/2019	IN071335		Ramesh G										Common-ICN-0012
06/09/2019	IN071127		Sivabagyam M	06/09/2019		Ramesh G		Alpha-RL-Unable to attach images for Interval test...
21/10/2019	IN069242		Sivabagyam		22/10/2019		Ramesh Goli		GHL-CRF-0567
03/02/2020	IN071561		SIVABAGYAM M	03/02/2020		RAMESH G		GHL-CRF-0558.1
06/04/2020	IN071865		Sivabagyam M	06/04/2020		Ramesh G		ML-MMOH-CRF-1484
15/12/2020	7902			Sivabagyam M	15/12/2020		Ramesh G		MMS-DM-CRF-0180.1
05/01/2021	6030			Sivabagyam M	05/01/2021		Ramesh G		ML-MMOH-CRF-1491
15/01/2021	7632			Sivabagyam M	15/01/2021		Ramesh G		ML-MMOH-CRF-1261.1
20/04/2021	6484			Ramesh Goli		20/04/2021		RAMESH G		MO-CRF-20147.7
25/10/2021	24460			Ramesh G		25/10/2021		Ramesh G		ML-MMOH-SCF-1911
16/08/2022	29803			Ramesh G 										ML-BRU-CRF-0635
03/02/2020	39052			Ramesh											ML-BRU-CRF-0634
20/07/2023	  24094	   Ranjith P R		21/07/2023		RAMESH G		ML-MMOH-CRF-1804
07/09/2023	  31792	   Ranjith P R		08/09/2023		RAMESH G		ML-MMOH-CRF-1913
2/01/2024     52560         Twinkle Shah   5/01/2024      Ramesh Goli         MO-CRF-20201
21/07/2024	64369			Ramesh Goli	21/02/2024	Ramesh G		MMS-DM-CRF-0280.1
14/08/2024	65094			Kishore Kumar	 16/08/2024    Ramesh Goli      ML-MMOH-CRF-2149
19/07/2023	   65008	Ranjith P R		20/07/2023		RAMESH G		PMG2024-COMN-CRF-0053
--------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block0Bytes, _wl_block0);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	Properties p = (Properties)session.getValue("jdbc");		
	String locale	= (String) p.getProperty("LOCALE");		
	String login_at_ws_no		= p.getProperty("client_ip_address")== null ?"":p.getProperty("client_ip_address");	// IN047204
	String patientid = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String enc_id = request.getParameter("enc_id")==null?"0":request.getParameter("enc_id");	
	String encounterIDBeanKey = "";
	if(enc_id.equals("")) enc_id = "0";

	encounterIDBeanKey = enc_id;

	eCA.PatientBannerGroupLine manageEmailBean = null;
	manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patientid+encounterIDBeanKey,"eCA.PatientBannerGroupLine",session);
	
	String bean_id1 = "eCA.ChartRecordingAddGroupBean" ; //Added for ML-MMOH-CRF-2149
	String bean_name1 = "eCA.ChartRecordingAddGroupBean"; //Added for ML-MMOH-CRF-2149
	eCA.ChartRecordingAddGroupBean bean1 = (eCA.ChartRecordingAddGroupBean)getBeanObject( bean_id1, bean_name1, request) ; //Added for ML-MMOH-CRF-2149 
			
	//IN031989 Starts
	String histRecType = "";
	String sortEventDateTime1 = "";
	String contrSysId = "";
	String accNum = "";
	String contrSysEventCode = "";
	StringTokenizer strTok = null;
	String listValue = "";
	//IN064132 changes starts
	String resulted_practitioner = "";
	boolean isPracSiteSpecific = false;
	//IN064132 changes ends
	boolean isVerifiedSiteSpec = false;//IN069290
	boolean isSiteSpecificNeonatalMotherSpecimen=false;//31792
	
	ArrayList list = manageEmailBean.returnSortList();
	Collections.sort(list);
	int listSize = list.size();
	for(int i=0; i<listSize; i++)
	{
		listValue = (String)list.get(i);
		strTok = new StringTokenizer(listValue,"`");
		while(strTok.hasMoreTokens())
		{
			strTok.nextToken();
			histRecType = (String) strTok.nextToken();
			sortEventDateTime1 = (String) strTok.nextToken();
			contrSysId = (String) strTok.nextToken();
			accNum = (String) strTok.nextToken();
			contrSysEventCode = (String) strTok.nextToken();
		}
	}
	//IN031989 Ends

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection con = null;
	PreparedStatement stmt2 = null;
	PreparedStatement stmt = null;
	PreparedStatement stHist=null;
	ResultSet rs = null;
	ResultSet rsHist=null;
	CallableStatement cs=null;//IN071127
	PreparedStatement pstmtImgView = null; // added for Bru-HIMS-CRF-052.1 [IN037793]
	ResultSet resImgView = null; // added for Bru-HIMS-CRF-052.1 [IN037793]
	PreparedStatement pstmtImgView1 = null; //7902
	ResultSet resImgView1 = null;//7902
	int recCount = 0; // added for Bru-HIMS-CRF-052.1 [IN037793]
	PreparedStatement pstmtImgCount = null; // [IN037793]
	ResultSet rsetImgCount = null; // added for Bru-HIMS-CRF-052.1 [IN037793]
	
	PreparedStatement pstmtPerFacId = null; // IN040866
	ResultSet rsetPerFacId = null;  // IN040866
	PreparedStatement pstmtOrderId = null; // IN047204
	ResultSet rsetOrderId = null;  // IN047204
	ArrayList keyList = manageEmailBean.returnList2();		
	String include_normalcy_indicator = request.getParameter("normalcy")==null?"N":request.getParameter("normalcy");
	String viewby = request.getParameter("viewby")==null?"N":request.getParameter("viewby");		
	
	String abnormal = request.getParameter("abnormal")==null?"N":request.getParameter("abnormal");
	String selectedhisrectype = request.getParameter("hist_type")==null?"":request.getParameter("hist_type");	
	
	String selectedeventgroup = request.getParameter("event_group")==null?"":request.getParameter("event_group");
	if(selectedeventgroup.equals("null")) selectedeventgroup = "";
	
	String selectedeventclass = request.getParameter("event_class")==null?"":request.getParameter("event_class");
	String selectedeventcode = request.getParameter("event_item")==null?"":request.getParameter("event_item");
	
	String order_type_3T	= request.getParameter("order_type_3T")==null?"": request.getParameter("order_type_3T"); //39052
	
	String eventdate = request.getParameter("event_date")==null?"":request.getParameter("event_date");
	
	String fromdate			= request.getParameter("from_date")==null?"": request.getParameter("from_date");
	String todate			= request.getParameter("to_date")==null?"": request.getParameter("to_date");

	fromdate		= com.ehis.util.DateUtils.convertDate(fromdate,"DMYHM",locale,"en");
	todate		= com.ehis.util.DateUtils.convertDate(todate,"DMYHM",locale,"en");

	String facility_id	= request.getParameter("facility_id")==null ?"": request.getParameter("facility_id");
	String sortOrder		= request.getParameter("graphorder")==null?"desc":request.getParameter("graphorder");
	
	String eventClasswidget		= request.getParameter("p_event_class_widget")==null?"":request.getParameter("p_event_class_widget");//IN035950
	String called_from_widget		= request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget");//IN035950
	String speciality_code		=	request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");  // MMS-QH-CRF-0177 [IN047572]	
	String attend_pract_code	= 	request.getParameter("attend_pract_code")==null?"":request.getParameter("attend_pract_code"); // MMS-QH-CRF-0177 [IN047572]	 
	String p_review_rad_yn=request.getParameter("p_review_rad_yn")==null?"N":request.getParameter("p_review_rad_yn");//IN071561
	StringBuffer sql =new StringBuffer();
	String outdata = "";
	String printdata = "";	
	String titleofdocument = "";
	String pline = "";
	String enctr_id = "";	
	String fac_id = "";//IN033489
	String delta_fail_id_ind = "",color_cell_indicator="";
	String descCellInd = "";
	String resp_id = (String)session.getValue("responsibility_id");
	String reln_id		=	request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
	if(resp_id == null)resp_id ="";
	String sqlstr="", conf_access_flag="";
	String performed_by = "";
	String Specimen_num = "";  //IN066453
	String categoryNum = "";//IN066453
	String Specimen_num1 =""; //IN066453
	String Specimen_num2 ="";//IN066453
	String resultNum = "";
	int histcount = 0;
	String clinician_id			= (String)session.getValue("ca_practitioner_id") == null ? "" : (String) session.getValue("ca_practitioner_id");//IN038439
	String contr_mod_accession_num = "";//IN038439
	contr_mod_accession_num = request.getParameter("contr_mod_accession_num") == null ? "" :  request.getParameter("contr_mod_accession_num"); //IN038439

	String page_no	= request.getParameter("page_no")==null ?"1": request.getParameter("page_no");
    String key_ref = patientid+encounter_id+facility_id;
	
	StringBuffer str_rowid = new StringBuffer();
	String key_value = "";

	eCA.ChartRecordingAddGroupBean encounterBean = (eCA.ChartRecordingAddGroupBean)getObjectFromBean("encounterBean"+key_ref,"eCA.ChartRecordingAddGroupBean",session);
	
	//IN070610, starts
	ArrayList<String> funcIds = new ArrayList<String>();
	funcIds.add("UPLOAD_TR_CATEGORY_ORDERS");
	encounterBean.adapter.setSiteSpecific(funcIds,"OR");
	Boolean uploadFuncTrOrders = encounterBean.adapter.isSiteSpecific("UPLOAD_TR_CATEGORY_ORDERS");
	//IN070610, ends

	int no_page = Integer.parseInt(page_no);
	no_page = (no_page*5) - 4;
	
	for(int i=no_page;i<=(no_page+4);i++)
	{
		Integer in = new Integer(i);
		key_value = encounterBean.getRecords(in.toString());
		if(key_value!= null)
		{
			if(i == no_page)
				str_rowid.append("\'"+key_value+"\'");
			else
				str_rowid.append(",\'"+key_value+"\'");
		}
	}

	int cnt=0;
	//INO30714 Starts
	//String facilityId = (String)session.getValue("facility_id");	//Checkstyle 4.0 Beta 6
	String facilityId = (String)session.getValue("facility_id");	// IN047204
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt1 =	null;
	ResultSet rs2 =	null;
	ResultSet rs1 =	null;
	String performed_by_id	=	"" ;
	String patient_class =	"";
	String default_pat_name ="";
	String encounter_id1 = "";
	String Sex = "";
	String facility_name =	"" ;
	String visit_adm_date	=	"" ;
	String attending_practitioner	=	"" ;
	String attending_practitioner_list	=	"" ;//IN066807
	String admitting_practitioner	=	"" ;
	String bed_number	=	"" ;
	String performing_phy_name	=	"" ;
	String age	=	"" ;
	String gender	=	"" ;
	String patient_name	=	"" ;
	String speciality_name	=	"" ;
	String printDateTime	=	"" ;
	String site_name	=	"" ;
	String doc_ref_id = "";
	String last_amended_by="";
	String authorized_by="";
	String  authorized_by_id		=	""; //IN069484
	String  authorized_sign			=   "N"; //IN069484
	String pract_sign = "";
	String query_privilege_type	=	"" ;
	String url1					=	"";
	String url						=	"";
	String cal_eventdate = "";//IN040090
	String contr_mod_acc_num = "";//IN065834
	//String footer_code = null;
	//String report_header_code = null;
	Hashtable htParameter=new Hashtable();
	eCA.HeaderDomParser parser = new eCA.HeaderDomParser();
	webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();
	StringBuffer sectionContentUpdatedXML=new StringBuffer();
	// IN071335 Changes Start.
	//url   = HttpUtils.getRequestURL(request).toString();
	//url = url.substring(0,url.indexOf("jsp/"));
	url					= application.getRealPath("/eCA")+"/";
	// IN071335 Changes End.
	/*IN066793 starts*/
	boolean sitespecific=false;
	Connection	 conn=null;
	boolean isSiteSpecificForLabPrint = false;//IN066453
	try
	{
		 conn	= ConnectionManager.getConnection(request);
		sitespecific = CommonBean.isSiteSpecific(conn, "CA","BURMESE_LANGUAGE_FONT");
		isSiteSpecificForLabPrint = CommonBean.isSiteSpecific(conn, "CA","CEH_LAB_PRINT_REST");//IN066453
	}
	catch(Exception e)
	{
		out.println("Exception@111 - in getting header_appl_yn : "+e);
		
	}
	finally
	{
		if(conn!=null)	ConnectionManager.returnConnection(conn,request);
	}
	if(sitespecific)
	{	
		url1 = url + "html/RecClinicalNotesTemplateDispayView_Burmese.xsl";
		url =url+"html/RecClinicalNotesTemplateSentenceView_Burmese.xsl";
	}	
	else
	{	
		url1 = url + "html/RecClinicalNotesTemplateDispayView.xsl";
		url =url+"html/RecClinicalNotesTemplateSentenceView.xsl";
	}	
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
	
	//INO30714 ends
	String ext_image_upld_id = ""; //Bru-HIMS-CRF-052.1 [IN037793]
	String ext_img_file_locn = ""; //Bru-HIMS-CRF-052.1 [IN037793]
	// IN047204 - Start
	String html_image_upld_id=""; //IN069028
	String dmsExternalLinkYN = ""; 
	String locn_code	= "";		
	String locn_type	= "";
	String loc_desc		= "";
	String visit_id		= "";
	String physician_id	= "";
	String admit_date	= "";
	String encntr_type	= "";
	HashMap extLinkHashMap = null;
	// IN047204 - End
	//Bru-HIMS-CRF-195.3 - IN047205 - Start
	eCA.CAEncounterList oEncounterList = new eCA.CAEncounterList();
	eCA.CAExternalLinkDataDTO externalDataDTO = null;
	String ext_image_appli_id = "";
	String ext_image_obj_id = "";
	String ext_image_source = "";
	String ext_srce_doc_ref_no = "";
	String ext_srce_doc_ref_line_no = "";
	String dis_clin_note_wt_metadata_yn=""; //52560
	ArrayList externalList = null;
	//Bru-HIMS-CRF-195.3 - IN047205 - End
		boolean isClinician=false;//IN067236
		boolean restrict_rd	=false;	//IN071561
		String specimen_type="";//7632
	try
	{
		dmsExternalLinkYN = manageEmailBean.getExternalDmsLinkYN(facilityId); //IN047204 
		con = ConnectionManager.getConnection(request);
		
		//start 52560
		    pstmt1= con.prepareStatement("SELECT NVL(DIS_CLIN_NOTE_WT_METADATA_YN,'N') DIS_CLIN_NOTE_WT_METADATA_YN FROM CA_NOTE_PARAM");	
		    rs1=pstmt1.executeQuery();
		    if(rs1.next())
		    {
		    	dis_clin_note_wt_metadata_yn  = rs1.getString("DIS_CLIN_NOTE_WT_METADATA_YN");
			}
			if(rs1 != null) rs1.close();
			if(pstmt1 != null) pstmt1.close();

		//end 52560
		
		boolean isViewLabRes=false;//IN069290
		isViewLabRes=eCommon.Common.CommonBean.isSiteSpecific(con, "CA","ORDERBY_BASEDON_LAB_SEQ");//IN069290
		isClinician = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","CLINICIAN_TO_THERAPIST");//IN067236
		isPracSiteSpecific = eCommon.Common.CommonBean.isSiteSpecific(con, "OR","RESULTED_PRACTITIONER"); //Added for IN064132
		isVerifiedSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","VERIFIEDBY_PRACTITIONER"); //Added for IN069290
		restrict_rd =eCommon.Common.CommonBean.isSiteSpecific(con, "CA","RD_PEER_REVIEW_RESTRICT");//IN071561
		isSiteSpecificNeonatalMotherSpecimen = eCommon.Common.CommonBean.isSiteSpecific(con,"OR","NEONATAL_MOTHER_SPECIMEN");//31792
		sqlstr=" select get_patient.get_line_detail(?,?) Pline, nvl(GET_TASK_APPLICABILITY(?,NULL,?,?),'X') conf_access_flag FROM dual ";
		stmt2 = con.prepareStatement(sqlstr);
		stmt2.setString(1, patientid);
		stmt2.setString(2,locale);
		stmt2.setString(3, "VIEW_CONF_RESULT");
		stmt2.setString(4, resp_id);
		stmt2.setString(5, reln_id);
		rs = stmt2.executeQuery();

		if(rs != null && rs.next())
		{
			pline = rs.getString("Pline").replace('|',',');
			conf_access_flag =rs.getString("conf_access_flag");
		}
		if(rs != null)rs.close();
		if(stmt2 != null)stmt2.close();		
		
		//sql.append("  Select NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX, DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id , AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, ?, '1') clinician_short_name, CA_GET_VISIT_HDR_NEW(a.facility_id, a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,?) encline , a.NORMAL_LOW, a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind, HIGH_STR, high_str_desc, LOW_STR, low_str_desc, CRIT_STR, crit_str_desc, ABN_STR, abn_str_desc, CRIT_HIGH_STR, crit_high_str_desc, CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) HIST_DATA, a.normalcy_str, a.FACILITY_ID ,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC From cr_encounter_detail a, PR_ENCOUNTER F where a.patient_id = ?  AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID "); //IN033489//IN037900 // commented for Bru-HIMS-CRF-052.1 [IN037793]
		//sql.append("  Select NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,    CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1')event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX, DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id , AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, ?, '1') clinician_short_name, CA_GET_VISIT_HDR_NEW(a.facility_id, a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,?) encline , a.NORMAL_LOW, a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.EXT_IMAGE_UPLD_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind, HIGH_STR, high_str_desc, LOW_STR, low_str_desc, CRIT_STR, crit_str_desc, ABN_STR, abn_str_desc, CRIT_HIGH_STR, crit_high_str_desc, CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) HIST_DATA, a.normalcy_str, a.FACILITY_ID ,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type From cr_encounter_detail a, PR_ENCOUNTER F where a.patient_id = ?  AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID "); //IN033489//IN037900 // modified for Bru-HIMS-CRF-052.1 [IN037793] - a.EVENT_CODE_TYPE added for IN047204 //Commented for IN064688		
		//sql.append("  Select NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,    CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1')event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX, RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind, normal_low ,normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id , AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, ?, '1') clinician_short_name, CA_GET_VISIT_HDR_NEW(a.facility_id, a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,?) encline , a.NORMAL_LOW, a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.EXT_IMAGE_UPLD_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind, HIGH_STR, high_str_desc, LOW_STR, low_str_desc, CRIT_STR, crit_str_desc, ABN_STR, abn_str_desc, CRIT_HIGH_STR, crit_high_str_desc, CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) HIST_DATA, a.normalcy_str, a.FACILITY_ID ,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type From cr_encounter_detail a, PR_ENCOUNTER F where a.patient_id = ?  AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID "); //Modified for IN064688[result_num,normal_low,normal_high]//Commented for IN064132
		//sql.append("  Select NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,    CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1')event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX, RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind, normal_low ,normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id , AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, ?, '1') clinician_short_name,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID), ?, '1') resulted_practitioner, CA_GET_VISIT_HDR_NEW(a.facility_id, a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,?) encline , a.NORMAL_LOW, a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.EXT_IMAGE_UPLD_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind, HIGH_STR, high_str_desc, LOW_STR, low_str_desc, CRIT_STR, crit_str_desc, ABN_STR, abn_str_desc, CRIT_HIGH_STR, crit_high_str_desc, CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) HIST_DATA, a.normalcy_str, a.FACILITY_ID ,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type From cr_encounter_detail a, PR_ENCOUNTER F where a.patient_id = ?  AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID "); //Modified for IN064688[result_num,normal_low,normal_high]//Modified for IN064132 //commented for IN067037
		//sql.append("  Select NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,    CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1')event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id , AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, ?, '1') clinician_short_name,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID), ?, '1') resulted_practitioner, CA_GET_VISIT_HDR_NEW(a.facility_id, a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,?) encline , a.NORMAL_LOW, a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.EXT_IMAGE_UPLD_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind, HIGH_STR, high_str_desc, LOW_STR, low_str_desc, CRIT_STR, crit_str_desc, ABN_STR, abn_str_desc, CRIT_HIGH_STR, crit_high_str_desc, CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) HIST_DATA, a.normalcy_str, a.FACILITY_ID ,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type From cr_encounter_detail a, PR_ENCOUNTER F where a.patient_id = ?  AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID "); //Modified for IN067037//commented for IN066453
		//IN069028 Start
		//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,    CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1')event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id , AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, ?, '1') clinician_short_name,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID), ?, '1') resulted_practitioner, CA_GET_VISIT_HDR_NEW(a.facility_id, a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,?) encline , a.NORMAL_LOW, a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.EXT_IMAGE_UPLD_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind, HIGH_STR, high_str_desc, LOW_STR, low_str_desc, CRIT_STR, crit_str_desc, ABN_STR, abn_str_desc, CRIT_HIGH_STR, crit_high_str_desc, CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) HIST_DATA, a.normalcy_str, a.FACILITY_ID ,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type From cr_encounter_detail a, PR_ENCOUNTER F where a.patient_id = ?  AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID "); //added for IN066453
		//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,    CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1')event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id , AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, ?, '1') clinician_short_name,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID), ?, '1') resulted_practitioner, CA_GET_VISIT_HDR_NEW(a.facility_id, a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,?) encline , a.NORMAL_LOW, a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.EXT_IMAGE_UPLD_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind, HIGH_STR, high_str_desc, LOW_STR, low_str_desc, CRIT_STR, crit_str_desc, ABN_STR, abn_str_desc, CRIT_HIGH_STR, crit_high_str_desc, CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) HIST_DATA, a.normalcy_str, a.FACILITY_ID ,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type,a.HTML_IMAGE_UPLD_ID From cr_encounter_detail a, PR_ENCOUNTER F where a.patient_id = ?  AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID "); 		
		//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,    CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1')event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id , AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, ?, '1') clinician_short_name,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID), ?, '1') resulted_practitioner, CA_GET_VISIT_HDR_NEW(a.facility_id, a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,?) encline , a.NORMAL_LOW, a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.EXT_IMAGE_UPLD_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind, HIGH_STR, high_str_desc, LOW_STR, low_str_desc, CRIT_STR, crit_str_desc, ABN_STR, abn_str_desc, CRIT_HIGH_STR, crit_high_str_desc, CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) HIST_DATA, a.normalcy_str, a.FACILITY_ID ,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type,a.HTML_IMAGE_UPLD_ID From cr_encounter_detail a, PR_ENCOUNTER F where a.patient_id = ?  AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID "); 		
		//IN069028 End.
		//IN070610, starts
		//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,    CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1')event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id , AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, ?, '1') clinician_short_name,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID), ?, '1') resulted_practitioner, CA_GET_VISIT_HDR_NEW(a.facility_id, a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,?) encline , a.NORMAL_LOW, a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.EXT_IMAGE_UPLD_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind, HIGH_STR, high_str_desc, LOW_STR, low_str_desc, CRIT_STR, crit_str_desc, ABN_STR, abn_str_desc, CRIT_HIGH_STR, crit_high_str_desc, CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) HIST_DATA, a.normalcy_str, a.FACILITY_ID ,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type,a.HTML_IMAGE_UPLD_ID From cr_encounter_detail a, PR_ENCOUNTER F where a.patient_id = ?  AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");
		if(uploadFuncTrOrders){
			//IN069242 Start.
			//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,    CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1')event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id , AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, ?, '1') clinician_short_name,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID), ?, '1') resulted_practitioner, CA_GET_VISIT_HDR_NEW(a.facility_id, a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,?) encline , a.NORMAL_LOW, a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.EXT_IMAGE_UPLD_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind, HIGH_STR, high_str_desc, LOW_STR, low_str_desc, CRIT_STR, crit_str_desc, ABN_STR, abn_str_desc, CRIT_HIGH_STR, crit_high_str_desc, CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) HIST_DATA, a.normalcy_str, a.FACILITY_ID ,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type,a.HTML_IMAGE_UPLD_ID,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt From cr_encounter_detail a, PR_ENCOUNTER F where a.patient_id = ?  AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");
			 
			if(!isViewLabRes){
				//6484 Start.
				//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,    CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1')event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id , AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, ?, '1') clinician_short_name,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID), ?, '1') resulted_practitioner, CA_GET_VISIT_HDR_NEW(a.facility_id, a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,?) encline , a.NORMAL_LOW, a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.EXT_IMAGE_UPLD_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind, HIGH_STR, high_str_desc, LOW_STR, low_str_desc, CRIT_STR, crit_str_desc, ABN_STR, abn_str_desc, CRIT_HIGH_STR, crit_high_str_desc, CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) HIST_DATA, a.normalcy_str, a.FACILITY_ID ,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type,a.HTML_IMAGE_UPLD_ID,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type From cr_encounter_detail a, PR_ENCOUNTER F where a.patient_id = ?  AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");//6030
				//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,    CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1')event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE, (SELECT c.compress_hist_data FROM cr_encounter_detail_txt c WHERE c.hist_rec_type = a.hist_rec_type AND c.contr_sys_id = a.contr_sys_id AND c.accession_num = a.accession_num AND c.contr_sys_event_code = a.contr_sys_event_code) compress_hist_data, (SELECT d.compress_hist_data_yn FROM cr_encounter_detail_txt d WHERE d.hist_rec_type = a.hist_rec_type AND d.contr_sys_id = a.contr_sys_id AND d.accession_num = a.accession_num AND d.contr_sys_event_code = a.contr_sys_event_code) compress_hist_data_yn, (SELECT e.comments FROM cr_encounter_detail_txt e WHERE e.hist_rec_type = a.hist_rec_type AND e.contr_sys_id = a.contr_sys_id AND e.accession_num = a.accession_num AND e.contr_sys_event_code = a.contr_sys_event_code) comments, a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id , AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, ?, '1') clinician_short_name,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID), ?, '1') resulted_practitioner, CA_GET_VISIT_HDR_NEW(a.facility_id, a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,?,a.hist_rec_type,'"+isPracSiteSpecific+"',A.AUTHORIZED_BY_ID) encline , a.NORMAL_LOW, a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.EXT_IMAGE_UPLD_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind, HIGH_STR, high_str_desc, LOW_STR, low_str_desc, CRIT_STR, crit_str_desc, ABN_STR, abn_str_desc, CRIT_HIGH_STR, crit_high_str_desc, CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) HIST_DATA, a.normalcy_str, a.FACILITY_ID ,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type,a.HTML_IMAGE_UPLD_ID,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.result_status resultStatus From cr_encounter_detail a, PR_ENCOUNTER F where a.patient_id = ?  ##ORDERTYPERESULT## AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");
				//6484 End.
				  //sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,    CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1')event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE, (SELECT c.compress_hist_data FROM cr_encounter_detail_txt c WHERE c.hist_rec_type = a.hist_rec_type AND c.contr_sys_id = a.contr_sys_id AND c.accession_num = a.accession_num AND c.contr_sys_event_code = a.contr_sys_event_code) compress_hist_data, (SELECT d.compress_hist_data_yn FROM cr_encounter_detail_txt d WHERE d.hist_rec_type = a.hist_rec_type AND d.contr_sys_id = a.contr_sys_id AND d.accession_num = a.accession_num AND d.contr_sys_event_code = a.contr_sys_event_code) compress_hist_data_yn, (SELECT e.comments FROM cr_encounter_detail_txt e WHERE e.hist_rec_type = a.hist_rec_type AND e.contr_sys_id = a.contr_sys_id AND e.accession_num = a.accession_num AND e.contr_sys_event_code = a.contr_sys_event_code) comments, a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id , AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, ?, '1') clinician_short_name,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID), ?, '1') resulted_practitioner, CA_GET_VISIT_HDR_NEW(a.facility_id, a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,?,a.hist_rec_type,'"+isPracSiteSpecific+"',A.AUTHORIZED_BY_ID) encline , a.NORMAL_LOW, a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.EXT_IMAGE_UPLD_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind, HIGH_STR, high_str_desc, LOW_STR, low_str_desc, CRIT_STR, crit_str_desc, ABN_STR, abn_str_desc, CRIT_HIGH_STR, crit_high_str_desc, CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) HIST_DATA, a.normalcy_str, a.FACILITY_ID ,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type,a.HTML_IMAGE_UPLD_ID,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.result_status resultStatus,to_char(a.modified_date,'dd/mm/yyyy hh24:mi') modified_date,NOTE_DATA_MODFIED_YN(a.hist_rec_type,a.accession_num) modifiedyn From cr_encounter_detail a, PR_ENCOUNTER F where a.patient_id = ?  ##ORDERTYPERESULT## AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");//24094
				  sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,    CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1')event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE, (SELECT c.compress_hist_data FROM cr_encounter_detail_txt c WHERE c.hist_rec_type = a.hist_rec_type AND c.contr_sys_id = a.contr_sys_id AND c.accession_num = a.accession_num AND c.contr_sys_event_code = a.contr_sys_event_code) compress_hist_data, (SELECT d.compress_hist_data_yn FROM cr_encounter_detail_txt d WHERE d.hist_rec_type = a.hist_rec_type AND d.contr_sys_id = a.contr_sys_id AND d.accession_num = a.accession_num AND d.contr_sys_event_code = a.contr_sys_event_code) compress_hist_data_yn, (SELECT e.comments FROM cr_encounter_detail_txt e WHERE e.hist_rec_type = a.hist_rec_type AND e.contr_sys_id = a.contr_sys_id AND e.accession_num = a.accession_num AND e.contr_sys_event_code = a.contr_sys_event_code) comments, a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id , AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, ?, '1') clinician_short_name,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID), ?, '1') resulted_practitioner, CA_GET_VISIT_HDR_NEW(a.facility_id, a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,?,a.hist_rec_type,'"+isPracSiteSpecific+"',A.AUTHORIZED_BY_ID) encline , a.NORMAL_LOW, a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.EXT_IMAGE_UPLD_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind, HIGH_STR, high_str_desc, LOW_STR, low_str_desc, CRIT_STR, crit_str_desc, ABN_STR, abn_str_desc, CRIT_HIGH_STR, crit_high_str_desc, CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) HIST_DATA, a.normalcy_str, a.FACILITY_ID ,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type,a.HTML_IMAGE_UPLD_ID,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.result_status resultStatus,to_char(a.modified_date,'dd/mm/yyyy hh24:mi') modified_date,NOTE_DATA_MODFIED_YN(a.hist_rec_type,a.accession_num) modifiedyn,or_get_neonate_spec_yn(NULL,NULL,NULL,a.hist_rec_type,a.accession_num)lv_neonate_spec_yn,a.EXT_IMAGE_DOC_ID  From cr_encounter_detail a, PR_ENCOUNTER F where a.patient_id = ?  ##ORDERTYPERESULT## AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");//24094//31792  //EXT_IMAGE_DOC_ID  added against  to 64369
                  
			}else{
				//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,    CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1')event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id , AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, ?, '1') clinician_short_name,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID), ?, '1') resulted_practitioner, CA_GET_VISIT_HDR_NEW(a.facility_id, a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,?) encline , a.NORMAL_LOW, a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.EXT_IMAGE_UPLD_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind, HIGH_STR, high_str_desc, LOW_STR, low_str_desc, CRIT_STR, crit_str_desc, ABN_STR, abn_str_desc, CRIT_HIGH_STR, crit_high_str_desc, CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) HIST_DATA, a.normalcy_str, a.FACILITY_ID ,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type,a.HTML_IMAGE_UPLD_ID,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no From cr_encounter_detail a, PR_ENCOUNTER F where a.patient_id = ?  AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");//6030
				//6484 Start.
				//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,    CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1')event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id , AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, ?, '1') clinician_short_name,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID), ?, '1') resulted_practitioner, CA_GET_VISIT_HDR_NEW(a.facility_id, a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,?) encline , a.NORMAL_LOW, a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.EXT_IMAGE_UPLD_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind, HIGH_STR, high_str_desc, LOW_STR, low_str_desc, CRIT_STR, crit_str_desc, ABN_STR, abn_str_desc, CRIT_HIGH_STR, crit_high_str_desc, CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) HIST_DATA, a.normalcy_str, a.FACILITY_ID ,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type,a.HTML_IMAGE_UPLD_ID,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type From cr_encounter_detail a, PR_ENCOUNTER F where a.patient_id = ?  AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");//6030
	 			//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,    CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1')event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id , AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, ?, '1') clinician_short_name,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID), ?, '1') resulted_practitioner, CA_GET_VISIT_HDR_NEW(a.facility_id, a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,?,a.hist_rec_type,'"+isPracSiteSpecific+"',A.AUTHORIZED_BY_ID) encline , a.NORMAL_LOW, a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.EXT_IMAGE_UPLD_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind, HIGH_STR, high_str_desc, LOW_STR, low_str_desc, CRIT_STR, crit_str_desc, ABN_STR, abn_str_desc, CRIT_HIGH_STR, crit_high_str_desc, CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) HIST_DATA, (SELECT c.compress_hist_data FROM cr_encounter_detail_txt c WHERE c.hist_rec_type = a.hist_rec_type AND c.contr_sys_id = a.contr_sys_id AND c.accession_num = a.accession_num AND c.contr_sys_event_code = a.contr_sys_event_code) compress_hist_data, (SELECT d.compress_hist_data_yn FROM cr_encounter_detail_txt d WHERE d.hist_rec_type = a.hist_rec_type AND d.contr_sys_id = a.contr_sys_id AND d.accession_num = a.accession_num AND d.contr_sys_event_code = a.contr_sys_event_code) compress_hist_data_yn, (SELECT e.comments FROM cr_encounter_detail_txt e WHERE e.hist_rec_type = a.hist_rec_type AND e.contr_sys_id = a.contr_sys_id AND e.accession_num = a.accession_num AND e.contr_sys_event_code = a.contr_sys_event_code) comments,  a.normalcy_str, a.FACILITY_ID ,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type,a.HTML_IMAGE_UPLD_ID,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.result_status resultStatus From cr_encounter_detail a, PR_ENCOUNTER F where a.patient_id = ?  ##ORDERTYPERESULT## AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");
				//6484 End.
				//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,    CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1')event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id , AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, ?, '1') clinician_short_name,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID), ?, '1') resulted_practitioner, CA_GET_VISIT_HDR_NEW(a.facility_id, a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,?,a.hist_rec_type,'"+isPracSiteSpecific+"',A.AUTHORIZED_BY_ID) encline , a.NORMAL_LOW, a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.EXT_IMAGE_UPLD_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind, HIGH_STR, high_str_desc, LOW_STR, low_str_desc, CRIT_STR, crit_str_desc, ABN_STR, abn_str_desc, CRIT_HIGH_STR, crit_high_str_desc, CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) HIST_DATA, (SELECT c.compress_hist_data FROM cr_encounter_detail_txt c WHERE c.hist_rec_type = a.hist_rec_type AND c.contr_sys_id = a.contr_sys_id AND c.accession_num = a.accession_num AND c.contr_sys_event_code = a.contr_sys_event_code) compress_hist_data, (SELECT d.compress_hist_data_yn FROM cr_encounter_detail_txt d WHERE d.hist_rec_type = a.hist_rec_type AND d.contr_sys_id = a.contr_sys_id AND d.accession_num = a.accession_num AND d.contr_sys_event_code = a.contr_sys_event_code) compress_hist_data_yn, (SELECT e.comments FROM cr_encounter_detail_txt e WHERE e.hist_rec_type = a.hist_rec_type AND e.contr_sys_id = a.contr_sys_id AND e.accession_num = a.accession_num AND e.contr_sys_event_code = a.contr_sys_event_code) comments,  a.normalcy_str, a.FACILITY_ID ,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type,a.HTML_IMAGE_UPLD_ID,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.result_status resultStatus,to_char(a.modified_date,'dd/mm/yyyy hh24:mi') modified_date,NOTE_DATA_MODFIED_YN(a.hist_rec_type,a.accession_num) modifiedyn From cr_encounter_detail a, PR_ENCOUNTER F where a.patient_id = ?  ##ORDERTYPERESULT## AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");//24094
				sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,    CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1')event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id , AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, ?, '1') clinician_short_name,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID), ?, '1') resulted_practitioner, CA_GET_VISIT_HDR_NEW(a.facility_id, a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,?,a.hist_rec_type,'"+isPracSiteSpecific+"',A.AUTHORIZED_BY_ID) encline , a.NORMAL_LOW, a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.EXT_IMAGE_UPLD_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind, HIGH_STR, high_str_desc, LOW_STR, low_str_desc, CRIT_STR, crit_str_desc, ABN_STR, abn_str_desc, CRIT_HIGH_STR, crit_high_str_desc, CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) HIST_DATA, (SELECT c.compress_hist_data FROM cr_encounter_detail_txt c WHERE c.hist_rec_type = a.hist_rec_type AND c.contr_sys_id = a.contr_sys_id AND c.accession_num = a.accession_num AND c.contr_sys_event_code = a.contr_sys_event_code) compress_hist_data, (SELECT d.compress_hist_data_yn FROM cr_encounter_detail_txt d WHERE d.hist_rec_type = a.hist_rec_type AND d.contr_sys_id = a.contr_sys_id AND d.accession_num = a.accession_num AND d.contr_sys_event_code = a.contr_sys_event_code) compress_hist_data_yn, (SELECT e.comments FROM cr_encounter_detail_txt e WHERE e.hist_rec_type = a.hist_rec_type AND e.contr_sys_id = a.contr_sys_id AND e.accession_num = a.accession_num AND e.contr_sys_event_code = a.contr_sys_event_code) comments,  a.normalcy_str, a.FACILITY_ID ,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type,a.HTML_IMAGE_UPLD_ID,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.result_status resultStatus,to_char(a.modified_date,'dd/mm/yyyy hh24:mi') modified_date,NOTE_DATA_MODFIED_YN(a.hist_rec_type,a.accession_num) modifiedyn,or_get_neonate_spec_yn(NULL,NULL,NULL,a.hist_rec_type,a.accession_num)lv_neonate_spec_yn,a.EXT_IMAGE_DOC_ID  From cr_encounter_detail a, PR_ENCOUNTER F where a.patient_id = ?  ##ORDERTYPERESULT## AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");//24094//31792 //EXT_IMAGE_DOC_ID  added against  to 64369
				
			}
			//IN069242 End.
		}else{
			//IN069242 Start.
			//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,    CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1')event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id , AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, ?, '1') clinician_short_name,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID), ?, '1') resulted_practitioner, CA_GET_VISIT_HDR_NEW(a.facility_id, a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,?) encline , a.NORMAL_LOW, a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.EXT_IMAGE_UPLD_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind, HIGH_STR, high_str_desc, LOW_STR, low_str_desc, CRIT_STR, crit_str_desc, ABN_STR, abn_str_desc, CRIT_HIGH_STR, crit_high_str_desc, CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) HIST_DATA, a.normalcy_str, a.FACILITY_ID ,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type,a.HTML_IMAGE_UPLD_ID From cr_encounter_detail a, PR_ENCOUNTER F where a.patient_id = ?  AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");
			 
			if(!isViewLabRes){
				//6484 Start.
				//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,    CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1')event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id , AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, ?, '1') clinician_short_name,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID), ?, '1') resulted_practitioner, CA_GET_VISIT_HDR_NEW(a.facility_id, a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,?) encline , a.NORMAL_LOW, a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.EXT_IMAGE_UPLD_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind, HIGH_STR, high_str_desc, LOW_STR, low_str_desc, CRIT_STR, crit_str_desc, ABN_STR, abn_str_desc, CRIT_HIGH_STR, crit_high_str_desc, CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) HIST_DATA, a.normalcy_str, a.FACILITY_ID ,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type,a.HTML_IMAGE_UPLD_ID,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type From cr_encounter_detail a, PR_ENCOUNTER F where a.patient_id = ?  AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");//6030
				//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,    CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1')event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id , AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, ?, '1') clinician_short_name,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID), ?, '1') resulted_practitioner, CA_GET_VISIT_HDR_NEW(a.facility_id, a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,?,a.hist_rec_type,'"+isPracSiteSpecific+"',A.AUTHORIZED_BY_ID) encline , a.NORMAL_LOW, a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.EXT_IMAGE_UPLD_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind, HIGH_STR, high_str_desc, LOW_STR, low_str_desc, CRIT_STR, crit_str_desc, ABN_STR, abn_str_desc, CRIT_HIGH_STR, crit_high_str_desc, CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) HIST_DATA,(SELECT c.compress_hist_data FROM cr_encounter_detail_txt c WHERE c.hist_rec_type = a.hist_rec_type AND c.contr_sys_id = a.contr_sys_id AND c.accession_num = a.accession_num AND c.contr_sys_event_code = a.contr_sys_event_code) compress_hist_data, (SELECT d.compress_hist_data_yn FROM cr_encounter_detail_txt d WHERE d.hist_rec_type = a.hist_rec_type AND d.contr_sys_id = a.contr_sys_id AND d.accession_num = a.accession_num AND d.contr_sys_event_code = a.contr_sys_event_code) compress_hist_data_yn, (SELECT e.comments FROM cr_encounter_detail_txt e WHERE e.hist_rec_type = a.hist_rec_type AND e.contr_sys_id = a.contr_sys_id AND e.accession_num = a.accession_num AND e.contr_sys_event_code = a.contr_sys_event_code) comments,  a.normalcy_str, a.FACILITY_ID ,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type,a.HTML_IMAGE_UPLD_ID,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.result_status resultStatus From cr_encounter_detail a, PR_ENCOUNTER F where a.patient_id = ?  ##ORDERTYPERESULT## AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");
				//6484 End.
				//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,    CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1')event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id , AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, ?, '1') clinician_short_name,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID), ?, '1') resulted_practitioner, CA_GET_VISIT_HDR_NEW(a.facility_id, a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,?,a.hist_rec_type,'"+isPracSiteSpecific+"',A.AUTHORIZED_BY_ID) encline , a.NORMAL_LOW, a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.EXT_IMAGE_UPLD_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind, HIGH_STR, high_str_desc, LOW_STR, low_str_desc, CRIT_STR, crit_str_desc, ABN_STR, abn_str_desc, CRIT_HIGH_STR, crit_high_str_desc, CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) HIST_DATA,(SELECT c.compress_hist_data FROM cr_encounter_detail_txt c WHERE c.hist_rec_type = a.hist_rec_type AND c.contr_sys_id = a.contr_sys_id AND c.accession_num = a.accession_num AND c.contr_sys_event_code = a.contr_sys_event_code) compress_hist_data, (SELECT d.compress_hist_data_yn FROM cr_encounter_detail_txt d WHERE d.hist_rec_type = a.hist_rec_type AND d.contr_sys_id = a.contr_sys_id AND d.accession_num = a.accession_num AND d.contr_sys_event_code = a.contr_sys_event_code) compress_hist_data_yn, (SELECT e.comments FROM cr_encounter_detail_txt e WHERE e.hist_rec_type = a.hist_rec_type AND e.contr_sys_id = a.contr_sys_id AND e.accession_num = a.accession_num AND e.contr_sys_event_code = a.contr_sys_event_code) comments,  a.normalcy_str, a.FACILITY_ID ,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type,a.HTML_IMAGE_UPLD_ID,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.result_status resultStatus,to_char(a.modified_date,'dd/mm/yyyy hh24:mi') modified_date,NOTE_DATA_MODFIED_YN(a.hist_rec_type,a.accession_num) modifiedyn From cr_encounter_detail a, PR_ENCOUNTER F where a.patient_id = ?  ##ORDERTYPERESULT## AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");//24094
				sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,    CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1')event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id , AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, ?, '1') clinician_short_name,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID), ?, '1') resulted_practitioner, CA_GET_VISIT_HDR_NEW(a.facility_id, a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,?,a.hist_rec_type,'"+isPracSiteSpecific+"',A.AUTHORIZED_BY_ID) encline , a.NORMAL_LOW, a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.EXT_IMAGE_UPLD_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind, HIGH_STR, high_str_desc, LOW_STR, low_str_desc, CRIT_STR, crit_str_desc, ABN_STR, abn_str_desc, CRIT_HIGH_STR, crit_high_str_desc, CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) HIST_DATA,(SELECT c.compress_hist_data FROM cr_encounter_detail_txt c WHERE c.hist_rec_type = a.hist_rec_type AND c.contr_sys_id = a.contr_sys_id AND c.accession_num = a.accession_num AND c.contr_sys_event_code = a.contr_sys_event_code) compress_hist_data, (SELECT d.compress_hist_data_yn FROM cr_encounter_detail_txt d WHERE d.hist_rec_type = a.hist_rec_type AND d.contr_sys_id = a.contr_sys_id AND d.accession_num = a.accession_num AND d.contr_sys_event_code = a.contr_sys_event_code) compress_hist_data_yn, (SELECT e.comments FROM cr_encounter_detail_txt e WHERE e.hist_rec_type = a.hist_rec_type AND e.contr_sys_id = a.contr_sys_id AND e.accession_num = a.accession_num AND e.contr_sys_event_code = a.contr_sys_event_code) comments,  a.normalcy_str, a.FACILITY_ID ,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type,a.HTML_IMAGE_UPLD_ID,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.result_status resultStatus,to_char(a.modified_date,'dd/mm/yyyy hh24:mi') modified_date,NOTE_DATA_MODFIED_YN(a.hist_rec_type,a.accession_num) modifiedyn,or_get_neonate_spec_yn(NULL,NULL,NULL,a.hist_rec_type,a.accession_num)lv_neonate_spec_yn,a.EXT_IMAGE_DOC_ID  From cr_encounter_detail a, PR_ENCOUNTER F where a.patient_id = ?  ##ORDERTYPERESULT## AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");//24094//31792 //EXT_IMAGE_DOC_ID  added against  to 64369
			
			}else{
				//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,    CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1')event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id , AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, ?, '1') clinician_short_name,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID), ?, '1') resulted_practitioner, CA_GET_VISIT_HDR_NEW(a.facility_id, a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,?) encline , a.NORMAL_LOW, a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.EXT_IMAGE_UPLD_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind, HIGH_STR, high_str_desc, LOW_STR, low_str_desc, CRIT_STR, crit_str_desc, ABN_STR, abn_str_desc, CRIT_HIGH_STR, crit_high_str_desc, CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) HIST_DATA, a.normalcy_str, a.FACILITY_ID ,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type,a.HTML_IMAGE_UPLD_ID,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no From cr_encounter_detail a, PR_ENCOUNTER F where a.patient_id = ?  AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");//6030
				//6484 Start.
				//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,    CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1')event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id , AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, ?, '1') clinician_short_name,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID), ?, '1') resulted_practitioner, CA_GET_VISIT_HDR_NEW(a.facility_id, a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,?) encline , a.NORMAL_LOW, a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.EXT_IMAGE_UPLD_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind, HIGH_STR, high_str_desc, LOW_STR, low_str_desc, CRIT_STR, crit_str_desc, ABN_STR, abn_str_desc, CRIT_HIGH_STR, crit_high_str_desc, CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) HIST_DATA, a.normalcy_str, a.FACILITY_ID ,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type,a.HTML_IMAGE_UPLD_ID,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type From cr_encounter_detail a, PR_ENCOUNTER F where a.patient_id = ?  AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");//6030
				//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,    CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1')event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id , AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, ?, '1') clinician_short_name,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID), ?, '1') resulted_practitioner, CA_GET_VISIT_HDR_NEW(a.facility_id, a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,?,a.hist_rec_type,'"+isPracSiteSpecific+"',A.AUTHORIZED_BY_ID) encline , a.NORMAL_LOW, a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.EXT_IMAGE_UPLD_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind, HIGH_STR, high_str_desc, LOW_STR, low_str_desc, CRIT_STR, crit_str_desc, ABN_STR, abn_str_desc, CRIT_HIGH_STR, crit_high_str_desc, CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) HIST_DATA, (SELECT c.compress_hist_data FROM cr_encounter_detail_txt c WHERE c.hist_rec_type = a.hist_rec_type AND c.contr_sys_id = a.contr_sys_id AND c.accession_num = a.accession_num AND c.contr_sys_event_code = a.contr_sys_event_code) compress_hist_data, (SELECT d.compress_hist_data_yn FROM cr_encounter_detail_txt d WHERE d.hist_rec_type = a.hist_rec_type AND d.contr_sys_id = a.contr_sys_id AND d.accession_num = a.accession_num AND d.contr_sys_event_code = a.contr_sys_event_code) compress_hist_data_yn, (SELECT e.comments FROM cr_encounter_detail_txt e WHERE e.hist_rec_type = a.hist_rec_type AND e.contr_sys_id = a.contr_sys_id AND e.accession_num = a.accession_num AND e.contr_sys_event_code = a.contr_sys_event_code) comments, a.normalcy_str, a.FACILITY_ID ,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type,a.HTML_IMAGE_UPLD_ID,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.result_status resultStatus From cr_encounter_detail a, PR_ENCOUNTER F where a.patient_id = ?  ##ORDERTYPERESULT## AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");
				//6484 End.
				//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,    CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1')event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id , AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, ?, '1') clinician_short_name,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID), ?, '1') resulted_practitioner, CA_GET_VISIT_HDR_NEW(a.facility_id, a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,?,a.hist_rec_type,'"+isPracSiteSpecific+"',A.AUTHORIZED_BY_ID) encline , a.NORMAL_LOW, a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.EXT_IMAGE_UPLD_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind, HIGH_STR, high_str_desc, LOW_STR, low_str_desc, CRIT_STR, crit_str_desc, ABN_STR, abn_str_desc, CRIT_HIGH_STR, crit_high_str_desc, CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) HIST_DATA, (SELECT c.compress_hist_data FROM cr_encounter_detail_txt c WHERE c.hist_rec_type = a.hist_rec_type AND c.contr_sys_id = a.contr_sys_id AND c.accession_num = a.accession_num AND c.contr_sys_event_code = a.contr_sys_event_code) compress_hist_data, (SELECT d.compress_hist_data_yn FROM cr_encounter_detail_txt d WHERE d.hist_rec_type = a.hist_rec_type AND d.contr_sys_id = a.contr_sys_id AND d.accession_num = a.accession_num AND d.contr_sys_event_code = a.contr_sys_event_code) compress_hist_data_yn, (SELECT e.comments FROM cr_encounter_detail_txt e WHERE e.hist_rec_type = a.hist_rec_type AND e.contr_sys_id = a.contr_sys_id AND e.accession_num = a.accession_num AND e.contr_sys_event_code = a.contr_sys_event_code) comments, a.normalcy_str, a.FACILITY_ID ,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type,a.HTML_IMAGE_UPLD_ID,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.result_status resultStatus,to_char(a.modified_date,'dd/mm/yyyy hh24:mi') modified_date,NOTE_DATA_MODFIED_YN(a.hist_rec_type,a.accession_num) modifiedyn From cr_encounter_detail a, PR_ENCOUNTER F where a.patient_id = ?  ##ORDERTYPERESULT## AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");//24094
				sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,    CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1')event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id , AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id, ?, '1') clinician_short_name,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID), ?, '1') resulted_practitioner, CA_GET_VISIT_HDR_NEW(a.facility_id, a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,?,a.hist_rec_type,'"+isPracSiteSpecific+"',A.AUTHORIZED_BY_ID) encline , a.NORMAL_LOW, a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.EXT_IMAGE_UPLD_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind, HIGH_STR, high_str_desc, LOW_STR, low_str_desc, CRIT_STR, crit_str_desc, ABN_STR, abn_str_desc, CRIT_HIGH_STR, crit_high_str_desc, CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind, HIGH_STR, HIGH_SYMBOL_ICON, LOW_STR, LOW_SYMBOL_ICON, CRIT_STR, CRIT_SYMBOL_ICON, ABN_STR, ABN_SYMBOL_ICON, CRIT_HIGH_STR, CRIT_HIGH_SYMBOL_ICON, CRIT_LOW_STR, CRIT_LOW_SYMBOL_ICON, 'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID,(SELECT b.hist_data FROM cr_encounter_detail_txt b WHERE b.hist_rec_type = a.hist_rec_type AND b.contr_sys_id = a.contr_sys_id AND b.accession_num = a.accession_num AND b.contr_sys_event_code = a.contr_sys_event_code) HIST_DATA, (SELECT c.compress_hist_data FROM cr_encounter_detail_txt c WHERE c.hist_rec_type = a.hist_rec_type AND c.contr_sys_id = a.contr_sys_id AND c.accession_num = a.accession_num AND c.contr_sys_event_code = a.contr_sys_event_code) compress_hist_data, (SELECT d.compress_hist_data_yn FROM cr_encounter_detail_txt d WHERE d.hist_rec_type = a.hist_rec_type AND d.contr_sys_id = a.contr_sys_id AND d.accession_num = a.accession_num AND d.contr_sys_event_code = a.contr_sys_event_code) compress_hist_data_yn, (SELECT e.comments FROM cr_encounter_detail_txt e WHERE e.hist_rec_type = a.hist_rec_type AND e.contr_sys_id = a.contr_sys_id AND e.accession_num = a.accession_num AND e.contr_sys_event_code = a.contr_sys_event_code) comments, a.normalcy_str, a.FACILITY_ID ,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, a.event_code_type,a.HTML_IMAGE_UPLD_ID,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.result_status resultStatus,to_char(a.modified_date,'dd/mm/yyyy hh24:mi') modified_date,NOTE_DATA_MODFIED_YN(a.hist_rec_type,a.accession_num) modifiedyn,or_get_neonate_spec_yn(NULL,NULL,NULL,a.hist_rec_type,a.accession_num)lv_neonate_spec_yn,a.EXT_IMAGE_DOC_ID  From cr_encounter_detail a, PR_ENCOUNTER F where a.patient_id = ?  ##ORDERTYPERESULT## AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");//24094//31792 //EXT_IMAGE_DOC_ID  added against  to 64369
				
			}	
			//IN069242 End.
		}//IN070610, ends
		if (!conf_access_flag.equals("A")) 
			sql.append(" and nvl(a.PROTECTION_IND,'N')!='Z' ");
		
		sql.append(" and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' "); //IN042552
		sql.append(" and nvl(a.STATUS,'`') not in('S','E')");  		
		if(abnormal.equals("Y"))
		{
			sql.append(" and nvl(a.normalcy_ind,'.')!='.' ");
		}

		if(!eventdate.equals("") && viewby.equals("D"))
			sql.append(" and  trunc(a.event_date)= to_date(?,'dd/mm/yyyy')");	
		
		if(!selectedhisrectype.equals(""))
			sql.append(" and a.hist_rec_type = ? ");

		if(!selectedeventclass.equals(""))
			sql.append(" and a.EVENT_CLASS = ? ");

		if(!selectedeventgroup.equals(""))
			sql.append(" and a.EVENT_GROUP = ? ");

		if(!selectedeventcode.equals(""))
			sql.append(" and rtrim(a.EVENT_CODE) = ? ");

		if(!fromdate.equals("")){
			sql.append(" and A.EVENT_DATE >= to_date(NVL(?,'01/01/1000'),'dd/mm/yyyy hh24:mi') ");
		}
		if(!todate.equals("")){
			sql.append(" and A.EVENT_DATE <= to_date(NVL(?,'01/01/9999'),'dd/mm/yyyy hh24:mi')+.00068287 "); 
		}
		//IN071561 starts
		if(restrict_rd){
			   //sql.append( " AND RD_PEER_RESULT_HIDE_YN (a.CONTR_SYS_ID,a.facility_id,A.REQUEST_NUM,a.request_num_seq,'"+login_user_id+"')='N' ");//common-icn-0180
		       sql.append( " AND RD_PEER_RESULT_HIDE_YN (a.CONTR_SYS_ID,a.facility_id,A.REQUEST_NUM,a.request_num_seq,?)='N' ");//common-icn-0180
		}
		//IN071561ends
		//IN035950 Start
		if("CA_CLINICIAN_WIDGET".equals(called_from_widget) && "".equals(eventClasswidget))
		{
			sql.append(" AND a.event_class IN ('PHY$','CLI$','NUR$') ");
		}
		else if("CA_CLINICIAN_WIDGET".equals(called_from_widget) && !"".equals(eventClasswidget))
		{
			sql.append(" AND a.event_class=? ");
		}
		//IN035950 End
		if(!facility_id.equals(""))
			sql.append(" and a.facility_id = ?");

		if(!encounter_id.equals(""))
			sql.append(" and a.ENCOUNTER_ID = ? ");	
		if(attend_pract_code.equals("")){ // MMS-QH-CRF-0177 [IN047572] - Start
			if(!speciality_code.equals("")){
				sql.append(" and f.SPECIALTY_CODE = ? ");
			}
		} else {
			sql.append(" and f.ATTEND_PRACTITIONER_ID = ? ");
		} // MMS-QH-CRF-0177 [IN047572] - End
		sql.append(" and a.rowid in( "+str_rowid.toString()+" ) ");

		sql.append(" order by ");
		sql.append(" 1 ");// commented and added in else for IN071865 //Un commented 
		sql.append(sortOrder+" ,");//commented and added in else for IN071865 starts  //Un commented 
		if(viewby.equals("D"))  
		{
			sql.append(" TO_CHAR(event_date,'YYYYMMDD') , ");//IN071865  //Un commented 
			//sql.append(" event_date ");//IN071865  //// commented 
			//sql.append(sortOrder+" ,") ; // commented 
		}//IN071865 starts
		else{
			//sql.append(" 1 ");		// commented 
			//sql.append(sortOrder+" ,");   // commented 
		}
		 
		if(!isViewLabRes)
			sql.append(" 3,2,5,4,nvl(a.REQUEST_NUM_SEQ,'0'),7,6,9,8 ");//6030
			else
				sql.append(" 3,2,5,4,  NVL (sequence_no,0),7,6,9,8 ");//6030
		if(!viewby.equals("D"))
		{
			//sql.append(", event_date  ");  // commented 
			//sql.append(sortOrder);  // commented 
		}// IN071865 ends

		outdata = outdata+"<table class='grid' cellspacing=0 cellpadding=0 width='100%'>";		
		printdata = printdata +outdata;
		
		//39052 Start.
		String  sqlQuery = sql.toString();
		if("CA01".equals(order_type_3T)){
			sqlQuery=sqlQuery.replaceAll("##ORDERTYPERESULT##"," AND 'CA01'=SUBSTR(a.ACCESSION_NUM,0,4) ");
		}else{
			sqlQuery=sqlQuery.replaceAll("##ORDERTYPERESULT##","");
		}
		//39052 End.
		
		stmt=con.prepareStatement(sqlQuery);
		int count1 = 0;
		stmt.setString(++count1,locale);
		stmt.setString(++count1,locale);
		stmt.setString(++count1,locale);
		stmt.setString(++count1,locale);
		stmt.setString(++count1,locale);
		stmt.setString(++count1,locale);
		stmt.setString(++count1,locale);//Added for IN064132
		stmt.setString(++count1,patientid);

		if(!eventdate.equals("") && viewby.equals("D"))
			stmt.setString(++count1,eventdate);
		if(!selectedhisrectype.equals(""))
			stmt.setString(++count1,selectedhisrectype);
		if(!selectedeventclass.equals(""))
			stmt.setString(++count1,selectedeventclass);
		if(!selectedeventgroup.equals(""))
			stmt.setString(++count1,selectedeventgroup);
		if(!selectedeventcode.equals(""))
			stmt.setString(++count1,selectedeventcode);

		if(!fromdate.equals(""))		
			stmt.setString(++count1,fromdate);			
		if(!todate.equals(""))
		stmt.setString(++count1,todate);
		//common-icn-0180 starts
		if(restrict_rd){
			stmt.setString(++count1,login_user_id);
		}
		//common-icn-0180 ends
		//IN035950 Start
		if("CA_CLINICIAN_WIDGET".equals(called_from_widget) && !"".equals(eventClasswidget))
		{
			stmt.setString(++count1,eventClasswidget);
		}
		//IN035950 Ends
		if(!facility_id.equals(""))
			stmt.setString(++count1,facility_id);
		if(!encounter_id.equals(""))
			stmt.setString(++count1,encounter_id);
		if(attend_pract_code.equals("")){ // MMS-QH-CRF-0177 [IN047572] - Start
			if(!speciality_code.equals("")){
				stmt.setString(++count1, speciality_code);
			}
		} else {
			stmt.setString(++count1, attend_pract_code);
		} // MMS-QH-CRF-0177 [IN047572] - End
		rs = stmt.executeQuery();

		String preveventdatetime = "";
		String prevhisttype = "";
		String preveventclass = "";
		String preveventgroupevent = "";
		String colspanval ="3";
		if(viewby.equals("D")) colspanval ="3";
		String classValue = "",quick_text_image_visible = "";
		String displayStyle = "gridDataChart";
		String histdatatype="";
		String event_group="";//IN040416
		String histrectype="";
		String accessionnum="";
		String eventdatetime="";
		String modified_date="";//24094
		String modified_date_YN="";//24094
		String status="";//24094
		String eventdate_hd ="";
		String pre_eventdate_hd ="";
		String sortEventDateTime="";
		String eventdatetime_th = "";

		String histtypedesc="";
		String eventclassdesc="";
		String eventgroupdesc="";
		String eventdesc="";
		String resultstr="";
		String encline="";
		String range="";
		String extimageapplid="";
		String contr_sys_id = "";
		String contr_sys_event_code  = "";
		String restricting_print = ""; //IN069242
		String normalrange1="";
		String normalrange2="";
		String normalrange = " - ";
		String normalcy_ind="";
		String criticalrange1="";
		String criticalrange2="";
		String criticalrange = " - ";
		String strStatus="";
		String resultStatus=""; //29803
		String data = "";
		String pacsimg = "";
		String sqlHist ="";
		String curreventgroupevent="";
		String result_uom = "";		
		String normalcy_str = "";		
		StringBuffer displaydata = null;
		String extimageobjid = "";//EMG
		String extimagedocid=""; //64369
		String deciresult="";//IN037900
		String decival ="";//IN037900
		String event_code_type = "";//IN047204
		String access_no_rd 	= ""; //IN047204					
		String order_id 	= ""; //IN047204
		String order_typ_code	= ""; //IN047204
		String acc_for_notefooter = "";//IN052367
		StringBuffer toolTip = new StringBuffer();
		String eventCode="",out_event_code="";//IN071127
		String Normal_Range = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NormalRange.label","ca_labels");
		String Critical_Range = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Critical.label","common_labels");		
		int image_count=0;//IN071127
		int i = 0,txt_count=0;
		int quick_text_count = 0;
		boolean first = true;
		String chkSelBox="";
		Clob note;
		java.io.BufferedReader r;
		String study_id="",ext_img_disable="",param_def_str="";//7902
		String ext_img_display="";//7902
		String lv_neonate_spec_yn ="";//31792
		sqlHist="select count(*) from CR_ENCOUNTER_DETAIL_TXT where hist_rec_type =? and contr_sys_id = ? and accession_num = ? and contr_sys_event_code=?";
		stHist=con.prepareStatement(sqlHist);	
		
		if(rs != null)
		{
			while(rs.next())
			{
				displaydata = new StringBuffer();
				toolTip.setLength(0);
				txt_count = 0;
				quick_text_count = 0;
				data = "";
				quick_text_count = rs.getInt("QUICK_TEXT_COUNT");
				if(quick_text_count == 1)
					quick_text_image_visible = "style='display'";
				else
					quick_text_image_visible = "style='display:none'";			

				histdatatype = rs.getString("HIST_DATA_TYPE") == null ? "" : rs.getString("HIST_DATA_TYPE");
				histrectype = rs.getString("HIST_REC_TYPE") == null ? "" : rs.getString("HIST_REC_TYPE");		
				accessionnum = rs.getString("ACCESSION_NUM") == null ? "" : rs.getString("ACCESSION_NUM");
				enctr_id = rs.getString("encounter_ID") == null ? "0" : rs.getString("encounter_ID");				 			
				eventdatetime = rs.getString("event_date_time") == null ? "" : rs.getString("event_date_time");
				modified_date = rs.getString("modified_date") == null ? "" : rs.getString("modified_date");//24094
				modified_date_YN = rs.getString("modifiedyn") == null ? "" : rs.getString("modifiedyn");//24094
				sortEventDateTime = rs.getString("sort_event_date") == null ? "" : rs.getString("sort_event_date");
				cal_eventdate 		= com.ehis.util.DateUtils.convertDate(eventdatetime,"DMYHM","en","en");//IN040090
				eventdatetime_th	= com.ehis.util.DateUtils.convertDate(eventdatetime,"DMYHM","en",locale);	
				 
				eventdate_hd = eventdatetime_th.substring(0,eventdatetime_th.indexOf(" "));
				histtypedesc = rs.getString("hist_rec_type_desc")==null?"":rs.getString("hist_rec_type_desc");	
				eventclassdesc = rs.getString("event_class_desc") == null ? "" : rs.getString("event_class_desc");
				eventgroupdesc = rs.getString("event_group_desc")==null?"":rs.getString("event_group_desc");
				eventdesc = rs.getString("event_desc") == null ? "" : rs.getString("event_desc");
				resultstr = rs.getString("RESULT_STR")==null?"":rs.getString("RESULT_STR");
				lv_neonate_spec_yn = rs.getString("lv_neonate_spec_yn") == null ? "" : rs.getString("lv_neonate_spec_yn");//31792
				if(isClinician&&eventclassdesc.equals("Clinician Notes"))//IN067236
					eventclassdesc="Therapist Notes";//IN067236
				//IN054648 Start.
				resultstr  = resultstr.replaceAll("<","&lt;");
				resultstr  = resultstr.replaceAll(">","&gt;");
				//IN054648 End.
				//IN064688 Changes Starts
				//resultNum = rs.getString("RESULT_NUM") == null ? "0" : rs.getString("RESULT_NUM");
				BigDecimal rn =rs.getBigDecimal("RESULT_NUM");
				if(rn!=null)
					resultNum=rn.toString();
				else
					resultNum="0";
				//IN064688 Changes Ends
				encline = rs.getString("encline") == null ? "" : rs.getString("encline");
				encline = encline.replace('\'',' ');
				fac_id = rs.getString("FACILITY_ID") == null ? "" : rs.getString("FACILITY_ID");//IN033489
				range = "";
				
				extimageapplid = rs.getString("EXT_IMAGE_APPL_ID")==null?"":rs.getString("EXT_IMAGE_APPL_ID");
				extimageobjid = rs.getString("EXT_IMAGE_OBJ_ID")==null?"":rs.getString("EXT_IMAGE_OBJ_ID");//EMG
				extimagedocid = rs.getString("EXT_IMAGE_DOC_ID")==null?"":rs.getString("EXT_IMAGE_DOC_ID");//64369
				performed_by = rs.getString("clinician_short_name")==null?"":rs.getString("clinician_short_name");
				Specimen_num = rs.getString("Specimen_num") == null ? "" : rs.getString("Specimen_num");//IN066453
				categoryNum = rs.getString("CATEGORY_NUMBER") == null ? "" : rs.getString("CATEGORY_NUMBER");//IN066453
				resulted_practitioner = rs.getString("resulted_practitioner")==null?"":rs.getString("resulted_practitioner"); //IN064132
				 
				contr_sys_id = rs.getString("contr_sys_id") == null ? "" : rs.getString("contr_sys_id");
				contr_sys_event_code = rs.getString("contr_sys_event_code") == null ? "" : rs.getString("contr_sys_event_code");
				result_uom = rs.getString("RESULT_NUM_UOM")==null?"":rs.getString("RESULT_NUM_UOM");
				eventCode = rs.getString("event_code")==null?"":rs.getString("event_code");
				restricting_print = rs.getString("restricting_print") == null ? "N" : rs.getString("restricting_print"); ////IN069242
				specimen_type=rs.getString("specimen_type") == null ? "" : rs.getString("specimen_type");//7632
				//IN066453 -Start
		//IN071106, starts, commented
				/*StringTokenizer st = new StringTokenizer(Specimen_num,"#");
			while(st.hasMoreTokens())
	    {
		    Specimen_num1 = java.net.URLEncoder.encode((String)st.nextToken());
		    Specimen_num2 = java.net.URLEncoder.encode((String)st.nextToken());
		  if(st.hasMoreTokens())
		     Specimen_num2 = java.net.URLEncoder.encode((String)st.nextToken());
	
	    }*/	    
	   
		//	IN066453 -end
		//IN071106, ends, commented
				//IN064688 Changes Starts
				//normalrange1 = rs.getString("NORMAL_LOW")==null?"":rs.getString("NORMAL_LOW");				
				//normalrange2 = rs.getString("NORMAL_HIGH")==null?"": rs.getString("NORMAL_HIGH");
				//7902 STARTS
				if(!extimageapplid.equals("") && extimageapplid.equals("CPACS"))
				{
					ext_img_disable="disabled";
					
					pstmtImgView1 = con.prepareStatement("SELECT PARAM_DEF_STR  FROM CA_EXT_IMAGE_APPL_LANG_VW WHERE  EXT_IMAGE_APPL_ID=?"); 
					pstmtImgView1.setString(1,extimageapplid);
					resImgView1 = pstmtImgView1.executeQuery();
					
					while(resImgView1.next())
					{
						param_def_str = resImgView1.getString("PARAM_DEF_STR") == null ? "" : resImgView1.getString("PARAM_DEF_STR");
					}
					if(pstmtImgView1!=null) pstmtImgView1.close();
					if(resImgView1!=null) resImgView1.close();
					
					if(!param_def_str.equals("") && param_def_str.contains("~STUDY_ID`")){
						
						pstmtImgView = con.prepareStatement("SELECT A.study_id  FROM or_order_line a, cr_encounter_detail b WHERE B.EXT_IMAGE_APPL_ID =? AND to_char(a.ext_appl_accession_num) = b.ext_image_obj_id AND b.ext_image_obj_id=?"); 
						pstmtImgView.setString(1,extimageapplid);
						pstmtImgView.setString(2,extimageobjid);
						resImgView = pstmtImgView.executeQuery();
						
						while(resImgView.next())
						{
							study_id = resImgView.getString("STUDY_ID") == null ? "" : resImgView.getString("STUDY_ID");
						}
						
						if(pstmtImgView!=null) pstmtImgView.close();
						if(resImgView!=null) resImgView.close();
					
					}	
				}
				if(study_id.equals("null"))
					study_id="";
				if(!study_id.equals("") && param_def_str.contains("~STUDY_ID`"))
				{
					ext_img_disable="";
					ext_img_display="";
				} 
				else if(!study_id.equals("") && !param_def_str.contains("~STUDY_ID`"))
				{
					ext_img_disable="";
					ext_img_display="";
				} 
				else if(study_id.equals("") && param_def_str.contains("~STUDY_ID`") && extimageapplid.equals("CPACS"))
				{
					ext_img_disable="disabled";
					ext_img_display="Study ID not available, we cannot Proceed";
				}
				else if(study_id.equals("") && !param_def_str.contains("~STUDY_ID`"))
				{
					ext_img_disable="";
					ext_img_display="";
				}	//7902 ENDS
				BigDecimal nl =rs.getBigDecimal("NORMAL_LOW");
				if(nl!=null)
					normalrange1=nl.toString();
				else
					normalrange1="";
				BigDecimal nh =rs.getBigDecimal("NORMAL_HIGH");
				if(nh!=null)
					normalrange2=nh.toString();
				else
					normalrange2="";
				//IN064688 Changes Ends
				color_cell_indicator = rs.getString("COLOR_CELL_IND")==null?"":rs.getString("COLOR_CELL_IND");
				event_code_type  = rs.getString("EVENT_CODE_TYPE")==null?"":rs.getString("EVENT_CODE_TYPE"); // IN047204
				// added for Bru-HIMS-CRF-052.1  - Start
			
				ext_image_upld_id = rs.getString("EXT_IMAGE_UPLD_ID") == null ? "" : rs.getString("EXT_IMAGE_UPLD_ID");
				html_image_upld_id = rs.getString("HTML_IMAGE_UPLD_ID") == null ? "" : rs.getString("HTML_IMAGE_UPLD_ID");  //IN069028
				event_group = rs.getString("event_group") == null ? "" : rs.getString("event_group");//IN040416
				if(!ext_image_upld_id.equals(null) && !ext_image_upld_id.equals("")) {
					//contr_sys_event_code=event_group;//IN040416
					pstmtImgView = con.prepareStatement("select EXT_IMAGE_FILE_LOCN_PARAM from CR_EXT_IMAGE_UPLD where EXT_IMAGE_UPLD_ID = ?"); 
						
					pstmtImgView.setString(1,ext_image_upld_id);
					resImgView = pstmtImgView.executeQuery();
					
					while(resImgView.next())
					{
						ext_img_file_locn = resImgView.getString("EXT_IMAGE_FILE_LOCN_PARAM") == null ? "" : resImgView.getString("EXT_IMAGE_FILE_LOCN_PARAM");
					}
					
				//IN040866 - Start
					String perfFacilityId = "";
					pstmtPerFacId = con.prepareStatement("select  distinct b.performing_facility_id from or_order_line a,or_order b where a.order_id = b.order_id and a.accession_num = ?"); 
					pstmtPerFacId.setString(1,extimageobjid);
					rsetPerFacId = pstmtPerFacId.executeQuery();
					if(rsetPerFacId.next()){
						perfFacilityId = rsetPerFacId.getString("PERFORMING_FACILITY_ID") == null ? "":  rsetPerFacId.getString("PERFORMING_FACILITY_ID");
					}
				
				//IN040866 - End
					// IN052800 - Start
					if(perfFacilityId.equals("") || perfFacilityId == null){
						perfFacilityId = manageEmailBean.getOrderIdFromSpecimen(extimageobjid);
					}
					//IN052800 - End
					//IN065970 starts
					//IN071127 starts
					//pstmtImgCount = con.prepareStatement("select count(*) from rl_specimen_image_dtls where OPERATING_FACILITY_ID = ? and SPECIMEN_NO = ? and TEST_CODE = ?");
					//pstmtImgCount.setString(1,fac_id); commented for IN040866
					//pstmtImgCount.setString(1,perfFacilityId);// modified for IN040866
					/*pstmtImgCount = con.prepareStatement("select count(*) from rl_specimen_image_dtls where SPECIMEN_NO = ? and TEST_CODE = ?");
					pstmtImgCount.setString(1,extimageobjid);
					pstmtImgCount.setString(2,contr_sys_event_code);  //IN040416//IN068560
					//pstmtImgCount.setString(2,event_group); //IN040416
					//IN065970 ends
					rsetImgCount = pstmtImgCount.executeQuery();
					if(rsetImgCount.next()) 
					{
						recCount = rsetImgCount.getInt(1);
					}	*/
					 cs = con.prepareCall( "{ call rl_image_count(?,?,?,?,?,?)}" );
					cs.setString(1,contr_sys_event_code);
					cs.setString(2,accessionnum);
					cs.setString(3,eventCode);
					cs.setString(4,patientid);
					cs.registerOutParameter( 5,  java.sql.Types.VARCHAR ) ;
					cs.registerOutParameter( 6,  java.sql.Types.INTEGER ) ;
					cs.execute() ;
					out_event_code	= cs.getString( 5 ) ;
					 image_count	= cs.getInt( 6 ) ;
					//IN071127 ends
					//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",extimageobjid).replace("~test#",contr_sys_event_code).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",fac_id).replace("~user_id#",login_user_id).replace("~language_id#",locale); //commented for IN040866
					//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",extimageobjid).replace("~test#",contr_sys_event_code).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",perfFacilityId).replace("~user_id#",login_user_id).replace("~language_id#",locale); // modified for IN040866
					//IN065970 reopen starts
					//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",extimageobjid).replace("~test#",event_group).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",perfFacilityId).replace("~user_id#",login_user_id).replace("~language_id#",locale); // modified for IN040416
					//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",extimageobjid).replace("~test#",event_group).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",fac_id).replace("~user_id#",login_user_id).replace("~language_id#",locale); // IN065970 reopen ends
					//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",extimageobjid).replace("~test#",contr_sys_event_code).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",fac_id).replace("~user_id#",login_user_id).replace("~language_id#",locale); // IN065970 //IN071127
					ext_img_file_locn = ext_img_file_locn.replace("~specNum#",extimageobjid).replace("~test#",out_event_code).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",fac_id).replace("~user_id#",login_user_id).replace("~language_id#",locale); //IN071127
					if(resImgView  != null) resImgView.close();
					if(pstmtImgView != null) pstmtImgView.close();
					if(cs  != null)  cs.close();
					if(rsetImgCount  != null)  rsetImgCount.close();
					if(pstmtImgCount  != null) pstmtImgCount.close();

					if(rsetPerFacId  != null) rsetPerFacId.close();
					if(pstmtPerFacId  != null) pstmtPerFacId.close();	
				}	
				
				// End
				if(include_normalcy_indicator.equals("I"))
					color_cell_indicator = rs.getString("SYMBOL_LEGEND_IND") == null ? "" : rs.getString("SYMBOL_LEGEND_IND");
				descCellInd = rs.getString("DESC_CELL_IND") == null ? "" : rs.getString("DESC_CELL_IND");				
				normalcy_ind = rs.getString("normalcy_ind") == null ? "" : rs.getString("normalcy_ind");
				normalcy_str = rs.getString("normalcy_str") == null ? "" : rs.getString("normalcy_str");

				criticalrange1 = rs.getString("CRITICAL_LOW");
				if (criticalrange1 == null) criticalrange1 = "";

				criticalrange2 = rs.getString("CRITICAL_HIGH");
				if (criticalrange2 == null) criticalrange2 = "";

				resultStatus= rs.getString("resultStatus") == null ? "" : rs.getString("resultStatus");	//29803
				strStatus = rs.getString("STATUS");
				if(strStatus == null) 
					strStatus = "";

				delta_fail_id_ind = rs.getString("DELTA_FAIL_IND");
				if(delta_fail_id_ind == null) delta_fail_id_ind = "";
				
				deciresult =rs.getString("RESULT_NUM1") == null ? "0" : rs.getString("RESULT_NUM1");//IN037900
				decival = rs.getString("RESULT_NUM_DEC") == null ? "0" : rs.getString("RESULT_NUM_DEC");//IN037900
				
				resultstr=replaceSpecialChar(resultstr);
				//IN031989 Starts
				try
		{
			if(	episode_type.equals("O") )
			{
						/*query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ?"; //uncommentted - [IN033977 for IN040199] //IN045646 get_desc for specialty_name changed from 2 to 1*/
						//query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy') ,'') DISCHARGE_DATE_TIME_1,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ?"; //IN067016//commented for IN066807
				//query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN a.PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(A.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(A.FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH,C.ADDED_DATE) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'2') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER A,MP_PATIENT B,ca_encntr_note c	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? AND  c.accession_num = ?"; //[IN033977 revert changes for IN040199]
				query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,ca_get_attend_pract_list (a.patient_id,a.encounter_id,a.facility_id) attending_pract_list,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy') ,'') DISCHARGE_DATE_TIME_1,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ?"; //IN066807
			}
			else
			{ 
						/*query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? "; //uncommentted - [IN033977 for IN040199] //IN045646 get_desc for specialty_name changed from 2 to 1*/
						//query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy') ,'') DISCHARGE_DATE_TIME_1,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? "; //IN067016//commented for IN066807
				//query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN a.PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(A.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(A.FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH,C.ADDED_DATE) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'2') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER A,MP_PATIENT B ,ca_encntr_note C	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? AND  c.accession_num = ?";  //[IN033977 revert changes for IN040199]
				query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,ca_get_attend_pract_list (a.patient_id,a.encounter_id,a.facility_id) attending_pract_list,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy') ,'') DISCHARGE_DATE_TIME_1,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? ";//IN066807
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
			//pstmt1.setString	(	13,	accessionnum); //[IN033977 for IN040199]
			
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
				bed_number	=	rs1.getString("bed_number")==null?"":rs1.getString("bed_number");	  //--[IN:029839]--
				performing_phy_name	=	rs1.getString("performed_by_name")==null?"":rs1.getString("performed_by_name");
				age				=	rs1.getString("AGE")==null?"":rs1.getString("AGE");
				gender					=	rs1.getString("gender")==null?"":rs1.getString("gender");
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
				//IN031989 Ends
		if("0".equals(enctr_id)){
			try{
				query_privilege_type	=	"SELECT  get_age (b.date_of_birth) age, DECODE (?,'en', b.patient_name, NVL (b.patient_name_loc_lang, b.patient_name)) patient_name, sex gender FROM mp_patient b WHERE  PATIENT_ID=? "; 
				
		
				pstmt1	=	con.prepareStatement(query_privilege_type);						
				pstmt1.setString	(	1,	locale	);
				pstmt1.setString	(	2,	patientid	);
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
		
				
		//--[IN042733] - Start
		
		try{
				pstmt1	= con.prepareStatement("select patient_name patient_name,deceased_yn,to_Char(deceased_date,'dd/mm/yyyy hh24:mi') deceased_date from mp_patient where patient_id = ?");//IN040205
				pstmt1.setString(1,patientid);
				rs1 = pstmt1.executeQuery();
				//Date newDeceasedDt = null; //IN050584
				//Date new_event_date_time = null; //IN050584
				String deceased_yn="";
				String deceased_date = "";
				

					while(rs1.next())
					{
						default_pat_name	= rs1.getString("patient_name") == null ? "" : rs1.getString("patient_name");
					
						deceased_yn			= rs1.getString("deceased_yn") == null ? "" : rs1.getString("deceased_yn");
						deceased_date		= rs1.getString("deceased_date") == null ? "" : rs1.getString("deceased_date");
							
						//IN050584 Starts
						/*if(!"".equals(deceased_date))
						{
							newDeceasedDt = 	new SimpleDateFormat("dd/mm/yyyy mm:ss").parse(deceased_date);
						}
						
						if(!"".equals(cal_eventdate))
						{
							new_event_date_time = 	new SimpleDateFormat("dd/mm/yyyy mm:ss").parse(cal_eventdate);
						}
						
					
						if("Y".equals(deceased_yn) && null!=new_event_date_time && null!=newDeceasedDt && new_event_date_time.after(newDeceasedDt) )
						{
							cal_eventdate = com.ehis.util.DateUtils.convertDate(deceased_date,"DMYHM","en","en");
						}*/
					}
					if(rs1 != null) rs1.close();
					if(pstmt1 != null) pstmt1.close();
						
					String eventdate_isAfter_decdate = "";
					pstmt1	= con.prepareStatement("SELECT CASE WHEN TO_DATE (?, 'dd/mm/yyyy hh24:mi') > TO_DATE (?, 'dd/mm/yyyy hh24:mi') THEN 'Y'  ELSE 'N' END eventdate_isAfter_decdate FROM DUAL");
					pstmt1.setString(1,cal_eventdate);
					pstmt1.setString(2,deceased_date);
					
					rs1 = pstmt1.executeQuery();
					
					while(rs1.next())
					{
						eventdate_isAfter_decdate = rs1.getString("eventdate_isAfter_decdate");
					}
					
					if("Y".equals(eventdate_isAfter_decdate))
					{
						cal_eventdate = com.ehis.util.DateUtils.convertDate(deceased_date,"DMYHM","en","en");
					}
					//IN050584 Ends	
		}
		catch(Exception ee)
		{
			//out.println("Exceptionin ExpandedClinicalEvent.jsp @ pstmt1 : "+ee.toString());//COMMON-ICN-0181
			ee.printStackTrace();
		}
		finally
		{
			if(rs1 != null) rs1.close();
			if(pstmt1 != null) pstmt1.close();
		}
		
		//--[IN042733] - End
				
				
				//INO30714 Starts
				String footer_code = null;//IN030859
				String report_header_code = null;//IN030859				
								try
								{
									String head_foot_qry ="select a.FOOTER_CODE,a.REPORT_HEADER_CODE from ca_note_type a where  a.NOTE_TYPE=?";
									pstmt2	= con.prepareStatement(head_foot_qry);
									pstmt2.setString(1,contr_sys_event_code);
									rs2 = pstmt2.executeQuery();
									
									while(rs2.next())
									{
										//note_header_code = rs2.getString("NOTE_HEADER_CODE")==null?"":rs2.getString("NOTE_HEADER_CODE");
										footer_code = rs2.getString("FOOTER_CODE")==null?"":rs2.getString("FOOTER_CODE");
										report_header_code = rs2.getString("REPORT_HEADER_CODE")==null?"":rs2.getString("REPORT_HEADER_CODE");
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
												out.println("Exception@1-readCLOB : "+e);
												e.printStackTrace();
											}


										}
									}
								}

								catch(Exception eee)
								{
									//out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());//COMMON-ICN-0181
									eee.printStackTrace();

								}
								finally
								{
									if(rs2 != null) rs2.close();
									if(pstmt2 != null) pstmt2.close();
									
								}
							if(!accessionnum.equals(""))
							{
								try
								{
									//String athorise_by_qry ="select AM_GET_DESC.AM_PRACTITIONER(a.AUTHORIZED_BY_ID,?,'1') AUTHORIZED_BY_ID,AM_GET_DESC.AM_PRACTITIONER(a.LAST_AMENDED_BY_ID,?,'1') LAST_AMENDED_BY_ID,a.DOC_REF_ID,AM_GET_DESC.AM_PRACTITIONER(a.PERFORMED_BY_ID,?,'1') performed_by_name,AM_GET_DESC.AM_SERVICE(a.SERVICE_CODE,?,'2') service_name from CA_ENCNTR_NOTE a where a.ACCESSION_NUM = ? and a.PATIENT_ID = ? " ;//Commented for IN065834
									String athorise_by_qry ="select AM_GET_DESC.AM_PRACTITIONER(a.AUTHORIZED_BY_ID,?,'1') AUTHORIZED_BY_NAME,a.AUTHORIZED_BY_ID AUTHORIZED_BY_ID,AM_GET_DESC.AM_PRACTITIONER(a.LAST_AMENDED_BY_ID,?,'1') LAST_AMENDED_BY_ID,a.DOC_REF_ID,AM_GET_DESC.AM_PRACTITIONER(a.PERFORMED_BY_ID,?,'1') performed_by_name,AM_GET_DESC.AM_SERVICE(a.SERVICE_CODE,?,'2') service_name,CONTR_MOD_ACCESSION_NUM from CA_ENCNTR_NOTE a where a.ACCESSION_NUM = ? and a.PATIENT_ID = ? " ;//Modified for IN065834

									pstmt2	= con.prepareStatement(athorise_by_qry);
									pstmt2.setString(1,locale);
									pstmt2.setString(2,locale);
									pstmt2.setString(3,locale);
									pstmt2.setString(4,locale);
									//IN052367 - Start
									if(accessionnum.contains("!"))
										acc_for_notefooter = extimageobjid;
									else
										acc_for_notefooter = accessionnum;
									pstmt2.setString(5,acc_for_notefooter);
									//pstmt2.setString(5,accessionnum);
									//IN052367 - End
									pstmt2.setString(6,patientid);
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
										contr_mod_acc_num		=	 rs2.getString("CONTR_MOD_ACCESSION_NUM")==null?"":rs2.getString("CONTR_MOD_ACCESSION_NUM") ;//IN030996
									}
								}
								catch (Exception roro )

								{
									//out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+roro.toString());//COMMON-ICN-0181
									roro.printStackTrace();

								}
								finally 
								{
									if(rs2 != null) rs2.close();
									if(pstmt2 != null) pstmt2.close();
									
								}
								//IN069484 Start.
								if(!"".equals(authorized_by_id)){
									
									try{
										pstmt2	= con.prepareStatement("SELECT PRACTITIONER_SIGN FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=?");
										pstmt2.setString(1,authorized_by_id);
										rs2 = pstmt2.executeQuery();
										while(rs2 !=null && rs2.next()){						
											java.sql.Blob img_blob  =  (java.sql.Blob)rs2.getBlob("PRACTITIONER_SIGN");
											if(img_blob!=null){//IN071865 starts
											byte[] bytes = img_blob.getBytes(1, (int)img_blob.length()); 						
											authorized_sign = new String(org.apache.commons.codec.binary.Base64.encodeBase64(bytes), "UTF-8");
											}// IN071865 ends
										}
									}catch(Exception se){
										se.printStackTrace();
									}finally
									{
										if(rs2 != null) rs2.close();
										if(pstmt2 != null) pstmt2.close();
									}
								}
								//IN069484 End.
							}
							encounter_id1 = enc_id ;
							if(enc_id.equals("0"))
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
					             discharge_date_only					=	com.ehis.util.DateUtils.convertDate(discharge_date_only,"DMY","en",locale);
				            }//IN067016--ends



							//out.println("RecClinicalNotesPrint.jsp:patient_name:"+patient_name);
							htParameter.put("V$ATT_PRACT", attending_practitioner);
							htParameter.put("V$ATT_PRACT_LT", attending_practitioner_list);//IN066807
							htParameter.put("V$ADM_PRACT", admitting_practitioner);
							htParameter.put("V$BED_NUM", bed_number);	//---[IN:029839]---
							htParameter.put("V$PT_SPLTY", speciality_name);
							//--[IN029296]  - Start
							if(patient_name.trim().equals(""))
								htParameter.put("V$PT_NAME", default_pat_name);
							else
								htParameter.put("V$PT_NAME", patient_name);
							//--[IN029296]  - End
							htParameter.put("V$PT_ID", patientid);
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
								paramHash.put("#p_patient_id#",patientid);
								//IN042046 starts
								//paramHash.put("#p_encounter_id#",encounter_id1);
								paramHash.put("#p_encounter_id#",enctr_id);
								
								//IN042046 ends
								paramHash.put("#p_accNum#",accessionnum);
								paramHash.put("#p_locale#",locale);
								paramHash.put("#p_eventDate#",cal_eventdate);//IN039562//IN040090
								//IN042046 starts
								//paramHash.put("#p_facility_id#",facility_id);//IN038439
								paramHash.put("#p_facility_id#",fac_id);
								//IN065834 changes starts
								//paramHash.put("#p_contr_mod_accession_num#",contr_mod_accession_num); //Commented for IN065834
								if(contr_mod_accession_num.equals("")){
									if(accessionnum !=null && accessionnum.contains("!")){
										String[] keyValues=accessionnum.split("!");
										contr_mod_acc_num=keyValues[1];
										paramHash.put("#p_contr_mod_accession_num#",contr_mod_acc_num);
									}
									else{
									paramHash.put("#p_contr_mod_accession_num#",contr_mod_acc_num);
									}
								}
								else
									paramHash.put("#p_contr_mod_accession_num#",contr_mod_accession_num);
								//IN065834 changes ends
								
								
								//IN042046 ends
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
										//out.println("Exception@1-readCLOB : "+e);//COMMON-ICN-0181
										e.printStackTrace();
									}


								}
							}
						}

						catch(Exception eee)
						{
							out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());
							eee.printStackTrace();

						}
						finally
						{
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
							paramHash.put("#p_accNum#",accessionnum);
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
					//INO30714 Ends
				//6484 Start.	
				if("Y".equals(rs.getString("compress_hist_data_yn")==null?"N":(String)rs.getString("compress_hist_data_yn"))){
					
					java.sql.Blob note_blob =  (java.sql.Blob)rs.getBlob("compress_hist_data");
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
									displaydata.append(line+"\n");
								}
							}					
						}
					}
					displaydata.append((rs.getString("comments")==null?"":(String)rs.getString("comments")));
				}else{	
				//6484 End.
					note=rs.getClob("HIST_DATA");				
					if(note!=null)
					{
						r = new java.io.BufferedReader(note.getCharacterStream());
						String line = null;	
						//displaydata.append("<table border='2'cellpadding='0' cellspacing='4' width='100%'><tr><td>"+section_content_rpt+"</td></tr></table><BR>");//INO30714					
						while((line=r.readLine()) != null) displaydata.append(line+"\n");
						//displaydata.append("<table border='2'cellpadding='0' cellspacing='4' width='100%'><tr><td>"+section_content_ftr+"</td></tr></table><BR>");//INO30714					
					}
					displaydata.append((rs.getString("comments")==null?"":(String)rs.getString("comments"))); //6484
				} //6484
				if( histdatatype.equals("HTM") || histdatatype.equals("HTML") )
				{
				   if("N".equals(dis_clin_note_wt_metadata_yn) || ("Y".equals(dis_clin_note_wt_metadata_yn) && !histrectype.equals("CLNT")))  //52560
				    {
					   data= "<table border='2'cellpadding='0' cellspacing='4' width='100%'><tr><td>"+section_content_rpt+"</td></tr></table><BR>";//IN030859
				    } //52560
					//data=resultstr+" "+displaydata.toString();//IN030859
					//[IN032246] Start.
					//data=data+""+resultstr+" "+displaydata.toString();//IN030859
					//IN043087 Start.
					//IN056146 Start.
					//String displaydataTemp = ((String)(displaydata.toString()).replaceAll("<address>&nbsp;</address>","").replaceAll("<ADDRESS>&nbsp;</ADDRESS>","").replaceAll("<DIV align=left> <ADDRESS><FONT size=3></FONT>&nbsp;</ADDRESS></DIV>","")).trim();
					//String displaydataTemp = ((String)(displaydata.toString()).replaceAll("<DIV align=left> <ADDRESS><FONT size=3></FONT>&nbsp;</ADDRESS></DIV>","")).trim();//IN068396
					String displaydataTemp = ((String)(displaydata.toString()).replaceAll("<DIV align=left> <ADDRESS><FONT size=3></FONT>&nbsp;</ADDRESS></DIV>","").replaceAll("line-height: 100%"," ")).trim();//IN068396
					//IN056146 End.
					data=data+"<PRE style='word-wrap:break-word;'>"+resultstr+"</PRE> <PRE style='word-wrap:break-word;'>"+displaydataTemp+"</PRE>";
					//data=data+"<PRE style='word-wrap:break-word;'>"+resultstr+"</PRE> <PRE style='word-wrap:break-word;'>"+displaydata.toString()+"</PRE>";
					//IN043087 End.
					//[IN032246] End.
					data= data+"<table border='2'cellpadding='0' cellspacing='4' width='100%'><tr><td>"+section_content_ftr+"</td></tr></table><BR>";//IN030859
					//IN058156 Start.
					if("CLNT".equals(histrectype) && "CA".equals(contr_sys_id))
						data = data+"<a style='cursor:pointer;color:blue' onClick=\"showNotesAuditFlow('"+accessionnum+"')\"><u>Audit Link</u></a>";
					//IN058156 End.	
				}
				else
				{					
					if(displaydata.length() >0)
					{
						//data=resultstr+"<br/><textarea align='ABSLEFT' style='FONT-FAMILY:Courier New;FONT-SIZE: 8pt' rows='10' cols='100' readOnly>"+displaydata.toString()+"</textarea>";	
						//[IN032246] Start.
						//data="<br/>"+resultstr+"<br/><textarea align='ABSLEFT' style='FONT-FAMILY:Courier New;FONT-SIZE: 8pt' rows='10' cols='100' readOnly>"+displaydata.toString()+"</textarea>";	
						//data = "<br/><PRE style='word-wrap:break-word;'>"+resultstr+"</PRE><br/><PRE style='word-wrap:break-word;'>"+displaydata.toString()+"</PRE>"; //Ramesh //IN068396
						data = "<br/><PRE style='word-wrap:break-word;'>"+resultstr+"</PRE><br/><PRE style='word-wrap:break-word;'>"+(displaydata.toString()).replaceAll("line-height: 100%"," ")+"</PRE>"; //IN068396
						//[IN032246] End.
					}
					else{
						//data=resultstr+" "+displaydata.toString();//IN068396
						data=resultstr+" "+(displaydata.toString()).replaceAll("line-height: 100%"," ");//IN068396
					}
				}

				if(keyList.contains(enctr_id+"`"+histrectype+"`"+contr_sys_id+"`"+accessionnum+"`"+contr_sys_event_code))
				{
					displayStyle = "gridDataChart";
					chkSelBox="checked";
				}					
				else
				{
					displayStyle = "gridDataChart";
					chkSelBox="";
				}
				
				if(histdatatype.equals("NUM"))
				{
				//IN064688 Starts
				//resultNum = rs.getString("RESULT_NUM") == null ? "0" : rs.getString("RESULT_NUM");
				BigDecimal rn1 =rs.getBigDecimal("RESULT_NUM");
				if(rn1!=null)
					resultNum=rn1.toString();
				else
					resultNum="";
				//IN064688 Ends
					String numFormat = "&nbsp;&nbsp;&nbsp;&nbsp;";
					if(rs.getString("RESULT_NUM_PREFIX") != null && !(rs.getString("RESULT_NUM_PREFIX")).equals(""))
					//[IN034973] Start
					//data = data + rs.getString("RESULT_NUM_PREFIX");
						//data = data + (rs.getString("RESULT_NUM")==null?"":rs.getString("RESULT_NUM"))+"  "+( rs.getString("RESULT_NUM_UOM")==null?"":rs.getString("RESULT_NUM_UOM"));
					{
						numFormat= numFormat +  rs.getString("RESULT_NUM_PREFIX");
					}
					/*//IN037900 Start
					if(decival.length()>0 && deciresult.length()> 9)	
						numFormat= numFormat +  "&nbsp;&nbsp;&nbsp;&nbsp;"+ (rs.getString("RESULT_NUM1")==null?"":rs.getString("RESULT_NUM1"))+"  "+( rs.getString("RESULT_NUM_UOM")==null?"":rs.getString("RESULT_NUM_UOM"));
					else
						numFormat= numFormat +  "&nbsp;&nbsp;&nbsp;&nbsp;"+ (rs.getString("RESULT_NUM")==null?"":rs.getString("RESULT_NUM"))+"  "+( rs.getString("RESULT_NUM_UOM")==null?"":rs.getString("RESULT_NUM_UOM"));
					//IN037900 end	*/ //Commented for IN064688
					numFormat= numFormat +  "&nbsp;&nbsp;&nbsp;&nbsp;"+ resultNum +"  "+( rs.getString("RESULT_NUM_UOM")==null?"":rs.getString("RESULT_NUM_UOM"));

					//data = numFormat  + data;//commented for IN063813
					//[IN034973] End.
					result_uom = rs.getString("RESULT_NUM_UOM")==null?"":rs.getString("RESULT_NUM_UOM");
					
					//Added by Jyothi.G on 09/12/2010 to fix IN025310
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
						toolTip.append(normalrange+"<br> "+criticalrange);
					else if(!normalrange.equals(""))
						toolTip.append(normalrange);
					else if(!criticalrange.equals(""))
						toolTip.append(criticalrange);
					else
						toolTip.append("");//END
					//IN064132 changes starts
					/*
					if(!performed_by.equals(""))
					{
						if(!(toolTip.toString()).equals(""))
							toolTip.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Performed.label","common_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels")+" : "+ performed_by );
					}
					*/
					if(isPracSiteSpecific && "LBIN".equals(histrectype))
					{
						if(!resulted_practitioner.equals(""))
						{	
							if(!(toolTip.toString()).equals("")){
								//if(isVerifiedSiteSpec)//IN069290 added Verified By //7632
									toolTip.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VerifiedBy.label","common_labels")+" : "+ resulted_practitioner );
								/* 7632 else
									toolTip.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Performed.label","common_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels")+" : "+ resulted_practitioner );
										*/
							}
						}
					}else 
					{
						if(!performed_by.equals(""))
						{
							if(!(toolTip.toString()).equals("")){
								//if(isVerifiedSiteSpec)//IN069290 added Verified By//7632
									toolTip.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VerifiedBy.label","common_labels")+" : "+ performed_by );
								/*7632 else
									toolTip.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Performed.label","common_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels")+" : "+ performed_by );
									*/
							}
						}
					}
					//IN069290start
					if(!encline.equals("") ){//removed isVerifiedSiteSpec 7632
						encline = encline.replaceAll("Performed By :","Verified By :");
					}
					//IN069290 ends
					StringBuffer sbtoolTip= new StringBuffer();
					sbtoolTip.append(toolTip.toString());
					// IN066453 -Start
		                if("LBIN".equals(histrectype) && contr_sys_id.equals("LB"))
			         	{
		                	Specimen_num2 = extractSpecimenNumber(accessionnum,"#","@");//IN071106
								//toolTip.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SpecimenNo.label","or_labels")+" : " + Specimen_num2+"<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CategoryNo.label","or_labels")+" : " + categoryNum+"<BR>");
								toolTip.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SpecimenNo.label","or_labels")+" : " + Specimen_num2+"<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CategoryNo.label","or_labels")+" : " + categoryNum+"<BR>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SpecimenType.label","or_labels")+" : " + specimen_type);//7632
							sbtoolTip.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SpecimenNo.label","or_labels")+" : " + Specimen_num2+"<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CategoryNo.label","or_labels")+" : " + categoryNum+"<BR>");
						}
			// IN066453 -end
					//IN064132 Changes ends
									
					range = toolTip.toString();
					//IN063813 changes starts
					if("".equals(range))
						data = numFormat  +  data;
					else
						data = numFormat  +"<br><br>"+sbtoolTip.toString()+"<br><br>"+data; 
					//IN063813 changed ends
				}
				else if(histdatatype.equals("STR"))
				{
					data = data;

					if(!normalcy_str.equals(""))
					{
						data = data + " <font color=blue>( Normal Value : " + normalcy_str + " )</font>";
					}
				}				
				// IN066453 -Start
				if("LBIN".equals(histrectype) && !histdatatype.equals("NUM") && contr_sys_id.equals("LB"))
			    {
					  if((range.toString()).equals("")){
						  Specimen_num2 = extractSpecimenNumber(accessionnum,"#","@");//IN071106
						//range = "<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SpecimenNo.label","or_labels")+" : " + Specimen_num2 +"<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CategoryNo.label","or_labels")+" : " + categoryNum +"<BR>";
						  range = "<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SpecimenNo.label","or_labels")+" : " + Specimen_num2 +"<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CategoryNo.label","or_labels")+" : " + categoryNum +"<BR>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SpecimenType.label","or_labels")+" : " + specimen_type;//7632
						//data = data +range;
						data = data + "<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SpecimenNo.label","or_labels")+" : " + Specimen_num2 +"<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CategoryNo.label","or_labels")+" : " + categoryNum +"<BR>";
					  }
				}
				// IN066453 -end

			/*	if(!extimageapplid.equals(""))
				{
					data = data + "&nbsp;"+ "<img src='../../eCA/images/"+extimageapplid+".gif' onClick=\" getFile('"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"','"+extimageapplid+"')\">";
				}*/
				if(!extimageapplid.equals(""))
				{
					if(!("DMS").equals(extimageapplid)) { // IN049533
						if(!("DOCUL").equals(extimageapplid) && (ext_image_upld_id.equals(null) || ext_image_upld_id.equals("")))  // modified for IN040237 - START
						//if(!("DOCUL").equals(extimageapplid)) //Condition added for EMG  // modified for IN040237
						{
							//IN050936 included patientid
							if(ext_img_disable.equals("disabled")){
								data = data + "&nbsp;"+ "<br><a class='gridLink'> ";
								data = data + "&nbsp;"+"<img src='../../eCA/images/"+extimageapplid+".gif' width='16' height='16' border=0 "+ext_img_disable+" alt='"+ext_img_display+"'></a>";
							}else{
								data = data + "&nbsp;"+ "<img src='../../eCA/images/"+extimageapplid+".gif' "+ext_img_disable+" onClick=\"return getFile('"+histrectype+"','"+contr_sys_id+"','"+extimageobjid+"','"+contr_sys_event_code+"','"+extimageapplid+"','"+patientid+"')\"  alt='"+ext_img_display+"' >";	
							}
							//64369 Start.
							if("DOCAT".equals(extimagedocid)){
								data = data + "&nbsp;&nbsp;"+ "<img src='../../eCA/images/"+extimagedocid+".gif'  onClick=\"return getFile('"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"','"+extimagedocid+"','"+patientid+"')\"  alt='' >";	
							}
							//64369 End.
							
						}
						else  if (ext_image_upld_id.equals(null) || ext_image_upld_id.equals(""))
						{
							//IN050936 included patientid
							if(ext_img_disable.equals("disabled")){
								data = data + "&nbsp;"+ "<br><a class='gridLink'> ";
								data = data + "&nbsp;"+"<img src='../../eCA/images/"+extimageapplid+".gif' width='16' height='16' border=0 "+ext_img_disable+" alt='"+ext_img_display+"'></a>";
							}else{
								data = data + "&nbsp;"+ "<img src='../../eCA/images/"+extimageapplid+".gif' "+ext_img_disable+"  onClick=\"return getFile('"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"','"+extimageapplid+"','"+patientid+"')\"  alt='"+ext_img_display+"' >";	
							}
						}
						//else if((!ext_image_upld_id.equals(null) && !ext_image_upld_id.equals("")) && image_count > 0) { //IN071127
						else if((!ext_image_upld_id.equals(null) && !ext_image_upld_id.equals("")) && image_count > 0) {//IN071127
							data = data + "&nbsp;"+"<a style='cursor:pointer;color:blue' "+ext_img_disable+"  onClick=\"viewUploadedImg('"+ext_img_file_locn+"')\"> View Image </a>";
						}
					} // IN049533
				}
				// added for IN047204 - Start
				//IN069028 Start.
				if(!html_image_upld_id.equals(""))
				{					
					data = data + "&nbsp;"+ "<img src='../../eCA/images/IniAss.png' onClick=\"return getFile_SH('"+java.net.URLEncoder.encode(accessionnum)+"')\">";
				}
				//IN069028 End.				
				if("Y".equals(dmsExternalLinkYN)) {// && "RD".equals(event_code_type)) { // commented for  Bru-HIMS-CRF-195.3 - IN047205 
					 
					extLinkHashMap = manageEmailBean.getExternalLinkParameters(facilityId, patientid, encounter_id, locale); 
					
					admit_date	= (String) extLinkHashMap.get("P_ENCNTR_DATE");
					locn_code	= (String) extLinkHashMap.get("P_LOCN_CODE");
					locn_type	= (String) extLinkHashMap.get("P_LOCN_TYPE");
					visit_id	= (String) extLinkHashMap.get("P_VISIT_ID");
					loc_desc	= (String) extLinkHashMap.get("P_LOC_DESC");
					physician_id	= (String) extLinkHashMap.get("P_PHYSICIAN_ID");
					encntr_type	= (String) extLinkHashMap.get("P_EPISODE_TYPE");
					externalList = oEncounterList.getExternalLinkdata(histrectype, contr_sys_id, accessionnum, contr_sys_event_code); //Bru-HIMS-CRF-195.3 - IN047205 - Start
					Iterator iter = externalList.iterator(); 
					while(iter.hasNext()){
						externalDataDTO = (eCA.CAExternalLinkDataDTO)iter.next();
						ext_image_appli_id = externalDataDTO.getExt_image_appl_id();
						ext_image_obj_id = externalDataDTO.getExt_image_obj_id();
						ext_image_source = externalDataDTO.getExt_image_source();
						ext_srce_doc_ref_no = externalDataDTO.getSrce_doc_ref_no();
						ext_srce_doc_ref_line_no = externalDataDTO.getSrce_doc_ref_line_no();	
					
						if("RD".equals(event_code_type)) { 		//Bru-HIMS-CRF-195.3 - IN047205 - End
	
							//Fix for IN047566/Start
							//access_no_rd 	= accessionnum.substring(accessionnum.indexOf("#")+1, accessionnum.indexOf("$"));
							if ((extimageobjid.equals(null) || extimageobjid.equals(""))) 
								access_no_rd 	= accessionnum.substring(accessionnum.indexOf("#")+1, accessionnum.indexOf("$"));
							else
								access_no_rd 	= extimageobjid;
							//Fix for IN047566/End						
							
							pstmtOrderId = con.prepareStatement("select  order_id, order_type_code from or_order_line where accession_num = ?"); 
							pstmtOrderId.setString(1,access_no_rd);
							rsetOrderId = pstmtOrderId.executeQuery();
							if(rsetOrderId.next()){
								order_id 		= rsetOrderId.getString("order_id") == null ? "":  rsetOrderId.getString("order_id");
								order_typ_code	= rsetOrderId.getString("order_type_code") == null ? "":  rsetOrderId.getString("order_type_code");	
							}
							
							if(rsetOrderId  != null) rsetOrderId.close();
							if(pstmtOrderId  != null) pstmtOrderId.close();
							//data = data + "&nbsp;"+ "<img src='../../eCommon/images/ExternalDocument.PNG' title='External Link' onClick=\"return getExtLink('"+patientid+"','"+encounter_id+"','"+accessionnum+"','"+order_id+"','"+facilityId+"','"+locale+"','"+login_user_id+"','"+resp_id+"','"+login_at_ws_no+"','"+order_typ_code+"','"+visit_id+"','"+physician_id+"','"+locn_type+"','"+locn_code+"','"+admit_date+"','"+encntr_type+"','"+loc_desc+"')\">";//IN47847 Added title to img tag -- Bru-HIMS-CRF-195.3 - IN047205 - Commented
							data = data + "&nbsp;"+ "<img src='../../eCommon/images/ExternalDocument.PNG' title='External Link' onClick=\"return getExtLink('"+patientid+"','"+encounter_id+"','"+accessionnum+"','"+order_id+"','"+fac_id+"','"+locale+"','"+login_user_id+"','"+resp_id+"','"+login_at_ws_no+"','"+order_typ_code+"','"+visit_id+"','"+physician_id+"','"+locn_type+"','"+locn_code+"','"+admit_date+"','"+encntr_type+"','"+loc_desc+"','"+ext_image_appli_id+"','"+ext_image_obj_id+"','"+ext_image_source+"','"+ext_srce_doc_ref_no+"','"+ext_srce_doc_ref_line_no+"')\">"; //Bru-HIMS-CRF-195.3 - IN047205 - Modified // IN049589 Passing peforming facility_id[fac_id] instead of login facility_id[facility_id]
						}	//Bru-HIMS-CRF-195.3 - IN047205 - Start
						else {
							data = data + "&nbsp;"+ "<img src='../../eCommon/images/ExternalDocument.PNG' title='External Link' onClick=\"return getExtLink('"+patientid+"','"+encounter_id+"','"+accessionnum+"','"+order_id+"','"+fac_id+"','"+locale+"','"+login_user_id+"','"+resp_id+"','"+login_at_ws_no+"','"+order_typ_code+"','"+visit_id+"','"+physician_id+"','"+locn_type+"','"+locn_code+"','"+admit_date+"','"+encntr_type+"','"+loc_desc+"','"+ext_image_appli_id+"','"+ext_image_obj_id+"','"+ext_image_source+"','"+ext_srce_doc_ref_no+"','"+ext_srce_doc_ref_line_no+"')\">";  // IN049589 Passing peforming facility_id[fac_id] instead of login facility_id[facility_id]
						}
					}	//Bru-HIMS-CRF-195.3 - IN047205 - End
				}
				// added for IN047204 - End
				// added for Bru-HIMS-CRF-052.1 [IN037793]  commented for IN040237
				/*if((!ext_image_upld_id.equals(null) && !ext_image_upld_id.equals("")) && recCount > 0) {
					//out.println("<a style='cursor:pointer;color:blue' onClick=\"viewUploadedImg('"+ext_image_obj_id+"','"+contrSysEventCode+"','','','"+recCount+"','"+facility_id+"')\"> View Image </a>");
					data = data + "&nbsp;"+"<a style='cursor:pointer;color:blue' onClick=\"viewUploadedImg('"+ext_img_file_locn+"')\"> View Image </a>";
				}*/
				//IN070610, starts
				String l_upload_view = "N";
				Integer l_rec_cnt = 0;
				
				if(uploadFuncTrOrders)
					l_rec_cnt = Integer.parseInt(rs.getString("uploaded_doc_cnt"));
				
				System.out.println("l_rec_cnt=>"+l_rec_cnt+",uploadFuncTrOrders=>"+uploadFuncTrOrders);
				
				if(l_rec_cnt > 0 && "TRET".equals(histrectype) && uploadFuncTrOrders)
				{
					l_upload_view = "Y";
				}							
				
				if("Y".equals(l_upload_view))								
					data = data + "<a style='cursor:pointer;color:blue' onClick=\"uploadedDocuments('"+accessionnum+"','"+contr_sys_event_code+"')\"><img src='../../eOR/images/DOCUL.gif' width='16' height='16' border=0 alt='Uploaded Documents'/></a>";
				//IN070610, ends
								
				if(strStatus.equals("P") || resultStatus.equals("4"))
					data = data +" <font color='red'>(Preliminary)</font>";

				if(include_normalcy_indicator.equals("I") && !include_normalcy_indicator.equals(""))
				{
					if(!color_cell_indicator.equals("NONE"))
						data = "<font  style='background-image:url(\"../../eCA/images/"+color_cell_indicator+"\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
					else if(normalcy_ind.equals("."))
					{
						data = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
					}
					else if(!normalrange1.equals("") && !normalrange2.equals(""))					
					{
						if(Float.parseFloat(resultNum)>0)
						{
							if((Float.parseFloat(resultNum) >= Float.parseFloat(normalrange1)) && (Float.parseFloat(resultNum) <= Float.parseFloat(normalrange2)))
							{
								data = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
							}
						}
					}
					else if(!normalrange1.equals("") && normalrange2.equals(""))//Added by Jyothi.G on 09/12/2010 to fix IN025310		
					{
						if(Float.parseFloat(resultNum)>0)
						{
							if(Float.parseFloat(resultNum) >= Float.parseFloat(normalrange1)) 
							{
								data = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
							}
						}
					}
					else if(normalrange1.equals("") && !normalrange2.equals(""))					
					{
						if(Float.parseFloat(resultNum)>0)
						{
							if(Float.parseFloat(resultNum) <= Float.parseFloat(normalrange2))
							{
								data = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
							}
						}
					}//END
				}
				else if(include_normalcy_indicator.equals("C") && !include_normalcy_indicator.equals(""))
				{
					if(!color_cell_indicator.equals("NONE"))
						data = "<font style='background-color:"+color_cell_indicator+";size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
					else if(normalcy_ind.equals("."))
					{
						data = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
					}
					else if(!normalrange1.equals("") && !normalrange2.equals(""))
					{
						if(Float.parseFloat(resultNum) > 0)
						{
							if((Float.parseFloat(resultNum) >= Float.parseFloat(normalrange1)) && (Float.parseFloat(resultNum) <= Float.parseFloat(normalrange2)))
							{
								data = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
							}
						}
					}
					else if(!normalrange1.equals("") && normalrange2.equals(""))//Added by Jyothi.G on 09/12/2010 to fix IN025310
					{
						if(Float.parseFloat(resultNum) > 0)
						{
							if(Float.parseFloat(resultNum) >= Float.parseFloat(normalrange1))
							{
								data = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
							}
						}
					}
					else if(normalrange1.equals("") && !normalrange2.equals(""))
					{
						if(Float.parseFloat(resultNum)>0)
						{
							if(Float.parseFloat(resultNum) <= Float.parseFloat(normalrange2))
							{
								data = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
							}
						}
					}//END
				}
				else
					data = "<font size=1>"+data+"</font>";

				if(!prevhisttype.equals(histtypedesc))
				{
					histcount++;

					if(!prevhisttype.equals(""))
						outdata = outdata + "</table></td></tr>";
					outdata =outdata + "<tr onMouseOver='javascript:showPopUp()' onMouseOut='hidePopUp()'><td colspan='"+colspanval+"' class=CAHIGHERLEVELCOLOR><input type=button name='collapse' id='collapse' value=' - ' onclick=\"collapseExpand(this,'"+histcount+"');\"> "+histtypedesc+"</td></tr>";
					printdata = printdata + "<tr><td colspan='"+colspanval+"' class=CAHIGHERLEVELCOLOR>"+histtypedesc+"</td></tr>";
					outdata = outdata + "<tr><td><table width='100%' id='tableId"+histcount+"'>";
					pre_eventdate_hd = "";
				}
				//65008 starts
				    String en_clin_note_modify_track_yn ="";
				    pstmt1 = con.prepareStatement("select EN_CLIN_NOTE_MODIFY_TRACK_YN from CA_NOTE_PARAM");
					rs1 = pstmt1.executeQuery();
					if(rs1.next())
					{
						en_clin_note_modify_track_yn = rs1.getString(1) == null ? "" : rs1.getString(1);
					}
					if(pstmt1 != null) pstmt1.close();
					
				//65008 ends
				if(viewby.equals("D"))
				{
					if(!pre_eventdate_hd.equals(eventdate_hd))
					{
						outdata = outdata +"<tr onMouseOver='javascript:hidePopUp()'><td colspan='"+colspanval+"' class=CATHIRDLEVELCOLOR><font size=1 color = black ><b>"+eventdate_hd+"</b>";
						//24094 starts
						//if(modified_date_YN.equals("Y")){//65008
						 if(modified_date_YN.equals("Y") && en_clin_note_modify_track_yn.equals("Y")){//65008
							outdata = outdata + "&nbsp;<img  src='../../eCA/images/modifiedresult.png' /></td>";
							
							}
							else{
								outdata = outdata + "";
							} 
						//24094 ends
						printdata = printdata +"<tr><td colspan='"+colspanval+"' class=CATHIRDLEVELCOLOR><font size=1 color = black ><b>"+eventdate_hd+"</b></font></td></tr>";
					}
				}

				if(!preveventclass.equals(eventclassdesc))
				{
					outdata = outdata +"<tr onMouseOver='javascript:hidePopUp()'><td colspan='"+colspanval+"' class=CAGROUP><font size=1>"+eventclassdesc+"</font>";
					
					printdata = printdata +"<tr><td colspan='"+colspanval+"' class=CAGROUP><font size=1>"+eventclassdesc+"</font></td></tr>";
				}				

				if (!eventgroupdesc.equals(""))
					 curreventgroupevent = "("+eventgroupdesc+")-"+eventdesc;
				else
					 curreventgroupevent = eventdesc;

				if(viewby.equals("E"))
				{					
					if(!curreventgroupevent.equals(preveventgroupevent))
					{
						if (!eventgroupdesc.equals("")){
							outdata = outdata +"<tr onMouseOver='javascript:hidePopUp()'><td colspan='"+colspanval+"' class=CAFOURTHLEVELCOLOR><font size=1> ("+eventgroupdesc+")- "+eventdesc+"</font>";
							//31792 starts
							if(isSiteSpecificNeonatalMotherSpecimen && lv_neonate_spec_yn.equals("Y")){
						
							
								
							outdata = outdata +"&nbsp;"+"<img src='../../eCA/images/MotherBlood.png' style='cursor:pointer;' onClick=\"NeonatalMotherSpecimenDetails('"+order_id+"','"+accessionnum+"','"+histrectype+"','"+patientid+"')\"></td></tr>";
							
							}
						
							//31792 ends
							printdata = printdata + "<tr><td colspan='"+colspanval+"' class=gridDataChart><font size=1>("+eventgroupdesc+")- "+eventdesc+"</font></td></tr>";
						}else{
							outdata = outdata + "<tr onMouseOver='javascript:hidePopUp()'><td colspan='"+colspanval+"' class=CAFOURTHLEVELCOLOR><font size=1> "+eventdesc+"</font></td></tr>";
							printdata = printdata + "<tr><td colspan='"+colspanval+"' class=gridDataChart><font size=1>"+eventdesc+"</font></td></tr>";
						}
					}

					if(i%2==0) classValue = "QRYEVEN";
					else classValue = "QRYODD";	

					if(strStatus.equals("E"))
					{
					//IN066453 start
						////IN069242 Start.
						//if(isSiteSpecificForLabPrint && "LBIN".equals(histrectype)){//ML-BRU-0491
						if("Y".equals(restricting_print)){
						////IN069242 End.
							outdata = outdata +"<tr><td valign='top'><input type='checkbox' disabled name='checkbox_"+cnt+"' "+chkSelBox+"></td><td class='TD_BROWN'  width='50%' onMouseOver=\"javascript:showPopUp(this,'"+encline+"','')\" onMouseOut='hidePopUp()'><font size=1>"+eventdatetime_th+"</font></td><td class='TD_BROWN' onMouseOver='javascript:hidePopUp()' id='"+i+"'><font size=1>"+data+"</font>"+pacsimg+"</td></tr>";
						}else{
						outdata = outdata +"<tr><td valign='top'><input type='checkbox' name='checkbox_"+cnt+"' "+chkSelBox+"    onClick=\"selectCheckBox('"+enctr_id+"','"+sortEventDateTime+"','"+classValue+"',this,'"+ eventdatetime+"','"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"','"+i+"')\" ></td><td class='TD_BROWN'  width='50%' onMouseOver=\"javascript:showPopUp(this,'"+encline+"','')\" onMouseOut='hidePopUp()'><font size=1>"+eventdatetime_th+"</font></td><td class='TD_BROWN' onMouseOver='javascript:hidePopUp()' id='"+i+"'><font size=1>"+data+"</font>"+pacsimg+"</td></tr>";
						}
					//IN066453 end	
						if((include_normalcy_indicator.equals("C") || include_normalcy_indicator.equals("B")) && !normalcy_ind.equals("") && !color_cell_indicator.equals("NONE"))
						{
							printdata =printdata + "<tr><td class='gridDataChart' ><font size=1>"+eventdatetime_th+"</font></td><td  class='"+displayStyle+"' id='"+i+"'>"+data+"</td></tr>";
						}
						else
						{
							printdata = printdata +"<tr><td class='gridDataChart'><font size=1>"+eventdatetime_th+"</font></td><td class='"+displayStyle+"' id='"+i+"'>"+data+"</td></tr>";
						}
					}
					else
					{						
					//IN066453 start						
						////IN069242 Start.
						//if(isSiteSpecificForLabPrint && "LBIN".equals(histrectype)){//ML-BRU-0491
						if("Y".equals(restricting_print) || "".equals(histdatatype.trim())){
						//IN069242 End.
							outdata = outdata + "<tr><td valign='top' width='2%'><input type='checkbox' disabled align='left' name='checkbox_"+cnt+"' id='checkbox_"+cnt+"' "+chkSelBox+" ></td><td  valign='top' width='20%' onMouseOver=\"javascript:showPopUp(this,'"+encline+"','')\" onMouseOut='javascript:hidePopUp()'><font size=1>"+eventdatetime_th+"</font>";
							
							//24094 starts
						//if(modified_date_YN.equals("Y")){//65008
							 if(modified_date_YN.equals("Y") && en_clin_note_modify_track_yn.equals("Y")){//65008
								outdata = outdata + "&nbsp;<img  src='../../eCA/images/modifiedresult.png' /></td>";
								
								}
								else{
									outdata = outdata + "";
								} 
							//24094 ends
						}else{
						outdata = outdata + "<tr><td valign='top' width='2%'><input type='checkbox' align='left' name='checkbox_"+cnt+"' id='checkbox_"+cnt+"' "+chkSelBox+"    onClick=\"selectCheckBox('"+enctr_id+"','"+sortEventDateTime+"','"+classValue+"',this,'"+ eventdatetime+"','"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"','"+i+"')\" ></td><td  valign='top' width='20%' onMouseOver=\"javascript:showPopUp(this,'"+encline+"','')\" onMouseOut='javascript:hidePopUp()'><font size=1>"+eventdatetime_th+"</font>";
						//24094 starts
						 
						//if(modified_date_YN.equals("Y"){//65008
						if(modified_date_YN.equals("Y") && en_clin_note_modify_track_yn.equals("Y")){//65008
						outdata = outdata + "&nbsp;<img  src='../../eCA/images/modifiedresult.png' /></td>";
						
						}
						else{
							outdata = outdata + "";
						} 
						//24094 ends
						}
						//IN066453 end	
						if( !"".equals(histdatatype.trim())){
						outdata = outdata +"<td width='78%' class='"+displayStyle+"' onMouseOver=\"javascript:displayTooltip(this,'"+range+"')\" onMouseOut='javascript:hideTooltip(this)' >"+data+"&nbsp;<input type='image' "+quick_text_image_visible+" name='image"+i+"' id='image"+i+"'  style='cursor:pointer' id='"+i+"' src='../../eCA/images/II_comment.gif' onClick=\"return enterQuickText('"+eventdatetime+"','"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"','S')\" ></td></tr>";
						
						printdata = printdata +"<tr><td class='gridDataChart' width='50%'><font size=1>"+eventdatetime_th+"</font></td>";
						
							printdata = printdata +"<td class='"+displayStyle+"'>"+data+"</td></tr>";
						}
					}												
				}
				else 
				{					
					if(i%2==0) classValue = "QRYEVEN";
					else classValue = "QRYODD";

					outdata = outdata + "<tr><td   width='5' onMouseOver=\"javascript:showPopUp(this,'"+encline+"','')\" onMouseOut='hidePopUp()'><font size=1>"+eventdatetime.substring(eventdatetime.indexOf(" "))+"</font></td>"; //IN26953
					//IN069242 Start.
					if("Y".equals(restricting_print) || "".equals(histdatatype.trim())){
						outdata = outdata + "<td width='25%'   align='left'><input type='checkbox' disabled name='checkbox_"+cnt+"' id='checkbox_"+cnt+"' "+chkSelBox+"    onClick=\"selectCheckBox('"+enctr_id+"','"+sortEventDateTime+"','"+classValue+"',this,'"+ eventdatetime+"','"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"','"+i+"')\" >"+curreventgroupevent; //IN26953
					}else{
					//IN069242 End.
					outdata = outdata + "<td width='25%' align='left'><input type='checkbox' name='checkbox_"+cnt+"' id='checkbox_"+cnt+"' "+chkSelBox+"    onClick=\"selectCheckBox('"+enctr_id+"','"+sortEventDateTime+"','"+classValue+"',this,'"+ eventdatetime+"','"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"','"+i+"')\" >"+curreventgroupevent; //IN26953
					}//IN069242
					if(isSiteSpecificNeonatalMotherSpecimen && lv_neonate_spec_yn.equals("Y")){						
						outdata = outdata +"&nbsp;"+"<img style='cursor:pointer;' src='../../eCA/images/MotherBlood.png' onClick=\"NeonatalMotherSpecimenDetails('"+order_id+"','"+accessionnum+"','"+histrectype+"','"+patientid+"')\">";
					}
					outdata = outdata+"</td>";
					if( !"".equals(histdatatype.trim())){
						outdata = outdata + "<td  class='"+displayStyle+"' onMouseOver=\"javascript:displayTooltip(this,'"+range+"')\" onMouseOut='javascript:hideTooltip(this)' >"+data+"</font>"+pacsimg+"<input type='image' "+quick_text_image_visible+" style='display:none' name='image"+i+"' id='image"+i+"'  src='../../eCA/images/II_comment.gif' onClick=\"return enterQuickText('"+eventdatetime+"','"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"','S')\" ></td></tr>";
					
						printdata = printdata + "<tr><td class='gridDataChart'><font size=1>"+eventdatetime.substring(eventdatetime.indexOf(" "))+"</font></td><td class='gridDataChart'><font size=1>"+curreventgroupevent+"</font></td>";
						
						printdata = printdata +"<td class='"+displayStyle+"' id='"+i+"'><font size=1>"+data+"</font>"+pacsimg+"<input type='image' style='display:none' name='image"+i+"' id='image"+i+"'   src='../../eCA/images/II_comment.gif' ></td></tr>";		
					}
				}		
				preveventdatetime = eventdatetime;
				prevhisttype = histtypedesc;
				preveventclass = eventclassdesc;
				preveventgroupevent = curreventgroupevent;
				pre_eventdate_hd = eventdate_hd;
				
				if(first)
				{
					if(viewby.equals("D"))
					{
						if(!selectedhisrectype.equals(""))
							titleofdocument = histtypedesc;
					}
					else
					{
						titleofdocument = histtypedesc;
					}
				}
				first = false;
				i++;
				cnt++;
			}
						
			outdata = outdata + "</table></td></tr>";
			outdata = outdata+"</table>";
			outdata = outdata.replaceAll("<IMAGE[^>]*SRC\\s*=\\s*\"[^\"]*\"[^>]*></IMAGE>", "");//ML_MMOH_SCF_2966
                        out.println(outdata);
			
		}	

		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(stmt2!=null) stmt2.close();
		if(stHist!=null) stHist.close();
		if(rsHist!=null) rsHist.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(stmt2!=null) stmt2.close();
		if(stHist!=null) stHist.close();
		if(rsHist!=null) rsHist.close();
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(enc_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(cnt));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(fac_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(enctr_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            _bw.write(_wl_block3Bytes, _wl_block3);

String copyRestrict = bean1.getCopyRestrictCEH(facilityId);
String resCEHView = bean1.getRestrictCEHTree();
if ("Y".equals(copyRestrict)  && resCEHView != null && ("FLOW_SHEET1".equals(resCEHView) || "FLOW_SHEET".equals(resCEHView)) ) {

            _bw.write(_wl_block16Bytes, _wl_block16);
 } 
            _bw.write(_wl_block17Bytes, _wl_block17);
            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
