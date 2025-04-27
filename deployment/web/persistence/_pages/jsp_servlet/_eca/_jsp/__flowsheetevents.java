package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __flowsheetevents extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/FlowSheetEvents.jsp", 1742387821762L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<HTML>\n<HEAD>\n<TITLE> New Document </TITLE>\n<META NAME=\"Generator\" CONTENT=\"EditPlus\">\n<META NAME=\"Author\" CONTENT=\"\">\n<META NAME=\"Keywords\" CONTENT=\"\">\n<META NAME=\"Description\" CONTENT=\"\">\n ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'></link>\n\t\t\t\n<style>\nA:active{\n\tcolor:white;\n}\nA:visited{\n\tcolor:white;\n}\nA:link { \n\tCOLOR:white;\n}\n/*IN067721 starts*/\n.gridDataChart\n\t{\n\tbackground-color: #FFFFFF;\n\tfont-family: Verdana, Arial, Helvetica, sans-serif;\n\tfont-size: 8pt;\n\tcolor: #000000;\n\tfont-weight:normal;\n\ttext-align:left;\n\tpadding-left:10px;\n\tpadding-right:10px;\n\tvertical-align:middle;\n\tborder-bottom:1px;\n\tborder-top:1px;\n\tborder-left:0px;\n\tborder-right:0px;\n\tborder-style:solid;\n\tborder-color:#949494;\n\t}\n/*IN067721 ends*/\n</style>\n\n<script src=\'../../eCA/js/FlowSheet.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</HEAD>\n\n<BODY   class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t<form name=\'flowSheetEventsForm\' id=\'flowSheetEventsForm\'>\n\n\t\t<div id=\'divUnitTitle\' style=\'postion:relative\'>\n\t\t\t<table  width=\'100%\' id=\'unitTitleTable\' class=\'grid\' align=\'center\' >\n\t\t\t\t<!-- <TR><td class=\'columnheadercenter\'>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</td><td class=\'columnheadercenter\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td><td class=\'columnheadercenter\' ><a href=\"javascript:;\" onClick=\'openGraph()\'><img title=\'Click here to view the Graph\' src=\'../../eCA/images/graph.gif\'></img></a></td></TR> -->\n\t\t\t\t<TR><TH class=\'COLUMNHEADERCENTER\' colspan=\'3\' align=\"center\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</TH></TR>\n\t\t\t\t<TR><TH class=\'COLUMNHEADERCENTER\' colspan=\'3\'>&nbsp;<br/></TH></TR> <!-- IN058144 -->\n\t\t\t</TABLE>\n\t\t</div>\n\t\t<table width=\'100%\' id=\'unitTable\' class=\'grid\' align=\'center\'>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t<input type=hidden name=\"noOfChkdBoxes\" id=\"noOfChkdBoxes\" value=\'0\'>\n\t\t\t\t\t<tr><td class=\'columnheadercenter\' style=\'visibility:hidden\' colspan=\'3\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td></tr>\n\t\t\t\t\t</Table>\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\t\t//setTimeout(\"alignUnitsAndTitle()\",100);\t\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t//parent.dataFrame.location.href=\"../../eCA/jsp/FlowSheetEventsData.jsp?p_patient_id=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&episode_type=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&p_hist_rec_type=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&p_event_class=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&p_event_group=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&eventitem=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&c_from_date=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&c_to_date=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&episode_wise=N&c_facility_id=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&encounter_id=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&performed_by=&errorEvent=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&abnormal=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&normalcy=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&viewConfRes=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&&cboFlowSheetComp=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&graphorder=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&enc_id=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&p_called_from=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\";//IN035950\n\t\t\t\t\t\t//parent.dataFrame.location.href=\"../../eCA/jsp/FlowSheetEventsData.jsp?p_patient_id=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&p_event_class_widget=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&p_called_from_widget=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&p_order_by_evtcode=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&speciality_code=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&attend_pract_code=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\";//IN035950, new param values attend_pract_code, speciality_code added for MMS-QH-CRF-0177 [IN047572]//IN071561\n\t\t\t\t\t\tparent.dataFrame.location.href=\"../../eCA/jsp/FlowSheetEventsData.jsp?p_patient_id=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&p_review_rad_yn=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="&order_type_3T=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\";//order_type_3T  added for 39052\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tparent.dataFrame.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\tparent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=APP-002415 Query caused no records to be retrieved.\";\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t\tif(top.content!=null)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\ttop.content.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=APP-002415 Query caused no records to be retrieved.\";\t\n\t\t\t\t\t\t\t\t}else\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tparent.parent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=APP-002415 Query caused no records to be retrieved.\";\t\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t<input type=hidden name=\'rowsForGraph\' id=\'rowsForGraph\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\t</form>\n\t\t<div id=\'extraTD\' style=\'position:absolute; height:5%; width:30%; visibility:hidden;\'></div>\n\t</BODY>\n</html>\n\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );
	
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
 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
041/11/2013	IN035950		Nijitha				CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
												more appealing. Keeping the display of information more clear and visible.   								 
21/06/2013	IN036050		Dinesh-Vijayakumark System does not group data which recorded from vital sign chart	
18/12/2013	IN042552		Ramesh G			Bru-HIMS-CRF-391 --- Notes Confidentiality
05/01/2016	IN058144		Ramesh G			Flowsheet uses too much blank spaces, display of date needs to be optimized. 
												Proposed is for the time to use a second line to reduce column width
