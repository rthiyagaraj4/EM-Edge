package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __querygroupapptresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/QueryGroupApptResult.jsp", 1729083484182L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<HTML>\n\t<head>\n\t<script src=\"../../eOP/js/menu.js\" language=\"JavaScript1.2\"></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/tableheaderscroll.js\'></script><!-- Supporting Js File For Fixed Header with scroll.... -->\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n\t<script type=\"text/javascript\">\n\twindow.onload = function () { \n\t\tif(document.getElementById(\"Qry_grp_appt_dtls\")!=null){\n\t\t\tfxheaderInit(\'Qry_grp_appt_dtls\',300);\n\t\t}\n\t}\n\t</script>\n\t<script>\n\t\t//function show_Reference_details(grp_id,app_date,prac_id,loc_type,loc)\n\t\tfunction show_Reference_details(fromTime,toTime,grp_id,app_date,prac_id,loc_type,loc)\n\t\t{\n\t\t\tvar dialogHeight = \"35\" ;\n\t\t\tvar dialogWidth\t= \"45\" ;\n\t\t\tvar dialogTop = \"160\" ;\n\t\t\tvar center = \"1\" ;\n\t\t\tvar status=\"no\";\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\tvar arguments\t= \"\" ;\n\t\t\twindow.showModalDialog(\"../../eOA/jsp/GroupApptFrame.jsp?fromTime=\"+fromTime+\"&toTime=\"+toTime+\"&group_id=\"+grp_id+\"&app_date=\"+app_date+\"&prac_id=\"+prac_id+\"&loc_type=\"+loc_type+\"&loc=\"+loc,arguments,features);\n\t\t}\n\t//function overlap_details(fromTime,toTime,groupId,apptDate)\n\tfunction overlap_details(fromTime,toTime,group_id,apptDate,location)\n\t\t{ \tvar dialogHeight = \"35\" ;\n\t\t\tvar dialogWidth\t= \"45\" ;\n\t\t\tvar dialogTop = \"160\" ;\n\t\t\tvar center = \"1\" ;\n\t\t\tvar status=\"no\";\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\tvar arguments\t= \"\" ; \n\t\t\twindow.showModalDialog(\"../../eOA/jsp/GroupApptOverlapFrames.jsp?fromTime=\"+fromTime+\"&toTime=\"+toTime+\"&group_id=\"+group_id+\"&apptDate=\"\n\t\t\t+apptDate+\"&location=\"+location,arguments,features);\n\t\t\t\n\t\t}\n\t\t/*Below  function modified for this incident [44296]*/\n\t\tfunction show_Appointmentslip_details(grp_id,app_date,prac_id,loc_type,loc,fromtime,totime)\n\t\t{\n\t\t\tvar dialogHeight = \"30\" ;\n\t\t\tvar dialogWidth\t= \"40\" ;\n\t\t\tvar dialogTop = \"160\" ;\n\t\t\tvar center = \"1\" ;\n\t\t\tvar status=\"no\";\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\tvar arguments\t= \"\" ;\n\t\t\t//window.showModalDialog(\"../../eOA/jsp/AppointmentSlip.jsp?app_date=\"+app_date+\"&group_id=\"+grp_id+\"&prac_id=\"+prac_id+\"&loc_type=\"+loc_type+\"&loc=\"+loc,arguments,features);\n\t\t\tif(confirm(getMessage(\"PRINT_APP_SLIP\",\"OA\"))){ \n\t\t\tlocation.href=\"../../eOA/jsp/AppointmentSlip.jsp?app_date=\"+app_date+\"&group_id=\"+grp_id+\"&prac_id=\"+prac_id+\"&loc_type=\"+loc_type+\"&loc=\"+loc+\"&fromtime=\"+fromtime+\"&totime=\"+totime+\"\";\n            alert(getMessage(\"REPORT_SUBMIT_SERVER\",\"Common\"));\t\t \n\t\t }//else{\n\t\t   //}\n\t\t}\n\t\n \n  \nfunction showTooltip(e,text,div, title, desc)\n{ \nif(text!=\"\"&&text==\"t2\"){\n div.style.display = \'inline\'; \n// div.style.position = \'relative\';\n div.style.position = \'absolute\';\n //div.style.float=\'right\';\n  document.getElementById(\"t2\").style.top = e.y;\n document.getElementById(\"t2\").style.left = e.x;\n div.style.width = \'200\';\n div.style.backgroundColor = \'#EFFCF0\';  \n div.style.border = \'dashed 1px black\';\n div.style.padding = \'10px\';\n //div.innerHTML = \'<b>\' + title + \'</b><div style=\"padding-left:10; padding-right:5\">\' + desc + \'</div>\';\n div.innerHTML =\'<div style=\"padding-left:10; padding-right:5\">\' + desc + \'</div>\';\n }else{\n hideTooltip(div);\n }\n \n}\n \nfunction hideTooltip(div)\n{\n div.style.display = \'none\';\n}\n</script>\n\t\n\t\t\n\t</script>\n\t\n\t ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t</head>\n\t<body OnMouseDown=\'CodeArrest();\' onKeyDown = \'lockKey()\'>\n\t<form name=\'QueryGroupResult\' id=\'QueryGroupResult\'>\n\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<P>\n\t\t\t<table align=\'right\'>\n\t\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t</tr>\n\t\t\t</table><br>\n\t\t\t</P>\n\t\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\' id=\"Qry_grp_appt_dtls\">\n\t\t\t<tr height=\'15%\'>\n\t\t\t<th class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t\t<th class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t\t<th class=\'COLUMNHEADER\' width=\"17%\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t</tr>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<td nowrap  class=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' style=\'color:blue;cursor:pointer;\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t<a href=javascript:overlap_details(\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\',\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\')>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</a>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&nbsp;</td>\t\t\t\t\t\n\t\t\t\t\t<td nowrap width=\"17%\" style=\"background-color:";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =";border-style:SOLID;border-left-color:#D5E2E5;border-right-color: #D5E2E5;border-top-color:#D5E2E5;border-bottom-color:#D5E2E5;FONT-SIZE:9pt;cursor:pointer;\" onMouseOut=\"hideTooltip(t2)\" onMouseOver=\"showTooltip(event,\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\',t2, \'Group Appointment Details\', \'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\')\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&nbsp;</td>\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\n\t</table>\n\t\n\t<div style=\"display:none;float: center;\" id=\"t2\"></div>\n\t\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));</script>\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t<script >\n\t\tif (document.getElementById(\"next\"))\n\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t</script>\n\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t<script >\n\t\tif (document.getElementById(\"next\"))\n\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\n<script>\nparent.frames[1].document.forms[0].select.disabled=false;\n</script>\n\n</form>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
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

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String fac_id		= (String) session.getValue( "facility_id" ) ;
StringBuffer sql = new StringBuffer("") ; 

