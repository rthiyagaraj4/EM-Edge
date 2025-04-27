package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __spltyepisode extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/SpltyEpisode.jsp", 1709116355871L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t<script language=\"JavaScript\" src =\"../../eCA/js/RecMaternityCons.js\"></script>\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/common.js\'></Script>\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/ValidateControl.js\'></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body OnMouseDown=\"CodeArrest()\"  onKeyDown=\"lockKey()\" >\n\t\t<form name=\"specialityeventaddmodifyForm\" id=\"specialityeventaddmodifyForm\"  method =\'post\' target=\'messageFrame\' >\n\t\t<!-- Modified by kishore kumar N on 22/12/2008 for the CRF 0387, applied new GRID CSS -->\n\t\t   \t<table class=\'grid\' width=\'100%\' align=\'center\'>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t   <tr>\n\t\t\t\t\t\t<td colspan = \'5\' class=\'CAGROUPHEADING\'><a name=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</a></td>\n\t\t\t\t\t  </tr>\n\t\t\t  ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n               <td class=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'  nowrap  width=\'25%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n               <td class=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'  nowrap width=\'20%\'> ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="<img src=\"../../eCommon/images/flow_text.gif\" align=middle  onClick=\"showDetial(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\',\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\')\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'  nowrap  width=\'35%\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&nbsp;-&nbsp;";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t <tr>\n\t\t\t  \n\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t \n</table>\t\n</form>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

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
  java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String module_id = request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
	String eventDescDisplay = "";
	

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String sql = "";
	String classValue="";
	try
	{    
			con = ConnectionManager.getConnection(request);
			String cycle = "";
			String prevCycle = "";
			String eventdesc = "";
			String eventcode = "";
			String outcomecode = "";
			String outcomedesc= "";
			String outcomeAccNum= "";
			String status = "";
			String startdate = "";
			String enddate = "";
			
           sql = "SELECT  CYCLE_NO,TO_CHAR(SPLTY_EVENT_START_DATE,'DD/MM/YYYY HH24:MI')	 SPLTY_EVENT_START_DATE,TO_CHAR(SPLTY_EVENT_END_DATE,'DD/MM/YYYY HH24:MI') SPLTY_EVENT_END_DATE ,SPLTY_EVENT_CODE	 ,CA_GET_DESC.CA_SPLTY_EVENT(SPLTY_EVENT_CODE,?,'1')||decode(ADDITIONAL_EVENT_YN,'Y','#','') SPLTY_EVENT_DESC	,SPLTY_EVENT_STATUS ,OUTCOME_CODE ,CA_GET_DESC.CA_SPLTY_OUTCOME(OUTCOME_CODE,?,'1') SPLTY_OUTCOME_DESC,OUTCOME_ACCESSION_NUM FROM CA_PAT_SPLTY_EPISODE_EVENT  where patient_id=? and  module_id=? Order by CYCLE_NO desc,ADDITIONAL_EVENT_YN,SPLTY_EVENT_START_DATE";
		     ps = con.prepareStatement(sql);
			 ps.setString(1,locale);
			 ps.setString(2,locale);
			 ps.setString(3,patient_id);
			 ps.setString(4,module_id);
		     rs = ps.executeQuery();
			 classValue = "gridData";
			while(rs.next())
		   {			
			 cycle=rs.getString("CYCLE_NO") == null ? "" : rs.getString("CYCLE_NO");
			/*if (Integer.parseInt(cycle)% 2 == 0 )
		  	classValue = "QRYEVENSMALL" ;
		   else
		  	classValue = "QRYODDSMALL" ;*/
			 eventcode=rs.getString("SPLTY_EVENT_CODE")== null ? "" :  rs.getString("SPLTY_EVENT_CODE");
			 eventdesc=rs.getString("SPLTY_EVENT_DESC")== null ? "" :  rs.getString("SPLTY_EVENT_DESC");
			 outcomecode=rs.getString("OUTCOME_CODE")== null ? "" : rs.getString("OUTCOME_CODE");
			 outcomeAccNum=rs.getString("OUTCOME_ACCESSION_NUM")== null ? "" : rs.getString("OUTCOME_ACCESSION_NUM");
			 outcomedesc=rs.getString("SPLTY_OUTCOME_DESC")== null ? "&nbsp;" :  rs.getString("SPLTY_OUTCOME_DESC");
			 status=rs.getString("SPLTY_EVENT_STATUS")== null ? "" :  rs.getString("SPLTY_EVENT_STATUS");

			 if(status.equals("C")) eventDescDisplay = eventdesc;
			 else if(!status.equals("C")) eventDescDisplay = "<b>"+eventdesc+"</b>";

			 if(status.equals("C"))
				  status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.closed.label","common_labels");
			 else
			   {
				 status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
			   }
			 startdate=rs.getString("SPLTY_EVENT_START_DATE")== null ? "" :  rs.getString("SPLTY_EVENT_START_DATE");
			 startdate= DateUtils.convertDate(startdate,"DMYHM","en",locale);
			 enddate=rs.getString("SPLTY_EVENT_END_DATE")== null ? "" :  rs.getString("SPLTY_EVENT_END_DATE");
			 enddate= DateUtils.convertDate(enddate,"DMYHM","en",locale);

			  if(enddate==null || enddate.equals("") )enddate=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.tilldate.label","ca_labels");  
			   
			   
            _bw.write(_wl_block8Bytes, _wl_block8);

				 if(!prevCycle.equals(cycle))
			   {
				  
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(cycle));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(cycle));
            _bw.write(_wl_block12Bytes, _wl_block12);
 }
				
				//outcomeAccNum= "MC1810";				
				 
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(eventDescDisplay));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(outcomedesc));
if(outcomeAccNum!=null && !outcomeAccNum.equals("")){
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(outcomeAccNum));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(outcomedesc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(status));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(startdate));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(enddate));
            _bw.write(_wl_block22Bytes, _wl_block22);

		
		prevCycle = cycle;
		}
	
            _bw.write(_wl_block23Bytes, _wl_block23);

	}
	catch(Exception ee)
	{
		//out.println("Exception in SpecialtyEventAddModifyIntermediate Module "+ee.toString());//COMMON-ICN-0181
		 ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		try{
				if(con != null) 
			  {	
				ConnectionManager.returnConnection(con);
				con.close();
				if(rs != null) rs.close();
		       if(ps != null) ps.close();
			  }
			}
		catch(Exception e){
		//	out.println(e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
	}


            _bw.write(_wl_block24Bytes, _wl_block24);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Cycle.label", java.lang.String .class,"key"));
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
