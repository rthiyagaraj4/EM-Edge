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
import com.ehis.util.*;

public final class __querywaitlistauditresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/QueryWaitListAuditResult.jsp", 1731556693517L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\t<HTML>\n\t<head>\n\t<script src=\"../../eOP/js/menu.js\" language=\"JavaScript1.2\"></script>\n\t<script src=\"../../eOA/js/QueryWaitListAudit.js\"></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t</head>\n\t<body OnMouseDown=\'CodeArrest();\' onKeyDown = \'lockKey()\' onscroll=\"scrollheader()\" >\n\t<form name=\'QueryWaitListResult\' id=\'QueryWaitListResult\'>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\n\t\t<div id=\'header\' style=\"visibility:visible;backgroundColor:white;overflow:scroll;height:100vh;width:100vw\">\n\t\t\t<table border=\"1\" width=\"160%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t\t<tr>\n\t\t\t<td class=\'COLUMNHEADER\'   colspan=5>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\'   colspan=5>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\'   colspan=3>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'7%\' nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'7%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&nbsp;";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'7%\'nowrap>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\t\n\t\t\t<td class=\'COLUMNHEADER\' width=\'7%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'10%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'8%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\'25%\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t\n\t\t\t\t\t<td width=\'7%\'  class=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&nbsp;</td>\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t<td width=\'7%\'   class=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t<td width=\'7%\'  class=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' nowrap>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&nbsp;</td>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t<td  width=\'7%\'   class=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t<td width=\'7%\'   class=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&nbsp;</td>\n\t\t\t\t\t \n\t\t\t\t\t ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>&nbsp;</td>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&nbsp;</td>\n\t\t\t\t\t  ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'nowrap >";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t<td  width=\'7%\'  class=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' nowrap>&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t<td width=\'10%\'   class=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="&nbsp;</td>\n\t\t\t\t\t<td width=\'8%\'   class=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="&nbsp;</td>\n\t\t\t\t\t<td width=\'25%\'   class=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' >";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="&nbsp;</td>\n\t\t\t\t </tr>\n\t\t\t\n\t\t\n\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\')); //history.go(-1);\n\t\t\t\tparent.frames[2].document.location.href=\"../../eCommon/html/blank.html\";</script>\n\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n</table></div>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");
Connection conn=null;
ResultSet rs1=null;
ResultSet rs2=null;
Statement stmt=null;

String locale = (String)session.getAttribute("LOCALE");

String fac_id		= (String) session.getValue( "facility_id" ) ;
String patient_id=request.getParameter("patient_id");
String patientname=request.getParameter("patientname");
String inviteddate=request.getParameter("inviteddate");
String waitlistnum=request.getParameter("waitlistnum");

inviteddate=DateUtils.convertDate(inviteddate,"DMY",locale,"en");


if (!patientname.equals(""))
	{
		patientname		= 	patientname + "%" ;
	}
String Reason_for_modify="";
String OLD_PREFERRED_DATE_TIME="";
String OLD_LOCN_CODE="";
String OLD_RESOURCE_CLASS="";
String OLD_RESOURCE_ID="";
String OLD_ORDER_CATALOG_CODE="";
String OLD_WAITLIST_CATEGORY_DESC="";
String NEW_PREFERRED_DATE_TIME="";
String NEW_LOCN_CODE="";
String NEW_RESOURCE_CLASS="";
String NEW_RESOURCE_ID="";
String NEW_RESOURCE_DESC="";
String OLD_RESOURCE_DESC="";
String NEW_LOCN_DESC="";
String OLD_LOCN_DESC="";
String NEW_ORDER_CATALOG_CODE="";
String NEW_WAITLIST_CATEGORY_DESC="";
String OLD_WAITLIST_CATEGORY_CODE="";
String NEW_WAITLIST_CATEGORY_CODE="";
String NEW_ORDER_CATALOG_DESC="";
String OLD_ORDER_CATALOG_DESC="";
String classValue="";
String WAIT_LIST_NO1="";
StringBuffer sql1=new StringBuffer("" );
StringBuffer sqlStr=new StringBuffer("");
StringBuffer sqlstr1 = new StringBuffer("");
int maxrecord=0;
int i=0;


