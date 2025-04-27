package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __sectionchartlist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/SectionChartList.jsp", 1732506743753L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<!-- Added by Arvind @ 08-12-08 -->\n\t\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/SectionChart.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n</head>\n<body   OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" OnScroll=\"scrollTitle()\" >\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\n\t<form name=\"sectionChartResultForm\" id=\"sectionChartResultForm\">\n<div id=\'divDataTitle\' style=\'postion:relative\'>\n\t <table   border=\'1\' width=\'100%\' id=\'dataTitleTable\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\'>\t\n\t\t\t<tr><th class=\'columnheader\' colspan=\'3\' width=\'20%\' align=\'left\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th></tr>\n\t\t\t<tr align=\'left\'><th class=\'columnheadercenter\' width=\'10%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t\t\t<th class=\'columnheadercenter\' width=\'50%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t\t<th class=\'columnheadercenter\' width=\'15%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th></tr>\t\n\t</table>\n </div>\n ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<table  class=\'grid\' align=\'center\' width=\"100%\"  >\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tgetChartCodeOnClick(parent.sectionChartHeaderFrame.document.sectionChartHeaderForm.chartDesc);\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<tr id =\"trRowId";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t\t\t\t\t\t\t\t<td width=\'20%\'class=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'  style=\'display:none\'> <input type=\'hidden\' name=\'seq_num";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' id=\'seq_num";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\t\t\t\t\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td  class=\'gridNumericData\' width=\'10%\' align=\'right\'> <a class=\'gridLink\'  href=\"javascript:changeSeq(\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\',\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\')\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" </a></td>\n\t\t\t\t\t\t\t\t\t<td width=\'50%\'\n\t\t\t\t\t\t\t\t\tclass=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\t\n\t\t\t\t\t\t\t\t\t<td width=\'15%\'  class=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'selectYN";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' id=\'selectYN";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' OnClick =\'removeRow(";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =")\' ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =">\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t</tr>\t\t\n\t\t\t\t\t\t\t\t\t<input type =\'hidden\' name=\'sectionCode";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' id=\'sectionCode";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t\t<tr style=\'display:none\' id=\'extraRow\'><td  id=\'extraTD\'><a class=\'gridLink\'  href=\"javaScript:changeSeq(\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t</a></td><td></td><td ></td></tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t<tr id =\'trRowId";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\t\t\t  <td width=\'20%\' class=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\t\t\t\t\n\t\t\t\t  </td>\n\t\t\t\t  \n\t\t\t\t  <td class=\'gridNumericData\'  width=\'10%\'  align=\'right\'> <a class=\'gridLink\'  href=\"javascript:changeSeq(\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\')\"> ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" </a></td>\n\t\t\t\t  <td width=\'50%\' class=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>\n\t\t\t\t  <td width=\'15%\'   class=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t\t\t  <input type=\'checkbox\' name=\'selectYN";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' value=\'Y\' OnClick =\'removeRow(";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =">\n\t\t\t\t  </td>\n\t\t\t</tr>\t\t\t\t\t\t\t\n\t\t\t<input type =\'hidden\' name=\'sectionCode";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t<tr style=\'display:none\' id=\'extraRow\'>\n\t\t\t\t<td ><a class=\'gridLink\'  href=\"javaScript:changeSeq(\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</a></td>\n\t\t\t</tr>\n\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n</table>\n\n\t<input type =\'hidden\' name=\'finalString\' id=\'finalString\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>     \n\t<input type =\'hidden\' name=\'array_length\' id=\'array_length\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'> \n\t<input type =\'hidden\' name=\'chartId\' id=\'chartId\' value=\'\'> \n\t<input type =\'hidden\' name=\'operation\' id=\'operation\' value=\'\'> \n\t<input type =\'hidden\' name=\'remove_value\' id=\'remove_value\' value=\'\'> \n\t<input type=\'hidden\' name=\'firstPos\' id=\'firstPos\' value=\'\'>\n\t<input type=\'hidden\' name=\'secPos\' id=\'secPos\' value=\'\'>\n\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\t\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );
	
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
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String operation = request.getParameter("operation") == null ? "" : request.getParameter("operation");
String tempfinalString = "";
String flag_for_list = request.getParameter("flag_for_list") == null ? "false" : request.getParameter("flag_for_list");
String tempRowCount = request.getParameter("rowCount") == null ? "0" : request.getParameter("rowCount");
int tempIntRowCount = Integer.parseInt(tempRowCount);
String firstPosition = request.getParameter("firstPosition") == null ? "0" : request.getParameter("firstPosition");
String secondPosition = request.getParameter("secondPosition") == null ? "0" : request.getParameter("secondPosition");

