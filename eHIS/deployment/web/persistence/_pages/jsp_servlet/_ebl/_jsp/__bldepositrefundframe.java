package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.net.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import com.ehis.util.*;
import java.util.*;
import eCommon.Common.*;
import org.apache.commons.codec.binary.Base64;
import java.util.*;
import com.ehis.util.*;

public final class __bldepositrefundframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLDepositRefundFrame.jsp", 1734609378681L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n<!--\n---------------------------------------------------------------------------------------------------------------\nSr No        Version           TFS/Incident        SCF/CRF            \t\t Developer Name\n--------------------------------------------------------------------------------------------------------\n1            V220412            30399          MMS-ME-SCF-0064-TF               Mohanapriya K\n--------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t<script>\n\t\t\t\t\n\t\t</script>\n<HTML>\n<head>\n\t<title>\n\t ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\t\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t</title>\n</head>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' type=\'text/css\'/>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\"src=\"../../eCommon/js/ValidateControl.js\"></script>\t\n\t\t<!--<script language=\"javascript\" src=\"../../eBL/js/BLEnterServiceRequest.js\"></script>\t-->\n\t\t<script language=\"javascript\" src=\"../../eBL/js/BLDepositReceipt.js\"></script>\n        <script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\n\n\t <!-- <iframe name=\'pat_banner_frame\' id=\'pat_banner_frame\' SRC=\"../../eBL/jsp/BLPatBanner.jsp?";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" frameborder=0 scrolling=\'no\' noresize style=\'height:7%;width:100vw\'></iframe> \t-->\n\t\t<!-- <iframe name=\'pat_banner_frame\' id=\'pat_banner_frame\' SRC=\"../../eCommon/jsp/pline.jsp?Patient_Id=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" frameborder=0 scrolling=\'no\' noresize style=\'height:40%;width:100vw\'></iframe> -->\t\n\t\t\t<iframe name=\'pline\' id=\'pline\' frameborder=\'0\'\tsrc=\"../../eCommon/jsp/pline.jsp?Patient_Id=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&episodetype=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&episodeid=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&visitid=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"  scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'details_frame\' id=\'details_frame\' SRC=\"../../eBL/jsp/BLDepositRefund.jsp?";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&called_from=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" frameborder=0 scrolling=\'no\' noresize style=\'height:34vh;width:100vw\'></iframe> \t\t\n\t\t\t<iframe SRC=\"../../eBL/jsp/BLBillSlmtType.jsp?function_id=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&billdoctypecode=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&billdocnum=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&billpayableamt=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&facilityid=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&loggeduser=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&patientid=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&slmtidno=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&slmtpayername=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&cashcounter=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&strblnggrpid=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" NAME=\"BillSlmtTypeFrame\" frameborder=0 noresize scrolling=\'yes\' style=\'height:40vh;width:100vw\'></iframe> \t\n\t\t\t<iframe SRC=\"../../eCommon/html/blank.html\"\t  name=\"\" id=\"\" frameborder=0 noresize scrolling=\'no\'style=\'height:6vh;width:100vw\'></iframe> \t\n\t\t\t<iframe name=\'details_frame\' id=\'details_frame\' SRC=\"../../eBL/jsp/BLDepositReceiptRefund.jsp?";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" frameborder=0 scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe> \n\t\t\t<iframe SRC=\"../../eCommon/html/blank.html\"\t  name=\"submit_frame\" id=\"submit_frame\" frameborder=0 noresize scrolling=\'yes\' style=\'height:6vh;width:100vw\'></iframe>\t\n\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n</HTML>\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; 
	try
	{
			
		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");
		String params = request.getQueryString();
		con	=	ConnectionManager.getConnection(request);

	//	 System.err.println("params BLEnterReceiptRefundFrame.jsp?"+params);   //Associate Package [IN:049347] session clearance   
		
	 	//added by Vijay for bill generation patient deposit collection  	
	
		String called_from=request.getParameter("called_from");
		System.out.println("called_from:: "+called_from);
	// ends --- 
	
	
		String modeOfCall= (request.getParameter("modeOfCall")==null)?"":request.getParameter("modeOfCall");
		if(modeOfCall.equals("Subscription")){
			session.removeAttribute("PACKAGE_SUBSCRIPTION_ASSOCIATION_ENCOUNTERS");
		}
//		String title = request.getParameter("title");	
		
		//con	=	ConnectionManager.getConnection(request);

		String facilityid = (String) session.getValue("facility_id");
		if (facilityid==null) facilityid = "";

		String	strloggeduser	=  (String) session.getValue("login_user");	
		if (strloggeduser==null) strloggeduser = "";
//		System.err.println("strloggeduser" +strloggeduser);

		String strclientip = p.getProperty("client_ip_address");
		if (strclientip==null) strclientip = "";
//		System.err.println("strclientip "+strclientip);

		//V220412 Starts
		String patient_id	="";
		String encounter_id	="";
		
		if("Y".equals(request.getParameter("encoded")==null?"":request.getParameter("encoded"))){
			patient_id	= new String(Base64.decodeBase64(((String)request.getParameter("patient_id")).getBytes()));
			encounter_id	= new String(Base64.decodeBase64(((String)request.getParameter("encounter_id")).getBytes()));
		}else{
			patient_id	= request.getParameter("patient_id");
			encounter_id	= request.getParameter("encounter_id");
		}
		//V220412 Ends
		
		System.out.println("pid,BLDepositRefundFrame.jsp="+patient_id);
		if(patient_id==null) patient_id="";	

		
		String episode_type = request.getParameter("episode_type");	
		if(episode_type==null) episode_type="";	
	
		String episode_id = request.getParameter("episode_id");	
		if(episode_id==null) episode_id="";	

		String visit_id = request.getParameter("visit_id");	
		if(visit_id==null) visit_id="";	
	
		if(encounter_id==null) encounter_id="";	

		String for_pline = "Facility_Id="+facilityid+"&Patient_Id="+patient_id;
		System.err.println("for_pline:"+for_pline);

		//String function_id="rcpt_rfnd";	
//for pkg deposit
	
/****added for package biling********************/
		String function_id = request.getParameter("function_id");	
		if(function_id==null) function_id="rcpt_rfnd";

		String pkgCode = request.getParameter("pkgCode");	
		if(pkgCode==null) pkgCode="";
		//String function_id="rcpt_rfnd";	
//end pkg dep
		
		
		String strbilldoctypecode="";String strbilldocnum="";String strslmtidno="";	String strslmtpayername="";String strcashcountercode="";	String strblnggrpid="";				String strbillpayableamt="";
		//String strunknownpatientyn = "";

		pstmt = con.prepareStatement( " select nvl(pat_dtls_unknown_yn,'N'),NATIONAL_ID_NO, PATIENT_NAME from mp_patient where patient_id = '" + patient_id + "'" );
		rs = pstmt.executeQuery();	
		if ( rs.next() && rs != null ) 
		{ 	
			//strunknownpatientyn =  rs.getString(1);
			strslmtidno  =   rs.getString(2);			
			strslmtpayername =  rs.getString(3);
		}
		System.err.println("Output after query : "+strslmtpayername+", "+strslmtidno);
//		String collect_dep_amt_in_adv_yn="";
	/*try{

		String query_date=" select COLLECT_DEP_DURING_ADM_YN from bl_ip_nursing_unit_type where NURSING_UNIT_TYPE_CODE = (Select nursing_unit_type_code from ip_nursing_unit where nursing_unit_code='CARD' and facility_id='"+facilityid+"') ";
		PreparedStatement pst2=con.prepareStatement(query_date);
		ResultSet rst2 = pst2.executeQuery();
		if (rst2!=null)
		{
		   if (rst2.next())
		   {
				 collect_dep_amt_in_adv_yn = rst2.getString(1);
		   }
		}

		if (rst2 != null)   rst2.close();
		if (pst2 != null)   pst2.close();
		System.err.println("collect deposit :"+collect_dep_amt_in_adv_yn);
	
	}catch(Exception ee)
	{
		System.err.println("Error from collect deposit"+ee);
	}*/
	
            _bw.write(_wl_block5Bytes, _wl_block5);

//for package billing
		if(function_id.equals("PKG_BILLING"))
		{			

            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
		}else{

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);

			}

            _bw.write(_wl_block9Bytes, _wl_block9);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(params));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(params));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strbilldoctypecode));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(strbilldocnum));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strbillpayableamt));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(strloggeduser));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strslmtidno));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(strslmtpayername));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strcashcountercode));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(strblnggrpid));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(params));
            _bw.write(_wl_block31Bytes, _wl_block31);


	}
	catch(Exception ee)
	{
		//out.println("from main :"+ee);
		ee.printStackTrace();
	}
	finally
	{
		if(con!=null) 
			ConnectionManager.returnConnection(con, request);
		if (rs != null)   rs.close();
		if (pstmt != null) pstmt.close();		 
	}

            _bw.write(_wl_block32Bytes, _wl_block32);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DEPOSIT.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DepositReceipt.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
