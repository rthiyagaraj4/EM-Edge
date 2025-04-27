package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __assignrelationshipview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/AssignRelationshipView.jsp", 1709115464545L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCA/js/AssignRelationship.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body class=\'CONTENT\' OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"  onScroll=\'scrollTitle()\'>\n<form name=\'AssignRelationshipForm\' id=\'AssignRelationshipForm\' method=\'POST\' action=\'../../servlet/eCA.AssignRelationshipServlet\'>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\n\t\t<div id=\'divDataTitle\' style=\'postion:relative\' >\t\t\t\n\t\t<table  width=\'100%\'  class=\'grid\' align=\'center\'>\n\t\t\t\n\t\t</table>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<div id=\'divDataTitle\' style=\'postion:relative\' >\t\t\t\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<center>\n\t\n\t<table width=\'100%\' id=\'dataTitleTable\' class=\'grid\' align=\'center\' >\n\t\t<TR>\n\t\t\t<td class=\'COLUMNHEADERCENTER\' width=\'25%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t<td class=\'COLUMNHEADERCENTER\' width=\'25%\' >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t<td class=\'COLUMNHEADERCENTER\' width=\'25%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t</tr>\n\t\t</table>\n\t</div>\n\t<table class=\'grid\' width=\'100%\' id=\'dataTable\' align=\'center\'>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'CAGROUP\' colspan=4>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t</tr>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\n\t\t\t\t<tr>\t\t\n\t\t\t\t<td class=\'gridData\' width=\'25%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="<a class=\'gridLink\' href=\"javascript:displayDetails(\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\',\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\')\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t</a>  \n\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t\t<td class=\'gridData\' width=\'25%\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t<TR style=\'visibility:hidden\'>\n\t\t<td class=\'COLUMNHEADERCENTER\' >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t<td class=\'COLUMNHEADERCENTER\' >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t</tr>\n\t</table>\n\n\t\t<input type=\'hidden\' name=\'modal_yn\' id=\'modal_yn\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n\t\t<input type=\'hidden\' name=\'episode_id\' id=\'episode_id\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t\t<input type=\'hidden\' name=\'visit_id\' id=\'visit_id\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t<input type=\'hidden\' name=\'query_string\' id=\'query_string\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t\t<input type=\'hidden\' name=\'currentDateTime\' id=\'currentDateTime\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t</form>\n\t</center>\n</body>\n</html>\n<script>alignWidth();</script>\n\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

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

	//out.println("QueryString = "+request.getQueryString());
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");

	String facility_id = (String) session.getAttribute("facility_id");
	String query_string = "";
	String current_date_time= com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
	String modal_yn = request.getParameter("modal_yn") == null ? "N" : request.getParameter("modal_yn");
	String episode_id = request.getParameter("episode_id") == null ? "" : request.getParameter("episode_id");
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String visit_id = request.getParameter("visit_id") == null ? "ABC" : request.getParameter("visit_id");
	String episode_type = request.getParameter("episode_type") == null ? "" : request.getParameter("episode_type");
	
	if(episode_type.equals("I"))	visit_id		=	"1";

	//String patInfoBuff = "";
	String patient_name = "";
	String encounter_details = "";
	String practitionerInfo = "";
	String expiry_period="";	
     String reason_text="";
	StringBuffer strBuffPatientInfo = null;
	StringTokenizer tokenPatDetails = null;

	String pline = "";
	Connection			con		=	null;
	try
	{
    con = ConnectionManager.getConnection(request);

	if(modal_yn.equals("Y"))
	{
		String sql_pline = "";

		if(episode_id.equals(""))
		{
			sql_pline = "select get_patient.get_line_detail(?,?) Pline FROM dual";
		}
		else
		{
			sql_pline = "select get_patient.get_line_detail(?,?,?) Pline FROM dual";
		}

		PreparedStatement ps_pline = null;
		ResultSet res_pline = null;

		/* modified try
		{*/
			
			ps_pline = con.prepareStatement(sql_pline);

			if(episode_id.equals(""))
			{
				ps_pline.setString(1,patient_id);
				ps_pline.setString(2,locale);
			}
			else
			{
				ps_pline.setString(1,facility_id);
				ps_pline.setString(2,episode_id);
				ps_pline.setString(3,locale);
			}

			res_pline = ps_pline.executeQuery();

			while(res_pline.next())
			{
				pline = res_pline.getString("Pline");
			}

			if(pline != null)
			{
				strBuffPatientInfo = new StringBuffer();
				tokenPatDetails = new StringTokenizer(pline,"|");

				while(tokenPatDetails.hasMoreTokens())
				{
					patient_name = tokenPatDetails.nextToken();
					strBuffPatientInfo.append(tokenPatDetails.nextToken());
					if(!episode_id.equals(""))
					{
						practitionerInfo = tokenPatDetails.nextToken();
						encounter_details = tokenPatDetails.nextToken();
					}
				}
			}
		
            _bw.write(_wl_block9Bytes, _wl_block9);

			if(ps_pline != null) ps_pline.close();
			if(res_pline != null) res_pline.close();
		/*}
		catch(Exception e)
		{
			out.println("Exception in AssignRelationshipView.jsp"+e.toString());
			e.printStackTrace();
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}*/
	}
	else
	{

            _bw.write(_wl_block10Bytes, _wl_block10);
} 
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

        /*modified con = null; */

		String head_desc = "", prev_head_desc = "";
		String phy_prov_name = "", phys_prov_reln_name = "", begin_date = "", end_date = "";
		//String whereClause = "";
		String practitioner_type="",practitioner_id="",relationship_id="",added_date="",added_id="";
		String relationship_name="",expiry_based="",expiry_rule="",expiry_rule1="";
		String terminateRelnCheck=""; // this variable is used for the next frame reference.
		String 	login_user_id		=	(String) session.getValue("login_user");
		String 	responsibility_id		=	(String) session.getValue("responsibility_id");
		String sql="";
		String CAN_TERMINATE_YN="N";

		/*modal_yn	=	request.getParameter("modal_yn");
		if(modal_yn==null) modal_yn = "N";*/
		//out.println("<script>alert('modal_yn = "+modal_yn+"');</script>");
	/*	try
		{ */
			PreparedStatement	 pstmt	=	null;
			PreparedStatement pstmt1=null;
			ResultSet			rs		=	null;
			ResultSet rs1=null;
			
			//con					=	(Connection) session.getValue("connection");

			/* modified con = ConnectionManager.getConnection(request); */
			//patient_id			=	request.getParameter("patient_id");
			//episode_id			=	request.getParameter("episode_id");
			//episode_type		=	request.getParameter("episode_type");
			//visit_id			=	request.getParameter("visit_id");
			query_string		=	request.getQueryString();

			//if(patient_id==null)		patient_id			=	"";
			//if(episode_id==null)		episode_id			=	"";
			//if(episode_type==null)		episode_type		=	"";
			//if(episode_type.equals("I"))	visit_id		=	"1";

			//String query_patient_encounter_details = "select PHY_PROV_TYPE practitioner_type,PHYS_PROV_ID practitioner_id,PHYS_PROV_RELN_ID relationship_id,to_char(sysdate,'dd/mm/yyyy hh24:mi') current_date_time, ADDED_BY_ID, to_char(ADDED_DATE,'dd/mm/yyyy hh24:mi:ss')  added_date,replace (PHYS_PROV_RELN_NAME,'''','') relationship_name,EXPIRY_BASED_YN expiry_based,to_char(expiry_period)||decode(expiry_rule, 'DAE', ' Days After Effect', 'HAE', ' Hours After Effect', 'DAA', ' Days After Adm/Visit', 'HAA', ' Hours After Adm/Visit', 'DAT', ' Days After Transfer', 'HAT', ' Hours After Transfer', 'DAD', ' Days After Discharge', 'HAD', ' Hours After Discharge') expiry_rule,decode(lifetime_or_encntr,'L','Lifetime','E','Encounter') head_desc, replace (phy_prov_name,'''','') phy_prov_name,     replace(phys_prov_reln_name ,'''','') phys_prov_reln_name,to_char(begin_date_time,'dd/mm/yyyy hh24:mi') begin_date, to_char(end_date_time,'dd/mm/yyyy hh24:mi') end_date from ca_encntr_pract_reln_vw where patient_id = ?  and sysdate between begin_date_time and nvl(end_date_time,sysdate) and (( LIFETIME_OR_ENCNTR ='L') or (episode_id = ? "+whereClause+")) order by LIFETIME_OR_ENCNTR, begin_date_time ";

			//String query_patient_encounter_details=" select PHY_PROV_TYPE practitioner_type,PHYS_PROV_ID practitioner_id,PHYS_PROV_RELN_ID relationship_id,to_char(sysdate,'dd/mm/yyyy hh24:mi') current_date_time, ADDED_BY_ID, to_char(ADDED_DATE,'dd/mm/yyyy hh24:mi:ss')  added_date,replace (CA_GET_DESC.CA_PRACT_RELN(PRACT_RELN_ID,?,'1'),'''','') relationship_name,EXPIRY_BASED_YN expiry_based,to_char(expiry_period) expiry_period, expiry_rule,decode(lifetime_or_encntr,'L','Lifetime','E','Encounter') head_desc, replace (AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,'1'),'''','') phy_prov_name,     replace(CA_GET_DESC.CA_PRACT_RELN(PRACT_RELN_ID,?,'1') ,'''','') phys_prov_reln_name,to_char(begin_date_time,'dd/mm/yyyy hh24:mi') begin_date, to_char(end_date_time,'dd/mm/yyyy hh24:mi') end_date from ca_encntr_pract_reln_vw where patient_id = ?  and sysdate between begin_date_time and nvl(end_date_time,sysdate) and (( LIFETIME_OR_ENCNTR ='L') or (episode_id = ? "+whereClause+")) order by LIFETIME_OR_ENCNTR, begin_date_time";

			//commented for perfmonace tuning 
			//String query_patient_encounter_details=" select PHY_PROV_TYPE practitioner_type,PHYS_PROV_ID practitioner_id,PHYS_PROV_RELN_ID relationship_id, ADDED_BY_ID, to_char(ADDED_DATE,'dd/mm/yyyy hh24:mi:ss')  added_date,replace (CA_GET_DESC.CA_PRACT_RELN(PHYS_PROV_RELN_ID,?,'1'),'''','') relationship_name,EXPIRY_BASED_YN expiry_based,to_char(expiry_period) expiry_period, expiry_rule,lifetime_or_encntr head_desc, replace (AM_GET_DESC.AM_PRACTITIONER(PHYS_PROV_ID,?,'1'),'''','') phy_prov_name,     replace(CA_GET_DESC.CA_PRACT_RELN(PHYS_PROV_RELN_ID,?,'1') ,'''','') phys_prov_reln_name,to_char(begin_date_time,'dd/mm/yyyy hh24:mi') begin_date, to_char(end_date_time,'dd/mm/yyyy hh24:mi') end_date from ca_encntr_pract_reln_vw where patient_id = ?  and sysdate between begin_date_time and nvl(end_date_time,sysdate) and (( LIFETIME_OR_ENCNTR ='L') or (episode_id = ? "+whereClause+")) order by LIFETIME_OR_ENCNTR, begin_date_time";

			String query_patient_encounter_details="SELECT a.practitioner_id,         a.pract_reln_id relationship_id, a.added_by_id,TO_CHAR (a.added_date, 'dd/mm/yyyy hh24:mi:ss') added_date,REPLACE  (ca_get_desc.ca_pract_reln (a.pract_reln_id, ?, '1'),'''', '') relationship_name, expiry_based_yn expiry_based, TO_CHAR (expiry_period) expiry_period, expiry_rule, lifetime_or_encntr head_desc,  REPLACE (am_get_desc.am_practitioner (a.practitioner_id, ?, '1'), '''','' ) phy_prov_name,TO_CHAR (begin_date_time, 'dd/mm/yyyy hh24:mi') begin_date,      TO_CHAR (end_date_time, 'dd/mm/yyyy hh24:mi') end_date,(select pract_type from am_practitioner where practitioner_id=a.practitioner_id) pract_type, a.remarks FROM ca_encntr_pract_reln a, ca_pract_reln b WHERE patient_id = ? AND SYSDATE BETWEEN begin_date_time AND NVL (end_date_time, SYSDATE) AND ((lifetime_or_encntr = 'L') OR (encounter_id = ?)) and b.pract_reln_id=a.pract_reln_id AND NVL(STATUS,'01')!='09' ORDER BY lifetime_or_encntr, begin_date_time ";

			pstmt		=	con.prepareStatement(query_patient_encounter_details);
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			//pstmt.setString(3,locale);
			pstmt.setString(3,patient_id);
			pstmt.setString(4,episode_id);
			
			
			rs	=	pstmt.executeQuery();
			
				//if(pstmt!=null) pstmt.close();
			int i=0;
			//String classValue = "";
					sql="select  CAN_TERMINATE_YN from ca_pract_reln_for_resp a, sm_resp_for_user b where b.appl_user_id =  ? AND  pract_reln_id =?  and a.resp_id = b.resp_id and a.resp_id=? ";
				pstmt1=con.prepareStatement(sql);	


			while(rs.next())
			{
				i++;
				//if((i%2)==0) 	classValue = "QRYEVEN";
				//else classValue = "QRYODD";

				head_desc			=	rs.getString("head_desc");

				if(head_desc.equals("L") )
					head_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.LifeTime.label","ca_labels");
				else if(head_desc.equals("E") )
					head_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounter.label","common_labels");

				phy_prov_name		=	rs.getString("phy_prov_name");
				//phys_prov_reln_name	=	rs.getString("phys_prov_reln_name");//tune
				begin_date			=	rs.getString("begin_date");
				end_date			=	rs.getString("end_date");
				practitioner_type	=	rs.getString("pract_type"); 
				practitioner_id		=	rs.getString("practitioner_id");
				relationship_id		=	rs.getString("relationship_id");		
				added_id			=	rs.getString("ADDED_BY_ID");
				added_date			=	rs.getString("added_date");
				relationship_name 	=	rs.getString("relationship_name");
				expiry_based 		=	rs.getString("expiry_based");
				expiry_period		=	rs.getString("expiry_period");
				expiry_rule1 		=	rs.getString("expiry_rule");			
				reason_text = rs.getString("remarks");	

				if(phy_prov_name==null)			phy_prov_name		= "&nbsp;";
				if(phys_prov_reln_name==null)	phys_prov_reln_name = "&nbsp;";
				if(begin_date==null)			begin_date			= "";
				if(end_date==null)				end_date			= "";
				if(practitioner_type==null)		practitioner_type	= "";
				if(practitioner_id==null)		practitioner_id	= "";
				if(relationship_id==null)		relationship_id	= "";
				if(added_date==null)		added_date	= "";
				if(relationship_name==null)		relationship_name	= "";
				if(expiry_based==null)		expiry_based	= "";
				if(expiry_period==null)		expiry_period	= "";
				if(expiry_rule==null)		expiry_rule	= "";

				if(added_id==null) added_id	= "";
				if(expiry_rule1==null) expiry_rule1	= "";
				
				begin_date	= com.ehis.util.DateUtils.convertDate(begin_date,"DMYHM","en",locale);
				end_date	= com.ehis.util.DateUtils.convertDate(end_date,"DMYHM","en",locale);
				if(expiry_rule1.equals("DAE"))
				expiry_rule=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DayAfterEffect.label","ca_labels");

			if(expiry_rule1.equals("HAE"))
				expiry_rule = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.HourAfterEffect.label","ca_labels");

			if(expiry_rule1.equals("DAA"))
				expiry_rule= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DayAfterAdmit.label","ca_labels");

			if(expiry_rule1.equals("HAA"))
				expiry_rule=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.HourAfterAdmit.label","ca_labels");

			if(expiry_rule1.equals("DAT"))
				expiry_rule=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DayAfterTransfer.label","ca_labels");
				
			if(expiry_rule1.equals("HAT"))
				expiry_rule=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.HourAfterTransfer.label","ca_labels");

			if(expiry_rule1.equals("DAD"))
				expiry_rule=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DayAfterDischarge.label","common_labels");

			if(expiry_rule1.equals("HAD"))
				expiry_rule= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.HourAfterDischarge.label","common_labels");

				expiry_rule=expiry_period+" " + expiry_rule;
				if(!(prev_head_desc.equals(head_desc)))
				{

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(head_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);

					prev_head_desc = head_desc;
				}
	/*modified try{	 */
				
					
				
				//if(pstmt1!=null) pstmt1.close();
		/*}catch(Exception e){
				out.println("Exception in AssignRelationshipView.jsp "+e.toString());
		} */
			if (added_id.equals(login_user_id)){
				terminateRelnCheck="N";
				CAN_TERMINATE_YN="N";
		
				pstmt1.setString(1,login_user_id);
				pstmt1.setString(2,relationship_id);
				pstmt1.setString(3,responsibility_id);
				rs1=pstmt1.executeQuery();
 
				while (rs1.next()){
						CAN_TERMINATE_YN=(rs1.getString("CAN_TERMINATE_YN")==null?"N":rs1.getString("CAN_TERMINATE_YN"));
				}

				if(rs1!=null)rs1.close();
					if(CAN_TERMINATE_YN.equals("Y")){
							terminateRelnCheck="Y";
					}
			}
			

	
            _bw.write(_wl_block17Bytes, _wl_block17);
if(modal_yn.equals("N")){
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(relationship_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(begin_date));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(added_date));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(phy_prov_name));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(relationship_name));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(expiry_based));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(expiry_rule));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(terminateRelnCheck));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(reason_text));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(phy_prov_name));
            _bw.write(_wl_block21Bytes, _wl_block21);

					if(begin_date.equals(""))	begin_date	= "&nbsp;";
					if(end_date.equals(""))				end_date = "&nbsp;";
				}else{
					if(begin_date.equals(""))	begin_date	= "&nbsp;";
					if(end_date.equals(""))				end_date = "&nbsp;";	
					
            out.print( String.valueOf(phy_prov_name));
}
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(relationship_name));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(begin_date));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block16Bytes, _wl_block16);

						
			

			}


	


			if(pstmt1!=null) pstmt1.close();
		
			
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			
		}catch(Exception e){
			//out.println("Exception in AssignRelationshipView.jsp:"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();
		}finally	{
			
						if(con!=null) ConnectionManager.returnConnection(con,request);
					}
		
	
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(current_date_time));
            _bw.write(_wl_block31Bytes, _wl_block31);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AssignRelationship.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.relationship.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.startdatetime.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddatetime.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.relationship.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.startdatetime.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddatetime.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
