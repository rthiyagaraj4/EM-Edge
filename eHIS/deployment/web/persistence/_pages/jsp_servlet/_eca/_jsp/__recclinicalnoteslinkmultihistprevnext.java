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
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __recclinicalnoteslinkmultihistprevnext extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesLinkMultiHistPrevNext.jsp", 1736157591807L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n\t<head>\n\t\t<title></title>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCA/js/RecClinicalNotesLinkRep.js\"></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n</head>\n<BODY  class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\'multiHistform\' id=\'multiHistform\' >\n<input type = hidden  name = idx_value\t\tvalue = ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" - 1>\n<input type = hidden  name = maxRecord\t\tvalue = ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =">\n<input type = hidden  name = cur_idx_value\tvalue = \"0\">\n\n<input type = hidden  name = \'from_date\'\tvalue =\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' >\n<input type = hidden  name = \'to_date\'\t\tvalue =\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n<input type = hidden  name = patient_id\t\tvalue =";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" >\n<input type = hidden  name = encounter_id\t\tvalue =";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =">\n<input type = hidden  name = hist_rec_type\t\tvalue =";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =">\n<input type = hidden  name = sec_hdg_code\t\tvalue =";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =">\n<input type = hidden  name = child_sec_hdg_code\t\tvalue =";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =">\n<input type = hidden  name = current_encounter\t\tvalue =";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =">\n<input type = hidden  name = past_encounter_yn\t\tvalue =";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =">\n<input type = hidden  name = pat_class_yn\t\tvalue =";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =">\n<input type = hidden  name = pat_class\t\tvalue =";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =">\n<input type = hidden  name = past_encounter\t\tvalue =";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =">\n<input type = hidden  name = operation_mode\t\tvalue =";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =">\n<input type = hidden  name = accession_num\t\tvalue =";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =">\n<input type = hidden  name = sort_by\t\tvalue =";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =">\n<input type = hidden  name = from\t\tvalue =";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =">\n<input type = hidden  name = to\t\t\tvalue =";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =">\n<input type = hidden  name = noofpages\t\t\tvalue =";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =">\n<input type = hidden  name = curidxval\t\t\tvalue =";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =">\n<input type = hidden  name = facilityIdSel\t\t\tvalue =";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =">\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\n<table border=0 cellpadding=3 cellspacing=0 width=\"100%\" align=\'center\' id=\'tablePrevNext\' style=\'display\'>\n\t<tr>\n\t\t<td  width=\'85%\'></td>\n\t\t<td align=\'left\' width=\'5%\'><input type=\'button\' id=\'prev\' name=\'prev\' id=\'prev\' value=\'<\' ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" class=\'button\' onclick=\'loadPrevNext1(this,document.forms[0].from.value,document.forms[0].to.value)\' align=\'right\'></td>\n\t\t<td  align =\'center\' class = \'QRYEVEN\'>\n\t\t\t\t<input type =\'label\' class=\"LABEL\" name = \'label_cap\' readonly> \n\t\t</td>\n\t\t<td align=\'left\' width=\'5%\'><input type=\'button\' id=\'next\' name=\'next\' id=\'next\' value=\'>\' ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" class=\'button\' onclick=\'loadPrevNext1(this,document.forms[0].from.value,document.forms[0].to.value)\' ></td>\n\t</tr>\n\t\n</table>\n\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\n<script> \n\nfunction defaultPage()\n{\n\t//var idx_value\t= document.forms[0].idx_value.value;\n\n\t//var called_from = parent.encountercontrol.document.forms[0].called_from.value;\n\t//var graphorder = parent.encountercontrol.document.forms[0].strGraphOrder.value;\n\t\n//\tvar cur_idx_value = document.forms[0].cur_idx_value.value;\n\n\t//var fromDateTime =\"\";\n\t//var toDateTime =\"\";\n\tvar displend = \"\";\n\tvar displstart = 1;\n\n\t//if(idx_value > 0)\n\t//{\n\t/*\tfromDateTime\t= dtArr[0];\n\t\ttoDateTime\t\t= dtArr[0];\n\n\t\tif (idx_value >= 1)\n\t\t{\n\t\t\t\n\t\t\t\ttoDateTime = dtArr[1];\n\t\t\t\n\n\t\t\tdisplend = eval(idx_value) ;\n\t\t}\n\t\telse\n\t\t\tdisplend = 1; */\n\t\t//new\n\t\tvar start\t= document.forms[0].from.value;\n\t\tvar end\t= document.forms[0].to.value;\n\t\tif(start==null)\n\t\t\tstart =1;\n\t\telse\n\t\t\tstart = parseInt(start);\n\t\t\n\t\tif(end==null)\n\t\t\tend =14;\n\t\telse\n\t\t\tend = parseInt(end);\n\n\t\t\n\n\t\tvar maxRecord\t= document.forms[0].maxRecord.value;\n\t\tvar noofpages\t= document.forms[0].noofpages.value;\n\t\tvar curidxval\t= document.forms[0].curidxval.value;\n\t\t\n\t\t//alert(\'start..\'+start+\'..end...\'+end+\'...maxRecord...\'+maxRecord);\n\t\t//displstart = ((start/14)+1).toFixed(0) ;\n\t\tdisplstart = curidxval ;\n\t\t//displend  =  (maxRecord)/14)+1 ;\n\t\tdisplend  =  noofpages ;\n\t\t//alert(\'displstart..\'+displstart+\'..displend...\'+displend);\n\t\t//new\n\n\n\t\t//document.forms[0].cur_idx_value.value = 0;\n\t\tif(parseInt(noofpages)>0){\n\t\t\tdocument.forms[0].label_cap.value = displstart + \" of \" + displend;\n\t\t}\n\n\t/*\tif(idx_value == 1)\n\t\t{\n\t\t\tdocument.forms[0].next.disabled = true;\n\t\t\tdocument.forms[0].prev.disabled = true;\n\n\t\t}*/\n\n\t\t\t//alert(\"fromDateTime...\"+fromDateTime+\"...toDateTime...\"+toDateTime);\n\t\t\tpopulateControl1(start,end);\n\t\t\t\n\t\t\n\t//}\n}\n\ndefaultPage();\n\n</script>\n\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

		  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		  String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p1.getProperty("LOCALE");

		String facility_id		=	(String) session.getValue("facility_id");




	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);


	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	StringBuffer strsql1 = new StringBuffer(" ");

	String disablePrev = " disabled ";
	String disableNext = "disabled";

	String	from_date_time		=	"",		to_date_time		=	"";
	String	from_date_time_th	=	"",		to_date_time_th		=	"";
		
	String  patient_id	 = "";
	String  sec_hdg_code	 = "";
	String  child_sec_hdg_code	 = "";
	String  hist_rec_type	 = "";
	String  current_encounter	 = "";
	String	encounter_id = "";
	String	past_encounter_yn = "";
	String	past_encounter = "";
	String	pat_class_yn = "";
	String	pat_class = "";
	String	med_template = "";
	/*String	histrectype = "";
	String	histrectype_prev = "";
	String	hist_rec_type_desc = "";
	String	event_date_time = "";
	String	event_date = "";
	String	classValue = "";
	String	histdatatype = "";
	String data = "";
	String sqlHist ="";
	String resultstr="";
	String contr_sys_id = "";
	String accessionnum="";
	String contr_sys_event_code  = "";
	String eventdesc="";
	String result_disp="";*/
	String sort_by="";
