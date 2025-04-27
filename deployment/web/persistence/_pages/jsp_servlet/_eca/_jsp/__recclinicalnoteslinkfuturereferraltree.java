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
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __recclinicalnoteslinkfuturereferraltree extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesLinkFutureReferralTree.jsp", 1709116156357L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script Language=\"JavaScript\" src=\'../../eCA/js/RecClinicalNotesLinkFutureEvent.js\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n</head>\n<body class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"  >\n<script language=javascript>\ndocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\ndocument.body.style.scrollbarArrowColor=\'#000080\';\ndocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\ndocument.body.style.scrollbarHighlightColor=\'white\';\ndocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n<form name=\'RecClinicalNotesLinkFutureEventTreeForm\' id=\'RecClinicalNotesLinkFutureEventTreeForm\'>\n\n ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\n<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\' align=\'center\'>\n<TR>\n<td class=\'columnheader\' width=\'100%\' >";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t <Script language=javascript>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\'Common\'));\n\t </script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n</table>\n<input type=\"hidden\" name=\"nature\" id=\"nature\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n<input type=\"hidden\" name=\"order\" id=\"order\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.RecordSet EventBean= null;synchronized(session){
                EventBean=(webbeans.eCommon.RecordSet)pageContext.getAttribute("EventBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(EventBean==null){
                    EventBean=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("EventBean",EventBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
EventBean.clearAll();
            _bw.write(_wl_block5Bytes, _wl_block5);


	String patient_id	="";
	String from_date	="";
	String end_date		="";
	String classValue	="";
	String encounter_id	="";
	String order = "";
    String facility_id      ="";
    String prevdate=""; 
    String result_category="";
    String nature="";
	String 	ref_date_str="";	
	String 	ref_time_str="";	
	String 	ref_id="";	
	
	 String  practionerid="";  

      
	StringBuffer sql=new StringBuffer();
	
	Connection con		=null;
	ResultSet rs		=null;
	PreparedStatement stmt		=null;
	
	
	

            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);


	try
	{
	con				=ConnectionManager.getConnection(request);
  
	practionerid   = (String) session.getValue("ca_practitioner_id"); 
	result_category=request.getParameter("result_cat")==null?"":request.getParameter("result_cat");
	nature=request.getParameter("nature")==null?"":request.getParameter("nature"); 
	from_date=request.getParameter("from_date")==null?"":request.getParameter("from_date");
	end_date=request.getParameter("to_date")==null?"":request.getParameter("to_date");
	patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	encounter_id=request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	order	=request.getParameter("order")==null?"":request.getParameter("order");
   
	facility_id 				=	(String) session.getValue("facility_id");
	
	sql.append(" select to_char(nvl(PREFERRED_TREATMENT_DATE,REFERRAL_DATE),'dd/mm/yyyy') date_str , to_char(nvl(PREFERRED_TREATMENT_DATE,REFERRAL_DATE),'hh24:mi')date_time_str , REFERRAL_ID from pr_referral_register where patient_id=? and trunc(nvl(PREFERRED_TREATMENT_DATE,REFERRAL_DATE)) > =  trunc(sysdate)");
	
	sql.append(" and nvl(PREFERRED_TREATMENT_DATE,REFERRAL_DATE) between nvl(to_date(?,'dd/mm/yyyy'),trunc(SYSDATE)) and  NVL(to_date(?,'dd/mm/yyyy'),SYSDATE+365) ");
	 
	   if((nature.equals("S")))
		{
        sql.append(" and FROM_PRACT_ID = ?");
		} 
	  
		if(order.equals("D"))
		sql.append(" order by nvl(PREFERRED_TREATMENT_DATE,REFERRAL_DATE) desc ");
		else
        sql.append(" order by nvl(PREFERRED_TREATMENT_DATE,REFERRAL_DATE) "); 
		stmt=con.prepareStatement(sql.toString());
		int count1 = 0;
		
//        stmt.setString(++count1,facility_id);
		stmt.setString(++count1,patient_id);
		
		
		stmt.setString(++count1,from_date);
		stmt.setString(++count1,end_date);
			 
         if((nature.equals("S"))){
     
			stmt.setString(++count1,practionerid);
		 
		} 
		
		        
		rs=stmt.executeQuery();

		
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

int i = 0,k=0;

 if (rs !=null)
 {
  	while(rs.next())
	{
     	if ( k%2 == 0 )
		classValue = "QRYEVEN" ;
		else
		classValue = "QRYODD" ;
	
		
		ref_date_str=rs.getString("date_str")==null?"":rs.getString("date_str");
		ref_time_str=rs.getString("date_time_str")==null?"":rs.getString("date_time_str");
		ref_id=rs.getString("REFERRAL_ID")==null?"":rs.getString("REFERRAL_ID");
		
	
	    if(!ref_date_str.equals(prevdate))
	    {
	     out.println("<tr><td colspan=2 class='CAHIGHERLEVELCOLOR'  style='color:white' onClick=javascript:call_resultref('"+ref_date_str+"','Dat')><font size=2>"+ref_date_str+"</font></td></tr>");
	    }

		
        out.println("<tr><td  class='"+classValue+"' colspan='2'><a href=javascript:call_resultref('"+ref_id+"','Refid')>&nbsp;&nbsp;-"+ref_time_str+"</a></td>");
	
	
        prevdate = ref_date_str;
	
		i++;
		k++;
	    }
    }
		
	 if(k==0){
	 
            _bw.write(_wl_block10Bytes, _wl_block10);
}
			
	if(rs!=null)	rs.close();
	if(stmt!=null) 	stmt.close();
	}
	catch(Exception e){
		//out.print("ERROR"+e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{	
		
		if(con!=null)ConnectionManager.returnConnection(con,request);

	}



            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(nature));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(order));
            _bw.write(_wl_block13Bytes, _wl_block13);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
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
}
