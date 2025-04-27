package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eBL.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __blcalldiscorslmtpage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLCallDiscOrSlmtPage.jsp", 1726148544157L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No        Version              TFS              SCF/CRF           \t\tDeveloper Name\n-----------------------------------------------------------------------------------------------\n1            V210211           13526         MOHE-CRF-0060 \t              Shikha Seth\n -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<script language=\'javascript\'>\n/*\n\tfunction callAdhocDiscFun()\n\t{\n\t\tvar patient_id = document.forms[0].patient_id.value;\n\t\tvar episode_type = document.forms[0].episode_type.value;\n\t\tvar episode_id = document.forms[0].episode_id.value;\n\t\tvar visit_id = document.forms[0].visit_id.value;\n\t\tvar encounter_id = document.forms[0].encounter_id.value;\n\t\tvar module_id = document.forms[0].module_id.value;\n\n\t\tvar dialogHeight    = \'40\' ;  \n\t\tvar dialogWidth = \'70\' ; \n\t\tvar dialogTop = \'100\' ;  \n\t\tvar center    = \'1\'  ;  \n\t\tvar arguments =   \'\'; \n\t\tvar features    = \'dialogHeight:\' + dialogHeight + \'; dialogWidth:\' + dialogWidth +\'; center:\' + center +\'; dialogTop:\' + dialogTop +\'; status=no;\' ; \n\t\tvar getUrl  =   \"../../eBL/jsp/BLAdhocDiscFrame.jsp?patient_id=\"+patient_id+\"&episode_type=\"+episode_type+\"&episode_id=\"+episode_id+\"&visit_id=\"+visit_id+\"&encounter_id=\"+encounter_id+\"&module_id=\"+module_id+\"&called_frm=OTH_MOD\";\n\n\t\tretVal = window.showModalDialog(getUrl,arguments,features);\n\n\t\tif(retVal != null && retVal!=\"\")\n\t\t{\n\t\t\tvar retArray = retVal.split(\"|\");\n\n\t\t\tvar bill_doc_type_code = retArray[0];\n\t\t\tvar bill_doc_num = retArray[1];\n\t\t\tvar bill_slmt_reqd_YN = retArray[2];\n\n\t\t\tif(bill_slmt_reqd_YN ==\"Y\")\n\t\t\t{\n\t\t\t\tcallSlmtFun(bill_doc_type_code,bill_doc_num);\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\twindow.returnValue=\"SUCCESS\";\n\t\t\t\tparent.window.close();\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\twindow.returnValue=\"SUCCESS\";\n\t\t\tparent.window.close();\n\t\t}\n\t}\n\n\tfunction callSlmtFun(bill_doc_type_code,bill_doc_num)\n\t{\n\t\tvar store_code = document.forms[0].store_code.value;\n\t\tvar module_id = document.forms[0].module_id.value;\n\t\tvar bill_group_code = document.forms[0].bill_group_code.value;\n\n\t\tif(bill_doc_type_code != \"\" && bill_doc_num != \"\")\n\t\t{\n\t\t\tvar retVal = new Array();\t\t\n\t\t\tvar center=\'1\';\n\t\t\tvar dialogTop = \"100\";\n\t\t\tvar dialogHeight = \"40\" ;\n\t\t\tvar dialogWidth = \"70\" ;\n\t\t\tvar features= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; center:\" + center + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\t\n\t\t\tvar arguments = \"\" ;\n\t\t\tvar column_sizes = escape(\"\");               \n\t\t\tvar column_descriptions =\"\";\t\t\n\n\t\t\tvar param = \"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"billdoctypecode=\"+bill_doc_type_code+\"&\"+\"billdocnum=\"+bill_doc_num+\"&\"+\"storecode=\"+store_code+\"&\"+\"blnggrp=\"+bill_group_code+\"&\"+\"module_id=\"+module_id;\t\n\t\t\tretVal=window.showModalDialog(\"../../eBL/jsp/BLStoreBillSlmtMain.jsp?\"+param,arguments,features);\n\t\t}\n\t\twindow.returnValue=\"SUCCESS\";\n\t\tparent.window.close();\n\t}\n*/\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<!--\n<body onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onSelect = \"codeArrestThruSelect();\" onLoad=\'callAdhocDiscFun()\'>\n-->\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</head>\n  <iframe name=\'main_frame\' id=\'main_frame\' SRC=\"../../eBL/jsp/BLAdhocDiscFrame.jsp?";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" frameborder=0 scrolling=\'no\' noresize style=\'height:95vh;width:99vw\'></iframe> \t\t\n   \t\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<head>\n<TITLE> ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</TITLE>\n</head>\n\n\t\t\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<iFRAME name=\'main_frame\' id=\'main_frame\' SRC=\"../../eBL/jsp/BLStoreBillSlmtMain.jsp?";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" frameborder=0 scrolling=\'no\' noresize style=\'height:100vh;width:100vw\'></iFRAME>\t\t\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<iFRAME name=\'main_frame\' id=\'main_frame\' SRC=\"../../eBL/jsp/BLBillSlmtMain.jsp?";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" frameborder=0 scrolling=\'no\' noresize style=\'height:100vh;width:100vw\'></iFRAME>\t\t\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\n\t\n<!--\n<body onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onSelect = \"codeArrestThruSelect();\" onLoad=\"callSlmtFun(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\',\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\')\">\n-->\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n<form name=\'updPatFinDtls\' id=\'updPatFinDtls\' method=\'post\' action=\'\'>\t\t\n\n<input type=\'hidden\' name=\'module_id\' id=\'module_id\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n<input type=\'hidden\' name=\'episode_id\' id=\'episode_id\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n<input type=\'hidden\' name=\'visit_id\' id=\'visit_id\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n<input type=\'hidden\' name=\'bill_group_code\' id=\'bill_group_code\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n<input type=\'hidden\' name=\'clinic_code\' id=\'clinic_code\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n<input type=\'hidden\' name=\'visit_type_code\' id=\'visit_type_code\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n<input type=\'hidden\' name=\'physician_id\' id=\'physician_id\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n<input type=\'hidden\' name=\'episode_type\' id=\'episode_type\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\n<input type=\'hidden\' name=\'doc_no\' id=\'doc_no\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n<input type=\'hidden\' name=\'store_code\' id=\'store_code\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n<input type=\'hidden\' name=\'slmt_reqd_yn\' id=\'slmt_reqd_yn\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n<input type=\'hidden\' name=\'bill_doc_type\' id=\'bill_doc_type\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n<input type=\'hidden\' name=\'bill_doc_num\' id=\'bill_doc_num\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\n<input type=\'hidden\' name=\'call_disc_function_yn\' id=\'call_disc_function_yn\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n<input type=\'hidden\' name=\'query_string\' id=\'query_string\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n<input type=\'hidden\' name=\'ordering_facility_id\' id=\'ordering_facility_id\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t \n</form>\n</body>\n\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n</html>\n\n\n\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);

	Connection con				= null;
	String params="",str_billed_YN="N";
