
/**
 * Write a description of class Calendario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Calendario
{
    static int[][][] dias = new int[12][6][7]; // arreglo con todos los meses, dias, semanas del año
    static String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
    public static void armar(int año)
    {
        int limite = 0; // limite de dias del mes
        boolean bisiesto = false; // si es bisiesto o no
        int contador = 0;
        boolean sem = false;
        if(año%4 == 0 && (!(año %100 == 0) || año%400 == 0))
        {
            bisiesto = true;
        }
        int semana = 0;
        for(int i = 0; i < 12; i++)
        {
            System.out.print(meses[i] + ": ");
            System.out.println();
            if(i == 1 && bisiesto)
            {
                limite = 29;
            }
            else if(i == 1)
            {
                limite = 28;
            }
            else if((i <= 6 && (i+1)%2 != 0) || (i > 6 && (i+1)%2 == 0))
            {
                limite = 31;
            }
            else
            {
                limite = 30;
            }
            
            for(int j = 1; j <= limite; j = j=j+contador)
            {
                contador = 0;
                for(int k = queDia(1, i, año); k < 7; k++)
                {
                    if(semana > 0 && !sem)
                    {
                        k = 0;
                        sem = true;
                    }
                    if(semana == 0 && k == queDia(1, i, año))
                    {
                        System.out.print("\t");
                        for(int h = 0; h < queDia(1, i, año); h++)
                        {
                            System.out.print("\t");
                        }
                        for(int t = 1; t < 7-queDia(1, i, año); t++ )
                        {
                            imprimir(t);
                            contador++;
                        }
                        
                    }
                    else if(j+k <= limite && semana > 0)
                    {
                        dias[i][semana][k] = j;          
                        imprimir((j+k ));
                        contador++;
                    }
                }
                semana++;
                System.out.println();
                sem = false;
            }
            semana = 0;
            System.out.println();
            System.out.println();
        }
    }
    public static void mes(int mes)
    {
        int semana = 0;
        for(int j = 0; j < 6; j++)
            {
                for(int k = 0; k < 7; k++)
                {  
                     if(dias[mes-1][j][k] != 0)
                     {
                         imprimir(dias[mes-1][j][k]);
                         if(dias[mes-1][j][k] < 10)
                         {
                             System.out.print("\t");
                         }
                     }
                     else
                     {
                         System.out.print("\t");
                     }
                }
                System.out.println();
        }
    }
    public static void imprimir(int dia)
    {
        if(dia == 0)
        {
            System.out.print("\t");
        }

            System.out.print(dia+"\t");


    }
    public static int diasem(int dia , int mes , int año){

        int centuria=año/100;

        int centuriaaño = año%100 ;

        int diasem= 0;

        int añomod=año-1;

        mes= cambiarmes(mes);

        if (mes<12){

            diasem =(dia+((13*(mes+1))/5)+centuriaaño+(centuriaaño/4)+(centuria/4)+(5*centuria))%7;

 

        }else if ((mes>12&&mes<=14)){

            diasem =(dia+((13*(mes+1))/5)+añomod+(añomod/4)-(añomod/100)+(añomod/400))%7;

 

        }
        return diasem;
    }

    public static int cambiarmes(int mes){
        switch (mes){

            case 0:

            mes=13;

            break;

 

            case 1:

            mes=14;

            break;

 

            case 2:

            mes=3;

            break;

 

            case 3:

            mes=4;

            break;

 

            case 4:

            mes=5;

            break;

 

            case 5:

            mes=6;

            break;

 

            case 6:

            mes=7;

            break;

 

            case 7:

            mes=8;

            break;

 

            case 9:

            mes=10;

            break;

 

            case 11:

            mes=12;

            break;

 

        }

        return mes;

    }

 

    public static int cambiarDia(int diasem){
        
        switch (diasem){

            case (0):

            diasem = 5;

            break;

            case (1):

            diasem = 6;

            break;

            case (2):

            diasem = 0;

            break;

            case (3):

            diasem = 1;

            break;

            case (4):

            diasem = 2;

            break;

            case (5):

            diasem = 3;

            break;

            case (6):

            diasem = 4;

            break;
        }
        return diasem;
    }
    public static int queDia(int dia, int mes, int año)
    {
        return cambiarDia(diasem(dia, mes, año));
    }
    public static void semanaSanta2(int año){
     int A = año%19;
     int B = año/100;
     int C = año%100;
     int D = B/4;
     int E = B%4;
     int F = (B+8)/25;
     int G = (B-F+1)/3;
     int H = ((19*A)+B-D-G+15)%30;
     int I = C/4;
     int K = C%4;
     int L = (32+(2*E)+(2*I)-H-K)%7;
     int M = (A+(11*H)+(22*L))/451;
     int N = H+L-(7*M)+114;
     int MES = N/31;
     int DIA = 1+(N%31);
     System.out.println("Mes: "+MES+" dia: "+DIA);
    }
    public static void analizarfestivo(int mes, int semana, int dia)
    {

         
    }
}
