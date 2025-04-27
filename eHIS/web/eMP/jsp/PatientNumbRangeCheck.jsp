<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<%
	request.setCharacterEncoding("UTF-8");
%>

<%
	Connection con =null;
	PreparedStatement pstmt=null ;
	PreparedStatement pstmt1=null ;
	ResultSet rs=null;
	ResultSet rs1=null;

try{
long rangeval = Long.parseLong(request.getParameter("rangeval"));
long maxrangeval = Long.parseLong(request.getParameter("maxrangeval"));
String pat_ser_grp_code = request.getParameter("pat_ser_grp_code");
String prefix_reqd_yn ="";
long str_num=0l;
long max_num =0l;
int flag=0;
int flag2=0;

	con = ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement("select prefix_reqd_yn,decode(pat_no_ctrl,'Z','S','U','F') sf from mp_pat_ser_grp where pat_ser_grp_code='"+pat_ser_grp_code +"'");
	
	rs=pstmt.executeQuery();

	if( rs != null )
	{
		while( rs.next() )
		{
			prefix_reqd_yn = rs.getString("prefix_reqd_yn")==null?"":rs.getString("prefix_reqd_yn");
			//sf = rs.getString("sf");
		}
	} if(pstmt != null) pstmt.close();
	//added on 29/03/04 to restrict the same range of values cannot be selected for any facility if the numbering control is facility based.
	 pstmt1 = con.prepareStatement("select MP_Pat_NumRange_Check('"+rangeval+"','"+maxrangeval+"','"+pat_ser_grp_code+"','"+prefix_reqd_yn+"') from dual");
	 if(rs!=null) rs.close();
	 rs= pstmt1.executeQuery();
	 
  while(rs.next())
	{
	   flag=rs.getInt(1);
	}     
	if(pstmt1 != null) pstmt1.close();



		if(flag==1)
		{
		%>
<script>
		//parent.frames[1].document.forms[0].submit();
	var errors= getMessage("INV_RANGE","MP")+ "<br>";
	parent.frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + errors+"&error_value="+1;
</script>
<%
	    } 
    
	if (flag==0)
	{

if(prefix_reqd_yn.equals("N"))
{

	String min_max_value="select (min(a.START_SRL_NO)) START_SRL_NO ,(max(a.MAX_SRL_NO)) MAX_SRL_NO from MP_PAT_SER_FACILITY a, mp_pat_ser_grp b where a.PAT_SER_GRP_CODE=b.PAT_SER_GRP_CODE and  b.prefix_reqd_yn ='N'";

	pstmt = con.prepareStatement(min_max_value);
	rs1=pstmt.executeQuery();

	if(rs1 !=null && rs1.next())
	{
		str_num=rs1.getLong("START_SRL_NO");
		max_num=rs1.getLong("MAX_SRL_NO");
	} if(pstmt != null) pstmt.close();

if(((rangeval>=str_num )&& (rangeval<=max_num)) || ((maxrangeval >=str_num) && (maxrangeval<=max_num)) || (rangeval<=str_num ))
{
	flag2=1;
}else
{
	flag2=0;
}

}else
{
	flag2=0;
}

	if(flag2==0) {%>
	<script>
	parent.frames[1].document.forms[0].submit()
	</script> 
<%
	}else { %>
		<script>
	var errors= getMessage("PAT_ID_EXIST_IN_RANGE","MP")+ "<br>";
	parent.frames[3].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + errors+"&error_value="+1;
</script>
<%}
	}
}catch(Exception e) { out.println(e.toString());}
finally
{
	if (pstmt != null) pstmt.close();
	if (pstmt1 != null) pstmt1.close();
	if (rs != null) rs.close();
	if (rs1 !=null) rs1.close();
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

