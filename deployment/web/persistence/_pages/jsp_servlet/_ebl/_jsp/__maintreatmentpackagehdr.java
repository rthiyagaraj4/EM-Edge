package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import eBL.Common.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __maintreatmentpackagehdr extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/MainTreatmentPackageHdr.jsp", 1737917152317L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No        Version           Incident             SCF/CRF             Developer Name\n--------------------------------------------------------------------------------------\n1            V210504            16777\t      PMG2021-COMN-CRF-0076      Ram kumar S\n2\t     V210730           16777\t      PMG2021-COMN-CRF-0076      Mohana Priya\n3\t\t\t V211118\t\t   23078\t        PMG2021-COMN-CRF-0076.1      Manivel Natarajan \n4\t\t\tV230106\t\t\t\t36652\t\t\tTH-KW-CRF-0145.1\t\t\tMohanapriya\n -->\n\n\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n <link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' /> \n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eBL/images/style.css\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t<script language=\'javascript\' src=\'../../eBL/js/json2.js\'></script>\n\t\n\t<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eBL/js/MaintainTreamentPackage.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\n\t\n\t</script>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n\t<title>MTP</title>\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<body onKeyDown=\"lockKey();\" onMouseDown=\"CodeArrest();\"  onscroll=\'moveFrame()\' onload=\'primaryPatValidation(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\',\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\')\'>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t<body onKeyDown=\"lockKey();\" onMouseDown=\"CodeArrest();\"  onscroll=\'moveFrame()\' onload=\"primaryPatValidation(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\')\">\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n<body onKeyDown=\"lockKey();\" onMouseDown=\"CodeArrest();\"  onscroll=\'moveFrame()\' onload=\'\'>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n<body onKeyDown=\"lockKey();\" onMouseDown=\"CodeArrest();\"  onscroll=\'moveFrame()\' onload=\'focusELement()\'>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n<form name=\'frmMaintainTreatHeader\' id=\'frmMaintainTreatHeader\' method=\'\' >\n<center>\n<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"BorderLight\">\n  <tr>\n    <td class=\"pad4side\">\n\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\"> \n      <tr>\n      \t<td class=\"label\" width=\"25%\"><b>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</b>\n\t      \t<input type=\"text\" name=\"patient_id\" id=\"patient_id\" id=\"patient_id\" \tvalue=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t maxlength=\"30\"  onBlur=\"ChangeUpperCase( this ),primaryPatValidation(this.value,\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\');if(this.value == \'\'){ PatientIdLookup(); primaryPatValidation(this.value,\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\');}\"    onKeyPress=\"return CheckForSpecChars(event);lockbackSpace();\" >\n\t\t\t<input type=\'button\' class=\'button\' name=\"patientidbut\" id=\"patientidbut\" value=\'?\' ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="  onClick=\"PatientIdLookup();primaryPatValidation(patient_id,\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\');\"     tabindex=\'2\' />\n\t      \t<img src=\'../../eCommon/images/mandatory.gif\'> <i><B>Recalculation will happen only when the transaction is saved.</B></i></td> \n       </tr>\n    </table></td>\n  </tr>\n  <!-- \n    <tr>\n      <td class=\"pad4side Bg-yellow\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n        <tbody>\n          <tr>\n            <td width=\"4%\" rowspan=\"2\"><img src=\"icon1.png\" width=\"33\" height=\"41\" alt=\"\"/></td>\n            <td id=\'tdLin\' nowrap class=\"BOLD\">NARENDRA DAMODARDAS 67YRS 3M 14D 004113</td>\n          </tr>\n          <tr>\n            <td>National ID: 33EE  Alt ID: </td>\n          </tr>\n        </tbody>\n      </table></td>\n    </tr>  \n    <tr>\n      <td class=\"pad4side\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"4\">\n        <tr>\n          <td class=\"CAGROUPHEADING\">Package Details</td>\n        </tr>\n        </table>\n        </td>\n        </tr>  -->\n        <input type=\'hidden\' name=\'patientId\' id=\'patientId\' id=\'patientId\' value=\'\'> \n\t\t <input type=\'hidden\' name=\'calledFrom\' id=\'calledFrom\' id=\'calledFrom\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'> <!--V230106-->\n\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t<input type=\'hidden\' name=\'userid\' id=\'userid\' id=\'userid\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t\t<input type=\'hidden\' name=\'ws_no\' id=\'ws_no\' id=\'ws_no\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n    </table>\n    </center>\n\t</form>\n\t\n    </body>\n    </html>\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );
	
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

