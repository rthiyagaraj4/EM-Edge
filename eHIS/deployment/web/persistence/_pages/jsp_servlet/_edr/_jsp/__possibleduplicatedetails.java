package jsp_servlet._edr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eDR.*;

public final class __possibleduplicatedetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/edr/jsp/PossibleDuplicateDetails.jsp", 1742295388554L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n   <!--   <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n   ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n     <script language=\'javascript\' src=\'../../eDR/js/PossibleDuplicates.js\'></script>\n     <Script language=\"JavaScript\" src=\"../../eCommon/js/common.js\" ></Script>\n     <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\'lockKey();\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t   <script>\n\t\t\t\t\t\tparent.frames[1].document.getElementById(\"p_patcount\").value = ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" ; \n\t\t\t\t\t\tparent.frames[4].document.getElementById(\"duplicatesdetails\").disabled = false;\n\t\t\t\t   </script>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" \n\t\t\t\t  <script>\n\t\t\t\t\t\t   var ErrorText = getMessage(\'NO_RECORD\',\'DR\');\n\t\t\t\t\t\t   parent.parent.frames[2].location.href =\"../../eCommon/jsp/error.jsp?err_val=&err_num=\"+ErrorText;\n\t\t\t\t\t\t   parent.frames[4].document.getElementById(\"duplicatesdetails\").disabled = true;\n\t\t\t\t  </script>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n    <form name=\'group_details_form\' id=\'group_details_form\'>\n\t<table border=0 width=100% cellspacing=0 cellpadding=0 >\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t  <tr>\n\t\t\t\t<td width=8% class=\'fields\'>\n\t\t\t\t\t<input type=checkbox name=\'selectpatient";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' id=\'selectpatient";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' onClick=\'javascript:checkDuplicatesDetails(\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\",\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\")\' ></td>\n\t\t\t\t<td width=3% class=\'label\'><a href=\'javascript:viewPatientDetails(\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\")\'>+</a></td>\n\t\t\t\t<td width=48% class=\'label\' colspan=\'1\' ><font size=1>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</font></td>\n\t\t\t\t<td width=10% class=label>\n\t\t\t\t   <input type=\'hidden\' name=\'selectpatientid";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' id=\'selectpatientid";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t<IMG SRC=\"../../eCommon/images/enabled.gif\" BORDER=0 ALT=\"\"></IMG></td>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\n\t\t\t\t<td width=10% class=label align=\'center\' >\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t<td width=20%class=label align=\'center\' >\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t\t<td class=\'label\' colspan=\'5\'><font size=1>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" </font></td>\n\t\t\t\t\t</tr>\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\n \t</table>\n\t\t<input type=hidden name=patcount id=patcount value=0>\n\t\t<input type=hidden name=patient_id1 id=patient_id1 value=\'\'>\n\t\t<input type=hidden name=patient_id2 id=patient_id2 value=\'\'>\n\t\t<input type=hidden name=p_dup_group_id id=p_dup_group_id value=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =">\n\t\t<input type=hidden name=p_dup_count id=p_dup_count value=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =">\n </form>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

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
            _bw.write(_wl_block6Bytes, _wl_block6);

    request.setCharacterEncoding("UTF-8");
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String locale=(String)session.getAttribute("LOCALE");

	Connection con              = null;
	java.sql.Statement	stmt    = null;
	ResultSet	rs			    = null;

	String str				    = "";
	String p_patient_id		    = "";
	String p_dup_group_id	    = "";
	String p_valid_duplicate    = "";
	String p_valid_check        = "";
	String p_dup_check          = "";
	String p_not_check          = "";
	String p_patient_line       = "";
	String p_dup_count		    = "";
	String p_order_by		    = "";
	String group_status		    = "";

	int i				        = 0;

	p_dup_count				    = request.getParameter("p_pat_count");
	p_patient_id                = request.getParameter("patient_id");

    try
	   {
		 con=ConnectionManager.getConnection(request);
		 stmt			    =con.createStatement();
		 if(p_patient_id==null)
		 {
		   p_patient_id ="";
		 }
		 if(p_dup_count==null)
		 {
		   p_dup_count  ="";
		 }

		 //str  =  "select dup_group_id,pat_count from dr_dup_group_vw2 where  system_gen_yn='Y' and marked_for_merge_yn='N' and patient_id = nvl(('"+p_patient_id+"'),patient_id) ";

		 str  =  " SELECT b.dup_group_id, pat_count FROM DR_DUP_GROUP_HDR A,DR_DUP_GROUP_DTLS B WHERE   A.DUP_GROUP_ID = B.DUP_GROUP_ID AND system_gen_yn='Y' AND marked_for_merge_yn='N'  and group_status = 'U' AND patient_id = NVL(('"+p_patient_id+"'),patient_id) ";

		 rs	  =  stmt.executeQuery(str);

		  if (rs != null)
			{
			  if (rs.next())
			   {
				 p_dup_group_id = rs.getString("dup_group_id");
				 p_dup_count    = rs.getString("pat_count") ;

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_dup_count));
            _bw.write(_wl_block10Bytes, _wl_block10);
			
			   }
			  else
			  {

            _bw.write(_wl_block11Bytes, _wl_block11);
			  }
		  }
	if (rs != null) rs.close();
	str  = "select decode(order_by_for_process_cycle,'P','PATIENT_ID','R','MP_PATIENT_ADDED_DATE','L','FILE_LOCATION','F','FILE_NO') order_by_for_process_cycle from dr_process_ctl " ;
	rs	 = stmt.executeQuery(str);
	if(rs!=null)
	{
		 if (rs.next())
		  {
			p_order_by = rs.getString("order_by_for_process_cycle");
		  }
	}
	if (rs != null) rs.close();

	//str   = "select group_status,dup_group_id,patient_id,mp_patient_added_date,	dup_indicator  valid_duplicate,patient_line from dr_dup_group_vw2 where dup_group_id='"+p_dup_group_id+"' " + " order by "+p_order_by+" ";

	str   = "SELECT group_status, a.dup_group_id, patient_id, mp_patient_added_date, dup_indicator valid_duplicate, SUBSTR(get_patient_line(patient_id,'"+locale+"'),1,LENGTH(get_patient_line(patient_id,'"+locale+"'))-6) patient_line FROM  DR_DUP_GROUP_HDR A,DR_DUP_GROUP_DTLS B WHERE A.DUP_GROUP_ID = B.DUP_GROUP_ID AND     a.dup_group_id='"+p_dup_group_id+"' ORDER BY "+p_order_by+"";
	
	rs	  = stmt.executeQuery(str);

            _bw.write(_wl_block12Bytes, _wl_block12);

	if (rs != null)
	  {
		while (rs.next())
		 {
				i++;
				p_patient_id		= rs.getString("patient_id") ;
				p_valid_duplicate	= rs.getString("valid_duplicate");
				p_patient_line		= rs.getString("patient_line") ;
				group_status		= rs.getString("group_status") ;
			    if(p_valid_duplicate.equals("V"))
					{
						p_valid_check = "checked";
						p_dup_check   = "unchecked";
						p_not_check   = "unchecked";
					}
					else if(p_valid_duplicate.equals("D"))
					{
						p_valid_check = "unchecked";
						p_not_check   = "unchecked";
						p_dup_check   = "checked";
					}
					else if(p_valid_duplicate.equals("X"))
					{
						p_valid_check = "unchecked";
						p_dup_check   = "unchecked";
						p_not_check   = "checked";
					}

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
              
				if (group_status.equals("I")){
				if (p_valid_check.equals("checked"))
				{

            _bw.write(_wl_block23Bytes, _wl_block23);

				}
				}

            _bw.write(_wl_block24Bytes, _wl_block24);
              if (group_status.equals("I")){
				if (p_dup_check.equals("checked"))
				{


            _bw.write(_wl_block23Bytes, _wl_block23);

				}
				}

            _bw.write(_wl_block25Bytes, _wl_block25);
               if (group_status.equals("I")){ 
				if (p_not_check.equals("checked"))
				{


            _bw.write(_wl_block23Bytes, _wl_block23);

				}
              }

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(p_patient_line));
            _bw.write(_wl_block27Bytes, _wl_block27);

				}
			}if (rs != null) rs.close();

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(p_dup_group_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(p_dup_count));
            _bw.write(_wl_block30Bytes, _wl_block30);
  if (rs != null) rs.close();
	if (stmt != null) stmt.close();
	}
	catch(Exception e)
	{
	   out.println("Error From File PossibleDuplicateDetails"+ e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block31Bytes, _wl_block31);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
