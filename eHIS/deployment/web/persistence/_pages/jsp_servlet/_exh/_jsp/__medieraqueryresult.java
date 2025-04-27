package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.Connection;
import java.util.HashMap;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eXH.XHQueryRender;
import eXH.XHDBAdapter;
import java.text.SimpleDateFormat;
import eXH.XHUtil;

public final class __medieraqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/MediERAQueryResult.jsp", 1743586712960L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<HTML>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\n\n<HEAD>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'></link>\t\t      \n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\t   \n<style>\n.left_child{\n\toverflow-y:auto;\n }\n</style>\n<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script language=\"javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/jquery-3.6.3.js\' language=\'javascript\'></script>\n\n<script language=\"javascript\">\n\nfunction funSubmit()\n{\n\tparent.resultFrame.ERA_QUERY_FORM.action = \'../../eXH/jsp/MediERAQueryResult.jsp\';\n\tparent.resultFrame.ERA_QUERY_FORM.target=\"resultFrame\";\n\tparent.resultFrame.ERA_QUERY_FORM.submit();\n}\n\n\tfunction funAction(typ)\n\t{  \n\t\tparent.resultFrame.ERA_QUERY_FORM.action_type.value = typ;\n\t\tfunSubmit();\n\t}\n\n\t//function callForOrderBy\n\tfunction callForOrderBy(obj,order)\n\t{\t\n\t\tif(order == \'A\') obj = obj + \' asc\';\n\t\tif(order == \'D\') obj = obj + \' desc\';\n\t\tvar url = \'&orderBy=\' + obj + \'&order=\' + order;\n\n\tthis.document.forms[0].action_type.value = \"\";\n\tthis.document.forms[0].action = \"../../eXH/jsp/MediERAQueryResult.jsp?\"+url;\n\tthis.document.forms[0].target = \"f_query_add_mod\";\n\tthis.document.forms[0].submit();\n}\n\n\tasync function checkEligibility(obj)\n\t{\t\n\t\tvar checkType = \"\";\n\t\t\n\t\tvar checkTypeButtons = document.getElementsByName(\'CheckType\');\n\n\t\tvar trans_num = obj.getAttribute(\'trans_num\');\n\t\tvar event_type = obj.getAttribute(\'event_type\');\n\t\tvar era_id = obj.getAttribute(\'era_id\');\n\n\t\tif ((trans_num == \"\") || (trans_num == \"0\"))\n\t\t{\n\t\t\talert(\"Claim ID is not available for the ERA transaction selected, no details can be displayed.\");\n\t\t\treturn;\n\t\t}\n\n\t\t\n\t\tvar dialogHeight = \"45vh\";    // have to remove \n\t\tvar dialogWidth  = \"80vw\";\n\t\tvar dialogTop    = \"50\";\n\n\t\tvar title=\"ERA Response Details \";\n\t\ttitle=encodeURIComponent(title);\n\t\tvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogTop:\" +dialogTop+ \"; status:no;scroll:no\" ;\n\n\t\tvar params= \"trans_num=\"+trans_num+\"&era_id=\"+era_id;\n\n\tvar arguments = new Array();\n\tvar url = \"../../eXH/jsp/MediERAQueryResponsePopUp.jsp?\" +params;\n\t\n\tvar retVal = await window.showModalDialog(url,arguments,features);\n      \n}\n\n\tfunction includeBoxChecked() {\n\n\t\tif (document.forms[0].includeMastercheckbox.checked == true) {\n\t\t\tif (document.forms[0].includeCheckbox.length != undefined) {\n\t\t\t\tfor ( var a = 0; a < document.forms[0].includeCheckbox.length; a++) {\n\t\t\t\t\tdocument.forms[0].includeCheckbox[a].checked = true;\n\t\t\t\t}\n\t\t\t} else if (document.forms[0].gatewayservers.length == undefined) {\n\t\t\t\tdocument.forms[0].includeCheckbox.checked = true;\n\t\t\t}\n\t\t}\n\t\telse {\n\t\t\tif (document.forms[0].includeCheckbox.length != undefined) {\n\t\t\t\tfor ( var a = 0; a < document.forms[0].includeCheckbox.length; a++) {\n\t\t\t\t\tdocument.forms[0].includeCheckbox[a].checked = false;\n\t\t\t\t}\n\t\t\t} else if (document.forms[0].includeCheckbox.length == undefined) {\n\t\t\t\tdocument.forms[0].includeCheckbox.checked = false;\n\t\t\t}\n\t\t}\n\t\treturn true;\n\t}\n\tfunction toggle(doc_num)\n\t{\n\t\t if( document.getElementById(\"hidethis\"+doc_num).style.display==\'none\' ){\n\t\t   document.getElementById(\"hidethis\"+doc_num).style.display = \'table\'; // set to table-row instead of an empty string\n\t\t }else{\n\t\t   document.getElementById(\"hidethis\"+doc_num).style.display = \'none\';\n\t\t }\n\t}\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\t\n\n<BODY leftmargin=0 topmargin=0 onMouseDown=\"CodeArrest()\" >\n\t<form name=\"ERA_QUERY_FORM\" id=\"ERA_QUERY_FORM\" method=\"POST\" action=\'\'  >\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\t\n\t\t\t\t<script>\n\t\t\t\talert(\'APP-002415 Query caused no records to be retrieved\');\n\t\t\t\thistory.go(-1);\n\t\t\t\tparent.resultFrame.location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" \n\t\t\t\t<table cellspacing=0 cellpadding=3 width=\'100%\' align=center border=1>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\"27\" class=\"COLUMNHEADER\" align=\'center\'>ERA Query Result</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\t   \n\t\t\t\t\t\t<td align=\"right\" class=\"CAGROUP\" > \n\t\t\t\t\t\t<A class=\'label\' style=\'cursor:pointer\' onClick=\"funAction(\'P\')\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</A>\n\t\t\t\t\t\t<A class=\'label\' onClick=\"funAction(\'N\')\" style=\'cursor:pointer\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</A>\n\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\n\t\t\t\t<div id=\"left_child\" class=\"left_child\">\n\t\t\t\t\t<table id=\"indicatorTable\" cellspacing=0 cellpadding=3 width=\'100%\' border=1 align=center>\t\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'6%\'>\n\t\t\t\t\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</font>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'8%\'>\n\t\t\t\t\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</font>\n\t\t\t\t\t\t\t</td>\n                            <td class=\'COLUMNHEADER\' width=\'15%\'>\n\t\t\t\t\t\t\t\t<font color=white >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</font>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t        <td class=\'COLUMNHEADER\' width=\'5%\'>\n\t\t\t\t\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</font>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t        <td class=\'COLUMNHEADER\' width=\'8%\'>\n\t\t\t\t\t\t\t\t<font color=white> ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</font>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\' align = \"right\">\n\t\t\t\t\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</font>\n\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'15%\'>\n\t\t\t\t\t\t\t\t<font color=white >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</font>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t    <input type=\'hidden\' name=\'action_type\' id=\'action_type\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\t\t     \n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="<tr id = \"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</div>\n\t\t\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t</table>\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
 																	    
