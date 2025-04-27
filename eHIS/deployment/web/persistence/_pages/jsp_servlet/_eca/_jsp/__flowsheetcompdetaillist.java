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

public final class __flowsheetcompdetaillist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/FlowSheetCompDetailList.jsp", 1728455751735L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<title></title>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<!-- Added by Arvind @ 07-12-08 -->\n\t\t\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCA/js/FlowSheetCompDetail.js\"></script>\n\t\t\n\n</head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<body onScroll=\"scrollTitle()\" onKeyDown=\"lockKey()\">\n<script language=javascript>\ndocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\ndocument.body.style.scrollbarArrowColor=\'#000080\';\ndocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\ndocument.body.style.scrollbarHighlightColor=\'white\';\ndocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\n\n<form name=\"FlowSheetEventSearchResultForm\" id=\"FlowSheetEventSearchResultForm\">\t\n<div id=\'divDataTitle\' style=\'postion:relative\'>\n<table border=\"0\" id=\"finalDiv\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" align=\"center\" scrolling=\"no\">\n \n<!-- <table cellpadding=\'3\' cellspacing=\'0\' border=\'0\' width=\'100%\' align=\'center\'>\n -->\n<td class=\'white\' width=\'88%\'></td> \n<td  align=\'right\' width=\'12%\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n</td>\n</tr>\n</table>\n<table border=\"1\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\"  name=\"resultTable\" id=\"resultTable\" id=\"resultTable\">\n<tr>\n<th class=\'columnHeader\' colspan=3 align=\"left\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n</tr><tr>\n<th class=\'columnHeadercenter\' style=\"font-size:10\" width=\"26%\" align=\"left\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n<th class=\'columnHeadercenter\' style=\"font-size:10\"width=\"64%\" align=\"left\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n<th class=\'columnHeadercenter\' style=\"font-size:10\" width=\"10%\" align=\"left\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td> \n</tr>\n</table>\n</div>\n<table class=\"grid\"  width=\"100%\"  name=\"resultTable\" id=\"resultTable\" id=\"resultTable\">\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n                <tr>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" width=\"26%\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"  width=\"64%\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" width=\"10%\"><input type=\"checkbox\" name=\"chkbox";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" id=\"chkbox";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" onClick=\"Reassaign(this);chkunchk(this)\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="><input type=\'hidden\' name=\'chk_value";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' id=\'chk_value";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"></td>\n\t\t\t\t<input type=\'hidden\' name=\'ret_value";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' id=\'ret_value";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="~";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="|";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'> \n\t\t\t\t</tr>\n\t\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t<!-- <script>document.forms[0].ctrlChkBox.checked = true</script>  -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n        <script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\'));</script>\n\t\t<!-- <script>document.forms[0].ctrlChkBox.disabled = true</script>  -->\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t<input type=\"hidden\" name=\"count\" id=\"count\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t\t\n\t\t\t\n</table>\n\n</form>\n</body>\n</script>\n</html>\n\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

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
--------------------------------------------------------------------------------------------------------------
Date		Edit History      Name       	Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           										created
07/03/2017	 IN063542		Raja S			10/03/2017		Ramesh G			GHL-CRF-0460
---------------------------------------------------------------------------------------------------------------
*/ 

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.RecordSet FlowSheetBean= null;synchronized(session){
                FlowSheetBean=(webbeans.eCommon.RecordSet)pageContext.getAttribute("FlowSheetBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(FlowSheetBean==null){
                    FlowSheetBean=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("FlowSheetBean",FlowSheetBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =	  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		//IN063542 Starts
		Properties pr  =	  (Properties)session.getValue("jdbc");
		String locale =   (String) pr.getProperty("LOCALE");
		//IN063542 Ends
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	StringBuffer strsql1 = new StringBuffer(" ");
	StringBuffer strsql2 = new StringBuffer(" "); //Added for IN063542
 	StringBuffer where = new StringBuffer(" ");
 	StringBuffer countsql = new StringBuffer(" ");
    
		
    String flow_sheet_id=request.getParameter("flow_sheet_id")==null?"":request.getParameter("flow_sheet_id");
	String history_type_id=request.getParameter("history_type_id")==null?"":request.getParameter("history_type_id");
	String event_item=request.getParameter("event_item")==null?"":request.getParameter("event_item");
    String searchby=request.getParameter("searchby")==null?"":request.getParameter("searchby");
	String criteria=request.getParameter("criteria")==null?"":request.getParameter("criteria");
	String text=request.getParameter("text")==null?"":request.getParameter("text");
	
	//out.println("<script>alert('searchby"+searchby+"')</script>");
	//out.println("<script>alert('criteria"+criteria+"')</script>");
	//out.println("<script>alert('text"+text+"')</script>");
		
	String from 			= 
	request.getParameter("from");
	//out.println("<script>alert('from"+from+"')</script>");
	String to 	= 
	request.getParameter("to");
	//out.println("<script>alert('to"+to+"')</script>");
	String whereclause= request.getParameter("whereclause")==null?"":request.getParameter("whereclause");

	//String pract_id=(String)session.getValue("ca_practitioner_id");
	//out.println("<script>alert('pract_id"+pract_id+"')</script>");
	
	//String rowid="";
	String eventcode="";
	String eventdesc="";
	String histrectype="";
	String event_code_type="";
	String key="";
			
	Connection con = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	
	int start = 0 ;
	int end = 0 ;
	int i=1;
	int k=0;
	int maxRecord =0;
	if ( from == null )
		start = 1;
	else
		start = Integer.parseInt(from);

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;
		StringBuffer strbuf= new StringBuffer("");
		StringBuffer strbuf1= new StringBuffer(""); //Added for IN063542

   
	    
	strsql1.append("select A.HIST_REC_TYPE, A.LONG_DESC HIST_REC_TYPE_DESC,D.EVENT_CODE,D.SHORT_DESC EVENT_DESC,NVL((SELECT 1 FROM CA_FLOW_SHEET_ITEM WHERE HIST_REC_TYPE=A.HIST_REC_TYPE and EVENT_CODE = D.EVENT_CODE AND EVENT_CODE_TYPE=D.EVENT_CODE_TYPE  AND FLOW_SHEET_ID=?),'0') EVENT_EXISTS  ,D.EVENT_CODE_TYPE FROM  CR_HIST_REC_TYPE A, CR_CLIN_EVENT_MAST D WHERE   A.HIST_REC_TYPE=? AND D.HIST_REC_TYPE=A.HIST_REC_TYPE");
	strsql2.append(" UNION select DECODE (C.ORDER_CATEGORY, 'LB', 'LBIN', 'RD', 'RDIN', '')  HIST_REC_TYPE, DECODE (C.ORDER_CATEGORY, 'LB', 'Laboratory', 'RD', 'Radiology', '')  HIST_REC_TYPE_DESC,c.contr_msr_panel_id EVENT_CODE,D.LONG_DESC EVENT_DESC,NVL((SELECT 1 FROM CA_FLOW_SHEET_ITEM WHERE HIST_REC_TYPE = ? AND EVENT_CODE = C.contr_msr_panel_id AND FLOW_SHEET_ID = ?),'0') EVENT_EXISTS,C.Order_category EVENT_CODE_TYPE from OR_ORDER_CATALOG c , OR_ORDER_CATALOG_LANG D WHERE ORDER_CATALOG_NATURE='P' AND C.ORDER_CATEGORY = ?  and C.ORDER_CATALOG_CODE= d.order_catalog_code and D.language_id=? "); //Added for IN063542

	//strsql1.append("select A.HIST_REC_TYPE, CR_GET_DESC.CR_HIST_REC_TYPE(A.HIST_REC_TYPE,?,'2') HIST_REC_TYPE_DESC,D.EVENT_CODE,D.SHORT_DESC EVENT_DESC,NVL((SELECT 1 FROM CA_FLOW_SHEET_ITEM WHERE HIST_REC_TYPE=A.HIST_REC_TYPE and EVENT_CODE = D.EVENT_CODE AND EVENT_CODE_TYPE=D.EVENT_CODE_TYPE  AND FLOW_SHEET_ID=?),'0') EVENT_EXISTS  ,D.EVENT_CODE_TYPE FROM  CR_HIST_REC_TYPE A, CR_CLN_EVT_MST_LANG_VW D WHERE   D.LANGUAGE_ID = ? AND A.HIST_REC_TYPE=? AND D.HIST_REC_TYPE=A.HIST_REC_TYPE");
	 countsql.append("SELECT count(*) total FROM  CR_HIST_REC_TYPE A, CR_CLIN_EVENT_MAST D WHERE   A.HIST_REC_TYPE=? AND D.HIST_REC_TYPE=A.HIST_REC_TYPE");

	   if(searchby.equals("C"))
		{
		 if(criteria.equals("S"))
         strbuf.append(" and D.EVENT_CODE like '"+text+"%'");
		 else if(criteria.equals("E"))
         strbuf.append(" and D.EVENT_CODE like '%"+text+"'");
		 else if(criteria.equals("C"))
         strbuf.append(" and D.EVENT_CODE like '%"+text+"%'");
		}
	 else if(searchby.equals("D"))
		{
		 if(criteria.equals("S"))
         strbuf.append(" and D.SHORT_DESC like '"+text+"%'");
		 else if(criteria.equals("E"))
         strbuf.append(" and D.SHORT_DESC like '%"+text+"'");
		 else if(criteria.equals("C"))
         strbuf.append(" and D.SHORT_DESC like '%"+text+"%'");
		}
    strsql1.append(strbuf.toString());
	countsql.append(strbuf.toString());
	//Added for IN063542 starts
	if("LBIN".equals(history_type_id) || "RDIN".equals(history_type_id)) {
		strsql1.append(strsql2.toString());
			 if(searchby.equals("C"))
				{
			 	if(criteria.equals("S"))
	         	strbuf1.append(" and c.contr_msr_panel_id like '"+text+"%'");
			 	else if(criteria.equals("E"))
	         	strbuf1.append(" and c.contr_msr_panel_id like '%"+text+"'");
			 	else if(criteria.equals("C"))
	         	strbuf1.append(" and c.contr_msr_panel_id like '%"+text+"%'");
				}
		 	else if(searchby.equals("D"))
				{
			 	if(criteria.equals("S"))
	         	strbuf1.append(" and C.LONG_DESC like '"+text+"%'");
			 	else if(criteria.equals("E"))
	         	strbuf1.append(" and C.LONG_DESC like '%"+text+"'");
			 	else if(criteria.equals("C"))
	         	strbuf1.append(" and C.LONG_DESC like '%"+text+"%'");
				}
			 strsql1.append(strbuf1.toString());
	}
	//Added for IN063542 Ends
	

	
	
   	try
	{
       con =  ConnectionManager.getConnection(request);

	   stmt = con.prepareStatement(countsql.toString());

	   int s=0;

		
       stmt.setString(++s,history_type_id);
		
					
    	rs = stmt.executeQuery();

		if(rs.next())
		{
          maxRecord = Integer.parseInt(rs.getString("total")==null?"0":rs.getString("total"));
		}
       //out.println("<script>alert('maxRecord"+maxRecord+"')</script>");
		if(rs != null)rs.close();
		if(stmt != null)stmt.close();

	    if ( (whereclause == null || whereclause.equals("")) )
	    {
       
           strsql1.append(where.toString()); 
	    }
	    else
	    {
		strsql1.append(whereclause);
		

	    }
		strsql1.append(" ORDER BY 2,1,4,3");


		stmt = con.prepareStatement(strsql1.toString());

		int st=0;

//		stmt.setString(++st,locale);
        stmt.setString(++st,flow_sheet_id);
//		stmt.setString(++st,locale);
		stmt.setString(++st,history_type_id);
		//Added for IN063542 starts
		if("LBIN".equals(history_type_id) || "RDIN".equals(history_type_id)) {
			stmt.setString(++st,history_type_id);
			stmt.setString(++st,flow_sheet_id);

			if("LBIN".equals(history_type_id))
				stmt.setString(++st,"LB");
			else if("RDIN".equals(history_type_id))
				stmt.setString(++st,"RD");
			stmt.setString(++st,locale);
		}	

		//Added for IN063542 ends
    	rs = stmt.executeQuery();
	    
	 
            _bw.write(_wl_block8Bytes, _wl_block8);

//out.println("<script>alert('start"+start+"')</script>");
//out.println("<script>alert('end"+end+"')</script>");
if ( !(start <= 1) )
		{
out.println("<A class='gridLink' HREF='../../eCA/jsp/FlowSheetCompDetailList.jsp?flow_sheet_id="+flow_sheet_id+"&history_type_id="+history_type_id+"&event_item="+event_item+"&searchby="+searchby+"&criteria="+criteria+"&text="+text+"&from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(where.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
		}
		

//out.println("<script>alert('start"+start+"')</script>");

  if ( !( (start+14) > maxRecord ) )
		{
	out.println("<A class='gridLink' HREF='../../eCA/jsp/FlowSheetCompDetailList.jsp?flow_sheet_id="+flow_sheet_id+"&history_type_id="+history_type_id+"&event_item="+event_item+"&searchby="+searchby+"&criteria="+criteria+"&text="+text+"&from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(where.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		}
	
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
 
	//out.println("<script>alert('start"+start+"')</script>");
	//out.println("<script>alert('end"+end+"')</script>");
	//out.println("<script>alert('i="+i+"')</script>");
      if ( start != 1 )
		{
		    for( int j=1; j<start; i++,j++ )
	           {
	             rs.next() ;
	           }
		}
	//out.println("<script>alert('end"+end+"')</script>");
	//out.println("<script>alert('i="+i+"')</script>");
	//out.println("<script>alert('rs.next()="+rs.next()+"')</script>");

		String classValue="";
		
		int p=0; 
	 while(rs!=null && rs.next() && i<=end)
		{
		
			 
		 eventcode=rs.getString("EVENT_CODE")==null?" ":rs.getString("EVENT_CODE");
		 eventdesc=rs.getString("EVENT_DESC")==null?" ":rs.getString("EVENT_DESC");
		 histrectype=rs.getString("HIST_REC_TYPE")==null?" ":rs.getString("HIST_REC_TYPE");
		 event_code_type=rs.getString("EVENT_CODE_TYPE")==null?" ":rs.getString("EVENT_CODE_TYPE");
		 
		 key = histrectype+eventcode+event_code_type;
		
		 	 
		 if ( i % 2 == 0 )
		 classValue = "gridData" ;
		 else
		 classValue = "gridData" ;
	  	
	    
		 String beankey="";		
	 	 String checkstatus="";		
	 	// String code2="";		
	 	 //String code="";		
         
		for(int m=0;m<FlowSheetBean.getSize();m+=2)
				{
					beankey=FlowSheetBean.getObject(m).toString();
					 					
					if(key.equalsIgnoreCase(beankey))
					{
					checkstatus="checked";
                    p++; 
					break;
					}
					
                   

				}
				
			
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(eventcode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(eventdesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(k));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(k));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(k));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(checkstatus));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(k));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(k));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(key));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(k));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(k));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(key));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(histrectype));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(eventcode));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(eventdesc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(event_code_type));
            _bw.write(_wl_block30Bytes, _wl_block30);

				i++;
				k++;
		}
		 if((p+1) == i || p == 14)
					{
					
            _bw.write(_wl_block31Bytes, _wl_block31);
}
		if(i == 1)
		{
   		
            _bw.write(_wl_block32Bytes, _wl_block32);
}
				
	if(rs!=null) rs.close();
	if(stmt!=null)stmt.close();		 	
	
	

}
			
			
catch(Exception e)
{
	e.printStackTrace();
	//out.println("Exception cauight in FlowSheetCompDetailListResult.jsp" + e);//COMMON-ICN-0181
	
}
finally 
{
	
	ConnectionManager.returnConnection(con,request);
}


            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(k));
            _bw.write(_wl_block34Bytes, _wl_block34);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.searchresult.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.EventCode.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EventDescription.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
