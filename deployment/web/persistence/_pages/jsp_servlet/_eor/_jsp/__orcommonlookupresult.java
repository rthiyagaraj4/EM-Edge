package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eCommon.Common.*;
import java.lang.reflect.*;
import eCommon.Common.*;
import java.util.*;

public final class __orcommonlookupresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrCommonLookupResult.jsp", 1731997750000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 =" \n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<html>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n    <head>\n        <title></title>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n        <script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n        <script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javaScript\" src=\"../../eOR/js/OrCommonLookup.js\" ></script>\n\t\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n        <table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\">\n        <tr>\n        <td width=\"80%\" class=\"white\">&nbsp;</td>\n        <td width=\"20%\" class=\"white\">&nbsp;\n    ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n        </td></tr>\n        </table>\n\n        <table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" id=\"ResultTab\">\n    ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n            <th>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th><th>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n    ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n    ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n          <!--   <tr onClick=\"Modify(this);\" > -->\n            <tr onClick=\"Modify(\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\');\" >\n    ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n                    <td class=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" onmouseover=\"this.style.cursor=\'pointer\'\" ><font class=\'HYPERLINK\' >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</font></td>\n    ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" onclick=\"disableClick(event);\" style=\'WORD-BREAK:BREAK-ALL;\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n    ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\t\t<input type=\"hidden\" name =\"hd_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" id=\"hd_";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\n            </tr>\n    ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n        </table>\n    ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n        <script> \n            //parent.lookup_cancel.close.click();\n\n              //var argArray = window.dialogArguments ; commented as b\'coz while click on next and if there is only one record it is defaulting,but it should not default.IN010406\n              //if ( argArray[5] != \"\" )\n                 //document.getElementById(\"ResultTab\").rows[1].click() ;\n        </script> \n    ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n        <script>\n\n                if(!parent.lookup_head.chkBothCriteria )\n                {\n                    if(parent.lookup_head.fromCalledPage)\n                    {\n                        parent.lookup_head.chkBothCriteria = true;\n                        parent.lookup_head.document. CriteriaForm .elements[1].click()\n                        parent.lookup_head.document. CriteriaForm .Search.click()\n                    }\n                    else\n                    {\n                        alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\n                    }\n                }\n                else\n                {\n                    alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\n                }\n\n\n\n       </script>\n    ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n            firstCodeVal = \"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" ;\n            firstDescVal = \"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" ;\n    ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n    <script>\n\t\tif( parent.lookup_head.document. CriteriaForm .Search != null )\n\t\t\tif( parent.lookup_head.document. CriteriaForm .Search.disabled )\n\t\t\t\tparent.lookup_head.document. CriteriaForm .Search.disabled = false;\n\t</script>\n\t</body>\n    </html>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block3Bytes, _wl_block3);
 
    String callFrom        = CommonBean.checkForNull( request.getParameter( "callFrom" ) ) ;

	if( !callFrom.equals("0") ) {
            _bw.write(_wl_block4Bytes, _wl_block4);
 request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block5Bytes, _wl_block5);

			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

    }

            _bw.write(_wl_block1Bytes, _wl_block1);

