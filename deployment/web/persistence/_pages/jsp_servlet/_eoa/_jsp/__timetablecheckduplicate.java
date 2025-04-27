package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __timetablecheckduplicate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/TimeTableCheckDuplicate.jsp", 1711964678266L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t\tvar err_message = getMessage(\'TIME_TABLE_ALREAY_EXIST\',\'OA\') ;\n\t\t\talert(err_message) ;\n\t\t\t//frames[1].document.forms[0].b_day.value=\'\';\n\t\t\ttoSubmit=false;\n\t\t\tframes[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\" ;\n\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\tvar err_message = getMessage(\'TIME_TABLE_ALREAY_EXIST\',\'OA\') ;\n\t\t\talert(err_message) ;\n\t\t\t//frames[1].document.forms[0].b_day.value=\'\';\n\t\t\ttoSubmit=false;\n\t\t\tframes[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\" ;\t\t\n\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\tvar err_message = getMessage(\'TIME_TABLE_ALREAY_EXST_FOR_DAY\',\'OA\') ;\n\t\t\tvar p=confirm(err_message);\n\t\t\tif (!p){ \n\t\t\t\ttoSubmit=false;\n\t\t\t\tframes[1].document.forms[0].b_day.value=\'\';\n\t\t\t}\n\t\t\tframes[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\" ;\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="dayObj=document.forms[0].b_day;\n      opt=document.createElement(\'OPTION\');\n\t  opt.value=\'\';\n\t  opt.text=\"----\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"----\";\n\t  opt1=document.createElement(\'OPTION\');\n\t  opt1.value=\'*A\';\n\t  opt1.text=\"*\"+getLabel(\"Common.all.label\",\"Common\");\n\t  while(dayObj.options.length > 0) dayObj.remove(dayObj.options[0]);\n\t  dayObj.add(opt);\n      dayObj.add(opt1);\n\n\t ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="opt=document.createElement(\'OPTION\');\n\t\t\t \n\t\t\topt.value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\';\n\t\t\topt.text=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\';\n\t\t\tframes[1].document.forms[0].b_day.add(opt);\n\t ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\n\t\t dayObj=document.forms[0].b_day;\n\t\tif (dayObj.options.length == 2)\n\t\t {\n\t\t\t dayObj.remove(dayObj.options[0]);\n\t\t\t dayObj.remove(dayObj.options[1]);\n\t\t\t opt=document.createElement(\'OPTION\');\n\t\t\t opt.value=\'\';\n\t\t\t opt.text=\"----\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"----\";\n\t\t\t dayObj.add(opt);\n\t\t  }\n ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);

Connection con = null;
Statement stmt=null;
ResultSet rs=null;
try
{	
	request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection(request);
	Map hash = (Map)obj.parseXMLString( request ) ;
	hash = (Map)hash.get("SEARCH") ;
	String fac_id  		= (String) session.getValue( "facility_id" ) ;
	String p_clinic_code	=(String) hash.get("cliniccode") ;
	String p_pract_code	= (String)hash.get("practcode") ;
	String p_day_no		= (String)hash.get("dayno") ;
	StringBuffer sql=new StringBuffer();
	String resourceClass=(String)hash.get("resourceClass");
	stmt = con.createStatement() ;
	String srcElement=(String)hash.get("from");
	String start_time=(String)hash.get("start_time");
	String end_time=(String)hash.get("end_time");
	String mode=(String)hash.get("mode");
	String rule_appl_yn = (String)hash.get("rule_appl_yn");
	int otheClinicTimeTableCount =0;	

            _bw.write(_wl_block2Bytes, _wl_block2);
 
	if (!srcElement.equals("b_pract_name") && !srcElement.equals("pract_butt") && srcElement.equals("apply"))
	{
		sql  =sql.append( "select count(*) as total from oa_clinic_time_table where facility_id = '"+fac_id+"' and RESOURCE_CLASS='"+resourceClass+"'") ;
		if ((!p_day_no.equals("*A"))){
			sql =sql.append(" and day_no = '"+p_day_no+"' ");
		}		
		if(mode.equals("insert")){
			if(p_pract_code.equals("")){
				sql=sql.append(" AND  clinic_code = '"+p_clinic_code+"' AND practitioner_id is null ");
			}else{// code changed so that overlapped timetable will be created
				sql=sql.append(" AND clinic_code = '"+p_clinic_code+"' and practitioner_id = '"+p_pract_code+"'");							
			}/*else if(rule_appl_yn.equals("Y")){
				sql=sql.append(" AND ((clinic_code = '"+p_clinic_code+"' and practitioner_id = '"+p_pract_code+"') OR (practitioner_id = '"+p_pract_code+"' AND ((TO_CHAR (start_time, 'HH24:mi') BETWEEN '"+start_time+"' AND '"+end_time+"' OR TO_CHAR (end_time, 'HH24:mi') BETWEEN '"+start_time+"' AND '"+end_time+"') OR ('"+start_time+"' BETWEEN TO_CHAR (start_time, 'HH24:mi') AND TO_CHAR (end_time, 'HH24:mi') OR '"+end_time+"' BETWEEN TO_CHAR (start_time, 'HH24:mi') AND TO_CHAR (end_time, 'HH24:mi')))");
				if ((!p_day_no.equals("*A"))){
					sql =sql.append(" and day_no = '"+p_day_no+"' ");
				}	
				sql=sql.append("))");				
				String othClinicTimeTableSQL = "select count(*) count from oa_clinic_time_table where facility_id = '"+fac_id+"' AND resource_class = '"+resourceClass+"' AND practitioner_id = '"+p_pract_code+"' AND (   (   TO_CHAR (start_time, 'HH24:mi') BETWEEN '"+start_time+"' AND '"+end_time+"' OR TO_CHAR (end_time, 'HH24:mi') BETWEEN '"+start_time+"' AND '"+end_time+"') OR (   '"+start_time+"' BETWEEN TO_CHAR (start_time, 'HH24:mi') AND TO_CHAR (end_time, 'HH24:mi') OR '"+end_time+"' BETWEEN TO_CHAR (start_time, 'HH24:mi') AND TO_CHAR (end_time, 'HH24:mi'))) AND CLINIC_CODE !='"+p_clinic_code+"'";
				if(rs!=null)rs.close();
				rs = stmt.executeQuery(othClinicTimeTableSQL) ;
				if(rs!=null && rs.next()){
					otheClinicTimeTableCount =rs.getInt("count") ;
				}
			}else if(rule_appl_yn.equals("N")){
				sql=sql.append(" AND clinic_code = '"+p_clinic_code+"' and practitioner_id = '"+p_pract_code+"'");							
			}*/
			//sql=sql.append(" AND ( (TO_CHAR (start_time, 'HH24:mi') BETWEEN '"+start_time+"' AND '"+end_time+"' OR TO_CHAR (end_time, 'HH24:mi') BETWEEN '"+start_time+"' AND '"+end_time+"') OR clinic_code = '"+p_clinic_code+"')");
		}else if(mode.equals("modify")){
			if(p_pract_code.equals("")){
				sql=sql.append(" AND clinic_code = '"+p_clinic_code+"' AND practitioner_id is null ");
			}else{// code changed so that overlapped timetable will be created
				sql=sql.append(" AND clinic_code = '"+p_clinic_code+"' AND practitioner_id = '"+p_pract_code+"'");
			}/*else if(rule_appl_yn.equals("Y")){
				sql=sql.append(" AND practitioner_id = '"+p_pract_code+"' AND ((TO_CHAR (start_time, 'HH24:mi') BETWEEN '"+start_time+"' AND '"+end_time+"' OR TO_CHAR (end_time, 'HH24:mi') BETWEEN '"+start_time+"' AND '"+end_time+"') OR ('"+start_time+"' BETWEEN TO_CHAR (start_time, 'HH24:mi') AND TO_CHAR (end_time, 'HH24:mi') OR '"+end_time+"' BETWEEN TO_CHAR (start_time, 'HH24:mi') AND TO_CHAR (end_time, 'HH24:mi'))) ");
			}else if(rule_appl_yn.equals("N")){
				sql=sql.append(" AND clinic_code = '"+p_clinic_code+"' AND practitioner_id = '"+p_pract_code+"'");
			}*/
			//sql=sql.append(" AND ( (TO_CHAR (start_time, 'HH24:mi') BETWEEN '"+start_time+"' AND '"+end_time+"' OR TO_CHAR (end_time, 'HH24:mi') BETWEEN '"+start_time+"' AND '"+end_time+"') AND clinic_code != '"+p_clinic_code+"')");
		}
		//sql = sql.append(" and nvl(practitioner_id,'X') = nvl('"+p_pract_code+"','X') " );
			//System.out.println("p_day_no ==>"+p_day_no);
		if(rs!=null)rs.close();
		rs = stmt.executeQuery(sql.toString()) ;
		sql.setLength(0);
		rs.next();
		int cnt = rs.getInt("total") ;
		rs.close() ;
	
	if ( (mode.equals("insert") && cnt >0) ||(mode.equals("modify") && cnt >1))
	{
		if ((!p_day_no.equals("*A")))
		{
            _bw.write(_wl_block3Bytes, _wl_block3);
}else if(rule_appl_yn.equals("Y") && otheClinicTimeTableCount > 1){
            _bw.write(_wl_block4Bytes, _wl_block4);
}else{
            _bw.write(_wl_block5Bytes, _wl_block5);
}
	}else
	{
		sql  = sql.append("select to_char(break_start_time,'HH24:MI') br_start_time, to_char(break_end_time,'HH24:MI') br_end_time from oa_clinic_break ") ;
		sql = sql.append("where facility_id = '"+fac_id+"' and clinic_code = '"+p_clinic_code+"' and day_no = '"+p_day_no+"' and " );
		sql = sql.append("nvl(practitioner_id,'X') = nvl('"+p_pract_code+"','X') ") ;
	}
}

    if (!p_pract_code.equals("") && (srcElement.equals("b_pract_name") || srcElement.equals("pract_butt")))
{
	 
            _bw.write(_wl_block6Bytes, _wl_block6);
 String sql1="select initcap(day_of_week)day_of_week, day_no from sm_day_of_week a where exists (select '1' from op_pract_for_clinic where decode(a.day_no,'1',working_day_1,'2',working_day_2,'3',working_day_3,'4',working_day_4,'5',working_day_5,'6',working_day_6,'7',working_day_7)='Y' and facility_id='"+fac_id+"' and clinic_code ='"+p_clinic_code+"' and practitioner_id='"+p_pract_code+"' and resource_class='"+resourceClass+"' and eff_status='E') order by 2";
      
	rs=stmt.executeQuery(sql1);
	String dayOfWeek="";
	String dayNumber="";
	while(rs.next() && rs!=null)
		{
			dayOfWeek=rs.getString("day_of_week");
			dayNumber=rs.getString("day_no");
			
			if(dayOfWeek.equals("Monday"))
								{
									dayOfWeek=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(dayOfWeek.equals("Tuesday"))
								{
									dayOfWeek=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(dayOfWeek.equals("Wednesday"))
								{
									dayOfWeek=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(dayOfWeek.equals("Thursday"))
								{
									dayOfWeek=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(dayOfWeek.equals("Friday"))
								{
									dayOfWeek=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(dayOfWeek.equals("Saturday"))
								{
									dayOfWeek=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(dayOfWeek.equals("Sunday"))
								{
									dayOfWeek=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}	


			
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(dayNumber));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(dayOfWeek));
            _bw.write(_wl_block9Bytes, _wl_block9);
}
            _bw.write(_wl_block10Bytes, _wl_block10);
}
 	if(rs !=null) rs.close();
	if(stmt !=null) stmt.close();
	hash.clear();
}catch( Exception e )
{
	//out.println(e.toString());
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally
{
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
