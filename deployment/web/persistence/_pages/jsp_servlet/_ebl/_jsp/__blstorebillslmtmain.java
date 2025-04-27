package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.BLReportIdMapper;
import java.sql.*;
import webbeans.eCommon.*;
import java.net.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __blstorebillslmtmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLStoreBillSlmtMain.jsp", 1736131738736L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No        Version              TFS              SCF/CRF           \t\tDeveloper Name\n-----------------------------------------------------------------------------------------------\n1            V210211           13526         MOHE-CRF-0060 \t              Shikha Seth\n -->\n\n\t";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<HTML>\n\t<HEAD>\n\t<TITLE> ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</TITLE>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<!--\t<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script>-->\n\t\t\t<script language=\"javascript\"src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\n\n\t\t\t<script>\n\t\t\t\tfunction callAsyncOnlinePrint(){\t\t\n\t\t\n\t\t\t\t\t\t\tvar xmlStr=\"<root><report/></root>\";\n\t\t\t\t\t\t\tvar xmlDoc = \"\" ;\n\t\t\t\t\t\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\t\t\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\t\t\t\txmlHttp.open(\"POST\",\"../../eBL/jsp/BLAdhocDiscOnlineReport.jsp\",true);\n\t\t\t\t\t\t\txmlHttp.send(xmlDoc);\t\n\t\t\t\t\t\t\t}\n\t\t</script>\n\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tparent.window.returnValue=\"N\";\n\t\t\t\t\t\twindow.close();\t\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t<script>\t\n\t\t\t\t\t\tparent.window.returnValue=\"N\";\n\t\t\t\t\t\twindow.close();\t\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\talert(getMessage(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\',\'BL\'));\n\t\t\t\t\t\t\t</script>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t   <script>\n\t\t\t\t\t\t  var strerrormessage = \'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\';\n\t\t\t\t\t\t  alert(strerrormessage);\n\t\t\t\t\t\t\tparent.window.returnValue=\"N\";\n\t\t\t\t\t\t  window.close();\t\n\t\t\t\t\t\t</script>\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tparent.window.returnValue=\"N\";\n\t\t\t\t\t\t\twindow.close();\t\n\t\t\t\t\t\t</script>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\talert(getMessage(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\',\'BL\'));\n\t\t\t\t\t\t\t\t\t\tparent.window.returnValue=\"N\";\n\t\t\t\t\t\t\t\t\t\twindow.close();\n\t\t\t\t\t\t\t\t</script>\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\t\t\t\t\t\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tparent.window.returnValue=\"N\";\n\t\t\t\t\t\t\twindow.close();\n\t\t\t\t\t\t</script>\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\talert(getMessage(\"BL6420\",\"BL\"));\n\t\t\t\t\t\tparent.window.returnValue=\"N\";\n\t\t\t\t\t\twindow.close();\t\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\t\n\n\t\t\n\t\t</HEAD>\n\t \n\t\t<FRAMESET framespacing=\"0\" frameborder=\"0\" ROWS=\"6%,9%,10%,3%,0%\"  align = \"center\">\n\t\t\t<FRAME SRC= \"../../eBL/jsp/BLBillSlmtDet.jsp?billdoctypecode=";
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

    private final static java.lang.String  _wl_block30 ="&slmtidno=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&slmtpayername=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&cashcounter=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&strmoduleid=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&strfunctionid=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&strroundingamt=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="&dfltcashbillslmtamt=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&ext_acc_interface_yn=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&unavail_service_code=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&billAlreadyPrinted=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&encounterFacilityId=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" NAME=\"BillSlmtEntryFrame\" frameborder=0 noresize scrolling=\'no\'> <!-- V210211-->\n\t\t\t\n\t\t\t<FRAME SRC=\"../../eCommon/html/blank.html\"\t  name=\"BillSlmtServiceFrame\" id=\"BillSlmtServiceFrame\" frameborder=0 noresize scrolling=\'no\'>\t\n\t\t\t\n\t\t\t<FRAME SRC=\"../../eBL/jsp/BLBillSlmtType.jsp?billdoctypecode=";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="&strblnggrpid=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="&encounterFacilityId=";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"\t  NAME=\"BillSlmtTypeFrame\" frameborder=0 noresize scrolling=\'no\'> <!-- V210211-->\n\t\t\t\n\t\t\t<FRAME SRC=\"../../eCommon/html/blank.html\"\t  name=\"BillSlmtTypeBtnFrame\" id=\"BillSlmtTypeBtnFrame\" frameborder=0 noresize scrolling=\'no\'>\t\t\n\t\t\t\t<FRAME SRC=\"../../eCommon/html/blank.html\"\t  name=\"BillSlmtSubmitFrame\" id=\"BillSlmtSubmitFrame\" frameborder=0 noresize scrolling=\'no\'>\t\t\n\t\t\t<FRAME SRC=\"../../eCommon/html/blank.html\"\t  name=\"BillSlmtConfirmFrame\" id=\"BillSlmtConfirmFrame\" frameborder=0 noresize scrolling=\'no\'>\t\t\n\t\t\t<!--<FRAME SRC=\'../../eCommon/jsp/error.jsp\' name=\"BillSlmtValidationFrame\" id=\"BillSlmtValidationFrame\" frameborder=0 noresize scrolling=\'no\'>\n\t\t\t\n\t\t\t<FRAME SRC=\'../../eBL/jsp/BLBillSlmtConfirm.jsp?billdoctypecode=";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' NAME=\"BillSlmtToolBarFrame\" frameborder=0 noresize scrolling=\'no\'>-->\n\n\t\t</FRAMESET>\t\n\n\t\t\t\t\n\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t   <script>\n\t\t\t\t\t\t\t\t\t  var strerrormessage = \'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\';\n\t\t\t\t\t\t\t\t\t  alert(strerrormessage);\n\t\t\t\t\t\tparent.window.returnValue=\"N\";\n\t\t\t\t\t\t\t\t\t  window.close();\t\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t</HTML>\n\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

			String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CallableStatement  call  = null;
		int  blprintVal =0;
		HashMap<String,String> asyncPrinterAttrib=new HashMap<String,String> (); 
		Boolean Slysite=false;
		String Slysite_spec ="";
		CallableStatement cstmt = null;//KDAH-CRF-0546		

		try
		{
			request.setCharacterEncoding("UTF-8");
			con	=	ConnectionManager.getConnection(request);

			try
			{
				Slysite = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BILL_PRINT_NOT_REQD");				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if(Slysite){
				Slysite_spec="Y";
			}
			else{
				Slysite_spec="N";
			}
			String str_ordering_facility_id = request.getParameter("ordering_facility_id"); //V210211
			String strbilldoctypecode         = request.getParameter("billdoctypecode");
			String strbilldocnum              = request.getParameter("billdocnum");	
			String strstorecode              = request.getParameter("storecode");
			String strmoduleid              = request.getParameter("module_id");	
			String strfunctionid              = request.getParameter("function_id");	
			String bill_print_reqd              ="";	
			if (strmoduleid == null || strmoduleid.equalsIgnoreCase("null")) 
			{	strmoduleid = ""; }
			if (strfunctionid == null || strfunctionid.equalsIgnoreCase("null")) 
			{	strfunctionid = ""; }

			String strslmtidno		= "";
			String strslmtpayername = "";	
	//		String strepitype   = "";
	//		String strpatid		    = "";

			String strdfltcashbillslmtamt = "", ext_acc_interface_yn="";
			String unavail_service_code="";	

			String str_bill_prt_format_vals ="";
			String bill_print_format_enabled_yn ="";
			String strMpiId = "";
			String strBlrblprt = "";	
			
			String billAlreadyPrinted = request.getParameter("billAlreadyPrinted");
			if(billAlreadyPrinted == null) billAlreadyPrinted="N";

			if (strbilldoctypecode == null || strbilldoctypecode.equals(" ") || strbilldoctypecode.equalsIgnoreCase("null")) 
			{	strbilldoctypecode = ""; }
			if (strbilldocnum == null || strbilldocnum.equals(" ") || strbilldocnum.equalsIgnoreCase("null")) 
			{strbilldocnum = "";}		
			if (strstorecode == null || strstorecode.equalsIgnoreCase("null")) 
			{strstorecode = "**";}		

			if (strbilldoctypecode.equals(""))
			{
				
            _bw.write(_wl_block10Bytes, _wl_block10);

			}
			else
			{	
		
				String strfacilityid = ""; 
				String strloggeduser = "";			
				String strbillpayableamt = "";
				String strblnggrpid	= "";		
				String strwsno = "";
				String strcashcountercode = "";
				String strshiftid	= "";
				String strsysmessageid = "";
				String strerrortext = "";
				String strpatientid ="";
				String strepisodetype = "";
				String strepisodeid = "";
				String strvisitid ="";
				String strprintvisitbilltype ="";
				String strprintzerobillcouponyn = "";
				String strbillgenyn				= "";
				String strzerobillgenyn			= "",strroundingamt="";
				String strslmtyn = "Y";
				String strerrorlevel = "";		
				int noofdecimal = 2;

			
				

				strfacilityid	=  (String) session.getValue("facility_id");
				strloggeduser	=  (String) session.getValue("login_user");			
				
				strblnggrpid		=  request.getParameter("blnggrp");	


				HttpSession httpSession = request.getSession(false);
				Properties p = (Properties)httpSession.getValue("jdbc");
				String locale	= (String)session.getAttribute("LOCALE");

				String strclientip = p.getProperty("client_ip_address");		

				if (strblnggrpid == null || strblnggrpid.equalsIgnoreCase("null")) 
				{strblnggrpid = "";}		

			/*
			try
			{		
				pstmt = con.prepareStatement( " select distinct store_code from bl_patient_charges_interface where operating_facility_id = '" + strfacilityid + "' and trx_doc_ref in ( select trx_doc_ref from bl_patient_charges_folio where operating_facility_id = '" + strfacilityid + "' and bill_doc_type_code= '" + strbilldoctypecode + "' and bill_doc_num = '" + strbilldocnum + ")'");
					
				rs = pstmt.executeQuery();	
				if ( rs.next() && rs != null ) 
				{ 	
					 strstorecode  =  rs.getString(1); 				 
				}
			}
			catch(Exception e) 
				{out.println(e.toString());	}

			finally 
			{
				if (rs != null)   rs.close();
				if (pstmt != null) pstmt.close();		 	
			}	

			if ( strstorecode == null || strstorecode.equalsIgnoreCase("null")) 
				 strstorecode = "**";
			 */

		
			try
				{	
					
						 call = 
						con.prepareCall("{ call BLOPIN.GET_BLNG_GRP_STORE_BILL_PRINT(?,?,?,?,?,?,?,?,?,?,?)}");			
						call.setString(1,strfacilityid);
						call.setString(2,strblnggrpid);
						call.setString(3,strstorecode);
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
						
				}	
				catch(Exception e) 
				{
					e.printStackTrace();
					//out.println(e.toString());
				}
			 
				double billpayableamt = 0;	
				double strtotInsamt =0 ;
				//Added for EMER 5320
				String billNatureCode = "";
				try
				{	
					//pstmt = con.prepareStatement( " select nvl(bill_tot_outst_amt,0), nvl(bill_tot_outst_amt,0), patient_id,episode_type,episode_id,visit_id , nvl(BILL_ROUNDING_AMT,0),mpi_id,bill_nature_code from bl_bill_hdr where operating_facility_id = '" + strfacilityid + "' and doc_type_code= '" + strbilldoctypecode + "' and doc_num = '" + strbilldocnum + "'"); //V210211 commented
					pstmt = con.prepareStatement( " select nvl(bill_tot_outst_amt,0), nvl(bill_tot_outst_amt,0), patient_id,episode_type,episode_id,visit_id , nvl(BILL_ROUNDING_AMT,0),mpi_id,bill_nature_code from bl_bill_hdr where operating_facility_id = ? and doc_type_code= ? and doc_num = ? "); //V210211  
					
					pstmt.setString(1,str_ordering_facility_id);
					pstmt.setString(2,strbilldoctypecode);
					pstmt.setString(3,strbilldocnum);
					rs = pstmt.executeQuery();	
					if ( rs.next() && rs != null ) 
					{
						strbillpayableamt =  rs.getString(1);			
						strpatientid =  rs.getString(3);			
						strepisodetype =  rs.getString(4);			
						strepisodeid =  rs.getString(5);			
						strvisitid =  rs.getString(6);			
						strroundingamt = rs.getString(7);
						strMpiId = rs.getString(8);	
						//Added for EMER 5320
						billNatureCode = rs.getString("bill_nature_code");	
								
						if(billNatureCode == null || "null".equals(billNatureCode)){
							billNatureCode = "";
						}
	//					System.err.println("strbillpayableamt in store main:"+strbillpayableamt);
	//					System.err.println("strroundingamt:"+strroundingamt);
						
					}
				}catch(Exception e){
				}finally{
					if(rs !=null) rs.close();
					if(pstmt != null) pstmt.close();
				}

				//Added for EMER 5320
				if(!"C".equals(billNatureCode))
				{
				
            _bw.write(_wl_block11Bytes, _wl_block11);

				}
				//Added for EMER 5320
					
					if(strbillpayableamt == null || strbillpayableamt.equals("")) strbillpayableamt="0";
			
				if ( !(strsysmessageid.equals("")))
				{	
					   /*try
						{			
							CallableStatement call = 
							con.prepareCall("{ ? = call  blcommon.get_error_text(?)}");	
							call.registerOutParameter(1,java.sql.Types.VARCHAR);
							call.setString(2,strsysmessageid);
							call.execute();				
							strerrortext = call.getString(1);			
							call.close();	
							if ( strerrortext == null ) strerrortext = "";
						}
						catch(Exception e)
							{out.println(e.toString()); }*/
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strsysmessageid));
            _bw.write(_wl_block13Bytes, _wl_block13);

				}

					if (!(strerrortext.equals("")))
					{
	
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strerrortext));
            _bw.write(_wl_block15Bytes, _wl_block15);

					}

					if ( strslmtyn.equals("N") ) 
					{
	
            _bw.write(_wl_block16Bytes, _wl_block16);

					}
					else
					{	
						strwsno = strclientip;

						if (!(strwsno.equals("")))		   
						{
							try {
									 call = 
									con.prepareCall(
									"{ call BL_USER_CHECK_FOR_CASH_COUNTER (?,?,?,?,?,?,?)}");			
									call.setString(1,strfacilityid);
									call.setString(2,"O");
									call.setString(3,strloggeduser);
									call.setString(4,strwsno);
									call.registerOutParameter(5,java.sql.Types.VARCHAR); // Cash Counter
									call.registerOutParameter(6,java.sql.Types.VARCHAR); // shift
									call.registerOutParameter(7,java.sql.Types.VARCHAR); // Error code
									call.execute();				

									strcashcountercode	 = call.getString(5);
									strshiftid		 = call.getString(6);
									strsysmessageid	 = call.getString(7);		
									call.close();	
									if ( strsysmessageid == null ) strsysmessageid = "";
									if ( strcashcountercode == null ) strcashcountercode = "";
									if ( strshiftid == null ) strshiftid = "";

	//								System.out.println("strcashcountercode main @@:"+strcashcountercode);
							}
							catch(Exception e) 
							{
								e.printStackTrace();
								//out.println(e.toString()); 
								}
							
							/* Added by Karthik for MMS-MD-SCF-0006 [IN:060039] 4/28/2016 Starts*/
							billpayableamt = 0;	
							if(strbillpayableamt == null || strbillpayableamt.equals("")) strbillpayableamt="0";
							billpayableamt = Double.parseDouble(strbillpayableamt);
							
							if(strsysmessageid.equals("")){
							try 
							{
								System.out.println("{ call Pharmacy blcommon.get_receipt_refund_check (?,?,?,?,?,?,?,?,?,?)}");
								call = con.prepareCall("{  call blcommon.get_receipt_refund_check (?,?,?,?,?,?,?,?,?,?)}");			
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
								
							
								if(billpayableamt>0){
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
		

							}
							catch(Exception e) 
							{   e.printStackTrace();
								//out.println(e.toString()); 
							}finally{
								call.close();
							}
							}
							
							if(strsysmessageid.equals("")){
								if(billpayableamt<0){
										try 
										{ 
											System.out.println("{ call Pharmacy blcommon.check_for_refund (?,?,?,?,?,?)}");
											call = con.prepareCall("{ call blcommon.check_for_refund (?,?,?,?,?,?)}");								
											call.setString(1,strloggeduser);
											call.setString(2,strfacilityid);
											call.setString(3,strcashcountercode);
											call.registerOutParameter(4,java.sql.Types.VARCHAR);
											call.registerOutParameter(5,java.sql.Types.VARCHAR);
											call.registerOutParameter(6,java.sql.Types.VARCHAR);
											call.execute();				
				
											String cash_counter_refund_allowed_yn = call.getString(4);
											String p_error_id= call.getString(5);
											String p_error_text= call.getString(6);                            
											
												if(cash_counter_refund_allowed_yn.equals("N")){
													strsysmessageid="BL1261";
												}
				
										}
										catch(Exception e) 
										{   e.printStackTrace();
											//out.println(e.toString()); 
										}finally{
											call.close();
										}
								}
							}
							
							
							if(strsysmessageid.equals("")){
								if(billpayableamt>0){
										try 
										{
											System.out.println("{ call Pharmacy blcommon.check_for_receipt (?,?,?,?,?,?)}");
											call = con.prepareCall("{ call blcommon.check_for_receipt (?,?,?,?,?,?)}");								
											call.setString(1,strloggeduser);
											call.setString(2,strfacilityid);
											call.setString(3,strcashcountercode);
											call.registerOutParameter(4,java.sql.Types.VARCHAR);
											call.registerOutParameter(5,java.sql.Types.VARCHAR);
											call.registerOutParameter(6,java.sql.Types.VARCHAR);
											call.execute();				
				
											String cash_counter_receipt_allowed_yn = call.getString(4);
											String p_error_id= call.getString(5);
											String p_error_text= call.getString(6);                            
											
												if(cash_counter_receipt_allowed_yn.equals("N")){
													strsysmessageid="BL1260";
												}
				
										}
										catch(Exception e) 
										{   e.printStackTrace();
											//out.println(e.toString()); 
										}finally{
											call.close();
										}
								}
							}						
						//Added by Gayathri V180702/GHL-SCF-1355
							
							if(strsysmessageid.equals("")){
							if(billpayableamt<0){
									try 
									{
										System.out.println("{ call blcommon.check_opening_balance (?,?,?,?,?,?)}");
										call = con.prepareCall("{ call blcommon.check_opening_balance (?,?,?,?,?,?,?)}");								
										
										call.setString(1,strfacilityid);
										call.setString(2,strcashcountercode);
										call.setString(3,strloggeduser);
										call.setString(4,strbilldoctypecode);
										call.setString(5,strbilldocnum);
										
										call.registerOutParameter(6,java.sql.Types.VARCHAR);
										call.registerOutParameter(7,java.sql.Types.VARCHAR);
										
										call.execute();				
			
			                         
			                            String p_error_id= call.getString(6);
			                            String p_error_text= call.getString(7);                            
										
			                               if(("BL1271").equals(p_error_id)){
				                            	strsysmessageid="BL1271";
				                            }
			
									}
									catch(Exception e) 
									{   e.printStackTrace();
										//out.println(e.toString()); 
									}finally{
										call.close();
									}
							}
						}
												
							/* Added by Karthik for MMS-MD-SCF-0006 [IN:060039] 4/28/2016 ends*/
				   
						}

						if ( !(strsysmessageid.equals("")))
						{	
							   //commented by ram 25/07/2007
							   /*try
								{			
									CallableStatement call = 
									con.prepareCall("{ ? = call  blcommon.get_error_text(?)}");	
									call.registerOutParameter(1,java.sql.Types.VARCHAR);
									call.setString(2,strsysmessageid);
									call.execute();				
									strerrortext = call.getString(1);			
									call.close();	
									if ( strerrortext == null ) strerrortext = "";
								}
								catch(Exception e)
									{out.println(e.toString()); }*/
	
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strsysmessageid));
            _bw.write(_wl_block18Bytes, _wl_block18);

						}
						else{
							if (strerrortext.equals("") && !(strcashcountercode.equals("")))
							{    
								/*try
								{		
									pstmt = con.prepareStatement( " select nvl(bill_tot_outst_amt,0), nvl(bill_tot_outst_amt,0), patient_id,episode_type,episode_id,visit_id  from bl_bill_hdr where operating_facility_id = '" + strfacilityid + "' and doc_type_code= '" + strbilldoctypecode + "' and doc_num = '" + strbilldocnum + "'");
					
									rs = pstmt.executeQuery();	
									if ( rs.next() && rs != null ) 
									{
										strbillpayableamt =  rs.getString(1);			
										strpatientid =  rs.getString(3);			
										strepisodetype =  rs.getString(4);			
										strepisodeid =  rs.getString(5);			
										strvisitid =  rs.getString(6);			
									}								
								}
								catch(Exception e) 
										{System.out.println("smitha1="+e.toString());	
										}

								finally 
								{
									if (rs != null)   rs.close();
									if (pstmt != null) pstmt.close();		 	
								}	*/

								try{
									
									//pstmt = con.prepareStatement( " select nvl(bill_tot_outst_amt,0)   from bl_bill_hdr where operating_facility_id = '" + strfacilityid + "' and mpi_id= '" + strMpiId + "' and mpi_ind = 'I'"); //V210211 COMMENTED
									pstmt = con.prepareStatement( " select nvl(bill_tot_outst_amt,0)   from bl_bill_hdr where operating_facility_id = ? and mpi_id= ? and mpi_ind = 'I'"); //V210211 
									
									pstmt.setString(1,str_ordering_facility_id);
									pstmt.setString(2,strMpiId);
									rs = pstmt.executeQuery();	
									if ( rs.next() && rs != null ) 
									{
										strtotInsamt = Double.parseDouble(rs.getString(1));
									}
									
								
									
									
	//								If((p_slmt_yn = 'Y') and (NVL (l_tot_bill_amt, 0) <> 0  or NVL(l_tot_bill_insu_amt,0) <>0)
		//							or((p_print_zero_bill_yn,'N')  = 'Y'   And (NVL (l_tot_bill_amt, 0) = 0  or NVL(l_tot_bill_insu_amt,0) =0)

							//		||(strprintzerobillcouponyn.equals("Y") && (strtotInsamt == 0 || billpayableamt == 0 ))	
																									
			


							
								/*if ((strslmtyn.equals("Y") && (strtotInsamt != 0 || billpayableamt != 0 ))
							||(strprintzerobillcouponyn.equals("Y") && (strtotInsamt == 0 || billpayableamt == 0 )))*/
							
							billpayableamt = Double.parseDouble(strbillpayableamt);
							if ( !(strslmtyn.equals("Y") && (billpayableamt != 0)) && strprintzerobillcouponyn.equals("Y")) 
									{
					
								if(!strbilldoctypecode.equals("") && !strbilldocnum.equals("")&& strzerobillgenyn.equals("Y"))
											{
							
										ResultSet  rstMt =  null;
										PreparedStatement pstmtRpt = null;
										strBlrblprt  ="BLRBLPRT";
							
											try
												{
											
												String qryStmt="select NVL(report_id,'BLRBLPRT'),BILL_PRINT_FORMAT_ENABLED_YN  from  bl_bill_reports a , bl_parameters b where  b.OPERATING_FACILITY_ID = '"+strfacilityid+"'   AND a.operating_facility_id (+) = b.operating_facility_id  AND bill_type (+) = 'PH-BILL'";
												
												
													pstmtRpt = con.prepareStatement(qryStmt);							
													rstMt = pstmtRpt.executeQuery();
													 while (rstMt!=null && rstMt.next())
													{	
													strBlrblprt  =  rstMt.getString(1);
													bill_print_format_enabled_yn=  rstMt.getString(2);
													}					

											//		System.err.println("eBL  BLAdhocDiscSubmit   strBlrblprt "+strBlrblprt);
												}catch(Exception ee)
										{
													ee.printStackTrace();
											strBlrblprt  ="BLRBLPRT";			
										}
											finally
										{
													try
											{
												  if(rstMt != null)  rstMt.close();	
												  if (pstmtRpt !=null) pstmtRpt.close();
											}catch(Exception ee1) {}							 

										}
										
							//Added By Vijay For MMS-CRF-0208
										
								try{
									strBlrblprt=BLReportIdMapper.getReportId(con, locale,strBlrblprt, strfacilityid); //Added strfacilityid by subha for MMS-DM-CRF-131.1
									System.out.println(" BLStoreBillSlmtMain for Report ID "+strBlrblprt);
									
								}catch(Exception e)
								{
									e.printStackTrace();
									System.err.println("Exception in BLStoreBillSlmtMain for reportID "+e);
								}									
										
										
						//Added below code for GST-GHL-CRF-0477
						String gstApplicableYN = "N";
						String printOrientation = "P";
						try{
							pstmtRpt = con.prepareStatement("Select bladdlchg.is_gst_applicable_yn('BL', 'BL_BILL_PRINT_ORIENTATION') gst_applicable from dual");
							rstMt = pstmtRpt.executeQuery();
							if(rstMt != null && rstMt.next()){
								gstApplicableYN = rstMt.getString("gst_applicable");
							}
							
						if("Y".equals(gstApplicableYN)){
							//ADDED FOR KDAH-CRF-0546
							try{ 				
									cstmt = con.prepareCall("{ call BLCOMMON.get_report_id_for_3t(?,?,?,?) }");
									cstmt.setString(1,strfacilityid);
									cstmt.setString(2,strepisodetype);				
									cstmt.registerOutParameter(3,java.sql.Types.VARCHAR);
									cstmt.registerOutParameter(4,java.sql.Types.VARCHAR);
										cstmt.execute();
										printOrientation = cstmt.getString(3);
										strBlrblprt = cstmt.getString(4);
										System.out.println("661-->printOrientation==>"+printOrientation);
										System.out.println("662-->strBlrblprt==>"+strBlrblprt);		
								}
								catch(Exception e){
									printOrientation = "P";
									System.err.println("Exception in getting BLStoreBillSlmtMain.jsp, 1"+e);
									e.printStackTrace();
								}
								finally{
									try
									{
										if (cstmt !=null) cstmt.close();
									}
									catch(Exception ee1) 
									{
										System.err.println("Exception in getting BLStoreBillSlmtMain.jsp, 2"+ee1);
										ee1.printStackTrace();
									}
								}
							//ADDED FOR KDAH-CRF-0546
							/*String printOrientationSql = "Select NVL (default_bill_print_orientation, 'P') default_bill_print_orientation "+
														"FROM bl_parameters "+
														"WHERE operating_facility_id = ?";
							
							pstmtRpt = con.prepareStatement(printOrientationSql);
							pstmtRpt.setString(1, strfacilityid);
							rstMt = pstmtRpt.executeQuery();
							
							if(rstMt != null && rstMt.next()){
								printOrientation = rstMt.getString("default_bill_print_orientation");
							}*/
													
							}
						}
						catch(Exception e){
							printOrientation = "P";
							System.err.println("Exception in getting printOrientation, 1"+e);
							e.printStackTrace();
						}
						finally{
							try
							{
								if(rstMt != null)  rstMt.close();	
								if (pstmtRpt !=null) pstmtRpt.close();
							}
							catch(Exception ee1) 
							{
								System.err.println("Exception in getting printOrientation, 2"+ee1);
								ee1.printStackTrace();
							}
						}
						if(("L".equals(printOrientation)) 
								&& ("BLRBLPRT".equals(strBlrblprt) || "BLRBLPRT_PH".equals(strBlrblprt))){
							strBlrblprt = "BLRBLPRL";
						}
						//Added below code for GST-GHL-CRF-0477

						}

					try{
							call = con.prepareCall("{ call blopin.CALL_BILL_PRINT_FRM_SLMT_NEW(?,?,?,?,?,?)}");			
							call.setString(1,strfacilityid);
							call.setString(2,strbilldoctypecode);
							call.setString(3,strbilldocnum);
							call.setString(4,locale);
							call.registerOutParameter(5,java.sql.Types.VARCHAR);	
							call.registerOutParameter(6,java.sql.Types.VARCHAR);	
							call.execute();	
							str_bill_prt_format_vals = call.getString(5);								
							strerrortext     	 = call.getString(6);				
									
							}
							catch (Exception e)
							{
								e.printStackTrace();
								System.err.println("Error while wexecuting CALL_BILL_PRINT_FRM_SLMT_NEW:"+e);
							}
							
							if(str_bill_prt_format_vals==null || str_bill_prt_format_vals.equals("")) str_bill_prt_format_vals="";
							
							if ( strerrortext == null ) strerrortext ="";
							
						
						if(bill_print_format_enabled_yn.equals("Y") && !str_bill_prt_format_vals.equals("") && strerrortext.equals(""))
						{
							
							/* Code commented by Karthik to move the Online Print module to asyncronous mode by Providing ajax Call*/
							int docNum = 0;
							if("Y".equals(Slysite_spec)){
							
								try{
								pstmt = con.prepareStatement("Select blopin.op_visit_bill_print_reqd(?,?,?)  from dual ");
								docNum = Integer.parseInt(strbilldocnum);
								pstmt.setString(1,strfacilityid);							
								pstmt.setString (2,strbilldoctypecode);
								pstmt.setInt(3,docNum);
								  rs = pstmt.executeQuery();
								 if(rs != null && rs.next()){
									 bill_print_reqd = rs.getString(1);
								   }
								 if("Y".equals(bill_print_reqd) && !"Y".equals(billAlreadyPrinted)) {
									System.err.println("asyncPrinterAttrib 1st Place->");
									asyncPrinterAttrib = new HashMap<String,String>();
									asyncPrinterAttrib.put(str_bill_prt_format_vals+"/"+(blprintVal++), strBlrblprt);
									System.err.println("asyncPrinterAttrib 1st Place->"+asyncPrinterAttrib);
									session.setAttribute("ASYNC_PRINTER_ATTRIB", asyncPrinterAttrib);
									out.println("<script>callAsyncOnlinePrint();</script>");
								}
								}
								 catch (SQLException e) {
										e.printStackTrace();
									}
							}
							else{
							asyncPrinterAttrib = new HashMap<String,String>();
							asyncPrinterAttrib.put(str_bill_prt_format_vals+"/"+(blprintVal++), strBlrblprt);
							session.setAttribute("ASYNC_PRINTER_ATTRIB", asyncPrinterAttrib);
							out.println("<script>callAsyncOnlinePrint();</script>");
							}						
						}	
						}								
						if ( billpayableamt == 0)
						{	
	
            _bw.write(_wl_block19Bytes, _wl_block19);

						return;
							}
						}
						catch(Exception e) {
							e.printStackTrace();
							System.out.println("2="+e.toString());}

						finally 
						{
							 if (rs != null)   rs.close();
							 if (pstmt != null) pstmt.close();		 	
						}	
								
							
			/**************added by ram 17311 28-dec-2009********************/	
			String rfnd_alwd_frm_ext_sys_only_yn="";
			try
			{		
				pstmt = con.prepareStatement( " select NVL(RFND_ALWD_FRM_EXT_SYS_ONLY_YN,'N'),nvl(dflt_cash_bill_slmt_amt,'N'),nvl(ext_account_interface_yn,'N') ext_acc_interface,UNAVAIL_PKG_BLNG_SERV_CODE from BL_PARAMETERS where operating_facility_id = '" + strfacilityid + "' ");
					
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
				{
				e.printStackTrace();
				//out.println(e.toString());	
				}

			finally 
			{
				if (rs != null)   rs.close();
				if (pstmt != null) pstmt.close();		 	
			}	
//						System.err.println("rfnd_alwd_frm_ext_sys_only_yn:"+rfnd_alwd_frm_ext_sys_only_yn);
			if ( rfnd_alwd_frm_ext_sys_only_yn == null || rfnd_alwd_frm_ext_sys_only_yn.equalsIgnoreCase("null")) 
				 rfnd_alwd_frm_ext_sys_only_yn = "N";
			if ( strdfltcashbillslmtamt == null) strdfltcashbillslmtamt = "";
			if ( ext_acc_interface_yn == null) ext_acc_interface_yn = "N";
			if(unavail_service_code == null) unavail_service_code="";

			if (rfnd_alwd_frm_ext_sys_only_yn.equals("Y") && billpayableamt < 0)
			{
				
            _bw.write(_wl_block20Bytes, _wl_block20);

			}
			 
		/**************ram End ********************/	

				try
				{		
//								pstmt = con.prepareStatement( " select national_id_num, SUBSTR(SHORT_NAME,1,40) from  mp_patient_mast where patient_id ='" + strpatientid + "'");							
					//pstmt = con.prepareStatement( " SELECT NATIONAL_ID_NO, SUBSTR(PATIENT_NAME,1,40) FROM MP_PATIENT WHERE PATIENT_ID ='" + strpatientid + "'");							
					pstmt = con.prepareStatement( " SELECT NATIONAL_ID_NO, PATIENT_NAME FROM MP_PATIENT WHERE PATIENT_ID ='" + strpatientid + "'");
					rs = pstmt.executeQuery();	
					if ( rs.next() && rs != null ) 
					{
						strslmtidno  =   rs.getString(1);			
						strslmtpayername =  rs.getString(2);			
					}
					else
					{
						strslmtidno  =  "";
						strslmtpayername = "";
					}
						if ( strslmtidno == null ) strslmtidno = "";
						if ( strslmtpayername == null ) strslmtpayername = "";
					
				}
				catch(Exception e) {
					e.printStackTrace();
					System.out.println("3="+e.toString());}

				finally 
				{
					if (rs != null)   rs.close();
					if (pstmt != null) pstmt.close();		 		
				}	

				try
				{		
					pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
					
					rs = pstmt.executeQuery();	
					if ( rs.next() && rs != null ) 
						noofdecimal  =  rs.getInt(1);			
				}
				catch(Exception e) {
					e.printStackTrace();
					System.out.println("4="+e.toString());}

				finally 
				{
					if (rs != null)   rs.close();
					if (pstmt != null) pstmt.close();		 		
				}	


				CurrencyFormat cf = new CurrencyFormat();
				strbillpayableamt =(String) cf.formatCurrency(strbillpayableamt, noofdecimal);	

            _bw.write(_wl_block21Bytes, _wl_block21);
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
            out.print( String.valueOf(strslmtidno));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strslmtpayername));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(strcashcountercode));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(strmoduleid));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(strfunctionid));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strroundingamt));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strdfltcashbillslmtamt));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(ext_acc_interface_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(unavail_service_code));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(billAlreadyPrinted ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(str_ordering_facility_id ));
            _bw.write(_wl_block41Bytes, _wl_block41);
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
            out.print( String.valueOf(strslmtidno));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strslmtpayername));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(strcashcountercode));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(strblnggrpid));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(strmoduleid));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(strfunctionid));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(strroundingamt));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strdfltcashbillslmtamt));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(ext_acc_interface_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(unavail_service_code));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(str_ordering_facility_id ));
            _bw.write(_wl_block44Bytes, _wl_block44);
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
            out.print( String.valueOf(strslmtidno));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strslmtpayername));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(strcashcountercode));
            _bw.write(_wl_block45Bytes, _wl_block45);
	
							}	
							else
							{
								
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(strerrortext));
            _bw.write(_wl_block47Bytes, _wl_block47);

							}
						}

				}
				ConnectionManager.returnConnection(con, request);		
			}	 
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("main exception in blmain-"+e);
		}
		finally
		{
			ConnectionManager.returnConnection(con, request);
		}
		
            _bw.write(_wl_block48Bytes, _wl_block48);
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
