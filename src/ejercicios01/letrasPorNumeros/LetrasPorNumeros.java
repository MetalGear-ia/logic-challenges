package ejercicios01.letrasPorNumeros;
public class LetrasPorNumeros {
    public static String convert(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        // Convertir a minúsculas y limpiar el string
        String cleanedStr = cleanString(input.toLowerCase());

        StringBuilder result = new StringBuilder();
        boolean firstNumber = true;

        for (char c : cleanedStr.toCharArray()) {
            if (Character.isLetter(c)) {
                // Si no es el primer número, agregar espacio
                if (!firstNumber) {
                    result.append(" ");
                }
                // Convertir letra a número (a=1, b=2, etc.)
                result.append(c - 'a' + 1);
                firstNumber = false;
            }
        }

        return result.toString();
    }

    private static String cleanString(String str) {
        // Remover acentos
        str = str.replaceAll("[áàäâã]", "a")
                .replaceAll("[éèëê]", "e")
                .replaceAll("[íìïî]", "i")
                .replaceAll("[óòöôõ]", "o")
                .replaceAll("[úùüû]", "u")
                .replaceAll("[ý]", "y")
                .replaceAll("[ñ]", "n");

        // Remover cualquier carácter que no sea letra o espacio
        str = str.replaceAll("[^a-z ]", "");

        // Remover espacios múltiples y espacios al inicio/fin
        return str.trim().replaceAll("\\s+", " ");
    }

    public static void main(String[] args) {
        System.out.println(convert("abc def")); // "1 2 3 4 5 6"
        System.out.println(convert("áéíóú")); // "1 5 9 15 21"
        System.out.println(convert("hello world")); // "8 5 12 12 15 23 15 18 12 4"
        System.out.println(convert("a-b c")); // "1 2 3"
        System.out.println(convert("")); // ""
    }
}