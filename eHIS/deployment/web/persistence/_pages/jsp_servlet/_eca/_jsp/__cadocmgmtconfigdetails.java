package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import eCA.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __cadocmgmtconfigdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CADocMgmtConfigDetails.jsp", 1730991444752L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\'../js/CADocMgmtConfig.js\' language=\'javascript\' ></script>\n<Script src=\'../../eCommon/js/CommonLookup.js\' language=\"JavaScript\" ></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<body onscroll=\'scrollTitleTop()\' class=\'CONTENT\' OnMouseDown=\"CodeArrest()\"  onKeyDown=\"lockKey()\">\n\t<form name=\"CADocMgmtConfigForm\" id=\"CADocMgmtConfigForm\" action=\"../../servlet/eCA.CADocMgmtConfigServlet\" method=\"post\" target=\"messageFrame\">\n\t\t<table class=\'grid\' align=\"center\" border=\"1\" cellpadding=\"1\" cellspacing=\"1\"\tstyle=\"width: 1000px;\">\n\t\t\t<tbody>\n\t\t\t\t<!--\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'columnheadercenter\' colspan=\"3\">Document Option&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t-->\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\"50%\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="  Option&nbsp;</td>\n\t\t\t\t\t\t<td class=\'COLUMNHEADER\' colspan=\"2\" width=\"50%\"> Storage Option Type &nbsp;</td>\n\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\t\t\t\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\'gridData\' style=\"border-bottom-width: 0px; \" width=\"50%\">&nbsp;</td>\n\t\t\t\t\t\t\t<td class=\'Fields\'   width=\"25%\" >\n\t\t\t\t\t\t\t\t<input type=\"radio\" name=\"docFolderOption";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" id=\"docFolderOption";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" value=\"D\" ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="checked";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" onclick=\"setDocPathEnabled(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\')\">Database(Existing)\n\t\t\t\t\t\t\t</td>\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td class=\'Fields\' width=\"25%\">\n\t\t\t\t\t\t\t\t<input type=\"radio\"\tname=\"docFolderOption";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" value=\"F\" ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\')\">Shared Path\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t \n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\'gridData\' style=\"border-top-width: 0px; border-bottom: 3px black;\" width=\"50%\" >\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' id=\"sharedPathMandatoryImg";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" name=\"sharedPathMandatoryImg";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="style=\'display: inline;\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="style=\'display: none;\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =">\n\t\t\t\t\t\t\t\t&nbsp;\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\'Fields\'  colspan=\"2\"  width=\"50%\" >\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"docSharedPath";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" id=\"docSharedPath";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" style=\"border-bottom-width: 0px;border-top-width: 0px;border-left-width: 0px;border-right-width: 0px;\" size=90 maxlength=128 onkeypress=\"return CheckForSpecCharsWithSpaceBlur(event)\" onBlur=\"return validateSharedPath(this);\";";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" disabled ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" >\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\t\n\t\t\t\t\t\t<input type=\"hidden\" name=\"docSubFuncitonId";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" id=\"docSubFuncitonId";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"/>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"docStoredType";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" id=\"docStoredType";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"/>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"docFuncitonName";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" id=\"docFuncitonName";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"/>\t\t\t\t\t\t\n\t\t\t\t\t\t<input type=\"hidden\" name=\"docSharedPathValue";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" id=\"docSharedPathValue";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"/>\t\t\t\t\t\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\t\n\t\t\t</tbody>\n\t\t</table>\t\t\t\t\t\t\n\t\t<br>\n\n\t\t\n\t\t<input type=\"hidden\" name=\"facilityId\" id=\"facilityId\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"/>\n\t\t<input type=\"hidden\" name=\"facilityId_df\" id=\"facilityId_df\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"/>\n\t\t<input type=\"hidden\" name=\"totaldocuments\" id=\"totaldocuments\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"/>\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\t\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);

