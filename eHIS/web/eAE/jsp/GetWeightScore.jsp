<!DOCTYPE html>

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>

	<html><HEAD>
	<% String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='testform' id='testform'>;

<%
request.setCharacterEncoding("UTF-8");
Connection con=null;
Statement stmt1=null;
	ResultSet rset1=null;
try
{
	con						=	ConnectionManager.getConnection(request);
	String gcs_code			=	request.getParameter("gcs_code");
	String Response_code	=	request.getParameter("Response_code");
	String gcs_score		=	request.getParameter("gcs_score")==null?"":request.getParameter("gcs_score");
	if(gcs_score.equals(""))	gcs_score	=	"0";

	String gcs_weight1 = "";
	String gcs_weight2 = "";
	String gcs_weight3 = "";

	

	%>
	<script>
	function getVal()
	{
		var gcs_weight1	=	parent.frames[3].document.forms[0].gcs_weight1.value;
		var gcs_weight2	=	parent.frames[3].document.forms[0].gcs_weight2.value;
		var gcs_weight3	=	parent.frames[3].document.forms[0].gcs_weight3.value;

		if(gcs_weight1=="")gcs_weight1="0";
		if(gcs_weight2=="")gcs_weight2="0";
		if(gcs_weight3=="")gcs_weight3="0";

		var gcs_score	=	parseFloat(gcs_weight1)+parseFloat(gcs_weight2)+parseFloat(gcs_weight3);
		parent.frames[3].document.forms[0].gcs_score.value=gcs_score;
			var calc_gcs_score = parseFloat(gcs_score);
			if(calc_gcs_score <=3)
				parent.frames[3].document.forms[0].priority.options[1].selected=true;
			else if(calc_gcs_score==4 || calc_gcs_score==5 )
				parent.frames[3].document.forms[0].priority.options[2].selected=true;
			else if(calc_gcs_score==6 || calc_gcs_score==7 || calc_gcs_score==8 )
				parent.frames[3].document.forms[0].priority.options[3].selected=true;
			else if(calc_gcs_score==9 || calc_gcs_score==10 || calc_gcs_score==11 || calc_gcs_score==12)
			{
				parent.frames[3].document.forms[0].priority.options[4].selected=true;
			}
			else if(calc_gcs_score>12)
			{
				parent.frames[3].document.forms[0].priority.options[5].selected=true;
			}
			else if(calc_gcs_score ==0)
			{
				parent.frames[3].document.forms[0].priority.options[0].selected=true;
			}
	}
	</script>
	<%
	if(Response_code.equals("ER"))	
	{
		stmt1=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rset1=stmt1.executeQuery("select *  from ae_gcs_score ");
		if (gcs_code.equals("E1"))
		{	
			while (rset1.next())
			{
				gcs_weight1=rset1.getString("ER_GCS_CODE1_SCORE");
			}
		}
		rset1.beforeFirst();
		if (gcs_code.equals("E2"))
		{
			while (rset1.next())
			{
				gcs_weight1=rset1.getString("ER_GCS_CODE2_SCORE");
			}
		}
		rset1.beforeFirst();
		if (gcs_code.equals("E3"))
		{
			while (rset1.next())
			{
				gcs_weight1=rset1.getString("ER_GCS_CODE3_SCORE");
			}
		}
		rset1.beforeFirst();
		if (gcs_code.equals("E4"))
		{
			while (rset1.next())
			{
				gcs_weight1=rset1.getString("ER_GCS_CODE4_SCORE");
			}
		}
		if(rset1!=null) rset1.close();
		if(stmt1!=null) stmt1.close();
		%>
		<script>
			var score_val='<%=gcs_weight1%>'
			parent.frames[3].document.forms[0].gcs_weight1.value=score_val;
			getVal();
		</script>
		<%
	}
	else if(Response_code.equals("VR"))	
	{
		stmt1=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rset1=stmt1.executeQuery("select *  from ae_gcs_score ");
		if (gcs_code.equals("V1"))
		{	
			while (rset1.next())
			{
				gcs_weight2=rset1.getString("VR_GCS_CODE1_SCORE");
			}
		}
		rset1.beforeFirst();
		if (gcs_code.equals("V2"))
		{
			while (rset1.next())
			{
				gcs_weight2=rset1.getString("VR_GCS_CODE2_SCORE");
			}
		}
		rset1.beforeFirst();
		if (gcs_code.equals("V3"))
		{
			while (rset1.next())
			{
				gcs_weight2=rset1.getString("VR_GCS_CODE3_SCORE");
			}
		}
		rset1.beforeFirst();
		if (gcs_code.equals("V4"))
		{
			while (rset1.next())
			{
				gcs_weight2=rset1.getString("VR_GCS_CODE4_SCORE");
			}
		}
		rset1.beforeFirst();
		if (gcs_code.equals("V5"))
		{
			while (rset1.next())
			{
				gcs_weight2=rset1.getString("VR_GCS_CODE5_SCORE");
			}
		}
		if(rset1!=null) rset1.close();
		if(stmt1!=null) stmt1.close();

		%>
		<script>
			var score_val='<%=gcs_weight2%>'
			parent.frames[3].document.forms[0].gcs_weight2.value=score_val;
			getVal();
		</script>
		<%
	}
	else if(Response_code.equals("MR"))	
	{
		stmt1=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rset1=stmt1.executeQuery("select *  from ae_gcs_score ");
		if (gcs_code.equals("M1"))
		{	
			while (rset1.next())
			{
				gcs_weight3=rset1.getString("MR_GCS_CODE1_SCORE");
			}
		}
		rset1.beforeFirst();
		if (gcs_code.equals("M2"))
		{
			while (rset1.next())
			{
				gcs_weight3=rset1.getString("MR_GCS_CODE2_SCORE");
			}
		}
		rset1.beforeFirst();
		if (gcs_code.equals("M3"))
		{
			while (rset1.next())
			{
				gcs_weight3=rset1.getString("MR_GCS_CODE3_SCORE");
			}
		}
		rset1.beforeFirst();
		if (gcs_code.equals("M4"))
		{
			while (rset1.next())
			{
				gcs_weight3=rset1.getString("MR_GCS_CODE4_SCORE");
			}
		}
		rset1.beforeFirst();
		if (gcs_code.equals("M5"))
		{
			while (rset1.next())
			{
				gcs_weight3=rset1.getString("MR_GCS_CODE5_SCORE");
			}
		}
		rset1.beforeFirst();
		if (gcs_code.equals("M6"))
		{
			while (rset1.next())
			{
				gcs_weight3=rset1.getString("MR_GCS_CODE6_SCORE");
			}
		}
		%>
		<script>
			var score_val='<%=gcs_weight3%>'
			parent.frames[3].document.forms[0].gcs_weight3.value=score_val;
			getVal();
		</script>
		<%
	}
}
catch( Exception e ){e.printStackTrace();}
finally
{
	if(rset1 != null)rset1.close();
	if(stmt1 != null)stmt1.close();
	ConnectionManager.returnConnection(con,request);

}
		%>

</form>
</body>
</html>