try {
	conn = ConnectionManager.getConnection(request);
	stmt=conn.createStatement();



		String install_yn_val="";	

				String sql_OR="select Operational_yn from sm_modules_facility where facility_id = '"+fac_id+"' and module_id = 'OR' ";
				rs2=stmt.executeQuery(sql_OR);
					if(rs2 !=null )
					{
						while (rs2.next())
						{
						install_yn_val=rs2.getString("Operational_yn");
						}

					}
			if(rs2 !=null)rs2.close();



	
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		

	
	if(!waitlistnum.equals(""))
		{
			sql1.append(" and b.wait_list_no='"+waitlistnum+"'");
		}
		if(!patientname.equals(""))
		{
			
			if(locale.equals("en"))
			{
			sql1.append(" and UPPER(a.PATIENT_NAME) like upper('"+patientname+"%')"); 
			}else if(locale.equals("th"))
			{
			sql1.append(" and UPPER(a.PATIENT_NAME_LOC_LANG) like upper('"+patientname+"%')"); 
			}
		}
		if(!inviteddate.equals(""))
		{
			sql1.append(" and to_char(a.INVITED_DATE_TIME,'dd/mm/yyyy')='"+inviteddate+"'");
		}
		if(!patient_id.equals(""))
		{
			sql1.append(" and a.PATIENT_ID='"+patient_id+"'");
		}
		sql1.append("order by b.ADDED_DATE desc");

	
	 
			sqlStr.append("select b.WAIT_LIST_NO,a.PATIENT_ID ");
	
		if(locale.equals("en"))
	{
		sqlStr.append(", a.patient_name");
	}else if(locale.equals("th"))
	{
		sqlStr.append(", a.PATIENT_NAME_LOC_LANG");
	}
		sqlStr.append(",a.INVITED_DATE_TIME,AM_GET_DESC.AM_CONTACT_REASON(a.REASON_FOR_MODIFY,'"+locale+"','1')  REASON_FOR_MODIFY ,b.ADDED_BY_ID, to_char(b.ADDED_DATE,'dd/mm/yyyy hh24:mi')ADDED_DATE ,to_char(b.OLD_PREFERRED_DATE_TIME,'dd/mm/yyyy')OLD_PREFERRED_DATE_TIME , b.OLD_LOCN_CODE, b.old_resource_class, b.OLD_RESOURCE_ID,b.OLD_ORDER_CATALOG_CODE, b.OLD_WAITLIST_CATEGORY_CODE, to_char(b.NEW_PREFERRED_DATE_TIME,'dd/mm/yyyy')NEW_PREFERRED_DATE_TIME, b.NEW_LOCN_CODE,  b.NEW_RESOURCE_CLASS , b.NEW_RESOURCE_ID, b.NEW_ORDER_CATALOG_CODE, b.NEW_WAITLIST_CATEGORY_CODE ,	decode(a.CARE_LOCN_TYPE_IND,'N', (case when b.old_locn_code is not null then (IP_GET_DESC.IP_NURSING_UNIT('"+fac_id+"', b.old_locn_code,'"+locale+"','2')) end),(case when b.old_locn_code is not null then(OP_GET_DESC.OP_CLINIC('"+fac_id+"', b.old_locn_code, '"+locale+"','2')) end)) old_locn_desc,decode(a.CARE_LOCN_TYPE_IND,'N', (case when b.new_locn_code is not null then (IP_GET_DESC.IP_NURSING_UNIT('"+fac_id+"', b.new_locn_code,'"+locale+"','2'))end),(case when b.new_locn_code is not null then (OP_GET_DESC.OP_CLINIC('"+fac_id+"', b.new_locn_code, '"+locale+"','2')) end)) new_locn_desc,(case when b.OLD_WAITLIST_CATEGORY_CODE is not null then  (OA_GET_DESC.OA_WAITLIST_CATEGORY(b.OLD_WAITLIST_CATEGORY_CODE , '"+locale+"','2')) end) waitlist,(case when b.NEW_WAITLIST_CATEGORY_CODE is not null then (OA_GET_DESC.OA_WAITLIST_CATEGORY(b.NEW_WAITLIST_CATEGORY_CODE , '"+locale+"','2')) end) waitlistnew,(case when b.new_resource_id is not null then decode(a.RESOURCE_CLASS,'P',(am_get_desc.am_practitioner(b.new_resource_id,'"+locale+"',1)),'R',(AM_GET_DESC.AM_FACILITY_ROOM('"+fac_id+"', b.new_resource_id,'"+locale+"','2')),'E', (AM_GET_DESC.AM_RESOURCE('"+fac_id+"', b.new_resource_id,'"+locale+"','2')))end) new_resource_id_name,(case when b.old_resource_id is not null then decode(a.RESOURCE_CLASS,'P',(am_get_desc.am_practitioner(b.old_resource_id,'"+locale+"',1)),'R',(AM_GET_DESC.AM_FACILITY_ROOM('"+fac_id+"', b.old_resource_id,'"+locale+"','2')),'E', (AM_GET_DESC.AM_RESOURCE('"+fac_id+"', b.old_resource_id,'"+locale+"','2')))end) old_resource_id_name");
		
		if(install_yn_val.equals("Y"))
		{
		sqlStr.append(",(CASE WHEN b.OLD_ORDER_CATALOG_CODE IS NOT NULL THEN (SELECT short_desc    FROM OR_ORDER_CATALOG_lang_vw WHERE ORDER_CATALOG_CODE =b.OLD_ORDER_CATALOG_CODE and language_id='"+locale+"') END ) ordercatalogold, (CASE WHEN b.NEW_ORDER_CATALOG_CODE IS NOT NULL THEN (SELECT short_desc FROM OR_ORDER_CATALOG_lang_vw   WHERE ORDER_CATALOG_CODE = b.NEW_ORDER_CATALOG_CODE and language_id='"+locale+"') END ) ordercatalognew ");
		}
		
		
		
		
		sqlStr.append("from pr_wait_list a,pr_wait_list_audit b where a.WAIT_LIST_NO=b.WAIT_LIST_NO and a.wait_list_no='"+waitlistnum+"'");
		sqlStr.append(sql1.toString()) ;
	//out.println(sqlStr);
		rs1=stmt.executeQuery(sqlStr.toString());
	
			if(rs1 !=null )
		{
			while(rs1.next())
			{
				if(maxrecord==0)
				{

	 
	 
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
 }
		
	/*	sqlStr.append("select b.WAIT_LIST_NO,a.PATIENT_ID ");
	
		if(locale.equals("en"))
	{
		sqlStr.append(", a.patient_name");
	}else if(locale.equals("th"))
	{
		sqlStr.append(", a.PATIENT_NAME_LOC_LANG");
	}
		sqlStr.append(",a.INVITED_DATE_TIME,AM_GET_DESC.AM_CONTACT_REASON(a.REASON_FOR_MODIFY,'"+locale+"','1')  REASON_FOR_MODIFY ,b.ADDED_BY_ID, to_char(b.ADDED_DATE,'dd/mm/yyyy hh24:mi')ADDED_DATE ,to_char(b.OLD_PREFERRED_DATE_TIME,'dd/mm/yyyy')OLD_PREFERRED_DATE_TIME , b.OLD_LOCN_CODE, b.old_resource_class, b.OLD_RESOURCE_ID,b.OLD_ORDER_CATALOG_CODE, b.OLD_WAITLIST_CATEGORY_CODE, to_char(b.NEW_PREFERRED_DATE_TIME,'dd/mm/yyyy')NEW_PREFERRED_DATE_TIME, b.NEW_LOCN_CODE,  b.NEW_RESOURCE_CLASS , b.NEW_RESOURCE_ID, b.NEW_ORDER_CATALOG_CODE, b.NEW_WAITLIST_CATEGORY_CODE ,	decode(a.CARE_LOCN_TYPE_IND,'N', (case when b.old_locn_code is not null then (IP_GET_DESC.IP_NURSING_UNIT('"+fac_id+"', b.old_locn_code,'"+locale+"','2')) end),(case when b.old_locn_code is not null then(OP_GET_DESC.OP_CLINIC('"+fac_id+"', b.old_locn_code, '"+locale+"','1')) end)) old_locn_desc,decode(a.CARE_LOCN_TYPE_IND,'N', (case when b.new_locn_code is not null then (IP_GET_DESC.IP_NURSING_UNIT('"+fac_id+"', b.new_locn_code,'"+locale+"','2'))end),(case when b.new_locn_code is not null then (OP_GET_DESC.OP_CLINIC('"+fac_id+"', b.new_locn_code, '"+locale+"','2')) end)) new_locn_desc,(case when b.OLD_WAITLIST_CATEGORY_CODE is not null then  (OA_GET_DESC.OA_WAITLIST_CATEGORY(b.OLD_WAITLIST_CATEGORY_CODE , '"+locale+"','2')) end) waitlist,(case when b.NEW_WAITLIST_CATEGORY_CODE is not null then (OA_GET_DESC.OA_WAITLIST_CATEGORY(b.NEW_WAITLIST_CATEGORY_CODE , '"+locale+"','2')) end) waitlistnew,(case when b.new_resource_id is not null then decode(a.RESOURCE_CLASS,'P',(am_get_desc.am_practitioner(b.new_resource_id,'"+locale+"',1)),'R',(AM_GET_DESC.AM_FACILITY_ROOM('"+fac_id+"', b.new_resource_id,'"+locale+"','2')),'E', (AM_GET_DESC.AM_RESOURCE('"+fac_id+"', b.new_resource_id,'"+locale+"','2')))end) new_resource_id_name,(case when b.old_resource_id is not null then decode(a.RESOURCE_CLASS,'P',(am_get_desc.am_practitioner(b.old_resource_id,'"+locale+"',1)),'R',(AM_GET_DESC.AM_FACILITY_ROOM('"+fac_id+"', b.old_resource_id,'"+locale+"','2')),'E', (AM_GET_DESC.AM_RESOURCE('"+fac_id+"', b.old_resource_id,'"+locale+"','2')))end) old_resource_id_name");
		
		if(install_yn_val.equals("Y"))
		{
		sqlStr.append(",(CASE WHEN b.OLD_ORDER_CATALOG_CODE IS NOT NULL THEN (SELECT short_desc    FROM OR_ORDER_CATALOG_lang_vw WHERE ORDER_CATALOG_CODE =b.OLD_ORDER_CATALOG_CODE and language_id='"+locale+"') END ) ordercatalogold, (CASE WHEN b.NEW_ORDER_CATALOG_CODE IS NOT NULL THEN (SELECT short_desc FROM OR_ORDER_CATALOG_lang_vw   WHERE ORDER_CATALOG_CODE = b.NEW_ORDER_CATALOG_CODE and language_id='"+locale+"') END ) ordercatalognew ");
		}
		
		
		
		
		sqlStr.append("from pr_wait_list a,pr_wait_list_audit b where a.WAIT_LIST_NO=b.WAIT_LIST_NO and a.wait_list_no='"+waitlistnum+"'");
		sqlStr.append(sql1.toString()) ;
	//out.println(sqlStr);
		rs1=stmt.executeQuery(sqlStr.toString()); */
		
	
				if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
				    classValue = "QRYODD" ;
		
			patient_id=rs1.getString("PATIENT_ID");
			if(patient_id==null)patient_id="";
			OLD_PREFERRED_DATE_TIME=rs1.getString("OLD_PREFERRED_DATE_TIME");
			if(OLD_PREFERRED_DATE_TIME ==null)OLD_PREFERRED_DATE_TIME="";

			String OLD_PREFERRED_DATE_TIME_DISP= DateUtils.convertDate(OLD_PREFERRED_DATE_TIME,"DMY","en",locale);

			NEW_PREFERRED_DATE_TIME=rs1.getString("NEW_PREFERRED_DATE_TIME");
			if(NEW_PREFERRED_DATE_TIME ==null)NEW_PREFERRED_DATE_TIME="";

			String NEW_PREFERRED_DATE_TIME_DISP= DateUtils.convertDate(NEW_PREFERRED_DATE_TIME,"DMY","en",locale);

			String ADDED_DATE= rs1.getString("ADDED_DATE");
			if(ADDED_DATE ==null)ADDED_DATE="";
			String ADDED_DATE_DISP= DateUtils.convertDate(ADDED_DATE,"DMYHM","en",locale);

			Reason_for_modify=rs1.getString("REASON_FOR_MODIFY");
			if(Reason_for_modify==null) Reason_for_modify="";
			//if(Reason_for_modify.length() >10)
			//Reason_for_modify=Reason_for_modify.substring(0,10);

			OLD_LOCN_CODE=rs1.getString("OLD_LOCN_CODE");
			if(OLD_LOCN_CODE ==null) OLD_LOCN_CODE="";
			NEW_LOCN_CODE=rs1.getString("NEW_LOCN_CODE");
			if(NEW_LOCN_CODE==null)NEW_LOCN_CODE="";

			OLD_LOCN_DESC=rs1.getString("old_locn_desc");
			if(OLD_LOCN_DESC==null) OLD_LOCN_DESC="";
			//if(OLD_LOCN_DESC.length() >10)
			//	OLD_LOCN_DESC=OLD_LOCN_DESC.substring(0,10);

			NEW_LOCN_DESC=rs1.getString("new_locn_desc");
			if(NEW_LOCN_DESC==null) NEW_LOCN_DESC="";
		//	if(NEW_LOCN_DESC.length() >10)
		//		NEW_LOCN_DESC=NEW_LOCN_DESC.substring(0,10);


			OLD_RESOURCE_ID=rs1.getString("OLD_RESOURCE_ID");
			if(OLD_RESOURCE_ID==null)OLD_RESOURCE_ID="";
			NEW_RESOURCE_ID=rs1.getString("NEW_RESOURCE_ID");
			if(NEW_RESOURCE_ID==null)NEW_RESOURCE_ID="";

			NEW_RESOURCE_CLASS=rs1.getString("NEW_RESOURCE_CLASS");
			if(NEW_RESOURCE_CLASS==null)NEW_RESOURCE_CLASS="";

			

			OLD_RESOURCE_CLASS=rs1.getString("OLD_RESOURCE_CLASS");
			if(OLD_RESOURCE_CLASS==null)OLD_RESOURCE_CLASS="";


			OLD_RESOURCE_DESC=rs1.getString("old_resource_id_name");
			if(OLD_RESOURCE_DESC ==null)OLD_RESOURCE_DESC="";

			
			if(OLD_RESOURCE_CLASS.equals("P"))
			{
				 OLD_RESOURCE_DESC=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
			 }
			 else if(OLD_RESOURCE_CLASS.equals("E"))
			{
				OLD_RESOURCE_DESC=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
			  }
			  else if(OLD_RESOURCE_CLASS.equals("R"))
			{
				OLD_RESOURCE_DESC=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
			}
			else if(OLD_RESOURCE_CLASS.equals("O"))
			{
				OLD_RESOURCE_DESC=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
			}


			//if(OLD_RESOURCE_DESC.length() >10)
			//	OLD_RESOURCE_DESC=OLD_RESOURCE_DESC.substring(0,10);

			NEW_RESOURCE_DESC=rs1.getString("new_resource_id_name");
			if(NEW_RESOURCE_DESC ==null)NEW_RESOURCE_DESC="";

			if(NEW_RESOURCE_CLASS.equals("P"))
			{
				 NEW_RESOURCE_DESC=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
			 }
			 else if(NEW_RESOURCE_CLASS.equals("E"))
			{
				NEW_RESOURCE_DESC=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
			  }
			  else if(NEW_RESOURCE_CLASS.equals("R"))
			{
				NEW_RESOURCE_DESC=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
			}
			else if(NEW_RESOURCE_CLASS.equals("O"))
			{
				NEW_RESOURCE_DESC=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
			}

			//if(NEW_RESOURCE_DESC.length() >10)
			//	NEW_RESOURCE_DESC=NEW_RESOURCE_DESC.substring(0,10);


			OLD_ORDER_CATALOG_CODE=rs1.getString("OLD_ORDER_CATALOG_CODE");
			if(OLD_ORDER_CATALOG_CODE==null)OLD_ORDER_CATALOG_CODE="";
			NEW_ORDER_CATALOG_CODE=rs1.getString("NEW_ORDER_CATALOG_CODE");
			if(NEW_ORDER_CATALOG_CODE==null)NEW_ORDER_CATALOG_CODE="";

			OLD_WAITLIST_CATEGORY_CODE=rs1.getString("OLD_WAITLIST_CATEGORY_CODE");
			if(OLD_WAITLIST_CATEGORY_CODE==null)OLD_WAITLIST_CATEGORY_CODE="";
			NEW_WAITLIST_CATEGORY_CODE=rs1.getString("NEW_WAITLIST_CATEGORY_CODE");
			if(NEW_WAITLIST_CATEGORY_CODE==null)NEW_WAITLIST_CATEGORY_CODE="";

			OLD_WAITLIST_CATEGORY_DESC=rs1.getString("waitlist");
			if(OLD_WAITLIST_CATEGORY_DESC==null)OLD_WAITLIST_CATEGORY_DESC="";
		//	if(OLD_WAITLIST_CATEGORY_DESC.length() > 10)
		//	OLD_WAITLIST_CATEGORY_DESC=OLD_WAITLIST_CATEGORY_DESC.substring(0,10);

			NEW_WAITLIST_CATEGORY_DESC=rs1.getString("waitlistnew");
			if(NEW_WAITLIST_CATEGORY_DESC==null)NEW_WAITLIST_CATEGORY_DESC="";
			// if(NEW_WAITLIST_CATEGORY_DESC.length() > 10)
			// NEW_WAITLIST_CATEGORY_DESC=NEW_WAITLIST_CATEGORY_DESC.substring(0,10);
			
			if(install_yn_val.equals("Y"))
		{
			OLD_ORDER_CATALOG_DESC=rs1.getString("ordercatalogold");
			if(OLD_ORDER_CATALOG_DESC==null)OLD_ORDER_CATALOG_DESC="";
			//if(OLD_ORDER_CATALOG_DESC.length() > 10)
			//OLD_ORDER_CATALOG_DESC=OLD_ORDER_CATALOG_DESC.substring(0,10);	

			NEW_ORDER_CATALOG_DESC=rs1.getString("ordercatalognew");
			if(NEW_ORDER_CATALOG_DESC==null)NEW_ORDER_CATALOG_DESC="";
			//if(NEW_ORDER_CATALOG_DESC.length() > 15)
			//NEW_ORDER_CATALOG_DESC=NEW_ORDER_CATALOG_DESC.substring(0,10);
		}

			WAIT_LIST_NO1=rs1.getString("WAIT_LIST_NO");
			if(WAIT_LIST_NO1==null)WAIT_LIST_NO1="";
			
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(OLD_PREFERRED_DATE_TIME_DISP));
            _bw.write(_wl_block23Bytes, _wl_block23);
if(OLD_LOCN_CODE.equals("")){
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
}else{
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(OLD_LOCN_DESC));
            _bw.write(_wl_block28Bytes, _wl_block28);
}
            _bw.write(_wl_block29Bytes, _wl_block29);
if(OLD_RESOURCE_CLASS.equals("")){
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
}else{
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(OLD_RESOURCE_DESC));
            _bw.write(_wl_block30Bytes, _wl_block30);
}
            _bw.write(_wl_block29Bytes, _wl_block29);
