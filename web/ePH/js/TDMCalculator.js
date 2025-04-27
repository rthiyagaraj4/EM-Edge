function TdmCalc(obj)
{
var res=0;
var diff=0;	
var thalf=0;
var T = 0;
var Dnew = 0;
var formObj =  document.formTdmCalc;
var txt1=formObj.txt1.value;
var txt2=formObj.txt2.value;
var txt3=formObj.txt3.value;
var txt4 = formObj.txt4.value;
var txt5 = formObj.txt5.value;
diff = (txt1-txt2);
var btnflg = formObj.Kflag.value;

if(checkscript())

{
	
if(txt2!=0 && txt1!=0 && txt3!=0 && btnflg=='K' ) {
   res=(Math.log(txt1/txt2))/txt3;
   res=res.toFixed(3); 
   formObj.Kval.value=res;
   formObj.Keresult.innerText=res;
   document.getElementById('Resunit').innerHTML = "hr<sup>-1</sup>";
   formObj.Reslgnd.style.visibility='visible';
  }
else if(txt2!=0 && txt1!=0 && txt3!=0 && btnflg=='T' ) {
   T= (Math.log(txt1/txt2))/txt3;
   T=T.toFixed(2);
   document.getElementById('Resunit').innerHTML = "hrs";
   formObj.Keresult.innerText=T;
   formObj.Reslgnd.style.visibility='visible';
   } 
else if(txt1!=0 && btnflg=='TH' ) {
	thalf = (0.693/txt1);
   thalf=thalf.toFixed(2);
   document.getElementById('Resunit').innerHTML = "hrs";
   formObj.Keresult.innerText=thalf ;
   formObj.Reslgnd.style.visibility='visible';
   }
else if(txt2!=0 && txt1!=0 && txt3!=0 && btnflg=='V' ) {
   res=(txt3/diff);
   res=res.toFixed(3); 
   formObj.Keresult.innerText=res ;
   document.getElementById('Resunit').innerHTML = "L";
   formObj.Reslgnd.style.visibility='visible';
   }
else if(txt1!=0 && txt2!=0 && txt3!=0 && btnflg=='TR' && txt4!=0 ) {
   Dnew=(txt1*txt2*(1-Math.exp(-(txt3)*(txt4))))/(Math.exp(-(txt3)*(txt4)));
   Dnew=Dnew.toFixed(2); 
   formObj.Keresult.innerText=Dnew ;
   document.getElementById('Resunit').innerHTML = "mg";
   formObj.Reslgnd.style.visibility='visible';
   }
else if(txt1!=0 && txt2!=0 && txt3!=0 && btnflg=='PK' && txt4!=0 ) {
   Dnew=(txt1*txt2*(1-Math.exp(-(txt3)*(txt4))));
   Dnew=Dnew.toFixed(2); 
   formObj.Keresult.innerText=Dnew ;
   document.getElementById('Resunit').innerHTML = "mg";
   formObj.Reslgnd.style.visibility='visible';
   }
else if(txt1!=0 && txt2!=0 && txt3!=0 && btnflg=='WPE' ) {
   res=(Math.log(txt1/txt2))/txt3;
   res=res.toFixed(2); 
   formObj.Keresult.innerText=res;
   document.getElementById('Resunit').innerHTML = "hr<sup>-1</sup>";
   formObj.Reslgnd.style.visibility='visible';
   }
else if(txt1!=0 && txt2!=0 && txt3!=0 && btnflg=='CR' ) {
	if(formObj.male.checked==true)
	{
	res = (1.23*(140-txt1)*(txt2))/txt3;
	}
	else{
    res = (1.04*(140-txt1)*(txt2))/txt3;
	}
	res=res.toFixed(2); 
	formObj.Keresult.innerText=res;
	document.getElementById('Resunit').innerHTML = "ml/min";
	formObj.Reslgnd.style.visibility='visible';
	}
 else if(txt1!=0  && btnflg=='CL' ) {
	res = 8*(txt1)/1000;
	res=res.toFixed(2); 
    formObj.Keresult.innerText=res;
	document.getElementById('Resunit').innerHTML = "L/hr";
	formObj.Reslgnd.style.visibility='visible';
    }
else if(txt1!=0 && txt2!=0 && txt3!=0 && txt4!=0 && txt5!=0 && btnflg=='EMNS' ) {
	res = (txt1*txt2*(txt3/txt4))/txt5;
	res=res.toFixed(2); 
	formObj.Keresult.innerText=res;
	document.getElementById('Resunit').innerHTML = "mg/L";
	formObj.Reslgnd.style.visibility='visible';
	}
else if(txt1!=0 && txt2!=0 && txt3!=0 && txt4!=0 && txt5!=0 && btnflg=='EMXS' ) {
 	res = txt1 + ((txt2*txt3*txt4)/txt5);
    res = res * 1;
	res=res.toFixed(2); 
    formObj.Keresult.innerText=res;
	document.getElementById('Resunit').innerHTML = "mg/L";
	formObj.Reslgnd.style.visibility='visible';
	}
else if(txt1!=0 && txt2!=0 && txt3!=0 && txt4!=0 && txt5!=0 && btnflg=='DS' ) {
	res = ((txt1 *txt2)/(txt4*txt5))/txt3;
    res=res.toFixed(2); 
    formObj.Keresult.innerText=res;
    document.getElementById('Resunit').innerHTML = "mg";
    formObj.Reslgnd.style.visibility='visible';
  }
  else
   {
	alert("Enter the required values")
	return false;
   }

}
}


function dispMal(obj)
{
	var formObj =  document.formTdmCalc;
	if(obj.checked)
	{
     var newHTML = "<br></br><label>CrCl (ml/min)</label>= 1.23  * (140- age ) (weight/Kg)&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<sup>_________________________</sup></br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SeCr(<label  style='font-size:9;'>&mu;</label>mol/L)";
	 document.getElementById('fdisp').innerHTML = newHTML;
	 formObj.female.checked=false;
	}
}

function dispFem(obj)
{
	var formObj =  document.formTdmCalc;
	if(obj.checked)
	{
     var newHTML = "<br></br><label>CrCl (ml/min)</label>= 1.04  * (140- age ) (weight/Kg)&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<sup>_________________________</sup></br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SeCr(<label  style='font-size:9;'>&mu;</label>mol/L)";
	 document.getElementById('fdisp').innerHTML = newHTML;
	 formObj.male.checked=false;
	}
}

