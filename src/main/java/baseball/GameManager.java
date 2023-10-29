package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameManager {
    private final int MAX_RANDOM_NUMBER_SIZE = 3;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;

    public List<Integer> createRandomNumber() {
        List<Integer> newNumber = new ArrayList<>();
        while (newNumber.size() < MAX_RANDOM_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!newNumber.contains(randomNumber)) {
                newNumber.add(randomNumber);
            }
        }
        return newNumber;
    }

    public List<Integer> getUserNumber() {
        String[] input = readLine().split("");

        List<Integer> inputList = Arrays.stream(input).map(h -> Integer.parseInt(h))
                .toList();

        if (inputList.size() != MAX_RANDOM_NUMBER_SIZE) throw new IllegalArgumentException();

        return inputList;
    }

    public String match(List<Integer> randomNumber, List<Integer> userNumber) {
        int ball = 0;
        int strike = 0;
        String result = "";

        for (Integer number : userNumber) {
            if (randomNumber.contains(number)) {
                if (userNumber.indexOf(number.intValue()) == randomNumber.indexOf(number.intValue())) {
                    strike += 1;
                    continue;
                }
                ball += 1;
            }
        }

        if (ball != 0) {
            result += ball + "볼 ";
        }
        if (strike != 0) {
            result += strike + "스트라이크";
        }
        if (ball == 0 && strike == 0) {
            result = "낫싱";
        }

        return result;
    }
}
