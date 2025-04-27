/****************************OCS MEDICOM ver 1.0*****************************
*  File	: comma.c 
   Author : Faizal Eledath
   Date Created : 17/04/1993
   Last Modified : 17/04/1993
   
   Modified By   : Aldrin Alberto
   Date Modified : 2/10/1996
   

*  Purpose : To format the amount fields with commas. The number of decimal 
	     places of the amount field should not exceed 2 decimal places.
            
*  Input Parameters : 1. character string containig amount.
  
*****************************************************************************/  

#include<stdio.h>
#include<string.h>
#include<stdlib.h>

                  
                     
/*void main (void)
{
 char str1[] = "   1429871.00";
 char *format_amt(char *str1);  
 format_amt(str1);
} */       

/* The below routine checks for descimal places and formats the amount string*/
char *format_amt(str)
char *str;
{
 char *put_comma(), 
      *check_decimal();
 void u_ltrim(char *str);
      
 if(strlen(str) == 0)
   strcpy(str, "0.00");
 else {      
       u_ltrim(str);
        str = check_decimal(str);
       str = put_comma(str);
      }
return str;
}

/**************************************************/

char *format_amt1(str)
char *str;
{
 char *put_comma1(), 
      *check_decimal1();
 void u_ltrim(char *str);
      
 if(strlen(str) == 0)
   strcpy(str, "0.000");
 else {      
       u_ltrim(str);
       //str = check_decimal(str);
       str = put_comma1(str);
      }
return str;
}
/****************************************************/

 
/* checks if decimal point if there in the amount string. If not present */
/* appends the string ".00" to the input string.		          */
char *check_decimal(str)
char str[100];
{ 
  char *chk_dcml;
  char str_tmp[100];
 
  if(strncmp(str, ".", 1) == 0){
    strcpy(str_tmp, "0");
    strcat(str_tmp, str);
    strcpy(str, str_tmp);
  }

  chk_dcml = strrchr(str, '.');

  /* if no decimal placess put decimal points and two zeros */
  if(chk_dcml == NULL) {
    strcat(str,".00");
  }
  else if(strlen(chk_dcml) < 2)
       strcat(str, "00");
  else if(strlen(chk_dcml) < 3)
       strcat(str, "0");

  return str;
}

/************************/

char *check_decimal1(str)
char str[100];
{ 
  char *chk_dcml;
  char str_tmp[100];
 
  if(strncmp(str, ".", 1) == 0){
    strcpy(str_tmp, "0");
    strcat(str_tmp, str);
    strcpy(str, str_tmp);
  }

  chk_dcml = strrchr(str, '.');

  /* if no decimal placess put decimal points and two zeros */
  if(chk_dcml == NULL) {
    strcat(str,".000");
  }
  else if(strlen(chk_dcml) < 2)
       strcat(str, "00");
  else if(strlen(chk_dcml) < 3)
       strcat(str, "0");
  
  return str;
}


/************************/
char *put_comma(str)
char *str;
{
  int i,l,m,a,b,c;
  float j,k;
  char arr[120],o_arr[120],l_str1[10];
  if (atof(str) < 0)             /*** Added by Aldrin incase of negative **/
      strcpy(arr,++str);
  else
      strcpy(arr,str);
      
  strncpy(l_str1,arr + (strlen(arr) - 2),2);
  l_str1[2] = '\0';
  arr[strlen(str)-3] = '\0';
  i = strlen(arr);
  j = i;
  k = j/3;
  l = (int)(k);
  m = i - (l*3);
  if (i > 3)
  {
      for (a=0;a<m;a++)
         o_arr[a] = arr[a];
   if (m)
   {
     o_arr[m] = ','; b=m+1;
   }
   else b = m;
  for (c=1,a=m;arr[a]!= '\0';a++,b++)
  {
     o_arr[b] = arr[a]; 
     c++;
     if (c > 3 && arr[a+1] != '\0')
     {
       o_arr[++b] = ','; c = 1;
     }
   }
   o_arr[b] = '\0';
  }
  else
      strcpy(o_arr,arr);
  sprintf(str,"%s.%s",o_arr,l_str1);
  return str;
}



/**************************/


/* Routine for formatting the amount fields. The inpput is a character string */
/* the routine assumes the last two digit is a decimal point. Also there is no*//* than two descimal places.                                                  */
char *put_comma1(str)
char *str;
{
  int i,l,m,a,b,c;
  float j,k;
  char arr[120],o_arr[120],l_str1[10];
  if (atof(str) < 0)             /*** Added by Aldrin incase of negative **/
      strcpy(arr,++str);
  else
      strcpy(arr,str);
      
  strncpy(l_str1,arr + (strlen(arr) - 3),3);
  l_str1[4] = '\0';
  arr[strlen(str)-4] = '\0';
  i = strlen(arr);
  j = i;
  k = j/3;
  l = (int)(k);
  m = i - (l*3);
  if (i > 3)
  {
      for (a=0;a<m;a++)
         o_arr[a] = arr[a];
   if (m)
   {
     o_arr[m] = ','; b=m+1;
   }
   else b = m;
  for (c=1,a=m;arr[a]!= '\0';a++,b++)
  {
     o_arr[b] = arr[a]; 
     c++;
     if (c > 3 && arr[a+1] != '\0')
     {
       o_arr[++b] = ','; c = 1;
     }
   }
   o_arr[b] = '\0';
  }
  else
      strcpy(o_arr,arr);
  sprintf(str,"%s.%s",o_arr,l_str1);
  return str;
}


void u_ltrim (in_str)
char *in_str;
{
int len,i=0,j=0;
char out_str[60];

     len = strlen (in_str);
     while ( in_str[i] == ' ' && i <= len)
// Incrementing pointer to first no blank character      
           i++;         

     if ( i <= len )
     {
        for (j=0;i<= len; i++,j++)
            out_str[j] = in_str[i];
        out_str[++j] = '\0';
     }
     else
        out_str[0] = '\0';

     strcpy (in_str, out_str);
}
