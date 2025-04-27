package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.HashMap;
import java.util.ArrayList;
import eXH.XHSQLSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eXH.XHDBAdapter;
import java.util.*;
import eXH.XHQueryRender;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __filteringandschedulingapplicationlevel extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/FilteringAndSchedulingApplicationLevel.jsp", 1742466484397L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html> \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<style>\n\tdiv {float: left}\n\t.testSty\n\t{   \n\t \twidth:expression(document.getElementById(\"indicatorTable\").clientWidth-document.getElementById(\"left_child\").clientWidth);\n\t\toverflow: scroll;\n\t}\n</style> \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n<script language=\'JavaScript\' src=\'../../eCommon/js/common.js\'></script>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script Language=\"JavaScript\"  src=\"../../eXH/js/FilterAndSchduleReference.js\" ></script>\n\n<script Language=\"JavaScript\">\nfunction funAction(typ)\n{\n \n\tif(typ==\'N\')\n\t{\n\t\tvar act = \'../../eXH/jsp/FilteringAndSchedulingApplicationLevel.jsp?action_type=N\';\n\t\tthis.document.forms[0].action = act;\n\t\tthis.document.forms[0].target=\"\";\n\t\tthis.document.forms[0].submit();\n\t}  \n\telse\n\t{\n\t\tvar act = \'../../eXH/jsp/FilteringAndSchedulingApplicationLevel.jsp?action_type=P\';\n\t\tthis.document.forms[0].action = act;\n\t\tthis.document.forms[0].target=\"\";\n\t\tthis.document.forms[0].submit();\n\t}\n}  \n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n  \n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\'>\n<form name=\"ProfileRef\" id=\"ProfileRef\" method=\"POST\" action=\'../../eXH/jsp/\' >\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<table name=elTableRow id=elTableRow border=1 cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n <tr>\n ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n <td colspan=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'  align=\"right\" class=\"CAGROUP\" > \n      <A class=\'label\' style=\'cursor:pointer\' onClick=\"funAction(\'P\')\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</A>\n\t  <A class=\'label\'  onClick=\"funAction(\'N\')\" style=\'cursor:pointer\' >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</A>\n      </td>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n </tr>\n <tr>\n      \n ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n\t<td class=\'COLUMNHEADER\' nowrap >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td> \n\t<td class=\'COLUMNHEADER\' nowrap>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\n\t<td class=\'COLUMNHEADER\' nowrap>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" \n\n</tr>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t<script>\n//\talert(\"XH1021\");\nalert(getMessage(\'XH1021\',\'XH\'));\n</script>\n\n\t\t\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" \n\n\t\t\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n<td ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" nowrap>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t<a  href=\" javascript:func1(\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\',\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\',\n\t\t  \'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\');\">&nbsp;\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\n&nbsp;";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t  ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t</td>\n\t\t<td ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" nowrap>&nbsp;";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\t\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n        </td>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t<td ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t</td>\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\t\n    \t</td>\n\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n</tr>\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n <tr>\n</table>\n<table name=elTableRow id=elTableRow border=0 cellspacing=0 cellpadding=3 width=\'100%\' >\n<tr>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" \n<td colspan=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n</td>\n<td align=\"right\">\n<input class=\'button\' type=\'button\'  name=\'Add\' id=\'Add\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' onClick=\"searcheval();\"> </td>\n</tr> \n \n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n</table> \n  <input type=hidden name=filter_group_id id=filter_group_id value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n  <input type=hidden name=Filter_group_code id=Filter_group_code value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
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
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block5Bytes, _wl_block5);
String sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

           ResultSet rsettype = null;
   		   ResultSet rsetsubtype = null;
   		   ResultSet rsetelement = null;
		   PreparedStatement pstmttype = null ;
		   PreparedStatement pstmtsubtype = null ;
		   PreparedStatement pstmtelement = null ;
		   ResultSet resultset = null;
		    String rule=XHDBAdapter.checkNull(request.getParameter("rule"));
			Connection conn = null;
			String[] filtertypequery;
			String[] filtertypeelement;
			String[] filtersubtypeauery;
			String[] elementquery;
			Statement stment=null;
			int columval=0;
		int levelcount=0; 
		String Fileter_group_code=XHDBAdapter.checkNull(request.getParameter("Filter_group_code"));
		System.out.println("FilteringandschedulingApplicationLevel Filter_group_code : "+Fileter_group_code);
	    try
	  {
        if(conn==null) conn = ConnectionManager.getConnection();
      }
    catch(Exception exp)
    {

		 System.out.println("Error in calling getconnection method of FilteringandschedulingApplicationLevel.jsp  :"+exp.toString());
		exp.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();			  
    }
