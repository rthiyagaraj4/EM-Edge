package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __chartsummarymedicalalerts extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartSummaryMedicalAlerts.jsp", 1738837634480L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \n--------------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n29/11/2012\t  IN035950\t\tNijitha\t\t CHL Hospital suggested that the presentation of the Clinician desktop be changed and \n\t\t\t\t\t\t\t\t\t\t more appealing. Keeping the display of information more clear and visible.\t\t\t\t\t\t\t\t\t\t\t\t \n-------------------------------------------------------------------------------------------------\nDate\t\tEdit History\tName\t\tRev.Date\t\tRev.Name\t\t\tDescription\n-------------------------------------------------------------------------------------------------\n24/05/2018\t\tIN065341\tPrakash C\t25/05/2018\t\tRamesh G\t\tMMS-DM-CRF-0115\n-------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<title>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</title><!--IN035950-->\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n        <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n      \t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCA/js/ResearchPatient.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n     \t<script>\n\t\t\tvar Highrisk_Status=\"N\";\n\t\t\t\n\t\t\tasync function HighRisk(patientid,authorize){\n\t\t\t\t\n\t\t\t\tif(authorize == \"Y\")\n\t\t\t\t{\n\t\t\t\t\t//window.location.href=\'ChartSummaryMedicalAlerts.jsp?patient_id=\'+patientid+\'&authorize=N\';//CHL_CRF\n\t\t\t\t\twindow.location.href=\'ChartSummaryMedicalAlerts.jsp?patient_id=\'+patientid+\'&title=\'+\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'+\'&authorize=N\';//CHL_CRF\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tvar val1 = \'V\' ;\n\t\t\t\t\tvar val2 = \'HR\' ;\n\t\t\t\t\tvar val3=\'C\'\n\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'==\"PatientQueue\")\n\t\t\t\t\t\tval3=\"O\";\n\t\t\t\t\tvar val = val1+\'/\'+val2+\'/\'+val3+\'/\';\n\n\t\t\t\t\tvar retVal = \tnew String();\n\t\t\t\t\tvar dialogHeight= \"70vh\" ;\n\t\t\t\t\tvar dialogWidth\t= \"70vw\" ;\n\t\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no\" ;\n\t\t\t\t\tvar arguments\t= \"\" ;\n\t\t\t\t\t\n\t\t\t\t\tretVal = await window.showModalDialog(\"AuthorizeMRAccess.jsp?constr=\"+val,arguments,features);\n\t\t\t\t\t\t\n\t\t\t\t\tif(retVal==\"T\"){\t\t\t\t\t\t\n\t\t\t\t\t\t//alert(\"succ\");\n\t\t\t\t\t\t//window.location.href=\'ChartSummaryMedicalAlerts.jsp?patient_id=\'+patientid+\'&authorize=Y\';//CHL_CRF\n\t\t\t\t\t\twindow.location.href=\'ChartSummaryMedicalAlerts.jsp?patient_id=\'+patientid+\'&title=\'+\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'+\'&authorize=Y\';//CHL_CRF\n\t\t\t\t\t}\n\t\t\t\t\telse{\t\n\t\t\t\t\t\t//alert(\"unn\");\n\t\t\t\t\t\t//window.location.href=\'ChartSummaryMedicalAlerts.jsp?patient_id=\'+patientid+\'&authorize=N\';//CHL_CRF\n\t\t\t\t\t\twindow.location.href=\'ChartSummaryMedicalAlerts.jsp?patient_id=\'+patientid+\'&title=\'+\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'+\'&authorize=N\';//CHL_CRF\n\t\t\t\t\t}\n\t\t\t\t}\n\n\t\t\t}\n\t\t\t\n\t\t/*\tfunction showToolTip()\n\t\t\t{\n\t\t\t\t\n\t\t\t}\n\n\t\tfunction showToolTip(obj,authorizeyn)\n\t\t{\n\t\t\tvar displayText = \'<table cellpadding=0 cellspacing=0 border=0><td class=YELLOW>\'\n\t\t\tif(authorizeyn == \'Y\')\n\t\t\t{\n\t\t\t\tdisplayText += \'Click to Normalize\';\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tdisplayText += \'Click to Authorize\';\n\t\t\t}\n\t\t\tdisplayText += \'</td></table>\';\n\t\t\tdocument.getElementById(\"authorizeMode\").innerHTML = displayText;\n\t\t\tdocument.getElementById(\"authorizeMode\").style.top  = obj.offsetTop+15; \n\t\t\tdocument.getElementById(\"authorizeMode\").style.left  = obj.offsetLeft-20 ;\n\t\t\tdocument.getElementById(\"authorizeMode\").style.visibility=\'visible\' ;\n\t\t}\n\n\t\tfunction hideToolTip()\n\t\t{\n\t\t\tdocument.getElementById(\"authorizeMode\").style.visibility=\'hidden\' ;\n\t\t}*/\n\n\n\t\t/*\tfunction HighRisk(){\n\t\t\t   \tvar P_access_type=document.forms[0].P_access_type.value;\n\t\t\t\tvar P_access_data=document.forms[0].P_access_data.value;\n\t\t\t\tvar Context=document.forms[0].Context.value;\n\t\t\t\tif (Highrisk_Status==\"N\") {\n\t\t\t\tdocument.location.href=\'AuthorizeHRC.jsp?patientid=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&Context=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&jsp_name=QryPatSumHRC.jsp&B_jsp_name=QryPatSHRCblank.jsp&context=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'\n\t\t\t\t}\n\t\t\t}*/\n     \t</script>\n</head>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\"HRCblank\" id=\"HRCblank\">\n <!-- ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" -->\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n<center>\n\t\t<a class=class=\'gridLink\' href=\"javascript:HighRisk(\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\',\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\')\" onMouseOver=\"showToolTip(this,\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\')\" onMouseOut=\"javascript:hideToolTip()\"> <font size=\'2\' color=\'red\'> [";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="]</font></a> \n\t\t<br>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="<table align=\'center\' class=\'grid\' width=\'100%\'><br>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\n</center>\n</table>\n</form>\n<div id=\'authorizeMode\' style=\'position:absolute; visibility:hidden;overflow:overflow\'></div>\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//[IN035950] Starts
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

