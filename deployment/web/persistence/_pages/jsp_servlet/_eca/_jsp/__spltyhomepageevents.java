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

public final class __spltyhomepageevents extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/SpltyHomePageEvents.jsp", 1709116362340L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<HTML>\n<HEAD>\n<TITLE> New Document </TITLE>\n<META NAME=\"Generator\" CONTENT=\"EditPlus\">\n<META NAME=\"Author\" CONTENT=\"\">\n<META NAME=\"Keywords\" CONTENT=\"\">\n<META NAME=\"Description\" CONTENT=\"\">\n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<style>\nA:active{\n\tcolor:white;\n}\nA:visited{\n\tcolor:white;\n}\nA:link {\n\tCOLOR:white;\n}\n\n</style>\n\n<script src=\'../../eCA/js/SpltyHomePage.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</HEAD>\n\n<BODY   class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t<form name=\'flowSheetEventsForm\' id=\'flowSheetEventsForm\'>\n\n\t\t<div id=\'divUnitTitle\' style=\'postion:relative\'>\n\t\t\t<table border=\'1\' width=\'100%\' id=\'unitTitleTable\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' >\n\t\t\t\t<TR><TH>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</TH><TH>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</TH><TH><!-- <input type=\'image\' src=\'../../eCA/images/graph.gif\' title=\'Click on the image to view the Graph\' onClick=\'openGraph()\'></input> --><a href=\"javascript:;\" onClick=\'openGraph()\'><img title=\'Click here to view the Graph\' src=\'../../eCA/images/graph.gif\'></img></a></TH></TR>\n\t\t\t</TABLE>\n\t\t</div>\n\t\t<table border=\'1\' width=\'100%\' id=\'unitTable\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\' style=\"border-bottom:#ffffff\">\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<TR style=\'visibility:hidden\'><TH class=\'WHITE\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</TH><TH class=\'WHITE\' >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</TH><TH class=\'WHITE\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</TH> </TR>\n\t\t\t\t\t<TR style=\'visibility:hidden\'><TH class=\'WHITE\' >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</TH> </TR>\n\t\t\t\t\t</Table>\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\t\tsetTimeout(\"alignUnitsAndTitle()\",100);\t\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t\tparent.dataFrame.location.href=\"../../eCA/jsp/SpltyHomePageEventDetails.jsp?p_patient_id=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&p_module_id=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&p_cycle_no=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&episode_type=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&p_hist_rec_type=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&p_event_class=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&p_event_group=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&eventitem=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&c_from_date=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&c_to_date=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&episode_wise=N&c_facility_id=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&encounter_id=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&performed_by=&errorEvent=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&abnormal=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&normalcy=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&viewConfRes=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&&cboFlowSheetComp=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&graphorder=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tparent.dataFrame.location.href=\"../../eCommon/html/blank.html\";\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\tparent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=APP-002415 Query caused no records to be retrieved.\";\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\tif(top.content!=null)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\ttop.content.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=APP-002415 Query caused no records to be retrieved.\";\t\n\t\t\t\t\t\t\t\t}else\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tparent.parent.parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=APP-002415 Query caused no records to be retrieved.\";\t\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t<input type=hidden name=\'rowsForGraph\' id=\'rowsForGraph\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t\t</form>\n\t</BODY>\n</html>\n\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

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

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	//	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
//		String locale = (String) p.getProperty("LOCALE");

	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
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
 		  
		  StringBuffer 	sqlData = new StringBuffer();
		  
		  String strFromDate	= "";
		  String strToDate		= "";
		  String strPatientId	= "";

		  String strHistRecType = "";
		  String strEventClass	= "";

		  String strEventGroup	= "";
		  String strEventCode	= "";
		  String strFacilityId	= "";
		  String strEncounterId = "";
		  String strEpisodeType = "";
		  String strNormalcyInd = "";
		  String strAbnormal	= "";
		  String strFlowSheetId = "";
		  String strViewConfRes = "";
		  String strGraphOrder	= "";
		  String called_from	= "";
		  String strErrorEvent	= "";
		  
		  //ArrayList eventList = new ArrayList();		  
		  
		  strGraphOrder		= request.getParameter("graphorder")==null?"":request.getParameter("graphorder");
		  strViewConfRes	= request.getParameter("viewConfRes")==null?"":request.getParameter("viewConfRes");
		  strFromDate		= request.getParameter("c_from_date")==null?"":request.getParameter("c_from_date");
		  strToDate			= request.getParameter("c_to_date")==null?"":request.getParameter("c_to_date");
		  strFlowSheetId	= request.getParameter("cboFlowSheetComp")==null?"":request.getParameter("cboFlowSheetComp");
		  strEventCode		= request.getParameter("eventitem")==null?"":request.getParameter("eventitem");
		  strErrorEvent		= request.getParameter("errorEvent")==null?"":request.getParameter("errorEvent");
		  strAbnormal		= request.getParameter("abnormal")==null?"N":request.getParameter("abnormal");
		  strPatientId		= request.getParameter("p_patient_id")==null?"":request.getParameter("p_patient_id");
		  strEventGroup		= request.getParameter("p_event_group")==null?"":request.getParameter("p_event_group");
		  strEventClass		= request.getParameter("p_event_class")==null?"":request.getParameter("p_event_class");
		  strHistRecType	= request.getParameter("p_hist_rec_type")==null?"":request.getParameter("p_hist_rec_type");
		  called_from		= request.getParameter("p_called_from")==null?"":request.getParameter("p_called_from");
		  strFacilityId		= request.getParameter("c_facility_id")==null?"":request.getParameter("c_facility_id");
		  strEpisodeType	= request.getParameter("episode_type")==null?"":request.getParameter("episode_type");
		  strEncounterId	= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		  String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String module_id = request.getParameter("module_id")==null?"":request.getParameter("module_id");
		String cycle_no = request.getParameter("cycle_no")==null?"":request.getParameter("cycle_no");
		strToDate = request.getParameter("to_date")==null?"":request.getParameter("to_date");
		strFromDate = request.getParameter("from_date")==null?"":request.getParameter("from_date");

