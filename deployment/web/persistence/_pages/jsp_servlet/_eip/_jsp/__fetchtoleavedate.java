package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;

public final class __fetchtoleavedate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/FetchToLeaveDate.jsp", 1742378956974L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n<script language=\"JavaScript\">\n\tasync function showPseudoBed(nursingunit)\n\t{\n\t\tvar features\t= \"dialogHeight:18.5; dialogWidth:40; dialogTop:185;scroll=auto; status:no;\"\n\t\tvar arguments = \"\";\n\t\tvar retVal = await parent.window.showModalDialog(\"../../eIP/jsp/PseudoBedAvailabilityChart.jsp?nursing_unit_code=\"+nursingunit,arguments,features);\n\t\tif(retVal != null && retVal != \'F\')\n\t\t{\n\t\t\tparent.frames[1].document.getElementById(\'pseudo_bed\').value = retVal;\n\t\t}\n\t\telse \n\t\t{\n\t\t\tparent.frames[1].document.getElementById(\'pseudo_bed\').value=\"\";\n\t\t\tparent.frames[1].document.getElementById(\'release_bed\').value=\"N\";\n\t\t\tparent.frames[1].document.getElementById(\'release_bed\').checked=false;\n\t\t}\n\t}\n\n\tfunction showCreatePseudobed(nursingunit,nursingunitdesc)\n\t{\n\t\tparent.frames[1].document.getElementById(\'pseudo_bed\').readOnly = true;\n\t\tparent.frames[1].document.getElementById(\'generate_pseudo_bed\').value = \'Y\';\n\t}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t\t\t<script>\n\t\t\t\tparent.frames[1].document.getElementById(\'to_date1\').innerText = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n\t\t\t\tparent.frames[1].document.forms[0].to_date.value = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n\n\t\t\t\tif (!";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" && !parent.frames[1].document.forms[0].leaveperiod.readOnly)\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"INVALID_LEAVE_REVISE\",\"IP\"));\n\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\t\t<script>\n\t\tvar obj= parent.frames[1].document.forms[0];\n\t\tobj.Bedcode.value = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\t\tobj.bed_cls_code.value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\tobj.bed_type_code.value = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\tobj.bed_typ_code.value = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<script>\n\t\talert(getMessage(\'INVALID_BED\',\'IP\'));\n\t\tvar obj= parent.frames[1].document.forms[0];\n\t\tobj.bed_cls_code.value = \'\';\n\t\tobj.bed_type_code.value = \'\';\n\t\tobj.room_no.value = \'\';\n\t\tobj.disp_room_no.value = \'\';\n\t\tif(obj.bed_chart.disabled == false)\n\t\tobj.bed_chart.focus();\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<script>\n\t\talert(getMessage(\'NON_OVERRIDEABLE_BKG\',\'IP\'));\n\t\tvar obj= parent.frames[1].document.forms[0]\n\t\tobj.bed_no.disabled=false;\n\t\tobj.bed_chart.disabled=false;\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<script>\n\t\talert(getMessage(\'INVALID_BED\',\'IP\'));\n\t\tvar obj= parent.frames[1].document.forms[0];\n\t\tobj.bed_cls_code.value = \'\';\n\t\tobj.bed_type_code.value = \'\';\n\t\tobj.room_no.value = \'\';\n\t\tobj.disp_room_no.value = \'\';\n\t\tif(obj.bed_chart.disabled == false)\n\t\tobj.bed_chart.focus();\n\t\t\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<script>\n\t\talert(getMessage(\'OCCUPIED_BED\',\'IP\'));\n\t\tvar obj= parent.frames[1].document.forms[0]\n\t\tobj.bed_no.disabled=false;\n\t\tobj.bed_no.readOnly=false;\n\t\tobj.bed_chart.disabled=false;\n\t\tobj.Bedcode.disabled=false;\n\t\tobj.bed_type_code.disabled=false;\n\t\tobj.bed_chart.disabled=false;\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n</html>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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

   Connection con = null;
   Statement stmt =  null;
   ResultSet rs=null;
   String facilityid  = "";
   String currdate    = "";
   int 	  leaveperiod = 0;
   String leaveind    = "";
   int    maxleave    = 0;
   
	try
	{
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		

		con  = ConnectionManager.getConnection(request);
		stmt = con.createStatement();	 
		String to_date   = "";	
		currdate    = request.getParameter("currdate");
		leaveperiod = Integer.parseInt((request.getParameter("leaveperiod")==null?"0":request.getParameter("leaveperiod")));
		leaveind    = request.getParameter("leaveind");   
		maxleave = Integer.parseInt((request.getParameter("maxleave")==null?"0":request.getParameter("maxleave")));
		facilityid  = (String)session.getValue("facility_id");
		String operation = request.getParameter("operation") ;

		if(operation == null)
		{
			try
			{
				String LeaveSql = "SELECT  to_char((to_date('"+currdate+"','dd/mm/rrrr hh24:mi')+'"+leaveperiod+"'/decode('"+leaveind+"','D',1,24)),'dd/mm/rrrr hh24:mi') to_date, to_date('"+currdate+"','dd/mm/rrrr hh24:mi')+'"+leaveperiod+"'/decode('"+leaveind+"','D',1,24) act_dt  from dual";

				boolean chk = true ;
				stmt=con.createStatement();
				rs = stmt.executeQuery(LeaveSql);    
				rs.next();

				to_date = rs.getString("to_date");	
				Timestamp ts = rs.getTimestamp("act_dt") ;

				Timestamp currdate1 = new Timestamp(System.currentTimeMillis());
				out.println(ts+"\n"+currdate1+"\n"+ts.before(currdate1) +"\n");
				if(to_date == null ) to_date = "";		
				else if(ts.before(currdate1))
				chk=false;

				
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(to_date));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(to_date));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block5Bytes, _wl_block5);

				//Valid Leave Check
				if(leaveind.equals("D"))
				{     
					if ((maxleave / 24) < leaveperiod) 
					{
						out.println("<script>alert(getMessage('LEAVE_LT_DAYS_XCEED','IP'));</script>");
						out.println("<script>parent.frames[1].document.forms[0].leaveperiod.focus();</script>");
					} 
				}	
				else
				{
					if (maxleave < leaveperiod) 
					{
					out.println("<script>alert(getMessage('LEAVE_LT_HRS_XCEED','IP'));</script>");	 
					out.println("<script>parent.frames[1].document.forms[0].leaveperiod.select();</script>");
					} 
				}
				if (stmt!=null) stmt.close();
				if (rs!=null) rs.close();
			}catch(Exception e){out.println("error " + e);}
			finally
			{
				if (stmt!=null) stmt.close();
				if (rs!=null) rs.close();
			}
		}
		else if(operation.equals("pseudo_bed"))
		{
			String nursing_unit	 = request.getParameter("nursing_unit_code");
			String sql = " Select allow_pseudo_bed_yn, generate_pseudo_bed_srl_yn, nursing_unit_short_desc from IP_NURSING_UNIT_LANG_VW where language_id='"+locale+"' and Nursing_Unit_Code= '"+nursing_unit+"' and facility_id = '"+facilityid+"'";
			String genpseudobedno="";
			try
			{
				stmt = con.createStatement();
				Statement stmt2 = con.createStatement();
				rs	= stmt.executeQuery(sql);
				if(rs.next())
				{
				String allow_pseudo_bed_yn = rs.getString("Allow_Pseudo_Bed_YN")==null?"N":rs.getString("Allow_Pseudo_Bed_YN");
				String nursingunitdesc = rs.getString("NURSING_UNIT_SHORT_DESC");
				if(allow_pseudo_bed_yn.equals("N"))
				{
					out.println("<script>parent.frames[1].document.getElementById('release_bed').disabled=true;alert(getMessage('NU_PSEUDO_BED_NOT_ALLOWED','IP'));parent.frames[1].document.getElementById('release_bed').checked=false;parent.frames[1].document.getElementById('release_bed').value='N'</script>");
				}
				else
				{
					if(rs.getString("Generate_Pseudo_Bed_Srl_YN").equals("Y"))
					{
						String selectnosql = " SELECT PREFIX_FOR_PSEUDO_BED_SRL_NO,NVL(NEXT_PSEUDO_BED_SRL,0) NEXT_PSEUDO_BED_SRL ,NVL(MAX_PSEUDO_BED_SRL,0) MAX_PSEUDO_BED_SRL FROM IP_NURSING_UNIT WHERE NURSING_UNIT_CODE = '"+nursing_unit+"' and facility_id='"+facilityid+"' " ;
						if(stmt2 != null) stmt2.close();
						stmt2 = con.createStatement();
						ResultSet rset = stmt2.executeQuery(selectnosql);
						if(rset.next())
						{
							if(rset.getInt("NEXT_PSEUDO_BED_SRL") > rset.getInt("MAX_PSEUDO_BED_SRL"))
							{
								out.println("<script>alert(getMessage('MAX_BED_NUM_REACHED','IP'));</script>");
							}
							else
							{
								String PREFIX_FOR_PSEUDO_BED_SRL_NO = rset.getString("PREFIX_FOR_PSEUDO_BED_SRL_NO");
								String NEXT_PSEUDO_BED_SRL = rset.getString("NEXT_PSEUDO_BED_SRL");

								if(PREFIX_FOR_PSEUDO_BED_SRL_NO == null || PREFIX_FOR_PSEUDO_BED_SRL_NO.equals("null"))PREFIX_FOR_PSEUDO_BED_SRL_NO="";
								if(NEXT_PSEUDO_BED_SRL == null || NEXT_PSEUDO_BED_SRL.equals("null"))NEXT_PSEUDO_BED_SRL="";

								if(!PREFIX_FOR_PSEUDO_BED_SRL_NO.equals(""))
								{
									genpseudobedno = PREFIX_FOR_PSEUDO_BED_SRL_NO+NEXT_PSEUDO_BED_SRL;
									out.println("<script>parent.frames[1].document.getElementById('pseudo_bed').value=\""+genpseudobedno+"\"</script>");
								}
								else
								{
									genpseudobedno = NEXT_PSEUDO_BED_SRL;
								out.println("<script>parent.frames[1].document.getElementById('pseudo_bed').value=\""+genpseudobedno+"\"</script>");
								}
							}
						}	
						if(rset != null) rset.close();
						if(stmt2 != null) stmt2.close();
						out.println("<script>showCreatePseudobed('"+nursing_unit+"','"+nursingunitdesc+"')</script>");
					}
					else
					{
					out.println("<script>showPseudoBed('"+nursing_unit+"')</script>");
					}
				}
			}
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			}
			catch(Exception e)
			{
				out.println(e.toString());
			}
			finally
			{
				if(stmt!=null)	stmt.close();
				if(rs!=null)	rs.close();			
			}
		}
		else
		{
		String occupaid_pat_id="";
		String override_yn="";
		String patient_id_value="";
		String nursing_unit	 = request.getParameter("nursing_unit_code");
		String bed_no			 = request.getParameter("bed_no");
		String patient_id=request.getParameter("patient_id");
		String sql = "select room_no, IP_GET_DESC.IP_BED_CLASS(bed_class_code,'"+locale+"','1') bed_class_long_desc, bed_class_code,bed_type_code, OCCUPYING_PATIENT_ID from ip_nursing_unit_bed where nursing_unit_code='"+nursing_unit+"' and bed_no='"+bed_no+"' and facility_id='"+facilityid+"'";
		try
		{
		stmt = con.createStatement();
		rs	= stmt.executeQuery(sql);
		if(rs!=null)
		{
		if(rs.next())
		{
		String room_no= rs.getString(1);
		String bed_class = rs.getString(2);
		String bed_class_code=rs.getString(3);
		String bed_type_code=rs.getString(4);
		occupaid_pat_id=rs.getString("OCCUPYING_PATIENT_ID");
		if(room_no==null) room_no="";
		if(bed_class==null) bed_class="";
		if(bed_class_code==null) bed_class_code="";
		if(rs!=null)	rs.close();
		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(bed_class_code));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(bed_class_code));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(bed_type_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(bed_type_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
	}
		else
		{	
            _bw.write(_wl_block11Bytes, _wl_block11);

		}
		}
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
		if(occupaid_pat_id.equals(patient_id))
		{
		stmt=con.createStatement();
		sql = " SELECT OVERRIDE_YN,PATIENT_ID FROM IP_BED_BOOKING WHERE BOOKING_TYPE = 'B' AND OVERRIDE_YN = 'N' and REQ_NURSING_UNIT_CODE='"+nursing_unit+"' and REQ_BED_NO='"+bed_no+"' and facility_id='"+facilityid+"'";
		rs	= stmt.executeQuery(sql);
		if(rs!=null && rs.next())
		{
		override_yn=rs.getString("OVERRIDE_YN");
		patient_id_value=rs.getString("PATIENT_ID");
		}
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
		if(override_yn.equals("N"))
		{
		if(patient_id.equals(patient_id_value))
		{
            _bw.write(_wl_block12Bytes, _wl_block12);
}
            _bw.write(_wl_block13Bytes, _wl_block13);
}
		else
		{
		stmt=con.createStatement();
		sql = " SELECT 1 FROM IP_BED_BOOKING WHERE BOOKING_TYPE = 'B' AND OVERRIDE_YN = 'N' and REQ_NURSING_UNIT_CODE='"+nursing_unit+"' and REQ_BED_NO='"+bed_no+"' and facility_id='"+facilityid+"'";
		rs	= stmt.executeQuery(sql);
		if(rs!=null && rs.next())
		{
		
            _bw.write(_wl_block14Bytes, _wl_block14);

		}
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();

		}
		}
		else
		{
            _bw.write(_wl_block15Bytes, _wl_block15);
}


		}
		catch(Exception e)
		{
		out.println(e.toString());
		}
		finally
		{
		if(stmt!=null)	stmt.close();
		if(rs!=null)	rs.close();			
		}
		}
	}catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());}
   finally
   {
   	ConnectionManager.returnConnection(con,request);
   }	

            _bw.write(_wl_block16Bytes, _wl_block16);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
