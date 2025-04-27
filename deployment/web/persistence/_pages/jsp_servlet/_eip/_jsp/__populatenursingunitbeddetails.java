package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;

public final class __populatenursingunitbeddetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/PopulateNursingUnitBedDetails.jsp", 1724943966615L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script src=\'../../eCommon/js/common.js\' language=\'Javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n<script>\nfunction displayToolTip(obj,x_coordinate,y_coordinate)\n{\n\tobj = obj + \"^^\";\n\tobj = unescape(obj);\n\tvar rowval = obj.split (\"<br>\");\n\t\n\tvar nowrapval = \"\";\n\tvar tab_dat  = \"<table id=\'tooltiptable1\' cellpadding=0 cellspacing=0 border=\'2\' width=\'25%\' align=\'right\'>\";\n\n\tfor( var i=0; i<rowval.length-1; i++ )\n\t{\n\t\tif(i==0)\n\t\t{\n\t\t\tvar colval = rowval[i].split(\"^^\");\n\t\t\ttab_dat += \"<tr>\";\n\t\t\ttab_dat += \"<td class = \'label\' nowrap > \"+ colval[0] +\" </td>\";\n\t\t\ttab_dat += \"<td class = \'label\' nowrap > \"+ colval[1] +\" </td>\";\n\t\t\ttab_dat += \"<td class = \'label\' nowrap > \"+ colval[2] +\" </td>\";\n\t\t\ttab_dat += \"<td class = \'label\' nowrap > \"+ colval[3] +\" </td>\";\n\t\t\ttab_dat += \"<td class = \'label\' nowrap > \"+ colval[4] +\" </td>\";\n\t\t\ttab_dat += \"</tr> \";\n\t\t\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\tvar colval = rowval[i].split(\"^^\");\n\t\t\ttab_dat += \"<tr>\";\n\t\t\ttab_dat += \"<td class = \'QUERYDATA\' nowrap > \"+ colval[0] +\" </td>\";\n\t\t\ttab_dat += \"<td class = \'QUERYDATA\' nowrap > \"+ colval[1] +\" </td>\";\n\t\t\ttab_dat += \"<td class = \'QUERYDATA\' nowrap > \"+ colval[2] +\" </td>\";\n\t\t\ttab_dat += \"<td class = \'QUERYDATA\' nowrap > \"+ colval[3] +\" </td>\";\n\t\t\ttab_dat += \"<td class = \'QUERYDATA\' nowrap > \"+ colval[4] +\" </td>\";\n\t\t\ttab_dat += \"</tr>\";\n\t\t}\n\t}\n\n\ttab_dat += \"</table> \";\n\n\tif (parent.frames[1].document.getElementById(\"t\") != null)\n\t\tparent.frames[1].document.getElementById(\"t\").innerHTML = tab_dat;\n\tif(parent.frames[1].document.getElementById(\"tooltiplayer\"))\n\t\tparent.frames[1].document.getElementById(\"tooltiplayer\").style.visibility=\"visible\";\n\tif(parent.frames[1].document.body) {\n\t\tvar bodwidth  = (parent.frames[1].document.body.offsetWidth)/2;\n\t\tvar bodheight = (parent.frames[1].document.body.offsetHeight)/2;\n\t}\n\t\n//\tvar x = x_coordinate - 1;\n\tvar y = y_coordinate - 5;\n\tif(parent.frames[1].document.body)\n\t\ty += parent.frames[1].document.body.scrollTop;\n//  x += parent.frames[1].document.body.scrollLeft;\n\tif(parent.frames[1].document.getElementById(\"tooltiplayer\")) {\n\t\tparent.frames[1].document.getElementById(\"tooltiplayer\").style.left= bodwidth;//2;\n\t\tparent.frames[1].document.getElementById(\"tooltiplayer\").style.top =bodheight; //y;\n\t}\n}\n\n\n</script>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\"bed_class_form1\" id=\"bed_class_form1\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
	Connection con			= null;
	PreparedStatement pstmt	= null;
	ResultSet rs			= null;

	//String locale					= (String)session.getAttribute("LOCALE");
	String facilityId				=	(String)session.getValue("facility_id");
	String nursingunitcode			= checkForNull(request.getParameter("nursingunit"));
	String x_coordinate				= checkForNull(request.getParameter("x_coordinate"));
	String y_coordinate				= checkForNull(request.getParameter("y_coordinate"));

	try
	{
		StringBuffer sql	=	new StringBuffer();
		StringBuffer tooltipStr	=  new StringBuffer();
		String bed_class	= "";				
		String total_beds	= "";				
		String occupied		= "";				
		String vacant		= "";				
		String block		= "";	
		int maxCount		= 0;
		//and a.eff_status = 'E' Added by Dharma on 26th Nov 2018 against AMS-SCF-0707 [IN:068007]
		sql.append("SELECT IP_GET_DESC.IP_BED_CLASS(b.bed_class_code,?,2) bed_class ,COUNT(*) total_beds, COUNT(a.occupying_patient_id) occupied, COUNT(*) - (COUNT(a.occupying_patient_id) + (SELECT COUNT(*) FROM IP_BED_BOOKING WHERE facility_id = ?  AND req_nursing_unit_code = ? AND req_bed_class_code = b.bed_class_code and booking_status in ('0','1') and ((sysdate BETWEEN blocked_from_date_time AND blocked_until_date_time) or ( booking_type = 'N' and blocked_until_date_time is null ))))vacant, (SELECT COUNT(*) FROM IP_BED_BOOKING WHERE facility_id = ? AND req_nursing_unit_code = ? AND req_bed_class_code = b.bed_class_code and booking_status in ('0','1') and ((sysdate BETWEEN blocked_from_date_time AND blocked_until_date_time) or (booking_type = 'N' and blocked_until_date_time is null ))) block FROM IP_NURSING_UNIT_BED a, IP_BED_CLASS b WHERE a.facility_id = ? AND a.nursing_unit_code = ? AND a.bed_class_code = b.bed_class_code AND pseudo_bed_yn = 'N' and a.eff_status = 'E' GROUP BY b.bed_class_code ");

//out.println("<script>alert(\""+sql.toString()+"\")</script>");
		con		=	ConnectionManager.getConnection(request);
		pstmt	=	con.prepareStatement(sql.toString());
		pstmt.setString(1,localeName);
		pstmt.setString(2,facilityId);
		pstmt.setString(3,nursingunitcode);
		pstmt.setString(4,facilityId);
		pstmt.setString(5,nursingunitcode);
		pstmt.setString(6,facilityId);
		pstmt.setString(7,nursingunitcode);
		rs		=	pstmt.executeQuery();

		while(rs.next())
		{

			if(maxCount==0)
			{
				tooltipStr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedClass.label","common_labels"));
				tooltipStr.append("^^");
				tooltipStr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.TotalBeds.label","ip_labels"));
				tooltipStr.append("^^");
				tooltipStr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Occupied.label","common_labels"));
				tooltipStr.append("^^");
				tooltipStr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Vacant.label","common_labels"));
				tooltipStr.append("^^");
				tooltipStr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.block.label","common_labels"));
				tooltipStr.append("^^");
				tooltipStr.append("<br>");
			}

			bed_class				= checkForNull(rs.getString("bed_class"));
			total_beds				= checkForNull(rs.getString("total_beds"));
			occupied				= checkForNull(rs.getString("occupied"));
			vacant					= checkForNull(rs.getString("vacant"));
			vacant					= Integer.parseInt(vacant) < 0 ? "0" : vacant +"";
			block					= checkForNull(rs.getString("BLOCK"));

			tooltipStr.append(bed_class);
			tooltipStr.append("^^");
			tooltipStr.append(total_beds);
			tooltipStr.append("^^");
			tooltipStr.append(occupied);
			tooltipStr.append("^^");
			tooltipStr.append(vacant);
			tooltipStr.append("^^");
			tooltipStr.append(block);
			tooltipStr.append("^^");
			tooltipStr.append("<br>");
			maxCount++;
		}
		
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();

		if(maxCount>0)
		{
			out.println("<script>displayToolTip(\""+tooltipStr.toString()+"\",\""+x_coordinate+"\",\""+y_coordinate+"\");</script>");
		}
	}catch(Exception e) 
	{	
		
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
