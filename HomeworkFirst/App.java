package HomeworkFirst;

 public class App {

    //Создаем участников

    public static class Participants {
        public String name;
        public int runConstrains;
        public int swimConstrains;
        public int jumpConstrains;
        public boolean done;


        public Participants(String name, int runConstrains, int swimConstrains, int jumpConstrains) {
            this.name = name;
            this.runConstrains = runConstrains;
            this.swimConstrains = swimConstrains;
            this.jumpConstrains = jumpConstrains;
            this.done = false;
        }
    }

    //Создать команду

    public static class Team {
        public String name;
        static Participants[] participants;
        public boolean done;

        public Team(String name, Participants[] participants) {
            this.name = name;
            this.participants = participants;
            this.done = false;
        }

        public void showResults() {
            if (done) {
                System.out.println("Полоса пройдена!");
            } else {
                System.out.println("Поражение:( Полоса не пройдена");
                for (int i = 0; i < 4; i++) {
                    System.out.println(participants[i].name + " не прошел(ла) все испытния ");
                }
            }
        }
    }


    // Создать конкурсы

    public static class Course {
        public int runDistance;
        public int swimDistance;
        public int jumpHeight;

        public Course(int runDistance, int swimDistance, int jumpHeight) {
            this.runDistance = runDistance;
            this.swimDistance = swimDistance;
            this.jumpHeight = jumpHeight;
        }

        void doIt (Team team) {
            int count = 0;
            for (int i = 0; i < 4; i++) {
                if ((team.participants[i].runConstrains >= runDistance) & (team.participants[i].swimConstrains >= swimDistance) & (team.participants[i].jumpConstrains >= jumpHeight) ) {
                    count += 1;
                    team.participants[i].done = true;
                }
            }
            if (count == 4) team.done = true;
        }
    }

    public static void main(String[] args) {

        Participants participants1 = new Participants("Ирина", 350, 100, 15);
        Participants participants2 = new Participants("Валера", 1000, 500, 35);
        Participants participants3 = new Participants("Саша", 850, 450, 33);
        Participants participants4 = new Participants("Надя",400, 75,13);

        Participants[] participants = {participants1, participants2, participants3, participants4};

        Team team = new Team("Массив", participants );

        Course c = new Course (750, 300, 32); // Создаем полосу препятствий
        c.doIt(team); 
        team.showResults();

    }

}

