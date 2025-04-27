package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.Common.*;
import eOR.*;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __customlistterminologygroupqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/CustomListTerminologyGroupQueryResult.jsp", 1709118894516L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t<script language=\"JavaScript\" src=\"../js/TerminologyGroup.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\n\tfunction Modify(obj)\n\t{\t\n\t\tvar code1=obj.cells[0].innerText;\n\t\tvar code2=escape(obj.cells[1].innerText);\n\t\tvar code3=obj.cells[2].innerText;\n\t\t//var code4=obj.cells[3].value;\n\t\t\n\t\tdocument.location.href = \"../../eMR/jsp/CustomListTerminologyGroupAddModify.jsp?mode=2&term_group_id=\"+code1+\"&term_set_id=\"+code2+\"&index_type=\"+code3+\"&effect_status=\"+code4;\n\t\t\n\t\tparent.frames[2].location.href=\"../../eMR/jsp/CustomListTerminologyGroupAddModifyDetail.jsp?mode=2&term_set_id=\"+code2+\"&term_grp_id=\"+code1+\"&index_type=\"+code3+\"&fromSearch=selectedrecord\";\n\t}\n\t</script>\n\t</head>\n\t\n\t<body OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<table cellpadding=1 cellspacing=0 width=\"100%\" align=\"center\">\n\t\t\t<tr>\n\t\t\t<td width=\"80%\" class=\"white\">&nbsp;</td>\n\t\t\t<td width=\"20%\" class=\"white\">&nbsp;\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t</td></tr>\n\t\t\t</table>\n\n\t\t\t<table border=\"2\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" id=\'result_tbl\'>\n\t\t\t<th width=\'12%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t\t<th width=\'12%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&nbsp;";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t<!--<th width=\'6%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" </th>-->\t\t\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n           <!-- <tr onClick=\"Modify(this);\" >-->\n\t\t   <tr>\n\t    ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\n                   <!-- <td class=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" onmouseover=\"changeCursor(this);\" ><font class=\'HYPERLINK\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</font></td>-->\n\t\t\t\t   <td class=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t    ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t<td align=\"center\" class=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" value=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" onclick=\"disableClick(event);\"><img src=\'../../eCommon/images/enabled.gif\'></img></td>\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" onclick=\"disableClick(event);\"><img src=\'../../eCommon/images/RRnwd.gif\'></img></td>\n\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" onclick=\"disableClick(event);\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t</tr>\n    ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t</table>\n\t</form>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\'Common\'));history.go(-1);</script> \n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t</body>\n\t</html>\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals(""))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals(""))) ? defaultValue : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

   
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	 response.addHeader("X-XSS-Protection", "1; mode=block");
	 response.addHeader("X-Content-Type-Options", "nosniff");
	//String sqlData = "select * from MR_CUSTOM_LIST_TERM_GROUP_DTL where upper(term_group_id) like upper(?) and upper(term_set_id) like upper(?) and upper(index_type) like upper(?) and upper(eff_status) like upper(?)";
	
	//String sqlData = "select TERM_GROUP_ID,TERM_SET_ID,INDEX_TYPE,AM_GET_DESC.AM_SPECIALITY(SPECIALITY_CODE,'"+localeName+"','2') SPECIALITY_DESC ,AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+localeName+"','2') PRACTITIONER_DESC,  EFF_STATUS from MR_CUSTOM_LIST_TERM_GROUP_DTL where upper(term_group_id) like upper(?) and upper(term_set_id) like upper(?) and upper(index_type) like upper(?) and upper(eff_status) like upper(?)";

	

	String status = "";
	String term_group_id	= CommonBean.checkForNull(request.getParameter("term_group_id"));
