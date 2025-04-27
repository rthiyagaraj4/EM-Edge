package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.net.URLEncoder;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __blinsuranceblnglinkqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLInsuranceBlngLinkQueryResult.jsp", 1723100363004L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n\n<HTML>\n\t<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n</head>\n<BODY class=\'CONTENT\'  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<form name=\'QueryResult\' id=\'QueryResult\'>\n\n<P>\n<table align=\'right\'>\n<tr>\n<td>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</td>\n</tr>\n</table>\n<br><br>\n</p>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<table class=\'grid\' border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\' align=\'center\'>\n\n<th class=\"columnheadercenter\" nowrap> \n\tBilling Group Code\n</th>\n<th class=\"columnheadercenter\" nowrap> \n\tCustomer Group Code\n</th>\n<th class=\"columnheadercenter\" nowrap> \n\tCustomer Code\n</th>\n<th class=\"columnheadercenter\" nowrap> \n\tPatient Class\n</th>\n<th class=\"columnheadercenter\" nowrap> \n\tPolicy Type Code\n</th>\n<th class=\"columnheadercenter\" nowrap> \n\tFacility Id\n</th>\n<th class=\"columnheadercenter\" nowrap> \n\tPriority No\n</th>\n\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n</td></tr>\n</table>\n</center>\n\n<br><center>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n</center>\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

     private String checkForNull(String inputString) {
 		if(inputString == null || "null".equals(inputString)){
 			inputString = "";
 		}
 		return inputString;
 	}
	

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
 request.setCharacterEncoding("UTF-8");
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
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String facility_id = (String)session.getAttribute("facility_id");

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

Connection conn  =  ConnectionManager.getConnection(request);
PreparedStatement stmt = null;
ResultSet rs = null;

