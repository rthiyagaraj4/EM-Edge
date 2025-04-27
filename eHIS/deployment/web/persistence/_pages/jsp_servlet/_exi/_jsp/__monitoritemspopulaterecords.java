package jsp_servlet._exi._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eXH.XHDBAdapter;
import eXI.MonitorItemsBean;
import eXH.XHQueryRender;
import webbeans.eCommon.ConnectionManager;
import eXH.XHUtil;
import java.sql.Connection;
import java.util.*;
import com.ehis.util.*;

public final class __monitoritemspopulaterecords extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exi/jsp/MonitorItemsPopulateRecords.jsp", 1709122568972L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\n\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<link rel=\'stylesheet\' href=\'../../eXH/html/menu.css\' type=\'text/css\'></link>\n<link rel=\'stylesheet\' href=\'../../eXH/html/style.css\' type=\'text/css\'></link>\n<link rel=\'stylesheet\' href=\'../../eXH/html/ViewEvents.css\' type=\'text/css\'></link>\n\n<!-- these style setting are used for table scroll -->\n<style>\n\tdiv {float: left}\n\t.testSty\n\t{\n\t\twidth:expression(document.getElementById(\"indicatorTable\").clientWidth-document.getElementById(\"left_child\").clientWidth);\n\t\toverflow: scroll;\n\t}\n</style>\n \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<script language=\'javascript\' src=\"../../eCommon/js/common.js\"></script>\n<script Language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script Language=\"javascript\" src=\"../../eXH/js/InterfaceUtil.js\"></script>\n<script Language=\"javascript\" src=\"../../eXH/js/menu.js\"></script>\n<script Language=\"javascript\" src=\"../../eXI/js/MonitorItems.js\"></script>\n<script Language=\"javascript\" src=\"../../eXH/js/jquery-1.7.min.js\"></script>\n<Script Language=\'javascript\'>\n\nfunction funAction(typ)\n{\n\tparent.schemaBrowserResultFrame.inv_monitoring_scr.action_type.value = typ;\n\tfunSubmit();\n}\n\nfunction funSubmit()\n{\n\tparent.schemaBrowserResultFrame.inv_monitoring_scr.action = \'../../eXI/jsp/MonitorItemsPopulateRecords.jsp\';\n\tparent.schemaBrowserResultFrame.inv_monitoring_scr.target = \"schemaBrowserResultFrame\";\n\tparent.schemaBrowserResultFrame.inv_monitoring_scr.submit();\n}\n\n</Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n<body onKeyDown =\'lockKey()\' onMouseDown=\'CodeArrest()\' onLoad=\'initFunc()\'>\n<form name = \"inv_monitoring_scr\" method=\"POST\" action=\'../../eXI/jsp/MonitorItemsPopulateRecords.jsp\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<input type=\'hidden\' name=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' id=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n \n<input type=\'hidden\' name=\'action_type\' id=\'action_type\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n<input type=\'hidden\' name=\'tableName\' id=\'tableName\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n<input type=\'hidden\' name=\'dateTo\' id=\'dateTo\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n<input type=\'hidden\' name=\'dateFrom\' id=\'dateFrom\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n<input type=\'hidden\' name=\'functionID\' id=\'functionID\' id=\'functionID\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n<input type=\'hidden\' name=\'queueType\' id=\'queueType\' id=\'queueType\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n<input type=\"hidden\" name=\"resultMessage\" id=\"resultMessage\" id=\"resultMessage\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\t\n\n<script>\t\n\talert(getMessage(\'XH1021\',\'XH\'));\n</script>\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\n<table id=\"indicatorTable\" cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n<tr>\n\t<td align=\"right\" class=\"CAGROUP\"> \n\t\t<A class=\'label\' style=\'cursor:pointer\' onClick=\"funAction(\'P\')\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</A>\n\t\t<A class=\'label\' onClick=\"funAction(\'N\')\" style=\'cursor:pointer\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</A>\n\t</td>\n</tr>\n</table>\n\n<div id=\"left_child\" style=\"display:none;\">\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n<table id=\"table1\" cellspacing=0 cellpadding=3 border=1>\t\n\t<tr>\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t<td class=\'COLUMNHEADER\'>\n\t\t\t<font color=white>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</font>\n\t\t</td>\n\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t</tr>\n\n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\n\t<tr id=\"testID\">\n\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t<td nowrap ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" align=\'right\'>\n\t\t\t\t<font size=1>&nbsp;";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t</td>\n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" onMouseOver=this.style.cursor=\'hand\' \n\t\t\t\t\t\t\t\t\t\tonMouseDown=\"buildMenu(\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\')\">\n\t\t\t\t<font size=1>&nbsp;";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =">\n\t\t\t\t<font size=1>&nbsp;";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\n</table>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n</div>\n<div id=\"right_child\" class=\"testSty\" style=\"overflow-y:scroll;overflow:-moz-scrollbars-vertical;display:none;\">\n<table id=\"table2\" cellspacing=0 cellpadding=3 border=1>\n\t<tr>\n\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t<td nowrap class=\'COLUMNHEADER\'>\n\t\t\t<font color=white>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\t\t\t\n\t</tr>\n\n\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t<tr>\n\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" >\n\t\t\t\t<font size=1>&nbsp;";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\n\t</tr>\n\n\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t</tr>\n</table>\n</div>\n\t\n<SCRIPT>\n\tdocument.getElementById(\"left_child\").style.display = \"block\";\n\tdocument.getElementById(\"right_child\").style.display = \"block\";\n</SCRIPT>\n\t\n\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n<input type=\"hidden\" name=\"isReloadAuthorised\" id=\"isReloadAuthorised\" id=\"isReloadAuthorised\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"/>\n</form>\n</html>\n\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8"); 
String locale = ((String)session.getAttribute("LOCALE"));

            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
 