11/01/2016	IN58138			Karthi L			Need to provide an alternative view to enable the quicksheet view by event and not by group.
--------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------------------------------
12/10/2016		IN047572		Karthi L											[MMS-QH-CRF-0177]To provide attending doctor and specialty  filter in the ?View Clinical Notes? and ?Clinical Event History?
03/11/2016		IN054151		Ramya M	 	22/11/2016		Karthi L		12.X-Alpha-CA- Clinical Event History - Event Grouping				
07/03/2017		IN063542		Raja S				10/03/2017		Ramesh G		GHL-CRF-0460
18/12/2018   IN067236      	 Sivabagyam M	18/12/2018	Ramesh G	   ML-MMOH-CRF-1148
03/01/2019  IN069290        	sivabagyam M      03/01/2019      Ramesh G    	 ML-MMOH-CRF-1317	
21/03/2019	IN067721		Raja S			21/03/2019		Ramesh G		ML-BRU-CRF-0516
03/02/2020			IN071561	SIVABAGYAM M		03/02/2020		RAMESH G		GHL-CRF-0558.1
05/01/2021	6030		Sivabagyam M		05/01/2021		Ramesh G	ML-MMOH-CRF-1491
03/02/2020	39052			Ramesh											ML-BRU-CRF-0634
--------------------------------------------------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block4Bytes, _wl_block4);

	  String strPatientId	= "";
	  String strEncounterId = "";
	  String strEncId = "";
	  String orderByEventCode = "N"; // INT-CRF-BRU-CIS-004 - IN058138	
	  strPatientId		= request.getParameter("p_patient_id")==null?"":request.getParameter("p_patient_id");
	  strEncounterId	= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	  strEncId	= request.getParameter("enc_id")==null?"0":request.getParameter("enc_id");
	  if(strEncounterId.equals("0"))
		strEncounterId = "";
	

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	  String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		String login_user = (String)session.getValue("login_user");//IN071561

    if(strEncId.equals(""))
	{
		strEncId ="0";
	}
	 eCA.ChartRecordingAddGroupBean chartingBean = (eCA.ChartRecordingAddGroupBean)getObjectFromBean("flowsheetBean"+strPatientId+strEncId,"eCA.ChartRecordingAddGroupBean",session);
	chartingBean.clearBean();

	
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

		  ArrayList dateList			= new ArrayList();
		  ArrayList tempDateList		= new ArrayList();
		  StringBuffer strBuffDates		= new StringBuffer();
		  StringBuffer sbQryCriteria	= new StringBuffer();
		  HashMap tempSessionMap		= null;

		  Connection con = null;
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
		  int i = 0;
	try
	{
		con = ConnectionManager.getConnection(request); 
		  StringBuffer 	sqlData = new StringBuffer();
		  
		  String strFromDate	= "";
		  String strToDate		= "";


		  String strHistRecType = "";
		  String strEventClass	= "";

		  String strEventGroup	= "";
		  String strEventCode	= "";
		  String strFacilityId	= "";

		  String strEpisodeType = "";
		  String strNormalcyInd = "";
		  String strAbnormal	= "";
		  String strFlowSheetId = "";
		  String strViewConfRes = "";
		  String strGraphOrder	= "";
		  String called_from	= "";
		  String strErrorEvent	= "";
			boolean isClinician=false;//IN067236
		  //ArrayList eventList = new ArrayList();
			boolean isViewLabRes=false;//IN069290
			boolean restrict_rd	=false;	//IN071561
			isViewLabRes=eCommon.Common.CommonBean.isSiteSpecific(con, "CA","ORDERBY_BASEDON_LAB_SEQ");//IN069290
			restrict_rd =eCommon.Common.CommonBean.isSiteSpecific(con, "CA","RD_PEER_REVIEW_RESTRICT");//IN071561
		  String clinician_id			= (String) session.getValue("ca_practitioner_id");//IN042552
		  String resp_id = (String)session.getValue("responsibility_id"); //IN042552
		  strNormalcyInd = request.getParameter("normalcy")==null?"N":request.getParameter("normalcy");
		  
		  strGraphOrder		= request.getParameter("graphorder")==null?"":request.getParameter("graphorder");
		  strViewConfRes	= request.getParameter("viewConfRes")==null?"":request.getParameter("viewConfRes");
		  strFromDate		= request.getParameter("c_from_date")==null?"":request.getParameter("c_from_date");
		  strToDate			= request.getParameter("c_to_date")==null?"":request.getParameter("c_to_date");
		  strFlowSheetId	= request.getParameter("cboFlowSheetComp")==null?"":request.getParameter("cboFlowSheetComp");
		  strEventCode		= request.getParameter("eventitem")==null?"":request.getParameter("eventitem");
		  strErrorEvent		= request.getParameter("errorEvent")==null?"":request.getParameter("errorEvent");
		  strAbnormal		= request.getParameter("abnormal")==null?"N":request.getParameter("abnormal");

		  strEventGroup		= request.getParameter("p_event_group")==null?"":request.getParameter("p_event_group");
		  strEventClass		= request.getParameter("p_event_class")==null?"":request.getParameter("p_event_class");
		  strHistRecType	= request.getParameter("p_hist_rec_type")==null?"":request.getParameter("p_hist_rec_type");
		  called_from		= request.getParameter("p_called_from")==null?"":request.getParameter("p_called_from");
		  strFacilityId		= request.getParameter("c_facility_id")==null?"":request.getParameter("c_facility_id");
		  strEpisodeType	= request.getParameter("episode_type")==null?"":request.getParameter("episode_type");
		  orderByEventCode 	= request.getParameter("p_order_by_evtcode")==null?"N":request.getParameter("p_order_by_evtcode");  // INT-CRF-BRU-CIS-004 - IN058138
		  //IN035950 Starts
		   String eventClasswidget		= request.getParameter("p_event_class_widget")==null?"":request.getParameter("p_event_class_widget");
		   String called_from_widget		= request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget");
		  String p_hist_type		= request.getParameter("p_hist_type")==null?"":request.getParameter("p_hist_type");
		  String speciality_code		=	request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");  // MMS-QH-CRF-0177 [IN047572]	
		  String attend_pract_code	= 	request.getParameter("attend_pract_code")==null?"":request.getParameter("attend_pract_code"); // MMS-QH-CRF-0177 [IN047572]	
		  String p_review_rad_yn=request.getParameter("p_review_rad_yn")==null?"N":request.getParameter("p_review_rad_yn");//IN071561
		  
		  String order_type_3T	= request.getParameter("order_type_3T")==null?"": request.getParameter("order_type_3T"); //39052
	
		  if("CA_RESULTS_WIDGET".equals(called_from_widget))
		  strHistRecType=p_hist_type;
		  //IN035950 Ends
		  strToDate = strToDate.equals("null")?"":strToDate;
		

//		  strFromDate	= com.ehis.util.DateUtils.convertDate(strFromDate,"DMYHM",locale,"en");
//		  strToDate		= com.ehis.util.DateUtils.convertDate(strToDate,"DMYHM",locale,"en");

		  sbQryCriteria.append(" a.patient_id = ? ");

			if(!strHistRecType.equals(""))
				sbQryCriteria.append(" and a.hist_rec_type = ? ");

			if(!strEventClass.equals(""))
				sbQryCriteria.append(" and a.event_class = ? ");

			if(!strEventGroup.equals(""))
				sbQryCriteria.append(" and a.event_group = ? ");

			if(!strEventCode.equals(""))
				sbQryCriteria.append(" and a.event_code = ? ");

			if(!strFromDate.equals(""))
				sbQryCriteria.append(" and a.event_date >= to_date(?,'dd/mm/yyyy HH24:MI')");

			if(!strToDate.equals(""))
				sbQryCriteria.append(" and a.event_date <= to_date(?,'dd/mm/yyyy HH24:MI')+0.00068287"); //adding 59 seconds more to the todate

			if(!strFacilityId.equals(""))
				sbQryCriteria.append(" and a.facility_id = ? ");

		//IN035950 Start
		if("CA_CLINICIAN_WIDGET".equals(called_from_widget) && "".equals(eventClasswidget))
		{
			sbQryCriteria.append(" AND a.event_class IN ('PHY$','CLI$','NUR$') ");
		}
		else if("CA_CLINICIAN_WIDGET".equals(called_from_widget) && !"".equals(eventClasswidget))
		{
			sbQryCriteria.append(" AND a.event_class=? ");
		}
		//IN035950 End
			if(!strEncounterId.equals(""))
				sbQryCriteria.append(" and a.encounter_id = ? ");

			if (!strEpisodeType.equals("") )
				sbQryCriteria.append(" and a.PATIENT_CLASS = ? ");

			if(strAbnormal.equals("Y"))
			{
				//Modified the following condition by Archana on 9/16/2010 related to the incident IN023804.
				sbQryCriteria.append(" and nvl(a.normalcy_ind,'.')!='.' ");
			}

			if(strViewConfRes.equals("X"))
				//sbQryCriteria.append("and nvl(PROTECTION_IND,'N')!='Z')");
				//sbQryCriteria.append("and nvl(PROTECTION_IND,'N')!='Z'  ");//VICHAYUT DEMO Issue
				sbQryCriteria.append("and nvl(a.PROTECTION_IND,'N')!='Z'  ");//VICHAYUT DEMO Issue
			sbQryCriteria.append(" and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' "); //IN042552
		   if(strErrorEvent.equals("Y"))//dont'include error events
			    sbQryCriteria.append(" and nvl(a.STATUS,'`')!= 'S'  ");
		   else 
			   sbQryCriteria.append(" and nvl(a.STATUS,'`') not in('S','E')");
			
		  if(restrict_rd)
			sbQryCriteria.append( " AND RD_PEER_RESULT_HIDE_YN (a.CONTR_SYS_ID,a.facility_id,A.REQUEST_NUM,a.request_num_seq,'"+login_user+"')='N' ");
		
		  if(!isViewLabRes)
			  sqlData.append( " Select a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time, a.hist_rec_type hist_type, b.short_desc hist_rec_type_desc, a.event_class eve_class, c.long_desc event_class_desc, nvl(a.event_group,'*ALL') event_group,nvl(e.long_desc,d.long_desc) event_group_desc ,a.event_code eve_code,d.long_desc  event_desc,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.hist_data_type hist_data_type From cr_encounter_detail a ,CR_HIS_RECTYP_LNG_VW b, CR_EVENT_CLASS_LANG_VW c ,CR_CLN_EVT_MST_LANG_VW d ,CR_CLN_EVT_GRP_LANG_VW e, PR_ENCOUNTER g "); // added PR_ENCOUNTER g for  MMS-QH-CRF-0177 [IN047572] //6030
			
			  else
				  sqlData.append( " Select a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time, a.hist_rec_type hist_type, b.short_desc hist_rec_type_desc, a.event_class eve_class, c.long_desc event_class_desc, nvl(a.event_group,'*ALL') event_group,nvl(e.long_desc,d.long_desc) event_group_desc ,a.event_code eve_code,d.long_desc  event_desc,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.hist_data_type hist_data_type,RL_NEW_REQUEST_NUM_SEQ(a.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no  From cr_encounter_detail a ,CR_HIS_RECTYP_LNG_VW b, CR_EVENT_CLASS_LANG_VW c ,CR_CLN_EVT_MST_LANG_VW d ,CR_CLN_EVT_GRP_LANG_VW e, PR_ENCOUNTER g "); // added PR_ENCOUNTER g for  MMS-QH-CRF-0177 [IN047572] //6030


			if (!strFlowSheetId.equals(""))
				sqlData.append(" ,ca_flow_sheet_item f ");

			sqlData.append(" where g.FACILITY_ID(+) = a.FACILITY_ID AND g.ENCOUNTER_ID(+) = a.ENCOUNTER_ID and b.hist_rec_type=a.hist_rec_type and c.hist_rec_type=a.hist_rec_type and  c.event_class = a.event_class and   d.hist_rec_type = a.hist_rec_type and  d.event_code = a.event_code and  D.EVENT_CODE_TYPE = a.EVENT_CODE_TYPE and e.hist_rec_type(+) = a.hist_rec_type and  e.event_group(+) = a.event_group and e.EVENT_GROUP_TYPE(+)= a.EVENT_GROUP_TYPE ##ORDERTYPERESULT## and d.language_id = ? and b.language_id = ? and c.language_id = ? and e.language_id(+) = ? "); // conditions facility_id and specialty_id added for MMS-QH-CRF-0177 [IN047572]    
			
			if(!strFlowSheetId.equals(""))
			{
				//sqlData.append(" and  f.flow_sheet_id = ? and f.hist_rec_type = a.hist_rec_type and f.event_code = a.event_code and  f.EVENT_CODE_TYPE = a.EVENT_CODE_TYPE  ") ;  // Commented for IN063542
				sqlData.append(" and  f.flow_sheet_id = ? and f.hist_rec_type = a.hist_rec_type and  f.EVENT_CODE_TYPE = a.EVENT_CODE_TYPE AND (f.event_code = a.event_code OR f.event_code = a.EVENT_GROUP) ") ;// Added for IN063542
			}

			sqlData.append( " AND " + sbQryCriteria.toString());
			if(attend_pract_code.equals("")){ // MMS-QH-CRF-0177 [IN047572] - Start
				if(!speciality_code.equals("")){
					sqlData.append(" and g.SPECIALTY_CODE = ? ");
				}
			} else {
				sqlData.append(" and g.ATTEND_PRACTITIONER_ID = ? ");
			} // MMS-QH-CRF-0177 [IN047572] - End
			//IN071561 starts
			//IN071561 ends
		   if (!strFlowSheetId.equals("")) {
				//sqlData.append( " ORDER BY f.order_seq_no, a.hist_rec_type  ,a.event_class,c.long_desc, nvl(a.event_group,'*ALL') ,e.long_desc  ,DECODE(A.HIST_REC_TYPE,'LBIN',nvl(a.request_num_seq,d.long_desc),d.long_desc),a.event_code, dummydate "+strGraphOrder+" " );
				if(orderByEventCode.equals("Y")) { // INT-CRF-BRU-CIS-004 - IN058138 - Start
					if(!isViewLabRes)
						sqlData.append( " ORDER BY f.order_seq_no, a.hist_rec_type  ,a.event_class,c.long_desc, d.long_desc, nvl(a.event_group,'*ALL') ,e.long_desc  ,nvl(a.request_num_seq,'0'), a.event_code, dummydate "+strGraphOrder+" " ); // modified by LK//6030
						else
							sqlData.append( " ORDER BY f.order_seq_no, a.hist_rec_type  ,a.event_class,c.long_desc, d.long_desc, nvl(a.event_group,'*ALL') ,e.long_desc  , NVL (sequence_no,0), a.event_code, dummydate "+strGraphOrder+" " ); // 6030
				} else { // INT-CRF-BRU-CIS-004 - IN058138 - End
				if(!isViewLabRes)//IN069290 starts
			   		sqlData.append( " ORDER BY f.order_seq_no, a.hist_rec_type  ,a.event_class,c.long_desc, nvl(a.event_group,'*ALL') ,e.long_desc  ,nvl(a.request_num_seq,'0'),d.long_desc,a.event_code, dummydate "+strGraphOrder+" " );
					else
					//sqlData.append( " ORDER BY f.order_seq_no, a.hist_rec_type  ,a.event_class, ,nvl(a.request_num_seq,'0'), nvl(a.event_group,'*ALL'),c.long_desc,e.long_desc ,d.long_desc,a.event_code, dummydate "+strGraphOrder+" " );//IN069290 ends //6030
					sqlData.append( " ORDER BY f.order_seq_no, a.hist_rec_type  ,a.event_class, NVL (sequence_no,0), nvl(a.event_group,'*ALL'),c.long_desc,e.long_desc ,d.long_desc,a.event_code, dummydate "+strGraphOrder+" " );//IN069290 ends//6030
				}	// INT-CRF-BRU-CIS-004 - IN058138
		   } else {
			 //IN036050 starts
			 //23-12-2013 - changes reverted for MOD Oman
			 
				if(orderByEventCode.equals("Y")) { // INT-CRF-BRU-CIS-004 - IN058138 - Start
					if(!isViewLabRes)
						sqlData.append( " ORDER BY  b.short_desc, a.hist_rec_type, c.long_desc,  d.long_desc, a.event_class, nvl(a.request_num_seq,'0'), event_group_desc, nvl(a.event_group,'*ALL'),  a.event_code, dummydate "+strGraphOrder+" " ); // modified by LK//6030
					else
						sqlData.append( " ORDER BY  b.short_desc, a.hist_rec_type, c.long_desc,  d.long_desc, a.event_class,  NVL (sequence_no,0), event_group_desc, nvl(a.event_group,'*ALL'),  a.event_code, dummydate "+strGraphOrder+" " ); // modified by LK//6030
				} else { // INT-CRF-BRU-CIS-004 - IN058138 - End
					//IN054151 Start
					//sqlData.append( " ORDER BY  b.short_desc, a.hist_rec_type, c.long_desc,  a.event_class, nvl(a.request_num_seq,'0'), event_group_desc, nvl(a.event_group,'*ALL'), d.long_desc, a.event_code, dummydate "+strGraphOrder+" " );
				if(!isViewLabRes)
					sqlData.append( " ORDER BY  b.short_desc, a.hist_rec_type, c.long_desc,  a.event_class,event_group_desc, nvl(a.request_num_seq,'0'), nvl(a.event_group,'*ALL'), d.long_desc, a.event_code, dummydate "+strGraphOrder+" " );//IN069290
					else
						//sqlData.append( " ORDER BY  b.short_desc, a.hist_rec_type, c.long_desc,  a.event_class, nvl(a.request_num_seq,'0'), nvl(a.event_group,'*ALL'), d.long_desc, a.event_code, dummydate "+strGraphOrder+" " );//IN069290//6030
						sqlData.append( " ORDER BY  b.short_desc, a.hist_rec_type, c.long_desc,  a.event_class,  NVL (sequence_no,0), nvl(a.event_group,'*ALL'), d.long_desc, a.event_code, dummydate "+strGraphOrder+" " );//IN069290//6030
					//IN054151 End
				} // INT-CRF-BRU-CIS-004 - IN058138
		   }
			//sqlData.append( " ORDER BY event_group_desc, b.short_desc, a.hist_rec_type, c.long_desc, a.event_class, nvl(a.request_num_seq,'0'),  nvl(a.event_group,'*ALL'), d.long_desc, a.event_code, dummydate "+strGraphOrder+" " );
			 //IN036050 ends

			 //Commented by Jyothi on 29/03/2010 to fix IN018685 and added the above line
			 //sqlData.append( " ORDER BY  a.hist_rec_type  ,a.event_class, c.long_desc,nvl(a.event_group,'*ALL'),e.long_desc  ,nvl(a.request_num_seq,'0'),d.long_desc,a.event_code , dummydate "+strGraphOrder+" " );

			 //sqlData.append( " ORDER BY  a.hist_rec_type  ,a.event_class, c.long_desc,nvl(a.event_group,'*ALL'),e.long_desc  ,DECODE(A.HIST_REC_TYPE,'LBIN',nvl(a.request_num_seq,d.long_desc),d.long_desc),a.event_code , dummydate "+strGraphOrder+" " );



			strBuffDates.append("Select to_char(a.event_date,'dd/mm/yyyy hh24:mi') event_date 	From 	cr_encounter_detail a, pr_encounter b "); // added pr_encounter b for MMS-QH-CRF-0177 [IN047572]

			strBuffDates.append("where  "+sbQryCriteria.toString());


			if(!strFlowSheetId.equals("")){
				//strBuffDates.append(" and exists (select 1 from ca_flow_sheet_item f where f.flow_sheet_id=? and f.hist_rec_type=a.hist_rec_type and  f.event_code=a.event_code  and  f.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) ") ; // Commented for IN063542
				strBuffDates.append(" and exists (select 1 from ca_flow_sheet_item f where f.flow_sheet_id=? and f.hist_rec_type=a.hist_rec_type  and  f.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE AND (f.event_code = a.event_code OR f.event_code = a.EVENT_GROUP)) ") ; // Added for IN063542
			}
			strBuffDates.append(" AND b.FACILITY_ID(+) = a.FACILITY_ID AND b.ENCOUNTER_ID(+) = a.ENCOUNTER_ID "); // MMS-QH-CRF-0177 [IN047572] - Start
			if(attend_pract_code.equals("")){ 
				if(!speciality_code.equals("")){
					strBuffDates.append(" and b.SPECIALTY_CODE = ? ");
				}
			} else {
				strBuffDates.append(" and b.ATTEND_PRACTITIONER_ID = ? ");
			} // MMS-QH-CRF-0177 [IN047572] - End
			strBuffDates.append(" Order by to_date(event_date,'dd/mm/yyyy hh24:mi')  "+strGraphOrder);



			
			String classValue = "";
			String histRecType = "";
			String eventDummyDate = "";
			String prevHistRecType = "";
			String histRecTypeDesc = "";
			String eventClass = "";
			String prevEventClass = "";
			String eventClassDesc = "";
			String eventGroup = "";
			String prevEventGroup = "";
			String eventGroupDesc = "";
			String eventCode = "";
			String prevEventCode = "";
			String eventDesc = "";
			String histDataType = "";
			String resultNumUOM = "";
			String resultNum = "";

			PreparedStatement pstmtDate = null;
			ResultSet resDate = null;

			int nIndex =1;
			
				isClinician = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","CLINICIAN_TO_THERAPIST");//IN067236
				
				//39052 Start.
				String  sqlQuery = sqlData.toString();
				if("CA01".equals(order_type_3T)){
					sqlQuery=sqlQuery.replaceAll("##ORDERTYPERESULT##"," AND 'CA01'=SUBSTR(a.ACCESSION_NUM,0,4) ");
				}else{
					sqlQuery=sqlQuery.replaceAll("##ORDERTYPERESULT##","");
				}
				//39052 End.
				
				pstmt = con.prepareStatement(sqlQuery);
				
				pstmt.setString(nIndex++,locale);
				pstmt.setString(nIndex++,locale);
				pstmt.setString(nIndex++,locale);
				pstmt.setString(nIndex++,locale);
				if (!strFlowSheetId.equals(""))
					pstmt.setString(nIndex++,strFlowSheetId);

				pstmt.setString(nIndex++,strPatientId);

				if(!strHistRecType.equals(""))
					pstmt.setString(nIndex++,strHistRecType);

				if(!strEventClass.equals(""))
					pstmt.setString(nIndex++,strEventClass);

				if(!strEventGroup.equals(""))
					pstmt.setString(nIndex++,strEventGroup);

				if(!strEventCode.equals(""))
					pstmt.setString(nIndex++,strEventCode);

				if(!strFromDate.equals(""))
					pstmt.setString(nIndex++,strFromDate);

				if(!strToDate.equals(""))
					pstmt.setString(nIndex++,strToDate);
				
				if(!strFacilityId.equals(""))
					pstmt.setString(nIndex++,strFacilityId);

				//IN035950 Start
					if("CA_CLINICIAN_WIDGET".equals(called_from_widget) && !"".equals(eventClasswidget))
					{
						pstmt.setString(nIndex++,eventClasswidget);
					}
				//IN035950 Ends
				if(!strEncounterId.equals(""))
					pstmt.setString(nIndex++,strEncounterId);
			
				if(!strEpisodeType.equals("") )
				{
					if(strEpisodeType.equals("I"))
						pstmt.setString(nIndex++,"IP");
					else if(strEpisodeType.equals("O"))
						pstmt.setString(nIndex++,"OP");
					else if(strEpisodeType.equals("D"))
						pstmt.setString(nIndex++,"DC");
					else if(strEpisodeType.equals("E"))
						pstmt.setString(nIndex++,"EM");
					else if(strEpisodeType.equals("X"))
						pstmt.setString(nIndex++,"XT");
				}
				if(attend_pract_code.equals("")){ // MMS-QH-CRF-0177 [IN047572] - Start
					if(!speciality_code.equals("")){
						pstmt.setString(nIndex++, speciality_code);
					}
				} else {
					pstmt.setString(nIndex++, attend_pract_code);
				} // MMS-QH-CRF-0177 [IN047572] - End
				nIndex = 1;

				pstmtDate = con.prepareStatement(strBuffDates.toString());

				pstmtDate.setString(nIndex++,strPatientId);

				if(!strHistRecType.equals(""))
					pstmtDate.setString(nIndex++,strHistRecType);


				if(!strEventClass.equals(""))
					pstmtDate.setString(nIndex++,strEventClass);

				if(!strEventGroup.equals(""))
					pstmtDate.setString(nIndex++,strEventGroup);

				if(!strEventCode.equals(""))
					pstmtDate.setString(nIndex++,strEventCode);

				if(!strFromDate.equals(""))
					pstmtDate.setString(nIndex++,strFromDate);

				if(!strToDate.equals(""))
					pstmtDate.setString(nIndex++,strToDate);

				if(!strFacilityId.equals(""))
					pstmtDate.setString(nIndex++,strFacilityId);

				//IN035950 Start
					if("CA_CLINICIAN_WIDGET".equals(called_from_widget) && !"".equals(eventClasswidget))
					{
						pstmtDate.setString(nIndex++,eventClasswidget);
					}
				//IN035950 Ends
				if(!strEncounterId.equals(""))
					pstmtDate.setString(nIndex++,strEncounterId);
			
				if(!strEpisodeType.equals("") )
				{
					if(strEpisodeType.equals("I"))
						pstmtDate.setString(nIndex++,"IP");
					else if(strEpisodeType.equals("O"))
						pstmtDate.setString(nIndex++,"OP");
					else if(strEpisodeType.equals("D"))
						pstmtDate.setString(nIndex++,"DC");
					else if(strEpisodeType.equals("E"))
						pstmtDate.setString(nIndex++,"EM");
					else if(strEpisodeType.equals("X"))
						pstmtDate.setString(nIndex++,"XT");
				}
				
				if(!strFlowSheetId.equals(""))
					pstmtDate.setString(nIndex++,strFlowSheetId);
				
				if(attend_pract_code.equals("")){ // MMS-QH-CRF-0177 [IN047572] - Start
					if(!speciality_code.equals("")){
						pstmtDate.setString(nIndex++, speciality_code);
					}
				} else {
					pstmtDate.setString(nIndex++, attend_pract_code);
				} // MMS-QH-CRF-0177 [IN047572] - End
				
				int tempInt = 0;

				try
				{
					rs = pstmt.executeQuery();
				}
				catch (Exception eeee)
				{
					//out.println("Exception in Query 1 try of FlowSheetEvents.jsp--"+eeee.toString());//COMMON-ICN-0181
							eeee.printStackTrace();//COMMON-ICN-0181
				}
		
				try
				{
					resDate = pstmtDate.executeQuery();
				}
				catch (Exception eee2)
				{
					//out.println("Exception in Query 2 try of FlowSheetEvents.jsp--"+eee2.toString());//COMMON-ICN-0181
							eee2.printStackTrace();//COMMON-ICN-0181
				}
				
				while(resDate.next())
				{
					if(dateList.size() < 10)
					{
						if(!dateList.contains(resDate.getString(1)))
						{
						   dateList.add(resDate.getString(1));
						}
					   tempDateList.add(resDate.getString(1));
					}
					else if(dateList.size() == 10)
					{
						if(dateList.contains(resDate.getString(1)))
						{
							tempDateList.add(resDate.getString(1));
						}
						else
						{
							break;
						}
					}
				}

				if (resDate!=null) resDate.close();
				if (pstmtDate!=null) pstmtDate.close();
				tempSessionMap = new HashMap();

				while(rs.next())
				{
					eventDummyDate = rs.getString("event_date_time") == null ? "" : rs.getString("event_date_time");
					histRecType = rs.getString("hist_type") == null ? "" : rs.getString("hist_type");
					histRecTypeDesc = rs.getString("hist_rec_type_desc") == null ? "" : rs.getString("hist_rec_type_desc");
					eventClass = rs.getString("eve_class") == null ? "" : rs.getString("eve_class");
					eventClassDesc = rs.getString("event_class_desc") == null ? "" : rs.getString("event_class_desc");
					eventGroup = rs.getString("event_group") == null ? "" : rs.getString("event_group");
					eventGroupDesc = rs.getString("event_group_desc") == null ? "" : rs.getString("event_group_desc");
					eventCode = rs.getString("eve_code") == null ? "" : rs.getString("eve_code");
					eventDesc = rs.getString("event_desc") == null ? "" : rs.getString("event_desc");
					resultNumUOM = rs.getString("uom") == null ? "" : rs.getString("uom");
					histDataType = rs.getString("hist_data_type") == null ? "" : rs.getString("hist_data_type");
					resultNum = rs.getString("RESULT_NUM") == null ? "" : rs.getString("RESULT_NUM");

					if(isClinician&&eventClassDesc.equals("Clinician Notes"))//IN067236
						eventClassDesc="Therapist Notes";//IN067236
					if(dateList.contains(eventDummyDate))
					{
						tempSessionMap.put("histRecType"+tempInt,histRecType);
						tempSessionMap.put("eventDummyDate"+tempInt,eventDummyDate);
						tempSessionMap.put("histRecTypeDesc"+tempInt,histRecTypeDesc);
						tempSessionMap.put("eventClass"+tempInt,eventClass);
						tempSessionMap.put("eventClassDesc"+tempInt,eventClassDesc);
						tempSessionMap.put("eventGroup"+tempInt,eventGroup);
						tempSessionMap.put("eventGroupDesc"+tempInt,eventGroupDesc);
						tempSessionMap.put("eventCode"+tempInt,eventCode);
						tempSessionMap.put("eventDesc"+tempInt,eventDesc);
						tempSessionMap.put("resultNumUOM"+tempInt,resultNumUOM);
						tempSessionMap.put("histDataType"+tempInt,histDataType);
						tempSessionMap.put("resultNum"+tempInt,resultNum);
						tempInt++;
					}
				}//end of while


				if (rs!=null) rs.close();
				if (pstmt!=null) pstmt.close();
				int tempGrafSeq = 0;

				for(i=0;i<tempInt;i++)
				{
					histRecType = (String) tempSessionMap.get("histRecType"+i);
					eventDummyDate = (String) tempSessionMap.get("eventDummyDate"+i);
					histRecTypeDesc = (String) tempSessionMap.get("histRecTypeDesc"+i);
					eventClass = (String) tempSessionMap.get("eventClass"+i);
					eventClassDesc = (String) tempSessionMap.get("eventClassDesc"+i);
					eventGroup = (String) tempSessionMap.get("eventGroup"+i);
					//out.println(eventGroup);
					eventGroupDesc = (String) tempSessionMap.get("eventGroupDesc"+i);
					eventCode = (String) tempSessionMap.get("eventCode"+i);
					eventDesc = (String) tempSessionMap.get("eventDesc"+i);
					resultNumUOM = (String) tempSessionMap.get("resultNumUOM"+i);
					histDataType = (String) tempSessionMap.get("histDataType"+i);
					resultNum = (String) tempSessionMap.get("resultNum"+i);

					if(i % 2 == 0)
						classValue = "CACHARTQRYEVEN";
					else
						classValue = "CACHARTQRYEVEN";

					if(!prevHistRecType.equals(histRecType))
					{
						out.println("<TR>");
						out.println("<TD colspan='3' class='CAFLOWSHEETLEVEL1'>"+histRecTypeDesc+"</TD>");
						out.println("</TR>");
						out.println("<TR>");
						out.println("<TD colspan='3' class='CAFLOWSHEETLEVEL2'>"+eventClassDesc+"</TD>");
						out.println("</TR>");

						//if(!eventGroup.equals("*ALL")) - commented for INT-CRF-BRU-CIS-004 - IN058138
						if(!eventGroup.equals("*ALL") && orderByEventCode.equals("N"))	// modified for INT-CRF-BRU-CIS-004 - IN058138
						{
							out.println("<TR>");
							out.println("<TD colspan='3' class='CAFLOWSHEETLEVEL3'>"+eventGroupDesc+"</TD>");
							out.println("</TR>");
						}
						out.println("<TR id='trIDGraph"+tempGrafSeq+"'>");
						out.println("<TD class='gridDataChart' width='140px'>"+eventDesc+"</TD>");
						if(!resultNumUOM.equals(""))
							out.println("<TD class='gridDataChart' width='80px'>["+resultNumUOM+"]</TD>");
						else
							out.println("<TD class='gridDataChart' width='80px'>"+resultNumUOM+"</TD>");
						if(histDataType.equals("NUM"))
						{
							if(resultNumUOM.equals("") || resultNumUOM == null) resultNumUOM = " ";
							out.println("<TD  class='gridDataChart' width='30px' align=center><input type='checkbox' id='chkGraphID"+tempGrafSeq+"' name='chkGraph' id='chkGraph' value='"+eventCode+"' onClick='constructValsForGraph("+tempGrafSeq+");limitTheGraphs(this)'></input><input type='hidden' name='UOM"+tempGrafSeq+"' id='UOM"+tempGrafSeq+"' value='"+resultNumUOM+"'><input type='hidden' name='desc"+tempGrafSeq+"' id='desc"+tempGrafSeq+"' value='"+eventDesc+"'></TD>");
						}
						else
						{
							out.println("<TD class='gridDataChart'>&nbsp;</TD>");
						}
						out.println("</TR>");
						tempGrafSeq++;
						prevHistRecType = histRecType;
						prevEventClass = eventClass ;
						prevEventGroup = eventGroup;
						prevEventCode = eventCode;
					}
					else if(!prevEventClass.equals(eventClass))
					{
						out.println("<TR>");
						out.println("<TD colspan='3' class='CAFLOWSHEETLEVEL2'>"+eventClassDesc+"</TD>");
						out.println("</TR>");
						//if(!eventGroup.equals("*ALL")) - commented for INT-CRF-BRU-CIS-004 - IN058138
						if(!eventGroup.equals("*ALL") && orderByEventCode.equals("N"))	// modified for INT-CRF-BRU-CIS-004 - IN058138
						{//event group is empty
							out.println("<TR>");
							out.println("<TD colspan='3' class='CAFLOWSHEETLEVEL3'>"+eventGroupDesc+"</TD>");
							out.println("</TR>");
						}
						out.println("<TR id='trIDGraph"+tempGrafSeq+"'>");
						out.println("<TD class='gridDataChart' width='140px'>"+eventDesc+"</TD>");
						if(!resultNumUOM.equals(""))
							out.println("<TD class='gridDataChart' width='80px'>["+resultNumUOM+"]</TD>");
						else
							out.println("<TD class='gridDataChart' width='80px'>"+resultNumUOM+"</TD>");
						if(histDataType.equals("NUM"))
						{
							if(resultNumUOM.equals("") || resultNumUOM == null) resultNumUOM = " ";
							out.println("<TD  class='gridDataChart' width='30px' align=center><input type='checkbox' id='chkGraphID"+tempGrafSeq+"' name='chkGraph' id='chkGraph' value='"+eventCode+"' onClick='constructValsForGraph("+tempGrafSeq+");limitTheGraphs(this)'></input><input type='hidden' name='UOM"+tempGrafSeq+"' id='UOM"+tempGrafSeq+"' value='"+resultNumUOM+"'><input type='hidden' name='desc"+tempGrafSeq+"' id='desc"+tempGrafSeq+"' value='"+eventDesc+"'></TD>");
						}
						else
						{
							out.println("<TD class='gridDataChart'>&nbsp;</TD>");
						}
						out.println("</TR>");
						prevEventClass = eventClass;
						prevEventGroup = eventGroup;
						prevEventCode = eventCode;
						tempGrafSeq++;
					}
					//else if(!prevEventGroup.equals(eventGroup))
					else if(!prevEventGroup.equals(eventGroup) && orderByEventCode.equals("N"))		// modified for INT-CRF-BRU-CIS-004 - IN058138
					{
						if(!eventGroup.equals("*ALL"))
						{
							out.println("<TR>");
							out.println("<TD colspan='3' class='CAFLOWSHEETLEVEL3'>"+eventGroupDesc+"</TD>");
							out.println("</TR>");
						}
						out.println("<TR id='trIDGraph"+tempGrafSeq+"'>");
						out.println("<TD class='gridDataChart' width='140px'>"+eventDesc+"</TD>");
						if(!resultNumUOM.equals(""))
							out.println("<TD class='gridDataChart' width='80px'>["+resultNumUOM+"]</TD>");
						else
							out.println("<TD class='gridDataChart' width='80px'>"+resultNumUOM+"</TD>");
						if(histDataType.equals("NUM"))
						{
							if(resultNumUOM.equals("") || resultNumUOM == null) resultNumUOM = " ";
							out.println("<TD  class='gridDataChart' width='30px' align=center><input type='checkbox'  id='chkGraphID"+tempGrafSeq+"' name='chkGraph' id='chkGraph' value='"+eventCode+"' onClick='constructValsForGraph("+tempGrafSeq+");limitTheGraphs(this)'></input><input type='hidden' name='UOM"+tempGrafSeq+"' id='UOM"+tempGrafSeq+"' value='"+resultNumUOM+"'><input type='hidden' name='desc"+tempGrafSeq+"' id='desc"+tempGrafSeq+"' value='"+eventDesc+"'></TD>");
						}
						else
						{
							out.println("<TD class='gridDataChart'>&nbsp;</TD>");
						}
						out.println("</TR>");
						prevEventGroup = eventGroup;
						prevEventCode = eventCode;
						tempGrafSeq++;
					}
					else if(!prevEventCode.equals(eventCode))
					{
						out.println("<TR id='trIDGraph"+tempGrafSeq+"'>");
						out.println("<TD class='gridDataChart' width='140px'>"+eventDesc+"</TD>");
						if(!resultNumUOM.equals(""))
							out.println("<TD class='gridDataChart' width='80px'>["+resultNumUOM+"]</TD>");
						else
							out.println("<TD class='gridDataChart' width='80px'>"+resultNumUOM+"</TD>");
						if(histDataType.equals("NUM"))
						{
							if(resultNumUOM.equals("") || resultNumUOM == null) resultNumUOM = " ";
							out.println("<TD  class='gridDataChart' width='30px' align=center><input type='checkbox'  id='chkGraphID"+tempGrafSeq+"' name='chkGraph' id='chkGraph' value='"+eventCode+"' onClick='constructValsForGraph("+tempGrafSeq+");limitTheGraphs(this)'></input><input type='hidden' name='UOM"+tempGrafSeq+"' id='UOM"+tempGrafSeq+"' value='"+resultNumUOM+"'><input type='hidden' name='desc"+tempGrafSeq+"' id='desc"+tempGrafSeq+"' value='"+eventDesc+"'></TD>");
						}
						else
						{
							out.println("<TD class='gridDataChart'>&nbsp;</TD>");
						}
						out.println("</TR>");
						prevEventCode = eventCode;
						tempGrafSeq++;
					}
				}//end of for
				//out.println("<script>alert('"+i+"')</script>");
				
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

					if(i != 0)
					{
				
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strEpisodeType));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strHistRecType));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strEventClass));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strEventGroup));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strEventCode));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strFromDate));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strToDate));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strFacilityId));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strErrorEvent));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strAbnormal));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(strNormalcyInd));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(strViewConfRes));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strFlowSheetId));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(strGraphOrder));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strEncId));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strEpisodeType));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strHistRecType));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strEventClass));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strEventGroup));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strEventCode));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strFromDate));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strToDate));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strFacilityId));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strErrorEvent));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strAbnormal));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(strNormalcyInd));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(strViewConfRes));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strFlowSheetId));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(strGraphOrder));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strEncId));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(eventClasswidget));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(called_from_widget));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(orderByEventCode));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(attend_pract_code));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strEpisodeType));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strHistRecType));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strEventClass));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strEventGroup));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strEventCode));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strFromDate));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strToDate));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strFacilityId));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strErrorEvent));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strAbnormal));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(strNormalcyInd));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(strViewConfRes));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strFlowSheetId));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(strGraphOrder));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strEncId));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(eventClasswidget));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(called_from_widget));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(orderByEventCode));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(attend_pract_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(p_review_rad_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(order_type_3T));
            _bw.write(_wl_block39Bytes, _wl_block39);

					}
					else
					{
				
            _bw.write(_wl_block40Bytes, _wl_block40);

							if(called_from.equals("OR"))
							{
						
            _bw.write(_wl_block41Bytes, _wl_block41);

							}
							else
							{
						
            _bw.write(_wl_block42Bytes, _wl_block42);

							}
				}
			}//end of try---main
			catch(Exception exception)
			{
				//out.println("Exception in main try of FlowSheetEvents.jsp--"+exception.toString());//common-icn-0181
				exception.printStackTrace();
			}
			finally
			{
				if(con!=null) ConnectionManager.returnConnection(con,request);
			}
			//session.setAttribute("eventList",eventList);
		
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Event.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Unit.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Event.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Event.label", java.lang.String .class,"key"));
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
}