//	String term_group_desc	= CommonBean.checkForNull(request.getParameter("TerminologyGroup_desc"));
	String term_set_id		= CommonBean.checkForNull(request.getParameter("term_set_id"));
	String index_type		= CommonBean.checkForNull(request.getParameter("index_type"));
	String spclt_code		= CommonBean.checkForNull(request.getParameter("spclt_code"));
	String pract_id			= CommonBean.checkForNull(request.getParameter("pract_id"));
	String spclt_desc		= CommonBean.checkForNull(request.getParameter("spclt_desc"));
	String pract_name		= CommonBean.checkForNull(request.getParameter("pract_name"));
	//String eff_status		= CommonBean.checkForNull(request.getParameter("eff_status"));
	String term_grp_desc	= CommonBean.checkForNull(request.getParameter("terminologygroup_desc"));

	
	boolean searched		= request.getParameter( "searched" ) == null ? false : true;

	try
	{
		String classvalue	= "";
		StringBuffer sqlData = new StringBuffer("");
		//sqlData.append("select TERM_GROUP_ID,TERM_SET_ID,INDEX_TYPE,AM_GET_DESC.AM_SPECIALITY(SPECIALITY_CODE,'"+localeName+"','2') SPECIALITY_DESC ,AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+localeName+"','2') PRACTITIONER_DESC,  EFF_STATUS from MR_CUSTOM_LIST_TERM_GROUP_DTL where upper(term_group_id) like upper(?) and upper(term_set_id) like upper(?) and upper(index_type) like upper(?) and upper(eff_status) like upper(?) ");
		
		//out.println("<script>alert('comes here');</script>");
		sqlData.append("select a.TERM_GROUP_ID,a.TERM_SET_ID,a.INDEX_TYPE,AM_GET_DESC.AM_SPECIALITY(a.SPECIALITY_CODE,'"+localeName+"','2') SPECIALITY_DESC ,AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+localeName+"','2') PRACTITIONER_DESC from MR_CUSTOM_LIST_TERM_GROUP_DTL a , AM_PRACTITIONER b, AM_SPECIALITY c , mr_term_group_hdr d");

		
		sqlData.append(" where upper(a.term_group_id) like upper(?) and upper(a.term_set_id) like upper(?) and upper(a.index_type) like upper(?)  ");

		sqlData.append(" AND d.TERM_GROUP_ID= a.term_group_id AND d.TERM_SET_ID =a.term_set_id  AND  c.SPECIALITY_CODE(+)= a.SPECIALITY_CODE  and  a.PRACTITIONER_ID  =    b.PRACTITIONER_ID(+) ");
		
		if(spclt_code!=null && !spclt_code.equals("") && (pract_id ==null || pract_id.equals("")))
			sqlData.append(" and upper(a.SPECIALITY_CODE) like upper(?) ");
		
		if(pract_id!=null && !pract_id.equals("") && (spclt_code ==null || spclt_code.equals("")))
			sqlData.append(" and upper(a.PRACTITIONER_ID) like upper(?) ");

		if(spclt_code!=null && !spclt_code.equals("") && pract_id!=null && !pract_id.equals(""))
			sqlData.append(" and upper(a.SPECIALITY_CODE) like upper(?) and  upper(a.PRACTITIONER_ID) like upper(?)");

		if(spclt_desc!=null && !spclt_desc.equals("") && (pract_name ==null || pract_name.equals("")))
			sqlData.append(" and upper(c.SHORT_DESC) like upper(?) and c.SPECIALITY_CODE=a.SPECIALITY_CODE ");

		if(pract_name!=null && !pract_name.equals("") && (spclt_desc ==null || spclt_desc.equals("")))
			sqlData.append(" and upper(b.PRACTITIONER_NAME) like upper(?) and  b.PRACTITIONER_ID=a.PRACTITIONER_ID");

		if(spclt_desc!=null && !spclt_desc.equals("") && pract_name!=null && !pract_name.equals(""))
			sqlData.append(" and upper(c.SHORT_DESC) like upper(?) and  upper(b.PRACTITIONER_NAME) like upper(?) and c.SPECIALITY_CODE=a.SPECIALITY_CODE  and b.PRACTITIONER_ID=a.PRACTITIONER_ID ");
			
		if(term_grp_desc!=null && !term_grp_desc.equals(""))
			sqlData.append(" and upper(d.TERM_GROUP_DESC) like upper(?) and d.TERM_GROUP_ID=a.TERM_GROUP_ID ");


	

		HashMap sqlMap = new HashMap();
		sqlMap.put( "sqlData", sqlData.toString());

		// Function Parameters
		HashMap funcMap = new HashMap();

		// The fields are going to be display
		ArrayList displayFields = new ArrayList();
		displayFields.add( "term_group_id");
	    displayFields.add( "term_set_id");
		displayFields.add( "index_type" );
		displayFields.add( "SPECIALITY_DESC");
		displayFields.add( "PRACTITIONER_DESC" );
		//displayFields.add( "eff_status" );
	
   		
		// The fields are going to be in where condition * should match with the query
		ArrayList chkFields = new ArrayList();
		chkFields.add(term_group_id+"%");
		chkFields.add(term_set_id+"%");
		chkFields.add(index_type+"%");
		//chkFields.add(eff_status+"%");
		if(spclt_code!=null && !spclt_code.equals("") && (pract_id ==null || pract_id.equals("")))
			chkFields.add(spclt_code+"%");
		if(pract_id!=null && !pract_id.equals("") && (spclt_code ==null || spclt_code.equals("")))	
			chkFields.add(pract_id+"%");
		if(spclt_code!=null && !spclt_code.equals("") && pract_id!=null && !pract_id.equals(""))
		{
			chkFields.add(spclt_code+"%");
			chkFields.add(pract_id+"%");
		}

		if(spclt_desc!=null && !spclt_desc.equals("") && (pract_name ==null || pract_name.equals("")))
			chkFields.add(spclt_desc+"%");

		if(pract_name!=null && !pract_name.equals("") && (spclt_desc ==null || spclt_desc.equals("")))
			chkFields.add(pract_name+"%");

		if(spclt_desc!=null && !spclt_desc.equals("") && pract_name!=null && !pract_name.equals(""))
		{
			chkFields.add(spclt_desc+"%");
			chkFields.add(pract_name+"%");
		}

		if(term_grp_desc!=null && !term_grp_desc.equals(""))
			chkFields.add(term_grp_desc+"%");	
	
	
			
	// Adding function related array list into the HashMap
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );

		// Calling the Result from Common Adaptor as a arraylist.
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		
		if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) ))
		{
		
            _bw.write(_wl_block9Bytes, _wl_block9);

	
			// For display the previous/next link
			 out.println(result.get(1));
		
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
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

		
			// Retriving the records from result arraylist

			ArrayList records=new ArrayList();
			String speclt_pract_desc = "";
			for(int recCount=2; recCount<result.size(); recCount++)
			{
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
		
            _bw.write(_wl_block15Bytes, _wl_block15);

			String link_columns = "1";
			records = (ArrayList) result.get(recCount);
			for(int colCount = 0; colCount < records.size(); colCount++)
			{
				if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 )
				{    
				
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(checkForNull((String)records.get(colCount))));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(checkForNull((String)records.get(colCount))));
            _bw.write(_wl_block20Bytes, _wl_block20);
	}
				else
				{
					if(checkForNull(((String)records.get(colCount))).equals("E")) 
					{	
						status = "E";	
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(status));
            _bw.write(_wl_block23Bytes, _wl_block23);
	}
					else if(checkForNull(((String)records.get(colCount))).equals("D"))
					{
						status = "D";	
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(status));
            _bw.write(_wl_block24Bytes, _wl_block24);
	}
					else
					{	
						speclt_pract_desc = checkForNull((String)records.get(colCount));
						if(speclt_pract_desc.equals("P"))
							speclt_pract_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
						else if(speclt_pract_desc.equals("S"))
							speclt_pract_desc =
							com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
						else if(speclt_pract_desc.equals(""))
							speclt_pract_desc = "&nbsp;";
						
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(speclt_pract_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);
	}	
				}
			}	
            _bw.write(_wl_block28Bytes, _wl_block28);
	if ( records != null ) records.clear();
        }
    
            _bw.write(_wl_block29Bytes, _wl_block29);
	out.flush();
	}
	else
	{	
            _bw.write(_wl_block30Bytes, _wl_block30);
	}
		out.println(CommonBean.setForm(request ,"CustomListTerminologyGroupQueryResult.jsp", searched));
		funcMap.clear();
		sqlMap.clear();
		displayFields.clear();
		chkFields.clear();
		result.clear();
	}
	catch(Exception e)
	{
		//out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace();
	}	

            _bw.write(_wl_block31Bytes, _wl_block31);
            _bw.write(_wl_block32Bytes, _wl_block32);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMR.TerminologyID.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TermSetID.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.IndexType.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitionername.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mr_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
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
}
