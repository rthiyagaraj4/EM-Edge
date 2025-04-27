package jsp_servlet._emo._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import java.net.*;
import java.util.*;
import com.ehis.util.*;

public final class __modeceaseddtlsqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emo/jsp/MODeceasedDtlsQueryResult.jsp", 1709118406134L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" <!--[eCommon.Common]Added by Sakthi against IN:-062848 -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n <html>\n    <head>\n\t    ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n      <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n        <script language=\'javascript\' src=\'../../eCommon/js/common.js\' ></script>\t\t\n\t\t<script language=\'javascript\' src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<Script src=\"../../eCommon/js/DateUtils.js\" language=\"JavaScript\"></Script>\n\t\t<script language=\'javascript\' src=\'../../eMO/js/MORegisterAttn.js\' ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\n\t\t\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\n  <script>\n        /*Below Code Added for this incident[33932] */\n\t\t if(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'!=\"\"){\n         var timeinterval=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'*1000*60; \t\n\t\t self.setInterval(\'submitPage()\',timeinterval)\n\t\t}\n       </script>\n     </head>                         \n\t\t\n\t\t<body  onMouseDown=\'CodeArrest()\'   onKeyDown=\"lockKey()\">\n\t\t<form name = \'MOAreaAvailabilityQueryResult_form\'>\n ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t \n\t <p>\n<table align=\'right\'>\n<tr>\n<td>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n</td>\n</tr>\n</table>\n</p>\n\n<br>\n<br>\n\t\t <table cellspacing=0 cellpadding=0 align=\'center\' width=\'100%\' border=\'1\' cellpadding=0 cellspacing=0>\n\t\t    <td class=\'columnheader\'>&nbsp;</td>\t\n\t\t\t<td class=\'columnheader\'>&nbsp;</td>\t\n\t\t    <td class=\'columnheader\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td> \n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<td class=\'columnheader\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td> <!Added by Sakthi against IN:-062848-->\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t<td class=\'columnheader\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\t\n\t\t\t<td class=\'columnheader\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\t\n\t\t    <td class=\'columnheader\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" </td>\t\t \n\t\t\t<td class=\'columnheader\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\t\t \n\t\t     \n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\t\t\t  \n    \n\t\n\t<tr>\n\t    \n\t <td> <a name=\'desc1\' href=\"javascript:viewPatientDetails(\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\')\"><font size=1>+</a></td>     ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t<td style=\'background-color:maroon;color:white\' width=2%>&nbsp;P</td>\t\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t<td style=\'background-color:Yellow;color:black\' width=2%>&nbsp;P</td>\t\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t           <td>&nbsp;</td>\t\n\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n        <td  style=\'background-color:black;color:white;\'><font size=1>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</a></td>\n\t\t   ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t   \n\t <td  class=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="><font size=1>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</a></td>\n\t ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t<td  style=\'background-color:black;\'> <a name=\'desc1\' href=\"javascript:showAllowOper(\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\',\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\')\" style=\'color:white;\' ><font size=1>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</a></td>\n   ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t<td class=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" > <a name=\'desc1\' href=\"javascript:showAllowOper(\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\')\" ><font size=1>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</a></td>\n  ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n   ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n        <td class=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" > <font size=1>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>   <!Added by Sakthi against IN:-06284-->\n\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t<td class=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'  ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" > <a name=\'desc1\' href=\"javascript:showPrevEncounter(\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\')\" > <font size=1>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n\t\t<td class=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="  > <font size=1>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="   > <font size=1>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" </td>\n\t\t<td class=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t\t<!--Style Added by Santhosh for ML-MMOH-CRF-1947>-->\n\t\t<td class=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" style=\'word-wrap:break-word;width:300px;\' > <font size=1>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t\t  </tr>\n ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n   </table>\n        <br>\n\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="<script>\n\t\t\tif(parent.frames[1].document.forms[0] != null)\n\t\t\tparent.frames[1].document.forms[0].search.disabled=false\n\t\t  </script>\n\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n       </form>\n    </body>\n  </html>\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

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

		String patient_name                       ="";
		String age                                ="";
		String sex                                ="";
		String location				              ="";
		String Nationality				          =""; //Added by Sakthi against IN:-062848
		String high_risk_yn                       ="";
		String treatment_area_desc		          ="";
		String assign_room_num                    ="";
		String assign_bed_num			          ="";
		String deceased_date			          ="";
		String body_release_date_time             ="";
		String burial_permit_no		              ="";     	
		String mlc_yn							  = checkForNull(request.getParameter("mlcyn"));
		String brought_dead_yn                    = checkForNull(request.getParameter("broughtindead"));
		String patient_det="";
		String citizenyn="";
		String religion="";
		String PM_YN= checkForNull(request.getParameter("pmyn"));
		String deceased_date_cnv = "";
		String body_release_date_time_cnv = "";
		

		String colordisplay                        ="";
		String patient_id			= checkForNull(request.getParameter("patient_id"));
		String BURIAL_PERMIT_NO		= checkForNull(request.getParameter("BURIAL_PERMIT_NO"));
		String clinic_code			= checkForNull(request.getParameter("locn"));
		String clinic_code1			= checkForNull(request.getParameter("clinic_code1"));
		String dec_date_time        = checkForNull(request.getParameter("dec_date_time"));
		String regcase        = checkForNull(request.getParameter("regcase"));
		String timeinterval="";
		StringBuffer getInt=new StringBuffer();
		
		String dec_date_time1 =request.getParameter("dec_date_time1")==null?"":request.getParameter("dec_date_time1");
		
		if(patient_id.equals("")) patient_id        = "%";
		if(BURIAL_PERMIT_NO.equals("")) BURIAL_PERMIT_NO       = "%";
		if(clinic_code.equals("")) clinic_code            = "%";
		if(clinic_code1.equals("")) clinic_code1  = "%";
		if(dec_date_time1.equals("")) dec_date_time1      = "";
		if(dec_date_time.equals("")) dec_date_time      = "01/01/1800 00:00";
	 
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
		String from = request.getParameter( "from" ) ;
	    String to = request.getParameter( "to" ) ;
		int start = 0 ;
	    int end = 0 ;
	    int i=1;
    	if ( from == null )
		start = 1 ;
	    else
		start = Integer.parseInt( from ) ;
    	if ( to == null )
	  	end = 8 ;
	    else
		end = Integer.parseInt( to ) ;
        //int maxRecord = 0; 
		try
			{
		con	= ConnectionManager.getConnection(request);		
 
		getInt.append("select QUEUE_REFRESH_INTERVAL from mo_parameter where facility_id='"+facility_id+"'"); 
		st=con.createStatement();
	    rs = st.executeQuery(getInt.toString());
		while(rs.next())
		{
		timeinterval=rs.getString("QUEUE_REFRESH_INTERVAL")==null?"0":rs.getString("QUEUE_REFRESH_INTERVAL");
		}

	if (rs!=null) rs.close();
	if (st!=null) st.close();
	Boolean validationForNationality	= CommonBean.isSiteSpecific(con,"MO","NATIONALITY_APP_YN"); //Added by Sakthi against IN:-062848


            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(timeinterval));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(timeinterval));
            _bw.write(_wl_block11Bytes, _wl_block11);

		String classValue	= "";
		int rowIndex		= 1;
		
		
		int ccount          = 0;
        
			StringBuffer getcount = new StringBuffer();
			getcount.append("select count(*) from  mo_encounter_dtls_vw where upper(PATIENT_ID) like upper('"+patient_id+"')  and NVL(BURIAL_PERMIT_NO,'*') like  ('"+BURIAL_PERMIT_NO+"') AND NVL(ASSIGN_CARE_LOCN_TYPE,'*') LIKE ('"+clinic_code+"') AND NVL(ASSIGN_CARE_LOCN_CODE,'*') LIKE ('"+clinic_code1+"') and REGN_ALLOWED_IN_MO_YN='Y' ");
 
	
           if(PM_YN.equals("Y"))
		   {
		   getcount.append("and pm_yn='Y'");
		   }

		   if(brought_dead_yn.equals("Y"))
		   {
			   getcount.append("and BROUGHT_DEAD_YN='Y'");
		   }
		   if(mlc_yn.equals("Y"))
		   {
			   getcount.append("and mlc_yn='Y'");
		   }else
		   {
		   }
		   if(regcase.equals("Y"))
		   {
		   getcount.append(" and PATIENT_ID  in (select NVL(patient_id,'*') from mo_mortuary_regn)");
		   }else
			{
			getcount.append(" and PATIENT_ID not in (select NVL(patient_id,'*') from mo_mortuary_regn where NVL(BODY_PART_OBTAINED_FROM,'*') not in ('A','D'))");
			}

			getcount.append("and facility_id ='"+facility_id+"' and to_date(substr(DECEASED_DATE,1,10),'dd/mm/yyyy') between to_date('"+dec_date_time+"','dd/mm/yyyy')");
			if(dec_date_time1.equals("")) getcount.append("and (sysdate)");
			else getcount.append("and to_date('"+dec_date_time1+"','dd/mm/yyyy')");
			
			
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
				
		 
            _bw.write(_wl_block12Bytes, _wl_block12);

