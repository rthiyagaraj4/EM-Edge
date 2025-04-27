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

public final class __cahomepagepatientsnew extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAHomePagePatientsNew.jsp", 1709115538762L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n<HEAD>\n<TITLE> ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" </TITLE>\n<META NAME=\"Generator\" CONTENT=\"EditPlus\">\n<META NAME=\"Author\" CONTENT=\"\">\n<META NAME=\"Keywords\" CONTENT=\"\">\n<META NAME=\"Description\" CONTENT=\"\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'styleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCA/html/CAHomeIeStyle.css\'></link> -->\n<script language=javascript src=\'../../eCA/js/CAMainMyTasks.js\'></script>\n\n</HEAD>\n<BODY OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<!--<script language=javascript>\ndocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\ndocument.body.style.scrollbarArrowColor=\'#000080\';\ndocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\ndocument.body.style.scrollbarHighlightColor=\'white\';\ndocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n-->\n<STYLE TYPE=\"text/css\">\n\tTABLE.HOMETAB \n\t{\n\t\twidth : 100%;\n\t\tborder : 1;\n\t\tborder-spacing : 0px;\n\t\tpadding : 3px;\n\t}\n</STYLE>\n<form name=\"patientnewform\" id=\"patientnewform\">\n<!-- <b><font color=\'red\'>Common Tasks List</font></b> -->\n<!--<table border=\'0\' width=\'100%\' id=\'dataTitleTable\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' >\n<tr><td  colspan=\'5\' class=\'COMMONTOOLBARFUNCTION\' style=\'border:0\'><b>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</b>\n</td></tr>\n</table> -->\n\n<table cellspacing=\'0\' cellpadding=3  border=1 width=100% align=\'center\'> \n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' nowrap>\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t<a class=\'gridLink\'  href=\'javascript:callPatientList(\"OP\");\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="(";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =")\n\t\t\t\t\t</a>\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="(0) \n\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t<a class=\'gridLink\'  href=\'javascript:callPatientList(\"EM\");\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="(0)\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t</tr>\n\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t<a class=\'gridLink\'  href=\'javascript:callPatientList(\"IP\");\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =")</a>\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t<a class=\'gridLink\'  href=\'javascript:callPatientList(\"DC\");\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t<a class=\'gridLink\' href=\'javascript:callReferralRequest(\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\");\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' nowrap>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t<a class=\'gridLink\' href=\'javascript:callReportRequest();\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =")</a>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="(0) \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t\t\t\t\t\t\t<b>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</b>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" (";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =")";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t&nbsp;&nbsp;";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\t\t\t\t\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' >&nbsp;</td>\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\n</table>\n<input type=\'hidden\' name=\"queryString\" id=\"queryString\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"></input>\n<input type=\'hidden\' name=\"pract_id\" id=\"pract_id\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"></input>\n<input type=\'hidden\' name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\"></input>\n<form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

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

	int count =0;
	int totCount = 0;
	String classValue = "WHITEROW";
	String order_category="";
	
	String pract_type =(String) session.getValue("practitioner_type") == null ? "" :(String) session.getValue("practitioner_type");
	String practitioner_id=(String)request.getParameter("practitioner_id") == null ? "" : (String)request.getParameter("practitioner_id");
	String Clin_id=(String)session.getValue("ca_practitioner_id");
	String facility_id=(String)session.getValue("facility_id");
	String sql1="";
	//String applicable_yn="";
	StringBuffer str = new StringBuffer();
	String comp_desc = "";
	int i = 0;
	try
	{
		
	PreparedStatement pstmt = null;
	ResultSet rset = null;
	PreparedStatement pstmtComp = null;
	ResultSet rsComp = null;
		con=ConnectionManager.getConnection(request);
		String s1="";
		//s1="SELECT COMP_ID, NVL((SELECT 'Y' FROM ca_personalized_home_page WHERE PRACT_TYPE =? AND PRACTITIONER_ID = ? AND COMP_ID=CA_HOME_PAGE_COMP.COMP_ID  AND ROWNUM=1), 'N') applicable_yn FROM CA_HOME_PAGE_COMP where  COMP_ID in ('OUTPATIENT','EMPATIENTS' ,'INPATIENTS','DCPATIENTS','REFERRALRQ','CONSULTS')";

		s1="SELECT COMP_ID, (select COMP_DESC FROM CA_HOME_PAGE_COMP where COMP_ID = A.COMP_ID) COMP_DESC FROM ca_personalized_home_page A WHERE PRACT_TYPE =? AND PRACTITIONER_ID = ? AND COMP_ID in ('OUTPATIENT','EMPATIENTS' ,'INPATIENTS','DCPATIENTS','REFERRALRQ','CONSULTS')";
	
		pstmtComp = con.prepareStatement(s1);
		pstmtComp.setString(1,pract_type);
		pstmtComp.setString(2,practitioner_id);
			
		rsComp = pstmtComp.executeQuery();
		while(rsComp.next())
		{
			i = i+1;
			//if ( i % 2 == 0 )
				classValue = "WHITEROW" ;
			//else
				//classValue = "CAQUERYODD" ;
			comp_desc = rsComp.getString("COMP_DESC");
			if(rsComp.getString("COMP_ID").equals("OUTPATIENT"))
			{
				//classValue = "CAQUERYODD";
			
			//referral 
			
            _bw.write(_wl_block10Bytes, _wl_block10);

			//Outpatients 
			order_category="";
			str = new StringBuffer();
			count=0; totCount=0;
			sql1="select count(*) from PR_ENCOUNTER Where facility_id =? and ATTEND_PRACTITIONER_ID = ? and VISIT_STATUS in ('01','02','03','04','05','06') and VISIT_ADM_DATE_TIME between trunc(sysdate) and trunc(sysdate)+1  and PATIENT_CLASS=? ";

			pstmt=con.prepareStatement(sql1);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,Clin_id);
			pstmt.setString(3,"OP");
			rset=pstmt.executeQuery();
			if (rset!=null) str = new StringBuffer();
			while (rset.next())
			{
				totCount=rset.getInt(1);
			}

			if(rset!=null)rset.close();
			if(pstmt!=null)pstmt.close();
			
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block12Bytes, _wl_block12);
 if (totCount!=0) { 
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(totCount));
            _bw.write(_wl_block15Bytes, _wl_block15);
 }else{
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);
 } 
            _bw.write(_wl_block18Bytes, _wl_block18);

			}
			else if(rsComp.getString("COMP_ID").equals("EMPATIENTS"))
			{
				//classValue = "CAQUERYODD";
				
			//referral 
			
			
            _bw.write(_wl_block10Bytes, _wl_block10);

			//Outpatients 
			order_category="";
			str = new StringBuffer();
			count=0; totCount=0;
			sql1="select count(*) from PR_ENCOUNTER Where facility_id =? and ATTEND_PRACTITIONER_ID = ? and VISIT_STATUS in ('01','02','03','04','05','06') and VISIT_ADM_DATE_TIME between trunc(sysdate) and trunc(sysdate)+1  and PATIENT_CLASS=? ";

			pstmt=con.prepareStatement(sql1);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,Clin_id);
			pstmt.setString(3,"EM");
			rset=pstmt.executeQuery();
			if (rset!=null) str = new StringBuffer();
			while (rset.next())
			{
				totCount=rset.getInt(1);
			}

			if(rset!=null)rset.close();
			if(pstmt!=null)pstmt.close();
			
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block12Bytes, _wl_block12);
 if (totCount!=0) { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(totCount));
            _bw.write(_wl_block15Bytes, _wl_block15);
 }else{
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
 } 
            _bw.write(_wl_block21Bytes, _wl_block21);

			}
			else if(rsComp.getString("COMP_ID").equals("INPATIENTS"))
			{
				//classValue = "CAQUERYEVEN";
				
		//Outpatients 
			
			order_category="";
			str = new StringBuffer();
			count=0; totCount=0;
			sql1="select count(*) from IP_OPEN_ENCOUNTER a Where a.facility_id =? AND  ATTEND_PRACTITIONER_ID=? AND PATIENT_CLASS=? AND ADT_STATUS IN ('00','01')";

			pstmt=con.prepareStatement(sql1);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,Clin_id);
			pstmt.setString(3,"IP");
			rset=pstmt.executeQuery();
			if (rset!=null) str = new StringBuffer();
			while (rset.next())
			{
				totCount=rset.getInt(1);
			}

			if(rset!=null)rset.close();
			if(pstmt!=null)pstmt.close();
			
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block12Bytes, _wl_block12);
 if (totCount!=0) { 
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(totCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
 }else{
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);
 } 
            _bw.write(_wl_block18Bytes, _wl_block18);

			}	else if(rsComp.getString("COMP_ID").equals("DCPATIENTS")){
				//classValue = "CAQUERYEVEN";
				
		//Outpatients 
			
			order_category="";
			str = new StringBuffer();
			count=0; totCount=0;
			sql1="select count(*) from IP_OPEN_ENCOUNTER a Where a.facility_id =? AND ATTEND_PRACTITIONER_ID=? AND PATIENT_CLASS=? AND ADT_STATUS IN ('00','01')";

			pstmt=con.prepareStatement(sql1);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,Clin_id);
			pstmt.setString(3,"DC");
			rset=pstmt.executeQuery();
			if (rset!=null) str = new StringBuffer();
			while (rset.next())
			{
				totCount=rset.getInt(1);
			}
			
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block12Bytes, _wl_block12);
 if (totCount!=0) { 
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(totCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
 }else{
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);
 } 
            _bw.write(_wl_block18Bytes, _wl_block18);

			}else if(rsComp.getString("COMP_ID").equals("REFERRALRQ")){
				//classValue = "CAQUERYEVEN";
				
		//Outpatients 
			
			order_category="";
			str = new StringBuffer();
			count=0; totCount=0;
			sql1="SELECT count(*) FROM ip_open_encounter a, pr_referral_register b WHERE a.facility_id = ? AND b.preferred_treatment_date <= SYSDATE AND b.bedside_referral_yn = 'Y' AND b.bedside_ref_seen_date IS NULL AND a.facility_id = b.from_facility_id AND a.encounter_id = b.from_encounter_id AND b.to_pract_id=? ORDER BY encounter_id, preferred_treatment_date ";

			pstmt=con.prepareStatement(sql1);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,Clin_id);
			rset=pstmt.executeQuery();
			if (rset!=null) str = new StringBuffer();
			while (rset.next())
			{
				totCount=rset.getInt(1);
			}
			
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block12Bytes, _wl_block12);
 if (totCount!=0) { 
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(totCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
 }else{
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
 } 
            _bw.write(_wl_block18Bytes, _wl_block18);

			}
			else if(rsComp.getString("COMP_ID").equals("MEDREPREQ"))
			{
				//classValue = "CAQUERYODD";
				
					order_category="";
					str = new StringBuffer();
					count=0; totCount=0;
					sql1="select count(*) from mr_report_request_hdr where facility_id = ? and ( forwarded_pract_id = ? or forwarded_hod_cord_id = ?) and request_status in ('03','06','05')";

					pstmt=con.prepareStatement(sql1);
					pstmt.setString(1,facility_id);
					pstmt.setString(2,Clin_id);
					pstmt.setString(3,Clin_id);
					rset=pstmt.executeQuery();
					if (rset!=null) str = new StringBuffer();
					while (rset.next())
					{
						totCount=rset.getInt(1);
					}
					
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block28Bytes, _wl_block28);
 if (totCount!=0) { 
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(totCount));
            _bw.write(_wl_block30Bytes, _wl_block30);
 }else{
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block32Bytes, _wl_block32);
 } 
            _bw.write(_wl_block33Bytes, _wl_block33);

			}
			else if(rsComp.getString("COMP_ID").equals("CONSULTS"))
			{
				//classValue = "CAQUERYODD";
				
					int totCountUnAsgn = 0;
					int totCountSelf = 0;
					String anchorObjStart = "";
					String anchorObjEnd = "";

					StringBuffer sqlUnAssigned = new StringBuffer("SELECT count(*)   FROM PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID=?  and status='O' and TO_PRACT_ID IS NULL  and TO_SPECIALITY_CODE in (SELECT pRIMARY_SPECIALITY_CODE from am_practitioner where PRACTITIONER_ID=?  union all SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES  WHERE FACILITY_ID=? AND PRACTITIONER_ID=?)");

					pstmt=con.prepareStatement(sqlUnAssigned.toString());
					pstmt.setString(1,facility_id);
					pstmt.setString(2,Clin_id);
					pstmt.setString(3,facility_id);
					pstmt.setString(4,Clin_id);

					rset=pstmt.executeQuery();

					while (rset.next())
					{
						totCountUnAsgn = rset.getInt(1);
					}

					if(rset != null) rset.close();
					if(pstmt != null) pstmt.close();
					sqlUnAssigned.setLength(0);

					sqlUnAssigned = new StringBuffer("SELECT count(*)   FROM PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID=?  and status='O' and TO_PRACT_ID = ? and ((BEDSIDE_REFERRAL_YN='Y' AND BEDSIDE_REF_SEEN_DATE is null) OR BEDSIDE_REFERRAL_YN='N') ");

					pstmt=con.prepareStatement(sqlUnAssigned.toString());
					pstmt.setString(1,facility_id);
					pstmt.setString(2,Clin_id);
					rset=pstmt.executeQuery();

					while (rset.next())
					{
						totCountSelf = rset.getInt(1);
					}

					if(rset != null) rset.close();
					if(pstmt != null) pstmt.close();
					sqlUnAssigned.setLength(0);
				
				
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(comp_desc));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block36Bytes, _wl_block36);

										if(totCountSelf != 0)
										{
											anchorObjStart = "<a  class='gridLink' href='javascript:callConsults(\"SE\");'>";
											anchorObjEnd = "</a>";
										}
										else
										{
											anchorObjStart = "";
											anchorObjEnd = "";
										}
								
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(anchorObjStart));

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(totCountSelf));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(anchorObjEnd));
            _bw.write(_wl_block40Bytes, _wl_block40);

									if(totCountUnAsgn != 0)
									{
										anchorObjStart = "<a class='gridLink' href='javascript:callConsults(\"SP\");'>";
										anchorObjEnd = "</a>";
									}
									else
									{
										anchorObjStart = "";
										anchorObjEnd = "";
									}
							
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(anchorObjStart));

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(totCountUnAsgn));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(anchorObjEnd));
            _bw.write(_wl_block42Bytes, _wl_block42);

				
			}
		}
		for(int j=i+1;j<=5;j++)
		{
			//if ( j % 2 == 0 )
				classValue = "WHITEROW" ;
			//else
				//classValue = "CAQUERYODD" ;
		
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block43Bytes, _wl_block43);

		}
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
		if(rsComp!=null) rsComp.close();
		if(pstmtComp!=null) pstmtComp.close();
		
	}
	catch(Exception e)
	{
		//out.println("Exception in CAHomePagePatientsNew.jsp: "+e.toString());//COMMON-ICN-0181
               e.printStackTrace();//COMMON-ICN-0181
	}

	finally
	{
		if(con != null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Patients.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.self.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