private String checkForNull(String inputString) {
			return (inputString == null) ? "" : inputString;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = 	(String)session.getAttribute("LOCALE");

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

		//String patientId="004113"; //004113
		String params = request.getQueryString();
	System.err.println("params ::::::::::::::: "+params);
	String patient=checkForNull(request.getParameter("patid"));
	String mode=checkForNull(request.getParameter("mode"));
	String calledFrom=checkForNull(request.getParameter("calledFrom"));//V230106
	String disable="";
	String readnly="";
	if(calledFrom.equals("managePatientPopup")){
		disable="disabled";
		readnly="readonly";
	}//V230106
	//SA0000004178
	System.err.println("calledFrom "+calledFrom);
	String facility_id = (String) session.getValue("facility_id");
	java.util.Properties p = null;
	String ws_no = "", userid = "";
	
	System.out.println("patient ::::::::::::::: "+patient);
	String calenderPrivileageYN = "N", modifyPractPrivYN = "N", assDeassEncPrivYN = "N", pkgServLmtDtlsPrivYN = "N", adhocDiscPrivYN = "N", cancelPkgPrivYN = "N"; // V211118
	
	try { // V211118
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			con = ConnectionManager.getConnection(request);
			String function_id = "EBL_TRAN_PACKAGE_MAINTAIN";
			
			userid = (String) session.getValue("login_user");
			p = (java.util.Properties) session.getValue("jdbc");
			ws_no = p.getProperty("client_ip_address");

			String responseText = "";
			String sql = "select privlege_code, NVL(allowed_yn,'N') from bl_user_privileges where user_code = '" + userid
					+ "' and function_id = '" + function_id + "'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				if("MODIFY_EFF_FROM_MTPKG".equals(rs.getString(1)))
					calenderPrivileageYN = checkForNull(rs.getString(2));
				else if("MODIFY_PRAC_NAME_MTPKG".equals(rs.getString(1)))
					modifyPractPrivYN = checkForNull(rs.getString(2));
				else if("MODIFY_ASSOC_DEASSOC_MTPKG".equals(rs.getString(1)))
					assDeassEncPrivYN = checkForNull(rs.getString(2));
				else if("MODIFY_PKG_SERV_LMT_DTLS_MTPKG".equals(rs.getString(1)))
					pkgServLmtDtlsPrivYN = checkForNull(rs.getString(2));	
				else if("ALLOW_ADHOC_DISC_ENTRY_MTPKG".equals(rs.getString(1)))
					adhocDiscPrivYN = checkForNull(rs.getString(2));	
				else if("ALLOW_CANCEL_PACKAGE_MTPKG".equals(rs.getString(1)))
					cancelPkgPrivYN = checkForNull(rs.getString(2));						
			}
		} catch (Exception e) {
			System.err.println(e);
		}
			
		System.err.println("PrivileageYN:"+calenderPrivileageYN+"/"+modifyPractPrivYN+"/"+assDeassEncPrivYN+"/"+pkgServLmtDtlsPrivYN+"/"+adhocDiscPrivYN+"/"+cancelPkgPrivYN);
			
	
            _bw.write(_wl_block8Bytes, _wl_block8);

if(calledFrom.equals("managePatientPopup")){
	if(mode.equals("reloaded")){
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(params));
            _bw.write(_wl_block11Bytes, _wl_block11);
}
	else{
		System.out.println("patient ::::mmm::::::::::: "+patient);
		
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patient));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(params));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
}else{
if(mode.equals("reloaded")){

            _bw.write(_wl_block14Bytes, _wl_block14);
}
else{
            _bw.write(_wl_block15Bytes, _wl_block15);
}
}

            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(patient ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(readnly));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(params));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(params));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(params));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(calledFrom));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(userid));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(ws_no));
            _bw.write(_wl_block27Bytes, _wl_block27);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
