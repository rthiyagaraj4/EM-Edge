package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eCommon.Common.*;
import webbeans.eCommon.ConnectionManager;
import java.net.URLEncoder;
import eCommon.Common.*;
import java.util.*;

public final class __cptlookupresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/cptLookupResult.jsp", 1709114640601L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eBL/js/cptResult.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eBL/js/cptLookup.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n        <table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\">\n        <tr>\n        <td width=\"40%\" class=\"white\">&nbsp;</td>\n\t\t<td width=\"40%\" class=\"white\">&nbsp;</td>\n        <td width=\"20%\" class=\"white\">&nbsp;\n    ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n        </td>\n\t\t</tr>\n        </table>\n\n    <table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" id=\"ResultTab\">\n    ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n            <th>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th><th>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n    ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n    ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n        <tr onClick=\"ModifyRes(\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\');\" >\n    ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n               <td class=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"  style=\"text-align: center;\" onmouseover=\"changeCursor(this);\" ><font class=\'HYPERLINK\' >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</font></td>\n    ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" style=\"text-align: center;\" onclick=\"disableClick(event);\" style=\'WORD-BREAK:BREAK-ALL;\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n    ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\t<input type=\"hidden\" name =\"hd_";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\n            </tr>\n    ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n        </table>\n    ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n        <script>\n        </script> \n    ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n    <script>\n\tif(!parent.lookup_head.chkBothCriteria )\n\t{\n\t\tif(parent.lookup_head.fromCalledPage)\n\t\t{\n\t\t\tparent.lookup_head.chkBothCriteria = true;\n\t\t\tparent.lookup_head.document. CriteriaForm .elements[1].click()\n\t\t\tparent.lookup_head.document. CriteriaForm .Search.click()\n\t\t}\n\t\telse\n\t\t{\n\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t\t}\n\t}\n\telse\n\t{\n\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n\t}              \n    </script>\n    \n\t";
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

/*
-------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
17/06/2020 	  		       Ram kumar S											AAKH-CRF-0122
-------------------------------------------------------------------------------------------------------------------------------------
*/ 

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
            _bw.write(_wl_block3Bytes, _wl_block3);

	request.setCharacterEncoding("UTF-8");
    String callFrom = CommonBean.checkForNull(request.getParameter("callFrom" ));

if( !callFrom.equals("0") ) {
            _bw.write(_wl_block4Bytes, _wl_block4);

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

    }

            _bw.write(_wl_block1Bytes, _wl_block1);

    
	String sqlData			= CommonBean.checkForNull(request.getParameter( "sqlData" ));
	System.err.println("CPT Query before "+sqlData);
	sqlData=sqlData.replace("a.pk_value( )","a.pk_value(+)");
	System.err.println("CPT Query after "+sqlData);
    String searchCriteria	= CommonBean.checkForNull(request.getParameter( "sc" ) ) ;
   // String searchType		= CommonBean.checkForNull(request.getParameter( "searchType" ) ) ;
    String linkFields		= CommonBean.checkForNull(request.getParameter( "linkFields" ) ) ;
    String displayOrder		= CommonBean.checkForNull(request.getParameter( "displayOrder" ) ) ;
	String code_desc		= "CPT Code";
	String type_desc		= "Service Code";
	String desc_desc		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
    Enumeration paramnames	= request.getParameterNames();
    int count = 0;
    while( paramnames.hasMoreElements() ) {
        String str = (String)paramnames.nextElement() ;
        if( str.equals( "from" ) || str.equals( "to" ) || str.equals( "searched" ) || str.equals( "sc" ) || str.equals( "linkFields" ) || str.equals( "displayOrder" ) || str.equals( "callFrom" ) )
            continue;
        count ++;
    }

    boolean searched = request.getParameter( "searched" ) == null ? false : true  ;

try{
    String classvalue = "" ;
    HashMap sqlMap = new HashMap();
    sqlMap.put( "sqlData", sqlData );
    HashMap funcMap = new HashMap();
    ArrayList displayFields = new ArrayList();

    if( displayOrder.equals("CODE_DESC") ) {
        displayFields.add( "CPTcode" );
        displayFields.add( "code" );
        displayFields.add( "description" );
    } else {
        displayFields.add( "CPTcode" );
        displayFields.add( "code" );
        displayFields.add( "description" );
    }
	
    ArrayList chkFields = new ArrayList();
    int i = 1;
    int j = 1;
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
    
    funcMap.put( "displayFields", displayFields );
	System.err.println("displayFields "+displayFields);
    funcMap.put( "chkFields", chkFields );
	System.err.println("ChkFileds "+chkFields);
    funcMap.put( "searchCriteria", searchCriteria );
	System.err.println("searchCriteria "+searchCriteria);
    //funcMap.put( "searchType", searchType );

    ArrayList result = (ArrayList) CommonBean.getSearchQueryResultPage(pageContext,sqlMap, funcMap, request, true);
            System.err.println("Result size   "+result.size() + " ");
	for (int z = 0; z < result.size(); z++) 
            System.err.println("Result from View   "+result.get(z) + " ");
		
		
            System.err.println("Result from callFrom   "+callFrom + " ");
	if( !callFrom.equals("0") ) {

    if( (result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){
    
            _bw.write(_wl_block7Bytes, _wl_block7);

         out.println(result.get(1));
		 System.err.println("Result l_blng_serv_desc   "+result.get(1) + " ");
    
            _bw.write(_wl_block8Bytes, _wl_block8);
 
     
		 System.err.println("CODE_DESC displayOrder  "+displayOrder + " ");
	if( displayOrder.equals("CODE_DESC") ) { 
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(code_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(type_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(desc_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
  } else { 
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(desc_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(type_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(code_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
  }  
     
	
            _bw.write(_wl_block12Bytes, _wl_block12);

	ArrayList records=new ArrayList();
	
	for(int recCount=2; recCount<result.size(); recCount++) {

		if ( recCount % 2 == 0 )
			classvalue = "gridData" ;
		else
			classvalue = "gridData" ;
    
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block14Bytes, _wl_block14);

        String link_columns = linkFields ;
		records = (ArrayList) result.get( recCount );
		String retval = "";
		 System.err.println("linkFields   "+linkFields + " ");
        for(int colCount=0; colCount<records.size(); colCount++){

			if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
    
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((String)records.get( colCount )));
            _bw.write(_wl_block17Bytes, _wl_block17);
      }else{ 
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((String)records.get( colCount )));
            _bw.write(_wl_block19Bytes, _wl_block19);

            }

			retval=retval+"~"+(String)records.get( colCount );	
			System.err.println("Values returning  "+retval);
			
        }
    
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
    }else{
    
            _bw.write(_wl_block25Bytes, _wl_block25);

    }
    out.println(CommonBean.setForm ( request ,"cptLookupResult.jsp", searched) );
	
	}
	else
	{
			System.err.println("records 0  "+result.get(0));
        if( ((String) result.get(0)).equals("1") )
        {
            java.util.ArrayList records = (java.util.ArrayList) result.get( 2 );
			System.err.println("records returning  "+result.get(2));
    
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
} catch(Exception e) {
    out.print("Exception @ Result JSP :"+e.toString());
	e.printStackTrace();
}

if( !callFrom.equals("0") ) {

            _bw.write(_wl_block29Bytes, _wl_block29);
 } 
            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
