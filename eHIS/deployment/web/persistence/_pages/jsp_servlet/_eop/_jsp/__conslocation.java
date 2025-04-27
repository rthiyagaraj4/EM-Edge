package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __conslocation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/ConsLocation.jsp", 1709119433242L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n<body onKeyDown = \'lockKey();\'>\n<div align=\'center\' >\n<script>\n function closew()\n  {\n\t  window.parent.close();\n  }\n  </script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<div>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

request.setCharacterEncoding("UTF-8");
//String p_patient_id="";
String p_locn_desc="";
String p_locn_type_desc="";
String p_status="";
String p_prior_locn_desc	= "";
String p_prior_locn_type_desc = "";
String p_date_time	= "";
String p_notes	= "";


StringBuffer sql=new StringBuffer();
//String p_encounter_id	= request.getParameter("Encounter_Id");
String patid=request.getParameter("Patient_ID");
String facilityid=request.getParameter("facilityid");
String room_num="";


            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	
	PreparedStatement pstmt = null;
	ResultSet rs		= null;
	Connection conn = null;
	//String fac_id    	= (String) session.getValue( "facility_id" ) ;
try {
	conn=ConnectionManager.getConnection(request);
	sql.append("select  patient_id, SUBSTR(curr_locn_desc,1,INSTR(curr_locn_desc,'**')-1) current_locn_desc, SUBSTR(curr_locn_desc, INSTR(curr_locn_desc,'**')+2) current_locn_type_desc, STATUS, SUBSTR(PRIOR_LOCN_DESC,1,INSTR(PRIOR_LOCN_DESC,'**')-1) prior_locn_desc, SUBSTR(PRIOR_LOCN_DESC,INSTR(PRIOR_LOCN_DESC,'**')+2) prior_locn_type_desc, to_char(DATE_TIME,'dd/mm/yyyy  hh24:mi') date_time, TRACKING_NOTES  notes, patient_tracking_status,room_num  from op_patient_tracking_locn_vw  where operating_facility_id='"+facilityid+"' and patient_id = '"+patid+"'");
	
	pstmt=conn.prepareStatement(sql.toString());	
	rs=pstmt.executeQuery();
   rs.next();

  //  p_patient_id=rs.getString("patient_id");
    p_locn_desc=rs.getString("current_locn_desc");
    if (p_locn_desc==null)
         p_locn_desc="";
    p_locn_type_desc=rs.getString("current_locn_type_desc");
     if (p_locn_type_desc==null)
        p_locn_type_desc="";
    p_status=rs.getString("STATUS");
     if (p_status==null)
        p_status="";
    p_date_time 	= rs.getString("date_time");
    if (p_date_time==null)
        p_date_time="";
    p_prior_locn_desc  =rs.getString("prior_locn_desc");
     if (p_prior_locn_desc==null)
        p_prior_locn_desc="";
    p_prior_locn_type_desc	= rs.getString("prior_locn_type_desc");
     if (p_prior_locn_type_desc==null)
        p_prior_locn_type_desc="";
    p_notes	= rs.getString("notes");
     if (p_notes==null)
        p_notes="";
        
        
        
      room_num=rs.getString("room_num");

     if ((room_num == null) || (room_num.equals("*ALL")) || (room_num).equals("null"))
      room_num="";


   if (rs!=null){
	out.println("<table width='80%' cellspacing='0' cellpadding='0' border='0'>");
	out.println("<td class='BORDER'>");
	out.println("<table width='100%' cellpadding='0' cellspacing='0' align='left'  BORDER='0'>");
	out.println("<tr><td width='50%'   align='right' class='label' ><br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.currentlocation.label","common_labels")+"&nbsp;&nbsp;&nbsp;&nbsp;</td>");
	out.println("<td  align='left' width ='50%'  class='QUERYDATA'><br>"+p_locn_desc+" / " +p_locn_type_desc+ "</td></tr>");	
	
	//added by smita for room number display on 03-02-04
	if (!( rs.getString("patient_tracking_status").equals("T")))
	{
	if(!(room_num.equals("")) )
			{
			out.println("<tr><td width='50%' align='right' class='label' nowrap><br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomno.label","common_labels")+"&nbsp;&nbsp;&nbsp;&nbsp;</td>");
			out.println("<td align='left' width='50%' class='QUERYDATA'><br>"+room_num+"</td></tr>");
			}	
	}
	
	out.println("<tr><td width='50%'  align='right'  class='label' ><br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")+"&nbsp;&nbsp;&nbsp;&nbsp;</td>");
	out.println("<td   align='left' width ='50%'  class='QUERYDATA'><br>"+p_status+"</td></tr>");
	out.println("<tr><td width='50%'  align='right' class='label' ><br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.datetime.label","common_labels")+"&nbsp;&nbsp;&nbsp;&nbsp;</td>");
	out.println("<td align='left' width ='50%'  class='QUERYDATA'><br>"+p_date_time+"</td></tr> ");
	if ( rs.getString("patient_tracking_status").equals("T"))
	{
	out.println("<tr><td width='50%'  align='right' class='label' ><br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.PriorLocation.label","op_labels")+"&nbsp;&nbsp;&nbsp;&nbsp;</td>");
	out.println("<td  align='left' width ='50%'  class='QUERYDATA'><br>"+p_prior_locn_desc+" / "+p_prior_locn_type_desc+"</td></tr>");

	
		if(!(room_num.equals("")))
		{
		out.println("<tr><td width='50%' align='right' class='label' nowrap><br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomno.label","common_labels")+"&nbsp;&nbsp;&nbsp;&nbsp;</td>");
		out.println("<td align='left' width='50%' class='QUERYDATA'><br>"+room_num+"</td></tr>");
		}	

	
	out.println("<tr><td width='50%' valign='top' align='right' class='label' ><br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notes.label","common_labels")+"&nbsp;&nbsp;&nbsp;&nbsp;</td>");
	out.println("<td  align='left' width ='50% ' class='QUERYDATA'><br>"+p_notes+"</td></tr>");
    }

    out.println("</table></table>");
}
else
{
	out.println("<table width='80%' cellspacing='0' cellpadding='0'>");
	out.println("<tr><td class='BORDER'>");
	out.println("<table width='100%'cellpadding='0' cellspacing='0' align='left'  BORDER='0'>");
	out.println("<tr><td width='50%'   class='label' ><br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.currentlocation.label","common_labels")+"&nbsp;&nbsp;&nbsp;&nbsp;</td>");
    out.println("<tr><td width='50%'   class='label' ><br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")+"&nbsp;&nbsp;&nbsp;&nbsp;</td>");
    out.println("<tr><td width='50%'   class='label' ><br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.datetime.label","common_labels")+"&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>");
        if ( rs.getString("patient_tracking_status").equals("T"))
			{
			out.println("<tr><td width='50%'  class='label' ><br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.PriorLocation.label","op_labels")+"&nbsp;&nbsp;&nbsp;&nbsp;</td>");
			out.println("<tr><td width='50%'  class='label' ><br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notes.label","common_labels")+"&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>");
            }
         out.println("</table></table>");
}

}
catch ( Exception e ){out.println(e.toString());}
finally{
	if ( pstmt != null ) pstmt.close() ;
	if ( rs != null ) rs.close() ;
	sql=null;
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
	}

            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
