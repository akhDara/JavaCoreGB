package HomeworkFirst;

public class Participants {
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
