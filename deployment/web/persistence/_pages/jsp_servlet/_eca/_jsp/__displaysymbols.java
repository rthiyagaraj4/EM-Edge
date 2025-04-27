package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCA.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __displaysymbols extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/DisplaySymbols.jsp", 1709115800529L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'\n\ttype=\'text/css\'></link>\n<head>\n<title>Symbol Table</title>\n</head>\n<SCRIPT language=\"javascript\" src=\"../../eCA/js/Symbols.js\"></SCRIPT>\n\n<style type=\"text/css\">\n.columnHeading {\n\tfont-family: verdana;\n\tfont-size: 30px;\n\tcolor: navy;\n\tbackground-color: grey;\n}\n\n.gridData3 {\n\tfont-family: Verdana, Arial, Helvetica, sans-serif;\n\tcolor: #000000;\n\tfont-weight: normal;\n\tbackground-color: grey;\n}\n\n.grid1 {\n\tfloat: right;\n\twidth: 20px;\n\tborder-left: 1px;\n\tborder-right: 1px;\n\tborder-top: 1px;\n\tborder-bottom: 1px;\n\tborder-color: #666666;\n\tborder-style: solid;\n}\n\n.borderhighlight {\n\twidth: 20px;\n\tbackground-color: #FF9900;\n\tfloat: right;\n\tbackground-repeat: repeat-x;\n\tfont-family: Verdana, Arial, Helvetica, sans-serif;\n\tfont-size: 8pt;\n\tcolor: #000000;\n\tfont-weight: normal;\n\ttext-align: left;\n\tpadding-right: 0px;\n\tvertical-align: top;\n\tborder-left: 2px;\n\tborder-right: 2px;\n\tborder-top: 2px;\n\tborder-bottom: 2px;\n\tborder-color: grey;\n\tborder-style: solid;\n\tmargin: 0;\n\tborder-collapse: collapse;\n}\n\ndiv.scroll {\n\toverflow-y: scroll;\n\toverflow-x: hidden;\n}\n</style>\n<body>\n\t<form name=\'displaySymbol\' id=\'displaySymbol\'>\n\t<div class=\'scroll\' style=\"height: 250px; width: 500px\">\n\t\t\t<table class=grid cellspacing=\'0\' style=\"width:500px\">\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\n\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'columnHeadercenter\' colspan=\"10\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<tr height=\'10px\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'totalSymbols\' id=\'totalSymbols\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t\t\t\t<!--IN041022 Starts-->\n\t\t\t\t\t<!--<input type=\'hidden\' name=\'selectedSymbol\' id=\'selectedSymbol\' value=\'\'>-->\n\t\t\t\t\t<input type=\'hidden\' name=\'selectedSymbol\' id=\'selectedSymbol\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t\t\t\t<!--IN041022 Ends-->\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\n\t\t\t</table>\n\t\t</div>\n\n\t\t<table cellspacing=\'0\' width=\"100%\" height=\"10%\">\n\t\t\t<tr>\n\t\t\t\t<td align=\'center\'><input width=\"100%\" height=\"10%\"\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" value=\"Insert\" onclick=\'insertSymbol();\'  />\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t\t<!--IN041022 Starts-->\n\t\t\t<SCRIPT LANGUAGE=\"JavaScript\">\n\nonLoadDefSymbol();</SCRIPT>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n<!--IN041022 Ends-->\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

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
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
21/05/2013		 IN030708	  Nijitha S			Bru-HIMS-CRF-221
29/05/2013		IN040304	  Karthi L			System is displaying the defined Symbols only once.
04/06/2013		IN040481	  Nijitha S			CRF-CA-Bru-HIMS-CRF-221/08-Record Clinical Notes->Symbols is not displayed completely
20/06/2013		IN041022			Nijitha S   CRF-CA-Bru-HIMS-CRF-221/11-System is not displaying error message 
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
18/02/2014	IN043895		Ramesh G		20/2/2014	    Chowminya		Clinical Notes is not correct for some of the Symbols which are loaded. 
04/06/2014	IN049424		Ramesh G 		04/06/2014		Akbar S			IN043895 Changes Reverted.
-----------------------------------------------------------------------------------------------------------------------------------------------------------
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
            _bw.write(_wl_block5Bytes, _wl_block5);
 
