package jsp_servlet._ecommon._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import webbeans.eCommon.*;
import eOT.*;
import eOT.Common.*;
import eCommon.Common.*;
import webbeans.eCommon.ConnectionManager;
import java.net.URLEncoder;
import eCommon.Common.*;
import java.util.*;

public final class __commonlookupresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/CommonLookupResult.jsp", 1742809483414L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<html>\n    <head>\n        <title></title>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' type=\'text/css\' />\n        <script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n        <script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n        <script language=\"Javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\n</head>\n<body onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n        <table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\">\n        <tr>\n        <td width=\"80%\" class=\"white\">&nbsp;</td>\n        <td width=\"20%\" class=\"white\">&nbsp;\n    ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\n        </td></tr>\n        </table>\n\n        <table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" id=\"ResultTab\">\n    ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n            <th>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th><th>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n    ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n    ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n          <!--   <tr onClick=\"Modify(this);\" > -->\n            <tr onClick=\"Modify(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\');\" >\n    ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n                    <td class=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" onmouseover=\"changeCursor(this);\" ><font class=\'HYPERLINK\' >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</font></td>\n    ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" onclick=\"disableClick(event);\" style=\'WORD-BREAK:BREAK-ALL;\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n    ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\t<input type=\"hidden\" id=\"hd_";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" name =\"hd_";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\n            </tr>\n    ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n        </table>\n    ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n        <script> \n            //parent.lookup_cancel.close.click();\n\n              //var argArray = window.dialogArguments ; commented as b\'coz while click on next and if there is only one record it is defaulting,but it should not default.IN010406\n              //if ( argArray[5] != \"\" )\n                 //document.getElementById(\'ResultTab\').rows[1].click() ;\n        </script> \n    ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n        <script>\n                if(!parent.lookup_head.chkBothCriteria )\n                {\n\n                    if(parent.lookup_head.fromCalledPage)\n                    {\n                        parent.lookup_head.chkBothCriteria = true;\n                        parent.lookup_head.document. CriteriaForm .elements[1].click()\n                        parent.lookup_head.document. CriteriaForm .Search.click()\n                    }\n                    else\n                    {\n\n                        alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n                    }\n                }\n                else\n                {\n                    alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n                }\n                \n\t\t         \n                    \n       </script>\n    ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n            firstCodeVal = \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" ;\n            firstDescVal = \"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" ;  \n    ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n    <script>\n\t\tif( parent.lookup_head.document. CriteriaForm .Search != null )\n\t\t\tif( parent.lookup_head.document. CriteriaForm .Search.disabled )\n\t\t\t\tparent.lookup_head.document. CriteriaForm .Search.disabled = false;\n\t</script>\n\t</body>\n    </html>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");

    String callFrom        = CommonBean.checkForNull(request.getParameter( "callFrom" ) ) ;
if( !callFrom.equals("0") ) {
            _bw.write(_wl_block3Bytes, _wl_block3);

			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);

    }

            _bw.write(_wl_block1Bytes, _wl_block1);

