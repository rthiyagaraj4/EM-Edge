package jsp_servlet._ebt._jsp;

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
import java.util.*;
import com.ehis.util.*;

public final class __btrrdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebt/jsp/BTRRDetail.jsp", 1742377693971L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<style>\nthead tr\t{\nposition:relative; \ntop: expression(offsetParent.scrollTop); /*IE5+ only*/\n}\n</style>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\n<script src=\'../../eCommon/js/rowcolor.js\' language=\'javascript\'></SCRIPT>\n\n\n<Script Language=\"JavaScript\" src=\"../../eBT/js/BTMaster.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eBT/js/BTMessage.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n\n<script Language=\"JavaScript\">\n\nvar flag=0;\nfunction showToolLinks(obj,objVal,objVal1)\n{\n\n\tvar tabdata = \"<html><head><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></head>\"+\n\t\"<body><table cellpadding=0 cellspacing=0 border=1 bordercolor=BLACK>\"+\t\t\t\t\t  \n\t\"<tr><td class=SENPAT nowrap>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td><td class=SENPAT nowrap>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td></tr><tr><td class=SENPAT nowrap>\";\n\n\tif(flag==0)\n\t{\n\t\ttabdata =tabdata+objVal+\"</td><td class=SENPAT nowrap>\"+objVal1+\"</td></tr></table></body></html>\";\n\t\tdocument.getElementById(\'toolLink\').innerHTML = tabdata;\n\t\tdocument.getElementById(\'toolLink\').style.top  = obj.offsetTop+50;\n\t\tdocument.getElementById(\'toolLink\').style.left  = obj.offsetLeft+50 ;\n\t\tdocument.getElementById(\'toolLink\').style.visibility=\'visible\';\n\t\tflag=1;\n\t}\n\telse\n\t{\n\t\tdocument.getElementById(\'toolLink\').style.visibility=\'hidden\' ;\n\t\tflag=0;\n\t}\n}\n\n\nfunction collectAllSelection(frmObj)\n{\n\tvar objStr=\"\";\n\n\tfor(kk=0;kk<frmObj.length;kk++)\n\t{\t\n\t\tif(frmObj[kk].type==\'checkbox\') \n\t\t{\n\t\t\tif( frmObj[kk].checked==true) \t\t    objStr=objStr+frmObj[kk].name+\",\";\n\t\t}\n\t}\n\treturn objStr;\n}\n\n\nfunction onRecordButton(obButton)\n{\n\t\n\t\n\tvar objFrm=parent.parent.message_search_frame.document.forms[0];\n\tvar objDetail=document.forms[0];\n\tvar objStr;\n\n\n\tobjFrm.FID.value = document.forms[0].facility.value;\n\tif(obButton.name==\'Reqprint\')\t\n\t{\n\t\tobjFrm.PRINT_MODE.value=\'REQUEST\';\t\n\t\tobjStr=objFrm.CHECKBOX_SEL.value\n\t}\n\telse\n\t{\n\t\tobjFrm.PRINT_MODE.value=\'REPRINT\';\t\n\t\tobjStr=objFrm.CHECKBOX_PRINT.value\n\t}\t\n\n\tvar objArr=new Array();\n\tobjArr=objStr.split(\',\');\n\t\n\t//BT0222,RECORD_SELECT\n\n\tif(obButton.name==\'Reqprint\' && (objStr==null || objStr.length==0)) \n\t{\n\t\t//alert(getBTMessage(\'BT0222\',\'BT\'));\n\t\talert(getBTMessage(\'BT0524\',\'BT\'));\n\t\tparent.location.reload(true);\n\t\tobjFrm.CHECKBOX_SEL.value=\'\';\n\t\tobjFrm.CHECKBOX_PRINT.value=\'\';\n\t\treturn;\n\t}\n\tif(obButton.name==\'Reprint\' && (objStr==null || objStr.length==0)) \n\t{\n\t\talert(getBTMessage(\'BT0224\',\'BT\'));\n\t\tparent.location.reload(true);\n\t\tobjFrm.CHECKBOX_SEL.value=\'\';\n\t\tobjFrm.CHECKBOX_PRINT.value=\'\';\n\t\treturn;\n\t}\n\n\t//P denote Request Print  denote R Reprint\n\tif(obButton.name==\'Reqprint\')\tobjFrm.PRINT_MODE.value=\'REQUEST\';\t\n\telse  \n\tobjFrm.PRINT_MODE.value=\'REPRINT\';\t\n\t//\talert(objStr);\n\n\tvar data = funBTMasterDetailXMLSubmit(objFrm,objDetail,objArr);\n\n\n\n\tvar xmlDoc=\"\";\n\tvar xmlHttp = new XMLHttpRequest();\n\t//alert(\"BTRRDetail.jsp data:\"+data);\n\txmlDoc.loadXML(data);\n\txmlHttp.open(\"POST\", \"../../servlet/eBT.BTRRUpdateServlet\", false);\n\txmlHttp.send(xmlDoc);\n\t//var resTxt=xmlHttp.responseText;//Sanjay\n\t//alert(\'BTRRDetail.jsp resTxt:\' + resTxt);\n\n\n\t//BT0208, COMPLETED\t\n\talert(getBTMessage(\'BT0208\',\'BT\'));\n\t//parent.window.close();\n\t//parent.window.reFresh();\n\tparent.location.reload(true);\n\tobjFrm.CHECKBOX_SEL.value=\'\';\n\tobjFrm.CHECKBOX_PRINT.value=\'\';\n\n}\n\nfunction funPrint(obj)\n{\n\tvar obValue;\n\tvar objFrm=parent.parent.message_search_frame.document.forms[0];\n\tvar objStr=objFrm.CHECKBOX_PRINT.value;\t\n\n\tif(obj.checked==true)\n\t{\t\n\t\tobValue = obj.name;\n\t\tobValue = obValue.substring(1,obValue.length)+\",\";\n\t\tif(objStr.length > 0)\tobValue=objStr+obValue;\n\t\tobjFrm.CHECKBOX_PRINT.value=obValue;\n\t}  \n\telse\n\t{\n\t\tobValue = obj.name;\n\t\tobValue = obValue.substring(1,obValue.length)+\",\";\n\t\tobValue=objStr.replace(obValue,\"\");\t\n\t\tobjFrm.CHECKBOX_PRINT.value=obValue;\n\t}\n\t//alert(obValue);\n}\n\n\nfunction fun(obj)\n{\n\tvar obValue;\n\tvar objFrm=parent.parent.message_search_frame.document.forms[0];\n\tvar objStr=objFrm.CHECKBOX_SEL.value;\t\n\n\tif(obj.checked==true)\n\t{\t\n\t\tobValue=obj.name+\",\";\n\t\tif(objStr.length > 0)\tobValue=objStr+obValue;\n\t\tobjFrm.CHECKBOX_SEL.value=obValue;\n\t}  \n\telse\n\t{\n\t\tobValue=objStr.replace(obj.name+\",\",\"\");\n\t\tobjFrm.CHECKBOX_SEL.value=obValue;\n\t}\n\t//alert(obValue);\n}\n\nfunction submitFormN()\n{\n\tvar from = new Number(document.forms[0].from.value );\n\tvar to = new Number(document.forms[0].to.value );\n\tvar maxval = new Number(document.forms[0].max_records.value );\t\t\n\n\tdocument.forms[0].from.value = from + maxval;\n\tdocument.forms[0].to.value = to + maxval;\n\tdocument.forms[0].submit();\n}\nfunction submitFormP()\n{\n\tvar from = new Number(document.forms[0].from.value );\n\tvar to = new Number(document.forms[0].to.value );\n\tvar maxval = new Number(document.forms[0].max_records.value );\n\tdocument.forms[0].from.value = from - maxval;\n\tdocument.forms[0].to.value = to - maxval;\n\tdocument.forms[0].submit();\n}\n</script>\n\n\n<style>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\tTD.";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="{\n\t\t\tBACKGROUND-COLOR:";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =";\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\tBORDER-STYLE: solid;\n\t\t\tBORDER-BOTTOM: #CC9966 0px solid;\n\t\t\tBORDER-LEFT: #CC9966 0px solid;\n\t\t\tBORDER-RIGHT: #CC9966 0px solid;\n\t\t\tBORDER-TOP: #CC9966 1px solid;\n\t\t}\n\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n\t</style>\n\n\t</head>\n\n\t<body>\n\t<form name=\'form_query1\' id=\'form_query1\' RECORD_ID_NAME=\'ROWID\' DETAIL_BLOCK_NAME=\'BTTable\' method=\'post\' action=\'BTRRDetail.jsp\'>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\n\n\t<!--\t<table align=\'center\' width=\'100%\' >\n\t<THEAD>\n\n\t<tr> \n\n\t<td class=\'GREEN\' align=\'right\' width=\'5%\'>&nbsp;</td>\n\t<td class=\'label\' align=\'left\' width=\'25%\' >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t<td class=\'Brown\' align=\'right\' width=\'5%\'>&nbsp;</td>\n\t<td class=\'label\' align=\'left\' width=\'25%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t<td  align=\'left\' width=\'30%\'>\n\t<input type=\'button\' name=\'Reqprint\' id=\'Reqprint\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'  class=\'button\' onClick=\'onRecord(this)\'>\n\t<input type=\'button\' name=\'Reprint\' id=\'Reprint\'  value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' class=\'button\' onClick=\'onRecord(this)\' >\t\t\n\t</td>\t\n\n\t</tr>\n\t</THEAD>\n\t</table>\n\t-->\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\n\t<input type=\'hidden\' name=\'from\' id=\'from\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t<input type=\'hidden\' name=\'to\' id=\'to\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t<input type=\'hidden\' name=\'column_sizes\' id=\'column_sizes\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t<input type=\'hidden\' name=\'column_descriptions\' id=\'column_descriptions\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t<input type=\'hidden\' name=\'sql\' id=\'sql\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t<input type=\'hidden\' name=\'max_records\' id=\'max_records\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t<input type=\'hidden\' name=\'pid\' id=\'pid\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t<input type=\'hidden\' name=\'fid\' id=\'fid\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t<input type=\'hidden\' name=\'opt\' id=\'opt\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\t\t\n\t<input type=\'hidden\' name=\'facility\' id=\'facility\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\n</form>\n<div id=\'toolLink\' style=\'position:absolute; visibility:hidden;overflow:overflow\'>\n</div>\n\n</body>\n</html>\n\n\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

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
	request.setCharacterEncoding("UTF-8");	
            _bw.write(_wl_block2Bytes, _wl_block2);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block2Bytes, _wl_block2);
 String locale = ((String)session.getAttribute("LOCALE"));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
	Connection conn=null;
