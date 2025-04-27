package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;

public final class __pendingordersscheduleresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/PendingOrdersScheduleResult.jsp", 1720613006000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!--<!DOCTYPE html>-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n \n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<!--<script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script>-->\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/PendingOrdersSchedule.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"  >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<script>\n\t\tparent.pendingOrdersScheduleHeader.document.location.href=\"../../eCommon/html/blank.html\";\n\t\tparent.pendingOrdersScheduleResult.document.location.href=\"../../eCommon/html/blank.html\";\n\t\tparent.pendingOrdersScheduleSearch.document.pendingOrder_schedule.search_result.disabled = false;\n\t</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<form name=\'pendingOrder_schedule_result\' id=\'pendingOrder_schedule_result\'>\n<table name=\'\' id=\'\' border=\'1\' cellspacing=\'0\' cellpadding = \'3\'  width=\"100%\" align=\"center\" class=\"grid\">\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<tr>\n\t\n\t\t<td width=\'8%\' class=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' align=left><font size=1>&nbsp;</font></td>\n\t\t\n\t\t<td width=\'8%\' class=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' align=left><font size=1>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&nbsp;</font></td>\n\t\t<!--Pass rad_auth_yn --[IN031304]  -->\n\t\t<td width=\'17%\' class=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' align=left nowrap><font size=1><a class=\'gridLink\' href=\'#\' onClick=\"BookAppointment(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\',\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\')\" >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</a></font></td>\n\t\t\n\t\t<td width=\'25%\' class=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' align=left><font size=1><a class=\'gridLink\' href=\'#\' onClick=\"callfunc(\'View\',\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\', \'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</a></font></td>\n\n\t\t<td width=\'27%\' class=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</font></td>\n\t\t\n\t\t<td width=\'15%\' class=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</font></td> \n\n\t</tr>\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n<script>\nparent.pendingOrdersScheduleSearch.document.pendingOrder_schedule.search_result.disabled=false;\n</script>\n</table>\n<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n<!-- <input type=\"hidden\" name=\"total_recs\" id=\"total_recs\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" >-->\n<input type=\"hidden\" name=\"current_date\" id=\"current_date\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n<form>\n\n</body>\n</html>\n \n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

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

