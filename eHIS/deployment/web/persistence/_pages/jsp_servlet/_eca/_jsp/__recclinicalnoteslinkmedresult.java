package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __recclinicalnoteslinkmedresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesLinkMedResult.jsp", 1736505272284L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t<title></title>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t\t<!-- added by Kishore Kumar N on 10/12/2008  -->\n\t\t\n\t\t<!-- end here -->\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCA/js/RecClinicalNotesLinkMed.js\"></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t  \t<script>\n\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t</script>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n<body onScroll=\" scrollTitle()\" onKeyDown=\"lockKey()\">\n\n<script language=javascript>\ndocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\ndocument.body.style.scrollbarArrowColor=\'#000080\';\ndocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\ndocument.body.style.scrollbarHighlightColor=\'white\';\ndocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\n<form name=\"RecClinicalNotesLinkMedResultForm\" id=\"RecClinicalNotesLinkMedResultForm\">\t\n<div id=\'divDataTitle\' style=\'postion:relative\'>\n<table border=\"1\" id=\"finalDiv\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" align=\"center\">\n<tr >\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\n</td>\n</tr>\n</table>\n\n<table border=\"1\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" align=\"center\" name=\"resultTable\" id=\"resultTable\" id=\"resultTable\">\n<tr>\n<th class=\'columnheadercenter\' width=\"5%\" style=\"font-size:10\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="<input type=\'checkbox\' name=\'ctrlChkBox\' id=\'ctrlChkBox\' onClick=\"javascript:perform(this);\" ></th>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t<th class=\'columnheadercenter\' width=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' style=\"font-size:10\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\t\t\t\t\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\t\t\t\n\t\t\t\t<th class=\'columnheadercenter\' width=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th> \n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'  style=\"font-size:10\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t<th class=\'columnheadercenter\' width=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</th>\n\t\t<th class=\'columnheadercenter\' width=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</th><!-- IN060688 -->\n\t\t<th class=\'columnheadercenter\' width=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'style=\"font-size:10\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n</tr>\n</table>\n</div>\n<table width=\"100%\" class=\'grid\' name=\"resultTable\" id=\"resultTable\" id=\"resultTable\">\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t<script>document.forms[0].ctrlChkBox.checked = true</script> \n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t<tr>\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"  width=\'5%\'><input type=\"checkbox\" name=\"chkbox";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" id=\"chkbox";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" onClick=\"Reassaign(this);chkunchk(this)\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" ><input type=\'hidden\' name=\'chk_value";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' id=\'chk_value";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t\t<input type=\'hidden\' name=\'ret_value";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' id=\'ret_value";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="~";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="|";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'></td>\n\t\t\t\t\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" width=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td><!--IN038667 -->\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' >";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td><!-- IN060688 -->\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t<script>document.forms[0].ctrlChkBox.disabled = true</script> \n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t<input type=\"hidden\" name=\"drug_name\" id=\"drug_name\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t<input type=\"hidden\" name=\"ord_status\" id=\"ord_status\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t<input type=\"hidden\" name=\"count\" id=\"count\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n</table>\n\n</form>\n</body>\n</script>\n</html>\n\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

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

