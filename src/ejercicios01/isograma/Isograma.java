package ejercicios01.isograma;

public class Isograma {
    public static boolean esIsogram(String str) {
        // Si el string está vacío, es un isograma
        if (str == null || str.isEmpty()) {
            return true;
        }

        // Convertir a minúsculas y remover acentos
        str = quitarAcentos(str.toLowerCase());

        // Si contiene espacios, no es un isograma
        if (str.contains(" ")) {
            return false;
        }

        // Limpiar el string (solo mantener letras)
        str = str.replaceAll("[^a-z]", "");

        // Verificar letras repetidas
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            // Si encontramos la misma letra en otra posición, no es un isograma
            if (str.indexOf(currentChar) != str.lastIndexOf(currentChar)) {
                return false;
            }
        }

        return true;
    }

    private static String quitarAcentos(String str) {
        return str.replaceAll("[áàäâã]", "a")
                .replaceAll("[éèëê]", "e")
                .replaceAll("[íìïî]", "i")
                .replaceAll("[óòöôõ]", "o")
                .replaceAll("[úùüû]", "u")
                .replaceAll("[ý]", "y")
                .replaceAll("[ñ]", "n");
    }

    public static void main(String[] args) {
        System.out.println(esIsogram("")); // true
        System.out.println(esIsogram("reto")); // true
        System.out.println(esIsogram("múrcielago")); // true
        System.out.println(esIsogram("PeRrO")); // false
        System.out.println(esIsogram("GaTo")); // true
        System.out.println(esIsogram("dos palabras")); // false
    }
}
