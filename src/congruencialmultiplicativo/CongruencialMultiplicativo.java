/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package congruencialmultiplicativo;

import javax.swing.JOptionPane;

/**
 *
 * @author jonnathan
 */
public class CongruencialMultiplicativo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a; // multiplicador
        int x; // Semilla
        int m;
        int opcion = 0;
        boolean verificacion = true;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Eliga una Opcion\n"
                    + "1    Congruencial Multiplicativo, Sistema Binario\n"
                    + "2    Congruencial Multiplicativo, Sistema Decimal\n"
                    + "3    Congruencial Multiplicativo con Numeros establecidos\n"
                    + "4    Salir", null, JOptionPane.INFORMATION_MESSAGE));
            switch (opcion) {
                case 1: // LA OPCION 1: CALCULA LOS VALORES DE a Y m, MEDIANTE SUS CORRESPONDIENTES FORMULAS EN EL SISTEMA BINARIO
                    x = semilla(); // se llama al metodo para pedir el valor de 'x'
                    a = multiplicador(2); // se llama al metodo para pedir y calcular el valor de 'a'. Se envia como parametro el sistema en el que se trabaja
                    m = modulo(2); // se llama el metodo para pedir y calcular el valor de 'm'. Se envia como parametro el sistema en el que se trabaja
                    calcular(x, a, m); // se llama el metodo para calcular el congruencial
                    break;
                case 2: // LA OPCION 2: CALCULA LOS VALORES DE a Y m, MEDIANTE SUS CORRESPONDIENTES FORMULAS EN EL SISTEMA DECIMAL
                    x = semilla();
                    a = multiplicador(10);
                    m = modulo(10);
                    calcular(x, a, m);
                    break;
                case 3: // LA OPCION 3: SE DEBE DE INGRESAR LOS VALORES FINALES DE m Y a.
                    x = semilla();
                    a = multiplicadorOp3(); // Se llama al metodo para pedir el valor final de 'a'
                    m = moduloOp3(); // se llama al metodo para pedir el valor final de 'm'
                    calcular(x, a, m);
                    break;
                case 4: // LA OPCION 4: SIRVE PARA SALIR DEL PROGRAMA
                    verificacion = false;
                    break;
                default:
            }
        } while (verificacion);

    }

    /*
    Metodo para pedir el valor de 'X0'
    */
    public static int semilla() {
        int x = 0;
        boolean entero = false;
        do {
            try {
                x = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor de la semilla ( X0 ).\n"
                        + "Debe ser entero impar", null, JOptionPane.INFORMATION_MESSAGE));
                //entero = true;
                if (x == JOptionPane.CANCEL_OPTION) {
                    entero = false;
                    break;
                }
                if (x > 0) {
                    return x;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe se entero");
            }
        } while (!entero);
        return x;
    }

    /*
    Metodo para pedir y calcular el valor de 'a', mediante la formula:
        Sistema Binario:    a = 8t + 3
        Sistema Decimal:    a = 200t + 3
    */
    public static int multiplicador(int base) {
        int a = 0;
        int t = 0;
        boolean entero = false;
        do {
            try {
                if (base == 2) {
                    t = Integer.parseInt(JOptionPane.showInputDialog(null, "Para calcular el multiplicador (a), "
                            + "se debe ingresar el valor de 't', deacuerdo a la siguiente Formula:\n"
                            + "Formula:  a = 8t + 3", null, JOptionPane.INFORMATION_MESSAGE));
                    if (t >= 0) {
                        a = 8 * t + 5;
                        entero = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe se entero");
                    }
                } else if (base == 10) {
                    t = Integer.parseInt(JOptionPane.showInputDialog(null, "Para calcular el multiplicador (a), "
                            + "se debe ingresar el valor de 't', deacuerdo a la siguiente Formula:\n"
                            + "Formula:  a = 200t + 3", null, JOptionPane.INFORMATION_MESSAGE));
                    if (t >= 0) {
                        a = 200 * t + 3;
                        entero = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe se entero");
                    }
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe se entero");
            }
        } while (!entero);
        return a;
    }

    /*
    Metodo para pedir y calcular el valor de 'm', mediante la formula:
        Sistema Binario:    m = 2^g
        Sistema Decimal:    m = 10^g
    */
    public static int modulo(int base) {
        int m = 0, g = 0;
        boolean entero = false;
        do {
            try {
                if (base == 2) {
                    g = Integer.parseInt(JOptionPane.showInputDialog(null, "Para calcular el modulo (m), ingrese un numero entero 'g' "
                            + ", de acuerdo a la FORUMLA:\n"
                            + "Formula: m = 2^g", null, JOptionPane.INFORMATION_MESSAGE));
                    if (g > 0) {
                        m = (int) Math.pow(2, g);
                        entero = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe se entero");
                    }
                } else if (base == 10) {
                    g = Integer.parseInt(JOptionPane.showInputDialog(null, "Para calcular el modulo (m), ingrese un numero entero 'd' "
                            + ", de acuerdo a la FORUMLA:\n"
                            + "Formula: m = 10^g", null, JOptionPane.INFORMATION_MESSAGE));
                    if (g > 0) {
                        m = (int) Math.pow(10, g);
                        entero = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Debe se entero");
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe se entero");
            }
        } while (!entero);
        return m;
    }

    /*
    Metodo para calcular el COngruencial
    */
    public static void calcular(int x, int a, int m) {
        int r = 0; // Resultado
        int i = 0,j=0; // Contador
        int x2 = x, aux=0;
        m = m/4;
        System.out.println("n\tX");
        while (i < m) {
            r = (a * x) % m;
            System.out.println(i + "\t" + r);
            x = (int) r;
            if(i == 0)
                aux = r;
            if(r==aux && i!=0)
                j++;
            i++;
        }
        System.out.println("Ciclos: "+j);
    }

    /*
    Metodo para pedir el valor final de 'a'
    */
    public static int multiplicadorOp3() {
        int a = 0;
        boolean entero = false;
        do {
            try {
                a = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el multiplicador (a), ", null, JOptionPane.INFORMATION_MESSAGE));
                if (a > 0) {
                    entero = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Debe se entero");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe se entero");
            }
        } while (!entero);
        return a;
    }

    /*
    Metodo para pedir el valor final de 'm'
    */
    public static int moduloOp3() {
        int m = 0;
        boolean entero = false;
        do {
            try {
                m = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el modulo (m)", null, JOptionPane.INFORMATION_MESSAGE));
                if (m > 0) {
                    entero = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Debe se entero");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe se entero");
            }
        } while (!entero);
        return m;
    }

}
