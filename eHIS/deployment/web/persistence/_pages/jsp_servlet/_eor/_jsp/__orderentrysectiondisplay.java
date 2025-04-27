package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __orderentrysectiondisplay extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntrySectionDisplay.jsp", 1737957776000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t <html>\n\t <head><title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/></link>\n  \t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n  \t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n  \t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntry.js\"></script>\n  \t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntrySearch.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n  \t<STYLE TYPE=\"text/css\">\t</STYLE>\n   \t<script>\n\t\tvar rows_cnt=0;\n\t\tvar cell_cnt=0;\n\n\t\tfunction rowCountChange(obj)\n\t\t{\n\t\t\trows_cnt=obj.rowIndex;\n\t\t}\n\n\t\tfunction changeColor(obj) //changes by Anbarasi\n\t\t{\n\t\t\tcell_cnt=obj.cellIndex;\n\t\t\tconsole.log(cell_cnt);\n\t\t\t var table = document.getElementById(\"tab\");\n\t\t\tfor (var t1 = 0; t1 < table.rows.length; t1++) {\n\t\t\t\tvar row = table.rows[t1];\n\n\t\t\t\t\t// Loop through the cells of the current row\n\t\t\tfor (var t2 = 0; t2 < row.cells.length; t2++) {\n\t\t\t\tvar cell = row.cells[t2];\n\t\t\t\t\t if (cell && cell.innerText.trim() !== \'\') \n\t\t\t\t\t {\n                cell.className = \"CAFIRSTSELECTHORZ\"; // Apply class\n\t\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\t//obj.className=\"CAFIRSTSELECTHORZ\"//IN043253\n\t\t\tobj.className=\"CAHIGHERLEVELCOLOR\"//IN043253\n\t\t}\n\n\t\tfunction selectCell()\n\t\t{\n\t\t\tif(document.getElementById(\"tab\").rows[0])\n\t\t\t{\n\t\t\t\tif(document.getElementById(\"tab\").rows[0].cells[0])\n\t\t\t\t\t//document.getElementById(\"tab\").rows(0).cells(0).className=\"CAFIRSTSELECTHORZ\"//IN043253\n\t\t\t\t\tdocument.getElementById(\"tab\").rows[0].cells[0].className=\"CAHIGHERLEVELCOLOR\"//IN043253\n\t\t\t}\n\t\t}\n\t</script>\n\t</head>\n\t<body onLoad=\'selectCell()\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t<form name=\'sectionForm\' id=\'sectionForm\'>\n\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'99.9%\' id=\'tab\' align=\"center\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\t\t\t\t\n\t\t\t\t<tr width=\"100%\" onClick=\"rowCountChange(this)\">\n\t\t\t\t\t<td width=\"19%\" class=\"CAFIRSTSELECTHORZ\" nowrap  onClick=\"changeColor(this)\"><!-- IN043253 -->\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t//IN038787 Start.\n\t\t\t\t\t\t\t//parent.criteriaTickSheetsFrame.location.href=\"../../eOR/jsp/OrderEntryTickSheetPanels.jsp?order_type=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&order_category=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&activity_type=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&tick_sheet_id=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&section_code=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&bean_id=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&bean_name=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&priv_applicability_yn=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&function_from=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"; \n\t\t\t\t\t\t\tparent.criteriaTickSheetsFrame.location.href=\"../../eOR/jsp/OrderEntryTickSheetPanels.jsp?order_type=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&order_dispaly_verticalYN=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"; \n\t\t\t\t\t\t\t//IN038787 End.\n\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t<td  width=\"19%\" class=\"CAFIRSTSELECTHORZ\" nowrap  onClick=\"changeColor(this)\"><!-- IN043253 -->\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\n\t\t\t<a CLASS=\"HIGHERLEVELLINK\"  style=\'color:white;cursor:pointer;height:20px;\' href=\'javascript:populateTickSheets(\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\",\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\");\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</a> </td>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t</tr>\n\t\t<script>\n\t\t\t//IN047581 added else if condition for <10 >5 condition\n\t\t\tif(";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" >= 10) //Changed IN043253.1\n\t\t\t{\n\t\t\t\t//IN043253 - Start\n\t\t\t\tparent.document.getElementById(\"OrderEntryFrameset\").rows = \"19%,10%,*\"; //IN047581.1\n\t\t\t\t\n\t\t\t\t//parent.document.getElementById(\"OrderEntryFrameset\").rows = \"19%,9%,*\";\n\t\t\t\t//IN043253 - End\n\t\t\t}\n\t\t\telse if(";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" < 10 &&  ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" > 5)\n\t\t\t{\n\t\t\t\tparent.document.getElementById(\"OrderEntryFrameset\").rows = \"19%,11%,*\";\n\t\t\t}else\n\t\t\t//\tparent.document.getElementById(\"OrderEntryFrameset\").rows = \"19%,5.5%,*\";\n\t\tparent.document.getElementById(\"criteriaMainFrame\").style.height=\"17vh\";\n\t\tparent.document.getElementById(\"criteriaDetailFrame\").style.height=\"6vh\";\n\t\tparent.document.getElementById(\"criteriaTickSheetsFrame\").style.height=\"74vh\";\n\n\n\t\t</script>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t</table>\n\t</form>\n\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t<input type=\"hidden\" name=\"function_from\" id=\"function_from\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t<input type=\"hidden\" name=\"order_dispaly_verticalYN\" id=\"order_dispaly_verticalYN\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"> <!--  IN038787  -->\n\t</body>\t\n</html>\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );
	
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

