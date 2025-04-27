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
import java.util.*;
import java.text.*;
import java.sql.*;

public final class __surgeryorderlookupresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/SurgeryOrderLookUpResult.jsp", 1733210608102L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n   \t\t Developed By  :- Maheshwaran K for the CRF : RUT-CRF-0012 (23395\t) as on 09/01/2013\n   \t\t Function      :-  To Display the Surgery OT Order related to the Patient IDs\n\t\t -->\n";
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\nfunction callMethod(start,end,patient_id,booking_ref_no)\n\t{\n\tvar start1=parseInt(start);\n\tvar end1=parseInt(end);\n\tvar  HTMLVal = new String();\n\tHTMLVal = \"<html><body onKeyDown=\'lockKey()\'><form name=\'dum_form\' id=\'dum_form\' method=\'post\' action=\'../../eIP/jsp/SurgeryOrderLookUpResult.jsp\'><input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'\"+patient_id+\"\'><input type=\'hidden\' name=\'from\' id=\'from\' value=\"+start1+\"><input type=\'hidden\' name=\'to\' id=\'to\' value=\"+end1+\"><input type=\'hidden\' name=\'booking_ref_no\' id=\'booking_ref_no\' value=\"+booking_ref_no+\"></form></body></html>\";\n\tdocument.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\tdocument.dum_form.submit();\n\t}\nfunction ReturnSurgeryOrder(order_id,order_line_no,oper_code,oper_desc,oper_surg_date)\n\t{\n\toper_desc=oper_desc.replace(\"#@\",\"\'\");//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395\t)-linked [IN:038460] as on 08/03/2013\n\twindow.returnValue = order_id+\"$\"+order_line_no+\"$\"+oper_code+\"$\"+oper_desc+\"$\"+oper_surg_date; \n\twindow.close();\n\t}\n//Maheshwaran K added for the Inci No : RUT-SCF-0258 [IN:039356] as on 15/04/2013\n//Start\nwindow.onunload = function() {\nif((window.returnValue==undefined)||(window.returnValue==\"\"))\n\t{\n\twindow.returnValue = \"\"+\"$\"+\"\"+\"$\"+\"\"+\"$\"+\"\"+\"$\"+\"\"; \n\t}\n}\n//End\n</script>\n<HEAD>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n  <body >\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t<input name=\'patient_id\' id=\'patient_id\' type=\'hidden\' value =";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =">\n\t\t<input type=hidden name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t<input type=hidden name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t\t<input type=hidden name=\'booking_ref_no\' id=\'booking_ref_no\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t<table width=\'100%\' border=\'0\' align=\'center\' >\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td width=\'20%\' align=\'right\' class=\'NONURGENT\'>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t\t\t\t<a href=\"javaScript:callMethod(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\',\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\')\" id=\'prev\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</a>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'prev\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\')\" id=\'next\' style=\'visibility:hidden\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</a>\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<input type=hidden name=\'whichPage\' id=\'whichPage\' value=\'next\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<th>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</th>\t\t\t\t\n\t\t\t\t\t\t\t\t\t<th>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</th>\n\t\t\t\t\t\t\t\t\t<th>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</th>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t\t<a href=\"javaScript:ReturnSurgeryOrder(\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\',";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =",\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\')\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</a>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\t\t\t\t\n\t\t\t\t\t\t\t<td>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="<td>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t<script >\n\t\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t<script >\n\t\t\t\t\t\tif (document.getElementById(\"next\"))\n\t\t\t\t\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t\t\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\n\t\t</table>\t\n\t</body>\t\t\n</html>\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

	//This Method is used to check whether OT Order already exists in IP_BOOKING_LIST for a particular Patient ID
	public boolean CheckOTOrderExists(Connection con ,String facilityID,String patient_id,String order_id,String booking_ref_no1,String order_line_no)
		{
		Statement ot_stmt=null;
		ResultSet ot_rset=null;
		boolean order_exists=false;
		String ot_sql="";
		try
			{
			if(booking_ref_no1.equals(""))
				{
				ot_sql="select count(*) as cnt from ip_booking_list where patient_id='"+patient_id+"' and facility_id='"+facilityID+"' and order_id='"+order_id+"' and order_line_no='"+order_line_no+"'";
				}
			else
				{
				ot_sql="select count(*) as cnt from ip_booking_list where patient_id='"+patient_id+"' and facility_id='"+facilityID+"' and order_id='"+order_id+"' and order_line_no='"+order_line_no+"' and BKG_LST_REF_NO!='"+booking_ref_no1+"'";
				}
			ot_stmt=con.createStatement();
			ot_rset=ot_stmt.executeQuery(ot_sql);
			ot_rset.next();
			int cnt=ot_rset.getInt("cnt");
			if(cnt>0)
				{
				order_exists=true;
				}
			ot_stmt.close();
			ot_rset.close();
			}
		catch(Exception e)	
			{
			System.out.println("Exception occurred while checking the ORDER ID exists in IP_BOOKING_LIST  : "+e);
			e.printStackTrace();
			}
		finally
			{
			try
				{if(ot_stmt!=null)
				ot_stmt.close();
				}
			catch(Exception e)	{}
			}
		return order_exists;	
		}

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
	String locale					= (String)session.getAttribute("LOCALE");
	String facilityID				= (String)session.getAttribute("facility_id");
	String all_surgeons=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.AllSurgeons.label","ot_labels") ;
	
            _bw.write(_wl_block8Bytes, _wl_block8);

		String patient_id=request.getParameter("patient_id");
		String from = request.getParameter( "from"  );
		String to = request.getParameter( "to")  ;
		String booking_ref_no = checkForNull(request.getParameter( "booking_ref_no"))  ;
		int start = 0 ;
		int end = 0 ;
		int s=0;
		int i=1;
		if ( from == null )
		start = 1 ;
		else
		start = Integer.parseInt( from );
		if ( to == null )
		end = 10 ;
		else
		end = Integer.parseInt( to ) ;
		int maxRecord = 0;
		String order_id="";
		String order_line_no="";
		String oper_code="";
		String oper_desc="";
		String pref_surg_date="";
		String speciality_desc="";
		String team_surgeon_name="";
		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(start));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(end));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(booking_ref_no));
            _bw.write(_wl_block13Bytes, _wl_block13);

			Connection con = null;
			Statement stmt=null;
			ResultSet rset=null;
			try
				{
				con =ConnectionManager.getConnection(request); 
				try
					{
					String sql="SELECT a.order_id surg_order_id,c.order_line_no surg_order_line_no,b.oper_code oper_code,b.short_desc oper_desc, TO_CHAR (a.pref_surg_date, 'dd/mm/yyyy') pref_surg_date,a.speciality_desc speciality_desc,a.team_surgeon_name team_surgeon_name  FROM ot_pending_orders_vw a, ot_oper_mast_lang_vw b , ot_pending_order_line c WHERE a.language_id = '"+locale+"'  AND b.language_id = '"+locale+"' AND a.performing_facility_id = '"+facilityID+"' and b.order_catalog_code=c.order_catalog_code  and a.order_id=c.order_id  AND b.order_catalog_code IN (SELECT order_catalog_code   FROM ot_pending_order_line WHERE order_id = a.order_id AND ROWNUM = 1)  AND a.pref_surg_date BETWEEN TO_DATE (NVL (to_char(SYSDATE,'DD/MM/YYYY'), '01/01/1900') || '00:00','DD/MM/YYYY HH24:MI') AND TO_DATE (NVL ('', '01/01/3000') || '23:59','DD/MM/YYYY HH24:MI') and a.patient_id='"+patient_id+"' order by a.pref_surg_date desc";
					stmt=con.createStatement();
				rset=stmt.executeQuery(sql);
					}
				catch(SQLException e)	
					{
					System.out.println("Exception occurred while executing the query to get Surgery Order  : "+e);
					e.printStackTrace();
					}
			 
				try
					{
					if ( start != 1 )
					for( int j=1; j<start; i++,j++ )
					rset.next() ;
					if(rset!=null)
						{
						while( i<=end && rset.next()  )
							{
							if(maxRecord==0)
							{
							
            _bw.write(_wl_block14Bytes, _wl_block14);

										if ( !(start <= 1) )
											{
											
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(start-10));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(end-10));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(booking_ref_no));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")));
            _bw.write(_wl_block18Bytes, _wl_block18);

											}
										//if ( !( (start+3) > maxRecord ) )
								//		{
											
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(start+10));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(end+10));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(booking_ref_no));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")));
            _bw.write(_wl_block20Bytes, _wl_block20);

									//		}
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

							}
							order_id=rset.getString("surg_order_id");		
							order_line_no=rset.getString("surg_order_line_no");		
							oper_code=rset.getString("oper_code");		
							oper_desc=rset.getString("oper_desc");		
							pref_surg_date=com.ehis.util.DateUtils.convertDate(rset.getString("pref_surg_date"),"DMY","en",locale);		
							speciality_desc=rset.getString("speciality_desc");
							team_surgeon_name=rset.getString("team_surgeon_name");		
							boolean order_exists=CheckOTOrderExists(con ,facilityID,patient_id,order_id,booking_ref_no,order_line_no);
							
            _bw.write(_wl_block25Bytes, _wl_block25);