StringBuffer sql1 = new StringBuffer("") ;

String locale = (String)session.getAttribute("LOCALE");
int maxRecord = 0;
String locationType = request.getParameter("locationType") ;
if (locationType ==null) locationType="";
String group_id = request.getParameter("group_id") ; 
if (group_id ==null) group_id="";
String location = request.getParameter( "location" ) ;
if (location ==null) location="";
String fromdate = request.getParameter("fromDate") ;
if (fromdate ==null) fromdate="";
String todate = request.getParameter("toDate") ;
if (todate ==null) todate="";
String from = request.getParameter("from") ;
String to = request.getParameter( "to" ) ;
fromdate=DateUtils.convertDate(fromdate,"DMY",locale,"en");
todate=DateUtils.convertDate(todate,"DMY",locale,"en");

String group_name = request.getParameter("group_name") ;
if (group_name ==null) group_name="";

/*Below line added by senthil*/
int minpat_check=0;
String min_patient= request.getParameter("min_patient");if(min_patient==null) min_patient="";
if(!min_patient.equals("")) minpat_check=Integer.parseInt(min_patient);
//End senthil 


String classValue	 = "";
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

PreparedStatement pstmt=null;

Statement stmt				= null;
ResultSet rs				= null;
Connection conn = null;	

Statement stmt1				= null;
ResultSet rs1				= null;


