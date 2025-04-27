#include <stdio.h>
#include <barcode.h>

char    *strchr();
/*
 * row, col, bar height and resolution is valid only for Laster printer
 */
void print_barcode(fp, s, row, col, bar_ht, resolution,default_printer_type)
FILE    *fp;
char    *s;
int     row, col, bar_ht, resolution;
int     default_printer_type;

{
  void  print_barcode_hp();
  void  print_barcode_epson();
  void  print_barcode_zebra();

  char  err_buf[100];
  int    h_printer_type;

  h_printer_type = default_printer_type;
    
  if (h_printer_type != 1 && h_printer_type != 2 && h_printer_type != 3)
    {
    disp_message(ERR_MESG, "Error: Invalid printer type\n");
    return;
    }
  if (h_printer_type == 1) /* Laser - PCL */
    print_barcode_hp(fp, s, row, col, bar_ht, resolution);
  else if (h_printer_type == 2) /* EPSON */
    print_barcode_epson(fp, s);
  else if (h_printer_type == 3) /* ZEBRA */
    print_barcode_zebra(fp, s, bar_ht);
}

/*
 * This is the actual printing routine for the barcode. It initialises the
 * printer in graphics mode and converts the binary bitmap data to char
 * values before printing.
 * 
 * This routine saves the current position of the cursor and can be called 
 * at any time (Within a single page) to print the barcode and continue
 * printing from where you left off. For example you can call this routine
 * to print the barcode at the begining of page at the desired position
 * and proceed with the rest of the page or print the page first and then
 * print the barcode at the end whichever is convenient
 *
 * The exact positioning may be slightly tricky for laser printers since
 * everything is in terms of dots/inch. So experiment with different heights
 * and row positions to get the desired result
 *******************/
/*****************************************************************************
 * CODE 39 BARCODE PRINTING PROGRAM FOR HP LASERJET PRINTERS
 ***************************************************************************/
void print_barcode_hp(fp, s, row, col, bar_ht, resolution)
FILE    *fp;
char    *s;
int     row, col, bar_ht, resolution;
{
  int   check_bar();
  void  form_data_str_hp();
  unsigned short bintoc();

  int i, j;
  char  s1[100];
  char  print_str[1000];
  char  barcode_str[250];
  char  data_str[2000];
  unsigned short c;
  int   data_bytes = 0;
  
  if (check_bar(s)) 
    {
    disp_message(ERR_MESG, "Error: Barcode contains invalid characters\n");
    /***
    printf("Error: Barcode contains invalid characters\n");
    ***/
    return;
    }
  /*
   * The * is the delimiter for code 39 and signifies the start and end
   * of the barcode
   * /
   /**
   sprintf(barcode_str, "%c%s%c", '*', s, '*');
   **/
   strcpy(barcode_str, "*");
   strcat(barcode_str, s);
   strcat(barcode_str, "*");


   form_data_str_hp(barcode_str, data_str);
   data_bytes = (int)(strlen(data_str) / 8);
   if (strlen(data_str) % 8)
     data_bytes++;


  fprintf(fp, "%c&f0S", ESC);  /* Save the current cursor position */
  if (row != 0)  /* row == 0 means from current position */
   fprintf(fp, "%c&a%dR", ESC, row-1);  /* Set the verical position */
  fprintf(fp, "%c&a%dC", ESC, col);  /* Set the horizontal position */

  fprintf(fp, "%c*t%dR", ESC, resolution);  /* Select the printer resolution*/
  fprintf(fp, "%c*r0F", ESC);  /* Raster graphics presentation to follow */
			       /* orientation */

  fprintf(fp, "%c*r1A", ESC);  /* Start Raster graphics at current cursor */

  j = 0;
  i = 0;
  print_str[0] = '\0';
  while (j < strlen(data_str)-8)
    {
    strncpy(s1, data_str+j, 8);
    s1[8] = '\0';
    c = bintoc(s1);
    print_str[i++] = c;
    j += 8;
    }
  if (j < strlen(data_str))
    {
    strcpy(s1, data_str+j);
    strncat(s1, "00000000");
    s1[8] = '\0';
    c = bintoc(s1);
    print_str[i++] = c;
    }
  print_str[i] = '\0';
  for (i=1; i <= bar_ht; i++)
     {
     fprintf(fp, "%c*b%dW", ESC, data_bytes); /* Transfer Raster by row */
     fprintf(fp, "%s", print_str);
     }
  /* 
   * Print the value of barcode below. Find out the center position using
   * data_bytes. This works only for Laser printer. Therefore this has to
   * be done in the individual routines.

  fprintf(fp, "\n");
  fprintf(fp, "%*.s", col, " "); 
  fprintf(fp, "%*.s", data_bytes/8, " ");
  fprintf(fp, "%s\n", s);
  ****/

  fprintf(fp, "%c*rB\n", ESC); /* End Raster Graphics */
  fprintf(fp, "%c&f1S\n", ESC); /* Restore cursor position */
}

/*
 * This function checks if the string to be barcodes contains valid 
 * characters. The variable chk_str contains all the valid characters. 
 * The character * should not be used since they are used as delimiters in
 * CODE39
 */
