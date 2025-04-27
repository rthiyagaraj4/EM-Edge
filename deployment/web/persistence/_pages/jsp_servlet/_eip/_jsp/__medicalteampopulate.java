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
import java.sql.*;
import java.text.*;
import com.ehis.util.*;

public final class __medicalteampopulate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/MedicalTeamPopulate.jsp", 1733290305816L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<body class=message onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t<script>\n\t\t\t\t\tif(parent.f_query_add_mod.frames[2].document.AdmitPatient_form)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar obj = parent.f_query_add_mod.frames[2].document.AdmitPatient_form.team_id;\n\t\t\t\t\t\tvar length  = obj.length;\n\t\t\t\t\t\tfor(i=0;i<length;i++)\n\t\t\t\t\t\t\tobj.remove(1); \n\t\t\t\t\t\tvar team_opt = parent.f_query_add_mod.frames[2].document.createElement(\'OPTION\');\n\t\t\t\t\t\tteam_opt.text = \'--- \'+getLabel(\'Common.defaultSelect.label\',\'Common\')+\' ---\';\n\t\t\t\t\t\tteam_opt.value = \"\";\n\t\t\t\t\t\tparent.f_query_add_mod.frames[2].document.forms[0].team_id.add(team_opt);\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals(""))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals(""))) ? defaultValue : inputString);
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

	
	String locale		= (String)session.getAttribute("LOCALE");
	
	String facilityId	= (String)session.getValue("facility_id");
	String practid		= checkForNull(request.getParameter("ippractid"));
	String dateVal		= checkForNull(request.getParameter("dateVal"));
	String admDate		= checkForNull(request.getParameter("admDate"));
	String booking		= checkForNull(request.getParameter("booking"));
	String expdate		= checkForNull(request.getParameter("expdate"));
	String teamid		= checkForNull(request.getParameter("team_id"));
	String med_code		= checkForNull(request.getParameter("med_code"));
	String spy_code		= checkForNull(request.getParameter("spy_code"));

	StringBuffer selectsql	= new StringBuffer();
	Connection con	= null;
	PreparedStatement pstmt =null;
	ResultSet rs	= null;
	PreparedStatement pstmt1 =null;
	ResultSet rs1	= null;

		// below eight lines added by Venkatesh.S on 29/Sep/2011 for the incident GHL-SCF-453 [IN028804].
			String patient_class = checkForNull(request.getParameter("patient_class"));
    String discharge_date_only="";