//		  strFromDate	= com.ehis.util.DateUtils.convertDate(strFromDate,"DMYHM",locale,"en");
//		  strToDate		= com.ehis.util.DateUtils.convertDate(strToDate,"DMYHM",locale,"en");

		  sbQryCriteria.append("g.patient_id = ?  and g.MODULE_ID=? and g.CYLE_NO=? and a.HIST_REC_TYPE=g.HIST_REC_TYPE and a.CONTR_SYS_ID=g.CONTR_SYS_ID and a.ACCESSION_NUM =g.ACCESSION_NUM	 and a.CONTR_SYS_EVENT_CODE	=g.CONTR_SYS_EVENT_CODE");

			if(!strHistRecType.equals(""))
				sbQryCriteria.append(" and a.hist_rec_type = ? ");

			if(!strEventClass.equals(""))
				sbQryCriteria.append(" and a.event_class = ? ");

			if(!strEventGroup.equals(""))
				sbQryCriteria.append(" and a.event_group = ? ");

			if(!strEventCode.equals(""))
				sbQryCriteria.append(" and a.event_code = ? ");

			if(!strFromDate.equals(""))
				sbQryCriteria.append(" and g.KEY_REF >= ?");

			if(!strToDate.equals(""))
				sbQryCriteria.append(" and g.KEY_REF <= ?"); 

			if(!strFacilityId.equals(""))
				sbQryCriteria.append(" and a.facility_id = ? ");

			if(!strEncounterId.equals(""))
				sbQryCriteria.append(" and a.encounter_id = ? ");

			if (!strEpisodeType.equals("") )
				sbQryCriteria.append(" and a.PATIENT_CLASS = ? ");

			if(strAbnormal.equals("Y"))
				sbQryCriteria.append(" and a.normalcy_ind is not null");

			if(strViewConfRes.equals("X"))
				sbQryCriteria.append("and nvl(PROTECTION_IND,'N')!='Z')");

		  

			sqlData.append( " Select a.event_date dummydate, g.KEY_REF event_date_time, a.hist_rec_type hist_type, b.short_desc hist_rec_type_desc, a.event_class eve_class, c.long_desc event_class_desc, nvl(a.event_group,'*ALL') event_group,nvl(e.long_desc,d.long_desc) event_group_desc ,a.event_code eve_code,d.long_desc  event_desc,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.hist_data_type hist_data_type From cr_encounter_detail a ,cr_hist_rec_type b, cr_event_class   c ,cr_clin_event_mast d ,cr_clin_event_group e,CA_PAT_SPLTY_HIST_REF g ");

			if (!strFlowSheetId.equals(""))
				sqlData.append(" ,ca_flow_sheet_item f ");

			sqlData.append(" where b.hist_rec_type=a.hist_rec_type and c.hist_rec_type=a.hist_rec_type and  c.event_class= a.event_class and   d.hist_rec_type=a.hist_rec_type and  d.event_code=a.event_code and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and e.hist_rec_type(+)=a.hist_rec_type and  e.event_group(+)=a.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE ");
			
			if(!strFlowSheetId.equals(""))
			{
				sqlData.append(" and  f.flow_sheet_id=? and f.hist_rec_type=a.hist_rec_type and f.event_code=a.event_code  and  f.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  ") ;
			}

			sqlData.append( " AND " + sbQryCriteria.toString());

		   if (!strFlowSheetId.equals(""))
			sqlData.append( " ORDER BY f.order_seq_no, a.hist_rec_type,c.long_desc  ,a.event_class, a.event_group,e.long_desc  ,nvl(a.request_num_seq,d.long_desc),a.event_code, event_date_time "+strGraphOrder+" " );
		   else 
			 sqlData.append( " ORDER BY  a.hist_rec_type,c.long_desc  ,a.event_class, a.event_group,e.long_desc  ,nvl(a.request_num_seq,d.long_desc),a.event_code, event_date_time  "+strGraphOrder+" " );

			


			strBuffDates.append("Select g.KEY_REF event_date	From 	cr_encounter_detail a, CA_PAT_SPLTY_HIST_REF g ");

			strBuffDates.append("where  "+sbQryCriteria.toString());


			if(!strFlowSheetId.equals(""))
				strBuffDates.append(" and exists (select 1 from ca_flow_sheet_item f where f.flow_sheet_id=? and f.hist_rec_type=a.hist_rec_type and f.event_code=a.event_code  and  f.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) ") ;
			
			strBuffDates.append(" Order by g.KEY_REF  "+strGraphOrder);




			int i = 0;
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
			
			try
			{				
				con = ConnectionManager.getConnection(request);
				pstmt = con.prepareStatement(sqlData.toString());				
				
				if (!strFlowSheetId.equals(""))
					pstmt.setString(nIndex++,strFlowSheetId);

				pstmt.setString(nIndex++,patient_id);
				pstmt.setString(nIndex++,module_id);
				pstmt.setString(nIndex++,cycle_no);

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

				nIndex =1;

				pstmtDate = con.prepareStatement(strBuffDates.toString());

				pstmtDate.setString(nIndex++,patient_id);
				pstmtDate.setString(nIndex++,module_id);
				pstmtDate.setString(nIndex++,cycle_no);

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

				int tempInt = 0;

				try
				{
					rs = pstmt.executeQuery();
				}
				catch (Exception eeee)
				{
					//out.println("Exception in Query 1 try of SpltyHomePageEvents.jsp--"+eeee.toString());//COMMON-ICN-0181
					eeee.printStackTrace();//COMMON-ICN-0181

				}
		
				try
				{
					resDate = pstmtDate.executeQuery();
				}
				catch (Exception eee2)
				{
					//out.println("Exception in Query 2 try of SpltyHomePageEvents.jsp--"+eee2.toString());//common-icn-0181
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

						if(!eventGroup.equals("*ALL"))
						{
							out.println("<TR>");
							out.println("<TD colspan='3' class='CAFLOWSHEETLEVEL3'>"+eventGroupDesc+"</TD>");
							out.println("</TR>");
						}
						out.println("<TR id='trIDGraph"+tempGrafSeq+"'>");
						out.println("<TD class='"+classValue+"'>&nbsp;"+eventDesc+"</TD>");
						out.println("<TD class='"+classValue+"'>"+resultNumUOM+"&nbsp;</TD>");
						if(histDataType.equals("NUM"))
						{
							if(resultNumUOM.equals("") || resultNumUOM == null) resultNumUOM = " ";
							out.println("<TD  class='"+classValue+"' align=center><input type='checkbox' id='chkGraphID"+tempGrafSeq+"' name='chkGraph' id='chkGraph' value='"+eventCode+"' onClick='constructValsForGraph("+tempGrafSeq+");limitTheGraphs(this)'></input><input type='hidden' name='UOM' id='UOM' value='"+resultNumUOM+"'><input type='hidden' name='desc' id='desc' value='"+eventDesc+"'></TD>");
						}
						else
						{
							out.println("<TD class='"+classValue+"'>&nbsp;</TD>");
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
						if(!eventGroup.equals("*ALL"))
						{//event group is empty
							out.println("<TR>");
							out.println("<TD colspan='3' class='CAFLOWSHEETLEVEL3'>"+eventGroupDesc+"</TD>");
							out.println("</TR>");
						}
						out.println("<TR id='trIDGraph"+tempGrafSeq+"'>");
						out.println("<TD class='"+classValue+"'>&nbsp;"+eventDesc+"</TD>");
						out.println("<TD class='"+classValue+"'>"+resultNumUOM+"&nbsp;</TD>");
						if(histDataType.equals("NUM"))
						{
							if(resultNumUOM.equals("") || resultNumUOM == null) resultNumUOM = " ";
							out.println("<TD  class='"+classValue+"' align=center><input type='checkbox' id='chkGraphID"+tempGrafSeq+"' name='chkGraph' id='chkGraph' value='"+eventCode+"' onClick='constructValsForGraph("+tempGrafSeq+");limitTheGraphs(this)'></input><input type='hidden' name='UOM' id='UOM' value='"+resultNumUOM+"'><input type='hidden' name='desc' id='desc' value='"+eventDesc+"'></TD>");
						}
						else
						{
							out.println("<TD class='"+classValue+"'>&nbsp;</TD>");
						}
						out.println("</TR>");
						prevEventClass = eventClass;
						prevEventGroup = eventGroup;
						prevEventCode = eventCode;
						tempGrafSeq++;
					}
					else if(!prevEventGroup.equals(eventGroup))
					{
						if(!eventGroup.equals("*ALL"))
						{
							out.println("<TR>");
							out.println("<TD colspan='3' class='CAFLOWSHEETLEVEL3'>"+eventGroupDesc+"</TD>");
							out.println("</TR>");
						}
						out.println("<TR id='trIDGraph"+tempGrafSeq+"'>");
						out.println("<TD class='"+classValue+"'>&nbsp;"+eventDesc+"</TD>");
						out.println("<TD class='"+classValue+"'>"+resultNumUOM+"&nbsp;</TD>");
						if(histDataType.equals("NUM"))
						{
							if(resultNumUOM.equals("") || resultNumUOM == null) resultNumUOM = " ";
							out.println("<TD  class='"+classValue+"' align=center><input type='checkbox'  id='chkGraphID"+tempGrafSeq+"' name='chkGraph' id='chkGraph' value='"+eventCode+"' onClick='constructValsForGraph("+tempGrafSeq+");limitTheGraphs(this)'></input><input type='hidden' name='UOM' id='UOM' value='"+resultNumUOM+"'><input type='hidden' name='desc' id='desc' value='"+eventDesc+"'></TD>");
						}
						else
						{
							out.println("<TD class='"+classValue+"'>&nbsp;</TD>");
						}
						out.println("</TR>");
						prevEventGroup = eventGroup;
						prevEventCode = eventCode;
						tempGrafSeq++;
					}
					else if(!prevEventCode.equals(eventCode))
					{
						out.println("<TR id='trIDGraph"+tempGrafSeq+"'>");
						out.println("<TD class='"+classValue+"'>&nbsp;"+eventDesc+"</TD>");
						out.println("<TD class='"+classValue+"'>"+resultNumUOM+"&nbsp;</TD>");
						if(histDataType.equals("NUM"))
						{
							if(resultNumUOM.equals("") || resultNumUOM == null) resultNumUOM = " ";
							out.println("<TD  class='"+classValue+"' align=center><input type='checkbox'  id='chkGraphID"+tempGrafSeq+"' name='chkGraph' id='chkGraph' value='"+eventCode+"' onClick='constructValsForGraph("+tempGrafSeq+");limitTheGraphs(this)'></input><input type='hidden' name='UOM' id='UOM' value='"+resultNumUOM+"'><input type='hidden' name='desc' id='desc' value='"+eventDesc+"'></TD>");
						}
						else
						{
							out.println("<TD class='"+classValue+"'>&nbsp;</TD>");
						}
						out.println("</TR>");
						prevEventCode = eventCode;
						tempGrafSeq++;
					}
				}//end of for
				//out.println("<script>alert('"+i+"')</script>");
				
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
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

					if(i != 0)
					{
				
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strEpisodeType));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strHistRecType));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strEventClass));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(strEventGroup));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strEventCode));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strFromDate));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(strToDate));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(strFacilityId));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(strErrorEvent));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(strAbnormal));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(strNormalcyInd));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strViewConfRes));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strFlowSheetId));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(strGraphOrder));
            _bw.write(_wl_block33Bytes, _wl_block33);

					}
					else
					{
				
            _bw.write(_wl_block34Bytes, _wl_block34);

							if(called_from.equals("OR"))
							{
						
            _bw.write(_wl_block35Bytes, _wl_block35);

							}
							else
							{
						
            _bw.write(_wl_block36Bytes, _wl_block36);

							}
				}
			}//end of try---main
			catch(Exception exception)
			{
				//out.println("Exception in main try of SpltyHomePageEvents.jsp--"+exception.toString());//COMMON-ICN-0181
				exception.printStackTrace();
			}
			finally
			{
				if(con!=null) ConnectionManager.returnConnection(con,request);
			}
			//session.setAttribute("eventList",eventList);
		
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Unit.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Graph.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Event.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Unit.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Graph.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
