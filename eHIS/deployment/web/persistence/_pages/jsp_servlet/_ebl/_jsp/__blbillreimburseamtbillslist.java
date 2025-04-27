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
import java.util.*;
import com.ehis.util.*;

public final class __blbillreimburseamtbillslist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLBillReimburseAmtBillsList.jsp", 1717485709832L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<html>\n\t<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<STYLE TYPE=\"text/CSS\">\n\n/* This style is used for locking the table\'s heading  */\n\ndiv#tbl-container {\nwidth: 1020px;\nheight: 245px;\noverflow: auto;\n}\n\nthead td, thead td.locked\t{\nposition:relative;\n}\n\nthead td {\ntop: expression(document.getElementById(\"tbl-container\").scrollTop-3); \nz-index: 20;\n}\n\n</STYLE>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\t\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\t\t\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\t\n\t\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eBL/js/BLBillReimburseAmtDetails.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<script>\n\tfunction check_load_slmt()\n\t{\n\t\tvar tot_rec = document.forms[0].total_records.value;\n\t\tvar rec_to_load;\n\n\t\tfor(var i=0;i<tot_rec;i++)\n\t\t{\n\t\t\tvar outst_amt_id = \"outst_amt_\"+i;\n\t\t\tvar outst_amt = eval(document.getElementById(\"outst_amt_id\"));\n\t\t\toutst_amt = outst_amt.innerText;\n\n\t\t\tif(eval(outst_amt) > 0)\n\t\t\t{\n\t\t\t\trec_to_load=i;\n\t\t\t\tbreak;\n\t\t\t}\n\t\t}\n\t\tif(rec_to_load != undefined && rec_to_load !=\"undefined\")\n\t\t{\n\t\t\tload_slmt_page(rec_to_load);\n\t\t}\n\t}\n\n\tfunction load_slmt_page(sel_rec)\n\t{\n\t\tvar patient_id = document.forms[0].patient_id.value;\n\t\tvar episode_type = document.forms[0].episode_type.value;\n\t\tvar query_string = document.forms[0].query_string.value;\n\n\t\tvar doc_type_code = eval(\"document.forms[0].doc_type_code_\"+sel_rec);\n\t\tdoc_type_code = doc_type_code.value;\n\n\t\tvar doc_num = eval(\"document.forms[0].doc_num_\"+sel_rec);\n\t\tdoc_num = doc_num.value;\n\n\t\tparent.frames[1].location.href = \"../../eBL/jsp/BLBillReimburseAmtBillServDetails.jsp?billdoctypecode=\"+doc_type_code+\"&billdocnum=\"+doc_num+\"&patient_id=\"+patient_id+\"&episode_type=\"+episode_type+\"&\"+query_string;\n\t}\t\n</script>\n\n<BODY onLoad=\"check_load_slmt();\" onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" \t\t\t\t\t      \t\t\t\t\t  onSelect=\"codeArrestThruSelect();\">\n<FORM name=\'AdhocDicountsbyServiceForm\' id=\'AdhocDicountsbyServiceForm\' onLoad=\"\" action=\"\" method=\'\'>\t\n<div>\n\t<table border=\'1\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\'>\t\n\t<tr><td class=\'COLUMNHEADER\' colspan=\'9\' align=\'left\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td></tr>\n\t</table>\n</div>\n\t<div id=\"tbl-container\" STYLE=\"overflow: auto; width: 100%; height: 105px;   padding:3px; margin: 0px\">\n\t<table border=\'1\' cellpadding=\'3\' cellspacing=\'0\' width=\'90%\' align=\'center\'>\t\n\t<thead>\n\t\t\t<tr><td></td></tr>\n\t\t<tr>\t\t\t\n<!--\n\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n-->\n\t\t\t<td class=\'COLUMNHEADER\' width=\'20%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'20%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'30%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'15%\'>Bill Amount</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'15%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t</tr>\n\t</thead>\n\t<tbody>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<tr>\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" width=\'20%\'><div id=\'doc_num_";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'><a href=\"javascript:load_slmt_page(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\',\'C\');\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="/";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</a></div></td>\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" width=\'20%\'><div id=\'doc_date";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</div></td>\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" width=\'25%\'><div id=\'str_blng_grp_desc_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" width=\'15%\'><div id=\'tot_bill_amt";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" width=\'15%\'><div id=\'outst_amt_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</div></td>\n\t\t\t\t\n\t\t\t</tr>\n\t\t\t<input type=\'hidden\' name=\'doc_type_code_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' id=\'doc_type_code_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t\t<input type=\'hidden\' name=\'doc_num_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' id=\'doc_num_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t\t<input type=\'hidden\' name=\'blng_grp_id_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' id=\'blng_grp_id_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="  \n\t</tbody>\n\t</table>\n\t</div>\n\t<input type=\"hidden\" name=\"query_string\" id=\"query_string\"\tvalue=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" >\n\t<input type=\"hidden\" name=\"total_records\" id=\"total_records\"\tvalue=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" >\n\t<input type=\"hidden\" name=\"noofdecimal\" id=\"noofdecimal\"\tvalue=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" >\n\t<input type=\"hidden\" name=\"called_frm\" id=\"called_frm\"\tvalue=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" >\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\"\tvalue=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" >\n\t<input type=\"hidden\" name=\"episode_type\" id=\"episode_type\"\tvalue=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" >\t\n\t<input type=\"hidden\" name=\"alw_co_wit_bl_slmt_yn\" id=\"alw_co_wit_bl_slmt_yn\"\tvalue=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" >\t\t\n\n</form>\n</BODY>\n<script>\n\tvar total_records = document.forms[0].total_records.value;\n//\talert(total_records);\n\tif(total_records == 0)\n\t{\n\t\tparent.window.returnValue = \"Y\";\n\t\tparent.window.close();\n\t}\n</script>\n</HTML>\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");	
	Connection con				= null;
	PreparedStatement pstmt		= null;
	PreparedStatement pstmt1	= null;
	Statement stmt				= null;
	ResultSet rs				= null;	
	ResultSet rs1				= null;
	String classval="";
	try
	{
		con	=	ConnectionManager.getConnection(request);

		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");

		int i=0,noofdecimal=2;

		String str_blng_grp_id="",str_blng_grp_desc="",doc_type_code="",doc_num="", doc_date="";

		String locale="", str_facility_id="", strloggeduser="", strclientip="", str_patient_id="", str_episode_type="", str_episode_id="", str_visit_id="", str_encounter_id="", str_module_id="", called_frm="", alw_co_wit_bl_slmt_yn="";

		String tot_bill_amt="", str_bill_tot_outst_amt="";

		double v_tot_bill_amt=0, v_bill_tot_outst_amt=0;
		
		CurrencyFormat cf1 = new CurrencyFormat();

		String query_string=request.getQueryString();

		try
		{
			locale	= (String)session.getAttribute("LOCALE");	
			if(locale==null || locale.equals("")) locale="en";	

			str_facility_id = (String) session.getValue("facility_id");
			if (str_facility_id==null) str_facility_id = "";

			strloggeduser	=  (String) session.getValue("login_user");	
			if (strloggeduser==null) strloggeduser = "";

			strclientip = p.getProperty("client_ip_address");
			if (strclientip==null) strclientip = "";

			str_patient_id = request.getParameter("patient_id");	
			if(str_patient_id==null) str_patient_id="";	
			
			str_episode_type = request.getParameter("episode_type");	
			if(str_episode_type==null) str_episode_type="";	
		
			str_episode_id = request.getParameter("episode_id");	
			if(str_episode_id==null) str_episode_id="";	

			str_visit_id = request.getParameter("visit_id");	
			if(str_visit_id==null) str_visit_id="";	
		
			str_encounter_id = request.getParameter("encounter_id");	
			if(str_encounter_id==null) str_encounter_id="";	

			str_module_id     =  request.getParameter("module_id");	
			if(str_module_id == null) str_module_id="";

			called_frm     =  request.getParameter("function_id");
			if(called_frm == null) called_frm="";

			alw_co_wit_bl_slmt_yn = request.getParameter("alw_co_wit_bl_slmt_yn");
			if(alw_co_wit_bl_slmt_yn == null) alw_co_wit_bl_slmt_yn="N";
		}
		catch(Exception e)
		{
			System.err.println("Error in BLBillListDtls.jsp - fetching values:"+e);
		}

            _bw.write(_wl_block6Bytes, _wl_block6);
	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

		try
		{
			try
			{		
				pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
				ResultSet rscurr = pstmt.executeQuery();	
				while(rscurr.next())
				{
					noofdecimal  =  rscurr.getInt(1);		
				}		
				rscurr.close();
				pstmt.close();
			}
			catch(Exception e)
			{
				System.err.println("3="+e.toString());
			}

			String strsql="Select DOC_TYPE_CODE,DOC_NUM,to_char(DOC_DATE,'DD/MM/YYYY HH24:MI:SS'),BLNG_GRP_ID,BILL_AMT,nvl(bill_tot_outst_amt,0) From BL_BILL_HDR" 
			+" where operating_facility_id = '"+str_facility_id+"'" 
			+" and patient_id = '"+str_patient_id+"'"
			+" and episode_type = '"+str_episode_type+"'"
			+" and episode_id = '"+str_episode_id+"'"
			+" and (('"+str_episode_type+"' IN ('O','E') and visit_id = '"+str_visit_id+"') OR ('"+str_episode_type+"' IN ('I','D')) OR ('"+str_episode_type+"'='R'))"
			+" and NVL(BILL_TOT_OUTST_AMT,0) > 0"
			+" and NVL(BILL_STATUS,'X') != 'C'"
			+" And Nvl(BILL_PAID_AMT,0)=0"
			+" and BILL_NATURE_CODE='C' ORDER BY DOC_DATE DESC,DOC_TYPE_CODE,DOC_NUM";

			stmt = con.createStatement();
			rs = stmt.executeQuery(strsql) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					doc_type_code = rs.getString(1);
					if(doc_type_code == null) doc_type_code="";

					doc_num = rs.getString(2);
					if(doc_num == null) doc_num="";

					doc_date = rs.getString(3);
					if(doc_date == null) doc_date="";

					str_blng_grp_id=rs.getString(4);
					if(str_blng_grp_id == null) str_blng_grp_id="";

					tot_bill_amt = rs.getString(5);
					if(tot_bill_amt == null) tot_bill_amt="0";
					tot_bill_amt = cf1.formatCurrency(tot_bill_amt, noofdecimal);
					v_tot_bill_amt = Double.parseDouble(tot_bill_amt);

					str_bill_tot_outst_amt =rs.getString(6);
					if(str_bill_tot_outst_amt == null) str_bill_tot_outst_amt="0";
					str_bill_tot_outst_amt = cf1.formatCurrency(str_bill_tot_outst_amt, noofdecimal);
					v_bill_tot_outst_amt = Double.parseDouble(str_bill_tot_outst_amt);

					try
					{		
						pstmt1 = con.prepareStatement( " select SHORT_DESC from bl_blng_grp_lang_vw where blng_grp_id='"+str_blng_grp_id+"'");
						rs1 = pstmt1.executeQuery();	
						while(rs1.next())
						{
							str_blng_grp_desc  =  rs1.getString(1);		
						}		
						if(str_blng_grp_desc == null) str_blng_grp_desc="";
						rs1.close();
						pstmt1.close();
					}
					catch(Exception e)
					{
						System.err.println("Billing Grp Desc Fetching="+e.toString());
					}

					if(i % 2 == 0 )
					{
						classval	=	"QRYEVEN";
					}
					else
					{
						classval	=	"QRYODD";
					}

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(doc_type_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(doc_num));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(doc_date,"DMYHMS","en",locale)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(str_blng_grp_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(v_tot_bill_amt));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(str_bill_tot_outst_amt));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(doc_type_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(doc_num));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(str_blng_grp_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
			
					i++;
				}//while		
			}//rs 
			stmt.close();
			rs.close();
		}
		catch(Exception e)
		{
			System.err.println("Exception in main qry :"+e);
		}

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(called_frm));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(str_patient_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(str_episode_type));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(alw_co_wit_bl_slmt_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);

	}
	catch(Exception ee)
	{
	  System.err.println("Error in main Adhoc disc " +ee);
	}
	finally 
	{
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.OUTST_PAT_BILLS.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DocType.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.documentno.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DocumentDate.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingGroup.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.outstandingamount.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }
}
