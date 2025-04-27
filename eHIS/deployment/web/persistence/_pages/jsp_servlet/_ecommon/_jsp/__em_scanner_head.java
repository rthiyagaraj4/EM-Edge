package jsp_servlet._ecommon._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eMP.*;
import java.util.*;
import com.ehis.util.*;

public final class __em_scanner_head extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/EM_Scanner_Head.jsp", 1709116472947L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="  \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<title>Scan Documents</title>\n</head>\n<body>\n\t<table align=\"center\" border=\"4\" cellpadding=\"1\" cellspacing=\"1\" style=\"width: 700px;\">\n\t\t<tr>\n\t\t\t<td>\n\t\t\t\t<!--<applet code=\"ScannerApplet.class\" codebase=\"../Scanner/\" archive=\"EMScanner.jar, JTwain.jar\" width=\"400\" height=\"300\">-->\n\t\t\t\t<!--<applet code=\"ScanImageApplet.class\" codebase=\"../Scanner/\" archive=\"ScanImageDemo.jar, JTwain.jar\" width=\"800\" height=\"600\">-->\n\t\t\t\t<!--<applet code=\"ScanImageApplet.class\" codebase=\"../Scanner/\" archive=\"ScanPatientDocument.jar, JTwain.jar, AspriseJavaPDF.jar\" width=\"900\" height=\"400\">-->\n\t\t\t\t<applet code=\"ScanImageApplet.class\" codebase=\"../Scanner/\" archive=\"ScanPatientDocument.jar, asprise_scan.jar\" width=\"900\" height=\"400\">\t\t\n\t\t\t\t<PARAM name=\"servletPath\" value=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\">\n\t\t\t\t<PARAM name=\"facility_id\" value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\n\t\t\t\t<PARAM name=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n\t\t\t\t<PARAM name=\"patient_id\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t\t\t\t<PARAM name=\"patient_name\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\t\t\t\t\n\t\t\t\t<PARAM name=\"document_id\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t\t\t\t<PARAM name=\"doc_main_type\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t\t\t\t<PARAM name=\"doc_type\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\n\t\t\t\t<PARAM name=\"scan_ui_enabled\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\t\t\t\t\n\t\t\t\t<PARAM name=\"doc_save_as\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t\t\t<PARAM name=\"doc_folder_option\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t\t\t<PARAM name=\"doc_shared_path\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t\t\t Sorry, Your browser does not support Java applet!\n\t\t\t\t</applet>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\t\n</body>\n</html>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

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

	System.out.println(" - - -  Inside EM_Scanner_Head.jsp  - - - ");

	Connection con	= null;
	ResultSet rs1 = null;
	PreparedStatement pstmt = null;

	String appPath = request.getRequestURL().toString();
	String contextPath = request.getContextPath();

	appPath = appPath.substring(0,appPath.indexOf(contextPath)+contextPath.length());

	String facilityId = "", patientid = "", encounterid = "", patientname = "";

	String document_id = "", doc_main_type = "", doc_type = "";

	facilityId	= (String)session.getValue("facility_id");
	patientid = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	encounterid = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");

	document_id	= request.getParameter("document_id")==null?"":request.getParameter("document_id");;
	doc_main_type = request.getParameter("doc_main_type")==null?"":request.getParameter("doc_main_type");
	doc_type = request.getParameter("doc_type")==null?"":request.getParameter("doc_type");

	String sql = "";

	String docMainTypeCode = "";

	String sFacilityId = "";
	int iDocScanEnabled = 0;	
	int iDocScanUIEnabled = 0; 
	int iDocSaveAs = 0; 
	int iDocFolderOption = 0;
	String sDocType = "";
	String sDocSharedPath = "";
	String sWebServiceUrl = ""; 

	
	try {
		con = ConnectionManager.getConnection(request);

		sql = "select patient_name from mp_patient where patient_id = ? ";

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,patientid);
		rs1 = pstmt.executeQuery();

		if(rs1 != null)
		{
			while(rs1.next())
			{
				patientname = rs1.getString(1);
			}	 
		}

		if(pstmt != null) pstmt.close();
		if(rs1 != null) rs1.close();

		}
	catch(Exception ex)
	{ 
		System.out.println("Exception raised while getting patient name "+ex.getMessage());
	}
	try {
		DocumentConfigOption docConfigOption = new DocumentConfigOption(); 		
	
		List<DocumentConfigBean> oDocConfigList = null;
		DocumentConfigBean oDocumentConfigBean = null;	
			
		oDocConfigList = new ArrayList<DocumentConfigBean>();

		if (doc_main_type.length() > 0)
		{
			if (doc_main_type.indexOf('~') > 0)
			{
				docMainTypeCode = doc_main_type.substring(0, doc_main_type.indexOf('~'));
			}
			else
			{
				docMainTypeCode = doc_main_type;
			}
			
		}

		oDocConfigList = docConfigOption.getDocumentConfigDetails(facilityId, docMainTypeCode);

		int nDocConfigListsize = oDocConfigList.size();
		if (nDocConfigListsize>0)
		{						
			oDocumentConfigBean = oDocConfigList.get(nDocConfigListsize-1);		
			
			sFacilityId 	= oDocumentConfigBean.getsFacilityId();
			iDocScanEnabled = oDocumentConfigBean.getiDocScanEnabled();
			iDocScanUIEnabled = oDocumentConfigBean.getiDocScanUIEnabled();
			iDocSaveAs = oDocumentConfigBean.getiDocSaveAs();  
			iDocFolderOption = oDocumentConfigBean.getiDocFolderOption();   
			sDocType = oDocumentConfigBean.getsDocType();   
			sDocSharedPath = oDocumentConfigBean.getsDocSharedPath();
			
		}	
		
	}
	catch(Exception ex)
	{ 
		System.out.println("Exception raised while getting configuration information "+ex.getMessage());
	}
	finally{
		if (con!=null) ConnectionManager.returnConnection(con,request);
	}

	System.out.println(" :::  facilityId: "+facilityId+" :::  patient_id: "+patientid+" :::  patient_name: "+patientname+" :::  encounterid: "+encounterid+" ::: document_id: "+document_id+" ::: doc_main_type: "+doc_main_type+" ::: doc_type: "+doc_type);

	System.out.println(" :::  iDocScanUIEnabled: "+iDocScanUIEnabled+" :::  iDocSaveAs: "+iDocSaveAs+" :::  iDocFolderOption: "+iDocFolderOption+" :::  sDocSharedPath: "+sDocSharedPath);


	//session.getServletContext().getRealPath("/");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(appPath));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientname));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(document_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(doc_main_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(doc_type));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(iDocScanUIEnabled));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(iDocSaveAs));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(iDocFolderOption));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(sDocSharedPath));
            _bw.write(_wl_block18Bytes, _wl_block18);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
