package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __setupdailyschallocationdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/SetUpDailySchAllocationDetails.jsp", 1709119276506L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html> \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'></link>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script language=\"JavaScript\">\n\t\t\tfunction validateSlots(obj,rownum)\n\t\t\t{\n\t\t\t\tif(obj.value == \'\') obj.value=0;\n\n\t\t\t\tif(CheckNum(obj))\n\t\t\t\t{\n\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' == \'Decreased\')\n\t\t\t\t\t{\n\t\t\t\t\t\tvar a = eval(\"document.getElementById(\"block_slot\")\"+rownum+\".value\");\n\t\t\t\t\t\tvar arr = a.split(\"`\");\n\t\t\t\t\t\ttotalslots = arr[0];\n\t\t\t\t\t\tif(eval(obj.value)>totalslots)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\talert(\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" Slots must be lesser than or equal to (Max Patients - Total Booked Patients )\");\n\t\t\t\t\t\t\tobj.focus();\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<body onLoad=\"document.getElementById(\"h\").verticalAlign=\'middle\'\" OnMouseDown=\"CodeArrest()\"onKeyDown = \'lockKey()\' >\n<form name=\"BlockApptAllocationDetails_form\" id=\"BlockApptAllocationDetails_form\">\n\t<table align=right cellpadding=0 cellspacing=0 width=\"98%\" border=1>\n\t\t<tr>\n\t\t\t<td colspan=4 class=DATA>\n\t\t\t\t<h5 id=h style=\"vertical-align: middle\">Slots to be ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="= ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</h5>\n\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" name=slots_inc_dec>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<th>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t\t<th>Max Patients</th>\n\t\t\t<th>Total Booked Patients</th>\n\t\t\t<!-- <th>Slots Blocked</th> -->\n\t\t\t<th>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" Slots</th>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t</table>\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" name=\"total_count\">\n\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" name=\"inc_dec\">\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");	
	String incdec = request.getParameter("inc_dec")==null?"":request.getParameter("inc_dec");

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(incdec));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(incdec));
            _bw.write(_wl_block6Bytes, _wl_block6);

		String facilityid = request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
        String sql="";
		String locncode =request.getParameter("location_code")==null?"":request.getParameter("location_code");
		String practitionerid = request.getParameter("practitioner_id")==null?"":request.getParameter("practitioner_id");
		String clinicdate = request.getParameter("clinic_date")==null?"":request.getParameter("clinic_date");
		String alcncriteria = request.getParameter("alcn_criteria")==null?"":request.getParameter("alcn_criteria");
		String allocation_changed = request.getParameter("allocation_changed")==null?"":request.getParameter("allocation_changed");
		String final_string = request.getParameter("final_string")==null?"":request.getParameter("final_string");
		String max_patients_per_day = request.getParameter("max_patients_per_day")==null?"":request.getParameter("max_patients_per_day");
		String alcncriteriadesc = "";
		if(alcncriteria.equals("NG"))
			alcncriteriadesc = "Nationality Group";
		else if(alcncriteria.equals("BG"))
			alcncriteriadesc = "Billing Group";
		String slotsincdec = request.getParameter("slots_inc_dec")==null?"&nbsp;":request.getParameter("slots_inc_dec");
		Connection con = null ;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt=null;
		String className = "";
		String readOnly = "";
		int i =0;

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(incdec));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(slotsincdec));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(slotsincdec));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(alcncriteriadesc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(incdec));
            _bw.write(_wl_block12Bytes, _wl_block12);
		
			
			if(alcncriteria.equals("NG"))
			{
				//sql = "select a.srl_no, a.alcn_criteria,a.alcn_catg_code,a.max_patients,a.total_booked_patients,a.total_blocked_slots,b.stat_grp_desc long_desc, to_number(a.max_patients - (a.total_booked_patients)) final_slots from oa_clinic_schedule_dtl a,am_stat_group b where a.facility_id='"+facilityid+"' and a.clinic_code='"+locncode+"' and to_char(a.clinic_date,'dd/mm/yyyy')=to_char(to_date('"+clinicdate+"','dd/mm/yyyy'),'dd/mm/yyyy') and nvl(a.practitioner_id,'|')=nvl('"+practitionerid+"','|') and a.alcn_catg_code=b.stat_grp_id(+) ORDER BY 2 DESC";
				sql = "select a.srl_no, a.alcn_criteria,a.alcn_catg_code,a.max_patients,a.total_booked_patients,a.total_blocked_slots,b.stat_grp_desc long_desc, to_number(a.max_patients - (a.total_booked_patients)) final_slots from oa_clinic_schedule_dtl a,am_stat_group b where a.facility_id=? and a.clinic_code=? and to_char(a.clinic_date,'dd/mm/yyyy')=to_char(to_date(?,'dd/mm/yyyy'),'dd/mm/yyyy') and nvl(a.practitioner_id,'|')=nvl(?,'|') and a.alcn_catg_code=b.stat_grp_id(+) ORDER BY 2 DESC";
			}
			else if(alcncriteria.equals("BG"))
			{
				//sql = "select a.srl_no, a.alcn_criteria,a.alcn_catg_code,a.max_patients,a.total_booked_patients,a.total_blocked_slots,b.long_desc long_desc, to_number(a.max_patients - (a.total_booked_patients)) final_slots from oa_clinic_schedule_dtl a,bl_blng_grp b where a.facility_id='"+facilityid+"' and a.clinic_code='"+locncode+"' and to_char(a.clinic_date,'dd/mm/yyyy')=to_char(to_date('"+clinicdate+"','dd/mm/yyyy'),'dd/mm/yyyy') and nvl(a.practitioner_id,'|')=nvl('"+practitionerid+"','|') and a.alcn_catg_code=b.blng_grp_id(+) ORDER BY 2 DESC ";
				sql = "select a.srl_no, a.alcn_criteria,a.alcn_catg_code,a.max_patients,a.total_booked_patients,a.total_blocked_slots,b.long_desc long_desc, to_number(a.max_patients - (a.total_booked_patients)) final_slots from oa_clinic_schedule_dtl a,bl_blng_grp b where a.facility_id=? and a.clinic_code=? and to_char(a.clinic_date,'dd/mm/yyyy')=to_char(to_date(?,'dd/mm/yyyy'),'dd/mm/yyyy') and nvl(a.practitioner_id,'|')=nvl(?,'|') and a.alcn_catg_code=b.blng_grp_id(+) ORDER BY 2 DESC ";
			}
			else if(alcncriteria.equals("PC"))
			{
				//sql  = "select a.srl_no, a.alcn_criteria,a.alcn_catg_code,a.max_patients,a.total_booked_patients,a.total_blocked_slots,b.long_desc, to_number(a.max_patients - (a.total_booked_patients)) final_slots long_desc from oa_clinic_schedule_dtl a,mp_pat_category b where a.facility_id='"+facilityid+"' and a.clinic_code='"+locncode+"' and to_char(a.clinic_date,'dd/mm/yyyy')=to_char(to_date('"+clinicdate+"','dd/mm/yyyy'),'dd/mm/yyyy') and nvl(a.practitioner_id,'|')=nvl('"+practitionerid+"','|') and a.alcn_catg_code=b.pat_cat_code(+) ORDER BY 2 DESC ";
				sql  = "select a.srl_no, a.alcn_criteria,a.alcn_catg_code,a.max_patients,a.total_booked_patients,a.total_blocked_slots,b.long_desc, to_number(a.max_patients - (a.total_booked_patients)) final_slots long_desc from oa_clinic_schedule_dtl a,mp_pat_category b where a.facility_id=? and a.clinic_code=? and to_char(a.clinic_date,'dd/mm/yyyy')=to_char(to_date(?,'dd/mm/yyyy'),'dd/mm/yyyy') and nvl(a.practitioner_id,'|')=nvl(?,'|') and a.alcn_catg_code=b.pat_cat_code(+) ORDER BY 2 DESC ";
			}
			int max_percen=0;
	        int total_booked	= 0;
			int total_blocked	= 0;
			
				try
				{
					con=ConnectionManager.getConnection(request);
				if (allocation_changed.equals("N"))
				  {
					//stmt =  con.createStatement();
					//rs = stmt.executeQuery(sql);
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,facilityid);
					pstmt.setString(2,locncode);
					pstmt.setString(3,clinicdate);
					pstmt.setString(4,practitionerid);
					rs = pstmt.executeQuery();
					if(rs !=null)
					{
						while(rs.next())
						{
							if(i%2 == 0 )
								className = "QRYEVEN";
							else
								className = "QRYODD";
							if(rs.getInt("final_slots") == 0 )
								readOnly = "readonly";
							else
								readOnly = "";

							String code = rs.getString("alcn_catg_code")==null?"":rs.getString("alcn_catg_code");
							String desc = rs.getString("long_desc")==null?"":rs.getString("long_desc");
							if(code.equals("*O")) desc = "Others";
							String passvalue = rs.getInt("final_slots")+"`"+alcncriteria+"`"+code+"`"+"$"+"`"+incdec+"`"+rs.getInt("total_booked_patients")+"`"+rs.getInt("total_blocked_slots")+"`";

							out.println("<tr><td class="+className+">"+desc+"</td>");
							out.println("<td  class="+className+">"+rs.getInt("max_patients")+"</td>");
							out.println("<td  class="+className+">"+rs.getInt("total_booked_patients")+"</td>");
							out.println("<td  class="+className+"><input type=hidden name=block_slot"+i+" value='"+passvalue+"' >");
							out.println("<input type=text "+readOnly+" name='block_slot_text"+i+"' id='block_slot_text"+i+"' value=0  maxlength=3 size=3 onKeyPress='return  allowValidNumber(this,event,3,0);' onBlur=\"javascript:validateSlots(this,'"+i+"')\"></td>");
							out.println("</tr>");
							i++;
						}
					}
				}
				else
				{
						StringTokenizer indtoken = new StringTokenizer(final_string, "|");
						while (indtoken.hasMoreTokens())
						{
						String inner_string = indtoken.nextToken();
						StringTokenizer stoken = new StringTokenizer(inner_string,"~");
						while(stoken.hasMoreTokens())
						{						
						if (i% 2 == 0 ) className = "QRYEVEN" ;
						else className = "QRYODD" ;
						String pat_category_code	= stoken.nextToken();
						String pat_category_desc	= stoken.nextToken();
						String percentage			= stoken.nextToken();
						int chk_percen				= Integer.parseInt(percentage);
				        total_booked			    = Integer.parseInt(stoken.nextToken());
						total_blocked			    = Integer.parseInt(stoken.nextToken());
						String passvalue = percentage+"`"+alcncriteria+"`"+pat_category_code+"`"+"$"+"`"+incdec+"`"+total_booked+"`"+total_blocked+"`";

						max_percen +=chk_percen;
						if (chk_percen <=total_booked) readOnly = "readonly";
						else
							readOnly ="";
						out.println("<tr><td class="+className+">"+pat_category_desc+"</td>");
						out.println("<td  class="+className+">"+chk_percen+"</td>");
						out.println("<td  class="+className+">"+total_booked+"</td>");
						out.println("<td  class="+className+"><input type=hidden name=block_slot"+i+" value='"+passvalue+"' >");
						out.println("<input type=text "+readOnly+" name='block_slot_text"+i+"' id='block_slot_text"+i+"' value=0  maxlength=3 size=3 onKeyPress='return  allowValidNumber(this,event,3,0);' onBlur=\"javascript:validateSlots(this,'"+i+"')\"></td>");
						out.println("</tr>");						
						i++;				                
						}                        
						}
                    int others = 0;
				    others = Integer.parseInt(max_patients_per_day) - max_percen;
					if  (others>0)
					{
				//	sql  = "select total_booked_patients,total_blocked_slots from oa_clinic_schedule_dtl where facility_id='"+facilityid+"' and clinic_code='"+locncode+"' and to_char(clinic_date,'dd/mm/yyyy')=to_char(to_date('"+clinicdate+"','dd/mm/yyyy'),'dd/mm/yyyy') and nvl(practitioner_id,'|')=nvl('"+practitionerid+"','|') and alcn_catg_code = '*O'";		
					sql  = "select total_booked_patients,total_blocked_slots from oa_clinic_schedule_dtl where facility_id=? and clinic_code=? and to_char(clinic_date,'dd/mm/yyyy')=to_char(to_date(?,'dd/mm/yyyy'),'dd/mm/yyyy') and nvl(practitioner_id,'|')=nvl(?,'|') and alcn_catg_code = '*O'";		
					if (stmt!=null) stmt.close();
					if (pstmt!=null) pstmt.close();
					if (rs!=null) rs.close();
					//stmt =  con.createStatement();
					//rs = stmt.executeQuery(sql);
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,facilityid);
					pstmt.setString(2,locncode);
					pstmt.setString(3,clinicdate);
					pstmt.setString(4,practitionerid);
					rs = pstmt.executeQuery();
					if(rs !=null)
						{
						if (rs.next())
							{
						        total_booked			    = rs.getInt(1);
								total_blocked			    = rs.getInt(2);
							}
						 else
                            {
						        total_booked			    = 0;
								total_blocked			    = 0;
						 }
						}
						String passvalue = others+"`"+alcncriteria+"`"+"*O"+"`"+"$"+"`"+incdec+"`"+total_booked+"`"+total_blocked+"`";
						out.println("<tr><td class="+className+">"+"Others"+"</td>");
						out.println("<td  class="+className+">"+others+"</td>");
						out.println("<td  class="+className+">"+total_booked+"</td>");
						out.println("<td  class="+className+"><input type=hidden name=block_slot"+i+" value='"+passvalue+"' >");
						out.println("<input type=text "+readOnly+" name='block_slot_text"+i+"' id='block_slot_text"+i+"' value=0  maxlength=3 size=3 onBlur=\"javascript:validateSlots(this,'"+i+"')\"></td>");
						out.println("</tr>");					
						i++;				                
					}
				}
				}catch (Exception e){
					//out.println(e);
				e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
				}
				finally
				{
					if(stmt !=null) stmt.close();
					if(rs !=null) rs.close();
					ConnectionManager.returnConnection(con,request);
				}

		
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(incdec));
            _bw.write(_wl_block15Bytes, _wl_block15);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
