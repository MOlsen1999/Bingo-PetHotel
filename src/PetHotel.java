import java.util.*;

public class PetHotel
{
   private final int MIN_ROOM_NUMBER = 100;
    private final int MAX_ROOM_NUMBER = 109;

    private Map<Integer, String> myPetHotel = new TreeMap<>();

    public static void main(String[] args)

    {
        PetHotel petHotel = new PetHotel();
        petHotel.run();
    }
        private void run ()
        {
                System.out.println("Welcome to the Per Hotel!");

                Scanner scanner = new Scanner(System.in);


                boolean myPetHotelOpen = true;

                do {
                    System.out.println("Please Enter Your Pets Name");

                    String commandLine = scanner.nextLine();

                    String[] words = commandLine.split(" ");
                    String command = words[0].toUpperCase();

                    int toRoomNumber;
                    int fromRoomNumber;

                    switch (command) {
                        case "CHECKIN":
                        case "C":
                            String petNameIn = words[1];
                            toRoomNumber = Integer.parseInt(words[2]);
                            checkIn(toRoomNumber, petNameIn);
                            break;

                        case "CHECKOUT":
                             String petNameOut = words[1];
                             toRoomNumber = Integer.parseInt(words[2]);
                             checkOut(toRoomNumber, petNameOut);
                            break;

                        case "Move":
                        case "M":
                            fromRoomNumber = Integer.parseInt(words[1]);
                            toRoomNumber = Integer.parseInt(words[2]);
                            move(fromRoomNumber, toRoomNumber);
                            break;

                        case "OCCUPANCY":
                        case "O":
                            printOccupancy();
                            break;

                        case "Room":
                        case "R":
                            Room();
                            break;

                        case "CLOSED FOR SEASON":
                                closed(0);
                            myPetHotel.clear();
                            System.out.println("Closed for the Season!");
                            break;

                        case "EXIT":
                            System.out.println("Exit!");
                            myPetHotelOpen = false;
                            break;
                    }

                } while (!myPetHotelOpen);
                }

        private void Room()
        {
            for(int roomNumber = MIN_ROOM_NUMBER; roomNumber <= MAX_ROOM_NUMBER; roomNumber++)
            {
                System.out.println(roomNumber + " ");

                boolean petInRoom = myPetHotel.containsKey(roomNumber);

                if (petInRoom)
                {
                    String petName = myPetHotel.get(roomNumber);
                    System.out.print(petName);
                }
               else
                {
                    System.out.println("Empty");
                }
            }
            }

        private void printOccupancy()
        {
            for(Map.Entry<Integer, String> entry: myPetHotel.entrySet())
            {
                int roomNumber = entry.getKey();
                String petName = entry.getValue();
                System.out.println("Room Number " + roomNumber + "Pet Name: " + petName);
            }
        }

        private void move(int fromRoomNumber, int toroomNumber)

        {
            boolean fromRoomOccupied = myPetHotel.containsKey(fromRoomNumber);
            boolean toRoomEmpty = !myPetHotel.containsKey(toroomNumber);

       if (fromRoomOccupied)

            if(toRoomEmpty)
            {
                String petName = myPetHotel.remove(fromRoomNumber);
                myPetHotel.put(toroomNumber, petName);
                System.out.println("Moved" + petName + "from room" + fromRoomNumber + "to room " + toroomNumber);
            }
            else
            {
                String petInDestinationRoom = myPetHotel.get(toroomNumber);
                System.out.println("Sorry, that room is occupied by "+ petInDestinationRoom);
            }
            else
                {
                    System.out.println("Sorry there is no pet in room" + fromRoomNumber);
                 }
        }

            private void checkIn (int roomNumber, String name)
            {
                myPetHotel.put(roomNumber, name);
                System.out.println(name + "checked into room" + roomNumber);
            }
            private void checkOut(int roomNumber, String name)
            {
                myPetHotel.remove(roomNumber, name);
                System.out.println(name + " checked out of room" + roomNumber );
                System.out.println("Thanks for Staying with us!!!");
            }

            private void closed (int closed)
            {
                myPetHotel.remove(closed);
                System.out.println("Closed for the Season!");
            }


}
