public class Ceasar_cipher {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        int key = 15;
        String originalMessage = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        String chiperedMessage = chipherMessage(originalMessage, key);
        System.out.println(chiperedMessage);


        System.out.println("************************************");

        String chipheredMessageKey1 = chipherMessage(originalMessage, 8);
        System.out.println(chipheredMessageKey1);
        String chipheredMessageKey2 = chipherMessage(originalMessage, 21);
        System.out.println(chipheredMessageKey2);

        StringBuilder twoKeysChipheredMessage = new StringBuilder();
        for (int i = 0; i < originalMessage.length(); i++) {
            if (i % 2 == 0) {
                twoKeysChipheredMessage
                        .append(chipheredMessageKey1.charAt(i));
            } else {
                twoKeysChipheredMessage
                        .append(chipheredMessageKey2.charAt(i));
            }
        }
        System.out.println(twoKeysChipheredMessage.toString());
    }

    private static String chipherMessage(String originalMessage, int key) {
        String shiftedAlphabet = getShiftedAlphabet(key);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < originalMessage.length(); i++) {
            char chipheredChar;
            Character originalChar = originalMessage.charAt(i);
            try {
                chipheredChar = shiftedAlphabet.charAt(ALPHABET.indexOf(Character.toUpperCase(originalChar)));
                if (Character.isLowerCase(originalChar)) {
                    chipheredChar = Character.toLowerCase(chipheredChar);
                }
            } catch (StringIndexOutOfBoundsException e) {
                chipheredChar = originalChar;
            }
            result.append(chipheredChar);
        }
        return result.toString();
    }

    private static String getShiftedAlphabet(int shiftKey) {
        return ALPHABET.substring(shiftKey) + ALPHABET.substring(0, shiftKey);
    }
}
