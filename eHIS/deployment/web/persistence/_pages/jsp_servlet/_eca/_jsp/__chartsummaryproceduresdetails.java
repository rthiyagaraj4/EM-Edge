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
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __chartsummaryproceduresdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartSummaryProceduresDetails.jsp", 1709115707652L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<title>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</title><!--IN035950-->\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\' />\n\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<table  width=\"100%\" class=\'grid\' id=\'tb1\' align=\'center\'>\n ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n</table>\n</body>\n</html>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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
 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
21/11/2012		IN035950		Nijitha			CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
												more appealing. Keeping the display of information more clear and visible.   								 
-------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date	Rev.Name	Description
-------------------------------------------------------------------------------------------------
28/06/2018	IN065341	Prakash C	29/06/2018	Ramesh G	MMS-DM-CRF-0115
03/04/2019	IN069978        Prakash C	03/04/2019	Ramesh G	MMS-ICN-00116
--------------------------------------------------------------------------------------------------------
*/

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
//String content_ID = request.getParameter("content_ID");checkstyle
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
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	
	Connection con=null;
    PreparedStatement stmt=null;
    ResultSet rs=null;
try
{	String Patient_Id        = request.getParameter("patient_id");
//IN065341 starts
	String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String operating_facility_id="";
	String RepDb=request.getParameter("RepDb")==null?"":request.getParameter("RepDb");
	String encounter_id=request.getParameter("enc_id1")==null?"":request.getParameter("enc_id1");//IN069978
	if(called_from.equals("CDR")){
		operating_facility_id = request.getParameter("facility_id1")==null?"":request.getParameter("facility_id1");
	}else{//IN065341 ends
	    operating_facility_id=(String) session.getValue("facility_id");
	}//IN065341
    String procedure="";
    String date="";
    String practitioner="";
    String classValue="";
   // String error_yn = "";
    int k=1;
   
        con=ConnectionManager.getConnection(request);
       
	try
    {


       // String sql="Select a.proc_narration,to_char(proc_date,'dd/mm/yyyy hh24:mi') proc_date,b.practitioner_name practitioner_name,proc_date dummydate, a.srl_no srl_no, a.ERROR_YN error_yn from pr_encounter_procedure a, am_practitioner b where a.facility_id = ? and a.PATIENT_ID = ? and b.practitioner_id=a.practitioner_id  and nvl(error_yn,'N')!='Y' order by dummydate desc "; 
		
		 //String sql="Select a.proc_narration,to_char(proc_date,'dd/mm/yyyy hh24:mi') proc_date,AM_GET_DESC.AM_PRACTITIONER(a.practitioner_id,?,'1') practitioner_name,proc_date dummydate, a.srl_no srl_no, a.ERROR_YN error_yn from pr_encounter_procedure a where a.facility_id = ? and a.PATIENT_ID = ? and nvl(error_yn,'N')!='Y' order by dummydate desc ";  
	//IN069978 starts
		// String sql="Select a.proc_narration,to_char(proc_date,'dd/mm/yyyy hh24:mi') proc_date,AM_GET_DESC.AM_PRACTITIONER ##REPDB##(a.practitioner_id,?,'1') practitioner_name,proc_date dummydate, a.srl_no srl_no, a.ERROR_YN error_yn from pr_encounter_procedure ##REPDB## a where a.facility_id = ? and a.PATIENT_ID = ? and nvl(error_yn,'N')!='Y' order by dummydate desc ";  
		 StringBuffer sql = new StringBuffer();
		 sql.append("Select a.proc_narration,to_char(proc_date,'dd/mm/yyyy hh24:mi') proc_date,AM_GET_DESC.AM_PRACTITIONER ##REPDB##(a.practitioner_id,?,'1') practitioner_name,proc_date dummydate, a.srl_no srl_no, a.ERROR_YN error_yn from pr_encounter_procedure ##REPDB## a where a.facility_id = ? and a.PATIENT_ID = ? and nvl(error_yn,'N')!='Y' "); //IN065341
		if(called_from.equals("CDR")){
			sql.append(" and a.encounter_id = ?");
		}
		sql.append(" order by dummydate desc");
		
		String result=sql.toString();
		result=result.replaceAll("##REPDB##", RepDb);//IN065341

		stmt = con.prepareStatement(result);
		stmt.setString(1, locale);
		stmt.setString(2, operating_facility_id);
		stmt.setString(3, Patient_Id);
		if(called_from.equals("CDR")){
		  stmt.setString(4, encounter_id);
		}
       //IN069978 ends	
        rs = stmt.executeQuery();
		
		//out.println(rs.next());
		/*if(rs.next())
		{
			 error_yn = rs.getString("error_yn") == null ? "N" : rs.getString("error_yn");
		}*/
		
		//if (rs == null)
		 while (rs.next())
        { 
		
                    if ( k%2 == 0 )
                            classValue = "QRYEVEN" ;
                    else
                            classValue = "QRYODD" ;
                    procedure       =(rs.getString(1)==null)?"&nbsp;":rs.getString(1);
                    date            =(rs.getString(2)==null)?"&nbsp;":rs.getString(2);
                    practitioner    =(rs.getString(3)==null)?"&nbsp;":rs.getString(3);

					if(!date.equals("&nbsp;"))
						date = com.ehis.util.DateUtils.convertDate(date,"DMYHM","en",locale);

                    out.println("<tr><td  class='gridData'> "+procedure+","+date+","+practitioner+"</td></tr>");
                    k++;
              
				
        }
			if(rs!=null)    rs.close();
            if(stmt!=null)  stmt.close();
    }
	catch(Exception e)
	{
		out.print("ERROR"+e);
	}
   

            _bw.write(_wl_block11Bytes, _wl_block11);

}
catch(Exception e)
{
	out.println(e);
}
finally
{
 if(con!=null)ConnectionManager.returnConnection(con,request);

}

            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