Statement stmt2				= null;
ResultSet rs2				= null;


try {
	conn = ConnectionManager.getConnection(request);	
	stmt = conn.createStatement();	
	stmt1 = conn.createStatement();	
	
	stmt2 = conn.createStatement();	
	
	
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);


		sql.append(" where ");  sql1.append(" where "); 
		if(!locationType.equals("")){
			sql.append("CARE_LOCN_TYPE_IND='"+locationType+"' and ") ;
			sql1.append("CARE_LOCN_TYPE_IND='"+locationType+"' and ") ;
		}
		if(!location.equals("")){
			sql.append(" clinic_code = '"+location+"' and ");
			sql1.append(" clinic_code = '"+location+"' and ");
		}
		
		if(!group_id.equals("")){
			sql.append("group_id='"+group_id+"' and ") ;
			sql1.append("group_id='"+group_id+"' and ") ;
		}

		if(!fromdate.equals("") && !todate.equals("")){
			sql.append("appt_date between to_date(nvl('"+fromdate+"','01/01/1400'),'dd/mm/yyyy') and ");
	        sql.append(" to_date(nvl('"+todate+"','31/12/5000'),'dd/mm/yyyy') ");
			sql.append("GROUP BY TO_CHAR (appt_date, 'dd/mm/yyyy'),practitioner_id,GROUP_ID,RESOURCE_CLASS,appt_slab_from_time,appt_slab_to_time order by  appt_Date , appt_slab_from_time, appt_slab_to_time DESC");
			
			sql1.append("appt_date between to_date(nvl('"+fromdate+"','01/01/1400'),'dd/mm/yyyy') and ");
	        sql1.append(" to_date(nvl('"+todate+"','31/12/5000'),'dd/mm/yyyy') ");
			}
		
		StringBuffer sqlStr = new StringBuffer("");
		sqlStr.append("select distinct TO_CHAR (appt_Date, 'dd/mm/yyyy') appt_Date,practitioner_id,group_id,count(APPT_REF_NO) as no_appt,nvl(to_char(appt_slab_from_time,'hh24:mi'),' ') appt_slab_from_time,nvl(to_char(appt_slab_to_time,'hh24:mi'),' ') appt_slab_to_time,RESOURCE_CLASS from oa_appt");
		
	   StringBuffer sqlStr1 = new StringBuffer("");
	   sqlStr1.append("select  AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1') practitioner_name1, AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2') practitioner_name2, AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2') practitioner_name3 from  oa_appt ");
	   
	   	
	   
	   sqlStr1.append(sql1.toString());
		
		sqlStr.append(sql.toString());
		
		rs = stmt.executeQuery(sqlStr.toString());
	
			 if ( start != 1 )
			 for( int j=1; j<start; i++,j++ ){
				rs.next() ;
				
			}
			while ( i<=end && rs.next() )
				{
					if(maxRecord==0)
					{
			
            _bw.write(_wl_block9Bytes, _wl_block9);
	if ( !(start <= 1) )
				
			/*Below line modified for this incident [44253]*/	
			 out.println("<td align ='right' id='prev'><A HREF='../../eOA/jsp/QueryGroupApptResult.jsp?locationType="+locationType+"&group_name="+group_name+"&min_patient="+min_patient+"&group_id="+group_id+"&location="+location+"&fromDate="+fromdate+"&toDate="+todate+"&from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

			out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eOA/jsp/QueryGroupApptResult.jsp?locationType="+locationType+"&group_name="+group_name+"&min_patient="+min_patient+"&group_id="+group_id+"&location="+location+"&fromDate="+fromdate+"&toDate="+todate+"&from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
		    sql.setLength(0);
		
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
}
					if ( i % 2 == 0 )
						classValue = "QRYEVEN" ;
					else
					classValue = "QRYODD" ;
                    
					group_id = checkForNull(rs.getString("group_id"));
					String appt_Date= checkForNull(rs.getString("appt_Date"));
					String prac_id= checkForNull(rs.getString("PRACTITIONER_ID"));
					
					//String practitioner_name=checkForNull(rs.getString("practitioner_name"));
					
					String fromTime=checkForNull(rs.getString("appt_slab_from_time"));
				    String toTime=checkForNull(rs.getString("appt_slab_to_time"));
					
					String resource_class=checkForNull(rs.getString("RESOURCE_CLASS"));
					
					int referance_count=0;String minpat_indicator=""; String div_val=""; String disply_desc="";
					referance_count=rs.getInt("no_appt"); 
					if(referance_count<minpat_check){
					minpat_indicator="#FF9F9F"; //cursor_hand="cursor:pointer;";
					div_val="t2";					
					disply_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.Grouppatient.label","oa_labels");
					}
					
					String overlapping="";int slapcount=0;
					//String count_Query="SELECT count(*) SlabOverLapCount  FROM oa_appt WHERE facility_id = '"+fac_id+"'   AND ((TO_DATE('"+fromTime+"','HH24:mi') + (1 / (60 * 24))   BETWEEN   TO_DATE(TO_CHAR(appt_slab_from_time, 'HH24:mi'),'HH24:mi') + (1 / (60 * 24)) AND TO_DATE (TO_CHAR (appt_slab_to_time, 'HH24:mi'), 'HH24:mi')) OR (TO_DATE ('"+toTime+"', 'HH24:mi') BETWEEN  TO_DATE (TO_CHAR (appt_slab_from_time, 'HH24:mi'),'HH24:mi') + (1 / (60 * 24)) AND TO_DATE (TO_CHAR (appt_slab_to_time, 'HH24:mi'), 'HH24:mi') ) OR (TO_DATE (TO_CHAR (appt_slab_from_time, 'hh24:miss'), 'hh24:miss') > TO_DATE ('"+fromTime+"', 'hh24:miss') AND TO_DATE (TO_CHAR (appt_slab_from_time, 'hh24:miss'),'hh24:miss') < TO_DATE ('"+toTime+"', 'hh24:miss'))) AND appt_date = TO_DATE ('"+appt_Date+"', 'dd/mm/yyyy')   AND patient_id IN (SELECT patient_id FROM oa_group_dtls where group_id = '"+group_id+"')  and CLINIC_CODE not in('"+location+"')";
					String count_Query="SELECT count(*) SlabOverLapCount  FROM oa_appt WHERE facility_id = ?   AND ((TO_DATE(?,'HH24:mi') + (1 / (60 * 24))   BETWEEN   TO_DATE(TO_CHAR(appt_slab_from_time, 'HH24:mi'),'HH24:mi') + (1 / (60 * 24)) AND TO_DATE (TO_CHAR (appt_slab_to_time, 'HH24:mi'), 'HH24:mi')) OR (TO_DATE (?, 'HH24:mi') BETWEEN  TO_DATE (TO_CHAR (appt_slab_from_time, 'HH24:mi'),'HH24:mi') + (1 / (60 * 24)) AND TO_DATE (TO_CHAR (appt_slab_to_time, 'HH24:mi'), 'HH24:mi') ) OR (TO_DATE (TO_CHAR (appt_slab_from_time, 'hh24:miss'), 'hh24:miss') > TO_DATE (?, 'hh24:miss') AND TO_DATE (TO_CHAR (appt_slab_from_time, 'hh24:miss'),'hh24:miss') < TO_DATE (?, 'hh24:miss'))) AND appt_date = TO_DATE (?, 'dd/mm/yyyy')   AND patient_id IN (SELECT patient_id FROM oa_group_dtls where group_id = ?)  and CLINIC_CODE not in(?)";
					
					
					//rs1 = stmt1.executeQuery(count_Query);
					pstmt = conn.prepareStatement(count_Query);
					pstmt.setString(1,fac_id);
					pstmt.setString(2,fromTime);
					pstmt.setString(3,toTime);
					pstmt.setString(4,fromTime);
					pstmt.setString(5,toTime);
					pstmt.setString(6,appt_Date);
					pstmt.setString(7,group_id);
					pstmt.setString(8,location);
					rs1 = pstmt.executeQuery();
					if(rs1.next()){
					  slapcount=rs1.getInt("SlabOverLapCount");				 	
					}
					if(0<slapcount){
					overlapping="Overlap Details";
					}else{
					overlapping="&nbsp;";
					}
					
					String practitioner_name="";
					rs2 = stmt2.executeQuery(sqlStr1.toString());
					if(rs2.next()){
					    if(resource_class.equals("P"))	
                           practitioner_name=checkForNull(rs2.getString("practitioner_name1"));
                        if(resource_class.equals("R"))	
                           practitioner_name=checkForNull(rs2.getString("practitioner_name2"));
                        if(resource_class.equals("E"))	
                           practitioner_name=checkForNull(rs2.getString("practitioner_name3")); 						
					}
					
					out.println("<tr>");
                    out.println("<td class='"+classValue+"'>" + appt_Date+"&nbsp;</td>");
					out.println("<td class='"+classValue+"'>"+practitioner_name+"&nbsp;</td>");
					out.println("<td class='"+classValue+"'>"+fromTime+"&nbsp;</td>");
					out.println("<td class='"+classValue+"'>" +toTime+"&nbsp;</td>");
					out.println("<td nowrap  class='"+classValue+"' style='color:blue;cursor:pointer;'> <a href=javascript:show_Reference_details('"+fromTime+"','"+toTime+"','"+group_id+"','"+appt_Date+"','"+prac_id+"')>"+group_name+"</a>&nbsp;</td>");
					out.println("<td nowrap  class='"+classValue+"' style='color:blue;cursor:pointer;'> <a href=javascript:show_Appointmentslip_details('"+group_id+"','"+appt_Date+"','"+prac_id+"','"+locationType+"','"+location+"','"+fromTime+"','"+toTime+"')>Appointment Slip</a></td>");
					/*Above line modified for this incident [44296]*/
					
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
if(0<slapcount){
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(fromTime));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(toTime));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(group_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(appt_Date));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(location));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(minpat_indicator));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(div_val));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(disply_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(referance_count));
            _bw.write(_wl_block24Bytes, _wl_block24);
					
					out.println("</tr>");
					i++;
					maxRecord++;
				}// while
	
            _bw.write(_wl_block25Bytes, _wl_block25);

	if(maxRecord == 0)
	{
            _bw.write(_wl_block26Bytes, _wl_block26);
}

	if ( maxRecord < 14 || (!rs.next()) ) {
	
            _bw.write(_wl_block27Bytes, _wl_block27);

			} else {
            _bw.write(_wl_block28Bytes, _wl_block28);
}
	
	if ( rs2!= null ) rs2.close() ;
	if ( stmt2 != null ) stmt2.close() ;

	if ( rs1 != null ) rs1.close() ;
	if ( stmt1 != null ) stmt1.close() ;
	
	if ( rs != null ) rs.close() ;
	if ( stmt != null ) stmt.close() ;
}
catch ( Exception e ){
	e.printStackTrace();
	//out.println("Exception  "+  e);
}

finally{

	if (conn !=null) ConnectionManager.returnConnection(conn,request);
	}

            _bw.write(_wl_block29Bytes, _wl_block29);
            _bw.write(_wl_block30Bytes, _wl_block30);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resource.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
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

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromtime.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.totime.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.AppointmentGroups.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.PrintAllSlip.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.OverlapDetails.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.noofpatsappts.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.OverlapDetails.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }
}