try{    //Search Criteria's from Query Criteria page
    String sqlData         = CommonBean.checkForNull(request.getParameter( "sqlData" ) );

    String searchCriteria  = CommonBean.checkForNull(request.getParameter( "sc" ) ) ;
    String linkFields      = CommonBean.checkForNull(request.getParameter( "linkFields" ) ) ;
    String displayOrder    = CommonBean.checkForNull(request.getParameter( "displayOrder" ) ) ;

	String code_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	String desc_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
    Enumeration paramnames = request.getParameterNames() ;
    
    
	String params = request.getQueryString() ;
	
	
	//Added against MOHE-SCF-0208...starts
	String[] arr = sqlData.split("::");
	String key = arr[0].substring(2,13);
	System.err.println("query = "+key);
	if(key.equals("INTERNALREP")){
		System.err.println("inside 0209");
	String facility_id = (String)session.getValue("facility_id");
	String locale = (String)session.getAttribute("LOCALE");
	int cnt = 0;
	int var = 1;
	System.err.println(arr[0]);
	String sql_query="";
	try {
	MessageManager mm = new MessageManager();
	java.util.Hashtable mesg = mm.getMessage(locale,arr[0],arr[1]);
	sql_query = (String) mesg.get("message");
	StringBuffer sb = new StringBuffer();
 
	int start = 0,end = 0;
	for(int i=0;i<sql_query.length();i++){
		end=i;
		if(sql_query.charAt(i) == '#'){
			sb.append(sql_query.substring(start, end));
			var++;
			sb.append(arr[var]);
			start = i+1;
		}
		if(i==sql_query.length()-1) sb.append(sql_query.substring(start,i+1));
	}

	sqlData = sb.toString();
//	out.println(sqlData);
	}
	catch (Exception e) {
		System.err.println("Err Msg CommonLookupResult.jsp in getting SQL "+e.getMessage());
	}
	}
	//Added against MOHE-SCF-0208...ends
    int count = 0;
    while( paramnames.hasMoreElements() ) {
        String str = (String)paramnames.nextElement() ;
        if( str.equals( "from" ) || str.equals( "to" ) || str.equals( "searched" ) || str.equals( "sc" ) || str.equals( "linkFields" ) || str.equals( "displayOrder" ) || str.equals( "callFrom" ) )
            continue;
        count ++;
    }
    boolean searched    = request.getParameter( "searched" ) == null ? false : true  ;


    String classvalue           = "" ;
    HashMap sqlMap = new HashMap();
    //include all the common parameters.
    sqlMap.put( "sqlData", sqlData );


    //Function Parameters
    HashMap funcMap = new HashMap();

    //The fields are going to be display
    ArrayList displayFields = new ArrayList();

    if( displayOrder.equals("CODE_DESC") ) {
        displayFields.add( "code" );
        displayFields.add( "description" );
    } else {
        displayFields.add( "description" );
        displayFields.add( "code" );
    }
	

    //The fields are going to be in where condition * should match with the query
   // out.println( "alert(\""+sqlData+"\")" );
    ArrayList chkFields = new ArrayList();
    int i = 1;
    int j = 1;
//    out.println( "here 2.1 " );
    for(; j<=count-1 ; i++,j+=2) {
        String fieldValue = request.getParameter( "f"+i ) ;
        String fieldType = request.getParameter( "f"+i+"T" ) ;

		if(fieldValue != null)
        {
            if( fieldType.equals("String") )
                chkFields.add(fieldValue);
            else if ( fieldType.equals("Integer") )
                chkFields.add( new Integer( Integer.parseInt(fieldValue) ) );
            else if ( fieldType.equals("Long") )
                chkFields.add( new Long( Long.parseLong(fieldValue) ) );
            else if ( fieldType.equals("Float") )
                chkFields.add( new Float( Float.parseFloat(fieldValue) ) );
            else if ( fieldType.equals("Double") )
                chkFields.add( new Double( Double.parseDouble(fieldValue) ) );
        }
    
    } 
    

    // Adding function related array list into the HashMap
    funcMap.put( "displayFields", displayFields );
    funcMap.put( "chkFields", chkFields );
    funcMap.put( "searchCriteria", searchCriteria );


    //Calling the Result from Common Adaptor as a arraylist.


    ArrayList result = (ArrayList) CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request, true);

//    out.println (result)  ;

if( !callFrom.equals("0") ) {

    if( (result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){
    
            _bw.write(_wl_block6Bytes, _wl_block6);

        // For display the previous/next link
         out.println(result.get(1));
		 
    
    
            _bw.write(_wl_block7Bytes, _wl_block7);
 
     
	if( displayOrder.equals("CODE_DESC") ) { 
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(code_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(desc_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
  } else { 
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(desc_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(code_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
  }  
     
	
            _bw.write(_wl_block11Bytes, _wl_block11);

        //Retriving the records from result arraylist
        ArrayList records=new ArrayList();
		
        for(int recCount=2; recCount<result.size(); recCount++) {
            if ( recCount % 2 == 0 )
                classvalue = "gridData" ;
            else
                classvalue = "gridData" ;
			
    
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block13Bytes, _wl_block13);


            //String link_columns = "1,2";
            String link_columns = linkFields ;

            records=(ArrayList) result.get( recCount );

			String retval="";

            for(int colCount=0; colCount<records.size(); colCount++){

 //           out.println((String) result.get(0)) ;

                if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
					
    
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((String)records.get( colCount )));
            _bw.write(_wl_block16Bytes, _wl_block16);
          }else{ 
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf((String)records.get( colCount )));
            _bw.write(_wl_block18Bytes, _wl_block18);

                }
			retval=retval+"~"+(String)records.get( colCount );
						
            }
    
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(retval));
            _bw.write(_wl_block22Bytes, _wl_block22);

        }
    
            _bw.write(_wl_block23Bytes, _wl_block23);

        if( ((String) result.get(0)).equals("1") ) {
    
            _bw.write(_wl_block24Bytes, _wl_block24);

        }
        out.flush();
    } else{
    
            _bw.write(_wl_block25Bytes, _wl_block25);

    }
        out.println(CommonBean.setForm ( request ,"CommonLookupResult.jsp", searched) );
   }
   else
   {
        if( ((String) result.get(0)).equals("1") )
        {
            java.util.ArrayList records = (java.util.ArrayList) result.get( 2 );
    
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(records.get(1)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(records.get(0)));
            _bw.write(_wl_block28Bytes, _wl_block28);

        }
   }
   sqlMap.clear();
   funcMap.clear();
   displayFields.clear();
   chkFields.clear();
   result.clear();
   //records.clear();
} catch(Exception e) {
    System.err.println("Exception @ Result JSP :"+e.toString());
	e.printStackTrace();
}

if( !callFrom.equals("0") ) {

            _bw.write(_wl_block29Bytes, _wl_block29);
 } 
            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
