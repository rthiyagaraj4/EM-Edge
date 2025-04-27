package jsp_servlet._exh._jsp;

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
import eXH.InterfaceUtil;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.*;
import com.ehis.util.*;

public final class __queuecriteriaresultsrutnin extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/QueueCriteriaResultsRutnin.jsp", 1733051668459L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\t\n\n<head>\n<LINK REL=\'stylesheet\' HREF=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></LINK>\n<LINK REL=\'stylesheet\' HREF=\'../../eXH/html/menu.css\' TYPE=\'text/css\'></LINK>\n\n<SCRIPT LANGUAGE=\'javascript\' SRC=\'../../eCommon/js/common.js\'></SCRIPT>\n<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/CommonLookup.js\"></SCRIPT>\n<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/CommonCalendar.js\"></SCRIPT>\n<SCRIPT SRC=\"../../eCommon/js/ValidateControl.js\" LANGUAGE=\"javascript\"></SCRIPT>\n<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eXH/js/ManageQueueRutnin.js\"></SCRIPT>\n<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/jquery-3.6.3.js\"></SCRIPT>\n<SCRIPT LANGUAGE=\'javascript\' SRC=\'../../eXH/js/menu.js\'></SCRIPT>\n<SCRIPT LANGUAGE=\'javascript\'>\n\nfunction funAction(typ)\n{\n\tparent.queueResultFrame.queueDispResult.action_type.value = typ;\n\tfunSubmit();\n}\n\nfunction funSubmit()\n{\n\tparent.queueResultFrame.queueDispResult.action = \'../../eXH/jsp/QueueCriteriaResultsRutnin.jsp\';\n\tparent.queueResultFrame.queueDispResult.target = \"queueResultFrame\";\n\tparent.queueResultFrame.queueDispResult.submit();\n}\n\n</SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n\n<BODY onKeyDown =\'lockKey()\' onMouseDown=\'CodeArrest()\' onLoad=\'initFunc()\'>\n<FORM name=\"queueDispResult\" id=\"queueDispResult\" METHOD=\"POST\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\t\n\n<script>\t\n\talert(getMessage(\'XH1021\',\'XH\'));\t\n</script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<table cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" align=\"center\">\n<TR>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<TD CLASS=\"label\">Workstation</TD>\n\t<TD CLASS=\"fields\">\n\t\t<SELECT name=\"workStation\" id=\"workStation\" ID=\"workStation\" style=\"width: 150px\">\n\t\t\t<OPTION VALUE=\'\'>-------";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="------</OPTION>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<OPTION VALUE=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' SELECTED>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</OPTION>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t</SELECT>&nbsp;\n\t\t<INPUT TYPE=\"button\" onClick=\"callNext()\" VALUE=\"Call Next Patient\">\n\t</TD>\n</TR>\n<TR>\n\t<td align=\"right\" class=\"CAGROUP\">&nbsp;</td>\n\t<td align=\"right\" class=\"CAGROUP\"> \n\t\t<A class=\'label\' style=\'cursor:pointer\' onClick=\"funAction(\'P\')\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</A>\n\t\t<A class=\'label\' onClick=\"funAction(\'N\')\" style=\'cursor:pointer\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</A>\n\t</td>\n</tr>\n</table>\n\n<TABLE id=\"table1\" cellspacing=0 cellpadding=3 border=1 width=\"100%\">\t\n\t<tr>\n\t\t<td class=\'COLUMNHEADER\'>\n\t\t\tPatientID\n\t\t</td>\t\t\n\t\t<td class=\'COLUMNHEADER\'>\n\t\t\tQueue No\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\'>\n\t\t\tWorkstation\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\'>\n\t\t\tWorkflow\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\'>\n\t\t\tUsername\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\'>\n\t\t\tScheduled Time\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\'>\n\t\t\tNext Station\n\t\t</td>\n\t</tr>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t<tr>\n\t\t<td ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" onMouseOver=\"this.style.cursor=\'hand\'\" onMouseDown=\"buildMenu(\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\',\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\');\">\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&nbsp;\n\t\t</td>\n\t\t<td ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =">\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =">\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&nbsp;\n\t\t</td>\n\t</tr>\n\t\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n</TABLE>\t\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n<INPUT TYPE=\'hidden\' name=\'action_type\' id=\'action_type\' VALUE=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n<INPUT TYPE=\'hidden\' name=\'loginID\' id=\'loginID\' ID=\'loginID\' VALUE=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n<INPUT TYPE=\'hidden\' name=\'siteID\' id=\'siteID\' VALUE=\'RT\'>\n<INPUT TYPE=\'hidden\' name=\'facilityID\' id=\'facilityID\' ID=\"facilityID\" VALUE=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n</FORM>\n</HTML>\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

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
String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

int recordCount = 0;
boolean boolToggle = true;
boolean boolNext = false; 
boolean boolPrevious = false;
String action_type = null;
String maxRecords = "10";
String strTDClass = "";
String strPrevious = null;
String strNext = null;
String loginID = null;
Connection dbConn = null;
HashMap resultsQry = null;
ArrayList arrRow = null;
ArrayList<String> arrCol = null;