try{    //Search Criteria's from Query Criteria page

	String locale=(String)session.getAttribute("LOCALE") ;
	locale 		 = (locale == null )?"en":locale.toLowerCase();
    String sqlData         		= CommonBean.checkForNull( request.getParameter( "sqlData" ) );
    String searchCriteria  		= CommonBean.checkForNull( request.getParameter( "sc" ) ) ;
    String linkFields      		= CommonBean.checkForNull( request.getParameter( "linkFields" ) ) ;
    String displayOrder    		= CommonBean.checkForNull( request.getParameter( "displayOrder" ) ) ;
    String title           		= CommonBean.checkForNull( request.getParameter( "title" ) ) ;
	String code_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	String desc_desc	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	
	String repositoryKey		= CommonBean.checkForNull( request.getParameter( "repositoryKey" ) );
    String repositoryFullPath	= CommonBean.checkForNull( request.getParameter( "repositoryFullPath" ) ) ;
	String parName				= CommonBean.checkForNull( request.getParameter( "parNameArray" ) ) ;
	String parValue				= CommonBean.checkForNull( request.getParameter( "parValueArray" ) ) ;

	String repositoryQuery 		= "";
	
	if(!"".equals(repositoryKey) && !"".equals(repositoryFullPath)){
		
		try{ 		
			Class c = Class.forName(repositoryFullPath);
			Method m = c.getDeclaredMethod("getValue", String.class);	
			m.setAccessible(true);		
			repositoryQuery = CommonBean.checkForNull((String)m.invoke(null, repositoryKey));	
			String[] parNameArray=parName.split(",");
			String[] parValueArray=parValue.split(",");
			
			for(int i=0;i<parNameArray.length;i++){
				if (repositoryQuery.indexOf(parNameArray[i]) >= 0){
					repositoryQuery = repositoryQuery.replaceAll(parNameArray[i],parValueArray[i]);
				} 
			}		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}/* catch (InstantiationException e) {
			e.printStackTrace();
		} */catch (IllegalAccessException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		if(!"".equals(repositoryQuery)){
			if((repositoryQuery.toUpperCase().indexOf("ORDER BY"))>-1)
				repositoryQuery=repositoryQuery.substring(0,repositoryQuery.toUpperCase().indexOf("ORDER BY"));
			sqlData=repositoryQuery+" "+sqlData;
		}
	}
	 Enumeration paramnames = request.getParameterNames() ;
	 
    /*while (paramnames.hasMoreElements()) {
        String paramName = (String)paramnames.nextElement();
        String paramValue = request.getParameter(paramName);
        out.println(paramName + " = " + paramValue + "<br>");
    }*/
    int count = 0;
    while( paramnames.hasMoreElements() ) {
        String str = (String)paramnames.nextElement() ;
	/*if(str.equals( "from" )){
	   out.println( "from = " + request.getParameter(str) + "<br>");
	}
	if(str.equals( "to" )){
	   out.println( "to = " + request.getParameter(str) + "<br>");
	}*/
        if( str.equals( "from" ) || str.equals( "to" ) || str.equals( "searched" ) || str.equals( "sc" ) || str.equals( "linkFields" ) || str.equals( "displayOrder" ) || str.equals( "callFrom" ) )
            continue;
        count ++;
    }
    boolean searched    = request.getParameter( "searched" ) == null ? false : true  ;


    String classvalue           = "" ;
    HashMap sqlMap = new HashMap();
    //include all the common parameters.
    //out.println(sqlData) ;
    
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
//    out.println( "alert(\""+sqlData+"\")" );
    ArrayList chkFields = new ArrayList();
    int i = 1;
    int j = 1;
    for(; j<=count-1 ; i++,j+=2) {
        String fieldValue = request.getParameter( "f"+i )  ;
        String fieldType = request.getParameter( "f"+i+"T" ) ;

//        out.println( "alert(\""+fieldValue + ":" + fieldType+"\")" );

        if(fieldValue != null)
        {
            if( fieldType.equals("String") )
                chkFields.add( fieldValue );
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

    /*
    Enumeration<String> attributeNames = pageContext.getAttributeNamesInScope(PageContext.PAGE_SCOPE);
    while (attributeNames.hasMoreElements()) {
        String attributeName = attributeNames.nextElement();
        Object attributeValue = pageContext.getAttribute(attributeName);
        System.out.println(attributeName + ": " + attributeValue);
    }*/
    
    ArrayList result = (ArrayList) CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request, true);
    

if( !callFrom.equals("0") ) {
    if( (result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){
    
            _bw.write(_wl_block8Bytes, _wl_block8);

        // For display the previous/next link
         out.println(result.get(1));
    
            _bw.write(_wl_block9Bytes, _wl_block9);
 
     
	if( displayOrder.equals("CODE_DESC") ) { 
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(code_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(desc_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
  } else { 
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(desc_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(code_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
  }  
     
	
            _bw.write(_wl_block13Bytes, _wl_block13);

        //Retriving the records from result arraylist
        ArrayList records=new ArrayList();
		
        for(int recCount=2; recCount<result.size(); recCount++) {
            if ( recCount % 2 == 0 )
                classvalue = "gridData" ;
            else
                classvalue = "gridData" ;
			
    
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block15Bytes, _wl_block15);


            //String link_columns = "1,2";
            String link_columns = linkFields ;

            records=(ArrayList) result.get( recCount );

			String retval="";

            for(int colCount=0; colCount<records.size(); colCount++){

 //           out.println((String) result.get(0)) ;

                if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
					
    
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf((String)records.get( colCount )));
            _bw.write(_wl_block18Bytes, _wl_block18);
          }else{ 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((String)records.get( colCount )));
            _bw.write(_wl_block20Bytes, _wl_block20);

                }
			retval=retval+"~"+(String)records.get( colCount );
						
            }
    
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(retval));
            _bw.write(_wl_block24Bytes, _wl_block24);

        }
    
            _bw.write(_wl_block25Bytes, _wl_block25);

        if( ((String) result.get(0)).equals("1") ) {
    
            _bw.write(_wl_block26Bytes, _wl_block26);

        }
        out.flush();
    } else{
    
            _bw.write(_wl_block27Bytes, _wl_block27);

    }
        out.println(CommonBean.setForm ( request ,"OrCommonLookupResult.jsp", searched) );
   }
   else
   {
        if( ((String) result.get(0)).equals("1") )
        {
            java.util.ArrayList records = (java.util.ArrayList) result.get( 2 );
    
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(records.get(1)));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(records.get(0)));
            _bw.write(_wl_block30Bytes, _wl_block30);

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

            _bw.write(_wl_block31Bytes, _wl_block31);
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
