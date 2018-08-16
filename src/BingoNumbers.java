import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BingoNumbers {

    Set<Integer> numbers = new HashSet();


    public static void main(String[] args) {
        BingoNumbers bingoNumbers = new BingoNumbers();
        bingoNumbers.run();

    }

    private void run() {
        System.out.println("Welcome to Bingo!");
        Scanner scanner = new Scanner(System.in);

        String inputNumber;
        Set<Integer> bingoNumbers = new HashSet();

        boolean myBingoGameStop = false;

        do {
            System.out.println("Please enter a number");

            String commandLine = scanner.nextLine();

            String[] words = commandLine.split(" ");
            String command = words[0].toUpperCase();

            switch (command) {
                case "CALL":
                    int number = validNumber(words[1]);
                    if (number > 0) {
                        call(number);
                    } else {
                        System.out.println("Please enter a number in the range 1 to 75 when using Call");
                    }
                    break;

                case "Called":

                    called();
                    break;


                case "Verify":
                    int verifyNumber = validNumber(words[1]);
                    if (verifyNumber > 0) {
                        Verify(verifyNumber);
                    } else {
                        System.out.println("Please enter a number in the range 1 to 75 when using Verify");
                    }
                    break;
                case "Challenge":

                    break;
                case "Bingo":
                    int bingo = Integer.parseInt(words[1]);
                    System.out.println("Congratulations you win a fruit cake!");
                    call(bingo);
                    numbers.clear();
                    System.out.println("Cheater!!!");
                    break;

                case "EXIT":
                    System.out.println("Game Over!");
                    myBingoGameStop = true;
                    break;
            }


        } while (!myBingoGameStop);

    }

    private int validNumber(String valiDNumber) {
        int answer = 0;

        try {
            answer = Integer.parseInt(valiDNumber);
            if (answer < 1 || answer > 75) {
                answer = 0;
            }
        } catch (Exception e) {
            answer = 0;
        }

        return answer;
    }

        private void call ( int number)
        {
            if (numbers.contains(number)) {
                System.out.println("Already called!");
            } else {
                numbers.add(number);
            }
        }

        private void called ()
        {
            for (int number : numbers) {
                System.out.println(number);
            }
        }
        private void Verify ( int verifyNumber)
        {
            if (numbers.contains(verifyNumber)) {
                System.out.println("Already called!");
            } else {
                System.out.println("Not called yet");
            }
        }

        private int challenge (String number)
        {
            int answer = -1;
            try {
                answer = Integer.parseInt(number);
                if (answer < 1 || answer > 75) {
                    answer = -1;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number in the range of 1 to 75 Please!");
            }
            System.out.println("Added:" + numbers);
            return answer;


        }

        private void bingo ( int bingo)
        {
            if (numbers.size() >= 5) {
                System.out.println("Congratulations you win a fruit cake!");
                numbers.clear();
            } else {

                System.out.println("Cheater!!!");
            }
        }
    }




