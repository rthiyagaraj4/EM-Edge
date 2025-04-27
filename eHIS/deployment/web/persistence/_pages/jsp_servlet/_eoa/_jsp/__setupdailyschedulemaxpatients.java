package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;

public final class __setupdailyschedulemaxpatients extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/SetUpDailyScheduleMaxPatients.jsp", 1709119277506L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t<script>\n\t\tvar in_cl_sp_tm\t\t= parent.frames[1].getMessage(\'INVALID_CLINIC_SPAN_TIME\',\'OA\');\n\t\tmax_pat\t\t\t= ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" ;\n\t\ttotal_time\t\t= ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" ;\n\t\ttime_per_patient\t= ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" ;\n\t\tif ( max_pat == 0 )\n\t\t{\t\t\t\n\t\t\tparent.frames[1].document.forms[0].max_patients_per_day.value = (total_time / time_per_patient) ;\n\t\t    parent.frames[1].document.forms[0].b_max_slots_per_day.value = parent.frames[1].document.forms[0].max_patients_per_day.value ;\n\t\t\tparent.frames[1].document.forms[0].l_max_pat_per_slot.value = parent.frames[1].document.forms[0].max_patients_per_day.value ;\n\t\t\tparent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t}\n\t\telse\n\t\t{\n\t\t\talert(in_cl_sp_tm);\n\t\t\tif(parent.frames[1].document.forms[0].function_mode.value!=\"modify\")\n\t\t\t\t{\n\t\t\t\t\tparent.frames[1].document.forms[0].time_per_patient.focus();\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tparent.frames[1].document.forms[0].end_time.select();\n\t\t\t\t\tparent.frames[1].document.forms[0].end_time.focus();\n\t\t\t\t}\n\t\t\t\tparent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t}\n\n\n\t\t</script>\n\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t<script>\n\n\t\t\t\t\tno_of_slabs\t\t= ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" ;\n\t\t\t\t\ttotal_time\t\t= ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" ;\n\t\t\t\t\ttime_per_slab\t\t= ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" ;\t\t\n\n\t\t\t\t\tif ( no_of_slabs == 0 )\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.frames[1].document.forms[0].max_patients_per_day.value = (total_time / time_per_slab) * parent.frames[1].document.forms[0].max_patients_per_slab.value ;\t\t\t\t\t\t\t//parent.frames[1].document.forms[0].max_other_visits.value=parent.frames[1].document.forms[0].max_patients_per_day.value;\n\t\t\t\t\t\t//parent.frames[1].document.forms[0].max_first_visit.value=\"0\";\n\t\t\t\t\t\t\n\t\t\t\t\t\tparent.frames[2].location.href=\'../../eCommon/jsp/error.jsp?err_num=\';\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tvar stm_valid\t     =  parent.frames[1].getMessage(\'SLAB_TIME_VALIDATION\',\'OA\') ;\n\t\t\t\t\t\talert(stm_valid) ;\n\t\t\t\t\t\tparent.frames[2].location.href=\'../../eCommon/jsp/error.jsp?err_num=\';\n\t\t\t\t\t\tparent.frames[1].document.forms[0].max_patients_per_day.focus();\n\t\t\t\t\t}\n\n\t\t\t\t\t</script>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="<script>\n\t\t\tparent.frames[1].document.forms[0].time_per_slab.value=\'\';\n\t\t\tparent.frames[1].document.forms[0].max_patients_per_slab.value=\'\';\n\t\t\t//alert(\'APPOA0041 Location time span should be a multiple of Time per Patient/Slab\');\n\t\t\tparent.frames[2].location.href=\'../../eCommon/jsp/error.jsp?err_num=\';\t\n\t\t\tparent.frames[1].document.forms[0].time_per_slab.focus();\n\t\t\t</script>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="<script>\n\t\t\tparent.frames[1].document.forms[0].time_per_slab.value=\'\';\n\t\t\tparent.frames[1].document.forms[0].max_patients_per_slab.value=\'\';\n\t\t\talert(\'APPOA0041 Location time span should be a multiple of Time per Patient/Slab\');\n\t\t\tparent.frames[2].location.href=\'../../eCommon/jsp/error.jsp?err_num=\';\t\n\t\t\tparent.frames[1].document.forms[0].time_per_slab.focus();\n\t\t\t</script>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\tvar in_cl_sp_tm\t\t= getMessage(\'INVALID_CLINIC_SPAN_TIME\',\'OA\');\n\t\tmax_pat\t\t\t= ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" ;\n\t\tif ( max_pat == 0 )\n\t\t{\n\t\t\tframes[1].document.forms[0].result.value=\"0\";\n\t\t\tframes[1].document.forms[0].max_patients_per_day.value = (total_time / time_per_patient) ;\n\t\t    frames[1].document.forms[0].b_max_slots_per_day.value = frames[1].document.forms[0].max_patients_per_day.value ;\n\t\t\tframes[1].document.forms[0].l_max_pat_per_slot.value = frames[1].document.forms[0].max_patients_per_day.value ;\n\t\t}\n\t\telse\n\t\t{\n\t\t\talert(in_cl_sp_tm);\n\t\t\tframes[1].document.forms[0].result.value=\"1\";\n\t\t\t\n\t\t}\n\n\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\n\n\t\t\t\t\tno_of_slabs\t\t= ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" ;\n\n\t\t\t\t\tif ( no_of_slabs == 0 ){\n\t\t\t\t\t\tframes[1].document.forms[0].result.value=\"0\";\n\t\t\t\t\t\tframes[1].document.forms[0].max_patients_per_day.value = (total_time / time_per_slab) * frames[1].document.forms[0].max_patients_per_slab.value ;\t\n\t\t\t\t\t\t//frames[1].document.forms[0].max_other_visits.value=frames[1].document.forms[0].max_patients_per_day.value;\n\t\t\t\t\t\t//frames[1].document.forms[0].max_first_visit.value=\"0\";\n\t\t\t\t\t}else{\n\t\t\t\t\t\tframes[1].document.forms[0].result.value=\"1\";\n\t\t\t\t\t\tvar stm_valid\t     = getMessage(\'SLAB_TIME_VALIDATION\',\'OA\') ;\n\t\t\t\t\t\talert(stm_valid) ;\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\tparent.frames[1].document.forms[0].time_per_slab.value=\'\';\n\t\t\tparent.frames[1].document.forms[0].max_patients_per_slab.value=\'\';\n\t\t\t//alert(\'APPOA0041 Location time span should be a multiple of Time per Patient/Slab\');\n\t\t\tparent.frames[1].document.forms[0].time_per_slab.focus();\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\t\t\n\t\t\talert(\'APPOA0041 Location time span should be a multiple of Time per Patient/Slab\');\n\t\t\tframes[1].document.forms[0].result.value=\"1\";\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

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
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

CallableStatement statement=null;
Connection con=null;
String p_total_time		= "" ;
String calling_from	= "";
String normal_yn	="";
String p_max_pat_cat="";
String p_start_time="";
String p_end_time="";
String p_time_per_patient="";
String p_time_per_slab	="";
String p_max_pat_per_slab ="";

try
{
	request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection(request);
	normal_yn		= request.getParameter("normal_yn") ;
	if(normal_yn ==null) normal_yn="";	
	if(!normal_yn.equals("Y"))  //If else condition Added by S.Sathish for IN020308 on Thursday, April 01, 2010
	{
		Map hash = (Map)obj.parseXMLString( request ) ;
		hash = (Map)hash.get("SEARCH") ;
		calling_from		=(String) hash.get("calling_from");
		if(calling_from == null || calling_from.equals("null")) calling_from="";		
		p_max_pat_cat		=(String) hash.get("maxpatcat");
		if(p_max_pat_cat == null) p_max_pat_cat="";		
		p_start_time		=(String) hash.get("starttime");
		if(p_start_time == null) p_start_time="";		
		p_end_time		=(String) hash.get("endtime");
		if(p_end_time == null) p_end_time="";		
		if(p_max_pat_cat.equals("1")){
					p_time_per_patient	= (String) hash.get("timeperpatient") ;
					if(p_time_per_patient == null) p_time_per_patient="";
		}else{
					p_time_per_slab	= (String) hash.get("timeperslab") ;
					if(p_time_per_slab == null) p_time_per_slab="";
					p_max_pat_per_slab	= (String) hash.get("maxpatperslab") ;
					if(p_max_pat_per_slab == null) p_max_pat_per_slab="";
				}
	}else{
		calling_from="";
	}


	if(calling_from.equals(""))
	{
		p_max_pat_cat		= request.getParameter("maxpatcat") ;
		if(p_max_pat_cat ==null) p_max_pat_cat="";
		p_start_time		= request.getParameter("starttime") ;
		if(p_start_time ==null) p_start_time="";
		p_end_time		= request.getParameter("endtime") ;
		if(p_end_time == null) p_end_time="";		
		if (p_max_pat_cat.equals("1"))
		{		
		
			p_time_per_patient	= request.getParameter("timeperpatient") ;
			if(p_time_per_patient == null) p_time_per_patient="";
			String p_max_patients		= "" ;		
			String p_time_per_pat		= "" ;	

			statement=con.prepareCall("{call oa_max_pat_per_day( ?,?,?,?,?,?)}" );

			statement.setString( 1,	p_start_time ) ;
			statement.setString( 2,	p_end_time ) ;
			statement.setString( 3,	p_time_per_patient );

			statement.registerOutParameter(4,Types.VARCHAR ) ;
			statement.registerOutParameter(5,Types.VARCHAR ) ;
			statement.registerOutParameter(6,Types.VARCHAR ) ;

			statement.execute() ;

			p_total_time	=	statement.getString(4) ;
			p_time_per_pat	=	statement.getString(5) ;
			p_max_patients	=	statement.getString(6) ;

	
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(p_max_patients));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(p_total_time));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(p_time_per_pat));
            _bw.write(_wl_block6Bytes, _wl_block6);

	if (statement!=null) statement.close();
	} //end type 1
	else
	{		
		p_time_per_slab		= request.getParameter("timeperslab") ;
		if(p_time_per_slab ==null) p_time_per_slab="";
		p_max_pat_per_slab	= request.getParameter("maxpatperslab") ;
		if(p_max_pat_per_slab ==null) p_max_pat_per_slab="";

		String p_no_of_slabs		= "";
		String timeperslab		= "";
		String  modslab ="";


		statement=null;
		statement=con.prepareCall("{call oa_max_pat_per_day( ?,?,?,?,?,?)}" );

		statement.setString( 1, p_start_time );
		statement.setString( 2,	p_end_time ) ;
		statement.setString( 3,	p_time_per_slab ) ;

		statement.registerOutParameter(4,Types.VARCHAR ) ;
		statement.registerOutParameter(5,Types.VARCHAR ) ;
		statement.registerOutParameter(6,Types.VARCHAR ) ;

		statement.execute() ;

		timeperslab	=	statement.getString(4) ;
		
		modslab	=	statement.getString(6) ;
		int m = Integer.parseInt(modslab);

		if (statement!=null) statement.close();		
		if(m == 0)
	{
		if(!(modslab == null)	)
		{
				statement=con.prepareCall("{call oa_max_pat_per_slab( ?,?,?)}" );

				statement.setString( 1, timeperslab );
				statement.setString( 2,	p_max_pat_per_slab ) ;

				statement.registerOutParameter(3,Types.VARCHAR ) ;

				statement.execute() ;

				//p_max_pat_val	= statement.getString(3);
				
				if (statement!=null) statement.close();
			if ((!p_start_time.equals("")) && (!p_end_time.equals("")) && (!p_time_per_slab.equals("")))
			{

					statement=con.prepareCall("{call oa_max_pat_per_day( ?,?,?,?,?,?)}" );

					statement.setString( 1,	p_start_time ) ;
					statement.setString( 2,	p_end_time ) ;
					statement.setString( 3,	p_time_per_slab );

					statement.registerOutParameter(4,Types.VARCHAR ) ;
					statement.registerOutParameter(5,Types.VARCHAR ) ;
					statement.registerOutParameter(6,Types.VARCHAR ) ;

					statement.execute() ;

					p_total_time	=	statement.getString(4) ;
					p_time_per_slab	=	statement.getString(5) ;
					p_no_of_slabs	=	statement.getString(6) ;

					
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(p_no_of_slabs));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(p_total_time));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_time_per_slab));
            _bw.write(_wl_block10Bytes, _wl_block10);

			 }
	    }
	    else
		{
			
            _bw.write(_wl_block11Bytes, _wl_block11);

		}


	}	else
		{
			
            _bw.write(_wl_block12Bytes, _wl_block12);

		}	
		
	}