try
	{	
	 
      //incident GHL-SCF-453 [IN028804] end.   
   
        request.setCharacterEncoding("UTF-8");
		con = ConnectionManager.getConnection(request);	
		out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
	// below eight lines added by Venkatesh.S on 29/Sep/2011 for the incident GHL-SCF-453 [IN028804].
		if(patient_class.equals("D")) //this block for DayCare patient.
		{
			StringTokenizer stringTokenizer = new StringTokenizer(admDate);
			while(stringTokenizer.hasMoreTokens()){
			discharge_date_only=stringTokenizer.nextToken();
			//String time_only=stringTokenizer.nextToken();
			}
			discharge_date_only=discharge_date_only+" 23:59";
			discharge_date_only = DateUtils.convertDate(discharge_date_only,"DMYHM","en",locale); 
			out.println("<script>parent.frames[2].document.forms[0].expecteddischargedate.value = '"+discharge_date_only+"';</script>");		
		}
	// incident GHL-SCF-453 [IN028804] end.  
	   
	   
	   if(patient_class.equals("I")) // This condition only added by Venkatesh.S(EmId-4008) for the                                           incident GHL-SCF-453 [IN028804].//this block for Inpatient                                            patient.
	   {

		if(expdate.equals("expdate"))
		{				
			if(!dateVal.equals(""))
			{	
				pstmt1 	= con.prepareStatement( "select to_char(to_date('"+admDate+"','dd/mm/rrrr hh24:mi')+'"+dateVal+"','dd/mm/rrrr hh24:mi') disdate from dual");
				rs1 = pstmt1.executeQuery();
				if(rs1.next())
				{
					String Expdate = rs1.getString("disdate");
					if(!(Expdate==null || Expdate.equals("")))
						Expdate = DateUtils.convertDate(Expdate,"DMYHM","en",locale); 
					out.println("<script>parent.frames[2].document.forms[0].expecteddischargedate.value = '"+Expdate+"';</script>");				
					if (rs1 != null) rs1.close();
					if (pstmt1 != null) pstmt1.close();
				}
			}
			else
			{
				out.println("<script>parent.document.frames[2].document.forms[0].expecteddischargedate.value = ''</script>");				
			}
		}}

		if (!(practid.equals("")))
		{
			selectsql.append(" select a.short_desc short_desc ,a.team_id, b.practitioner_id from 	AM_MEDICAL_TEAM_LANG_VW a, AM_PRACT_FOR_TEAM b where a.language_id = '"+locale+"' and a.facility_id ='"+facilityId+"' and a.facility_id = b.facility_id and b.practitioner_id ='"+practid+"' and a.speciality_code = '"+spy_code+"' and b.team_id=a.team_id and a.appl_for_ip_yn = 'Y' order by 1 ");
		}
		else if (practid.equals(""))
		{
			selectsql.append(" select distinct a.short_desc short_desc, a.team_id from AM_MEDICAL_TEAM_LANG_VW a, AM_PRACT_FOR_TEAM b where a.language_id = '"+locale+"' and a.facility_id ='"+facilityId+"' and a.facility_id = b.facility_id and a.speciality_code = '"+spy_code+"' and b.team_id=a.team_id and a.appl_for_ip_yn = 'Y' order by 1 ");
		}
		
		
		pstmt 	= con.prepareStatement(selectsql.toString());
		rs = pstmt.executeQuery() ;
		String str1 = "";
		String str2 = "";
		if( rs != null ) 
		{
			// This condition added by Nanda - 01/10/2002 
			if(booking.equals("AssignBed"))
			{
				int i=0; 
				while(rs.next()) 
				{
					str1 = rs.getString( "team_id" ) ;
					str2 = rs.getString( "short_desc" );
					i++;
					if(i==1)
					{
						if(med_code.equals("tfr_out"))
						{
							out.println(	"<script> var element = parent.frames[2].document.createElement('OPTION');"+
							"element.text = \""+str2+"\";"+ 
							"element.value= \""+str1+"\";"+
							"element.selected='true';"+
							"parent.frames[2].document.forms[0].team_id.add(element);</script>");
						}
						else
						{
							out.println(	"<script> var element = parent.frames[1].document.createElement('OPTION');"+
							"element.text = \""+str2+"\";"+ 
							"element.value= \""+str1+"\";"+
							"element.selected='true';"+
							"parent.frames[1].document.forms[0].team_id.add(element);</script>");		
						}
					}
					else
					{
						if(med_code.equals("tfr_out"))
						{
							out.println(	"<script> var element = parent.frames[2].document.createElement('OPTION');"+
							"element.text = \""+str2+"\";"+ 
							"element.value= \""+str1+"\";"+
							"parent.frames[2].document.forms[0].team_id.selectedIndex=0;"+
							"parent.frames[2].document.forms[0].team_id.add(element);</script>");
						}
						else
						{
							out.println(	"<script> var element = parent.frames[1].document.createElement('OPTION');"+
							"element.text = \""+str2+"\";"+ 
							"element.value= \""+str1+"\";"+
							"parent.frames[1].document.forms[0].team_id.selectedIndex=0;"+
							"parent.frames[1].document.forms[0].team_id.add(element);</script>");
						}
					}
				}		
			}

			if(booking.equals("booking"))
			{
				int i=0; 
				while( rs.next() ) 
				{
					str1 = rs.getString( "team_id" ) ;
					str2 = rs.getString( "short_desc" );
					i++;
					if(i==1)
					{
						out.println(	"<script> var element = 	parent.frames[1].document.createElement('OPTION');"+
						"element.text = \""+str2+"\";"+ 
						"element.value= \""+str1+"\";"+
						"element.selected=true ;"+
						"parent.frames[1].document.forms[0].team_id.add(element);</script>");				 
					}
					else
					{
						out.println(	"<script> var element = parent.frames[1].document.createElement('OPTION');"+
						"element.text = \""+str2+"\";"+ 
						"element.value= \""+str1+"\";"+
						"parent.frames[1].document.forms[0].team_id.selectedIndex=0;"+
						"parent.frames[1].document.forms[0].team_id.add(element);</script>");				 
					}
				}		
			}
			
			if(booking.equals("transfer"))
			{
				while( rs.next() ) 
				{
					str1 = rs.getString( "team_id" ) ;
					str2 = rs.getString( "short_desc" );
					out.println(	"<script> var element = parent.frames[1].document.createElement('OPTION');"+
					"element.text = \""+str2+"\";"+ 
					"element.value= \""+str1+"\";"+
					"parent.frames[1].document.forms[0].team_id.add(element);</script>");				 
				}		     
			}

			if(booking.equals("admit"))
			{
			
            _bw.write(_wl_block7Bytes, _wl_block7);

				int i=0;
				while( rs.next() ) 
				{
					str1 = rs.getString( "team_id" ) ;
					str2 = rs.getString( "short_desc" );
					i++;
					
					out.println(	"<script> var element = parent.f_query_add_mod.document.frames[2].document.createElement('OPTION');"+
					"element.text = \""+str2+"\";"+ 
					"element.value= \""+str1+"\";"+
					"element.selected=true;"+
					"parent.f_query_add_mod.document.frames[2].document.forms[0].team_id.add(element);</script>");
				}
				
				if(!teamid.equals("") && i > 0)
				{
				out.println("<script>parent.f_query_add_mod.document.frames[2].document.forms[0].team_id.value=\""+teamid+"\";</script>");
				}
			}
		}

		out.println("</script><script>let iframe = top.content; let lastFrame = iframe.frames[iframe.frames.length - 1].location.href = '../../eCommon/jsp/error.jsp?err_num=';</script></head><body onMouseDown='CodeArrest()' onKeyDown='lockKey()' CLASS='MESSAGE'></body></html>");

		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();

	}catch(Exception e)
	{
		out.println("Exception in MedicalTeamPopulate.jsp : "+ e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);	
	}

            _bw.write(_wl_block8Bytes, _wl_block8);
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
