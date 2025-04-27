package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import java.util.*;

public final class __newproctermcodegroup extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/NewProcTermCodeGroup.jsp", 1709119750000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block4 ="\n<html>\n<head>\n<title></title>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n<!-- <script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script>\n --><script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"Javascript\" src=\"../../eOR/js/NewProcedureTermCode.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\nfunction callLink(obj){\n\t\n\tvar term_code=\"\";\n\tvar code_level=\"\";\n\tvar search_criteria=\"S\";\n\tvar multiple_yn=\"Y\";\n\tvar search_by=\"\";\n\tvar temp_term_code=\"\";\n\tvar term_code_associated=\"\";\n\tvar Db_term_code=\"\";\n\tvar qryStr =  document.getElementById(\"qryStr\").value;\n\tvar term_grp_id=obj.cells[0].innerText;\n    var term_grp_desc=obj.cells[1].innerText;\n    var term_set_id=obj.cells[0].children(1).value;\n    //var term_set_id=\"ICD10\";\n\t//obj.cells[2].children(0).checked = true ;\n\t\n\tif(qryStr.indexOf(\"term_set_id=\")!=-1)\n\t\tqryStr = qryStr.replace(\"term_set_id=\",\"\");\n\t\n\t//parent.lookup_detail.location.href = \"../../eOR/jsp/NewProcTermCodeQueryResult.jsp?term_set_id=\"+term_set_id+\"&term_code=\"+term_code+\"&code_level=\"+code_level+\"&sc=\"+search_criteria+\"&multiple_yn=\"+multiple_yn+\"&search_by=\"+search_by+\"&temp_term_code=\"+temp_term_code+\"&term_code_associated=\"+term_code_associated+\"&Db_term_code=\"+Db_term_code;\n\t//parent.lookup_detail.location.href = \"../../eOR/jsp/NewProcTermCodeQueryResult.jsp?term_set_id=\"+term_set_id+\"&term_code=\"+term_code+\"&code_level=\"+code_level+\"&sc=\"+search_criteria+\"&multiple_yn=\"+multiple_yn+\"&search_by=\"+search_by+\"&temp_term_code=\"+temp_term_code+\"&term_code_associated=\"+term_code_associated+\"&Db_term_code=\"+Db_term_code+\"&term_grp_id=\"+term_grp_id;\n\tparent.lookup_detail.location.href = \"../../eOR/jsp/NewProcTermCodeQueryResult.jsp?\"+qryStr+\"&term_set_id=\"+term_set_id+\"&term_grp_id=\"+term_grp_id+\"&radioval=G&sc=S&multiple_yn=N\";\n\t\n\t\n}\n</script>\n<body OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<input type=\"hidden\" name=\"qryStr\" id=\"qryStr\" value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\t\n\t\n\t\t<table cellpadding=1 cellspacing=0 width=\"100%\" align=\"center\">\n\t\t<tr onclick=\"retainGrpChk()\">\n\t\t\t<td width=\"80%\" class=\"white\">&nbsp;</td>\n\t\t\t<td width=\"20%\" class=\"white\">&nbsp;\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\t</td>\n\t\t</tr>\n\t\t</table>\n\n\t\t<table border=\"2\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" id=\'grp_tbl\'>\n\t\t\n\t\t<th width=\'35%\'><font size=\'1\'>Term Group ID</font></th>\n\t\t<th width=\'55%\'><font size=\'1\'>Term Group Description</font></th>\n\t\t<th width=\'10%\'><font size=\'1\'>Select</font></th>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<tr>\n\t\t\t\t<td colspan=\'4\' class=\'CAHIGHER\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" </td>\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n\t\t<tr onClick=\"callLink(this);\" >\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" onmouseover=\"changeCursor(this);\" ><font size=\'1\' class=\'HYPERLINK\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</font><input type=\'hidden\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'></td>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"  onclick=\"disableClick(event);\"><font size=\'1\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</font></td>\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\t\t<td class=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" align=\'center\' onclick=\"disableClick(event);\"><input type=\"checkbox\" name=\"term_grp";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" id=\"term_grp";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="></td> \t\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\n\t\t</table>\n\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));history.go(-1);</script> \n\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=ISO-8859-1");
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
String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);


