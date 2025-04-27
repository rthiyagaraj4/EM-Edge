package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;
import eOR.Common.*;
import eOR.*;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import java.util.*;

public final class __newproctermcodequeryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/NewProcTermCodeQueryResult.jsp", 1709119750000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block4 ="\n\n\n<html>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t<head>\n\t<title></title>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<!-- \t<script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script>\n -->\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eOR/js/NewProcedureTermCode.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\n\tfunction Modify(obj){\n\t\tvar code1=obj.cells[0].innerText;\n\t\tvar code2=obj.cells[1].innerText;\n\t\tvar code3=obj.cells[2].innerText;\n\t\tvar code4=obj.cells[3].children(0).value;\n\t\tvar retVal = code1 + \"||\" + code2 + \"||\" + code3 + \"||\" + code4 +\"~\";\n\t\ttop.window.returnValue = retVal ;\n\t\ttop.close()\n\t}\n\t</script>\n\t<body OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<table cellpadding=1 cellspacing=0 width=\"100%\" align=\"center\">\n\t\t<tr onclick=\'retainCodeChk()\'>\n\t\t\t<td width=\"80%\" class=\"white\" >&nbsp;</td>\n\t\t\t<td width=\"20%\" class=\"white\" >&nbsp;\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t</td>\n\t\t</tr> \n\t\t</table>\n\t\t\n\t<table border=\"2\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" id=\'result_tbl\'>\n\t\t<th width=\'20%\'><font size=\'1\'>Term Code</font></th>\n\t\t<th width=\'40%\'><font size=\'1\'>Term Code Description</font></th>\n\t\t<th width=\'20%\'><font size=\'1\'>Code Level</font></th>\n\t\t<!-- <th width=\'45%\'>Term Set Description</th> -->\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<th><font size=\'1\'>Select</font></th>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<tr>\n\t\t\t\t<td colspan=\'4\' class=\'CAHIGHER\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" </td>\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n             <tr onClick=\"Modify(this);\" >\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" onmouseover=\"changeCursor(this);\" ><font class=\'HYPERLINK\' size=\'1\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t</font></td>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" onclick=\"disableClick(event);\"><font size=\'1\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</font></td>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t<td style=\'display:none\'><input type=\'hidden\' name=\'code_level";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' id=\'code_level";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'></td>\n   \t   ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" onclick=\"\" ><font class=\'\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</font></td> \n\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t<td style=\'display:none\'><input type=\'hidden\' name=\'code_level";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'></td>\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t <td class=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" align=\'center\' onclick=\"disableClick(event);\"><input type=\"checkbox\" name=\"term_chk";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" id=\"term_chk";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="></td>\n\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\t\t\n           </tr>\n    ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t<input type=\"hidden\" name=\'cnt\' id=\'cnt\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n   <input type=\"hidden\" name=\'temp_term_code1\' id=\'temp_term_code1\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t<input type=\"hidden\" name=\"ret_term_code\" id=\"ret_term_code\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t<input type=\"hidden\" name=\"db_term_code\" id=\"db_term_code\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n    <input type=\"hidden\" name=\'qry_string\' id=\'qry_string\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n    <input type=\"hidden\" name=\'multiple_yn\' id=\'multiple_yn\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t<input type=\"hidden\" name=\'search_by\' id=\'search_by\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>  <!-- Added By vinod 14/05/2005 -->\n\t\n</table>\n\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t<script>\n\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\n\t\t\tparent.lookup_head.document.CriteriaForm.Search.disabled = false;\n\t\t\t/*\n\t\t\tThis component TermCodeSearch is used commonly. If OK button is not there it gives error\n\t\t\t*/\n\t\t\tif (parent.lookup_cancel.document.getElementById(\"ok\") != null)\n\t\t\t{\n\t\t\t\tparent.lookup_cancel.document.getElementById(\"ok\").disabled = false;\n\t\t\t}\n\t\t\t\n\t\t\thistory.go(-1);\n\t\t</script> \n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n</body>\n\t<script>\n\t\t\tparent.lookup_head.document.CriteriaForm.Search.disabled = false;\n\t</script> \n</html>\n\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet TerminologyLookup= null;synchronized(session){
                TerminologyLookup=(webbeans.eCommon.RecordSet)pageContext.getAttribute("TerminologyLookup",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(TerminologyLookup==null){
                    TerminologyLookup=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("TerminologyLookup",TerminologyLookup,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block4Bytes, _wl_block4);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

    
	// String sqlData         = "select a.term_Code term_code, a.short_Desc term_code_description,a.long_Desc long_description, Decode(CODE_LEVEL,'1',LEVEL_1_DESC,'2',LEVEL_2_DESC,'3',LEVEL_3_DESC, '4',LEVEL_4_DESC ,'5',LEVEL_5_DESC ,'6',LEVEL_6_DESC ,'7',LEVEL_7_DESC ,'8',LEVEL_8_DESC ,'9',LEVEL_9_DESC ,'10',LEVEL_5_DESC )  code_level_desc,code_level from mr_term_code a, mr_Term_set b    where a.term_set_id = b.term_set_ID and upper(select_yn) like upper('Y') and upper(a.term_Set_id) = upper(?)  and 	upper(a.term_code)  like upper(?) and upper(a.short_Desc) like upper(?) and upper(short_Desc) like  DECODE   ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?)) and code_level= nvl(?,code_level) order by 1";
     

    String searchCriteria  = CommonBean.checkForNull( request.getParameter( "sc" ) ) ;
    String term_set_id	   = CommonBean.checkForNull( request.getParameter( "term_set_id" ) ) ;
    String term_code	   = CommonBean.checkForNull( request.getParameter( "term_code" ) ) ;
    String search_by	   = CommonBean.checkForNull( request.getParameter( "search_by" ) ) ;
  //  String search_text	   = CommonBean.checkForNull( request.getParameter( "search_text" ) ) ;
  //  String term_code_desc  = CommonBean.checkForNull( request.getParameter( "term_code" ) ) ;
    String code_level	   = CommonBean.checkForNull( request.getParameter( "code_level" ) ) ;
    String multiple_yn     = CommonBean.checkForNull( request.getParameter( "multiple_yn" ) ) ;
    String temp_term_code  = CommonBean.checkForNull( request.getParameter( "temp_term_code" ) ) ;
    String term_code_associated  = CommonBean.checkForNull( request.getParameter( "term_code_associated" ) ) ;
    String Db_term_code  = CommonBean.checkForNull( request.getParameter( "Db_term_code" ) ) ;
    String term_grp_id  = CommonBean.checkForNull( request.getParameter( "term_grp_id" ) ) ;
    String radioval  = CommonBean.checkForNull( request.getParameter( "radioval" ) ) ;

	StringBuffer sqlData	= new StringBuffer("");
	if(term_grp_id.equals("") && radioval.equals("C")){
	sqlData.append("select a.term_Code term_code, a.short_Desc term_code_description,a.long_Desc long_description, Decode(CODE_LEVEL,'1',LEVEL_1_DESC,'2',LEVEL_2_DESC,'3',LEVEL_3_DESC, '4',LEVEL_4_DESC ,'5',LEVEL_5_DESC ,'6',LEVEL_6_DESC ,'7',LEVEL_7_DESC ,'8',LEVEL_8_DESC ,'9',LEVEL_9_DESC ,'10',LEVEL_5_DESC )code_level_desc,code_level,b.term_set_id term_set_id,b.term_set_desc term_set_desc from mr_term_code a, mr_Term_set b where a.term_set_id = b.term_set_ID and upper(select_yn) like upper('Y') and upper(a.term_Set_id) = upper(?) and ");
	}else{
		  sqlData.append("SELECT a.TERM_CODE term_code, c.SHORT_DESC term_code_description, c.CODE_LEVEL code_level, DECODE(c.CODE_LEVEL,'1',LEVEL_1_DESC,'2',LEVEL_2_DESC, '3',LEVEL_3_DESC, '4',LEVEL_4_DESC ,'5',LEVEL_5_DESC , '6',LEVEL_6_DESC ,'7',LEVEL_7_DESC ,'8',LEVEL_8_DESC ,  '9',LEVEL_9_DESC ,'10',LEVEL_10_DESC ) code_level_desc,b.term_set_id term_set_id,b.term_set_desc term_set_desc FROM MR_TERM_GROUP_DTL a, mr_term_set b,mr_term_code c   WHERE   a.term_set_id = b.term_set_id AND b.term_set_id = c.term_set_id AND a.term_code  = c.term_code   AND a.term_group_id LIKE UPPER(?) AND a.TERM_SET_ID LIKE UPPER(?) and ");
		
		multiple_yn = "N";
	}
	 if(search_by.equals("C"))
		sqlData.append("upper(a.term_code)");
	 else
		sqlData.append("upper(short_desc)");
	 
	 sqlData.append(" like  DECODE   ((?), 'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?)) and code_level= nvl(?,code_level) order by 1");
/*	if(search_by.equals("C"))
		term_code_desc = "";
	else
		term_code = "";*/
		
	boolean searched	   = request.getParameter( "searched" ) == null ? false : true  ;
	//out.println("<script>alert('"+term_set_id+"===="+term_code+"');</script>");
try
{
	//out.println("--clearAll--"+TerminologyLookup.clearAll()+"==");
	ArrayList Terminology		=	(ArrayList)TerminologyLookup.getRecordSetHandle();
	HashMap Termcode= new HashMap();
	//out.println("--getSize--"+TerminologyLookup.getSize()+"==");
	if(Terminology.size()>0)
	{
		//Termcode=(HashMap)Terminology.get(0);
		Terminology = (ArrayList)TerminologyLookup.getObject(0);
		Termcode = (HashMap)Terminology.get(0);
		/*Set itr_set			=	Termcode.keySet();
		Iterator recordItr		=	itr_set.iterator();
		while(recordItr.hasNext()){
			String grpid1="";
			grpid1=(String)recordItr.next();
			//out.println("--Termcode--"+grpid1+"====");
		}*/
		//out.println("--Termcode-size-"+Termcode.size()+"====");
	}
	
	String classvalue			= "";
	String checked="",disabled="";

	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData", sqlData.toString());

	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	displayFields.add( "term_code" );
    displayFields.add( "term_code_description" );
	//displayFields.add( "long_description" );
    displayFields.add( "code_level_desc" );
	displayFields.add( "code_level" );
	displayFields.add( "term_set_id" );
	displayFields.add( "term_set_desc" );
    //  displayFields.add( "term_set_desc" );
	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();
	if(!term_grp_id.equals("") || !radioval.equals("C"))
		chkFields.add(term_grp_id.trim());

	chkFields.add(term_set_id.trim());
	chkFields.add(searchCriteria.trim());
	chkFields.add(term_code);
	chkFields.add(term_code);
	chkFields.add(term_code);
	chkFields.add(code_level.trim());
	

	//Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );
	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
	if ( sqlMap != null ) sqlMap.clear();
	if ( funcMap != null ) funcMap.clear();
	if ( chkFields != null ) chkFields.clear();
	
	String link_columns = "1";
	
	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) ))
	{
	
            _bw.write(_wl_block8Bytes, _wl_block8);

			//For displaying the previous/next link
			 out.println(result.get(1));
	
            _bw.write(_wl_block9Bytes, _wl_block9);
  if(multiple_yn.equals("Y"))
			{
	 
            _bw.write(_wl_block10Bytes, _wl_block10);
   
			}
		  //Retriving the records from result arraylist
		   ArrayList records=new ArrayList();
		   String tmp_hdr = "",tmp_setid= "",tmp_code= "",tmp_desc= "",level= "",level_desc= "";
		   for ( int recCount=2; recCount<result.size(); recCount++) 
		   {
		 	 if ( recCount % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
		
		   if (multiple_yn.equals("Y"))
				link_columns = "0";
		   else if(radioval.equals("G"))
				link_columns = "0";	
        
			records=(ArrayList) result.get( recCount );
			
			tmp_code	 = (String)records.get( 0 );
			tmp_desc	 = (String)records.get( 1 );
			level_desc	 = (String)records.get( 2 );
			level		 = (String)records.get( 3 );
			tmp_setid	 = (String)records.get( 4 );
			
			if(!tmp_hdr.equals((String)records.get( 4 )) && radioval.equals("G")){
		
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((String)records.get( 5 )));
            _bw.write(_wl_block12Bytes, _wl_block12);
  tmp_hdr = (String)records.get( 4 );
			}
		
            _bw.write(_wl_block13Bytes, _wl_block13);
 
			for (int colCount=0; colCount<records.size(); colCount++)
			 {
				if(!multiple_yn.equals("Y"))
				 {
					if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 )
					 {
		
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((String)records.get( colCount ) ));
            _bw.write(_wl_block16Bytes, _wl_block16);
 
			        }
					else
					{ 
						if ( colCount == 0 ||colCount == 1 || colCount == 2 )
						{
		
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((String)records.get( colCount )));
            _bw.write(_wl_block19Bytes, _wl_block19);
	
						}
						else if ( colCount == 3 )
						{
		
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(records.get( colCount )));
            _bw.write(_wl_block23Bytes, _wl_block23);
 
						}
					}
				 }
				else
			      {
					if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 )
					 {
						
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((String)records.get( colCount )));
            _bw.write(_wl_block26Bytes, _wl_block26);
		}
					else
					{ 
						if ( colCount == 0 ||colCount == 1 || colCount == 2 )
						 {
		
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((String)records.get( colCount )));
            _bw.write(_wl_block19Bytes, _wl_block19);

						}
						else if ( colCount == 3)
						{
		
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(records.get( colCount )));
            _bw.write(_wl_block28Bytes, _wl_block28);

						}
						if ( (String.valueOf(colCount)).equals("3") )
						 {
    						
							//out.println("==in=="+Termcode.containsKey(tmp_setid+tmp_code+tmp_desc+level+level_desc)+"=="+tmp_code);	
							//if(Termcode.containsKey(tmp_code+tmp_desc+level+level_desc)){
							if(Termcode.containsKey(tmp_code+"|"+tmp_desc)){
								String chk_val = (String)Termcode.get(tmp_code+"|"+tmp_desc);
								//out.println("==in=="+(String)Termcode.get(tmp_setid+tmp_grpid));
								if(chk_val != null && chk_val.equals("Y"))
									checked = "checked";
								else
									checked = "";
							}else
								checked = "";
							//	String temp_rec= (String)records.get( 0 )+"~";
							/*	if	(temp_term_code.indexOf((String)records.get( 0 )+"~") != -1)
								{
									int ind = temp_term_code.indexOf((String)records.get( 0 )+"~") ;
									String temp1=temp_term_code.substring(ind,temp_term_code.length());
									int ind1=temp1.indexOf("~") ;
									String temp2=temp1.substring(0,ind1);
									if (temp2.equals((String)records.get( 0 )) )
									 {
										checked = "checked";
										disabled= "";
									}
									else
									{
										checked = "";
										disabled= "";
									}
								}
								else
								{
									checked = "";
									disabled= "";
								}*/
/* Modified by vinod 9/13/2005
	To handle the term codes which are substrings of other term codes.
	A term code will be suffixed with "~" before comparing with the string "DB_term_code" to identify the exact matching sub string
*/	
					//		String temp_rec1 = (String)records.get( 0 )+"~";
					/*		if (Db_term_code.indexOf((String)records.get( 0 )+"~") != -1) 
							 {
								int ind = Db_term_code.indexOf((String)records.get( 0 )+"~") ;
								String temp1=Db_term_code.substring(ind,Db_term_code.length());
								int ind1=temp1.indexOf("~") ;
								String temp2=temp1.substring(0,ind1);
								 if(temp2.equals((String)records.get( 0 )))
									{
										checked = "checked";
										disabled= "disabled";
									}
									else
									{
										checked = "";
										disabled= "";
									}
							}*/
		
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block34Bytes, _wl_block34);

						}
				}
			}	
         } /* End of For column Count */
 		if ( records != null ) records.clear();
    
            _bw.write(_wl_block35Bytes, _wl_block35);

      } /* End of For record Count */

    
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(result.size()));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(temp_term_code));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(term_code_associated));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(Db_term_code));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(multiple_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(search_by));
            _bw.write(_wl_block43Bytes, _wl_block43);
out.flush();
	}
	else /* If  result.size() not >=3) */
     {

            _bw.write(_wl_block44Bytes, _wl_block44);

	  }
	/**Following code changed by vinod 06/09/2005 - Extra characters were printing in result page  */
	out.println(CommonBean.setForm(request ,"NewProcTermCodeQueryResult.jsp?\"+request.getQueryString()+\"", searched));
	if ( displayFields != null ) displayFields.clear();
	if ( result != null ) result.clear();
 }
catch(Exception e) 
	{
		//out.print("Exception @ Result JSP :"+e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}	

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
