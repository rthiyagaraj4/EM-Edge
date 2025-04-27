package jsp_servlet._exi._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.util.*;
import eXH.XHDBAdapter;
import eXH.XHUtil;
import eXI.MonitorItemsBean;
import java.util.*;
import com.ehis.util.*;

public final class __monitoritemsmorecriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exi/jsp/MonitorItemsMoreCriteria.jsp", 1709122568894L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\t\t\t\t\t\t  \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link> \n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\"javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\t\n<script language=\"javascript\" src=\"../../eXI/js/MonitorItems.js\" ></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eXH/js/InterfaceUtil.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<body onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\'>\n\t<form name=\"searchCriteria\" id=\"searchCriteria\" method=\"GET\">\n\n\t<fieldset style=\" border-color:black;\">\n\t\n\t<table  border=\'0\' id=\'staticFieldTab\' width=\'100%\'>\n\t<TR>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<th colspan=\"4\">\n\t\t\tProcessed Records Search Criteria\n\t\t</th>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t</TR>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<tr ID=\"transDateTR\">\n\t\t\t<td class=\'LABEL\' align=\'center\'>\n\t\t\t\tTransaction Date\n\t\t\t</td>\n\t\t\t<td class=\'LABEL\' align=\'center\' colspan=\'2\'>\n\t\t\t\tFrom \n\t\t\t\t<input type=\'text\' name=\'dateFrom\' id=\'dateFrom\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' size=\'11\' onBlur=\'isAfterCurrDate(this);\'> \n\t\t\t\t<input type=\'image\' src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'dateFrom\',\'dd/mm/y\');\">\n\t\t\t\tTo:\n\t\t\t\t<input type=\'text\' name=\'dateTo\' id=\'dateTo\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' size=\'11\' onBlur=\'isAfterCurrDate(this);\'> \n\t\t\t\t<input type=\'image\' src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'dateTo\',\'dd/mm/y\');\">\n\t\t\t</td>\n\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t</tr><tr>\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<td class=\'LABEL\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t<td class=\'FIELDS\'>\n\t\t\t\t<SELECT name=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' id=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' ID=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' style=\"width: 150px\">\n\t\t\t\t\t<OPTION value=\"\">All</OPTION>\n\t\t\t\t\t<OPTION value=\"N\">New</OPTION>\n\t\t\t\t\t<OPTION value=\"S\">Success</OPTION>\n\t\t\t\t\t<OPTION value=\"M\">Master Error</OPTION>\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t<OPTION value=\"E\">Error</OPTION>\n\t\t\t\t\t<OPTION value=\"U\">Update</OPTION>\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t</SELECT>\n\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' style=\"width: 150px\">\n\t\t\t\t\t<OPTION value=\"\">All</OPTION>\n\t\t\t\t\t<OPTION value=\"N\">Pending</OPTION>\n\t\t\t\t\t<OPTION value=\"S\">Success</OPTION>\n\t\t\t\t\t<OPTION value=\"E\">Error</OPTION>\t\t\t\n\t\t\t\t</SELECT>\n\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t<td class=\'FIELDS\'>\n\t\t\t\t<input type=\'text\' name=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' value=\'\' size=\'11\' onBlur=\"xhBeforeNow(this,\'DMY\');\"> \n\t\t\t\t<input type=\'image\' src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\',\'dd/mm/y\');\">\n\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t<td class=\'FIELDS\'>\n\t\t\t\t<INPUT TYPE=\'text\' name=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' style=\"width: 150px\">\n\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t</tr>\n\t</table>\n\t<table border=\'0\' align=\'right\'>\n\t\t <tr>\n\t\t\t<td>\n\t\t\t\t<input type=\'button\' value=\'Export\' ID=\"export2Excel\" name =\'export2Excel\' onclick=\'exportData()\'>&nbsp;\n\t\t\t\t<input type=\'button\' value=\'Search\' name =\'btnSearch\' onclick=\'displayData()\'>&nbsp;\n\t\t\t</td>\n\t\t</tr> \n\t</table>\n\t</fieldset>\n\t <INPUT TYPE=\"hidden\" id=\"operation\" name=\"operation\" id=\"operation\" value=\"\">\n\t <INPUT TYPE=\"hidden\" id=\"tableName\" name=\"tableName\" id=\"tableName\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t <INPUT TYPE=\"hidden\" id=\"queueType\" name=\"queueType\" id=\"queueType\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t <INPUT TYPE=\"hidden\" id=\"functionID\" name=\"functionID\" id=\"functionID\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t <INPUT TYPE=\"hidden\" id=\"locale\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t</form>\t\t\t\t\t\t\t\t\t\t    \n</body>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n</html>\n\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

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
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";	
	String locale = ((String)session.getAttribute("LOCALE"));

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

