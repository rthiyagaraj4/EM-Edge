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

public final class __maternityconstree extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/MaternityConsTree.jsp", 1736157589823L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\n\t<script src=\'../../eCA/js/CAMainMenu.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCA/js/MaternityConsTree.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\t\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script> \n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<body  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\" onload=\"callfunction()\">\n<script language=javascript>\ndocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\ndocument.body.style.scrollbarArrowColor=\'#000080\';\ndocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\ndocument.body.style.scrollbarHighlightColor=\'white\';\ndocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<FORM METHOD=POST ACTION=\"\" name=\"maternityMenu\" id=\"maternityMenu\">\n<TABLE width=\'100%\' align=\'center\' border=0 cellspacing=0>\n\n<TR>\n\t<TD width=\'50%\'>&nbsp;</TD><TD align=\'right\' width=\'50%\'><img src=\'../../eCommon/images/close-all.gif\' onclick=\"changeTree(this)\" id=\'toggleTreeCollapse\' style=\'display\' alt = \'Collapse All\'></img>&nbsp;<img src=\'../../eCommon/images/expand-all.gif\' onclick=\"changeTree(this)\" id=\'toggleTreeExpand\' style=\'display\' alt = \'Expand All\'></img></TD>\n</TR>\n</TABLE>\n<script>\n\n\tvar obj;\n\tobj = new dTree(\'obj\');\n\tobj.add(0,-1,\'<font size=2 style=font-weight:bold style=color:#333>\'+getLabel(\"Common.menu.label\",\"common\")+\'</font>\');\n\tobj.config.useStatusText=true;\n\tobj.add(\'OBGSTATUS\',\'0\',\'OBG STATUS\',\'\',\'OBG STATUS\',\'\',\'\',\'\',\'\',\'R\');\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\tobj.add(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\',\'OBGSTATUS\',\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\',\'\',\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\',\'\',\'\',\'\',\'\',\'R\');\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\',\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\',\'\',\'\',\'\',\'\',\'R\');\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\n\n\t\t\tdocument.write(obj);\n\t\t\tobj.openAll();\n\n\t</script>\n\t<input type=hidden name=\'req_event_code\' id=\'req_event_code\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t<input type=hidden name=\'module_id\' id=\'module_id\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t<input type=hidden name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t<input type=hidden name=\'queryString\' id=\'queryString\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\t\n</FORM>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);


	String queryString = request.getQueryString() == null ? "" : request.getQueryString();
	String module_id =  request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
	String patient_id =  request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	//Querires to fecth the data
	//String cycle_sql1="SELECT SPLTY_EPISODE_DESC,SPLTY_TITLE_EVENT_DESC FROM CA_SPLTY_EPISODE_CYCLE_LANG_VW WHERE MODULE_ID=? AND LANGUAGE_ID=?";

	//String cycle_sql2="SELECT CYCLE_NO FROM CA_PAT_SPLTY_EPISODE_HDR WHERE PATIENT_ID=? AND  MODULE_ID=? ORDER  BY 1";

	//String cycle_sql_open="SELECT CYCLE_NO FROM CA_PAT_SPLTY_EPISODE_HDR WHERE PATIENT_ID=? AND  MODULE_ID=? AND CYCLE_STATUS='O' ORDER  BY 1";
	
	//String sql="SELECT SPLTY_EVENT_CODE,SPLTY_EVENT_DESC FROM CA_SPLTY_EVENT_LANG_VW WHERE MODULE_ID=? AND LANGUAGE_ID=? AND EFF_STATUS='E' ORDER BY 2";

	String menuSql="SELECT  A.SPLTY_EVENT_CODE,A.SPLTY_TASK_CODE,CA_GET_DESC.CA_SPLTY_TASKS( A.SPLTY_TASK_CODE,?,'1') SPLTY_TASK_DESC,A.ORDER_SEQ_NO,A.NUMB_OF_TRANS_ALLOWED,A.SPLTY_TASK_TYPE,A.EXECUTABLE_NAME,A.ACTION_CODE,'MAIN' HEADER_SPLTY_TASK_CODE FROM CA_SPLTY_TASKS_FOR_EVENTS_VW A WHERE  MODULE_ID=?  AND HEADER_SPLTY_TASK_CODE IS NULL ORDER BY ORDER_SEQ_NO ";

	String sel_menuSql="SELECT  A.SPLTY_EVENT_CODE,A.SPLTY_TASK_CODE,CA_GET_DESC.CA_SPLTY_TASKS( A.SPLTY_TASK_CODE,?,'1') SPLTY_TASK_DESC,A.ORDER_SEQ_NO,A.NUMB_OF_TRANS_ALLOWED,A.SPLTY_TASK_TYPE,A.EXECUTABLE_NAME,A.ACTION_CODE,'MAIN' HEADER_SPLTY_TASK_CODE FROM CA_SPLTY_TASKS_FOR_EVENTS_VW A WHERE SPLTY_EVENT_CODE=?  AND MODULE_ID=?  AND HEADER_SPLTY_TASK_CODE IS NULL ORDER BY ORDER_SEQ_NO";

	String hdquerySQL="SELECT A.SPLTY_TASK_CODE,CA_GET_DESC.CA_SPLTY_TASKS( A.SPLTY_TASK_CODE,?,'1') SPLTY_TASK_DESC,A.ORDER_SEQ_NO,A.NUMB_OF_TRANS_ALLOWED,A.SPLTY_TASK_TYPE,A.EXECUTABLE_NAME,A.ACTION_CODE,A.HEADER_SPLTY_TASK_CODE FROM CA_SPLTY_TASKS_FOR_EVENTS_VW A WHERE SPLTY_EVENT_CODE=? AND MODULE_ID=? AND HEADER_SPLTY_TASK_CODE =? ORDER BY ORDER_SEQ_NO";

	String actionSQL="SELECT A.ACTION_CODE,CASE WHEN A.SPLTY_TASK_TYPE='NT' THEN CA_GET_DESC.CA_NOTE_TYPE(A.ACTION_CODE,?,'1') WHEN A.SPLTY_TASK_TYPE='CH' THEN CA_GET_DESC.CA_CHART(A.ACTION_CODE,?,'1') WHEN A.SPLTY_TASK_TYPE='TM' THEN CA_GET_DESC.CA_SECTION_HDG(A.ACTION_CODE,?,'1') END SPLTY_TASK_DESC FROM CA_SPLTY_TASKS_FOR_EVENTS_VW A  WHERE SPLTY_EVENT_CODE=? AND MODULE_ID=? AND SPLTY_TASK_CODE =?";

	String dateSQL="SELECT TO_CHAR(TRANS_DATE,'DD/MM/YYYY HH24:MI')TRANS_DATE_STR,ACCESSION_NUM FROM CA_PAT_SPLTY_EPISODE_TASK WHERE PATIENT_ID	=? AND FACILITY_ID	=? AND MODULE_ID=? AND CYCLE_NO=? AND SPLTY_EVENT_CODE =? AND SPLTY_TASK_CODE=?";

	//String eventSQl="SELECT SPLTY_EVENT_CODE,SPLTY_EVENT_STATUS,CA_GET_DESC(SPLTY_EVENT_CODE,?,'1') FROM CA_PAT_SPLTY_EPISODE_EVENT WHERE  PATIENT_ID =? AND MODULE_ID=? AND CYCLE_NO=?";

	//String CYCLE_NO_OPEN=null;
	//int cycle_val=0;
	//String SPLTY_EPISODE_DESC=null;
	//String SPLTY_TITLE_EVENT_DESC=null;
	String facility_id = (String) session.getValue("facility_id");
	int cycle_no=0;

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	//main task variables
	String splt_event_code="";
	String splty_task_code="";
	String splty_task_desc="";
	String splty_task_type="";
	String actn_code;
	//String actn_code_desc;
	//sub tasks variables
	String sub_task_code=null;
	String sub_task_desc=null;
	String sub_task_type=null;
	String sub_hd_tsk_code=null;
	String sub_act_code=null;
	String sub_act_desc=null;

	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt3 = null;
	Connection con = null;
	ResultSet rs = null,rsMenu=null,rs2=null,rsDate=null;
	//String where_cond="";
	String req_event_code=request.getParameter("req_event_code")==null?"":request.getParameter("req_event_code");

	try{
	con = ConnectionManager.getConnection(request);
	}catch(Exception e){
		e.printStackTrace() ;
	}


            _bw.write(_wl_block9Bytes, _wl_block9);