/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
04/12/2012		IN031304		ChowminyaG		Include Dept_authorization validation for RD orders br appt schedule(IN035976)	 
-------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eOR.QueryBean beanQuery= null;{
                beanQuery=(eOR.QueryBean)pageContext.getAttribute("beanQuery");
                if(beanQuery==null){
                    beanQuery=new eOR.QueryBean();
                    pageContext.setAttribute("beanQuery",beanQuery);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);


//String bean_id	 = "Or_PatOrderByPrivRelnBean" ;
//String bean_name = "eOR.PatOrderByPrivRelnBean";
//PatOrderByPrivRelnBean bean = (PatOrderByPrivRelnBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
//PatOrderByPrivRelnBean bean = (PatOrderByPrivRelnBean)getBeanObject( bean_id, bean_name, request ) ;

SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy");
java.util.Date date	 			= new java.util.Date();
String dateString 				= dtSystemFormat.format(date);
request.setCharacterEncoding("UTF-8");

String order_category	 = request.getParameter( "order_category" )	== null?"":request.getParameter( "order_category" )	;
String order_type		 = request.getParameter( "order_type" )		== null?"":request.getParameter( "order_type" )		;
String activity_type	 = request.getParameter( "activity_type" )	== null?"":request.getParameter( "activity_type" )	;
String order_catalog_code= request.getParameter( "orderable" )		== null?"":request.getParameter( "orderable" )		;
String performing_locn	 = request.getParameter( "performing_locn" )== null?"":request.getParameter( "performing_locn" );
String priority			 = request.getParameter( "priority" )		== null?"":request.getParameter( "priority" )		;
String patient_id		 = request.getParameter( "patient_id" )		== null?"":request.getParameter( "patient_id")		;
String patient_class	 = request.getParameter( "patient_class" )	== null?"":request.getParameter( "patient_class" )	;
String period_from		 = request.getParameter( "date_from" )		== null?"":request.getParameter( "date_from" )		;
String period_to		 = request.getParameter( "date_to" )		== null?"":request.getParameter( "date_to" )		;

String facility_id = (String)session.getValue("facility_id");
//out.print("<script>alert('period_from:-"+period_from+"--period_to-"+period_to+"--');</script>");	

ArrayList resultData=new ArrayList();
Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 

//resultData=(ArrayList)bean.getSearchDetails(order_category,order_type, activity_type ,order_catalog_code ,performing_locn ,priority ,patient_id , patient_class , period_from, period_to,facility_id);
beanQuery.setLanguageId(localeName);

resultData=(ArrayList)beanQuery.getPendingScheduleSearchDetails(order_category,order_type, activity_type ,order_catalog_code ,performing_locn ,priority ,patient_id , patient_class , period_from, period_to,facility_id,properties);

//out.println("<script>alert('"+resultData.size()+"');</script>");
if(resultData.size() == 0)
{
	//parent.pendingOrdersScheduleSearch.document.pendingOrder_schedule.search_result.disabled=false;
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
	
            _bw.write(_wl_block9Bytes, _wl_block9);

}

            _bw.write(_wl_block10Bytes, _wl_block10);

try{

String slClassValue		 = "";
//String order_cat		 = "";
String sex				 = "";
String Patient_Id		 = "";
String Patient_details   = "";
//String temp_grpby		 = "";
String order_id			 = "";
String colorString		 = "";
String wait_indicator	 = "";
String locn_code		 = "";
String start_date_time	 = "";
String order_line_num	 = "";
String  Priority="";
String rad_auth_yn	 = "N"; //--[IN031304]

String[] row_details = null;
row_details			 = new String[25];
for(int i=0;i<resultData.size();i++){

	//row_details			 = new String[25];
	row_details			 = (String[])resultData.get(i);
	Patient_details		 = (String)row_details[0]	;
//	order_cat			 = (String)row_details[1]	;
	order_id			 = (String)row_details[6]	;
	Patient_Id			 = (String)row_details[7]	;
	order_catalog_code	 = (String)row_details[11]	;
	locn_code			 = (String)row_details[13]	;
	order_line_num		 = (String)row_details[20]	;
	start_date_time		 = (String)row_details[21]	;
	wait_indicator		 = (String)row_details[23]	;
	sex					 = (String)row_details[24]	;
	Priority           =  (String)row_details[3];
	
	//--[IN031304]-Start
	rad_auth_yn=(String)beanQuery.getRadiologyAuthYn(order_id,order_line_num);
	//--[IN031304] - End
	/*if(i % 2 == 0)
		slClassValue = "QRYEVEN";
	else
		slClassValue = "QRYODD";*/
		slClassValue="gridData";
	
	if(wait_indicator==null)
		wait_indicator= "";
	
	if(!wait_indicator.equals("") && wait_indicator.equals("GREEN"))
		colorString = "QRY2";
	else if(!wait_indicator.equals("") && wait_indicator.equals("RED"))
		colorString = "QRY7";
	else if(!wait_indicator.equals("") && wait_indicator.equals("YELLOW"))
		colorString = "YELLOW";
	
	if(Priority.trim().equalsIgnoreCase("U")){
				
			Priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");	

			}else if(Priority.trim().equalsIgnoreCase("S")){
				
				Priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
			}else{
				
				Priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
			}
	
	
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(((!wait_indicator.equals("") && wait_indicator.equals("NORMAL"))?slClassValue:colorString)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(Priority));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(start_date_time));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rad_auth_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(start_date_time,"DMYHM","en",localeName)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((String)row_details[2]));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Patient_Id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf((String)row_details[10]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(Patient_details));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((String)row_details[18]));
            _bw.write(_wl_block23Bytes, _wl_block23);
}

}catch(Exception e){
	//out.println("Exception in displaying the values::"+e.getMessage());//COMMON-ICN-0181
      e.printStackTrace();//COMMON-ICN-0181
	
}
            _bw.write(_wl_block24Bytes, _wl_block24);
//=bean_id
            _bw.write(_wl_block25Bytes, _wl_block25);
//=bean_name
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
//=resultData.size()
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(dateString));
            _bw.write(_wl_block29Bytes, _wl_block29);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