try
{
 stment= conn.createStatement();
 resultset = stment.executeQuery("select count(*) AS rowcount from XH_FILTER_LEVEL_CONFIG where filter_group_code='"+Fileter_group_code+"'");

 resultset.next();
 levelcount = resultset.getInt("rowcount") ;
 if(levelcount!=0)
 {
	filtertypequery=new String[levelcount];
	filtersubtypeauery=new String[levelcount];
	elementquery=new String[levelcount];
	filtertypeelement=new String[levelcount];
 
            _bw.write(_wl_block8Bytes, _wl_block8);

		   int k=0;
		   ResultSet rset = null;
   		    PreparedStatement pstmt = null ;
		  
		   int i=0;
		  try  
		  {  
			ArrayList arrRow = null,arrCol = null;
			String qry_id = "VIEWXHFILTERANDSCDHULINGLEVEL";
			String strstyle="";
			String Wherecause="";
			
			  // Added by prithivi for enotification requirement on 11/05/2016
			      String searchFor = XHDBAdapter.checkNull(request.getParameter("searchFor"));
				  
				  if("QueryFilter".equals(searchFor) && "ENOTIFYFIL".equals(Fileter_group_code))
				  {
					  System.out.println("FilteringAndSchedulingApplicationLevle.jsp::::::::::searchfor value...."+searchFor);
					  String filterLevelType = XHDBAdapter.checkNull(request.getParameter("filter_level_type"));
					  String filterLevelSubtype = XHDBAdapter.checkNull(request.getParameter("filter_level_subtype"));
					  String filterLevelValue = XHDBAdapter.checkNull(request.getParameter("filter_level_value"));
					  String subTypeDesc = XHDBAdapter.checkNull(request.getParameter("filter_level_subtype_desc"));

					  if(subTypeDesc == null)
					     subTypeDesc="";

					  String subTypeDescQuery = XHSQLSet.getSQL(Fileter_group_code).replace("#subTypeDesc",subTypeDesc);  

					  Wherecause=" where FILTER_GROUP_CODE='"+Fileter_group_code+"' and UPPER (filter_level1_type) LIKE upper('%"+filterLevelType+"%') "+
					  " and UPPER (filter_level1_subtype) LIKE upper('%"+filterLevelSubtype+"%') AND UPPER (FILTER_LEVEL1_CODE) LIKE upper('%"+filterLevelValue+"%') "+
					  " AND EXISTS ("+subTypeDescQuery+")";
					  
				  }
				  else
				  {
                      Wherecause=" where FILTER_GROUP_CODE='"+Fileter_group_code+"'  ";
				  }
			 
			System.out.println("FilteringAndSchedulingApplicationLevle.jsp::::::::::where clause...."+Wherecause);
			request.setAttribute(XHQueryRender.strQueryId,qry_id);
			request.setAttribute(XHQueryRender.whereClause,Wherecause);
			request.setAttribute(XHQueryRender.col,"38");
			// Added by prithivi for enotification requirement on 11/05/2016
			if("ENOTIFYFIL".equals(Fileter_group_code))
			{
				request.setAttribute(XHQueryRender.maxRec,"10");
			}
			else{
				request.setAttribute(XHQueryRender.maxRec,"6");
			}
			
			//conn = ConnectionManager.getConnection(request); 
			HashMap resultsQry = XHQueryRender.getResults(request,session,conn,"");
			arrRow = (ArrayList)resultsQry.get("qry_result"); 
			boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
			boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
			String strPrevious =  "Previous";
			String strNext  =  "Next";
			if (boolPrevious == true)
			{
				strPrevious =  "Previous";
			}
			else
			{
				strPrevious = " ";
			}
			if (boolNext== true)
			{
				strNext  =   "Next";
			}
			else
			{
				strNext  = " ";
			}
			 
	
            _bw.write(_wl_block9Bytes, _wl_block9);
int npfra=levelcount*3;
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(npfra));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strPrevious));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strNext));
            _bw.write(_wl_block13Bytes, _wl_block13);
            _bw.write(_wl_block14Bytes, _wl_block14);

	 int q=0;
	 String sql="select B.LEVEL_NUMBER,B.TYPE_QUERY,B.SUBTYPE_QUERY,B.LOOKUP_QUERY,B.FILTER_ELEMENT_TYPE_DESC,B.FILTER_SUBTYPE_DESC,B.ELEMENT_CODE_NAME,A.FACILITY_ID  from XH_FILTER_GROUP A,XH_FILTER_LEVEL_CONFIG B where B.FILTER_GROUP_CODE=A.FILTER_GROUP_CODE and B.FILTER_GROUP_CODE='"+Fileter_group_code+"' ORDER BY 1 ";
	 pstmt = conn.prepareStatement(sql);
	 rset = pstmt.executeQuery();
	 while(rset.next())
	 {
			if(rset.getString(2).toString().trim().indexOf(":FACILITY")!=-1)
			{
              filtertypequery[q]=rset.getString(2).toString().trim().replaceAll(":FACILITY","'"+XHDBAdapter.checkNull(rset.getString(8).toString().trim())+"'");
			}
			else
			{
			filtertypequery[q]=rset.getString(2);
			}
			if(rset.getString(3).toString().trim().indexOf(":FACILITY")!=-1)
			{
			filtersubtypeauery[q]=rset.getString(3).toString().trim().replaceAll(":FACILITY","'"+XHDBAdapter.checkNull(rset.getString(8).toString().trim())+"'");
			}
			else
			{
			filtersubtypeauery[q]=rset.getString(3).toString();
			}
			if(rset.getString(4).toString().trim().indexOf(":FACILITY")!=-1)
			{
			elementquery[q]=rset.getString(4).toString().trim().replaceAll(":FACILITY","'"+XHDBAdapter.checkNull(rset.getString(8).toString().trim())+"'");
			}
			else
			{
			elementquery[q]=rset.getString(4).toString().trim();
			}
			filtertypeelement[q]=rset.getString(7).trim();

q++;

 
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rset.getString(5)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rset.getString(6)));
            _bw.write(_wl_block17Bytes, _wl_block17);

	if((rset.getString(7).trim().indexOf("None")!=-1) || (rset.getString(7).trim().indexOf("none")!=-1))
	{
	}
	else
	{
	
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rset.getString(7)));
            _bw.write(_wl_block17Bytes, _wl_block17);
}
	
            _bw.write(_wl_block1Bytes, _wl_block1);

     }
   if(pstmt!=null)pstmt.close();
   if(rset!=null)rset.close();

            _bw.write(_wl_block19Bytes, _wl_block19);
 
	if(arrRow.size()==0)
	{
if(rule.equals("R"))
		{

            _bw.write(_wl_block20Bytes, _wl_block20);
   }
	}else{
	
            _bw.write(_wl_block1Bytes, _wl_block1);

boolean boolToggle =  true;	
for(i=0;i<arrRow.size();i++)
{

	arrCol = (ArrayList)arrRow.get(i);

	if (boolToggle == true)
		{
			strstyle = "class='QRYEVEN'";
			boolToggle =  false;
		}
		else
		{
			strstyle = "class='QRYODD'";
			boolToggle =  true;
		}


		//filtertypequery[q].

            _bw.write(_wl_block21Bytes, _wl_block21);


	int p=1;
  for(k=0;k<levelcount;k++)
  {
       String sql1=filtertypequery[k].toString().trim(); String sql2=filtersubtypeauery[k].toString().trim();String sql3=elementquery[k].toString().trim();

	   TreeMap tretype=new TreeMap();
	   TreeMap tresubtype=new TreeMap();
       TreeMap treelement=new TreeMap();
     for(int a=1;a<arrCol.size();a++)
	  {
         		   int val=a%4;
          String pastestr=":"+(a);
		
		   if(val==0)
		  {
		  }
		  else if(val==1)
		  {
		     
             sql1=sql1.replaceAll(pastestr,"'"+XHDBAdapter.checkNull((String)arrCol.get(a))+"'");
			 sql2=sql2.replaceAll(pastestr,"'"+XHDBAdapter.checkNull((String)arrCol.get(a))+"'");
			 sql3=sql3.replaceAll(pastestr,"'"+XHDBAdapter.checkNull((String)arrCol.get(a))+"'");

		  }
		  else if(val==2)
	     {
			 
			   sql1=sql1.replaceAll(pastestr,"'"+XHDBAdapter.checkNull((String)arrCol.get(a))+"'");
			   sql2=sql2.replaceAll(pastestr,"'"+XHDBAdapter.checkNull((String)arrCol.get(a))+"'");
			   sql3=sql3.replaceAll(pastestr,"'"+XHDBAdapter.checkNull((String)arrCol.get(a))+"'");
         }
		  else if(val==3)
	     {
			  sql1=sql1.replaceAll(pastestr,"'"+XHDBAdapter.checkNull((String)arrCol.get(a))+"'");
			  sql2=sql2.replaceAll(pastestr,"'"+XHDBAdapter.checkNull((String)arrCol.get(a))+"'");
			  sql3=sql3.replaceAll(pastestr,"'"+XHDBAdapter.checkNull((String)arrCol.get(a))+"'");
         }

	  }
  
  try
	  {
     pstmttype = conn.prepareStatement(sql1);
	 rsettype = pstmttype.executeQuery();
	 while(rsettype.next())
	 {
         tretype.put(rsettype.getString(2).toString().trim(),rsettype.getString(1).toString().trim());
	 }
	 
	  }
	  catch(Exception e)
	  {
        System.out.println("(FilteringAndSchedulingApplicationLevel.jsp:exception) :"+e);
	  }
           finally
	      {
			/**/
	      }
try
	  {
    pstmtsubtype = conn.prepareStatement(sql2);
	 rsetsubtype = pstmtsubtype.executeQuery();
	 while(rsetsubtype.next())
	 {
         tresubtype.put(rsetsubtype.getString(2).toString().trim(),rsetsubtype.getString(1).toString().trim());
	 }
          

	  }
	  catch(Exception e)
	  {
		  System.out.println("(FilteringAndSchedulingApplicationLevel.jsp:Exception-2) :"+e);	 
	  }
	   finally
	      {
			/**/
	      }

    try
	  {

     pstmtelement = conn.prepareStatement(sql3);
	 rsetelement = pstmtelement.executeQuery();
	 while(rsetelement.next())
	 {
         treelement.put(rsetelement.getString(2).toString().trim(),rsetelement.getString(1).toString().trim());
	 }
	
	  }
      catch(Exception e)
	  {
		  System.out.println("(FilteringAndSchedulingApplicationLevel.jsp:exception-3) :"+e);
	  }
	   finally
	      {
			/**/
	      }


            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strstyle));
            _bw.write(_wl_block23Bytes, _wl_block23);
 if(k==0)
 {
	
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf( (String)arrCol.get(0)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( (String)arrCol.get(1)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( (String)arrCol.get(2)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( (String)arrCol.get(3)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( (String)arrCol.get(4)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( (String)arrCol.get(5)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( (String)arrCol.get(6)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( (String)arrCol.get(7)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( (String)arrCol.get(8)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( (String)arrCol.get(9)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( (String)arrCol.get(10)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( (String)arrCol.get(11)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( (String)arrCol.get(12)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( (String)arrCol.get(13)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( (String)arrCol.get(14)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( (String)arrCol.get(15)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( (String)arrCol.get(16)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( (String)arrCol.get(17)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( (String)arrCol.get(18)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( (String)arrCol.get(19)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( (String)arrCol.get(20)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( (String)arrCol.get(21)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((String)arrCol.get(22)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( (String)arrCol.get(23)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( (String)arrCol.get(24)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( (String)arrCol.get(25)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( (String)arrCol.get(26)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( (String)arrCol.get(27)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( (String)arrCol.get(28)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( (String)arrCol.get(29)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( (String)arrCol.get(30)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( (String)arrCol.get(31)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( (String)arrCol.get(32)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( (String)arrCol.get(33)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( (String)arrCol.get(34)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( (String)arrCol.get(35)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( (String)arrCol.get(36)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( (String)arrCol.get(37)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(levelcount));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(tretype.get(XHDBAdapter.checkNull((String)arrCol.get(p)))==null?"":tretype.get(XHDBAdapter.checkNull((String)arrCol.get(p)))));
            _bw.write(_wl_block1Bytes, _wl_block1);

 }
		  else
	  {
			  
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(tretype.get(XHDBAdapter.checkNull((String)arrCol.get(p)))==null?"":tretype.get(XHDBAdapter.checkNull((String)arrCol.get(p)))));
            _bw.write(_wl_block29Bytes, _wl_block29);
}
			 
	p++;

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strstyle));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(tresubtype.get(XHDBAdapter.checkNull((String)arrCol.get(p)))==null?"":tresubtype.get(XHDBAdapter.checkNull((String)arrCol.get(p)))));
            _bw.write(_wl_block32Bytes, _wl_block32);

	p++; 

            _bw.write(_wl_block33Bytes, _wl_block33);

      if((filtertypeelement[k].indexOf("None")!=-1)|| (filtertypeelement[k].indexOf("none")!=-1))
	  {
	  }
	  else
	  {
		  
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(strstyle));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(treelement.get(XHDBAdapter.checkNull((String)arrCol.get(p)))==null?"":treelement.get(XHDBAdapter.checkNull((String)arrCol.get(p)))));
            _bw.write(_wl_block1Bytes, _wl_block1);

	  }
p++;

            _bw.write(_wl_block35Bytes, _wl_block35);

	
p++;

            _bw.write(_wl_block36Bytes, _wl_block36);

	 }	
		if(pstmtelement!=null )
		pstmtelement.close() ;
		if(rsetelement!=null)
		rsetelement.close() ;
		if(pstmtsubtype!=null )
		pstmtsubtype.close() ;
		if(rsetsubtype!=null)
		rsetsubtype.close() ;
		if(pstmttype!=null )
		pstmttype.close() ;
		if(rsettype!=null)
		rsettype.close() ;
			

            _bw.write(_wl_block37Bytes, _wl_block37);

 }
      columval=i;
	  if(rset!=null) rset.close();
      if(pstmt!=null) pstmt.close();
	  
			
	} ///end if 
        }
		catch(Exception exp)
		{
		   System.out.println("Error in FilteringAndSchedulingApplicationLevel.jsp :"+exp.toString());
		   exp.printStackTrace(System.err);
		}
		finally
		{
			ConnectionManager.returnConnection(conn);
		}

            _bw.write(_wl_block38Bytes, _wl_block38);
int npfra2=levelcount*3;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(npfra2));
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

	}

else
	{
	out.println("<script>parent.frames[1].document.forms[0].reset();parent.frames[2].document.location.href='../../eCommon/html/blank.html';parent.frames[3].document.location.href='../../eCommon/html/blank.html';</script>");
	}
resultset.close() ;
stment.close();

	}	
   catch(Exception exp)
    {
		  System.out.println("Error in calling getconnection method of FilteringandschedulingApplicationLevel.jsp  :"+exp.toString());
		exp.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
    }


            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(Fileter_group_code));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(Fileter_group_code));
            _bw.write(_wl_block44Bytes, _wl_block44);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Add.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
