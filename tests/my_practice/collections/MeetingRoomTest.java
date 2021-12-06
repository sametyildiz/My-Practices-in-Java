package my_practice.collections;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;



class MeetingRoomTest {
    private static MeetingRoom meetingRoom;
    private static MeetingRoom meetingRoomEfective;

    @BeforeAll
    static void setUp() {
        meetingRoom = new MeetingRoom();
        meetingRoomEfective = new MeetingRoomEfective();
    }


    private static Stream<Arguments> reservationArgs(){
        return Stream.of(

                Arguments.of("Room-3" ,new int[]{0,25}, false),
                Arguments.of("Room-3" ,new int[]{9,10}, true),
                Arguments.of("Room-3" ,new int[]{9,10}, true),
                Arguments.of("Room-3" ,new int[]{8,10}, true),
                Arguments.of("Room-3" ,new int[]{9,14}, true),
                Arguments.of("Room-3" ,new int[]{13,15}, true),
                Arguments.of("Room-3" ,new int[]{8,11}, true),
                Arguments.of("Room-3" ,new int[]{18,20}, true),
                Arguments.of("Room-3" ,new int[]{16,17}, true),
                Arguments.of("Room-3" ,new int[]{15,16}, true),
                Arguments.of("Room-3" ,new int[]{17,18}, true),

                Arguments.of("Room-2" ,new int[]{7,8}, true),
                Arguments.of("Room-2" ,new int[]{9,12}, true),
                Arguments.of("Room-2" ,new int[]{8,13}, true),
                Arguments.of("Room-2" ,new int[]{13,15}, true),
                Arguments.of("Room-2" ,new int[]{14,15}, true),
                Arguments.of("Room-2" ,new int[]{13,14}, true),
                Arguments.of("Room-2" ,new int[]{17,19}, true),
                Arguments.of("Room-2" ,new int[]{16,20}, true),
                Arguments.of("Room-2" ,new int[]{22,24}, true),
                Arguments.of("Room-2" ,new int[]{9,14}, true),
                Arguments.of("Room-2" ,new int[]{12,15}, true),


                Arguments.of("Room-1" ,new int[]{1,5}, true),
                Arguments.of("Room-1" ,new int[]{3,4}, true),
                Arguments.of("Room-1" ,new int[]{21,23}, true),
                Arguments.of("Room-1" ,new int[]{6,9}, true),
                Arguments.of("Room-1" ,new int[]{7,11}, true),
                Arguments.of("Room-1" ,new int[]{12,13}, true),
                Arguments.of("Room-1" ,new int[]{13,15}, true),
                Arguments.of("Room-1" ,new int[]{20,21}, true),
                Arguments.of("Room-1" ,new int[]{21,23}, true),
                Arguments.of("Room-1" ,new int[]{23,22}, false),



                Arguments.of("Room-4" , new int[]{6,8},true),
                Arguments.of("Room-4" , new int[]{6,8},true),
                Arguments.of("Room-4" , new int[]{7,8},true),
                Arguments.of("Room-4" , new int[]{5,8},true),
                Arguments.of("Room-4" , new int[]{8,9},true),
                //5-9
                Arguments.of("Room-4" , new int[]{10,12},true),
                Arguments.of("Room-4" , new int[]{11,13},true),
                Arguments.of("Room-4" , new int[]{11,12},true),
                Arguments.of("Room-4" , new int[]{14,18},true),
                Arguments.of("Room-4" , new int[]{13,19},true),
                //10-19
                Arguments.of("Room-4" , new int[]{20,24},true),
                //20-24

                Arguments.of("Room-5" , new int[]{5,7},true),
                Arguments.of("Room-5" , new int[]{3,4},true),
                Arguments.of("Room-5" , new int[]{1,2},true),
                Arguments.of("Room-5" , new int[]{1,3},true),
                //1-4,5-7
                Arguments.of("Room-5" , new int[]{8,10},true),
                Arguments.of("Room-5" , new int[]{12,14},true),
                Arguments.of("Room-5" , new int[]{11,12},true),
                Arguments.of("Room-5" , new int[]{10,11},true),
                //8-14
                Arguments.of("Room-5" , new int[]{15,17},true),
                Arguments.of("Room-5" , new int[]{15,17},true),
                //15-17
                Arguments.of("Room-5" , new int[]{18,19},true),
                Arguments.of("Room-5" , new int[]{19,20},true),
                //18-20



                Arguments.of("Room-6", new int[]{2,5},true),
                Arguments.of("Room-6", new int[]{6,8},true),
                Arguments.of("Room-6", new int[]{10,12},true),
                Arguments.of("Room-6", new int[]{2,13},true)



        );
    }

    @ParameterizedTest
    @MethodSource("reservationArgs")
    void calculateAvaibility(String roomName,int[] request, boolean result) {
        Assertions.assertEquals(result, meetingRoom.calculateAvaibility(roomName, request) );

    }

    @AfterAll
    static void printResevations() {
        Assertions.assertDoesNotThrow(()-> meetingRoom.printReservations("Room-1"));
        Assertions.assertDoesNotThrow(()-> meetingRoom.printReservations("Room-2"));
        Assertions.assertDoesNotThrow(()-> meetingRoom.printReservations("Room-3"));
        Assertions.assertDoesNotThrow(()-> meetingRoom.printReservations("Room-4"));
        Assertions.assertDoesNotThrow(()-> meetingRoom.printReservations("Room-5"));
        Assertions.assertDoesNotThrow(()-> meetingRoom.printReservations("Room-6"));
        System.out.println("*********************************************************************");
        Assertions.assertDoesNotThrow(()-> meetingRoomEfective.printReservations("Room-1"));
        Assertions.assertDoesNotThrow(()-> meetingRoomEfective.printReservations("Room-2"));
        Assertions.assertDoesNotThrow(()-> meetingRoomEfective.printReservations("Room-3"));
        Assertions.assertDoesNotThrow(()-> meetingRoomEfective.printReservations("Room-4"));
        Assertions.assertDoesNotThrow(()-> meetingRoomEfective.printReservations("Room-5"));
        Assertions.assertDoesNotThrow(()-> meetingRoomEfective.printReservations("Room-6"));


    }

    @ParameterizedTest
    @MethodSource("reservationArgs")
    void calculateAvaibiltyEfective(String roomName,int[] request, boolean result) {
        Assertions.assertEquals(result, meetingRoomEfective.calculateAvaibility(roomName, request) );


    }

}