/*
--------------------------------------------------------------------------------------------------------------
Date       	Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
11/09/2013  IN043253	 	Chowminya	Ticksheet has more than 5 sections in it, the 6th section onwards displays below and it is hidden
16/09/2013  IN043253.1  	Chowminya	Ticksheet display fails when 10 section was used
01/12/2013	IN038787		Ramesh G			Bru-HIMS-CRF-358
13/03/2014	IN047581		Chowminya	Reduce space between Tick Sheet Section and Order Catalog
-----------------------------------------------------------------------
*/

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id 		= request.getParameter("bean_id");
	String bean_name 	= request.getParameter("bean_name");
	/* Mandatory checks end */
	/* Initialize Function specific start */
	//OrderEntryBean bean = (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	OrderEntryBean bean	  = (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	/* Initialize Function specific end */
	String order_category	= bean.checkForNull(request.getParameter("order_category"),"");
	String order_type		= bean.checkForNull(request.getParameter("order_type"),"");
	String activity_type	= bean.checkForNull(request.getParameter("activity_type"),"");
	String tick_sheet_id	= bean.checkForNull(request.getParameter("tick_sheet_id"),"");
	String function_from		= bean.checkForNull(request.getParameter("function_from"),"");
	String priv_applicability_yn	= bean.checkForNull(request.getParameter("priv_applicability_yn"),"");
	String  order_dispaly_verticalYN			= request.getParameter("order_dispaly_verticalYN")==null?"N":(String)request.getParameter("order_dispaly_verticalYN");  //IN038787
	// Set to the bean
	bean.setOrderCategoryValue(order_category);
	bean.setOrderTypeValue(order_type);
	int i = 0;

            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	try
	{
		ArrayList SectionDisplay = bean.getSectionPopulate(order_category,tick_sheet_id,order_type);

		for(int j=0; j<SectionDisplay.size(); j++)
		{
			String[] record = (String[])SectionDisplay.get(i);

			if(i == 0)
			{

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(order_type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(activity_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(tick_sheet_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(priv_applicability_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(order_type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(activity_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(tick_sheet_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(priv_applicability_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(order_dispaly_verticalYN));
            _bw.write(_wl_block21Bytes, _wl_block21);

			} 
			else 
			{  

            _bw.write(_wl_block22Bytes, _wl_block22);
						
			}							

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(order_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(tick_sheet_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(activity_type));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(priv_applicability_yn));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(order_dispaly_verticalYN));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block26Bytes, _wl_block26);

			i++;
			if( i %5 == 0)
			{
				out.print( "</td></tr> <tr width='100%' onClick=\"rowCountChange(this)\">" ); //rowChange
			}
		} // End of For

		if( i % 5 > 0)
		{
			for (int u=0;u<5-i%5;u++)
				out.println("<td width='19%' class=\"white\" align=\"left\">&nbsp;&nbsp;</td>");
		}

		if(SectionDisplay.size()==0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script> ");
		}


            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(SectionDisplay.size()));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(SectionDisplay.size()));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(SectionDisplay.size()));
            _bw.write(_wl_block30Bytes, _wl_block30);

	} catch(Exception e)
	{
		//out.println("Exception Section"+e.toString());//COMMON-ICN-0181
                  e.printStackTrace();//COMMON-ICN-0181
	}

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(order_dispaly_verticalYN));
            _bw.write(_wl_block35Bytes, _wl_block35);

	// set it back persistence, few set Methods have been used, to set the value in the bean
	putObjectInBean(bean_id,bean,request);


            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.SearchForOrderingPractitioner.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