/*
-------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
19/03/2020 	IN070345  		Ramesh Goli											MO-CRF-20147.1
-------------------------------------------------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block6Bytes, _wl_block6);

    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");	
	String mode="";
	
	
	String sFacilityId = "",sFacilityId_df = "";
	
	
	mode = (request.getParameter("mode")==null)?"":request.getParameter("mode");
	sFacilityId = (request.getParameter("facilityId")==null)?"":request.getParameter("facilityId");	
	sFacilityId_df = (request.getParameter("facilityId_df")==null)?"":request.getParameter("facilityId_df");	
	
	
	
	try{

		CADocumentConfigBean docConfigBean = new CADocumentConfigBean(); 
		HashMap<String,Object> docConfigDetailsMap= new HashMap<String,Object>();		
		ArrayList<CADocumentConfig> documentFuncitonList = new ArrayList<CADocumentConfig>() ;
		HashMap<String,ArrayList<CADocumentConfig>> documentMapDetails = new HashMap<String,ArrayList<CADocumentConfig>>();
		CADocumentConfig docConfig = null;
		CADocumentConfig docConfigDetails = null;
		
		docConfigDetailsMap = docConfigBean.getDocumentConfigDetails(sFacilityId);
		
		documentFuncitonList = (ArrayList<CADocumentConfig>)docConfigDetailsMap.get("DOCFUNCTIONLIST");
		documentMapDetails = (HashMap<String,ArrayList<CADocumentConfig>>)docConfigDetailsMap.get("DOCFUNCTIONLISTDETAILS");		
		int totalDocuments = 0;

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

				for(int i=0; i<documentFuncitonList.size();i++){
					docConfig = documentFuncitonList.get(i);
				
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(docConfig.getDocFunctionName() ));
            _bw.write(_wl_block10Bytes, _wl_block10);

					ArrayList<CADocumentConfig> docFuncitonDetailsList = new ArrayList<CADocumentConfig>() ;
					docFuncitonDetailsList = documentMapDetails.get(docConfig.getDocFuncitonId());
					
					for(int j=0; j<docFuncitonDetailsList.size();j++){
						docConfigDetails = docFuncitonDetailsList.get(j);
						String docFolderOption =(String)docConfigDetails.getDocStoredType();
						System.out.println("--------------------->"+docFolderOption+"<-------------");
				
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(j ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(j ));
            _bw.write(_wl_block13Bytes, _wl_block13);
if("D".equals(docFolderOption)){
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(j));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(j ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(j ));
            _bw.write(_wl_block17Bytes, _wl_block17);
if("F".equals(docFolderOption)){
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(j));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(docConfigDetails.getDocSubFunctionName() ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(j ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(j ));
            _bw.write(_wl_block21Bytes, _wl_block21);
if("F".equals(docFolderOption)){
            _bw.write(_wl_block22Bytes, _wl_block22);
}else{ 
            _bw.write(_wl_block23Bytes, _wl_block23);
}
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(j ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(j ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(j ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(docConfigDetails.getDocStoredPath() ));
            _bw.write(_wl_block27Bytes, _wl_block27);
if("D".equals(docFolderOption)){
            _bw.write(_wl_block28Bytes, _wl_block28);
}
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(j ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(j ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(docConfigDetails.getDocSubFuncitonId() ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(j ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(j ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(docFolderOption ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(j ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(j ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(docConfigDetails.getDocSubFunctionName() ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(j ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(j ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(docConfigDetails.getDocStoredPath() ));
            _bw.write(_wl_block37Bytes, _wl_block37);
 
						if((j+1)==docFuncitonDetailsList.size()){
							totalDocuments=(j+1);
						}
					}
				}
				
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(sFacilityId));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(sFacilityId_df));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(totalDocuments ));
            _bw.write(_wl_block41Bytes, _wl_block41);

	}catch(Exception e1){
	 //out.println("(CADocMgmtConfigDetails.jsp:Exception) "+e1);//common-icn-0181
	 e1.printStackTrace(System.err);
	}
	finally
	{
		
	}
	
            _bw.write(_wl_block42Bytes, _wl_block42);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