int check_bar(s)
char    *s;
{
  int   i;
  char  *c;

  for (i = 0; i < strlen(s); ++i)
     {
     c=strchr(chk_str, s[i]);
     if (c == (char *) NULL || *c == '*')
       return (1); /* TRUE */
     }
  return(0); /* FALSE */
}

/*
 * This function gets the corresponding bitmap data for each of the 
 * barcode character and pads it into the data string
 */
void form_data_str_hp(s, out_s)
char    *s;
char    *out_s;
{
  int   i;
  char  *c;

  out_s[0] = '\0';

  for (i=0; i < strlen(s); ++i)
     {
     c=strchr(chk_str, s[i]);
     strcat(out_s, barcode[c-chk_str]);
     strcat(out_s, "000");
     }
  return;
}

/****
 * Function for converting binary to character values
 ***/
unsigned short bintoc(instr)
char    *instr;
{
  unsigned short i;
  int   dum_val;
  unsigned      short   inchar;
  
  i = 0;
  dum_val = 1;
  inchar = 0;
  while ( i < 8)
    {
    if (instr[7-i] == '1')
      inchar += dum_val;
    dum_val = dum_val * 2;
    i++;
    }
  return (inchar);
}
/***************************************************************************/
/*
 * This is the actual printing routine for the barcode. The printing routine
 * is much more simple compared to laser because you print only one bit at a
 * time rather than the entire barcode line so the values are either 255 or 0
 */
void print_barcode_epson(fp, s)
FILE    *fp;
char    *s;
{
  int   check_bar();
  void  form_data_str_epson();
  int i, j;
  unsigned short c;
  int n, n1, n2;
  char  barcode_str[250];
  char  data_str[2000];
  
  if (check_bar(s)) 
    {
    disp_message(ERR_MESG, "Error: Barcode contains invalid characters\n");
    /***
    printf(ERR_MESG, "Error: Barcode contains invalid characters\n");    
    ***/
    return;
    }
  /*
   * The * is the delimiter for code 39 and signifies the start and end
   * of the barcode
   */
   strcpy(barcode_str, "*");
   strcat(barcode_str, s);
   strcat(barcode_str, "*");

   form_data_str_epson(barcode_str, data_str);

   fprintf(fp, "%c%c%c", ESC, 'A', 7); /* Set line spacing 0 */
   fprintf(fp, "%c%c%c", ESC, 'U', 1); /* Set line uni-direction printing on */
  /*************************************************************************
   * The printing of barcode in dot-matrix printers differ from laser.
   * Laser printer prints 1 dot height X 1 barcode width line at a time
   * and you repeat this for the number of pixels to get the desired height.
   * 
   * The dot-matrix prints one character height X 1 dot width at a time and
   * you repeat this for the number of bits to get the entire barcode. You
   * can increase the height in terms of 1 character height by repeating
   * the process again. The line spacing has to be set to 0 so that no gaps
   * appear between 2 barcode lines. Beacuse of this there may be a problem
   * if you print text on the same line as barcode. Unlike laser printer 
   * where you can print the barcode at any point of time for dot-matrix
   * it has to follow the report format since you cannot dynamically 
   * re-position the cursor 
   *
   * Uni-direction printing is used for more accurate printing
   ************************************************************************/

   n = strlen(data_str);
   if (n > 255)
     {
     n1 = n%256;
     n2 = n/256;
     }
   else
     {
     n1 = n;
     n2 = 0;
     }
   
    i = 0;
   /*
    * The printer command used is ESC * m n1 n2
    * Where m - Graphics option; 32 -> 24 pin, Single density
    *                            33 -> 24 pin, Double density
    *                            39 -> 24 pin, Triple density (best results)
    * If n is the total no of columns (bits) to be printed then n2 is the 
    * quotient after dividing n by 256 and n1 is the remainder. When you
    * need fewer than 256 cols then just make n1 the no. of col bits and
    * n2 as 0
    *****/
   fprintf(fp, "%c*%c%c%c", ESC, 39, n1, n2);
   for (i = 0; i < n; i++)
     {
     if (data_str[i] == '1')
       c = 255;
     else
       c = 0;
     /*
      * Since 24 pin printing mode is used the printer must receive 24bits
      * of info for each column. Since printer used 8-Bit bytes of info in
      * its communication with the computer, it needs 3 bytes of info for
      * each position
      */
     fprintf(fp, "%c%c%c", c,c,c);
     }

   fprintf(fp, "%c%c", ESC, '2');     /* Reset default line spacing */ 
   fprintf(fp, "%c%c%c", ESC, 'U', 0);/* Set uni-direction printing off */
   
   return;
}
/*
 * This function gets the corresponding bitmap data for each of the 
 * barcode character and pads it into the data string
 */
void form_data_str_epson(s, out_s)
char    *s;
char    *out_s;
{
  int   i;
  char  *c;

  for (i=0; i < strlen(s); ++i)
     {
     if (i)
       strcpy(out_s, "00");

     c=strchr(chk_str, s[i]);
     strcat(out_s, barcode[c-chk_str]);
     }
  return;
}
/***************************************************************************/
void print_barcode_zebra(fp, s, bar_ht)
FILE    *fp;
char    *s;
int     bar_ht;
{           
  /*
   * format for Zebra printer N,Data. Program zebcon will do the formating
   * and generates ZPL file.
   */
  fprintf(fp, "%s", s );
  return;
}
/****************************************************************************/