/*	String secKey = "";
	String eventclassdesc = "";
	String preveventclass = "";
	String colspanval ="3";
	String curreventgroupevent="";
	String eventgroupdesc="";
	//String eventgroupdesc="";
	//String eventdesc="";
	String preveventgroupevent="";
	String event_date_prev="";*/
	String operation_mode="";
	String accession_num="";
	String facilityIdSel="";
	

	int nKey = 0;
//	int nIndex =1;
	int maxRecord = 0;
//	int from_new = 0;
//	int to_new = 0;
	int noofpages = 0;
	int curidxval = 1;



	from_date_time		=	(request.getParameter("from_date_time")==null)	?	""	:	request.getParameter("from_date_time");
	to_date_time		=	(request.getParameter("to_date_time")==null)	?	""	:	request.getParameter("to_date_time");
	if(!from_date_time.equals(""))
	{
		from_date_time_th	=	com.ehis.util.DateUtils.convertDate(from_date_time,"DMYHM",locale,"en");
	}
	if(!to_date_time.equals(""))
	{
	to_date_time_th		=	com.ehis.util.DateUtils.convertDate(to_date_time,"DMYHM",locale,"en");
	}
	
	patient_id			=	(request.getParameter("patient_id")==null)	?	""	:	request.getParameter("patient_id");
	sec_hdg_code			=	(request.getParameter("sec_hdg_code")==null)	?	""	:	request.getParameter("sec_hdg_code");
	child_sec_hdg_code			=	(request.getParameter("child_sec_hdg_code")==null)	?	""	:	request.getParameter("child_sec_hdg_code");
	encounter_id		=	(request.getParameter("encounter_id")==null)	?	""	:	request.getParameter("encounter_id");
	current_encounter		=	(request.getParameter("current_encounter")==null)	?	""	:	request.getParameter("current_encounter");
	past_encounter_yn		=	(request.getParameter("past_encounter_yn")==null)	?	""	:	request.getParameter("past_encounter_yn");
	past_encounter		=	(request.getParameter("past_encounter")==null)	?	""	:	request.getParameter("past_encounter");
	pat_class_yn		=	(request.getParameter("pat_class_yn")==null)	?	""	:	request.getParameter("pat_class_yn");
	pat_class		=	(request.getParameter("pat_class")==null)	?	""	:	request.getParameter("pat_class");
	med_template		=	(request.getParameter("med_template")==null)	?	""	:	request.getParameter("med_template");
	hist_rec_type		=	(request.getParameter("hist_rec_type")==null)	?	""	:	request.getParameter("hist_rec_type");
	operation_mode		=	(request.getParameter("operation_mode")==null)	?	""	:	request.getParameter("operation_mode");
	accession_num		=	(request.getParameter("accession_num")==null)	?	""	:	request.getParameter("accession_num");
	facilityIdSel		=	(request.getParameter("facilityIdSel")==null)	?	""	:	request.getParameter("facilityIdSel");

	//String from = request.getParameter( "from" ) ;
    //String to = request.getParameter( "to" ) ;

	// new 
	
	int start = 1 ;
    int end = 14 ;