function dispFormula(obj)
{
 var formObj =  document.formTdmCalc;
 var res=0;
 var diff=0;	
 var thalf=0;
 var T = 0;
 var age =  "<br></br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style='font-size:1'>&nbsp;</label><label style='font size:10'>age</label>&nbsp;";
 var weght = "<label style='font size:10'>Weight/kg</label>&nbsp;";
 var SeCr = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SeCr&nbsp;";
 var Ke="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style='font-size:1'>&nbsp;&nbsp;</label><label style='font-size:11;'> Ke</label>&nbsp;";
 var Cmax="<label  style='font-size:11;'>C</label><sub>&nbsp;<label  style='font-size:11;'>max exp</label></sub>&nbsp;";
 var Cmin="&nbsp;<label  style='font-size:11;'>C</label><sub>&nbsp;<label  style='font-size:11;'>min exp</label></sub>&nbsp;";
 var Cpost="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label  style='font-size:11;'>C</label><sub>&nbsp;<label  style='font-size:11;'>Post</label></sub><label  style='font-size:1;'>&nbsp;</label>&nbsp;";
 var Cpre="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label  style='font-size:11;'>C</label><sub>&nbsp;<label  style='font-size:11;'>Pre</label></sub><label  style='font-size:1;'>&nbsp;</label>&nbsp;";
 var Vd="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style='font-size:1'>&nbsp;&nbsp;</label><label style='font-size:11;'> Vd</label>&nbsp;";
 var dose="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style='font-size:11'>Dose</label><label style='font-size:1'>&nbsp;</label>&nbsp;";
 var Tlb="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style='font-size:1'>&nbsp;&nbsp;&nbsp;&nbsp;</label><label style='font-size:11'>T ";
 var ke_ftlbl="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ke&nbsp;= Elimination rate constant (hr <sup>-1</sup>)";
 var Cpst_ftlbl="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;C<sub>post<label style='font-size:1'>&nbsp;</label></sub> = Peak concentration (mcg/ml)";
 var Cpre_ftlbl="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;C<sub>pre<label style='font-size:1'>&nbsp;</label></sub>&nbsp;=&nbsp;Trough concentration (mcg/ml)";
 var T_ftlbl="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;T<label style='font-size:1'>&nbsp;&nbsp;&nbsp;</label>=&nbsp;Dosing intervals (hrs)";
 var Vd_ftlbl =  "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Vd&nbsp;= Volume distribution (L/kg)";
 var Cmin_ftlbl= "&nbsp;<label style='font-size:1'>&nbsp;</label>C<sub>min exp</sub>&nbsp;=&nbsp;Expected minimum serum concentration (mcg/ml)";
 var Dnw_ftlbl="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style='font-size:1'>&nbsp;</label>D<sub>new</sub><label style='font-size:9'>&nbsp;</label>=&nbsp;New dose (mg)";
 var Cmx_ftlbl =  "&nbsp;C<sub>max exp</sub><label style='font-size:7'>&nbsp;</label>=&nbsp;Expected maximum serum concentration (mcg/ml)";
 var F_ftlbl = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;F<label style='font-size:9'>&nbsp;</label>= Bioavailability , 1.0";
 var S_ftlbl = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;S<label style='font-size:7'>&nbsp;</label>= Salt factor , 1.0";
 var Cl_ftlbl = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style='font-size:6'>&nbsp;</label>CL<label style='font-size:7'>&nbsp;</label>=&nbsp;Clearance";
 var Cpss_ftlbl="&nbsp;C<sub><label style='font-size:10'>pss max</label></sub><label style='font-size:8'>&nbsp;</label>=&nbsp;Expected maximum serum concentration at &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;steady state (mcg/ml) ";

switch (obj.value)
	{
case "KE":
	var newHTML = "<br></br>Ke (hr <sup>-1</sup>) = ln (C<sub>post</sub>/ C<sub>pre</sub>) <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<sup>____________</sup></br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;T";

	document.getElementById('fdisp').innerHTML = newHTML;
	document.getElementById('Keresult').innerHTML = " ";
	document.getElementById('Resunit').innerHTML = " ";
	document.getElementById('txtlbl_1').innerHTML = Cpost;
	document.getElementById('txtlbl_2').innerHTML = Cpre;
    document.getElementById('txtlbl_3').innerHTML = Tlb;
	document.getElementById('footlbl_1').innerHTML = ke_ftlbl;
	document.getElementById('footlbl_2').innerHTML = Cpre_ftlbl;
	document.getElementById('footlbl_3').innerHTML = Cpst_ftlbl;
	document.getElementById('footlbl_4').innerHTML = T_ftlbl;
	document.getElementById('Reslgnd').innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ke (hr <sup>-1</sup>) &nbsp;&nbsp;= &nbsp;&nbsp;";
    document.formTdmCalc.elements[3].name="Cpost";
	document.formTdmCalc.elements[4].name="Cpre";
	document.formTdmCalc.elements[5].name="T";
	formObj.txt1.value=""
    formObj.txt2.value=""
    formObj.txt3.value=""
    formObj.Kflag.value='K';
    formObj.fdisp.style.visibility='visible';
    formObj.male.style.visibility='hidden';
    formObj.female.style.visibility='hidden';
    formObj.malelb.style.visibility='hidden';
    formObj.femlb.style.visibility='hidden';
	formObj.divtxt_1.style.display ='inline';
	formObj.divtxt_2.style.display ='inline';
	formObj.divtxt_3.style.display ='inline';
    formObj.divtxt_4.style.display ='none';
    formObj.divtxt_5.style.display ='none';	
    formObj.txt1.style.visibility='visible';
    formObj.txt2.style.visibility='visible';
    formObj.txtlbl_1.style.visibility='visible';
    formObj.txtlbl_2.style.visibility='visible';
    formObj.Reslgnd.style.visibility='hidden';
    formObj.txtlbl_4.style.visibility='hidden';
    formObj.txt4.style.visibility='hidden';
    formObj.Ke.style.visibility='visible';
    formObj.txtlbl_3.style.visibility='visible';
    formObj.txtlbl_5.style.visibility='hidden';
    formObj.txt3.style.visibility='visible';
    formObj.txt5.style.visibility='hidden';
    formObj.Keresult.style.visibility='visible';
    formObj.Resunit.style.visibility='visible';
    formObj.footlbl_1.style.visibility='visible';
    formObj.footlbl_2.style.visibility='visible';
    formObj.footlbl_3.style.visibility='visible';
    formObj.footlbl_4.style.visibility='visible';
    formObj.footlbl_5.style.visibility='hidden'; 
    break;

case "DSGINTVL":

	var newHTML = "<br></br>T(hr)&nbsp;=&nbsp;&nbsp;ln(C<sub>Post</sub>/C<sub>Pre</sub>) <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<sup>____________</sup></br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ke";
	document.getElementById('fdisp').innerHTML = newHTML;
	document.getElementById('Resunit').innerHTML = " ";
	document.getElementById('Keresult').innerHTML = " ";
	document.getElementById('txtlbl_1').innerHTML = Cpost;
	document.getElementById('txtlbl_2').innerHTML = Cpre;
	document.getElementById('txtlbl_3').innerHTML =  Ke;
	document.getElementById('footlbl_4').innerHTML =  ke_ftlbl;
	document.getElementById('footlbl_3').innerHTML = Cpre_ftlbl; 
	document.getElementById('footlbl_2').innerHTML = Cpst_ftlbl;
	document.getElementById('footlbl_1').innerHTML = T_ftlbl;
	document.getElementById('Reslgnd').innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;T(hr)&nbsp;=&nbsp;&nbsp;";
    document.formTdmCalc.elements[3].name="Cpost";
	document.formTdmCalc.elements[4].name="Cpre";
	document.formTdmCalc.elements[5].name="Ke";
	formObj.txt1.value="";
    formObj.txt2.value="";
	formObj.txt3.value="";
	formObj.txt4.value="";
    formObj.male.style.visibility='hidden';
    formObj.female.style.visibility='hidden';
    formObj.malelb.style.visibility='hidden';
    formObj.femlb.style.visibility='hidden';
	formObj.divtxt_4.style.display ='none';
    formObj.divtxt_5.style.display ='none';	
	formObj.divtxt_1.style.display ='inline';
	formObj.divtxt_2.style.display ='inline';
	formObj.divtxt_3.style.display ='inline';
    formObj.fdisp.style.visibility='visible';
    formObj.Kflag.value='T';
    formObj.Ke.style.visibility='visible';
	formObj.txt1.style.visibility='visible';
    formObj.txt2.style.visibility='visible';
	formObj.txtlbl_1.style.visibility='visible';
    formObj.txtlbl_2.style.visibility='visible';
	formObj.Reslgnd.style.visibility='hidden';
	formObj.txtlbl_4.style.visibility='hidden';
	formObj.txtlbl_5.style.visibility='hidden';
	formObj.txt5.style.visibility='hidden';
	formObj.txt4.style.visibility='hidden';
	formObj.txtlbl_3.style.visibility='visible';
	formObj.txt3.style.visibility='visible';
	formObj.Keresult.style.visibility='visible';
	formObj.Resunit.style.visibility='visible';
	formObj.footlbl_1.style.visibility='visible';
    formObj.footlbl_2.style.visibility='visible';
    formObj.footlbl_3.style.visibility='visible';
    formObj.footlbl_4.style.visibility='visible';
    formObj.footlbl_5.style.visibility='hidden';
	break;

case "DSGHLF":

	var newHTML = "<br></br>&nbsp;&nbsp;T<sub>1/2</sub>&nbsp;(hr)&nbsp;&nbsp;= &nbsp;&nbsp;&nbsp;0.693<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;<sup>________</sup></br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ke";
	document.getElementById('fdisp').innerHTML = newHTML;
	document.getElementById('Resunit').innerHTML = " ";
    document.getElementById('Keresult').innerHTML = " ";
	document.getElementById('txtlbl_1').innerHTML = Ke;
	document.getElementById('footlbl_2').innerHTML = ke_ftlbl;
	document.getElementById('footlbl_1').innerHTML =T_ftlbl;
	document.getElementById('Reslgnd').innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;T<sub>1/2</sub>&nbsp;(hr)&nbsp;=&nbsp;&nbsp;";
   	document.formTdmCalc.elements[3].name="Ke";
    formObj.txt1.value=""
    formObj.Kflag.value='TH';
	formObj.txt3.value="";
	formObj.male.style.visibility='hidden';
    formObj.female.style.visibility='hidden';
    formObj.malelb.style.visibility='hidden';
    formObj.femlb.style.visibility='hidden';
	//formObj.divtxt_1.style.display ='none';
	formObj.divtxt_2.style.display ='none';
	formObj.divtxt_3.style.display ='none';
    formObj.divtxt_4.style.display ='none';
    formObj.divtxt_5.style.display ='none';	

    

//  formObj.divtxt_3.style.display ='inline';

    formObj.fdisp.style.visibility='visible';
    formObj.Ke.style.visibility='visible';
	formObj.txt1.style.visibility='visible';
    formObj.txt2.style.visibility='hidden';
	formObj.txt3.style.visibility='hidden';
	formObj.txt4.style.visibility='hidden';
	formObj.txt5.style.visibility='hidden';
    formObj.txtlbl_1.style.visibility='visible';
    formObj.txtlbl_2.style.visibility='hidden';
	formObj.txtlbl_3.style.visibility='hidden';
	formObj.txtlbl_5.style.visibility='hidden';
	formObj.Keresult.style.visibility='visible';
	formObj.Resunit.style.visibility='visible';
	formObj.Reslgnd.style.visibility='hidden';
	formObj.txtlbl_4.style.visibility='hidden';
	formObj.footlbl_1.style.visibility='visible';
	formObj.footlbl_2.style.visibility='visible';
	formObj.footlbl_3.style.visibility='hidden';
	formObj.footlbl_4.style.visibility='hidden';
	formObj.footlbl_5.style.visibility='hidden';  
	break;

case "VLDSN":

	var newHTML = "<br></br>&nbsp;&nbsp;Vd&nbsp;&nbsp;=&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Dose<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<sup>______________</sup></br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(&nbsp;&nbsp;C<sub>Post</sub> - C<sub>Pre</sub>&nbsp;&nbsp;)";
	document.getElementById('fdisp').innerHTML = newHTML;
	document.getElementById('Resunit').innerHTML = " ";
    document.getElementById('Keresult').innerHTML = " ";
	document.getElementById('txtlbl_3').innerHTML = dose;
	document.getElementById('txtlbl_1').innerHTML = Cpost;
	document.getElementById('txtlbl_2').innerHTML = Cpre;
  	document.getElementById('footlbl_1').innerHTML = Vd_ftlbl;
	document.getElementById('footlbl_3').innerHTML = Cpre_ftlbl; 
	document.getElementById('footlbl_2').innerHTML = Cpst_ftlbl;
    document.getElementById('Reslgnd').innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Vd&nbsp;=&nbsp;&nbsp;";
    document.formTdmCalc.elements[3].name="Cpost";
	document.formTdmCalc.elements[4].name="Cpre";
	document.formTdmCalc.elements[5].name="Dose";
	formObj.txt1.value="";
	formObj.txt2.value="";
	formObj.txt3.value="";
	formObj.txt4.value="";
    formObj.Kflag.value='V';
	formObj.male.style.visibility='hidden';
    formObj.female.style.visibility='hidden';
    formObj.malelb.style.visibility='hidden';
    formObj.femlb.style.visibility='hidden';
    formObj.divtxt_4.style.display ='none';
    formObj.divtxt_5.style.display ='none';	
	formObj.divtxt_1.style.display ='inline';
	formObj.divtxt_2.style.display ='inline';
	formObj.divtxt_3.style.display ='inline';
    formObj.fdisp.style.visibility='visible';
    formObj.Ke.style.visibility='visible';
    formObj.txt1.style.visibility='visible';
    formObj.txt2.style.visibility='visible';
    formObj.txtlbl_1.style.visibility='visible';
    formObj.txtlbl_2.style.visibility='visible';
    formObj.txtlbl_5.style.visibility='hidden';
	formObj.Reslgnd.style.visibility='hidden';
	formObj.txtlbl_4.style.visibility='hidden';
	formObj.txt4.style.visibility='hidden';
	formObj.txt5.style.visibility='hidden';
	formObj.Keresult.style.visibility='visible';
	formObj.Resunit.style.visibility='visible';
    formObj.txtlbl_3.style.visibility='visible';
	formObj.txt3.style.visibility='visible';
	formObj.footlbl_1.style.visibility='visible';
    formObj.footlbl_2.style.visibility='visible';
    formObj.footlbl_3.style.visibility='visible';
    formObj.footlbl_4.style.visibility='hidden';
    formObj.footlbl_5.style.visibility='hidden'; 
	break;

case "NWTRGH":

     var newHTML = "<br></br>&nbsp;&nbsp;D<sub>new</sub>&nbsp;=&nbsp;(C<sub>min exp</sub>)(Vd)(1-e<sup>-KeT</sup>) <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<sup>_____________________</sup></br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;e<sup>-KeT</sup>&nbsp;";

	document.getElementById('fdisp').innerHTML = newHTML;
	document.getElementById('Resunit').innerHTML = " ";
	document.getElementById('Keresult').innerHTML = " ";
    document.getElementById('txtlbl_1').innerHTML = Cmin;
    document.getElementById('txtlbl_2').innerHTML = Vd;
    document.getElementById('txtlbl_3').innerHTML = Ke;
    document.getElementById('txtlbl_4').innerHTML = Tlb;
	document.getElementById('footlbl_4').innerHTML = ke_ftlbl;
	document.getElementById('footlbl_3').innerHTML = Vd_ftlbl;
	document.getElementById('footlbl_2').innerHTML = Cmin_ftlbl;
	document.getElementById('footlbl_1').innerHTML = Dnw_ftlbl;
	document.getElementById('footlbl_5').innerHTML = T_ftlbl;
	document.getElementById('Reslgnd').innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;D<sub>new</sub>&nbsp;&nbsp;= &nbsp;&nbsp;";
    document.formTdmCalc.elements[3].name="Cmin";
	document.formTdmCalc.elements[4].name="Vd";
	document.formTdmCalc.elements[5].name="Ke";
	document.formTdmCalc.elements[6].name="T";
	formObj.txt1.value="";
	formObj.txt2.value="";
	formObj.txt3.value="";
    formObj.txt4.value="";
	formObj.male.style.visibility='hidden';
    formObj.female.style.visibility='hidden';
    formObj.malelb.style.visibility='hidden';
    formObj.femlb.style.visibility='hidden';
	formObj.divtxt_1.style.display ='inline';
	formObj.divtxt_2.style.display ='inline';
    formObj.divtxt_3.style.display ='inline';
	formObj.divtxt_4.style.display ='inline';
	formObj.fdisp.style.visibility='visible';
    formObj.Kflag.value='TR';
    formObj.Ke.style.visibility='visible';
	formObj.Reslgnd.style.visibility='hidden';
    formObj.txtlbl_1.style.visibility='hidden';
    formObj.txtlbl_2.style.visibility='hidden';
	formObj.txtlbl_3.style.visibility='visible';
	formObj.txtlbl_4.style.visibility='visible';
	formObj.txtlbl_5.style.visibility='hidden';
	formObj.divtxt_1.style.display ='inline';
	formObj.divtxt_2.style.display ='inline';
	formObj.Keresult.style.visibility='visible';
	formObj.Keresult.style.visibility='visible';
	formObj.Resunit.style.visibility='visible';
	formObj.txt1.style.visibility='visible';
    formObj.txt2.style.visibility='visible';
	formObj.txt3.style.visibility='visible';
	formObj.txt4.style.visibility='visible';
	formObj.txt5.style.visibility='hidden';
    formObj.txtlbl_1.style.visibility='visible';
    formObj.txtlbl_2.style.visibility='visible';
    formObj.Reslgnd.style.visibility='hidden';
	formObj.footlbl_1.style.visibility='visible';
    formObj.footlbl_2.style.visibility='visible';
    formObj.footlbl_3.style.visibility='visible';
    formObj.footlbl_4.style.visibility='visible';
	formObj.footlbl_5.style.visibility='visible';
    break;

case "NWPK":
	
	var newHTML = "D<sub>new</sub>&nbsp;=&nbsp;(C<sub>max exp</sub>)(Vd)(1-e<sup>-KeT</sup>) </sup></TR>";
	document.getElementById('fdisp').innerHTML = newHTML;
	document.getElementById('Resunit').innerHTML = " ";
	document.getElementById('Keresult').innerHTML = " ";
    document.getElementById('txtlbl_1').innerHTML = Cmax;
    document.getElementById('txtlbl_2').innerHTML = Vd;
    document.getElementById('txtlbl_3').innerHTML = Ke;
    document.getElementById('txtlbl_4').innerHTML = Tlb;
	document.getElementById('footlbl_4').innerHTML = ke_ftlbl;
	document.getElementById('footlbl_3').innerHTML = Vd_ftlbl;
	document.getElementById('footlbl_2').innerHTML = Cmx_ftlbl;
	document.getElementById('footlbl_1').innerHTML = Dnw_ftlbl;
	document.getElementById('footlbl_5').innerHTML = T_ftlbl;
	document.getElementById('Reslgnd').innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;D<sub>new</sub>&nbsp;&nbsp;= &nbsp;&nbsp;";
    document.formTdmCalc.elements[3].name="Cmax";
	document.formTdmCalc.elements[4].name="Vd";
	document.formTdmCalc.elements[5].name="Ke";
	document.formTdmCalc.elements[6].name="T";
    formObj.fdisp.style.visibility='visible';
    formObj.Kflag.value='PK';
    formObj.txt1.value="";
	formObj.txt2.value="";
	formObj.txt3.value="";
	formObj.txt4.value="";
	formObj.divtxt_1.style.display ='inline';
	formObj.divtxt_2.style.display ='inline';
	formObj.divtxt_3.style.display ='inline';
	formObj.divtxt_4.style.display ='inline';
	formObj.Ke.style.visibility='visible';
	formObj.txtlbl_3.style.visibility='hidden';
	formObj.Reslgnd.style.visibility='hidden';
	formObj.txt1.style.visibility='visible';
    formObj.txt2.style.visibility='visible';
    formObj.txt3.style.visibility='visible';
    formObj.txt4.style.visibility='visible';
	formObj.txt5.style.visibility='hidden';
	formObj.divtxt_1.style.display ='inline';
	formObj.divtxt_2.style.display ='inline';
    formObj.txtlbl_1.style.visibility='visible';
    formObj.txtlbl_2.style.visibility='visible';
    formObj.Resunit.style.visibility='visible';
    formObj.txtlbl_3.style.visibility='visible';
	formObj.txtlbl_4.style.visibility='visible';
	formObj.txtlbl_5.style.visibility='hidden';
	formObj.Keresult.style.visibility='visible';
	formObj.footlbl_1.style.visibility='visible';
    formObj.footlbl_2.style.visibility='visible';
    formObj.footlbl_3.style.visibility='visible';
    formObj.footlbl_4.style.visibility='visible';
	formObj.footlbl_5.style.visibility='visible';
    break;

case "WTHLDPRE":
 
	
	var newHTML = "<br><label>Pre Level<br></br>Withold time (hr) = ln(C<sub>Pre</sub> /C<sub>min exp</sub> )&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<sup>_______________</sup></br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ke";
	document.getElementById('fdisp').innerHTML = newHTML;
	document.getElementById('Resunit').innerHTML = " ";
	document.getElementById('Keresult').innerHTML = " ";
    document.getElementById('txtlbl_1').innerHTML = Cpre;
    document.getElementById('txtlbl_2').innerHTML =Cmin;
    document.getElementById('txtlbl_3').innerHTML = Ke;
  	document.getElementById('footlbl_3').innerHTML =  ke_ftlbl;
	document.getElementById('footlbl_2').innerHTML = Cmin_ftlbl;
	document.getElementById('footlbl_1').innerHTML = Cpre_ftlbl;
	document.getElementById('Reslgnd').innerHTML = "Withhold Time(hr) = &nbsp;&nbsp;";
    document.formTdmCalc.elements[3].name="Cpre";
	document.formTdmCalc.elements[4].name="Cmin";
	document.formTdmCalc.elements[5].name="Ke";
    formObj.fdisp.style.visibility='visible';
    formObj.Kflag.value='WPE';
    formObj.txt1.value="";
	formObj.txt2.value="";
	formObj.txt3.value="";
	formObj.txt4.value="";
    formObj.male.style.visibility='hidden';
    formObj.female.style.visibility='hidden';
    formObj.malelb.style.visibility='hidden';
    formObj.femlb.style.visibility='hidden';
	formObj.divtxt_1.style.display ='inline';
	formObj.divtxt_2.style.display ='inline';
	formObj.divtxt_3.style.display ='inline';
    formObj.divtxt_4.style.display ='none';
    formObj.divtxt_5.style.display ='none';
	formObj.Ke.style.visibility='visible';
	formObj.txtlbl_3.style.visibility='hidden';
	formObj.Reslgnd.style.visibility='hidden';
	formObj.txt1.style.visibility='visible';
    formObj.txt2.style.visibility='visible';
    formObj.txt3.style.visibility='visible';
    formObj.txt4.style.visibility='hidden';
	formObj.txt5.style.visibility='hidden';
	formObj.divtxt_1.style.display ='inline';
	formObj.divtxt_2.style.display ='inline';
    formObj.txtlbl_1.style.visibility='visible';
    formObj.txtlbl_2.style.visibility='visible';
    formObj.Resunit.style.visibility='visible';
    formObj.txtlbl_3.style.visibility='visible';
	formObj.txtlbl_4.style.visibility='hidden';
    formObj.txtlbl_5.style.visibility='hidden';
	formObj.Keresult.style.visibility='visible';
	formObj.footlbl_1.style.visibility='visible';
    formObj.footlbl_2.style.visibility='visible';
    formObj.footlbl_3.style.visibility='visible';
    formObj.footlbl_4.style.visibility='hidden';
	formObj.footlbl_5.style.visibility='hidden';
    break;

case "WTHLDPOST":

	var newHTML = "<br><label>Post Level<br></br>Withold time (hr) = ln(C<sub>Post</sub> /C<sub>max exp</sub> )&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<sup>_______________</sup></br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ke";
	document.getElementById('fdisp').innerHTML = newHTML;
	document.getElementById('Resunit').innerHTML = " ";
	document.getElementById('Keresult').innerHTML = " ";
    document.getElementById('txtlbl_1').innerHTML = Cpost;
    document.getElementById('txtlbl_2').innerHTML = Cmax;
    document.getElementById('txtlbl_3').innerHTML = Ke;
 	document.getElementById('footlbl_3').innerHTML = ke_ftlbl;
	document.getElementById('footlbl_2').innerHTML = Cmx_ftlbl;
	document.getElementById('footlbl_1').innerHTML = Cpst_ftlbl;
	document.getElementById('Reslgnd').innerHTML = "Withhold Time(hr) = &nbsp;&nbsp;";
    document.formTdmCalc.elements[3].name="Cpost";
	document.formTdmCalc.elements[4].name="Cmax";
	document.formTdmCalc.elements[5].name="Ke";
    formObj.fdisp.style.visibility='visible';
    formObj.Kflag.value='WPE';
    formObj.txt1.value="";
	formObj.txt2.value="";
	formObj.txt3.value="";
	formObj.txt4.value="";
    formObj.male.style.visibility='hidden';
    formObj.female.style.visibility='hidden';
	formObj.malelb.style.visibility='hidden';
    formObj.femlb.style.visibility='hidden';
    formObj.divtxt_4.style.display ='none';
    formObj.divtxt_5.style.display ='none';
	formObj.divtxt_1.style.display ='inline';
	formObj.divtxt_2.style.display ='inline';
	formObj.divtxt_3.style.display ='inline';
	formObj.Ke.style.visibility='visible';
	formObj.txtlbl_3.style.visibility='hidden';
	formObj.Reslgnd.style.visibility='hidden';
	formObj.txt1.style.visibility='visible';
    formObj.txt2.style.visibility='visible';
    formObj.txt3.style.visibility='visible';
    formObj.txt4.style.visibility='hidden';
	formObj.txt5.style.visibility='hidden';
    formObj.txtlbl_1.style.visibility='visible';
    formObj.txtlbl_2.style.visibility='visible';
    formObj.Resunit.style.visibility='visible';
    formObj.txtlbl_3.style.visibility='visible';
	formObj.txtlbl_4.style.visibility='hidden';
    formObj.txtlbl_5.style.visibility='hidden';
	formObj.Keresult.style.visibility='visible';
	formObj.footlbl_1.style.visibility='visible';
    formObj.footlbl_2.style.visibility='visible';
    formObj.footlbl_3.style.visibility='visible';
    formObj.footlbl_4.style.visibility='hidden';
	formObj.footlbl_5.style.visibility='hidden';
    break;
/*
case "WTHLDPREPST":

	var newHTML = "<br><label>Pre & Post Level <br></br>Withold time (hr) = ln(C<sub>Post</sub> @ C<sub>Pre</sub>/C<sub>max exp</sub>@ C<sub>min exp</sub>)&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<sup>_______________________________</sup></br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ke";
	document.getElementById('fdisp').innerHTML = newHTML;
	document.getElementById('Resunit').innerHTML = " ";
	document.getElementById('Keresult').innerHTML = " ";
    document.getElementById('txtlbl_1').innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;C<sub>Post</sub>&nbsp;";
    document.getElementById('txtlbl_2').innerHTML = "C<sub>man exp</sub>";
    document.getElementById('txtlbl_3').innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ke&nbsp;";
    //document.getElementById('txtlbl_4').innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;T&nbsp;";


	document.getElementById('footlbl_4').innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ke&nbsp;&nbsp;= Elimination rate constant (hr <sup>-1</sup>)";
	document.getElementById('footlbl_3').innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Vd&nbsp;&nbsp;= Volume distribution (L/kg)";
	document.getElementById('footlbl_2').innerHTML = "&nbsp;&nbsp;C<sub>maxexp</sub>&nbsp;=&nbsp;Expected maximum serum concentration (mcg/ml)";
	document.getElementById('footlbl_1').innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;D<sub>new</sub>&nbsp;=&nbsp;New dose (mg)";
	document.getElementById('footlbl_5').innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;T&nbsp;&nbsp;= Dosing intervals (hrs)";
	document.getElementById('Reslgnd').innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;D<sub>new</sub>&nbsp;&nbsp;= &nbsp;&nbsp;";

    formObj.fdisp.style.visibility='visible';
    formObj.Kflag.value='PK';
    formObj.txt1.value="";
	formObj.txt2.value="";
	formObj.txt3.value="";
	formObj.txt4.value="";
	formObj.male.style.visibility='hidden';
    formObj.female.style.visibility='hidden';
    formObj.malelb.style.visibility='hidden';
    formObj.femlb.style.visibility='hidden';
	formObj.Ke.style.visibility='visible';
	formObj.txtlbl_3.style.visibility='hidden';
	formObj.Reslgnd.style.visibility='hidden';
	formObj.txt1.style.visibility='visible';
    formObj.txt2.style.visibility='visible';
    formObj.txt3.style.visibility='visible';
    formObj.txt4.style.visibility='hidden';
	formObj.txt5.style.visibility='hidden';
    formObj.txtlbl_1.style.visibility='visible';
    formObj.txtlbl_2.style.visibility='visible';
    formObj.Resunit.style.visibility='visible';
    formObj.txtlbl_3.style.visibility='visible';
	formObj.txtlbl_4.style.visibility='hidden';
    formObj.txtlbl_5.style.visibility='hidden';
	formObj.Keresult.style.visibility='visible';
	formObj.footlbl_1.style.visibility='visible';
    formObj.footlbl_2.style.visibility='visible';
    formObj.footlbl_3.style.visibility='visible';
    formObj.footlbl_4.style.visibility='visible';
	formObj.footlbl_5.style.visibility='visible';
	break;
*/

case "CRCL":

	var newHTML = "<br></br><label>CrCl (ml/min)</label>= 1.23  * (140- age ) (weight/Kg)&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<sup>_________________________</sup></br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SeCr(<label  style='font-size:9;'>&mu;</label>mol/L)";
	document.getElementById('fdisp').innerHTML = newHTML;
	document.getElementById('Resunit').innerHTML = " ";
	document.getElementById('Keresult').innerHTML = " ";
    document.getElementById('txtlbl_1').innerHTML = age;
    document.getElementById('txtlbl_2').innerHTML = weght;
    document.getElementById('txtlbl_3').innerHTML = SeCr;
 	document.getElementById('footlbl_4').innerHTML = ke_ftlbl;
	document.getElementById('footlbl_3').innerHTML = Vd_ftlbl;
	document.getElementById('footlbl_2').innerHTML = Cmx_ftlbl;
	document.getElementById('footlbl_1').innerHTML = Dnw_ftlbl;
	document.getElementById('footlbl_5').innerHTML = T_ftlbl;
	document.getElementById('Reslgnd').innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style='font-size:11'>CrCl&nbsp;&nbsp;= &nbsp;&nbsp;";
    document.formTdmCalc.elements[3].name="age";
	document.formTdmCalc.elements[4].name="weight";
	document.formTdmCalc.elements[5].name="SeCr";
	formObj.divtxt_1.style.display ='inline';
	formObj.divtxt_2.style.display ='inline';
	formObj.divtxt_3.style.display ='inline';
    formObj.divtxt_4.style.display ="none";
	formObj.divtxt_5.style.display ="none";
    formObj.fdisp.style.visibility='visible';
    formObj.Kflag.value='CR';
    formObj.txt1.value="";
	formObj.txt2.value="";
	formObj.txt3.value="";
	formObj.txt4.value="";
	formObj.male.style.visibility='visible';
    formObj.female.style.visibility='visible';
    formObj.malelb.style.visibility='visible';
    formObj.femlb.style.visibility='visible';
    formObj.Ke.style.visibility='visible';
	formObj.txtlbl_3.style.visibility='hidden';
	formObj.Reslgnd.style.visibility='hidden';
	formObj.txt1.style.visibility='visible';
    formObj.txt2.style.visibility='visible';
    formObj.txt3.style.visibility='visible';
    formObj.txt4.style.visibility='hidden';
	formObj.txt5.style.visibility='hidden';
    formObj.txtlbl_1.style.visibility='visible';
    formObj.txtlbl_2.style.visibility='visible';
    formObj.Resunit.style.visibility='visible';
    formObj.txtlbl_3.style.visibility='visible';
	formObj.txtlbl_4.style.visibility='hidden';
	formObj.txtlbl_5.style.visibility='hidden';
	formObj.Keresult.style.visibility='visible';
	formObj.footlbl_1.style.visibility='visible';
    formObj.footlbl_2.style.visibility='visible';
    formObj.footlbl_3.style.visibility='visible';
    formObj.footlbl_4.style.visibility='visible';
	formObj.footlbl_5.style.visibility='visible';
	break;

case "CLA":
	var newHTML = "<br></br><label>8 (ml/kg/hr) x body weight (kg)  &nbsp;<br>&nbsp;&nbsp;&nbsp;<sup>___________________________</sup></br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1000</label>";
	document.getElementById('fdisp').innerHTML = newHTML;
	document.getElementById('Resunit').innerHTML = " ";
	document.getElementById('Keresult').innerHTML = " ";
    document.getElementById('txtlbl_1').innerHTML = "<label  style='font-size:11;'>body weight&nbsp;";
 	document.getElementById('footlbl_1').innerHTML = Cl_ftlbl ;
	document.getElementById('Reslgnd').innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CL (L/hr) &nbsp;&nbsp;= &nbsp;&nbsp;";
    //document.formTdmCalc.elements[3].name="Cpre";
	document.formTdmCalc.elements[3].name="Body weight";
	//document.formTdmCalc.elements[5].name="Ke";
    formObj.fdisp.style.visibility='visible';
    formObj.Kflag.value='CL';
    formObj.txt1.value="";
	formObj.txt2.value="";
	formObj.txt3.value="";
	formObj.txt4.value="";
	formObj.divtxt_2.style.display ='none';
    formObj.divtxt_3.style.display ='none';	
	formObj.divtxt_4.style.display ='none';
    formObj.divtxt_5.style.display ='none';	
	formObj.male.style.visibility='hidden';
    formObj.female.style.visibility='hidden';
    formObj.malelb.style.visibility='hidden';
    formObj.femlb.style.visibility='hidden';
	formObj.Ke.style.visibility='visible';
	formObj.txtlbl_3.style.visibility='hidden';
	formObj.Reslgnd.style.visibility='hidden';
	formObj.txt1.style.visibility='visible';
	formObj.txt2.style.visibility='hidden';
    formObj.txt3.style.visibility='hidden';
    formObj.txt4.style.visibility='hidden';
	formObj.txt5.style.visibility='hidden';
    formObj.txtlbl_1.style.visibility='visible';
	formObj.txtlbl_2.style.visibility='hidden';
    formObj.txtlbl_3.style.visibility='hidden';
	formObj.txtlbl_4.style.visibility='hidden';
    formObj.txtlbl_5.style.visibility='hidden';
	formObj.Resunit.style.visibility='visible';
	formObj.Keresult.style.visibility='visible';
	formObj.footlbl_1.style.visibility='visible';
    formObj.footlbl_2.style.visibility='hidden';
    formObj.footlbl_3.style.visibility='hidden';
    formObj.footlbl_4.style.visibility='hidden';
	formObj.footlbl_5.style.visibility='hidden';
	
    break;

case "MINS":
	
	var newHTML = "<br></br><label>C&nbsp;<sub>pss min</sub> (mg/L)  = (S)(F)(Dose/T)  &nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<sup>_____________</sup></br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CL</label>";
	document.getElementById('fdisp').innerHTML = newHTML;
	document.getElementById('Resunit').innerHTML = " ";
	document.getElementById('Keresult').innerHTML = " ";
    document.getElementById('txtlbl_1').innerHTML ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style='font-size:11'>S ";
    document.getElementById('txtlbl_2').innerHTML ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style='font-size:1'>&nbsp;</label><label style='font-size:12'>F ";
    document.getElementById('txtlbl_3').innerHTML =  dose;
    document.getElementById('txtlbl_4').innerHTML ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style='font-size:1'>&nbsp;&nbsp;&nbsp;&nbsp;</label><label style='font-size:11'>T ";
	document.getElementById('txtlbl_5').innerHTML ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style='font-size:10'>CL&nbsp;";
	document.getElementById('footlbl_1').innerHTML = "&nbsp;&nbsp;C<sub><label style='font-size:10'>pss min</label></sub><label style='font-size:8'>&nbsp;</label>=&nbsp;Expected minimum serum concentration at &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;steady state (mcg/ml) ";
	document.getElementById('footlbl_2').innerHTML =S_ftlbl;
	document.getElementById('footlbl_3').innerHTML = F_ftlbl;
	document.getElementById('footlbl_4').innerHTML =T_ftlbl
	document.getElementById('footlbl_5').innerHTML = Cl_ftlbl;
	document.getElementById('Reslgnd').innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;C<sub>pss min</sub> &nbsp;(mg/L)&nbsp;= &nbsp;&nbsp;";
     document.formTdmCalc.elements[3].name="S";
	document.formTdmCalc.elements[4].name="F";
	document.formTdmCalc.elements[5].name="dose";
	document.formTdmCalc.elements[6].name="T";
	document.formTdmCalc.elements[7].name="CL";
    formObj.fdisp.style.visibility='visible';
    formObj.Kflag.value='EMNS';
    formObj.txt1.value="";
	formObj.txt2.value="";
	formObj.txt3.value="";
	formObj.txt4.value="";
	formObj.txt5.value="";
	formObj.male.style.visibility='hidden';
    formObj.female.style.visibility='hidden';
    formObj.malelb.style.visibility='hidden';
    formObj.femlb.style.visibility='hidden';
	formObj.divtxt_2.style.display ='inline';
	formObj.divtxt_3.style.display ='inline';
    formObj.divtxt_4.style.display ='inline';
	formObj.divtxt_5.style.display ='inline';
	formObj.Ke.style.visibility='visible';
	formObj.txtlbl_3.style.visibility='hidden';
	formObj.Reslgnd.style.visibility='hidden';
	formObj.txt1.style.visibility='visible';
    formObj.txt2.style.visibility='visible';
    formObj.txt3.style.visibility='visible';
    formObj.txt4.style.visibility='visible';
	formObj.txt5.style.visibility='visible';
    formObj.txtlbl_1.style.visibility='visible';
    formObj.txtlbl_2.style.visibility='visible';
    formObj.Resunit.style.visibility='visible';
    formObj.txtlbl_3.style.visibility='visible';
	formObj.txtlbl_4.style.visibility='visible';
	formObj.txtlbl_5.style.visibility='visible';
	formObj.Keresult.style.visibility='visible';
	formObj.footlbl_1.style.visibility='visible';
    formObj.footlbl_2.style.visibility='visible';
    formObj.footlbl_3.style.visibility='visible';
    formObj.footlbl_4.style.visibility='visible';
	formObj.footlbl_5.style.visibility='visible';
	break;

case "MAXS":
	
	var newHTML = "<br></br><label>C&nbsp;<sub>pss max</sub> (mg/L)  = [ C&nbsp;<sub>pss min</sub> ]  +  [&nbsp;(S)&nbsp;(F)&nbsp;(Dose)&nbsp;/&nbsp;Vd&nbsp;]</label>";
	document.getElementById('fdisp').innerHTML = newHTML;
	document.getElementById('Resunit').innerHTML = " ";
	document.getElementById('Keresult').innerHTML = " ";
    document.getElementById('txtlbl_2').innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style='font-size:11'>S ";
    document.getElementById('txtlbl_3').innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style='font-size:1'>&nbsp;</label><label style='font-size:12'>F ";
    document.getElementById('txtlbl_4').innerHTML = dose;
    document.getElementById('txtlbl_5').innerHTML = Vd;
	document.getElementById('txtlbl_1').innerHTML = "&nbsp;&nbsp;<label style='font-size:11'>C</label><label style='font-size:11'><sub>pss min</sub></label>&nbsp;";
	document.getElementById('footlbl_1').innerHTML = Cpss_ftlbl;
	document.getElementById('footlbl_2').innerHTML = S_ftlbl;
	document.getElementById('footlbl_3').innerHTML = F_ftlbl;
	document.getElementById('footlbl_4').innerHTML = T_ftlbl;
	document.getElementById('footlbl_5').innerHTML = Vd_ftlbl;
	document.getElementById('Reslgnd').innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;C<sub>pss max</sub> &nbsp;(mg/L)&nbsp;= &nbsp;&nbsp;";
    document.formTdmCalc.elements[3].name="Cpss min";
	document.formTdmCalc.elements[4].name="S";
	document.formTdmCalc.elements[5].name="F";
	document.formTdmCalc.elements[6].name="Dose";
	document.formTdmCalc.elements[7].name="Vd";
    formObj.fdisp.style.visibility='visible';
    formObj.Kflag.value='EMXS';
    formObj.txt1.value="";
	formObj.txt2.value="";
	formObj.txt3.value="";
	formObj.txt4.value="";
	formObj.txt5.value="";
	formObj.male.style.visibility='hidden';
    formObj.female.style.visibility='hidden';
    formObj.malelb.style.visibility='hidden';
    formObj.femlb.style.visibility='hidden';
	formObj.divtxt_2.style.display ='inline';
	formObj.divtxt_3.style.display ='inline';
    formObj.divtxt_4.style.display ='inline';
	formObj.divtxt_5.style.display ='inline';
	formObj.Ke.style.visibility='visible';
	formObj.txtlbl_3.style.visibility='hidden';
	formObj.Reslgnd.style.visibility='hidden';
	formObj.txt1.style.visibility='visible';
    formObj.txt2.style.visibility='visible';
    formObj.txt3.style.visibility='visible';
    formObj.txt4.style.visibility='visible';
	formObj.txt5.style.visibility='visible';
    formObj.txtlbl_1.style.visibility='visible';
    formObj.txtlbl_2.style.visibility='visible';
    formObj.Resunit.style.visibility='visible';
    formObj.txtlbl_3.style.visibility='visible';
	formObj.txtlbl_4.style.visibility='visible';
	formObj.txtlbl_5.style.visibility='visible';
	formObj.Keresult.style.visibility='visible';
	formObj.footlbl_1.style.visibility='visible';
    formObj.footlbl_2.style.visibility='visible';
    formObj.footlbl_3.style.visibility='visible';
    formObj.footlbl_4.style.visibility='visible';
	formObj.footlbl_5.style.visibility='visible';
	break;

case "DSE":

	var newHTML = "<br></br><label>Dose = C&nbsp;<sub>pss max</sub> (CL)&nbsp;&nbsp;&nbsp;&nbsp; <label  style='font-size:9;'>&Chi;</label>&nbsp;&nbsp;T<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<sup>_____________</sup></br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(S)&nbsp;(F)&nbsp;&nbsp;</label>";
	document.getElementById('fdisp').innerHTML = newHTML;
	document.getElementById('Resunit').innerHTML = " ";
	document.getElementById('Keresult').innerHTML = " ";
    document.getElementById('txtlbl_4').innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style='font-size:11'>S ";
    document.getElementById('txtlbl_5').innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style='font-size:1'>&nbsp;</label><label style='font-size:12'>F ";
    document.getElementById('txtlbl_3').innerHTML = Tlb;
    document.getElementById('txtlbl_2').innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style='font-size:10'>CL&nbsp;";
	document.getElementById('txtlbl_1').innerHTML =  "<label style='font-size:11'>C</label>&nbsp;<label style='font-size:11'><sub>pss max</sub></label>&nbsp;";
	document.getElementById('footlbl_1').innerHTML = Cpss_ftlbl;
	document.getElementById('footlbl_4').innerHTML = S_ftlbl;
	document.getElementById('footlbl_5').innerHTML =  F_ftlbl;
	document.getElementById('footlbl_3').innerHTML = T_ftlbl;
	document.getElementById('footlbl_2').innerHTML = Cl_ftlbl;
	document.getElementById('Reslgnd').innerHTML = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Dose(mg)&nbsp;= &nbsp;&nbsp;";
    document.formTdmCalc.elements[3].name="Cpss max";
	document.formTdmCalc.elements[4].name="CL";
	document.formTdmCalc.elements[5].name="T";
	document.formTdmCalc.elements[6].name="S";
	document.formTdmCalc.elements[7].name="F";	
    formObj.fdisp.style.visibility='visible';
    formObj.Kflag.value='DS';
    formObj.txt1.value="";
	formObj.txt2.value="";
	formObj.txt3.value="";
	formObj.txt4.value="";
	formObj.txt5.value="";
	formObj.male.style.visibility='hidden';
    formObj.female.style.visibility='hidden';
    formObj.malelb.style.visibility='hidden';
    formObj.femlb.style.visibility='hidden';
	formObj.divtxt_2.style.display ='inline';
	formObj.divtxt_3.style.display ='inline';
    formObj.divtxt_4.style.display ='inline';
	formObj.divtxt_5.style.display ='inline';
	formObj.Ke.style.visibility='visible';
	formObj.txtlbl_3.style.visibility='hidden';
	formObj.Reslgnd.style.visibility='hidden';
	formObj.txt1.style.visibility='visible';
    formObj.txt2.style.visibility='visible';
    formObj.txt3.style.visibility='visible';
    formObj.txt4.style.visibility='visible';
	formObj.txt5.style.visibility='visible';
    formObj.txtlbl_1.style.visibility='visible';
    formObj.txtlbl_2.style.visibility='visible';
    formObj.Resunit.style.visibility='visible';
    formObj.txtlbl_3.style.visibility='visible';
	formObj.txtlbl_4.style.visibility='visible';
	formObj.txtlbl_5.style.visibility='visible';
	formObj.Keresult.style.visibility='visible';
	formObj.footlbl_1.style.visibility='visible';
    formObj.footlbl_2.style.visibility='visible';
    formObj.footlbl_3.style.visibility='visible';
    formObj.footlbl_4.style.visibility='visible';
	formObj.footlbl_5.style.visibility='visible';
    break;
   }
}

