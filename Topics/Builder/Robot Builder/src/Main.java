import java.util.Scanner;

class Robot {

    private final String CPU;
    private final int legs;
    private final int hands;
    private final int eyes;

    Robot(String CPU, int legs, int hands, int eyes) {
        this.CPU = CPU;
        this.legs = legs;
        this.hands = hands;
        this.eyes = eyes;
    }

    public static class RobotBuilder {

        private String CPU;
        private int legs;
        private int hands;
        private int eyes;

        void setCPU(String cpu) {
            this.CPU = cpu;
        }

        void setLegs(int legs) {
            this.legs = legs;
        }

        void setHands(int hands) {
            this.hands = hands;
        }

        void setEyes(int eyes) {
            this.eyes = eyes;
        }

        Robot build() {
            return new Robot(this.CPU, this.legs, this.hands, this.eyes);
        }
    }

    @Override
    public String toString() {
        return "CPU : " + CPU + "\n" +
                "Legs : " + legs + "\n" +
                "Hands : " + hands + "\n" +
                "Eyes : " + eyes + "\n";
    }
}

class TestDrive {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Robot.RobotBuilder robotBuilder = new Robot.RobotBuilder();
        /* Set CPU */
        robotBuilder.setCPU("Intel Core i5");

        int legs = scanner.nextInt();
        robotBuilder.setLegs(legs);


        int hands = scanner.nextInt();
        robotBuilder.setHands(hands);

        int eyes = scanner.nextInt();
        robotBuilder.setEyes(eyes);

        Robot robot = robotBuilder.build();

        System.out.println(robot);
        scanner.close();
    }
}