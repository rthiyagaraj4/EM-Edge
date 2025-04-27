package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __reponline extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/repOnline.jsp", 1723991205407L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\">\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<Script language=\'javascript\' src=\'../../eCommon/js/common.js\'></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n\t<script>\n\t\tfunction query()\n\t\t{\n\t\t\tframes[1].location.href=\'../../eMP/jsp/blank.jsp?step_1=4&module_id=MP\';\n\t\t}\n\t</script>\n</head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="<!--Modified by Thamizh selvi on 3rd Jan 2019 against ML-MMOH-CRF-1245-->\n\t\t\t\t\t<script>\n\t\t\t\t\t\talert(getMessage(\"REPRINT_STILL_BORN_BABY\",\"MP\"));\t\t\t\n\t\t\t\t\t\tparent.frames[1].location.href=\'../../eMP/jsp/blank.jsp?step_1=4&module_id=MP\';\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</html>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);




	if(request.getParameter("step").equals("1") )
	{	
		out.println("<html><head>");
		String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
		out.println("</head><iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='"+source+"' frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe><iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eMP/jsp/blank.jsp?step_1=4' frameborder=0 scrolling='auto' style='height:83vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe></html>");
	}
	else if(request.getParameter("step").equals("2"))
	{
		String patient_id	=  request.getParameter("patient_ID");
		String module_id	= request.getParameter("module_id");
		String facility_id	= (String)session.getValue("facility_id");

		String pat_ser_grp_code		= "";
		String inhouse_birth_yn		= "";
		String deceased_yn		= "";
		String maintain_doc_or_file = "";
		String file_no				= "";
		String sqlString			= "";
		Boolean isStillBornRepReprintAppl = false;//Added by Thamizh selvi on 3rd Jan 2019 against ML-MMOH-CRF-1245
		
		Connection con			= null;
		java.sql.Statement stmt	= null;
		ResultSet rset			= null;
	
		try
		{
			con		= ConnectionManager.getConnection(request);

			isStillBornRepReprintAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","STILL_BORN_REPORTS_REPRINT");//Added by Thamizh selvi on 3rd Jan 2019 against ML-MMOH-CRF-1245

			stmt	= con.createStatement();
			rset	= stmt.executeQuery("SELECT pat_ser_grp_code, INHOUSE_BIRTH_YN, deceased_yn FROM MP_PATIENT where patient_id = '"+patient_id+"'") ;
			
			if (rset.next())
			{
				pat_ser_grp_code = rset.getString(1);
				inhouse_birth_yn = rset.getString(2);
				deceased_yn = rset.getString(3);
			}
			if(rset!=null) rset.close();
			if(stmt!=null) stmt.close();

			stmt	= con.createStatement();
			rset	= stmt.executeQuery("SELECT maintain_doc_or_file FROM mp_param where module_id='MP'") ;
			if(rset.next())
			{
				maintain_doc_or_file = rset.getString(1);
				if(maintain_doc_or_file == null || maintain_doc_or_file.equals("null")) 
					maintain_doc_or_file = "F";
			}
			if(rset!=null) rset.close();
			if(stmt!=null) stmt.close();

			if(maintain_doc_or_file.equals("D"))
			{
				file_no = "";
			}
			else
			{
				stmt = con.createStatement();
				rset = stmt.executeQuery("SELECT file_no FROM mr_pat_file_index WHERE patient_id = '"+patient_id+"' AND facility_id = '"+facility_id+"'") ;
		
				if(rset.next())
				{
				   file_no = rset.getString(1);
					if(file_no == null || file_no.equals("null")) file_no = "";
				}
			}
			
			if(inhouse_birth_yn.equals("N"))
			{  /* in below line  this report MPBNBWBL id added by venkatesh.S on 11/12/2012 against 36610 */
				sqlString = "SELECT distinct A.report_id,B.report_desc, 1 no_of_copies, b.module_id FROM mp_online_reports A, sm_report_lang_vw B, sm_print_routing c WHERE a.pat_ser_grp_code = '"+pat_ser_grp_code+"' and B.report_id=A.report_id AND a.report_id = c.report_id (+) and NVL(c.facility_id,'"+facility_id+"')='"+facility_id+"' and A.report_id in ('MPBWBLBL', 'MPBFRNST', 'MPBIDLBL','MPBSTLBL','MPBPTLBL','MPBPTLBL'";

				if(deceased_yn.equals("Y"))
					sqlString = sqlString + " ,'MPDTHCER'";
				if(!file_no.equals(""))
					sqlString = sqlString + " ,'MPBFLLBL'";

				sqlString = sqlString + " ,'MPBIDLBG') and b.language_id = '"+localeName+"' order by 2"; 


				
			}else{	 /* in below line this report MPBNBWBL id added by venkatesh.S on 11/12/2012 against 36610.1 */
				sqlString = "select distinct A.report_id,B.report_desc, 1 no_of_copies, b.module_id from mp_online_reports A, sm_report_lang_vw B, sm_print_routing c where a.pat_ser_grp_code = '"+pat_ser_grp_code+"' and B.report_id=A.report_id and a.report_id = c.report_id (+) and NVL(c.facility_id,'"+facility_id+"')='"+facility_id+"' and A.report_id in ('MPBNBFRM', 'MPBWBLBL','MPBFRNST', 'MPBIDLBL','MPBSTLBL','MPBNBWBL','MPBPTLBL'";//Birth Certifiacte is reomved from internal reports based on PMG CRF--689 & 695
				//sqlString = "select distinct A.report_id,B.report_desc, 1 no_of_copies, b.module_id from mp_online_reports A, sm_report_lang_vw B, sm_print_routing c where a.pat_ser_grp_code = '"+pat_ser_grp_code+"' and B.report_id=A.report_id and a.report_id = c.report_id (+) and NVL(c.facility_id,'"+facility_id+"')='"+facility_id+"' and A.report_id in ('MPBNBFRM', 'MPBWBLBL','MPBFRNST', 'MPBIDLBL','MPBIRCER'";
				//sqlString = "select distinct A.report_id,B.report_desc, 1 no_of_copies, b.module_id from mp_online_reports A, sm_report_lang_vw B, sm_print_routing c where a.pat_ser_grp_code = '"+pat_ser_grp_code+"' and B.report_id=A.report_id and a.report_id = c.report_id (+) and NVL(c.facility_id,'"+facility_id+"')='"+facility_id+"' and A.report_id in ('MPBFLLBL','MPBFRNST','MPBIDLBG','MPBIDLBL','MPBWBLBL') and b.language_id = '"+localeName+"' order by 2";//changed for PMG CRF-695

				String nbSQL="select outcome from mp_birth_register where patient_id='"+patient_id+"'";
				stmt	= con.createStatement();
				rset	= stmt.executeQuery(nbSQL);
				String outCome="";
				if(rset!=null && rset.next()){
					outCome=rset.getString("outcome");
				}
				if(outCome=="" || outCome==null || outCome=="null")
					outCome="";
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
				if(deceased_yn.equals("Y"))
					sqlString = sqlString + " ,'MPDTHCER'";
				if(!file_no.equals(""))
					sqlString = sqlString + " ,'MPBFLLBL'";
				sqlString = sqlString + " ,'MPBIDLBG') and b.language_id = '"+localeName+"' order by 2";
				String CUSTOMER_ID=(String)session.getAttribute("CUSTOMER_ID");
				if(outCome.equals("S") && !CUSTOMER_ID.equals("SRR") && !isStillBornRepReprintAppl){
            _bw.write(_wl_block7Bytes, _wl_block7);
}
			}
			String reportParamNames		= "p_patient_id,p_file_no";
			String reportParamValues	= ""+patient_id+","+file_no+"";
			StringBuffer htmlFor = null;
			htmlFor = new StringBuffer();

			htmlFor.append(" <html><head> <link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
			htmlFor.append(" </head><body class='message' onKeyDown='lockKey()'>");
			htmlFor.append(" <script language = 'JavaScript'>");
			htmlFor.append(" var dialogHeight = '450px' ;");
			htmlFor.append(" var dialogWidth = '700px' ;");
			htmlFor.append(" var dialogTop = '65' ;");
			htmlFor.append(" var arguments = ''; ");
			//modified the below line by Abirami - Bru-HIMS-CRF-313 / Passing function id in the Query String.
			htmlFor.append(" var getUrl =  '../../eCommon/jsp/InternalReportsPrint.jsp?P_function_id=ONLINE_REPORT&step=1&sqlString="+java.net.URLEncoder.encode(sqlString)+"&Patient_ID="+patient_id+"&reportParamNames="+reportParamNames+"&reportParamValues="+reportParamValues+"';");
			htmlFor.append(" var features = 'dialogTop:'+ dialogTop +'; dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +'; status=no;' ;");
			htmlFor.append(" retVal = window.showModalDialog(getUrl,arguments,features); ");
			htmlFor.append(" </script>");
			
			out.println(htmlFor.toString());
		
			if(htmlFor != null && htmlFor.length() > 0)
			{
				htmlFor.delete(0,htmlFor.length());
			}
			 //out.println("<script>window.location.href='../../eMP/jsp/blank.jsp?step_1=4&module_id="+module_id+"';</script></body></html>");

			if (rset != null) rset.close();
			if (stmt != null) stmt.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			out.println("Error here");
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
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