String action_type = null;
String maxRecords = "24";

            _bw.write(_wl_block8Bytes, _wl_block8);

int recordCount = 0;
boolean boolToggle =  true;
String strTDClass = "";
String tableName = "";
String functionID = "";
String dateFrom = "";
String dateTo = "";
String queueType = "";
String operation = request.getParameter("operation");
String siteID = (String)session.getAttribute("intSiteID");
ArrayList<String> tableIndColList = null;
ArrayList<String> tabColumnList = null;
Map<String,String> tabDatatypeColList = null;
ArrayList<HashMap> arrRow = null;
Connection conn = null;
boolean boolNext = false; 
boolean boolPrevious = false;
boolean isEditable = true;
boolean isReloadAuthorised = false;
String strPrevious = null;
String strNext = null;
HashMap<String, String> currentRecord = null;
HashMap resultsQry = null;

try
{
	System.out.println(" ********************** Inside MonitorItemsPopulateRecords 89 **********************");
	String resultMessage = XHDBAdapter.checkNull(request.getParameter("message"));
	Properties prop = (Properties)session.getValue("jdbc");
	String loginID = prop.getProperty("login_user");
	System.out.println(" ********************** Inside MonitorItemsPopulateRecords 93 **********************");
	MonitorItemsBean monitorItemsBean = new MonitorItemsBean();
	conn = ConnectionManager.getConnection(request);
	functionID = XHDBAdapter.checkNull(request.getParameter("functionID"));
	dateFrom = XHDBAdapter.checkNull(request.getParameter("dateFrom"));
	dateTo = XHDBAdapter.checkNull(request.getParameter("dateTo"));
	action_type = XHDBAdapter.checkNull(request.getParameter("action_type"));
	queueType = XHDBAdapter.checkNull(request.getParameter("queueType"));

	System.out.println(" ********************** Parameters functionID : "+functionID+" : dateFrom : "+dateFrom+ " : dateFrom : "+dateTo+ " : dateTo : "+dateFrom+" : action_type : "+action_type+" : action_type : "+action_type+" : queueType : "+queueType);
	
	tableName = monitorItemsBean.getFuncTableName(functionID, queueType);

	System.out.println(" ********************** Parameters tableName : "+tableName);

	String whrClause = "";
	String temp = "";
	StringBuilder whrClauseBuilder = new StringBuilder();
	boolean isCriteriaAdded = false;
	String reloadYN = new XHUtil().singleParamExeQry("SELECT reload_yn FROM xh_authorized_user WHERE login_name = '"+ loginID +"'");	

	System.out.println(" ********************** Parameters reloadYN : "+reloadYN+" : siteID : "+siteID);
	
	if("SI".equals(siteID) && "Y".equals(reloadYN)) isReloadAuthorised = true;

	System.out.println(" ********************** Parameters isReloadAuthorised : "+isReloadAuthorised);
	
	tableIndColList = (ArrayList)MonitorItemsBean.getIndexColList(functionID, prop);
	System.out.println(" ********************** Parameters tableIndColList Size : "+tableIndColList.size());

	tabColumnList = (ArrayList)MonitorItemsBean.getTabColList(tableName, prop);
	System.out.println(" ********************** Parameters tabColumnList Size : "+tabColumnList.size());

	tabDatatypeColList = MonitorItemsBean.getTabDataTypeList(tableName, prop);
	System.out.println(" ********************** Parameters tableIndColList Size : "+tableIndColList.size());

	request.setAttribute(XHQueryRender.strQueryId, "INVENTORY_MONITORING_SCR");
	request.setAttribute("tableName", tableName);
	request.setAttribute(XHQueryRender.col, tabColumnList.size());
	request.setAttribute(XHQueryRender.maxRec, maxRecords);
	request.setAttribute(XHQueryRender.whereClause, whrClause);

	if(tableIndColList != null && (tableIndColList.size() > 0))
	{

	for(String colName: tableIndColList)
	{
		temp = XHDBAdapter.checkNull(request.getParameter(colName));

		System.out.println(" ********************** Parameters request.getParameter(colName) : "+request.getParameter(colName)+" : siteID : "+siteID);

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(colName));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(colName));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block12Bytes, _wl_block12);

		if(temp != null && !temp.equals(""))
		{
			if(isCriteriaAdded) whrClauseBuilder.append(" AND ");
			else whrClauseBuilder.append(" WHERE ");
			if("TRXDATETIME".equals(colName)) whrClauseBuilder.append("TRXDATETIME = TO_DATE('"+temp+"','dd/mm/yyyy')");
			else	whrClauseBuilder.append(colName + " = '" + temp + "'");
			isCriteriaAdded = true;
		}
	}

	System.out.println(" ********************** Parameters whrClauseBuilder : "+whrClauseBuilder.toString());

	if(dateFrom != null & !dateFrom.equals(""))
	{
		if(isCriteriaAdded) whrClauseBuilder.append(" AND ");
		else whrClauseBuilder.append(" WHERE ");
		if(dateTo != null & !dateTo.equals(""))
		{
			whrClauseBuilder.append("TO_DATE(TO_CHAR(trx_date,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN TO_DATE('"+dateFrom+"','dd/mm/yyyy') AND TO_DATE('"+dateTo+"','dd/mm/yyyy')");
		}
		else
		{
			whrClauseBuilder.append("TO_DATE(TO_CHAR(trx_date,'dd/mm/yyyy'),'dd/mm/yyyy') >= TO_DATE('"+dateFrom+"','dd/mm/yyyy')");
		}
	}
	else if(dateTo != null & !dateTo.equals(""))
	{
		if(isCriteriaAdded) whrClauseBuilder.append(" AND ");
		else whrClauseBuilder.append(" WHERE ");
		whrClauseBuilder.append("TO_DATE(TO_CHAR(trx_date,'dd/mm/yyyy'),'dd/mm/yyyy') <= TO_DATE('"+dateTo+"','dd/mm/yyyy')");
	}

	System.out.println(" ********************** Parameters whrClauseBuilder : "+whrClauseBuilder.toString());
	
	if("XF_DF_HEALTHCAREDELIVERY".equalsIgnoreCase(tableName)) 
	{		
		whrClauseBuilder.append(" ORDER BY ORDERDOCTOR, HEALTHCAREOFFERINGID, TRXDATETIME");
	}
	whrClause = whrClauseBuilder.toString();	

	System.out.println(" ********************** Parameters whrClause : "+whrClause);
	
	request.setAttribute(XHQueryRender.whereClause, whrClause);

	System.out.println(" ********************** Parameters 190 : ");

	boolean tempIsIndCol = false;
	for(Iterator<String> it = tabColumnList.iterator(); it.hasNext(); )
	{
		String currentColName = it.next();
		for(String colName: tableIndColList)
		{
			if(currentColName.equals(colName))
			{
				it.remove();
				tempIsIndCol = true;
				break;
			}
		}
		if(tempIsIndCol)
		{
			tempIsIndCol = false;
			continue;
		}
	}	
	System.out.println(" ********************** Parameters 211 : ");
	}

	resultsQry = XHQueryRender.getResults(request, session, conn);
	arrRow = (ArrayList)resultsQry.get("qry_result");	
	recordCount = arrRow.size();
	
	System.out.println(" ********************** Parameters 218 : ");

	boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
	strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");

	System.out.println(" ********************** Parameters 225 : ");

	if (boolPrevious == true)
	{
		strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	}
	else
	{
		strPrevious = " ";
	}
	if (boolNext== true)
	{
		strNext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	}
	else
	{
		strNext = " ";
	}

	System.out.println(" ********************** Parameters 244 : ");

 	
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(action_type));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tableName));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(dateTo));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(dateFrom));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(functionID));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(queueType));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf( resultMessage ));
            _bw.write(_wl_block20Bytes, _wl_block20);

	System.out.println(" ********************** Parameters arrRow.size() : "+arrRow.size());
