package trabajos_programacion_def;

import java.util.Scanner;

public class Ahorcado {

	public static void main(String[] args) {
		System.out.println("¡Vamos a jugar al ahorcado! ");
		System.out.println("¿Podrás acertar la palabra secreta?");

		String palabraSecreta = generarPalabra();
		char[] guiones = getGuiones(palabraSecreta);
		
		//String repetidas = null; //también puede ponerse ="";
		Scanner teclado = new Scanner(System.in);
		boolean juegoTerminado = false;
		int intentos = 6; //oportunidades
		int fallos = 0;
    
		do {
			System.out.println("Te quedan " + intentos + " intentos");
			System.out.println("Has fallado "+fallos+" veces");
			System.out.println();
			System.out.println(espacios(guiones));
			System.out.println("");
			System.out.println("Teclea una letra:");
			String palabra=teclado.next().toLowerCase();
			char letra = palabra.charAt(0);//Por si el usuario introduce una mayuscula, que se transforme a minuscula y no de error
				//	repetidas +=letra; //aqui se van acumulando(sumando) las letras que se vayan repitiendo
			
			
			if (palabra.equals(palabraSecreta)) {
				System.out.println("\nFelicidades ¡HAS GANADO!");
				juegoTerminado=true;
				
		}
		
			if (letraAcertada(palabraSecreta, letra, guiones)) {
				System.out.println("Has acertado. ¡Sigue!");
			}
					
			else {			
			if (hasGanado(palabraSecreta, guiones, letra)==true) {
			System.out.println("\nFelicidades ¡HAS GANADO!"); 
			juegoTerminado = true;
		}
		
		
			if (!letraAcertada(palabraSecreta, letra, guiones)) {
				System.out.println("¡¡No has acertado la letra!!");
				--intentos;
				fallos++;
				intentos=(dibujar(intentos));
				
				if (intentos == 0) {
					System.out.println("Agotaste los intentos...");
					System.out.println("La palabra era "+palabraSecreta);
					juegoTerminado = true;
				}	}
			}
		} while (!juegoTerminado);
		
	}
	//método por si aciertas la letra
	public static boolean letraAcertada(String palabraSecreta, char letra, char guiones[]) {
		boolean letraAcertada = false;
		for (int i = 0; i < palabraSecreta.length(); i++) {
			if (palabraSecreta.charAt(i) == letra) {
				guiones[i] = letra;
				// System.out.println("¡Has acertado la letra "+ letra +"!");
				letraAcertada = true;
		}
	}
		return letraAcertada;
		}
	//método para los espacios
	public static String espacios(char[] guion) {
		String text = "";
		for (int i = 0; i < guion.length; i++) { //i: indice, este for es para que la i recorra todas las posiciones de la palabra
			text = text + " " + guion[i];
		}
		return text;
	}

	// Este es el metodo string que genera las palabras de mi ahorcado:
	public static String generarPalabra() {
		String[] palabras = { "movil", "gato", "lapiz", "mochila", "raton", "depuracion" };
		int palabraRandom = (int) ((Math.random() * palabras.length));
		return palabras[palabraRandom];
	}
	