String prefStyleSheet = request.getParameter("prefStyle");//Nijitha
//String content_ID = request.getParameter("content_ID"); checkstyle
String title = request.getParameter("title");
//String sStyle = "";
if(!"".equals(prefStyleSheet)){
 sStyle=prefStyleSheet;
}
/*else{
	sStyle=prefStyleSheet;
}*/
//[IN035950] Ends

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(title ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block10Bytes, _wl_block10);

	String patientid=request.getParameter("patient_id");
	String context=request.getParameter("context");
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(title));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(context));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(title));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(title));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(context));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(context));
            _bw.write(_wl_block18Bytes, _wl_block18);

	Connection con= null;
	PreparedStatement stmt =null;
	ResultSet rs	 =null;

	
	

	PreparedStatement stmt1 =null;
	ResultSet rs1	 =null;
	String RepDb=request.getParameter("RepDb")==null?"":request.getParameter("RepDb");//IN065341
	String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");//IN065341

try
	{
		String query_high_risk_condition ="";
		String high_risk_desc ="",classValue="";
		int i =0;
		String sqlhighriskcount="";
		int maxrecord = 0;

	//out.println(request.getQueryString());
	//IN065341 starts
		String authorize ="";
		if(called_from.equals("CDR")){
			authorize="Y";
		}else{
			 authorize = (request.getParameter("authorize")==null)?"N":request.getParameter("authorize");
		}	
	
	con = ConnectionManager.getConnection(request);

	//sqlhighriskcount = "select count(*) as total from pr_high_risk_condition a where patient_id=? and rownum=1 ";
	sqlhighriskcount = "select count(*) as total from pr_high_risk_condition ##REPDB## a where patient_id=? and rownum=1 ";//IN065341
	sqlhighriskcount=sqlhighriskcount.replaceAll("##REPDB##",RepDb);//IN065341
	stmt1 = con.prepareStatement(sqlhighriskcount);
	stmt1.setString(1,patientid);
	rs1=stmt1.executeQuery();
	rs1.next();
	maxrecord = rs1.getInt("total");

	if(maxrecord>0)
	{
	

            _bw.write(_wl_block19Bytes, _wl_block19);

	
	
	

            _bw.write(_wl_block20Bytes, _wl_block20);
if(!called_from.equals("CDR")){ //IN065341 
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(authorize));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(authorize));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
} //IN065341
            _bw.write(_wl_block2Bytes, _wl_block2);

		if(authorize.equals("Y"))
		{
	
            _bw.write(_wl_block26Bytes, _wl_block26);

			//query_high_risk_condition = "Select distinct b.SHORT_DESC high_risk_desc from pr_high_risk_condition a, mr_high_risk b where patient_id =? and b.high_risk_code = a.high_risk_code";
			
			//query_high_risk_condition = "Select distinct b.short_desc high_risk_desc from pr_high_risk_condition a,mr_high_risk_lang_vw b where patient_id =? and a.close_date is null and b.high_risk_code = a.high_risk_code and b.language_id = ?";
			query_high_risk_condition = "Select distinct b.short_desc high_risk_desc from pr_high_risk_condition ##REPDB## a,mr_high_risk_lang_vw ##REPDB## b where patient_id =? and a.close_date is null and b.high_risk_code = a.high_risk_code and b.language_id = ?";//IN065341
			query_high_risk_condition=query_high_risk_condition.replaceAll("##REPDB##",RepDb);//IN065341
			stmt = con.prepareStatement(query_high_risk_condition);

			stmt.setString(1,patientid);
			stmt.setString(2,locale);

			rs = stmt.executeQuery();
			while(rs.next())
					{
						if ( i%2 == 0 )
							classValue="QRYODD";
						else
							classValue="QRYEVEN";

						i++;
						high_risk_desc	= rs.getString("high_risk_desc");

						out.println("<tr><td class='gridData'>"+high_risk_desc+"</td></tr>");
					}
			if(i == 0)
			{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
			}
		}
	}
	//IN035950  Starts
	if(maxrecord==0)
	out.println("<table class='grid' width='100%' cellspacing='0' cellpadding='0'><tr><td class='gridData'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NODATAFOUND.label","ca_labels")+"</td></tr>");
	//IN035950  Ends
		if(rs!=null) rs.close();
		if(rs1!=null) rs1.close();
		if(stmt!=null) stmt.close();
		if(stmt1!=null) stmt1.close();
}
catch(Exception e)
{
		//out.println("Exception@1 : "+e.getMessage());//COMMON-ICN-0181
	        e.printStackTrace();//COMMON-ICN-0181
}
finally
{
				
if(con!=null) ConnectionManager.returnConnection(con,request);
}



            _bw.write(_wl_block27Bytes, _wl_block27);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.HighRisk.label", java.lang.String .class,"key"));
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