try
{
	Properties prop = (Properties)session.getValue("jdbc");
	loginID = prop.getProperty("login_user");	
	String patientID = request.getParameter("patientID");
	String facilityID = request.getParameter("facilityID");
	String workStation = request.getParameter("workStation");
	String workflow = request.getParameter("workflow");
	String userName = request.getParameter("userName");
	String scheduledTime = request.getParameter("scheduledTime");
	String nextStation = request.getParameter("nextStation");
	action_type = XHDBAdapter.checkNull(request.getParameter("action_type"));
	String ticketNo = XHDBAdapter.checkNull(request.getParameter("ticketNo"));
	String qry = "SELECT patient_id, queue_num, workstation, workflow, username, scheduled_time, loc_status, next_station FROM xq_queue_simulate_trans";
	String[] tempColNames = {"patient_id", "workstation", "queue_num", "workflow", "username", "scheduled_time", "next_station"};
	String[] tempColVal = {patientID, workStation, ticketNo, workflow, userName, scheduledTime, nextStation};
	String whrClause = InterfaceUtil.buildWhrClause(tempColNames,tempColVal);
	qry += whrClause;

	dbConn = ConnectionManager.getConnection(request);

	System.out.println("Query "+qry);
	request.setAttribute(XHQueryRender.strQueryId, "MANAGE_PATIENT_QUEUE");
	request.setAttribute("query", qry);
	request.setAttribute(XHQueryRender.col,8);
	request.setAttribute(XHQueryRender.maxRec, maxRecords);

	resultsQry = XHQueryRender.getResults(request, session, dbConn);
	arrRow = (ArrayList)resultsQry.get("qry_result");	
	recordCount = arrRow.size();

	boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
	strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");

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
		strNext  = " ";
	}
 	
	if(arrRow.size() == 0)
	{

            _bw.write(_wl_block7Bytes, _wl_block7);

	}
	else
	{

            _bw.write(_wl_block8Bytes, _wl_block8);

		int countRec = 0;
		PreparedStatement roomNoPSTMT = null;
		ResultSet roomNoRS = null;
		String roomNoQry = "SELECT DISTINCT workstation,workstation desc1 FROM xq_queue_simulate_trans";
		roomNoPSTMT = dbConn.prepareStatement(roomNoQry,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		roomNoRS = roomNoPSTMT.executeQuery();
	
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

	try
	{
		if(roomNoRS != null)
		{
			roomNoRS.last();
			countRec = roomNoRS.getRow();
			roomNoRS.beforeFirst();
		}
		if(countRec == 1)
		{
			roomNoRS.next();
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(roomNoRS.getString(1)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(roomNoRS.getString(2)));
            _bw.write(_wl_block13Bytes, _wl_block13);

		}
		else if(countRec >= 1)
		{
			while(roomNoRS != null && roomNoRS.next())
			{
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(roomNoRS.getString(1)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(roomNoRS.getString(2)));
            _bw.write(_wl_block13Bytes, _wl_block13);

			}
		}
	}
	catch(Exception exp)
	{
		exp.printStackTrace(System.err);
	}
	finally
	{
		if(roomNoRS != null) roomNoRS.close();
		if(roomNoPSTMT != null) roomNoPSTMT.close();
	}
	
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( strPrevious ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( strNext ));
            _bw.write(_wl_block17Bytes, _wl_block17);

		for (int j = 0; j < arrRow.size(); j++)
		{
			arrCol = (ArrayList<String>)arrRow.get(j);
			if (boolToggle == true)
			{
				strTDClass = "class='QRYEVEN'";
				boolToggle =  false;
			}
			else
			{
				strTDClass = "class='QRYODD'";
				boolToggle =  true;
			}

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf( XHDBAdapter.checkNull(arrCol.get(0)) ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( XHDBAdapter.checkNull(arrCol.get(1)) ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( XHDBAdapter.checkNull(arrCol.get(2)) ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( XHDBAdapter.checkNull(arrCol.get(3)) ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( XHDBAdapter.checkNull(arrCol.get(4)) ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( XHDBAdapter.checkNull(arrCol.get(5)) ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( XHDBAdapter.checkNull(arrCol.get(6)) ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( XHDBAdapter.checkNull(arrCol.get(7)) ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(XHDBAdapter.checkNull(arrCol.get(0))));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(XHDBAdapter.checkNull(arrCol.get(1))));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(XHDBAdapter.checkNull(arrCol.get(2))));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(XHDBAdapter.checkNull(arrCol.get(3))));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(XHDBAdapter.checkNull(arrCol.get(4))));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(XHDBAdapter.checkNull(arrCol.get(5))));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(XHDBAdapter.checkNull(arrCol.get(7))));
            _bw.write(_wl_block25Bytes, _wl_block25);

		}

            _bw.write(_wl_block26Bytes, _wl_block26);

	}	
	if(arrRow != null) arrRow.clear();
	if(resultsQry != null) resultsQry.clear();
}
catch(Exception e1)
{	
	e1.printStackTrace(System.err);	
}
finally
{
	ConnectionManager.returnConnection(dbConn);
}

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf( action_type ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( loginID ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf( (String)session.getAttribute("facility_id") ));
            _bw.write(_wl_block30Bytes, _wl_block30);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