//    int i=1;

 /*   if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = 14 ;
    else
        end = Integer.parseInt( to ) ; */
	
	try
		{
			con =  ConnectionManager.getConnection(request);
			String sort_qry =" select DISPLAY_ORDER  from ca_section_hdg b where b.SEC_HDG_CODE=? and b.ADDED_FACILITY_ID =? ";

			stmt = con.prepareStatement(sort_qry);
			stmt.setString(1,sec_hdg_code);
			stmt.setString(2,facility_id);
			rs = stmt.executeQuery();
			while(rs.next())
			{
			 sort_by = rs.getString("DISPLAY_ORDER")==null?"C":rs.getString("DISPLAY_ORDER");
			}

			if(rs!=null) rs.close();
			if(stmt!=null)stmt.close();
		}
		catch(Exception e )
		{
			e.printStackTrace();
			//out.println("Exception caught in RecClinicalNotesLinkMultiHIst.jsp" + e);//COMMON-ICN-0181

		}


	//new
	strsql1.append(" Select count(*) total From cr_encounter_detail a  where a.patient_id = ?");

	strsql1.append(" AND  EXISTS (SELECT 1 FROM CA_SECTION_RESULT_EVENT WHERE SEC_HDG_CODE=? AND EVENT_CODE=A.EVENT_CODE AND EVENT_GROUP_CODE=NVL(A.EVENT_GROUP,A.EVENT_CODE))");



	if(!from_date_time_th.equals("")){
		strsql1.append(" and A.EVENT_DATE >= to_date(NVL(?,'01/01/1000'),'dd/mm/yyyy hh24:mi') ");
		}

	if(!to_date_time_th.equals("")){
		strsql1.append(" and A.EVENT_DATE <= to_date(NVL(?,'01/01/9999'),'dd/mm/yyyy hh24:mi')+.00068287 "); //adding 59 seconds more to the todate
		}

	if(!facilityIdSel.equals(""))
		strsql1.append(" and a.facility_id = ?");
	
	if (!current_encounter.equals("N"))
		strsql1.append(" and a.encounter_id=? ");

	if(sort_by.equals("D"))
	  		strsql1.append(" order by a.event_date ");
	if(sort_by.equals("C"))
	  		strsql1.append(" order by a.hist_rec_type desc");

	try
	{
		//con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(strsql1.toString());
		int count1=0;
		
		pstmt.setString(++count1,patient_id);
		pstmt.setString(++count1,sec_hdg_code);
	if(!from_date_time_th.equals(""))
		pstmt.setString(++count1,from_date_time_th);			
	if(!to_date_time_th.equals(""))
		pstmt.setString(++count1,to_date_time_th);
	if(!facilityIdSel.equals(""))
		pstmt.setString(++count1,facilityIdSel);
	if (!current_encounter.equals("N"))
		pstmt.setString(++count1,encounter_id);
		
	
//	int nCtr = 0;
		rs = pstmt.executeQuery();
		
//		String strDateRecd = "";
			//String strLastDt = "";

			while (rs.next())
			{
				
				//strDateRecd = rs.getString(1);
				maxRecord = rs.getInt("total"); 
				//out.println("date recievd++++"+strDateRecd);
						
			}

			noofpages =(int)Math.ceil(maxRecord/14);
			if(maxRecord%14>0)
			{
				noofpages++;
			}

			
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception cauight in RecClinicalNotesLinkmulticriteria.jsp" + e);//COMMON-ICN-0181
	}
	finally
	{
		if(con != null) ConnectionManager.returnConnection(con,request);
	}


		if ( !(start <= 1) )
		{
			disablePrev ="";
			//from_new = start-14;
			//to_new = end-14 ;
		}
		if ( !( (start+14) > maxRecord ) )
		{
			disableNext="";

			//from_new = start+14;
			///to_new=end+14;
		}




            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(nKey));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(from_date_time));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(to_date_time));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(hist_rec_type));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(child_sec_hdg_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(current_encounter));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(past_encounter_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(pat_class_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(pat_class));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(past_encounter));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(operation_mode));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(sort_by));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(start));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(end));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(noofpages));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(curidxval));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(facilityIdSel));
            _bw.write(_wl_block30Bytes, _wl_block30);
 if(noofpages>0) {
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(disablePrev));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(disableNext));
            _bw.write(_wl_block33Bytes, _wl_block33);
}
            _bw.write(_wl_block34Bytes, _wl_block34);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
