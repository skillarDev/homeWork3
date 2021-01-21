import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число.
        // При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число, чем загаданное, или меньше.
        // После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).

        Scanner scanner1 = new Scanner(System.in);
        Random random1 = new Random();
        int randomNum;
        int count;
        int repeat;

        do {
            randomNum = random1.nextInt(10);
//            System.out.println(randomNum);
            count = 3;
            repeat = 0;
            System.out.println("Угадайте число от 0 до 9 включительно. Осталось попыток: "+count+"\nВведите число : ");
            int userNum = scanner1.nextInt();

            for (; count != 0 && userNum != randomNum;) {
                count--;
                if(userNum < randomNum && count != 0) {
                    System.out.println("Вы не угадали! Загаданное число больше. Осталось попыток: " + count + "\nВведите число : ");
                    userNum = scanner1.nextInt();
                    continue;
                }
                if(userNum > randomNum && count != 0){
                    System.out.println("Вы не угадали! Загаданное число меньше. Осталось попыток: "+count+"\nВведите число : ");
                    userNum = scanner1.nextInt();
                    continue;
                }
            }

            if(userNum == randomNum) {
                System.out.println("Вы выиграли!\nПовторить игру еще раз? 1 – да / 0 – нет: ");
                repeat = scanner1.nextInt();
                do {
                    if (repeat != 0 && repeat != 1) {
                        System.out.println("Введите 1 или 0 (1 – да / 0 – нет): ");
                        repeat = scanner1.nextInt();
                    }
                } while (repeat != 1 && repeat != 0);
            }

             if(count == 0) {
                System.out.println("Вы програли!\nПовторить игру еще раз? 1 – да / 0 – нет: ");
                repeat = scanner1.nextInt();
                do {
                    if (repeat != 0 && repeat != 1) {
                        System.out.println("Введите 1 или 0 (1 – да / 0 – нет): ");
                        repeat = scanner1.nextInt();
                    }
                } while (repeat != 1 && repeat != 0);
            }

        } while (repeat == 1);



        // * Создать массив из слов
        // String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
        // "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}
        // При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
        // сравнивает его с загаданным словом и сообщает, правильно ли ответил пользователь.
        // Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
        // apple – загаданное
        // apricot - ответ игрока
        // ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
        // Для сравнения двух слов посимвольно можно пользоваться:
        // String str = "apple";
        // char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
        // Играем до тех пор, пока игрок не отгадает слово.
        // Используем только маленькие буквы.

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random random2 = new Random();
        int randIndex = random2.nextInt(words.length);
        String secretWord = words[randIndex];
//        System.out.println(secretWord);
        Scanner scanner2 = new Scanner(System.in);
        boolean done = false;
        String hidden = "";

        do {
            hidden = "";
            System.out.println("Введите слово с маленькой буквы: ");
            String receivedWord = scanner2.next();

            for (int i = 0; i < secretWord.length(); i++) {

                char secretChar = secretWord.charAt(i);
                char receivedChar = receivedWord.charAt(0);
                if (i < receivedWord.length()) {
                    receivedChar = receivedWord.charAt(i);
                }

                if (secretChar == receivedChar) {
                    hidden += String.valueOf(receivedChar);
                    done = true;
                    if (i == secretWord.length() - 1 && done == true) {
                        System.out.println("Вы угадали, это слово: "+hidden);
                        break;
                    }
                } else {
                    for (int j = i; j < 15; j++) {
                        hidden += "#";
                        done = false;
                    }
                    System.out.println(hidden);
                    break;
                }

            } // конец for
        } while (done == false);

    }
}
