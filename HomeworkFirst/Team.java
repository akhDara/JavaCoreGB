package HomeworkFirst;

public class Team {


    //Создать команду
        public String name;
        public Participants[] participants;
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
