/* 
 * Copyright 2019 Elísabet Palomino .
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Elísabet Palomino
 */
public class Main {

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static final Random RND = new Random();

    public static void main(String[] args) {


//CONSTANTES
        //LÍMITES DEL DIA
        final int H_MIN = 0;
        final int H_MAX = 23;
        //final int TMP_MIN = 0; 

        final int M_MIN = 0;
        final int M_MAX = 59;
        //final int TMP_MAX = H_MAX * 60 + M_MAX; //MINUTOS MÁXIMOS

        //ATENCION BANCARIA
        final int H_INI = 10;
        final int M_INI = 30;
        final int TMP_INI = H_INI * 60 + M_INI;

        final int H_FIN = 12;
        final int M_FIN = 15;
        final int TMP_FIN = H_FIN * 60 + M_FIN;

        // Hora Usuario
        int hUsr;
        int mUsr;
        int tmpUsr;

        // HORA ALEATORIA      
        int hRnd = RND.nextInt(H_MAX - H_MIN + 1) + H_MIN;
        int mRnd = RND.nextInt(M_MAX - M_MIN + 1) + M_MIN;
        int tmpRnd = hRnd * 60 + mRnd;

        try {
            //SE PIDEN VALORES A LEER (HORA Y MINUTOS ACTUALES)
            System.out.print("Hora actual ......: ");
            hUsr = SCN.nextInt();
            System.out.print("Minuto actual ....: ");
            mUsr = SCN.nextInt();
            tmpUsr = hUsr * 60 + mUsr;

            //HORAS ALEATORIAS 
            System.out.printf("Hora aleatoria ...: %02d:%02d%n", hRnd, mRnd);
            System.out.printf("Hora aleatoria ...: %s%n",
                    tmpRnd >= TMP_INI && tmpRnd <= TMP_FIN
                            ? "Atención disponible" : "Atención NO disponible");//hora aleatoria, dentro del rango de oficina?

            //HORAS MANUALES
            System.out.printf("Hora manual.......: %02d:%02d%n", hUsr, mUsr);
            System.out.printf("Hora manual.......: %s%n",
                    tmpUsr >= TMP_INI && tmpUsr <= TMP_FIN
                            ? "Atención disponible" : "Atención SI disponible");

        } catch (Exception e) {

            System.out.println("ERROR: Entrada Incorrecta");

        } finally {

            SCN.nextLine();

        }

    }//main

}//class
