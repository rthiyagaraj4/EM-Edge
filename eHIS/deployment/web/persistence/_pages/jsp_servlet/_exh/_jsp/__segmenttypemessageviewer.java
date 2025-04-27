package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import eXH.*;
import webbeans.eCommon.ConnectionManager;
import oracle.sql.ARRAY;
import eXH.XHIdentify;
import java.util.Arrays;
import java.util.regex.Pattern;
import eXH.XHDBAdapter;

public final class __segmenttypemessageviewer extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/SegmentTypeMessageViewer.jsp", 1709122391694L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n  \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<!--head-->\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n \n\n<head> \n\t<link rel=\"StyleSheet\" href=\"../../eXH/html/dtree.css\" type=\"text/css\" />\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t<link rel=\"StyleSheet\" href=\"../../eXH/html/lris_style.css\" type=\"text/css\" />\n\t<link rel=\"StyleSheet\" href=\"../../eXH/html/IeStyle.css\" type=\"text/css\" />\n\n\n<script type=\"text/javascript\" src=\"../../eXH/js/dtree1.js\"></script> \n\n\t<script>\n\t\n\t</script>  \n</head>\n<BODY   >\n<form name=\"view_segment_form\" id=\"view_segment_form\">\n                       \n<div class=\'dtree\'>\n<script type=\'text/javascript\'>\n\td = new dTree(\'d\');\n\td.config.useStatusText=true;\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<body class=\'TREEBODY\'>\n<script> \nvar count=1;\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\ndocument.write(d);\nd.openAll();\n\n\n\nfunction replacefun(str)\n{\nif(str.indexOf(\'+\')!=-1)\n\t{\n\tvar t = /\\+/g; \nstr=str.replace(t,\" \");\n\n    \n\t}\n\telse\n\t{\n\n\t}\n\treturn str;\n}\n\n\n\n</script>\n\n\n\n\n</form>\n\n</body>\n</div>\n</html>\n\n\n\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

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
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

int capval=0;
		String locale = ((String)session.getAttribute("LOCALE"));
		locale = "en"; 
		Connection connection = null;
		Statement  segstatement = null;
		String SegType="";
		String SegName="";
		String prof_id="";
		String Standard_code="";
		String System_def_string="";
		HashMap resultsQry = null;
		HashMap resultssegQry = null;
		prof_id=(String)session.getAttribute("Profile_id");
		SegType=(String)session.getAttribute("Segment_id");
		SegName=(String)session.getAttribute("Segment_name");
		Standard_code=(String)session.getAttribute("stand_code");
		
		Pattern Regex = null;
		ResultSet segset=null;
		
		
		
try
	{
		if(connection==null) connection = ConnectionManager.getConnection();
     
    }
    catch(Exception exp)
    {
		 System.out.println("Error in calling getconnection method of ViewSegmentJSP :"+exp.toString());
		exp.printStackTrace(System.err);
    }
try
{
	
	    resultsQry=XHIdentify.treeHashMap(connection,locale);
	   resultssegQry=XHIdentify.treeSegHashMap(connection,locale); 
	   resultssegQry=XHIdentify.treeSegHashMap(connection,locale); 
	if(prof_id.equals(""))
	{
	  out.println("d.add(0,-1,'"+XHDBAdapter.checkNull(prof_id)+"','','ALL');"); 
	}
	else
	{
	  out.println("d.add(0,-1,'"+XHDBAdapter.checkNull(prof_id)+"','','"+XHDBAdapter.checkNull(prof_id)+"');"); 
	}
	 int count=2; 

out.println("d.add(1,0,'"+SegName+"','','"+SegName+"');"); 

String segmentqry="SELECT SYSTEM_DEFINED_STRING FROM XH_EVENT_SEGMENT_CONFIG WHERE PROFILE_ID ='"+prof_id+"' AND CONFIG_NAME ='"+SegType+"' and STANDARD_CODE='"+Standard_code+"' AND Config_type = 'S'";
//System.out.println("SegmentTypeMessageViewer.jsp segmentqry :"+segmentqry); 

segstatement=connection.createStatement();
segset=segstatement.executeQuery(segmentqry);
		while(segset.next())
	  {
		System_def_string=segset.getString(1);
		String Systemdefstr=System_def_string.replaceAll("#","|");
	 try{
		Regex = Pattern.compile("\\|",Pattern.MULTILINE);
		}
		catch(Exception e)
		{
		System.out.println("(SegmentTypeMessageViewer.jsp:Exception) :"+e);
		}
		String[] array=Regex.split(Systemdefstr);
		for(int check=1;check<array.length;check++)
		{
	
		  if(array[check].equals(""))
		  {
		  }
		  else
		  {
				if(array[check].indexOf("^")!=-1)
			   {			
     
				  try{
						Regex = Pattern.compile("\\^",Pattern.MULTILINE);
					 }
					 catch(Exception e)
					 {
						System.out.println("(SegmentTypeMessageViewer.jsp:Exception) : "+e);
					 } 
                String[] arraycap=Regex.split(array[check]);
             for(int cap=0;cap<arraycap.length;cap++)
		     {
              if(cap==0)
				 {
				  String validation=((String)resultsQry.get(arraycap[cap]))==null?arraycap[cap]:java.net.URLEncoder.encode((String)resultsQry.get(arraycap[cap])); 
                   
                   		 out.println("d.add("+count+",1,replacefun(unescape('"+validation+"')),'','"+arraycap[cap]+"');");
				 capval=count;
		
				}
				else
				 {
					 String validation2=((String)resultsQry.get(arraycap[cap]))==null?arraycap[cap]:java.net.URLEncoder.encode((String)resultsQry.get(arraycap[cap]));
					capval=capval+1; 
				
				   out.println("d.add("+capval+","+count+",replacefun(unescape('"+validation2+"')),'','"+arraycap[cap]+"');");
				 }
		   }
		   count=capval;
		   }
else
				  {
                
					  String validation1=((String)resultsQry.get(array[check]))==null?array[check]:java.net.URLEncoder.encode((String)resultsQry.get(array[check]));
                      if(check==1)
					  {
					  }
					  else
					  {
                         out.println("d.add("+count+",1,replacefun(unescape('"+validation1+"')),'','"+array[check]+"');");
					  }
				  }

				  		count++;
			  }

	} 
		  }

	if(segset!=null)
	{
		segset.close();
	}




	

//out.println("d.add("+count+",2,'"+(String)seg.get(i)+"','','"+(String)seg.get(i)+"');")
	



if(segstatement!=null)
	segstatement.close();
}
catch(Exception exp)
    {
	   exp.printStackTrace(System.err);
    }
	 try{
		ConnectionManager.returnConnection(connection);
	}catch(Exception ex){ System.out.println("Error in closing dbrealted statements in callejb method of SegmentTypeMessageViewer.jsp :"+ex.toString());
		   ex.printStackTrace(System.err); }


            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
