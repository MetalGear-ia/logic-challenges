package ejercicios02.palindromos;
class Palindromo {
      public static void esPalindromo(String[] cadena) {
          int index = cadena.length - 1; // El índice debe comenzar desde cadena.length - 1
      String[] cadenaInvertida = new String[cadena.length];

          // Invertir la cadena
      for (int i = 0; i < cadena.length; i++) {
            cadenaInvertida[i] = cadena[index];
            index--;
      }

          // Comprobar si la cadena es un palíndromo
      for (int i = 0; i < cadena.length; i++) {
              if (!cadena[i].equals(cadenaInvertida[i])) { // Comparación de contenido con .equals()
                  System.out.println("No es palindromo");
                  return; // Salir si no es palíndromo
            }
      }

          // Si todo fue correcto, es palíndromo
      System.out.println("Es palindromo");
      }


      public static void main(String[] args) {
      String[] numeros = new String[] {"h", "o", "l", "a"};
      Palindromo.esPalindromo(numeros);
      }
}