try
{
	Properties prop = (Properties)session.getValue("jdbc");
	MonitorItemsBean monitorItemsBean = new MonitorItemsBean();
	String functionID = XHDBAdapter.checkNull(request.getParameter("funcID"));
	String queueType = XHDBAdapter.checkNull(request.getParameter("queueType"));
	String dispColName = "";

	String tableName = monitorItemsBean.getFuncTableName(functionID, queueType);	
	List<String> tabIndexColList = MonitorItemsBean.getIndexColList(functionID, prop);
	String strDate = XHUtil.getFormattedStringDate("dd/MM/yyyy", new Date());

            _bw.write(_wl_block8Bytes, _wl_block8);
 if("XF_DF_HEALTHCAREDELIVERY".equals(tableName)) { 
            _bw.write(_wl_block9Bytes, _wl_block9);
 } 
            _bw.write(_wl_block10Bytes, _wl_block10);
		
			if(tabIndexColList != null && tabIndexColList.contains("TRX_DATE"))
			{
		
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( strDate ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( strDate ));
            _bw.write(_wl_block13Bytes, _wl_block13);

			}
			if(tabIndexColList != null && tabIndexColList.size() > 0)
			{
				int trCounter = 2; // Variable used to create new <TR> for every two <TD>s
				for(String colName: tabIndexColList)
				{
					dispColName = MonitorItemsBean.getDispName(colName);
					
					if(trCounter == 2)
					{
						trCounter = 0;
		
            _bw.write(_wl_block14Bytes, _wl_block14);
			}
					if("RECORD_STATUS".equals(colName))
					{
		
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( dispColName ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( colName ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( colName ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf( colName ));
            _bw.write(_wl_block19Bytes, _wl_block19);

				if(!"XI_MANUFACTURER_IB".equals(functionID) && !"XI_TRADECODE_IB".equals(functionID)
						&& !"XI_ITEM_IB".equals(functionID) && !"XI_ITEM_STORE_BIN_LOCN_IB".equals(functionID)
						&& !"XI_ITEM_UOM_DEFN_IB".equals(functionID) && !"XI_SUPPLIER_IB".equals(functionID))
				{
			
            _bw.write(_wl_block20Bytes, _wl_block20);

				}
			
            _bw.write(_wl_block21Bytes, _wl_block21);

				}
				else if("WS_STATUS".equals(colName))
				{
		
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( dispColName ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( colName ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( colName ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf( colName ));
            _bw.write(_wl_block22Bytes, _wl_block22);

				}
				else if("TRXDATETIME".equals(colName))
				{
		
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( dispColName ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf( colName ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( colName ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf( colName ));
            _bw.write(_wl_block25Bytes, _wl_block25);

				}
				else if(!"TRX_DATE".equals(colName))
				{
		
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( dispColName ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( colName ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( colName ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf( colName ));
            _bw.write(_wl_block27Bytes, _wl_block27);

				}
			if(!"TRX_DATE".equals(colName))	trCounter++;
			}
			}
		
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( tableName ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf( queueType ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf( functionID ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf( locale ));
            _bw.write(_wl_block32Bytes, _wl_block32);

}
catch(Exception exp)
{
	exp.printStackTrace(System.err);
}

            _bw.write(_wl_block33Bytes, _wl_block33);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
