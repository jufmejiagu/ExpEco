//  RecordandoJava

package javaapplication4;
import java.util.*;
import java.util.concurrent.TimeUnit;

//  @author
//  Juan Camilo Bustamante Hernandez
//  Estudiante de Ingeniería de Sistemas
//  Universidad Nacional de Colombia, sede Medellín
 
public class RecordandoJava {
    
    public static void Esperar(int x){
        
        try {
            
            TimeUnit.SECONDS.sleep(x);
            
        } catch (InterruptedException e) {
            System.out.println("Error inesperado, ¡Sálvese quien pueda! D:");
        }
        
              
        
    }

    public static void mostro(){
         System.out.println("¡Bienvenido al experimento ecónomico!");
        System.out.println("");
        System.out.println("Durante 5 períodos usted debera tomar decisiones de producción en "
                + "una fabrica.");
        System.out.println("Ademas debe reportar su producción ante un inspector, pero este no"
                + " estara presente en cada período para corroborar su reporte.");
        System.out.println("");
        
        Esperar(7);
        
        System.out.println("¡EMPECEMOS!");
        System.out.println("");
        
        Esperar(2);
        
        }
    
    public static void main(String[] args) {
        
        Scanner InputTeclado = new Scanner(System.in);
        int UnidadesProduccion;
        String UnidadesProduccionSTR;
        int DineroTotal;
        int Impuesto = 6;
        int UnidadesReporte;
        String UnidadesReporteSTR;
        int DotacionInicial = 250;
        int[] GananciasTecActual = {30, 28, 25, 21, 16, 10};
        int[] GananciasTecNueva = {0, 0, 0, 0, 0, 0};
        double TasaAumentoTec = 1.65;
        
        for (int i = 0;i<GananciasTecActual.length; i++){
            GananciasTecNueva[i] = (int)Math.floor((GananciasTecActual[i] * TasaAumentoTec) + 0.5); 
        }
        
        int CostoAdopcion = 60;
        String PreguntaTecNueva;
        int[] Multas = {12, 15, 19, 24, 30, 37};
        
        DineroTotal = DotacionInicial;
        
        NewJFrame pepito = new NewJFrame();
        
        pepito.setVisible(true);
        
        
        
        
       
        
        for (int n = 1;n < 6;n++){

            int SaldoInicial = DineroTotal;
            int ProbabilidadMonitoreo = 0 + (int)(Math.random() * ((100 - 0) + 1));
            int Suerte = 0 + (int)(Math.random() * ((100 - 0) + 1));
            int[] GananciasTecPeriodo = {0, 0, 0, 0, 0, 0};
            int GananciaProduccionPeriodo = 0;
            int GananciaTotalPeriodo;
            int ImpuestoPeriodo;
            int MultaPeriodo = 0;
            int InversionTec = 0;

            System.out.println("");
            System.out.println("Período " + n);
            System.out.println("");
            System.out.println("Su saldo actual es de: " + DineroTotal);
            System.out.println("");
            System.out.println("La probabilidad de ser monitoreado es " + ProbabilidadMonitoreo + "%");
            System.out.println("");
            Esperar(3);
            System.out.println("La siguiente tabla muestra las ganancias de cada unidad producida dependiendo"
                    + " de la tecnología escogida.");
            System.out.println("");
            System.out.println("Unidad      Ganancia con tecnología actual      Ganancia con tecnología nueva");
            System.out.println("1           " + GananciasTecActual[0] + "               "
                    + "                   " + GananciasTecNueva[0]);
            System.out.println("2           " + GananciasTecActual[1] + "               "
                    + "                   " + GananciasTecNueva[1]);
            System.out.println("3           " + GananciasTecActual[2] + "               "
                    + "                   " + GananciasTecNueva[2]);
            System.out.println("4           " + GananciasTecActual[3] + "               "
                    + "                   " + GananciasTecNueva[3]);
            System.out.println("5           " + GananciasTecActual[4] + "               "
                    + "                   " + GananciasTecNueva[4]);
            System.out.println("6           " + GananciasTecActual[5] + "               "
                    + "                   " + GananciasTecNueva[5]);
            System.out.println("");

            do {

                System.out.println("El costo de comprar una nueva tecnología es: " + CostoAdopcion);
                System.out.println("¿Desea comprar la tecnología nueva?");
                System.out.println("1. Si");
                System.out.println("2. No");
                PreguntaTecNueva = InputTeclado.nextLine();

            } while ((!PreguntaTecNueva.equals("1")) && (!PreguntaTecNueva.equals("2")));

            //System.out.println(Arrays.toString(GananciasTecActual));
            //System.out.println(Arrays.toString(GananciasTecNueva));

            if (PreguntaTecNueva.equals("1")){

                DineroTotal = DineroTotal - CostoAdopcion;
                InversionTec = CostoAdopcion;
                CostoAdopcion = ((int)Math.floor((CostoAdopcion * TasaAumentoTec) + 0.5)) - 10;
                Impuesto = ((int)Math.floor(((Impuesto + 3) * TasaAumentoTec) + 0.5)) - 5;

                //System.out.println(CostoAdopcion);

                for (int i = 0;i<GananciasTecActual.length; i++){

                    GananciasTecActual[i] = GananciasTecNueva[i];
                    GananciasTecPeriodo[i] = GananciasTecActual[i];
                    GananciasTecNueva[i] = (int)Math.floor((GananciasTecActual[i] * TasaAumentoTec) + 0.5); 
                    Multas[i] = ((int)Math.floor(((Multas[i] + 5) * TasaAumentoTec) + 0.5)) - 5;

                }

            }else{

                CostoAdopcion = (int)Math.floor((CostoAdopcion * 0.9) + 0.5);
                Impuesto = ((int)Math.floor((Impuesto * 0.9) + 0.5));

                //System.out.println(CostoAdopcion);

                for (int i = 0;i<GananciasTecActual.length; i++){

                    GananciasTecPeriodo[i] = GananciasTecActual[i];
                    GananciasTecActual[i] = (int)Math.floor((GananciasTecActual[i] * 0.95) + 0.5);
                    GananciasTecNueva[i] = (int)Math.floor((GananciasTecNueva[i] * 1.05) + 0.5);
                    Multas[i] = (int)Math.floor((Multas[i] * 0.9) + 0.5);

                }

            }

            //System.out.println(Arrays.toString(GananciasTecActual));
            //System.out.println(Arrays.toString(GananciasTecNueva));
            //System.out.println(Arrays.toString(GananciasTecPeriodo));
            
            System.out.println("");
            System.out.println("Su saldo actual es de: " + DineroTotal);
            System.out.println("");
            
            Esperar(3);

            do {

                System.out.println("¿Cuantas unidades desea producir?");
                System.out.println("Nota: Recuerde que el impuesto de producción por cada unidad reportada"
                        + " es de: " + Impuesto);
                UnidadesProduccionSTR = InputTeclado.nextLine();

            }while ((!UnidadesProduccionSTR.equals("1")) && (!UnidadesProduccionSTR.equals("2")) &&
                     (!UnidadesProduccionSTR.equals("3")) && (!UnidadesProduccionSTR.equals("4")) &&
                     (!UnidadesProduccionSTR.equals("5")) && (!UnidadesProduccionSTR.equals("6")) &&
                     (!UnidadesProduccionSTR.equals("0")));

            UnidadesProduccion = Integer.parseInt(UnidadesProduccionSTR);
            System.out.println("");

            for (int UniProd = 0; UniProd < UnidadesProduccion; UniProd++){

                DineroTotal = DineroTotal + GananciasTecPeriodo[UniProd];
                GananciaProduccionPeriodo = GananciaProduccionPeriodo + GananciasTecPeriodo[UniProd];

            }

            System.out.println("Su saldo actual es de: " + DineroTotal);
            System.out.println("");
            
            Esperar(3);

            System.out.println("La siguiente tabla muestra las multas por subreporte");
            System.out.println("");
            System.out.println("Cantidad de unidades    Multa");
            System.out.println("subreportadas");
            System.out.println("1                       " + Multas[0]);
            System.out.println("2                       " + Multas[1]);
            System.out.println("3                       " + Multas[2]);
            System.out.println("4                       " + Multas[3]);
            System.out.println("5                       " + Multas[4]);
            System.out.println("6                       " + Multas[5]);
            System.out.println("");
            
            do {

                System.out.println("¿Cuantas unidades desea reportar?");
                System.out.println("Nota: Recuerde que la probabilidad de ser monitoreado"
                        + " es " + ProbabilidadMonitoreo + "%");
                UnidadesReporteSTR = InputTeclado.nextLine();

            }while ((!UnidadesReporteSTR.equals("1")) && (!UnidadesReporteSTR.equals("2")) &&
                     (!UnidadesReporteSTR.equals("3")) && (!UnidadesReporteSTR.equals("4")) &&
                     (!UnidadesReporteSTR.equals("5")) && (!UnidadesReporteSTR.equals("6")) &&
                     (!UnidadesReporteSTR.equals("0")));

            UnidadesReporte = Integer.parseInt(UnidadesReporteSTR);
            ImpuestoPeriodo = UnidadesReporte * Impuesto;
            DineroTotal = DineroTotal - ImpuestoPeriodo;

            System.out.println("");
            System.out.println("Su saldo actual es de: " + DineroTotal);
            System.out.println("");
            
            Esperar(3);

            if (Suerte < ProbabilidadMonitoreo){

                System.out.println("¡Usted ha sido monitoreado!");
                System.out.println("");

                if (UnidadesReporte < UnidadesProduccion){

                    int SubReporte = UnidadesProduccion - UnidadesReporte;

                    System.out.println("Se encontró que usted subreportó " + SubReporte + " unidades.");
                    System.out.println("");
                    
                    for (int i = 0;i<SubReporte; i++){

                    MultaPeriodo = MultaPeriodo + Multas[i];

                    }

                }else{

                    System.out.println("Felicitaciones, su reporte se encuentra en orden.");
                    System.out.println("");

                }

            }else{

                System.out.println("¡Usted NO ha sido monitoreado!");
                System.out.println("");

            }
            
            Esperar(3);
            
            GananciaTotalPeriodo = GananciaProduccionPeriodo - ImpuestoPeriodo - MultaPeriodo - InversionTec;
                    
            DineroTotal = SaldoInicial + GananciaTotalPeriodo;
            
            System.out.println("");
            System.out.println("Resumen del período");
            System.out.println("");
            System.out.println("Saldo inicial: " + SaldoInicial);
            System.out.println("Inversión en tecnología: " + InversionTec);
            System.out.println("Ganancias por producción: " + GananciaProduccionPeriodo);
            System.out.println("Pago de impuestos según autorreporte: " + ImpuestoPeriodo);
            System.out.println("Pago de multas: " + MultaPeriodo);
            System.out.println("");
            System.out.println("Ganancias del período: " + GananciaTotalPeriodo);
            System.out.println("");
            System.out.println("Saldo final: " + DineroTotal);
            System.out.println("");
            System.out.println("");
            System.out.println("");
            
            Esperar(12);

        }
    
    }
    
}
