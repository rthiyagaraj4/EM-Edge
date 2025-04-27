package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import eCA.*;
import java.text.*;
import java.io.*;
import java.net.*;
import webbeans.eCommon.*;
import javax.servlet.*;
import java.sql.Clob;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __encsummpageheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/EncSummPageHeader.jsp", 1709115861794L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--[if IE 6]>  \n  <!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\">\n<![endif]-->  \n<!--[if IE 7]>  \n  <!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\">\n<![endif]-->  \n<!--[if gte IE 7]>  \n\t<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"> \n<![endif]-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="  \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n\t<head>\n\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\" />\n\t\t<title>Encounter Summary Header Preview</title>\t\t\n\t\t<style type=\"text/css\">\n\t\t\ttable.bottomBorder { border-collapse:collapse; }\n\t\t\ttable.bottomBorder { border-bottom:1px dotted black;padding:5px; }\n\t\t</style>\n\t\t\t\t\n\t</head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\t\n\t<body class=\'CONTENT\' scroll=\"auto\" style=\"background-color:transparent\">\n\t\t<form name=\"EncounterSummary_HeaderForm\" id=\"EncounterSummary_HeaderForm\">\n\t\t\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t\t\n\n\n\n\n\t\t<table align=\'center\' border=\'0\' cellpadding=\'0\' cellspacing=\'0\' style=\'width: 900px\'>\n\t\t\t<tbody>\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<td valign=\'top\' align=\'center\' bgcolor=\"#DCDCDC\"><span\n\t\t\t\t\t\t\tstyle=\'font-size: 11pt\'><strong><span\n\t\t\t\t\t\t\t\t\tstyle=\'color: XYZ808080\'><span\n\t\t\t\t\t\t\t\t\t\tstyle=\'font-family: verdana, geneva, sans-serif\'>Current Header Preview</span></span></strong></span>\n\t\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<td valign=\'top\' align=\'center\' bgcolor=\"#DCDCDC\"><span\n\t\t\t\t\t\t\tstyle=\'font-size: 11pt\'><strong><span\n\t\t\t\t\t\t\t\t\tstyle=\'color: XYZ808080\'><span\n\t\t\t\t\t\t\t\t\t\tstyle=\'font-family: verdana, geneva, sans-serif\'>Current Footer Preview</span></span></strong></span>\n\t\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t</tr>\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t</tbody>\n\t\t</table>\t\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\n\t\t\t<table align=\'center\' border=\'0\' cellpadding=\'0\' cellspacing=\'0\' style=\'width: 900px\'>\n\t\t\t\t<thead>\n\t\t\t\t\t<p>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</p>\n\t\t\t\t</thead>\n\t\t\t</table>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</p>\n\t\t\t\t</thead>\n\t\t\t</table>\t\t\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<hr>\t\t\t\n\t\t\t<table align=\'center\' border=\'0\' cellpadding=\'0\' cellspacing=\'0\' style=\'width: 900px\'>\n\t\t\t\t<tbody>\n\t\t\t\t\t<tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t<td valign=\'top\' align=\'center\' bgcolor=\"#DCDCDC\"> <span\n\t\t\t\t\t\t\t\tstyle=\'font-size: 11pt\'><strong><span\n\t\t\t\t\t\t\t\t\t\tstyle=\'color: XYZ808080\'><span\n\t\t\t\t\t\t\t\t\t\t\tstyle=\'font-family: verdana, geneva, sans-serif\'>Modified Header Preview</span></span></strong></span>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t<td valign=\'top\' align=\'center\' bgcolor=\"#DCDCDC\"><span\n\t\t\t\t\t\t\t\tstyle=\'font-size: 11pt\'><strong><span\n\t\t\t\t\t\t\t\t\t\tstyle=\'color: XYZ808080\'><span\n\t\t\t\t\t\t\t\t\t\t\tstyle=\'font-family: verdana, geneva, sans-serif\'>Modified Footer Preview</span></span></strong></span>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t</tbody>\n\t\t\t</table>\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\n\t\t\t\t<table align=\'center\' border=\'0\' cellpadding=\'0\' cellspacing=\'0\' style=\'width: 900px\'>\n\t\t\t\t\t<thead>\n\t\t\t\t\t\t<p>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</p>\n\t\t\t\t\t</thead>\n\t\t\t\t</table>\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t<table align=\'center\' border=\'0\' cellpadding=\'0\' cellspacing=\'0\' style=\'width: 900px\'>\n\t\t\t\t\t<thead>\n\t\t\t\t\t\t<p>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</p>\n\t\t\t\t\t</thead>\n\t\t\t\t</table>\t\t\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\t\t\t\n\t\t\n\t\t<hr>\t\t\n\t\t</form></body>\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n</html>\n\n\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );
	
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);
	
	response.setHeader( "Pragma", "no-cache" );   
	response.setHeader( "Cache-Control", "no-cache" );   
	response.setDateHeader( "Expires", 0 );
	
	request.setCharacterEncoding("UTF-8");
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	String facilityId	= (String)session.getValue("facility_id");
	
	String demoSql = "", bloodSql = "", encounterSql = "", complaintSql = "", orderSql = "", encSummSql="", authSplSql="", patientSql = "", headerFooterSql = "";
	String locnSql = "", payerSql = "";
	
	// Database Connection, Statements and Resultset Variables
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement stmt = null;
	CallableStatement cstmt = null;

	//Patient Demographic Information variables
	String patientid = "", encounterid = "";
	String patientNamePrefix = "", patientFirstName = "", patientSecondName = "", patientThirdName = "", patientFamilyName = "", gender = "", dateOfBirth = "", ageInYears = "";
	String patientName = "", bloodGroup = "";
	
	//Patient Encounter Information variables
	String attendPractitionerId = "", visitDateTime = "", practitionerName = "", specialtyName = "";
	String locnType = "", locnCode = "", locnDesc = "";
	String payerCode ="", payerName = "";
	
	//Facility Details
	String facilityName = "", addrLine1="", addrLine2="", addrLine3="", addrLine4="", postalCode="", countryName="";
	String telephone1="", telephone2="", telephone3="", telephone4="", fax= "";
	String emailId="", website="", address="";
	
	//Summary Details
	String v_summ_code = "", v_summ_desc = "";
	
	//Signature Doctor Details
	String attendPractName = "", attendPractDegree = "", attendPractSplty ="";
	String admitPractName = "", admitPractDegree = "", admitPractSplty = ""; 
    String authPractName = "", authPractDegree = "", authPractSplty = ""; 
	
	//Order Specific Details
	String specimenNo = "", specimenType = "", orderNo = "", orderDate="";
	String collectedDate = "", registeredDate = "", authorisedBy = "", authorisedDate="", printedDate="";

	// HTML header String
	String htmlHeaderString = "", htmlFooterString = "";
	String htmlHeaderPrevString = "", htmlFooterPrevString = "";
	Blob blobImage = null;
	String facilityImageName = "";
	
	String headfootFlagStr = "";
	int headfootFlag = 0;
	
	String changeFlag = "";
	
	String printFlag = "0";
	char charAtEnd = '\u0000';	
	
	int chunkSize = 0;
	Reader instream = null; 
	
	//htmlHeaderString = request.getParameter("headerString")==null?"":request.getParameter("headerString");
	
	//htmlHeaderString = URLDecoder.decode(htmlHeaderString);
		
	v_summ_code = request.getParameter("summCode")==null?"":request.getParameter("summCode");	
	
	if (htmlHeaderString.length() <1)
		htmlHeaderString = "";
	
	try
	{
		
		con		= ConnectionManager.getConnection(request);
		
		headfootFlagStr = request.getParameter("HeadFootFlag")==null? "":request.getParameter("HeadFootFlag");
		headfootFlag = Integer.parseInt(headfootFlagStr);
		
		changeFlag = request.getParameter("changeFlag")==null? "":request.getParameter("changeFlag");
		
		headerFooterSql = "select es_header_code, es_footer_code, es_header_code_preview, es_footer_code_preview from cr_es_summ_layout_hdr where ES_SUMM_CODE = ?";
		stmt=con.prepareStatement(headerFooterSql);
		stmt.setString(1, v_summ_code);
		rs=stmt.executeQuery();
		
		if (rs!=null){
			if(rs.next())
			{
				Clob headerClob = rs.getClob("es_header_code");
				Clob footerClob  = rs.getClob("es_footer_code");
				
				Clob headerPrevClob = rs.getClob("es_header_code_preview");
				Clob footerPrevClob  = rs.getClob("es_footer_code_preview");
				
				if (headerClob != null) {  
			    	htmlHeaderString = headerClob.getSubString(1, (int) headerClob.length());
			   	}
				
				if (footerClob != null) {  
					htmlFooterString = footerClob.getSubString(1, (int) footerClob.length());
			   	}
				
				if (headerPrevClob != null) {  
			    	htmlHeaderPrevString = headerPrevClob.getSubString(1, (int) headerPrevClob.length());
			   	}
				
				if (footerPrevClob != null) {  
					htmlFooterPrevString = footerPrevClob.getSubString(1, (int) footerPrevClob.length());
			   	}
			}
		}
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
		
		if ((htmlHeaderString.length()> 0) || (htmlFooterString.length()> 0)){
			
			patientSql = "select patient_id, encounter_id from cr_encounter_detail where rowid in (select max(rowid) from cr_encounter_detail)";
			stmt=con.prepareStatement(patientSql);
			rs=stmt.executeQuery();
	
			if (rs!=null){
				if(rs.next())
				{
					patientid = rs.getString("patient_id")==null?"":rs.getString("patient_id");
					encounterid = rs.getString("encounter_id")==null?"":rs.getString("encounter_id");
				}
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			
			// To get the Facility Information
			rs = null;
			stmt = null;
			demoSql="select facility_name, addr_line1, addr_line2, addr_line3, addr_line4, addr_postal_code, tel_no1, tel_no2, tel_no3, tel_no4, fax_no, email_id, website_id, "+
						" long_name country_name, facility_logo, facility_image_file_name  from sm_facility_param a, mp_country b "+
						" where facility_id = ? and a.country_code = b.country_code(+)  ";
			stmt=con.prepareStatement(demoSql);
			stmt.setString(1,facilityId);
	
			rs=stmt.executeQuery();
	
			if (rs!=null){
				if(rs.next())
				{
					facilityName = rs.getString("facility_name")==null?"":rs.getString("facility_name");
					addrLine1 = rs.getString("addr_line1")==null?"":rs.getString("addr_line1");
					addrLine2 = rs.getString("addr_line2")==null?"":rs.getString("addr_line2");
					addrLine3 = rs.getString("addr_line3")==null?"":rs.getString("addr_line3");
					addrLine4 = rs.getString("addr_line4")==null?"":rs.getString("addr_line4");
					postalCode = rs.getString("addr_postal_code")==null?"":rs.getString("addr_postal_code");
					telephone1 = rs.getString("tel_no1")==null?"":rs.getString("tel_no1");
					telephone2 = rs.getString("tel_no2")==null?"":rs.getString("tel_no2");
					telephone3 = rs.getString("tel_no3")==null?"":rs.getString("tel_no3");
					telephone4 = rs.getString("tel_no4")==null?"":rs.getString("tel_no4");
					fax = rs.getString("fax_no")==null?"":rs.getString("fax_no");
					emailId = rs.getString("email_id")==null?"":rs.getString("email_id");
					website = rs.getString("website_id")==null?"":rs.getString("website_id");
					countryName = rs.getString("country_name")==null?"":rs.getString("country_name");
					blobImage = rs.getBlob("facility_logo");   
					facilityImageName = rs.getString("facility_image_file_name")==null?"":rs.getString("facility_image_file_name");
					
					if (addrLine1.length()>0){
						charAtEnd = addrLine1.charAt(addrLine1.length() - 1);
						if (!(charAtEnd == ','))
							addrLine1 += ',';	
					}
					
					if (addrLine2.length()>0){
						charAtEnd = addrLine2.charAt(addrLine2.length() - 1);
						if (!(charAtEnd == ','))
							addrLine2 += ',';
					}
					
					if (addrLine3.length()>0){
						charAtEnd = addrLine3.charAt(addrLine3.length() - 1);
						if (!(charAtEnd == ','))
							addrLine3 += ',';
					}
					
					if (addrLine4.length()>0){
						charAtEnd = addrLine4.charAt(addrLine4.length() - 1);
						if (!(charAtEnd == ','))
							addrLine4 += ',';
					}
					
					address = addrLine1 + " " + addrLine2 +" "+ addrLine3 + " " + addrLine4+ " " + postalCode + " " +countryName +".";
	
					
				}
			}		
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
	
			/** BLOB to Image **/
	
			long blobLength = blobImage.length();

			if (blobLength>0){
				
				StringBuffer image_folder = new StringBuffer();
				String path	= "";		
				String strFileSep =	"";		
		
				java.util.Properties pFileSep	= null;
				
				try
				{					
					
					path = application.getRealPath("/");
		
					image_folder.append(path);
		
					pFileSep	= System.getProperties();
					strFileSep	= (String) pFileSep.getProperty("file.separator");
					image_folder.append("eCA");
					image_folder.append(strFileSep);
					image_folder.append("images");
					image_folder.append(strFileSep);			
					image_folder.append(facilityImageName);	
									
					File filecreate ;		
					String filename	= "";
					boolean fcre = false;
					
					filename = image_folder.toString();
					
					filecreate = new File(filename);			
					if(!filecreate.exists())
					{
						InputStream is = blobImage.getBinaryStream();   
			            FileOutputStream fos = new FileOutputStream(filename);   
			  
						int b = 0;   
						while ((b = is.read()) != -1)   
						{   
						    fos.write(b);    
						}   
						fos.close();
					}				
				}		
				catch ( IOException e )
				{
					//out.println("<h3> Exception raise by Servlet ...Error in getting image file path </h3> Foll: Error Received : "+e.toString());//COMMON-ICN-0181
					e.printStackTrace();
				}
				catch ( Exception e )
				{
					//out.println("<h3> Exception raise by Servlet ...Error in getting image file path </h3> Foll: Error Received : "+e.toString());//COMMON-ICN-0181
					e.printStackTrace();
				}
			}
			
			// To get the Patient Demographic Information
			rs = null;
			stmt = null;
			demoSql="select patient_id, name_prefix, first_name, second_name, third_name, family_name, sex, to_char(date_of_birth, 'dd/MM/YYYY') date_of_birth, "+
					" round((trunc(sysdate) - trunc(to_date(to_char(date_of_birth, 'dd/MM/YYYY'),'DD/MM/YYYY')))/  365) age_in_years "+
					" from mp_patient where patient_id = ? ";
			stmt=con.prepareStatement(demoSql);
			stmt.setString(1,patientid);
	
			rs=stmt.executeQuery();
	
			if (rs!=null){
				if(rs.next())
				{
					patientNamePrefix = rs.getString("name_prefix")==null?"":rs.getString("name_prefix");
					patientFirstName = rs.getString("first_name")==null?"":rs.getString("first_name");
					patientSecondName = rs.getString("second_name")==null?"":rs.getString("second_name");
					patientThirdName = rs.getString("third_name")==null?"":rs.getString("third_name");
					patientFamilyName = rs.getString("family_name")==null?"":rs.getString("family_name");
					gender = rs.getString("sex");
					dateOfBirth = rs.getString("date_of_birth");
					ageInYears = rs.getString("age_in_years");	
					patientName = patientNamePrefix + " " + patientFirstName +" "+ patientSecondName + " " + patientThirdName+ " " + patientFamilyName;
				}
			}		
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
	
			// To get the Patient Blood Group Details
			rs = null;
			stmt = null;
	
			bloodSql = "SELECT C.SHORT_DESC blood_grp, b.short_desc    rh_factor,a.g6pd_marker g6pd, a.sicc_marker sicc FROM MP_PAT_OTH_DTLS A, "+     
					" MR_RHESUS_FACTOR B, MR_BLOOD_GRP_LANG_VW C WHERE PATIENT_ID = ? and a.rh_factor = b.RHESUS_FACTOR_CODE(+) and a.blood_grp = c.blood_grp(+) "+ 
					" AND C.LANGUAGE_ID = ?" ;
			stmt=con.prepareStatement(bloodSql);
			stmt.setString(1,patientid);
			stmt.setString(2,locale);
	
			rs=stmt.executeQuery();
	
			while(rs.next())
			{
				bloodGroup = rs.getString("blood_grp");
			}
	
			// To get the Patient Encounter Details
			rs = null;
			stmt = null;
			encounterSql = "select facility_id, encounter_id, attend_practitioner_id, to_char(visit_adm_date_time, 'DD MON YYYY') visit_date_time, practitioner_name, "+ 
							" assign_care_locn_type, assign_care_locn_code "+
							" from pr_encounter, am_practitioner where attend_practitioner_id = practitioner_id and patient_id = ? and encounter_id = ? ";
			stmt=con.prepareStatement(encounterSql);
			stmt.setString(1,patientid);
			stmt.setString(2,encounterid);
			rs=stmt.executeQuery();
	
			if (rs!=null){
				if(rs.next())
				{
					facilityId = rs.getString("facility_id")==null?"":rs.getString("facility_id");
					attendPractitionerId = rs.getString("attend_practitioner_id")==null?"":rs.getString("attend_practitioner_id");
					visitDateTime = rs.getString("visit_date_time")==null?"":rs.getString("visit_date_time");
					practitionerName = rs.getString("practitioner_name")==null?"":rs.getString("practitioner_name");	
					locnType = rs.getString("assign_care_locn_type")==null?"":rs.getString("assign_care_locn_type");
					locnCode = rs.getString("assign_care_locn_code")==null?"":rs.getString("assign_care_locn_code");
				}
			}		
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();		
			
			if ((locnType.equalsIgnoreCase("n")) || (locnType.equalsIgnoreCase("c"))){
				if (locnType.equalsIgnoreCase("n")) {
					locnSql = "select nursing_unit_code, long_desc, short_desc  from ip_nursing_unit where facility_id = ? and nursing_unit_code = ? ";
				}
				else if (locnType.equalsIgnoreCase("c")){
					locnSql = "select clinic_code, long_desc, short_desc from op_clinic where facility_id = ? and clinic_code = ? ";
				}
				stmt=con.prepareStatement(locnSql);
				stmt.setString(1,facilityId);
				stmt.setString(2,locnCode);
				rs=stmt.executeQuery();
		
				if (rs!=null){
					if(rs.next())
					{
						locnDesc = rs.getString("long_desc")==null?"":rs.getString("long_desc");
					}
				}		
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();		
			}
			
			// To get the Patient Payer Details
			rs = null;
			stmt = null;
			payerSql = "Select a.cust_code, b.long_name, b.short_name from bl_episode_fin_dtls a, ar_customer b "+ 
							" where patient_id = ? and encounter_id = ? "+
							" and a.cust_code = b.cust_code ";
			stmt=con.prepareStatement(payerSql);
			stmt.setString(1,patientid);
			stmt.setString(2,encounterid);
			rs=stmt.executeQuery();
	
			if (rs!=null){
				if(rs.next())
				{
					payerCode = rs.getString("cust_code")==null?"":rs.getString("cust_code");
					payerName = rs.getString("long_name")==null?"":rs.getString("long_name");
				}
			}		
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();	
			
			
			
			// To get the Encounter Summary title
			rs = null;
			stmt = null;
			encSummSql = "Select ES_SUMM_TITLE from CR_ES_SUMM_HDR where ES_SUMM_CODE = ? and ES_SUMM_STATUS = 'E' ";
			
			stmt=con.prepareStatement(encSummSql);
			stmt.setString(1,v_summ_code);		
			rs=stmt.executeQuery();
	
			if (rs!=null){
				if(rs.next())
				{
					v_summ_desc = rs.getString("ES_SUMM_TITLE")==null?"":rs.getString("ES_SUMM_TITLE");					
				}
			}		
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();			
			
			//Singature Doctor Name, Speciality			
			rs = null;
			stmt = null;
			authSplSql = "select facility_id, encounter_id, "+ 
							" attend_practitioner_id,  nvl(b.practitioner_name,'') attend_pract_name,  nvl(b.degree,'') attend_pract_degree, nvl(e.long_desc,'') attend_splty_name, "+
							" admit_practitioner_id, nvl(c.practitioner_name,'') admit_pract_name, nvl(c.degree,'') admit_pract_degree, nvl(f.long_desc,'') admit_splty_name, "+
							" disp_auth_practitioner_id,  nvl(d.practitioner_name,'') auth_pract_name, nvl(d.degree,'') auth_pract_degree, nvl(g.long_desc,'') auth_splty_name "+
						" from pr_encounter a, am_practitioner b, am_practitioner c, am_practitioner d, am_speciality e, am_speciality f, am_speciality g "+
						" where attend_practitioner_id = b.practitioner_id "+
								" and admit_practitioner_id = c.practitioner_id(+) "+
								" and disp_auth_practitioner_id = d.practitioner_id(+) "+
								" and b.primary_speciality_code = e.speciality_code(+) "+
								" and c.primary_speciality_code = f.speciality_code(+) "+
								" and d.primary_speciality_code = g.speciality_code(+) "+
								" and patient_id = ? and encounter_id = ? ";
			
			stmt=con.prepareStatement(authSplSql);
			stmt.setString(1,patientid);
			stmt.setString(2,encounterid);
			rs=stmt.executeQuery();
			
			if (rs!=null){
				if(rs.next())
				{
					attendPractName = rs.getString("attend_pract_name")==null?"":rs.getString("attend_pract_name");					
					attendPractDegree = rs.getString("attend_pract_degree")==null?"":rs.getString("attend_pract_degree");
					attendPractSplty = rs.getString("attend_splty_name")==null?"":rs.getString("attend_splty_name");
					
					admitPractName = rs.getString("admit_pract_name")==null?"":rs.getString("admit_pract_name");					
					admitPractDegree = rs.getString("admit_pract_degree")==null?"":rs.getString("admit_pract_degree");
					admitPractSplty = rs.getString("admit_splty_name")==null?"":rs.getString("admit_splty_name");
					
					authPractName = rs.getString("auth_pract_name")==null?"":rs.getString("auth_pract_name");					
					authPractDegree = rs.getString("auth_pract_degree")==null?"":rs.getString("auth_pract_degree");
					authPractSplty = rs.getString("auth_splty_name")==null?"":rs.getString("auth_splty_name");
				}
			}	
			
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();	
	
			// To get the Patient Speciality
			rs = null;
			stmt = null;
			authSplSql = "select long_desc speciality_name  from pr_encounter a, am_speciality b "+ 
					" where a.specialty_code = b.speciality_code and patient_id = ? and encounter_id = ? ";
			stmt=con.prepareStatement(authSplSql);
			stmt.setString(1,patientid);		
			stmt.setString(2,encounterid);
			rs=stmt.executeQuery();
	
			if (rs!=null){
				if(rs.next())
				{				
					specialtyName = rs.getString("speciality_name")==null?"":rs.getString("speciality_name");				
				}
			}		
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();		
			
			// Order related information
			rs = null;
			stmt = null;
			orderSql = " select a.patient_id, a.encounter_id, a.order_id, to_char(c.ord_date_time, 'DD/MM/YYYY') ord_date_time, "+ 
						" specimen_no, to_char(spec_colltd_date_time, 'DD/MM/YYYY') spec_colltd_date_time, to_char(spec_regd_date_time, 'DD/MM/YYYY') spec_regd_date_time, "+
						" a.specimen_type_code, b.specimen_desc, "+
						" verified_by_id, to_char(verified_date, 'DD/MM/YYYY') verified_date, to_char(result_printed_date, 'DD/MM/YYYY') result_printed_date "+
						" from rl_request_header a, rl_specimen_type_code b, or_order c "+
						" where a.patient_id = ? and a.encounter_id = ?   "+
						" and a.added_date in (select max(added_date) from rl_request_header d "+ 
	                                			" where d.patient_id = a.patient_id and d.encounter_id = a.encounter_id) "+
						" and a.specimen_type_code = b.specimen_type_code "+
	                    " and a.order_id = c.order_id ";
			
			stmt=con.prepareStatement(orderSql);
			stmt.setString(1,patientid);		
			stmt.setString(2,encounterid);
			rs=stmt.executeQuery();
			
			if (rs!=null){
				if(rs.next())
				{	
					orderNo 		= rs.getString("order_id")==null?"":rs.getString("order_id");
					orderDate 		= rs.getString("ord_date_time")==null?"":rs.getString("ord_date_time");
					specimenNo 		= rs.getString("specimen_no")==null?"":rs.getString("specimen_no");	
					specimenType 	= rs.getString("specimen_desc")==null?"":rs.getString("specimen_desc");	
						
					collectedDate 	= rs.getString("spec_colltd_date_time")==null?"":rs.getString("spec_colltd_date_time");	
					registeredDate 	= rs.getString("spec_regd_date_time")==null?"":rs.getString("spec_regd_date_time");	
					authorisedBy 	= rs.getString("verified_by_id")==null?"":rs.getString("verified_by_id");	
					authorisedDate 	= rs.getString("verified_date")==null?"":rs.getString("verified_date");	
					printedDate 	= rs.getString("result_printed_date")==null?"":rs.getString("result_printed_date");						
				}
			}		
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();		
		}
	
	
            _bw.write(_wl_block7Bytes, _wl_block7);

			if (headfootFlag == 0){
				htmlHeaderString =  htmlHeaderString.replace("XYZ", "#"); 
				htmlHeaderString =  htmlHeaderString.replace("^", "'"); 
				htmlHeaderString =  htmlHeaderString.replace("*", "&"); 
				htmlHeaderString =  htmlHeaderString.replace("facilityName", facilityName); 
				htmlHeaderString =  htmlHeaderString.replace("facilityImageName", facilityImageName);
				htmlHeaderString =  htmlHeaderString.replace("address", address);
				htmlHeaderString =  htmlHeaderString.replace("telephone1", telephone1);
				htmlHeaderString =  htmlHeaderString.replace("telephone2", telephone2);
				htmlHeaderString =  htmlHeaderString.replace("telephone3", telephone3);
				htmlHeaderString =  htmlHeaderString.replace("telephone4", telephone4);
				htmlHeaderString =  htmlHeaderString.replace("fax", fax);
				htmlHeaderString =  htmlHeaderString.replace("emailId", emailId);
				htmlHeaderString =  htmlHeaderString.replace("website", website);
				
				htmlHeaderString =  htmlHeaderString.replace("patientName", patientName);
				htmlHeaderString =  htmlHeaderString.replace("gender", gender);
				htmlHeaderString =  htmlHeaderString.replace("bloodGroup", bloodGroup);
				htmlHeaderString =  htmlHeaderString.replace("dateOfBirth", dateOfBirth);
				htmlHeaderString =  htmlHeaderString.replace("ageInYears", ageInYears);
				htmlHeaderString =  htmlHeaderString.replace("practitionerName", practitionerName);
				htmlHeaderString =  htmlHeaderString.replace("payerName", payerName);
				
				htmlHeaderString =  htmlHeaderString.replace("patientid", patientid);
				htmlHeaderString =  htmlHeaderString.replace("encounterid", encounterid);
				htmlHeaderString =  htmlHeaderString.replace("visitDateTime", visitDateTime);
				htmlHeaderString =  htmlHeaderString.replace("specialtyName", specialtyName);
				htmlHeaderString =  htmlHeaderString.replace("locationName", locnDesc);
				
				htmlHeaderString =  htmlHeaderString.replace("specimenNo", specimenNo);
				htmlHeaderString =  htmlHeaderString.replace("specimenType", specimenType);
				htmlHeaderString =  htmlHeaderString.replace("orderNo", orderNo);
				htmlHeaderString =  htmlHeaderString.replace("orderDate", orderDate);
				htmlHeaderString =  htmlHeaderString.replace("collectedDate", collectedDate);
				htmlHeaderString =  htmlHeaderString.replace("registeredDate", registeredDate);			
				htmlHeaderString =  htmlHeaderString.replace("authorisedBy", authorisedBy);
				htmlHeaderString =  htmlHeaderString.replace("authorisedDate", authorisedDate);
				htmlHeaderString =  htmlHeaderString.replace("printedDate", printedDate);
				
				htmlHeaderString =  htmlHeaderString.replace("v_summ_desc", v_summ_desc);				
				
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("XYZ", "#"); 
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("^", "'"); 
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("*", "&"); 
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("facilityName", facilityName); 
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("facilityImageName", facilityImageName);
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("address", address);
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("telephone1", telephone1);
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("telephone2", telephone2);
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("telephone3", telephone3);
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("telephone4", telephone4);
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("fax", fax);
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("emailId", emailId);
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("website", website);
				
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("patientName", patientName);
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("gender", gender);
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("bloodGroup", bloodGroup);
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("dateOfBirth", dateOfBirth);
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("ageInYears", ageInYears);
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("practitionerName", practitionerName);
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("payerName", payerName);
				
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("patientid", patientid);
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("encounterid", encounterid);
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("visitDateTime", visitDateTime);
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("specialtyName", specialtyName);
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("locationName", locnDesc);
				
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("specimenNo", specimenNo);
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("specimenType", specimenType);
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("orderNo", orderNo);
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("orderDate", orderDate);
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("collectedDate", collectedDate);
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("registeredDate", registeredDate);			
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("authorisedBy", authorisedBy);
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("authorisedDate", authorisedDate);
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("printedDate", printedDate);
				
				htmlHeaderPrevString =  htmlHeaderPrevString.replace("v_summ_desc", v_summ_desc);
			}
			else
			{
				htmlFooterString =  htmlFooterString.replace("XYZ", "#"); 
				htmlFooterString =  htmlFooterString.replace("^", "'"); 
				htmlFooterString =  htmlFooterString.replace("*", "&"); 
				htmlFooterString =  htmlFooterString.replace("facilityName", facilityName); 
				htmlFooterString =  htmlFooterString.replace("facilityImageName", facilityImageName);
				htmlFooterString =  htmlFooterString.replace("address", address);
				htmlFooterString =  htmlFooterString.replace("telephone1", telephone1);
				htmlFooterString =  htmlFooterString.replace("telephone2", telephone2);
				htmlFooterString =  htmlFooterString.replace("telephone3", telephone3);
				htmlFooterString =  htmlFooterString.replace("telephone4", telephone4);
				htmlFooterString =  htmlFooterString.replace("fax", fax);
				htmlFooterString =  htmlFooterString.replace("emailId", emailId);
				htmlFooterString =  htmlFooterString.replace("website", website);
				
				htmlFooterString =  htmlFooterString.replace("patientName", patientName);
				htmlFooterString =  htmlFooterString.replace("gender", gender);
				htmlFooterString =  htmlFooterString.replace("bloodGroup", bloodGroup);
				htmlFooterString =  htmlFooterString.replace("dateOfBirth", dateOfBirth);
				htmlFooterString =  htmlFooterString.replace("ageInYears", ageInYears);
				htmlFooterString =  htmlFooterString.replace("practitionerName", practitionerName);
				htmlFooterString =  htmlFooterString.replace("payerName", payerName);
				
				htmlFooterString =  htmlFooterString.replace("patientid", patientid);
				htmlFooterString =  htmlFooterString.replace("encounterid", encounterid);
				htmlFooterString =  htmlFooterString.replace("visitDateTime", visitDateTime);
				htmlFooterString =  htmlFooterString.replace("specialtyName", specialtyName);
				htmlFooterString =  htmlFooterString.replace("locationName", locnDesc);
				
				htmlFooterString =  htmlFooterString.replace("specimenNo", specimenNo);
				htmlFooterString =  htmlFooterString.replace("specimenType", specimenType);
				htmlFooterString =  htmlFooterString.replace("orderNo", orderNo);
				htmlFooterString =  htmlFooterString.replace("orderDate", orderDate);
				htmlFooterString =  htmlFooterString.replace("collectedDate", collectedDate);
				htmlFooterString =  htmlFooterString.replace("registeredDate", registeredDate);			
				htmlFooterString =  htmlFooterString.replace("authorisedBy", authorisedBy);
				htmlFooterString =  htmlFooterString.replace("authorisedDate", authorisedDate);
				htmlFooterString =  htmlFooterString.replace("printedDate", printedDate);
				
				htmlFooterString =  htmlFooterString.replace("attendPractName", attendPractName);
				htmlFooterString =  htmlFooterString.replace("attendPractDegree", attendPractDegree);
				htmlFooterString =  htmlFooterString.replace("attendPractSplty", attendPractSplty);
				
				htmlFooterString =  htmlFooterString.replace("admitPractName", admitPractName);
				htmlFooterString =  htmlFooterString.replace("admitPractDegree", admitPractDegree);
				htmlFooterString =  htmlFooterString.replace("admitPractSplty", admitPractSplty);	
				
				htmlFooterString =  htmlFooterString.replace("authPractName", authPractName);
				htmlFooterString =  htmlFooterString.replace("authPractDegree", authPractDegree);
				htmlFooterString =  htmlFooterString.replace("authPractSplty", authPractSplty);
				
				htmlFooterString =  htmlFooterString.replace("v_summ_desc", v_summ_desc);	
				
				
				htmlFooterPrevString =  htmlFooterPrevString.replace("XYZ", "#"); 
				htmlFooterPrevString =  htmlFooterPrevString.replace("^", "'"); 
				htmlFooterPrevString =  htmlFooterPrevString.replace("*", "&"); 
				htmlFooterPrevString =  htmlFooterPrevString.replace("facilityName", facilityName); 
				htmlFooterPrevString =  htmlFooterPrevString.replace("facilityImageName", facilityImageName);
				htmlFooterPrevString =  htmlFooterPrevString.replace("address", address);
				htmlFooterPrevString =  htmlFooterPrevString.replace("telephone1", telephone1);
				htmlFooterPrevString =  htmlFooterPrevString.replace("telephone2", telephone2);
				htmlFooterPrevString =  htmlFooterPrevString.replace("telephone3", telephone3);
				htmlFooterPrevString =  htmlFooterPrevString.replace("telephone4", telephone4);
				htmlFooterPrevString =  htmlFooterPrevString.replace("fax", fax);
				htmlFooterPrevString =  htmlFooterPrevString.replace("emailId", emailId);
				htmlFooterPrevString =  htmlFooterPrevString.replace("website", website);
				
				htmlFooterPrevString =  htmlFooterPrevString.replace("patientName", patientName);
				htmlFooterPrevString =  htmlFooterPrevString.replace("gender", gender);
				htmlFooterPrevString =  htmlFooterPrevString.replace("bloodGroup", bloodGroup);
				htmlFooterPrevString =  htmlFooterPrevString.replace("dateOfBirth", dateOfBirth);
				htmlFooterPrevString =  htmlFooterPrevString.replace("ageInYears", ageInYears);
				htmlFooterPrevString =  htmlFooterPrevString.replace("practitionerName", practitionerName);
				htmlFooterPrevString =  htmlFooterPrevString.replace("payerName", payerName);
				
				htmlFooterPrevString =  htmlFooterPrevString.replace("patientid", patientid);
				htmlFooterPrevString =  htmlFooterPrevString.replace("encounterid", encounterid);
				htmlFooterPrevString =  htmlFooterPrevString.replace("visitDateTime", visitDateTime);
				htmlFooterPrevString =  htmlFooterPrevString.replace("specialtyName", specialtyName);
				htmlFooterPrevString =  htmlFooterPrevString.replace("locationName", locnDesc);
				
				htmlFooterPrevString =  htmlFooterPrevString.replace("specimenNo", specimenNo);
				htmlFooterPrevString =  htmlFooterPrevString.replace("specimenType", specimenType);
				htmlFooterPrevString =  htmlFooterPrevString.replace("orderNo", orderNo);
				htmlFooterPrevString =  htmlFooterPrevString.replace("orderDate", orderDate);
				htmlFooterPrevString =  htmlFooterPrevString.replace("collectedDate", collectedDate);
				htmlFooterPrevString =  htmlFooterPrevString.replace("registeredDate", registeredDate);			
				htmlFooterPrevString =  htmlFooterPrevString.replace("authorisedBy", authorisedBy);
				htmlFooterPrevString =  htmlFooterPrevString.replace("authorisedDate", authorisedDate);
				htmlFooterPrevString =  htmlFooterPrevString.replace("printedDate", printedDate);
				
				htmlFooterPrevString =  htmlFooterPrevString.replace("attendPractName", attendPractName);
				htmlFooterPrevString =  htmlFooterPrevString.replace("attendPractDegree", attendPractDegree);
				htmlFooterPrevString =  htmlFooterPrevString.replace("attendPractSplty", attendPractSplty);
				
				htmlFooterPrevString =  htmlFooterPrevString.replace("admitPractName", admitPractName);
				htmlFooterPrevString =  htmlFooterPrevString.replace("admitPractDegree", admitPractDegree);
				htmlFooterPrevString =  htmlFooterPrevString.replace("admitPractSplty", admitPractSplty);
				
				htmlFooterPrevString =  htmlFooterPrevString.replace("authPractName", authPractName);
				htmlFooterPrevString =  htmlFooterPrevString.replace("authPractDegree", authPractDegree);
				htmlFooterPrevString =  htmlFooterPrevString.replace("authPractSplty", authPractSplty);
				
				htmlFooterPrevString =  htmlFooterPrevString.replace("v_summ_desc", v_summ_desc);
			}
		
            _bw.write(_wl_block8Bytes, _wl_block8);

				if (headfootFlag == 0){ 
				
            _bw.write(_wl_block9Bytes, _wl_block9);

				}
				else
				{
				
            _bw.write(_wl_block10Bytes, _wl_block10);

				}
				
            _bw.write(_wl_block11Bytes, _wl_block11);

		if (headfootFlag == 0){ 
		
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( htmlHeaderString));
            _bw.write(_wl_block13Bytes, _wl_block13);

		}
		else
		{
		
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( htmlFooterString));
            _bw.write(_wl_block14Bytes, _wl_block14);

		}
		if (changeFlag.equalsIgnoreCase("true")){
		
            _bw.write(_wl_block15Bytes, _wl_block15);

					if (headfootFlag == 0){ 
					
            _bw.write(_wl_block16Bytes, _wl_block16);

					}
					else
					{
					
            _bw.write(_wl_block17Bytes, _wl_block17);

					}
					
            _bw.write(_wl_block18Bytes, _wl_block18);

			if (headfootFlag == 0){ 
			
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf( htmlHeaderPrevString));
            _bw.write(_wl_block20Bytes, _wl_block20);

			}
			else
			{
			
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf( htmlFooterPrevString));
            _bw.write(_wl_block22Bytes, _wl_block22);

			}
		}
		
            _bw.write(_wl_block23Bytes, _wl_block23);


		}
		catch(Exception e){
			//out.println("Exception"+e.toString());//COMMON-ICN-0181	
			e.printStackTrace();	
		}
		finally
		{
			if(con!=null)ConnectionManager.returnConnection(con,request);
		}

	
            _bw.write(_wl_block24Bytes, _wl_block24);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
