package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.util.zip.*;
import webbeans.eCommon.*;
import eOR.*;
import java.math.*;
import java.io.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __chartsummaryeventslast24hrs extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartSummaryEventsLast24hrs.jsp", 1742379130982L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!-- \n--------------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n23/08/2011    IN:028353      Menaka      Incident No: 028353 - <System adds \'0\' before result of Auto\n                                                               report orders in Clinical Event History ( Flow sheet view ).> \n27/01/2012\t  INO30714\t\tMenaka V\t THAI screen>View Clinical Event History>View>In the Recorded Clinical\n\t\t\t\t\t\t\t\t\t\t Note the name is not displayed in THAI \n05/04/2012\t  IN031989\t\tMenaka V\t When a patient is selected by using patient without encounter search function and when clinical\n\t\t\t\t\t\t\t\t\t\t event history is accessed the note header is incomplete for all the existing notes for that patient.\n20/06/2012\t  IN033489\t\tMenaka V\t Report header blank in clinical event history.\n12/11/2012\t  EMG\t\t\tChowminya G\t\n29/11/2012\t  IN035950\tNijitha\t\t\tCHL Hospital suggested that the presentation of the Clinician desktop be changed and \n15/05/2013\t  IN037793\t\tKarthi L\tTo be able to view the Specimen image attachment in \'Existing Orders\' function and \'Clinical Event History\' function in OR and CA.\t\n30/05/2013\t  IN040237\t\tKarthi L\tClicking on the icon, system is displaying error message.\n17/06/2013\tIN040866\t\tKarthi L\tSystem is not displaying the Image in CA \n22/06/2013  IN040416\t\tNijitha S  CRF-OR-Bru-HIMS-CRF-052.1/02-System is not displaying \'View\' hyperlink for the Laboratory Panel Order. \n18/12/2013\tIN042552\t\tRamesh G\tBru-HIMS-CRF-391 --- Notes Confidentiality\t\t\n----------------------------------------------------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        \tRev.Date\t\tRev.Name\t\tDescription\n----------------------------------------------------------------------------------------------------------------------------------------------------------\n06/03/2014\tIN047204\t\tKarthi L\t\t07/03/2014\t\tRamesh \t\t\tOrder result screen for Radiology to provide a link to the DMS URL where the scanned radiology result document is uploaded to. \n12/03/2014\tIN047566\t\tAkbar\t\t\t\t\t\t\t\t\t\t\tLinked issue of Bru-HIMS-CRF-195.2-47204/01\n19/03/2014\tIN47847\t\t\tNijitha S\t\t\t\t\t\t\t\t\t\tOrder result screen for Radiology to provide a link to the DMS URL where the scanned radiology result document is uploaded to\n01/04/2014\tIN048253\t\tKarthi L\t\t01/04/2014\t\tAkbar\t\t\tGetting Script error when click on External Application link icon.\n15/05/2014\tIN047205\t\tKarthi L\t\t16/05/2014\t\tRamesh\t\t\tChanges to clinical event history and chart summary view - to provide link to the scanned document in clinical views\n08/09/2014  IN050936\t\tChowminya\t\t\t\t\t\t\t\t\t\tNone of the order retrieving any image from RIS/PACS but already having order image in PACS\n17/10/2014\tIN050649\t\tKarthi L\t\t\t\t\t\t\t\t\t\tRecord chart same time, system separate data of chart in view chart summary.\n30/01/2015  IN053093\t\tNijitha S\t\t\t\t\t\t\t\t\t\tML-BRU-SCF-1515\n19/03/2015\tIN052800\t\tKarthi L\t\t\t\t\t\t\t\t\t\tIf link image for Histology orderable, from CA, user not able to view the image. No link appear under View.\n09/10/2015\tIN055910\t\tKarthi L\t\t\t\t\t\t\t\t\t\tFrom Clinician Access, modified result shall be identified by include \"!\" in Blue color\t\t\n20/10/2015\tIN057138\t\tKarthi L\t\t\t\t\t\t\t\t\t\tChief Complaint ( Long Text ) which has been recorded  from the Manage Patient ...\n07/07/2017\tIN064688\t\tRaja S\t\t\t08/07/2017\t\tRameshG\t\t\tML-MMOH-SCF-0753\n07/02/2018\tIN065970\t\tVijayakumar K\t07/02/2018\t\tRameshGo\t\tML-BRU-SCF-1611.1 [IN:065970]\n07/03/2018\tIN065970\t\tVijayakumar K\t07/03/2018\t\tRameshGo\t\tML-BRU-SCF-1611.1 [IN:065970] reopen\n19/03/2018\tIN067037\t\tRaja S\t\t\t19/03/2018\t\tRamesh G\t\tML-BRU-SCF-1787\n26/02/2018\tIN066119\t\tRaja S\t\t\t26/02/2018\t\tRamesh G\t\tML-MMOH-CRF-1024\n18/12/2018   IN067236      \t Sivabagyam M\t18/12/2018\t\tRamesh G\t   \tML-MMOH-CRF-1148\n30/07/2019\tIN070610\t\tDinesh T\t\t30/07/2019\t\tRamesh G\t\tTBMC-CRF-0011.1\n03/02/2020\tIN071561\t\tSIVABAGYAM M\t03/02/2020\t\tRAMESH G\t\tGHL-CRF-0558.1\n15/12/2020\t7902\t\t\tSivabagyam M\t15/12/2020\t\tRamesh G\t\tMMS-DM-CRF-0180.1\n20/04/2021\t6484\t\t\tRamesh Goli\t\t20/04/2021\t\tRAMESH G\t\tMO-CRF-20147.7\n16/08/2022\t29803\t\t\tRamesh G \t\t\t\t\t\t\t\t\t\tML-BRU-CRF-0635\n20/07/2023\t  24094\t   Ranjith P R\t\t21/07/2023\t\tRAMESH G\t\tML-MMOH-CRF-1804\n08/08/2023  48184           Krishna Pranay   11/08/2023    RAMESH G       RL-COMMON-View Chart Summary(View Image)\n\n-----------------------------------------------------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" <!-- Added math.* IN064688 -->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" <!--  IN052800 -->\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<title>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</title>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' type=\'text/css\' />\n\n<style>\nA \n{ \n\ttext-decoration : none ;\n}\n</style>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\"../../eCA/js/ResearchPatient.js\" language=\"javascript\"></script>\n<script src=\"../../eCA/js/CAOpenExternalApplication.js\" language=\"javascript\"></script>\n<script src=\'../../eXH/js/ExternalApplication.js\' language=\'javascript\'></script> <!-- added for IN047024 -->\n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n <!-- added for IN048253 -->\n<script>\n\n//function call24hrsummary(patient_id,title,reln_id)//INO30714\n//function call24hrsummary(patient_id,title,reln_id,enc_id)//INO30714//IN071561\nasync function call24hrsummary(patient_id,title,reln_id,enc_id,p_review_rad_yn)//INO30714//IN071561\n{\n\tvar dialogHeight\t= \"80vh\" ;\n\tvar dialogWidth\t= \"85vw\" ;\n\tvar status = \"no\";\n\tvar scroll = \"yes\";\n\tvar dialogTop = \"\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\"+ dialogTop + \"; status:\"+ status + \"; scroll:\"+ scroll;\n\t\n\t//retVal \t\t\t= window.showModalDialog(\'../../eCA/jsp/ChartSummaryEventsLast24hrsDtlsMain.jsp?patient_id=\'+patient_id+\'&modal_yn=Y\'+\'&title=\'+encodeURIComponent(title,\"UTF-8\")+\'&relationship_id=\'+reln_id,arguments,features);//INO30714\n\t//retVal \t\t\t= window.showModalDialog(\'../../eCA/jsp/ChartSummaryEventsLast24hrsDtlsMain.jsp?patient_id=\'+patient_id+\'&modal_yn=Y\'+\'&title=\'+encodeURIComponent(title,\"UTF-8\")+\'&relationship_id=\'+reln_id+\'&encounter_id=\'+enc_id,arguments,features);//INO30714//IN071561\n\tretVal \t\t\t= await top.window.showModalDialog(\'../../eCA/jsp/ChartSummaryEventsLast24hrsDtlsMain.jsp?patient_id=\'+patient_id+\'&modal_yn=Y\'+\'&title=\'+encodeURIComponent(title,\"UTF-8\")+\'&relationship_id=\'+reln_id+\'&encounter_id=\'+enc_id+\'&p_review_rad_yn=\'+p_review_rad_yn,arguments,features);//INO30714//IN071561\n}\n</script>\n</head>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<center>\n<table class=\'grid\' width=\'100%\' id=\'tb1\'><tr>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t <tr><td colspan=\'3\' class=\'gridData\' >\n\t\t\t     <a class=\'gridLink\' href=\"javascript:call24hrsummary(\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\',\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\')\"> ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</a></td></tr> <!-- INO30714 --> <!-- IN071561 -->\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n</table>\n</center>\n<!--INO30714 Starts -->\n<form>\n<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'> \n<input type=\"hidden\" name=\"enc_id\" id=\"enc_id\" value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'> \n</form>\n<!-- INO30714 Ends-->\n</body>\n</html>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );
	
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


	String replaceSpecialChar(String resultStr)
	{		
		if(resultStr.indexOf("\n")!=-1)
			resultStr = resultStr.replaceAll("\n","~");			
		if(resultStr.indexOf("\r")!=-1)
			resultStr = resultStr.replaceAll("\r","");
		//if(resultStr.indexOf("'")!=-1)
		//	resultStr = resultStr.replaceAll("'","`");
		//if(resultStr.indexOf("\"")!=-1)
			//resultStr = resultStr.replaceAll("\"","|");
		
		// commented above line and added below line for ML-BRU-SCF-1642
		if(resultStr.indexOf("%")!=-1)
			resultStr = resultStr.replaceAll("%","%25");
		if(resultStr.indexOf("'")!=-1)
			resultStr = resultStr.replaceAll("'","%27");
		if(resultStr.indexOf("\\")!=-1)
			resultStr = resultStr.replaceAll("\\\\","&#92");
		if(resultStr.indexOf("+")!=-1) 
			resultStr = resultStr.replaceAll("\\+","&#43");	
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
	//[IN035950] Starts
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

String prefStyleSheet = request.getParameter("prefStyle");//Nijitha
//String content_ID = request.getParameter("content_ID");	//Checkstyle 4.0 Beta 6
//String sStyle = "";
String fac_id= (String) session.getValue("facility_id");//IN047204
if(!"".equals(prefStyleSheet)){
 sStyle=prefStyleSheet;
}
/*else{
	sStyle=prefStyleSheet;
}*/
//[IN035950] Ends
	String title= request.getParameter("title")==null?"":request.getParameter("title");

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(title));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block11Bytes, _wl_block11);

	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	Connection con	= null;
	PreparedStatement stmt	= null;
	ResultSet rs			= null;
	String classValue 		= "",viewconf_appl="X";
	StringBuffer sql			= new StringBuffer() ;	

	PreparedStatement pstmtImgView = null; // added for Bru-HIMS-CRF-052.1 [IN037793]
	ResultSet resImgView = null; // added for Bru-HIMS-CRF-052.1 [IN037793]
	int recCount = 0; // added for Bru-HIMS-CRF-052.1 [IN037793]
	PreparedStatement pstmtImgCount = null; // [IN037793]
	ResultSet rsetImgCount = null; // added for Bru-HIMS-CRF-052.1 [IN037793]
	
	PreparedStatement pstmtPerFacId = null; // IN040866
	ResultSet rsetPerFacId = null;  // IN040866
	
	PreparedStatement pstmtOrderId = null; // IN047204
	ResultSet rsetOrderId = null;  // IN047204
	String login_at_ws_no		= p.getProperty("client_ip_address")== null ?"":p.getProperty("client_ip_address");	// IN047204	
	String login_user = (String)session.getValue("login_user"); // added for Bru-HIMS-CRF-052.1 [IN037793]
	String patient_id = request.getParameter("patient_id");
	String enc_id = request.getParameter("encounter_id");//INO30714
	
	String accessionNum="",histRecType="",contrSysEventCode="",contrSysId="",eventDate="";
	String histRecTypeDesc="",eventClassDesc = "",eventGroupDesc = "",eventDesc = "";
	String textExist = "",histDataType ="",resultStr="";
	String resultNum= "", resultNumUom = "",normalLow = "",	normalHigh="";
	String histRecTypeDescPrev = "",eventClassDescPrev = "",eventGroupDescPrev ="", 		eventDatePrev="",tempStrValue="";
	String normalcyInd = "";
	String modified_date = "";//24094
	String modified_YN = "";//24094
	String ext_image_appl_id = "", ext_image_obj_id = "";
	String color_cell_indicator = "";
	String descCellInd = "";
	String styleValue = "";
	String resp_id = (String)session.getValue("responsibility_id");
	String reln_id		=	request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
	String clinician_id			= (String)session.getValue("ca_practitioner_id") == null ? "" : (String) session.getValue("ca_practitioner_id");//IN042552
	String modal_yn=request.getParameter("modal_yn");
	String p_review_rad_yn=request.getParameter("p_review_rad_yn")==null?"N":request.getParameter("p_review_rad_yn");//IN071561

	String legend_type = "";
	String result_yn = "";
	String result_num_prefix = "";
	String result_status = "";
	String resultStatus ="";//29803
	String normalcy_str = "";
	String enctr_id = "";//IN031989
	if (modal_yn==null) modal_yn="N";
	int i=0;
	if(resp_id == null)resp_id ="";
	//String fac_id = "";//IN033489 - moved top for IN047204
	String event_group ="";//IN040416
	String ext_image_upld_id = ""; //Bru-HIMS-CRF-052.1 [IN037793]
	String ext_img_file_locn = ""; //Bru-HIMS-CRF-052.1 [IN037793]
	// IN047204  - Start
	String event_code_type = "";
	eCA.CAEncounterList oEncounterList = new eCA.CAEncounterList(); 
	String dmsExternalLinkYN = ""; 
	String access_no_rd 	= ""; 
	String order_id 		= ""; 
	String order_typ_code	= ""; 
	String locn_code	= "";		
	String locn_type	= "";
	String loc_desc		= "";
	String visit_id		= "";
	String physician_id	= "";
	String admit_date	= "";
	String encntr_type	= "";
	HashMap extLinkHashMap = null;
	// IN047204  - End
	//Bru-HIMS-CRF-195.3 - IN047205 - Start
	eCA.CAExternalLinkDataDTO externalDataDTO = null;
	String ext_image_appli_id = "";
	String ext_image_obj_id_dms = "";
	String ext_image_source = "";
	String ext_srce_doc_ref_no = "";
	String ext_srce_doc_ref_line_no = "";
	ArrayList externalList = null;
	//Bru-HIMS-CRF-195.3 - IN047205 - End
	eCA.PatientBannerGroupLine manageEmailBean = null; //IN052800
	//IN066119 starts
	String bean_id = "Or_ViewOrder" ;
	String bean_name = "eOR.ViewOrder";
	ViewOrder bean = (ViewOrder)getBeanObject( bean_id, bean_name,request ) ;
	String hideSpecimenType = "N";
	HashMap orParamFac = new HashMap();
	//IN066119 ends
		boolean isClinician=false;//IN067236
		PreparedStatement pstmtImgView1 = null; //7902
		ResultSet resImgView1 = null;//7902
		String study_id="",ext_img_disable="",param_def_str="",ext_img_display="";//7902

            _bw.write(_wl_block12Bytes, _wl_block12);

	try
	{
		manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patient_id+enc_id,"eCA.PatientBannerGroupLine",session); //IN052800
		//IN070610, starts
		ArrayList<String> funcIds = new ArrayList<String>();
		funcIds.add("UPLOAD_TR_CATEGORY_ORDERS");
		manageEmailBean.adapter.setSiteSpecific(funcIds,"OR");
		Boolean uploadFuncTrOrders = manageEmailBean.adapter.isSiteSpecific("UPLOAD_TR_CATEGORY_ORDERS");
		//IN070610, ends
		boolean restrict_rd	=false;	//IN071561
		dmsExternalLinkYN = oEncounterList.getExternalDmsLinkYN(fac_id); //IN047204 	
		con	= ConnectionManager.getConnection(request);
		//IN066119 STARTS
		orParamFac=bean.orParamFacility(con, fac_id);
		hideSpecimenType = (String)orParamFac.get("HIDE_SPECIMENTYPE");
		//IN066119 ENDS
	isClinician = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","CLINICIAN_TO_THERAPIST");//IN067236
	restrict_rd =eCommon.Common.CommonBean.isSiteSpecific(con, "CA","RD_PEER_REVIEW_RESTRICT");//IN071561
		stmt= con.prepareStatement(" select GET_TASK_APPLICABILITY(?,NULL,?,?) from dual ");
		stmt.setString(1,"VIEW_CONF_RESULT");
		stmt.setString(2,resp_id);
		stmt.setString(3,reln_id);
		rs=stmt.executeQuery();
		if (rs.next())
			viewconf_appl=rs.getString(1);
		if (viewconf_appl==null) viewconf_appl="X";
		if (rs!=null) rs.close();
		if (stmt!=null) stmt.close();

		stmt = con.prepareStatement("select LEGEND_TYPE from CR_CLIN_EVENT_PARAM ");
		rs = stmt.executeQuery();
		if (rs.next())
		{
			legend_type = rs.getString(1) == null ? "S" : rs.getString(1);
		}
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();

		stmt = con.prepareStatement("select VIEW_RESULT_DATETIME_YN from CA_ENCNTR_PARAM ");
		rs = stmt.executeQuery();
		if (rs.next())
		{
			result_yn = rs.getString(1) == null ? "N" : rs.getString(1);
		}
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
	
		//sql.append("SELECT event_date ,a.accession_num, TO_CHAR(event_date,'hh24:mi') event_date_time, TO_CHAR(EVENT_AUTH_DATE_TIME,'hh24:mi') result_date_time, B.short_desc hist_rec_type_desc, C.short_desc event_class_desc, DECODE(A.event_code,A.event_group,NULL,E.short_desc) event_group_desc, d.short_desc event_desc, A.hist_data_type, a.RESULT_NUM_PREFIX, A.result_num, A.result_num_uom, A.result_str, NORMAL_LOW, NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID = A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE = A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits, A.hist_rec_type, A.contr_sys_event_code, A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, TO_CHAR(event_date,'DD/MM/YYYY hh24:mi') SPECIMEN_COL_DATETIME, a.STATUS, a.NORMALCY_STR FROM CR_ENCOUNTER_DETAIL A ,CR_HIS_RECTYP_LNG_VW B,  CR_EVENT_CLASS_LANG_VW C,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e WHERE         B.LANGUAGE_ID = ? AND B.hist_rec_type=A.hist_rec_type AND c.hist_rec_type=A.hist_rec_type AND C.event_class= A.event_class AND  C.LANGUAGE_ID = ? AND D.LANGUAGE_ID = ?  AND d.hist_rec_type=A.hist_rec_type AND  d.event_code=A.event_code and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  AND  E.LANGUAGE_ID(+)= ?  AND e.hist_rec_type(+)=A.hist_rec_type AND  e.event_group(+)=A.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE  and patient_id=? ");//IN031989
		//sql.append("SELECT event_date ,a.accession_num, TO_CHAR(event_date,'hh24:mi') event_date_time, TO_CHAR(EVENT_AUTH_DATE_TIME,'hh24:mi') result_date_time, B.short_desc hist_rec_type_desc, C.short_desc event_class_desc, DECODE(A.event_code,A.event_group,NULL,E.short_desc) event_group_desc, d.short_desc event_desc, A.hist_data_type, a.RESULT_NUM_PREFIX, A.result_num, A.result_num_uom, A.result_str, NORMAL_LOW, NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID = A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE = A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits, A.hist_rec_type, A.contr_sys_event_code, A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, TO_CHAR(event_date,'DD/MM/YYYY hh24:mi') SPECIMEN_COL_DATETIME, a.STATUS, a.NORMALCY_STR, a.encounter_ID, A.FACILITY_ID FROM CR_ENCOUNTER_DETAIL A ,CR_HIS_RECTYP_LNG_VW B,  CR_EVENT_CLASS_LANG_VW C,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e WHERE         B.LANGUAGE_ID = ? AND B.hist_rec_type=A.hist_rec_type AND c.hist_rec_type=A.hist_rec_type AND C.event_class= A.event_class AND  C.LANGUAGE_ID = ? AND D.LANGUAGE_ID = ?  AND d.hist_rec_type=A.hist_rec_type AND  d.event_code=A.event_code and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  AND  E.LANGUAGE_ID(+)= ?  AND e.hist_rec_type(+)=A.hist_rec_type AND  e.event_group(+)=A.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE  and patient_id=? ");//IN031989 commented for Bru-HIMS-CRF-052.1 [IN037793]
		
		//sql.append("SELECT event_date ,a.accession_num, TO_CHAR(event_date,'hh24:mi') event_date_time, TO_CHAR(EVENT_AUTH_DATE_TIME,'hh24:mi') result_date_time, B.short_desc hist_rec_type_desc, C.short_desc event_class_desc, DECODE(A.event_code,A.event_group,NULL,E.short_desc) event_group_desc, d.short_desc event_desc, A.hist_data_type, a.RESULT_NUM_PREFIX, A.result_num, A.result_num_uom, A.result_str, NORMAL_LOW, NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID = A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE = A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits, A.hist_rec_type, A.contr_sys_event_code, A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, TO_CHAR(event_date,'DD/MM/YYYY hh24:mi') SPECIMEN_COL_DATETIME, a.STATUS, a.NORMALCY_STR, a.encounter_ID, A.FACILITY_ID,A.event_group, a.event_code_type FROM CR_ENCOUNTER_DETAIL A ,CR_HIS_RECTYP_LNG_VW B,  CR_EVENT_CLASS_LANG_VW C,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e WHERE         B.LANGUAGE_ID = ? AND B.hist_rec_type=A.hist_rec_type AND c.hist_rec_type=A.hist_rec_type AND C.event_class= A.event_class AND  C.LANGUAGE_ID = ? AND D.LANGUAGE_ID = ?  AND d.hist_rec_type=A.hist_rec_type AND  d.event_code=A.event_code and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  AND  E.LANGUAGE_ID(+)= ?  AND e.hist_rec_type(+)=A.hist_rec_type AND  e.event_group(+)=A.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE  and patient_id=? ");  // modified for Bru-HIMS-CRF-052.1 [IN037793]//IN040416 - a.EVENT_CODE_TYPE added for IN047204 //Commented for IN067037
		//sql.append("SELECT event_date ,a.accession_num, TO_CHAR(event_date,'hh24:mi') event_date_time, TO_CHAR(EVENT_AUTH_DATE_TIME,'hh24:mi') result_date_time, B.short_desc hist_rec_type_desc, C.short_desc event_class_desc, DECODE(A.event_code,A.event_group,NULL,E.short_desc) event_group_desc, d.short_desc event_desc, A.hist_data_type, a.RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'9999999ChartSummaryEventsLast24hrsChartSummaryEventsLast24hrsChartSummaryEventsLast24hrs.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, A.result_num_uom, A.result_str,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_LOW, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID = A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE = A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits, A.hist_rec_type, A.contr_sys_event_code, A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, TO_CHAR(event_date,'DD/MM/YYYY hh24:mi') SPECIMEN_COL_DATETIME, a.STATUS, a.NORMALCY_STR, a.encounter_ID, A.FACILITY_ID,A.event_group, a.event_code_type FROM CR_ENCOUNTER_DETAIL A ,CR_HIS_RECTYP_LNG_VW B,  CR_EVENT_CLASS_LANG_VW C,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e WHERE         B.LANGUAGE_ID = ? AND B.hist_rec_type=A.hist_rec_type AND c.hist_rec_type=A.hist_rec_type AND C.event_class= A.event_class AND  C.LANGUAGE_ID = ? AND D.LANGUAGE_ID = ?  AND d.hist_rec_type=A.hist_rec_type AND  d.event_code=A.event_code and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  AND  E.LANGUAGE_ID(+)= ?  AND e.hist_rec_type(+)=A.hist_rec_type AND  e.event_group(+)=A.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE  and patient_id=? ");  // modified for IN067037//IN070610
		
		//IN070610, starts
		System.out.println("---------uploadFuncTrOrders------>"+uploadFuncTrOrders);
		if(uploadFuncTrOrders){
			//6484 Start.
			//sql.append("SELECT event_date ,a.accession_num, TO_CHAR(event_date,'hh24:mi') event_date_time, TO_CHAR(EVENT_AUTH_DATE_TIME,'hh24:mi') result_date_time, B.short_desc hist_rec_type_desc, C.short_desc event_class_desc, DECODE(A.event_code,A.event_group,NULL,E.short_desc) event_group_desc, d.short_desc event_desc, A.hist_data_type, a.RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, A.result_num_uom, A.result_str,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_LOW, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID = A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE = A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits, A.hist_rec_type, A.contr_sys_event_code, A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, TO_CHAR(event_date,'DD/MM/YYYY hh24:mi') SPECIMEN_COL_DATETIME, a.STATUS, a.NORMALCY_STR, a.encounter_ID, A.FACILITY_ID,A.event_group, a.event_code_type,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt FROM CR_ENCOUNTER_DETAIL A ,CR_HIS_RECTYP_LNG_VW B,  CR_EVENT_CLASS_LANG_VW C,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e WHERE         B.LANGUAGE_ID = ? AND B.hist_rec_type=A.hist_rec_type AND c.hist_rec_type=A.hist_rec_type AND C.event_class= A.event_class AND  C.LANGUAGE_ID = ? AND D.LANGUAGE_ID = ?  AND d.hist_rec_type=A.hist_rec_type AND  d.event_code=A.event_code and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  AND  E.LANGUAGE_ID(+)= ?  AND e.hist_rec_type(+)=A.hist_rec_type AND  e.event_group(+)=A.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE  and patient_id=? ");  // modified for IN067037
			//sql.append("SELECT event_date ,a.accession_num, TO_CHAR(event_date,'hh24:mi') event_date_time, TO_CHAR(EVENT_AUTH_DATE_TIME,'hh24:mi') result_date_time, B.short_desc hist_rec_type_desc, C.short_desc event_class_desc, DECODE(A.event_code,A.event_group,NULL,E.short_desc) event_group_desc, d.short_desc event_desc, A.hist_data_type, a.RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, A.result_num_uom, A.result_str,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_LOW, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID = A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE = A.contr_sys_event_code and (dbms_lob.getlength(hist_data)>0 or nvl(dbms_lob.getlength(compress_hist_data),0)>0)) ,'N') text_exisits, A.hist_rec_type, A.contr_sys_event_code, A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, TO_CHAR(event_date,'DD/MM/YYYY hh24:mi') SPECIMEN_COL_DATETIME, a.STATUS, a.NORMALCY_STR, a.encounter_ID, A.FACILITY_ID,A.event_group, a.event_code_type,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt,a.result_status resultStatus FROM CR_ENCOUNTER_DETAIL A ,CR_HIS_RECTYP_LNG_VW B,  CR_EVENT_CLASS_LANG_VW C,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e WHERE         B.LANGUAGE_ID = ? AND B.hist_rec_type=A.hist_rec_type AND c.hist_rec_type=A.hist_rec_type AND C.event_class= A.event_class AND  C.LANGUAGE_ID = ? AND D.LANGUAGE_ID = ?  AND d.hist_rec_type=A.hist_rec_type AND  d.event_code=A.event_code and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  AND  E.LANGUAGE_ID(+)= ?  AND e.hist_rec_type(+)=A.hist_rec_type AND  e.event_group(+)=A.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE  and patient_id=? ");  
			//6484 End.
			sql.append("SELECT event_date ,a.accession_num, TO_CHAR(event_date,'hh24:mi') event_date_time, TO_CHAR(EVENT_AUTH_DATE_TIME,'hh24:mi') result_date_time, B.short_desc hist_rec_type_desc, C.short_desc event_class_desc, DECODE(A.event_code,A.event_group,NULL,E.short_desc) event_group_desc, d.short_desc event_desc, A.hist_data_type, a.RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, A.result_num_uom, A.result_str,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_LOW, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID = A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE = A.contr_sys_event_code and (dbms_lob.getlength(hist_data)>0 or nvl(dbms_lob.getlength(compress_hist_data),0)>0)) ,'N') text_exisits, A.hist_rec_type, A.contr_sys_event_code, A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, TO_CHAR(event_date,'DD/MM/YYYY hh24:mi') SPECIMEN_COL_DATETIME, a.STATUS, a.NORMALCY_STR, a.encounter_ID, A.FACILITY_ID,A.event_group, a.event_code_type,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt,a.result_status resultStatus,TO_CHAR(a.modified_date,'dd/mm/yyyy hh24:mi') modified_date, NOTE_DATA_MODFIED_YN(a.hist_rec_type,a.accession_num) modifiedyn FROM CR_ENCOUNTER_DETAIL A ,CR_HIS_RECTYP_LNG_VW B,  CR_EVENT_CLASS_LANG_VW C,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e WHERE         B.LANGUAGE_ID = ? AND B.hist_rec_type=A.hist_rec_type AND c.hist_rec_type=A.hist_rec_type AND C.event_class= A.event_class AND  C.LANGUAGE_ID = ? AND D.LANGUAGE_ID = ?  AND d.hist_rec_type=A.hist_rec_type AND  d.event_code=A.event_code and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  AND  E.LANGUAGE_ID(+)= ?  AND e.hist_rec_type(+)=A.hist_rec_type AND  e.event_group(+)=A.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE  and patient_id=? ");  //24094  
			
		}else{
			//6484 Start.
			//sql.append("SELECT event_date ,a.accession_num, TO_CHAR(event_date,'hh24:mi') event_date_time, TO_CHAR(EVENT_AUTH_DATE_TIME,'hh24:mi') result_date_time, B.short_desc hist_rec_type_desc, C.short_desc event_class_desc, DECODE(A.event_code,A.event_group,NULL,E.short_desc) event_group_desc, d.short_desc event_desc, A.hist_data_type, a.RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, A.result_num_uom, A.result_str,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_LOW, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID = A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE = A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits, A.hist_rec_type, A.contr_sys_event_code, A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, TO_CHAR(event_date,'DD/MM/YYYY hh24:mi') SPECIMEN_COL_DATETIME, a.STATUS, a.NORMALCY_STR, a.encounter_ID, A.FACILITY_ID,A.event_group, a.event_code_type FROM CR_ENCOUNTER_DETAIL A ,CR_HIS_RECTYP_LNG_VW B,  CR_EVENT_CLASS_LANG_VW C,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e WHERE         B.LANGUAGE_ID = ? AND B.hist_rec_type=A.hist_rec_type AND c.hist_rec_type=A.hist_rec_type AND C.event_class= A.event_class AND  C.LANGUAGE_ID = ? AND D.LANGUAGE_ID = ?  AND d.hist_rec_type=A.hist_rec_type AND  d.event_code=A.event_code and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  AND  E.LANGUAGE_ID(+)= ?  AND e.hist_rec_type(+)=A.hist_rec_type AND  e.event_group(+)=A.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE  and patient_id=? ");  // modified for IN067037
			//sql.append("SELECT event_date ,a.accession_num, TO_CHAR(event_date,'hh24:mi') event_date_time, TO_CHAR(EVENT_AUTH_DATE_TIME,'hh24:mi') result_date_time, B.short_desc hist_rec_type_desc, C.short_desc event_class_desc, DECODE(A.event_code,A.event_group,NULL,E.short_desc) event_group_desc, d.short_desc event_desc, A.hist_data_type, a.RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, A.result_num_uom, A.result_str,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_LOW, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID = A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE = A.contr_sys_event_code and (dbms_lob.getlength(hist_data)>0 or nvl(dbms_lob.getlength(compress_hist_data),0)>0)) ,'N') text_exisits, A.hist_rec_type, A.contr_sys_event_code, A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, TO_CHAR(event_date,'DD/MM/YYYY hh24:mi') SPECIMEN_COL_DATETIME, a.STATUS, a.NORMALCY_STR, a.encounter_ID, A.FACILITY_ID,A.event_group, a.event_code_type,0 uploaded_doc_cnt,a.result_status resultStatus FROM CR_ENCOUNTER_DETAIL A ,CR_HIS_RECTYP_LNG_VW B,  CR_EVENT_CLASS_LANG_VW C,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e WHERE         B.LANGUAGE_ID = ? AND B.hist_rec_type=A.hist_rec_type AND c.hist_rec_type=A.hist_rec_type AND C.event_class= A.event_class AND  C.LANGUAGE_ID = ? AND D.LANGUAGE_ID = ?  AND d.hist_rec_type=A.hist_rec_type AND  d.event_code=A.event_code and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  AND  E.LANGUAGE_ID(+)= ?  AND e.hist_rec_type(+)=A.hist_rec_type AND  e.event_group(+)=A.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE  and patient_id=? "); 
			//6484 End.
			sql.append("SELECT event_date ,a.accession_num, TO_CHAR(event_date,'hh24:mi') event_date_time, TO_CHAR(EVENT_AUTH_DATE_TIME,'hh24:mi') result_date_time, B.short_desc hist_rec_type_desc, C.short_desc event_class_desc, DECODE(A.event_code,A.event_group,NULL,E.short_desc) event_group_desc, d.short_desc event_desc, A.hist_data_type, a.RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num, A.result_num_uom, A.result_str,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_LOW, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, a.normalcy_ind,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID = A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE = A.contr_sys_event_code and (dbms_lob.getlength(hist_data)>0 or nvl(dbms_lob.getlength(compress_hist_data),0)>0)) ,'N') text_exisits, A.hist_rec_type, A.contr_sys_event_code, A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, TO_CHAR(event_date,'DD/MM/YYYY hh24:mi') SPECIMEN_COL_DATETIME, a.STATUS, a.NORMALCY_STR, a.encounter_ID, A.FACILITY_ID,A.event_group, a.event_code_type,0 uploaded_doc_cnt,a.result_status resultStatus, TO_CHAR(a.modified_date,'dd/mm/yyyy hh24:mi') modified_date, NOTE_DATA_MODFIED_YN(a.hist_rec_type,a.accession_num) modifiedyn  FROM CR_ENCOUNTER_DETAIL A ,CR_HIS_RECTYP_LNG_VW B,  CR_EVENT_CLASS_LANG_VW C,CR_CLN_EVT_MST_LANG_VW d,CR_CLN_EVT_GRP_LANG_VW e WHERE         B.LANGUAGE_ID = ? AND B.hist_rec_type=A.hist_rec_type AND c.hist_rec_type=A.hist_rec_type AND C.event_class= A.event_class AND  C.LANGUAGE_ID = ? AND D.LANGUAGE_ID = ?  AND d.hist_rec_type=A.hist_rec_type AND  d.event_code=A.event_code and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  AND  E.LANGUAGE_ID(+)= ?  AND e.hist_rec_type(+)=A.hist_rec_type AND  e.event_group(+)=A.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE  and patient_id=? "); //24094 
			
		}//IN070610, ends
		
		if(result_yn.equals("Y"))
			sql.append("and (a.event_date between sysdate-1 and (sysdate) OR A.EVENT_AUTH_DATE_TIME  between sysdate-1 and (sysdate))" );
		else
			sql.append("and a.event_date between sysdate-1 and (sysdate)" );

		sql.append(" and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' "); //IN042552
		//IN071561 STARTS
		 if(restrict_rd)
			   sql.append( " AND RD_PEER_RESULT_HIDE_YN (a.CONTR_SYS_ID,a.facility_id,A.REQUEST_NUM,a.request_num_seq,'"+login_user+"')='N' ");
		//IN071561 ENDS
		if (modal_yn.equals("N"))
		{
			if(result_yn.equals("Y"))
				sql.append(" and (( A.HIST_REC_TYPE != 'LBIN' AND a.event_date in (select event_date from (select event_date, dense_rank() over (order by event_date desc) drank,rank() over (order by event_date desc) rank from cr_encounter_detail where patient_id=? and event_date between sysdate-1 and sysdate) where rank<10 or drank<2) ) OR (A.HIST_REC_TYPE='LBIN' AND CONTR_SYS_ID='LB' AND a.EVENT_AUTH_DATE_TIME in (select EVENT_AUTH_DATE_TIME from (select EVENT_AUTH_DATE_TIME, dense_rank() over (order by EVENT_AUTH_DATE_TIME desc) drank,rank() over (order by EVENT_AUTH_DATE_TIME desc) rank from cr_encounter_detail where patient_id=? and EVENT_AUTH_DATE_TIME between sysdate-1 and sysdate) where rank<10 or drank<2)))");
			else
				sql.append(" and a.event_date in (select event_date from (select event_date, dense_rank() over (order by event_date desc) drank,rank() over (order by event_date desc) rank from cr_encounter_detail where patient_id=? and event_date between sysdate-1 and sysdate) where rank<10 or drank<2) ");
		}
		if (viewconf_appl.equals("X"))
			sql.append(" and (nvl(A.PROTECTION_IND,'N')!='Z' )  ");

		if(result_yn.equals("Y"))
			 //sql.append(" and nvl(a.STATUS,'`') not in('S','E')  order by case when a.hist_rec_type='LBIN' AND CONTR_SYS_ID='LB' THEN  A.EVENT_AUTH_DATE_TIME ELSE a.event_date END desc,hist_rec_type,event_class_desc,a.event_class,request_num_seq,event_group_desc,a.event_group,event_desc,a.event_code "); - commented for IN050649
			 sql.append(" and nvl(a.STATUS,'`') not in('S','E')  order by case when a.hist_rec_type='LBIN' AND CONTR_SYS_ID='LB' THEN  A.EVENT_AUTH_DATE_TIME ELSE a.event_date END desc,hist_rec_type,event_class_desc,a.event_class, event_group_desc, a.event_group, request_num_seq, event_desc, a.event_code "); //modified for  IN050649
		else
			//sql.append(" and nvl(a.STATUS,'`') not in('S','E')  order by a.event_date desc,hist_rec_type,event_class_desc,a.event_class,request_num_seq,event_group_desc,a.event_group,event_desc,a.event_code "); - Commented for IN050649
			sql.append(" and nvl(a.STATUS,'`') not in('S','E')  order by a.event_date desc,hist_rec_type,event_class_desc,a.event_class,event_group_desc, a.event_group, request_num_seq, event_desc, a.event_code "); // modified for IN050649
		
		stmt=con.prepareStatement(sql.toString());
		stmt.setString(1,locale);
		stmt.setString(2,locale);
		stmt.setString(3,locale);
		stmt.setString(4,locale);
		stmt.setString(5,patient_id);

		if (modal_yn.equals("N"))
		{
			if(result_yn.equals("Y"))
			{
				stmt.setString(6,patient_id);
				stmt.setString(7,patient_id);
			}
			else
				stmt.setString(6,patient_id);
		}

		rs = stmt.executeQuery();
		

		while(rs.next())
		{
			accessionNum = rs.getString("accession_num")==null?"":rs.getString("accession_num");
			histRecType = rs.getString("hist_rec_type")==null?"":rs.getString("hist_rec_type");
			contrSysEventCode = rs.getString("contr_sys_event_code")==null?"":rs.getString("contr_sys_event_code");
			contrSysId = rs.getString("contr_sys_id")==null?"":rs.getString("contr_sys_id");
			eventDate = rs.getString("event_date_time")==null?"":rs.getString("event_date_time");
			modified_date = rs.getString("modified_date") == null ? "" : rs.getString("modified_date");//24094
			modified_YN = rs.getString("modifiedyn") == null ? "" : rs.getString("modifiedyn");//24094
			histRecTypeDesc = rs.getString("hist_rec_type_desc")==null?"":rs.getString("hist_rec_type_desc");
			eventClassDesc = rs.getString("event_class_desc")==null?"":rs.getString("event_class_desc");
			eventGroupDesc = rs.getString("event_group_desc")==null?"":rs.getString("event_group_desc");
			eventDesc = rs.getString("event_desc")==null?"":rs.getString("event_desc");
			textExist = rs.getString("text_exisits")==null?"":rs.getString("text_exisits");	
			histDataType = rs.getString("hist_data_type")==null?"":rs.getString("hist_data_type");	
			ext_image_appl_id = rs.getString("ext_image_appl_id")==null?"":rs.getString("ext_image_appl_id");	
			ext_image_obj_id = rs.getString("ext_image_obj_id")==null?"":rs.getString("ext_image_obj_id");
			if(legend_type.equals("C"))
				color_cell_indicator = rs.getString("COLOR_CELL_IND")==null?"":rs.getString("COLOR_CELL_IND");
			else if(legend_type.equals("S"))
				color_cell_indicator = rs.getString("normal_range_symbol")==null?"":rs.getString("normal_range_symbol");
			descCellInd = rs.getString("DESC_CELL_IND") == null ? "" : rs.getString("DESC_CELL_IND");
			normalcyInd = rs.getString("normalcy_ind")==null?"":rs.getString("normalcy_ind");
			result_status = rs.getString("STATUS")==null?"":rs.getString("STATUS");
			resultStatus = rs.getString("resultStatus")==null?"":rs.getString("resultStatus");//29803
			normalcy_str = rs.getString("NORMALCY_STR")==null?"":rs.getString("NORMALCY_STR");
			enctr_id = rs.getString("encounter_ID") == null ? "0" : rs.getString("encounter_ID");//IN031989
			fac_id = rs.getString("FACILITY_ID") == null ? "" : rs.getString("FACILITY_ID");//
			event_group = rs.getString("event_group") == null ? "" : rs.getString("event_group");//IN040416
			styleValue = "";
			event_code_type  = rs.getString("EVENT_CODE_TYPE")==null?"":rs.getString("EVENT_CODE_TYPE"); // IN047204
			// added for Bru-HIMS-CRF-052.1 [IN037793]
			
			ext_image_upld_id = rs.getString("EXT_IMAGE_UPLD_ID") == null ? "" : rs.getString("EXT_IMAGE_UPLD_ID");
			//7902 STARTS
			if(!ext_image_appl_id.equals("")&& ext_image_appl_id.equals("CPACS"))
			{
			
				ext_img_disable="disabled";
				
				pstmtImgView1 = con.prepareStatement("SELECT PARAM_DEF_STR  FROM CA_EXT_IMAGE_APPL_LANG_VW WHERE  EXT_IMAGE_APPL_ID=?"); 
				pstmtImgView1.setString(1,ext_image_appl_id);
				resImgView1 = pstmtImgView1.executeQuery();
				
				while(resImgView1.next())
				{
					param_def_str = resImgView1.getString("PARAM_DEF_STR") == null ? "" : resImgView1.getString("PARAM_DEF_STR");
				}
				if(pstmtImgView1!=null) pstmtImgView1.close();
				if(resImgView1!=null) resImgView1.close();
				
				if(!param_def_str.equals("") && param_def_str.contains("~STUDY_ID`")){
					pstmtImgView = con.prepareStatement("SELECT A.study_id  FROM or_order_line a, cr_encounter_detail b WHERE B.EXT_IMAGE_APPL_ID =? AND to_char(a.ext_appl_accession_num) = b.ext_image_obj_id AND b.ext_image_obj_id=?"); 
					pstmtImgView.setString(1,ext_image_appl_id);
					pstmtImgView.setString(2,ext_image_obj_id);
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
			else if(study_id.equals("") && param_def_str.contains("~STUDY_ID`") && ext_image_appl_id.equals("CPACS"))
			{
				ext_img_disable="disabled";
				ext_img_display="Study ID not available, we cannot Proceed";
			}
			else if(study_id.equals("") && !param_def_str.contains("~STUDY_ID`"))
			{
				ext_img_disable="";
				ext_img_display="";
			}	//7902 ENDS
			if(isClinician&&eventClassDesc.equals("Clinician Notes"))//IN067236
				eventClassDesc="Therapist Notes";//IN067236
			// added for Bru-HIMS-CRF-052.1[IN037793] - Start
			if(!ext_image_upld_id.equals(null) && !ext_image_upld_id.equals("")) {
				pstmtImgView = con.prepareStatement("select EXT_IMAGE_FILE_LOCN_PARAM from CR_EXT_IMAGE_UPLD where EXT_IMAGE_UPLD_ID = ?"); 
				pstmtImgView.setString(1,ext_image_upld_id);
				resImgView = pstmtImgView.executeQuery();
				//contrSysEventCode = event_group; //IN040416
				String recCountInt = "";
				while(resImgView.next())
				{
					ext_img_file_locn = resImgView.getString("EXT_IMAGE_FILE_LOCN_PARAM") == null ? "" : resImgView.getString("EXT_IMAGE_FILE_LOCN_PARAM");
				}
				
				//IN040866 - Start
				String perfFacilityId = "";
				pstmtPerFacId = con.prepareStatement("select  distinct b.performing_facility_id from or_order_line a,or_order b where a.order_id = b.order_id and a.accession_num = ?"); 
				pstmtPerFacId.setString(1,ext_image_obj_id);
				rsetPerFacId = pstmtPerFacId.executeQuery();
				if(rsetPerFacId.next()){
					perfFacilityId = rsetPerFacId.getString("PERFORMING_FACILITY_ID") == null ? "":  rsetPerFacId.getString("PERFORMING_FACILITY_ID");
				}
				
				//IN040866 - End
				// IN052800 - Start
				if(perfFacilityId.equals("") || perfFacilityId == null){
					perfFacilityId = manageEmailBean.getOrderIdFromSpecimen(ext_image_obj_id);
				}
				//IN052800 - End
				//IN065970 starts
				//pstmtImgCount = con.prepareStatement("select count(*) from rl_specimen_image_dtls where OPERATING_FACILITY_ID = ? and SPECIMEN_NO = ? and TEST_CODE = ?");
				//pstmtImgCount.setString(1,fac_id); //commented for IN040866
				//pstmtImgCount.setString(1,perfFacilityId);// modified for IN040866
				pstmtImgCount = con.prepareStatement("select count(*) from rl_specimen_image_dtls where SPECIMEN_NO = ? and TEST_CODE = ?");
				pstmtImgCount.setString(1,ext_image_obj_id);
				pstmtImgCount.setString(2,contrSysEventCode);////48184 As per discuss with lab.I have done changes
				//pstmtImgCount.setString(2,event_group); //IN040416
			//	pstmtImgCount.setString(2,event_group); 

				//IN065970 ends
				
				rsetImgCount = pstmtImgCount.executeQuery();
				if(rsetImgCount.next()) 
				{
					recCount = rsetImgCount.getInt(1);
				}
				
				recCountInt = String.valueOf(recCount);
				//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",ext_image_obj_id).replace("~test#",contrSysEventCode).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",facilityId).replace("~user_id#",login_user).replace("~language_id#",locale); //commented for IN040866
				//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",ext_image_obj_id).replace("~test#",contrSysEventCode).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",perfFacilityId).replace("~user_id#",login_user).replace("~language_id#",locale); // modified for IN040866, IN040416
				//IN065970 reopen starts
				//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",ext_image_obj_id).replace("~test#",event_group).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",perfFacilityId).replace("~user_id#",login_user).replace("~language_id#",locale); // modified for IN040416
				//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",ext_image_obj_id).replace("~test#",event_group).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",fac_id).replace("~user_id#",login_user).replace("~language_id#",locale); // IN065970 reopen ends
			   	  ext_img_file_locn = ext_img_file_locn.replace("~specNum#",ext_image_obj_id).replace("~test#",contrSysEventCode).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",fac_id).replace("~user_id#",login_user).replace("~language_id#",locale); // //48184 As per discuss with lab.I have done changes

				if(resImgView  != null) resImgView.close();
				if(pstmtImgView != null) pstmtImgView.close();

				if(rsetImgCount  != null)  rsetImgCount.close();
				if(pstmtImgCount  != null) pstmtImgCount.close();

				if(rsetPerFacId  != null) rsetPerFacId.close();
				if(pstmtPerFacId  != null) pstmtPerFacId.close();
			}	
			//Bru-HIMS-CRF-052.1[IN037793] - End
			if(!color_cell_indicator.equals("") && color_cell_indicator != null)
				styleValue = "STYLE= 'FONT-SIZE: 7PT;background-color:"+color_cell_indicator+"' ";
			else
				styleValue = " class = 'QRYEVEN' ";	
			
			if(result_yn.equals("Y") && histRecType.equals("LBIN") && contrSysId.equals("LB"))
				eventDate = rs.getString("result_date_time")==null?"":rs.getString("result_date_time");
						
			if(!eventDate.equals(eventDatePrev))
			{
				i++;
				classValue = "QRYODD";

				if(result_yn.equals("Y") && histRecType.equals("LBIN") && contrSysId.equals("LB"))
					out.println("<tr><td VALIGN=top class='gridData' colspan=3><b>"+eventDate+" ("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.SpecimenCollectedAt.label","ca_labels")+" : "+rs.getString("SPECIMEN_COL_DATETIME")+")</b></td></tr>");
				else
					out.println("<tr><td VALIGN=top class='gridData' colspan=3><b>"+eventDate+"</b></td></tr>");
				out.println("<tr><td VALIGN=top class='gridData' colspan=3>&nbsp;<b>"+histRecTypeDesc+"</b></td></tr>");
				out.println("<tr><td VALIGN=top class='gridData' colspan=3>&nbsp;&nbsp;<b>"+eventClassDesc+"</b></td></tr>");
				if (!eventGroupDesc.equals(""))
					out.println("<tr><td VALIGN=top class='gridData' colspan=3>&nbsp;&nbsp;&nbsp;<b>"+eventGroupDesc+"</b></td></tr>");
							
				eventDatePrev = eventDate;
				histRecTypeDescPrev = histRecTypeDesc;
				eventClassDescPrev = eventClassDesc;
				eventGroupDescPrev = eventGroupDesc;
			}
			else if(!histRecTypeDesc.equals(histRecTypeDescPrev))
			{
				classValue = "QRYODD";
				out.println("<tr><td VALIGN=top  class='gridData' colspan=3>&nbsp;<b>"+histRecTypeDesc+"</b></td></tr>");
				out.println("<tr><td VALIGN=top class='gridData' colspan=3>&nbsp;&nbsp;<b>"+eventClassDesc+"</b></td></tr>");
				if (!eventGroupDesc.equals(""))
					out.println("<tr><td VALIGN=top class='gridData' colspan=3>&nbsp;&nbsp;&nbsp;"+eventGroupDesc+"</b></td></tr>");
							
				histRecTypeDescPrev = histRecTypeDesc;
				eventClassDescPrev = eventClassDesc;
				eventGroupDescPrev = eventGroupDesc;
			}
			
			else if(!eventClassDesc.equals(eventClassDescPrev))
			{
				classValue = "QRYODD";
				out.println("<tr><td VALIGN=top class='gridData' colspan=3>&nbsp;&nbsp;<b>"+eventClassDesc+"</b></td></tr>");
				if (!eventGroupDesc.equals(""))
					out.println("<tr><td VALIGN=top class='gridData' colspan=3>&nbsp;&nbsp;&nbsp;<b>"+eventGroupDesc+"</b></td></tr>");
							
				eventClassDescPrev = eventClassDesc;
				eventGroupDescPrev = eventGroupDesc;
			}
			else if(!eventGroupDesc.equals(eventGroupDescPrev))
			{
				classValue = "QRYODD";
				if (!eventGroupDesc.equals(""))
					out.println("<tr><td VALIGN=top class='gridData' colspan=3>&nbsp;&nbsp;&nbsp;<b>"+eventGroupDesc+"</b></td></tr>");
							
				eventGroupDescPrev = eventGroupDesc;
			}

			classValue = "QRYEVEN";	
			resultStr = rs.getString("result_str")==null?"":rs.getString("result_str");
			if("Y".equals(hideSpecimenType) && "LBIN".equals(histRecType))//IN066119
			{
				resultStr="";
			}
			
			out.println("<tr><td class='gridData'>&nbsp;&nbsp;&nbsp&nbsp;</td><td VALIGN=top  class='gridData'>"+eventDesc+"</td>");

			if(histDataType.equals("NUM"))
			{
				result_num_prefix=rs.getString("result_num_prefix")==null?"":rs.getString("result_num_prefix");
				//IN064688 Changes starts
				//resultNum=rs.getString("result_num")==null?"":rs.getString("result_num");//Menaka for IN:028353 
				BigDecimal rm =rs.getBigDecimal("result_num");
				if(rm!=null)
				resultNum=rm.toString();
				else
				resultNum="";
				//IN064688 Changes Ends
				
				resultNumUom=rs.getString("result_num_uom")==null?"":rs.getString("result_num_uom");
				//IN064688 Changes starts
				//normalLow=rs.getString("NORMAL_LOW")==null?"":rs.getString("NORMAL_LOW");
				BigDecimal nl =rs.getBigDecimal("NORMAL_LOW");
				if(nl!=null)
				normalLow=nl.toString();
				else
				normalLow="";
				//normalHigh=rs.getString("NORMAL_HIGH")==null?"":rs.getString("NORMAL_HIGH");
				BigDecimal nh=rs.getBigDecimal("NORMAL_HIGH");
				if(nh!=null)
				normalHigh=nh.toString();
				else
				normalHigh="";
				//IN064688 Changes Ends
				out.println("<td class='gridData'>");
				//HSA-CRF-0257.1 - IN055910- Start
				if("LBIN".equalsIgnoreCase(histRecType) && "C".equalsIgnoreCase(result_status)) {
					out.println("<img src='../../eCA/images/modifiedresult.png' name='mod_result' alt='Modified Result'/>&nbsp;");
				}	
				//HSA-CRF-0257.1 - IN055910 - End				
				if(!color_cell_indicator.equals("") && color_cell_indicator != null)
				{
					if(legend_type.equals("S"))
						out.println("<font  style='background-image:url(\"../../eCA/images/"+color_cell_indicator+"\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
					else
						out.println("<font  style='background-color:"+color_cell_indicator+";size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
				}
				else
				{
					if(normalcyInd.equals("."))
					{
						if(legend_type.equals("S"))
							out.println("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
						else
							out.println("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
					}
					else if(!normalLow.equals("") && !normalHigh.equals(""))
					{
						if(Float.parseFloat(resultNum) > 0)
						{
							if((Float.parseFloat(resultNum) >= Float.parseFloat(normalLow)) && (Float.parseFloat(resultNum) <= Float.parseFloat(normalHigh)))
							{
								if(legend_type.equals("S"))
									out.println("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
								else
									out.println("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
							}
						}
					}
					else if(!normalLow.equals("") && normalHigh.equals(""))//Added by Jyothi.G on 09/12/2010 to fix IN025310
					{
						if(Float.parseFloat(resultNum) > 0)
						{
							if(Float.parseFloat(resultNum) >= Float.parseFloat(normalLow)) 
							{
								if(legend_type.equals("S"))
									out.println("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
								else
									out.println("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
							}
						}
					}
					else if(normalLow.equals("") && !normalHigh.equals(""))
					{
						if(Float.parseFloat(resultNum) > 0)
						{
							if(Float.parseFloat(resultNum) <= Float.parseFloat(normalHigh))
							{
								if(legend_type.equals("S"))
									out.println("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
								else
									out.println("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
							}
						}
					}//END
				}
				//IN067037 starts
				/*
				//IN053093 Starts
				if(Float.parseFloat(resultNum) < 1)
				{
					out.println("<b>"+result_num_prefix+Double.parseDouble(resultNum)+"</b>&nbsp;"+resultNumUom);
				}
				else
				{
					out.println("<b>"+result_num_prefix+resultNum+"</b>&nbsp;"+resultNumUom);
				}
				//IN053093 Ends
				*/
				if(!resultNum.equals("")){
					out.println("<b>"+result_num_prefix+resultNum+"</b>&nbsp;"+resultNumUom);
				}
				//IN067037 ends
				//Added by Jyothi.G on 09/12/2010 to fix IN025310
				if(!normalLow.equals("") && !normalHigh.equals(""))
					out.println("("+normalLow+"~"+normalHigh+")");
				else if(!normalLow.equals(""))
					out.println("(>="+normalLow+")");
				else if(!normalHigh.equals(""))
					out.println("(<="+normalHigh+")");//END
					
				if(!normalcyInd.equals(""))
				{
					out.println("<FONT size =1 COLOR='BLACK' >"+descCellInd+"<br></FONT>");						
				}

				if(!resultStr.equals(""))
				{
					if(resultStr.length() > 25){
						tempStrValue = resultStr.substring(0,24);
						resultStr = replaceSpecialChar(resultStr);
						//resultStr= java.net.URLEncoder.encode(resultStr); // added for ML-BRU-SCF-1642 - IN057138
						out.println("&nbsp;<a href=\"javaScript:ShowComments('"+resultStr+"')\">"+tempStrValue+"...</a>");
					}else{
						out.println("&nbsp;"+resultStr);
					}
				}
				if(textExist.equals("Y"))
				{
					//out.println("<input type='image' src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"')\">");//IN031989	
					out.println("<input type='image' src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"','"+enctr_id+"','"+fac_id+"')\">");//IN031989	//IN033489
				}
			}
			else if(histDataType.equals("STR"))
			{
				out.println("<td VALIGN=top class='gridData'>");
				//HSA-CRF-0257.1 - IN055910- Start
				if("LBIN".equalsIgnoreCase(histRecType) && "C".equalsIgnoreCase(result_status)) {
					out.println("<img src='../../eCA/images/modifiedresult.png' name='mod_result' alt='Result Modified'/>&nbsp;");
				}	
				//HSA-CRF-0257.1 - IN055910 - End
				if(!color_cell_indicator.equals(""))
				{
					if(legend_type.equals("S"))
						out.println("<font  style='background-image:url(\"../../eCA/images/"+color_cell_indicator+"\");size:1;width:16px;height:16px' ></font>&nbsp;");
					else
						out.println("<font  style='background-color:"+color_cell_indicator+";size:1;width:16px;height:16px'></font>&nbsp;");
				}
				else if(normalcyInd.equals("."))
				{
					if(legend_type.equals("S"))
						out.println("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
					else
						out.println("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
				}
				if(resultStr.length() > 25)
				{
					tempStrValue = resultStr.substring(0,24);
					resultStr = replaceSpecialChar(resultStr);
					//resultStr= java.net.URLEncoder.encode(resultStr); // added for ML-BRU-SCF-1642 - IN057138
					out.println("<a class='gridLink' href=\"javaScript:ShowComments('"+resultStr+"')\">"+tempStrValue+"...</a>");
				}
				else
				{
					out.println(resultStr);
				}

				if(!normalcyInd.equals(""))
				{
					out.println("<FONT size = 1 COLOR='BLACK' >"+descCellInd+"<br></FONT>");						
				}
				if(!normalcy_str.equals(""))
				{
					out.println(" <font color=blue>( Normal Value : "+normalcy_str+" )</font>");
				}
				if(textExist.equals("Y"))
				{
					out.println("<input type='image' src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"')\">");	
					
				}
			}
			else if(histDataType.equals("TXT")||histDataType.equals("HTM"))
			{
				out.println("<td VALIGN=top class='gridData'>");
				//HSA-CRF-0257.1 - IN055910- Start
				if("LBIN".equalsIgnoreCase(histRecType) && "C".equalsIgnoreCase(result_status)) {
					out.println("<img src='../../eCA/images/modifiedresult.png' name='mod_result' alt='Modified Result'/>&nbsp;");
				}	
				//HSA-CRF-0257.1 - IN055910 - End
				if(!color_cell_indicator.equals(""))
				{
					if(legend_type.equals("S"))
						out.println("<font  style='background-image:url(\"../../eCA/images/"+color_cell_indicator+"\");size:1;width:16px;height:16px' ></font>&nbsp;");
					else
						out.println("<font  style='background-color:"+color_cell_indicator+";size:1;width:16px;height:16px'></font>&nbsp;");
				}
				else if(normalcyInd.equals("."))
				{
					if(legend_type.equals("S"))
						out.println("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
					else
						out.println("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
				}
				if(!histRecType.equals("CLNT")&& histDataType.equals("TXT"))
				{
					//out.println("Result Text:");
				}
				if(textExist.equals("Y"))
				{
					//out.println("<input type='image' src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"')\">");//IN031989
					//24094 starts
					 if(modified_YN.equals("Y")){
					out.println("<img src='../../eCA/images/modifiedresult.png' />");
					}
					//24094 ends
					out.println("<input type='image' src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"','"+enctr_id+"','"+fac_id+"')\">");//IN031989	//IN033489				
				}
			}
			if(!ext_image_appl_id.equals(""))
			{
				if(!("DMS").equals(ext_image_appl_id)) { // IN049533
					if(!("DOCUL").equals(ext_image_appl_id) && (ext_image_upld_id.equals(null) || ext_image_upld_id.equals("")))  // modified for IN040237 - START
					  //if(!("DOCUL").equals(ext_image_appl_id)) //Condition added for EMG // modified for IN040237
					{
						//IN050936 included patient_id	
						  //out.println("<img src='../../eCA/images/"+ext_image_appl_id+".gif' onClick=\"return getFile('"+histRecType+"','"+contrSysId+"','"+ext_image_obj_id+"','"+contrSysEventCode+"','"+ext_image_appl_id+"','"+patient_id+"')\">");//7902
						  out.println("<img src='../../eCA/images/"+ext_image_appl_id+".gif' "+ext_img_disable+" onClick=\"return getFile('"+histRecType+"','"+contrSysId+"','"+ext_image_obj_id+"','"+contrSysEventCode+"','"+ext_image_appl_id+"','"+patient_id+"')\"  alt='"+ext_img_display+"' >");//7902
					}
					else if (ext_image_upld_id.equals(null) || ext_image_upld_id.equals(""))
					{ 	
						//IN050936 included patient_id
						//out.println("<img src='../../eCA/images/"+ext_image_appl_id+".gif'  onClick=\"return getFile('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"','"+ext_image_appl_id+"','"+patient_id+"')\">");//7902
						out.println("<img src='../../eCA/images/"+ext_image_appl_id+".gif' "+ext_img_disable+" onClick=\"return getFile('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"','"+ext_image_appl_id+"','"+patient_id+"')\"  alt='"+ext_img_display+"' >");//7902
					}
					else if((!ext_image_upld_id.equals(null) && !ext_image_upld_id.equals("")) && recCount > 0) {
						out.println("<a style='cursor:pointer;color:blue' onClick=\"viewUploadedImg('"+ext_img_file_locn+"')\"><br></br>View Image </a>");
					}
				}	// IN049533
			}
			
			/* commented for IN040237
			// added for Bru-HIMS-CRF-052.1 [IN037793]
			if((!ext_image_upld_id.equals(null) && !ext_image_upld_id.equals("")) && recCount > 0) {
				out.println("<a style='cursor:pointer;color:blue' onClick=\"viewUploadedImg('"+ext_img_file_locn+"')\"> View Image </a>");
			}
			*/
			// added for IN047204 - Start
			
			if("Y".equals(dmsExternalLinkYN)) {// && "RD".equals(event_code_type)) { // commented for  Bru-HIMS-CRF-195.3 - IN047205 
					extLinkHashMap = oEncounterList.getExternalLinkParameters(fac_id, patient_id, enctr_id, locale); 
					admit_date	= (String) extLinkHashMap.get("P_ENCNTR_DATE");
					locn_code	= (String) extLinkHashMap.get("P_LOCN_CODE");
					locn_type	= (String) extLinkHashMap.get("P_LOCN_TYPE");
					visit_id	= (String) extLinkHashMap.get("P_VISIT_ID");
					loc_desc	= (String) extLinkHashMap.get("P_LOC_DESC");
					physician_id	= (String) extLinkHashMap.get("P_PHYSICIAN_ID");
					encntr_type	= (String) extLinkHashMap.get("P_EPISODE_TYPE");
					
					externalList = oEncounterList.getExternalLinkdata(histRecType, contrSysId, accessionNum, contrSysEventCode); //Bru-HIMS-CRF-195.3 - IN047205 - Start
					Iterator iter = externalList.iterator();
					while(iter.hasNext()){
						externalDataDTO = (eCA.CAExternalLinkDataDTO)iter.next();
						ext_image_appli_id = externalDataDTO.getExt_image_appl_id();
						ext_image_obj_id_dms = externalDataDTO.getExt_image_obj_id();
						ext_image_source = externalDataDTO.getExt_image_source();
						ext_srce_doc_ref_no = externalDataDTO.getSrce_doc_ref_no();
						ext_srce_doc_ref_line_no = externalDataDTO.getSrce_doc_ref_line_no();
						if("RD".equals(event_code_type)) { 		//Bru-HIMS-CRF-195.3 - IN047205 - End
						
							//Fix for IN047566/Start
							//access_no_rd 	= accessionNum.substring(accessionNum.indexOf("#")+1, accessionNum.indexOf("$"));
							if ((ext_image_obj_id.equals(null) || ext_image_obj_id.equals(""))) 
								access_no_rd 	= accessionNum.substring(accessionNum.indexOf("#")+1, accessionNum.indexOf("$"));
							else
								access_no_rd 	= ext_image_obj_id;
							//Fix for IN047566/End
							
							pstmtOrderId = con.prepareStatement("select  order_id, order_type_code from or_order_line where accession_num = ?"); 
							pstmtOrderId.setString(1,access_no_rd);
							rsetOrderId = pstmtOrderId.executeQuery();
							if(rsetOrderId.next()){
								order_id = rsetOrderId.getString("order_id") == null ? "":  rsetOrderId.getString("order_id");
								order_typ_code	= rsetOrderId.getString("order_type_code") == null ? "":  rsetOrderId.getString("order_type_code");	
							}
							
							if(rsetOrderId  != null) rsetOrderId.close();
							if(pstmtOrderId  != null) pstmtOrderId.close();
							
							//out.println("<img src='../../eCommon/images/ExternalDocument.PNG' title='External Link' onClick=\"return getExtLink('"+patient_id+"','"+enctr_id+"','"+accessionNum+"','"+order_id+"','"+fac_id+"','"+locale+"','"+login_user+"','"+resp_id+"','"+login_at_ws_no+"','"+order_typ_code+"','"+visit_id+"','"+physician_id+"','"+locn_type+"','"+locn_code+"','"+admit_date+"','"+encntr_type+"','"+loc_desc+"')\">");//IN47847 Added title to img tag - commented for Bru-HIMS-CRF-195.3 - IN047205 
							out.println("<img src='../../eCommon/images/ExternalDocument.PNG' title='External Link' onClick=\"return getExtLink('"+patient_id+"','"+enctr_id+"','"+accessionNum+"','"+order_id+"','"+fac_id+"','"+locale+"','"+login_user+"','"+resp_id+"','"+login_at_ws_no+"','"+order_typ_code+"','"+visit_id+"','"+physician_id+"','"+locn_type+"','"+locn_code+"','"+admit_date+"','"+encntr_type+"','"+loc_desc+"','"+ext_image_appli_id+"','"+ext_image_obj_id_dms+"','"+ext_image_source+"','"+ext_srce_doc_ref_no+"','"+ext_srce_doc_ref_line_no+"')\">");
						}	//Bru-HIMS-CRF-195.3 - IN047205 - Start
						else{
							
								out.println("<img src='../../eCommon/images/ExternalDocument.PNG' title='External Link' onClick=\"return getExtLink('"+patient_id+"','"+enctr_id+"','"+accessionNum+"','"+order_id+"','"+fac_id+"','"+locale+"','"+login_user+"','"+resp_id+"','"+login_at_ws_no+"','"+order_typ_code+"','"+visit_id+"','"+physician_id+"','"+locn_type+"','"+locn_code+"','"+admit_date+"','"+encntr_type+"','"+loc_desc+"','"+ext_image_appli_id+"','"+ext_image_obj_id_dms+"','"+ext_image_source+"','"+ext_srce_doc_ref_no+"','"+ext_srce_doc_ref_line_no+"')\">");
								
						}
					}	//Bru-HIMS-CRF-195.3 - IN047205 - End	
			}
			// added for IN047204 - End
			//IN070610, starts
			String l_upload_view = "N";
			Integer l_rec_cnt = 0;
			
			if(uploadFuncTrOrders)
				l_rec_cnt = Integer.parseInt(rs.getString("uploaded_doc_cnt"));
			
			if(l_rec_cnt > 0 && "TRET".equals(histRecType) && uploadFuncTrOrders)
			{
				l_upload_view = "Y";
			}							
			
			if("Y".equals(l_upload_view))								
				out.println("<a style='cursor:pointer;color:blue' onClick=\"uploadedDocuments('"+accessionNum+"','"+contrSysEventCode+"')\"><img src='../../eOR/images/DOCUL.gif' width='16' height='16' border=0 alt='Uploaded Documents'/></a>");
			//IN070610, ends
			
			if(result_status.equals("P") || resultStatus.equals("4") )  //resultStatus add for 29803
				out.println("<font color='red'>(Preliminary)</font>");
			out.println("</td></tr>");
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();

		if (i==0)
			out.println("<tr><td class='gridData'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Nohistorydata.label","ca_labels")+"</td></tr>");		
		else if (modal_yn.equals("N"))
		{

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(title));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(reln_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(enc_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(p_review_rad_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

		}
	}	
	catch(Exception e)
	{
		//out.println(e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{	
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(enc_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.MoreDtlRef.label", java.lang.String .class,"key"));
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
}