if(OLD_WAITLIST_CATEGORY_CODE.equals("")){
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
}else{
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(OLD_WAITLIST_CATEGORY_DESC));
            _bw.write(_wl_block30Bytes, _wl_block30);
}
            _bw.write(_wl_block29Bytes, _wl_block29);
if(OLD_ORDER_CATALOG_CODE.equals("")){
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
}else{
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(OLD_ORDER_CATALOG_DESC));
            _bw.write(_wl_block30Bytes, _wl_block30);
}
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(NEW_PREFERRED_DATE_TIME_DISP));
            _bw.write(_wl_block33Bytes, _wl_block33);
if(NEW_LOCN_CODE.equals("")){
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block34Bytes, _wl_block34);
}else{
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(NEW_LOCN_DESC));
            _bw.write(_wl_block35Bytes, _wl_block35);
}
            _bw.write(_wl_block36Bytes, _wl_block36);
if(NEW_RESOURCE_CLASS.equals("")){
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
}else{
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(NEW_RESOURCE_DESC));
            _bw.write(_wl_block30Bytes, _wl_block30);
}
            _bw.write(_wl_block38Bytes, _wl_block38);
if(NEW_WAITLIST_CATEGORY_CODE.equals("")){
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
}else{
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(NEW_WAITLIST_CATEGORY_DESC));
            _bw.write(_wl_block30Bytes, _wl_block30);
}
            _bw.write(_wl_block39Bytes, _wl_block39);
