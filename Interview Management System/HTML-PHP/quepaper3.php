<?php
error_reporting(0);

// #########################################
// In this page you will find the code required to create multiple choice exams
// Copy this code and save it to a file name "whatever.php"
// The file name must finish with ".php"
// Save the file to a PHP unable server.
// Please consider adding a link to this service:
//      http://www.phptutorial.info/scripts/multiple_choice/
//
// A website was created based in this script at which allows
//   to create and maintain the test online at:
//      http://www.testak.org
//
// #########################################
//      CONFIGURATION
$title = "Test";
$address = "adminlogin.html";
$randomizequestions ="yes"; // set up as "no" to show questions without randomization
//    END CONFIGURATION
// #########################################

$a = array(
1 => array(
   0 => "what is 1",
   1 => "1",
   2 => "2",
   3 => "3",
   4 => "4",
   5 => "5",
   6 => 1
),
2 => array(
   0 => "what is 2",
   1 => "1",
   2 => "2",
   3 => "3",
   4 => "4",
   5 => "5",
   6 => 2
),
3 => array(
   0 => "what is 3",
   1 => "1",
   2 => "2",
   3 => "3",
   4 => "4",
   5 => "5",
   6 => 3
),
4 => array(
   0 => "what is 4",
   1 => "1",
   2 => "2",
   3 => "3",
   4 => "4",
   5 => "5",
   6 => 4
),
5 => array(
   0 => "what is 5",
   1 => "1",
   2 => "2",
   3 => "3",
   4 => "4",
   5 => "5",
   6 => 5
),
6 => array(
   0 => "what is 6",
   1 => "1",
   2 => "2",
   3 => "3",
   4 => "5",
   5 => "6",
   6 => 5
),
7 => array(
   0 => "what is 7",
   1 => "1",
   2 => "2",
   3 => "3",
   4 => "4",
   5 => "7",
   6 => 5
),
8 => array(
   0 => "what is 8",
   1 => "1",
   2 => "2",
   3 => "3",
   4 => "4",
   5 => "8",
   6 => 5
),
9 => array(
   0 => "what is 9",
   1 => "1",
   2 => "2",
   3 => "3",
   4 => "4",
   5 => "9",
   6 => 5
),
10 => array(
   0 => "what is 10",
   1 => "1",
   2 => "2",
   3 => "6",
   4 => "8",
   5 => "10",
   6 => 5
),
);

$max=10;

$question=$_POST["question"] ;

if ($_POST["Randon"]==0){
        if($randomizequestions =="yes"){$randval = mt_rand(1,$max);}else{$randval=1;}
        $randval2 = $randval;
        }else{
        $randval=$_POST["Randon"];
        $randval2=$_POST["Randon"] + $question;
                if ($randval2>$max){
                $randval2=$randval2-$max;
                }
        }
        
$ok=$_POST["ok"] ;

if ($question==0){
        $question=0;
        $ok=0;
        $percentage=0;
        }else{
        $percentage= Round(100*$ok / $question);
        }
?>

<HTML><HEAD><TITLE>Multiple Choice Questions:  <?php print $title; ?></TITLE>
<link rel="stylesheet" type="text/css" href="style1.css">
<SCRIPT LANGUAGE='JavaScript'>
<!-- 
function Goahead (number){
        if (document.percentage.response.value==0){
                if (number==<?php print $a[$randval2][6] ; ?>){
                        document.percentage.response.value=1
                        document.percentage.question.value++
                        document.percentage.ok.value++
                }else{
                        document.percentage.response.value=1
                        document.percentage.question.value++
                }
        }
}
// -->
</SCRIPT>

</HEAD>
<BODY>

<CENTER>
<H1><?php print "$title"; ?></H1>
<TABLE BORDER=0 CELLSPACING=5 WIDTH=500>

<?php if ($question<$max){ ?>

<TR><TD ALIGN=RIGHT>
<FORM METHOD=POST NAME="percentage" ACTION="<?php print $URL; ?>">


<BR><input type=submit style="Font-Family:Caviar Dreams;background-color:rgba( , , , );color:black;font-size:15px;" value="NEXT >>">
<input type=hidden name=response value=0>
<input type=hidden name=question value=<?php print $question; ?>>
<input type=hidden name=ok value=<?php print $ok; ?>>
<input type=hidden name=Randon value=<?php print $randval; ?>>
<br><?php print $question+1; ?> / <?php print $max; ?>
</FORM>
<HR>
</TD></TR>

<TR><TD>
<FORM METHOD=POST NAME="question" ACTION="">
<?php print "<b>".$a[$randval2][0]."</b>"; ?>
<BR>
<BR>     <INPUT TYPE=radio NAME="option" VALUE="1"  onClick=" Goahead (1);"><?php print $a[$randval2][1] ; ?>
<BR>     <INPUT TYPE=radio NAME="option" VALUE="2"  onClick=" Goahead (2);"><?php print $a[$randval2][2] ; ?>
<?php if ($a[$randval2][3]!=""){ ?>
<BR>     <INPUT TYPE=radio NAME="option" VALUE="3"  onClick=" Goahead (3);"><?php print $a[$randval2][3] ; } ?>
<?php if ($a[$randval2][4]!=""){ ?>
<BR>     <INPUT TYPE=radio NAME="option" VALUE="4"  onClick=" Goahead (4);"><?php print $a[$randval2][4] ; } ?>
<?php if ($a[$randval2][5]!=""){ ?>
<BR>     <INPUT TYPE=radio NAME="option" VALUE="5"  onClick=" Goahead (5);"><?php print $a[$randval2][5] ; } ?>



</FORM>

<?php
}else{
?>
<TR><TD ALIGN=Center>
<p>The Test has finished
<BR>Percentage of correct responses: <?php print $percentage ; ?> %</p>
<A HREF="<?php print $address; ?>">Home Page</a>

<?php } ?>

</TD></TR>
</TABLE>

</CENTER>
</BODY>
</HTML>