request.setCharacterEncoding("UTF-8");
String locale = ((String)session.getAttribute("LOCALE"));
String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

		String order = "";
		String orderBy = "";
		String action_type=null;
		Connection conn = null;
		Statement stmt=null;
		ResultSet rset=null ;
		String event_type = "";
		String dest_code = "";


		String era_from_dt="",era_to_dt = "", from_era_id = "", to_era_id = "", to_claim_id = "", from_claim_id = "", claim_status_type = "";
        String rs_mk_era_no = "" ,rs_mk_era_date = "",rs_scheme_name = "",rs_era_trans_no = "",rs_trans_date = "", rs_era_type = "",rs_prov_paid_amount = "", rs_pat_paid_amount = ""; String rs_actual_amount_paid = "", rs_process_statu =  "",rs_claim_id  = "",rs_prov_claim_no = "",rs_sheme_claim_no = "",rs_mem_plicy_num = "",rs_patient_initials = "";	String rs_patient_first_name = "",rs_surname = "",rs_patient_dob = "",rs_claim_patient_deptcode = "",rs_claimed_by_provider = "",rs_paid_to_provider = "";			
		String rs_paid_to_member = "",rs_not_paid = "",	rs_claim_status = "",rs_process_ack_message = "",rs_process_error_message ="",rs_bill_doc_type_code = "",rs_era_date="";		String rs_bill_doc_number = "",rs_process_status = "",rs_claim_status_desc = "", rs_process_status_desc = "", rs_era_status_desc = "";

		String rs_patient_id = "", rs_patient_name = "", rs_claimed_amount = "", rs_approved_amount = "", rs_event_type = "";

		String l_adj_query = "";

		String l_mk_era_no = "",l_prov_claim_id =  "",l_adj_date = "",l_adj_amount = "", l_adj_desc = ""; 

		String l_adj_image_str = "";

		String rs_era_date_desc = "";

		String checkboxvalue = "",rs_trans_Id = "";
         

		String  currentSubGroup = "",prevSubGroup = "";
		HttpSession httpSession = request.getSession(false);
		era_from_dt = XHDBAdapter.checkNull(request.getParameter("era_from_dt"));
		era_to_dt= XHDBAdapter.checkNull(request.getParameter("era_to_dt"));
		from_era_id = XHDBAdapter.checkNull(request.getParameter("from_era_id"));
		to_era_id = XHDBAdapter.checkNull(request.getParameter("to_era_id"));
		to_claim_id = XHDBAdapter.checkNull(request.getParameter("to_claim_id"));
		from_claim_id = XHDBAdapter.checkNull(request.getParameter("from_claim_id"));
		claim_status_type = XHDBAdapter.checkNull(request.getParameter("claim_status_type"));

		if(era_from_dt!="" && era_from_dt!=null && era_from_dt!=" ")
		{
		   era_from_dt = era_from_dt+ " 00:00:00";
		}

		//String trans_to_dt = XHDBAdapter.checkNull(request.getParameter("trans_to_dt"));
		if(era_to_dt!="" && era_to_dt!=null && era_to_dt!=" ")
		{
		   era_to_dt =era_to_dt + " 23:59:59";
		}	

		String isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM"));

		if(isDebugYN.equals("Y")){
			System.out.println("MediERAQueryResult.jsp:::claim_status_type....."+claim_status_type);
			System.out.println("MediERAQueryResult.jsp:::era_from_dt....."+era_from_dt+" era_to_dt :::: "+era_to_dt );
			System.out.println("MediERAQueryResult.jsp:::from_era_id....."+from_era_id +"::: to_era_id ::: "+to_era_id);
			System.out.println("MediERAQueryResult.jsp:::from_claim_id....."+from_claim_id +"::: to_claim_id ::: "+to_claim_id);
		}
		/*"patient_id="+patient_id+"&encounter_id="+encounter_id+"&practitioner_id="+practitioner_id+"&patient_class="+patient_class+"&nursing_unit_code="+nursing_unit_code+"&period_dt1="+period_dt1+"&period_dt2="+period_dt1+"&company_name="+company_name; */

		boolean  boolToggle = true;
		String strTDClass = "";
		String whereClause = "";
		int totalRecords=0;

		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		ArrayList arrRows = new ArrayList();
        ArrayList arrColumns = new ArrayList();

		try
		{ 
			conn = ConnectionManager.getConnection(request);

			whereClause = " ";
			int count = 0;
			if(era_from_dt!="" && era_from_dt!=null && era_to_dt!="" && era_to_dt!=null)
			{	
				if(count == 0){
					whereClause = whereClause + " where TO_Date(ERA_TRANS_DATE ,'DD/MM/YY HH24:MI:SS') BETWEEN TO_Date('"+era_from_dt+"','DD/MM/YYYY HH24:MI:SS') AND TO_Date('"+era_to_dt+"', 'DD/MM/YYYY HH24:MI:SS')";
				}
				else{
                    whereClause = whereClause + " And TO_Date(ERA_TRANS_DATE ,'DD/MM/YY HH24:MI:SS') BETWEEN TO_Date('"+era_from_dt+"','DD/MM/YYYY HH24:MI:SS') AND TO_Date('"+era_to_dt+"', 'DD/MM/YYYY HH24:MI:SS')";
				}
				count++;
			}

			if(from_era_id != null && from_era_id != "" && from_era_id != " " && to_era_id != null && to_era_id != "" && to_era_id != " ")
			{
				if(count ==0){
                   whereClause = whereClause + " where MK_ERA_NO BETWEEN '#from_era_id' AND '#to_era_id' ";
				}
				else{
				 whereClause = whereClause + " AND MK_ERA_NO BETWEEN '#from_era_id' AND '#to_era_id' ";
				}
				count++;
			}
			if(from_claim_id != null && from_claim_id != "" && from_claim_id != " " && to_claim_id != null && to_claim_id != "" && to_claim_id != " ")
			{
				if(count ==0){
				whereClause = whereClause + " where  PROV_CLAIM_NO BETWEEN '#from_claim_id' AND '#to_claim_id' ";
				}
                else{
                     whereClause = whereClause + " AND PROV_CLAIM_NO BETWEEN '#from_claim_id' AND '#to_claim_id' ";
				 }
				 count++;
			}
			if(claim_status_type != null && claim_status_type != "" && claim_status_type != " " )
			{ 
				if(count ==0){
					whereClause = whereClause + " where CLAIM_STATUS =  '#claim_status_type' ";  
				}
				else{
                    whereClause = whereClause + " AND CLAIM_STATUS =  '#claim_status_type' "; 
				}
			}
			whereClause = whereClause + " order by MK_ERA_NO, PROV_CLAIM_NO ";

			request.setAttribute(XHQueryRender.strQueryId,"MEDICLAIMSERAPROCESS");

			if(isDebugYN.equals("Y")){
				System.out.println("MediERAQueryResult.jsp :: whereClause....."+whereClause);
			}
			request.setAttribute(XHQueryRender.col,"35"); 
			request.setAttribute(XHQueryRender.maxRec,"6");
			request.setAttribute(XHQueryRender.whereClause,whereClause);
			HashMap resultsQry = XHQueryRender.getResults(request,session,conn,"");	
			//String sqlQuery= XHQueryRender.sqlQuery;	
			//System.out.println("sqlQuery... "+sqlQuery);
			ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 

			ArrayList arrCol = null;
			boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
			boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
			//if(isDebugYN)System.out.println("boolPrevious...."+boolPrevious);
			//if(isDebugYN)System.out.println("boolNext...."+boolNext);
			String strPrevious = "Previous";
			String strNext  = "Next";
			if (boolPrevious == true)
			{
				strPrevious = "Previous";
			}
			else
			{
				strPrevious = " ";
			}
			if (boolNext== true)
			{
				strNext  = "Next";
			}
			else
			{
				strNext  = " ";
			}
			if(isDebugYN.equals("Y")){
				System.out.println("MediERAQueryResult.jsp :: action_type in jsp...."+action_type);
			}

			if(arrRow.size()==0)
			{
				
            _bw.write(_wl_block7Bytes, _wl_block7);

			}
			else
			{
				
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( strPrevious ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( strNext ));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(action_type));
            _bw.write(_wl_block18Bytes, _wl_block18);

						System.out.println("MediERAQueryResult.jsp :: Before getting details....."+arrRow.size());
						Map cmp = new HashMap();
                        int j=0;
						totalRecords=0;
						for (j=0; j<arrRow.size();j++)
						{
							rs_mk_era_no = ""; rs_mk_era_date = ""; rs_scheme_name = ""; rs_era_trans_no = ""; rs_trans_date = "";  rs_era_type = ""; rs_prov_paid_amount = "";  rs_pat_paid_amount = ""; rs_actual_amount_paid = "";  rs_process_status =  ""; rs_claim_id  = ""; rs_prov_claim_no = ""; rs_sheme_claim_no = ""; rs_mem_plicy_num = ""; 
							
							rs_patient_initials = "";	rs_patient_first_name = ""; rs_surname = ""; rs_patient_dob = ""; rs_claim_patient_deptcode = ""; rs_claimed_by_provider = ""; rs_paid_to_provider = "";			
							rs_paid_to_member = ""; rs_not_paid = ""; 	rs_claim_status = ""; rs_process_ack_message = ""; rs_process_error_message =""; rs_bill_doc_type_code = ""; rs_era_date="";	rs_bill_doc_number = ""; rs_process_status = ""; rs_claim_status_desc = ""; rs_era_status_desc = "";

							rs_patient_id = "";  rs_patient_name = "";  rs_claimed_amount = "";  rs_approved_amount = ""; rs_event_type = "";
 
							rs_era_date_desc = "";

							arrCol = (ArrayList)arrRow.get(j);
							rs_mk_era_no = arrCol.get(0).equals("null")?"":(String)arrCol.get(0);
							rs_mk_era_date = arrCol.get(1).equals("null")?"":(String)arrCol.get(1);
							rs_scheme_name = arrCol.get(2).equals("null")?"":(String)arrCol.get(2);
							rs_era_trans_no = arrCol.get(3).equals("null")?"":(String)arrCol.get(3);
							rs_era_date = arrCol.get(4).equals("null")?"":(String)arrCol.get(4);
							rs_era_type = arrCol.get(5).equals("null")?"":(String)arrCol.get(5);
							rs_prov_paid_amount = arrCol.get(6).equals("null")?"":(String)arrCol.get(6);
							rs_pat_paid_amount = arrCol.get(7).equals("null")?"":(String)arrCol.get(7);
							rs_actual_amount_paid = arrCol.get(8).equals("null")?"":(String)arrCol.get(8);
							rs_process_status= arrCol.get(9).equals("null")?"":(String)arrCol.get(9);
							rs_claim_id = arrCol.get(10).equals("null")?"":(String)arrCol.get(10);
							rs_prov_claim_no = arrCol.get(11).equals("null")?"":(String)arrCol.get(11);
							rs_sheme_claim_no = arrCol.get(12).equals("null")?"":(String)arrCol.get(12);
							rs_mem_plicy_num = arrCol.get(13).equals("null")?"":(String)arrCol.get(13);
							rs_patient_initials = arrCol.get(14).equals("null")?"":(String)arrCol.get(14);
							rs_patient_first_name = arrCol.get(15).equals("null")?"":(String)arrCol.get(15);
							rs_surname = arrCol.get(16).equals("null")?"":(String)arrCol.get(16);
							rs_patient_dob = arrCol.get(17).equals("null")?"":(String)arrCol.get(17);
							rs_claim_patient_deptcode = arrCol.get(18).equals("null")?"":(String)arrCol.get(18);
							rs_claimed_by_provider = arrCol.get(19).equals("null")?"":(String)arrCol.get(19);
							rs_paid_to_provider = arrCol.get(20).equals("null")?"":(String)arrCol.get(20);
							rs_paid_to_member= arrCol.get(21).equals("null")?"":(String)arrCol.get(21);
							rs_not_paid = arrCol.get(22).equals("null")?"":(String)arrCol.get(22);
							rs_claim_status = arrCol.get(23).equals("null")?"":(String)arrCol.get(23);
							rs_process_ack_message = arrCol.get(24).equals("null")?"":(String)arrCol.get(24);
							rs_process_error_message = arrCol.get(25).equals("null")?"":(String)arrCol.get(25);
							rs_bill_doc_type_code = arrCol.get(26).equals("null")?"":(String)arrCol.get(26);
							rs_bill_doc_number = arrCol.get(27).equals("null")?"":(String)arrCol.get(27);

							rs_patient_id = arrCol.get(28).equals("null")?"":(String)arrCol.get(28);
							rs_patient_name = arrCol.get(29).equals("null")?"":(String)arrCol.get(29);
							rs_claimed_amount = arrCol.get(30).equals("null")?"":(String)arrCol.get(30);
							rs_approved_amount = arrCol.get(31).equals("null")?"":(String)arrCol.get(31);

							rs_event_type = arrCol.get(32).equals("null")?"":(String)arrCol.get(32);

							rs_claim_status_desc = arrCol.get(33).equals("null")?"":(String)arrCol.get(33);

							rs_era_status_desc = arrCol.get(34).equals("null")?"":(String)arrCol.get(34);

							/*

							if (rs_claim_status.equals("2") || rs_claim_status.equals("3") || rs_claim_status.equals("4"))
								rs_claim_status_desc = rs_process_error_message;

								*/

							if (rs_claim_id.equals("0"))
								rs_claim_id = "";

                            String result = "";
							SimpleDateFormat sdf;
							SimpleDateFormat sdf1;
                            System.out.println(":: rs_mk_era_date :: "+rs_mk_era_date);

							String hideTable = "style='display:none;'";

							/*try {
								//sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
								//sdf1 = new SimpleDateFormat("dd/MM/yyyy");
								//rs_era_date = sdf1.format(sdf.parse(rs_era_date));
								SimpleDateFormat sourceDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
								Date dateObj = sourceDateFormat.parse(rs_trans_date);
								SimpleDateFormat desiredDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
								rs_trans_date = desiredDateFormat.format(dateObj).toString();

								SimpleDateFormat sourceDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
								Date dateObj1 = sourceDateFormat1.parse(rs_mk_era_date);
								SimpleDateFormat desiredDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
								rs_mk_era_date = desiredDateFormat1.format(dateObj1).toString();


								 System.out.println(":: rs_mk_era_date :: "+rs_mk_era_date);
							}
							catch(Exception e) {
								e.printStackTrace();
							}*/
							l_adj_query = "Select CLAIM_ID, PROV_CLAIM_NO,TO_CHAR (ADJUSTMENT_DATE,'DD/MM/YYYY') ADJUSTMENT_DATE,TO_CHAR (ADJUSTMENT_AMOUNT, 9999990.99) ADJUSTMENT_AMOUNT, ADJUSTMENT_DESC" 
												+" from XF_ERA_ADJ a, XF_ERA_CLAIM b"
												+"		where A.MK_ERA_NO = B.MK_ERA_NO"
												+"				and A.BILL_DOC_TYPE_CODE = B.BILL_DOC_TYPE_CODE"
												+"				and A.BILL_DOC_NUMBER = B.BILL_DOC_NUMBER "
												+"				and A.MK_ERA_NO = ? AND B.PROV_CLAIM_NO = ? ";

							System.out.println("l_adj_query...."+l_adj_query);

							pstmt = conn.prepareStatement(l_adj_query);
							pstmt.setString(1, rs_mk_era_no);
							pstmt.setString(2, rs_claim_id);

							rs = pstmt.executeQuery();

							while(rs.next())
							{
								l_mk_era_no = rs.getString("CLAIM_ID")==null?"":rs.getString("CLAIM_ID"); 
								l_prov_claim_id =  rs.getString("PROV_CLAIM_NO")==null?"":rs.getString("PROV_CLAIM_NO");
								l_adj_amount = rs.getString("ADJUSTMENT_AMOUNT")==null?"":rs.getString("ADJUSTMENT_AMOUNT"); 
								l_adj_desc = rs.getString("ADJUSTMENT_DESC")==null?"":rs.getString("ADJUSTMENT_DESC"); 
								l_adj_date = rs.getString("ADJUSTMENT_DATE")==null?"":rs.getString("ADJUSTMENT_DATE"); 

								arrColumns.add(l_mk_era_no);
								arrColumns.add(l_prov_claim_id);
								arrColumns.add(l_adj_amount);
								arrColumns.add(l_adj_desc);
								arrColumns.add(l_adj_date);

								arrRows.add(arrColumns);
								arrColumns = new ArrayList();
								arrColumns.clear();
							}
    						currentSubGroup = rs_mk_era_no+"@"+rs_mk_era_date+"@"+rs_scheme_name+"@"+rs_era_type+"@"+rs_prov_paid_amount;
							System.out.println("currentSubGroup...."+currentSubGroup);			
									
							if (!currentSubGroup.equalsIgnoreCase(prevSubGroup))
							{
								if (j>0) {
									out.println("</table>");
									out.println("</td>");
									out.println("</tr>");
								}
								String str="";							
								out.println("<tr width='100%' id = 'trGrpHeader"+j+"' >");								
								out.println("<td width='300' style='display:block' class='CAGROUP' >"+rs_mk_era_no+"&nbsp;</td>");
								out.println("<td width='300' style='display:block' class='CAGROUP'>"+rs_mk_era_date+"&nbsp;</td>");
								out.println("<td width='300' style='display:block' class='CAGROUP'>"+rs_scheme_name+"&nbsp;</td>");
								out.println("<td width='300' style='display:block' class='CAGROUP'>"+rs_era_type+"&nbsp;</td>");
								out.println("<td width='300' style='display:block' class='CAGROUP'>"+rs_era_trans_no+"&nbsp;</td>");
								out.println("<td width='300' class='CAGROUP' align = \"right\" >&nbsp;"+rs_prov_paid_amount+"</td>");
								out.println("<td width='300' style='display:block' class='CAGROUP' align = \"right\" >"+rs_era_status_desc+"&nbsp; </td>");
								out.println("</tr>");
								out.println("<tr>");
								out.println("<td colspan = \"7\">");
								out.println("<table  cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" border=\"1\" align=\"center\">");
								out.println("<tr>");
								out.println("<td class='COLUMNSUBHEADER' style=\"font-size:11px;\" width='3%'>");
									out.println("<font color=white >View</font>");
								out.println("</td>	");
								out.println("<td class='COLUMNSUBHEADER' style=\"font-size:11px;\" width='5%'>");
									out.println("<font color=white >Claim Id</font>");
								out.println("</td>	");
								out.println("<td class='COLUMNSUBHEADER' style=\"font-size:11px;\" width='8%'>");
									out.println("<font color=white>Bill Doc. Type  Bill No.</font>");
								out.println("</td>");
								out.println("<td class='COLUMNSUBHEADER' style=\"font-size:11px;\" width='7%'>");
									out.println("<font color=white>Patient ID</font>");
								out.println("</td>");
								out.println("<td class='COLUMNSUBHEADER' style=\"font-size:11px;\" width='15%'>");
									out.println("<font color=white><fmt:message key=\"Common.PatientName.label\" bundle=\"${common_labels}\"/></font>");
								out.println("</td>");
								out.println("<td class='COLUMNSUBHEADER' style=\"font-size:11px;\" width='7%'>");
									out.println("<font color=white>Policy No</font>");
								out.println("</td>");
								out.println("<td class='COLUMNSUBHEADER' style=\"font-size:11px;\" width='8%' align = \"right\">");
									out.println("<font color=white>Claimed Amount</font>");
								out.println("</td>");
								out.println("<td class='COLUMNSUBHEADER' style=\"font-size:11px;\" width='8%' align = \"right\">");
									out.println("<font color=white>Approved Amount</font>");
								out.println("</td>");
								out.println("<td class='COLUMNSUBHEADER' style=\"font-size:11px;\" width='8%' align = \"right\">");
									out.println("<font color=white >Received Amount</font>");
								out.println("</td>	");								
								out.println("<td class='COLUMNSUBHEADER'  style=\"font-size:11px;\" width='15%'>");
									out.println("<font color=white><fmt:message key=\"eXH.claimstatus.label\" bundle=\"${xh_labels}\"/>Claim Status</font>");
								out.println("<td class='COLUMNSUBHEADER'  style=\"font-size:11px;\" width='15%'>");
									out.println("<font color=white>Status Description</font>");
								out.println("</td>");															
								out.println("</tr>");
								out.println("<tr>");
							}
							else
							{
								out.println("<tr>");
							}

                            checkboxvalue = "<img src='../../eXH/images/ViewDetails.gif' style='width:20px; height: 20px;' alt='Check Details' align='middle'   onClick='checkEligibility(this)'  trans_num='"+rs_claim_id+"' event_type='"+rs_event_type+"'  era_id='"+rs_mk_era_no+"'>";
							//checkboxvalue =rs_patient_id+"$!^"+rs_sex+"$!^"+rs_family_name+"$!^"+rs_episode_id+"$!^"+rs_encounter_id+"$!^"+rs_patient_class+"$!^"+rs_visit_adm_date_time+"$!^"+rs_visit_adm_type+"$!^"+rs_service_code+"$!^"+rs_discharge_date_time+"$!^"+rs_operating_facility_id+"$!^"+rs_doc_type_code+"$!^"+rs_doc_num+"$!^"+rs_doc_date+"$!^"+rs_bill_from_date+"$!^"+rs_bill_to_date+"$!^"+rs_visit_id+"$!^"+rs_cust_code+"$!^"+rs_blng_grp_id+"$!^";		
							if(arrRows.size()>0)
							{
								l_adj_image_str = "<img src='../../eXH/images/ViewDetails.gif' style='width:15px; height: 15px;margin-top :-15px;' alt='View Adjustment Details' align='right' onClick=\"toggle('"+rs_mk_era_no+""+rs_claim_id+"')\"/>";
							}
							else
								l_adj_image_str = "";

							out.println("<td class='gridData' align='center'>"+checkboxvalue+"</td>");
							out.println("<td  class='gridData' style=\"font-size:11px;\"> "+rs_claim_id+" "+l_adj_image_str+"&nbsp;</td>");
							out.println("<td  class='gridData' style=\"font-size:11px;\"> "+rs_bill_doc_type_code+"/"+rs_bill_doc_number+"&nbsp; </td>");
							out.println("<td  class='gridData' style=\"font-size:11px;\"> "+rs_patient_id+"&nbsp; </td>");
							out.println("<td  class='gridData' style=\"font-size:11px;\"> "+rs_patient_name+" &nbsp;</td>");
							out.println("<td  class='gridData' style=\"font-size:11px;\"> "+rs_mem_plicy_num+"&nbsp; </td>");
							out.println("<td  class='gridNumericData' style=\"font-size:11px;\" align = \"right\" > &nbsp; "+rs_claimed_amount+"</td>");
							out.println("<td  class='gridNumericData' style=\"font-size:11px;\" align = \"right\" > &nbsp; "+rs_approved_amount+"</td>");
							out.println("<td  class='gridNumericData' style=\"font-size:11px;\" align = \"right\" > &nbsp;"+rs_paid_to_provider+" </td>");
							out.println("<td  class='gridData' style=\"font-size:11px;\"> "+rs_claim_status_desc+"&nbsp; </td>");
							out.println("<td  class='gridData' style=\"font-size:11px;\"> "+rs_process_error_message+"&nbsp; </td>");
							out.println("</tr>");

							String id="hidethis"+rs_mk_era_no+""+rs_claim_id;
                            if(arrRows.size()>0)
							{
								
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(hideTable));
            _bw.write(_wl_block21Bytes, _wl_block21);

								out.println("<td colspan = \"10\">");
								out.println("<table  cellspacing=\"0\" cellpadding=\"3\" width=\"95%\" border=\"1\" align=\"right\" border=\"1\" align=\"center\">");
								out.println("<tr>");
								out.println("<td class='COLUMNSUBHEADER'  style=\"font-size:11px;\" width='8%'>");
									out.println("<font color=white ><fmt:message key=\"eXH.ClaimNumber.label\" bundle=\"${xh_labels}\"/></font>");
								out.println("</td>	");
								out.println("<td class='COLUMNSUBHEADER'  style=\"font-size:11px;\" width='8%'>");
									out.println("<font color=white ><fmt:message key=\"eBL.ADJUSTMENT_AMT.label\" bundle=\"${bl_labels}\"/></font>");
								out.println("</td>	");
								out.println("<td class='COLUMNSUBHEADER'  style=\"font-size:11px;\" width='20%'>");
									out.println("<font color=white><fmt:message key=\"eXH.adjDesc.label\" bundle=\"${xh_labels}\"/></font>");
								out.println("</td>");
								out.println("<td class='COLUMNSUBHEADER'  style=\"font-size:11px;\" width='14%'>");
									out.println("<font color=white><fmt:message key=\"eXH.adjDate.label\" bundle=\"${xh_labels}\"/></font>");
								out.println("</td>");
								out.println("</tr>");
								
								for (int k=0; k<arrRows.size();k++)
								 {
									arrColumns = (ArrayList)arrRows.get(k);
									out.println("<tr>");
									out.println("<td  class='gridData' style=\"font-size:11px;\"> "+arrColumns.get(1)+"&nbsp; </td>");
									out.println("<td  class='gridNumericData' style=\"font-size:11px;\"align = \"right\">&nbsp; "+arrColumns.get(2)+" </td>");
									out.println("<td  class='gridData' style=\"font-size:11px;\"> "+arrColumns.get(3)+"&nbsp; </td>");
									out.println("<td  class='gridData' style=\"font-size:11px;\"> "+arrColumns.get(4)+"&nbsp; </td>");
									out.println("</tr>");
									arrColumns.clear();
								}
								
								out.println("</table>");
								out.println("</td>");
								out.println("</tr>");
								
							}
                            if(arrRows!=null) arrRows.clear();

							if (!currentSubGroup.equalsIgnoreCase(prevSubGroup)){

							}
							prevSubGroup = currentSubGroup; 
							System.out.println("prevSubGroup...."+prevSubGroup);
							}
							if ((j>0) ){
								out.println("</table>");
								out.println("</td>");
								out.println("</tr>");			
							}
						
            _bw.write(_wl_block22Bytes, _wl_block22);

				}
				if(arrRow!=null) arrRow.clear();
				if(arrCol!=null) arrCol.clear();
				if(resultsQry!=null) resultsQry.clear();

			}catch(Exception e1)
				{
				 out.println("(MediERAQueryResult.jsp:Exception) "+e1);
				 e1.printStackTrace(System.err);
				}
				finally
				{
				ConnectionManager.returnConnection(conn);
				}
	
            _bw.write(_wl_block23Bytes, _wl_block23);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ERANumber.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ERADate.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.schemecode.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ERAtype.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Transaction.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.NUM.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAID_AMT.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }
}
