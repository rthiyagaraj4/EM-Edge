package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.net.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __practalertresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/PractAlertResult.jsp", 1709116054419L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\t\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\t\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\t\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\n\t\n\t\t\t<body class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t\t<form name=\'PractAlert\' id=\'PractAlert\' >\n\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t <script>alert(\'Query caused no records to be retrieved\')</script>\n\t\t ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<table cellpadding=\'3\' align=\'center\' width=\'100%\'>\n\t\t\t\t<tr >\n\t\t\t<td width=\'100%\' class=\'white\' ></td>\n\t\t\t\t<td nowrap width=\'10%\'>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n</td>\n</tr>\n</table>\t\n\t<table id=\'PatCriteriaResultTbl\'  class=\'grid\' width=\'100%\' border=\'0\' cellpadding=\'3\' cellspacing=\'0\'>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\t\n\t\t<tr>\t\t\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n\t\t\t <td width=\'50%\'><b>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =",";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t</td></tr>\n\t\t\t<tr><td class=\'gridData\' >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td><td class=\'gridData\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td></tr>\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<td ><b>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t</td></tr>\n\t\t\t</td><td class=\'gridData\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td><td class=\'gridData\'>\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td></tr> \t\t\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\t\t\n\t\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" \n</body>\n</html>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

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
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";	
	

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

			Connection con = null;		

		
			try
			{
				java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
				String locale = (String) p.getProperty("LOCALE");		
				
				String from 					= request.getParameter("from") ;
	
				String to 						= request.getParameter("to") ;
				
				String fromDate			=	request.getParameter("fromDate") == null ? "" : request.getParameter("fromDate");
				
				String toDate			=	request.getParameter("toDate") == null ? "" : request.getParameter("toDate"); 				
				
				 String group_By	=	request.getParameter("group_By") == null ? "" :		request.getParameter("group_By");
				 if(!localeName.equals("en"))
				{
                 fromDate		=	com.ehis.util.DateUtils.convertDate(fromDate,"DMY",locale,"en");
			     toDate	=	com.ehis.util.DateUtils.convertDate(toDate,"DMY",locale,"en");
				}
				 
				String Patient_id="";
				String Patient_name="";
				String encounter_id="";
				String facility_id="";
				String Categ_desc="";
				String Event_desc="";
				String alert_remarks="";
				int maxRecord = 0;
				int start = 0 ;
				int end = 0 ;
				int i=1;

				if ( from == null )
					start = 1 ;
				else
					start = Integer.parseInt( from ) ;

				if ( to == null )
	  				end = 12 ;
				else
				end = Integer.parseInt( to ) ;

				con = ConnectionManager.getConnection(request);
				PreparedStatement pstmt= null;				
				ResultSet rset=null;				
				String sqlQuery="";
				
				try
			 {
			String sqlRecoed = " SELECT COUNT(*) total_records FROM  CA_ALERT_ACTION_LOG a,CA_ALERT_CATEG_LANG b WHERE  b.LANGUAGE_ID =? AND  a.ACTION_PEND_DATETIME BETWEEN TO_DATE(?,'dd/mm/yyyy hh24:mi')   AND TO_DATE(?,'dd/mm/yyyy hh24:mi')AND B.ALERT_CATEG_CODE=a.ALERT_CATEG_CODE  "; 
			
		
			pstmt = con.prepareStatement(sqlRecoed);
			pstmt.setString(1,locale);
			pstmt.setString(2,fromDate);
			pstmt.setString(3,toDate);
			
		    rset = pstmt.executeQuery();		
			if(rset.next())
			{
				maxRecord = rset.getInt("total_records");					
			}
			
			if (rset != null)
				rset.close();

			if (pstmt != null)
				pstmt.close();

		}catch(Exception e){
			e.printStackTrace();
		}
		 if(maxRecord==0){	 
            _bw.write(_wl_block8Bytes, _wl_block8);
	}		
	  if(maxRecord !=0) { 
            _bw.write(_wl_block9Bytes, _wl_block9);

				if ( !(start <= 1) )
				out.println("<A HREF='../../eCA/jsp/PractAlertResult.jsp?from="+(start-12)+"&to="+(end-12)+"&toDate="+toDate+"&fromDate="+fromDate+"&group_By="+group_By+"'"+" text-decoration='none'    class ='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");				

				  if ( !( (start+12) >= maxRecord ) )
					{
			out.println("<A HREF='../../eCA/jsp/PractAlertResult.jsp?from="+(start+12)+"&to="+(end+12)+"&toDate="+toDate+"&fromDate="+fromDate+"&group_By="+group_By+"'"+" text-decoration='none'                                 class ='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	}
	

            _bw.write(_wl_block10Bytes, _wl_block10);
   sqlQuery="SELECT mp.PATIENT_ID,mp.PATIENT_NAME ,pr.ENCOUNTER_ID,pr.FACILITY_ID,b.ALERT_CATEG_DESC,c.ALERT_EVENT_DESC,a.ALERT_REMARKS  FROM mp_patient mp,pr_encounter pr,CA_ALERT_ACTION_LOG a,CA_ALERT_CATEG_LANG b,CA_ALERT_EVENT_LANG c WHERE mp.PATIENT_ID=A.PATIENT_ID AND b.LANGUAGE_ID = ? AND a.ACTION_PEND_DATETIME BETWEEN TO_DATE(?,'dd/mm/yyyy hh24:mi') AND TO_DATE(?,'dd/mm/yyyy hh24:mi')AND B.ALERT_CATEG_CODE=a.ALERT_CATEG_CODE AND  c.ALERT_CATEG_CODE=a.ALERT_CATEG_CODE  and A.facility_id=pr.facility_id and A.ENCOUNTER_ID=pr.encounter_id  ";		
				pstmt = con.prepareStatement(sqlQuery);
				pstmt.setString(1,locale);
				pstmt.setString(2,fromDate);
				pstmt.setString(3,toDate);				
				rset = pstmt.executeQuery();

				 if ( start != 1 )
				 for( int j=1; j<start; i++,j++ )
					 rset.next() ;

				 while(rset!=null && rset.next() && i<=end){
				
					 Patient_id=rset.getString("PATIENT_ID");
					 Patient_name=rset.getString("PATIENT_NAME");
					 encounter_id=rset.getString("ENCOUNTER_ID");
					 facility_id=rset.getString("FACILITY_ID");	
					 Categ_desc=rset.getString("ALERT_CATEG_DESC");
					 Event_desc=rset.getString("ALERT_EVENT_DESC");
					 alert_remarks=rset.getString("ALERT_REMARKS"); 		
		
            _bw.write(_wl_block11Bytes, _wl_block11);
 
			if(group_By.equals("1")&&(!(Patient_id.equals("")))) {
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Patient_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(Patient_name));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Categ_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(Event_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(alert_remarks));
            _bw.write(_wl_block16Bytes, _wl_block16);
 } 
			else if(group_By.equals("2")&&(!(Patient_id.equals("")))) {
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Categ_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Event_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(Patient_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(Patient_name));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(alert_remarks));
            _bw.write(_wl_block20Bytes, _wl_block20);
 } 
            _bw.write(_wl_block21Bytes, _wl_block21);
 i++; } 
}
}
catch(Exception e)
{
	//out.println(e);//COMMON-ICN-0181
	e.printStackTrace();
}
finally 
{
	if (con!=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block22Bytes, _wl_block22);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