PreparedStatement pstmt=null;
CallableStatement cstmt=null;
ResultSet rs=null;

/* Below two lines added by Sanjay for ML-MMOH-CRF-0404 on 15-Oct-15 */
PreparedStatement pstmtXMatchDesc=null;
ResultSet rsXMatchDesc=null;

String strColumnDelimiter = ",";
int max_records = 15;		
String desc_data="";
String  strPlus="";

String login_user;
Properties p=null;
HttpSession httpSession = request.getSession(false);
p = (Properties)httpSession.getValue("jdbc"); 
login_user =  p.getProperty("login_user");
String strColorInd="";
String strStageCode="";
String strResultString="";
StringTokenizer strToken=null;
StringTokenizer strSubToken=null;
//		int j = 0;
int i = 0;

Vector vectorColumnSizes = new Vector();
Vector vectorColumnDescriptions = new Vector();
Vector vectorHtmlData = new Vector(10,2);
int start = 0,end = 0;
int intFetchedRecords = 0;
String strFacilityId="";

try
{
	conn = ConnectionManager.getConnection(request);



	cstmt=conn.prepareCall("{ call BT_CONSUMBTION_COLOR(?,?,?,?,?,?,?,?)}");

	cstmt.setString(1,"0");
	cstmt.setString(2,"0");
	cstmt.setString(3,"0");
	cstmt.setString(4,"0");			
	cstmt.setString(5,"2");
	cstmt.setString(6,"0");			
	cstmt.registerOutParameter(7,Types.VARCHAR);
	cstmt.registerOutParameter(8,Types.VARCHAR);
	
	cstmt.execute();
	strResultString = cstmt.getString(7);
	

	
	strToken=new StringTokenizer(strResultString,"#");

	while(strToken.hasMoreElements())
	{			
		strSubToken=new StringTokenizer(strToken.nextToken(),"@");
		while(strSubToken.hasMoreElements())
		{		
			strColorInd=strSubToken.nextToken();
			strStageCode=strSubToken.nextToken();
		}		
		
		
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strStageCode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strColorInd));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);

	max_records = (request.getParameter("max_records")== null) ? 50:Integer.parseInt(request.getParameter("max_records"));
	String pid    = request.getParameter( "pid" ) ;
	String fid    = request.getParameter( "fid" ) ;
	String opt	  = request.getParameter( "opt" ) ;
	//		String objstr = request.getParameter("objstr");
	// Below line commented by Sanjay for ML-MMOH-CRF-0404 on 15-Oct-15
	//String sql ="SELECT A.ROWID REC_ID1,A.patient_id PATIENT_ID1,NVL(to_char(A.REQUEST_FOR_ISSUE_DATE,'dd/mm/yyyy hh24:mi'),'') REQ_DATE1,NVL(TO_CHAR(E.TRANSFUSE_EXPECT_DATE_TIME,'dd/mm/yyyy hh24:mi:ss'),'') TRANS_EXP_DATE,NVL(TO_CHAR(F.SPEC_REGD_DATE_TIME,'dd/mm/yyyy hh24:mi:ss'),'') SPEC_REG_DATE1, A.specimen_no SPECIMEN_NO1,D.short_Desc PRODUCT_DESC1,C.operating_facility_id OPERATING_FACILITY_ID1, NVL(to_char(A.reserved_date,'dd/mm/yyyy hh24:mi:ss'),'') RESERVED_DATE1,A.issued_date ISSUED_DATE1,A.unit_no UNIT_NO1, A.product_code PRODUCT_CODE1, B.blood_group BLOOD_GROUP1, B.rhesus_code RHESUS_CODE1, A.unit_status UNIT_STATUS1, DECODE(NVL(A.REQUEST_FOR_ISSUE_BY,'0'),'0','GREEN','BROWN') COLR1,DECODE(NVL(A.REQUEST_FOR_ISSUE_BY,'0'),'0','UNCHECKED','CHECKED') CHK1,A.request_for_issue_by REQUEST_FOR_ISSUE_BY1 FROM BT_UNIT_REQUEST_DTL A, BT_BLOOD_UNITS_MAST B, BT_OUTSTAND_SPECIMENS_VW C,BT_PRODUCT_MAST_LANG_VW D,BT_UNIT_REQUEST_CATEGORY E,BT_UNIT_REQUEST_HDR F WHERE ";

	// Below lines added by Sanjay for ML-MMOH-CRF-0404 on 15-Oct-15
	//String sql ="SELECT A.ROWID REC_ID1,A.patient_id PATIENT_ID1,NVL(to_char(A.REQUEST_FOR_ISSUE_DATE,'dd/mm/yyyy hh24:mi'),'') REQ_DATE1,NVL(TO_CHAR(E.TRANSFUSE_EXPECT_DATE_TIME,'dd/mm/yyyy hh24:mi:ss'),'') TRANS_EXP_DATE,NVL(TO_CHAR(F.SPEC_REGD_DATE_TIME,'dd/mm/yyyy hh24:mi:ss'),'') SPEC_REG_DATE1, A.specimen_no SPECIMEN_NO1,D.short_Desc PRODUCT_DESC1,C.operating_facility_id OPERATING_FACILITY_ID1, NVL(to_char(A.reserved_date,'dd/mm/yyyy hh24:mi:ss'),'') RESERVED_DATE1,A.issued_date ISSUED_DATE1,A.unit_no UNIT_NO1, A.product_code PRODUCT_CODE1, B.blood_group BLOOD_GROUP1, B.rhesus_code RHESUS_CODE1, A.unit_status UNIT_STATUS1, DECODE(NVL(A.REQUEST_FOR_ISSUE_BY,'0'),'0','GREEN','BROWN') COLR1,DECODE(NVL(A.REQUEST_FOR_ISSUE_BY,'0'),'0','UNCHECKED','CHECKED') CHK1,A.request_for_issue_by REQUEST_FOR_ISSUE_BY1, a.xmatch_act_result_status XMATCH_RESULT_STATUS1 FROM BT_UNIT_REQUEST_DTL A, BT_BLOOD_UNITS_MAST B, BT_OUTSTAND_SPECIMENS_VW C,BT_PRODUCT_MAST_LANG_VW D,BT_UNIT_REQUEST_CATEGORY E,BT_UNIT_REQUEST_HDR F WHERE ";
	String sql ="SELECT A.ROWID REC_ID1,A.patient_id PATIENT_ID1,NVL(to_char(A.REQUEST_FOR_ISSUE_DATE,'dd/mm/yyyy hh24:mi'),'') REQ_DATE1,NVL(TO_CHAR(E.TRANSFUSE_EXPECT_DATE_TIME,'dd/mm/yyyy hh24:mi:ss'),'') TRANS_EXP_DATE,NVL(TO_CHAR(F.SPEC_REGD_DATE_TIME,'dd/mm/yyyy hh24:mi:ss'),'') SPEC_REG_DATE1, A.specimen_no SPECIMEN_NO1,D.short_Desc PRODUCT_DESC1,C.operating_facility_id OPERATING_FACILITY_ID1, NVL(to_char(A.reserved_date,'dd/mm/yyyy hh24:mi:ss'),'') RESERVED_DATE1,A.issued_date ISSUED_DATE1,A.unit_no UNIT_NO1, A.product_code PRODUCT_CODE1, B.blood_group BLOOD_GROUP1, B.rhesus_code RHESUS_CODE1, A.unit_status UNIT_STATUS1, DECODE(NVL(A.REQUEST_FOR_ISSUE_BY,'0'),'0','GREEN','BROWN') COLR1,DECODE(NVL(A.REQUEST_FOR_ISSUE_BY,'0'),'0','UNCHECKED','CHECKED') CHK1,A.request_for_issue_by REQUEST_FOR_ISSUE_BY1, (select DEC_UNIT_STATUS_DESC from BT_DECODED_UNIT_STATUS where DEC_UNIT_STATUS_CODE = a.DECODED_UNIT_STATUS) XMATCH_STATUS FROM BT_UNIT_REQUEST_DTL A, BT_BLOOD_UNITS_MAST B, BT_OUTSTAND_SPECIMENS_VW C,BT_PRODUCT_MAST_LANG_VW D,BT_UNIT_REQUEST_CATEGORY E,BT_UNIT_REQUEST_HDR F WHERE ";
	
	//String sqlXMatchDesc = "select UNIT_STATUS_DESC from bt_unit_status where UNIT_STATUS_CODE=? and rownum=1";
	
	// Commented by Sanjay on 28-Nov-14 against ML-BRU-SCF-1449 IN052212. Commented C.ORDERED_FACILITY_ID
	//sql = sql +"  A.PATIENT_ID='"+pid+"' and C.ORDERED_FACILITY_ID='"+fid+"' and A.unit_no = B.unit_no AND A.product_code = B.product_code AND NVL(A.unit_status, 'UO') IN ('UR') AND NVL(A.reserved_date, SYSDATE) >= SYSDATE AND A.operating_facility_id = C.operating_facility_id AND C.specimen_no = A.specimen_no AND d.product_Code = a.product_Code and d.language_id = '"+locale+"' and  F.specimen_no = A.specimen_no and F.patient_id = A.patient_id and F.operating_facility_id = C.operating_facility_id and B.operating_facility_id = C.operating_facility_id AND C.patient_id = A.patient_id and E.specimen_no= A.specimen_no and e.product_code =a.product_code and e.patient_id = a.patient_id and E.operating_Facility_id = C.operating_facility_id ";

	sql = sql +"  A.PATIENT_ID='"+pid+"' and A.unit_no = B.unit_no AND A.product_code = B.product_code AND NVL(A.unit_status, 'UO') IN ('UR') AND NVL(A.reserved_date, SYSDATE) >= SYSDATE AND A.operating_facility_id = C.operating_facility_id AND C.specimen_no = A.specimen_no AND d.product_Code = a.product_Code and d.language_id = '"+locale+"' and  F.specimen_no = A.specimen_no and F.patient_id = A.patient_id and F.operating_facility_id = C.operating_facility_id and B.operating_facility_id = C.operating_facility_id AND C.patient_id = A.patient_id and E.specimen_no= A.specimen_no and e.product_code =a.product_code and e.patient_id = a.patient_id and E.operating_Facility_id = C.operating_facility_id ";


	if(opt.equals("RN")==true) 			sql=sql+" and A.REQUEST_FOR_ISSUE_BY is Null ORDER BY A.reserved_date";
	else
	if(opt.equals("RA")==true)			sql=sql+" and A.REQUEST_FOR_ISSUE_BY is Not Null  ORDER BY A.reserved_date";
	else
	sql = sql+"  ORDER BY A.reserved_date";


	String from = request.getParameter( "from" ) ;

	String to = request.getParameter( "to" ) ;
	
	

	boolean calling_from_main =  true;

	if ( (from == null) && ( to == null) )
	{
		calling_from_main = true;
	}
	else
	{
		calling_from_main = false;
	}

	from = (from == null) ? "0":from;

	to = (to == null) ? max_records+"":to;

	String column_descriptions = request.getParameter("column_descriptions");

	column_descriptions = (column_descriptions == null) ? "":column_descriptions;

	//eBT.LogFile.log("QADebugger","Column Desc"+column_descriptions,this);

	String column_sizes = request.getParameter("column_sizes");
	column_sizes = (column_sizes == null) ? "":column_sizes;


	//	System.err.println(" EBT columnsize"+column_sizes);
	//  System.err.println(" EBT columndesc"+column_descriptions);
	//  System.err.println(" EBT sql="+sql1);

	//eBT.LogFile.log("QADebugger","ColumnSize "+column_sizes,this);


	StringTokenizer strTokenizer = null;
	strTokenizer = new StringTokenizer(column_sizes,strColumnDelimiter);
	i = 0;
	while(strTokenizer.hasMoreTokens())
	{
		vectorColumnSizes.insertElementAt( strTokenizer.nextToken(),i);
		++i;
	}

	strTokenizer = null;
	strTokenizer = new StringTokenizer(column_descriptions,strColumnDelimiter);
	i = 0;
	while(strTokenizer.hasMoreTokens())
	{
		vectorColumnDescriptions.insertElementAt( strTokenizer.nextToken(),i);
		++i;
	}

	start = Integer.parseInt(from) ;
	end  = Integer.parseInt(to);
	if (start<=0) from = "0";

	try
	{
		String row = "<tr style='background-color:;'>";
		String evn = "<td class='QRYEVEN'";
		String odd = "<td class='QRYODD'";
		String strHtmlData = "";
		//String strTempColumnType = "";
		//Dhana
		String strClickEvent = " onClick=fun(this) ";
		String strPatientId = "";
		String strSpecimenNo="";
		String strUnitNo="";
		String strProductCode= "";
		String strBloodGroup="";
		String strRhesusCode="";
		String strChk="";
		String strColr="";
		String tagHtml="";
		String strIssuedDate="";
		String strIssuedBy="";
		String strEnabled="";	
		String strReqDate="";
		String strTransExpectDate="";
		String strReservedDate="";
		String strSpecRegdDate="";
		String strUnitStatus="";
		String strDonateType="";
		String strProductDesc="";
		String rec_id;
		int intTempStart = start;
		// Below 3 lines added by Sanjay for ML-MMOH-CRF-0404 on 15-Oct-15
		String strXMatchResultStatus = "";
		//String strXMatchResultStatusDesc = "";
		//pstmtXMatchDesc = conn.prepareStatement(sqlXMatchDesc);

		//System.out.println("BTRRDetail.jsp sql:" +sql);
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		vectorHtmlData.add("<table border='1' width='100%' cellspacing='0' cellpadding='0' id='tb1' class='scrollTable'>");
		//eBT.LogFile.log("QADebugger","Finish 2",this);
		vectorHtmlData.add("<THEAD>");
		for(i=0;i<vectorColumnSizes.size();i++)
		{			
			if( i == 1)
			{
				vectorHtmlData.add("<td class='columnheader' width='"+vectorColumnSizes.get(i)+"%'></td>");
			}
			else
			{
				try
				{
					desc_data=""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,""+vectorColumnDescriptions.get(i),"bt_labels");
				}
				catch(Exception e1)
				{
					desc_data = "";
				}
				vectorHtmlData.add("<td class='columnheader'			width='"+vectorColumnSizes.get(i)+"%'>"+desc_data+"</td>");
			}
		}
		vectorHtmlData.add("</THEAD>");
		while(rs.next())
		{


			/*	if (!(intTempStart<=0))
					{
						--intTempStart;
						continue;
					}*/
			++intFetchedRecords;

			vectorHtmlData.add(row);					


			strPatientId = rs.getString("PATIENT_ID1");

			//eBT.LogFile.log("QADebugger","PatientId"+strPatientId,this);

			strFacilityId=rs.getString("OPERATING_FACILITY_ID1");
			//eBT.LogFile.log("QADebugger","PatientId"+strFacilityId,this);

			
			strSpecimenNo=rs.getString("SPECIMEN_NO1"); 		
			//eBT.LogFile.log("QADebugger","PatientId"+strSpecimenNo,this);

			strUnitNo = rs.getString("UNIT_NO1");

			//eBT.LogFile.log("QADebugger","PatientId"+strUnitNo,this);

			strProductCode =rs.getString("PRODUCT_CODE1");
			strProductDesc =rs.getString("PRODUCT_DESC1");

			//eBT.LogFile.log("QADebugger","PatientId"+strProductCode,this);


			strBloodGroup=rs.getString("BLOOD_GROUP1");

			// Below two lines added by Sanjay for ML-MMOH-CRF-0404 on 25-11-2015
			strXMatchResultStatus=rs.getString("XMATCH_STATUS");
			strXMatchResultStatus=strXMatchResultStatus==null?"":strXMatchResultStatus;

			//eBT.LogFile.log("QADebugger","PatientId"+strBloodGroup,this);

			strRhesusCode=rs.getString("RHESUS_CODE1");      
			//eBT.LogFile.log("QADebugger","PatientId"+strRhesusCode,this);

			strUnitStatus=rs.getString("UNIT_STATUS1");
			strUnitStatus=strUnitStatus==null?"":strUnitStatus;


			strColr=rs.getString("COLR1");
			//eBT.LogFile.log("QADebugger","PatientId"+strColr,this);


			strChk=rs.getString("CHK1");
			//eBT.LogFile.log("QADebugger","PatientId"+strChk,this);
			//strChk = "UNCHECKED";
			rec_id=rs.getString("REC_ID1");
			//eBT.LogFile.log("QADebugger","PatientId"+rec_id,this);

			
			strIssuedDate=rs.getString("ISSUED_DATE1");
			//eBT.LogFile.log("QADebugger","PatientId"+strIssuedDate,this);

			strIssuedBy=rs.getString("REQUEST_FOR_ISSUE_BY1");


			

			strReservedDate=com.ehis.util.DateUtils.convertDate(rs.getString("RESERVED_DATE1"),"DMYHMS","en",locale);
			strSpecRegdDate=com.ehis.util.DateUtils.convertDate(rs.getString("SPEC_REG_DATE1"),"DMYHMS","en",locale);


			//eBT.LogFile.log("QADebugger","PatientId"+strIssuedBy,this);

			strEnabled=(strChk.equals("CHECKED")==true)?"disabled":"";
			
			//strEnabled="";

			//eBT.LogFile.log("QADebugger","PatientId"+strEnabled,this);

			// strTransExpectDate=rs.getString("TRANS_EXP_DATE");
			strTransExpectDate=com.ehis.util.DateUtils.convertDate(rs.getString("TRANS_EXP_DATE"),"DMYHMS","en",locale);


			//				strReqDate=rs.getString("REQ_DATE1");
			//              strReqDate=(strReqDate==null)?"":strReqDate;
			strReqDate=com.ehis.util.DateUtils.convertDate(rs.getString("REQ_DATE1"),"DMYHM","en",locale);
			//				strReqDate=com.ehis.util.DateUtils.convertDate(rs.getString("REQ_DATE1"),"DMYHMS","en",locale);
			
			// Dhana Color Indication
			try{

				cstmt.setString(1,strUnitNo);
				cstmt.setString(2,strSpecimenNo);
				cstmt.setString(3,strProductCode);
				cstmt.setString(4,strUnitStatus);
				cstmt.setString(5,"0");
				cstmt.setString(6,strFacilityId);
				cstmt.registerOutParameter(7,Types.VARCHAR);
				cstmt.registerOutParameter(8,Types.VARCHAR);			
				cstmt.execute();			            

				strPlus  =  cstmt.getString(7);
				strDonateType = cstmt.getString(8);
				
				
				
				if(strPlus.equals("0")==true)
				strPlus = "LABELCENTER";
				if(strDonateType.equals("N")==true)
				strDonateType ="LABELCENTER";

				/*	if(strDonateType.equals("5")==true) 
			{
				strDonateType = "E";
				strPlus = "T";
			}
			else if(strDonateType.equals("6")==true) 
			{
				strDonateType = "E";
				strPlus = "D";
			}
			else if((strDonateType.equals("D")==true) || (strDonateType.equals("T")==true))
			{								
				strPlus = strDonateType;
					strDonateType = "LABELCENTER";
			}
			else if(strDonateType.equals("0")==true)
			{
					strDonateType ="LABELCENTER";
			}*/
			}
			catch(Exception sqlE)
			{
				strDonateType = "0";
			}

			if (intFetchedRecords%2 == 0)
			{
				strHtmlData =  evn ;
			}
			else
			{
				strHtmlData = odd;
			}
			// Added by Sanjay for ML-MMOH-CRF-0404 on 15-Oct-15 STARTS
			/*
			if (strXMatchResultStatus.length() > 0)
			{
				try
				{				
					//sqlXMatchDesc = "select UNIT_STATUS_DESC from bt_unit_status where UNIT_STATUS_CODE='"+strXMatchResultStatus+"' and rownum=1";
					//pstmtXMatchDesc = conn.prepareStatement(sqlXMatchDesc);
					//System.out.println("BTRRDetail.jsp sqlXMatchDesc:"+sqlXMatchDesc+":strXMatchResultStatus:"+strXMatchResultStatus);//Sanjay
					pstmtXMatchDesc.setString(1, strXMatchResultStatus);
					rsXMatchDesc = pstmtXMatchDesc.executeQuery();
					while(rsXMatchDesc.next())
					{
						strXMatchResultStatusDesc=rsXMatchDesc.getString(1);
						strXMatchResultStatusDesc=strXMatchResultStatusDesc==null?"":strXMatchResultStatusDesc;
					}
				}
				catch(Exception sqlE)
				{
					strXMatchResultStatusDesc="";
					//System.out.println("Ex in BTRRDetail.jsp:"+sqlE);
				}
				/* Commented by Sanjay against Linked Incident BT-ML-MMOH-CRF-0404-01[IN058480] Original Incident ML-MMOH-CRF-0404 on 17-11-2015
				finally
				{
					pstmtXMatchDesc.close();
					rsXMatchDesc.close();
				}
				*/
			//}			
			// Added by Sanjay for ML-MMOH-CRF-0404 on 15-Oct-15 ENDS


			tagHtml="<td align='center' class='"+strColr+"'>&nbsp;</td>";

			if(strChk.equals("CHECKED")==true)	
			tagHtml=tagHtml+"<td align='center' class ="+strPlus+" OnClick=\"showToolLinks(this,'"+strIssuedBy+"','"+strReqDate+"');\"><b  style='cursor:pointer'>+</b></td>";
			else	
			tagHtml+="<td align='center' class ="+strPlus+" >&nbsp;</td>";



			//Dhana Color indication in blood unit

			if(strDonateType.equals("N")==true)
			{

				tagHtml=tagHtml+strHtmlData+" align='center' ><b class='label'>"+strUnitNo+"&nbsp;</b><input type='hidden'name='UNIT_NO' value="+strUnitNo+" REC_ID='"+rec_id+"'></td>";			

			}
			else
			{
				tagHtml=tagHtml+"<td class="+strDonateType+"   ><b class='WHITE'>"+strUnitNo+"&nbsp;</b><input type='hidden'name='UNIT_NO' value="+strUnitNo+" REC_ID='"+rec_id+"'></td>";
				//tagHtml="<td class="+strDonateType+"  align='center' ><b class='WHITE'>"+strSpecimenNo+"</b></td>";			
			}
			tagHtml=tagHtml+strHtmlData+" align='center' ><b class='label'>"+strSpecimenNo+"&nbsp;</b></td>";
			tagHtml=tagHtml+strHtmlData+" align='center' ><b class='label'>"+strReservedDate+"&nbsp;</b></td>";
			tagHtml=tagHtml+strHtmlData+" align='center' ><b class='label'>"+strSpecRegdDate+"&nbsp;</b></td>";
			tagHtml=tagHtml+strHtmlData+" align='center' ><b class='label'>"+strProductDesc+		
			"</b><input type='hidden'name='PRODUCT_CODE' value="+strProductCode+" REC_ID='"+rec_id+"'></td>";

			/*
			tagHtml=tagHtml+strHtmlData+" align='center' ><b class='label'>"+strBloodGroup+"&nbsp;</b></td>";
			tagHtml=tagHtml+strHtmlData+" align='center' ><b class='label'>"+strRhesusCode+"&nbsp;</b></td>";
			*/
			tagHtml+="<td align='center' class ='LABELCENTER'><b>"+strBloodGroup+"&nbsp;</b></td>";
			
			// Below line added by Sanjay for ML-MMOH-CRF-0404 on 25-11-2015		
			//tagHtml+="<td align='center' class ='LABELCENTER'><b>"+strXMatchResultStatusDesc+"&nbsp;</b></td>";
			tagHtml+="<td align='center' class ='LABELCENTER'><b>"+strXMatchResultStatus+"&nbsp;</b></td>";

			tagHtml+="<td align='center' class ='LABELCENTER'><b>"+strRhesusCode+"&nbsp;</b></td>";
			tagHtml=tagHtml+strHtmlData+" align='center' ><b class='label'>"+strTransExpectDate+"&nbsp;</b></td>";

			if(opt.equals("RR")==true|| opt.equals("RN")==true)
			{
				tagHtml+="<td align='center' class ='LABELCENTER'><input type='checkbox' name='"+rec_id+"' id='"+rec_id+"'  align='center' "+strClickEvent+" "+strEnabled+" ><input type='hidden'name='SPECIMEN_NO' value="+strSpecimenNo+" REC_ID='"+rec_id+"'></td>"; 
			}

			if(opt.equals("RR")==true|| opt.equals("RA")==true)
			{
				if (strChk.equals("UNCHECKED")==true) strEnabled ="disabled";
				else strEnabled ="";
				if(opt.equals("RA")==true)
				{
					tagHtml+="<td align='center' class ='LABELCENTER'><input type='checkbox' name='"+"R"+rec_id+"' id='"+"R"+rec_id+"'  align='center'  onClick=funPrint(this)  "+strEnabled+" ><input type='hidden'name='SPECIMEN_NO' value="+strSpecimenNo+" REC_ID='"+rec_id+"'></td>"; 
				}
				else
				{
					tagHtml+="<td align='center' class ='LABELCENTER'><input type='checkbox' name='"+"R"+rec_id+"' id='"+"R"+rec_id+"'  align='center'  onClick=funPrint(this)  "+strEnabled+" ></td>"; 
				}
			}
			vectorHtmlData.add(tagHtml);
			vectorHtmlData.add("</tr>");
			if (intFetchedRecords >= max_records)
			{
				break;
			}
		}
		vectorHtmlData.add("</table>");
		rs.close();
		pstmt.close();
		cstmt.close();
		ConnectionManager.returnConnection(conn, request);		
	}
	catch(Exception expSQL)
	{
		ConnectionManager.returnConnection(conn, request);
		//eBT.LogFile.log("QADebugger","Exception "+expSQL,this);
	}
	//eBT.LogFile.log("QADebugger","size"+vectorHtmlData.size(),this);
	//debug("Final sql  = "+sql);
	
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

	for (int l=0;l<vectorHtmlData.size();++l)
	{					
		//eBT.LogFile.log("QADebugger",""+(String)vectorHtmlData.get(l),this);
		out.println((String)vectorHtmlData.get(l));
	}
	//out.println("<script language='javascript'> alert('size "+vectorHtmlData.size()+"');</script>");
	if(vectorHtmlData.size() <= 16)
	{						
		out.println("<script language='javascript'>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>");
	}
	
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(start));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(end));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(column_sizes));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(column_descriptions));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(sql));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(max_records));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(pid));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(fid));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(opt));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strFacilityId));
            _bw.write(_wl_block31Bytes, _wl_block31);

}
catch(Exception exp)
{
}
            _bw.write(_wl_block32Bytes, _wl_block32);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RequestedBy.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBT.ReservednotRequested.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bt_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBT.ReservedRequested.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bt_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBT.RequestReprint.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bt_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Reprint.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }
}