function getClockTime()
{
 var now    = new Date();
 var day = now.getDay();
 var today= ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"]
 day = today[day];
 var monthnumber = now.getMonth();
 monthnumber = monthnumber + 1;
 var monthday    = now.getDate();
 var year        = now.getYear();
 var hour   = now.getHours();
 var minute = now.getMinutes();
 var second = now.getSeconds();
   //if (hour   < 10) { hour   = "0" + hour;   }
 hour < 10 ? hour = "0" + hour : hour = hour
//   if (minute < 10) { minute = "0" + minute; }
 minute < 10 ? minute = "0" + minute : minute = minute
  // if (second < 10) { second = "0" + second; }
 second < 10 ? second = "0" + second : second = second
 var timeString = day+' '+  monthday+'/' + monthnumber+'/' + year+ ' '+ hour + ':' + minute + ':' + second ;              
 document.getElementById('clk').innerHTML=timeString;	
 return timeString;
}


function checkscript() {

 var formObj =  document.formTdmCalc;
/*
	for (i=3;i<6;i++) {

	    box = document.formTdmCalc.elements[i];
  			if (!box.value) {	
			alert('You haven\'t filled in ' + box.name + '!');
			box.focus()
			return false;
		}
	}

*/

elemlen = document.formTdmCalc.elements.length;
for (i=0;i<elemlen;i++) {
 box = document.formTdmCalc.elements[i];
if ( box.getAttribute('type') == 'text'){
if ((!box.value) && (box.style.visibility=='visible')) {
		alert('You haven\'t filled in ' + box.name + '!');
		box.focus()
			return false;
		  }    
	  }
  }
return true;
}
