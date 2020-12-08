package com.dusinski;

import com.dusinski.AdventOfCode.Day3.TobogganMap;
import com.dusinski.AdventOfCode.Day4.PassportCheck;
import com.dusinski.AdventOfCode.Day5.BinaryPlaneBoarding;
import com.dusinski.AdventOfCode.Day6.CustomCustoms;
import com.dusinski.AdventOfCode.Day7.HandyHaversacksCheck;
import com.dusinski.AdventOfCode.Day8.HandheldHalting;
import com.dusinski.AdventOfCode.GetInput;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdventOfCoding {

    //        PassPolicyCheck psc= PassPolicyCheck.getInstance();
//        psc.readFile();
//        System.out.println("right passes: "+psc.checkPolicy());

//        List<Integer> intList = Arrays.asList(1,2,3,4);
//        Consumer<Integer> cns=p->System.out.println(p.toString());
////        intList.forEach(System.out::println);
//        intList.stream()
//                .filter(t->t>1)
//                .filter(t->t<4)
//                .forEach(cns);



    //        int[] testArray = {15,14,13,12,11,10,9,8,7, 6, 5, 4, 3, 2, 1};
//        System.out.println(Arrays.stream(testArray).boxed().collect(Collectors.toList()));
//        testArray(testArray);
//        System.out.println(Arrays.stream(testArray).boxed().collect(Collectors.toList()));

    @Test
    public void Day3TobogganMapCheck(){
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day3tobogganMap.txt");
        TobogganMap tm = new TobogganMap(test);
        Map<String,Long> result = new HashMap<>();
        result.put("1,1", (long) tm.countTreeOnTheWay(1,1));
        result.put("1,3",(long) tm.countTreeOnTheWay(1,3));
        result.put("1,5",(long) tm.countTreeOnTheWay(1,5));
        result.put("1,7",(long) tm.countTreeOnTheWay(1,7));
        result.put("2,1",(long) tm.countTreeOnTheWay(2,1));
        assertEquals(2698900776L,(long)result.values().stream().reduce((long) 1, (a,b)->a*b));

        //        test.forEach(System.out::println);
//        result.entrySet().stream().forEach(System.out::println);
    }

    @Test
    public void day4PassportCheck(){
        GetInput gi = new GetInput();
        List<String> test = gi.getPassFileAsStringArray("day4PassportList.txt");
        PassportCheck pc = new PassportCheck(test);
        assertEquals(147, pc.howManyPassportIsValid());
    }
    @Test
    public void day5FindMaxBoardingId(){
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day5binaryBoarding.txt");
        BinaryPlaneBoarding bpb = new BinaryPlaneBoarding(test);
        assertEquals(926,bpb.findMaxBoardingID());
    }

    @Test
    public void findEmptySeatId(){
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day5binaryBoarding.txt");
        BinaryPlaneBoarding bpb = new BinaryPlaneBoarding(test);
        assertEquals(657,bpb.findEmptySeatsID());

    }

    @Test
    public void testGetCustomAnswersCount(){
        GetInput gi = new GetInput();
        List<String> test = gi.getPassFileAsStringArray("day6customList.txt");
        CustomCustoms cc = new CustomCustoms(test);
        assertEquals(6778,cc.getAnswersCount());
    }

    @Test
    public void tstGetEveryCustomAnswerCount(){
        GetInput gi = new GetInput();
        List<String> test = gi.getPassFileAsStringArray("day6customList.txt");
        CustomCustoms cc = new CustomCustoms(test);
        assertEquals(3406,cc.getEveryAnswersCount());
    }

   @Test
    public void testHandyHaversacksColorsCheck(){
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day7handyHaversacksRules.txt");
        HandyHaversacksCheck hhc = new HandyHaversacksCheck(test);
        assertEquals(287,hhc.getPossibleBagColors());

    }

    @Test
    public void testHandyHaversacksCountCheck(){
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day7handyHaversacksRules.txt");
        HandyHaversacksCheck hhc = new HandyHaversacksCheck(test);
        assertEquals(48160,hhc.getBagsAmount());
    }

    @Test
    public void testHandheldHaltingAccBeforeStop(){
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day8HandheldHaltingGame.txt");
        HandheldHalting hh = new HandheldHalting(test);
        assertEquals(1501,hh.getAccBeforeHandStop());
    }

    @Test
    public void testHandheldHaltingWhenAppCorrect(){
        GetInput gi = new GetInput();
        List<String> test = gi.getInputAsStringArray("day8HandheldHaltingGame.txt");
        HandheldHalting hh = new HandheldHalting(test);
        assertEquals(509,hh.getAccWhenAppCorrected());
    }

}
