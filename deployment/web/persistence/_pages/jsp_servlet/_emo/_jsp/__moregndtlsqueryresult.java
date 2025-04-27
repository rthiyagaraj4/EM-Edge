package jsp_servlet._emo._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import java.net.*;
import java.util.*;
import com.ehis.util.*;

public final class __moregndtlsqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emo/jsp/MORegnDtlsQueryResult.jsp", 1742813117587L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n <html>\n    <head>\n\t    ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n      <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n        <script language=\'javascript\' src=\'../../eCommon/js/common.js\' ></script>\n\t\t\n\t\t<script language=\'javascript\' src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eMO/js/MORegDetailsQuery.js\' ></script>\n\t\t<script language=\'javascript\' src=\'../../eMO/js/MOAreaAvailabilityQueryCriteria.js\' ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t</head>                         \n\t\t<body  onMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n\t\t<form name = \'MOAreaAvailabilityQueryResult_form\'>\n ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t\t\t <p>\n\t<table align=\'right\'>\n\t<tr>\n\t<td>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t</td>\n\t</tr>\n\t</table>\n\t</p>\n\n<br>\n<br>\n\t\t\t\t\n\t\t  <table cellspacing=0 cellpadding=0 align=\'center\' width=\'100%\' border=\'1\' cellpadding=0 cellspacing=0>\n\t\t    <th>&nbsp;</th>\t<!--Modified by Shanmukh for ML-MMOH-CRF-1036-->\t\t\n\t\t    <th>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th> \n\t\t\t<th>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="<br>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t\t\n\t\t   <th>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t\t<th>\n\t\t   ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t         ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>\n\t\t\t<th>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n\t\t\t<th nowrap>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\t\n\t\t\t<th>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</th>\t\n\t\t    ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t         <th>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</th>\n\t       ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\n\t\t\t <th>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</th>\t\t \n\t\t \n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t<tr><th colspan=13 align=left><B>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="/";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</B></th></tr>\n\t ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\n    \n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\n\t<tr>\n\t<!-- <td class=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t<a name=\'desc1\' href=\"javascript:showAllowedOperations(\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\',\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\')\" > <font size=1>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</a></td> -->\n\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" \n\t<td style=\'background-color:maroon;color:white\' width=\'3%\'>&nbsp;P</td>\n\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t<td style=\'background-color:yellow;color:maroon\' width=\'3%\'>&nbsp;P</td>\n\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t<td>&nbsp;</Td>\n\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\n\t\t\n\t\t<td class=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'  ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="> <font size=1>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t<td class=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" > <font size=1>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' align=\'right\'  ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n\t\t\n\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t<td  style=\'background-color:black;\'>\n\t\t<a name=\'desc1\' style=\"color:white\" href=\'javascript:showAllowedOperations1(\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\",\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\")\' > <font size=1>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</a></td>\n\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t<td class=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =">\n\t\t<a name=\'desc1\' href=\'javascript:showAllowedOperations1(\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</a></td>\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" align=\'left\'> <font size=1>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'   ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" </td>\n\t\t<td class=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t   <td class=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =" ><font size=1> ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td>\n\t   ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t<!--Style Added by Santhosh for ML-MMOH-CRF-1947>-->\n\t\t<td class=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' align=\'left\' ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" style=\'word-wrap:break-word;width:300px;\'> <font size=1>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>\n\t\t\t\n\t\t\t\n\t\t\n    </tr>\n ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n   </table>\n        <br>\n\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="<script>\n\t\t\tif(parent.frames[1].document.forms[0] != null)\n\t\t\tparent.frames[1].document.forms[0].search.disabled=false\n\t\t  </script>\n\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t  <input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'>\n\n       </form>\n    </body>\n  </html>\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

        request.setCharacterEncoding("UTF-8");
		String atype                      = checkForNull(request.getParameter("atype"));
		String HIGH_RISK_BODY_YN="";
		String colordisplay="";
		String brought_dead_yn="";
		String postmortem_type="";
		String rno						  = checkForNull(request.getParameter("rno"));
		String pid						  = checkForNull(request.getParameter("pid"));
		String pmstatus					  = checkForNull(request.getParameter("pmstatus"));
		String rstatus					  = checkForNull(request.getParameter("rstatus"));
		String bdprtyn="";
		String bdprt="";
		String BODY_PART_OBTAINED_FROM_DESC="";
		String frmdate					  = checkForNull(request.getParameter("frmdate"));
		String todate                     = checkForNull(request.getParameter("todate"));
		String burial_permit_no		= request.getParameter("burial_permit_no")==null?"":request.getParameter("burial_permit_no");
    	String bur_perm_no="";
		String obtained_from			= request.getParameter("obt_frm")==null?"":request.getParameter("obt_frm");
		String function_id			= request.getParameter("function_id")==null?"":request.getParameter("function_id");

		if(atype.equals("")) atype        = "%";
		if(rno.equals("")) rno            = "%";
		if(pid.equals("")) pid            = "%";
		if(pmstatus.equals("")) pmstatus  = "%";
		if(todate.equals("")) todate      = "";
		if(frmdate.equals("")) frmdate    = "01/01/1800 00:00";
		String area_type_desc="";
		String area	                      = checkForNull(request.getParameter("area"));
		String gender	                      = checkForNull(request.getParameter("gender"));
		if(area.equals("")) area          = "%";
		String enc_id		              = "";
		String dis_rno		              = "";
		String dis_pid		              = "";
		String dis_pname	              = "";
		String dis_age		              = "";
		String patient_deceased_age       = "";
		String dis_sex		              = "";
		String dis_pmyn		              = "";
		String dis_pmstat	              = "";
		String by_recd_dt                 = "";
		String dis_acode                  = "";
		String dis_atype                  = "";
		String dis_pmstatdesc             ="";
		String RELEASE_BODY_YN            = "";
		String by_recd_dt_disply		  = "";
		String from = request.getParameter( "from" ) ;
	    String to = request.getParameter( "to" ) ;
        int start = 0 ;
    	int end = 0 ;
	    int l=1;
        if ( from == null )
	    start = 1 ;
	    else
	    start = Integer.parseInt( from ) ;
        if ( to == null )
	    end =6 ;
	    else
	    end = Integer.parseInt( to ) ;
   

 
            _bw.write(_wl_block6Bytes, _wl_block6);

     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		Connection	    con		= null;
		Statement		st		= null;
		ResultSet		rs		= null;			        
		String facility_id = (String)session.getValue("facility_id");
		String locale = (String)session.getAttribute("LOCALE");
				
 
            _bw.write(_wl_block9Bytes, _wl_block9);

		String classValue	= "";
		int rowIndex		= 1;
		String AREA_DESC    ="";
		String prevcode     ="";
		int ccount          = 0;
		Boolean isReceivedDateTimeAppl;
        try
			{
			con	= ConnectionManager.getConnection(request);
			isReceivedDateTimeAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MO","RECEIVED_DATE_TIME");// Added by Shanmukh for ML-MMOH-CRF-1036		
			/*st	= con.createStatement();
			rs  =st.executeQuery("select AREA_DESC from mo_area_vw where AREA_CODE ='"+area+"'");
			while(rs!=null && rs.next())
			{
				area = rs.getString(1);
			}
			if (rs!=null) rs.close();
			if (st!=null) st.close();*/
			StringBuffer getcount = new StringBuffer();
			getcount.append("select count(*) from  mo_mortuary_regn_vw where upper(REGISTRATION_NO) like upper('"+rno+"') and upper(NVL(PATIENT_ID,'*')) like upper('"+pid+"') and NVL(AREA_CODE,'*') like  ('"+area+"') AND NVL(area_type,'*') LIKE ('"+atype+"') and upper(POSTMORTEM_STATUS) like upper('"+pmstatus+"') ");

			if(rstatus.equals("R"))
			    getcount.append("and RELEASE_BODY_DATE is not null ");
			else if(rstatus.equals("C"))
				getcount.append("and RELEASE_BODY_DATE is null ");
							 
		if(obtained_from.equals("C"))
        {
        getcount.append(" and  BODY_PART_OBTAINED_FROM is  null");
       }else if(obtained_from.equals("A")||obtained_from.equals("U")||obtained_from.equals("D")||(!obtained_from.equals("C")))
        {
       getcount.append(" and  BODY_PART_OBTAINED_FROM like '"+obtained_from+"%'");
       }
		    getcount.append(" and  SEX LIKE '"+gender+"%'");
			getcount.append(" and  NVL(BURIAL_PERMIT_NO,'*') LIKE '"+burial_permit_no+"%'");
			//getcount.append("and BODY_PART_OBTAINED_FROM is null  ");
			getcount.append("and facility_id ='"+facility_id+"' and to_date(substr(BODY_RECEIVED_DATE,1,10),'dd/mm/yyyy') between to_date('"+frmdate+"','dd/mm/yyyy')");
			if(todate.equals("")) getcount.append("and (sysdate)");
			else getcount.append("and to_date('"+todate+"','dd/mm/yyyy')");
			
			
			st=con.createStatement();
			
			rs = st.executeQuery(getcount.toString());
			while(rs!=null && rs.next())
			{
				ccount = rs.getInt(1);
			}
			if (rs!=null) rs.close();
			if (st!=null) st.close();
		    if(ccount > 0)
			{
            _bw.write(_wl_block10Bytes, _wl_block10);

	if ( !(start <= 1) )
		out.println("<A HREF='../jsp/MORegnDtlsQueryResult.jsp?function_id="+function_id+"&from="+(start-6)+"&to="+(end-6)+"&rno="+URLEncoder.encode(rno)+"&pid="+URLEncoder.encode(pid)+"&pmstatus="+URLEncoder.encode(pmstatus)+"&rstatus="+URLEncoder.encode(rstatus)+"&frmdate="+URLEncoder.encode(frmdate)+"&todate="+URLEncoder.encode(todate)+"&burial_permit_no="+URLEncoder.encode(	burial_permit_no)+"&obt_frm="+URLEncoder.encode(obtained_from)+"&area="+URLEncoder.encode(area)+"&gender="+URLEncoder.encode(gender)+"'"+"text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

	if ( !( (start+6) > ccount ) )
		out.println("<A HREF='../jsp/MORegnDtlsQueryResult.jsp?function_id="+function_id+"&from="+(start+6)+"&to="+(end+6)+"&rno="+URLEncoder.encode(rno)+"&pid="+URLEncoder.encode(pid)+"&pmstatus="+URLEncoder.encode(pmstatus)+"&rstatus="+URLEncoder.encode(rstatus)+"&frmdate="+URLEncoder.encode(frmdate)+"&todate="+URLEncoder.encode(todate)+"&burial_permit_no="+URLEncoder.encode(burial_permit_no)+"&obt_frm="+URLEncoder.encode(obtained_from)+"&area="+URLEncoder.encode(area)+"&gender="+URLEncoder.encode(gender)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

	
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
if(isReceivedDateTimeAppl){

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
}else{

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
if(obtained_from.equals("C"))
             {
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
}else{
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
if(!obtained_from.equals("C"))
             {
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

			StringBuffer operSql = new StringBuffer();
		/*	operSql.append("select BURIAL_PERMIT_NO,BODY_PART_OBTAINED_FROM_DESC,postmortem_type,HIGH_RISK_BODY_YN,BROUGHT_DEAD_YN ,REGISTRATION_NO,BODY_RECEIVED_DATE,BODY_PART_OBTAINED_FROM,PATIENT_ID,ENCOUNTER_ID, PATIENT_NAME,AGE,SEX,PM_YN,POSTMORTEM_STATUS,POSTMORTEM_STATUS_DESC,NVL(AREA_CODE,'*') AREA_CODE,NVL( AREA_TYPE,'Unassigned') AREA_TYPE,area_type_desc, NVL(AREA_DESC,'Unassigned') AREA_DESC,decode(RELEASE_BODY_DATE,null,'No','Yes') released_yn from mo_mortuary_regn_vw");
			operSql.append(" where upper(REGISTRATION_NO) like upper('"+rno+"') ");
			operSql.append(" and upper(NVL(PATIENT_ID,'*')) like upper('"+pid+"') ");
			operSql.append(" and NVL(AREA_CODE,'*') like ('"+area+"')");
			operSql.append(" AND NVL(area_type,'*') LIKE ('"+atype+"')");
			//operSql.append(" and BODY_PART_OBTAINED_FROM is null ");
			operSql.append(" and upper(POSTMORTEM_STATUS)like upper('"+pmstatus+"')");

			if(obtained_from.equals("C"))
        {
        operSql.append(" and  BODY_PART_OBTAINED_FROM is  null");
       }else if(obtained_from.equals("A")||obtained_from.equals("U")||obtained_from.equals("D")||(!obtained_from.equals("C")))
        {
       operSql.append(" and  BODY_PART_OBTAINED_FROM like '"+obtained_from+"%'");
       }
		
			
			operSql.append(" and  SEX LIKE '"+gender+"%'");

			operSql.append(" and  NVL(BURIAL_PERMIT_NO,'*') LIKE '"+burial_permit_no+"%'");
			if(rstatus.equals("R"))
			    operSql.append("and RELEASE_BODY_DATE is not null ");
			else if(rstatus.equals("C"))
				operSql.append("and RELEASE_BODY_DATE is null ");
		
			operSql.append(" and facility_id ='"+facility_id+"'");
			operSql.append(" and to_date(substr(BODY_RECEIVED_DATE,1,10),'dd/mm/yyyy') between to_date('"+frmdate+"','dd/mm/yyyy') and ");
			if(todate.equals("")) operSql.append("(sysdate)");
			else operSql.append(" to_date('"+todate+"','dd/mm/yyyy')");
			operSql.append(" order by area_desc,area_code,  registration_no ");*/


			operSql.append("select BURIAL_PERMIT_NO,BODY_PART_OBTAINED_FROM_DESC,postmortem_type,HIGH_RISK_BODY_YN,BROUGHT_DEAD_YN ,REGISTRATION_NO,BODY_RECEIVED_DATE,BODY_PART_OBTAINED_FROM,PATIENT_ID,ENCOUNTER_ID,decode('"+locale+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) PATIENT_NAME,AGE,deceased_age,SEX,PM_YN,POSTMORTEM_STATUS,POSTMORTEM_STATUS_DESC,NVL(AREA_CODE,'*') AREA_CODE,NVL( AREA_TYPE,'Unassigned') AREA_TYPE,area_type_desc, MO_GET_DESC.MO_AREA('"+facility_id+"',AREA_CODE,'"+locale+"','2') AREA_DESC,decode(RELEASE_BODY_DATE,null,'No','Yes') released_yn from mo_mortuary_regn_vw");
			operSql.append(" where upper(REGISTRATION_NO) like upper('"+rno+"') ");
			operSql.append(" and upper(NVL(PATIENT_ID,'*')) like upper('"+pid+"') ");
			operSql.append(" and NVL(AREA_CODE,'*') like ('"+area+"')");
			operSql.append(" AND NVL(area_type,'*') LIKE ('"+atype+"')");
			//operSql.append(" and BODY_PART_OBTAINED_FROM is null ");
			operSql.append(" and upper(POSTMORTEM_STATUS)like upper('"+pmstatus+"')");

			if(obtained_from.equals("C"))
        {
        operSql.append(" and  BODY_PART_OBTAINED_FROM is  null");
       }else if(obtained_from.equals("A")||obtained_from.equals("U")||obtained_from.equals("D")||(!obtained_from.equals("C")))
        {
       operSql.append(" and  BODY_PART_OBTAINED_FROM like '"+obtained_from+"%'");
       }
		
			
			operSql.append(" and  SEX LIKE '"+gender+"%'");

			operSql.append(" and  NVL(BURIAL_PERMIT_NO,'*') LIKE '"+burial_permit_no+"%'");
			if(rstatus.equals("R"))
			    operSql.append("and RELEASE_BODY_DATE is not null ");
			else if(rstatus.equals("C"))
				operSql.append("and RELEASE_BODY_DATE is null ");
		
			operSql.append(" and facility_id ='"+facility_id+"'");
			operSql.append(" and to_date(substr(BODY_RECEIVED_DATE,1,10),'dd/mm/yyyy') between to_date('"+frmdate+"','dd/mm/yyyy') and ");
			if(todate.equals("")) operSql.append("(sysdate)");
			else operSql.append(" to_date('"+todate+"','dd/mm/yyyy')");
			operSql.append(" order by area_desc,area_code,  registration_no ");


			st=con.createStatement();
			
			rs = st.executeQuery(operSql.toString());
			if ( start != 1 )
	        for( int j=1; j<start; l++,j++ ){
	        rs.next() ;
            }
			
			
			while(rs.next()&&l<=end)
			{
			  classValue =	((rowIndex%2)==0)? "QRYEVEN" : "QRYODD";
			  rowIndex++;
			  enc_id  = rs.getString("ENCOUNTER_ID");
			  if(enc_id==null) enc_id ="&nbsp;";
			  dis_rno  = rs.getString("REGISTRATION_NO");
			  if(dis_rno==null) dis_rno ="";
			  by_recd_dt  = rs.getString("BODY_RECEIVED_DATE");
			  if(by_recd_dt==null) by_recd_dt ="";
			 brought_dead_yn=rs.getString("brought_dead_yn"); 
			  if(brought_dead_yn==null) brought_dead_yn ="";
			  bdprt=rs.getString("BODY_PART_OBTAINED_FROM"); 
			 if(bdprt==null)bdprtyn ="N";else bdprtyn="Y";

			 if(bdprt==null)bdprt="";

			 if(bdprtyn==null)bdprtyn ="";
			  dis_pid = rs.getString("PATIENT_ID");
			  if(dis_pid==null) dis_pid ="";
			  dis_pname = rs.getString("PATIENT_NAME");
			  if(dis_pname==null) dis_pname ="";
			  dis_age = rs.getString("AGE");
			   if(dis_age==null) dis_age ="";		  
			  patient_deceased_age = rs.getString("deceased_age");
			  if(patient_deceased_age==null) patient_deceased_age="";			 
			  dis_sex = rs.getString("SEX");
			  if(dis_sex==null) dis_sex ="";
			  dis_pmyn = rs.getString("PM_YN");
			   if(dis_pmyn==null) dis_pmyn ="";
			  bur_perm_no=rs.getString("BURIAL_PERMIT_NO");
              if(bur_perm_no==null) bur_perm_no ="";
			  HIGH_RISK_BODY_YN=rs.getString("HIGH_RISK_BODY_YN");
             if(HIGH_RISK_BODY_YN==null) HIGH_RISK_BODY_YN ="";
			  dis_pmstat = rs.getString("POSTMORTEM_STATUS");
			  if(dis_pmstat==null) dis_pmstat ="";
			  dis_pmstatdesc = rs.getString("POSTMORTEM_STATUS_DESC");
			  if(dis_pmstatdesc==null) dis_pmstatdesc ="";
			  
			  dis_acode = rs.getString("AREA_CODE");
			  if(dis_acode==null) dis_acode ="";
			  dis_atype = rs.getString("AREA_TYPE");
			  area_type_desc = rs.getString("area_type_desc")==null?"":rs.getString("area_type_desc");
			 postmortem_type=rs.getString("postmortem_type")==null?"":rs.getString("postmortem_type"); BODY_PART_OBTAINED_FROM_DESC=rs.getString("BODY_PART_OBTAINED_FROM_DESC")==null?"":rs.getString("BODY_PART_OBTAINED_FROM_DESC");
			  RELEASE_BODY_YN = rs.getString("released_yn");
			  AREA_DESC = rs.getString("AREA_DESC");
			  if(dis_atype==null) dis_atype ="";
			  if(RELEASE_BODY_YN==null) RELEASE_BODY_YN ="";
			  if(AREA_DESC==null) AREA_DESC ="";


				by_recd_dt_disply=DateUtils.convertDate(by_recd_dt,"DMYHM","en",locale);
			  
						/*****Gender Decode****/
						if(dis_sex.equals("Male"))
						{
							dis_sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
						}else if(dis_sex.equals("Female"))
						{
							dis_sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
						}else if(dis_sex.equals("Unknown"))
						{
							dis_sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
						}

						/*****Y/N Decode****/
						if(RELEASE_BODY_YN.equals("No"))
						{
							RELEASE_BODY_YN=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
						}else if(RELEASE_BODY_YN.equals("Yes"))
						{
							RELEASE_BODY_YN=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
						}
						
						/*****AREA_DESC Decode****/
						if(AREA_DESC.equals(""))
						{
							AREA_DESC=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unassigned.label","common_labels");
						}

						/*****POSTMORTEM_STATUS_DESC Decode****/
						if(dis_pmstat.equals("N"))
							dis_pmstatdesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
						else if(dis_pmstat.equals("A"))
							dis_pmstatdesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.NotRequested.label","mo_labels");
						else if(dis_pmstat.equals("R"))
							dis_pmstatdesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Requested.label","common_labels");
						else if(dis_pmstat.equals("S"))
							dis_pmstatdesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProgress.label","common_labels");
						else if(dis_pmstat.equals("E"))
							dis_pmstatdesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.completed.label","common_labels");
						else if(dis_pmstat.equals("C"))
							dis_pmstatdesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");

						/*****BODY_PART_OBTAINED_FROM_DESC Decode****/
						if(bdprt.equals("A"))
						BODY_PART_OBTAINED_FROM_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.AmputatedBodyPart.label","mo_labels");
						else if(bdprt.equals("D"))
							BODY_PART_OBTAINED_FROM_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.DeadFetus.label","mo_labels");
						else if(bdprt.equals("U"))
							BODY_PART_OBTAINED_FROM_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.UnidentifiedBodyPart.label","mo_labels");
						else 
							BODY_PART_OBTAINED_FROM_DESC = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");



						/*****area_type_desc Decode****/
						if(dis_atype.equals("S"))
						{
						area_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.StorageArea.label","mo_labels");
						}else if(dis_atype.equals("R"))
						{
						area_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.ReleaseArea.label","mo_labels");
						}else if(dis_atype.equals("P"))
						{
						area_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.PostmortemArea.label","mo_labels");
						}else if(dis_atype.equals("O"))
						{
						area_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
						}

		      if(prevcode.equals(AREA_DESC)) prevcode = "";
			  else prevcode = AREA_DESC;







			  if(!(prevcode.equals("")))
		{ 
			
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(prevcode));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(dis_acode));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(area_type_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);
 }prevcode =AREA_DESC; 
            _bw.write(_wl_block28Bytes, _wl_block28);
if(HIGH_RISK_BODY_YN.equals("Y"))
	{
	colordisplay="style='background-color:orange'";
	}else 
		{
		colordisplay="";
	}
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(dis_acode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(dis_atype));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(dis_acode));
            _bw.write(_wl_block33Bytes, _wl_block33);
	if(postmortem_type.equals("M"))
		{
	
            _bw.write(_wl_block34Bytes, _wl_block34);
}else if(postmortem_type.equals("C")){
            _bw.write(_wl_block35Bytes, _wl_block35);
}else{
            _bw.write(_wl_block36Bytes, _wl_block36);
}
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(dis_rno));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(by_recd_dt_disply));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(dis_pid));
            _bw.write(_wl_block43Bytes, _wl_block43);
if(brought_dead_yn.equals("Y")){
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(java.net.URLEncoder.encode(dis_pname)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(dis_pid));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(dis_rno));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bdprtyn));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(dis_pname));
            _bw.write(_wl_block47Bytes, _wl_block47);
}else{
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(java.net.URLEncoder.encode(dis_pname)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(dis_pid));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(dis_rno));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bdprtyn));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(dis_pname));
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(patient_deceased_age));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(dis_sex));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(dis_pmstatdesc));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(enc_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(RELEASE_BODY_YN));
            _bw.write(_wl_block55Bytes, _wl_block55);
if(!obtained_from.equals("C"))
        {
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(BODY_PART_OBTAINED_FROM_DESC));
            _bw.write(_wl_block58Bytes, _wl_block58);
}
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(bur_perm_no));
            _bw.write(_wl_block62Bytes, _wl_block62);

	l++;
	}
  
            _bw.write(_wl_block63Bytes, _wl_block63);
}
	    else
				{
		          out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				}
				if (rs != null) rs.close();
                if (st != null) st.close();

				}
    catch(Exception e) {out.println(e.toString());
	e.printStackTrace();}
    finally
    {
       	ConnectionManager.returnConnection(con,request);
		
            _bw.write(_wl_block64Bytes, _wl_block64);
}
		
	
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block66Bytes, _wl_block66);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.registrationno.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.Body.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.received.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.Receipt.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.DeceasedName.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.PostmortemStatus.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.ReleasedYN.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.BodyPartType.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.BurialPermitNo.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
