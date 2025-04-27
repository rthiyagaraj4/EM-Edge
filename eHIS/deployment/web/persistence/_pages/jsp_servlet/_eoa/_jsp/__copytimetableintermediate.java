package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;

public final class __copytimetableintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/CopyTimeTableIntermediate.jsp", 1711954657811L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "utf-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 =" \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t\t\n\t\t\t\n\t\t\t var i=2;\n\t\t\t var len=parent.frames[0].document.forms[0].Time_Table_Details.options.length;\n\t\t\t var lBox=parent.frames[0].document.forms[0].Time_Table_Details; \n\t\t\t lBox.remove(lBox.options[0]);\n\t\t\t var opt=parent.frames[0].document.createElement(\'OPTION\');\n\t\t\t opt.value=\'\';\n\t\t     opt.text=\'------------------------\'+getLabel(\"Common.defaultSelect.label\",\"Common\")+\'------------------------\';\n\t\t\t lBox.add(opt);\n\n\t\t\t while(i<= len){\n\t\t\t\t lBox.remove(lBox.options[i]);\n\t\t\t\t i+=1;\n\t\t\t}   \n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t\t\t\tvar element = parent.frames[0].document.createElement(\'OPTION\');\n\t\t\t\t\telement.value=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="|";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n\t\t\t\t\telement.text = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\t\t\t\t\tparent.frames[0].document.forms[0].Time_Table_Details.add(element);\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=utf-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=utf-8");
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
ResultSet rs=null;
PreparedStatement pstmt =null;


try{
	request.setCharacterEncoding("utf-8");
con = ConnectionManager.getConnection(request);
	Map hash = (Map)obj.parseXMLString( request ) ;
	hash = (Map)hash.get("SEARCH") ;

	String facilityId	=(String) session.getValue("facility_id");
	String loginuser 	= (String) session.getValue( "login_user" ) ;
	
	
	String steps     =(String) hash.get("steps");
	String clinic_code     =(String) hash.get("clinic_code");
	
     
    if(steps.equals("1")){
	
		StringBuffer sql=new StringBuffer("");
		String pract_id="";
		String care_locn_type_ind= "";
		String day_no ="";
		String time_table_type="";
		String time_table_type_no="";
		String practitioner_name="";
		String day_of_week="";
		String resource_class="";
		String start_time="";
		String end_time="";
		
		/*Below query commented by venkatesh against GHL-SCF-992 on 18-02-2016 */
		//	sql.append("select care_locn_type_ind,CARE_LOCN_TYPE_DESC, clinic_code,clinic_name,resource_class,decode(resource_class,'P','Practitioner','E','Equipment','B','Bed','R','Room','O','Other') resource_class_desc,nvl(practitioner_id,'')practitioner_id,nvl(practitioner_id,'') pract_id,nvl(PRACTITIONER_FULL_NAME,'')practitioner_name,day_no,day_of_week,decode(time_table_type,'1','Slot','2','Slab','3','Free Format') time_table_type,time_table_type time_table_type_no,TO_CHAR (start_time, 'HH24:mi') start_time, TO_CHAR (end_time, 'HH24:mi') end_time from oa_clinic_time_table_vw where facility_id ='"+facilityId+"' and clinic_code = '"+clinic_code+"' and practitioner_id is not null ");
			 /* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
			sql.append("select care_locn_type_ind,CARE_LOCN_TYPE_DESC, clinic_code,clinic_name,resource_class,decode(resource_class,'P','Practitioner','E','Equipment','B','Bed','R','Room','O','Other') resource_class_desc,nvl(practitioner_id,'')practitioner_id,nvl(practitioner_id,'') pract_id,nvl(PRACTITIONER_FULL_NAME,'')practitioner_name,day_no,day_of_week,decode(time_table_type,'1','Slot','2','Slab','3','Free Format') time_table_type,time_table_type time_table_type_no,TO_CHAR (start_time, 'HH24:mi') start_time, TO_CHAR (end_time, 'HH24:mi') end_time from oa_clinic_time_table_vw where facility_id ='"+facilityId+"' and clinic_code = '"+clinic_code+"' and practitioner_id is not null AND (EFF_STATUS!='D' OR EFF_STATUS IS NULL)");
					
		
			pstmt=con.prepareStatement(sql.toString());
		//	if (rs!=null) rs.close();
			rs = pstmt.executeQuery() ;
			sql.setLength(0);
			
            _bw.write(_wl_block2Bytes, _wl_block2);

			if (rs != null){
						
				while(rs.next()){
					 pract_id=rs.getString("pract_id");
					 	care_locn_type_ind= rs.getString("care_locn_type_ind");
					 	day_no = rs.getString("day_no");
					 		time_table_type=rs.getString("time_table_type");
					 		time_table_type_no=rs.getString("time_table_type_no");
					 		practitioner_name=rs.getString("practitioner_name");
					 		day_of_week=rs.getString("day_of_week");
					 		resource_class=rs.getString("resource_class");
					 		start_time=rs.getString("start_time");
					 		end_time=rs.getString("end_time");
			
					
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(pract_id));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(time_table_type_no));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(day_no));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(resource_class));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(start_time));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(end_time));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(day_of_week));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(time_table_type));
            _bw.write(_wl_block7Bytes, _wl_block7);

				}
			}
		

	}

	if(rs !=null) rs.close();	
	if(pstmt !=null)pstmt.close();
	hash.clear();

}catch( Exception e ){
	System.out.println("Exception Steps :"+e);
	e.printStackTrace();

}finally{
	if(con !=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
