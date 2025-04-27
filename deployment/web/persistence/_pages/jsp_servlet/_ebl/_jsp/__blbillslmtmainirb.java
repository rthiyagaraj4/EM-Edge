package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.net.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;
import eBL.BLCashSlmtRestriction;

public final class __blbillslmtmainirb extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLBillSlmtMainIRB.jsp", 1740492177681L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No        Version           TFS/Incident        SCF/CRF            \t\t \tDeveloper Name\n--------------------------------------------------------------------------------------------------------\n1            V210129            13523         \tMOHE-CRF-0060       \t\t\tShikha Seth\n2\t\t\t V220801\t\t\t34498\t\t\tBL-Bill Maintenance Function\tMohanapriya\n3\t\t\t V231128\t\t\t51666 \t\t   GHL-CRF-0642-US004\t\t\t Namrata Charate\n--------------------------------------------------------------------------------------------------------\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n\t<HEAD>\n\t\t<TITLE> ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" </TITLE>\n\t\t<!--<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link>-->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<!--<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script>-->\n\t\t<script language=\"javascript\"src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<script>\t\t\t\n\t\t\t\t\tparent.window.returnValue=\"N\";\n\t\t\t\t\twindow.close();\t\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t<script>\t\n\t\t\t\t\t\t\tparent.window.returnValue=\"N\";\n\t\t\t\t\t\t\twindow.close();\t\n\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\t\t\t\t\t<script>alert(getMessage(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\',\'BL\'));\t\t\t\t\t\t\t\n\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar strerrormessage = \'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\';\n\t\t\t\t\t\talert(strerrormessage);\n\t\t\t\t\t\tparent.window.returnValue=\"N\";\n\t\t\t\t\t\twindow.close();\t\n\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t<!-- \t<script>  \n\t\t\t\t\t\t/*alert(\"Settlement Not Allowed\");\n\t\t\t\t\t\tparent.window.returnValue=\"N\";\n\t\t\t\t\t\twindow.close();\t*/\n\t\t\t\t \t</script> --> \n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\talert(getMessage(\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\',\'BL\'));\n\t\t\t\t\t\t\tparent.window.returnValue=\"N\";\n\t\t\t\t\t\t\twindow.close();\n\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\t\t\t\t\t\t\t<script>\n// \t\t\t\t\t\t\t\t\tparent.window.returnValue=\"N\";\n// \t\t\t\t\t\t\t\t\twindow.close();\n\t\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\talert(getMessage(\'BL5201\',\'BL\'));\n\t\t\t\t\t\t\tparent.window.returnValue=\"N\";\n\t\t\t\t\t\t\twindow.close();\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\talert(getMessage(\"BL6420\",\"BL\"));\n\t\t\t\t\t\t\t\tparent.window.returnValue=\"N\";\n\t\t\t\t\t\t\t\twindow.close();\t\n\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\t\n<!-- userSettledAmount was replaced with strbillpayableamt for the param billpayableamt for Partial Settlement Rajesh -->\n\t</HEAD> \n\t\n\t\t\t<IFRAME SRC= \"../../eBL/jsp/BLBillSlmtDetIRB.jsp?billdoctypecode=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&billdocnum=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&billpayableamt=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&facilityid=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&loggeduser=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&patientid=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&episodetype=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&episodeid=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&visitid=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&encounterid=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&moduleid=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&slmtidno=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&slmtpayername=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&cashcounter=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&strblnggrpid=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="&strroundingamt=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&called_frm=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&alw_co_wit_bl_slmt_yn=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&cal_frm_multi_bil_slmt=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&dfltcashbillslmtamt=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="&ext_acc_interface_yn=";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="&unavail_service_code=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="&addl_charge_amt=";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="&partSettled=";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="&fromBillGen=";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" NAME=\"BillSlmtEntryFrame\" ID=\"BillSlmtEntryFrame\" frameborder=0 noresize scrolling=\'yes\' style=\'height:35vh;width:100vw\'></IFRAME>\n\t\t\t<IFRAME SRC=\"../../eBL/jsp/BLBillSlmtServiceSelectedList.jsp\"\t  name=\"BillSlmtServiceFrame\" id=\"BillSlmtServiceFrame\" frameborder=0 noresize scrolling=\'no\' style=\'height:24vh;width:100vw\'></IFRAME>\t\t\n\t\t\t<IFRAME  frameborder=0 SRC=\"../../eBL/jsp/BLBillSlmtTypeIRB.jsp?billdoctypecode=";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="&encounterFacilityId=";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="&restrictEligibility=";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" NAME=\"BillSlmtTypeFrame\" ID=\"BillSlmtTypeFrame\" frameborder=0 scrolling=\'auto\' style=\'height:33vh;width:100vw\'></IFRAME>\t\t\n\t\t\t<IFRAME SRC=\"../../eCommon/html/blank.html\"\t  name=\"BillSlmtTypeBtnFrame\" id=\"BillSlmtTypeBtnFrame\" frameborder=0 noresize scrolling=\'no\' style=\'height:6vh;width:100vw\'></IFRAME>\t\t\n\t\t\t<IFRAME SRC=\"../../eCommon/html/blank.html\"\t  name=\"BillSlmtSubmitFrame\" id=\"BillSlmtSubmitFrame\" frameborder=0 noresize scrolling=\'no\' style=\'height:5vh;width:100vw\'></IFRAME>\t\t\n\t\t\t<IFRAME SRC=\"../../eCommon/html/blank.html\"\t  name=\"BillSlmtConfirmFrame\" id=\"BillSlmtConfirmFrame\" frameborder=0 noresize scrolling=\'no\' style=\'height:0vh;width:100vw\'></IFRAME>\t\t\n\t\t\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar strerrormessage = \'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\';\n\t\t\t\t\t\t    alert(strerrormessage);\n\t\t\t\t\t\t\tparent.window.returnValue=\"N\";\n\t\t\t\t\t\t\twindow.close();\t\n\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n</HTML>\n\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );
	
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
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
	
		//Added by Manivel Natarajan on 10/Aug/2006
		request.setCharacterEncoding("UTF-8");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; ResultSet rs1 = null;	ResultSet rs2 = null;	
		con	=	ConnectionManager.getConnection(request);
		//String strfacilityid	=  (String) session.getValue("facility_id"); //V210129 Commented
		String strfacilityid	=  request.getParameter("encounterFacilityId");	//V210129 Added
		//if(strfacilityid == null) strfacilityid=""; //V220801 commented
		if(strfacilityid == null)
			strfacilityid	=  (String) session.getValue("facility_id"); //V220801
		System.err.println("strfacilityid "+strfacilityid);
		String strloggeduser	=  (String) session.getValue("login_user");			
		if(strloggeduser == null) strloggeduser="";
		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");	
		//int noofdecimal = 2; 
		int noofdecimal = 0; //Added by muthu for 31094 - no.of decimal values on 31-5-12
		String strclientip = p.getProperty("client_ip_address");
		String strblnggrpid	="";String pkg_seq_no="";String pkg_code="";//,str_bl_package_enabled_yn="N";
		//String query_string=request.getQueryString();
		String strdfltcashbillslmtamt = "", ext_acc_interface_yn="";
		String unavail_service_code="";	
		String retValue="N";
		String fromBillGen = request.getParameter("fromBillGen");
		if(fromBillGen == null){
			fromBillGen = "";
		}
		//Added for Bill Maintanence
		String billMaintain = request.getParameter("billMaintain");
		String userSettledAmount = request.getParameter("userSlmtAmt");				
		String negative1= request.getParameter("negative");
		if(negative1 == null){
			negative1 = "";
		}
		if(userSettledAmount == null){
			userSettledAmount = "0.0";
		}

		if(billMaintain == null || "null".equals(billMaintain)){
			billMaintain = "";
		}
		//Added for Bill Maintanence
		//KDAH-CRF-0318
		String addlChargeAmtForBill = "";
		//Added for MMS-ME-SCF-0015 on 19-Aug-20 by Shikha
		String totalExcemptedAmount = ""; 
		float userSettledAmountFloat = 0; 
		
		String restrictEligibility="";  //V231128
		BLCashSlmtRestriction billRestr = new BLCashSlmtRestriction();  //V231128
		restrictEligibility = billRestr.checkCashRestrictionEligibility(strfacilityid);  //V231128
		System.err.println("restrictEligibility in BLBillSlmtMainIRB.jsp @@@@@@@@@@@@@@@@@@@@@-- >"+restrictEligibility);  //V231128
		
		
		//Added for MMS-ME-SCF-0015 on 19-Aug-20 by Shikha
		try
		{
			/****************added for package billing refund****************************/
			String call_frm = request.getParameter("call_frm")==null?"": request.getParameter("call_frm");
			String strbilldoctypecode ="";String strbilldocnum ="";

	try
		{		
		//pstmt = con.prepareStatement( " select blcommon.get_bill_round_decimal_place ('"+strfacilityid+"') from dual ");
			pstmt = con.prepareStatement("select blcommon.get_decimal_place(?) from dual");
				pstmt.setString(1,strfacilityid);
				rs = pstmt.executeQuery();	
				if ( rs.next() && rs != null )
				{
					noofdecimal  =  rs.getInt(1);
 				//System.out.println("get_decimal_place @ noofdecimal==> "+noofdecimal);
				}
			}
			catch(Exception e)
			{   e.printStackTrace();
				System.out.println("4="+e.toString());
			}
			finally 
			{
				if (rs != null)   rs.close();
				if (pstmt != null) pstmt.close();		 		
			}

			//if(str_bl_package_enabled_yn.equals("Y")){
			if(!call_frm.equals("") && call_frm.equals("PKG_RFND"))
			{
				String frmdoctype			= request.getParameter("frmdoctype")==null?"": request.getParameter("frmdoctype");
				String frmdocnum			= request.getParameter("frmdocnum")==null?"": request.getParameter("frmdocnum");
				String todoctype			= request.getParameter("todoctype")==null?"": request.getParameter("todoctype");
				String todocnum				= request.getParameter("todocnum")==null?"": request.getParameter("todocnum");
				pkg_seq_no				= request.getParameter("pkg_seq_no")==null?"": request.getParameter("pkg_seq_no");
				pkg_code				= request.getParameter("pkg_code")==null?"": request.getParameter("pkg_code");

				try
				{		
					pstmt = con.prepareStatement("SELECT DISTINCT bill_DOC_TYPE_CODE, bill_doc_num FROM bl_patient_charges_folio WHERE bill_DOC_TYPE_CODE BETWEEN ? AND ? AND bill_doc_num BETWEEN  ? AND   ? AND SETTLEMENT_IND = 'C' ")	;		
					
					pstmt.setString(1,frmdoctype);
					pstmt.setString(2,todoctype);
					pstmt.setString(3,frmdocnum);
					pstmt.setString(4,todocnum);	
					rs = pstmt.executeQuery();	
					if ( rs.next() && rs != null ) 
					  {	 	
						strbilldoctypecode  =  rs.getString(1); 
						strbilldocnum     =  rs.getString(2);					
					  }
				}catch(Exception e) 
					{
					e.printStackTrace();
					out.println(e.toString());	}
				finally 
				{
					if (rs != null)   rs.close();
					if (pstmt != null) pstmt.close();		 	
				}	
			}
			//}/************PACKAGE BILLING*****************ENDS**/
			else
			{
				strbilldoctypecode         = request.getParameter("billdoctypecode");
				if(strbilldoctypecode == null || strbilldoctypecode.equals(" ")) strbilldoctypecode="";
				strbilldocnum              = request.getParameter("billdocnum");			
				if(strbilldocnum == null || strbilldocnum.equals(" ")) strbilldocnum="";
			}
			
			String p_patient_id     =  request.getParameter("patient_id");	
			if(p_patient_id == null) p_patient_id="";
			/****************added for package billing refund**********************starts******/
//to get billing group
			if(call_frm.equals("PKG_RFND"))
			{
				String pkg_enc_id="",pkg_visit_id="",pkg_epi_type="";
				try
				{		
					//pstmt = con.prepareStatement("SELECT ENCOUNTER_ID,VISIT_ID,EPISODE_TYPE FROM BL_PACKAGE_ENCOUNTER_DTLS WHERE PATIENT_ID='"+p_patient_id+"' and  PACKAGE_CODE='"+pkg_code+"' and  PACKAGE_SEQ_NO='"+pkg_seq_no+"'");		
					pstmt = con.prepareStatement("SELECT encounter_id, visit_id, episode_type  FROM bl_package_encounter_dtls A  WHERE operating_facility_id = ? AND patient_id = ? AND package_code = ?  AND package_seq_no = ?   AND package_seq_no IN ( SELECT package_seq_no FROM bl_package_sub_hdr     WHERE operating_facility_id = ? AND patient_id = ? AND package_code = ?            AND package_seq_no = ?  AND status = 'C')");
					
					pstmt.setString(1,strfacilityid);
					pstmt.setString(2,p_patient_id);
					pstmt.setString(3,pkg_code);
					pstmt.setString(4,pkg_seq_no);	
					pstmt.setString(5,strfacilityid);
					pstmt.setString(6,p_patient_id);
					pstmt.setString(7,pkg_code);
					pstmt.setString(8,pkg_seq_no);	
					rs1 = pstmt.executeQuery();	
					while( rs1.next() && rs1 != null ) 
					{	 	
						pkg_enc_id  =  rs1.getString(1); 
						pkg_visit_id     =  rs1.getString(2);					
						pkg_epi_type     =  rs1.getString(3);					
					}
					rs1.close();
					pstmt.close();
				}
				catch(Exception e) 
				{   e.printStackTrace();
					System.out.println("BL_PACKAGE_ENCOUNTER_DTLS main :"+e);	
					out.println(e.toString());	
				}
				if(pkg_enc_id == null) pkg_enc_id="";
				if(pkg_visit_id == null) pkg_visit_id="";
				if(pkg_epi_type == null) pkg_epi_type="";
			
				try
				{		
					if(pkg_epi_type.equals("O"))
					{
						pstmt = con.prepareStatement("SELECT BLNG_GRP_ID FROM bl_visit_fin_dtls WHERE PATIENT_ID=? and  EPISODE_ID=? and  VISIT_ID=? and episode_type=? and operating_facility_id=?");	

						pstmt.setString(1,p_patient_id);
						pstmt.setString(2,pkg_enc_id);
						pstmt.setString(3,pkg_visit_id);
						pstmt.setString(4,pkg_epi_type);
						pstmt.setString(5,strfacilityid);
						rs2 = pstmt.executeQuery();	
						while( rs2.next() && rs2 != null ) 
						  {	 	
							strblnggrpid  =  rs2.getString(1); 										
						  }
					}
					else if(pkg_epi_type.equals("I") || pkg_epi_type.equals("D")) 
					{
						pstmt = con.prepareStatement("SELECT BLNG_GRP_ID FROM bl_episode_fin_dtls WHERE PATIENT_ID=? and  EPISODE_ID=? and episode_type=? and operating_facility_id=?");//and  VISIT_ID='"+pkg_visit_id+"'");	

						pstmt.setString(1,p_patient_id);
						pstmt.setString(2,pkg_enc_id);
						pstmt.setString(3,pkg_epi_type);
						pstmt.setString(4,strfacilityid);
						rs2 = pstmt.executeQuery();	
						while( rs2.next() && rs2 != null ) 
						  {	 	
							strblnggrpid  =  rs2.getString(1); 										
						  }
					}
					rs2.close();
					pstmt.close();
				}
				catch(Exception e) 
				{   e.printStackTrace();
					System.out.println("bl_episode_fin_dtls main :"+e);	
					out.println(e.toString());	
				}
				if(strblnggrpid == null) strblnggrpid="";
				//System.out.println("strblnggrpid main :"+strblnggrpid);		
			}
			else
			{
/****************added for package billing refund***********************ends*****/
				strblnggrpid		=  request.getParameter("blnggrp");	
				if(strblnggrpid == null) strblnggrpid="";
			}
			String billgenlater     =  request.getParameter("billgenlater");	
			if(billgenlater == null || billgenlater.equals(" ")) billgenlater="N";

			String p_function_id     =  request.getParameter("function_id");	
			if(p_function_id == null) p_function_id="";

			String p_module_id     =  request.getParameter("module_id");	
			if(p_module_id == null) p_module_id="";

			String p_clinic_code     =  request.getParameter("clinic_code");	
			if(p_clinic_code == null) p_clinic_code="";

			String p_visit_type_code     =  request.getParameter("visit_type_code");	
			if(p_visit_type_code == null) p_visit_type_code="";
		

			String p_episode_type     =  request.getParameter("episode_type");	
			if(p_episode_type == null) p_episode_type="";

			String p_encounter_id     =  request.getParameter("p_encounter_id");	
			if(p_encounter_id == null) p_encounter_id="";

			String p_episode_id     =  request.getParameter("p_episode_id");	
			if(p_episode_id == null) p_episode_id="";

			String p_visit_id     =  request.getParameter("p_visit_id");	
			if(p_visit_id == null) p_visit_id="";

			String p_user     =  request.getParameter("p_user");	
			if(p_user == null) p_user="";

			String p_ws_no     =  request.getParameter("p_ws_no");	
			if(p_ws_no == null) p_ws_no="";

			String locale			= (String)session.getAttribute("LOCALE");
			if(locale == null) locale="en";

			String called_frm  =  request.getParameter("function_id");	
			if(called_frm == null) called_frm="";

			String alw_co_wit_bl_slmt_yn = request.getParameter("alw_co_wit_bl_slmt_yn");	
			if(alw_co_wit_bl_slmt_yn == null) alw_co_wit_bl_slmt_yn="";

			if(alw_co_wit_bl_slmt_yn.equals(""))
			{
				alw_co_wit_bl_slmt_yn = request.getParameter("allow_chkout_with_bill_stmt_yn");	
				if(alw_co_wit_bl_slmt_yn == null) alw_co_wit_bl_slmt_yn="N";
			}

			String cal_frm_multi_bil_slmt = request.getParameter("cal_frm_multi_bil_slmt");	
			if(cal_frm_multi_bil_slmt == null) cal_frm_multi_bil_slmt="";

			String strslmtidno		= "";	String strslmtpayername = "";	String strepitype   = "";
			String strunknownpatientyn = "N";	String strpatid		    = "";	
			if (strbilldoctypecode == null || strbilldoctypecode.equalsIgnoreCase("null")) 
			{	strbilldoctypecode = ""; }
			if (strbilldocnum == null || strbilldocnum.equalsIgnoreCase("null")) 
			{strbilldocnum = "";}		
			//if (strbilldoctypecode.trim().length() == 0 )

			if (strbilldoctypecode.equals(""))
			{			

            _bw.write(_wl_block9Bytes, _wl_block9);

			}
			else
			{	
				
				String beanId = "BillDetailsBean";
				String beanName = "eBL.BLBillDetailsBean";
				BLBillDetailsBean bean=(BLBillDetailsBean) getBeanObject(beanId, beanName, request);
				HashMap<String, ArrayList<BLBillDetailsBean>> billDtlMap=bean.getBillDtlMap();
				ArrayList<BLBillDetailsBean> billDetailList=billDtlMap.get("REPRINT");
				
				StringBuilder docNumList=new StringBuilder();
				StringBuilder docTypeCode=new StringBuilder();
				StringBuilder docNumTypeList=new StringBuilder();
				float totalExcemptedAmountFloat=0;
				
				for(BLBillDetailsBean beanObj:billDetailList ){
					docNumList.append("'");
					docNumList.append(beanObj.getDocNum());
					docNumList.append("'");
					docNumList.append(",");
					
					docTypeCode.append("'");
					docTypeCode.append(beanObj.getDocTypeCode());
					docTypeCode.append("'");
					docTypeCode.append(",");
					
					docNumTypeList.append("'");
					docNumTypeList.append(beanObj.getDocNum()+"/"+beanObj.getDocTypeCode());
					docNumTypeList.append("'");
					docNumTypeList.append(",");
					System.out.println(beanObj);
					
					totalExcemptedAmountFloat +=  ((beanObj.getExcemptedAmt()==null)||("".equals(beanObj.getExcemptedAmt()))) ? 0 : Float.parseFloat(beanObj.getExcemptedAmt()) ;
				}
				docNumList.deleteCharAt(docNumList.length()-1);
				docTypeCode.deleteCharAt(docTypeCode.length()-1);
				docNumTypeList.deleteCharAt(docNumTypeList.length()-1);
				
				String strbillpayableamt = "";	//String strblnggrpid	= "";		
				String strcliniccode = "";		String strwsno = "";
				String strcashcountercode = "";		String strshiftid	= "";
				String strsysmessageid = "";		String strerrortext = "";
				String strpatientid ="";		String strepisodetype = "";
				String strepisodeid = "";		String strvisitid =""; String strencounterid="";
				String strprintvisitbilltype ="";		String strprintzerobillcouponyn = "",strbillnaturecode="";
				String strbillgenyn				= "";		String strzerobillgenyn			= "",strroundingamt="";
				String strslmtyn = "Y"; 		String strerrorlevel = "";		
				float strbillpayableamtFloat=0;
				float strroundingamtFloat=0;
				float addlChargeAmtForBillFloat=0;
				
			
				if (strblnggrpid == null || strblnggrpid.equalsIgnoreCase("null")) 
				{strblnggrpid = "";}		
				try
				{		
					pstmt = con.prepareStatement( " select clinic_code, episode_type,patient_id,bill_nature_code,nvl(bill_tot_outst_amt,0), patient_id,episode_type,episode_id,visit_id,nvl(BILL_ROUNDING_AMT,0),ENCOUNTER_ID,nvl(addl_charge_amt,0) addl_charge_amt, NVL(ADDL_CHARGE_EXEMPT_AMT,0) ADDL_CHARGE_EXEMPT_AMT from bl_bill_hdr where operating_facility_id = '" + strfacilityid + "' and  doc_num||'/'||doc_type_code  IN("+docNumTypeList+")"); //Modified for MMS-ME-SCF-0015 on 19-Aug-20 by Shikha
	

					rs = pstmt.executeQuery();	
					while ( rs != null && rs.next() ) 
					{	 	
						strcliniccode  =  rs.getString(1); 
						strepitype     =  rs.getString(2);
						strpatid       =  rs.getString(3);
						strbillnaturecode = rs.getString(4);
						strbillpayableamt =  rs.getString(5);
						System.err.println("330==strbillpayableamt==>"+strbillpayableamt);
						strbillpayableamtFloat += Float.parseFloat( (strbillpayableamt==null)?"0":strbillpayableamt );
						strpatientid =  rs.getString(6);	
						strepisodetype =  rs.getString(7);			
						strepisodeid =  rs.getString(8);			
						strvisitid =  rs.getString(9);	
						strroundingamt = rs.getString(10);
						strroundingamtFloat += Float.parseFloat( (strroundingamt==null)?"0":strroundingamt );
						
						strencounterid = rs.getString(11);
						addlChargeAmtForBill = rs.getString("addl_charge_amt");	
						addlChargeAmtForBillFloat +=Float.parseFloat( (addlChargeAmtForBill==null)?"0":addlChargeAmtForBill );
						//Added for MMS-ME-SCF-0015 on 19-Aug-20 by Shikha
						totalExcemptedAmount = rs.getString("ADDL_CHARGE_EXEMPT_AMT");
						totalExcemptedAmountFloat +=Float.parseFloat((totalExcemptedAmount==null)?"0":totalExcemptedAmount);
						//Ended for MMS-ME-SCF-0015 on 19-Aug-20 by Shikha
					}
				}
				catch(Exception e) 
				{   e.printStackTrace();
					out.println(e.toString());	
				}
				finally 
				{
					if (rs != null)   rs.close();
					if (pstmt != null) pstmt.close();		 	
				}	
//				strbillpayableamt=""+ (strbillpayableamtFloat - totalExcemptedAmountFloat); //Commented for MMS-ME-SCF-0015 on 19-Aug-20 by Shikha
				strbillpayableamt=""+ (strbillpayableamtFloat ); //Added for MMS-ME-SCF-0015 on 19-Aug-20 by Shikha

				strroundingamt=""+strroundingamtFloat;
				addlChargeAmtForBill=""+addlChargeAmtForBillFloat;

				if ( strcliniccode == null || strcliniccode.equalsIgnoreCase("null")) 
					strcliniccode = "";

				if ( strepitype == null || strepitype.equalsIgnoreCase("null")) 
					 strepitype = "";

				if ( strpatid == null || strpatid.equalsIgnoreCase("null")) 
					 strpatid = "";

				if ( strbillnaturecode == null || strbillnaturecode.equalsIgnoreCase("null")) 
					 strbillnaturecode = "";

//				System.err.println("strbillnaturecode :" +strbillnaturecode);
				/*Added by Karthik for Report Reprint called from Starts*/
				if("Y".equals(billMaintain)){					
				
					String reprint_billdoctypecode=request.getParameter("billdoctypecode");
					String reprint_billdocnum=request.getParameter("billdocnum");
					String reprint_moduleid="";
					
					String sqlReprintReportModule="select distinct module_id from BL_PATIENT_CHARGES_FOLIO where BILL_DOC_TYPE_CODE=? and BILL_DOC_NUM=? and OPERATING_FACILITY_ID=?";
					
					try
					{	
						pstmt = con.prepareStatement(sqlReprintReportModule);
						pstmt.setString(1, reprint_billdoctypecode);
						pstmt.setString(2, reprint_billdocnum);
						pstmt.setString(3, strfacilityid);
						rs = pstmt.executeQuery();	
						if ( rs.next() && rs != null ) 
						{ 	
							reprint_moduleid =  rs.getString(1);							
						}
					}
					catch(Exception e) 
					{   e.printStackTrace();
						out.println(e.toString());	
					}
					finally 
					{
						if (rs != null)   rs.close();
						if (pstmt != null) pstmt.close();		 	
					}	
					
					session.setAttribute("BL_MODULE_CALLED_FROM_REPORT_REPRINT", reprint_moduleid);
					
				}
				//billMaintain added in condition Rajesh V
				if(!strbillnaturecode.equals("C") && !"Y".equals(billMaintain))
				{

            _bw.write(_wl_block10Bytes, _wl_block10);


				}

				try
				{	
					pstmt = con.prepareStatement( " select nvl(pat_dtls_unknown_yn,'N'),NATIONAL_ID_NO, PATIENT_NAME from mp_patient where patient_id = '" + strpatid + "'" );
					rs = pstmt.executeQuery();	
					if ( rs.next() && rs != null ) 
					{ 	
						strunknownpatientyn =  rs.getString(1);
						strslmtidno  =   rs.getString(2);			
						strslmtpayername =  rs.getString(3);
					}
				}
				catch(Exception e) 
				{   e.printStackTrace();
					out.println(e.toString());	
				}
				finally 
				{
					if (rs != null)   rs.close();
					if (pstmt != null) pstmt.close();		 	
				}	

				if ( strunknownpatientyn == null || strunknownpatientyn.equalsIgnoreCase("null")) 
					strunknownpatientyn = "";
				if ( strslmtidno == null ) strslmtidno = "";
				if ( strslmtpayername == null ) strslmtpayername = "";

				if (strcliniccode.equals(""))
				{
					try
					{		
						pstmt = con.prepareStatement("select clinic_code from bl_visit_fin_dtls where (operating_facility_id,episode_type,episode_id,visit_id,patient_id) in (select operating_facility_id,episode_type,episode_id,visit_id,patient_id from bl_bill_hdr where operating_facility_id = ? and doc_type_code= ? and doc_num = ?)");
						
						pstmt.setString(1,strfacilityid);
						pstmt.setString(2,strbilldoctypecode);
						pstmt.setString(3,strbilldocnum);
						rs = pstmt.executeQuery();	
						if ( rs.next() && rs != null ) 
						{strcliniccode =  rs.getString(1); }
					}
					catch(Exception e) 
					{   e.printStackTrace(); 
						out.println(e.toString());	
					}
					finally 
					{
						if (rs != null)   rs.close();
						if (pstmt != null) pstmt.close();		 	
					}	
				}

				if ( strcliniccode == null || strcliniccode.equalsIgnoreCase("null")) 
					strcliniccode = "";	
	
				try
				{	
					if(!(called_frm.equals("CHECKOUT_VISIT") && alw_co_wit_bl_slmt_yn.equals("Y") && p_episode_type.equals("E")))
					{
						CallableStatement call = 
						con.prepareCall("{ call BLOPIN.GET_BLNG_GRP_CLINIC_BILL_PRINT(?,?,?,?,?,?,?,?,?,?,?)}");			
						call.setString(1,strfacilityid);
						call.setString(2,strblnggrpid);
						call.setString(3,strcliniccode);
						call.registerOutParameter(4,java.sql.Types.VARCHAR);	
						call.registerOutParameter(5,java.sql.Types.VARCHAR);	
						call.registerOutParameter(6,java.sql.Types.VARCHAR);	
						call.registerOutParameter(7,java.sql.Types.VARCHAR);	
						call.registerOutParameter(8,java.sql.Types.VARCHAR);	
						call.registerOutParameter(9,java.sql.Types.VARCHAR);	
						call.registerOutParameter(10,java.sql.Types.VARCHAR);	
						call.registerOutParameter(11,java.sql.Types.VARCHAR);	

						call.execute();		

						strbillgenyn = call.getString(4);		
						strzerobillgenyn = call.getString(5);		
						strprintvisitbilltype = call.getString(6);		
						strprintzerobillcouponyn = call.getString(7);		
						strslmtyn	= call.getString(8);		
						strerrorlevel	= call.getString(9);		
						strsysmessageid	= call.getString(10);		
						strerrortext	= call.getString(11);		

						call.close();	

						if (strbillgenyn == null) strbillgenyn = "N";
						if (strzerobillgenyn == null ) strzerobillgenyn = "N";
						if (strprintvisitbilltype == null ) strprintvisitbilltype = "N";
						if (strslmtyn == null) strslmtyn = "N";
						if (strprintzerobillcouponyn == null ) strprintzerobillcouponyn = "N";
						if (strerrorlevel == null ) strerrorlevel = "";
						if (strsysmessageid == null ) strsysmessageid = "";
						if (strerrortext == null ) strerrortext ="";
						
						//Added for MMS-SCF-501.1
						if("[object]".equals(strblnggrpid) && "BL0195".equals(strsysmessageid)){
							strsysmessageid = "";
						}
						//Added for MMS-SCF-501.1
//						System.err.println("strbillgenynmain :"+ strbillgenyn);
						
						if (strunknownpatientyn.equals("Y") && strepitype.equals("E"))
						{
							//Karthik added to stop settlement window from being closed during Report Reprint
							if("Y".equals(billMaintain)) strslmtyn = "Y";
							else strslmtyn = "N";
						}
					}
					else
					{
						strslmtyn	= "Y";		
					}
				}
				catch(Exception e) 
				{        e.printStackTrace();
						out.println(e.toString());
				}
				if ( !(strsysmessageid.equals(""))  && p_episode_type.equals("O") )
				{	

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strsysmessageid));
            _bw.write(_wl_block12Bytes, _wl_block12);

				}

				if (!(strerrortext.equals(""))  && p_episode_type.equals("O")  )
				{

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strerrortext));
            _bw.write(_wl_block14Bytes, _wl_block14);

				}
						
