package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eBL.ModifyFinancialDetails.request.BLModifyFinancialDetailsRequest;
import eBL.ModifyFinancialDetails.response.BLModifyFinancialDetailsResponse;
import eBL.ModifyFinancialDetails.dao.BLModifyFinancialDetailsDao;
import eBL.ModifyFinancialDetails.dao.BLModifyFinancialDetailsDaoImpl;
import org.jaxen.util.FollowingAxisIterator;
import eCommon.XSSRequestWrapper;

public final class __packageencassociation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/PackageEncAssociation.jsp", 1719514580000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n  ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \r\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\r\n<html>\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/IeStyle_new.css\' type=\'text/css\' media=\"all\" onload=\"this.media=\'all\'\" />\r\n<script language=\'javascript\' src=\'../../eCommon/js/jquery.js\'></script>\r\n<script language=\'javascript\' src=\'../../eBL/js/BLModifyFinancialDetails.js\'></script>\r\n<style type=\"text/css\">\r\n\t.pkgContainer{\r\n\t    \tbackground-color:#F7F7F7;\r\n\t\t\twidth: auto;\r\n\t\t\theight: inherit;\r\n\t    }\r\n\t    .headercontainer {\r\n\t\t\tbackground-color: #0F4C8F;\r\n\t\t\theight: inherit;\r\n\t\t\twidth: 98%;\r\n\t\t\theight: inherit;\r\n\t\t\tborder-radius: 1%;\r\n\t\t\tdisplay: inline-block;\r\n\t\t\tpadding: 1%;\r\n\t\t\tmargin: 1%;\r\n\t\t}\r\n\t\t.pkgsubcontainer{\r\n\t\t\tbackground-color: white;\r\n\t\t\twidth: 98%;\r\n\t\t\theight: inherit;\r\n\t\t\tborder-radius: 1%;\r\n\t\t\tdisplay: inline-block;\r\n\t\t\tpadding: 1%;\r\n\t\t\t\r\n\t\t}\r\n\t\t.tablContainer{\r\n\t\t\toverflow: auto;\r\n\t\t\twidth: 98%;\r\n\t\t\theight: 25%;\r\n\t\t\tdisplay: block;\r\n\t\t\tborder-radius: 1%;\r\n\t\t\tmargin: 1%;\r\n\t\t}\r\n\t\t.tabl {\r\n   \t\t\tdisplay: table;\r\n   \t\t\twidth: 98%;\r\n\t\t}\r\n\t\t.table-hdr{\r\n\t\t\tdisplay: table-header-group;\r\n\t\t\tposition: sticky; \r\n\t\t\ttop: 0; \r\n\t\t\tbackground-color: #ccc;\r\n\t\t\tfont-weight: bold;\r\n\t\t}\r\n\t\t.table-bdy-row {\r\n\t\t  display: table-row-group;\r\n\t\t}\r\n\t\t.row{\r\n\t\t\t display: table-row;\r\n\t\t\t width:98%\r\n\t\t}\r\n\t\t.cellpk {\r\n\t\t   display: table-cell;\r\n\t\t   border: solid; \r\n\t\t   border-color: white; \r\n           border-width: thin;   \r\n\t\t}\r\n\t\t\r\n\t\t.rowx,\r\n\t\t.cellpk {\r\n\t\t  padding: 0.5%;\r\n\t\t}\r\n\t\t/* Style input field in grid */\r\n\t\t/* .gridInputs{\r\n\t\t\theight: 40px;\r\n\t\t\twidth: 50%;\r\n\t\t\tborder: 1px solid #DADCE0;\r\n\t\t\tborder-radius: 2px;\r\n\t\t\tfont-size: 15px;\r\n\t\t\tpadding: 10px 5px; \r\n\t\t\toutline: none;\r\n\t\t\tbackground: none;\r\n\t\t\tz-index: 1;\r\n\t\t}    */\r\n\t\t.pkggridcontainer {\r\n\t\t\tbackground-color: white;\r\n\t\t\twidth: 98%;\r\n\t\t\theight: fit-content;\r\n\t\t\tposition: relative;\r\n\t\t\tdisplay: inline-block;\r\n\t\t\tborder: 1% solid #d3d3d3;\r\n\t\t\tborder-radius: 1%;\r\n\t\t\tmargin: 1%;\r\n\t\t\tpadding: 1%;\r\n\t\t}\r\n\t\t.srchImg{\r\n\t\t\tposition: absolute;\r\n\t\t\ttop: 64%;\r\n\t\t\tleft: 25%;\r\n\t\t\twidth: 4%;\r\n\t\t\tdisplay: inline-block ;\r\n\t\t}\r\n    \r\n    </style>\r\n<title>Package Encounter Association</title>\r\n</head>\r\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\r\n<body>\r\n<div class=\'pkgContainer\'>\r\n\t<div id=\"headerDiv\" class=\"headercontainer\" style=\"background-color: #00A0DD;\" >\r\n\t\t<div class=\"lookup-title\" style=\"color: white;\">Package Encounter Association</div>\r\n\t</div>\r\n\t<div class=\"pkgsubcontainer\" id=\"pkgdtls\">\r\n\t\t<div  class=\"pkggridcontainer\" >\r\n\t\t\t<div class=\"tabl\">\r\n\t\t\t\t<div class=\"table-hdr\">\r\n\t\t\t\t\t<div class=\"cell\">Seq&nbsp;No</div>\r\n\t\t\t\t\t<div class=\"cell\">Package&nbsp;Code</div>\r\n\t\t\t\t\t<div class=\"cell\">Package&nbsp;Description</div>\r\n\t\t\t\t\t<div class=\"cell\">Associate&nbsp;Y/N</div>\r\n\t\t\t\t</div>\r\n\t\t\t\t<div class=\"table-bdy-row\" id=\"tableDtls\" contenteditable=\"false\">\r\n\t\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\r\n\t\t\t\t\t\t\t <div class=\"row\" id=\"row_";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"> \r\n\t\t\t\t\t\t\t\t\t<div class=\"cell\">\r\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"gridInputs\"  id=\"seqNo_";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\" name=\"seqNo_";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" disabled readonly/>\r\n\t\t\t\t\t\t\t\t\t</div> \r\n\t\t\t\t\t\t\t\t\t<div class=\"cell\">\r\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\r\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"gridInputs\"  id=\"pkgCode_";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" disabled readonly  name=\"pkgCode_";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" />\r\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' id=\'existPkg";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' name=\'existPkg";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' value=\'Y\' />\r\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" name=\"pkgCode_";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" onchange=\"clearPkgValues(\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\')\" />\r\n\t\t\t\t\t\t\t\t\t\t<button class=\"gridSerachIcon\" type=\"button\" onclick=\"pkgDtlsLkp(\'pkgCode_";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\',\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\')\" id=\"pkgicon";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\r\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"mdi mdi-magnify\"></span>\r\n\t\t\t\t\t\t\t\t\t\t</button>\r\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="  \r\n\t\t\t\t\t\t\t\t\t</div> \r\n\t\t\t\t\t\t\t\t\t<div class=\"cell\" >\r\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"gridInputs\"  id=\"pkgdesc_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" name=\"pkgdesc_";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" disabled readonly/>\r\n\t\t\t\t\t\t\t\t\t</div> \r\n\t\t\t\t\t\t\t\t\t <div class=\"cell\" align=\"center\">\r\n\t\t\t\t\t\t\t\t\t\t <input type=\"checkbox\" class=\"row-checkbox\" id=\"selectPkg_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="checked";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" name=\"selectPkg_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"  onclick=\"selectPkg(this,\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\')\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" />\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t</div>\r\n\t</div>\t\r\n\t<div class=\"buttoncontainer\" align=\"right\">\r\n\t\t<input type=\"Button\" class=\"btn btn-primary\" value=\"Add\" onclick=\"addPkgDtls();\" >\r\n\t\t<input type=\"Button\" class=\"btn btn-primary\" value=\"Save\" onclick=\"savePkgDtls();\">\r\n\t\t<input type=\"Button\" class=\"btn btn-primary\" value=\"Close\" onclick=\"closePopup();\" >\r\n\t\t&nbsp;&nbsp;&nbsp;&nbsp;\r\n\t</div>\r\n\t\r\n</div>\r\n\t\r\n\t<br><br>\r\n\t<input type=\"hidden\" id=\"pkgTotalRows\" name=\"pkgTotalRows\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"/>\r\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\r\n\t<input type=\"hidden\" id=\"prevPkgAsscRows\" name=\"prevPkgAsscRows\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"/> \r\n\t<input type=\'hidden\' id=\'QryString\' name=\'QryString\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\r\n\t<input type=\'hidden\' id=\'selectRec\' name=\'selectRec\' value=\'[]\'>\r\n</body>\r\n</html>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 
	request.setCharacterEncoding("UTF-8");
	request = new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
            _bw.write(_wl_block3Bytes, _wl_block3);

		int pkgCount=0;
		String[] pkgCode;
		String[] pkgSeqNo;
		String[] pkgAssocFlag;
		String[] pkgDesc;
		String[] existPkg;
		String bean_id										= 	"BLModifyFinancialDetailsResponse" ;
		String bean_name									= 	"eBL.ModifyFinancialDetails.response.BLModifyFinancialDetailsResponse";
		BLModifyFinancialDetailsRequest modifyFinancialDetailsRequest = new BLModifyFinancialDetailsRequest();
		BLModifyFinancialDetailsDao modifyFinancialDetailsDao = new BLModifyFinancialDetailsDaoImpl();
		List<BLModifyFinancialDetailsResponse> packageDetailsList = new ArrayList<BLModifyFinancialDetailsResponse>();
		//String disabled="",reloadYN="";
	String pkgCodeStr =request.getParameter("pkgCodeStr")==null?"":request.getParameter("pkgCodeStr");
	System.out.println(pkgCodeStr);
	int length=0;
	if(pkgCodeStr.length()>0){
		//System.out.println("18 "+packageDetailsList.size()); 
		/* if(packageDetailsList.size()>0)
			packageDetailsList.clear(); */
		System.out.println("138 "); 
		BLModifyFinancialDetailsResponse modifyFinancialDetailsResponse = null;
		//String pkgCodeStr =(String)request.getParameter("pkgCodeStr");
		System.out.println("140 "); 
		String pkgSeqNoStr = request.getParameter("pkgSeqNoStr")==null?"":request.getParameter("pkgSeqNoStr");
		String pkgAssocFlagStr =request.getParameter("pkgAssocFlagStr")==null?"":request.getParameter("pkgAssocFlagStr");
		String pkgDescStr=request.getParameter("pkgDescStr")==null?"":request.getParameter("pkgDescStr");
		String existPkgRec=request.getParameter("existPkgRec")==null?"":request.getParameter("existPkgRec");
		System.out.println(pkgSeqNoStr);
		System.out.println(pkgAssocFlagStr);
		System.out.println(pkgDescStr);
		System.out.println(existPkgRec);
		pkgCode=pkgCodeStr.split("\\|");
		pkgSeqNo=pkgSeqNoStr.split("\\|");
		pkgAssocFlag=pkgAssocFlagStr.split("\\|");
		pkgDesc=pkgDescStr.split("\\|");
		existPkg=existPkgRec.split("\\|");
		pkgCount=pkgCode.length;
		String existTotPkgRec=request.getParameter("existTotPkgRec")==null?"0":request.getParameter("existTotPkgRec"); 
		System.out.println("pkgCount "+pkgCount); 
		System.out.println("existTotPkgRec in enc assoc=>"+existTotPkgRec); 
		length=Integer.parseInt(existTotPkgRec);
		System.out.println("length "+length); 
		for(int k=0;k<pkgCount;k++){
			System.out.println("156 "); 
			modifyFinancialDetailsResponse = new BLModifyFinancialDetailsResponse();
			System.out.println("156 "+k); 
			System.out.println("160 "+pkgSeqNo[k]); 
			System.out.println("161 "+pkgCode[k]); 
			System.out.println("1762 "+pkgDesc[k]); 
			System.out.println("1762 "+pkgAssocFlag[k]);
			System.out.println("i3o ");
			
			System.out.println("19889 "+existPkg[k]);
			modifyFinancialDetailsResponse.setPkgSeqNo(pkgSeqNo[k]==null?"":pkgSeqNo[k]);
			modifyFinancialDetailsResponse.setPkgCode(pkgCode[k]==null?"":pkgCode[k]);
			modifyFinancialDetailsResponse.setPkgDesc(pkgDesc[k]==null?"":pkgDesc[k]);
			modifyFinancialDetailsResponse.setPkgAssocYN(pkgAssocFlag[k]==null?"":pkgAssocFlag[k]);
			System.out.println("19889 "+existPkg[k]);
			modifyFinancialDetailsResponse.setExistPkgYN(existPkg[k]==null?"":existPkg[k]);
			System.out.println("168 "+modifyFinancialDetailsResponse.getPkgCode());
			packageDetailsList.add(modifyFinancialDetailsResponse);
			System.out.println("169 "+packageDetailsList.size()); 
		}
		
	}else{
		String episodeType = request.getParameter("episodeType");
		String patientId = (String)request.getParameter("patientId");
		String episodeId = (String)request.getParameter("episodeId");
		String visitId = (String)request.getParameter("visitId");
		String facility_id = (String)request.getParameter("facility_id");
		modifyFinancialDetailsRequest.setEpisodeType(episodeType);
		modifyFinancialDetailsRequest.setPatientID(patientId);
		modifyFinancialDetailsRequest.setEpisodeId(episodeId);
		modifyFinancialDetailsRequest.setVisitId(visitId);
		modifyFinancialDetailsRequest.setFacilityId(facility_id);
		packageDetailsList = modifyFinancialDetailsDao.getpackageDetails(modifyFinancialDetailsRequest);
		length=packageDetailsList.size();
	}
	System.out.println("packageDetailsList.size()::"+packageDetailsList.size());
	
	int i=0;
	
	
	/* 
	System.out.println("packageDetailsList.seqno()::"+packageDetailsList.get(0).getPkgSeqNo());
	 */
	
	
            _bw.write(_wl_block4Bytes, _wl_block4);
if(packageDetailsList.size()>0) {
						for(i=0;i<packageDetailsList.size();i++){
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(i));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(i));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(i));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(packageDetailsList.get(i).getPkgSeqNo()));
            _bw.write(_wl_block9Bytes, _wl_block9);
if(packageDetailsList.get(i).getExistPkgYN().equals("Y")){
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(i));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(i));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(packageDetailsList.get(i).getPkgCode()));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
}else{
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(packageDetailsList.get(i).getPkgCode()));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
} 
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(packageDetailsList.get(i).getPkgDesc()));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
if(packageDetailsList.get(i).getPkgAssocYN().equals("Y")){
            _bw.write(_wl_block25Bytes, _wl_block25);
}
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(packageDetailsList.get(i).getPkgAssocYN()));
            _bw.write(_wl_block29Bytes, _wl_block29);
}
						
					}/* else{
							out.println("<script>alert('No data found');</script>");
							//getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON')
						} */
					//it will give data only when package is associated otherwise user need to associate from LOV
				
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(packageDetailsList.size()));
            _bw.write(_wl_block31Bytes, _wl_block31);
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(length));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block34Bytes, _wl_block34);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