	// En este método se generan los guiones
	public static char[] getGuiones(String palabra) {
		
		int nLetrasPalabra = palabra.length();

		char[] guiones = new char[nLetrasPalabra]; //para inicializar el array ponemos el new char

		for (int i = 0; i < guiones.length; i++) { //en el metodo de getPalabra sería palabra.length
			guiones[i] = '_';
		}
		return guiones;

	}
	//En este metodo se cambian los guiones por las letras:
	public static boolean hayGuiones(char letra, String palabra) {
		
		for (int i = 0; i < palabra.length(); i++)
			if (letra == palabra.charAt(i))
				return true;
		
		return false;
	}
		//metodo por si has ganado
	public static boolean hasGanado(String palabraSecreta, char []guiones, char letra) {
		String letrasAcumuladas = ""; // =null;
		
		for (int i = 0; i < palabraSecreta.length();i++) { //la i recorre toda la palabra
			letra = guiones[i]; // 
			letrasAcumuladas = letrasAcumuladas +letra; // se van acumulando/sumando las letras a lo anterior
		}
		if (palabraSecreta.equals(letrasAcumuladas)) {
			return true;
		}
		return false;
	}
	//método para dibujar el muñequito
		public static int dibujar(int intentos) {
	        switch (intentos) {
	            case 6: 
	                System.out.println(" ---------------------");
	                for (int j = 0; j < 15; j++) {
	                    System.out.println(" |");
	 
	                }
	                System.out.println("__________");
	                break;
	 
	            case 5:
	                System.out.println(" ---------------------");
	                System.out.println(" |                     |");
	                System.out.println(" |                     |");
	                System.out.println(" |                  -------");
	                System.out.println(" |                 | -  -  |");
	                System.out.println(" |                 |   U   |");
	                System.out.println(" |                  -------");
	                for (int j = 0; j < 10; j++) {
	                    System.out.println(" |");
	 
	                }
	                System.out.println("__________");
	                break;
	 
	            case 4:
	                System.out.println(" ---------------------");
	                System.out.println(" |                     |");
	                System.out.println(" |                     |");
	                System.out.println(" |                  -------");
	                System.out.println(" |                 | -  -  |");
	                System.out.println(" |                 |   U   |");
	                System.out.println(" |                  -------");
	                System.out.println(" |                     |   ");
	                System.out.println(" |                     |   ");
	                System.out.println(" |                     |   ");
	                System.out.println(" |                     |   ");
	                System.out.println(" |                     |   ");
	                for (int j = 0; j < 5; j++) {
	                    System.out.println(" |");
	 
	                }
	                System.out.println("__________");
	                break;
	 
	            case 3:
	                System.out.println(" ---------------------");
	                System.out.println(" |                     |");
	                System.out.println(" |                     |");
	                System.out.println(" |                  -------");
	                System.out.println(" |                 | -  -  |");
	                System.out.println(" |                 |   U   |");
	                System.out.println(" |                  -------");
	                System.out.println(" |                     |   ");
	                System.out.println(" |                   / |   ");
	                System.out.println(" |                 /   |   ");
	                System.out.println(" |                /    |   ");
	                System.out.println(" |                     |   ");
	                for (int j = 0; j < 5; j++) {
	                    System.out.println(" |");
	 
	                }
	                System.out.println("__________");
	                break;
	 
	            case 2:
	                System.out.println(" ---------------------");
	                System.out.println(" |                     |");
	                System.out.println(" |                     |");
	                System.out.println(" |                  -------");
	                System.out.println(" |                 | -  -  |");
	                System.out.println(" |                 |   U   |");
	                System.out.println(" |                  -------");
	                System.out.println(" |                     |   ");
	                System.out.println(" |                   / | \\ ");
	                System.out.println(" |                  /  |   \\ ");
	                System.out.println(" |                 /   |     \\ ");
	                System.out.println(" |                     |   ");
	                for (int j = 0; j < 5; j++) {
	                    System.out.println(" |");
	 
	                }
	                System.out.println("__________");
	                break;
	 
	            case 1:
	                System.out.println(" ---------------------");
	                System.out.println(" |                     |");
	                System.out.println(" |                     |");
	                System.out.println(" |                  -------");
	                System.out.println(" |                 | -  -  |");
	                System.out.println(" |                 |   U   |");
	                System.out.println(" |                  -------");
	                System.out.println(" |                     |   ");
	                System.out.println(" |                   / | \\ ");
	                System.out.println(" |                  /  |   \\ ");
	                System.out.println(" |                 /   |     \\ ");
	                System.out.println(" |                     |   ");
	                System.out.println(" |                    /  ");
	                System.out.println(" |                   /      ");
	                System.out.println(" |                  /       ");
	                for (int j = 0; j < 2; j++) {
	                    System.out.println(" |");
	 
	                }
	                System.out.println("__________");
	                break;
	 
	            case 0:
	               System.out.println(" ---------------------");
	                System.out.println(" |                     |");
	                System.out.println(" |                     |");
	                System.out.println(" |                  -------");
	                System.out.println(" |                 | X  X  |");
	                System.out.println(" |                 |   ^   |");
	                System.out.println(" |                  -------");
	                System.out.println(" |                     |   ");
	                System.out.println(" |                   / | \\ ");
	                System.out.println(" |                  /  |   \\ ");
	                System.out.println(" |                 /   |     \\ ");
	                System.out.println(" |                     |   ");
	                System.out.println(" |                    / \\");
	                System.out.println(" |                   /   \\  ");
	                System.out.println(" |                  /     \\ ");
	                for (int j = 0; j < 2; j++) {
	                    System.out.println(" |");
	 
	                }
	                System.out.println("__________");
	                System.out.println("HAS PERDIDO...");
	                break;
	                
	        }
	        return intentos;
	    }  
	
	}