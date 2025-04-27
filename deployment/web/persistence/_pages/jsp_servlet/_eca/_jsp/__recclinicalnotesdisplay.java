package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __recclinicalnotesdisplay extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesDisplay.jsp", 1709116122699L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<head>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart4.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n</head>\n\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" class=\'CONTENT\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<div id=\'encDetailsLayer\' style=\'position:absolute; width:60%; visibility:hidden;\'>\n</div>\n<form name=\"details2_form\" id=\"details2_form\">\n\t<input type=\'hidden\' name=\'data\' id=\'data\' value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

	String replaceSpecialChar(String resultStr)
	{
		//resultStr=resultStr.replace('\n','�');
		//resultStr=resultStr.replace('\r',' ');
		//resultStr=resultStr.replace('\'','�');
		/*commended on 18/03/2006
			while(resultStr.indexOf("\n")!=-1)
		{	
			int a=resultStr.indexOf("\n");
			StringBuffer temp=new StringBuffer(resultStr);
			temp.replace(a,a+1,"~");
			resultStr=temp.toString();
			
		}
		while(resultStr.indexOf("\r")!=-1)
		{	
			int a=resultStr.indexOf("\r");
			StringBuffer temp=new StringBuffer(resultStr);
			temp.replace(a,a+1,"");
			resultStr=temp.toString();
			
		}
		while(resultStr.indexOf("'")!=-1)
		{	
			int a=resultStr.indexOf("'");
			StringBuffer temp=new StringBuffer(resultStr);
			temp.replace(a,a+1,"`");
			resultStr=temp.toString();
			
		}
		return resultStr;*/
		if(resultStr.indexOf("\n")!=-1)
			resultStr = resultStr.replaceAll("\n","~");	
		if(resultStr.indexOf("\r")!=-1)
			resultStr = resultStr.replaceAll("\r","");
		if(resultStr.indexOf("'")!=-1)
			resultStr = resultStr.replaceAll("'","`");
		return resultStr;
	}



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
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		Properties p = (Properties)session.getValue("jdbc");
		String locale	= (String) p.getProperty("LOCALE");
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con = null;
	PreparedStatement stmt = null;// con.createStatement();
	PreparedStatement stHist = null;
	ResultSet rs = null;
	ResultSet rsHist = null;
	
	//ResultSet rs1 = null;

	String selectedhisrectype = request.getParameter("hist_type")==null?"":request.getParameter("hist_type");
	String selecteddate = request.getParameter("event_date")==null?"":request.getParameter("event_date");
	String selectedeventgroup = request.getParameter("event_group")==null?"":request.getParameter("event_group");
	if(selectedeventgroup.equals("null")) selectedeventgroup = "";
	String selectedeventclass = request.getParameter("event_class")==null?"":request.getParameter("event_class");
	String selectedeventcode = request.getParameter("event_item")==null?"":request.getParameter("event_item");
	String patientid = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String accessionNum = request.getParameter("accession_num")==null?"":request.getParameter("accession_num");
	 /**Starts - Added on 28th August 2003**/
	String resp_id = (String)session.getValue("responsibility_id");
	if(resp_id == null)resp_id ="";
	StringBuffer sql = new StringBuffer();
	StringBuffer outdata = new StringBuffer();


	try
	{
		con = ConnectionManager.getConnection(request);
		/*sql.append("  Select   a.hist_rec_type ");
		sql.append(" ,b.short_desc hist_rec_type_desc ");
		sql.append(" ,a.event_class ");
		sql.append(" ,c.long_desc  event_class_desc ");
		sql.append(" ,a.event_group  ");
		sql.append(" ,e.long_desc  event_group_desc ");
		sql.append(" ,a.event_code ");
		sql.append(" ,d.long_desc  event_desc ");
		sql.append(" ,a.accession_num ");
		sql.append(" ,a.contr_sys_id ");
		sql.append(" ,a.contr_sys_event_code ");
		sql.append(" ,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time ");
		sql.append(" ,a.HIST_DATA_TYPE ");
		sql.append(" ,a.hist_rec_type ");
		sql.append(" ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.result_num),TO_CHAR(a.result_num,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num ");
		sql.append(" ,a.RESULT_NUM_UOM ");
		sql.append(" ,a.result_str ");
		sql.append(" ,(select decode(a.normalcy_ind,HIGH_STR,'Abnormal',LOW_STR,'Abnormal',ABN_STR,'Abnormal',CRIT_STR,'Critically Abnormal',CRIT_HIGH_STR,'Critically Abnormal',CRIT_LOW_STR,'Critically Abnormal') from cr_clin_event_param) normalcy_ind ");
		sql.append(" ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))  normal_low  ");
		sql.append(" ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high  ");
		sql.append(" ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low  ");
		sql.append(" ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high ");
		sql.append(" ,a.performed_by_id ");
		sql.append(" ,a.result_num_prefix ");
		sql.append(" ,f.short_name clinician_short_name ");
		sql.append(" ,CA_GET_VISIT_HDR(a.facility_id, a.patient_class,a.encounter_id,a.patient_id, a.performed_by_id) encline ");
		sql.append(" From cr_encounter_detail a ");
		sql.append(" ,cr_hist_rec_type b ");
		sql.append(" ,cr_event_class   c  ");
		sql.append(" ,cr_clin_event_mast d ");
		sql.append(" ,cr_clin_event_group e ");
		sql.append(" ,am_practitioner f ");
		sql.append(" where b.hist_rec_type=a.hist_rec_type ");
		sql.append(" and  c.hist_rec_type=a.hist_rec_type ");
		sql.append(" and  c.event_class= a.event_class ");
		sql.append(" and  d.hist_rec_type=a.hist_rec_type ");
		sql.append(" and  d.event_code=a.event_code ");
		sql.append(" and  e.hist_rec_type(+)=a.hist_rec_type ");
		sql.append(" and  e.event_group(+)=a.event_group ");
		sql.append(" and  f.practitioner_id(+)=a.performed_by_id ");
		sql.append(" and a.patient_id = ? and (nvl(PROTECTION_IND,'N')!='Z' OR						(nvl(PROTECTION_IND,'N')='Z'  and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,?,NULL)='A')) and nvl(a.STATUS,'NYSE') not in ('S','E')");

			if(!selecteddate.equals(""))
				sql.append(" and  trunc(a.event_date)= trunc(to_date(?,'dd/mm/yyyy hh24:mi'))");
			if(!selectedhisrectype.equals(""))
				sql.append( " and a.hist_rec_type = ? ");
			if(!selectedeventclass.equals(""))
				sql.append( " and a.EVENT_CLASS = ? ");
			if(!selectedeventgroup.equals(""))
				sql.append( " and a.EVENT_GROUP = ? ");
			if(!selectedeventcode.equals(""))
				sql.append( " and a.EVENT_CODE = ? ");
			if(!accessionNum.equals(""))
				sql.append( " and a.ACCESSION_NUM  = ? ");

		sql.append( " order by hist_rec_type_desc,event_class_desc,event_group_desc,event_desc ");  */
		//
		sql.append("  Select   a.hist_rec_type ");
		sql.append(" ,b.short_desc hist_rec_type_desc ");
		sql.append(" ,a.event_class ");
		sql.append(" ,c.long_desc  event_class_desc ");
		sql.append(" ,a.event_group  ");
		sql.append(" ,e.long_desc  event_group_desc ");
		sql.append(" ,a.event_code ");
		sql.append(" ,d.long_desc  event_desc ");
		sql.append(" ,a.accession_num ");
		sql.append(" ,a.contr_sys_id ");
		sql.append(" ,a.contr_sys_event_code ");
		sql.append(" ,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time ");
		sql.append(" ,a.HIST_DATA_TYPE ");
		sql.append(" ,a.hist_rec_type ");
		sql.append(" ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.result_num),TO_CHAR(a.result_num,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) result_num ");
		sql.append(" ,a.RESULT_NUM_UOM ");
		sql.append(" ,a.result_str ");
		sql.append(" ,(select decode(a.normalcy_ind,HIGH_STR,'Abnormal',LOW_STR,'Abnormal',ABN_STR,'Abnormal',CRIT_STR,'Critically Abnormal',CRIT_HIGH_STR,'Critically Abnormal',CRIT_LOW_STR,'Critically Abnormal') from cr_clin_event_param) normalcy_ind ");
		sql.append(" ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))  normal_low  ");
		sql.append(" ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high  ");
		sql.append(" ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low  ");
		sql.append(" ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high ");
		sql.append(" ,a.performed_by_id ");
		sql.append(" ,a.result_num_prefix ");
		sql.append(" ,f.short_name clinician_short_name ");
		sql.append(" ,CA_GET_VISIT_HDR(a.facility_id, a.patient_class,a.encounter_id,a.patient_id, a.performed_by_id) encline ");
		sql.append(" From cr_encounter_detail a ");
		sql.append(" ,CR_HIS_RECTYP_LNG_VW b ");
		sql.append(" ,CR_EVENT_CLASS_LANG_VW   c  ");
		sql.append(" ,CR_CLN_EVT_MST_LANG_VW d ");
		sql.append(" ,CR_CLN_EVT_GRP_LANG_VW e ");
		sql.append(" ,AM_PRACTITIONER_LANG_VW f ");
		sql.append(" where b.language_id = ? and b.hist_rec_type=a.hist_rec_type ");
		sql.append(" and  c.language_id = ? and c.hist_rec_type=a.hist_rec_type ");
		sql.append(" and  c.event_class= a.event_class ");
		sql.append(" and  d.language_id = ? and d.hist_rec_type=a.hist_rec_type ");
		sql.append(" and  d.event_code=a.event_code ");
		sql.append(" and  e.language_id = ? and e.hist_rec_type(+)=a.hist_rec_type ");
		sql.append(" and  e.event_group(+)=a.event_group ");
		sql.append(" and  f.language_id = ? and f.practitioner_id(+)=a.performed_by_id ");
		sql.append(" and a.patient_id = ? and (nvl(PROTECTION_IND,'N')!='Z' OR						(nvl(PROTECTION_IND,'N')='Z'  and GET_TASK_APPLICABILITY('VIEW_CONF_RESULT',NULL,?,NULL)='A')) and nvl(a.STATUS,'NYSE') not in ('S','E')");
		if(!selecteddate.equals(""))
				sql.append(" and  trunc(a.event_date)= trunc(to_date(?,'dd/mm/yyyy hh24:mi'))");
		if(!selectedhisrectype.equals(""))
				sql.append( " and a.hist_rec_type = ? ");
		if(!selectedeventclass.equals(""))
				sql.append( " and a.EVENT_CLASS = ? ");
		if(!selectedeventgroup.equals(""))
				sql.append( " and a.EVENT_GROUP = ? ");
		if(!selectedeventcode.equals(""))
				sql.append( " and a.EVENT_CODE = ? ");
		if(!accessionNum.equals(""))
		sql.append( " and a.ACCESSION_NUM  = ? ");
		sql.append( " order by hist_rec_type_desc,event_class_desc,event_group_desc,event_desc ");
		//
		outdata.append( "<table cellspacing=0 cellpadding=3 width='100%' border=1> align='center' ");
		stmt = con.prepareStatement(sql.toString());
		stmt.setString(1, locale );
		stmt.setString(2, locale );
		stmt.setString(3, locale );
		stmt.setString(4, locale );
		stmt.setString(5, locale );
		stmt.setString(6, patientid );
		stmt.setString(7, resp_id);
		if(!selecteddate.equals(""))
			stmt.setString(8, selecteddate);
		if(!selectedhisrectype.equals(""))
			stmt.setString(9, selectedhisrectype);
		if(!selectedeventclass.equals(""))
			stmt.setString(10, selectedeventclass);
		if(!selectedeventgroup.equals(""))
			stmt.setString(11, selectedeventgroup);
		if(!selectedeventcode.equals(""))
			stmt.setString(12, selectedeventcode);
		if(!accessionNum.equals(""))
			stmt.setString(13, accessionNum);
		rs = stmt.executeQuery();
		//String preveventdatetime = "";
		String prevtext = "";
		String prevhisttype = "";
		String preveventclass = "";
		String preveventgroupevent = "";
		String colspanval ="2";
		String classValue = "";
		int i = 0;

		if(rs != null)
		{
			while(rs.next())
			{
				String histdatatype = rs.getString("HIST_DATA_TYPE");
				String histrectype = rs.getString("HIST_REC_TYPE");
				String accessionnum = rs.getString("ACCESSION_NUM");
				String eventdatetime = rs.getString("event_date_time");
				String histtypedesc = rs.getString("hist_rec_type_desc");
				String eventclassdesc = rs.getString("event_class_desc");
				String eventgroupdesc = rs.getString("event_group_desc")==null?"":rs.getString("event_group_desc");
				String eventdesc = rs.getString("event_desc");
				StringBuffer encline = new StringBuffer();
				encline.append(rs.getString("encline"));
				String normalcy_ind =rs.getString("normalcy_ind")==null?"":rs.getString("normalcy_ind");
				String normalrange = (rs.getString("NORMAL_LOW")==null?"":rs.getString("NORMAL_LOW"))
					+" - "+(rs.getString("NORMAL_HIGH")==null?"":rs.getString("NORMAL_HIGH"));
				String criticalrange = (rs.getString("CRITICAL_LOW")==null?"":rs.getString("CRITICAL_LOW"))+" - "+(rs.getString("CRITICAL_HIGH")==null?"":rs.getString("CRITICAL_HIGH"));
				if(normalrange.equals(" - "))
					normalrange="";
				else
					normalrange=" ("+normalrange+")";
				if(!criticalrange.equals(" - "))
					encline.append("<br> Critical Range : "+criticalrange);
				StringBuffer data = new StringBuffer();
				
				String resultstr=rs.getString("RESULT_STR")==null?"":rs.getString("RESULT_STR");
				String contr_sys_id=rs.getString("CONTR_SYS_ID")==null?"":rs.getString("CONTR_SYS_ID");
				String contr_sys_event_code=rs.getString("contr_sys_event_code")==null?"":rs.getString("contr_sys_event_code");
				String result_num_prefix=rs.getString("result_num_prefix");
				if(result_num_prefix==null) result_num_prefix="";

				if(histdatatype.equals("NUM"))
				{
					if(!result_num_prefix.equals(""))//|| !result_num_prefix.equals("NO_DATA)"))
					{
						data.append(result_num_prefix+"&nbsp;");
					}

					data.append(rs.getString("RESULT_NUM")+"  "+( rs.getString("RESULT_NUM_UOM")==null?"":rs.getString("RESULT_NUM_UOM"))+" <font color=red>"+normalcy_ind+"</font>" +normalrange);
					//*** checking for if there is any STR  
					if(!resultstr.equals("") && resultstr !=null)
					{
						resultstr=replaceSpecialChar(resultstr);
						data.append("&nbsp;&nbsp;<a href=javaScript:ShowComments('"+java.net.URLEncoder.encode(resultstr)+"')>Comments </a>");
					}
					// 

					StringBuffer sqlHist  =new StringBuffer();
					sqlHist.append("select count(*) from CR_ENCOUNTER_DETAIL_TXT ");
					sqlHist.append(" where hist_rec_type = ? and contr_sys_id = ? ");
					sqlHist.append(" and accession_num = ? and contr_sys_event_code =? ");
						stHist = con.prepareStatement(sqlHist.toString());
						stHist.setString(1, histrectype);
						stHist.setString(2, contr_sys_id);
						stHist.setString(3, accessionnum);
						stHist.setString(4, contr_sys_event_code);

						rsHist=stHist.executeQuery();
						//out.println(sqlHist);
			
						while(rsHist.next()) 
						{ 
							if(rsHist.getInt(1) >0) {
							data.append("<a href=\"javascript:getText('"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"')\"><img id='textimg' src='../../eCA/images/flow_text.gif' ></a></font>");
							
							}
						}
						if(rsHist!=null) rsHist.close();
						if(stHist!=null) stHist.close();	

				}
				else if(histdatatype.equals("STR"))
				{
					data.append(rs.getString("RESULT_STR")+"&nbsp;");
					
					StringBuffer sqlHist  =new StringBuffer();
					sqlHist.append("select count(*) from CR_ENCOUNTER_DETAIL_TXT ");
					sqlHist.append(" where hist_rec_type = ? and contr_sys_id = ? ");
					sqlHist.append(" and accession_num = ? and contr_sys_event_code =? ");
					stHist = con.prepareStatement(sqlHist.toString());
					stHist.setString(1, histrectype);
					stHist.setString(2, contr_sys_id);
					stHist.setString(3, accessionnum);
					stHist.setString(4, contr_sys_event_code);

					rsHist=stHist.executeQuery();
		
					while(rsHist.next()) 
					{ 
						if(rsHist.getInt(1) >0) {
						data.append("<a href=\"javascript:getText('"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"')\"><img id='textimg' src='../../eCA/images/flow_text.gif' ></a></font>");
						
						}
					}
					if(rsHist!=null) rsHist.close();
					if(stHist!=null) stHist.close();	

				}
				else if(histdatatype.equals("TXT") || histdatatype.equals("DOC"))
				{
					data.append("<a href=\"javascript:showDocDetails('"+histdatatype+"','"+histrectype+"','"+accessionnum+"','"+eventdesc+"','"+contr_sys_id+"','"+contr_sys_event_code+"')\"><img border=no src='../../eCA/images/flow_text.gif'></img></a>");
				}
				
				
				if(!prevhisttype.equals(histtypedesc))
					outdata.append( "<tr><td colspan='"+colspanval+"' class=CAHIGHERLEVELCOLOR>"+histtypedesc+"</td></tr>");
				if(!preveventclass.equals(eventclassdesc))
				{
					outdata.append("<tr><td colspan='"+colspanval+"' class=CAGROUP><font size=1>"+eventclassdesc+"</font></td></tr>");
				}

				String curreventgroupevent = eventgroupdesc+eventdesc;
				if(!curreventgroupevent.equals(preveventgroupevent))
					outdata.append("<tr><td colspan='"+colspanval+"' class=CAFOURTHLEVELCOLOR><font size=1>"+eventgroupdesc+" "+eventdesc+"</font></td></tr>");

				if(!prevtext.equals(rs.getString("RESULT_STR")))
				{
					if(i%2==0) classValue = "QRYEVEN";
					else classValue = "QRYODD";
					outdata.append("<tr><td class='"+classValue+"' ><font size=1>"+eventdatetime+"</font></td><td class='"+classValue+"' onMouseOver='javascript:hidePopUp()'><font size=1>"+data.toString()+"</font></td></tr>");
					i++;
				}

				//preveventdatetime = eventdatetime;
				prevhisttype = histtypedesc;
				preveventclass = eventclassdesc;
				preveventgroupevent = curreventgroupevent;
			}
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			outdata.append("</table>");
			out.println(outdata.toString());

			String strTemp = "";

			strTemp = outdata.toString();
			strTemp = strTemp.replaceAll("\""," ");
			outdata = new StringBuffer(strTemp);

/*			
			for(int l=0;l<outdata.toString().length();l++)
				outdata = new StringBuffer(outdata.toString().replace('\"',' '));

*/
			
		}
		
		//if(rs!=null) rs.close();
		//if(stmt!=null) stmt.close();
		if(rsHist!=null) rsHist.close();
		if(stHist!=null) stHist.close();		
		
	}catch(Exception e){
		e.printStackTrace();
		//out.println(e+sql.toString());//COMMON-ICN-0181
	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(outdata.toString()));
            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