try{
	//String date="";
	if(req_event_code.equals("")){
	pstmt=con.prepareStatement(menuSql);
	pstmt.setString(1,locale);
	pstmt.setString(2,module_id);
	rsMenu=pstmt.executeQuery();
	while(rsMenu.next()){
		splt_event_code=rsMenu.getString(1);
		splty_task_code=rsMenu.getString(2);
		splty_task_desc=rsMenu.getString(3); 
		splty_task_type=rsMenu.getString(6); 
		actn_code=rsMenu.getString(8);

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(splty_task_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(splty_task_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(splty_task_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);

	if(splty_task_type.equals("HD")){
	pstmt1=con.prepareStatement(hdquerySQL);
	pstmt1.setString(1,locale);
	pstmt1.setString(2,splt_event_code);
	pstmt1.setString(3,module_id);
	pstmt1.setString(4,splty_task_code);
	rs	  =pstmt1.executeQuery();
	while(rs.next()){
	sub_task_code=rs.getString(1);
	sub_task_desc=rs.getString(2);
	sub_task_type=rs.getString(5);
	sub_hd_tsk_code=rs.getString(8);
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sub_task_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(splty_task_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(sub_task_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(sub_task_code));
            _bw.write(_wl_block15Bytes, _wl_block15);

	pstmt2=con.prepareStatement(actionSQL);
	pstmt2.setString(1,locale);
	pstmt2.setString(2,locale);
	pstmt2.setString(3,locale);
	pstmt2.setString(4,splt_event_code);
	pstmt2.setString(5,module_id);
	pstmt2.setString(6,splty_task_code);	
	rs2	  =pstmt2.executeQuery();
	while(rs2.next()){
	sub_act_code=rs2.getString(1);
	sub_act_desc=rs2.getString(2);
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sub_act_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(sub_task_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(sub_act_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(sub_act_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
}
	if(rs2!=null)
	rs2.close();
	if(pstmt2!=null)
	pstmt2.close();
	}
	if(rs!=null)
	rs.close();
	if(pstmt1!=null)
	pstmt1.close();
}else{
	pstmt2=con.prepareStatement(actionSQL);
	pstmt2.setString(1,locale);
	pstmt2.setString(2,locale);
	pstmt2.setString(3,locale);
	pstmt2.setString(4,splt_event_code);
	pstmt2.setString(5,module_id);
	pstmt2.setString(6,splty_task_code);
	rs	  =pstmt2.executeQuery();
	while(rs.next()){
		sub_act_code=rs.getString(1);
		sub_act_desc=rs.getString(2);
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sub_act_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(splty_task_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(sub_act_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(sub_act_code));
            _bw.write(_wl_block15Bytes, _wl_block15);

	try{
	pstmt3=con.prepareStatement(dateSQL);
	pstmt3.setString(1,patient_id);
	pstmt3.setString(2,facility_id);
	pstmt3.setString(3,module_id);
	pstmt3.setInt(4,cycle_no);
	pstmt3.setString(5,splt_event_code);
	pstmt3.setString(6,splty_task_code);
	rsDate=pstmt3.executeQuery();
	while(rsDate.next()){
	}
	if(rsDate!=null)
		rsDate.close();
	if(pstmt3!=null)
		pstmt3.close();
	}catch(Exception e){
	e.printStackTrace() ;
	}
	}
	if(rs!=null)
	rs.close();
	if(pstmt2!=null)
	pstmt2.close();
}
}
if(rsMenu!= null) rsMenu.close();
if(pstmt!=null) pstmt.close();
}else{//if event is selected....
	pstmt=con.prepareStatement(sel_menuSql);
	pstmt.setString(1,locale);
	pstmt.setString(2,req_event_code);
	pstmt.setString(3,module_id);
	rsMenu=pstmt.executeQuery();
	while(rsMenu.next()){
		splt_event_code=rsMenu.getString(1);
		splty_task_code=rsMenu.getString(2);
		splty_task_desc=rsMenu.getString(3);
		splty_task_type=rsMenu.getString(6);
		actn_code=rsMenu.getString(8);


            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(splty_task_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(splty_task_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(splty_task_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);

	if(splty_task_type.equals("HD")){
	pstmt1=con.prepareStatement(hdquerySQL);
	pstmt1.setString(1,locale);
	pstmt1.setString(2,splt_event_code);
	pstmt1.setString(3,module_id);
	pstmt1.setString(4,splty_task_code);
	rs	  =pstmt1.executeQuery();
	while(rs.next()){
	sub_task_code=rs.getString(1);
	sub_task_desc=rs.getString(2);
	sub_task_type=rs.getString(5);
	sub_hd_tsk_code=rs.getString(8);
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sub_task_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(splty_task_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(sub_task_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(sub_task_code));
            _bw.write(_wl_block15Bytes, _wl_block15);

	pstmt2=con.prepareStatement(actionSQL);
	pstmt2.setString(1,locale);
	pstmt2.setString(2,locale);
	pstmt2.setString(3,locale);
	pstmt2.setString(4,splt_event_code);
	pstmt2.setString(5,module_id);
	pstmt2.setString(6,splty_task_code);
	rs2	  =pstmt2.executeQuery();
	while(rs2.next()){
	sub_act_code=rs2.getString(1);
	sub_act_desc=rs2.getString(2);
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sub_act_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(sub_task_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(sub_act_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(sub_act_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
}
	if(rs2!=null)
	rs2.close();
	if(pstmt2!=null)
	pstmt2.close();
	}
	if(rs!=null)
	rs.close();
	if(pstmt1!=null)
	pstmt1.close();
}else{
	pstmt2=con.prepareStatement(actionSQL);
	pstmt2.setString(1,locale);
	pstmt2.setString(2,locale);
	pstmt2.setString(3,locale);
	pstmt2.setString(4,splt_event_code);
	pstmt2.setString(5,module_id);
	pstmt2.setString(6,splty_task_code);
	rs	  =pstmt2.executeQuery();
	while(rs.next()){
		sub_act_code=rs.getString(1);
		sub_act_desc=rs.getString(2);
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sub_act_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(splty_task_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(sub_act_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(sub_act_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
//query the transactio dates and paint them
	try{
	pstmt3=con.prepareStatement(dateSQL);
	pstmt3.setString(1,patient_id);
	pstmt3.setString(2,facility_id);
	pstmt3.setString(3,module_id);
	pstmt3.setInt(4,cycle_no);
	pstmt3.setString(5,splt_event_code);
	pstmt3.setString(6,splty_task_code);
	rsDate=pstmt3.executeQuery();
	while(rsDate.next()){
//here to paint the transactions dates
	}
	if(rsDate!=null)
		rsDate.close();
	if(pstmt3!=null)
		pstmt3.close();
	}catch(Exception e){
	e.printStackTrace() ;
	}
	}
	if(rs!=null)
	rs.close();
	if(pstmt2!=null)
	pstmt2.close();
}
	}//end rsMenu 
  }//end of else
 }//end of try

	catch(Exception e)
	{
		//out.println("Error while gettting the menu: "+e);//COMMON-ICN-0181
           e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		try
		{
			if(rs!= null) rs.close();
			if(pstmt!=null) pstmt.close();
			
			if(con!= null) ConnectionManager.returnConnection(con,request);
		}
		catch(Exception e)
		{
			//out.println("Exception in CAMainMenu.jsp"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
	}
	
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(req_event_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(queryString));
            _bw.write(_wl_block20Bytes, _wl_block20);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
