package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __clinicaleventgroupindtabresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ClinicalEventGroupIndTabResult.jsp", 1709115735418L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n<style>\n\t\tTD.FIRSTSELECTED\n\t\t{\n\t\t\tBACKGROUND-COLOR: #B1C5E9;  \n\t\t\tFONT-SIZE: 9pt ;\n\t\t\tBORDER-STYLE: SOLID;\n\t\t\tborder-left-color: #B2B6D7;\n\t\t\tborder-right-color: #B2B6D7;\n\t\t\tborder-top-color: #E2E3F0;\n\t\t\tborder-bottom-color: #E2E3F0;\n\t\t\theight:18;\t\n\t\t}\n</style>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCA/js/ClinicalEventGroup.js\'></script>\n\t\t<script>\n\t\t\t\tfunction callfun(srlno)\n\t\t\t\t{\n\t\t\t\t\tvar rowId_obj = document.getElementById(\"rowId\");\n\t\t\t\t\t\t\n\t\t\t\t\tfor(i=0;i<rowId_obj.length;i++)\n\t\t\t\t\t{\n\t\t\t\t\t\tfor(j=0;j<rowId_obj[i].cells.length;j++)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(i == (srlno-1))\n\t\t\t\t\t\t\t{\t\n\t\t\t\t\t\t\t\trowId_obj[i].cells[j].className = \"FIRSTSELECTED\";\t\n\t\t\t\t\t\t\t}\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t</script>\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" \n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' >\n\n\t<script language=javascript>\ndocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\ndocument.body.style.scrollbarArrowColor=\'#000080\';\ndocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\ndocument.body.style.scrollbarHighlightColor=\'white\';\ndocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n<form name=\'DiscrPanelQueryResult_form\' id=\'DiscrPanelQueryResult_form\' >\n\n\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'99%\' align=\'center\'>\n<tr ><td class=\'CAGROUP\' align=center><b><font size=\'2\'>Associated Event Groups</b></td></tr>\n</table> \n<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'99%\' align=\'center\'>\n<tr>\n<th width=\'20%\'>SrlNo</th>\n<th width=\'30%\'>Contr System</th>\n<th width=\'40%\'>EventGroup</th>\n<th width=\'40%\'>&nbsp&nbsp</th>\n</tr>\n\t\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n            <tr id=\'last\' >\n\t\t\t<td class=\'\" + classValue + \"\' align=\'center\' width=\'20%\' nowrap>\n\t\t\t<a href=\'javascript:panelposition(\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\",\"X\");onclick=callfun(\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\");\'> ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" </a>\n\t\t\t</td>\n\t\t\t<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>\t\n\n</table>\n\t\n\n<input type=\"hidden\" name=\"first\" id=\"first\" value=\"\" >\n<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\n\t\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

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
            webbeans.eCommon.RecordSet EventBean= null;synchronized(session){
                EventBean=(webbeans.eCommon.RecordSet)pageContext.getAttribute("EventBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(EventBean==null){
                    EventBean=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("EventBean",EventBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";



            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

Connection con = null;
//PreparedStatement pstmt = null;
//ResultSet rs = null;

try
{

	con	= ConnectionManager.getConnection();
	String contr="";
	String groupcode="";
	String contrnew="";
	String groupcodenew="";
	String classValue="";
	String checkAttribute="checked";
	
	String code="";
	String flag="";
	String mode="";
	String discrete="";
	String shortdesc="";
	String shortdescnew="";
//	String idupdate="";
//	String descupdate="";
//	String mandatoryupdate="";
	String clearvalue="";
	String disp_flag="";
	String change="";
	String pos1="";
	String pos2="";
	String temp_id="";
	String temp_mandatory1="";
	String temp_description="";
	String removebean="";
	String lastlink="";
	

	mode=(request.getParameter("mode")==null)?"":request.getParameter("mode");
	clearvalue=(request.getParameter("clearvalue")==null)?"":request.getParameter("clearvalue");
	removebean=(request.getParameter("removebean")==null)?"N":request.getParameter("removebean");
	//out.println("<script>alert('clearvalue ="+clearvalue+"')</script>");
	discrete= 
	(request.getParameter("discreteid")==null)?"":request.getParameter("discreteid");
	contr = (request.getParameter("contr")==null)?"":request.getParameter("contr");
	groupcode = (request.getParameter("groupcode")==null)?"":request.getParameter("groupcode");
	code = (request.getParameter("code")==null)?"":request.getParameter("code");
	flag = (request.getParameter("flag")==null)?"":request.getParameter("flag");
	shortdesc = (request.getParameter("shortdesc")==null)?"":request.getParameter("shortdesc");
	disp_flag = (request.getParameter("disp_flag")==null)?"":request.getParameter("disp_flag");
	change = (request.getParameter("change")==null)?"":request.getParameter("change");
	pos1 = (request.getParameter("pos1")==null)?"":request.getParameter("pos1");
	pos2 = (request.getParameter("pos2")==null)?"":request.getParameter("pos2");
	lastlink = (request.getParameter("lastlink")==null)?"":request.getParameter("lastlink");
	//out.println("<script>alert('flag"+flag+"')</script>");
	int sp=0;
	int sptemp1=0;
	int sptemp2=0;
	if(change.equals("Y"))
	{
		
		ArrayList b= new ArrayList();
		b= EventBean.getRecordSetHandle();
		int j=Integer.parseInt(pos1);
		sptemp1=Integer.parseInt(pos1);
		sptemp2=Integer.parseInt(pos2);
		int m=(3*j)-3;
		temp_id=b.get(m).toString();
		temp_description=b.get(m+1).toString();
		temp_mandatory1=b.get(m+2).toString();
		
		 sp=(j*3);
		//if(pos1!=pos2){
		EventBean.removeObject(m+2);
		EventBean.removeObject(m+1);
		EventBean.removeObject(m);
		
		//}
		//out.println("<script>parent.frames[2].location.href=../../eAM/jsp/DiscretePanelQueryCriteriaResult.jsp?mode="+mode+"&change=Y</script>");
		
		int n=Integer.parseInt(pos2);
		int p=(3*n)-3;
		
		int q;
		if(j<n)
		q=p-3;
		else
        q=p;
		
		//ArrayList c= new ArrayList();
		//c= EventBean.getRecordSetHandle();
		
		//int sp1=n*3;
		if(lastlink.equals("X"))
		{

        EventBean.putObject(temp_id);
		EventBean.putObject(temp_description);
		EventBean.putObject(temp_mandatory1);
		
		}
		else
		{
         
		// if(pos1!=pos2){
			// if(sptemp1!=sptemp2){
		EventBean.addObject(q,temp_id);
		EventBean.addObject(q+1,temp_description);
		EventBean.addObject(q+2,temp_mandatory1);
		
		// }
		}
	    
		flag="true";
		
		b.clear();
		}
        		
		
		if(code != null )
		{	
			if(flag.equals("false") )
			{
				if(!code.equals("0"))
				{
				
				int s=Integer.parseInt(code) ;
			     
				EventBean.removeObject(s+2);
				EventBean.removeObject(s+1);
				EventBean.removeObject(s);
					
				 }
				 else
				 {
				      
					  
					int s=Integer.parseInt(code) ;
					EventBean.removeObject(s+2);
					EventBean.removeObject(s+1); 
					EventBean.removeObject(s);
				}
			}
		}
	
	

            _bw.write(_wl_block8Bytes, _wl_block8);

	
	if(removebean.equals("Y"))
	{
		if(!(contr.equals("") && groupcode.equals("")) )
		
		{
				
			if(EventBean.containsObject(groupcode)==false)
			
			{
							
				EventBean.putObject(contr);
				EventBean.putObject(groupcode);
				EventBean.putObject(shortdesc);
							
			}
			else
			{
				if (disp_flag.equals("frompanel"))
				{
					int i = Integer.parseInt(clearvalue);
					
					EventBean.setObject(i,contr);
					EventBean.setObject(i+1,groupcode);
					EventBean.setObject(i+2,shortdesc);
				}
				else
					out.println("<script>alert('APP-002005 Record Already Exists...')</script>");
			}
		}

	}
	else
	{	
		//out.println("<script>alert('change"+change+"')</script>");
		if((!change.equals("Y") && change.equals("") && ( flag.equals("true") || flag.equals("")) ))
		{
			//out.println("<script>alert('inside clear')</script>");
			EventBean.clearAll();
		}
		
	}
	/*	if(mode.equals("update"))
		{	
			//int count=0;
			String sqlupdate="Select DISCR_MSR_ID,short_desc,MANDATORY_YN from am_discr_msr_battery_view where DISCR_MSR_BATTERY_ID=? order by ORDER_SRL_NO";
			pstmt=con.prepareStatement(sqlupdate,ResultSet.TYPE_SCROLL_INSENSITIVE,
											  ResultSet.CONCUR_UPDATABLE);
			
			pstmt.setString(1,discrete);
			rs=pstmt.executeQuery();
			while( rs.next())
			{
				idupdate=(rs.getString("DISCR_MSR_ID")==null)?"":rs.getString("DISCR_MSR_ID");
				descupdate=(rs.getString("short_desc")==null)?"":rs.getString("short_desc");
				mandatoryupdate= (rs.getString("MANDATORY_YN")==null)?"":rs.getString("MANDATORY_YN");
				
				EventBean.putObject(idupdate);
				EventBean.putObject(descupdate);
				EventBean.putObject(mandatoryupdate);
				
			}if(rs!=null) rs.close();
			  if(pstmt!=null) pstmt.close();
		} */
	

			ArrayList a= new ArrayList();
			a= EventBean.getRecordSetHandle();
						           
			int size=0;
			int j=0;
			int k=1;
			size=a.size();
			
			for(int i=0;i<size;i++)
			{
				if ( j % 2 == 0 )
					 classValue = "QRYEVEN" ;
				else
					 classValue = "QRYODD" ;	
			
				
				out.println("<tr id=rowId><td class='" + classValue + "' align='center' width='20%' nowrap><a href='javascript:panelposition("+k+");onclick=callfun("+k+");'> "+k+" </a></td>");
				contrnew=a.get(i).toString();
				groupcodenew=a.get(i+1).toString();
				shortdescnew= a.get(i+2).toString();

				
				out.println("<td class='" + classValue + "' align='left' width='30%' nowrap><A HREF='../../eCA/jsp/ClinicalEventGroupIndTabAddElement.jsp?contr="+java.net.URLEncoder.encode(contrnew)+"&groupcode="+java.net.URLEncoder.encode(groupcodenew)+"&srno="+i+"&shortdesc="+java.net.URLEncoder.encode(shortdescnew)+"&flag=frompanel"+"&mode="+mode+"&clearvalue="+i+"' target=add>"+contrnew+"</a></td>");
				
				out.println("<td class='" + classValue + "' align='left' width='40%' nowrap>"+shortdescnew+"</td>");
				out.println("<td class='" + classValue + "' align='left' width='40%'><input type=checkbox "+checkAttribute+" name='panelVals' id='panelVals' value='"+i+"'onClick='Reassaign(this)' ></td>");
				i+=2;
				out.println("</tr>");
				j++;
				k++;
			
				
			}
			a.clear();
			
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(k));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(k));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(k));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block13Bytes, _wl_block13);

 //out.println("<script>alert('before show');</script>");
out.println("<script>showvis('true')</script>");
}
catch(Exception e)
{
	 //out.println("Exception="+e.toString());//COMMON-ICN-0181
           e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if (con!= null)
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block14Bytes, _wl_block14);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