//	String str_trx_doc_ref="",str_trx_doc_ref_line_num="";
//	Statement stmt=null;
	ResultSet rs=null;
	PreparedStatement pstmt = null;

	try
	{	
		request.setCharacterEncoding("UTF-8");
		con	=	ConnectionManager.getConnection(request);

		System.err.println("Query String in BLCallDiscOrSlmtPage.jsp:"+request.getQueryString());
		//V210211 START
		String str_ordering_facility_id = request.getParameter("ordering_facility_id");
		if (str_ordering_facility_id == null) str_ordering_facility_id = (String) session.getValue("facility_id");
		//V210211 END		
		String str_module_id=request.getParameter("module_id");
		if(str_module_id == null) str_module_id="";

		String str_patient_id=request.getParameter("patient_id");
		if(str_patient_id == null) str_patient_id="";

		String str_episode_id=request.getParameter("episode_id");
		if(str_episode_id == null) str_episode_id="";

		String str_visit_id=request.getParameter("visit_id");
		if(str_visit_id == null) str_visit_id="";

		String bl_items_sl_no = request.getParameter("bl_items_sl_no");
		if(bl_items_sl_no==null) bl_items_sl_no="";
		
		String str_encounter_id=request.getParameter("encounter_id");
		if(str_encounter_id == null) str_encounter_id="";

		String str_episode_type=request.getParameter("episode_type");
		if(str_episode_type == null) str_episode_type="";

		String str_clinic_code=request.getParameter("clinic_code");
		if(str_clinic_code == null) str_clinic_code="";

		if(str_clinic_code.equals(""))
		{
			str_clinic_code=request.getParameter("locn_code");
			if(str_clinic_code == null) str_clinic_code="";
		}

		String str_visit_type_code=request.getParameter("visit_type_code");
		if(str_visit_type_code == null) str_visit_type_code="";

		String str_physician_id=request.getParameter("physician_id");
		if(str_physician_id == null) str_physician_id="";

		String str_bill_group_code=request.getParameter("blng_grp");
		if(str_bill_group_code == null) str_bill_group_code="";

		if(str_bill_group_code.equals(""))
		{
			str_bill_group_code=request.getParameter("blnggrp");
			if(str_bill_group_code == null) str_bill_group_code="";
		}
		
		String str_bill_doc_type_code=request.getParameter("bill_doc_type_code");
		if(str_bill_doc_type_code == null) str_bill_doc_type_code="";

		String str_bill_doc_num=request.getParameter("bill_doc_num");
		if(str_bill_doc_num == null) str_bill_doc_num="";

		String str_slmt_reqd_yn=request.getParameter("slmt_reqd_yn");
		if(str_slmt_reqd_yn == null) str_slmt_reqd_yn="";

		String str_doc_no =request.getParameter("doc_no");
		if(str_doc_no == null) str_doc_no="";

		String str_store_code =request.getParameter("store_code");
		if(str_store_code == null) str_store_code="";

		String str_call_disc_function_YN=request.getParameter("call_disc_function_yn");
		if(str_call_disc_function_YN == null) str_call_disc_function_YN="N";

		String allow_chkout_with_bill_stmt_yn = request.getParameter("allow_chkout_with_bill_stmt_yn");
		if(allow_chkout_with_bill_stmt_yn == null) allow_chkout_with_bill_stmt_yn="N";

		String str_function_id = request.getParameter("function_id");
		if(str_function_id == null) str_function_id="";
		
		String  calledFrom_UHID=request.getParameter("called_frmUHID");
		if(calledFrom_UHID == "" || calledFrom_UHID== null) calledFrom_UHID="N";

		if(str_module_id.equals("MP"))
			str_episode_type = "R";
		
		/*Added by Rajesh for ML-MMOH-CRF-0753*/
		String billAlreadyPrinted = request.getParameter("billAlreadyPrinted");
		if(billAlreadyPrinted == null || "null".equals(billAlreadyPrinted)){
			billAlreadyPrinted = "N";
		}
		
		// start  Corrected by Dhanasekar for  PH ST partial settlment
		
		StringBuffer strbuf = new StringBuffer();

	//	bl_items_sl_no = "QFSTSI-659,1";
		StringTokenizer str1 = new StringTokenizer(bl_items_sl_no ,";");
		StringTokenizer str = null;
		String strbufquery="";
		String tempValue=null;

		StringBuffer stbuf = new StringBuffer();
		int flag = 0;
		int flagMain = 0;
		
		
		  while (str1.hasMoreElements())
		 {
		 
		   tempValue = 	str1.nextToken();
		    
		   if(tempValue.length()>0)
			{
			str = new StringTokenizer(tempValue,",");	
			if(str.hasMoreElements())
			 {
				if(flagMain == 1) strbuf.append(" OR ");
					strbuf.append("(SEC_KEY_MAIN = '"+str.nextToken()+"'  AND (");
					flagMain = 1;
		  	        flag = 0;	 		  
			while(str.hasMoreElements())
			 {
		 
			if(flag ==1)   strbuf.append(" OR ");       
			  strbuf.append("SEC_KEY_LINE_NO LIKE ('"+str.nextToken()+"%')");
			 flag = 1;
			 }	
			strbuf.append("))");
		 }
			}
		}
		 

		 if(bl_items_sl_no.length()==0)
			  strbufquery="SEC_KEY_MAIN='"+str_doc_no+"'";
		 else 
			 strbufquery=strbuf.toString();
		
		
		// End  Corrected by Dhanasekar for  PH ST partial settlment
		
		
		
		
		
		
		
		

		if(str_call_disc_function_YN.equals("Y"))
		{
			try
			{
/*
				String sql1= " select TRX_DOC_REF,TRX_DOC_REF_LINE_NUM from bl_patient_charges_interface where patient_id='"+str_patient_id+"' and episode_id='"+str_episode_id+"' and visit_id='"+str_visit_id+"' and episode_type='"+str_episode_type+"' and PRIMARY_KEY_MAIN='"+str_doc_no+"' and PRIMARY_KEY_MODULE_ID='"+str_module_id+"'";
				System.err.println("strsql sql1 "+sql1);
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql1);	

				while(rs.next())
				{
					str_trx_doc_ref = rs.getString(1);
					str_trx_doc_ref_line_num = rs.getString(2);
				}	
				rs.close();
				stmt.close();
			   if(str_billed_YN == null) str_billed_YN="N";
			   System.err.println("str_billed_YN from query :"+str_billed_YN);

				sql1= " select BILLED_FLAG,BILL_DOC_TYPE_CODE,BILL_DOC_NUM from bl_patient_charges_folio where patient_id='"+str_patient_id+"' and episode_id='"+str_episode_id+"' and visit_id='"+str_visit_id+"' and episode_type='"+str_episode_type+"' and TRX_DOC_REF='"+str_trx_doc_ref+"' and TRX_DOC_REF_LINE_NUM='"+str_trx_doc_ref_line_num+"'";
*/	
				String sql1="";
/*				if(str_module_id.equals("AE"))
				{
					sql1 = "select BILLED_FLAG,BILL_DOC_TYPE_CODE,BILL_DOC_NUM from  BL_PATIENT_CHARGES_FOLIO where TRX_DOC_REF in (select TRX_DOC_REF from bl_patient_charges_interface where SEC_KEY_MAIN='"+str_doc_no+"' and confirmed_yn='Y') and BILL_DOC_TYPE_CODE is not null and BILL_DOC_NUM is not null and patient_id='"+str_patient_id+"' and episode_id='"+str_episode_id+"' and visit_id='"+str_visit_id+"' and episode_type='"+str_episode_type+"' and rownum=1 and ";
				}
				else
				{*/
					if(str_module_id.equals("PH") || (str_module_id.equals("ST")))
					{
						sql1 = "select BILLED_FLAG,BILL_DOC_TYPE_CODE,BILL_DOC_NUM from  BL_PATIENT_CHARGES_FOLIO where (TRX_DOC_REF,TRX_DOC_REF_LINE_NUM) in (select TRX_DOC_REF,TRX_DOC_REF_LINE_NUM from bl_patient_charges_interface where  "+strbufquery+"   and confirmed_yn='Y') and BILL_DOC_TYPE_CODE is not null and BILL_DOC_NUM is not null and patient_id=? and episode_id=? and visit_id=? and episode_type=? and  SETTLEMENT_IND ='C' and rownum=1";
					}
					else
					{
						sql1 = "select BILLED_FLAG,BILL_DOC_TYPE_CODE,BILL_DOC_NUM from  BL_PATIENT_CHARGES_FOLIO where TRX_DOC_REF in (select TRX_DOC_REF from bl_patient_charges_interface where  "+strbufquery+"   and confirmed_yn='Y') and BILL_DOC_TYPE_CODE is not null and BILL_DOC_NUM is not null and patient_id=? and episode_id=? and visit_id=? and episode_type=? and  SETTLEMENT_IND ='C' and rownum=1";
					}
//				}

//				System.err.println("strsql sql1 "+sql1);

				pstmt = con.prepareStatement(sql1);
				pstmt.setString(1,str_patient_id);
				pstmt.setString(2,str_episode_id);
				pstmt.setString(3,str_visit_id);
				pstmt.setString(4,str_episode_type);
				rs = pstmt.executeQuery();	

				while(rs.next())
				{
				   str_billed_YN  =  rs.getString(1);
				   str_bill_doc_type_code  =  rs.getString(2);	
				   str_bill_doc_num  =  rs.getString(3);	
				}	
				rs.close();
				pstmt.close();
			   if(str_billed_YN == null) str_billed_YN="N";
			   if(str_bill_doc_num == null) str_bill_doc_num="";
			   if(str_bill_doc_type_code == null) str_bill_doc_type_code="";
//			   System.err.println("str_billed_YN from query :"+str_billed_YN);
			}
			catch(Exception e)
			{
				System.err.println("Error while calling BLCOMMON.BL_VALIDATE_UPD_FIN_DTLS :"+e);
			}
		}
		
		
		Boolean UHIDAMRISite=false;
		String UHIDAMRISiteSpec ="";
		try
		{
			
			UHIDAMRISite = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","UHID_VALID_DAYS_APPL");	
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		if(UHIDAMRISite){
			UHIDAMRISiteSpec="Y";
		}
		else{
			UHIDAMRISiteSpec="N";
		}
		
		
		
		
		
		
		

            _bw.write(_wl_block5Bytes, _wl_block5);

	if(str_call_disc_function_YN.equals("Y") && (str_billed_YN.equals("N") || str_bill_doc_num.equals("")))
	{
		System.err.println("Inside Discount variables forming logic");
		params="patient_id="+str_patient_id+"&episode_type="+str_episode_type+"&episode_id="+str_episode_id+"&visit_id="+str_visit_id+"&encounter_id="+str_encounter_id+"&module_id="+str_module_id+"&doc_no="+str_doc_no+"&store_code="+str_store_code+"&slmt_reqd_yn="+str_slmt_reqd_yn+"&called_frm=OTH_MOD&allow_chkout_with_bill_stmt_yn="+allow_chkout_with_bill_stmt_yn+"&locn_code="+str_clinic_code+"&visit_type_code="+str_visit_type_code+"&function_id="+str_function_id+"&bl_items_sl_no="+bl_items_sl_no;
//		System.err.println("Inside Discount variables forming logic-later");

            _bw.write(_wl_block6Bytes, _wl_block6);
 



if("Y".equals(UHIDAMRISiteSpec) && ("Y").equals(calledFrom_UHID)){

	
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

	
}

else{

            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
 } 
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(params));
            _bw.write(_wl_block10Bytes, _wl_block10);

	}
	else
	{
		params="billdoctypecode="+str_bill_doc_type_code+"&"+"billdocnum="+str_bill_doc_num+"&"+"storecode="+str_store_code+"&"+"blnggrp="+str_bill_group_code+"&"+"module_id="+str_module_id+"&billAlreadyPrinted="+billAlreadyPrinted;

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

	if(str_module_id.equals("PH") || (str_module_id.equals("ST")))
		{
				params=params+"&ordering_facility_id="+str_ordering_facility_id; //V210211

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(params));
            _bw.write(_wl_block14Bytes, _wl_block14);

		}
		else{

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(params));
            _bw.write(_wl_block16Bytes, _wl_block16);

		}

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(str_bill_doc_type_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(str_bill_doc_num));
            _bw.write(_wl_block19Bytes, _wl_block19);

	}

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(str_module_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(str_patient_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(str_episode_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(str_visit_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(str_encounter_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(str_bill_group_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(str_clinic_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(str_visit_type_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(str_physician_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(str_episode_type));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(str_doc_no));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(str_store_code));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(str_slmt_reqd_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(str_bill_doc_type_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(str_bill_doc_num));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(str_call_disc_function_YN));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(str_ordering_facility_id));
            _bw.write(_wl_block38Bytes, _wl_block38);

	}
	catch(Exception e)
	{
		System.err.println("Main Exception:"+e);
	}
	finally
	{ 
		ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block39Bytes, _wl_block39);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.UHID_RENEW_CHARGE_DTLS.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DISC_SLMT_FOR_ENC_CHARGE_DTLS.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BILL_SLMT_DTL.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }
}
