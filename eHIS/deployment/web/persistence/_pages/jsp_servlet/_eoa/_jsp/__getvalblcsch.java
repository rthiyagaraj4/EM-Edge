package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;

public final class __getvalblcsch extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/GetValBLCSch.jsp", 1712313280764L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="<html><HEAD>\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t\t\t\t\t<Script src=\"../../eOA/js/BlockLiftCancelSch.js\" language=\"JavaScript\"></Script>\n\t\t\t\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\n</HEAD><body CLASS=\'MESSAGE\' onKeyDown = \'lockKey()\'><form name=\'testform\' id=\'testform\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<script>\n\t\t\t\n\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<script>\n\t       // parent.frames[1].document.getElementById(\"info\").innerHTML=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\tparent.frames[3].location.href=\'../../eCommon/jsp/error.jsp\'\n       </script>\n\t\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
request.setCharacterEncoding("UTF-8");
	String locn = request.getParameter("locn");
	String pract = request.getParameter("pract");
	
	//out.println("locn inside getval"+locn);
	//out.println("locn inside getval"+pract);
	
	

	Connection con = null;
	String facilityId = (String)session.getValue("facility_id");
	Statement stmt=null;
    PreparedStatement pstmt=null;
	ResultSet rs = null;
	String sql="";
	String dat="";
	String locn_id="";

	StringTokenizer st = new StringTokenizer(locn,"|");
	while (st.hasMoreTokens())
	{
			locn_id = st.nextToken();
			st.nextToken();
			st.nextToken();
			st.nextToken();
			st.nextToken();
	}
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	try{
	con = ConnectionManager.getConnection(request);
		if(pract.equals("") || pract == null){
		if (!(locn_id.equals("") || locn_id == null))
		{
		
            _bw.write(_wl_block8Bytes, _wl_block8);

		}
	}


if (!(locn_id.equals("") || locn_id == null))
{
		//int i=0;
           StringBuffer dispStr=new StringBuffer("");
          
			//sql  = "  select distinct initcap(b.day_of_week) wkdt, a.day_no from  oa_clinic_time_table a, sm_day_of_week b where facility_id = '"+facilityId+"'  and clinic_code = '"+locn_id+"' and a.day_no = b.day_no order by a.day_no ";
			sql  = "  select distinct initcap(b.day_of_week) wkdt, a.day_no from  oa_clinic_time_table a, sm_day_of_week b where facility_id = ? and clinic_code = ? and a.day_no = b.day_no order by a.day_no ";
			stmt = con.createStatement() ;
			//rs = stmt.executeQuery(sql) ;
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facilityId);
			pstmt.setString(2,locn_id);
			rs = pstmt.executeQuery();
			if (rs != null)
			{
				while(rs.next())
				{
					dat=rs.getString("wkdt");
					if(dat.equals("Monday")){
						out.println("<script>parent.frames[1].document.getElementById('mon').disabled=false</script>");
					}else if(dat.equals("Tuesday")){
						out.println("<script>parent.frames[1].document.getElementById('tue').disabled=false</script>");
					}else if(dat.equals("Wednesday")){
						out.println("<script>parent.frames[1].document.getElementById('wed').disabled=false</script>");
					}else if(dat.equals("Thursday")){
						out.println("<script>parent.frames[1].document.getElementById('thu').disabled=false</script>");
					}else if(dat.equals("Friday")){
						out.println("<script>parent.frames[1].document.getElementById('fri').disabled=false</script>");
					}else if(dat.equals("Saturday")){
						out.println("<script>parent.frames[1].document.getElementById('sat').disabled=false</script>");
					}else if(dat.equals("Sunday")){
						out.println("<script>parent.frames[1].document.getElementById('sun').disabled=false</script>");
					}
				}


					/*if(dat.equals("Monday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(dat.equals("Tuesday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(dat.equals("Wednesday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(dat.equals("Thursday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(dat.equals("Friday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(dat.equals("Saturday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(dat.equals("Sunday"))
								{
									dat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}*/


            /* if(rs.next()){
	         dispStr.append("<table id='id' border='0' cellpadding='0' cellspacing='0'  width='80%'>");
	           do{ 
					dayofweek =  rs.getString(1);
					dayofweek = dayofweek.substring(0, 3);
					//out.println("dayofweek"+dayofweek);
					
					i++;

					
				
				}while(rs.next());

				day_1_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Monday.label","common_labels");
				out.println("sssssssssss:"+day_1_desc);
		        day_2_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Tuesday.label","common_labels");
				day_3_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Wednesday.label","common_labels");
				day_4_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Thursday.label","common_labels");
				day_5_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Friday.label","common_labels");
				day_6_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Saturday.label","common_labels");
				day_7_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Sunday.label","common_labels");
				dispStr.append("<tr><td class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.day.label","common_labels")+"</td>");
				
                dispStr.append("<td class=fields width='7%' align='right'>&nbsp;"+day_1_desc+"<input type='checkbox' name='day_1' id='day_1' value='N' onClick='checkDay(this);' ></td>");
                dispStr.append("<td class=fields width='7%'>"+day_2_desc+"<input type='checkbox' name='day_2' id='day_2' value='N' onClick='checkDay(this);'  ></td>");
				dispStr.append("<td class=fields width='7%'>"+day_3_desc+"<input type='checkbox' name='day_3' id='day_3' value='N' onClick='checkDay(this);'></td>");
				dispStr.append("<td class=fields width='7%'>"+day_4_desc+"<input type='checkbox' name='day_4' id='day_4' value='N' onClick='checkDay(this);'></td>");
                dispStr.append("<td class=fields width='7%'>"+day_5_desc+"<input type='checkbox' name='day_5' id='day_5' value='N' onClick='checkDay(this);'  ></td>");
				dispStr.append("<td class=fields width='7%'>"+day_6_desc+"<input type='checkbox' name='day_6' id='day_6' value='N' onClick='checkDay(this);' ></td>");
                dispStr.append("<td class=fields width='7%'>"+day_7_desc+"<input type='checkbox' name='day_7' id='day_7' value='N' onClick='checkDay(this);' ></td>");


				 //dispStr.append("<td class=fields width='7%'>"+day_7_desc+"<input type='checkbox' //name='day_7' value='"+day_7+"' onClick='checkDay(this);' ></td>");

				dispStr.append("<td class=fields width='7%'></td>");
				dispStr.append("<td class=fields width='7%'></td>");
				dispStr.append("<td class=fields width='7%'></td>");
				dispStr.append("<td class=fields width='7%'></td>");
				dispStr.append("<td class=fields width='7%'></td>");
			   
					  
				dispStr.append("</tr></table>");*/


            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(dispStr.toString()));
            _bw.write(_wl_block10Bytes, _wl_block10);

				//}
		//}

		
}
}


	if(stmt != null)stmt.close();
	if(rs != null) rs.close();


}catch(Exception e) { 
//out.println(e.toString());
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally{
	ConnectionManager.returnConnection(con,request);
}


            _bw.write(_wl_block11Bytes, _wl_block11);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