request.setCharacterEncoding("UTF-8");
//[IN035950] Starts
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String note_type				=	request.getParameter("note_type"); 
	String note_group				=	request.getParameter("note_group"); 
	String symbol_grp =  request.getParameter("symbol_group") == null? "" : request.getParameter("symbol_group");
	String symbol_group_desc =  request.getParameter("symbol_group_desc") == null? "" : request.getParameter("symbol_group_desc");
	List symbolsList = null;
	int noOfSymbols =0;
	int symbol_grp_count=0;
	int totalRows=0;
	String symbol="";
	String curr_symbol_grp_desc="";
	int index=0;
	int indicator=0;
	String buttonHidden="type='button'";
	ResultSet resultSet =null;
	Connection con = null;
	try
	{
		PreparedStatement pst = null;
		con = ConnectionManager.getConnection(request);
		StringBuilder symbolsQuery = new StringBuilder();
	
		//symbolsQuery.append("select sym.symbol,symgrp.symbol_group_desc FROM ca_symbol sym, ca_symbol_group symgrp WHERE sym.symbol_group = symgrp.symbol_group AND SYMBOL_GRP_NOTE IN (?,?) AND sym.EFF_STATUS='E' AND  symgrp.EFF_STATUS='E' group BY symgrp.symbol_group_desc,sym.symbol, symgrp.symbol_group order by symgrp.symbol_group_desc asc"); //commented for IN040304
		symbolsQuery.append("select sym.symbol,symgrp.symbol_group_desc FROM ca_symbol sym, ca_symbol_group symgrp WHERE sym.symbol_group = symgrp.symbol_group AND SYMBOL_GRP_NOTE IN (?,?) AND sym.EFF_STATUS='E' AND  symgrp.EFF_STATUS='E' group BY symgrp.symbol_group_desc,sym.symbol, symgrp.symbol_group,sym.SYMBOL_ID order by symgrp.symbol_group_desc asc"); //modified for IN040304		
		pst = con.prepareStatement(symbolsQuery.toString()); 
		pst.setString(1,note_group);
		pst.setString(2,note_type);
		resultSet = pst.executeQuery();
	
		
            _bw.write(_wl_block8Bytes, _wl_block8);

					String firstSysbol ="";//IN041022
					while(resultSet.next())
					{
						symbol_group_desc = resultSet.getString("symbol_group_desc");
						if(!curr_symbol_grp_desc.trim().equalsIgnoreCase(symbol_group_desc.trim()))
						{
						   index=0;
							
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(symbol_group_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);

						}
						curr_symbol_grp_desc =symbol_group_desc;								
						symbol = resultSet.getString("symbol");
						if(index==0 || index==10)
						{
							if(index==10)
							{
							index=0;//IN040481
							
            _bw.write(_wl_block11Bytes, _wl_block11);

						    }
							else
							{
							
            _bw.write(_wl_block12Bytes, _wl_block12);

							}
						}
						if(!"".equals(symbol))
						{
						//IN041022 Starts
						if("".equals(firstSysbol))
						firstSysbol =symbol;
						//IN041022 Ends
						out.println("<td nowrap style='width:20px;' style = 'cursor:pointer;' id='symbol"+indicator+"' class='grid1'  onClick='javascript:storeSelectedSymbol(\""+symbol+"\",\""+indicator+"\")' ondblclick='javascript:insertSymOnDBLclk(\""+symbol+"\")' > ");
						//IN043895 Start.
						//out.println("<font style='float:right;font-weight:bold;'>");
							//IN049424 Start.
							//out.println("<font face='\"Charis SIL\", \"Doulos SIL\", Gentium,\"Arial Unicode MS\"' style='float:right;font-weight:bold;'>");
							out.println("<font style='float:right;font-weight:bold;'>");
							//IN049424 End.
						//IN043895 End.						
						out.println(symbol);
						out.println("</font>");
						out.println("</td>");
						index++;
						indicator++;
						}
					}
					if(indicator==0){
						out.println("<table class='grid' width='100%' cellspacing='0' cellpadding='0'><tr><td class='gridData' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NODATAFOUND.label","ca_labels")+"</td></tr>");
						buttonHidden="type='hidden'";
					}
					
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(indicator));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(firstSysbol));
            _bw.write(_wl_block15Bytes, _wl_block15);

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		resultSet.close();
		ConnectionManager.returnConnection(con,request);
	}		
	
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(buttonHidden));
            _bw.write(_wl_block17Bytes, _wl_block17);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