String searchCriteria  = CommonBean.checkForNull( request.getParameter( "sc" ) ) ;
String term_set_id	   = CommonBean.checkForNull( request.getParameter( "term_set_id" ) ) ;
String term_code	   = CommonBean.checkForNull( request.getParameter( "term_code" ) ) ;
String search_by	   = CommonBean.checkForNull( request.getParameter( "search_by" ) ) ;
//  String search_text	   = CommonBean.checkForNull( request.getParameter( "search_text" ) ) ;
//  String term_code_desc  = CommonBean.checkForNull( request.getParameter( "term_code" ) ) ;
String code_level	   = CommonBean.checkForNull( request.getParameter( "code_level" ) ) ;
String temp_term_code  = CommonBean.checkForNull( request.getParameter( "temp_term_code" ) ) ;
String term_code_associated  = CommonBean.checkForNull( request.getParameter( "term_code_associated" ) ) ;
String Db_term_code  = CommonBean.checkForNull( request.getParameter( "Db_term_code" ) ) ;
StringBuffer sqlData	= new StringBuffer("");
sqlData.append("SELECT TERM_SET_ID,TERM_GROUP_ID,TERM_GROUP_DESC FROM MR_TERM_GROUP_HDR WHERE  EFF_STATUS = 'E' AND TERM_SET_ID LIKE NVL(?,TERM_SET_ID) AND TERM_GROUP_APPLICABLITY ='P' ORDER BY 1,2");

boolean searched	   = request.getParameter( "searched" ) == null ? false : true  ;

ArrayList Terminology		=	(ArrayList)TerminologyLookup.getRecordSetHandle();
HashMap Termcode= new HashMap();
String chk_val = "",tmp_grpid="",tmp_setid="";
//TerminologyLookup.clearAll();
if(Terminology.size()>0)
{
	//Termcode=(HashMap)Terminology.get(0);
	Terminology = (ArrayList)TerminologyLookup.getObject(0);
	Termcode = (HashMap)Terminology.get(0);
	//out.println("--Termcode--"+Termcode.size()+"====");
}
try{
	String classvalue			= "";
	String checked				= "";
	String disabled				= "";


	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData", sqlData.toString());

	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	
	displayFields.add( "TERM_GROUP_ID" );
	displayFields.add( "TERM_GROUP_DESC" );
	displayFields.add( "TERM_SET_ID" );

	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();
	chkFields.add(term_set_id.trim());
	
	//Adding function related array list into the HashMap
    funcMap.put( "displayFields", displayFields );
    funcMap.put( "chkFields", chkFields );
    funcMap.put( "searchCriteria", searchCriteria );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
	if ( sqlMap != null ) sqlMap.clear();
	if ( funcMap != null ) funcMap.clear();
	if ( chkFields != null ) chkFields.clear();
	if ( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block8Bytes, _wl_block8);
//For display the previous/next link
		 out.println(result.get(1));
	
            _bw.write(_wl_block9Bytes, _wl_block9);

		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		String link_columns = "1";
		String tmp_hdr = "";
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
			else
				 classvalue = "QRYODD" ;
			records=(ArrayList) result.get( recCount );
			
			tmp_grpid=(String)records.get( 0 );
			tmp_setid=(String)records.get( 2 );
			/*Set itr_set			=	Termcode.keySet();
			Iterator recordItr	=	itr_set.iterator();
			while(recordItr.hasNext() && recCount==2)
			{	
				String grpid=(String)recordItr.next();
				//out.println("==keys =="+grpid);
			}*/
			
			if(Termcode.containsKey(tmp_setid+tmp_grpid)){
				chk_val = (String)Termcode.get(tmp_setid+tmp_grpid);
				//out.println("==in=="+(String)Termcode.get(tmp_setid+tmp_grpid));
				
			if(chk_val != null && chk_val.equals("Y"))
				checked = "checked";
			else
				checked = "";
			}else
				checked = "";

			if(!tmp_hdr.equals((String)records.get( 2 ))){
		
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((String)records.get( 2 )));
            _bw.write(_wl_block11Bytes, _wl_block11);
  tmp_hdr = (String)records.get( 2 );
			}
		
            _bw.write(_wl_block12Bytes, _wl_block12);

			
			for (int colCount=0; colCount<records.size(); colCount++)
			{
				if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((String)records.get( colCount )));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(tmp_hdr));
            _bw.write(_wl_block16Bytes, _wl_block16);
		}else if( colCount == 1){ 
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf((String)records.get( colCount )));
            _bw.write(_wl_block18Bytes, _wl_block18);
		}
            _bw.write(_wl_block19Bytes, _wl_block19);
	}/* End of For column Count */
			if ( records != null ) records.clear();
		
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block25Bytes, _wl_block25);

		}/* End of For record Count */
            _bw.write(_wl_block26Bytes, _wl_block26);

		out.flush();
	}else{
            _bw.write(_wl_block27Bytes, _wl_block27);
}
		
	out.println(CommonBean.setForm(request ,"NewProcTermCodeGroup.jsp", searched));
	if ( displayFields != null ) displayFields.clear();
	if ( result != null ) result.clear();
}
catch(Exception e) {
	//out.print("Exception @ Result JSP :"+e.toString());//COMMON-ICN-0181
	e.printStackTrace();
}	

            _bw.write(_wl_block28Bytes, _wl_block28);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
