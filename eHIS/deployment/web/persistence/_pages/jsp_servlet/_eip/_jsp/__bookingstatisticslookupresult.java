package jsp_servlet._eip._jsp;

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

public final class __bookingstatisticslookupresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/BookingStatisticsLookupResult.jsp", 1742367687081L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n\t<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<script>\n\t\t\tfunction closeWin(val)\n\t\t\t{\n\t\t\t\twindow.parent.returnValue=val\n\t\t\t\twindow.parent.close()\n\t\t\t}\n\n\t\t\tasync function showModal(valu)\n\t\t\t{\n\t\t\t\tif(param.value !=\'returnval\')\n\t\t\t\t{\n\t\t\t\tvar retVal = \tnew String();\n\t\t\t\tvar dialogHeight= \"1000px\" ;\n\t\t\t\tvar dialogWidth\t= \"1200px\" ;\n\t\t\t\tvar dialogTop = \"80\" ;\n\t\t\t\tvar center = \"1\" ;\n\t\t\t\tvar status=\"no\";\n\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\t\tvar arguments\t= \"\" ;\n\t\t\t\tretVal = await window.showModalDialog(\"../jsp/AmendBookingMain.jsp?bookingRefNo=\"+valu ,arguments,features);\n\t\t\t\tparent.frames[1].document.location.reload();\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\tparent.window.returnValue=valu ;\n\t\t\t\tparent.window.close();\n\t\t\t\t}\n\t\t\t}\n\t\t\t\n\t\t\tasync function callCanRev(valu)\n\t\t\t{\n\t\t\t\tvar dialogHeight= \"80vh\" ;\n\t\t\t\tvar dialogWidth\t= \"75vw\" ;\n\t\t\t\tvar dialogTop = \"80\" ;\n\t\t\t\tvar center = \"1\" ;\n\t\t\t\tvar status=\"no\";\n\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\t\tvar arguments\t= \"\" ;\n\t\t\t\tretVal = await window.showModalDialog(\"../jsp/AmendBookingMain.jsp?calling=AB&bookingRefNo=\"+valu ,arguments,features);\n\t\t\t}\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t</head>\t\t\t\t\t\t\t\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t<input type=\'hidden\' name=\'param\' id=\'param\' value=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' >\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

			request.setCharacterEncoding("UTF-8");
			Connection con = null;
			Statement stmt = null;
			ResultSet rs =null;
			
			Statement ipstmt = null;
			ResultSet iprs =null;
			String ipsql = "";
			String facility_id = (String)session.getValue("facility_id");
			StringBuffer where_criteria = new StringBuffer();
			String soundex_function = "";
			StringBuffer sql = new StringBuffer();
			String class_val = "QRYEVEN";
			String whereClause = request.getParameter("whereclause");
			String soundex_type	=request.getParameter("soundex");
			String nursing_unit_code=request.getParameter("nursing_unit");
			String speciality_code	=request.getParameter("Splcode");
			String practitioner_id	=request.getParameter("practid");
			String from_date	=request.getParameter("from_date");
			String to_date		=request.getParameter("to_date");
			String patient_id	=request.getParameter("patient_id");
			String gender		=request.getParameter("gender");
			String name_prefix	=request.getParameter("name_prefix");
			String name_suffix	=request.getParameter("name_suffix");
			String first_name	=request.getParameter("first_name");
			String second_name	=request.getParameter("second_name");
			String third_name	=request.getParameter("third_name");
			String family_name	=request.getParameter("family_name");
			
			String param=request.getParameter("param");
			if(param == null) param="";
			String call_function = request.getParameter("call_function");
			//AB -->Active Booking
			//CB --> Cancel Booking
			if( call_function == null )
				call_function ="";

			String patient_name	="";
			String nursing_unit_short_desc="";
			String bed_no="";
			String patient_id1="";
			String bkg_grace_period ="";
			
			
	
            _bw.write(_wl_block4Bytes, _wl_block4);

			try{
				con =ConnectionManager.getConnection(request);
				stmt = con.createStatement();
				ipstmt = con.createStatement();
				if(whereClause==null)
				{
					if(soundex_type!=null)
					{
						if(soundex_type.equals("E"))
							soundex_function = "ethnic_soundex";
						else
							soundex_function = "soundex";
					}
					
					//facility_id
					if(where_criteria.length() > 0) where_criteria.delete(0,where_criteria.length());
					where_criteria.append(" and facility_id='"+facility_id+"'");

					//nursing_unit_code
					if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
					{
						where_criteria.append(" and nursing_unit_code='"+nursing_unit_code+"' ");
					}

					//speciality_code
					if(speciality_code!=null && !speciality_code.equals(""))
					{
						where_criteria.append(" and specialty_code='"+speciality_code+"' ");
					}
					
					//practitioner_id
					if(practitioner_id!=null && !practitioner_id.equals(""))
					{
						where_criteria.append(" and practitioner_id='"+practitioner_id+"' ");
					}

					//from_date
					if(from_date!=null && !from_date.equals(""))
					{
						where_criteria.append(" and trunc(preferred_date) >= to_date('"+from_date+"' , 'dd/mm/rrrr') ");
					}
					
					//to_date
					if(to_date!=null && !to_date.equals(""))
					{
						where_criteria.append(" and trunc(preferred_date) <= to_date('"+to_date+"' , 'dd/mm/rrrr') ");
					}

					//patient_id
					if(patient_id!=null && !patient_id.equals(""))
					{
						where_criteria.append(" and patient_id like'"+patient_id+"%' ");
					}

					//gender
					if(gender!=null && !gender.equals(""))
					{
						where_criteria.append(" and gender='"+gender+"' ");
					}

					//name_prefix
					if(name_prefix!=null && !name_prefix.equals(""))
					{
						where_criteria.append(" and name_prefix='"+name_prefix+"' ");
					}

					//name_suffix
					if(name_suffix!=null && !name_suffix.equals(""))
					{
						where_criteria.append(" and name_suffix='"+name_suffix+"' ");
					}
					//first_name
					if(first_name!=null && !first_name.equals(""))
					{
						where_criteria.append(" and "+soundex_function+"(first_name) like "+soundex_function+"('"+first_name+"') || '%' ");
					}

					//second_name
					if(second_name!=null && !second_name.equals(""))
					{
						where_criteria.append(" and "+soundex_function+"(second_name) like "+soundex_function+"('"+second_name+"') || '%' ");
					}

					//third_name
					if(third_name!=null && !third_name.equals(""))
					{
						where_criteria.append(" and "+soundex_function+"(third_name) like "+soundex_function+"('"+third_name+"') || '%' ");
					}

					//family_name
					if(family_name!=null && !family_name.equals(""))
					{
						where_criteria.append(" and "+soundex_function+"(family_name) like "+soundex_function+"('"+family_name+"') || '%' ");
					}
				}
				else
				{
					if(where_criteria.length() > 0) where_criteria.delete(0,where_criteria.length());
					where_criteria.append(whereClause);
				}

				ipsql = "Select bkg_grace_period from ip_param where facility_id='"+facility_id+"' ";
				iprs = ipstmt.executeQuery(ipsql);
				if(iprs!= null)
				{
					if(iprs.next())
					{
						bkg_grace_period = iprs.getString("bkg_grace_period");
							if(bkg_grace_period == null) bkg_grace_period ="";
					}					
				}
				if(iprs!=null)   iprs.close();
				if(ipstmt!=null) ipstmt.close();
/*
				if(sql.length() > 0) sql.delete(0,sql.length());				
				sql.append(" select  count(*)");
				sql.append(" from ip_booking_list_vw where");
				sql.append(" booking_status='1' and trunc(preferred_date)>= trunc(sysdate-"+maxperiodforrevbkg+") " +where_criteria.toString());
				sql.append(" order by bkg_lst_ref_no, preferred_date");
				
				
				rs = stmt.executeQuery(sql.toString());
				rs.next();
	*/
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" select bkg_lst_ref_no, preferred_date, to_char(preferred_date, 'dd/mm/rrrr')  ");
				sql.append("  disp_preferred_date, patient_id,");
				sql.append(" patient_name, nursing_unit_short_desc, bed_no from ip_booking_list_vw where");				

	
				if ( call_function.equals("CB") )
					sql.append(" ( ( booking_status ='1'  and trunc(preferred_date)<= trunc(sysdate))  or booking_status='9')  " +where_criteria.toString() );		
				else
					//sql+= " booking_status='1'  " +where_criteria ;
					sql.append(" booking_status='1' and trunc(preferred_date)>= trunc(sysdate- "+bkg_grace_period+") " +where_criteria.toString() );
						
						
				sql.append(" order by bkg_lst_ref_no, preferred_date");
						
				//out.println(sql.toString());		
				rs		= stmt. executeQuery(sql.toString());
	

				out.println(" <table cellspacing=0 cellpadding=0 align='center' width='100%' border='1' cellpadding=0 cellspacing=0>");
				
					out.println("<tr>");
						out.println("<th>&nbsp;</th>");
						out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BookingRefNo.label","common_labels")+"</th>");
						out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PreferredDate.label","common_labels")+"</th>");
						out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"</th>");
						out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels")+"</th>");
						out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+"</th>");
						out.println("<th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels")+"</th>");
					out.println("</tr>");
					
					if(rs!=null)
					{
						while(rs.next())
						{
							
							patient_id1=rs.getString("patient_id");
							if(patient_id1 == null) patient_id1="&nbsp;";

							patient_name=rs.getString("patient_name");
							if(patient_name == null) patient_name="&nbsp;";

							nursing_unit_short_desc=rs.getString("nursing_unit_short_desc");
							if(nursing_unit_short_desc== null) nursing_unit_short_desc="&nbsp;";

							bed_no = rs.getString("bed_no");
							if( bed_no == null) bed_no="&nbsp;";


							if(class_val.equals("QRYEVEN"))
								class_val = "QRYODD";
							else
								class_val = "QRYEVEN";

							out.println("<tr>");
							/*	if ( call_function.equals("AB") )
								{*/
									out.println("<td class='"+class_val+"'><a href=\"javascript:callCanRev('"+rs.getString("bkg_lst_ref_no")+"')\">+</a></td>");
								
								out.println("<td class='"+class_val+"'>");
								if(param.equals("ADMIT") )
									out.println("<a href=\"javascript:closeWin('"+rs.getString("bkg_lst_ref_no")+"')\">");			
								else if(! (call_function.equals("AB") || call_function.equals("CB")) )
									out.println("<a href=\"javascript:showModal('"+rs.getString("bkg_lst_ref_no")+"')\">");
								out.println(rs.getString("bkg_lst_ref_no")+"</a></td>");

								out.println("<td class='"+class_val+"'>"+rs.getString("disp_preferred_date")+"</td>");
								out.println("<td class='"+class_val+"'>"+patient_id1+"</td>");
								out.println("<td class='"+class_val+"'>"+patient_name+"</td>");
								out.println("<td class='"+class_val+"'>"+nursing_unit_short_desc+"</td>");
								out.println("<td class='"+class_val+"'>"+bed_no+"</td>");
							out.println("</tr>");
						}
					}
	out.println("</table>");
	if (rs != null) rs.close();
	}catch(Exception e) {out.println(e.toString());}
	finally
	{
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		if (ipstmt != null) ipstmt.close();
		ConnectionManager.returnConnection(con,request);
	}
				
	
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(param));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