if(arrRow == null || (arrRow.size() == 0)){
	System.out.println(" ********************** Parameters 259 : ");

            _bw.write(_wl_block21Bytes, _wl_block21);

}
else{

            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf( strPrevious ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf( strNext ));
            _bw.write(_wl_block24Bytes, _wl_block24);
 if(tableIndColList != null) {
            _bw.write(_wl_block25Bytes, _wl_block25);

		for(String colName: tableIndColList)
		{
	
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( colName ));
            _bw.write(_wl_block27Bytes, _wl_block27);

		}
	
            _bw.write(_wl_block28Bytes, _wl_block28);

		for (int j = 0; j < recordCount; j++)
		{
			currentRecord = arrRow.get(j);
			if (boolToggle == true)
			{
				if("IeStyle.css".equalsIgnoreCase(sStyle)) strTDClass = "class='XHQRYEVEN'";
				else strTDClass = "class='QRYEVEN'";
				boolToggle =  false;
			}
			else
			{
				if("IeStyle.css".equalsIgnoreCase(sStyle)) strTDClass = "class='XHQRYODD'";
				else strTDClass = "class='QRYODD'";
				boolToggle =  true;
			}
	
            _bw.write(_wl_block29Bytes, _wl_block29);

		for(String colName: tableIndColList)
		{
			if(tabDatatypeColList.get(colName).equals("NUMBER"))
			{
	
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf( MonitorItemsBean.checkNumber((String)currentRecord.get(colName)) ));
            _bw.write(_wl_block32Bytes, _wl_block32);

			}
			else if(tabDatatypeColList.get(colName).equals("DATE"))
			{
				String val = (String)currentRecord.get(colName);
				int valLen = val.length();
	
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf( (valLen == 21)?val.substring(0,19):val ));
            _bw.write(_wl_block32Bytes, _wl_block32);

			}
			else if("RECORD_STATUS".equalsIgnoreCase(colName) && currentRecord.get(colName).equals("E"))
			{
	
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf( currentRecord.get("TRX_NO") ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf( XHDBAdapter.checkNull(currentRecord.get(colName)) ));
            _bw.write(_wl_block32Bytes, _wl_block32);

			}
			else
			{
	
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf( XHDBAdapter.checkNull(currentRecord.get(colName)) ));
            _bw.write(_wl_block32Bytes, _wl_block32);

			}
		}
	
            _bw.write(_wl_block28Bytes, _wl_block28);

		}
	
            _bw.write(_wl_block36Bytes, _wl_block36);
}
            _bw.write(_wl_block37Bytes, _wl_block37);

		for(String colName: tabColumnList)
		{
	
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( colName ));
            _bw.write(_wl_block27Bytes, _wl_block27);

		}
	
            _bw.write(_wl_block39Bytes, _wl_block39);

		boolToggle = true;
		for (int j = 0; j < recordCount; j++)
		{
			currentRecord = arrRow.get(j);
			if (boolToggle == true)
			{
				if("IeStyle.css".equalsIgnoreCase(sStyle)) strTDClass = "class='XHQRYEVEN'";
				else strTDClass = "class='QRYEVEN'";
				boolToggle =  false;
			}
			else
			{
				if("IeStyle.css".equalsIgnoreCase(sStyle)) strTDClass = "class='XHQRYODD'";
				else strTDClass = "class='QRYODD'";
				boolToggle =  true;
			}
	
            _bw.write(_wl_block40Bytes, _wl_block40);

		for(String colName: tabColumnList)
		{
			if(tabDatatypeColList.get(colName).equals("NUMBER"))
			{
	
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf( MonitorItemsBean.checkNumber((String)currentRecord.get(colName)) ));
            _bw.write(_wl_block32Bytes, _wl_block32);

			}
			else if(tabDatatypeColList.get(colName).equals("DATE"))
			{
				String val = (String)currentRecord.get(colName);
				int valLen = val.length();
	
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf( (valLen == 21)?val.substring(0,19):val ));
            _bw.write(_wl_block32Bytes, _wl_block32);

			}
			else
			{
	
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf( XHDBAdapter.checkNull(currentRecord.get(colName)) ));
            _bw.write(_wl_block32Bytes, _wl_block32);

			}
		}
	
            _bw.write(_wl_block42Bytes, _wl_block42);
 } 
	
            _bw.write(_wl_block43Bytes, _wl_block43);

	}	
	if(arrRow != null) arrRow.clear();
	if(currentRecord != null) currentRecord.clear();
	if(resultsQry != null) resultsQry.clear();
}
catch(Exception e1)
{
	out.println("<SCRIPT>alert(getMessage('XH1021','XH'));</SCRIPT>");
	e1.printStackTrace(System.err);
	System.out.println(e1);
	System.out.println("functionID "+functionID);
	System.out.println("queueType "+queueType);
	System.out.println("tableName "+tableName);
	System.out.println("isReloadAuthorised "+isReloadAuthorised);
	System.out.println("tableIndColList "+tableIndColList);
	System.out.println("tabColumnList "+tabColumnList);
	System.out.println("tabDatatypeColList "+tabDatatypeColList);
}
finally
{
	ConnectionManager.returnConnection(conn);
}

            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf( isReloadAuthorised ));
            _bw.write(_wl_block45Bytes, _wl_block45);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
