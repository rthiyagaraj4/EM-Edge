package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import eCA.ChartComponentFormulaBean;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __viewchartcomponentlist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ViewChartComponentList.jsp", 1743594577420L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t\t\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCA/js/ChartComponent.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\t\n\t\t<style>\t\t\n\t\tTD.columnfirstHeader{\n\t\t\tCOLOR: white ;\n\t\t\tbackground-color:#83AAB4;\t\t\n\t\t\tpadding-left:3px;\n\t\t\tfont-family: Verdana;\n\t\t\tfont-size: 10pt;\n\t\t\tfont-weight:bold;\t\t\t\n\n\t\t}\t\n\t\t\t\t\n\t\tTD.columnData{\n\t\t\tBACKGROUND-COLOR: white;\n\t\t\tCOLOR: black ;\n\t\t\tfont-family: Verdana;\n\t\t\tfont-size: 10pt;\n\t\t}\n\t\t\n\t</style>\n\t<script>\n\tfunction graphPram(sobj,mobj,pid,obj){\t\t\n\t\tvar formatId=obj.value;\t\t\n\t\tvar st = \"document.ViewChartComponentListForm.\"+pid+\"\";\n\t\tvar xScal = \"\";\n\t\tvar yScal = \"\";\n\t\tvar minY  = \"\";\n\t\tvar maxY  = \"\";\n\t\tvar disOr = \"\";\n\t\tif(formatId==\'G\'||formatId==\'T\'){\n\t\t\tvar seqNo= sobj.value;\t\t\t\n\t\t\tvar disMeaCode=mobj.value;\t\t\t\n\t\t\tvar viewChart=document.ViewChartComponentListForm.viewChart.value;\n\t\t\t\n\t\t\tvar query_string=\"SeqNo=\"+seqNo+\"&DisMeaCode=\"+disMeaCode+\"&ViewChart=\"+viewChart;\n\t\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\t\tvar xmlStr  = \"<root><SEARCH \";\n\t\t\txmlStr +=\" /></root>\";\n\t\t\tvar xmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\txmlHttp.open(\"POST\",\"ViewChartComponentGetData.jsp?\"+query_string, false ) ;\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\n\t\t\tif(trimString(xmlHttp.responseText)!=\"Error\")\n\t\t\t{\n\t\t\t\tvar result = trimString(xmlHttp.responseText);\t\t\t\t\n\t\t\t\tvar temp_result = result.split(\"|\");\n\t\t\t\txScal = trimString(temp_result[0]);\n\t\t\t\tyScal = trimString(temp_result[1]);\n\t\t\t\tminY  = trimString(temp_result[2]);\n\t\t\t\tmaxY  = trimString(temp_result[3]);\n\t\t\t\tdisOr  = trimString(temp_result[4]);\n\t\t\t}\n\t\t}\n\t\tif(formatId==\'G\'){\n\t\t\tdocument.getElementById(pid+\'t2\').innerHTML = \"<input type=\'text\' name=\'\"+pid+\"DisOrder\' id=\'\"+pid+\"DisOrder\' value=\'\"+disOr+\"\' onKeyPress=\\\"return CheckNumber(event);\\\" maxlength=\\\"3\\\" style=\\\"width:60px;\\\"/>\";\n\t\t\tdocument.getElementById(pid+\'t6\').innerHTML = \"<input type=\'text\' name=\'\"+pid+\"t6XS\' id=\'\"+pid+\"t6XS\' value=\'\"+xScal+\"\' onKeyPress=\\\"return CheckNumber(event);\\\" onblur=\\\"javascriopt:validateXScal(this)\\\" maxlength=\\\"2\\\" style=\\\"width:60px;\\\"/>\";\n\t\t\tdocument.getElementById(pid+\'t7\').innerHTML = \"<input type=\'text\' name=\'\"+pid+\"t7YS\' id=\'\"+pid+\"t7YS\' value=\'\"+yScal+\"\'  onKeyPress=\\\"return CheckFloat(event,this);\\\" onblur=\\\"javascriopt:valideateYScal(this,document.ViewChartComponentListForm.\"+pid+\"t8minY,document.ViewChartComponentListForm.\"+pid+\"t9maxY)\\\" maxlength=\\\"5\\\" style=\\\"width:60px;\\\"/>\";\n\t\t\tdocument.getElementById(pid+\'t8\').innerHTML = \"<input type=\'text\' name=\'\"+pid+\"t8minY\' id=\'\"+pid+\"t8minY\' value=\'\"+minY+\"\' onKeyPress=\\\"return CheckFloat(event,this);\\\" onblur=\\\"javascriopt:valideateYMin(document.ViewChartComponentListForm.\"+pid+\"t7YS,this,document.ViewChartComponentListForm.\"+pid+\"t9maxY)\\\"  maxlength=\\\"6\\\" style=\\\"width:60px;\\\"/>\";\n\t\t\tdocument.getElementById(pid+\'t9\').innerHTML = \"<input type=\'text\' name=\'\"+pid+\"t9maxY\' id=\'\"+pid+\"t9maxY\' value=\'\"+maxY+\"\' onblur=\\\"javascriopt:valideateYMax(document.ViewChartComponentListForm.\"+pid+\"t7YS,document.ViewChartComponentListForm.\"+pid+\"t8minY,this)\\\"  onKeyPress=\\\"return CheckFloat(event,this);\\\" maxlength=\\\"6\\\" style=\\\"width:60px;\\\"/>\";\t\n\t\t}else if(formatId==\'T\'){\n\t\t\tdocument.getElementById(pid+\'t2\').innerHTML = \"<input type=\'text\' name=\'\"+pid+\"DisOrder\' id=\'\"+pid+\"DisOrder\' value=\'\"+disOr+\"\' onKeyPress=\\\"return CheckNumber(event);\\\"  maxlength=\\\"3\\\" style=\\\"width:60px;\\\"/>\";\n\t\t\tdocument.getElementById(pid+\'t6\').innerHTML = \'\';\n\t\t\tdocument.getElementById(pid+\'t7\').innerHTML = \'\';\n\t\t\tdocument.getElementById(pid+\'t8\').innerHTML = \'\';\n\t\t\tdocument.getElementById(pid+\'t9\').innerHTML = \'\';\n\t\t}else{\n\t\t\tdocument.getElementById(pid+\'t2\').innerHTML = \'\';\n\t\t\tdocument.getElementById(pid+\'t6\').innerHTML = \'\';\n\t\t\tdocument.getElementById(pid+\'t7\').innerHTML = \'\';\n\t\t\tdocument.getElementById(pid+\'t8\').innerHTML = \'\';\n\t\t\tdocument.getElementById(pid+\'t9\').innerHTML = \'\';\n\t\t}\n\t}\n\tfunction validateXScal(obj){\t\t\n\t\tvar xScal=obj.value;\t\t\n\t\tif(xScal!=\"\" && xScal!=null){\t\t\t\n\t\t\tif( xScal<2 || xScal>23){\n\t\t\t\talert(\'X-Axis Interval value should be within range 2 to 23 hrs.\');\n\t\t\t\tobj.select();\n\t\t\t}\n\t\t}\n\t\t\n\t}\n\tfunction valideateYMax(ysObj,minObj,maxObj){\t\t\n\t\tvar yscal=parseFloat(trimString(ysObj.value));\n\t\tvar ymin =parseFloat(trimString(minObj.value));\t\t\n\t\tvar ymax =parseFloat(trimString(maxObj.value));\n\t\tvar errYscal = document.ViewChartComponentListForm.ErrYscal.value;\n\t\tvar errYmin = document.ViewChartComponentListForm.ErrYmin.value;\n\t\tif(errYscal==\"\" && errYmin==\"\" ){\n\t\t\tif(ymax!=\"\"){\n\t\t\t\tif(ymax<ymin){\n\t\t\t\t\tdocument.ViewChartComponentListForm.ErrYmax.value=\'Error\';\n\t\t\t\t\talert(\"Max Y-Axis value should be greater than Min Y-Axis value.\");\n\t\t\t\t\tmaxObj.select();\n\t\t\t\t\t\n\t\t\t\t}else if((ymax-ymin)<yscal) {\n\t\t\t\t\tdocument.ViewChartComponentListForm.ErrYmax.value=\'Error\';\n\t\t\t\t\talert(\"Max Y-Axis value should be greater than or equal to difference of Min Y-Axis value & Max Y-Axis value.\");\n\t\t\t\t\tmaxObj.select();\n\t\t\t\t}else{\n\t\t\t\t\tdocument.ViewChartComponentListForm.ErrYmax.value=\'\';\n\t\t\t\t}\n\t\t\t}\n\t\t\t\t\n\t\t}\n\t}\n\tfunction valideateYMin(ysObj,minObj,maxObj){\t\t\n\t\tvar yscal=parseFloat(trimString(ysObj.value));\n\t\tvar ymin =parseFloat(trimString(minObj.value));\t\t\n\t\tvar ymax =parseFloat(trimString(maxObj.value));\t\n\t\tvar errYscal = document.ViewChartComponentListForm.ErrYscal.value;\n\t\tvar errYmax = document.ViewChartComponentListForm.ErrYmax.value;\n\t\tif(errYscal==\"\" && errYmax==\"\" ){\n\t\t\tif(ymin!=\"\"){\n\t\t\t\tif(ymax!=\"\"){\n\t\t\t\t\tif(ymin>ymax){\n\t\t\t\t\t\tdocument.ViewChartComponentListForm.ErrYmin.value=\'Error\';\n\t\t\t\t\t\talert(\"Min Y-Axis value should be less than Max Y-Axis value.\");\n\t\t\t\t\t\tminObj.select();\n\t\t\t\t\t}else if(yscal!=\"\"){\n\t\t\t\t\t\tif((ymax-ymin)<yscal) {\n\t\t\t\t\t\t\tdocument.ViewChartComponentListForm.ErrYmin.value=\'Error\';\n\t\t\t\t\t\t\talert(\"Min Y-Axis value should be less than or equal to difference of Min Y-Axis value & Max Y-Axis value.\");\n\t\t\t\t\t\t\tminObj.select();\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse{\n\t\t\t\t\t\t\tdocument.ViewChartComponentListForm.ErrYmin.value=\'\';\n\t\t\t\t\t\t}\n\t\t\t\t\t}else{\n\t\t\t\t\t\tdocument.ViewChartComponentListForm.ErrYmin.value=\'\';\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\t\n\t\t}\n\t}\n\tfunction valideateYScal(ysObj,minObj,maxObj){\t\t\n\t\tvar yscal=parseFloat(trimString(ysObj.value));\n\t\tvar ymin =parseFloat(trimString(minObj.value));\t\t\n\t\tvar ymax =parseFloat(trimString(maxObj.value));\t\n\t\tvar errYmin = document.ViewChartComponentListForm.ErrYmin.value;\n\t\tvar errYmax = document.ViewChartComponentListForm.ErrYmax.value;\n\t\tif(errYmin==\"\" && errYmax==\"\" ){\n\t\t\tif(yscal!=\"\"){\n\t\t\t\tif(ymin!=\"\" && ymax!=\"\"){\t\t\t\t\n\t\t\t\t\tif((ymax-ymin)<yscal) {\n\t\t\t\t\t\tdocument.ViewChartComponentListForm.ErrYscal.value=\'Error\';\n\t\t\t\t\t\talert(\"Y-Axis Interval value should be less than or equal to difference of Min Y-Axis value & Max Y-Axis value.\");\n\t\t\t\t\t\tysObj.select();\n\t\t\t\t\t}else{\n\t\t\t\t\t\tdocument.ViewChartComponentListForm.ErrYscal.value=\'\';\n\t\t\t\t\t}\t\t\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t}\n\tfunction CheckNumber(event){\t\t\n\t\tvar strCheck = \'0123456789\';\n\t\tvar whichCode = (window.Event) ? event.which : event.keyCode;\t\t\n\t\tkey = String.fromCharCode(whichCode);  // Get key value from key code\t\t\n\t\tif (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\t\tif( (event.keyCode >= 97) && (event.keyCode <= 122) )\n\t\t\treturn (event.keyCode -= 32);\n\t\treturn true ;\n\t}\n\tfunction CheckFloat(event,obj){\t\t\n\t\tvar strCheck = \'0123456789.\';\n\t\tvar whichCode = (window.Event) ? event.which : event.keyCode;\t\t\n\t\tkey = String.fromCharCode(whichCode);  // Get key value from key code\t\t\n\t\tif (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\t\tif((((obj.value).split(\'.\')).length)>1 && (event.keyCode == 46)) return false;\t\t\n\t\tif( (event.keyCode >= 97) && (event.keyCode <= 122) )\n\t\t\treturn (event.keyCode -= 32);\t\t\n\t\treturn true ;\n\t}\t\n\t</script>\n\t</head>\n\t\n\t<body OnMouseDown=\"CodeArrest()\"  onKeyDown=\"lockKey()\">\t\n\t<form name=\'ViewChartComponentListForm\' id=\'ViewChartComponentListForm\' action=\'\' method=\'post\'>\t\n\t<TABLE width=\'100%\' height=\'100%\'  cellpadding=\'0\'  cellspacing=\'0\' border=\'0\' >\n\t\t<TR>\n\t\t<TD valign=\'top\' >\n\t\t\t<TABLE  class=\'grid\' border=\"1\" cellpadding=\"0\"  cellspacing=\"0\" width=\'100%\' >\n\t\t\t\t<TR>\n\t\t\t\t\t<!--<TD style=\'width:80px;\'  class=\'columnfirstHeader\'>Order Sequence No</TD>\n\t\t\t\t\t<TD  style=\'width:150px;\'  class=\'columnfirstHeader\'>Discrete Measure Code</TD> -->\n\t\t\t\t\t<TD  class = \'columnheadercenter\' rowspan=\"2\" >Chart Component</TD>\n\t\t\t\t\t<TD class = \'columnheadercenter\'  rowspan=\"2\" >Format</TD>\n\t\t\t\t\t<TD class = \'columnheadercenter\' rowspan=\"2\"  >Display Order<img SRC=\"../../eCommon/images/mandatory.gif\"></TD>\n\t\t\t\t\t<TD  colspan=\'4\' class = \'columnheadercenter\' align=\'center\'>Graph Details</TD>\n\t\t\t\t</TR>\n\t\t\t\t<TR>\n\t\t\t\t\t<TD   class = \'columnheadercenter\' >X-Axis Interval<img SRC=\"../../eCommon/images/mandatory.gif\"></TD>\n\t\t\t\t\t<TD   class = \'columnheadercenter\' >Y-Axis Interval<img SRC=\"../../eCommon/images/mandatory.gif\"></TD>\n\t\t\t\t\t<TD  class = \'columnheadercenter\' >Min Y-Axis Value<img SRC=\"../../eCommon/images/mandatory.gif\"></TD>\n\t\t\t\t\t<TD   class = \'columnheadercenter\' >Max Y-Axis Value<img SRC=\"../../eCommon/images/mandatory.gif\"></TD>\t\n\t\t\t\t</TR>\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\t\t\t\n\t\t\t\t\n\t\t\t</TABLE>\t\t\n\t\t</TD>\t\n\t\n\t\t\n\t</TR>\t\n\t</TABLE>\n\t<input type=\'hidden\' name=\'noOfRows\' id=\'noOfRows\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'/>\n\t<input type=\'hidden\' name=\'viewChart\' id=\'viewChart\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'/>\n\t<input type=\'hidden\' name=\'ErrYscal\' id=\'ErrYscal\' value=\'\'/>\n\t<input type=\'hidden\' name=\'ErrYmin\' id=\'ErrYmin\' value=\'\'/>\n\t<input type=\'hidden\' name=\'ErrYmax\' id=\'ErrYmax\' value=\'\'/>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t</form>\n\t</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

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
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
29/03/2012						Ramesh G		
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            eCA.ChartComponentResultsetBean recordsBean= null;synchronized(session){
                recordsBean=(eCA.ChartComponentResultsetBean)pageContext.getAttribute("recordsBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(recordsBean==null){
                    recordsBean=new eCA.ChartComponentResultsetBean();
                    pageContext.setAttribute("recordsBean",recordsBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
				
				Connection con = null;
				PreparedStatement psmt = null;
				ResultSet rset = null;
				int noOfRows = 0;
				//ArrayList grphValues=new ArrayList();
				String viewChartSearch = "";
				StringBuffer sb = new StringBuffer();
				try{
					con = ConnectionManager.getConnection();
					viewChartSearch=  request.getParameter("viewChartSearch")==null ? "" : request.getParameter("viewChartSearch");
					psmt = con.prepareStatement("SELECT CCSC.DISCR_DISP_ORDER_SEQ,CCSC.DISCR_MSR_ID,ADM.LONG_DESC ,CVCC.FORMAT_TYPE,CVCC.DISP_ORD_SEQ_NUM,CVCC.X_AXIS_SCALE,CVCC.Y_AXIS_SCALE,CVCC.MIN_Y_AXIS,CVCC.MAX_Y_AXIS FROM CA_CHART_SECTION_COMP CCSC JOIN AM_DISCR_MSR ADM ON ADM.DISCR_MSR_ID=CCSC.DISCR_MSR_ID LEFT JOIN CA_VIEW_CHART_CONFIG CVCC ON CVCC.CHART_ID=CCSC.CHART_ID AND CCSC.DISCR_MSR_ID=CVCC.DISCR_MSR_ID WHERE CCSC.DISCR_MSR_TYPE IN ('N', 'I') AND CCSC.CHART_ID=? ORDER BY CCSC.DISCR_DISP_ORDER_SEQ");
					psmt.setString(1,viewChartSearch);	
					rset = psmt.executeQuery();
					int r=0;
					while(rset.next())
					{	
						//ArrayList tempGraphData = new ArrayList();
						String order_seq = rset.getString("DISCR_DISP_ORDER_SEQ");
						String discr_msr_id = rset.getString("DISCR_MSR_ID");
						String discr_msr_name = rset.getString("LONG_DESC");
						String formatid = rset.getString("FORMAT_TYPE")==null ? "" : rset.getString("FORMAT_TYPE");
						String dis_ord_seq = rset.getString("DISP_ORD_SEQ_NUM")==null ? "" : rset.getString("DISP_ORD_SEQ_NUM");
						String xscal =  rset.getString("X_AXIS_SCALE")==null ? "" : rset.getString("X_AXIS_SCALE");
						String yscal = rset.getString("Y_AXIS_SCALE")==null ? "" : rset.getString("Y_AXIS_SCALE");
						String ymin = rset.getString("MIN_Y_AXIS")==null ? "" : rset.getString("MIN_Y_AXIS");
						String ymax = rset.getString("MAX_Y_AXIS")==null ? "" : rset.getString("MAX_Y_AXIS");

						/*tempGraphData.add(formatid);
						tempGraphData.add(xscal);
						tempGraphData.add(yscal);
						tempGraphData.add(ymin);
						tempGraphData.add(ymax);
						grphValues.add(tempGraphData);*/
						out.println("<TR id='r"+noOfRows+"'>");
												
						sb.append("<input type='hidden' name='r"+noOfRows+"OrderSeq' id='r"+noOfRows+"OrderSeq' value='"+order_seq+"'/>");						
						sb.append("<input type='hidden' name='r"+noOfRows+"DisMsrId' id='r"+noOfRows+"DisMsrId' value='"+discr_msr_id+"'/>");
						out.println("<TD id='r"+noOfRows+"t3' style='padding-left:5px;width:150px;' class='gridData'>"+discr_msr_name+"</TD>");
						out.println("<TD id='r"+noOfRows+"t4' style='width:150px;'  class='gridData'>");
						out.println("<select name='r"+noOfRows+"format' id='r"+noOfRows+"format' onChange=\"javascript:graphPram(document.ViewChartComponentListForm.r"+noOfRows+"OrderSeq,document.ViewChartComponentListForm.r"+noOfRows+"DisMsrId,'r"+noOfRows+"',this)\" >");
						out.println("<option value=''>-- Select --</option>");
						if("G".equals(formatid))
							out.println("<option value='G' selected >Graph</option>");
						else 
							out.println("<option value='G'>Graph</option>");
						if("T".equals(formatid))
							out.println("<option value='T' selected >Table</option>");
						else 
							out.println("<option value='T'>Table</option>");						
						
						out.println("</select>");
						out.println("</TD>");
						

						if("G".equals(formatid)){
							out.println("<TD id='r"+noOfRows+"t2'  class='gridData'><input type='text' name='r"+noOfRows+"DisOrder' id='r"+noOfRows+"DisOrder' value='"+dis_ord_seq+"' onKeyPress=\"return CheckNumber(event);\" maxlength=\"3\" style=\"width:60px;\"/></TD>");
							out.println("<TD id='r"+noOfRows+"t6'  nowrap='true' class='gridData' align='left' ><input type='text' name='r"+noOfRows+"t6XS' id='r"+noOfRows+"t6XS' value='"+xscal+"' onblur=\"javascript:validateXScal(this);\" onKeyPress=\"return CheckNumber(event);\" maxlength=\"2\" style=\"width:60px;\"/></TD>");
							out.println("<TD id='r"+noOfRows+"t7' nowrap='true' class='gridData' align='left' ><input type='text' name='r"+noOfRows+"t7YS' id='r"+noOfRows+"t7YS' value='"+yscal+"'   onblur=\"javascriopt:valideateYScal(this,document.ViewChartComponentListForm.r"+noOfRows+"t8minY,document.ViewChartComponentListForm.r"+noOfRows+"t9maxY)\" onKeyPress=\"return CheckFloat(event,this);\" maxlength=\"5\" style=\"width:60px;\"/></TD>");
							//out.println("<TD id='r"+noOfRows+"t8'  nowrap='true' class='gridData' align='left' ><input type='text' name='r"+noOfRows+"t8minY' id='r"+noOfRows+"t8minY' value='"+ymin+"'  onblur=\"javascriopt:valideateYMin(document.ViewChartComponentListForm.r"+noOfRows+"t7YS,this,document.ViewChartComponentListForm.r"+noOfRows+"t9maxY)\" onKeyPress=\"return CheckFloat(event,this);\" maxlength=\"6\" style=\"width:60px;\"/></TD>");
							out.println("<TD id='r"+noOfRows+"t8'  nowrap='true' class='gridData' align='left' ><input type='text' name='r"+noOfRows+"t8minY' id='r"+noOfRows+"t8minY' value='"+ymin+"'  onblur=\"javascriopt:valideateYMin(document.ViewChartComponentListForm.r"+noOfRows+"t7YS,this,document.ViewChartComponentListForm.r"+noOfRows+"t9maxY)\"  onKeyPress=\"return CheckFloat(event,this);\" maxlength=\"6\" style=\"width:60px;\"/></TD>");
							out.println("<TD id='r"+noOfRows+"t9' nowrap='true' class='gridData' align='left' ><input type='text'  name='r"+noOfRows+"t9maxY' id='r"+noOfRows+"t9maxY' value='"+ymax+"' onblur=\"javascriopt:valideateYMax(document.ViewChartComponentListForm.r"+noOfRows+"t7YS,document.ViewChartComponentListForm.r"+noOfRows+"t8minY,this)\" onKeyPress=\"return CheckFloat(event,this);\" maxlength=\"6\" style=\"width:60px;\"/></TD>");
						}else if("T".equals(formatid)){
							out.println("<TD id='r"+noOfRows+"t2'  class='gridData'><input type='text' name='r"+noOfRows+"DisOrder' id='r"+noOfRows+"DisOrder' value='"+dis_ord_seq+"' onKeyPress=\"return CheckNumber(event);\" maxlength=\"3\" style=\"width:60px;\"/></TD>");
							out.println("<TD id='r"+noOfRows+"t6'  nowrap='true' class='gridData' align='left' >&nbsp;</TD>");
							out.println("<TD id='r"+noOfRows+"t7' nowrap='true' class='gridData' align='left' >&nbsp;</TD>");
							out.println("<TD id='r"+noOfRows+"t8'  nowrap='true' class='gridData' align='left' >&nbsp;</TD>");
							out.println("<TD id='r"+noOfRows+"t9' nowrap='true' class='gridData' align='left' >&nbsp;</TD>");
						}else{
							out.println("<TD id='r"+noOfRows+"t2'  nowrap='true' class='gridData' align='left' >&nbsp;</TD>");
							out.println("<TD id='r"+noOfRows+"t6'  nowrap='true' class='gridData' align='left' >&nbsp;</TD>");
							out.println("<TD id='r"+noOfRows+"t7' nowrap='true' class='gridData' align='left' >&nbsp;</TD>");
							out.println("<TD id='r"+noOfRows+"t8'  nowrap='true' class='gridData' align='left' >&nbsp;</TD>");
							out.println("<TD id='r"+noOfRows+"t9' nowrap='true' class='gridData' align='left' >&nbsp;</TD>");

						}
						out.println("</TR>");
						
						

						noOfRows++;
					}					
				}catch(Exception e){					
					System.out.println(e);					
				}finally{
					if(psmt!=null)psmt.close();
					if(rset!=null) rset.close();
					if(con!=null) ConnectionManager.returnConnection(con,request);					
				}

			  
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( noOfRows));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( viewChartSearch));
            _bw.write(_wl_block11Bytes, _wl_block11);

	out.println(sb.toString());
	
            _bw.write(_wl_block12Bytes, _wl_block12);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ChartComponentList.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