if(statement !=null) statement.close();
}else{ //Else condition Added by S.Sathish for IN020308 on Thursday, April 01, 2010 starts here
		

		if (p_max_pat_cat.equals("1"))
		{
			
			String p_max_patients		= "" ;		
			String p_time_per_pat		= "" ;	

			statement=con.prepareCall("{call oa_max_pat_per_day( ?,?,?,?,?,?)}" );

			statement.setString( 1,	p_start_time ) ;
			statement.setString( 2,	p_end_time ) ;
			statement.setString( 3,	p_time_per_patient );

			statement.registerOutParameter(4,Types.VARCHAR ) ;
			statement.registerOutParameter(5,Types.VARCHAR ) ;
			statement.registerOutParameter(6,Types.VARCHAR ) ;

			statement.execute() ;

			p_total_time	=	statement.getString(4) ;
			p_time_per_pat	=	statement.getString(5) ;
			p_max_patients	=	statement.getString(6) ;

			
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(p_max_patients));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(p_total_time));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(p_time_per_pat));
            _bw.write(_wl_block14Bytes, _wl_block14);

			if (statement!=null) statement.close();

		}
		else{			
		String p_no_of_slabs		= "";
		String timeperslab		= "";
		String  modslab ="";
		


		statement=null;
		statement=con.prepareCall("{call oa_max_pat_per_day( ?,?,?,?,?,?)}" );

		statement.setString( 1, p_start_time );
		statement.setString( 2,	p_end_time ) ;
		statement.setString( 3,	p_time_per_slab ) ;

		statement.registerOutParameter(4,Types.VARCHAR ) ;
		statement.registerOutParameter(5,Types.VARCHAR ) ;
		statement.registerOutParameter(6,Types.VARCHAR ) ;

		statement.execute() ;

		timeperslab	=	statement.getString(4) ;
		
		modslab	=	statement.getString(6) ;
		int m = Integer.parseInt(modslab);

		if (statement!=null) statement.close();
		if(m == 0)
		{
		if(!(modslab == null)	)
		{
				statement=con.prepareCall("{call oa_max_pat_per_slab( ?,?,?)}" );

				statement.setString( 1, timeperslab );
				statement.setString( 2,	p_max_pat_per_slab ) ;

				statement.registerOutParameter(3,Types.VARCHAR ) ;

				statement.execute() ;

				//p_max_pat_val	= statement.getString(3);
				
				if (statement!=null) statement.close();
			if ((!p_start_time.equals("")) && (!p_end_time.equals("")) && (!p_time_per_slab.equals("")))
			{

					statement=con.prepareCall("{call oa_max_pat_per_day( ?,?,?,?,?,?)}" );

					statement.setString( 1,	p_start_time ) ;
					statement.setString( 2,	p_end_time ) ;
					statement.setString( 3,	p_time_per_slab );

					statement.registerOutParameter(4,Types.VARCHAR ) ;
					statement.registerOutParameter(5,Types.VARCHAR ) ;
					statement.registerOutParameter(6,Types.VARCHAR ) ;

					statement.execute() ;

					p_total_time	=	statement.getString(4) ;
					p_time_per_slab	=	statement.getString(5) ;
					p_no_of_slabs	=	statement.getString(6) ;

					
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(p_no_of_slabs));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(p_total_time));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_time_per_slab));
            _bw.write(_wl_block16Bytes, _wl_block16);
}
	    }else{
			
            _bw.write(_wl_block17Bytes, _wl_block17);

		}
	}else{
			
            _bw.write(_wl_block18Bytes, _wl_block18);

		}	

		}

}//Ends here

if(statement !=null) statement.close();
}
catch(Exception e ){
//out.println(e.toString());
e.printStackTrace();
}
finally{
	ConnectionManager.returnConnection(con,request);
	
	}

            _bw.write(_wl_block19Bytes, _wl_block19);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
