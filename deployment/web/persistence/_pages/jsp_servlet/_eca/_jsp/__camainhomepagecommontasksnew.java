package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __camainhomepagecommontasksnew extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAMainHomePageCommonTasksNew.jsp", 1709115548527L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n<HEAD>\n<TITLE>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" </TITLE>\n<META NAME=\"Generator\" CONTENT=\"EditPlus\">\n<META NAME=\"Author\" CONTENT=\"\">\n<META NAME=\"Keywords\" CONTENT=\"\">\n<META NAME=\"Description\" CONTENT=\"\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'styleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\"../../eCA/js/CAMainCommonTasks.js\"></script>\n\t<script language=javascript src=\'../../eCA/js/CAMainMyTasks.js\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></SCRIPT>\n</HEAD>\n\n<BODY  OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<!--<script language=javascript>\ndocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\ndocument.body.style.scrollbarArrowColor=\'#000080\';\ndocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\ndocument.body.style.scrollbarHighlightColor=\'white\';\ndocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n-->\n<form>\n<!-- <b><font color=\'red\'>Common Tasks List</font></b> -->\n<!--<table border=\'0\' width=\'100%\' id=\'dataTitleTable\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' >\n<tr><td  colspan=\'5\' class=\'COMMONTOOLBARFUNCTION\' style=\'border:0\'><b>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</b>\n</td></tr>\n</table> -->\n<table cellspacing=\'0\' border=1 cellpadding=3 width=\'100%\' align=\'center\'>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' nowrap>\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<a class=\'gridLink\' href=\'javascript:pendingAuth();\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="(";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =")</a>\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="(0) \n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t\n\t\t \n   \t    ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t<a class=\'gridLink\' href=\'javascript:pendingCosign();\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="(0)\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t<tr>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' nowrap>\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t<a class=\'gridLink\' href=\"javascript:;\" onClick=\"return funMedicationsDue()\">\n\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =")</a>\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t</td>\n\t\t</tr>\n\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t<a class=\'gridLink\' href=\"javascript:;\" onClick=\"pendingConsent(\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\')\">\n\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t</td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t<a class=\'gridLink\' href=\"javascript:;\" onClick=\"pendingAppointment()\">\n\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' >&nbsp;</td>\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n</table>\n<input type=\'hidden\' name=\"queryString\" id=\"queryString\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"></input>\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
 
	Connection con = null;
	PreparedStatement pstmtComp = null,pstmtDesc = null,pstmtDesc1 = null;
	ResultSet rsComp = null, rsDesc = null;
	
	int totCount=0;
	String classValue = "";
	StringBuffer sql=null,sql1=null; // new StringBuffer();
	String compId="";
	String comp_desc="";
	//String applicable_yn="";
	int i = 0;
	StringBuffer toolTipStr = new StringBuffer();

	String pract_type =(String) session.getValue("practitioner_type") == null ? "" :(String) session.getValue("practitioner_type");
	String practitioner_id=(String)request.getParameter("practitioner_id") == null ? "" : (String)request.getParameter("practitioner_id");

	String facility_id=(String) session.getValue("facility_id");
	String Clin_id=(String)session.getValue("ca_practitioner_id");
	String responsibility_id		= (String)session.getValue("responsibility_id");
	if(responsibility_id==null) responsibility_id = "";
	
	try
	{
		con=ConnectionManager.getConnection(request);
		//pstmtComp = con.prepareStatement("SELECT COMP_ID, NVL((SELECT 'Y' FROM ca_personalized_home_page WHERE PRACT_TYPE =? AND PRACTITIONER_ID = ? AND COMP_ID=CA_HOME_PAGE_COMP.COMP_ID AND ROWNUM=1), 'N') applicable_yn FROM CA_HOME_PAGE_COMP where  COMP_ID in ('PEND_AUTH'	,'PEN_COSIGN','PRES_MEDI','PEND_CONST','PEND_APPT') ");
		pstmtComp = con.prepareStatement("SELECT COMP_ID, (select COMP_DESC FROM CA_HOME_PAGE_COMP where COMP_ID = A.COMP_ID) COMP_DESC FROM ca_personalized_home_page A WHERE PRACT_TYPE =? AND PRACTITIONER_ID = ? AND COMP_ID in ('PEND_AUTH'	,'PEN_COSIGN','PRES_MEDI','PEND_CONST','PEND_APPT') ");
		pstmtComp.setString(1,pract_type);
		pstmtComp.setString(2,practitioner_id);
		rsComp = pstmtComp.executeQuery();

	    sql= new StringBuffer();
		sql.append("SELECT COUNT (*) tot_cnt   FROM OR_ORDER_PEND_STATUS_LOG a  WHERE a.PEND_STATUS_IND=? and ORDERING_FACILITY_ID=? and a.ORDER_DATE BETWEEN TRUNC (SYSDATE - 7) AND SYSDATE   and ( SOURCE_TYPE='R' or (a.source_type, a.source_code) IN (                      SELECT DECODE (locn_type, 'W', 'N', locn_type),                             locn_code                        FROM ca_pract_by_locn_view                       WHERE facility_id = ? AND practitioner_id = ?))  AND ORDER_CATEGORY IN  (select order_Category from or_review_user_categories  where (practitioner_id =?  or resp_id = ?)  and DECODE(?,'CS',COSIGN_YN,'PO',AUTH_YN ,'PS', SPL_APPR_YN )= 'Y')   ");
		pstmtDesc=con.prepareStatement(sql.toString());
		
		while(rsComp.next())
		{
			i = i+1;
			//if ( i % 2 == 0 )
				classValue = "WHITEROW" ;
			//else
				//classValue = "CAQUERYODD" ;
		//pending Authorization
		compId=rsComp.getString("COMP_ID");
		comp_desc=rsComp.getString("COMP_DESC");
		toolTipStr = new StringBuffer();
	    if(compId.equals("PEND_AUTH"))
		{
			//classValue = "CAQUERYEVEN";
			
			 	//	     sql= new StringBuffer();

			//sql.append("SELECT COUNT (*) tot_cnt   FROM or_order a  WHERE a.ord_date_time BETWEEN TRUNC (SYSDATE - 7) AND SYSDATE  AND ordering_facility_id = ?  AND a.order_status = (SELECT order_status_code                            FROM or_order_status_code                           WHERE order_status_type = '03')     AND NVL (cont_order_ind, 'DO') IN ('CO', 'DO', 'CR', 'DR')    AND ord_auth_reqd_yn = 'Y'    and (a.source_type, a.source_code) IN (                      SELECT DECODE (locn_type, 'W', 'N', locn_type),                             locn_code                        FROM ca_pract_by_locn_view                       WHERE facility_id = ? AND practitioner_id = ?) ");
			
		
			//pstmtDesc=con.prepareStatement(sql.toString());
			pstmtDesc.setString(1,"PO");
			pstmtDesc.setString(2,facility_id);
			pstmtDesc.setString(3,facility_id);
			pstmtDesc.setString(4,Clin_id);
			pstmtDesc.setString(5,Clin_id);
			pstmtDesc.setString(6,responsibility_id);
			pstmtDesc.setString(7,"PO");
			rsDesc=pstmtDesc.executeQuery();
			totCount = 0;
			
			while (rsDesc.next())
			{
				totCount =rsDesc.getInt(1);
			}
			if(rsDesc!=null)rsDesc.close();
			//if(pstmtDesc!=null)pstmtDesc.close();
			//sql=null;
		
			
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block11Bytes, _wl_block11);
 if (totCount!=0) 
					{ 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(totCount));
            _bw.write(_wl_block14Bytes, _wl_block14);
 }
					else
					{
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
 } 
            _bw.write(_wl_block17Bytes, _wl_block17);
}
			else if(compId.equals("PEN_COSIGN")){ //classValue = "CAQUERYEVEN";
            _bw.write(_wl_block18Bytes, _wl_block18);

			
			//Pending Cosign
			toolTipStr = new StringBuffer();
			
 		    //sql= new StringBuffer();
			totCount=0;
			//sql.append(" SELECT count(*) tot_cnt     FROM or_order a     WHERE  	      a.ord_date_time BETWEEN trunc(SYSDATE - 7) AND SYSDATE      AND  a.ordering_facility_id = ?      AND  ord_cosign_reqd_yn = 'Y' 	 AND (a.source_type, a.source_code) IN (SELECT decode(locn_type, 'W', 'N',                                                     locn_type), locn_code                FROM ca_pract_by_locn_view                WHERE facility_id = ?                  AND practitioner_id = ?)  	 AND  ord_cosign_by_pract_id IS NULL       AND ord_cosign_date_time IS NULL   ");

			//pstmtDesc=con.prepareStatement(sql.toString());
			pstmtDesc.setString(1,"CS");
			pstmtDesc.setString(2,facility_id);
			pstmtDesc.setString(3,facility_id);
			pstmtDesc.setString(4,Clin_id);
			pstmtDesc.setString(5,Clin_id);
			pstmtDesc.setString(6,responsibility_id);
			pstmtDesc.setString(7,"CS");
			rsDesc=pstmtDesc.executeQuery();
			totCount=0;
			while (rsDesc.next())
			{
				totCount=rsDesc.getInt(1);
			}

		if(rsDesc!=null)rsDesc.close();
		//if(pstmtDesc!=null)pstmtDesc.close();
			//sql=null;
			
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block11Bytes, _wl_block11);
 if (totCount!=0)
					{ 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(totCount));
            _bw.write(_wl_block14Bytes, _wl_block14);
 }
				else
				{ 
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
 } 
            _bw.write(_wl_block21Bytes, _wl_block21);

			
			}else if(compId.equals("PRES_MEDI")		){
				//classValue = "CAQUERYODD";
		
		//Expire/Expired
		
 		 sql1= new StringBuffer();
		toolTipStr = new StringBuffer();
		totCount=0;
		sql1.append("select count(*) count from  or_ordeR_line a , or_order c where C.ORD_DATE_TIME BETWEEN TRUNC(SYSDATE-30) AND SYSDATE   and a.CONT_ORDER_IND in ('CO','CR') and  a.order_Category ='PH' and c.order_id=a.order_id and (NVL(END_DATE_TIME,SYSDATE) >= sysdate  and          ABS(round(TO_NUMBER(TO_CHAR(NVL(END_DATE_TIME,SYSDATE)- SYSDATE)) * 24,2))   <  (select SINGLE_CONT_RENEW_HRS_BEHIND from   or_param_by_facility   where operating_facility_id = ?) and order_line_Status  not in (select order_status_Code from or_order_Status_Code where      order_STatus_type in ('92','96','99')) and end_date_time is not null or NVL(END_DATE_TIME,SYSDATE) < sysdate  and ABS(round(TO_NUMBER(TO_CHAR(SYSDATE -NVL(end_date_time,SYSDATE))) * 24,2))  <   (select SINGLE_CONT_RENEW_HRS_AHEAD from or_param_by_facility where operating_facility_id = ?) and order_line_Status  not in (select order_status_Code from or_order_Status_Code where order_STatus_type in ('92','96','99')) ) and end_date_time is not null and (c.source_type,c.source_Code) in (select DECODE(LOCN_TYPE,'W','N',LOCN_TYPE),locn_code from CA_PRACT_BY_LOCN_VIEW where  FACILITY_ID=? AND practitioner_id= ? ) and c.ord_pract_id =? ");

		pstmtDesc1 = con.prepareStatement(sql1.toString());
		pstmtDesc1.setString(1,facility_id);	
		pstmtDesc1.setString(2,facility_id);	
		pstmtDesc1.setString(3,facility_id);	
		pstmtDesc1.setString(4,Clin_id);	
		pstmtDesc1.setString(5,Clin_id);	
		rsDesc = pstmtDesc1.executeQuery();

		while(rsDesc.next()){
			totCount=rsDesc.getInt(1);
		}
			if(rsDesc!=null)rsDesc.close();
			if(pstmtDesc1!=null)pstmtDesc1.close();
			sql1=null;
		
		
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
if(totCount != 0){
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(totCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
}else{
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block27Bytes, _wl_block27);


		}else if(compId.equals("PEND_CONST")){
			//classValue = "CAQUERYODD";
				

	//Pending Consent
		
 		sql1= new StringBuffer();
		toolTipStr = new StringBuffer();
		totCount=0;
		sql1.append("SELECT COUNT (*) tot_cnt   FROM OR_ORDER_PEND_STATUS_LOG a  WHERE a.PEND_STATUS_IND=? and ORDERING_FACILITY_ID=? and a.ORDER_DATE BETWEEN TRUNC(SYSDATE - 7) AND TRUNC(SYSDATE)+.9999   and ( a.SOURCE_TYPE='R' or (a.source_type, a.source_code) IN (                      SELECT DECODE (locn_type, 'W', 'N', locn_type),                             locn_code                        FROM ca_pract_by_locn_view                       WHERE facility_id = ? AND practitioner_id = ?)) ");

		//sql1.append("select  count(*) totalCount from or_order A WHERE a.ordering_facility_id = ? and a.ORD_CONSENT_REQD_YN = 'Y' AND (a.ORDER_STATUS =  (select order_status_code from  or_order_status_code where ORDER_STATUS_Type ='00') OR exists (select 'Y' from or_order_line b,or_order_Status_code c  where b.order_id = a.order_id and b.order_line_Status = c.order_Status_code and c.order_Status_type not in ('99','97','94')   and ORD_CONSENT_STATUS = 'P' and rownum <=1)) And ( a.source_type !='R'  and (a.source_type,a.source_CODE) IN (SELECT DECODE(LOCN_TYPE,'W','N',LOCN_TYPE),locn_code FROM ca_pract_by_locn_view WHERE practitioner_id=?) or  a.source_type ='R' ) and a.ORD_DATE_TIME  between TRUNC (SYSDATE - 7) AND SYSDATE "); 


		pstmtDesc1 = con.prepareStatement(sql1.toString());
        pstmtDesc1.setString(1,"PC");	
        pstmtDesc1.setString(2,facility_id);	
        pstmtDesc1.setString(3,facility_id);	
		pstmtDesc1.setString(4,Clin_id);	
		rsDesc = pstmtDesc1.executeQuery();
		while(rsDesc.next())
		{
			totCount=rsDesc.getInt(1);
		}

		if(rsDesc!=null) rsDesc.close();
		if(pstmtDesc1!=null) pstmtDesc1.close();
		sql1=null;
	
		
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
if(totCount != 0){
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(totCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
}else{
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block30Bytes, _wl_block30);

			
			}else if(compId.equals("PEND_APPT")){
			//classValue = "CAQUERYODD";
				

	//Pending Consent
		
 		sql1= new StringBuffer();
		toolTipStr = new StringBuffer();
		totCount=0;
		sql1.append("SELECT COUNT (*) tot_cnt   FROM OR_ORDER_PEND_STATUS_LOG a  WHERE a.PEND_STATUS_IND=? and ORDERING_FACILITY_ID=? and a.ORDER_DATE BETWEEN TRUNC (SYSDATE - 7) AND SYSDATE   and (a.source_type='R' OR (a.source_type, a.source_code) IN (                      SELECT DECODE (locn_type, 'W', 'N', locn_type),                             locn_code                        FROM ca_pract_by_locn_view                       WHERE facility_id = ? AND practitioner_id = ?)) ");

		//sql1.append("select  count(*) totalCount from or_order A WHERE a.ordering_facility_id = ? and a.ORD_CONSENT_REQD_YN = 'Y' AND (a.ORDER_STATUS =  (select order_status_code from  or_order_status_code where ORDER_STATUS_Type ='00') OR exists (select 'Y' from or_order_line b,or_order_Status_code c  where b.order_id = a.order_id and b.order_line_Status = c.order_Status_code and c.order_Status_type not in ('99','97','94')   and ORD_CONSENT_STATUS = 'P' and rownum <=1)) And ( a.source_type !='R'  and (a.source_type,a.source_CODE) IN (SELECT DECODE(LOCN_TYPE,'W','N',LOCN_TYPE),locn_code FROM ca_pract_by_locn_view WHERE practitioner_id=?) or  a.source_type ='R' ) and a.ORD_DATE_TIME  between TRUNC (SYSDATE - 7) AND SYSDATE "); 


		pstmtDesc1 = con.prepareStatement(sql1.toString());
        pstmtDesc1.setString(1,"PA");	
        pstmtDesc1.setString(2,facility_id);	
        pstmtDesc1.setString(3,facility_id);	
		pstmtDesc1.setString(4,Clin_id);	
		rsDesc = pstmtDesc1.executeQuery();
		while(rsDesc.next())
		{
			totCount=rsDesc.getInt(1);
		}

		if(rsDesc!=null) rsDesc.close();
		if(pstmtDesc1!=null) pstmtDesc1.close();
		sql1=null;
	
		
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block23Bytes, _wl_block23);
if(totCount != 0){
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(totCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
}else{
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block30Bytes, _wl_block30);

			
			}
		}
		for(int j=i+1;j<=6;j++)
		{
			//if ( j % 2 == 0 )
				classValue = "WHITEROW" ;
			//else
				//classValue = "CAQUERYODD" ;
		
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block32Bytes, _wl_block32);

		}
		sql=null;
		if(pstmtDesc!=null) pstmtDesc.close();
		if(rsComp!=null) rsComp.close();
		if(pstmtComp!=null) pstmtComp.close();

		
	}
	catch(Exception e)
	{
		//out.println("Exception: "+e);//COMMON-ICN-0181
		e.printStackTrace();
	}
 
	finally
	{
		if(con != null) ConnectionManager.returnConnection(con,request);
	}

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NewDocument.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Orders.label", java.lang.String .class,"key"));
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
}
