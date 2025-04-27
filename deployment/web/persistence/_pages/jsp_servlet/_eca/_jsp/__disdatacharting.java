package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __disdatacharting extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/DisDataCharting.jsp", 1739188140513L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></SCRIPT>\n\t<script src=\'../../eCA/js/DisDataCharting.js\' language=\'javascript\'></SCRIPT>\n\t\t\t\n\t<script language=\'javascript\'>\n\t\tfunction onSuccess(){}\n\n\t</script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<title>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</title></head>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\n\t\t<script>\n\t\t\talert(getMessage(\"CA_DIAG_PROCEDURE\",\"CA\"));\n\t\t\t//window.close();\n\t\t\tparent.document.getElementById(\'dialog_tag\').close();\n\t\t\tproceed = false;\n\t\t</script> \n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t <iframe name=\"titleFrame\" src=\'../../eCA/jsp/DisDataChartingTitle.jsp?";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' frameborder=\"1\" scrolling=\"no\" noresize style=\"height:";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="; width:98vw;\"></iframe>\n\t\t\t\t <iframe name=\"addModifyFrame\" src=\'../../eCA/jsp/DisDataChartingRecord.jsp?";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' frameborder=\"0\" scrolling=\"auto\" noresize style=\"height:";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="; width:98vw;\"></iframe>\n\t\t\t\t <iframe name=\"toolsFrame\" src=\'../../eCA/jsp/DisDataChartingTools.jsp?";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' frameborder=\"0\" scrolling=\"no\" noresize style=\"height:";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="; width:98vw;\"></iframe>\n\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n<!-- \t\t\t\t\t<frame name =\'messageFrame\' border=\"0\"  marginwidth=0 marginheight=0 frameborder=NO scrolling=NO src=\'../../eCommon/jsp/error.jsp\'  noresize > </frame>\n -->\n \t\t\t\t        <iframe name=\"messageFrame\" src=\'../../eCommon/jsp/error.jsp\' frameborder=\"0\" scrolling=\"no\" noresize style=\"height:";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="; width:98vw;\"></iframe>\n \t\t\t\t\n ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t    <iframe name=\"titleFrame\" src=\'../../eCA/jsp/DisDataChartingTitle.jsp?";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="; width:98vw;\"></iframe>\n\t\t\t\t\t\t    <iframe name=\"addModifyFrame\" src=\'../../eCommon/html/blank.html?";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="; width:98vw;\"></iframe>\n\t\t\t\t\t\t    <iframe name=\"toolsFrame\" src=\'../../eCA/jsp/DisDataChartingTools.jsp?";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="; width:98vw;\"></iframe>\n\t\t\t\t\t\t\t\n\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n<!-- \t\t\t\t\t<frame name =\'messageFrame\' border=\"0\"  marginwidth=0 marginheight=0 frameborder=1 scrolling=NO src=\'../../eCommon/jsp/error.jsp\'  noresize > </frame>\n -->\n \t\t\t\t        <iframe name=\"messageFrame\" src=\'../../eCommon/jsp/error.jsp\' frameborder=\"0\" scrolling=\"no\" noresize style=\"height:";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t      //  </frameset>\n\t\t\t\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n</html>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

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
10/12/2012		IN036447		ChowminyaG		 Multiple Reference Range of integer numeric discrete measure do not display in Vital sign battery 
14/02/2013		IN036756		ChowminyaG		 Record Vital Signs->Defined Discrete Measure Components are not displayed 
18/06/2018		IN070732		Ramesh Goli		 SKR-SCF-1232
-------------------------------------------------------------------------------------------------------------------------------------
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String strTitle = "";
	String called_from = request.getParameter("called_from");
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");

	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

    Connection con =null;
    
	try
	{
		con = ConnectionManager.getConnection(request);
		PreparedStatement pstmt=null;
		ResultSet rset=null ;
    
		PreparedStatement pstmtCheck = null;
		String past_visit   = "";
		String patientline  = "";
		String dob		    = "";	//--[IN036447]
		String sex		    = "";			
		String qs = request.getQueryString();

		String qs1 = qs;
		String facilityid = (String) session.getValue("facility_id");
		String pat_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
		String episodeid = request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
		String visitid = request.getParameter("visit_id")==null?"":request.getParameter("visit_id");
		String Patient_Id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String amendMode = request.getParameter("amendMode")==null?"":request.getParameter("amendMode");
		String replaceMode=request.getParameter("replaceMode") == null?"":request.getParameter("replaceMode");

		String amerepMode=request.getParameter("amerepMode")==null?"N":request.getParameter("amerepMode");
		String module_id = request.getParameter("module_id")==null?"":request.getParameter("module_id");
		if(visitid.equals("")) visitid="";
		
		//[IN036447] - Start //IN036756
			String strSqlPat = "Select sex, to_char(date_of_birth,'dd/mm/yyyy') date_of_birth from Pr_encounter a, Mp_patient b where a.ENCOUNTER_ID=? and facility_id=? and A.PATIENT_ID = b.PATIENT_ID";
			pstmt = con.prepareStatement(strSqlPat);
			
			pstmt.setString	(	1,	episodeid);
			pstmt.setString	(	2,	facilityid	);
			rset = pstmt.executeQuery();

			if(rset.next())
			{
				sex = rset.getString("sex");
				dob = rset.getString("date_of_birth");
			}
			if(rset != null) rset.close();
			if(pstmt != null) pstmt.close();
			//[IN036447] - End //IN036756
		
		if(called_from == null || called_from.equals("") )
			strTitle = " Vital Signs";
		else
		{
			String strSqlPatienLine = "select get_patient.get_line_detail(?,?,?) patient_line from dual";
			pstmt = con.prepareStatement(strSqlPatienLine);
			
			pstmt.setString	(	1,	facilityid	);
			pstmt.setString	(	2,	episodeid);
			pstmt.setString	(	3,	locale);

			rset = pstmt.executeQuery();

			if(rset.next())
				patientline = rset.getString("patient_line");

			if(rset != null) rset.close();
			if(pstmt != null) pstmt.close();

			strTitle = patientline;
		}

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(strTitle));
            _bw.write(_wl_block9Bytes, _wl_block9);

		String retvalue = "";
		String lastrecorddate = "";
		boolean proceed = false;
		boolean func_appl_yn = true;
		    
		pstmtCheck = con.prepareStatement(" select ca_get_func_appl_past_visit(?,?,?,?,?) from dual");
		pstmtCheck.clearParameters();
		pstmtCheck.setString(1,facilityid);                // facid
		pstmtCheck.setString(2,"VITAL_SIGNS");              // p_function
		pstmtCheck.setString(3,episodeid);        // p_episode_id
		pstmtCheck.setString(4,pat_class);         // p_episode_type
		pstmtCheck.setString(5,Patient_Id);      // p_patient_id    
           
		rset = pstmtCheck.executeQuery();

		while(rset!=null && rset.next())
		{
			past_visit = rset.getString(1);
		}

		if(rset!=null) rset.close();
		if(pstmtCheck!=null) pstmtCheck.close();

        if(past_visit!=null && past_visit.equalsIgnoreCase("FALSE")) 
		{
			func_appl_yn = false;

            _bw.write(_wl_block10Bytes, _wl_block10);
   
		}   

		if(func_appl_yn)
		{      
			String sqlstr="select CA_GET_BATTERY_ID(?,?,?) from dual";

			pstmt=con.prepareStatement(sqlstr);
			pstmt.setString(1,facilityid);
			pstmt.setString(2,pat_class);
			pstmt.setString(3,episodeid);
			rset=pstmt.executeQuery();

			if(rset != null && rset.next())
			{
                retvalue = rset.getString(1)==null?"**":rset.getString(1);
				retvalue=retvalue.trim();  //retvalue trimed trim() by Arvind for ICN 18983 - REopen
                if(retvalue.indexOf("**") >=0)
                    out.println("<script>alert(getMessage('NO_VITAL_SIGN_BATTERY','CA'))</script>");
                else
				{
					qs=qs + "&battey_id="+retvalue;
                    qs1 = qs;
                    proceed = true;
                }
			}

			if (rset!=null) rset.close();
			if (pstmt!=null) pstmt.close();
	
			StringBuffer sql=new StringBuffer();
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append(" SELECT to_char(test_observ_dt_tm,'dd/mm/yyyy hh24:mi:ss')");
			sql.append(" test_observ_dt_tm FROM ca_encntr_discr_msr WHERE test_observ_dt_tm");
            sql.append(" =(SELECT MAX(test_observ_dt_tm) FROM ca_encntr_discr_msr");  
            //IN070732 Start.
			//sql.append(" WHERE facility_id = ? AND ENCOUNTER_ID = ?) and facility_id = ? AND ENCOUNTER_ID = ? AND ROWNUM=1");  
			sql.append(" WHERE facility_id = ? AND ENCOUNTER_ID = ?  AND DISCR_MSR_ID IN(SELECT DISTINCT DISCR_MSR_ID FROM AM_DISCR_MSR_BATTERY_VIEW WHERE DISCR_MSR_BATTERY_ID=?)) and facility_id = ? AND ENCOUNTER_ID = ?   AND ROWNUM=1");  
            //IN070732 End.
			
			pstmt=con.prepareStatement(sql.toString());
			//IN070732 Start.
			//pstmt.setString(1,facilityid);
			//pstmt.setString(2,episodeid);
			//pstmt.setString(3,facilityid);
			//pstmt.setString(4,episodeid);
			
			pstmt.setString(1,facilityid);
			pstmt.setString(2,episodeid); 
			pstmt.setString(3,retvalue);
			pstmt.setString(4,facilityid);
			pstmt.setString(5,episodeid);
			//IN070732 End.			
			rset=pstmt.executeQuery();
			
	        if(rset!=null && rset.next())
			{
				lastrecorddate = rset.getString("test_observ_dt_tm")==null?"":rset.getString("test_observ_dt_tm");
				//Date conversion added by Archana Dhal on 11/10/2010 related to incident no. IN024814.
				//lastrecorddate = com.ehis.util.DateUtils.convertDate(lastrecorddate,"DMYHMS","en",locale);
				//This is reverted back since the problem is comming in replace mode
	        }

			qs = qs+"&last_record_date="+lastrecorddate;
			qs = qs+"&dob="+dob+"&patsex="+sex;
			qs1 = qs; //--[IN036447] to clear the data on click on clear button
			//String frameSet = "7%,*,7%";
			String height1 = "7vh";  
			String height2 = "60vh";
			String height3 = "7vh";  
			String height4 = "6vh";
			if(amendMode != null && amendMode.equals("Y"))
				//frameSet = "11%,*,7%";
				height1 = "11vh";
			    height3 = "7vh";

			if(replaceMode != null && replaceMode.equals("Y"))
				//frameSet = "11%,*,7%";
				 height1 = "7vh";
		   		 height3 = "7vh";

			if(!module_id.equals(""))
			{
				//frameSet = "11%,*,7%,7%";
					height1 = "7vh";
					height2 = "78vh";
				    height3 = "7vh";
				    height4 = "7vh";
			}

			if(proceed &&  amerepMode.equals("N"))
			{ 

            _bw.write(_wl_block11Bytes, _wl_block11);
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(qs));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(height1));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(qs));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(height2));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(qs1));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(height3));
            _bw.write(_wl_block18Bytes, _wl_block18);

				if(!module_id.equals(""))
				{

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(height4));
            _bw.write(_wl_block20Bytes, _wl_block20);

				}

            _bw.write(_wl_block2Bytes, _wl_block2);
   
			}
			else if(proceed &&  amerepMode.equals("Y"))
			{

            _bw.write(_wl_block21Bytes, _wl_block21);
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(qs));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(height1));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(qs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(height2));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(qs1));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(height3));
            _bw.write(_wl_block25Bytes, _wl_block25);

				if(!module_id.equals(""))
				{

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(height4));
            _bw.write(_wl_block20Bytes, _wl_block20);

				}

            _bw.write(_wl_block27Bytes, _wl_block27);
			}
		} 

            _bw.write(_wl_block28Bytes, _wl_block28);

		if(rset != null) rset.close();
		if(pstmt != null) pstmt.close();    
	}
	catch ( Exception e) { }
    finally
	{
		if(con != null)ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
