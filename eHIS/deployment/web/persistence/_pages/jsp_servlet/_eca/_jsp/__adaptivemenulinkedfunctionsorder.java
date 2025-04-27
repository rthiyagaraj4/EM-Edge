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

public final class __adaptivemenulinkedfunctionsorder extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/AdaptiveMenuLinkedFunctionsOrder.jsp", 1709115424218L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n<!--\n\tFileName\t: AdaptiveMenuLinkedFunctionsOrder.jsp\n\tVersion\t    : 1.0\t\n\tCreated On\t: 29-06-2009\n\tCreated By\t: Arvind Singh Pal\n\tPurpose     : for CRF-0544-IP\n\n\t-->\n";
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

    private final static java.lang.String  _wl_block6 ="\n<HTML>\n<style>\n\t\tTD.FIRSTSELECTED\n\t\t{\n\t\t\tBACKGROUND-COLOR: #B1C5E9;  \n\t\t\tFONT-SIZE: 9pt ;\n\t\t\tBORDER-STYLE: SOLID;\n\t\t\tborder-left-color: #B2B6D7;\n\t\t\tborder-right-color: #B2B6D7;\n\t\t\tborder-top-color: #E2E3F0;\n\t\t\tborder-bottom-color: #E2E3F0;\n\t\t\theight:18;\t\n\t\t}\n</style>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\t\t\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t\n\t\t<script language=\'javascript\' src=\'../../eCA/js/AdaptiveMenu.js\'></script>\n\t\t<script>\n\t\t\t\tfunction callfun(srlno)\n\t\t\t\t{\n\t\t\t\t\tvar rowId_obj = document.getElementById(\"rowId\");\n\t\t\t\t\t\t\n\t\t\t\t\tfor(i=0;i<rowId_obj.length;i++)\n\t\t\t\t\t{\n\t\t\t\t\t\tfor(j=0;j<rowId_obj[i].cells.length;j++)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(i == (srlno-1))\n\t\t\t\t\t\t\t{\t\n\t\t\t\t\t\t\t\trowId_obj[i].cells[j].className = \"FIRSTSELECTED\";\t\n\t\t\t\t\t\t\t}\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t</script>\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" \n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' >\n\n<script language=javascript>\ndocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\ndocument.body.style.scrollbarArrowColor=\'#000080\';\ndocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\ndocument.body.style.scrollbarHighlightColor=\'white\';\ndocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\ndocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n<form name=\'Linked_form\' id=\'Linked_form\' >\n\n\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'99%\' align=\'center\'>\n<tr ><td class=\'CAGROUP\' align=center><b><font size=\'2\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</b></td></tr>\n</table> \n<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'99%\' align=\'center\'>\n<tr>\n<th width=\'20%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n<!-- <th width=\'30%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th> -->\n<th width=\'60%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n <th width=\'20%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\n</tr>\n\t\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tvar strMesg = getMessage(\"LINK_FUN_MORE_THAN_5\",\"CA\");\n\t\t\t\t\t\t\t\t\tstrMesg = strMesg.replace(\'$$\',\'5\');\n\t\t\t\t\t\t\t\t\talert(strMesg);\n\t\t\t\t\t\t</script>\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' align=\'left\' width=\'40%\'><input type=checkbox ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" name=\'panelVals\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' onClick=\'Reassaign(this)\' ></td>\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n            <tr id=\'last\' >\n\t\t\t<td class=\'\" + classValue + \"\' align=\'center\' width=\'20%\' nowrap >\n\t\t\t<a href=\'javascript:panelposition(\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\",\"X\");onclick=callfun(\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\");\'> ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" </a>\n\t\t\t</td>\n\t\t\t<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>\t\n\n</table>\n\n\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\t\t\n<input type=\"hidden\" name=\"first\" id=\"first\" value=\"\" >\n<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n<input type=\"hidden\" name=\"ql_type\" id=\"ql_type\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n<input type=\"hidden\" name=\"adpt_function_name\" id=\"adpt_function_name\" value=\"\">\n<input type=\"hidden\" name=\"desc\" id=\"desc\" value=\"\">\n<input type=\"hidden\" name=\"eff_status\" id=\"eff_status\" value=\"\">\n<input type=\"hidden\" name=\"eff_status_update\" id=\"eff_status_update\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n<input type=\"hidden\" name=\"enabled_checked_update\" id=\"enabled_checked_update\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n<input type=\"hidden\" name=\"count\" id=\"count\" value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\n\t\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\n</form>\n</body>\n<script>\nfunction showStatus()\n{\n\tvar ql_type = document.Linked_form.ql_type.value;\n\tif(ql_type == \'AM\'){\t\n\tvar eff_update = document.Linked_form.eff_status_update.value;\n\tvar eff_status = parent.f_query_add_mod.document.QuickLink_Form.eff_status;\n\tif(eff_update!=\"\")//IN066387\n    eff_status.value = eff_update;\n\n\tif(eff_status.value == \'E\')\n\t\t{\n\t\t  eff_status.checked = true;\n\t\t}\n\t\telse\n\t\t{\n\t\t\teff_status.checked = false;\n\t\t}\n\t}\n}\nshowStatus();\n</script>\n</html>\n\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

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
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
12/03/2018		IN066387	Kamalakannan G	12/03/2018		Ramesh G			Quick Link enable
---------------------------------------------------------------------------------------------------------------
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
            _bw.write(_wl_block5Bytes, _wl_block5);
            webbeans.eCommon.RecordSet adaptivemenuBean= null;synchronized(session){
                adaptivemenuBean=(webbeans.eCommon.RecordSet)pageContext.getAttribute("adaptivemenuBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(adaptivemenuBean==null){
                    adaptivemenuBean=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("adaptivemenuBean",adaptivemenuBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try
{

	con	= ConnectionManager.getConnection();
	String panel_id="";
	String desc="";
	String id="";
	String description="";
	String classValue="";
	String checkAttribute="checked";
	
	String code="";
	String flag="";
	String mode="";
	String discrete="";
	String mandatory="";
	String mandatory1="";
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
	String sql="";
	String load="";
	String eff_status_update="";
	String enabled_checked_update	= "checked";
	String ql_type	= "";
	String adpt_id	= "";
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

	sql="select  a.DISPLAY_ORDER, a.L_ADPT_FUNCTION_REF, b.ADPT_FUNCTION_NAME  from SM_QUICK_LINK_ADPT_MNU_DTL a,SM_QUICK_LINK_ADPT_MNU b where a.L_ADPT_FUNCTION_REF = b.ADPT_FUNCTION_REF order by a.DISPLAY_ORDER";
	

	mode=(request.getParameter("mode")==null)?"":request.getParameter("mode");
	load=(request.getParameter("load")==null)?"":request.getParameter("load");
	
	ql_type=(request.getParameter("ql_type")==null)?"":request.getParameter("ql_type");
	adpt_id=(request.getParameter("adpt_id")==null)?"":request.getParameter("adpt_id");
	clearvalue=(request.getParameter("clearvalue")==null)?"":request.getParameter("clearvalue");
	removebean=(request.getParameter("removebean")==null)?"N":request.getParameter("removebean");	
	discrete= 
	(request.getParameter("discreteid")==null)?"":request.getParameter("discreteid");
	panel_id = (request.getParameter("id")==null)?"":request.getParameter("id");
	desc = (request.getParameter("description")==null)?"":request.getParameter("description");
	
	if(desc.indexOf("|")!=-1)
	
    {
    for(int i=0;i<desc.length();i++)
	{
	//	if(desc.indexOf("|")!=-1)
			desc=desc.replace('|','+');
	}
	}
	code = (request.getParameter("code")==null)?"":request.getParameter("code");
	flag = (request.getParameter("flag")==null)?"":request.getParameter("flag");
	mandatory = (request.getParameter("mandatory")==null)?"":request.getParameter("mandatory");
	disp_flag = (request.getParameter("disp_flag")==null)?"":request.getParameter("disp_flag");
	change = (request.getParameter("change")==null)?"":request.getParameter("change");
	pos1 = (request.getParameter("pos1")==null)?"":request.getParameter("pos1");
	pos2 = (request.getParameter("pos2")==null)?"":request.getParameter("pos2");
	lastlink = (request.getParameter("lastlink")==null)?"":request.getParameter("lastlink");
	//out.println("<script>alert('flag"+flag+"')</script>");


	String sql1 = "select EFF_STATUS,QUICK_LINK_TYPE from SM_QUICK_LINK_LIST_VW  where QUICK_LINK_REF = ? and QUICK_LINK_TYPE = ?";
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1,adpt_id);
			pstmt.setString(2,ql_type);
			rs = pstmt.executeQuery();


			while(rs.next())
			{
				ql_type = rs.getString("QUICK_LINK_TYPE") == null ? "" : rs.getString("QUICK_LINK_TYPE");
				eff_status_update = rs.getString("EFF_STATUS") == null ? "E" : rs.getString("EFF_STATUS");//IN066387
				


				if(eff_status_update.equals("E"))
				{
					enabled_checked_update = "checked";
				}
				else
				{
					enabled_checked_update = "";
				}

			}
			if(rs != null)  rs.close(); 
			if(pstmt != null)  pstmt.close();
	int sp=0;
	int sptemp1=0;
	int sptemp2=0;
	if(change.equals("Y"))
	{
					
		ArrayList b= new ArrayList();
		b= adaptivemenuBean.getRecordSetHandle();
		int j=Integer.parseInt(pos1);
		sptemp1=Integer.parseInt(pos1);
		sptemp2=Integer.parseInt(pos2);
		int m=(3*j)-3;
		temp_id=b.get(m).toString();
		temp_description=b.get(m+1).toString();
		temp_mandatory1=b.get(m+2).toString();
		
		 sp=(j*3);
		//if(pos1!=pos2){
		adaptivemenuBean.removeObject(m+2);
		adaptivemenuBean.removeObject(m+1);
		adaptivemenuBean.removeObject(m);		
		
		
		int n=Integer.parseInt(pos2);
		int p=(3*n)-3;
		
		int q;
		if(j<n)
		q=p-3;
		else
        q=p;		
		
		if(lastlink.equals("X"))
		{
        adaptivemenuBean.putObject(temp_id);
		adaptivemenuBean.putObject(temp_description);
		adaptivemenuBean.putObject(temp_mandatory1);
		
		}
		else
		{         
		
		adaptivemenuBean.addObject(q,temp_id);
		adaptivemenuBean.addObject(q+1,temp_description);
		adaptivemenuBean.addObject(q+2,temp_mandatory1);
		
		// }
		}
	   
		flag="true";
		
		b.clear();
		}
        		
		
		if(code != null )
		{	
			if(flag.equals("false") )
			{
				int elementSize=adaptivemenuBean.getSize();
				if(elementSize<=3){
					out.println("<script>alert(getMessage('ATLEAST_ONE_LINK_FUN','CA'))</script>");
						
				}
				else{
					if(!code.equals("0"))
				{
				
				int s=Integer.parseInt(code) ;
			     
				adaptivemenuBean.removeObject(s+2);
				adaptivemenuBean.removeObject(s+1);
				adaptivemenuBean.removeObject(s);
					
				 }
				 
				 else
				 {
				      
					  
					int s=Integer.parseInt(code) ;
					adaptivemenuBean.removeObject(s+2);
					adaptivemenuBean.removeObject(s+1); 
					adaptivemenuBean.removeObject(s);
				}
				}
			}
		}
	
	

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

	

	int MaxLinkedRecord=0;
	if(removebean.equals("Y"))
	{
		if(!(panel_id.equals("") && desc.equals("")) )
		
		{
			MaxLinkedRecord=adaptivemenuBean.getSize();			
			if(adaptivemenuBean.containsObject(panel_id)==false )
			
			{
			if(MaxLinkedRecord<15){		
				adaptivemenuBean.putObject(panel_id);
				adaptivemenuBean.putObject(desc);
				adaptivemenuBean.putObject(mandatory);						
				}
				else{
						
            _bw.write(_wl_block15Bytes, _wl_block15);
}
							
			}
			else
			{
							
				if (disp_flag.equals("frompanel"))
				{
					int i = Integer.parseInt(clearvalue);					
					adaptivemenuBean.setObject(i,panel_id);
					adaptivemenuBean.setObject(i+1,desc);
					adaptivemenuBean.setObject(i+2,mandatory);
					
				}
				
				else
					//out.println("<script>alert('APP-002005 Record Already Exists...')</script>");
				out.println("<script>alert(getMessage('CODE_ALREADY_EXISTS','Common'))</script>");

		}
	}

}
	else
	{	
		
		if(load.equals("load")){
			pstmt=con.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			adaptivemenuBean.clearAll();
			while(rs.next()){				
				panel_id=rs.getString("L_ADPT_FUNCTION_REF");			
				desc=rs.getString("ADPT_FUNCTION_NAME");				
				adaptivemenuBean.putObject(panel_id);
				adaptivemenuBean.putObject(desc);	
				adaptivemenuBean.putObject(mandatory);	
	}
		}		
		
	}	

			ArrayList a= new ArrayList();
			a= adaptivemenuBean.getRecordSetHandle();
						           
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
				
				id=a.get(i).toString();
				description=a.get(i+1).toString();
				mandatory1= a.get(i+2).toString();				

				//out.println("<td class='" + classValue + "' align='left' width='30%' nowrap>"+id+"</td>");			
				
				out.println("<td class='" + classValue + "' align='left' width='40%' nowrap>");
				
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(description));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(checkAttribute));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);

				out.println("<input type='hidden' name='id_"+k+"' id='id_"+k+"' value='"+id+"'>");
				out.println("<input type='hidden' name='dispOrder_"+k+"' id='dispOrder_"+k+"' value='"+k+"'>");
				i+=2;
				out.println("</tr>");
				j++;
				k++;
				
				
			}
			a.clear();
			
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(k));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(k));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(k));
            _bw.write(_wl_block24Bytes, _wl_block24);

		

            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(ql_type));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(eff_status_update));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(enabled_checked_update));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(j));
            _bw.write(_wl_block30Bytes, _wl_block30);

 //out.println("<script>alert('before show');</script>");
out.println("<script>showvis('true')</script>");
}
catch(Exception e)
{
	e.printStackTrace();	
}
finally
{
	if (con!= null)
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block31Bytes, _wl_block31);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.LinkedFunc.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SerialNo.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.FunctionRef.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.UncheckToRemove.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }
}