int i=0;

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCA.SectionChartBean bean = (eCA.SectionChartBean)getObjectFromBean("bean","eCA.SectionChartBean",session);

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

	 Connection con			= null;
	StringTokenizer tokenizeTilde = null;
	StringTokenizer tokenizePipe = null;
	String finalString = "";
	String classValue = "";
	String description = "";
	String searchText = request.getParameter("chartDesc");	
	String seq_num = "";
	String sectionCode = "";
	String flagY = "";
	//String discreteMeasureid = "";
	String chartId = request.getParameter("chartId") == null ? "" :  request.getParameter("chartId");
	String subString = "";
	int slno = 1;
	int rowCount= 0;
	//String operation = request.getParameter("operation") == null ? "" : request.getParameter("operation");

	try
	{
		con = ConnectionManager.getConnection(request);
		if(searchText==null || searchText.equals("")||searchText.equals("%"))
				searchText = "%";
		else
			searchText = searchText.toUpperCase() +"%";
 
            _bw.write(_wl_block13Bytes, _wl_block13);

		if(!operation.equals("split"))
		{		
			
			ArrayList retArray1 = bean.getQueryForChart(chartId,searchText,con);
			if(retArray1 != null)
			{
				if(chartId.equals(""))
					{
					
            _bw.write(_wl_block14Bytes, _wl_block14);

					}
				else
					{
					ArrayList arrayDesc = (ArrayList)retArray1.get(0);
					bean.setConcatenatedString("");
					ArrayList  discreteMeasureId  = (ArrayList)retArray1.get(2);
					ArrayList orderSeqNo = (ArrayList)retArray1.get(1);
					ArrayList flag = (ArrayList)retArray1.get(3);
					bean.setLength(arrayDesc.size());
					for(i = 0;i<arrayDesc.size();i++)
						{
							if(((String)flag.get(rowCount)).equals("Y"))
								{
									classValue ="gridData";// (rowCount % 2 ==0) ? "gridData" : "gridData";
									
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((String)orderSeqNo.get(rowCount)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((String)orderSeqNo.get(rowCount)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf((String)orderSeqNo.get(rowCount)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf((String)arrayDesc.get(rowCount)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((String)flag.get(rowCount)));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
out.println("checked");
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf((String)discreteMeasureId.get(rowCount)));
            _bw.write(_wl_block33Bytes, _wl_block33);
	
									rowCount++;					
									slno++;
								}
						}
								
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(slno));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(slno));
            _bw.write(_wl_block35Bytes, _wl_block35);
 	
					}
			}
		}
	else
		{			
		ArrayList orderSeqNo = new ArrayList();
		ArrayList arrayDesc = new ArrayList();
		ArrayList  discreteMeasureId  = new ArrayList();
		ArrayList flag = new ArrayList();
		ArrayList orderSeqNoList = new ArrayList();
		ArrayList arrayDescList = new ArrayList();
		ArrayList  discreteMeasureIdList  = new ArrayList();
		ArrayList flagList = new ArrayList();
		ArrayList indexList = new ArrayList();
		int positionOne = Integer.parseInt(firstPosition);
		positionOne = positionOne - 1;
		int positionTwo = Integer.parseInt(secondPosition);	
		positionTwo = positionTwo - 1;
		int totalRows = tempIntRowCount;
		String flag1 = "";
		String desc = "";
		String ordSeq = "";
		String discrt = "";
		if(!flag_for_list.equals("false"))
			{
			if(totalRows < positionTwo)
			positionTwo = positionTwo -1;
			else
			positionTwo = positionTwo;
			finalString = request.getParameter("finalString") == null? "" :request.getParameter("finalString");
			tokenizeTilde = new StringTokenizer(finalString,"~");
			if(!finalString.equals(""))
				{
				while(tokenizeTilde.hasMoreTokens())
					 {
						subString = tokenizeTilde.nextToken();
						tokenizePipe =  new StringTokenizer(subString,"||");
						description =tokenizePipe.nextToken();
						sectionCode = tokenizePipe.nextToken();
						seq_num = tokenizePipe.nextToken();
						flagY = tokenizePipe.nextToken();
						
						arrayDescList.add(description);
						discreteMeasureIdList.add(sectionCode);
						orderSeqNoList.add(seq_num);
						flagList.add(flagY);
					 }
						indexList.add(0,arrayDescList);
						indexList.add(1,orderSeqNoList);
						indexList.add(2,discreteMeasureIdList);
						indexList.add(3,flagList);
						bean.setArrayList(indexList);
						putObjectInBean("bean",bean,session);	
				}
				ArrayList list = bean.retrieveArrayList();
				arrayDesc = (ArrayList)list.get(0);
				orderSeqNo = (ArrayList)list.get(1);
				discreteMeasureId = (ArrayList)list.get(2);
				flag = (ArrayList)list.get(3);
				int j;
				for(j=0;j<orderSeqNo.size();j++)
					{	
						ordSeq= (String)orderSeqNo.get(j);
						desc= (String)arrayDesc.get(j);
						discrt= (String)discreteMeasureId.get(j);
						flag1= (String)flag.get(j);
						if(positionOne == j)
							{	
							arrayDesc.add(positionTwo,desc);
							discreteMeasureId.add(positionTwo,discrt);
							flag.add(positionTwo,flag1);
							if(positionTwo > positionOne)
								{
									j = orderSeqNo.size();
									
								}
							if(positionTwo > positionOne)
								{
									arrayDesc.remove(positionOne);
									discreteMeasureId.remove(positionOne);
									flag.remove(positionOne);
								}
						   else
								{
									arrayDesc.remove(positionOne + 1);
									discreteMeasureId.remove(positionOne + 1);
									flag.remove(positionOne + 1);
								}	
							}
					}
					list.add(0,arrayDesc);
					list.add(1,orderSeqNo);
					list.add(2,discreteMeasureId);
					list.add(3,flag);
					bean.setArrayList(list);
					putObjectInBean("bean",bean,session);	
					tempfinalString  = (String)bean.setFinalString(list);
			}
					
			String tempValue = request.getParameter("tempValue") == null ? "" : request.getParameter("tempValue");
				if(tempValue.equals("temp"))
					{
						finalString = request.getParameter("finalString") == null? "" :request.getParameter("finalString");
					}
				else
					{
								
						finalString = tempfinalString;
					}
				bean.setConcatenatedString(finalString);
				bean.setLength(0);
				tokenizeTilde = new StringTokenizer(finalString,"~");
				classValue = "gridData";
				while(tokenizeTilde.hasMoreTokens())
				 {
					//classValue = ((rowCount%2)==0 )? "QRYEVEN" : "QRYODD";
					subString = tokenizeTilde.nextToken();
					tokenizePipe =  new StringTokenizer(subString,"||");
					description =tokenizePipe.nextToken();
					sectionCode = tokenizePipe.nextToken();
					seq_num = tokenizePipe.nextToken();
					if(seq_num.equalsIgnoreCase("null"))
					{
						seq_num="";
					}

	
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(seq_num));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(seq_num));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(seq_num));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(description));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block29Bytes, _wl_block29);
out.println("checked");
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(sectionCode));
            _bw.write(_wl_block45Bytes, _wl_block45);
			rowCount++;		
				}
	
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rowCount+1));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rowCount+1));
            _bw.write(_wl_block47Bytes, _wl_block47);

		}
	
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(finalString));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(rowCount));
            _bw.write(_wl_block50Bytes, _wl_block50);

	putObjectInBean("bean",bean,session);	


	}
	catch(Exception ee)
	{
		//out.println("Exception in SectionChartList Block: "+ ee.toString());//common-icn-0181
		ee.printStackTrace();
	}
	finally
	{
		if(con != null) ConnectionManager.returnConnection(con);
	}

            _bw.write(_wl_block51Bytes, _wl_block51);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Selected.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Section.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderSrlNo.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SectionDescription.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