/*
-----------------------------------------------------------------------
Date       Edit History      Name        		Description
-----------------------------------------------------------------------
?             100            ?           		created
07/11/2011    IN029477      Chowminya G      	Incident No: IN029477 -  <Dosage details in link notes option - incorrect> 
18/04/2013    IN038667      Chowminya G         Result Link In Clinical Notes ? To Include ?Route?
30/04/2013    IN038667.1    Chowminya G         Reopen - Result Link In Clinical Notes ? To Include ?Route?
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
27/06/2014	IN049863		Karthi L	27/06/2014		Akbar				Link Doc medication of record clinical note, system does not display list of medication.
25/07/2016	IN060688		Ramesh G										AAKH-CRF-0088.1
08/03/2018	IN066621		Ramesh G										ML-BRU-SCF-1770
27/01/20222	IN027665		Ramesh G 										MMS-DM-CRF-0199		
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block3Bytes, _wl_block3);
            webbeans.eCommon.RecordSet Bean= null;synchronized(session){
                Bean=(webbeans.eCommon.RecordSet)pageContext.getAttribute("Bean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(Bean==null){
                    Bean=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("Bean",Bean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);

			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale = (String) p1.getProperty("LOCALE");
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String drug_name="";
	String generic_name=""; //IN060688
	//String dosage_detail="";
	String qty_value="";
	String qty_unit="";
	String freq_desc="";
	String durn_value="";
	String durn_desc="";
	String start_date="";
	String end_date="";
	//IN038667 - Start
	String route_desc="";
	String		width			=	"";
	double		col_width		=	0.0;
	//IN038667 - end
	StringBuffer strsql1 = new StringBuffer(" ");
	
	String from_date_time	=	request.getParameter("from_date_time")==null?"1/1/1900":request.getParameter("from_date_time");
	String to_date_time		=	request.getParameter("to_date_time")==null?"1/1/4000":request.getParameter("to_date_time");
	String from_date_time_th=	com.ehis.util.DateUtils.convertDate(from_date_time,"DMYHM",locale,"en");
	String to_date_time_th	=	com.ehis.util.DateUtils.convertDate(to_date_time,"DMYHM",locale,"en");
	String order			=	request.getParameter("order")==null?"":request.getParameter("order");
	String patient_class	=	request.getParameter("patient_class")==null?"A":request.getParameter("patient_class");
	String ord_status		=	request.getParameter("ord_status")==null?"A":request.getParameter("ord_status");
	String current_encounter=	request.getParameter("current_encounter")==null?"":request.getParameter("current_encounter");
	String patient_id		=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id		=	request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String from 			=	request.getParameter("from");
	String to 				= 	request.getParameter("to");
	//String whereclause		=	request.getParameter("whereclause")==null?"":request.getParameter("whereclause");
	
	String facility_id		=	(String)session.getValue("facility_id");//--[IN029477]
	String result_linked_rec_type		=	request.getParameter("result_linked_rec_type")==null?"":request.getParameter("result_linked_rec_type");
	String sec_hdg_code		=	request.getParameter("sec_hdg_code")==null?"":request.getParameter("sec_hdg_code");
	String strOrderId = "";
	String strOrdLineNum = "";
	String strSliding_scale_yn = "";
	
	String pract_id=(String)session.getValue("ca_practitioner_id");
	String rowid="";

	ArrayList  fields			=	new ArrayList();
	String categ_sec_qry ="";
	String field_ref ="";
	String col_field ="";
	//String col_val ="";
	int col_span=0;
		
	Connection con = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	
	PreparedStatement pstmt=null , stmt1 = null, stmt2 = null,stmt3 = null,stmt4 = null;//--[IN029477]
	ResultSet rset=null, rs1 = null, rs2 = null, rs3 = null, rs4 = null;//--[IN029477]

	int start = 0 ;
	int end = 0 ;
	int i = 1;
	int k = 0;
	int maxRecord = 0;
	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;

   	try
	{
		con =  ConnectionManager.getConnection(request);
		StringBuffer str=new StringBuffer();

		//str.append("SELECT COUNT(*) as total FROM   OR_ORDER A, OR_ORDER_LINE B, AM_FREQUENCY C, AM_DURATION_TYPE E, IP_NURSING_UNIT F, OP_CLINIC G WHERE A.ORDER_ID = B.ORDER_ID AND C.FREQ_CODE  = B.FREQ_CODE AND E.DURN_TYPE= B.DURN_TYPE AND F.NURSING_UNIT_CODE(+)=A.SOURCE_CODE AND CLINIC_CODE(+)=A.SOURCE_CODE  AND A.ORDERING_FACILITY_ID=F.FACILITY_ID(+) AND A.ORDERING_FACILITY_ID=G.FACILITY_ID(+) AND A.ORD_DATE_TIME BETWEEN nvl(TO_DATE(?,'DD/MM/YYYY  hh24:mi'),sysdate-36500) AND  nvl(TO_DATE(?,'DD/MM/YYYY  hh24:mi'),sysdate)+.9999   AND  A.PATIENT_ID=?  AND A.ORDER_CATEGORY='PH' ");
	 
		//str.append("SELECT COUNT(*) as total FROM   OR_ORDER A, OR_ORDER_LINE B,  IP_NURSING_UNIT F, OP_CLINIC G WHERE A.ORDER_ID = B.ORDER_ID AND F.NURSING_UNIT_CODE(+)=A.SOURCE_CODE AND CLINIC_CODE(+)=A.SOURCE_CODE  AND A.ORDERING_FACILITY_ID=F.FACILITY_ID(+) AND A.ORDERING_FACILITY_ID=G.FACILITY_ID(+) AND A.ORD_DATE_TIME BETWEEN nvl(TO_DATE(?,'DD/MM/YYYY  hh24:mi'),sysdate-36500) AND  nvl(TO_DATE(?,'DD/MM/YYYY  hh24:mi'),sysdate)   AND  A.PATIENT_ID=?  AND A.ORDER_CATEGORY='PH' and a.order_type_code != 'MS' ");// commented for IN049863
		str.append("SELECT COUNT(*) as total FROM   OR_ORDER A, OR_ORDER_LINE B,  IP_NURSING_UNIT F, OP_CLINIC G WHERE A.ORDER_ID = B.ORDER_ID AND F.NURSING_UNIT_CODE(+)=A.SOURCE_CODE AND CLINIC_CODE(+)=A.SOURCE_CODE  AND A.ORDERING_FACILITY_ID=F.FACILITY_ID(+) AND A.ORDERING_FACILITY_ID=G.FACILITY_ID(+) AND A.ORD_DATE_TIME BETWEEN nvl(TO_DATE(?,'DD/MM/YYYY  hh24:mi'),sysdate-36500) AND  nvl(TO_DATE(?,'DD/MM/YYYY  hh24:mi'),sysdate)   AND  A.PATIENT_ID=?  AND A.ORDER_CATEGORY='PH' and b.order_type_code != 'MS' "); // modified for IN049863
		if (!patient_class.equalsIgnoreCase("A"))
		{	
			// str.append("AND A.PATIENT_CLASS =?");
			str.append("AND A.encounter_id in (select encounter_id from pr_encounter where patient_id=? and patient_class=?)"); 
		}
		// else
		//	str.append(" AND  A.PATIENT_CLASS IN ('DC','EM','XT','IP','OP')");

		if (!ord_status.equalsIgnoreCase("A"))
			str.append(" AND B.ORDER_LINE_STATUS =?");
		else
			str.append(" AND B.ORDER_LINE_STATUS IN (select  ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE where ORDER_STATUS_TYPE in ('03','05','10','25','30','35','36','56','58','45','50','93','99', '62', '64') )");   //IN027665  added 62, 64
		//str.append(" AND B.ORDER_LINE_STATUS IN (select ORDER_STATUS_CODE from OR_ORDER_STATUS_CODE)");
		//str.append(" AND B.ORDER_LINE_STATUS IN ('CD','CN','DC','IR','OS','AL')");
	
		//A.ORD_PRACT_ID
	
		if (order.equalsIgnoreCase("S"))
			str.append("AND A.ORD_PRACT_ID = ?");
	
		if((!encounter_id.equals("")) && current_encounter.equals("Y") )
			str.append(" and a.encounter_id = ?");
	
		str.append(" ORDER BY B.CATALOG_DESC");

		stmt = con.prepareStatement(str.toString());	  
	  
	  
		//AND A.PATIENT_ID=?
		/* stmt.setString(1,from_date_time);
		stmt.setString(2,to_date_time);
		stmt.setString(3,patient_id);
		stmt.setString(4,pract_id);
		stmt.setString(5,encounter_id);*/

		int st1=0;

		stmt.setString(++st1,from_date_time_th);
        stmt.setString(++st1,to_date_time_th);
		stmt.setString(++st1,patient_id);

		if (!patient_class.equalsIgnoreCase("A"))
		{
			stmt.setString(++st1,patient_id);
			stmt.setString(++st1,patient_class);
		}
		if (!ord_status.equalsIgnoreCase("A"))
		    stmt.setString(++st1,ord_status);
		if (order.equalsIgnoreCase("S")) 
			stmt.setString(++st1,pract_id);
		
		if((!encounter_id.equals("")) && current_encounter.equals("Y") )
			stmt.setString(++st1,encounter_id);		
	   
		rs = stmt.executeQuery();
		
		if(rs!=null && rs.next())
			maxRecord=rs.getInt("total");

		if(rs!=null) rs.close();
		if(stmt!=null)stmt.close();

		if (maxRecord== 0)
		{
	
            _bw.write(_wl_block9Bytes, _wl_block9);

		}
		
		//  if ( (whereclause == null || whereclause.equals("")) )
		//{
	  
		/*  strsql1.append("SELECT b.rowid row_id,B.ORDER_ID,B.ORDER_LINE_NUM,B.ORDER_CATALOG_CODE, REPLACE(B.CATALOG_DESC,'''','') CATALOG_DESC,DECODE(SUBSTR(B.CATALOG_DESC,1,1),'%',0,1) DUP_DESC,B.QTY_VALUE,B.QTY_UNIT,B.FREQ_CODE,C.FREQ_DESC, B.DURN_VALUE,B.DURN_TYPE,E.DURN_DESC,TO_CHAR(B.START_DATE_TIME,'DD/MM/YYYY hh24:mi') START_DATE,  TO_CHAR(B.END_DATE_TIME,'DD/MM/YYYY hh24:mi')END_DATE, A.SOURCE_CODE,  A.ORD_PRACT_ID,DECODE(A.PATIENT_CLASS,'IP', F.SHORT_DESC,G.SHORT_DESC) LOCATION,B.ORDER_LINE_STATUS FROM   OR_ORDER A, OR_ORDER_LINE B, AM_FREQUENCY C, AM_DURATION_TYPE E, IP_NURSING_UNIT F, OP_CLINIC G WHERE A.ORDER_ID   = B.ORDER_ID AND C.FREQ_CODE  = B.FREQ_CODE AND E.DURN_TYPE= B.DURN_TYPE AND F.NURSING_UNIT_CODE(+)=A.SOURCE_CODE AND CLINIC_CODE(+)=A.SOURCE_CODE  AND A.ORDERING_FACILITY_ID=F.FACILITY_ID(+) AND A.ORDERING_FACILITY_ID=G.FACILITY_ID(+) AND A.ORD_DATE_TIME BETWEEN nvl(TO_DATE(?,'DD/MM/YYYY  hh24:mi'),sysdate-36500) AND  nvl(TO_DATE(?,'DD/MM/YYYY  hh24:mi'),sysdate)+.9999  AND  A.PATIENT_ID=?  AND A.ORDER_CATEGORY='PH' ");
	
	
		if (!patient_class.equalsIgnoreCase("A"))
			strsql1.append("AND A.PATIENT_CLASS =?");
		//else
		//strsql1.append(" AND  A.PATIENT_CLASS IN ('DC','EM','XT','IP','OP')");
	
		if (!ord_status.equalsIgnoreCase("A"))
			strsql1.append(" AND B.ORDER_LINE_STATUS =?");
		else
			strsql1.append(" AND B.ORDER_LINE_STATUS IN (select  ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE where ORDER_STATUS_TYPE in ('03','05','10','25','30','36','56','58','45','50','93','99')) ");
	
		if (order.equalsIgnoreCase("S"))
		strsql1.append("AND A.ORD_PRACT_ID = ?");

		//out.println("<script>alert('ord_status"+ord_status+"')</script>");
		//out.println("<script>alert('strsql1"')</script>");
	
		if((!encounter_id.equals("")) && current_encounter.equals("Y") )
			strsql1.append(" and a.encounter_id = ?");
	
		strsql1.append(" ORDER BY DUP_DESC,B.CATALOG_DESC");*/
	
		//strsql1.append("SELECT b.rowid row_id,B.ORDER_ID,B.ORDER_LINE_NUM,B.ORDER_CATALOG_CODE, REPLACE(B.CATALOG_DESC,'''','') CATALOG_DESC,DECODE(SUBSTR(B.CATALOG_DESC,1,1),'%',0,1) DUP_DESC,decode(h.sliding_scale_yn,'Y','<font color=red>(Sliding Scale)</font>','') sliding_scale_yn,RTRIM (RTRIM (TO_CHAR (B.QTY_VALUE, '9999999999999990.999999999999'), '0'), '.') QTY_VALUE,B.QTY_UNIT,B.FREQ_CODE,AM_GET_DESC.AM_FREQUENCY(B.FREQ_CODE,?,'1') FREQ_DESC, B.DURN_VALUE,B.DURN_TYPE,AM_GET_DESC.AM_DURATION_TYPE(B.DURN_TYPE,?,'1') DURN_DESC,TO_CHAR(B.START_DATE_TIME,'DD/MM/YYYY hh24:mi') START_DATE,  TO_CHAR(B.END_DATE_TIME,'DD/MM/YYYY hh24:mi')END_DATE, A.SOURCE_CODE,  A.ORD_PRACT_ID,DECODE(A.PATIENT_CLASS,'IP', F.LONG_DESC,G.LONG_DESC) LOCATION,B.ORDER_LINE_STATUS,(SELECT 'Route :'|| '<span style = background-color:'|| DECODE (SUBSTR (route_color, 7, 12),'', 'ffffff', SUBSTR (route_color, 7, 12)) || '>'|| '<font color='|| DECODE (substr(route_color,0,6),'','000000',substr(route_color,0,6)) || '>'|| route_desc|| '</font>'|| '</span>' FROM ph_route_lang_vw WHERE language_id = ? AND route_code = B.route_code) route_desc FROM   OR_ORDER A, OR_ORDER_LINE B, IP_NURSING_UNIT_LANG_VW  F, OP_CLINIC_LANG_VW G,or_order_line_ph h WHERE b.order_id = h.order_id and b.order_line_num = h.order_line_num and F.LANGUAGE_ID(+) = ? AND G.LANGUAGE_ID(+) = ? and A.ORDER_ID   = B.ORDER_ID   AND F.NURSING_UNIT_CODE(+)=A.SOURCE_CODE AND CLINIC_CODE(+)=A.SOURCE_CODE  AND A.ORDERING_FACILITY_ID=F.FACILITY_ID(+) AND A.ORDERING_FACILITY_ID=G.FACILITY_ID(+) AND A.ORD_DATE_TIME BETWEEN nvl(TO_DATE(?,'DD/MM/YYYY  hh24:mi'),sysdate-36500) AND  nvl(TO_DATE(?,'DD/MM/YYYY  hh24:mi'),sysdate)  AND  A.PATIENT_ID=?  AND A.ORDER_CATEGORY='PH' and a.order_type_code != 'MS' ");//IN038667 Included route //added decode to route_color IN038667.1 // commented for IN049863
		//IN060688 Start.
		//strsql1.append("SELECT b.rowid row_id,B.ORDER_ID,B.ORDER_LINE_NUM,B.ORDER_CATALOG_CODE, REPLACE(B.CATALOG_DESC,'''','') CATALOG_DESC,DECODE(SUBSTR(B.CATALOG_DESC,1,1),'%',0,1) DUP_DESC,decode(h.sliding_scale_yn,'Y','<font color=red>(Sliding Scale)</font>','') sliding_scale_yn,RTRIM (RTRIM (TO_CHAR (B.QTY_VALUE, '9999999999999990.999999999999'), '0'), '.') QTY_VALUE,B.QTY_UNIT,B.FREQ_CODE,AM_GET_DESC.AM_FREQUENCY(B.FREQ_CODE,?,'1') FREQ_DESC, B.DURN_VALUE,B.DURN_TYPE,AM_GET_DESC.AM_DURATION_TYPE(B.DURN_TYPE,?,'1') DURN_DESC,TO_CHAR(B.START_DATE_TIME,'DD/MM/YYYY hh24:mi') START_DATE,  TO_CHAR(B.END_DATE_TIME,'DD/MM/YYYY hh24:mi')END_DATE, A.SOURCE_CODE,  A.ORD_PRACT_ID,DECODE(A.PATIENT_CLASS,'IP', F.LONG_DESC,G.LONG_DESC) LOCATION,B.ORDER_LINE_STATUS,(SELECT 'Route :'|| '<span style = background-color:'|| DECODE (SUBSTR (route_color, 7, 12),'', 'ffffff', SUBSTR (route_color, 7, 12)) || '>'|| '<font color='|| DECODE (substr(route_color,0,6),'','000000',substr(route_color,0,6)) || '>'|| route_desc|| '</font>'|| '</span>' FROM ph_route_lang_vw WHERE language_id = ? AND route_code = B.route_code) route_desc FROM   OR_ORDER A, OR_ORDER_LINE B, IP_NURSING_UNIT_LANG_VW  F, OP_CLINIC_LANG_VW G,or_order_line_ph h WHERE b.order_id = h.order_id and b.order_line_num = h.order_line_num and F.LANGUAGE_ID(+) = ? AND G.LANGUAGE_ID(+) = ? and A.ORDER_ID   = B.ORDER_ID   AND F.NURSING_UNIT_CODE(+)=A.SOURCE_CODE AND CLINIC_CODE(+)=A.SOURCE_CODE  AND A.ORDERING_FACILITY_ID=F.FACILITY_ID(+) AND A.ORDERING_FACILITY_ID=G.FACILITY_ID(+) AND A.ORD_DATE_TIME BETWEEN nvl(TO_DATE(?,'DD/MM/YYYY  hh24:mi'),sysdate-36500) AND  nvl(TO_DATE(?,'DD/MM/YYYY  hh24:mi'),sysdate)  AND  A.PATIENT_ID=?  AND A.ORDER_CATEGORY='PH' and b.order_type_code != 'MS' ");  // modified for IN049863
		strsql1.append("SELECT b.rowid row_id,B.ORDER_ID,B.ORDER_LINE_NUM,B.ORDER_CATALOG_CODE, REPLACE(B.CATALOG_DESC,'''','') CATALOG_DESC,i.GENERIC_NAME GENERIC_NAME,DECODE(SUBSTR(B.CATALOG_DESC,1,1),'%',0,1) DUP_DESC,decode(h.sliding_scale_yn,'Y','<font color=red>(Sliding Scale)</font>','') sliding_scale_yn,RTRIM (RTRIM (TO_CHAR (B.QTY_VALUE, '9999999999999990.999999999999'), '0'), '.') QTY_VALUE,B.QTY_UNIT,B.FREQ_CODE,AM_GET_DESC.AM_FREQUENCY(B.FREQ_CODE,?,'1') FREQ_DESC, B.DURN_VALUE,B.DURN_TYPE,AM_GET_DESC.AM_DURATION_TYPE(B.DURN_TYPE,?,'1') DURN_DESC,TO_CHAR(B.START_DATE_TIME,'DD/MM/YYYY hh24:mi') START_DATE,  TO_CHAR(B.END_DATE_TIME,'DD/MM/YYYY hh24:mi')END_DATE, A.SOURCE_CODE,  A.ORD_PRACT_ID,DECODE(A.PATIENT_CLASS,'IP', F.LONG_DESC,G.LONG_DESC) LOCATION,B.ORDER_LINE_STATUS,(SELECT 'Route :'|| '<span style = background-color:'|| DECODE (SUBSTR (route_color, 7, 12),'', 'ffffff', SUBSTR (route_color, 7, 12)) || '>'|| '<font color='|| DECODE (substr(route_color,0,6),'','000000',substr(route_color,0,6)) || '>'|| route_desc|| '</font>'|| '</span>' FROM ph_route_lang_vw WHERE language_id = ? AND route_code = B.route_code) route_desc FROM   OR_ORDER A, OR_ORDER_LINE B, IP_NURSING_UNIT_LANG_VW  F, OP_CLINIC_LANG_VW G,or_order_line_ph h, PH_GENERIC_NAME_LANG_VW i WHERE b.order_id = h.order_id and b.order_line_num = h.order_line_num and h.GENERIC_ID = i.GENERIC_ID  and i.LANGUAGE_ID(+) = ? and F.LANGUAGE_ID(+) = ? AND G.LANGUAGE_ID(+) = ? and A.ORDER_ID   = B.ORDER_ID   AND F.NURSING_UNIT_CODE(+)=A.SOURCE_CODE AND CLINIC_CODE(+)=A.SOURCE_CODE  AND A.ORDERING_FACILITY_ID=F.FACILITY_ID(+) AND A.ORDERING_FACILITY_ID=G.FACILITY_ID(+) AND A.ORD_DATE_TIME BETWEEN nvl(TO_DATE(?,'DD/MM/YYYY  hh24:mi'),sysdate-36500) AND  nvl(TO_DATE(?,'DD/MM/YYYY  hh24:mi'),sysdate)  AND  A.PATIENT_ID=?  AND A.ORDER_CATEGORY='PH' and b.order_type_code != 'MS' ");  // modified for IN049863
		//IN060688 End.
		/*if (!patient_class.equalsIgnoreCase("A"))
			strsql1.append("AND A.PATIENT_CLASS =?");*/
		if (!patient_class.equalsIgnoreCase("A"))
		{		
			strsql1.append(" AND A.encounter_id in (select encounter_id from pr_encounter where patient_id=? and patient_class=?)"); 
		}
		//else
		//strsql1.append(" AND  A.PATIENT_CLASS IN ('DC','EM','XT','IP','OP')");
	
		if (!ord_status.equalsIgnoreCase("A"))
			strsql1.append(" AND B.ORDER_LINE_STATUS =?");
		else
			strsql1.append(" AND B.ORDER_LINE_STATUS IN (select  ORDER_STATUS_CODE FROM OR_ORDER_STATUS_CODE where ORDER_STATUS_TYPE in ('03','05','10','25','30','35','36','56','58','45','50','93','99','62','64')) ");  //IN027665  added 62, 64
	
		if (order.equalsIgnoreCase("S"))
			strsql1.append(" AND A.ORD_PRACT_ID = ?");

		//out.println("<script>alert('ord_status"+ord_status+"')</script>");
		//out.println("<script>alert('strsql1"')</script>");
	
		if((!encounter_id.equals("")) && current_encounter.equals("Y") )
			strsql1.append(" and a.encounter_id = ?");
	
		strsql1.append(" ORDER BY DUP_DESC,B.CATALOG_DESC");
		/*}
		else
		{
			strsql1.append(whereclause);
		}*/
	
		//shaiju new diag starts
		categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_SEC_DEF F where f.SEC_HDG_CODE =? and f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY=? order by ORDER_SEQ_NUM";
	
		pstmt = con.prepareStatement(categ_sec_qry);
		
		pstmt.setString(1,sec_hdg_code);
		pstmt.setString(2,result_linked_rec_type);
		pstmt.setString(3,result_linked_rec_type);

		rset = pstmt.executeQuery();

		if(rset.next())
		{
			do
			{
				field_ref = rset.getString("FIELD_REF")==null?"":rset.getString("FIELD_REF");
				fields.add(field_ref);
			}
			while(rset.next());
		}
		else
		{
			if (rset != null) rset.close();
			if (pstmt != null) pstmt.close();

			categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_DEF  F where f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY=? order by ORDER_SEQ_NUM";

			pstmt = con.prepareStatement(categ_sec_qry);
			pstmt.setString(1,result_linked_rec_type);
			pstmt.setString(2,result_linked_rec_type);

			rset = pstmt.executeQuery();

			if(rset.next())
			{
				do
				{
					field_ref = rset.getString("FIELD_REF")==null?"":rset.getString("FIELD_REF");
					fields.add(field_ref);
				}
				while(rset.next());

				if (rset != null) rset.close();
				if(pstmt != null) pstmt.close();
			}
		}
	    //shaiju new diag ends

		//AND A.PATIENT_ID=?
		stmt = con.prepareStatement(strsql1.toString());
		int st=0;

		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);//IN038667
		stmt.setString(++st,locale);//IN060688
		stmt.setString(++st,locale);
		stmt.setString(++st,locale);
         
		stmt.setString(++st,from_date_time_th);
        stmt.setString(++st,to_date_time_th);
	  
		stmt.setString(++st,patient_id);
       
		if (!patient_class.equalsIgnoreCase("A"))
		{
			stmt.setString(++st,patient_id);
			stmt.setString(++st,patient_class);
		}
		if (!ord_status.equalsIgnoreCase("A"))
		    stmt.setString(++st,ord_status);	   
		if (order.equalsIgnoreCase("S")) 
			stmt.setString(++st,pract_id);
	  
		if((!encounter_id.equals("")) && current_encounter.equals("Y") )
			stmt.setString(++st,encounter_id);
		
    	rs = stmt.executeQuery();
	
            _bw.write(_wl_block10Bytes, _wl_block10);

	if ( !(start <= 1) )
	{
		out.println("<td width='85%' class='CAGROUP' ><b><font size='2'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.searchresult.label","common_labels")+"</b></td><td width='10%' >");
		out.println("<A HREF='../../eCA/jsp/RecClinicalNotesLinkMedResult.jsp?from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&patient_class="+patient_class+"&ord_status="+ord_status+"&order="+order+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&current_encounter="+current_encounter+"&from="+(start-14)+"&to="+(end-14)+"&result_linked_rec_type="+result_linked_rec_type+"&sec_hdg_code="+sec_hdg_code+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
	}
	else
	{
		out.println("<td width='100%' class='CAGROUP' ><b><font size='2'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.searchresult.label","common_labels")+"</b></td><td width='10%' >");
	}

	//out.println("<script>alert('start"+start+"')</script>");
	
	if ( !( (start+14) > maxRecord ) )
	{
		out.println("<A HREF='../../eCA/jsp/RecClinicalNotesLinkMedResult.jsp?from_date_time="+from_date_time+"&to_date_time="+to_date_time+"&patient_class="+patient_class+"&ord_status="+ord_status+"&order="+order+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&current_encounter="+current_encounter+"&from="+(start+14)+"&to="+(end+14)+"&result_linked_rec_type="+result_linked_rec_type+"&sec_hdg_code="+sec_hdg_code+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	}

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

	if(fields.size()>0)
	{
		for(int l=0;l<fields.size();++l)
		{
			//IN038667 - Start
			col_span = fields.size();
			col_width= 100/col_span;
			width = col_width+"%";
			//IN038667 - end Included width in all 4 fields
			col_field = (String)fields.get(l);
			if(col_field.equals("DRUGNAME"))
			{

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(width));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

			}
			//IN060688 Start.
			else if("GENERICNAME".equals(col_field))
			{

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(width));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

			}
			//IN060688 End.
			else if(col_field.equals("DOSAGEDETAILS"))
			{

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(width));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

			}
			else if(col_field.equals("STARTDATE"))
			{

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(width));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

			}
			else if(col_field.equals("ENDDATE"))
			{

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(width));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

			}
		}
	}
	else
	{
	//IN038667 - Start
		col_width= 100/5;
		width = col_width+"%";
		//IN038667 - end Included width in all 4 fields

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(width));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(width));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(width));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(width));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(width));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

	}

            _bw.write(_wl_block24Bytes, _wl_block24);
 	
    if ( start != 1 )
	{
		for( int j=1; j<start; i++,j++ )
		{
			 rs.next() ;
		}
	}
	String classValue="gridData";

	StringBuffer sbDivided		=	new StringBuffer();
	StringBuffer sbDosageDtl	=	new StringBuffer();

	String strSplitQry =	"";
	String strQtyQry =	"";//--[IN029477]
	String strQtyQry1 =	"";//--[IN029477]
	String uom_Dis = "D";//--[IN029477]
	String strSplitDosageFlag = "N", strDosageQry ="";
	
	int	p =	0, nMinVal =	0,	nMaxVal	= 0;

	strSplitQry	=	"select MIN(ORDER_LINE_DOSE_QTY_VALUE) min_val,max(ORDER_LINE_DOSE_QTY_VALUE) max_val from OR_ORDER_LINE_FIELD_VALUES where ORDER_ID = ? and ORDER_LINE_NUM =? AND ORDER_LINE_SEQ_NUM >= 200 and ORDER_LINE_FIELD_MNEMONIC = 'SCHED_ADMIN_TIME'";
	//--[IN029477] - Start
	strQtyQry	=	"select uom_display_in_trans from PH_FACILITY_PARAM where facility_id=?";
	stmt3 = con.prepareStatement(strQtyQry);
	stmt3.clearParameters();

				stmt3.setString(1,facility_id);

				rs3 = stmt3.executeQuery();

				if(rs3 != null && rs3.next() )
				{
					uom_Dis = rs3.getString("uom_display_in_trans");
				}
	//--[IN029477] - End
	
	stmt1 = con.prepareStatement(strSplitQry);
	//IN066621 Start.
	//strDosageQry	=	" SELECT Ph_Splitdose_NEW(?,?,'NOTES') dosagedtl FROM DUAL ";
	strDosageQry	=	" SELECT PH_SPLITDOSE_NEW(?,?,?,?,'NOTES') dosagedtl FROM DUAL ";
	//IN066621 End.
	stmt2	=	con.prepareStatement(strDosageQry);
		
	while(rs!=null && rs.next() && i<=end)
	{
		sbDivided.delete(0,sbDivided.length());
		sbDosageDtl.delete(0,sbDosageDtl.length());

		drug_name		=	rs.getString("CATALOG_DESC")==null?" ":rs.getString("CATALOG_DESC");
		rowid			=	rs.getString("row_id")==null?" ":rs.getString("row_id");
		qty_value		=	rs.getString("QTY_VALUE")==null?" ":rs.getString("QTY_VALUE");
		qty_unit		=	rs.getString("QTY_UNIT")==null?" ":rs.getString("QTY_UNIT");
		freq_desc		=	rs.getString("FREQ_DESC")==null?" ":rs.getString("FREQ_DESC");
		durn_value		=	rs.getString("DURN_VALUE")==null?" ":rs.getString("DURN_VALUE");
		durn_desc		=	rs.getString("DURN_DESC")==null?" ":rs.getString("DURN_DESC");
		start_date		=	rs.getString("START_DATE")==null?" ":rs.getString("START_DATE");
		end_date		=	rs.getString("END_DATE")==null?" ":rs.getString("END_DATE");
		strOrderId		=	rs.getString("ORDER_ID")==null?" ":rs.getString("ORDER_ID");
		strOrdLineNum	=	rs.getString("ORDER_LINE_NUM")==null?" ":rs.getString("ORDER_LINE_NUM");
		strSliding_scale_yn	=	rs.getString("sliding_scale_yn")==null?" ":rs.getString("sliding_scale_yn");
		route_desc      =	rs.getString("route_desc")==null?" ":rs.getString("route_desc");//IN038667
		generic_name	= 	rs.getString("GENERIC_NAME")==null?" ":rs.getString("GENERIC_NAME");//IN060688
		if(!start_date.equals(" " ))
			start_date		= com.ehis.util.DateUtils.convertDate(start_date,"DMYHM","en",locale);

		if(!end_date.equals(" " ))
			end_date		= com.ehis.util.DateUtils.convertDate(end_date,"DMYHM","en",locale);

		stmt1.setString(1,strOrderId);
		stmt1.setString(2,strOrdLineNum);
		
		rs1 = stmt1.executeQuery();

		if( rs1 != null && rs1.next() )
		{
			nMinVal		= rs1.getInt("min_val");
			nMaxVal		= rs1.getInt("max_val");

			if(nMinVal != nMaxVal) 
			{
				strSplitDosageFlag	=	"Y";

				sbDivided.append(" - (Divided Dose) ");
				stmt2.clearParameters();

				stmt2.setString(1,strOrderId);
				stmt2.setString(2,strOrdLineNum);
				stmt2.setString(3,facility_id);  //IN066621
				stmt2.setString(4,locale);  //IN066621
				rs2 = stmt2.executeQuery();

				if(rs2 != null && rs2.next() )
				{
					sbDivided.append(rs2.getString(1));	
				}
			}
			else
			{
				sbDivided.delete(0,sbDivided.length());
				sbDivided.append("");
				strSplitDosageFlag	=	"N";
			}
		}
				
		if( rs1 != null) rs1.close();
		if(stmt1 != null) stmt1.clearParameters();
		
		if( rs2 != null) rs2.close();
		if(stmt2 != null) stmt2.clearParameters();

		if( rs3 != null) rs3.close();
		if(stmt3 != null) stmt3.clearParameters();
		/*if(qty_value.trim().indexOf(".")==0)
		{
			out.println("qty_value "+qty_value.trim().indexOf("."));
			qty_value="0"+qty_value;
		}  */

		if(!strSliding_scale_yn.trim().equals("")) //Modified --[IN029477]
		{
			sbDosageDtl.append(strSliding_scale_yn);
		}
		else
		{
			sbDosageDtl.append(qty_value.trim()); //Modified --[IN029477]
			sbDosageDtl.append(" ");
			if(uom_Dis.equals("D")) //--[IN029477] - start
			{
				strQtyQry1	=	"select am_get_desc.am_uom(?,'en','2') descc from dual";
				stmt4 = con.prepareStatement(strQtyQry1);
				stmt4.clearParameters();

				stmt4.setString(1,qty_unit);

				rs4 = stmt4.executeQuery();

				if(rs4 != null && rs4.next() )
				{
					qty_unit = rs4.getString("descc");
				}
				
				if( rs4 != null) rs4.close();
				if(stmt4 != null) stmt4.clearParameters();
				if(qty_unit!=null && !qty_unit.equals("")) //IN038667
					sbDosageDtl.append(qty_unit);
			}
			else
			{
				if(qty_unit!=null && !qty_unit.equals("")) //IN038667
					sbDosageDtl.append(qty_unit);
			}		//--[IN029477] - end
		}
		//sbDosageDtl.append(" ");
		sbDosageDtl.append(sbDivided.toString());
		sbDosageDtl.append(" - ");
		sbDosageDtl.append(freq_desc);
		sbDosageDtl.append(" for ");
		sbDosageDtl.append(durn_value);
		sbDosageDtl.append(" ");
		sbDosageDtl.append(durn_desc);
		sbDosageDtl.append(" ");//IN038667
		sbDosageDtl.append(route_desc);//IN038667
		sbDosageDtl.append(" ");//IN038667

		//dosage_detail=qty_value+" "+qty_unit+" - "+freq_desc+" for "+durn_value+" "+durn_desc;
		/*if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;*/
	    
		String beankey="";		
		String checkstatus="";		
         
		for(int m=0;m<Bean.getSize();m+=2)
		{
			beankey=Bean.getObject(m).toString();
					
  			if(rowid.equalsIgnoreCase(beankey))
			{
				checkstatus="checked";
                p++; 
				break;
			}					
 		}
				
        if(p == maxRecord || p == 14)
		{

            _bw.write(_wl_block25Bytes, _wl_block25);

		}

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(k));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(k));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(k));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(checkstatus));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(k));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(k));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rowid));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(k));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(k));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rowid));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(generic_name));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(sbDosageDtl.toString()));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block39Bytes, _wl_block39);

			if(fields.size()>0)
			{
				col_span = fields.size();
				//IN038667 - Start
				col_width= 100/col_span;
				width = col_width+"%";
				//IN038667 - end Included width in all 4 fields
				
				for(int n=0;n<fields.size();++n)
				{
					col_field = (String)fields.get(n);
						
					if(col_field.equals("DRUGNAME"))
					{

            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(width));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block43Bytes, _wl_block43);
		
					}
					//IN060688 Start.
					else if("GENERICNAME".equals(col_field))
					{

            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(width));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(generic_name));
            _bw.write(_wl_block43Bytes, _wl_block43);
		
					}
					//IN060688 End.
					else if(col_field.equals("DOSAGEDETAILS"))
					{
						//dosage value changed from (strSliding_scale_yn sbDivided.toString() - freq_desc for durn_value durn_desc route_desc) to sbDosageDtl.toString()
						if(!strSliding_scale_yn.trim().equals("")) //Modified --[IN029477]
						{

            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(width));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sbDosageDtl.toString()));
            _bw.write(_wl_block45Bytes, _wl_block45);

						}
						else
						{

            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(width));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sbDosageDtl.toString()));
            _bw.write(_wl_block45Bytes, _wl_block45);

						}
					}
					else if(col_field.equals("STARTDATE"))
					{

            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(width));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block43Bytes, _wl_block43);

					}
					else if(col_field.equals("ENDDATE"))
					{

            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(width));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block43Bytes, _wl_block43);

					}
				}
			}
			else
			{

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(width));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(width));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(generic_name));
            _bw.write(_wl_block49Bytes, _wl_block49);

				if(!strSliding_scale_yn.equals(""))
				{

            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(width));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sbDosageDtl.toString()));
            _bw.write(_wl_block45Bytes, _wl_block45);

				}
				else
				{

            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(width));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sbDosageDtl.toString()));
            _bw.write(_wl_block45Bytes, _wl_block45);

				}

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(width));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(width));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block43Bytes, _wl_block43);

			}

            _bw.write(_wl_block51Bytes, _wl_block51);

			i++;
			k++;
		}

		if( rs1 != null) rs1.close();
		if(stmt1 != null) stmt1.close();
			
		if( rs2 != null) rs2.close();
		if(stmt2 != null) stmt2.close();

		if(maxRecord == 0)
		{

            _bw.write(_wl_block52Bytes, _wl_block52);

		}
		if(rs!=null) rs.close();
		if(stmt!=null)stmt.close();		 	
	}
	catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception cauight in RecClinicalNotesLinkMedResult.jsp" + e);//COMMON-ICN-0181
	}
	finally 
	{
		
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(ord_status));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(k));
            _bw.write(_wl_block58Bytes, _wl_block58);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DrugName.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.GenericName.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.DosageDetails.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DrugName.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.GenericName.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.DosageDetails.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }
}
