package my_practice.iterator_exercise;

import java.util.Scanner;

public class Start {
    private CityTraveller traveller;
    private Scanner scanner = new Scanner(System.in);
    private Cities location;
    public Start(){

        CityTraveller.printMap();
        System.out.print("Your Start Location : ");
        System.out.printf(" %s" ,
                location = (traveller = new CityTraveller(switch (scanner.nextInt()){
            case 1 -> Cities.ISTANBUL;
            case 2 -> Cities.ANKARA;
            case 3 -> Cities.ESKISEHIR;
            case 4 -> Cities.IZMIR;
            case 5 -> Cities.BODRUM;
            default -> {
                System.out.printf("\nDefault Start Location : %s" , Cities.ISTANBUL);
                yield Cities.ISTANBUL;
            }
        })).startPoint);
        scanner.nextLine();
        System.out.println();

    }

    public void theTravel(){
        boolean exit = false;
        while (!exit) {
            CityTraveller.printMap();
            System.out.println("\n" +
                    "> n for next city \n" +
                    "> p for previous city \n\n" +
                    "> stop to stop your adventure");
            System.out.print("Your Choice :");
            location = switch (scanner.nextLine()){
                case "n" -> traveller.travel(true , location);
                case "p" -> traveller.travel(false , location);
                default -> {
                    exit = true;
                    yield location;
                }
            };
        }
    }





}