if(order_exists==true)
								{
								out.println(oper_desc);			
								}
							else
								{	
								String oper_desc1= oper_desc.replaceAll("'","#@");//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	)-linked [IN:038460] as on 08/03/2013
								
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(oper_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(oper_desc1));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(pref_surg_date));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(oper_desc));
            _bw.write(_wl_block30Bytes, _wl_block30);

								}
								
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(pref_surg_date));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(speciality_desc));
            _bw.write(_wl_block33Bytes, _wl_block33);
if(team_surgeon_name==null)
								{
								
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(all_surgeons));
            _bw.write(_wl_block35Bytes, _wl_block35);
					
								}
							else
								{
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(team_surgeon_name));
            _bw.write(_wl_block37Bytes, _wl_block37);

								}
								
            _bw.write(_wl_block38Bytes, _wl_block38);

							maxRecord++;
							i++;
							}
						}
					if(maxRecord==0)
					{
						/* out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); window.returnValue =''; window.close();</script>"); */
						out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); parent.parent.document.getElementById('dialog_tag').close();</script>");
					}
					if ((maxRecord < 3) ||(!rset.next()))
						{
						
            _bw.write(_wl_block39Bytes, _wl_block39);

						}
						else
							{
							
            _bw.write(_wl_block40Bytes, _wl_block40);

							}
					rset.close();
					stmt.close();
					}
				catch(SQLException e)	
					{
					System.out.println("Exception occurred while getting the Surgery Order  : "+e);
					e.printStackTrace();
					}	
				}
			catch(Exception e) {out.println(e.toString());}
			finally
				{
				ConnectionManager.returnConnection(con,request); 
				}	
			
            _bw.write(_wl_block41Bytes, _wl_block41);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.SurgeryOrder.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.SurgeryDate.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgeon.label", java.lang.String .class,"key"));
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
}