if ( !(start <= 1) )
	out.println("<A HREF='../jsp/MODeceasedDtlsQueryResult.jsp?from="+(start-8)+"&to="+(end-8)+"&patient_id="+URLEncoder.encode(patient_id)+"&BURIAL_PERMIT_NO="+URLEncoder.encode(BURIAL_PERMIT_NO)+"&locn="+URLEncoder.encode(clinic_code)+"&clinic_code1="+URLEncoder.encode(clinic_code1)+"&dec_date_time="+URLEncoder.encode(dec_date_time)+"&dec_date_time1="+URLEncoder.encode(dec_date_time1)+"&regcase="+URLEncoder.encode(	regcase)+"&brought_dead_yn="+URLEncoder.encode(brought_dead_yn)+"&mlc_yn="+URLEncoder.encode(mlc_yn)+"&pmyn="+URLEncoder.encode(PM_YN)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+8) > ccount ) )
	out.println("<A HREF='../jsp/MODeceasedDtlsQueryResult.jsp?from="+(start+8)+"&to="+(end+8)+"&patient_id="+URLEncoder.encode(patient_id)+"&BURIAL_PERMIT_NO="+URLEncoder.encode(BURIAL_PERMIT_NO)+"&locn="+URLEncoder.encode(clinic_code)+"&clinic_code1="+URLEncoder.encode(clinic_code1)+"&dec_date_time="+URLEncoder.encode(dec_date_time)+"&dec_date_time1="+URLEncoder.encode(dec_date_time1)+"&regcase="+URLEncoder.encode(regcase)+"&brought_dead_yn="+URLEncoder.encode(brought_dead_yn)+"&mlc_yn="+URLEncoder.encode(mlc_yn)+"&pmyn="+URLEncoder.encode(PM_YN)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");


            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

			if(validationForNationality)
			{
			
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

			}
			
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

			
           

            StringBuffer operSql = new StringBuffer();
            //operSql.append("select PATIENT_ID, PATIENT_NAME, AGE,PM_YN,SEX,HIGH_RISK_YN, LOCATION,CITIZEN_YN,RELGN_DESC, TREATMENT_AREA_DESC,ASSIGN_ROOM_NUM, ASSIGN_BED_NUM, DECEASED_DATE, BODY_RELEASE_DATE_TIME, BURIAL_PERMIT_NO,MLC_YN, BROUGHT_DEAD_YN from mo_encounter_dtls_vw where REGN_ALLOWED_IN_MO_YN='Y'  and upper(PATIENT_ID) like upper('"+patient_id+"')  and NVL(BURIAL_PERMIT_NO,'*') like  ('"+BURIAL_PERMIT_NO+"') AND NVL(ASSIGN_CARE_LOCN_TYPE,'*') LIKE ('"+clinic_code+"') AND NVL(ASSIGN_CARE_LOCN_CODE,'*') LIKE ('"+clinic_code1+"')");

			operSql.append("select PATIENT_ID, decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name,  mp_get_desc.mp_country(nationality_code,'"+localeName+"',3)Nationality, AGE, PM_YN, SEX, HIGH_RISK_YN, DECODE(assign_care_locn_type,'N',IP_GET_DESC.IP_NURSING_UNIT(facility_id,assign_care_locn_code,'"+localeName+"',2), OP_GET_DESC.OP_CLINIC(facility_id,assign_care_locn_code,'"+localeName+"',2)) LOCATION , CITIZEN_YN,  mp_get_desc.MP_REGION(relgn_code,'"+localeName+"',2) RELGN_DESC, ae_get_desc.AE_TMT_AREA_FOR_CLINIC(facility_id,assign_care_locn_code,treatment_area_code,'"+localeName+"',2) TREATMENT_AREA_DESC, ASSIGN_ROOM_NUM, ASSIGN_BED_NUM, DECEASED_DATE, BODY_RELEASE_DATE_TIME, BURIAL_PERMIT_NO,MLC_YN, BROUGHT_DEAD_YN from mo_encounter_dtls_vw where REGN_ALLOWED_IN_MO_YN='Y'  and upper(PATIENT_ID) like upper('"+patient_id+"')  and NVL(BURIAL_PERMIT_NO,'*') like  ('"+BURIAL_PERMIT_NO+"') AND NVL(ASSIGN_CARE_LOCN_TYPE,'*') LIKE ('"+clinic_code+"') AND NVL(ASSIGN_CARE_LOCN_CODE,'*') LIKE ('"+clinic_code1+"')");
			
			operSql.append(" and facility_id ='"+facility_id+"' and to_date(substr(DECEASED_DATE,1,10),'dd/mm/yyyy') between to_date('"+dec_date_time+"','dd/mm/yyyy')");
			if(dec_date_time1.equals("")) operSql.append("and (sysdate)");
			else operSql.append("and to_date('"+dec_date_time1+"','dd/mm/yyyy')");
			
		  if(PM_YN.equals("Y"))
		   {
		   operSql.append("and pm_yn='Y' and mlc_yn='N'");
		   }

		   if(brought_dead_yn.equals("Y"))
		   {
			   operSql.append("and BROUGHT_DEAD_YN='Y'");
		   }
		   if(mlc_yn.equals("Y"))
		   {
			   operSql.append("and mlc_yn='Y'");
		   }
		   if(regcase.equals("Y"))
		   {
		   operSql.append(" and PATIENT_ID  in (select NVL(patient_id,'*') from mo_mortuary_regn)");
		   }else
			{
			operSql.append(" and PATIENT_ID not in (select NVL(patient_id,'*') from mo_mortuary_regn where NVL(BODY_PART_OBTAINED_FROM,'*') not in ('A','D'))");
			}
			
			operSql.append(" order by to_date(BODY_RELEASE_DATE_TIME,'dd/mm/yyyy hh24:mi') desc");
			
			
			st=con.createStatement();
			
			rs = st.executeQuery(operSql.toString());
			
	 	     if ( start != 1 )
	         for( int j=1; j<start; i++,j++ ){
	         rs.next() ;
            }
			while(rs.next()&&i<=end)
			{
			classValue =	((rowIndex%2)==0)? "QRYEVEN" : "QRYODD";
			rowIndex++;
			  
			patient_id          =rs.getString("patient_id")==null?"&nbsp;":rs.getString("patient_id");   
			patient_name        =rs.getString("patient_name")==null?"&nbsp;":rs.getString("patient_name");   
		    Nationality         =rs.getString("Nationality")==null?"&nbsp;":rs.getString("Nationality"); //Added by Sakthi against IN:-062848
	        age                 =rs.getString("age")==null?"&nbsp;":rs.getString("age");      
			sex                 =rs.getString("sex")==null?"&nbsp;":rs.getString("sex");      
			PM_YN               =rs.getString("PM_YN")==null?"&nbsp;":rs.getString("PM_YN");
			high_risk_yn        =rs.getString("high_risk_yn")==null?"&nbsp;":rs.getString("high_risk_yn");
			citizenyn           =rs.getString("CITIZEN_YN")==null?"&nbsp;":rs.getString("CITIZEN_YN");      
			religion            =rs.getString("RELGN_DESC")==null?"&nbsp;":rs.getString("RELGN_DESC");      
			//if(citizenyn.equals("Y")) citizenyn="Citizen";else citizenyn="Non Citizen";
			location			=rs.getString("location")==null?"&nbsp;":rs.getString("location");  
			
			if(sex!=null && !sex.equals("") && sex.equals("Male"))
				sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			else if(sex!=null && !sex.equals("") && sex.equals("Female"))
				sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			else if(sex!=null && !sex.equals("") && sex.equals("Unknown"))
				sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
			if(citizenyn.equals("Y")) 
			{
				citizenyn=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.citizen.label","common_labels");				
			}
			else
			{ 
			     citizenyn=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.noncitizen.label","common_labels");
			}


            patient_det= patient_id+","+patient_name+","+age+","+sex+","+religion+","+citizenyn;
			treatment_area_desc	=rs.getString("treatment_area_desc")==null?"&nbsp;":rs.getString("treatment_area_desc");   
			assign_room_num     =rs.getString("assign_room_num")==null?"&nbsp;":rs.getString("assign_room_num");      
			assign_bed_num		=rs.getString("assign_bed_num")==null?"&nbsp;":rs.getString("assign_bed_num");   
			deceased_date		=rs.getString("deceased_date")==null?"&nbsp;":rs.getString("deceased_date");  
			body_release_date_time =rs.getString("body_release_date_time")==null?"&nbsp;":rs.getString("body_release_date_time");   
			burial_permit_no	=rs.getString("burial_permit_no")==null?"&nbsp;":rs.getString("burial_permit_no");   
			mlc_yn		 	    =rs.getString("mlc_yn")==null?"&nbsp;":rs.getString("mlc_yn");  			
			brought_dead_yn     =rs.getString("brought_dead_yn")==null?"&nbsp;":rs.getString("brought_dead_yn");    
			
			if(!deceased_date.equals(""))
				deceased_date_cnv = DateUtils.convertDate(deceased_date,"DMYHM","en",localeName); 
			if(!body_release_date_time.equals(""))
				body_release_date_time_cnv = DateUtils.convertDate(body_release_date_time,"DMYHM","en",localeName); 



            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);

	     if(mlc_yn.equals("Y"))
		{
            _bw.write(_wl_block24Bytes, _wl_block24);
}else if(PM_YN.equals("Y"))
		{
            _bw.write(_wl_block25Bytes, _wl_block25);
}else 
		{
            _bw.write(_wl_block26Bytes, _wl_block26);
}
	    
     
	if(high_risk_yn.equals("Y"))
	{
	colordisplay="style='background-color:Orange;'";
	}else
	{
		colordisplay="";
	}

     if(regcase.equals("Y"))
		   { if(brought_dead_yn.equals("Y"))
	{
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(patient_det));
            _bw.write(_wl_block28Bytes, _wl_block28);
}else
			   {
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(patient_det));
            _bw.write(_wl_block32Bytes, _wl_block32);
}
	 
	 }else{
	 if(brought_dead_yn.equals("Y"))
	{
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(burial_permit_no));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patient_det));
            _bw.write(_wl_block36Bytes, _wl_block36);
}else { 
   
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(burial_permit_no));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(patient_det));
            _bw.write(_wl_block40Bytes, _wl_block40);
}}
            _bw.write(_wl_block41Bytes, _wl_block41);

			if(validationForNationality)
			{
			
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(Nationality));
            _bw.write(_wl_block44Bytes, _wl_block44);

			}
	
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(burial_permit_no));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(location));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(treatment_area_desc));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(assign_room_num));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(assign_bed_num));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(deceased_date_cnv));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(body_release_date_time_cnv));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(colordisplay));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(burial_permit_no));
            _bw.write(_wl_block55Bytes, _wl_block55);

	i++;
		}
  
            _bw.write(_wl_block56Bytes, _wl_block56);
}
	    else
				{
		          out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
				}
				if (rs != null) rs.close();
                if (st != null) st.close();

				}
    catch(Exception e) {out.println(e.toString());}
    finally
    {
       	ConnectionManager.returnConnection(con,request);
		
            _bw.write(_wl_block57Bytes, _wl_block57);
}
		
	
            _bw.write(_wl_block58Bytes, _wl_block58);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.DeceasedPatientDetls.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.treatmentarea.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomno.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.deceaseddatetime.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.BodyDisToMortuary.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMO.BurialPermitNumber.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mo_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