if(NEW_ORDER_CATALOG_CODE.equals("")){
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block41Bytes, _wl_block41);
}else{
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(NEW_ORDER_CATALOG_DESC));
            _bw.write(_wl_block30Bytes, _wl_block30);
}
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Reason_for_modify));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rs1.getString("ADDED_BY_ID")));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(ADDED_DATE_DISP));
            _bw.write(_wl_block46Bytes, _wl_block46);
 i++;
		maxrecord++;
		}//end of while
		}

		if(maxrecord == 0)
		{
            _bw.write(_wl_block47Bytes, _wl_block47);
}

	sqlstr1.setLength(0);
	sqlStr.setLength(0);
	sql1.setLength(0);
	if(stmt !=null)stmt.close();
	if(rs1 !=null)rs1.close();
}catch ( Exception e ){
	//out.println("Exception " +e);
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}finally{
	ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block48Bytes, _wl_block48);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OldValue.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NewValue.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otherDetails.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PreferredDate.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.LocationDesc.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resource.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.category1.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.catalog.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PreferredDate.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.LocationDesc.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resource.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.category1.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }

    private boolean _jsp__tag14(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag14 = null ;
        int __result__tag14 = 0 ;

        if (__tag14 == null ){
            __tag14 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag14);
        }
        __tag14.setPageContext(pageContext);
        __tag14.setParent(null);
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.catalog.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag14;
        __result__tag14 = __tag14.doStartTag();

        if (__result__tag14!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag14== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag14.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag14);
            return true;
        }
        _activeTag=__tag14.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag14);
        __tag14.release();
        return false;
    }

    private boolean _jsp__tag15(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag15 = null ;
        int __result__tag15 = 0 ;

        if (__tag15 == null ){
            __tag15 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag15);
        }
        __tag15.setPageContext(pageContext);
        __tag15.setParent(null);
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.ReasonForModify.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag15;
        __result__tag15 = __tag15.doStartTag();

        if (__result__tag15!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag15== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag15.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag15);
            return true;
        }
        _activeTag=__tag15.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag15);
        __tag15.release();
        return false;
    }

    private boolean _jsp__tag16(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag16 = null ;
        int __result__tag16 = 0 ;

        if (__tag16 == null ){
            __tag16 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag16);
        }
        __tag16.setPageContext(pageContext);
        __tag16.setParent(null);
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.modifiedby.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag16;
        __result__tag16 = __tag16.doStartTag();

        if (__result__tag16!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag16== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag16.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag16);
            return true;
        }
        _activeTag=__tag16.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag16);
        __tag16.release();
        return false;
    }

    private boolean _jsp__tag17(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag17 = null ;
        int __result__tag17 = 0 ;

        if (__tag17 == null ){
            __tag17 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag17);
        }
        __tag17.setPageContext(pageContext);
        __tag17.setParent(null);
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.ModifiedOn.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag17;
        __result__tag17 = __tag17.doStartTag();

        if (__result__tag17!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag17== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag17.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag17);
            return true;
        }
        _activeTag=__tag17.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag17);
        __tag17.release();
        return false;
    }
}