//				System.err.println("strslmtyn check:"+strslmtyn);

				/*if ( strslmtyn.equals("N") && p_episode_type.equals("O") ) 
				{*/

            _bw.write(_wl_block15Bytes, _wl_block15);

				/*}
				else
				{*/	
					strwsno = strclientip;
					if (!(strwsno.equals("")))		   
					{
						CallableStatement call =null;
						try 
						{
							call = con.prepareCall("{ call BL_USER_CHECK_FOR_CASH_COUNTER (?,?,?,?,?,?,?)}");			
							call.setString(1,strfacilityid);
							call.setString(2,strepisodetype);//"O");//Karthikkkkkk
							call.setString(3,strloggeduser);
							call.setString(4,strwsno);
							call.registerOutParameter(5,java.sql.Types.VARCHAR); // Cash Counter
							call.registerOutParameter(6,java.sql.Types.VARCHAR); // shift
							call.registerOutParameter(7,java.sql.Types.VARCHAR); // Error code
							call.execute();				

							strcashcountercode	 = call.getString(5);
							strshiftid		 = call.getString(6);
							strsysmessageid	 = call.getString(7);		
	
							if ( strsysmessageid == null ) strsysmessageid = "";
							if ( strcashcountercode == null ) strcashcountercode = "";
							if ( strshiftid == null ) strshiftid = "";
						}
						catch(Exception e) 
						{   e.printStackTrace();
							out.println(e.toString()); 
						}finally{
							call.close();
						}
				
						if ( (strsysmessageid.equals("")))
						{	
							System.err.println("strsysmessageid11111"+strsysmessageid);	
						
					/*	try 
						{
							call = con.prepareCall("{ call blcommon.get_receipt_refund_check (?,?,?,?,?,?,?,?,?,?)}");			
							call.setString(1,strfacilityid);
							call.setString(2,strcashcountercode);
							call.registerOutParameter(3,java.sql.Types.VARCHAR);
							call.registerOutParameter(4,java.sql.Types.VARCHAR);
							call.registerOutParameter(5,java.sql.Types.VARCHAR);
							call.registerOutParameter(6,java.sql.Types.VARCHAR);
							call.registerOutParameter(7,java.sql.Types.VARCHAR);
							call.registerOutParameter(8,java.sql.Types.VARCHAR);
							call.registerOutParameter(9,java.sql.Types.VARCHAR);
							call.registerOutParameter(10,java.sql.Types.VARCHAR);
							call.execute();				

                            String g_rcpt_ip_allowed_yn= call.getString(3);
                            String g_rcpt_op_allowed_yn= call.getString(4);
                            String g_rcpt_ref_allowed_yn= call.getString(5);
                            String g_rfnd_ip_allowed_yn= call.getString(6);
                            String g_rfnd_op_allowed_yn= call.getString(7);
                            String g_rfnd_ref_allowed_yn= call.getString(8);
                            String p_error_id= call.getString(9);
                            String p_error_text= call.getString(10);	

                            if(strbillpayableamtFloat>0){
	                            if(g_rcpt_op_allowed_yn.equals("N") && (strepisodetype.equals("O") || strepisodetype.equals("E"))){
	                            	strsysmessageid="BL9652";
	                            }
	                            if(g_rcpt_ip_allowed_yn.equals("N") && (strepisodetype.equals("I") || strepisodetype.equals("D"))){
	                            	strsysmessageid="BL9653";
	                            }
	                            if(g_rcpt_ref_allowed_yn.equals("N") && strepisodetype.equals("R")){
	                            	strsysmessageid="BL9654";
	                            }
                            }else{
	                            if(g_rfnd_op_allowed_yn.equals("N") && (strepisodetype.equals("O") || strepisodetype.equals("E"))){
	                            	strsysmessageid="BL9655";
	                            }
	                            if(g_rfnd_ip_allowed_yn.equals("N") && (strepisodetype.equals("I") || strepisodetype.equals("D"))) {                 			
	                            	strsysmessageid="BL9656";
	                            }
	                            if(g_rfnd_ref_allowed_yn.equals("N") && strepisodetype.equals("R")){	             			
	                            	strsysmessageid="BL9657";
	                            }
                            }
                           // strsysmessageid="BL1024";
						
						}
						catch(Exception e) 
						{   e.printStackTrace();
							out.println(e.toString()); 
						}finally{
							call.close();
						}*/
						
						try 
						{
							call = con.prepareCall("{ call bl_bill_settlement_proc.get_rcpt_rfnd_privs(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");		
							call.setString(1,strfacilityid);
							call.setString(2,strloggeduser);
							call.setString(3,strcashcountercode);
							call.registerOutParameter(4,java.sql.Types.VARCHAR);
							call.registerOutParameter(5,java.sql.Types.VARCHAR);
							call.registerOutParameter(6,java.sql.Types.VARCHAR);
							call.registerOutParameter(7,java.sql.Types.VARCHAR);
							call.registerOutParameter(8,java.sql.Types.VARCHAR);
							call.registerOutParameter(9,java.sql.Types.VARCHAR);
							call.registerOutParameter(10,java.sql.Types.VARCHAR);
							call.registerOutParameter(11,java.sql.Types.VARCHAR);
							call.registerOutParameter(12,java.sql.Types.VARCHAR);
							call.registerOutParameter(13,java.sql.Types.NUMERIC);
							call.registerOutParameter(14,java.sql.Types.VARCHAR);
							call.execute();				

                            String p_rcpt_op_allowed_yn= call.getString(4);
                            String p_rcpt_ip_allowed_yn= call.getString(5);
                            String p_rcpt_ref_allowed_yn= call.getString(6);
							 String p_user_receipt_yn= call.getString(7);
                            String p_rfnd_op_allowed_yn= call.getString(8);
                            String p_rfnd_ip_allowed_yn= call.getString(9);
                            String p_rfnd_ref_allowed_yn= call.getString(10);
							String p_rfnd_receipt_yn= call.getString(11);
                            String p_error_id= call.getString(12);
                            int p_error_level= call.getInt(13);
                            String p_error_text= call.getString(14);
			    
			    for(BLBillDetailsBean beanObj:billDetailList ){
							
							  Double countVal;
							System.out.println("beanObj.getTotOutStdAmt()="+beanObj.getTotOutStdAmt());
							
							 countVal= Double.parseDouble(beanObj.getTotOutStdAmt());


							   if(countVal >0.00){
							   
                           System.err.println("strcashcountercode222"+beanObj.getEpisodeType().equals("O"));
							if(p_rcpt_op_allowed_yn.equals("N") && (beanObj.getEpisodeType().equals("O")||beanObj.getEpisodeType().equals("E"))){
							
	                            
	                            	strsysmessageid="BL9652";
	                            
								}
								if(p_rcpt_ip_allowed_yn.equals("N") &&(beanObj.getEpisodeType().equals("I")||beanObj.getEpisodeType().equals("D"))){
	                           
	                            	strsysmessageid="BL9653";
	                           
								}
								if(p_rcpt_ref_allowed_yn.equals("N") && beanObj.getEpisodeType().equals("R")){
	                            
	                            	strsysmessageid="BL9654";

								}
								if(p_user_receipt_yn.equals("N"))
								{
								strsysmessageid="BL1260";
								}
                           
							}
							
							
							else{
							if(p_rfnd_op_allowed_yn.equals("N") &&(beanObj.getEpisodeType().equals("O")||beanObj.getEpisodeType().equals("E"))){
	                            
	                            	strsysmessageid="BL9655";
	                            
								}
								if(p_rfnd_ip_allowed_yn.equals("N") &&(beanObj.getEpisodeType().equals("I")||beanObj.getEpisodeType().equals("D"))){
	                                    			
	                            	strsysmessageid="BL9656";
	                           
								}
								if(p_rfnd_ref_allowed_yn.equals("N") && beanObj.getEpisodeType().equals("R")){
	                           	             			
	                            	strsysmessageid="BL9657";
	                          
                            }
							if(p_rfnd_receipt_yn.equals("N"))
								{
								strsysmessageid="BL1261";
								}
						
						}
								
						
						}
					}	
						catch(Exception e) 
						{   e.printStackTrace();
							out.println(e.toString()); 
						}finally{
							call.close();
						}
					}
					}
					if ( !(strsysmessageid.equals("")))
					{	
	
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strsysmessageid));
            _bw.write(_wl_block17Bytes, _wl_block17);

					}
					else if (strerrortext.equals("") && !(strcashcountercode.equals("")))
					{    
						double billpayableamt = 0;	
						try
						{
							if(strbillpayableamt == null || strbillpayableamt.equals("")) strbillpayableamt="0";
							billpayableamt = Double.parseDouble(strbillpayableamt);
							if ( billpayableamt == 0)
							{	

            _bw.write(_wl_block18Bytes, _wl_block18);

							}
						}	
						catch(Exception e) 
						{   e.printStackTrace();
							System.out.println("smitha1="+e.toString());	
						}
						finally 
						{
							if (rs != null)   rs.close();
							if (pstmt != null) pstmt.close();		 	
						}	

						if("Y".equals(negative1))
						{	
						 try {
								 pstmt = con.prepareStatement("Select IBAEHIS.bl_bill_settlement_proc.get_outstanding_yn(?,?) outst from dual ");
								 pstmt.setString(1, strfacilityid);
								 pstmt.setString(2, strpatientid);
								   rs = pstmt.executeQuery();
								   if(rs != null && rs.next()){
									   retValue = rs.getString("outst");
								   }
								    con.commit();
							}
								   catch (SQLException e) {
									
									e.printStackTrace();
								}
							finally 
							{
								if (rs != null)   rs.close();
								if (pstmt != null) pstmt.close();		 	
							}
						
						if(retValue.equals("Y")){
						
            _bw.write(_wl_block19Bytes, _wl_block19);
		
						}
						}
						String rfnd_alwd_frm_ext_sys_only_yn="";

						try
						{		
							pstmt = con.prepareStatement( " select NVL(RFND_ALWD_FRM_EXT_SYS_ONLY_YN,'N'),nvl(dflt_cash_bill_slmt_amt,'N'),nvl(ext_account_interface_yn,'N') ext_acc_interface,UNAVAIL_PKG_BLNG_SERV_CODE from BL_PARAMETERS where operating_facility_id = ? ");
							
							pstmt.setString(1,strfacilityid);
							
							rs = pstmt.executeQuery();	
							if ( rs.next() && rs != null ) 
							{ 	
								 rfnd_alwd_frm_ext_sys_only_yn  =  rs.getString(1);
								 strdfltcashbillslmtamt =  rs.getString(2);
				 				 ext_acc_interface_yn =rs.getString(3);
				  				 unavail_service_code  =  rs.getString(4);
							}
						}
						catch(Exception e) 
						{   e.printStackTrace();
							out.println(e.toString());	
						}
						finally 
						{
							if (rs != null)   rs.close();
							if (pstmt != null) pstmt.close();		 	
						}	

						if ( rfnd_alwd_frm_ext_sys_only_yn == null || rfnd_alwd_frm_ext_sys_only_yn.equalsIgnoreCase("null")) 
						 rfnd_alwd_frm_ext_sys_only_yn = "N";
						if ( strdfltcashbillslmtamt == null) strdfltcashbillslmtamt = "";
						if ( ext_acc_interface_yn == null) ext_acc_interface_yn = "N";
						if(unavail_service_code == null) unavail_service_code="";


						if (rfnd_alwd_frm_ext_sys_only_yn.equals("Y") && billpayableamt < 0)
						{

            _bw.write(_wl_block20Bytes, _wl_block20);

						}
		CurrencyFormat cf = new CurrencyFormat();
		strbillpayableamt = cf.formatCurrency(strbillpayableamt, noofdecimal);		
		//Added for MMS-ME-SCF-0015 on 19-Aug-20 by Shikha
		userSettledAmountFloat +=  Float.parseFloat((userSettledAmount==null)?"0":userSettledAmount);
		if(fromBillGen == null || fromBillGen==""){
			userSettledAmount = Float.toString(userSettledAmountFloat);
		} else 			
			userSettledAmount = Float.toString(userSettledAmountFloat - totalExcemptedAmountFloat);
		//Ended for MMS-ME-SCF-0015 on 19-Aug-20 by Shikha
		userSettledAmount = cf.formatCurrency(userSettledAmount,noofdecimal);
		
		String partSettled = "N";
		if(userSettledAmount.equals(strbillpayableamt)){
			partSettled = "N";
		}
		else{
			partSettled = "Y";
		}

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(strbilldoctypecode));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strbilldocnum));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(userSettledAmount));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(strfacilityid));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(strloggeduser));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strpatientid));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(strepisodetype));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strepisodeid));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(strvisitid));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strencounterid));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(p_module_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(strslmtidno));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(strslmtpayername));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(strcashcountercode));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strblnggrpid));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strroundingamt));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(called_frm));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(alw_co_wit_bl_slmt_yn));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(cal_frm_multi_bil_slmt));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(strdfltcashbillslmtamt));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(ext_acc_interface_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(unavail_service_code));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(addlChargeAmtForBill ));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(partSettled ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(fromBillGen ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(strbilldoctypecode));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strbilldocnum));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strbillpayableamt));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(strfacilityid));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(strloggeduser));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strpatientid));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(strepisodetype));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strepisodeid));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(strvisitid));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strencounterid));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(p_module_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(strslmtidno));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(strslmtpayername));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(strcashcountercode));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strblnggrpid));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strroundingamt));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(called_frm));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(alw_co_wit_bl_slmt_yn));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(cal_frm_multi_bil_slmt));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(strdfltcashbillslmtamt));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(ext_acc_interface_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(unavail_service_code));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(strfacilityid ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(restrictEligibility ));
            _bw.write(_wl_block49Bytes, _wl_block49);
	
					}	
					else
					{

            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(strerrortext));
            _bw.write(_wl_block51Bytes, _wl_block51);

					}
				//}
				//ConnectionManager.returnConnection(con, request);		
			}	 
		}
		catch(Exception e)
		{   e.printStackTrace();
			System.out.println("main exception in blmain-"+e);
		}
		finally
		{
			if(pstmt != null)		pstmt.close();
			ConnectionManager.returnConnection(con, request);
		}

            _bw.write(_wl_block52Bytes, _wl_block52);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BILL_SLMT_DTL.label", java.lang.String .class,"key"));
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
}
