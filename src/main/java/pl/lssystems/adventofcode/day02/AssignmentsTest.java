package pl.lssystems.adventofcode.day02;

import org.junit.jupiter.api.Test;
import pl.lssystems.adventofcode.utils.Utils;

import java.util.concurrent.atomic.AtomicInteger;

public class AssignmentsTest {

    @Test
    public void assignment1() {
        AtomicInteger score = new AtomicInteger();

        Utils.processLine("day02/input.txt", line -> {
            int OP = line.toCharArray()[0] - 64;
            int MP = line.toCharArray()[2] - 87, dst = Math.abs(OP - MP);
            int RE = OP != MP ? (OP > MP && dst == 1 || OP < MP && dst != 1 ? 0 : 6) : 3;
            score.addAndGet(MP + RE);
        });

        System.out.println("Total score: " + score);
    }

    @Test
    public void assignment2() {
        AtomicInteger score = new AtomicInteger();

        Utils.processLine("day02/input.txt", line -> {
            int OP = line.toCharArray()[0] - 64;
            int RE = line.toCharArray()[2] - 87;
            int MP = RE == 1 ? (OP == 1 ? 3 : OP - 1) : (RE == 3 ? (OP == 3 ? 1 : OP + 1) : OP);
            score.addAndGet(MP + (RE == 1 ? 0 : RE == 3 ? 6 : 3));
        });

        System.out.println("Total score: " + score);
    }

}