try{
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    String sql = " ";
    
    
    String blngGroup = request.getParameter("billingGrpCode")==null?"":request.getParameter( "billingGrpCode" ).trim().toUpperCase();
    String payerGroup =request.getParameter("payerGrpCode")==null?"":request.getParameter( "payerGrpCode" ).trim().toUpperCase();
    String payer =request.getParameter("payerCode")==null?"":request.getParameter( "payerCode" ).trim().toUpperCase();
	String policyType =request.getParameter("policyTypeCode")==null?"":request.getParameter( "policyTypeCode" ).trim().toUpperCase();

	String patientClass =request.getParameter("patientClass")==null?"":request.getParameter( "patientClass" ).trim().toUpperCase();
	String oprFacId =request.getParameter("facility")==null?"":request.getParameter( "facility" ).trim().toUpperCase();
	String priorNo =request.getParameter("priority")==null?"":request.getParameter( "priority" ).trim().toUpperCase();
	
	
	System.out.println("blngGroup/>>>>>>>>>>>>>>>>>>>>>>"+blngGroup+"/"+to+"/"+from);
	
	//String patientClass="";
	
	
	System.out.println("blngGroup/payerGroup/payer/policyType/patientClass/oprFacId/priorNo"+blngGroup+"/"+payerGroup+"/"+payer+"/"+policyType+"/"+patientClass+"/"+oprFacId+"/"+priorNo);
	
	if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;        

        if ( !(blngGroup == null || blngGroup.equals("")) ){
	        sql = sql + " and upper(hdr.BLNG_GRP_ID) like upper('"+blngGroup +"%')";
			cnt++;
        }
        if ( !(payerGroup == null || payerGroup.equals("")) ){
				sql=sql+" and upper(hdr.CUST_GROUP_CODE) like '"+payerGroup+"%'";
				cnt=1;
        }        
        if ( !(payer == null || payer.equals("")) ){
				sql=sql+" and upper(hdr.CUST_CODE) like '"+payer+"%'";
				cnt=2;
        }
        if ( !(policyType == null || policyType.equals("")) ){
			sql=sql+" and upper(hdr.POLICY_TYPE_CODE) like '"+policyType+"%'";
			cnt=2;
         }
	 

    //appending order by clause
    String ord[] = request.getParameterValues("orderbycolumns");

    if ( !(ord == null || ord .equals("")) )
    {
    	System.out.println("Inside orderby if cond");
        sql=sql+" order by ";
        for ( int i=0;i < ord.length;i++ )
        {
        if ( i == ord.length - 1 )
            sql=sql+ord[i];
        else
            sql=sql+ord[i]+",";
        }
    }

    } //end of where clause IF
    else{
            sql = whereClause;
    }



    int start = 0 ;
    int end = 0 ;
    int i=1;

    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = 14 ;
    else
        end = Integer.parseInt( to ) ;

	int maxRecord = 0;
	try{
		
	
		String strsql = "SELECT count(*) as total FROM BL_PAYERS_PRIORITY_BY_BG hdr where hdr.operating_facility_id = ? "+sql ;
		String strsql1 = "SELECT OPERATING_FACILITY_ID,BLNG_GRP_ID,CUST_GROUP_CODE,CUST_CODE,PATIENT_CLASS,POLICY_TYPE_CODE,PRIORITY_NO FROM "+
				" BL_PAYERS_PRIORITY_BY_BG hdr where hdr.operating_facility_id = ?  "+sql ;

		/* Fixed SQL Injection for Common-ICN-0222 */
		System.out.println("sql-> "+sql);
		System.out.println("strsql-> "+strsql);
		stmt = conn.prepareStatement(strsql);
		stmt.setString(1, facility_id);
		System.out.println("prepareStatement->1");
		rs = stmt.executeQuery();
		System.out.println("executeQuery->1");
		rs.next();
		maxRecord = rs.getInt("total");
		
		if(maxRecord == 0){
			System.out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		if(stmt!=null)	stmt.close();
		if(rs!=null)	rs.close();
		System.out.println("strsql1->"+strsql1+" facility_id : "+facility_id);
		stmt = conn.prepareStatement(strsql1);
		stmt.setString(1, facility_id);
		System.out.println("prepareStatement->");
		rs = stmt.executeQuery();
		System.out.println("executeQuery->");
		
	}catch(Exception e){
		//System.out.println("exception occurred "+e);
		e.printStackTrace();
	}

            _bw.write(_wl_block9Bytes, _wl_block9);

if ( !(start <= 1) )
    out.println("<A HREF='../../eBL/jsp/BLInsuranceBlngLinkQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eBL/jsp/BLInsuranceBlngLinkQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

            _bw.write(_wl_block10Bytes, _wl_block10);
             org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag __tag0 = null ;
            int __result__tag0 = 0 ;

            if (__tag0 == null ){
                __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
            }
            __tag0.setPageContext(pageContext);
            __tag0.setParent(null);
            __tag0.setValue(locale 
);
            _activeTag=__tag0;
            __result__tag0 = __tag0.doStartTag();

            if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                }
            }
            if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag0);
                return;
            }
            _activeTag=__tag0.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
            __tag0.release();
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

	int mOrder = 0;
	if ( start != 1 )
    for( int j=1; j<start; i++,j++ )
      rs.next() ;
	String classValue= " ";
   	while ( rs.next() && i<=end  )
	{
    	if( i % 2 == 0 )
           classValue = "gridData" ;  
        else
           classValue = "gridData" ;  
    	out.println("<tr><td align=='left' class='" + classValue + "' nowrap>");
    
	    blngGroup = rs.getString("BLNG_GRP_ID");
	    payerGroup = rs.getString("CUST_GROUP_CODE");
	    payer = checkForNull(rs.getString("CUST_CODE"));
	    patientClass = rs.getString("PATIENT_CLASS");
	    policyType = checkForNull(rs.getString("POLICY_TYPE_CODE"));   
	    oprFacId = rs.getString("OPERATING_FACILITY_ID");   
	    priorNo = checkForNull(rs.getString("PRIORITY_NO"));   
	
		String mode="modify";
    
		out.println("<a href='../../eBL/jsp/BLInsuranceBlngLinkAddModify.jsp?mode=modify&blngGroup="+ blngGroup+"&payerGroup="+payerGroup+"&payer="+payer+"&patientClass="+patientClass+"&policyType="+policyType+"&oprFacId="+oprFacId+"&priorNo="+priorNo+"' target='f_query_add_mod' >");
	    out.println(blngGroup+"</a></td>");
	    out.println("<td class='" + classValue+"' nowrap>"+payerGroup+"</td>");
	    out.println("<td class='" + classValue+"' nowrap>"+payer+"</td>");
	    out.println("<td class='" + classValue+"' nowrap>"+patientClass+"</td>");
	    out.println("<td class='" + classValue+"' nowrap>"+policyType+"</td>");
	    out.println("<td class='" + classValue+"' nowrap>"+oprFacId+"</td>");
	    out.println("<td class='" + classValue+"' nowrap>"+priorNo+"</td>");
		i++;
	} 

            _bw.write(_wl_block12Bytes, _wl_block12);
		
}
catch(Exception e)
{
	out.println("here "+e);
}
finally{
	if(stmt!=null)	stmt.close();
	if(rs!=null)	rs.close();
	ConnectionManager.returnConnection(conn,request);	
}

            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.SetBundleTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.SetBundleTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setBasename(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDSN.resources.Labels", java.lang.String .class,"basename"));
        __tag1.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("dl_labels", java.lang.String .class,"var"));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.fmt.SetBundleTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
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
}
